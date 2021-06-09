package com.ctag.domain.model.logs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.junit.Test;

import com.ctag.domain.model.users.UserId;

public class LogsRepositoryIntegrationTest {

	private static final int ID = 1;

	@Inject
	private LogCustom underTest;

	@Inject
	private LogsRepository repo;

	@Test
	public void getAllLogsTest() {

		LogCustom log1 = repo.get(new LogsCustomId(ID)).get();

		List<LogCustom> allRooms =

				repo.get(repo.getSpecificationBuilder().ofAggregate(LogCustom.class).all().build())
						.collect(Collectors.toList());

		repo.add(log1);

		assertThat(allRooms).isNotEmpty().contains(log1);

	}

	@Test
	public void findLogsByUserTest() {

		underTest = new LogCustom();

		underTest.setUserId(new UserId(ID));

		repo.add(underTest);

		List<LogCustom> logs = repo.findLogsByUser(underTest.getUserId());

		assertThat(logs.get(logs.size()-1).getUserId()).isEqualTo(underTest.getUserId());

	}

}
