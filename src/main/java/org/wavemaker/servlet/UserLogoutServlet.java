package org.wavemaker.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
public class UserLogoutServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException{
        HttpSession existingSession=httpServletRequest.getSession(false);
        if(existingSession!=null){
            existingSession.invalidate();
        }
        PrintWriter out = httpServletResponse.getWriter();
        out.print("User Logout Successfully");
    }
}
