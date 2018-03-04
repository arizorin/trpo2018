package practice3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Update extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        DAO dao = new DAO();
        dao.Update(req.getParameter("Login"),req.getParameter("Password"),req.getParameter("Role"));
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("User updated!");
        out.print("<a href=\"javascript:history.back()\">Back</a>");
        out.print("</html></body>");
        }

}
