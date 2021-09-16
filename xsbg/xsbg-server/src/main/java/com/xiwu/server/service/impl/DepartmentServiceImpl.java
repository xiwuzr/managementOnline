package com.xiwu.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiwu.server.mapper.DepartmentMapper;
import com.xiwu.server.pojo.Department;
import com.xiwu.server.pojo.RespBean;
import com.xiwu.server.service.IDepartmentService;
import org.springframework.stereotype.Service;

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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    /**
     * 获取所有部门
     *
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return baseMapper.getAllDepartments(-1);

    }
    /**
     * 添加部门
     *
     * @param dep
     * @return
     */
    @Override
    public RespBean addDep(Department dep) {
        dep.setEnabled(true);
        baseMapper.addDep(dep);
        if (1 == dep.getResult()) {
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public RespBean deleteDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        baseMapper.deleteDep(dep);
        if (-2==dep.getResult()) {
            return RespBean.error("删除失败，该部门下还有子部门！");
        }
        if (-1==dep.getResult()) {
            return RespBean.error("删除失败，该部门下还有员工！");
        }
        if (1==dep.getResult()) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
