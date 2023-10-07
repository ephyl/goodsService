package telegramStore.goodsService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @GetMapping("/{storeId}")
    List<GoodDto> getAllGoodsFromStoreWithId(@PathVariable String storeId) {
        return goodsService.getAllGoodsDtoByStoreID(Integer.parseInt(storeId));
    }

    @PostMapping()
    ResponseEntity<Integer> reduceQuantities(@RequestBody List<GoodDto> goodsDtoList) {
        Integer count = goodsService.reduceQuantity(goodsDtoList);
        return ResponseEntity.ok(count);
    }


}
