package com.utils.interceptor;

import com.controller.mail.MailController;
import com.utils.BaseUtils;
import com.utils.common.AES;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
public class SignInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(MailController.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Map<String, Object> map = BaseUtils.getParamMap(request);
        Object osign = map.get("sign");
        if (osign == null) {
            return false;
        }
        map.put("xm-name","SSM");
        map.put("dev-name","spf");
        map.remove("sign");
        String str = BaseUtils.createLinkString(map);
        String key = "abcdefgabcdefg12";
        String sign = AES.encryptToBase64(str,key);

        if (!sign.equals(osign.toString())) {
            logger.info("===================>签名验证失败<========================");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
