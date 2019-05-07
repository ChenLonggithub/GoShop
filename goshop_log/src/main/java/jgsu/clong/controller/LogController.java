package jgsu.clong.controller;

import jgsu.clong.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("log")
    public String log(String message,String id){
        logService.insertLog(message,id);
        return "main";
    }
}
