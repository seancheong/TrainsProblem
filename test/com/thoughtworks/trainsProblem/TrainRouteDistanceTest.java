package com.thoughtworks.trainsProblem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class TrainRouteDistanceTest extends TrainTestBase {
	public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";
	
	private final char[] routeABC = { 'A', 'B', 'C' };
	private final char[] routeAED = { 'A', 'E', 'D' };

	private List<TrainRoute> routeList;
	
	@Before
	public void setUp() throws Exception {
		routeList = new ArrayList<TrainRoute>(convertGraphValueIntoTrainRouteList());
	}

	@Test
	public void whenRouteProvidedExists_testResult_shouldReturnTheDistanceOfTotalTrips() {
		// given
		String distanceString = "9";
		
		// when
		TrainRouteDistance routeDistance = new TrainRouteDistance(routeList);
		
		// then
		assertThat(routeDistance.calculateDistance(routeABC), is(distanceString));
	}
	
	@Test
	public void whenRouteProvidedNotExists_testResult_shouldReturnNoSuchRouteString() {
		// when
		TrainRouteDistance routeDistance = new TrainRouteDistance(routeList);
		
		// then
		assertThat(routeDistance.calculateDistance(routeAED), is(NO_SUCH_ROUTE));
	}

}
