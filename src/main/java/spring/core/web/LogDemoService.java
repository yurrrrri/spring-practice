package spring.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.core.common.MyLogger;

@RequiredArgsConstructor
@Service
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }

}