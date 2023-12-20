package telegramStore.goodsService.scheduled;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BusinessScheduler {
    private final BusinessLogicService businessLogicService;

    public void runScheduler(){
        businessLogicService.someMethod();
    }
}
