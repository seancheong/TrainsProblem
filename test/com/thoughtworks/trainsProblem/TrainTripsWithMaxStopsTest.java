package com.thoughtworks.trainsProblem;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TrainTripsWithMaxStopsTest extends TrainTestBase {

	private char point;
	private int maxStops;

	private List<TrainRoute> routeList;

	@Before
	public void setUp() throws Exception {
		routeList = new ArrayList<TrainRoute>(convertGraphValueIntoTrainRouteList());
	}

	@Test
	public void whenStartingPtAndEndingPtWithMaxStopsPassedIn_testResult_shouldReturnCorrectTrips() {
		// given
		point = 'C';
		maxStops = 3;

		// when
		TrainTripsWithMaxStops trainTrips = new TrainTripsWithMaxStops(point, point, maxStops, routeList);

		// then
		assertThat(trainTrips.printValue(), is(2));
	}
}
