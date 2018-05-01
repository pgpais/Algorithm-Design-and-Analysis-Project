import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	List<LinkedList<Integer>> graph;
	int[] inDegree, outDegree;
	
	public Graph(int numNodes){
		graph = new ArrayList<LinkedList<Integer>>(numNodes);
		inDegree = new int[numNodes];
		outDegree = new int[numNodes];
	}
	
	public int inDegree(int node) {
		return inDegree[node];
	}
	
	public int outDegree(int node) {
		return outDegree[node];
	}
	
	public LinkedList<Integer> inAdjacentNodes(int node){
		//TODO: dafuq? como fa�o isto?
		return null;
	}
	
	public LinkedList<Integer> outAdjacentNodes(int node){
		return graph.get(node);
	}
}
