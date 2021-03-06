package top.durandal.api.service;


import top.durandal.entity.ShoppingCar;

import java.util.List;

/**
 * (ShoppingCar)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:50:03
 */
public interface ShoppingCarService {

    /**
     * 通过ID查询单条数据
     *
     * @param shoppingcarId 主键
     * @return 实例对象
     */
    ShoppingCar queryById(Integer shoppingcarId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ShoppingCar> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shoppingCar 实例对象
     * @return 实例对象
     */
    ShoppingCar insert(ShoppingCar shoppingCar);

    /**
     * 修改数据
     *
     * @param shoppingcar 实例对象
     * @return 实例对象
     */
    ShoppingCar update(ShoppingCar shoppingcar);

    /**
     * 通过主键删除数据
     *
     * @param shoppingcarId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer shoppingcarId);

    List<ShoppingCar> getAllCartByUserId(Integer userId);
}