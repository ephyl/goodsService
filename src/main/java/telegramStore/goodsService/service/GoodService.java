package telegramStore.goodsService.service;

import telegramStore.goodsService.goodsDto.GoodDto;

import java.util.List;
import java.util.UUID;

public interface GoodService {

    List<GoodDto> getAllGoodsDtoByStoreID(int id);

    Integer reduceQuantity(List<GoodDto> goodDtoList);

    GoodDto getGoodDtoByGoodID(UUID uuid);

    GoodDto create(GoodDto goodDto);
}
