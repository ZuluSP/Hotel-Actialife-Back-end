package com.ctag.lifecyclelisteners;

import javax.inject.Inject;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.seedstack.scheduler.ScheduledTasks;
import org.seedstack.seed.Configuration;
import org.seedstack.seed.LifecycleListener;

import com.ctag.domain.configuration.lifecycles.HabitacionTipoLifeCycleConfiguration;
import com.ctag.tasks.habitaciontipo.HabitacionTipoRaisePrice;

public class HabitacionTipoLifeCycle implements LifecycleListener {

	private ScheduledTasks scheduledTasks;
	@Configuration
	private HabitacionTipoLifeCycleConfiguration config;

	@Inject
	public HabitacionTipoLifeCycle(ScheduledTasks scheduledTasks) {
		this.scheduledTasks = scheduledTasks;
	}

	private Trigger trigger;
	//private Logger logger;

	@Override
	public void started() {

		//logger.info("started");
		Integer minutes = config.getMinutes();
		trigger = // configuras el trigger
				TriggerBuilder.newTrigger()
						.withSchedule(
								SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(minutes).withRepeatCount(5))
						.withIdentity("Downtime", "Server").build();
		//logger.info("execute " + minutes);

		scheduledTasks.scheduledTask(HabitacionTipoRaisePrice.class).withPriority(10) // no es necesaria
				.withTrigger(trigger).withTaskName("HabitacionTipoRaisePrice").schedule();
	}

	@Override
	public void stopping() {
		scheduledTasks.scheduledTask(HabitacionTipoRaisePrice.class).unschedule(trigger.getKey().getName());
	}
}
