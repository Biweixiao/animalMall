package com.bwx.service.serviceImpl;

import com.bwx.service.IFileService;
import com.bwx.utils.FTPUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.assertj.core.util.Lists;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author:Biweixiao
 **/
@Service
public class FileServiceImpl implements IFileService {

    @Override
    public String upload(MultipartFile file, String path) {
//        String fileName = file.getOriginalFilename();
//        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + ".png";
        System.out.println(uploadFileName);
        System.out.println("开始上传文件，上传路径{},新文件名{}:" + path + "," + uploadFileName);
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdir();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到ftp服务器上
            targetFile.delete();
        } catch (IOException e) {
            System.out.println("文件上传异常原因：" + e);
            return null;
        }
        return uploadFileName;
    }

    @Override
    public String uploadMainImg(MultipartFile file, String path, int num, String uuid, String type) {
        String uploadFileName = uuid + "_" + type + "_" + num + ".png";

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdir();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到ftp服务器上
            targetFile.delete();
        } catch (IOException e) {
            System.out.println("文件上传异常原因：" + e);
            return null;
        }
        return uploadFileName;
    }

}
