package edu.nuc.xunwupro.security;

import edu.nuc.xunwupro.entity.User;
import edu.nuc.xunwupro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName AuthProvider
 * @Description 数据库验证用户身份逻辑
 * @Author 孔先生
 * @Date 2018/10/30 12:29
 * @Version 1.0
 **/
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userService;
    //Md5解密password
    private final Md5PasswordEncoder encoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();
        User user = userService.findUserByName(userName);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("很抱歉，验证失败，用户不存在");
        }
        //if (user.getPassword().equals(inputPassword)) {
        //加盐(ID)验证密码匹配
        if (this.encoder.isPasswordValid(user.getPassword(), inputPassword, user.getId())) {
            //authentication.setAuthenticated(true);

            return new UsernamePasswordAuthenticationToken();
        }
        throw new BadCredentialsException("密码不对？");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
