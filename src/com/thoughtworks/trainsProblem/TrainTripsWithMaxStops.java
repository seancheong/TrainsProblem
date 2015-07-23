package com.thoughtworks.trainsProblem;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is to calculate the number of trips between two points with a maximum stops
 */
public class TrainTripsWithMaxStops extends Train {

	private int numberOfStops;
	private int maxStops;
	private int numberOfTrips;
	private char destination;

	private List<TrainRoute> routeList;
	private List<TrainRoute> tempRouteList;

	public TrainTripsWithMaxStops(char startPt, char endPt, int max, List<TrainRoute> cloneList) {

		routeList = new ArrayList<TrainRoute>(cloneList);
		destination = endPt;
		maxStops = max;

		numberOfStops = 0;
		numberOfTrips = 0;
		tempRouteList = new ArrayList<TrainRoute>();

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
				if (numberOfStops < maxStops) {
					tempRouteList.add(trainRoute);
					numberOfStops++;

					if (isLastElementSameAsLastThirdElementFromList(tempRouteList)) {
						tempRouteList.remove(lastElementIndex(tempRouteList));
						numberOfStops--;
					} else if (trainRoute.getEndingPoint() == destination) {
						numberOfTrips++;
						calculateTrainRoute(trainRoute.getEndingPoint());
					} else {
						calculateTrainRoute(trainRoute.getEndingPoint());
					}
				}
			}
			resetToPreviosLoopSettingsForLastIndex(i);
		}
	}

	@Override
	protected void resetToPreviosLoopSettingsForLastIndex(int lastIndex) {
		if (routeList.size() != 0 && lastIndex == lastElementIndex(routeList)
				&& tempRouteList.size() != 0) {
			tempRouteList.remove(lastElementIndex(tempRouteList));
			numberOfStops--;
		}
	}

	@Override
	public String calculateDistance(char[] route) {
		return "";
	}
}
