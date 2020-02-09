package Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
		public static Stack back = new Stack();
		public static Stack forward = new Stack();
		
	
	public static void main(String[] args) {
		Queue q = new LinkedList();
		Stack s = new Stack();
		
		s.push("0");
		s.push("1");
		s.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		while(!s.empty())
		System.out.println(s.pop());
		
		while(!q.isEmpty())
			System.out.println(q.poll());
		System.out.println("===============");
		
		goURL("1.네이트");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");
		
		PrintStatus();
		
		goBack();
		System.out.println(" = 뒤로가기 버튼을 누른 후 =");
		PrintStatus();
		
		goBack();
		System.out.println(" = '뒤로' 버튼을 누른 후  =");
		PrintStatus();
		
		goForward();
		System.out.println(" = '앞으로' 버튼을 누른 후  =");
		PrintStatus();
		
		goURL("codechobo.com");
		System.out.println(" = 새로운  주소로 이동 후  =");
		PrintStatus();
	}
	
	public static void PrintStatus() {
		System.out.println("back:"+back);
		System.out.println("forward:"+forward);
		System.out.println("전체화면은 '" + back.peek()+"'입니다.");
		System.out.println();
		
	}
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty())
			forward.clear();
	}	
	public static void goForward() {
		if(forward.empty())
			back.push(forward.pop());
	}
	public static void goBack() {
		if(!back.empty())
			forward.push(back.pop());
	}
	

}
