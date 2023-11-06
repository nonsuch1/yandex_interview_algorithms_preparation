import java.io.IOException;
import java.util.Scanner;
import java.io.File;

class Main {
	public static void main(String[] args) throws IOException {
		String file = "input.txt";		
		Scanner scanner = new Scanner(new File(file));	
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		System.out.println(a + b);
	}
}
