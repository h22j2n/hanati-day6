import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
//		String date = "2018-08-23";
		String date = "1111 2222 3333 4444";
		//년 월 일 분리시키고 싶음
		
		StringTokenizer str = new StringTokenizer(date, " ");
		System.out.println(str.countTokens());
		//3출력
		
		//hasMoreTokens() : True / False 로 반환
		while(str.hasMoreTokens()) {
			String token = str.nextToken();
			System.out.println(token);
			//2018
			//08
			//23 출력
		}

		

	}
}
