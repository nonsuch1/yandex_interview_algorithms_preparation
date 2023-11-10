import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int xa = input[0];
		int ya = input[1];
		int xb = input[2];
		int yb = input[3];

		Solution solution = new Solution();
		double res = solution.getDistance(xa, ya, xb, yb);
		System.out.println(res);
	}
}

class Solution {
	public double getDistance(int xa, int ya, int xb, int yb) {
		double ra = getRadius(xa, ya); 
		double rb = getRadius(xb, yb);
		
		double s1 = ra + rb;
		
		double fia = Math.atan2(ya, xa);
		double fib = Math.atan2(yb, xb);

		double segmentLength = Double.min(ra, rb) * Double.min(Math.abs(fia - fib), Math.abs(2 * Math.PI - fia + fib));
		
		double s2 = Math.abs(ra - rb) + segmentLength;
		return Double.min(s1, s2);
		
	}	

	private double getRadius(int x, int y) {
		return Math.sqrt((double) x * x + (double) y * y);
	}
}
