package com.xiwu.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiwu.server.pojo.Department;
import com.xiwu.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> getAllDepartments(Integer i);

    /**
     * 添加部门
     * @param dep
     * @return
     */
    void addDep(Department dep);

    /**
     * 删除部门
     * @param
     * @return
     */
    void deleteDep(Department dep);

}
