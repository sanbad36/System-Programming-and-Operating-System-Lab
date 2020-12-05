/*
 * Write a Java program (using OOP features) to implement following scheduling algorithms:
 * FCFS , SJF (Preemptive), Priority (Non-Preemptive) and Round Robin (Preemptive)
 */

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static FCFS fcfs = new FCFS();
	private static SJF sjf = new SJF();
	private static RoundRobin roundRobin = new RoundRobin();

	public static int getChoice() {
		int choice;
		System.out.println("\n\n\n[1] FCFS Algorithm\n" +
						   "[2] SJF Non-Preemptive Algorithm\n" +
						   "[3] Round Robin Algorithm\n" +
						   "[4] Exit\n\n\n");		

		System.out.println("Enter your choice : ");
		choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}

	public static void main(String[] args) {
		boolean quit = false;
		while(!quit) {
			switch(getChoice()) {
				case 1:
					fcfs.fcfsAlgorithm();
					fcfs.displayGanttChart(fcfs.getReadyQueue());
					break;

				case 2:
					sjf.sjfNonPreemptive();
					sjf.displayGanttChart(sjf.getReadyQueue());
					break;

				case 3:
					roundRobin.roundRobinAlgorithm();
					roundRobin.displayGanttChart(roundRobin.getArrivalQueue());
					break;

				case 4:
					quit = true;
					break;

				default:
					System.out.println("Wrong choice!");
					break;
			}
		}
	}
}


/*

FCFS Scheduling : 

	Process AT BT  CT TT WT RT 
	p1 		0	2  2  2  0  0
	p2		1	2  4  3  1  1
	p3		5	3  8  3  0  0
	p4		6	4  12 6  2  2
 

| p1 | p2 |   | p3 | p4 |
	
0	 2    4   5    8    12

SJF Scheduling : 

Round Robin Scheduling : 


Process AT BT CT TT WT RT 

P1  	0  3 / 1 / 0 
P2 		1  5 / 3 / 1 / 0
P3 		3  2 / 0
P4 		9  5 / 3 / 1 
P5 		12 5  / 3 


Queue  {P1} {P2} {P1} {p3} {p2}  {p4} {p2} {p4}  {p5}  {p4}  p5 

| p1 | p2 | p1 | p3 | p2 | p4  |  p2 | p4 | p5 |  p4 | p5 | p5 | 

0    2    4    5    7    9     11   12   14   16    17   19   20 

*/


 

