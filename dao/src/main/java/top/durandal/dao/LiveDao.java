package top.durandal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Live;

import java.util.List;

/**
 * (Live)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-06 16:28:34
 */
@Mapper
@Repository
public interface LiveDao {

    /**
     * 通过ID查询单条数据
     *
     * @param liveId 主键
     * @return 实例对象
     */
    Live queryById(String liveId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Live> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param live 实例对象
     * @return 对象列表
     */
    List<Live> queryAll(Live live);

    /**
     * 新增数据
     *
     * @param live 实例对象
     * @return 影响行数
     */
    int insert(Live live);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Live> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Live> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Live> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Live> entities);

    /**
     * 修改数据
     *
     * @param live 实例对象
     * @return 影响行数
     */
    int update(Live live);

    /**
     * 通过主键删除数据
     *
     * @param liveId 主键
     * @return 影响行数
     */
    int deleteById(String liveId);

}