package com.xiwu.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwu.server.mapper.MenuMapper;
import com.xiwu.server.pojo.Admin;
import com.xiwu.server.pojo.Menu;
import com.xiwu.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal()).getId();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        List<Menu> menus=(List<Menu>) valueOperations.get("menu_" + adminId);
        if(CollectionUtils.isEmpty(menus)){
            menus = baseMapper.getMenusByAdminId(adminId);
            log.debug("数据库中查询得到的数据");
            valueOperations.set("menu_"+adminId,menus);
        }

        return menus;

    }

    /**
     * 根据角色获取菜单列表
     *
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return baseMapper.getMenusWithRole();
    }

    @Override
    public List<Menu> getAllMenus() {
        return baseMapper.getAllMenus();
    }
}
