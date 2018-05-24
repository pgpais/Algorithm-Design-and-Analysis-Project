import java.util.LinkedList;
import java.util.Stack;

public class Problem {
	
	int nSuspects;
	int numNodes;
	//2n - IN | 2n+1 - OUT
	LinkedList<Integer>[] conjectures;
	int[] inDegree;
	
	@SuppressWarnings("unchecked")
	public Problem(int nSuspects, int nPreceding, int nConcurrent) {
		this.nSuspects = nSuspects;
		numNodes = 2*nSuspects;
		conjectures = new LinkedList[numNodes];
		inDegree = new int[numNodes];
		for(int i = 0; i < nSuspects; i++) {
			int doubleI = i*2;
			conjectures[doubleI] = new LinkedList<Integer>();
			conjectures[doubleI].add(i*2 + 1);
			conjectures[doubleI + 1] = new LinkedList<Integer>();
			inDegree[doubleI + 1] ++;
		}
	}
	
	public void addPreceding(int x, int y) {
		int doubleX = 2*x;
		int doubleY = 2*y;
		conjectures[doubleX + 1].add(doubleY);
		inDegree[doubleY]++;
	}
	
	public void addConcurrent(int x, int y) {
		int doubleX = 2*x;
		int doubleY = 2*y;
		conjectures[doubleX].add(doubleY +1);
		inDegree[doubleY + 1]++;
		conjectures[doubleY].add(doubleX +1);
		inDegree[doubleX + 1]++;
	}
	
	public boolean solve() {
		int numProcNodes = 0;
		Stack<Integer> ready = new Stack<Integer>();
		
		for(int i = 0; i < numNodes; i++) {
			if(inDegree[i] == 0)
				ready.push(i);
		}
		
		while(!ready.isEmpty()) {
			int node = ready.pop();
			numProcNodes++;
			for(int n : conjectures[node]) {
				inDegree[n]--;
				if(inDegree[n] == 0) {
					ready.push(n);
				}
			}
		}
		
		return numProcNodes == numNodes;
	}	
}
