import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MinSquare {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int k = scanner.nextInt();
		int[] x = new int[k];
		int[] y = new int[k];
		for (int i = 0; i < k; i++) {
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
		}
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		for (int i = 0; i < k; i++) {
			minX = Integer.min(minX, x[i]);
			minY = Integer.min(minY, y[i]);
			maxX = Integer.max(maxX, x[i]);
			maxY = Integer.max(maxY, y[i]);
		}
		System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
	}
}
