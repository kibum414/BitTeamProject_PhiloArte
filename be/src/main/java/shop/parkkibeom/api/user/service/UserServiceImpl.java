package shop.parkkibeom.api.user.service;

import shop.parkkibeom.api.security.domain.SecurityProvider;
import shop.parkkibeom.api.security.exception.SecurityRuntimeException;
import shop.parkkibeom.api.user.domain.Role;
import shop.parkkibeom.api.user.domain.UserDto;
import shop.parkkibeom.api.user.domain.UserVo;
import shop.parkkibeom.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;
    private final ModelMapper modelMapper;

    @Override
    public String signup(UserVo user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);

            userRepository.save(user);

            // 토큰 발급
            return provider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDto signin(UserVo user) {
        try {
            UserDto userDto = modelMapper.map(user, UserDto.class);

            // 토큰까지 담아줌
            userDto.setToken(
                    (passwordEncoder.matches(user.getPassword(), userRepository.findByUsername(user.getUsername()).get().getPassword())) // .get() : Optional 객체 내에서 끄집어내기 위해 사용
                            ?
                            provider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).get().getRoles())
                            : "WRONG_PASSWORD"
            );

            return userDto;
        } catch (Exception e) {
            throw new SecurityRuntimeException("Invalid Username / Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<UserVo> findAll() {
        // userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userRepository.findAll();
    }

}
