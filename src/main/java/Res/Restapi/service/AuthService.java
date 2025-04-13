package Res.Restapi.service;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expirationTime;

    public String generateToken(String email, String role) { // Ham tạo token
        // Sử dụng Instant.now() để lấy thời gian phát hành
        Instant now = Instant.now();

        // Tính toán thời gian hết hạn của token
        Instant expiration = now.plusMillis(expirationTime);

        return Jwts.builder()
                .setSubject(email) // Payload: thông tin người dùng -> email
                .claim("ROLE", role) // them quyen cua nguoi dung vao payload
                .setIssuedAt(Date.from(now)) // Thời gian phát hành
                .setExpiration(Date.from(expiration)) // Thời gian hết hạn
                .signWith(SignatureAlgorithm.HS256, secretKey) // Ký với secret key
                .compact(); // Trả về token đã được tạo
    }

}
