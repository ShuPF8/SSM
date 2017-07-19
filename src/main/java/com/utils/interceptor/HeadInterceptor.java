package com.utils.interceptor;

import com.controller.mail.MailController;
import com.utils.BaseUtils;
import com.utils.common.AES;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * Created by IntelliJ IDEA
 * <p>〈〉 </p>
 * 〈〉
 *
 * @author linxm
 * @date 2017/5/4
 * @time 19:05
 * @version 1.0
 */
@Component
public class HeadInterceptor implements HandlerInterceptor{
    private static final Logger logger = Logger.getLogger(MailController.class);
    private ThreadLocal<Long> requestTime = new ThreadLocal<Long>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("===================>请求地址"+request.getRequestURI()+"开始");
        requestTime.set(System.currentTimeMillis());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        long statTime = requestTime.get().longValue();
        long endTime = System.currentTimeMillis();
        logger.info("===================>请求地址"+request.getRequestURI()+"结束,耗时===>"+(endTime - statTime)+"ms");
    }
}
