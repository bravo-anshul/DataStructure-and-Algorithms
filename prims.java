import java.util.*;

public class prims{

	public static class Edge{
		int dest, weight;
		Edge(int d, int w){
			this.dest = d;
			this.weight = w;
		}

	}

	public static class Node{
		int vertex;
		int key = Integer.MAX_VALUE;
		LinkedList<Edge> edges = new LinkedList<>();

		Node(int i){
			this.vertex = i;
		}
		
	}
	
	static class comparator implements Comparator<Node> { 
  
        @Override
        public int compare(Node node0, Node node1) 
        { 
            return node0.key - node1.key; 
        } 
    } 

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		Node[] nodes = new Node[n];
		for(int i =0;i<n;i++){
			nodes[i] = new Node(i);
		}
		int[] parent = new int[n];
		boolean[] visited = new boolean[n];

		

		//Graph graph = new Graph(n);
		for(int i=0;i<m;i++){
			int s = scan.nextInt();
			int d = scan.nextInt();
			int w = scan.nextInt();

			Edge e = new Edge(d,w);
			nodes[s-1].edges.add(e);
	
			e = new Edge(s,w);
			nodes[d-1].edges.add(e);
			/*if(nodes[d-1].minWeight>w){
				nodes[d-1].minWeight = w;
				nodes[d-1].minEdge = s;
			}	*/
		}

		for(int i=0;i<n;i++)
			parent[i] = i;

		/*for(int i=0;i<n;i++){
			System.out.println("Edges of node :"+(i+1));
			for(Edge e : nodes[i].edges){
				System.out.println("Edges are ->"+e.dest+" weight is :"+e.weight);
			}
		}*/


		visited[0] = true;
		nodes[0].key=0;
		

		PriorityQueue<Node> queue = new PriorityQueue<>(n, new comparator());
		for(Node nn : nodes)
			queue.add(nn);
		
		while(!queue.isEmpty()){
			Node currNode = queue.poll();

			visited[currNode.vertex] = true;

			for(Edge e : currNode.edges){
				if(visited[e.dest-1] == false){
					if(nodes[e.dest-1].key > e.weight){
						queue.remove(nodes[e.dest-1]);
						nodes[e.dest-1].key = e.weight;
						queue.add(nodes[e.dest-1]);
						parent[e.dest-1] = currNode.vertex;
					}
				}
			}
		}
		
		for (int o = 1; o < n; o++) 
            System.out.println(parent[o] + " " + "-"+ " " + o); 
        
        int totalWeight=0;
        for(Node nn : nodes)
        	totalWeight+=nn.key;
        
        System.out.println("Total weight is :" + totalWeight);  
        

	}
	

}		