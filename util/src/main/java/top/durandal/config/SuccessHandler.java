package top.durandal.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.RestController;
import top.durandal.statictext.StaticText;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    RedisTemplate<String,String> redisTemplate;

    private final SecretKey tokenKey = Keys.hmacShaKeyFor(StaticText.TOKEN_KEY.getBytes());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String usernameEmail = ((User) authentication.getPrincipal()).getUsername();
        List<Object> roles = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        String token = Jwts.builder().setHeaderParam("TYP", "JWT").setSubject(usernameEmail)
                .setIssuer("durandal")
                .claim("roles", roles)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(tokenKey).compact();
        if (token != null) {
            redisTemplate.opsForValue().set(usernameEmail,token,60 * 60 * 24 * 1000, TimeUnit.SECONDS);
            System.out.println("handlerEmail:"+usernameEmail);
            System.out.println(redisTemplate.opsForValue().get(usernameEmail));
            httpServletResponse.setHeader(StaticText.TOKEN_HEADER,StaticText.TOKEN_PREFIX+token);
            httpServletResponse.getWriter().write("The user's token is : "+"\n"+token);
        }else {
            httpServletResponse.getWriter().write("No token");
        }

    }
}
