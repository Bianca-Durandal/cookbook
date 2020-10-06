package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Follow)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 关注对象ID
     */
    private Integer followId;
}