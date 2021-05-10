package shop.parkkibeom.api.security.exception;

import java.io.Serializable;

public class LoginRuntimeException extends RuntimeException implements Serializable {
    private static final long serialVersionID = 1L;

    // 에러 발생 시 우리가 만든 메시지 찍어달라는 것
    public LoginRuntimeException() {
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }

    // 에러 발생 시 쓸 메시지 있으면 해당 메시지 찍어달라는 것
    public LoginRuntimeException(String message) {
        super(message);
    }
}
