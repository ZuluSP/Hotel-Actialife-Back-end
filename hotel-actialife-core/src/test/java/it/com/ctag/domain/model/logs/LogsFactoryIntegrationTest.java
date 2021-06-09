package com.ctag.domain.model.logs;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.testing.junit4.SeedITRunner;

@JpaUnit
@Transactional
@RunWith(SeedITRunner.class)
public class LogsFactoryIntegrationTest {

	private static final Integer TEST_INTEGER = 1;
	private static final String TEST_STRING = "test";
	private static final Long INITIAL_EXPECTED_CONTROL_RESULTS = 1L;
	private static final Long EXPECTED_CONTROL_RESULTS = 2L;

	@Inject
	private LogsFactory factory;
	@Inject
	private LogsRepository repository;

	@Test
	public void createHabitacionTipo() throws Exception {

		validateAllLogs(INITIAL_EXPECTED_CONTROL_RESULTS);

		LogCustom createLog = factory.createLog(TEST_INTEGER, TEST_STRING, TEST_STRING);

		validateAllLogs(EXPECTED_CONTROL_RESULTS);

		assertThat(createLog.getUserId().getId()).isEqualTo(TEST_INTEGER);
		assertThat(createLog.getLog()).isEqualTo(TEST_STRING);
		assertThat(createLog.getTime()).isEqualTo(TEST_STRING);

	}

	public void validateAllLogs(Long expected) {
		Long before = repository
				.get(repository.getSpecificationBuilder()
						.of(LogCustom.class)
						.all()
						.build())
				.count();
		assertThat(before).isEqualTo(expected);
	}

}