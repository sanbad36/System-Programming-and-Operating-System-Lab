import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;


public abstract class Scheduling {
	protected static Deque<Process> arrivalQueue = new ArrayDeque<>();
	protected static Deque<Process> readyQueue = new ArrayDeque<>();
	protected static Deque<Process> bufferQueue = new ArrayDeque<>();
	protected static Deque<Process> arrivalCopy = new ArrayDeque<>();
	protected static Scanner scanner = new Scanner(System.in);
	
	public static void init() {
		System.out.println("enter the number of processes : ");
		int nums = scanner.nextInt();
		scanner.nextLine();
		for(int i = 1; i <= nums; i++) {
			System.out.println("enter arrival time and burst time for process P" + i);
			int at = scanner.nextInt();
			int bt = scanner.nextInt();
			scanner.nextLine();
			arrivalQueue.add(new Process("P" + i, at, bt, 0, 0, 0, 0));
		}		
	}

	public static void displayGanttChart(Deque<Process> readyQueue) {
		readyQueue.stream()
				  .filter((el)-> !(el.getPno().equals("--")))
				  .forEach(System.out::println);			

		System.out.println("\n\nGantt Chart Representation : ");
		for(int i = 0; i < readyQueue.size(); i++) {
			System.out.print(" ____");
		}

		System.out.println();
		readyQueue.forEach((ps) -> {
			System.out.print("| " + ps.getPno() + " ");
		});

			System.out.println("|");
			System.out.print("0    ");

		readyQueue.forEach((ps) -> {
			if(ps.getCT() > 9) {
				System.out.print(ps.getCT() + "   ");
			} else {
				System.out.print(ps.getCT() + "    ");
			}
		});

		System.out.println();
	}

	public static Deque<Process> getReadyQueue() {
		return readyQueue;
	}

	public static Deque<Process> getArrivalQueue() {
		return arrivalQueue;
	}


}