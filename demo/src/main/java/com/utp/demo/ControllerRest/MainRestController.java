package com.utp.demo.ControllerRest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainRestController {
    
    @GetMapping("/main")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
