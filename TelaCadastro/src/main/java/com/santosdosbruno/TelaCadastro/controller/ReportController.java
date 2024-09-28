package com.santosdosbruno.TelaCadastro.controller;

import com.santosdosbruno.TelaCadastro.service.ReportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.PathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportServiceInterface reportService;

    @Autowired
    private NotificationController notificationController;

    @GetMapping
    public ResponseEntity<Void> requestReportGeneration() {
        reportService.requestCSVReportGeneration();
        notificationController.sendReportStatus("Report Requested");
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/downloadReport")
    public ResponseEntity<Resource> downloadReport(@RequestParam String filePath) {
        try {
            String decodedFilePath = URLDecoder.decode(filePath, "UTF-8");
            Path path = Paths.get(decodedFilePath);
            Resource resource = new PathResource(path);

            if (resource.exists()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + path.getFileName().toString());
                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(path.toFile().length())
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (UnsupportedEncodingException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
