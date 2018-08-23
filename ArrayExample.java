import java.util.Arrays;

/**
 * 1차원 배열 선언, 생성, 초기화
 * 
 * @author 조희진
 *
 */
public class ArrayExample {

	public static void main(String[] args) {
		int[] array;
		array = new int[10];
		array[0] = 10;
		array[9] = 100;
		/*
		 * for (int i = 0; i < array.length; i++) { array[i] = array.length - i; }
		 */
//		System.out.println(array[0]);
//		System.out.println(array[9]);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}

//		int[] array2 = new int[] {1,2,3,4,5};
		int[] array2 = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}

		for (int value : array2) {
			System.out.println(value);
		}

		// 미션 1(배열 복사)
		int[] array3 = { 3, 1, 9, 2, 5 };
		int[] array4 = new int[7];
		for (int i = 0; i < array3.length; i++) {
			array4[i] = array3[i];
		}
		for (int i : array4) {
			System.out.println(i);
		}

		// 미션 2(정렬)
		int[] lottos = { 34, 12, 3, 9, 25, 2 };

		int num;
		for (int i = 0; i < lottos.length - 1; i++) {
			for (int k = i + 1; k < lottos.length; k++)
				if (lottos[i] > lottos[k]) {
					num = lottos[i];
					lottos[i] = lottos[k];
					lottos[k] = num;
				}
		}

		for (int i : lottos) {
			System.out.print(i + "\t");
		}
		
		
		//로또 번호 생성
		System.out.println();
		
		
		int[] lottos2 = new int[6];

		int tmp;
		

		for (int i = 0; i < lottos2.length; i++) {
			lottos2[i] = (int) (Math.random() * 6) + 1;
			for (int j = 0; j < i; j++) {
				if(lottos2[i]==lottos2[j]) {
					i--;
				}
				
			}
			
			}

		
		for (int i : lottos2) {
			System.out.print(i + "\t");
		}

	}

}
