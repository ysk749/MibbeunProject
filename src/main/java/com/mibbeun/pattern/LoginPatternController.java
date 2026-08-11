package com.mibbeun.pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pattern/")

public class LoginPatternController {

    private AuthService authService = null;

    public LoginPatternController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiMessageResponse> signUp(@RequestBody SignUpRequest request) {
        ApiMessageResponse result = authService.signUp(request);
        return result.isSuccess() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        AuthResponse result = authService.login(request);
        if (result != null) return ResponseEntity.ok(result);
        return ResponseEntity.status(401).body(new ApiMessageResponse(false, "아이디 또는 비밀번호가 일치하지 않습니다."));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiMessageResponse> registerPattern(@RequestBody PatternRegisterRequest request) {
        ApiMessageResponse result = authService.registerPattern(request);
        return result.isSuccess() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/plogin")
    public ResponseEntity<?> patternLogin(@RequestBody PatternLoginRequest request) {
        AuthResponse result = authService.patternLogin(request);
        if (result != null) return ResponseEntity.ok(result);
        return ResponseEntity.status(401).body(new ApiMessageResponse(false, "패턴이 일치하지 않습니다."));
    }
}