package top.durandal.api.service;

import top.durandal.entity.Video;

import java.util.List;

public interface VideoService {

    List<Video> getVideoByWorksId(Integer worksId);


}
