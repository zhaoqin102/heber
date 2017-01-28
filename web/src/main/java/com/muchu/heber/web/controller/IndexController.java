package com.muchu.heber.web.controller;

import ch.qos.logback.core.net.JMSAppenderBase;
import com.muchu.heber.web.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping
    public ModelAndView index() {
        logger.info("接到请求");
        return new ModelAndView("index");
    }

    @GetMapping("update")
    public ModelAndView sessionApi(WebRequest request) {
        request.setAttribute("user", "name", RequestAttributes.SCOPE_SESSION);
        return new ModelAndView("update");
    }

    @GetMapping("session")
    public Object getUser(WebRequest request) {
        return request.getAttribute("user", RequestAttributes.SCOPE_SESSION);
    }

}
