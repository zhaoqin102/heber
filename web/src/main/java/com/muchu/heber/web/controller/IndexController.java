package com.muchu.heber.web.controller;

import com.muchu.heber.web.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger("jms");

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping
    public ModelAndView index() {
        logger.info("接到请求");
        indexService.index();
        return new ModelAndView("index");
    }

    @RequestMapping("update")
    public ModelAndView update(boolean isSleep, String password) {
        logger.info("接到请求");
        indexService.update(isSleep, password);
        return new ModelAndView("update");
    }
}
