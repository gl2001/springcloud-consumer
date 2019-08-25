package cn.sz.gl.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sz.gl.pojo.Emp;
import cn.sz.gl.service.impl.EmpClientServiceCallbackFactory;

@FeignClient(value="service-helloworld",fallback=EmpClientServiceCallbackFactory.class)
public interface EmpClientService {

	@RequestMapping(value="ec/findbyid/{id}")
	public Emp findbyid(@PathVariable("id")Integer empno);
	
	@RequestMapping(value="ec/findall")
	public List<Emp> findall();
}
