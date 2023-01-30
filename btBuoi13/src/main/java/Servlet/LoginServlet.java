package Servlet;

import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet (name=  "Login Servlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



//
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookiee : cookies
//             ) {
//            if (cookiee.getName().equals("username"))
//            {
//                System.out.println(cookiee.getValue());
//            }
//        }

//        HttpSession session = req.getSession();
//        session.setMaxInactiveInterval(8*3600);
//        System.out.println((session.getAttribute("username") ==null)?"the username is now null":("the username is not null and the value is "+(String)session.getAttribute("username")));
//        session.setAttribute("username" , "thanh@gmail.com");
//        session.setAttribute("password" , "123456");
        //System.out.println(data);



        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

//        HttpSession session = req.getSession();
//        session.setMaxInactiveInterval(8*3600);
//        String emailSession = (String) session.getAttribute("username");
//        String passSession  = (String) session.getAttribute("password");

        boolean isSuccess = (new LoginService()).checkLogin(email , password);
        //boolean isSuccess = (email.equals(emailSession) && password.equals(passSession)) ;
        if (isSuccess)
        {
            Cookie cookiee = new Cookie("email" , URLEncoder.encode( email, "UTF-8" ));

            cookiee.setMaxAge(8*3600);
            resp.addCookie(cookiee);
            resp.sendRedirect(req.getContextPath()+"/roles");

        }else
        {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        System.out.println("Login "+((isSuccess ) ?"successfully" :"unscucessfully") );
    }
}
