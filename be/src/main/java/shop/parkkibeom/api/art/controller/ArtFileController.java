package shop.parkkibeom.api.art.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.parkkibeom.api.art.domain.ArtFileDto;
import shop.parkkibeom.api.art.service.ArtFileServiceImpl;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/files")
public class ArtFileController {

    private final ArtFileServiceImpl artFileService;

    @Value("${shop.parkkibeom.upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<List<ArtFileDto>> uploadFiles(List<MultipartFile> files) {

        for (MultipartFile file : files) {
            if (file.getContentType().startsWith("image") == false) {
                log.warn("이미지 파일이 아닙니다.");

                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }

        return new ResponseEntity<>(artFileService.uploadFiles(files), HttpStatus.OK);

    }

    @GetMapping("/display/{fileName}")
    public ResponseEntity<byte[]> getFiles(@PathVariable("fileName") String fileName) {

        try {
            String srcFileName = URLDecoder.decode(fileName, "UTF-8");
            log.info("fileName: " + srcFileName);

            File file = new File(uploadPath + File.separator + srcFileName);
            log.info("file: " + file);

            HttpHeaders httpHeaders = new HttpHeaders();

            // MIME 타입 처리
            httpHeaders.add("Content-Type", Files.probeContentType(file.toPath()));

            log.info("httpHeaders: " + httpHeaders);

            // 파일 데이터 처리
            return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), httpHeaders, HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{fileId}")
    public ResponseEntity<List<ArtFileDto>> updateFiles(List<MultipartFile> files) {

        return new ResponseEntity<>(artFileService.updateFiles(files), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{fileId}")
    public ResponseEntity<Long> deleteFiles(@PathVariable("fileId") Long fileId) {
        return new ResponseEntity<>(artFileService.deleteFiles(fileId), HttpStatus.OK);
    }

}
