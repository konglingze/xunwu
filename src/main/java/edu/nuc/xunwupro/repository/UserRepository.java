package edu.nuc.xunwupro.repository;

import edu.nuc.xunwupro.entity.User;
import org.springframework.data.repository.CrudRepository;

//Jpa 操作类
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String userName);

}
