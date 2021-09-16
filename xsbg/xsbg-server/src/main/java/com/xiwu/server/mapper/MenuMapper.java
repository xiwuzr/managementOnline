package com.xiwu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwu.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByAdminId(Integer adminId);

    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
