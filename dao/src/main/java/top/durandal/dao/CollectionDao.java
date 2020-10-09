package top.durandal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.durandal.entity.Collection;

import java.util.List;

@Mapper
@Repository
public interface CollectionDao {
    /**
     * 通过worksId获得所有的关注列表
     * @param worksId
     */
    @Select("select user_id from collection where works_id = #{worksId}")
    @Results({
            @Result(property = "userList",column = "user_id",many = @Many(select = "top.durandal.dao.UserDao.findUserById"))
    })
    List getCollectionByWorksId(int worksId);


}
