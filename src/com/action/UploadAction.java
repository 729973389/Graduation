package com.action;

import com.until.VeDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadAction {
      //上传图片
    @RequestMapping("image.action")
    public String upload(@RequestParam(value = "image",required = false)MultipartFile file, HttpServletRequest request){
          String path=request.getSession().getServletContext().getRealPath("/")+"upfiles";
          String filename=file.getOriginalFilename();
          int i=filename.lastIndexOf(".");
          String name= VeDate.geteStringDatex();
          String type=filename.substring(i+1);
          filename=name+"."+type;
          File targetFile=new File(path,filename);
          if (!targetFile.exists()){
              targetFile.mkdirs();
          }
          try{
              file.transferTo(targetFile);
          }catch (IOException e){
              e.printStackTrace();
          }
          request.setAttribute("imageFileName",filename);
          return "saveimage";
    }
}
