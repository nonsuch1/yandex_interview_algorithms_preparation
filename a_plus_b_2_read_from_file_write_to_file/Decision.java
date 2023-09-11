import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.nio.file.*;

public class Decision {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		
		Path path = Paths.get("output.txt");
		byte[] result = (a + b + "").getBytes();

		Files.write(path, result);
	}
}
