import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionTracker extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //getSession() return the current HttpSession associated with this request or,
        // if there is ni current session and create is true, return a new session;
        HttpSession session = request.getSession(true);
        //get the time when session was created
        Date createTime = new Date(session.getCreationTime());
        //get the time when the session was accessed recently
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
        String title = "Servlet Session Tracker";
        Integer visitCount = new Integer(0);
        String visitCountKey = new String("visitCount");
        String  userIDKey = new String("userID");
        String userID = new String("gyl");
        //getAttribute() return the value of the named attribute as an object, or null id no attribute if given name exists;
        if (session.getAttribute(visitCountKey) == null){
            session.setAttribute(visitCountKey, new Integer(0));
        }

        if (session.isNew()){
            title = "Servlet Session Tracker";
            session.setAttribute(userIDKey, userID);
        }else{
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount += 1;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session Information</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "  <th>Session Information</th><th>Values</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>Create Time</td>\n" +
                "  <td>" +  df.format(createTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>Last Access Time</td>\n" +
                "  <td>" + df.format(lastAccessTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>User ID</td>\n" +
                "  <td>" + userID +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>Access Count：</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>");
    }
}

