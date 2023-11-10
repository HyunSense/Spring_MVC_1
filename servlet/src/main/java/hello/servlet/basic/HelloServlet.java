package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");

        System.out.println("request = " + request);
        System.out.println("response = " + response);
//        request = org.apache.catalina.connector.RequestFacade@64bb0f2d
//        response = org.apache.catalina.connector.ResponseFacade@28c57a60
        // Re..Facade는 Tomcat, Jetty, Undertow 등등 was 서버들이 표준스팩 구현체

        // 쿼리파라미터 조회
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // header 정보에 들어감
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain; UTF-8");

        // http Body부에 들어감
        response.getWriter().write("hello " + username);
    }
}
