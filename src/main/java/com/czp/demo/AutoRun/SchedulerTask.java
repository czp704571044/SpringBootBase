package com.czp.demo.AutoRun;

import com.czp.demo.Util.myUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling // 2.开启定时任务*/
public class SchedulerTask {    //定时任务

    private int count=0;


    @Scheduled(cron="*/6 * * * * ?")
    private void process(){

    }
}
