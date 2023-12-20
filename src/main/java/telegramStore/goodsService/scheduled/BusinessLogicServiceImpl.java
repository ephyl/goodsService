package telegramStore.goodsService.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogicServiceImpl implements BusinessLogicService {
    @Override
    @Scheduled(cron = "0 26 16 * * *")
    public void someMethod() {
        System.out.println("________________ I AM HERE FROM CRON____________________");
    }
}
