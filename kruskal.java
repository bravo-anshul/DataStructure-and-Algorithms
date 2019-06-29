import java.util.*;

public class kruskal{

	static class Edge{
		int src, dest, weight;
		Edge(int s, int d, int w){
			this.src = s;
			this.dest = d;
			this.weight = w;
		}

		public Edge minEdge(Edge a, Edge b){
			if(a.weight<b.weight)
				return a;
			else
				return b;
		}

	}
	

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		Edge[] edge = new Edge[m];
		int[] parent = new int[n];
		boolean[] visited = new boolean[n];

		for(int i=0;i<n;i++)
			parent[i] = 0;

		//Graph graph = new Graph(n);
		for(int i=0;i<m;i++){
			int s = scan.nextInt();
			int d = scan.nextInt();
			int w = scan.nextInt();

			edge[i] = new Edge(s-1, d-1, w);
		}
		for (int i = 0; i < m; i++)
            for (int j = 0; j < m-1; j++)
                if (edge[j].weight > edge[j+1].weight)
                {
                    // swap temp and arr[i]
                    Edge temp = edge[j];
                    edge[j] = edge[j+1];
                    edge[j+1] = temp;
                }
		/*System.out.println("Edges weight :");
		for(int i=0;i<m;i++){
			System.out.print(edge[i].weight);
		}*/



		int totalWeight=0;
		int count=0;
		
		for (int i=0;count != n-1;i++){
			//System.out.println("Inside if of "+i);
			Edge smallestEdge = edge[i];
			int src = smallestEdge.dest;
			int dest =  smallestEdge.src;
			
			while(parent[src]!=0){
				src = parent[src];
			}
			while(parent[dest]!=0){
				dest = parent[dest];
			}

			//System.out.println("U and V are"+u+" "+v);
			if((src!=dest)){
			//if(parent[dest] != parent[src]){
				parent[dest] = src;
				System.out.println("Updated parents are"+(parent[src]+1)+(parent[dest]+1));
				totalWeight+=smallestEdge.weight;
				//visited[v] =true;
				//visited[u] = true;
				count+=1;
			}	
			


		}
		
		System.out.println(totalWeight);



	}
	

}		