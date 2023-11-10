package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    // 반환타입이 String이라 ViewResolver가 해당 뷰를 찾게된다.
    // 문자열로 작성을 하고싶다면 클래스 단위에 @RestController를 사용해도 되지만
    // 메서드내에서도 @ResponseBody 를 작성하여 문자열을 반환시킬 수 있다.
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);

        return "ok";

    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String userName,
            @RequestParam int age) {
        log.info("username={}, age={}", userName, age);

        return "ok";

    }

    @ResponseBody
    @RequestMapping("/request-param-v4") // String, int, Integer 등의 단순 타입이면 @RequestParam 생략가능
    public String requestParamV4(String userName, int age) {
        log.info("username={}, age={}", userName, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required") // String, int, Integer 등의 단순 타입이면 @RequestParam 생략가능
    public String requestParamRequired(
            @RequestParam(required = true) String userName,
            @RequestParam(required = false) int age) { // required false 에서 int는 기본형이기때문에 null 못받음
        log.info("username={}, age={}", userName, age); // Integer age로 해줘야 한다.

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault( // defaultValue 가있으면 사실 required 속성이 필요없음
            @RequestParam(required = true, defaultValue = "guest") String userName, // defaultValue는 빈문자열도 처리해준다.
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username={}, age={}", userName, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
//        log.info("helloData={}", helloData);
//
//
//        return "ok";
//    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok";
    }
}
