package com.thoughtworks.trainsProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * This is the main file of this whole application.
 * This application able to help the railroad to compute the distance along a certain route, 
 * the number of different routes between two towns, and the shortest route between two towns.
 * 
 * Modify the INPUT_FILENAME for Graph list.
 */

public class TrainApp {
	public static final String INPUT_FILENAME = "input.txt";

	private final char[] routeABC = { 'A', 'B', 'C' };
	private final char[] routeAD = { 'A', 'D' };
	private final char[] routeADC = { 'A', 'D', 'C' };
	private final char[] routeAEBCD = { 'A', 'E', 'B', 'C', 'D' };
	private final char[] routeAED = { 'A', 'E', 'D' };
	private final List<TrainRoute> routeList = new ArrayList<TrainRoute>();

	// main function of this application
	public static void main(String[] args) {
		TrainApp trainApp = new TrainApp(INPUT_FILENAME);
		trainApp.printToConsole();
	}

	public TrainApp(String fileName) {
		try {
			readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printToConsole() {
		
		// parameters can be changed in order to calculate different routes
		TrainRouteDistance routeDistance = new TrainRouteDistance(routeList);
		TrainTripsWithMaxStops tripsWithMaxStops = new TrainTripsWithMaxStops('C', 'C', 3, routeList);
		TrainTripsWithNExactStops tripsWithNExactStops = new TrainTripsWithNExactStops('A', 'C', 4,
				routeList);
		TrainLengthOfShortestStops lengthOfShortestStops1 = new TrainLengthOfShortestStops('A',
				'C', routeList);
		TrainLengthOfShortestStops lengthOfShortestStops2 = new TrainLengthOfShortestStops('B',
				'B', routeList);
		TrainNumberOfDifferentRoutesWithMaxDistance numberOfDifferentRoutesFromOnePoint = new TrainNumberOfDifferentRoutesWithMaxDistance(
				'C', 'C', 30, routeList);

		System.out.println("Output #1: " + routeDistance.calculateDistance(routeABC));
		System.out.println("Output #2: " + routeDistance.calculateDistance(routeAD));
		System.out.println("Output #3: " + routeDistance.calculateDistance(routeADC));
		System.out.println("Output #4: " + routeDistance.calculateDistance(routeAEBCD));
		System.out.println("Output #5: " + routeDistance.calculateDistance(routeAED));
		System.out.println("Output #6: " + tripsWithMaxStops.printValue());
		System.out.println("Output #7: " + tripsWithNExactStops.printValue());
		System.out.println("Output #8: " + lengthOfShortestStops1.printValue());
		System.out.println("Output #9: " + lengthOfShortestStops2.printValue());
		System.out.println("Output #10: " + numberOfDifferentRoutesFromOnePoint.printValue());
	}
	
	// After getting the input from an input file, 
	// this function will convert every value into TrainRoute Object
	private void convertGraphValueIntoTrainRouteList(List<String> tempList) {		
		for(String input : tempList) {
			TrainRoute trainRoute = new TrainRoute(input.charAt(0), input.charAt(1), input.charAt(2));
			routeList.add(trainRoute);
		}
	}
	
	// read file function
	public void readFile(String filename) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(filename));

        String line;
        List<String> tempList = new ArrayList<String>();

        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");
            int length = vals.length;
         
            for (int i = 0; i < length; i++) {
                	tempList.add(vals[i]);
            }
        }
        
        if(buffer != null)
        	buffer.close();
        
        convertGraphValueIntoTrainRouteList(tempList);
    }
}
