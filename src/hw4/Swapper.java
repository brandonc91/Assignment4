package hw4;

import java.util.*;

public class Swapper {

	private static Process cpu;
	public final int MEMSIZE = 100;

	public Swapper() {
		cpu = new Process();	
	}
	
	public static int[] fcfs() {
		List<HashMap<String, Number>> processLists = cpu.processes;
		printList(processLists);
		HashMap<String, Number> currentProcess = null;
		int[] result = new int[102];
		
		for (int timeCount = 0; timeCount <= 100; timeCount++) {
			for (int i = 0; i < processLists.size(); i++) {
				if (processLists.get(i).get("arrivalTime").floatValue() <= timeCount && processLists.get(i).get("completed").floatValue() == 0) {
					if (currentProcess == null) {
						currentProcess = processLists.get(i);
					} 
				}
			}
			int currentCompleted = currentProcess.get("completed").intValue();
			currentCompleted++;
			currentProcess.put("completed", currentCompleted);
			for (int i = 0; i < processLists.size(); i++) {
				if (processLists.get(i).get("pid").equals(currentProcess.get("pid"))) {
					processLists.set(i, currentProcess);
				}
			}
			
			System.out.print(timeCount + "\t");
			System.out.print("pid: " + currentProcess.get("pid") + "\t");
			result[timeCount] = currentProcess.get("pid").intValue();
			System.out.println();
			
			
			if (currentProcess.get("runTime").equals(currentProcess.get("completed"))) {
				currentProcess = null;
			}
			
		}
		result[101] = processLists.size();
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

	
	

	public void firstFit() {
		// keep list of free blocks of memory
		// when receiving request for memory, scan list for first block that is large enough to satisfy request
		// if the block is significantly larger than requested, split block, add remainder to list as a free block

	}	

	public void nextFit() {

	}

	public void bestFit() {

	}


	// Run each algorithm 5 times simulating 1 minute each time to get an avg of the # of processes 
	// successfully swapped into memory
	
	
	
}
