package moe.nijigen.studentscore.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username=request.getSession().getAttribute("token");
        if(username==null){
            System.out.println("未登录!");
            request.setAttribute("loginMsg","未授权访问，请登录！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            return true;
        }


    }
}
