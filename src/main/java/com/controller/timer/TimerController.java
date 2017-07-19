package com.controller.timer;

import com.utils.BaseUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author SPF
 * @Date 2017/5/27
 */
@Component
public class TimerController extends BaseUtils{

    public void job() {
        task();
    }

    public void task() {
        System.out.println("timer");
    }

}
