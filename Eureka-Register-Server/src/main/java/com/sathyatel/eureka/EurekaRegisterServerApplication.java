package com.sathyatel.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegisterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegisterServerApplication.class, args);
	}
	
	
	@Bean
	@Profile("!default")
	public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils)
	{
		EurekaInstanceConfigBean b=new EurekaInstanceConfigBean(inetUtils);
		AmazonInfo info=AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		b.setDataCenterInfo(info);
		return b;
		
	}


}
