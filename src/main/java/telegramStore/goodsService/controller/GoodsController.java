package telegramStore.goodsService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import telegramStore.goodsService.goodsDto.GoodDto;
import telegramStore.goodsService.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/{id}")
    List<GoodDto> getAllGoodsFromStoreWithId(@PathVariable String id) {
        return goodsService.getAllGoodsDtoByStoreID(Integer.parseInt(id));
    }
    @PostMapping()
    ResponseEntity<Integer> reduceQuantities(@RequestBody List<GoodDto> goodsDtoList) {

        Integer count = goodsService.reduceQuantity(goodsDtoList);
        return ResponseEntity.ok(count);
    }

}
