package telegramStore.goodsService.goodsDto;

import lombok.Data;

import java.util.UUID;
@Data
public class GoodDto {
    private UUID uuid;

    private UUID storeUuid;

    private  String name;

    private int quantity;

    private double price;
}
