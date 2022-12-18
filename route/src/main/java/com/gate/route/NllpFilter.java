package com.gate.route;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * packageName    : com.gate.route
 * fileName       : GlobalFilter
 * author         : hyeokchan
 * date           : 2022/12/17
 * description    : nllp gateway filter
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/17        hyeokchan       최초 생성
 */
@Component
public class NllpFilter extends AbstractGatewayFilterFactory<NllpFilter.Config> {
    private static final Logger logger = LogManager.getLogger(NllpFilter.class);
    public NllpFilter(){
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        // exchange : 서비스 요청/응답값을 담고 있는 변수, 요청/응답값을 출력하거나 변환할 때 사용
        return (((exchange, chain) -> {
            logger.info("NllpFilter baseMessage>>>>>" + config.getBaseMessage());
            if(config.isPreLogger()){
                logger.info("NllpFilter Start>>>>>" + exchange.getRequest());
            }
            // 서비스로부터 리턴받은 응답값 : Mono.fromRunnable 구분 이후의 exchange.getResponse();
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if(config.isPostLogger()){
                    logger.info("NllpFilter End>>>>>" + exchange.getResponse());
                }
            }));
        }));
    }

    // application.yml에 선언한 각 filter의 인자값 사용을 위한 클래스
    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
