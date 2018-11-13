package edu.nuc.xunwupro.entity;

import edu.nuc.xunwupro.ApplicationTests;
import edu.nuc.xunwupro.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        Assert.assertEquals("konglingze",user.getName());
    }

}
