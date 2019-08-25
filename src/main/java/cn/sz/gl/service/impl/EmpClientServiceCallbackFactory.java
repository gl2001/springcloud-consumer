package cn.sz.gl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.gl.pojo.Emp;
import cn.sz.gl.service.EmpClientService;
@Service
public class EmpClientServiceCallbackFactory implements EmpClientService {

	@Override
	public Emp findbyid(Integer empno) {
		Emp emp = new Emp();
		emp.setEmpName("没有");
		emp.setEmpno(empno);
		return emp;
	}

	@Override
	public List<Emp> findall() {
		return null;
	}

}
