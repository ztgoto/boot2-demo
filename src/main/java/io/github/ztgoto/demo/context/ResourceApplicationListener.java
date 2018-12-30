package io.github.ztgoto.demo.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
@Configuration
public class ResourceApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {
	
	public static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 15;
	
	public static final String ENABLED_CONFIG_KEY = "customize:config:enabled";
	
	private int order = DEFAULT_ORDER;
	
	private static final String CUSTOMIZE_PROPERTIES = "customizeProperties";

	@Override
	public int getOrder() {
		
		return this.order;
	}
	

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment  env = event.getEnvironment();
		MutablePropertySources  source = env.getPropertySources();
		if (source.contains(CUSTOMIZE_PROPERTIES)) {
			return;
		}
//		OriginTrackedMapPropertySource ps = new OriginTrackedMapPropertySource(name, source)
//		MapPropertySource s = new MapPropertySource(name, source)
		
		Map<String, Object> properties = new HashMap<>();
//		properties.put("server.port", 9090);
		
		MapPropertySource ps = new MapPropertySource(CUSTOMIZE_PROPERTIES, properties);
		
		if (source.contains(RandomValuePropertySource.RANDOM_PROPERTY_SOURCE_NAME)) {
			source.addAfter(RandomValuePropertySource.RANDOM_PROPERTY_SOURCE_NAME, ps);
		} else {
			source.addAfter(
					StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
					ps);
		}
		
	}
	

}
