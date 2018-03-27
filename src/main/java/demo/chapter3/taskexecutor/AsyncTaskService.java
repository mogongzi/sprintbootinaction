package demo.chapter3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.out.println("Start Async Task: " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("Start Async Task + 1: " + (i + 1));
    }
}
