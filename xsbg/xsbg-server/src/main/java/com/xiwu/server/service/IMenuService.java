package com.xiwu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwu.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     *
     * @return
     */
    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
