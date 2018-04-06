package com.shop.of.accounting.web.interceptor;

import com.shop.of.accounting.AuthorizedUser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interceptor adds the user to the model of every requests managed
 */
/*    Эти перехватчики (Interceptor) позволяют выполнять задачи, которые являются общими для каждого запроса
            или набора запросов, без необходимости копировать код в каждом методе контроллера. Например, можно выполнять
            аутентификацию пользователя прежде, чем запрос достигнет Вашего контроллера и, в случае успеха,
            получить некоторые дополнительные данные о пользователе из базы данных, добавив их в объект HttpServletRequest.
            С другой стороны, если запрос не прошел установленную Вами проверку (например, входит в список "опасных" запросов,
            похожих на хакерские) Вы можете перенаправить пользователя на другую страницу.*/
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
