package com.nz.supplieritem.controller.upload;

import com.nz.supplieritem.entity.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    String folder = "C:\\Users\\谁\\Desktop\\haha\\";
    @PostMapping
    public FileInfo uploadFile(MultipartFile file){
        System.out.println(file.getName());
        String path = folder + new Date().getTime() + ".txt";
        File f = new File(path);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileInfo(path);
    }
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest req, HttpServletResponse res) throws IOException {
        try(
                InputStream in = new FileInputStream(new File(folder + id + ".txt"));
                OutputStream out = res.getOutputStream();
                ){
            res.setContentType("application/x-download");
            res.addHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(in,out);
            out.flush();
        }
    }

}
