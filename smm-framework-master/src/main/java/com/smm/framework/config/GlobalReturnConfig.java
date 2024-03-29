package com.smm.framework.config;

import com.smm.framework.exception.ServiceException;
import com.smm.framework.response.ResponseResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author CHX
 * @description Controller返回参数全局包装成ResponseResult对象
 * @date 2019-11-04
 */
/**
 * @author CHX
 * @description Controller返回参数全局包装成ResponseResult对象
 *              使用是一般需要指定basePackages，@RestControllerAdvice(basePackages = {"com.netx.web.controller"})
 *              只拦截controller包下的类；否则swagger也会拦截影响swagger正常使用
 * @date 2019-11-04
 */
@EnableWebMvc
@Configuration
@RestControllerAdvice
public class GlobalReturnConfig  implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object returnObj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(returnObj==null){ // 返回值为void
            return ResponseResult.success();
        }

        //全局异常会拦截统一封装成ResponseResult对象，因此不需要再包装了
        if(returnObj instanceof ResponseResult){
            return returnObj;
        }

        if(returnObj instanceof String){
            throw new ServiceException("Controller层暂时不支持返回String类型参数。如需返回String参数，请用ResponseResult.success(obj)方式返回");
        }

        return  ResponseResult.success(returnObj);

    }
}