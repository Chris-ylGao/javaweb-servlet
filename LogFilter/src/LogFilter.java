import java.io.IOException;

public class LogFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("web Link: http://www.googole.com");
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        //get and print initialize parameter
        String site = config.getInitParameter("Site");
        System.out.println("Web: " + site);
    }

}
