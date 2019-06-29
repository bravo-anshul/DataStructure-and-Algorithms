
// GRAPH REPRESENTATION USING LINKED LIST

import java.util.LinkedList;
import java.util.Stack;

public class graph {
	
	static class Graph{
		int nodes;
		LinkedList<Integer> adjListArray[];
		
		public Graph(int v) {
			this.nodes = v;
			
			adjListArray = new LinkedList[v];
			
			for(int i=0;i<nodes;i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
		
		// BFS of graph done using queue.

		public void BFS(int s) {
			boolean[] visited = new boolean[nodes];
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			visited[s] = true;
			queue.add(s);
			
			while(queue.size() != 0) {
				System.out.print(queue.poll());
				for(int i : adjListArray[s]) {
					if(!visited[i]) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}
		}

		// DFS of grapn done using stack.
		
		public void DFS(int s) {
			boolean[] visited = new boolean[nodes];
			Stack<Integer> stack = new Stack<Integer>();
		
			stack.push(s);
			while(stack.empty() == false) {
				s = stack.peek();	
				System.out.print(s);
				stack.pop();
				if(!visited[s]) {
					System.out.print(s);
					visited[s] = true;
				}
				
				for(int i : adjListArray[s]) {
					if(!visited[i]) {
						stack.push(i);
					}
				}	
			}	
		}
		//END OF CLASS
		
	}

	// Function to add edge between two nodes of any given grapn.
	
	static void addEdge(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);

		// This function is for Directed grapn. Uncomment below line for undirected graph.

		//graph.adjListArray[dest].add(src);
	}

	static void printGraph(Graph graph) {
		for(int i=0;i<graph.nodes;i++) {
			System.out.println("");
			System.out.println("Adjency List of :"+i);
			for(Integer node : graph.adjListArray[i]) {
				System.out.print("-> " + node);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int v = 5;
		Graph graph = new Graph(v);
		addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
        
        printGraph(graph);
        
        Graph g = new Graph(4); 
        
        addEdge(g, 0, 1); 
        addEdge(g, 0, 2); 
        addEdge(g, 1, 2); 
        addEdge(g, 2, 0); 
        addEdge(g, 2, 3); 
        addEdge(g, 3, 3); 
        
        printGraph(g);
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
        
        //Graph DFS
        
        Graph g = new Graph(6); 
        addEdge(g, 1, 2); 
        addEdge(g, 2, 3); 
        addEdge(g, 1, 3); 
        addEdge(g, 4, 5); 
        
        g.DFS(1);
	

	}

}
