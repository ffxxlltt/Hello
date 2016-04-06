package com.multithread.wait;
//import java.lang.InterruptedException;

public class MyThreadPrinter2 implements Runnable {
	private String name;
	private Object prev;
	private Object self;

	private MyThreadPrinter2(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	public void run() {
		int count = 5;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.println(name);
					count--;
					self.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
		MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
		MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);

		Thread ma, mb, mc;

		System.out.println("Start...");
		ma = new Thread(pa);
		ma.start();
		Thread.sleep(10);
		mb = new Thread(pb);
		mb.start();
		Thread.sleep(10);
		mc = new Thread(pc);
		mc.start();
		Thread.sleep(10);
		ma.join();
		mb.join();
		mc.join();
		System.out.println("End.");

	}

}
