
public class FCFS extends Scheduling{

	public void fcfsAlgorithm() {		
		init();
		int elapsedTime = 0, tt = 0, wt = 0, rt = 0;
		for(Process p : arrivalQueue) { 
			if(elapsedTime < p.getAT()) {
				elapsedTime = p.getAT();
				readyQueue.add(new Process("--", 0, 0, elapsedTime, 0, 0, 0));
			}
			rt = elapsedTime - p.getAT();
			elapsedTime += p.getBT();			
			tt = elapsedTime - p.getAT();
			wt = tt - p.getBT();
			readyQueue.add(new Process(p.getPno(), p.getAT(), p.getBT(), elapsedTime, tt, wt, rt));
		}
	}	
}