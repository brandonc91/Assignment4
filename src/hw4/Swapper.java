package hw4;

import java.util.*;

public class Swapper {

	private static Process cpu;

	public Swapper() {
		cpu = new Process();	
	}
	
	public static int[] fcfs() {
		List<HashMap<String, Number>> processLists = cpu.processes;
		int[] result = new int[102];
		printList(processLists);
		HashMap<String, Number> currentProcess = null;
		
		for (int timeCount = 0; timeCount <= 100; timeCount++) {
			for (int i = 0; i < processLists.size(); i++) {
				
			}
		}
		
		return result;
	}
	
	
	public static void printList(List<HashMap<String, Number>> pl) {
		for (int i = 0; i < pl.size(); i++) {
			System.out.print("pid: "+pl.get(i).get("pid")+"\t");
			System.out.print("Arrival Time: "+pl.get(i).get("arrivalTime")+"\t");
			System.out.print("Run Time: "+pl.get(i).get("burstTime")+"\t");
			System.out.println("Priority: "+pl.get(i).get("priority"));
		}
		System.out.println();
	}

}
