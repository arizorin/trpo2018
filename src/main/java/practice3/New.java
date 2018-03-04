package practice3;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class New extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        DAO dao = new DAO();
        user.setLogin(req.getParameter("Login"));
        user.setPassword(req.getParameter("Password"));
        user.setRole(req.getParameter("Role"));
        dao.addUser(user);
        PrintWriter out = resp.getWriter();
        out.print("Пользователь со значениями:" + user.toString() + "был успешно добавлен!");
    }

}
