package com.thoughtworks.trainsProblem;

/*
 * This class is to input values into organized object.
 * Having starting point, ending point and edge property.
 */
public class TrainRoute {
	private char startingPoint;
	private char endingPoint;
	private int edge;

	public TrainRoute(char startingPoint, char endingPoint, char edge) {
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.edge = Character.getNumericValue(edge);
	}

	public char getStartingPoint() {
		return startingPoint;
	}

	public char getEndingPoint() {
		return endingPoint;
	}

	public int getEdge() {
		return edge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((startingPoint == ' ') ? 0 : Character.getNumericValue(startingPoint));
		return result;
	}

	// had to overwrite this to make sure I can compare between two similar value object
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainRoute other = (TrainRoute) obj;
		if (startingPoint == ' ' && endingPoint == ' ') {
			if (other.startingPoint != ' ' || other.endingPoint != ' ')
				return false;
		} else if (startingPoint != other.startingPoint || endingPoint != other.endingPoint)
			return false;
		return true;
	}
}
