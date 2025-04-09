// package Res.Restapi.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import java.util.Collections;

// @Configuration // Đánh dấu đây là class cấu hình Spring
// @EnableWebSecurity // Kích hoạt tính năng bảo mật web của Spring Security
// public class SecurityConfig {
// private final String[] PUBLIC_ENDPIONT = { "api/user/**" };
// private final String[] PRIVATE_ENDPIONT = { "api/admin/**" };

// @Bean // Định nghĩa một Bean cho Spring quản lý
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// // Cấu hình bảo mật cho các request HTTP
// http
// // Cấu hình CORS (cho phép gọi API từ các domain khác)
// .cors(cors -> cors.configurationSource(corsConfigurationSource()))

// // Vô hiệu hóa CSRF (phù hợp cho API không trạng thái)
// .csrf(csrf -> csrf.disable())

// // Cấu hình phân quyền cho các request
// .authorizeHttpRequests(authz -> authz
// // Cho phép tất cả truy cập POST /api/user/register (đăng ký user)
// .requestMatchers(HttpMethod.POST, PUBLIC_ENDPIONT).permitAll()
// .requestMatchers(HttpMethod.GET, PUBLIC_ENDPIONT).permitAll()
// // Chỉ role ADMIN mới được truy cập POST /api/admin/**
// .requestMatchers(HttpMethod.POST, PRIVATE_ENDPIONT).hasRole("ADMIN")
// // Chỉ role ADMIN mới được truy cập GET /api/admin/**
// .requestMatchers(HttpMethod.GET, PRIVATE_ENDPIONT).hasRole("ADMIN")
// // Tất cả các request khác phải được xác thực
// .anyRequest().authenticated())

// // Cấu hình form login (đăng nhập qua form)
// .formLogin(form -> form
// // Định nghĩa URL xử lý login
// .loginProcessingUrl("/api/login")
// // Cho phép tất cả truy cập trang login
// .permitAll())

// // Kích hoạt xác thực HTTP Basic (tài khoản/mật khẩu qua header)
// .httpBasic(httpBasic -> {
// }); // Không cần custom gì nên để trống

// // Trả về đối tượng SecurityFilterChain đã cấu hình
// return http.build();
// }

// @Bean // Bean cho cấu hình CORS
// public UrlBasedCorsConfigurationSource corsConfigurationSource() {
// // Tạo cấu hình CORS
// CorsConfiguration config = new CorsConfiguration();
// // Cho phép gửi cookie/credentials
// config.setAllowCredentials(true);
// // Cho phép tất cả origin (có thể thay bằng domain cụ thể như
// // "http://localhost:3000")
// config.setAllowedOriginPatterns(Collections.singletonList("*"));
// // Cho phép tất cả header
// config.setAllowedHeaders(Collections.singletonList("*"));
// // Cho phép tất cả HTTP method (GET, POST, v.v.)
// config.setAllowedMethods(Collections.singletonList("*"));

// // Áp dụng cấu hình CORS cho mọi endpoint
// UrlBasedCorsConfigurationSource source = new
// UrlBasedCorsConfigurationSource();
// source.registerCorsConfiguration("/**", config);
// return source;
// }

// @Bean // Bean để mã hóa mật khẩu
// public PasswordEncoder passwordEncoder() {
// // Sử dụng BCrypt để mã hóa mật khẩu
// return new BCryptPasswordEncoder();
// }
// }