package Collections;

import java.util.LinkedList;

class HashTable{
	
	//해쉬 테이블에 저장할 노드 
	class Node{
		String key;
		String value;
		
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		//value를 가져올 get, set 설정
		String value() {
			return value;
		}
		void value(String value) {
			this.value = value;
		}
	}
	
	//데이터를 저장할 링크드 리스트 배열로 선언
	LinkedList<Node> [] data; //방금 선언한 노드가 들어간다.
	
	//해쉬 테이블 크기 지정해서 생성한다.(배열방 생성)
	HashTable(int size){
		this.data = new LinkedList[size];
	}
	
	//해쉬 알고리즘 지정
	int getHashCode(String key) {
		int hashcode = 0; //해쉬 코드 0으로 초기화
		//toCharArray() 메소드는 문자열을 char형 배열로 바꾼다.
		for(char c : key.toCharArray()) {//입력받은 키의 문자열을 돌면서 아스키 코드의 값을 c에 저장한다.
			hashcode += c;
//			System.out.println("아스키 코드 값 확인 : " + hashcode);
			
		}
		return hashcode;
	}
	
	//해쉬코드를 받아서 배열방에 인덱스로 지정한다.
	int convertToIndex(int hashcode) {
		//해쉬코드를 배열방의 크기로 나눈 나머지 값을 반환한다.
		return hashcode % data.length;
	}
	
	
	//인덱스로 배열방을 찾은 이후에 노드가  배열방에 여러개 일 경우 검색 키를 가지고 해당 노드를 찾아가야 한다.
	Node searchKey(LinkedList<Node> list, String key) {
		if(list == null) return null;
		for(Node node : list) {//배열방에 있는 링크드리스트를 돌면서 
			if (node.key.equals(key)) {//노드의 키가 검색하는 키와 같은지 비교한후 같으면 node를 반환한다.
				return node;
			}
		}
		return null;// 같은 데이터가 없을 경우 null을 반환
	}
	
	void put(String key, String value) {
		int hashcode = getHashCode(key); //키를 가지고 해쉬코드를(아스키코드를 더한 값) 받아온다.
		int index = convertToIndex(hashcode); //해쉬코드를 배열방의 크기로 나눈 나머지 받아온다. 
		System.out.println(key + ", hashcode("+hashcode + "), index ("+index + ")");
		
		LinkedList<Node> list = data[index]; //배열방 번호를 이용해 기존에 있는 데이터를 가져온다.
		if (list ==null ) {//배열방 안에 아무 데이터가 없다면
			list = new LinkedList<Node>();//링크드 리스트를 생성한다.
			data[index] = list;//해당 리스트를 배열방에 넣어준다.
		}
		
		Node node = searchKey(list, key); // 배열방에 기존의 키로 데이터가 있는지 검사
		if (node ==null) { //노드가 null이면 데이터가 없다
			list.addLast(new Node(key, value));//받아온 정보를 가지고 노드 객체를 생성해 list에 넣어준다.
		}else {
			node.value(value);//노드에 같은 키가 있다면 값을 변경해준다.
		}
	}
	String get (String key) {
		int hashcode = getHashCode(key); //키를 가지고 해쉬 코드 받아온다.
		int index = convertToIndex(hashcode);//받아온 해쉬코드로 인덱스를 받아온다.(아스키코드 더한 값을 배열방 개수로 나눈값)
		LinkedList<Node> list = data[index];//인덱스로 링크드 리스트를 가져온다.
		Node node = searchKey(list, key); // 링크드리스트(배열방이 3이면 3번의 배열방을 키값과 같이 전달, 키 값과 비교해 같은 노드객체가 있다면 가져온다.)
		return node == null ? "Not Found" : node.value();
	}
}

public class HashTableEx {

	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		
		h.put("sung", "She is pretty");
		h.put("jin", "She is a model");
		h.put("hee", "She is an angel");
		h.put("min", "She is cute");
		h.put("sung", "error");
		
		
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		System.out.println(h.get("dde"));
		
		HashTable s = new HashTable(5);
		s.put("sung", "sh1");
		s.put("sung1", "sh2");
		s.put("sung2", "sh3");
		s.put("sung3", "sh4");
		s.put("sung4", "sh5");
		
		System.out.println(s.get("sung"));
		System.out.println(s.get("sung1"));
		System.out.println(s.get("sung2"));
		System.out.println(s.get("sung3"));
		System.out.println(s.get("sung4"));
		
	}

}
