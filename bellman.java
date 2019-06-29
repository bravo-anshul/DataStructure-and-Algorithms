import java.util.*;

public class bellman{
	
	public static class Edge{
		int src, dest, weight;
		Edge(int s,int d, int w){
			this.dest = d;
			this.weight = w;
			this.src = s;
		}

	}


	public static void main(String[] args)	 {
	
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		int[] key = new int[n];
		Edge[] edges = new Edge[m];

		for(int i=0;i<m;i++){
			int s = scan.nextInt();
			int d = scan.nextInt();
			int w = scan.nextInt();
			Edge e = new Edge(s-1,d-1,w);
			edges[i] = e;
		}

		for(int i=0;i<n;i++){
			key[i] = Integer.MAX_VALUE;
		}

		key[0]=0;

		for(int j=1;j<n;j++){
			for(Edge e : edges){
				int s = e.src;
				int d = e.dest;
				int w = e.weight;
				if(key[d]>key[s]+w){
					key[d] = key[s]+w;
				}
			}
		}
		for(int i=1 ;i<n;i++){
			System.out.print(key[i]+" ");
		}
		
	}
}