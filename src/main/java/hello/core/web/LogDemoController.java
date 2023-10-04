package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//        private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;

    @RequestMapping("/log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String reqUrl = request.getRequestURL().toString();
        System.out.println("reqUrl = " + reqUrl);
//        MyLogger myLogger = myLoggerObjectProvider.getObject();
        System.out.println("class : " + myLogger.getClass());;
        myLogger.setRequestUrl(reqUrl);

        Thread.sleep(1000);

        myLogger.log("log controller test");

        logDemoService.logic("testId");

        return "OK";

    }
}
