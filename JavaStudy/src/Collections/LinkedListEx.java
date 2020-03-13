package Collections;

public class LinkedListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.delete(2);
		head.delete(3);
		head.retvieve();
		System.out.println(head+"확인합니다. 주소를~~");
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
				System.out.println(n.next+"==="+n.next.next);
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


class LinkedList1{
	//첫번째 노드를 가리킨다.
	private Node1 head;
	private Node1 tail;
	private int size = 0;
	
	private class Node1{
		
		private Object date;//데이터가 저장될 필드
		private Node1 next; //다음 노드를 가리키는 필드
	
		public Node1(Object input) {
			this.date = input;
			this.next = null;
		}
		
		public String toString() { //노드의 내용을 쉽게 출력 확인 기능
			return String.valueOf(this.date);
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
}

