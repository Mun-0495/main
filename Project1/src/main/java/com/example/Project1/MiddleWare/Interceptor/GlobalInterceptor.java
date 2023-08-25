package com.example.Project1.MiddleWare.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Component;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = (String)request.getSession().getAttribute("USER");
        
        //세션에 현재 정보가 없다면은 세션에 GUEST를 할당해준다. 
        //근데 만약 null이 아닌데 GUEST가 아니다? 유저라는 뜻.
        //유저면 로그인이고 사인업이고 뭐고 바로 보드로 보내버린다.
        if(user == null) {
            request.getSession().setAttribute("USER", "GUEST");
        } else if(!user.equals("GUEST")) {
            response.sendRedirect("re:direct/home");
            return false;  // 인증 및 권한이 유효한 경우 요청 계속 진행
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 요청 처리 후 호출되는 메서드
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // 응답 처리 후 호출되는 메서드
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
