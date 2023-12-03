package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.aop.LogTime;
import com.tuana9a.learnjavaspringweb.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileController {
    @Autowired
    private AppConfig config;

    @LogTime
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Object> upload(@RequestParam("files") MultipartFile[] files) throws Exception {
        Path folder = Paths.get(config.ROOT_FOLDER);
        for (MultipartFile file : files) {

            if (file == null) continue;

            String name = file.getOriginalFilename();
            name = (name == null ? "unknown.txt" : name);
            Files.copy(file.getInputStream(), folder.resolve(name));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/explorer.exe/**/*", method = RequestMethod.GET)
    public ResponseEntity<Object> explorer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathRequest = req.getRequestURI().substring("/explorer.exe/".length());

        // URL-decode the file name (might contain spaces and on) and prepare file object.
        String pathDecoded = URLDecoder.decode(pathRequest, "UTF-8");
        // System.out.println(pathDecoded);
        File file = new File(config.ROOT_FOLDER, pathDecoded);

        // Check if file actually exists in filesystem.
        if (!file.exists()) {
            // Throw an exception, or send 404, or show default/warning page, or just ignore it.
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return ResponseEntity.notFound().build();
        }

        if (file.isDirectory()) {
            return ResponseEntity.ok("is a folder");
        } else if (file.isFile()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            String contentType = Files.probeContentType(Paths.get(pathDecoded));
            System.out.println(contentType);

            return ResponseEntity.ok()
                    .contentLength(file.length())
                    .header("Content-Type", contentType)
                    .body(resource);
        }
        // unknown what is this file
        return ResponseEntity.notFound().build();
    }

}
