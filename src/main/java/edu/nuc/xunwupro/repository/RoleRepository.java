package edu.nuc.xunwupro.repository;

import edu.nuc.xunwupro.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
     List<Role> findRoleById(Long userId);
}
