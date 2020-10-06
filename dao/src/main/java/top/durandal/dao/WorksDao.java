package top.durandal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Works;

import java.util.List;

/**
 * (Works)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:40
 */
@Mapper
@Repository
public interface WorksDao {

    /**
     * 通过ID查询单条数据
     *
     * @param worksId 主键
     * @return 实例对象
     */
    Works queryById(Integer worksId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Works> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param works 实例对象
     * @return 对象列表
     */
    List<Works> queryAll(Works works);

    /**
     * 新增数据
     *
     * @param works 实例对象
     * @return 影响行数
     */
    int insert(Works works);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Works> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Works> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Works> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Works> entities);

    /**
     * 修改数据
     *
     * @param works 实例对象
     * @return 影响行数
     */
    int update(Works works);

    /**
     * 通过主键删除数据
     *
     * @param worksId 主键
     * @return 影响行数
     */
    int deleteById(Integer worksId);

}