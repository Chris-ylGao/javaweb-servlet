import java.io.IOException;
import java.io.PrintWriter;

public class ErrorHandler extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //javax.servlet.error.exception give message when Exception happened
        // can be stored in java.lang.Throwable
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        //javax.servlet.error.status_code gives status code
        // can be store in the java.lang.Integer
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        //javax.servlet.error.servlet_name give servlet name
        // can be stored in the java.lang.String
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null){
            servletName = "Unknown";
        }
        //javax.servlet.error.request_uri gives information of url operation
        // can be stored and analysed in java.lang.String
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null){
            requestUri = "Unknown";
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Error/Exception";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        out.println("<h1>Test of Error Handler</h1>");
        if (throwable == null && statusCode == null){
            out.println("<h2>Error Message Lose</h2>");
            out.println("Please return to page <a href=\"" +
                    response.encodeURL("http://localhost:8080/") +
                    "\">Main Page</a>。");
        }else if (statusCode != null) {
            out.println("Error Code : " + statusCode);
        }else{
            out.println("<h2>Error Message</h2>");
            out.println("Servlet Name : " + servletName +
                    "</br></br>");
            out.println("Exception Type : " +
                    throwable.getClass( ).getName( ) +
                    "</br></br>"); //get the exception type
            out.println("Request URI: " + requestUri +
                    "<br><br>");
            out.println("Exception Message: " +
                    throwable.getMessage( ));//get the message of specified Exception;
        }
        out.println("</body>");
        out.println("</html>");

    }
}
