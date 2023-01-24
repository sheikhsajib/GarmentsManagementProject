package com.garmentsmanagement.GM.repository.fileUploadRepo;

import com.garmentsmanagement.GM.entity.imageEntity.FileUploadDownload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadDownload, Long> {
    Optional<FileUploadDownload> findByName(String fileName);

}
