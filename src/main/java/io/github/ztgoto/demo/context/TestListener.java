package io.github.ztgoto.demo.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class TestListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("+++++++++++++++"+ event.getClass().getName());
		
	}

}
