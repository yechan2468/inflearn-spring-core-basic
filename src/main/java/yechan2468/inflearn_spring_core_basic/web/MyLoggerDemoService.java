package yechan2468.inflearn_spring_core_basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import yechan2468.inflearn_spring_core_basic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class MyLoggerDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic() {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service");
    }
}
