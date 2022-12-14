package Test;

import java.util.*;  // for EmptyStackException

interface LinkedStack<ET> {
	// 인수 elem을 스택 top에 삽입
	public void push(ET elem);
	// 스택 top의 원소를 삭제해서 리턴.
	public ET pop();
	// 스택에 있는 원소 수를 리턴.
	public int size();
}

class SLinkedStack<ET> implements LinkedStack<ET> {
	private  Node<ET> top;
	private  int size;  // number of nodes in stack
		
	public SLinkedStack() {
		top = null;
		size = 0; 
	}
	public void push(ET theElem) {
		top = new Node<ET>( theElem, top ); // add node 
		size++;
	}
	public ET pop() {
		if(top == null) 
			return null;
		
		Node<ET> np = top;
		top = top.next;  // 삭제 
		size--;
		return np.elem;
	}
	public int size() { 
		return  size; 
	}	
	class Node<ET>{
		private  ET elem;
		private  Node<ET> next;
			
		Node( ET e, Node<ET> n ) {
			elem = e;
			next = n;
		}
	} // class Node

}

public class LinkedStackMain {
	public static void main(String[] args) {
		SLinkedStack<Integer> ls = new SLinkedStack<Integer>();
	}

}
