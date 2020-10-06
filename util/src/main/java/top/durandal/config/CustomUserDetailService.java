package top.durandal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.durandal.dao.UserDao;
import top.durandal.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userDao.findByName(name);
        if (user==null){
            throw new UsernameNotFoundException("not Found User");
        }
        List<GrantedAuthority>authorities =new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        org.springframework.security.core.userdetails.User userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPass(),authorities);
        return userDetails;
    }
}
