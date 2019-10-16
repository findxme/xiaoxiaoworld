package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.util.FtpUtils;
import com.xmx.ssm.util.PageLimit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
//    @ResponseBody
    public ModelAndView fileUpload(@RequestParam(value = "file") MultipartFile file, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/user/file");

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            try {
//            File file1 = new File("E:/Windows/Desktop/新建文件夹/" + fileName);

                FtpUtils ftp = FtpUtils.getInstance();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

                ftp.uploadFile("/", simpleDateFormat.format(new Date()) + (new Random()).nextInt(100) + "_" + fileName, file.getInputStream());
                //ftp.downloadFile("ftpFile/data", "123.docx", "F://");
//                ftp.deleteFile("ftpFile/data", fileName);
//                file.transferTo(file1);


            } catch (Exception e) {
                e.printStackTrace();
                //上传失败
                return modelAndView;
            }


            //上传成功
            return modelAndView;
        }
        //文件不存在
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONObject aVoid() throws IOException {
        FtpUtils ftp = FtpUtils.getInstance();
        return PageLimit.layuiJson(0, "", 0, ftp.getFileList("/"));
    }


    @ResponseBody
    @RequestMapping("/deleteFile")
    public int deleteFile(String name) {

        try {
            FtpUtils ftpUtils = FtpUtils.getInstance();
            ftpUtils.deleteFile("/", name);
        } catch (Exception e) {

            return 0;
        }
        return 1;
//        return null;
    }


    @RequestMapping("/downloadFile")
    public void downloadFile(String name, HttpServletResponse response) throws IOException {
        System.err.println(name);
        FtpUtils ftpUtils = new FtpUtils();
        ftpUtils.downloadFile("/",name,response);
    }

}
