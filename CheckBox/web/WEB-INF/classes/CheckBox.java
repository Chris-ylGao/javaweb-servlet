import java.io.IOException;
import java.io.PrintWriter;

public class CheckBox extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // set the content type
        //text/html
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "Reading CheckBox";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Google symbol：</b>: "
                + request.getParameter("google") + "\n" +
                "  <li><b>Facebook symbol：</b>: "
                + request.getParameter("facebook") + "\n" +
                "  <li><b>Github symbol：</b>: "
                + request.getParameter("github") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
    }

