package com.ctag.domain.configuration.lifecycles;

import org.seedstack.coffig.Config;

@Config("com.ctag.hotel.lifecycle-listener")
public class HabitacionTipoLifeCycleConfiguration {
	
	@Config("cleardevicestask.minutes")
	private Integer minutes;
	

	public Integer getMinutes() {
		return minutes;
	}
}
