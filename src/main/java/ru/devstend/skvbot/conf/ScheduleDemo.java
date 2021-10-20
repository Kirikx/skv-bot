package ru.devstend.skvbot.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class ScheduleDemo {

    @Scheduled(cron = "${scheduler}")
    public void scheduier() {
        log.info("scheduier");
    }

}
