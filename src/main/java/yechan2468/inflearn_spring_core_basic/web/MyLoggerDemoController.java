package yechan2468.inflearn_spring_core_basic.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yechan2468.inflearn_spring_core_basic.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class MyLoggerDemoController {

    private final MyLoggerDemoService myLoggerDemoService;
    private final MyLogger myLogger;  // request scoped bean이므로, 주입 시점에 터져버림

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller");
        myLoggerDemoService.logic();

        return "OK";
    }
}
