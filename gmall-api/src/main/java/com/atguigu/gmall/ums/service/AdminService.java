package com.atguigu.gmall.ums.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@Service
@Component
public interface AdminService extends IService<Admin> {

    //登陆
    Admin login(String username, String password);

    Admin getAdminByUserName(String userName);
}
