package com.xiwu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwu.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(Integer adminId);
}
