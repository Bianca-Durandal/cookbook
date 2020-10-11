//package top.durandal.controller;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import top.durandal.api.service.GoodsService;
//import top.durandal.common.ResponseInfo;
//
//@RestController
//@RequestMapping("goods")
//public class GoodsController {
//
//    @Reference
//    GoodsService goodsService;
//
//    @GetMapping("getGoodsByGoodsId")
//    public ResponseInfo getGoodsByGoodsId(int goodsId){
//        goodsService.queryById(goodsId);
//        return ResponseInfo.success();
//    }
//}
