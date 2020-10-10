package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.FollowService;
import top.durandal.dao.FollowDao;
import top.durandal.entity.Follow;
import top.durandal.entity.User;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class FollowServiceImpl implements FollowService {

    @Resource
    FollowDao followDao;

    public Follow queryById() {
        return null;
    }

    public List<Follow> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public Follow insert(Follow follow) {
        return null;
    }

    public Follow update(Follow follow) {
        return null;
    }

    public boolean deleteById() {
        return false;
    }

    public boolean isFollow(Integer followId,Integer userId) {
        Integer follow = followDao.isFollow(userId);
        return follow.equals(followId);
    }
}
