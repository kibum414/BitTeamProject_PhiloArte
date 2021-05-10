package shop.parkkibeom.api.user.domain;

import java.sql.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

@Data
public class UserDto {

	@ApiModelProperty(position = 0)
	private String username;

	@ApiModelProperty(position = 1)
	private String name;

	@ApiModelProperty(position = 2)
	private String password;

	@ApiModelProperty(position = 3)
	private String email;

	@ApiModelProperty(position = 4)
	private String birthday;

	@ApiModelProperty(position = 5)
	private String gender;

	@ApiModelProperty(position = 6)
	private String phoneNumber;

	@ApiModelProperty(position = 7)
	private Date regDate;

	@ApiModelProperty(position = 8)
	private String token;

	@ApiModelProperty(position = 9)
	private List<Role> roles;

}
