package by.it.webapp.filter;


import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("In charset filter!");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
