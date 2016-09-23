package biz.controller;

import biz.service.ApachePOIService;
import biz.service.impl.ApachePOIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Knight_JXNU on 2016/9/22.
 */
@Controller
@RequestMapping(value = "/apachepoi")
public class ApachePOI {

    @Autowired
    ApachePOIServiceImpl apachePOIService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/export")
    public void export(){
        apachePOIService.getAll();
    }

}
