package tp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		
		String size = input.readLine();
		//Send size.charAt(0) and size.charAt(2) to class Problem
		
		String[] sizes = size.split(" ");
		
		int w,h;
		w = Integer.parseInt(sizes[0]);
		h = Integer.parseInt(sizes[1]);
		
		Problem prob = new Problem(w, h);
		
		for(int i = 0; i < h; i++) {
			String line = input.readLine();
			char[] row = new char[w];
			for(int j = 0; j < row.length; j++) {
				row[j] = line.charAt(j*2);
			}
			prob.addLine(row, i);
		}
		
		System.out.println(prob.solve());
	}

}
