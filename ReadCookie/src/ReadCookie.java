import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

public class ReadCookie extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Cookie cookie =null;
        Cookie[] cookies = null; // to store the request's cookies
        cookies = request.getCookies();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "Adding cookie Example";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );
        if( cookies != null ){
            out.println("<h2>Cookies and Values</h2>");
            // for loop to print cookies and values
            //getName() to get name of cookie
            //getValue() to get value of cookie
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                out.print("Name：" + cookie.getName( ) + "，");
                out.print("Value：" +  cookie.getValue());
            }
        }else{
            out.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");

    }
}
