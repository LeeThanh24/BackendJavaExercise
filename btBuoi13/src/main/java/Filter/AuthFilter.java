package Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/roles")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            boolean isLogin = false ;
            for (Cookie cookie : cookies) {
                if ("email".equals(cookie.getName())) {
                    isLogin = true ;
                    break;

                }
            }
            if (isLogin==true )
            {
                filterChain.doFilter(request, response);
            }else
            {
                response.sendRedirect(request.getContextPath() + "/login");

            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}

