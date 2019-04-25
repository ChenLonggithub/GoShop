package jgsu.clong.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class MyFileUpload {

    public static List<String> upload_image(MultipartFile[] files) {

        //根据配置文件和key值，获取到Path
        String path = MyProperUtil.getProperties("myUpload.properties", "windows_path");
        /*创建一个数组来存储文件的名字*/
        List<String> list_image = new ArrayList<>();
        /*循环处理文件*/
        for (int i = 0; i < files.length; i++) {
            /*只有当文件不为空时处理*/
            if (!files[i].isEmpty()) {
                /*获取文件原始文件名*/
                String originalFilename = files[i].getOriginalFilename();
                //UUID uuid = UUID.randomUUID();
                //生成唯一文件名
                String name = System.currentTimeMillis() + originalFilename;
                String upload_name = path + "/" + name;

                try {
                    //将文件存储到给定的目录下
                    files[i].transferTo(new File(upload_name));
                    list_image.add(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list_image;
    }
}
