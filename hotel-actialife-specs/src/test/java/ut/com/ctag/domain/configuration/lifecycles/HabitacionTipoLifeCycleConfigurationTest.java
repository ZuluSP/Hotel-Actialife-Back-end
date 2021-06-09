package com.ctag.domain.configuration.lifecycles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.internal.configuration.plugins.Plugins;

public class HabitacionTipoLifeCycleConfigurationTest {
	
	private static final Integer TEST_INTEGER = 1;
	private HabitacionTipoLifeCycleConfiguration underTest = new HabitacionTipoLifeCycleConfiguration();

	@Test
	public void testGetMinutes() {
		
		try {
			 Plugins.getMemberAccessor().set(HabitacionTipoLifeCycleConfiguration.class.getDeclaredField("minutes"), underTest, TEST_INTEGER);
			assertEquals(underTest.getMinutes(), TEST_INTEGER);
			
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		

	}
}
