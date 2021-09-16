package com.xiwu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwu.server.pojo.Admin;
import com.xiwu.server.pojo.RespBean;
import com.xiwu.server.pojo.Role;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 获取登录信息
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password,String code, HttpServletRequest request);

    /**
     * 使用用户名获取登录信息
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**
     * 使用id 获取身份信息
     * @param adminId
     * @return
     */
    //List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
//    List<Admin> getAllAdmins(String keywords);
//
//    /**
//     * 更新操作员角色
//     * @param adminId
//     * @param rids
//     * @return
//     */
//    RespBean updateAdminRole(Integer adminId, Integer[] rids);
//
//    /**
//     * 更新用户密码
//     * @param oldPass
//     * @param pass
//     * @param adminId
//     * @return
//     */
//    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);
//
//    /**
//     * 更新用户头像
//     * @param url
//     * @param id
//     * @param authentication
//     * @return
//     */
//    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);

    /**
     * 退出登录，前端删除token后端不操作
     * @return
     */
    RespBean logOut();

    List<Role> getRoles(Integer id);

    /**
     * 获取所有操作员
     *
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    RespBean addAdminRole(Integer adminId, Integer[] rids);
}
