package com.garmentsmanagement.GM.service;

import com.garmentsmanagement.GM.entity.imageEntity.FileUploadDownload;
import com.garmentsmanagement.GM.repository.fileUploadRepo.FileUploadRepository;
import com.garmentsmanagement.GM.utility.ImgUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository sRepo;

    public String uploadImage(MultipartFile file) throws IOException {
        String uniqFname = RandomStringUtils.randomAlphabetic(5)+file.getOriginalFilename();
        FileUploadDownload imageData = sRepo.save(FileUploadDownload.builder()
                .name(uniqFname)
                .type(file.getContentType())
                .imageData(ImgUtil.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return uniqFname;
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<FileUploadDownload> dbImageData = sRepo.findByName(fileName);
        byte[] images=ImgUtil.decompressImage(dbImageData.get().getImageData());
        return images;
    }

}
