package com.spring.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;

@Controller
public class FileUploadController {
	// 3. 썸네일 생성 : 이미지 파일의 경우
    private static String makeThumbnail(String uploadPath, String path, String file_name) throws Exception {
    	
        // BufferedImage : 실제 이미지 X, 메모리상의 이미지를 의미하는 객체
        // 원본 이미지파일을 메모리에 로딩
        BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, file_name));
        
        // 정해진 크기에 맞게 원본이미지를 축소
        BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
        
        // 썸네일 이미지 파일명
        String thumbnailName = uploadPath + path + File.separator + "s_" + file_name;
        
        // 썸네일 이미지 파일 객체 생성
        File newFile = new File(thumbnailName);
        
        // 파일 확장자 추출
        String formatName = file_name.substring(file_name.lastIndexOf(".") + 1);
        
        // 썸네일 파일 저장
        ImageIO.write(destImg, formatName.toUpperCase(), newFile);
        return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }
}
