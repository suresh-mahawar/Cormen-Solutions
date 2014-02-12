package cormen;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddBinaryArray{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String bin1[] = new String[N];
		String bin2[] = new String[N];
		bin1 = br.readLine().split(" ");
		bin2 = br.readLine().split(" ");
		boolean binary1[] = new boolean[N];
		boolean binary2[] = new boolean[N];
		boolean binary3[] = new boolean[N+1];
		for(int i = 0 ; i<N ; i++){
			binary1[i] = Integer.parseInt(bin1[i])==1 ? true : false;
			binary2[i] =  Integer.parseInt(bin2[i])==1 ? true : false;
		}
		boolean carry = false;
		for(int i = N-1 ; i>=0 ; i-- ){
			binary3[i+1] = binary1[i] ^ binary2[i] ^ carry;
			carry = (carry & !binary1[i] & binary2[i]) |(binary1[i] & binary2[i]) |(carry & binary1[i]);
		}
		binary3[0] = carry ? true : false;
		for(int i = 0 ; i<N+1 ; i++ ){
			System.out.print(binary3[i] ? "1 " : "0 ");
		}
	}
}
