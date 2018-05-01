import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	List<LinkedList<Integer>> graph;
	
	public Graph(int numNodes){
		graph = new ArrayList<LinkedList<Integer>>(numNodes);
	}
}
