package io.github.ztgoto.demo.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class ConfigurationApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

	private int order = 0;
	
	@Override
	public int getOrder() {
		
		return this.order;
	}

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("--------------------");
		
	}

}
