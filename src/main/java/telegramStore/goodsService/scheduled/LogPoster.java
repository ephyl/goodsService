package telegramStore.goodsService.scheduled;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class LogPoster {
    private final static Logger LOGGER = LoggerFactory.getLogger(LogPoster.class);
//    @Scheduled(fixedRate = 200)
//    public void postInfo() {
//        LOGGER.warn("WJWHJHWJHW");
//    }

}
