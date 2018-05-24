package tp3;

public class Problem {
	
	int lanternLevel;
	int w, h;
	char[][] map;
	
	public Problem(char w, char h) {
		map = new char[h][w];
		this.w = w;
		this.h = h;
		lanternLevel = 0;
	}
	
	public void addLine(char[] line, int rowNum) {
		for(int i = 0; i < line.length; i++) {
			char c = line[i];
			map[rowNum][i] = c;
			if(c == '*') {
				
			}
		}
	}
	
	public int shortestPath() {
		
		
		
		return -1;
	}
	
	boolean canMove(int x1, int y1, int x2, int y2) {
		if((x2 >= 0 && x2 < w) || (y2 >= 0 && y2 < h)) {
			return (map[x2][y2] == '*' || map[x1][y1] == '*');
		} else
			return lanternLevel > 0;
	}
	
	void bfsExplore() {
		
	}
	
}
