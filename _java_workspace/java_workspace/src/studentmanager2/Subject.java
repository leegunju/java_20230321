package studentmanager2;

public class Subject {

	private int subcode;
	private String subname;
	private double subcredit;

	public Subject() {
	}

	public Subject(String subname) {
		this.subname = subname;
	}

	public Subject(int subcode, String subname, double subcredit) {
		this.subcode = subcode;
		this.subname = subname;
		this.subcredit = subcredit;
	}

	public int getSubcode() {
		return subcode;
	}

	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public double getSubcredit() {
		return subcredit;
	}

	public void setSubcredit(double subcredit) {
		this.subcredit = subcredit;
	}

	@Override
	public String toString() {
		return "Subject [subcode=" + subcode + ", subname=" + subname + ", subcredit=" + subcredit + "]";
	}
}