package com.thoughtworks.trainsProblem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class TrainTripsWithNExactStopsTest extends TrainTestBase {
	
	private char startPt;
	private char endPt;
	private int maxStops;
	
	private List<TrainRoute> routeList;

	@Before
	public void setUp() throws Exception {
		routeList = new ArrayList<TrainRoute>(convertGraphValueIntoTrainRouteList());
	}

	@Test
	public void whenStartPtAndEndPtPassedInWithMaxStops_testResult_shouldReturnCorrectTripsNumber() {
		//given
		startPt = 'A';
		endPt = 'C';
		maxStops = 4;
		
		// when
		TrainTripsWithNExactStops trainTrips = new TrainTripsWithNExactStops(startPt, endPt, maxStops, routeList);
		
		// then
		assertThat(trainTrips.printValue(), is(3));
	}

}
