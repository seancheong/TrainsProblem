package com.thoughtworks.trainsProblem;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is to calculate the number of trips between two points with an exact stops
 */
public class TrainTripsWithNExactStops extends Train {

	private int numberOfStops;
	private int maxStops;
	private int numberOfTrips;
	private char destination;

	private List<TrainRoute> routeList;

	public TrainTripsWithNExactStops(char startPt, char endPt, int stops, List<TrainRoute> cloneList) {

		routeList = new ArrayList<TrainRoute>(cloneList);
		destination = endPt;
		maxStops = stops;

		numberOfStops = 0;
		numberOfTrips = 0;

		calculateTrainRoute(startPt);
	}

	@Override
	public int printValue() {
		return numberOfTrips;
	}

	@Override
	public void calculateTrainRoute(char point) {
		for (int i = 0; i < routeList.size(); i++) {
			TrainRoute trainRoute = routeList.get(i);

			if (trainRoute.getStartingPoint() == point) {
				if (numberOfStops <= maxStops) {
					numberOfStops++;
					
					if (numberOfStops == maxStops) {
						if (trainRoute.getEndingPoint() == destination) {
							numberOfTrips++;
						}
						numberOfStops--;
					} else {
						calculateTrainRoute(trainRoute.getEndingPoint());
					}
				}
			}
			resetToPreviosLoopSettingsForLastIndex(i);
		}
	}

	@Override
	protected void resetToPreviosLoopSettingsForLastIndex(int lastindex) {
		if (routeList.size() != 0 && lastindex == routeList.size() - 1) {
			numberOfStops--;
		}
	}

	@Override
	public String calculateDistance(char[] route) {
		return "";
	}
}
