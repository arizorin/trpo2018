package practice3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        DAO d = new DAO();
        d.show();
        out.print("<html><body>");
        out.print("<table border='1'");
        out.print("<tr><th>LOGIN</TH><TH>PASSWORD</TH></TR>");
        System.out.println(d.getResponse());
        out.print(d.getResponse());
        out.print("</table>");
        out.print("</body></html>");
    }

}