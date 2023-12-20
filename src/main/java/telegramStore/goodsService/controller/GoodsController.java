package telegramStore.goodsService.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.service.GoodService;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
@Validated
public class GoodsController {

    private final GoodService goodService;

    @GetMapping("/{storeId}")
    public List<GoodDto> getAllGoodsFromStoreWithId(@PathVariable @Pattern(regexp = "\\d+", message = "должно быть номером") String storeId) {
        return goodService.getAllGoodsDtoByStoreID(Integer.parseInt(storeId));
    }

    @PostMapping
    public Integer reduceQuantities(@RequestBody List<GoodDto> goodsDtoList) {
        return goodService.reduceQuantity(goodsDtoList);
    }


}
