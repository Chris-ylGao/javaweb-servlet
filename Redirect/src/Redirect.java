import java.io.IOException;

public class Redirect extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String site = new String("http://www.google.com");
        //SC_MOVED_TEMPORARILY
        //Status code (302) indicating that the resource has temporarily moved to another location, but that future references should still use the original URI to access the resource.
        // This definition is being retained for backwards compatibility.
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}
