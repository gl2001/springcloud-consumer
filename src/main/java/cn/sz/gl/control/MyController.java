package cn.sz.gl.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.sz.gl.pojo.Emp;
import cn.sz.gl.service.EmpClientService;


@RestController
@ConfigurationProperties(prefix="helloservice")
public class MyController {

	@Autowired
	private RestTemplate restTemplate;
	
	private String servicepath;
	
	/*private String findbyidpath;
	private String findallpath;*/
	
	@Autowired
	private EmpClientService empClientService;
	
	@RequestMapping(value="/sh/{kw}")
	public String show(@PathVariable("kw")String kw) {
		System.out.println("---"+kw+"---");
		System.out.println("=="+servicepath+kw+"==");
		System.out.println(restTemplate);
		//return "abc";
		return restTemplate.getForObject(servicepath+kw, String.class);
	}
	
	/*@RequestMapping(value="findbyid/{id}")
	public Emp findbyid(@PathVariable("id")Integer id) {
		return restTemplate.getForObject(findbyidpath+id, Emp.class);
	}*/
	
	
	@RequestMapping(value="findbyid/{id}")
	public Emp findbyid(@PathVariable("id")Integer id) {
		Emp emp = empClientService.findbyid(id);
		/*if(emp==null) {
			throw new RuntimeException("异常了");
		}*/
		/*if(emp.getEmpName().equals("空")) {
			throw new RuntimeException("没有数据");
		}*/
		return emp;
	}
	
	@RequestMapping(value="findall")
	public List<Emp> findall(){
		return empClientService.findall();
	}
	

	public String getServicepath() {
		return servicepath;
	}

	public void setServicepath(String servicepath) {
		this.servicepath = servicepath;
	}



	/*public String getFindbyidpath() {
		return findbyidpath;
	}



	public void setFindbyidpath(String findbyidpath) {
		this.findbyidpath = findbyidpath;
	}



	public String getFindallpath() {
		return findallpath;
	}



	public void setFindallpath(String findallpath) {
		this.findallpath = findallpath;
	}*/
	
	
	
	
}
