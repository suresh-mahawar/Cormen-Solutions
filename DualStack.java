package cormen;
import java.io.*;

public class DualStack {
	public static int N = 10;
	public static int top1=-1;
	public static int top2=N;
	public static int dualStack[] = new int[N];
	public static void main(String[] args)throws IOException{		
		push1(532);
		push1(173);
		push1(124);
		push1(453);
		push2(133);
		push2(34);
		push2(532);
		push2(322);
		push2(652);
		push2(252);
		push2(6352);
		push2(7452);
		
		System.out.println("pop1 = "+pop1());
		System.out.println("pop1 = "+pop1());
		System.out.println("pop2 = "+pop2());
		System.out.println("pop2 = "+pop2());
	}
	public static void push1(int element){
		if((top1+1)<top2){
			dualStack[++top1] = element;
		}else{
			System.out.println("Overflow stack 1");
		}
	}
	public static void push2(int element){
		if((top1+1)<top2){
			dualStack[--top2] = element;
		}else{
			System.out.println("Overflow stack 2");
		}
	}
	public static int pop1(){
		if(top1>=0){
			return dualStack[top1--];
		}else{
			System.out.println("Underflow stack 1");
			return -1;
		}
	}
	public static int pop2(){
		if(top2<=N-1){
			return dualStack[top2++];
		}else{
			System.out.println("Underflow stack 2");
			return -1;
		}
	}
}
