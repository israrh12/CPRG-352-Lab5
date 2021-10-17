/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author owner-pc
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesh = request.getSession();
        if(sesh.getAttribute("users") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }else{
            String logOff = request.getParameter("logoff");
            if(logOff != null){
                request.setAttribute("logout", "Logged Off");
                sesh.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }else{
                response.sendRedirect("home");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesh = request.getSession();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        User u = new User(user, pass);
        AccountService val = new AccountService();
        
        if(user != "" && pass != ""){
            if (val.login(user, pass) != null){
                sesh.setAttribute("users", u);
                response.sendRedirect("home");
                return;
            }else{
                request.setAttribute("error", "Failed Authentication");
                request.setAttribute("username", user);
                request.setAttribute("password", pass);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
        }else{
            request.setAttribute("error", "Failed Authentication");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
    }


}
