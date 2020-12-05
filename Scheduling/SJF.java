
import java.util.List;
import java.util.ArrayList;

public class SJF extends Scheduling {

    public Process getMinimum(int elapsedTime) {
        List<Process> list = new ArrayList<>();
        for(Process p : arrivalQueue) {
            if(p.getAT() <= elapsedTime) {
                list.add(p);
            }
        }
        double minVal = Double.MAX_VALUE;
        Process process = new Process();
        for(Process p : list) {
            if(p.getBT() < minVal) {
                minVal = p.getBT();
                process = p;
            }
        }
        return process;
    }

	public void sjfNonPreemptive() {
		init();
		int elapsedTime = 0, tt = 0, wt = 0, rt = 0;
		int avgtt = 0, avgwt = 0;
		int nums = arrivalQueue.size();

		for(int i = 0; i < nums; i++) {
			Process p = arrivalQueue.getFirst();
			if(elapsedTime < p.getAT()) {
				elapsedTime = p.getAT();
				readyQueue.add(new Process("--", 0, 0, elapsedTime, 0, 0, 0));
			}

            Process minimum = getMinimum(elapsedTime);
			rt = elapsedTime - minimum.getAT();
            elapsedTime += minimum.getBT();
            tt = elapsedTime - minimum.getAT();
            avgtt += tt;
            wt = tt - minimum.getBT();
            avgwt += wt;
            readyQueue.add(new Process(minimum.getPno(), minimum.getAT(), minimum.getBT(), elapsedTime, tt, wt, rt));
            arrivalQueue.remove(minimum);			
		}
	}
	
}