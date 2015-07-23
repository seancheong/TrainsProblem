package com.thoughtworks.trainsProblem;

import java.util.ArrayList;
import java.util.List;
/*
 * This class is to calculate the length of the shortest route between two points (in terms of distance to travel) 
 */
public class TrainLengthOfShortestStops extends Train {

	private int numberOfStops;
	private int shortestStops;
	private int lengthForShortestStops;
	private char destination;

	private List<TrainRoute> routeList;
	private List<TrainRoute> tempRouteList;

	public TrainLengthOfShortestStops(char startPt, char endPt, List<TrainRoute> cloneList) {

		routeList = new ArrayList<TrainRoute>(cloneList);

		numberOfStops = 0;
		shortestStops = 0;
		lengthForShortestStops = 0;

		destination = endPt;
		tempRouteList = new ArrayList<TrainRoute>();

		calculateTrainRoute(startPt);
	}

	@Override
	public int printValue() {
		return lengthForShortestStops;
	}

	@Override
	public void calculateTrainRoute(char point) {
		for (int i = 0; i < routeList.size(); i++) {
			TrainRoute trainRoute = routeList.get(i);

			if (trainRoute.getStartingPoint() == point) {
				if (!isLastElementSameAsLastThirdElementFromList(tempRouteList)) {
					numberOfStops++;
					tempRouteList.add(trainRoute);
					if (trainRoute.getEndingPoint() == destination) {
						if (shortestStops == 0 || numberOfStops < shortestStops) {
							shortestStops = numberOfStops;

							calculateLengthForShortestStops();
						}
						numberOfStops--;
						tempRouteList.remove(lastElementIndex(tempRouteList));
					} else {
						calculateTrainRoute(trainRoute.getEndingPoint());
					}
				}
			}
			resetToPreviosLoopSettingsForLastIndex(i);
		}
	}

	private void calculateLengthForShortestStops() {
		lengthForShortestStops = 0;

		for (int j = 0; j < tempRouteList.size(); j++) {
			lengthForShortestStops += tempRouteList.get(j).getEdge();
		}
	}

	@Override
	protected void resetToPreviosLoopSettingsForLastIndex(int lastIndex) {
		if (routeList.size() != 0 && lastIndex == lastElementIndex(routeList)
				&& tempRouteList.size() != 0) {
			numberOfStops--;
			tempRouteList.remove(lastElementIndex(tempRouteList));
		}
	}

	@Override
	public String calculateDistance(char[] route) {
		return "";
	}

}
