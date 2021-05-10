package shop.parkkibeom.api.user.service;

import shop.parkkibeom.api.user.domain.UserDto;
import shop.parkkibeom.api.user.domain.UserVo;

import java.util.List;

public interface UserService {
    public String signup(UserVo user);
    public UserDto signin(UserVo user);
    public List<UserVo> findAll();
}
