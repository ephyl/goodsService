package telegramStore.goodsService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.service.GoodsService;

import java.util.UUID;

@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodController {
    private final GoodsService goodsService;

    @GetMapping("/{uuid}")
    GoodDto getOneGoodBYId(@PathVariable String uuid) {
        return goodsService.getGoodDtoByGoodID(UUID.nameUUIDFromBytes(uuid.getBytes()));
    }

    @PostMapping()
    GoodDto addGood(@RequestBody GoodDto goodDto) {
        return goodsService.create(goodDto);
    }

}
