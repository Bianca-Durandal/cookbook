package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.ShoppingCar;

import java.util.List;

/**
 * (ShoppingCar)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:39
 */
@Mapper
@Repository
public interface ShoppingCarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param shoppingCarId 主键
     * @return 实例对象
     */
    @Select("select * from shopping_car where shoppingcar_id=#{shoppingCarId}")
    ShoppingCar queryById(Integer shoppingCarId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ShoppingCar> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shoppingcar 实例对象
     * @return 对象列表
     */
    List<ShoppingCar> queryAll(ShoppingCar shoppingcar);

    /**
     * 新增数据
     *
     * @param shoppingCar 实例对象
     * @return 影响行数
     */
    @Insert("insert into shopping_car (user_id,goods_id,shop_num) values(#{userId},#{goodsId},#{shopNum})")
    @Options(useGeneratedKeys = true,keyProperty = "shoppingCarId")
    int insert(ShoppingCar shoppingCar);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShoppingCar> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShoppingCar> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShoppingCar> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ShoppingCar> entities);

    /**
     * 修改数据
     *
     * @param shoppingcar 实例对象
     * @return 影响行数
     */
    int update(ShoppingCar shoppingcar);

    /**
     * 通过主键删除数据
     *
     * @param shoppingcarId 主键
     * @return 影响行数
     */
    int deleteById(Integer shoppingcarId);

    @Select("select * from shopping_car where user_id=#{userId}")
    @Results({
            @Result(property = "goods",column = "goods_id",
            one = @One(select = "top.durandal.dao.GoodsDao.queryById"))
    })
    List<ShoppingCar> getAllCartByUserId(Integer userId);
}