package project7;

public class Poker {
	private String design;
	private String point;
	public Poker() {}
	public Poker(String design,String point) {
		this.design = design;
		this.point = point;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
}
