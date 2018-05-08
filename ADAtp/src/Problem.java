import java.util.ArrayList;
import java.util.List;

public class Problem {
	
	int nSuspects;
	List<Pair> preceding, concurrent;
	
	public Problem(int nSuspects, int nPreceding, int nConcurrent) {
		preceding = new ArrayList<Pair>(nPreceding);
		concurrent = new ArrayList<Pair>(nConcurrent);
	}
	
	public void addPreceding(int x, int y) {
		preceding.add(new Pair(x,y));
	}
	
	public void addConcurrent(int x, int y) {
		concurrent.add(new Pair(x,y));
	}
	
	public boolean solve() {
		//TODO: Criar grafo "Preceding". Comparar Lista "Concurrent" com esse grafo
		// e procurar inconsistencias stuff
		
		Graph graph = new Graph(nSuspects, preceding);
		
		
		
		return false;
	}
	
	private 
	
	
}
