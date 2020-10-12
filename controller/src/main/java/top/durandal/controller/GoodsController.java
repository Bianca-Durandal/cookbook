package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.GoodsService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Goods;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Reference
    GoodsService goodsService;

    @GetMapping("getGoodsByGoodsId")
    public ResponseInfo getGoodsByGoodsId(int goodsId){
        Goods goods = goodsService.queryById(goodsId);
        if (goods==null){
            return ResponseInfo.error("没有该商品的信息");
        }
        return ResponseInfo.success(goods);
    }
}
