package com.bwx.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:Biweixiao
 **/
public interface IFileService {
    String upload(MultipartFile file, String path);

    String uploadMainImg(MultipartFile file, String path, int num, String uuid, String type);
}
