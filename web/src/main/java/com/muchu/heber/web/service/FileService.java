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

/**
 * @author 梁海鹏
 * @createTime 16-12-11 下午10:10
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

    public boolean store(MultipartFile file) {
        try {
            ServletContextResource resource = new ServletContextResource(servletContext, file.getOriginalFilename());
            Files.copy(file.getInputStream(), resource.getFile().toPath());
            return true;
        } catch (IOException e) {
            logger.error("Failed to store file " + file.getOriginalFilename(), e);
            return false;
        }
    }
}
