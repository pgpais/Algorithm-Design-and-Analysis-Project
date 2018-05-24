package tp3;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem {

	int lanternLevel;
	int w, h;
	char[][] map;
	int[][] lantern;
	int[][] steps;

	public Problem(char w, char h) {
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

	boolean canMove(int x1, int y1, int x2, int y2) {
		if ((x2 >= 0 && x2 < w) || (y2 >= 0 && y2 < h)) {
			if ((map[x2][y2] == '*' || map[x1][y1] == '*')) {
				return true;
			} else if (lanternLevel > 0)
				return true;
		}
		return false;
	}

	void bfsExplore() {
		Queue<int[]> waiting = new PriorityQueue<int[]>();
		waiting.add(createNode(0, 0));

		do {
			//[0] x [1] y [2] lanterLevel [3] dist
			int[] node = waiting.poll();
			// process
			if(node[0] == w-- && node[1] == h--) {
				//done!
			}
			if (canMove(node[0], node[1], node[0]++, node[1])) {
				waiting.add(moveTo(node[0], node[1], node[0]++, node[1]));
			}
			if (canMove(node[0], node[1], node[0]--, node[1])) {
				waiting.add(moveTo(node[0], node[1], node[0]--, node[1]));
			}
			if (canMove(node[0], node[1], node[0], node[1]++)) {
				waiting.add(moveTo(node[0], node[1], node[0], node[1]++));
			}
			if (canMove(node[0], node[1], node[0], node[1]--)) {
				waiting.add(moveTo(node[0], node[1], node[0], node[1]--));
			}

		} while (!waiting.isEmpty());

	}

	int[] moveTo(int i, int j, int k, int l) {
		
		
		
		return new int[] {-1,-1};
	}

	int[] createNode(int x, int y) {
		return new int[] { x, y };
	}

}
