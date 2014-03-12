package hw4;

import java.util.*;

public class Process {
	
	public List<HashMap<String, Number>> processes;

	public Process() {
		processes = processGenerator();
	}
	/**
	 * Generate processes to fill 100 time slices, each process contains properties as process id, arrival time, run time, priority, and completed
	 * @return a list contains all processes
	 */
	public List<HashMap<String, Number>> processGenerator() {
		List<HashMap<String, Number>> processList = new ArrayList<HashMap<String, Number>>();
		int pid = 1;
		while (isFilled(processList)) {
			HashMap<String, Number> p = new HashMap<String, Number>();
			int burstTime = (int) (Math.random() * 5) + 1;
			int size = makeSize();
			if (pid == 1) {
				p.put("arrivalTime", 0);
				p.put("burstTime", burstTime);	// Burst time is generated to be 1, 2, 3, 4, or 5 seconds randomly and uniformly
				p.put("size", size);			// Size is generated to be 4, 8, 16, or 32 MB randomly and uniformly
				p.put("pid", pid++);
				p.put("completed", 0);
				

			} else {
				float previousArrivalTime = processList.get(pid-2).get("arrivalTime").floatValue();
				int previousburstTime = processList.get(pid-2).get("burstTime").intValue();
				float arrivalTime = (float) (previousArrivalTime + (Math.random() * (float) previousburstTime));
				p.put("arrivalTime", arrivalTime);
				p.put("burstTime", burstTime);
				p.put("size", size);
				p.put("pid", pid++);
				p.put("completed", 0);

			}
			processList.add(p);
		}
		int burstTimeSum = 0;
		for (int i = 0; i < processList.size(); i++) {
			burstTimeSum += processList.get(i).get("burstTime").intValue();
		}
		int burstTime = 100 - burstTimeSum + 1;
		int priority = 1 + (int) (Math.random() * 4);
		HashMap<String, Number> p = new HashMap<String, Number>();
		float previousArrivalTime = processList.get(pid-2).get("arrivalTime").floatValue();
		int previousburstTime = processList.get(pid-2).get("burstTime").intValue();
		float arrivalTime = (float) (previousArrivalTime + (Math.random() * (float) previousburstTime));
		p.put("arrivalTime", arrivalTime);
		p.put("burstTime", burstTime);
		p.put("pid", pid);
		p.put("completed", 0);
		p.put("priority", priority);
		processList.add(p);
		return processList;
	}
	
	private static int makeSize() {
		int minimum = 0;
		int maximum = 4;
		int mem_sizes[] = { 4, 8, 16, 32 };
		int randomNum = minimum + (int)(Math.random()*maximum); 
		
		return mem_sizes[randomNum];
	}
	
	private static boolean isFilled(List<HashMap<String, Number>> pList) {
		int burstTimeSum = 0;
		for (int i = 0; i < pList.size(); i++) {
			burstTimeSum += pList.get(i).get("burstTime").intValue();
		}
		if (burstTimeSum >= 90) return false;
		return true;
	}
	

	
}