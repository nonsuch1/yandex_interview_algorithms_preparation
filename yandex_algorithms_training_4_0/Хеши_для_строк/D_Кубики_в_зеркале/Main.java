import java.util.Scanner;
import java.util.File;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] input = Arrays.stream(scanner.nextLine().spit(" ")).mapToInt(Integer::parseInt).toArray();
		int ballsN= input[0];
		int colorsN = input[1];
		int[] 
	}
}
