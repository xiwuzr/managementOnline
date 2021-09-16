package com.xiwu.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiwu.server.pojo.Department;
import com.xiwu.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-04-11
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getAllDepartments();

    RespBean addDep(Department dep);


    RespBean deleteDep(Integer id);
}
