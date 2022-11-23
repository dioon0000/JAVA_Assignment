package Test;

//ET = Element Type

//LinearList 인터페이스
interface LinearList<ET>{
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	void show();
	ET get(int index);
}

//LinearList를 상속받는 SLinkedList class 생성
class SLinkedList <ET> implements LinearList<ET>{
	
	//노드의 첫 부분
	private Node<ET> head;
	//List의 개수
	private int size;
	
	//생성자
	public SLinkedList() {
		//head의 초기값은 null, size=0으로 설정
		head = null;
		size = 0;
	}
	
	//Node<ET> class
	class Node<ET>{
		//elem ET형 변수
		private ET elem;
		//Node형 next변수
		private Node next;
		//constructor
		Node(ET elem, Node next){
			this.elem = elem;
			this.next = next;
		}
	} 
	
	//LinearList 인터페이스 속에 있는 insert 함수 오버라이드
	@Override
	public void insert(ET theElem) {
		head = new Node<ET>(theElem, head);
		size++;
	}
	
	//LinearList 인터페이스 속에 있는 remove 함수 오버라이드
	@Override
	public Boolean remove(ET theElem) {	
		//pn은 이전노드, cn은 현재 노드를 의미
		Node<ET> pn = null, cn;
		//cn을 head 노드부터 cn값이 null 즉 리스트의 끝이 될때까지 for문 실행
		for(cn = head; cn != null; cn = cn.next) {
			if(cn.elem.equals(theElem)) 
				break;
			//pn을 cn으로 변경
			pn = cn;
		}
		//리스트의 끝까지 방문했을 때, theElem값이 없을 경우
		if(cn == null)
			return false;
		//cn 노드가 head 노드와 동일할 경우
		if(cn.equals(head)) {
			//head.next 노드를 저장할 임시 노드 nextNode 생성
			Node<ET> nextNode = head.next;
			//head 노드를 nextNode로 변경
			head = nextNode;
			//위 과정을 통하여 올바르게 지워졌기 때문에 size값을 1 줄임
			size--;
			return true;
		}
		//pn.next값이 cn.next값으로 변한다면 cn 노드에 접근할 방법이 사라지므로 올바르게 지워진 것으로 판단
		pn.next = cn.next;
		size--;
		return true;
	}
	
	//LinearList 인터페이스 속에 있는 search 함수 오버라이드
	@Override
	public int search(ET theElem) {	
		int i = 0;
		Node<ET> cn;
		   for(cn = head; cn != null; cn = cn.next) {
			   if( cn.elem.equals(theElem) )
				   //theElem의 idx값을 리턴
				   return i;
			   i++;				
	   	   }
		   return -1;
	}
	
	//LinearList 인터페이스 속에 있는 get 함수 오버라이드
	@Override
	public ET get(int index) {
		//index가 리스트의 범위를 벗어나는 경우 예외를 발생시켜 null을 리턴
		if (index < 0 || index >= size) {
			try {
				throw new IndexOutOfBoundsException();
			}
			catch(IndexOutOfBoundsException e){
				return null;
			}
		}

		Node<ET> cn = head;
		for(int i = 0; i < index; i++) {
			cn = cn.next;
		}
		return cn.elem;
	}
	
	//LinearList 인터페이스 속에 있는 show 함수 오버라이드
	@Override
	public void show() {
		Node<ET> cn = head;
		//리스트의 size만큼 cn.elem값을 출력
		for(int i=0; i < size; ++i) {
			System.out.print(cn.elem + " ");
			cn = cn.next;
		}
		System.out.println();
	}
}

public class LinkedListMain {
	public static void main(String[] args) {
		SLinkedList<Integer> ll = new SLinkedList<Integer>();
		ll.insert(50);
		ll.insert(30);
		ll.insert(70);
		ll.insert(20);
		ll.insert(40);
		ll.insert(60);
		ll.show(); // 60 40 20 70 30 50
		System.out.println(ll.get(3)); // 70
		System.out.println(ll.get(9)); // null
		System.out.println(ll.search(30)); // 4
		System.out.println(ll.search(90)); // -1
		ll.remove(60);
		ll.remove(70);
		ll.remove(50);
		ll.remove(90);
		ll.show(); // 40 20 30
	}
}