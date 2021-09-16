package com.xiwu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwu.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
    /**
     * 更新菜单表，返回受影响的行数
     * @param rid
     * @param mids
     * @return
     */

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
