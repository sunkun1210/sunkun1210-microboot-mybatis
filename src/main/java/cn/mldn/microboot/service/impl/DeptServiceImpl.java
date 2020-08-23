package cn.mldn.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.mldn.microboot.util.controller.MyPageHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import cn.mldn.microboot.dao.IDeptDAO;
import cn.mldn.microboot.service.IDeptService;
import cn.mldn.microboot.vo.Dept;
import cn.mldn.microboot.vo.Member;
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDAO deptDAO;
	@Override
	public PageInfo<Dept> list() {
		MyPageHelper.startPage(2,3);
		List<Dept> list =deptDAO.selectByExample();
		PageInfo<Dept> pageList = new PageInfo<>(list);
		return pageList;
	}
	@Override
	public boolean add(Dept vo) {
		return this.deptDAO.doCreate(vo);
	}
}
