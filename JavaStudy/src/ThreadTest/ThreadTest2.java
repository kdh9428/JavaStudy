package ThreadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest2 {
	public static List<Integer> list = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) throws InterruptedException {

		Task1 t1 = new Task1();
		Task1 t2 = new Task1();
		
		System.out.println("End "+Thread.currentThread().getName());
		
		Runnable task2 = () ->{
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : "+(n1+n2));
		};
		ExecutorService exr = Executors.newSingleThreadExecutor();
		exr.submit(task2);
		System.out.println("End "+ Thread.currentThread().getName());
		exr.shutdown();
		
		Runnable task3 = () ->{
			System.out.println("==============================================");
			String name = Thread.currentThread().getName();
			System.out.println(name + " : "+(7+5));
		};
		Runnable task4 = () ->{
			String name = Thread.currentThread().getName();
			System.out.println(name + " : "+(7-5));
		};
		ExecutorService exr1 = Executors.newFixedThreadPool(2);
		exr1.submit(task3);
		exr1.submit(task4);
		exr1.submit(()->{
			String name = Thread.currentThread().getName();
			System.out.println(name + " : "+(5*7));
		});
		exr1.shutdown();
		
		for(int i = 0; i < 16; i++)
			list.add(i);
		System.out.println(list);
		
		Runnable task5 = ()->{
//			synchronized (list) {
				ListIterator<Integer> itr = list.listIterator();
				while(itr.hasNext())
					itr.set(itr.next()+1);
//			}
		};
		ExecutorService exr3 = Executors.newFixedThreadPool(3);
		exr3.submit(task5);
		exr3.submit(task5);
		exr3.submit(task5);

		exr3.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(list);
	}
}

class Task1 extends Thread{
	
	@Override
	public void run() {
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : "+(n1+n2));
	}
}


class Counter1 {
	int count = 0;
	synchronized public void increment() {
		count++;
	}
	
	public void decrement() {
		
	synchronized(this) {
		count--;
		}
	}
	
	public int getCount() {
		return count;
	}
}

