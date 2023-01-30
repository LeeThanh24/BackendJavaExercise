package Filter;//package Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/login","/roles"})
//public class CustomFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies.length);
//
//            for (Cookie cookie : cookies) {
//                if ("email".equals(cookie.getName())) {
//                    filterChain.doFilter(request, response);
//
//                }
//            }
//
////            response.sendRedirect(request.getContextPath() + "/login");
////        } else {
////            response.sendRedirect(request.getContextPath() + "/login");
////        }
////
//    }
//}