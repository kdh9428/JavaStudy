package ThreadTest;

public class ThreadTest1 {
	public static Counter cnt = new Counter();
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable task5 = () ->{
			for(int i=0; i<1000; i++)
				cnt.increment(); //값을 1 증가
		};
		Runnable task6 = () ->{
			for(int i=0; i<1000; i++)
				cnt.decrement(); //값을 1 감소
		};
		
		Thread t5 = new Thread(task5);
		Thread t6 = new Thread(task6);
		t5.start();
		t6.start();
		
		t5.join();	//t5이 참조하는 쓰레드의 종료를 기다림
		t6.join();	//t6이 참조하는 쓰레드의 종료를 기다림
		System.out.println("종료 : "+cnt.getCount());
		
		
		Runnable task1 = ()->{
			try {
				for(int i =0; i<20; i++) {
					if(i%2 ==0)
						System.out.println(i+" ");
						Thread.sleep(10); 	//0.1초간 멈춘다.
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable task2 = () ->{
			
			try {
				for(int i=0; i<20; i++) {
					if (i%2==1)
						System.out.println(i + " ");
						Thread.sleep(10); //0.1초간 잠을 잔다.
				}
			} catch (InterruptedException e2) {
			}
			
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		System.out.println("main 종료");
		
		
		Task t3 = new Task();
		Task t4 = new Task();
		
		t3.start();
		t4.start();
		System.out.println("End "+Thread.currentThread().getName());
		t1.join();
		t2.join();
	}
}

class Task extends Thread{
	@Override
	public void run() {
	    int n1 = 10;
	    int n2 = 20;
	    String name = Thread.currentThread().getName();
	    System.out.println(name + ": "+(n1+n2));
	}
}



class Counter{
	int count = 0; //공유되는 변수
	
	public void increment() {
		count++; //첫 번째 쓰레드에 의해 실행
	}
	public void decrement() {
		count--;// 또 다른 쓰레드에 의해 실행
	}
	public int getCount() {
		return count;
	}
}
