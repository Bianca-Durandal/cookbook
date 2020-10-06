package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Fans)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fans implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 粉丝ID
     */
    private Integer fansId;
}