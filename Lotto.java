import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		System.out.println("돈을 입력하세요.(1000원~5000원)");
		Scanner sc = new Scanner(System.in);
		int num = (int) (sc.nextInt() / 1000);
		int[][] lottos = new int[num][6];
		Random random = new Random();

		for (int k = 0; k < num; k++) {
			for (int i = 0; i < lottos[k].length; i++) {
				lottos[k][i] = random.nextInt(45) + 1;
				for (int j = 0; j < i; j++) {
					if (lottos[k][i] == lottos[k][j]) {
						i--;
					}
				}
			}
			
			Arrays.sort(lottos[k]);

			for (int i = 0; i < k; i++) {
				if (Arrays.equals(lottos[k], lottos[i])) {
					k--;
				}
			}

		}
		for (int t = 0; t < num; t++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(lottos[t][j] + "\t");
			}
			System.out.println();

		}

		

	}
}
