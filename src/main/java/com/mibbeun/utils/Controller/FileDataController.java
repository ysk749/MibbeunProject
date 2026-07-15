package com.mibbeun.utils.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.mibbeun.utils.Vo.VoFileInfo;



@RestController
@RequestMapping("/")
public class FileDataController {
	//@PostMapping("/fileUpload")
	String fileDir = "D:\\Temp\\";
	@RequestMapping(value="/fileUpload",method= {RequestMethod.POST})
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("업로드할 파일이 없습니다.");
        }
        
        try {
            // 파일을 저장할 경로 설정
           
            File uploadPath = new File(fileDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            
            // 파일 저장
            File dest = new File(uploadPath.getAbsolutePath() + File.separator + file.getOriginalFilename());
            try (FileOutputStream fos = new FileOutputStream(dest)) {
                fos.write(file.getBytes());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 '" + file.getOriginalFilename() + "' 업로드 성공!");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 중 오류 발생: " + e.getMessage());
        }
	    
	}
	
	@RequestMapping(value="/fileUploadVo",method= {RequestMethod.POST})
	public VoFileInfo uploadFileVo(@RequestParam("file") MultipartFile file) {
        
		VoFileInfo fieldInfoVo = new VoFileInfo();
        if (file.isEmpty()) {
        	fieldInfoVo.setErrorMsg("업로드할 파일이 없습니다.");
        }
        
        try {
            // 파일을 저장할 경로 설정
            File uploadPath = new File(fileDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            
            // 파일 저장
            File dest = new File(uploadPath.getAbsolutePath() + File.separator + file.getOriginalFilename());
            try (FileOutputStream fos = new FileOutputStream(dest)) {
                fos.write(file.getBytes());
            }
            fieldInfoVo.setErrorMsg("업로드 성공!");

        } catch (IOException e) {
            e.printStackTrace();
            fieldInfoVo.setErrorMsg("파일 업로드 중 오류 발생: " + e.getMessage());
        }
        return fieldInfoVo;
	    
	}
	
	//@RequestMapping(value="/fileDownload",method= {RequestMethod.GET})
	//@GetMapping("/fileDownload/{fileName:.+}")
	//@RequestMapping(value="/fileDownload/{fileName:.+}",method= {RequestMethod.POST})
	//@PostMapping("/download-post")
	//public ResponseEntity<Resource> downloadFile(@RequestParam String filename) {
	@RequestMapping(value="/fileDownload",method= {RequestMethod.POST})
   public ResponseEntity<InputStreamResource> downloadFilePost(@RequestBody DownloadRequest request) {
        
        // 파일을 저장한 경로 
        String filePath = fileDir + request.getFileName();
        File file = new File(filePath);
        
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
}

/*
Delphi 예제
procedure fileUpload;
var
  LIdHTTP: TIdHTTP;
  LMultiPartFormData: TIdMultiPartFormDataStream;
begin
  LIdHTTP := TIdHTTP.Create(nil);
  LMultiPartFormData := TIdMultiPartFormDataStream.Create;
  try
    // 서버 URL 설정
    LIdHTTP.Request.ContentType := 'multipart/form-data';

    // 업로드할 파일 추가
    LMultiPartFormData.AddFile('file', 'D:\Delphi\LogView_20220928.zip', 'LogView_20220928.zip');

    // 추가적인 폼 데이터가 있다면 추가
    LMultiPartFormData.AddFormField('description', '이것은 예제 파일입니다.');

    // HTTP POST 요청으로 파일 업로드
    LIdHTTP.Post('http://127.0.0.1:8080/fileUpload', LMultiPartFormData);
    ShowMessage('파일 업로드 성공!');
  finally
    LIdHTTP.Free;
    LMultiPartFormData.Free;
  end;
end;

procedure fileDownload;
var
  LIdHTTP: TIdHTTP;
  LPostData: TStringStream;
  LFileName: String;
  LFilePath: String;
  LFileStream: TFileStream;
begin
  LIdHTTP := TIdHTTP.Create(nil);
  LPostData := TStringStream.Create('{"fileName": "LogView_20220928.zip"}', TEncoding.UTF8); // POST로 보낼 데이터
  LFileStream := nil;
  try
    // 서버 URL 및 헤더 설정
    LIdHTTP.Request.ContentType := 'application/json';
    LIdHTTP.HTTPOptions := [hoForceEncodeParams];

    // 다운로드할 파일명과 로컬 저장 경로 설정
    LFileName := 'LogView_20220928.zip';
    LFilePath := 'D:\Download\' + LFileName;
    LFileStream := TFileStream.Create(LFilePath, fmCreate);

    // POST 요청을 통해 파일 다운로드
    LIdHTTP.Post('http://localhost:8080/fileDownload', LPostData, LFileStream);

    ShowMessage('파일 다운로드 성공!');
  finally
    LIdHTTP.Free;
    LPostData.Free;
    LFileStream.Free; // 스트림을 닫아줘야 파일이 정상적으로 저장됩니다.
  end;
end; 
  
 */
 
