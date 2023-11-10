package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Slf4j
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring";

        System.out.println("name = " + name);

        //사용하지도 않는 로그를 찍을때 + 연산자를 사용시, 연산이 일어나면서 메모리를 사용하고 cpu 도 사용하게된다.
        // 즉 쓸모없는 리소스를 잡아먹게 된다.
        // 사용하지 않는 로그를 찍을때 name을 파라미터로 인식하고 호출을할때 trace 레벨은 호출하지 않는다는 설정을 확인하고
        // 로직을 중단한다.
        log.info("info log=" + name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
