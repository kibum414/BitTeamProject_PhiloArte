package shop.parkkibeom.api.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN", "관리자 권한"),
    USER("ROLE_USER", "사용자 권한"),
    UNKNOWN("ROLE_UNKNOWN", "알 수 없는 권한");

    private final String code;
    private final String description;

    public static Role of(String code) {
        // enum은 배열 : 유저에 따라 Role의 개수가 다르기 때문에 배열화
        // ADMIN 이나 USER 라는 Role이 있으면 넣고, 없으면 UNKNOWN
        // 후에 람다 등에 활용할 경우 stream 객체여야 하기 때문에 stream화
        return Arrays
                .stream(Role.values())
                .filter(i -> i.getCode().equals(code))
                .findAny()
                .orElse(UNKNOWN);
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
