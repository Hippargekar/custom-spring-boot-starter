package com.job.multi;

public class TaskOddEven implements Runnable {
    private NumberSequence numberSequence;
    private int threadId;

    public TaskOddEven(NumberSequence numberSequence, int threadId) {
        this.numberSequence = numberSequence;
        this.threadId = threadId;
    }

    @Override
    public void run() {
       numberSequence.printNumberV1(threadId);
    }
}
