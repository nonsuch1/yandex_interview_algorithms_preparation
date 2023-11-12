import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] input0 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = input0[0];
		int start = input0[1];
		int end = input0[2];
	
		int[][] matrix = new int[n + 1][n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			matrix[i] = IntStream.concat(IntStream.of(0), Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)).toArray();
		}	
		Solution solution = new Solution();
		solution.solve(start, end, matrix);
	}
}

class Solution {
	private boolean[] visited;
	private int[] dist;
	private int[] prev;
		
	public void solve(int start, int end, int[][] matrix) {
		visited = new boolean[matrix.length];
		dist = new int[matrix.length];
		prev = new int[matrix.length];
		
		for (int i = 1; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		dist[start] = 0;
		prev[start] = 0;
		while (notVisitedVertexExist()) {
			int curv = getIndexOfMinDistNotVisitedVertex();
			visited[curv] = true;
			for (int j = 1; j < matrix[curv].length; j++) {
				if (matrix[curv][j] >= 0) {
					if (dist[j] > dist[curv] + matrix[curv][j]) {
						dist[j] = dist[curv] + matrix[curv][j];
						prev[j] = curv;
					}
				}
			}	
		}
		printPath(end, start);
	}

	private void printPath(int previous, int start) {
		if (previous == -1) {
			System.out.println(-1);
			System.exit(0);
		}
		if (previous == 0) return;
		printPath(prev[previous], start);
		if (previous != start) {
			System.out.print(" ");
		}
		System.out.print(previous);
	}
	
	private boolean notVisitedVertexExist() {
		int i = 1;
		while (i < visited.length) {
			if (visited[i] == false && dist[i] != Integer.MAX_VALUE) 
				return true;
			i++;
		}
		return false;
	}

	private int getIndexOfMinDistNotVisitedVertex() {
		int i = 1;
		while (i < visited.length && visited[i]) {
			i++;
		}
		int minDistIndex = i;
                while (i < visited.length) {
			if (!visited[i]) {
				if (minDistIndex == - 1) {
					minDistIndex = i;
				} else if (dist[i] < dist[minDistIndex]){
					minDistIndex = i;
				}
			}
			i++;
                }
		
		return minDistIndex;
	}
}
