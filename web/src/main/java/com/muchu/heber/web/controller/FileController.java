package com.muchu.heber.web.controller;

import com.muchu.heber.web.exception.FileNotFound;
import com.muchu.heber.web.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.logback.AmqpAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 梁海鹏
 * @createdate 16-12-11 下午12:08
 */
@RestController
@RequestMapping("file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);


    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("{fileName:\\d.(?:txt|jpg)}")
    public ResponseEntity<Resource> downFile(@PathVariable("fileName") String fileName) {
        Resource resource = fileService.loadFile(fileName);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            fileService.store(file);
        }
        return new ModelAndView("update");
    }

    @GetMapping("upload")
    public ModelAndView upload() {
        return new ModelAndView("uploadForm");
    }

    @ExceptionHandler(FileNotFound.class)
    public ResponseEntity handlerFileNotFound(FileNotFound fileNotFound) {
        logger.error("{} not fount!", fileNotFound.getMessage());
        return ResponseEntity.notFound().build();
    }
}
