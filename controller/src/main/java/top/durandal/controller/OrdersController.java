package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.OrdersService;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.Orders;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrdersController {

    @Reference
    OrdersService ordersService;

    @GetMapping("getOrderByUserId")
    public ResponseInfo getOrderByUserId(Integer userId) {
        List<Orders> allOrders = ordersService.getOrderByUserId(userId);
        System.out.println(allOrders);
        if (allOrders==null){
            return ResponseInfo.error("没有订单信息");
        }
        return ResponseInfo.success(allOrders);
    }
}
