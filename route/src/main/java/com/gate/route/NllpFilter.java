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
        return (((exchange, chain) -> {
            logger.info("NllpFilter baseMessage>>>>>" + config.getBaseMessage());
            if(config.isPreLogger()){
                logger.info("NllpFilter Start>>>>>" + exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if(config.isPostLogger()){
                    logger.info("NllpFilter End>>>>>" + exchange.getResponse());
                }
            }));
        }));
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
