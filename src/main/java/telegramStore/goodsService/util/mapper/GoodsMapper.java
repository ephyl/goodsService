package telegramStore.goodsService.util.mapper;

import org.mapstruct.Mapper;
import telegramStore.goodsService.entity.Good;
import telegramStore.goodsService.goodsDto.GoodDto;

@Mapper
public interface GoodsMapper {
    GoodDto sourceToDestination(Good good);
    Good destinationToSource(GoodDto goodDto);


}
