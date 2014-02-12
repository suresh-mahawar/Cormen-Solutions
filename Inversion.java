package cormen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inversion {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[]  = new int[N];
		String in[] = new String[N];
		in = br.readLine().split(" ");
		for(int i =0 ; i<N  ; i++){
			input[i] = Integer.parseInt(in[i]);
		}
		findInversion(input,0,N-1);
	}
	public static void findInversion(int input[],int start, int end){
		if( start < end) {
			int mid = (start+end)/2;
		findInversion(input,start,mid);
		findInversion(input,mid+1,end);
		//inversionPair(input,start,mid,end);
		inversionPairInPlace(input,start,mid,end);
		}
	}
	public static void inversionPairInPlace(int input[],int start, int mid, int end){
		int j = end;
		while(j>=(mid+1)){
			if(input[mid] > input[j]){
				int current = input[j];
				input[j] = input[mid];
				int i = mid-1;
				while(i>=start && input[i] > current){
					input[i+1] = input[i];
					i--;
				}
				input[i+1] = current;
				while(i>=start){
					System.out.println(input[i--]+" "+current);
				}
			}
			else{
				int i = mid;
				while(i>=start){
					System.out.println(input[i--]+" "+input[j]);
				}

			}
			j--;
		}
	}
	public static void inversionPair(int input[],int start, int mid, int end){
		int n1 = mid-start+1;
		int n2 = end-mid;
		int Left[] = new int[n1];
		int Right[] = new int[n2];
		for(int i = 0 ; i<n1 ; i++){
			Left[i] = input[i+start];	
		}
		for(int i = 0 ; i<n2 ; i++){
			Right[i] = input[i+mid+1];
		}
		int i = n1-1, j = n2-1,k = start;
		
		i = 0;
		j = 0;
		while(i<n1 && j<n2){
			if(Left[i]<Right[j]){
				System.out.println(Left[i]+" "+Right[j]);
				input[k++] = Left[i++];
			}else{
				input[k++] = Right[j++];
			}
		}
		while(i<n1){
			input[k++] = Left[i++];
		}
		while(j<n2){
			input[k++] = Right[j++];
		}
	}
}
