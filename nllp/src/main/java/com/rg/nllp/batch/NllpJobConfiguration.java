package com.rg.nllp.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class NllpJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private static ArrayList<String> list = new ArrayList<>();

    @Bean
    public Job helloJob(){
        initList();
        return jobBuilderFactory.get("helloJob")
                .start(helloStepStart(null))
                .incrementer(new RunIdIncrementer())
                .build();
    }

    public static void initList(){
        for (int i = 0; i < 20; i++) {
            list.add(UUID.randomUUID().toString());
        }
    }

    @Bean
    @JobScope
    public Step helloStepStart(@Value("#{jobParameters[date]}") String date){
        return stepBuilderFactory.get("helloStepStart")
                .<String, String>chunk(3)
                .reader(new ItemReader<String>() {
                    @Override
                    public String read() throws Exception {
                        return list.get(0);
                    }
                })
                .writer(new ItemWriter<String>() {
                    @Override
                    public void write(List<? extends String> items) throws Exception {
                        log.info(">>>>> items : {}", items);
                    }
                })
                .build();
    }

}
