package cormen;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InsertionSort {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		String inputs[] = new String[N];
		inputs = br.readLine().split(" ");
		for(int i = 0 ; i<inputs.length ; i++){
			input[i] = Integer.parseInt(inputs[i]);
		}
		sort(input);
		for(int i = 0 ; i<input.length ; i++){
			System.out.print(" "+input[i]);
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
