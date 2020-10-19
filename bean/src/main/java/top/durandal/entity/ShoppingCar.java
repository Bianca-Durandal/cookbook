package top.durandal.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (ShoppingCar)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCar implements Serializable {
    /**
     * 购物车ID
     */
    @ApiModelProperty(hidden = true)
    private Integer shoppingCarId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 商品个数
     */
    private Integer shopNum;

    @ApiModelProperty(hidden = true)
    private Goods goods;

}