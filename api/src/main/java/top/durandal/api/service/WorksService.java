package top.durandal.api.service;


import top.durandal.entity.Works;

import java.util.List;

/**
 * (Works)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:50:04
 */
public interface WorksService {

    /**
     * 通过ID查询单条数据
     *
     * @param worksId 主键
     * @return 实例对象
     */
    Works queryById(Integer worksId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Works> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param works 实例对象
     * @return 实例对象
     */
    Works insert(Works works);

    /**
     * 修改数据
     *
     * @param works 实例对象
     * @return 实例对象
     */
    Works update(Works works);

    /**
     * 通过主键删除数据
     *
     * @param worksId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer worksId);

}