package top.durandal.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.durandal.common.ResponseInfo;

import java.io.File;
import java.io.IOException;

@Controller
public class DownImg {

    @PostMapping("/upload")
    @ResponseBody
    public ResponseInfo upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseInfo.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        String filePath = "http://49.235.194.31/img/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);

            return ResponseInfo.success(fileName);
        } catch (IOException e) {
        }
        return ResponseInfo.error("上传失败");
    }


}
