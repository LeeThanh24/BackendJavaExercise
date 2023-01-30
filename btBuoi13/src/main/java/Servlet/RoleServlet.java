package Servlet;

import service.RoleTableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name= "Role Servlet" ,urlPatterns = {"/roles","/roles/add"})
public class RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleTableService roleTableService = new RoleTableService();
//        for (RolesModel item : roleTableService.printAllRoles()
//             ) {
//            System.out.println( item.getName()+" - " +item.getDescription() );
//        }

        req.setAttribute("ListRoles",roleTableService.printAllRoles());
        //System.out.println(roleTableService.printAllRoles().size());
        System.out.println("hello role add ");
        req.getRequestDispatcher("role-table.jsp").forward(req,resp);
    }
}
