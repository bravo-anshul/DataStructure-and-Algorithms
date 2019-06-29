import java.util.*;

public class kmp{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		int[] lps = new int[s.length()];
		lps[0] = 0;
		int len=0;
		int m = s.length();
		for(int i =1;i<m;){
			if(s.charAt(i) == s.charAt(len)){
				len+=1;
				lps[i] = len;
				i+=1;
			}
			else{
				if(len!=0){
					len = lps[len-1];
				}
				else{
					lps[i] = len;
					i++;
				}
			}
		}

		String text = scan.nextLine();
		int j=0;
		int i=0;
		while(i<text.length()){
			if(text.charAt(i) == s.charAt(j)){
				i+=1;
				j+=1;
			}
			if(j == m){
				System.out.println("Pattern found at index :"+(i-j));
				j = lps[j-1];
			}
			else if(i<text.length() && text.charAt(i)!=s.charAt(j)){
				if(j!=0){
					j = lps[j-1];
				}
				else{
					i+=1;
				}
			}
		}



		

		/*System.out.println("");
		for(int i : lps){
			System.out.print(i+",");
		}*/

	}	

}