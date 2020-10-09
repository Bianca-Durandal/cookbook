package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collection implements Serializable {

    private Integer worksId;

    private Integer userId;

    private List<User> userList;
}
