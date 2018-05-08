import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem {
	
	int nSuspects;
	List<Pair> preceding, concurrent;
	
	public Problem(int nSuspects, int nPreceding, int nConcurrent) {
		preceding = new ArrayList<Pair>(nPreceding);
		concurrent = new ArrayList<Pair>(nConcurrent);
		this.nSuspects = nSuspects;
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
		
		boolean[] processed = new boolean[nSuspects];
		
		/*
		 * Checks every Pair with the graph.
		 */
		for(Pair p : concurrent) {
			if(!dfsExplore(graph, p.getX(), p.getY(), processed)) {
				if(!dfsExplore(graph, p.getY(), p.getX(), processed)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	/*
	 * Depth First Traversal - Tries to find the goal node, returns as soon as it is found.
	 */
	private boolean dfsExplore(Graph graph, int startNode, int goal, boolean[] processed) {
		
		Stack<Integer> foundUnprocessed = new Stack<Integer>();
		foundUnprocessed.push(startNode);
		
		do {
			int node = foundUnprocessed.pop();
			if(!processed[node]) {
				//Process
				if(node == goal) {
					return false;
				}
				processed[node] = true;
				
				for(int v : graph.outAdjacentNodes(node)) {
					if(!processed[v]) {
						foundUnprocessed.push(v);
					}
				}
			}
		} while(!foundUnprocessed.isEmpty());
		
		return true;
	}
	
	
}
