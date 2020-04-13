package ThreadTest;

public class ThreadTest1 {
	
	public static void main(String[] args) {
		
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
