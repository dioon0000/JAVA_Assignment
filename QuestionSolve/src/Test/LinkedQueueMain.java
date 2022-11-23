package Test;
import java.util.*; //NoSuchElementException을 포함하는 자바 라이브러리 패키지

//LinkedQueue<ET> 클래스
class LinkedQueue<ET> {
	//뒤쪽 노드
	private Node<ET> rear; 
	//Queue의 사이즈
	private int size;
	//생성자
	public LinkedQueue() {
		//초기 rear값은 null
		rear = null;
		size = 0;
	}

	class Node <ET>{
		private ET  elem;
		private Node<ET> next;

		public Node(ET elem, Node<ET> next) {
			this.elem = elem;
			this.next = next;
		}	
	}
	
	public void add(ET elem) {
		//현재 노드
		Node<ET> cn = new Node<ET>(elem, rear);
		//뒤쪽 노드에 연결된 값이 존재하지 않을 경우
		if(rear == null)
			//cn.next값은 cn (자신이 자신을 가리키는 환형구조를 이룸)
			cn.next = cn;
		//만약 뒤쪽 노드에 연결된 값이 존재할 경우
		else {
			cn.next = rear.next;
			rear.next = cn;
		}
		//새로만든 노드 cn은 모든과정을 끝낸 뒤, rear로 변경해준다
		rear = cn;
		size++;
	}
	
	public ET remove() {
		//강제 오류발생 구문
		if(size() == 0) throw new NoSuchElementException();

		//rear.next는 항상 front를 가리키고 있음 (중요)
		Node<ET> front = rear.next;
		if(size == 1)
			rear = null;
		else
			//front.next값은 front가 제거되고 난뒤에 새로운 front값이므로 rear.next에 넣어줌
			rear.next = front.next;
			
		size--;
		return front.elem;
	}
	
	public int size() {
		return size; 
	}
}

public class LinkedQueueMain{
	public static void main(String[] args) {
		LinkedQueue<Integer> lq = new LinkedQueue<Integer>();
		lq.add(1); lq.add(2); lq.add(3); lq.add(4); lq.add(5);
		System.out.println(lq.size()); //5
		System.out.println(lq.remove()); // 1
	}
}