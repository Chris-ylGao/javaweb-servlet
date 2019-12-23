import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Refresh extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setIntHeader("Refresh",5);
        response.setContentType("text/html;charset=UTF-8");
        //get current systematic time
        Calendar cale = Calendar.getInstance();
        Date currentTime = cale.getTime();
        // restrict output format
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
        String nowTime = df.format(currentTime);

        //set html page
        PrintWriter out = response.getWriter();
        String title = "Refresh page in 5 seconds";
        String docType =
                "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + nowTime + "</p>\n");

    }
}
