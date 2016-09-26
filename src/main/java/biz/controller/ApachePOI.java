package biz.controller;

import biz.service.ApachePOIService;
import biz.service.impl.ApachePOIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Knight_JXNU on 2016/9/22.
 */
@Controller
@RequestMapping(value = "/apachepoi")
public class ApachePOI {

    @Autowired
    ApachePOIServiceImpl apachePOIService;

    private String fileUrl = "C:/Users/MW/Desktop/student.xlsx";

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/export")
    public String export(String filrUrl1) throws Exception{
        apachePOIService.getAll(filrUrl1);
        return "/hello";
    }

    @RequestMapping("importFromExcel")
    public String importFromExcel(String fileUrl2) throws Exception{
        apachePOIService.importFromExcel(fileUrl2);
        return "/hello";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public void insertStuden(){
        apachePOIService.insert();
    }

    @ResponseBody
    @RequestMapping("/view")
    public String showView() {
        return "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>View</title></head><body><input type='button' value='test'></body></html>";
    }

}
