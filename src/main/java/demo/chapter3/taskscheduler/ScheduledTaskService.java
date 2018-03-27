package demo.chapter3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 20000)
    public void reportCurrentTime() {
        System.out.println("Every 20 seconds run: " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 18 12 ? * *")
    public void fixTimeExecution() {
        System.out.println("appointed time: " + dateFormat.format(new Date()) + " run");
    }
}
