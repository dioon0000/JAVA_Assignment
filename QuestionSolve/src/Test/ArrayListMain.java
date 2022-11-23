package Test;

//LinearList 인터페이스
interface ArrayLinearList<ET>{
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	ET get(int index);
	void show();
	int binarySearch(Integer[] arr, int x);
}

//LinearList를 상속받는 ArrayListSorted 클래스
class ArrayListSorted <ET> implements ArrayLinearList<ET> {
	ET[] elem;
	int size;
	static final int INIT_CAPACITY = 5;
	
	//Overloading
	public ArrayListSorted() { //ArrayListSorted 클래스의 새로운 객체를 만들 때, 크기값을 지정해주지않으면 Default 크기인 5로 생성
		this(INIT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public ArrayListSorted(int initCapacity) {
		elem = (ET[]) new Object[initCapacity];
	}
	@Override
	public void insert(ET theElem) {
		if(size == elem.length)
			changeCapacity(2 * size);
		
		int i = 0;
		@SuppressWarnings("unchecked")
		//<ET> 제네릭클래스를 사용하는 비교형 Comparable자료형 e 변수 생성
		Comparable<ET> e = (Comparable<ET>) theElem;
		//a.compareTo(b)에서 a가 b보다 큰 경우 1, 같은 경우 0, 작은 경우 -1을 리턴 
		while(i<size &&e.compareTo(elem[i]) > 0)
			i++;
		
		for(int j=size; j>i; j--)
			elem[j] = elem[j-1];
		
		elem[i] = theElem;
		size++;
	}
	public void changeCapacity(int newCapacity) {
		@SuppressWarnings("unchecked")
		ET[] tmp = (ET[]) new Object[newCapacity];
		for(int i = 0; i < size; i++)
			tmp[i] = elem[i];
		elem = tmp;
		
	}
	@Override
	public Boolean remove(ET theElem) {
		int i;
		//theElem값을 찾으면 특정 idx에서 i는 멈춤 ex) theElem: 20, i=1
		for(i=0; i<size; i++) {
			if(elem[i].equals(theElem))
				break;
		}
		
		if(i == size)
			return false;
		//58줄 for문에서 멈춘 i값이 그대로 쓰임
		for(; i< size-1; i++)
			elem[i] = elem[i+1];
		
		size--;
		//size가 elem.length를 4배 줄인것보다 작거나 같은경우에는 메모리를 낭비하지 않기위해 배열의 크기를 줄임
		if(size<= elem.length/4)
			changeCapacity(elem.length/2);
		
		return true;
	}
	@Override
	public int search(ET theElem){
		int i;
		for(i=0; i<size; i++) {
			if(elem[i].equals(theElem))
				return i;
		}
		return -1;
	}
	@Override
	public ET get(int index){
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		return elem[index];
	}
	@Override
	public void show(){
		for(int i = 0; i<size; i++)
			System.out.print(elem[i] + " ");
		
		System.out.println();
	}
	@Override
	public int binarySearch(Integer[] arr, int x){
		int l = 0, r = arr.length -1;
		while(l<=r) {
			int m = (l+r)/2;
			if(x == arr[m])
				return m;
			else if(x < arr[m])
				r = m -1;
			else l = m +1;
		}
		return -1;
	}
}


public class ArrayListMain {

	public static void main(String[] args) {
		int []arr = new int [5];
		ArrayListSorted <Integer> al = new ArrayListSorted<Integer> ();
		int x = 10;
		al.insert(30);
		al.insert(50);
		al.insert(20);
		al.insert(10);
		al.insert(40);
		//System.out.println(al.binarySearch(al.elem, x));
		int r = al.search(20);
		System.out.println(r); //1
		System.out.println(al.get(3)); //40
		al.show(); //10 20 30 40 50
	}

}
