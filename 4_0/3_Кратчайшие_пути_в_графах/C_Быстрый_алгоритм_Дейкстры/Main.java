import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		input[0];
	}
}
