package tp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		
		String size = input.readLine();
		//Send size.charAt(0) and size.charAt(2) to class Problem
		Problem prob = new Problem(size.charAt(0), size.charAt(2));
				
		for(int i = 0; i < size.charAt(2); i++) {
			String line = input.readLine();
			char[] row = new char[size.charAt(0)];
			for(int j = 0; j < size.charAt(0); j++) {
				row[j] = line.charAt(j*2);
			}
			prob.addLine(row, i);
		}
	}

}
