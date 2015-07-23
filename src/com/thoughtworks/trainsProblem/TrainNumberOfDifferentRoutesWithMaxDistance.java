package com.thoughtworks.trainsProblem;

import java.util.ArrayList;
import java.util.List;
/*
 * This class is to calculate the number of different routes between two points with a maximum distance
 */
public class TrainNumberOfDifferentRoutesWithMaxDistance extends Train {

	private int maxDistance;
	private int numberOfTrips;
	private char destination;

	private List<TrainRoute> routeList;
	private List<TrainRoute> tempRouteList;

	public TrainNumberOfDifferentRoutesWithMaxDistance(char startPt, char endPt, int max, List<TrainRoute> cloneList) {

		routeList = new ArrayList<TrainRoute>(cloneList);
		destination = endPt;
		maxDistance = max;

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
				int distance;
				tempRouteList.add(trainRoute);
				distance = calculateCurrentDistance(tempRouteList);

				if (distance < maxDistance) {

					if (isLastElementSameAsLastThirdElementFromList(tempRouteList)) {
						tempRouteList.remove(lastElementIndex(tempRouteList));
					} else if (trainRoute.getEndingPoint() == destination) {
						numberOfTrips++;
						calculateTrainRoute(trainRoute.getEndingPoint());
					} else {
						calculateTrainRoute(trainRoute.getEndingPoint());
					}
				} else
					tempRouteList.remove(lastElementIndex(tempRouteList));
			}
			resetToPreviosLoopSettingsForLastIndex(i);
		}
	}

	private int calculateCurrentDistance(List<TrainRoute> list) {
		int distance = 0;

		for (TrainRoute trainList : list) {
			distance += trainList.getEdge();
		}

		return distance;
	}

	@Override
	protected void resetToPreviosLoopSettingsForLastIndex(int lastIndex) {
		if (routeList.size() != 0 && lastIndex == lastElementIndex(routeList)
				&& tempRouteList.size() != 0) {
			tempRouteList.remove(lastElementIndex(tempRouteList));
		}
	}

	@Override
	public String calculateDistance(char[] route) {
		return "";
	}
}
