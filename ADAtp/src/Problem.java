
public class Problem {

	String sequence1, sequence2;

	public Problem(String sequence1, String sequence2) {
		this.sequence1 = sequence1;
		this.sequence2 = sequence2;
	}

	public String solveProblem() {

		int biggestSequence = 0;
		String winnerSequence = "";

		if (sequence1.length() == 0 || sequence2.length() == 0) {
			return "";
		} else {
			int[][] commonSeqLength = new int[sequence1.length()][sequence2.length()];
			String[][] commonSeq = new String[sequence1.length()][sequence2.length()];
			for (int i = 0; i < sequence1.length(); i++) {
				for (int k = 0; k < sequence2.length(); k++) {
					commonSeq[i][k] = "";
				} 
			}

			// filling in the first column and row
			for (int i = 0; i < sequence1.length(); i++) {
				if (sequence1.charAt(i) == sequence2.charAt(0)) {
					commonSeqLength[i][0]++;
					commonSeq[i][0] = sequence1.substring(i, i + 1);
				} else if (i > 0 && commonSeqLength[i][0] == 0) {
					commonSeqLength[i][0] = commonSeqLength[i - 1][0];
					commonSeq[i][0] = commonSeq[i - 1][0];
				}
				if (biggestSequence < commonSeqLength[i][0]) {
					biggestSequence = commonSeqLength[i][0];
					winnerSequence = commonSeq[i][0];
				} else if (biggestSequence == commonSeqLength[i][0]) {
					if (commonSeq[i][0].compareTo(winnerSequence) < 0) {
						winnerSequence = commonSeq[i][0];
					}
				}
			}
			// k = 1 because (0,0) is already dealt with in the previous cycle
			for (int k = 1; k < sequence2.length(); k++) {
				if (sequence2.charAt(k) == sequence1.charAt(0)) {
					commonSeqLength[0][k]++;
					commonSeq[0][k] = sequence2.substring(k, k + 1);
				} else if (k > 0 && commonSeqLength[0][k] == 0) {
					commonSeqLength[0][k] = commonSeqLength[0][k - 1];
					commonSeq[0][k] = commonSeq[0][k - 1];
				}
				if (biggestSequence < commonSeqLength[0][k]) {
					biggestSequence = commonSeqLength[0][k];
					winnerSequence = commonSeq[0][k];
				} else if (biggestSequence == commonSeqLength[0][k]) {
					if (commonSeq[0][k].compareTo(winnerSequence) < 0) {
						winnerSequence = commonSeq[0][k];
					}
				}
			}

			// filling in the rest of the matrix
			for (int i = 1; i < sequence1.length(); i++) {
				for (int k = 1; k < sequence2.length(); k++) {
					if (sequence1.charAt(i) == sequence2.charAt(k)) {
						commonSeqLength[i][k] = commonSeqLength[i - 1][k - 1] + 1;
						commonSeq[i][k] = commonSeq[i - 1][k - 1].concat(sequence1.substring(i, i + 1));
					} else {
						if (commonSeqLength[i - 1][k] == commonSeqLength[i][k - 1]) {

							if (commonSeq[i - 1][k].compareTo(commonSeq[i][k - 1]) < 0) {
								commonSeqLength[i][k] = commonSeqLength[i - 1][k];
								commonSeq[i][k] = commonSeq[i - 1][k];
							} else {
								commonSeqLength[i][k] = commonSeqLength[i][k - 1];
								commonSeq[i][k] = commonSeq[i][k - 1];
							}

						} else if (commonSeqLength[i - 1][k] > commonSeqLength[i][k - 1]) {
							commonSeqLength[i][k] = commonSeqLength[i - 1][k];
							commonSeq[i][k] = commonSeq[i - 1][k];
						} else {
							commonSeqLength[i][k] = commonSeqLength[i][k - 1];
							commonSeq[i][k] = commonSeq[i][k - 1];
						}
					}
					if (biggestSequence < commonSeqLength[i][k]) {
						biggestSequence = commonSeqLength[i][k];
						winnerSequence = commonSeq[i][k];
					} else if (biggestSequence == commonSeqLength[i][k]) {
						if (commonSeq[i][k].compareTo(winnerSequence) < 0) {
							winnerSequence = commonSeq[i][k];
						}
					}
				}
			}
		}
		return winnerSequence;
	}
}
