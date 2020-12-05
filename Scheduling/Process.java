
public class Process {
	private String pNo;
	private int at;
	private int bt;
	private int ct;
	private int tt;
	private int wt;
	private int rt;
	public Process() {}

	public Process(String pNo, int at, int bt, int ct, int tt, int wt, int rt) {
		this.pNo = pNo;
		this.at  = at;
		this.bt  = bt;
		this.ct  = ct;
		this.tt  = tt;
		this.wt  = wt;
		this.rt  = rt;
	}

	public String toString() {
		return "{"  + 
				"pNo : " + pNo + ", " + 
				"at  : " + at  + ", " + 
				"bt  : " + bt  + ", " +
				"ct  : " + ct  + ", " +
				"tt  : " + tt  + ", " + 
				"wt  : " + wt  + ", " + 
				"rt  : " + rt  + " }";
	}

	public int getAT() {
		return at;
	}

	public int getBT() {
		return bt;
	}

	public String getPno() {
		return pNo;
	}

	public int getCT() {
		return ct;
	}

	public void setBT(int bt) {
		this.bt = bt;
	}

	public void setCT(int ct) {
		this.ct = ct;
	}

	public void setWT(int wt) {
		this.wt = wt;
	}

	public void setRT(int rt) {
		this.rt = rt;
	}

	public void setTT(int tt) {
		this.tt = tt;
	}

}