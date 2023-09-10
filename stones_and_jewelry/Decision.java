import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Decision {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String jewelry = scanner.nextLine();
		String stones = scanner.nextLine();
		
		int count = 0;

		for (byte stone: stones.getBytes()) {
			if (jewelry.indexOf(stone) != - 1) {
				count++;
			}
		}	
		System.out.println(count);
	}
}
