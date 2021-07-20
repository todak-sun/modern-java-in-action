package io.todak.study.modernjavainaction.ch02;

import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        String s = threadName.get();

        System.out.println(s);
    }

}
