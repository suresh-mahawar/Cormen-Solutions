package cormen;

import java.io.*;

public class QueueUsing2Stacks {
	public static int stack1Size = 10;
	public static int stack2Size = 10;
	public static int top1=-1;
	public static int top2=-1;
	public static int stack1[] = new int[stack1Size];
	public static int stack2[] = new int[stack2Size];
	
	public static void main(String[] args) throws IOException{
		enqueue(10);
		enqueue(11);
		enqueue(12);
		enqueue(13);
		enqueue(14);
		enqueue(15);
		enqueue(16);
		enqueue(17);
		enqueue(18);
		enqueue(19);
		enqueue(20);
		enqueue(21);
		enqueue(21);
		enqueue(21);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}
	
	public static void enqueue(int element){
		push1(element);
	}
	public static int dequeue(){
		if(top1==-1){
			System.out.println("Underflow");
			return -1;
		}
		while(top1>0){
			push2(pop1());
		}
		int element = pop1();
		while(top2>=0){
			push1(pop2());
		}
		return element;
	}
	
	public static void push1(int element){
		if(top1<stack1Size-1){
			stack1[++top1] = element;
		}else{
			System.out.println("Overflow");
		}
	}
	public static void push2(int element){
		if(top2<stack2Size-1){
			stack2[++top2] = element;
		}else{
			System.out.println("Overflow");
		}
	}
	public static int pop1(){
		if(top1>=0){
			return stack1[top1--];
		}else{
			return -1;
		}
	}
	public static int pop2(){
		if(top2>=0){
			return stack2[top2--];
		}else{
			return -1;
		}
	}
}
