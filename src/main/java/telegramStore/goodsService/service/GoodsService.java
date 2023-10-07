package telegramStore.goodsService.service;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import telegramStore.goodsService.entity.Good;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.repository.GoodsRepository;
import telegramStore.goodsService.util.mapper.GoodsMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository repository;

    private final GoodsMapper goodsMapper;

    public List<GoodDto> getAllGoodsDtoByStoreID(int id) {
        List<Good> goodList = repository.findByStoreIdAndGoodsQuantityIsGreaterThan(id, 0);
        return goodList.stream()
                .map(goodsMapper::toGoodDto)
                .collect(Collectors.toList());
    }

    public int reduceQuantity(List<GoodDto> goodDtoList) {
        int count = 0;
        for (GoodDto g : goodDtoList) {
            Good good = repository.findById(g.getProductId()).orElseThrow(RuntimeException::new); // TO DO add custom exception
            good.setGoodsQuantity(good.getGoodsQuantity() - g.getGoodsQuantity());
            count++;
        }
        return count;
    }

    public GoodDto getGoodDtoByGoodID(UUID uuid) {
        Good good = repository.findById(uuid).orElseThrow(RuntimeException::new);
        GoodsMapper mapper = Mappers.getMapper(GoodsMapper.class);

        return mapper.sourceToDestination(good);
    }

    public GoodDto create(GoodDto goodDto) {
        GoodsMapper mapper = Mappers.getMapper(GoodsMapper.class);

        return mapper.sourceToDestination(repository.save(mapper.destinationToSource(goodDto)));
    }
}
