package org.wavemaker.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
public class UserLoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String userName = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        if (userName.equals("root") && password.equals("Pramati@123")) {
            HttpSession existingSession = httpServletRequest.getSession(false);
            if (existingSession != null) {
                existingSession.invalidate();
            }
            HttpSession newSession = httpServletRequest.getSession(true);
            newSession.setMaxInactiveInterval(10*60);
            PrintWriter out=httpServletResponse.getWriter();
            out.print("User Login Successfully");
        }
        else {
            PrintWriter out = httpServletResponse.getWriter();
            out.print("Credentials are Not matched");
        }
    }
}
