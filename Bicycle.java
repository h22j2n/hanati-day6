
public class Bicycle {
	int id;
	String brand;
	
	public Bicycle() {
		this(0,null);
	}
	
	public Bicycle(int id, String brand) {
		this.id = id;
		this.brand = brand;
		
		
		
	}
	
	public void running() {
		System.out.println("자전거가 달립니다.");
	}

}
