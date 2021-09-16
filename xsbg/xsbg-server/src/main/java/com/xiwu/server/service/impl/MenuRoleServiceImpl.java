package com.xiwu.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwu.server.mapper.MenuRoleMapper;
import com.xiwu.server.pojo.MenuRole;
import com.xiwu.server.pojo.RespBean;
import com.xiwu.server.service.IMenuRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {
    @Override
    @Transactional // 开启事务
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        // 如果调用此接口，没传其它参数，证明是删除已有菜单
        QueryWrapper<MenuRole> rid1 = new QueryWrapper<MenuRole>().eq("rid", rid);
        baseMapper.delete(rid1);
        if (null == mids || 0 == mids.length) {
            return RespBean.success("更新成功！");
        }
        // 如果传参过来，新建批量更新方法，更新角色菜单
        Integer resule = baseMapper.insertRecord(rid, mids);
        if (resule == mids.length) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
