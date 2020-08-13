package com.bwx.controller;

import com.bwx.Entity.DO.ProductDO;
import com.bwx.service.IFileService;
import com.bwx.service.IProductService;
import com.bwx.utils.ContentReviewUtil;
import com.bwx.utils.FTPUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

/**
 * @Author:Biweixiao
 **/
//文件上传服务
@Controller
@RequestMapping(value = "/ftp")
public class FtpController {
    @Autowired
    private IFileService iFileService;
    @Autowired
    private IProductService iProductService;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String uploadFileName = iFileService.upload(file, path);
        session.setAttribute("uploadFileName", uploadFileName);
        return "文件上传成功！";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam(value = "upload_file", required = false) MultipartFile file, @Param("uuid") String uuid, HttpServletRequest request, HttpSession session) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        ProductDO productDO = iProductService.selectById(uuid);
        int num = productDO.getMainImageNum() + 1;
        String type = "m";
        String uploadFileName = iFileService.uploadMainImg(file, path, num, uuid, type);
        String url = "https://9686.fun/images/" + uploadFileName;
        if (!checkImg(url)) {
            deleteFile(uploadFileName);
            num -= 1;
        }
        productDO.setMainImageNum(num);
        iProductService.update(productDO);
        return url;
    }

    @RequestMapping("/uploadFileD")
    @ResponseBody
    public String uploadFileD(@RequestParam(value = "upload_file", required = false) MultipartFile file, @Param("uuid") String uuid, HttpServletRequest request, HttpSession session) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        ProductDO productDO = iProductService.selectById(uuid);
        int num = productDO.getDetailImageNum() + 1;
        String type = "d";
        String uploadFileName = iFileService.uploadMainImg(file, path, num, uuid, type);
        String url = "https://9686.fun/images/" + uploadFileName;
        if (!checkImg(url)) {
            deleteFile(uploadFileName);
            num -= 1;
        }
        productDO.setDetailImageNum(num);
        iProductService.update(productDO);
        return url;
    }

    public void deleteFile(String fileName) throws IOException {
        FTPUtil ftpUtil = new FTPUtil();
        ftpUtil.deleteFile(fileName);
    }

    public boolean checkImg(String imgUrl) {
        ContentReviewUtil contentReviewUtil = new ContentReviewUtil();
        return contentReviewUtil.checkImg(imgUrl);
    }
}
