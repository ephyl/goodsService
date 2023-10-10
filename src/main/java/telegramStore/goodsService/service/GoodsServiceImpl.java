package telegramStore.goodsService.service;

import jakarta.transaction.Transactional;
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
public class GoodsServiceImpl implements GoodService {

    private final GoodsRepository repository;

    private final GoodsMapper goodsMapper;

    @Override
    public List<GoodDto> getAllGoodsDtoByStoreID(int id) {
        List<Good> goodList = repository.findByStoreIdAndGoodsQuantityIsGreaterThan(id, 0);
        return goodList.stream()
                .map(goodsMapper::toGoodDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Integer reduceQuantity(List<GoodDto> goodDtoList) {
        int count = 0;
        for (GoodDto g : goodDtoList) {
            Good good = repository.findById(g.getProductId()).orElseThrow(RuntimeException::new); // TO DO add custom exception
            good.setGoodsQuantity(good.getGoodsQuantity() - g.getGoodsQuantity());
            repository.save(good);
            count++;
        }
        return count;
    }

    @Override
    public GoodDto getGoodDtoByGoodID(UUID uuid) {
        Good good = repository.findById(uuid).orElseThrow(RuntimeException::new);
        GoodsMapper mapper = Mappers.getMapper(GoodsMapper.class);

        return mapper.sourceToDestination(good);
    }

    @Override
    @Transactional
    public GoodDto create(GoodDto goodDto) {
        GoodsMapper mapper = Mappers.getMapper(GoodsMapper.class);

        return mapper.sourceToDestination(repository.save(mapper.destinationToSource(goodDto)));
    }
}
