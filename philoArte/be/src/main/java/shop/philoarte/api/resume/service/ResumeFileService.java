package shop.philoarte.api.resume.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import shop.philoarte.api.resume.domain.ResumeFileDTO;

public interface ResumeFileService {

    List<ResumeFileDTO> uploadFile(List<MultipartFile> uploadFiles);

    void removeFiles(Long resumeId);
}
