import java.util.ArrayList;
import java.util.List;

public class Problem {
	
	int nSuspects;
	List<Pair> Preceding, Concurrent;
	
	public Problem(int nSuspects, int nPreceding, int nConcurrent) {
		Preceding = new ArrayList<Pair>(nPreceding);
		Concurrent = new ArrayList<Pair>(nConcurrent);
	}
	
	public void addPreceding(int x, int y) {
		Preceding.add(new Pair(x,y));
	}
	
	public void addConcurrent(int x, int y) {
		Concurrent.add(new Pair(x,y));
	}
	
	public boolean solve() {
		//TODO: Criar grafo "Preceding". Comparar Lista "Concurrent" com esse grafo
		// e procurar inconsistencias
		
		return false;
	}
	
	
}
