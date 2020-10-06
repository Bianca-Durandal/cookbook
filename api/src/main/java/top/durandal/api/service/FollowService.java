package top.durandal.api.service;


import top.durandal.entity.Follow;

import java.util.List;

/**
 * (Follow)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 16:49:56
 */
public interface FollowService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    Follow queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Follow> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    Follow insert(Follow follow);

    /**
     * 修改数据
     *
     * @param follow 实例对象
     * @return 实例对象
     */
    Follow update(Follow follow);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 是否成功
     */
    boolean deleteById();

}