package com.job.multi.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddPrinter {
    private int count = 1;
    private static final int MAX_COUNT = 20;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition even = lock.newCondition();
    private final Condition odd = lock.newCondition();

    public void printOdd() {
        while (true) {
            try {
                lock.lock();
                while (count <= MAX_COUNT && count % 2 == 0) {
                    odd.await();
                }
                if (count > MAX_COUNT) {
                    even.signal(); // Wake the even thread in case it's waiting
                    break;
                }
                System.out.println("Odd: " + count);
                count++;
                even.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() {
        while (true) {
            try {
                lock.lock();
                while (count <= MAX_COUNT && count % 2 != 0) {
                    even.await();
                }
                if (count > MAX_COUNT) {
                    odd.signal(); // Wake the odd thread in case it's waiting
                    break;
                }
                System.out.println("Even: " + count);
                count++;
                odd.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EvenOddPrinter printer = new EvenOddPrinter();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(printer::printOdd);
        executor.submit(printer::printEven);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("All tasks completed.");
    }
}
