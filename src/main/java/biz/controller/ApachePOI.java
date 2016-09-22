package biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Knight_JXNU on 2016/9/22.
 */
@Controller
@RequestMapping(value = "/apachepoi")
public class ApachePOI {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/export")
    public String export(){
        
    }

}
