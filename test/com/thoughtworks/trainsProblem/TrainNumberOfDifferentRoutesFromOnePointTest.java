package com.thoughtworks.trainsProblem;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TrainNumberOfDifferentRoutesFromOnePointTest extends TrainTestBase {

	private char point;
	private int maxDistance;

	private List<TrainRoute> routeList;

	@Before
	public void setUp() throws Exception {
		routeList = new ArrayList<TrainRoute>(convertGraphValueIntoTrainRouteList());
	}

	@Test
	public void whenStartingPtAndEndingPtWithMaxDistancePassedIn_testResult_shouldReturnCorrectRoutes() {
		// given
		point = 'C';
		maxDistance = 30;

		// when
		TrainNumberOfDifferentRoutesWithMaxDistance trainRoute = new TrainNumberOfDifferentRoutesWithMaxDistance(
				point, point, maxDistance, routeList);

		// then
		assertThat(trainRoute.printValue(), is(7));
	}
}
