package top.durandal.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    @ApiModelProperty(hidden = true)
    private Integer userId;

    @NotNull
    private String userName;

    @NotNull
    private String userPass;

    @ApiModelProperty(hidden = true)
    private Date userDate;

    @NotNull
    @Pattern(regexp = "^1[3456789]\\d{9}$")
    private String userPhone;

    private String userShow;

    private String userEmail;
}
