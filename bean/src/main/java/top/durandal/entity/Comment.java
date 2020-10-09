package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    /**
     * 评论ID
     */
    private Integer worksId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 发布内容
     */
    private String commentContent;
    /**
     * 评论日期
     */
    private String commentDate;

    private Integer userFromId;

    private Integer userToId;
}