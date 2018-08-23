
public class SystemExample {
	public static void main(String[] args) {
		System.out.println("프로그램 Start");

		
		//System.exit(0);
		System.gc();
		//gc 호출 의미없음 바로 동작하지는 않음.
		
		long start = System.currentTimeMillis();
		
		/*
		for (int i = 0; i < 10000000; i++) {
			System.out.println(i);
		}
		*/
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println(System.getenv("path"));
		System.out.println(System.getenv("java_home"));
		
		
		System.out.println("프로그램 Finish");
		
	}
}
