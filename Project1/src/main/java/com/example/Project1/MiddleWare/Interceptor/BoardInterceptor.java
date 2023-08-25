package com.example.Project1.MiddleWare.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Component;

@Component
public class BoardInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("USER");

        System.out.println("Prehandle Start");
        System.out.println("User stats now ... " + user);

        // 유저 정보 확인.
        // 유저 정보가 GUEST라면 로그인으로 보낸다.
        // 만약 GUEST가 아니라면 계속 진행.
        if(user.equals("GUEST")) {
            System.out.println("No Authorization");
            response.sendRedirect("/api/login");
            return false;
        }
        return true;  // 인증 및 권한이 유효한 경우 요청 계속 진행
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
