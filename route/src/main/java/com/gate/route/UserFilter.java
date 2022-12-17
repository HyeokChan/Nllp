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
 * fileName       : UserFilter
 * author         : hyeokchan
 * date           : 2022/12/17
 * description    : user gateway filter
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/17        hyeokchan       최초 생성
 */
@Component
public class UserFilter extends AbstractGatewayFilterFactory<UserFilter.Config> {
    private static final Logger logger = LogManager.getLogger(UserFilter.class);
    public UserFilter(){
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            logger.info("UserFilter baseMessage>>>>>" + config.getBaseMessage());
            if(config.isPreLogger()){
                logger.info("UserFilter Start>>>>>" + exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if(config.isPostLogger()){
                    logger.info("UserFilter End>>>>>" + exchange.getResponse());
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
