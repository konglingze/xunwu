package edu.nuc.xunwupro.service;

import edu.nuc.xunwupro.entity.User;

/**
 * @ClassName IUserService
 * @Description 用户服务
 * @Author 孔先生
 * @Date 2018/10/30 12:35
 * @Version 1.0
 **/
public interface IUserService {
    User findUserByName(String userName);



}
