package com.muchu.heber.web.service;

import com.muchu.heber.web.exception.FileNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 梁海鹏
 * @createdate 16-12-11 下午10:10
 */
@Service
public class FileService {

    private final ServletContext servletContext;

    private Logger logger = LoggerFactory.getLogger(FileService.class);

    @Autowired
    public FileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public Resource loadFile(String fileName) {
        ServletContextResource resource = new ServletContextResource(servletContext, fileName);
        if (!resource.exists())
            throw new FileNotFound(fileName);
        return resource;
    }

    public void store(MultipartFile file) {
        Path resource = Paths.get("/home/zhaoqin102/" + file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), resource);
        } catch (IOException e) {
            logger.error("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
}
