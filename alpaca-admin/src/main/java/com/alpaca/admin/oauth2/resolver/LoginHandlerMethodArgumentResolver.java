package com.alpaca.admin.oauth2.resolver;

import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.oauth2.annotation.LoginUser;
import com.alpaca.admin.oauth2.interceptor.AuthorizationInterceptor;
import com.alpaca.admin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @ClassName: LoginHandlerMethodArgumentResolver
 * @Description: TODO
 * @Author：song
 * @Date: 2018/11/24 19:10
 * @Version: 1.0.0
 */
@Component
public class LoginHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private ISysUserService sysUserService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SysUser.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取用户ID
        Object object = request.getAttribute(AuthorizationInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if(object == null){
            return null;
        }

        //获取用户信息
        SysUser user = sysUserService.getById((String)object);

        return user;
    }
}
