package com.job.multi;

public class NumberSequence {
    private int startNumber = 1;
    private final int endNumber;
    private final int numberOfThreads;

    public NumberSequence(int startNumber, int endNumber, int numberOfThreads){
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.numberOfThreads = numberOfThreads;
    }

    public synchronized void  printNumber(int threadId){
        while (true){
            System.out.println("startNumber: "+ startNumber+ " threadId: " +threadId +" modules: "+ ((startNumber-1) % numberOfThreads)  +" threadName: "+Thread.currentThread().getName() +" "+((startNumber-1) % numberOfThreads != threadId));
            while(startNumber<= endNumber && (startNumber-1) % numberOfThreads != threadId){
                System.out.println(Thread.currentThread().getName() +" : going to waiting.");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println(e.getLocalizedMessage());
                }
                System.out.println(Thread.currentThread().getName() +" : resumed from waiting.");
            }
            if(startNumber > endNumber) break;
            System.out.println(Thread.currentThread().getName() +" : "+ startNumber);
            startNumber++;
            notifyAll();
        }
    }

    public synchronized void printNumberV1(int remainder) {
        while (true) {
            // Exit condition first: end processing if all numbers are printed
            if (startNumber > endNumber) {
                notifyAll(); // Wake up any waiting threads so they can exit too
                break;
            }
            // Check if it's this thread's turn to print
            if ((startNumber - 1) % numberOfThreads != remainder) {
                try {
                    wait(); // Not this thread's turn, wait
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            } else {
                // It's this thread's turn
                System.out.println(Thread.currentThread().getName() + " : " + startNumber);
                startNumber++;         // Increment the shared number
                notifyAll();          // Wake up all threads to recheck their turn
            }
        }
        // Optional: log thread termination
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}
