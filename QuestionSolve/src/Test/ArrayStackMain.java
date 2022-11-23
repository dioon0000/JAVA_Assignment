package Test;

import java.util.*;  //EmptyStackException을 포함하는 자바 라이브러리 패키지

//Stack<ET> 인터페이스
interface Stack<ET> {
	// 인수 elem을 스택 top에 삽입
	public void push(ET elem);
	// 스택 top의 원소를 삭제해서 리턴.
	public ET pop( );
	// 스택에 있는 원소 수를 리턴.
	public int size( );
}

//Stack<ET>를 상속받는 ArrayStack<ET> 클래스
class ArrayStack<ET> implements Stack<ET>  {
	private ET[] elem;
	private int top;
	final static int INIT_CAPACITY = 5; //Default Size = 5;
	
	//Overloading
	public ArrayStack() {
		this(INIT_CAPACITY);
	}
	public ArrayStack(int initCapacity){
		if(initCapacity < 0) throw new IllegalArgumentException("Initialcapacity > 0");

		elem = (ET[]) new Object[initCapacity];
		top = -1;
	}
	@Override
	public void push(ET e) {
		if(top == elem.length-1)  
			doubleCapacity();
		top++;
		elem[top] = e;
	}
	@Override
	public ET pop() {
		if(top == -1) throw new EmptyStackException();

		ET e = elem[top];
		top--;  // 삭제 
		return e;
	}
	@Override
	public int size() {
		return top+1; 
	}
	
	private void doubleCapacity() {
		//Object는 모든 객체 타입
		Object[] tmp = elem;
		//Object 타입의 tmp 배열을 ET[] 타입으로 변환
		elem = (ET[]) new Object[2*tmp.length];

		int size = top + 1;
		//arraycopy(arr1, arr1 시작주소, arr2, arr2의 시작주소, 길이)
		System.arraycopy(tmp, 0, elem, 0, size);
	}
} 

public class ArrayStackMain {
	public static void main(String[] args) {
	}
}
