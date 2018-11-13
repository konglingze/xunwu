package edu.nuc.xunwupro.service.user;

import edu.nuc.xunwupro.entity.Role;
import edu.nuc.xunwupro.entity.User;
import edu.nuc.xunwupro.repository.RoleRepository;
import edu.nuc.xunwupro.repository.UserRepository;
import edu.nuc.xunwupro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 孔先生
 * @Date 2018/10/30 12:38
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            return null;
        }
        List<Role> roles = roleRepository.findRoleById(user.getId());
        if (roles == null || roles.isEmpty()) {
            throw new DisabledException("权限非法");
        }
        //权限存在
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" +
                    role.getName()));
        });
        return user;
    }
}
