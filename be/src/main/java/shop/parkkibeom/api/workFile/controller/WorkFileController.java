package shop.parkkibeom.api.workFile.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.parkkibeom.api.workFile.service.WorkFileServiceImpl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

@Log4j2
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class WorkFileController {

    private final WorkFileServiceImpl workFileService;

    @Value("${shop.parkkibeom.upload.path}")
    private String uploadPath;

    @PostMapping("/uploadArts")
    public ResponseEntity<String> uploadWorks(@RequestBody ArrayList<MultipartFile> files) {

        for(MultipartFile file : files) {
            if (file.getContentType().startsWith("image")== false) {
                log.warn("이미지 파일이 아닙니다.");

                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            // 실제 파일 이름에 IE나 Edge는 전체 경로가 들어오므로 \\로 구분된 마지막 글자가 파일명
            String originalFileName = file.getOriginalFilename();
            String fileName = originalFileName.substring(originalFileName.lastIndexOf("\\") + 1);

            log.info("fileName: " + fileName);

            // UUID
            String uuid = UUID.randomUUID().toString();

            // 저장할 파일 이름 중간에 "_"를 이용해서 구분하여 파일 경로 포함한 저장 파일명
            String saveFileName = uploadPath + File.separator + uuid + "_" + fileName;
            Path savePath = Paths.get(saveFileName);

            
        }
    }

}
