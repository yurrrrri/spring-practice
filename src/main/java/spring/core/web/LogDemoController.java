package spring.core.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.core.common.MyLogger;

@RequiredArgsConstructor
@Controller
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        myLogger.setRequestUrl(requestUrl);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }

}