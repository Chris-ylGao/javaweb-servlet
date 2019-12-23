import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.*;

public class DatabaseAccess extends javax.servlet.http.HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "gaoyl1996";
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "Servlet Mysql";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try{
            // register JDBC driver
            Class.forName(JDBC_DRIVER);

            // connect to database with url,username,pw

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //execute mysql query
            stmt =  conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";//sql query
            //using resultSet to store result
            ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);


            while(rs.next()){
                // searching keywords
                //getINt()
                //getString()
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                // 输出数据
                out.println("ID: " + id);
                out.println(", web name: " + name);
                out.println(", web URL: " + url);
                out.println("<br />");
            }
            out.println("</body></html>");
            // closing resultSet and connection  after executing
            rs.close();
            ((java.sql.Statement) stmt).close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) ((java.sql.Statement) stmt).close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
