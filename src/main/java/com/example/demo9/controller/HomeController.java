package com.example.demo9.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homeGet() {
    return "home";
  }

  @PostMapping("/ckeditor/imageUpload")
  @ResponseBody
  public Map<String, Object> imageUpload(@RequestParam("upload") MultipartFile upload) {
    Map<String, Object> result = new HashMap<>();
    try {
      // 날짜 폴더 생성 (선택)
      String today = new SimpleDateFormat("yyyyMMdd").format(new Date());

      // 📌 상대경로 기반으로 프로젝트 내 업로드 폴더 설정
      String uploadPath = new File("").getAbsolutePath() + File.separator + "src"
              + File.separator + "main"
              + File.separator + "webapp"
              + File.separator + "ckeditorUpload";

      File dir = new File(uploadPath, today);
      if (!dir.exists()) dir.mkdirs();

      // 파일명 중복 방지
      String originalFilename = upload.getOriginalFilename();
      String saveName = System.currentTimeMillis() + "_" + originalFilename;
      File saveFile = new File(dir, saveName);

      upload.transferTo(saveFile);

      // CKEditor가 요구하는 응답 구조
      result.put("uploaded", 1);
      result.put("fileName", saveName);
      result.put("url", "/ckeditorUpload/" + today + "/" + saveName);

    } catch (Exception e) {
      result.put("uploaded", 0);
      result.put("error", Map.of("message", "이미지 업로드 실패: " + e.getMessage()));
      e.printStackTrace();
    }
    return result;
  }
}
