package cormen;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		String in[] = new String[N];
		in = br.readLine().split(" ");
		for(int i = 0 ; i<N ; i++){
			input[i] = Integer.parseInt(in[i]);
		}
		int max = maxSubArray(input,0,N-1);
		System.out.print("sum = "+max);
	}
	public static int maxSubArray(int input[], int start, int end){
		if(start<end){
			int mid = (start+end)/2;
			int leftSum = 0,rightSum = 0;
			for(int i = start ; i<=mid ; i++){
				leftSum+=input[i];
			}
			maxSubArray(input,start,mid);
			for(int i = mid+1 ; i<=end ; i++){
				rightSum+=input[i];
			}
			maxSubArray(input,mid+1,end);
			int crossSum = crossMaxSum(input,start,mid,end);
			int max = leftSum > rightSum ? leftSum : rightSum;
			max = crossSum > max ? crossSum : max;
		
			return max ;
		}
		return 0;
	}
	public static int crossMaxSum(int input[], int start, int mid, int end){
		int i = mid, j = mid+1, crossSum = 0,maxLeft = 0 ,maxRight = 0;
		while(i>=start){
				crossSum  += input[i--];
				if(maxLeft<crossSum)maxLeft = crossSum;
		}
		crossSum = 0;
		while(j<=end){
				crossSum += input[j++];
				if(maxRight<crossSum)maxRight = crossSum;
		}
		int max = maxLeft+maxRight ;
		return max;
	}
}
