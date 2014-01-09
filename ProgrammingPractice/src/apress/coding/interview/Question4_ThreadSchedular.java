package apress.coding.interview;

import javax.sql.rowset.spi.SyncResolver;

/**
 * 
 * @author rohitkondekar
 * 
 * Question 4 There are three threads in a process. The first thread prints 1 1 1 ..., the second one prints 2 2 2 ..., 
 * and the third one prints 3 3 3 ... endlessly. How do you schedule these three threads in order to print 1 2 3 1 2 3 ...?
 *
 * Need to use synchonization
 * Java defines methods wait, notify, and notifyAll in the base class Object. 
 * The method wait is used when a thread is waiting for some condition that is typically controlled by another thread. It allows us to
 * put a thread to sleep while waiting for the condition to change, and the thread will be wakened up when a notify or notifyAll occurs.
 *  
 */

public class Question4_ThreadSchedular {
	
	public class SimpleThread extends Thread {
		private int value;
		
		SimpleThread(int num){
			value=num;
			start();
		}
		
		public void run(){
			while(true){
				synchronized (this) {
					try{
						wait();
					}catch(InterruptedException e){
						throw new RuntimeException(e);
					}
					System.out.print(value+" ");
				}
			}
		}
	}
	
	static final int count=7;
	static final int sleep=35;
	
	public static void main(String[] args) throws InterruptedException {

		Question4_ThreadSchedular q4 = new Question4_ThreadSchedular();
		SimpleThread[] th = new SimpleThread[count];
		for(int i=0;i<count;i++)
			th[i] = q4.new SimpleThread(i+1);
		
		int index=0;
		while(true)
		{
			synchronized (th[index]) {
				th[index].notify();
			}
			Thread.sleep(sleep);
			index=(++index)%count;
		}

		
	}

}
