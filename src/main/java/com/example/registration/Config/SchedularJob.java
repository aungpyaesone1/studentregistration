package com.example.registration.Config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedularJob {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Scheduled(cron = "0/5 * * ? * *")
    public void task() {
        System.out.println("Scheduler task with duration : " + sdf.format(new Date()));
    }
}
