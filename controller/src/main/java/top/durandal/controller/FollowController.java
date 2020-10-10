package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.FollowService;
import top.durandal.common.ResponseInfo;

@RestController
@RequestMapping("follow")
public class FollowController {

    @Reference
    FollowService followService;

    public ResponseInfo isFollow(Integer followId,Integer userId){
        boolean isFollow = followService.isFollow(followId, userId);
        if (!isFollow){
            return ResponseInfo.error("你没有关注该对象");
        }
        return ResponseInfo.success(userId+"关注了"+followId);
    }

}
