package org.wavemaker.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
public class UserAuthentication implements Filter {
    public void init(FilterConfig arg0) throws ServletException {

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;
        HttpSession existingSession=httpServletRequest.getSession(false);
        if(existingSession!=null){
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
        else{
            PrintWriter out=httpServletResponse.getWriter();
            out.print("User is not logged in! Login is Needed");
        }
    }
    public void destroy() {

    }
}
