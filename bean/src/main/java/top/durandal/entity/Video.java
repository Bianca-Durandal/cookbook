package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private String videoSrc;

    private Integer WorksId;

    private String videoContent;
}
