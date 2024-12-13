package com.example.carleaseplatform.adapter.in;

import com.example.carleaseplatform.infrastructure.configuration.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/login")
  public Map<String, String> login(@RequestBody Map<String, String> request) {
    String username = request.get("username");
    String password = request.get("password");

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, password)
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtUtil.generateToken(username);

    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return response;
  }
  @GetMapping("/token")
  public String generateToken(@RequestParam String username) {
    return jwtUtil.generateToken(username);
  }
}
