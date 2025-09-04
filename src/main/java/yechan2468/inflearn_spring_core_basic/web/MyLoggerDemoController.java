package yechan2468.inflearn_spring_core_basic.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yechan2468.inflearn_spring_core_basic.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class MyLoggerDemoController {

    private final MyLoggerDemoService myLoggerDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller");
        myLoggerDemoService.logic();

        return "OK";
    }
    /*
    [8f4db798-e89c-452e-8627-f3082ab7ec69] init MyLogger yechan2468.inflearn_spring_core_basic.common.MyLogger@75b22f31
    [8f4db798-e89c-452e-8627-f3082ab7ec69] [http://localhost:8080/log-demo] controller
    [8f4db798-e89c-452e-8627-f3082ab7ec69] [http://localhost:8080/log-demo] service
    [8f4db798-e89c-452e-8627-f3082ab7ec69] close MyLogger yechan2468.inflearn_spring_core_basic.common.MyLogger@75b22f31
     */
}
