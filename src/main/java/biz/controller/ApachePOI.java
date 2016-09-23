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

    @ResponseBody
    @RequestMapping("/export")
    public void export(HttpServletRequest request) throws Exception{
        String Url = (String) request.getAttribute("filrUrl");
        apachePOIService.getAll(Url);
    }

    @ResponseBody
    @RequestMapping("importFromExcel")
    public void importFromExcel() throws Exception{
        apachePOIService.importFromExcel(fileUrl);
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
