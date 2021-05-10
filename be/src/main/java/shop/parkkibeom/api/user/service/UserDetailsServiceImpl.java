package shop.parkkibeom.api.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override // 아이디가 맞으면 유저를 로딩시키는 서비스 하나만 존재
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
