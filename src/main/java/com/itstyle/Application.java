package com.itstyle;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
/**
 * 支付主控(启动的时候一定要把main方法的注释去掉，配置好支付宝、微信以及银联相关参数)
 * 创建者 科帮网
 * 创建时间 2017年7月27日
 * 启动   java -jar spring-boot-pay.jar --server.port=8886 
 * linux 下 后台启动  nohup java -jar spring-boot-pay.jar --server.port=8886 & 
 * 
 * 2018-10-10 更新说明：
 * 1）原当当 Dubbox 2.8.4 替换为 Dubbo 2.6.2
 * 2）原spring-context-dubbo.xml 配置 替换为 dubbo-spring-boot-starter 2.0.0
 * 3）原 zkclient 0.6 替换为 curator-recipes 4.0.1
 * 4）原 zookeeper 3.4.6 升级为 zookeeper 3.5.3
 */
@EnableDubboConfiguration
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
		logger.info("支付项目启动 ");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/cert/**").addResourceLocations(
				"classpath:/cert/");
		super.addResourceHandlers(registry);
		logger.info("自定义静态资源目录,这只是个Demo,生产肯定不会暴露");
	}
}