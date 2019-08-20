package com.zhwlt.logistics.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
@Component
public class MyHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.down().withDetail("info","还活着！").build();
	}

}