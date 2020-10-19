package top.durandal.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 重写接收过滤器，使得Spring security能够接收json请求
 *
 * @author bianca-durandal-attagina
 */
public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        String password = this.getBodyParams(request).get(SPRING_SECURITY_FORM_PASSWORD_KEY);
        if (!StringUtils.isEmpty(password)) {
            return password;
        }
        return super.obtainPassword(request);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = this.getBodyParams(request).get(SPRING_SECURITY_FORM_USERNAME_KEY);
        if (!StringUtils.isEmpty(username)) {
            return username;
        }
        return super.obtainUsername(request);

    }

    /**
     * 获取body参数  body中的参数只能获取一次
     *
     * @param request
     * @return
     */
    private Map<String, String> getBodyParams(HttpServletRequest request) {
        Map<String, String> bodyParams = threadLocal.get();
        if (bodyParams == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try (InputStream is = request.getInputStream()) {
                bodyParams = objectMapper.readValue(is, Map.class);
            } catch (IOException e) {
            }
            if (bodyParams == null) {
                bodyParams = new HashMap<>();
            }
            threadLocal.set(bodyParams);
        }

        return bodyParams;

    }
}
