package org.takeback.mvc.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/12/18.
 */
public class AdminboardFilter extends OncePerRequestFilter {

    public static boolean systemInitialized = true;

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if(!systemInitialized){
            response.setContentType("text/html;charset=gbk");
            PrintWriter pw = response.getWriter();
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<h2 align='center'>初始化</h2>");
            pw.println("<form action=initSystem method=post>");
            pw.println("管理员帐号:<input type=text name=username><br>");
            pw.println("管理员密码:<input type=password name=passwd><br>");
            pw.println("重复密码:<input type=password name=repasswd><br>");
            pw.println("<input type=submit value=确定><br>");
            pw.println("</form>");
            pw.println("<body/>");
            pw.println("<html/>");
        }else{
            filterChain.doFilter(request,response);
        }
    }

}
