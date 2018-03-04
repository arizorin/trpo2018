package practice3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        DAO dao = new DAO();
        user.setLogin(req.getParameter("Login"));
        dao.deleteUser(user);
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("User:" + req.getParameter("Login") + "deleted!");
        out.print("<a href=\"javascript:history.back()\">Back</a>");
        out.print("</body></html>");
    }
}
