package cormen;

public class StackUsing2Queue {
	public static int queue1Size = 10;
	public static int queue2Size = 10;
	public static int head1 = -1;
	public static int tail1 = -1;
	public static int head2 = -1;
	public static int tail2 = -1;
	public static int queue1[] = new int[queue1Size];
	public static int queue2[] = new int[queue2Size];
	
	public static void main(String[] args){
		
		push(10);
		push(11);
		push(12);
		push(13);
		push(14);
		push(15);
		push(16);
		push(17);
		push(18);
		
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		
	}
	
	
	public static void push(int element){
		enqueue1(element);
	}
	public static int pop(){
		while(tail1<head1){
			enqueue2(dequeue1());
		}
		int element = dequeue1();
		while(tail2<=head2 && tail2!=-1){
			enqueue1(dequeue2());
		}
		return element;
	}
	public static void enqueue1(int element){
		if(tail1==-1){
			tail1 = 0;
		}
		if(head1<queue1Size-1){
			queue1[++head1] = element;
		}else{
			System.out.println("Overflow");
		}
	}
	public static void enqueue2(int element){
		if(tail2==-1){
			tail2 = 0;
		}
		if(head2<queue2Size-1){
			queue2[++head2] = element;
		}else{
			System.out.println("Overflow");
		}
	}
	public static int dequeue1(){
		int element=0;
		if(tail1<head1){
			return queue1[tail1++];
		}else if(tail1==head1 && tail1!=-1){
			element = queue1[tail1];
			tail1 = head1 = -1;
			return element;
		}else{
			System.out.println("Underflow");
			return -1;
		}
	}
	public static int dequeue2(){
		int element=0;
		if(tail2<head2){
			return queue2[tail2++];
		}else if(tail2==head2 && tail2!=-1){
			element = queue2[tail2];
			tail2 = head2 = -1;
			return element;
		}else {
			System.out.println("Underflow");
			return -1;
		}
	}
}
