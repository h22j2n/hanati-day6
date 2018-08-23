
public class MountainBicycle extends Bicycle{
	//추가 속성
	String frame;
	boolean suspension;
	
	public MountainBicycle() {
		this(null,false);
	}
	
	public MountainBicycle(String frame, boolean suspension) {
		this.frame = frame;
		this.suspension = suspension;
		
	}
	
	public MountainBicycle(int id, String brand, String frame, boolean suspension) {
//		this.id = id;
//		this.brand = brand;
		super(id,brand);
		this.frame = frame;
		this.suspension = suspension;
	}
	public void running() {
		System.out.println("산도 달립니다.");
	}
	

}
