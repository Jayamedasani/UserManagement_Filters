package org.wavemaker.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.wavemaker.constants.PersistentType;
import org.wavemaker.manager.UserManagerFactory;
import org.wavemaker.userinterface.UserOperations;
import org.wavemaker.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class UserServlet extends HttpServlet {
    private UserOperations userManager= UserManagerFactory.getUserManager(PersistentType.MEMORY_TYPE.valueOf("DB"));
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<User> users = userManager.getUsers();
            response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
        }
        catch (NullPointerException e){
            PrintWriter out=response.getWriter();
            out.print("Null Pointer Exception raised");
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = objectMapper.readValue(request.getReader(), User.class);
        userManager.addUser(user);
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=objectMapper.readValue(req.getReader(),User.class);
        userManager.deleteUser(user.getId());
    }
}