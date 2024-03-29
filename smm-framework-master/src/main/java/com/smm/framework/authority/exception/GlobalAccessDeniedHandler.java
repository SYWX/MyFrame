package com.smm.framework.authority.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CHX
 * @description 鉴权异常: 认证用户访问无权限资源时的异常
 * @date 2019-11-04
 */
@Component
public class GlobalAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        responseException(httpServletResponse);
    }

    private void responseException(HttpServletResponse response) {

        Map<String,Object> exceptionMap = new HashMap(2);

        exceptionMap.put("code",403);
        exceptionMap.put("msg","认证用户访问无权限资源时的异常");

        JSONObject responseJsonObject = new JSONObject(exceptionMap);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(responseJsonObject.toString());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}