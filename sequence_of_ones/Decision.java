import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Decision {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int arrLength = scanner.nextInt();
		int[] array = new int[arrLength];
		int i = 0;
		while (i < array.length) {
			array[i] = scanner.nextInt();
			i++;
		}
		
		int onesMaxLength = 0;
		i = 0;
		while (i < array.length) {
			if (array[i] == 1) {
				int currentLength = 0;
				while (i < array.length && array[i] == 1) {
					currentLength++;
					i++;
				}
				if (currentLength > onesMaxLength) {
					onesMaxLength = currentLength;	
				}
			}
			i++;	
		}
		System.out.println(onesMaxLength);	
	}
}
