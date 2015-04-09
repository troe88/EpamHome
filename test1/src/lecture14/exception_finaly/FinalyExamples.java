package lecture14.exception_finaly;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinalyExamples {
	public static void main(final String[] args) {
		System.out.println("start");
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			doSomething();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("unlock()");
			lock.unlock();
		}
		System.out.println("finish");
	}

	private static void doSomething() {
		System.out.println("do...");
		throw new RuntimeException();
	}
}
