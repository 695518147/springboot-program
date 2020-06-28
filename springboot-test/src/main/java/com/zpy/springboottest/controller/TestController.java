package com.zpy.springboottest.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/pdf-download", method = GET)
    public ResponseEntity download() throws IOException {
        File file = new File("/Users/kuangbendewoniu/IdeaProjects/springboot-program/springboot-test/src/main/resources/HelloWorld.pdf");
        InputStream in = new FileInputStream(file);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName() );
        return new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
    }

}
