package top.durandal.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import top.durandal.common.ResponseInfo;
import top.durandal.entity.User;
import top.durandal.statictext.StaticText;

import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

        private final SecretKey tokenKey = Keys.hmacShaKeyFor(StaticText.TOKEN_KEY.getBytes());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userEmail = ((User) authentication.getPrincipal()).getUserEmail();
        List<Object> roles = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        String token= Jwts.builder().setHeaderParam("TYP", "JWT").setSubject(userEmail)
                .setIssuer("durandal")
                .claim("roles", roles)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(tokenKey).compact();
        resToken(token);
    }

    public ResponseInfo resToken(String token){
        if (token==null){
            return ResponseInfo.error("没有token");
        }
        return ResponseInfo.success(token);
    }
}
