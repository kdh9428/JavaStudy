package Collections;

public class LinkedListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retvieve();
		System.out.println("=====================");
		
		LinkedList1 aa = new LinkedList1();
		aa.addFirst("asdfff");
		aa.add(1, 23);
		aa.addLast(234);
		System.out.println("=======aa");
		System.out.println(aa.get(0));
		System.out.println(aa.get(1));
		
		
		
		Node aas = new Node(2);
		
		Object a;
		a=aas;
		System.out.println(a);
		System.out.println("==================");
		aa.add(0,aas);
		System.out.println(aa);
		
		if(a instanceof Node) {
			System.out.println("숫자형");
		}else if(a instanceof String) {
			System.out.println("문자형");
		}
	}
}

class Node{
	int date;
	Node next = null;
	
	Node(int date){
		this.date = date;
	}
	void append(int d) {
		Node end = new Node(d);
		
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void delete(int d) {
		Node n = this;
		while(n.next != null) {
			if(n.next.date == d) {
				n.next = n.next.next;
			}else {
				n = n.next;
			}
		}
	}
	
	void retvieve() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.date+" => ");
			n = n.next;
		}
		System.out.println(n.date);
	}
}

//LinkedList 다른 버전 공부
class LinkedList1{
	//첫번째 노드를 가리킨다.
	private Node1 head;
	private Node1 tail;
	private int size = 0;
	
	private class Node1 {
		
		private Object data;//데이터가 저장될 필드
		private Node1 next; //다음 노드를 가리키는 필드
	
		public Node1(Object input) {
			Object aaa = "11";
			System.out.println(input);
			if(input.equals(aaa)) {
				System.out.println("맞음");
			}
			this.data = input;
			this.next = null;
		}
		
		public String toString() { //노드의 내용을 쉽게 출력 확인 기능
			return String.valueOf(this.data);
		}
	}
	
	
	public void addFirst(Object input) {//첫번째 노드(시작의 추가하는 방법) 
		Node1 newNode = new Node1(input);//노드 생성
		newNode.next = head;//새로운 노드의 다음 노드로 헤드를 지정한다.
		head = newNode;//헤드로 새로운 노드를 지정한다.
		size++;//linkedlist 사이즈가 증가된다
		if(head.next == null) {//head의 다음 값이 없다면
			tail = head;//첫번째 생성된 객체를 헤드로 지정한다.
		}
	}
	
	public void addLast(Object input) {
		Node1 newNode= new Node1(input);
		if(size == 0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	Node1 node(int index) {
		Node1 x = head;
		
		for(int i=0;i<index;i++) {
			x = x.next;
		}
		return x;
	}
	
	public void add(int k, Object input) {
		if(k==0) {
			addFirst(input);
		}else{
			Node1 temp1 = node(k-1);
			Node1 temp2 = temp1.next;
			Node1 newNode = new Node1(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			if(newNode.next == null) {
				tail=newNode;
			}
		}
	}
	
	@Override
	public String toString() {
		if(head == null) {
			return "[]";
		}
		Node1 temp = head;
		String str = "[";
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data;
		
		return str+"]";
	}
	
	public Object removeFirst() {
		Node1 temp = head; //노드 탐색 
		head = head.next;// 해드의 다음 노드를 해드에 넣는다.
		Object returnData = new Object();
		returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	public Object remove(int k) {
		if(k==0) {
			return removeFirst();
		}
		Node1 temp= node(k-1);
		Node1 todoDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = temp;
		}
		todoDeleted = null;
		size--;
		return returnData;
	}
	
	//list 사이즈
	public int size() {
	    return size;
	}
	
	//엘리먼트 가져오기
	public Object get(int k){
	    Node1 temp = node(k);
	    return temp.data;
	}
}

