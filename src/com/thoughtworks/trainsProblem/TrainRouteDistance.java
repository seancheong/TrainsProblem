package com.thoughtworks.trainsProblem;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is to calculate distance taken for certain route, 
 * will print "NO SUCH ROUTE" if certain route cannot be found
 */
public class TrainRouteDistance extends Train {

	public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

	private List<TrainRoute> routeList;

	public TrainRouteDistance(List<TrainRoute> cloneList) {

		routeList = new ArrayList<TrainRoute>(cloneList);
	}

	@Override
	public int printValue() {
		return 0;
	}

	@Override
	public String calculateDistance(char[] route) {
		int distance = 0;

		for (int i = 0; i < route.length - 1; i++) {
			boolean routeFound = false;

			for (TrainRoute trainRoute : routeList) {
				if (trainRoute.getStartingPoint() == route[i]
						&& trainRoute.getEndingPoint() == route[i + 1]) {
					distance += trainRoute.getEdge();
					routeFound = true;
				}
			}
			if (!routeFound) {
				distance = 0;
				break;
			}
		}
		if (distance == 0)
			return NO_SUCH_ROUTE;

		return Integer.toString(distance);
	}

	@Override
	public void calculateTrainRoute(char point) {
		//
	}

	@Override
	protected void resetToPreviosLoopSettingsForLastIndex(int lastIndex) {
		//
	}

}
