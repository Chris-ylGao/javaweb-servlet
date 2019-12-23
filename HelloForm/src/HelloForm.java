import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloForm extends javax.servlet.http.HttpServlet {
    private static final long serialVersionID = 1L;


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.  create cookie for name and url
        Cookie name = new Cookie ("name",request.getParameter("name"));
        Cookie url = new Cookie("url", request.getParameter("url"));
        //2. set max expire time as 24 hrs;
        // the unit of setMaxAge() is second;
        name.setMaxAge(60*60*24);
        url.setMaxAge(60*60*24);
        //3. add cookie to the header of request
        response.addCookie(name);
        response.addCookie(url);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Example of setting Cookie";
        //String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String docType = "<!DOCTYPE html> \n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Web Name</b>："
                + request.getParameter("name") + "\n" +
                "  <li><b>Web Link</b>："
                + request.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
doGet(request, response);
    }

}
