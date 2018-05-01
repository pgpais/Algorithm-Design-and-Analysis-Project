import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] info = input.readLine().split(" ");
		int susp = Integer.parseInt(info[0]);
		int preConj = Integer.parseInt(info[1]);
		int concConj = Integer.parseInt(info[2]);
		
		Problem prob = new Problem(susp, preConj, concConj);
		
		int susp1, susp2 = 0;
		
		for(int i = 0; i < preConj; i++) {
			info = input.readLine().split(" ");
			susp1 = Integer.parseInt(info[0]);
			susp2 = Integer.parseInt(info[1]);
			prob.addPreceding(susp1, susp2);
		}
		
		for(int i = 0; i < concConj; i++) {
			info = input.readLine().split(" ");
			susp1 = Integer.parseInt(info[0]);
			susp2 = Integer.parseInt(info[1]);
			prob.addConcurrent(susp1, susp2);
		}
		
		

	}

}
