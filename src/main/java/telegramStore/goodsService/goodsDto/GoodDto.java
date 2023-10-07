package telegramStore.goodsService.goodsDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class GoodDto {

    private UUID productId;

    private int storeId;

    private String name;

    private int goodsQuantity;

    private BigDecimal price;
}
