package com.thoughtworks.trainsProblem;

import java.util.List;

/*
 * This abstract Train class is to contains some basic functions that will be inherited
 * by other classes
 */
public abstract class Train {

	// print outputs to console
	public abstract int printValue();

	// calculate train routes based on various situation
	public abstract void calculateTrainRoute(char point);

	// calculate distance taken for certain route, 
	// will print "NO SUCH ROUTE" if certain route cannot be found 
	public abstract String calculateDistance(char[] route);

	// if the last element from the loop has been checked,
	// this function will revert to previous loop settings
	protected abstract void resetToPreviosLoopSettingsForLastIndex(int lastIndex);

	// this function is to prevent stack overflow error, e.g. CD -> DC -> CD (infinite loop)
	protected boolean isLastElementSameAsLastThirdElementFromList(List<TrainRoute> list) {
		return (list.size() > 2 && list.get(lastElementIndex(list)).equals(list.get(lastElementIndex(list) - 2)));
	}

	protected int lastElementIndex(List<TrainRoute> list) {
		return list.size() - 1;
	}
}
