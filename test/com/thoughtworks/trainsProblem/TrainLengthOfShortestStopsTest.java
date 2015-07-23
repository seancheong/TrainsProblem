package com.thoughtworks.trainsProblem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class TrainLengthOfShortestStopsTest extends TrainTestBase {
	
	private char startPt;
	private char endPt;
	
	private List<TrainRoute> routeList;

	@Before
	public void setUp() throws Exception {
		routeList = new ArrayList<TrainRoute>(convertGraphValueIntoTrainRouteList());
	}

	@Test
	public void whenStartPtAndEndPtPassedIn_testResult_shouldReturnCorrectLength() {
		// given
		startPt = 'A';
		endPt = 'C';
		
		// when
		TrainLengthOfShortestStops trainLength = new TrainLengthOfShortestStops(startPt, endPt, routeList);
		
		// then
		assertThat(trainLength.printValue(), is(9));
	}
	
	@Test
	public void whenStartPtBAndEndPtBPassedIn_testResult_shouldReturn9Length() {
		// given
		startPt = 'B';
		endPt = 'B';
		
		// when
		TrainLengthOfShortestStops trainLength = new TrainLengthOfShortestStops(startPt, endPt, routeList);
		
		// then
		assertThat(trainLength.printValue(), is(9));
	}

}
