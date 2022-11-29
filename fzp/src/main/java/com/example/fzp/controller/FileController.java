package com.example.fzp.controller;

import com.example.fzp.entity.User;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "files",produces = "application/json;charset=utf-8")
public class FileController {

    @PostMapping("/upload")
    public Object upload(@RequestParam(value = "file")MultipartFile file, HttpServletRequest req) throws IOException {
//        String uploadPathImg = "C:/Users/12426/Desktop/A404/";
        String uploadPathImg = "/www/wwwroot/static/";
        String fileName = null;
        try {
            if (file != null) {
                 fileName = System.currentTimeMillis() + file.getOriginalFilename();
                String upload_file_dir=uploadPathImg;//注意这里需要添加目录信息
                String destFileName =  uploadPathImg + fileName;
                //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
                File upload_file_dir_file = new File(upload_file_dir);
                if (!upload_file_dir_file.exists())
                {
                    upload_file_dir_file.mkdirs();
                }
                //5.把浏览器上传的文件复制到希望的位置
                File targetFile = new File(upload_file_dir_file, fileName);
                file.transferTo(targetFile);
//                entity.setImgUrl(fileName);
            }
//            companyMapper.addCompay(company);
        }catch (Exception e){
            e.printStackTrace();
        }


        if (fileName.length()==0){
            Map map = new HashMap<>();
            map.put("code",1);
            map.put("message","上传失败");
            return map;
        }
        Map map = new HashMap<>();
        map.put("code",0);
        map.put("message","上传成功");
        map.put("data","http://www.wuhuazai.com/uploadeview/"+fileName);
        return map;

    }
}

