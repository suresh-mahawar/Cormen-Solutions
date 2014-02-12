package cormen;

import java.io.*;

public class RodCutting{
	public static int memo[] = new int[1000];
	public  static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String in[] = new String[n];
		in = br.readLine().split(" ");
		for(int i = 0 ; i<n ; i++){
			input[i] = Integer.parseInt(in[i]);
		}
		int max = maxRevenue(input,n);
		System.out.print(max);
	}

	public static int maxRevenue(int input[], int n){
		if(n==0) return 0;
		if(memo[n-1]>0) return memo[n-1];
	    int q = -1;
		for(int i = 1; i<=n ; i++){
			q = max(q, input[i-1]+maxRevenue(input,n-i));
		}
		memo[n-1] = q;
		return q;
	}
	public static int max(int a,int b){
		return a - ((a-b) & ((a-b)>>(Integer.SIZE-1)));
	}
}