package shop.parkkibeom.api.user.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class UserVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_no")
	private long userNo;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Size(min = 8, message = "Minimum Password Length: 8 characters")
	private String password;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "reg_date")
	private Date regDate;

	// 접속할 때 바로 알려주기 위해 즉시 할당. Authority
	@ElementCollection(fetch = FetchType.EAGER)
	List<Role> roles;
}
