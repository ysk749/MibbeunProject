package com.mibbeun.pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final XUserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(XUserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public ApiMessageResponse signUp(SignUpRequest request) {
        if (userRepository.existsById(request.getUserId())) {
            return new ApiMessageResponse(false, "이미 존재하는 아이디입니다.");
        }
        XUser user = new XUser(
                request.getUserId(),
                request.getUserNm(),
                passwordEncoder.encode(request.getUserPswd())
        );
        userRepository.save(user);
        return new ApiMessageResponse(true, "회원가입이 완료되었습니다.");
    }

    public AuthResponse login(LoginRequest request) {
        XUser user = userRepository.findActiveUser(request.getUserId());
        if (user == null) return null;
        if (!passwordEncoder.matches(request.getUserPswd(), user.getUserPswd())) return null;

        String token = jwtProvider.generateToken(user.getUserId());
        return new AuthResponse(user.getUserId(), user.getUserNm(), token);
    }

    public ApiMessageResponse registerPattern(PatternRegisterRequest request) {
        XUser user = userRepository.findActiveUser(request.getUserId());
        if (user == null) return new ApiMessageResponse(false, "사용자를 찾을 수 없습니다.");

        user.setUserPattern(passwordEncoder.encode(request.getPattern()));
        userRepository.save(user);
        return new ApiMessageResponse(true, "패턴이 등록되었습니다.");
    }

    public AuthResponse patternLogin(PatternLoginRequest request) {
        XUser user = userRepository.findActiveUser(request.getUserId());
        if (user == null || user.getUserPattern() == null) return null;
        if (!passwordEncoder.matches(request.getPattern(), user.getUserPattern())) return null;

        String token = jwtProvider.generateToken(user.getUserId());
        return new AuthResponse(user.getUserId(), user.getUserNm(), token);
    }
}