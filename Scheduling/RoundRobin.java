
public class RoundRobin extends Scheduling {

	public  void addBufferQueue(Process p, int low, int high) { 
		arrivalCopy.forEach((ps) -> {
			if(ps.getAT() > low && ps.getAT() <= high) { 
				bufferQueue.add(ps);
			}
		});	
		if(p != null) {
			bufferQueue.add(p);
		}
	}

	public Process findProcess(String pNo) {
		for(Process p : arrivalQueue) {
			if(p.getPno().equals(pNo)) {
				return p;
			}
		}
		
		return null;
	}

	public  void roundRobinAlgorithm() {
		init();
		int elapsedTime = 0, tt = 0, wt = 0, rt = 0;
		int quantum = 2;

		arrivalQueue.forEach((ps)-> {
			arrivalCopy.add(new Process(ps.getPno(), ps.getAT(), ps.getBT(), ps.getCT(), 0, 0, 0));
		});

		Process p = arrivalCopy.getFirst();

		if(elapsedTime < p.getAT()) {
			elapsedTime = p.getAT();
			readyQueue.add(new Process("--", 0, 0, elapsedTime, 0, 0, 0));
		}	

		if (p.getBT() > quantum) {
			int bt = p.getBT() - quantum;
			p.setBT(bt);
			elapsedTime += quantum;
			readyQueue.add(new Process(p.getPno(), p.getAT(), p.getBT(), elapsedTime, 0, 0, 0));
			addBufferQueue(p, 0, elapsedTime);

		} else {
			rt = elapsedTime - p.getAT();
			elapsedTime += p.getBT();			
			p.setBT(0);
			Process p1 = findProcess(p.getPno());
			tt = elapsedTime - p.getAT();
			wt = tt - p.getBT();
			p1.setCT(elapsedTime);						
			p1.setTT(tt);
			p1.setWT(wt);
			p1.setRT(rt);
			readyQueue.add(new Process(p.getPno(), p.getAT(), p.getBT(), elapsedTime, 0, 0, 0));			
		}

		while(!bufferQueue.isEmpty()) {
			Process p1 = bufferQueue.removeFirst();
			int low;
			if (p1.getBT() > quantum) {
				int bt = p1.getBT() - quantum;
				p1.setBT(bt);
				low = elapsedTime;
				elapsedTime += quantum;
				readyQueue.add(new Process(p1.getPno(), p1.getAT(), p1.getBT(), elapsedTime, 0, 0, 0));
				addBufferQueue(p1, low, elapsedTime);

			} else {
				Process p2 = findProcess(p1.getPno());
				low = elapsedTime;
				elapsedTime += p1.getBT();			
				p1.setBT(0);
				readyQueue.add(new Process(p1.getPno(), p1.getAT(), p1.getBT(), elapsedTime, 0, 0, 0));			
				addBufferQueue(null, low, elapsedTime);				
				tt = elapsedTime - p1.getAT();
				wt = tt - p2.getBT();
				p2.setCT(elapsedTime);						
				p2.setTT(tt);
				p2.setWT(wt);
				p2.setRT(rt);
			}
		}
	}
	
}