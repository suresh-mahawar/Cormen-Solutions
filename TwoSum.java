package cormen;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//input : 	10
//        	1 2 9 3 6 4 7 8 10 5
//        	10
//output : 	1 9
//			2 8
//			3 7
//			4 6

public class TwoSum {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		String inputs[] = new String[N];
		inputs = br.readLine().split(" ");
		for(int i = 0 ; i<inputs.length ; i++){
			input[i] = Integer.parseInt(inputs[i]);
		}
		int sum = Integer.parseInt(br.readLine());
		sort(input);
		int i = 0;
		int j = N-1;
		while(i<j){
			if((input[i]+input[j])==sum){
				System.out.println(input[i]+" "+input[j]);
				i++;
				j--;
			}
			else if((input[i]+input[j])>sum){
				j--;
			}
			else{
				i++;
			}
		}
	}
	public static void sort(int input[]){
		for(int i = 1 ; i<input.length ;  i++){
			int currentElement = input[i]; 
			int backPointer = i-1;
			while(backPointer >= 0 && input[backPointer] > currentElement){
				input[backPointer+1]= input[backPointer];
				backPointer--;
			}
			input[backPointer+1] = currentElement;
		}
	}
}
