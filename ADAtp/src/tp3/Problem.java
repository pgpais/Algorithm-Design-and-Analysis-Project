package tp3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem {

	int lanternLevel;
	int w, h;
	char[][] map;
	int[][] lantern;
	int[][] steps;

	public Problem(int w, int  h) {
		map = new char[h][w];
		lantern = new int[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				lantern[i][j] = -1;
			}
		}

		this.w = w;
		this.h = h;

		lanternLevel = 0;
	}

	public void addLine(char[] line, int rowNum) {
		for (int i = 0; i < line.length; i++) {
			char c = line[i];
			map[rowNum][i] = c;
		}
	}

	public int shortestPath() {

		return -1;
	}

	boolean canMove(int[] node, int x2, int y2) {
		if (x2 >= 0 && x2 < w && y2 >= 0 && y2 < h) {
			if ((map[x2][y2] == '*' || map[node[0]][node[1]] == '*')) {
				return true;
			} else if (node[2] > 0)
				return true;
		}
		return false;
	}

	public int solve() {
		Queue<int[]> waiting = new LinkedList<int[]>();
		waiting.add(new int[] { 0, 0, 0, 0 });

		do {
			// [0] x, [1] y, [2] lanternLevel, [3] dist.
			int[] node = waiting.poll();
			// process
			if (node[0] == w-1 && node[1] == h-1) {
				return node[3];
			}
			if (canMove(node, node[0]+1, node[1])) {
				waiting.add(moveTo(node, node[0]+1, node[1]));
			}
			if (canMove(node, node[0]-1, node[1])) {
				waiting.add(moveTo(node, node[0]-1, node[1]));
			}
			if (canMove(node, node[0], node[1]+1)) {
				waiting.add(moveTo(node, node[0], node[1]+1));
			}
			if (canMove(node, node[0], node[1]-1)) {
				waiting.add(moveTo(node, node[0], node[1]-1));
			}

		} while (!waiting.isEmpty());
		return -1;
	}

	int[] moveTo(int[] node, int x2, int y2) {
		int lantern = node[2];

		// se nao for lampada, reduz lantern
		if (map[x2][y2] != '*') {
			// se for lantern, substitui se tiver mais carga
			int mapLight = Character.getNumericValue(map[x2][y2]);
			if (mapLight > lantern) {
				lantern = mapLight;
			}
			if (map[node[0]][node[1]] != '*') {
				lantern--;
				if (lantern < 0)
					System.err.println("negative lantern");
			}
		}

		return new int[] { x2, y2, lantern, node[3]++ };
	}

	int[] createNode(int x, int y, int lanternLevel, int dist) {
		return new int[] { x, y };
	}

}
