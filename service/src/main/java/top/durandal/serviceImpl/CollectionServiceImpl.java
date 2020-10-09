package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.CollectionService;
import top.durandal.dao.CollectionDao;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class CollectionServiceImpl implements CollectionService {

    @Resource
    CollectionDao collectionDao;

    public List getCollectionByWorksId(int worksId) {
        List collectionUser = collectionDao.getCollectionByWorksId(worksId);
        if (collectionUser.size()!=0){
            return collectionUser;
        }
        return null;
    }
}
