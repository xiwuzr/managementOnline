package com.xiwu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwu.server.pojo.MenuRole;
import com.xiwu.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface IMenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
