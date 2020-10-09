package top.durandal.api.service;

import java.util.List;

public interface CollectionService {
    /**
     * 通过worksId获得所有的收藏信息
     * @param worksId
     */
    List getCollectionByWorksId(int worksId);
}
