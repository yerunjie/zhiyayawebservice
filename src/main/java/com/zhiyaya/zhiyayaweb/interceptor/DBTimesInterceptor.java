package com.zhiyaya.zhiyayaweb.interceptor;

import com.zhiyaya.zhiyayaweb.aspect.DBAccessAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yerunjie
 */
@Service("dbTimesInterceptor")
public class DBTimesInterceptor extends BaseInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DBTimesInterceptor.class);

    @Autowired
    private DBAccessAspect dbAccessAspect;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        logger.info("all db access times: " + dbAccessAspect.getTimes());
        super.afterCompletion(request, response, handler, ex);
    }
}