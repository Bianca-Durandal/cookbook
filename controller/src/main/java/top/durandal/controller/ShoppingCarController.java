package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import top.durandal.api.service.ShoppingCarService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.ShoppingCar;

import java.util.List;

@RestController
@RequestMapping("cart")
public class ShoppingCarController {

    @Reference
    ShoppingCarService shoppingCarService;

    @PostMapping("insert")
    public ResponseInfo insertCart(@RequestBody ShoppingCar shoppingCar){
        ShoppingCar insert = shoppingCarService.insert(shoppingCar);
        if (insert==null){
            return ResponseInfo.error("没有插入成功");
        }
        return ResponseInfo.success(insert);
    }

    @GetMapping("getAllCartByUserId")
    public ResponseInfo getAllCartByUserId(Integer userId){
        List<ShoppingCar> allCartByUserId = shoppingCarService.getAllCartByUserId(userId);
        if (allCartByUserId==null){
            return ResponseInfo.error("没有购物车信息");
        }
        return ResponseInfo.success(allCartByUserId);
    }
}
