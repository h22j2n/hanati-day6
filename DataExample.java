import java.util.Date;

public class DataExample {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today.getYear());
		System.out.println(today.toString());
		System.out.println(today.toLocaleString());
		System.out.println(today.getTime());
		
	}
}
