package top.durandal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.api.service.CollectionService;
import top.durandal.common.ResponseInfo;

import java.util.List;

@RestController
@RequestMapping("collection")
public class CollectionController {

    @Reference
    CollectionService collectionService;

    @GetMapping("getCollectionByWorksId")
    public ResponseInfo getCollectionByUserId(int worksId){
        List collectionUser = collectionService.getCollectionByWorksId(worksId);
        if (collectionUser == null) {
            return ResponseInfo.error("该作品没有被收藏");
        }
        return ResponseInfo.success(collectionUser);
    }
}
