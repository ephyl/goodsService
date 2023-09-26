package telegramStore.goodsService.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import telegramStore.goodsService.entity.Good;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.repository.GoodsRepository;
import telegramStore.goodsService.util.mapper.GoodsMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    private GoodsRepository repository;

    @Autowired
    public GoodsService(GoodsRepository repository) {
        this.repository = repository;
    }

    public List<GoodDto> getAllGoodsDtoByStoreID(int id) {
        GoodsMapper mapper = Mappers.getMapper(GoodsMapper.class);
        List<Good> goodList = repository.findByStoreIdAndQuantityIsGreaterThan(id, 0);
        return goodList.stream().map(mapper::sourceToDestination).collect(Collectors.toList());
    }

    public int reduceQuantity(List<GoodDto> goodDtoList) {
        int count = 0;
        for (GoodDto g :
                goodDtoList
        ) {
            Good good = repository.findById(g.getUuid()).orElseThrow(RuntimeException::new); // TO DO add custom exception
            good.setQuantity(good.getQuantity() - g.getQuantity());
            count++;
        }
        return count;
    }

}
