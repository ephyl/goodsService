package telegramStore.goodsService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.service.GoodService;

import java.util.UUID;

@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodController {

    private final GoodService goodService;

    @GetMapping("/{uuid}")
    GoodDto getOneGoodBYId(@PathVariable String uuid) {
        return goodService.getGoodDtoByGoodID(UUID.nameUUIDFromBytes(uuid.getBytes()));
    }

    @PostMapping()
    GoodDto addGood(@RequestBody GoodDto goodDto) {
        return goodService.create(goodDto);
    }

}
