import java.util.*;

public class dijkstra{


	public static class Edge{
		int  dest, weight;
		Edge(int d, int w){
			this.dest = d;
			this.weight = w;
		}
	}

	static class Node{
		int vertex=0;
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
		boolean[] visited = new boolean[n];

		for(int i=0;i<n;i++){
			nodes[i] = new Node(i);
		}


		for(int i=0;i<m;i++){
			int s = scan.nextInt();
			int d = scan.nextInt();
			int w = scan.nextInt();
			
			Edge e = new Edge(d-1,w);
			nodes[s-1].edges.add(e);
			e = new Edge(s-1,w);
			nodes[d-1].edges.add(e);
		}


		nodes[16].key = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>(n, new comparator());

		queue.add(nodes[16]);
		
		while(!queue.isEmpty()){
			Node currNode = queue.poll();
			visited[currNode.vertex] = true;
			//System.out.println("current Node is"+currNode.vertex);
			for(Edge e : currNode.edges){
				if(visited[e.dest] == false){
					if(currNode.key+e.weight < nodes[e.dest].key){
						//queue.remove(nodes[e.dest]);
						nodes[e.dest].key = e.weight+currNode.key;
						queue.add(nodes[e.dest]);	
					}
				}
			}
		}
		/*System.out.println(nodes[4].key+" ");
		for(int i=1 ;i<n;i++){
			System.out.print(nodes[i].key+" ");
		}*/
		for(int i=0 ;i<n;i++){
           if(i==(16))
               continue;
           if(nodes[i].key != Integer.MAX_VALUE)
               System.out.print(nodes[i].key+" ");
           else                    
               System.out.print(-1+" ");
       }
	}
} 	