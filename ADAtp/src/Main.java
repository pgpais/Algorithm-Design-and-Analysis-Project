import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String sequence1 = input.readLine();
		String sequence2 = input.readLine();
		input.close();

		Problem prob = new Problem(sequence1, sequence2);
		String result = prob.solveProblem();

		System.out.println(result.length());
		if (result.length() > 0)
			System.out.println(result);
	}

}
