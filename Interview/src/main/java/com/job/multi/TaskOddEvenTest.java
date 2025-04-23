package com.job.multi;

public class TaskOddEvenTest {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        NumberSequence numberSequence = new NumberSequence(1, 9, numberOfThreads);
        for (int index = 0 ; index < numberOfThreads; index++){
            int threadId = index;
            new Thread(new TaskOddEven(numberSequence, threadId), "TH-"+ threadId).start();
        }
    }
}
