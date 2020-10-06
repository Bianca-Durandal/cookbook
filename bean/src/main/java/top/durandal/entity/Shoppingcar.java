package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Shoppingcar)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoppingcar implements Serializable {
    /**
     * 购物车ID
     */
    private Integer shoppingcarId;
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

}