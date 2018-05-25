package tp3;

import java.util.LinkedList;
import java.util.Queue;

public class Problem {

	int w, h;
	char[][] map;
	int[][] lanternLevel;

	public Problem(int w, int h) {
		map = new char[w][h];
		lanternLevel = new int[w][h];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				lanternLevel[j][i] = -1; // saves the best lantern at a given pos
			}
		}

		this.w = w;
		this.h = h;

	}

	public void addLine(char[] line, int rowNum) {
		for (int i = 0; i < line.length; i++) {
			char c = line[i];
			map[i][rowNum] = c;
		}
	}

	boolean canMove(int[] node, int x2, int y2) {
		if (x2 >= 0 && x2 < w && y2 >= 0 && y2 < h) { // if inside map
			if (lanternLevel[x2][y2] < node[2]-1) {// if not been there with a better lanternLevel
				return true;
			} else if (map[x2][y2] == '*') { // if going to lamp
				return true;
			} else if (map[node[0]][node[1]] == '*') { // if on lamp
				return true;
			} else if (node[2] > 0) { // if lanternlevel wouldn't be negative
				return true;
			}
		}
		return false;
	}

	public int solve() {
		Queue<int[]> waiting = new LinkedList<int[]>();
		int[] node = new int[] { 0, 0, 0, 0 };
		node[2] = map[0][0] == '*' ? 0 : Character.getNumericValue(map[0][0]);
		waiting.add(node);

		do {
			// [0] x, [1] y, [2] lanternLevel, [3] dist.
			node = waiting.poll();
			// process
			if (node[0] == w - 1 && node[1] == h - 1) {
				// for testing purposes
				// for (int i = 0; i < h; i++) {
				// for (int j = 0; j < w; j++) {
				// System.out.print(testGrid[j][i] + " ");
				// }
				// System.out.println();
				// }
				// System.out.println(node[0] + " " + node[1]);
				return node[3];
			}
			if (canMove(node, node[0] + 1, node[1])) {
				waiting.add(moveTo(node, node[0] + 1, node[1]));
			}
			if (canMove(node, node[0] - 1, node[1])) {
				waiting.add(moveTo(node, node[0] - 1, node[1]));
			}
			if (canMove(node, node[0], node[1] + 1)) {
				waiting.add(moveTo(node, node[0], node[1] + 1));
			}
			if (canMove(node, node[0], node[1] - 1)) {
				waiting.add(moveTo(node, node[0], node[1] - 1));
			}

		} while (!waiting.isEmpty());
		return -1;
	}

	int[] moveTo(int[] node, int x2, int y2) {
		int lantern = node[2];

		// se nao for lampada, reduz lantern
		if (map[x2][y2] != '*' && map[node[0]][node[1]] != '*') {
				lantern--;
		}

		// se for lantern, substitui se tiver mais carga
		int mapLight = Character.getNumericValue(map[x2][y2]);
		if (mapLight > lantern) {
			lantern = mapLight;
		}

		lanternLevel[x2][y2] = lantern;
		
		return new int[] { x2, y2, lantern, node[3] + 1 };
	}
}
