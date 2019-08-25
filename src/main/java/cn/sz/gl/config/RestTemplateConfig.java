package cn.sz.gl.config;

import org.apache.commons.codec.language.bm.Rule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced//开启 Ribbon 负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myrule() {
		return new RandomRule();
	}
}
