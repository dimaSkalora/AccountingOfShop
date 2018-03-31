package com.shop.of.accounting.web.interceptor;

import com.shop.of.accounting.AuthorizedUser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interceptor adds the user to the model of every requests managed
 */
// Перехватчик обработчика должен реализовать интерфейс HandlerInterceptor
public class ModelInterceptor extends HandlerInterceptorAdapter {

    /*postHandle () - Вызывается после выполнения обработчика, позволяет манипулировать объектом ModelAndView,
     прежде чем отображать его для просмотра страницы.*/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty()) {
            if (AuthorizedUser.id() != 0) {
                modelAndView.getModelMap().addAttribute("user", AuthorizedUser.getUser());
            }
        }
    }
}
