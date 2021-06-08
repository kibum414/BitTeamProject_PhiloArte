package shop.philoarte.api.resume.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.philoarte.api.resume.domain.ResumeFileDTO;
import shop.philoarte.api.resume.service.ResumeFileServiceImpl;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/resume_file")
@CrossOrigin(origins = "*")
public class ResumeFileController {
    private final ResumeFileServiceImpl service;

    @PostMapping(value = "/upload_file", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<List<ResumeFileDTO>> uploadFile(List<MultipartFile> uploadFiles) {
        return ResponseEntity.ok(service.uploadFile(
                uploadFiles.stream().filter(f -> f.getContentType().startsWith("image")).collect(Collectors.toList())));

    }

    @Value("${shop.upload.path}")
    private String uploadPath;

    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName) {
        ResponseEntity<byte[]> result = null;
        try {
            String srcFileName = URLDecoder.decode(fileName, "UTF-8");

            log.info("fileName: " + srcFileName);

            File file = new File(uploadPath + File.separator + srcFileName);

            log.info("file: " + file);
            log.info("file: " + file.toPath());
            result = ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(FileCopyUtils.copyToByteArray(file));
            System.out.println("result: " + result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return result;
    }
}