import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCookie extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies =null;
        cookies = request.getCookies();

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Example of Delete Cookie";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );
        //steps of delete cookie
        //1. get the cookie to be deleted
        //2. setMaxAge(0)
        //3. add this cookie to header of response
        if( cookies != null ){
            out.println("<h2>Cookie Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++){
                //1.
                cookie = cookies[i];
                if((cookie.getName( )).compareTo("url") == 0 ){
                    //2.
                    cookie.setMaxAge(0);
                    //3.
                    response.addCookie(cookie);
                    out.print("Deleted cookie：" +
                            cookie.getName( ) + "<br/>");
                }
                out.print("Name：" + cookie.getName( ) + "，");
                out.print("Value：" + cookie.getValue( )+" <br/>");
            }
        }else{
            out.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
