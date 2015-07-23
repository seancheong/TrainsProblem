package com.thoughtworks.trainsProblem;

import java.util.ArrayList;
import java.util.List;

public class TrainTestBase {
	public static final String[] GRAPH = new String[] { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5",
			"CE2", "EB3", "AE7" };

	private final List<TrainRoute> routeList = new ArrayList<TrainRoute>();

	protected List<TrainRoute> convertGraphValueIntoTrainRouteList() {
		for (int i = 0; i < GRAPH.length; i++) {
			TrainRoute trainRoute = new TrainRoute(GRAPH[i].charAt(0), GRAPH[i].charAt(1),
					GRAPH[i].charAt(2));
			routeList.add(trainRoute);
		}
		return routeList;
	}
}
