package com.mibbeun.utils.Controller;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mibbeun.amt.Vo.InAmtVo;
import com.mibbeun.utils.Service.AtchFileService;
import com.mibbeun.utils.Vo.AtchFileSVo;
import com.mibbeun.utils.Vo.AtchFileVo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mibbeun.utils.Controller.VersionUtils;




@RestController
@RequestMapping("/")
public class FileUtilsUpDownController {
	//@PostMapping("/fileUpload")
	String fileDir = "D:\\Temp\\";
	private VersionUtils versionUtils = new VersionUtils();
	
	@Autowired
	AtchFileService atchFileService;
	
	public static String GetUUID(){
		 UUID one = UUID.randomUUID();
		 return one.toString();
	}	
	
	public static String GetExet(String ExeFileName){
		return ExeFileName.substring(ExeFileName.lastIndexOf(".") + 1);
	} 	
		
	public static String GetFileName(String ExeFileName){
		Date now = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); // 예: 20250822_153045
	    String ext = GetExet(ExeFileName);
	    return "File_"+sdf.format(now)+"."+ext;
	    
	}   
	

	@RequestMapping(value="/common/fileUpload.do",method= {RequestMethod.POST})
    public AtchFileSVo uploadMultipleFiles(MultipartHttpServletRequest request) {
        
        // 파일을 저장할 디렉토리 경로
        String uploadDirectory = fileDir;
        File dir = new File(uploadDirectory);
        if (!dir.exists()) {
            dir.mkdirs(); // 디렉토리가 없으면 생성
        }

        AtchFileSVo fieldSaveSVo = new AtchFileSVo();        
        List<AtchFileVo> fieldSaveList = new ArrayList<AtchFileVo>();  
        fieldSaveSVo.setAtchFileListVo(fieldSaveList);
        
        // Iterator를 사용하여 모든 파일 이름(폼 필드 이름)을 순회
        Iterator<String> fileNames = request.getFileNames();
        int ii=0;
        String groupUUID = GetUUID();
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            AtchFileVo fieldSaveItem = new AtchFileVo();
            ii = ii + 1;     
            // MultipartFile 객체를 가져옴
            MultipartFile file = request.getFile(fileName);
            if (file != null && !file.isEmpty()) {
            	// vo 입력
                String originalFilename = file.getOriginalFilename();
                // File destFile = new File(uploadDirectory + originalFilename);
            	fieldSaveItem.setAtchFileId(groupUUID);
            	String ServerName = GetFileName(originalFilename);
            	fieldSaveItem.setAtchFileOgcpNm(originalFilename);
                fieldSaveItem.setAtchFileSno(ii);
                fieldSaveItem.setAtchFileSavNm(ServerName);
                fieldSaveItem.setAtchFilePath(uploadDirectory);
                fieldSaveItem.setAtchFileExtsnNm(GetExet(originalFilename));
                fieldSaveItem.setAtchFileSizeNval(file.getSize());
                //--------------------------
                File destFile = new File(uploadDirectory + ServerName);

                try {
                    // 파일을 지정된 경로에 저장
                    file.transferTo(destFile);
                    
                    System.out.println("파일 '" + originalFilename + "' 저장 완료.");
                } catch (IOException e) {
                    e.printStackTrace();
                    //return "파일 '" + originalFilename + "' 저장 실패!";
                    fieldSaveSVo.setErrormsgid("5678");
                    fieldSaveSVo.setErrormsg(originalFilename + " 저장 실패!");
                }
                atchFileService.insertAtchFile(fieldSaveItem);
                fieldSaveList.add(fieldSaveItem);
            }
            
        }
        return fieldSaveSVo;
    }	
		
	@RequestMapping(value = "/common/fileDown.do", method=RequestMethod.GET)
	public void fileDownload(
			HttpServletRequest request
			,HttpServletResponse response
			,@RequestParam(value="atchFileId", required=false) String atchFileId
			,@RequestParam(value="atchFileSno", required=false) String fileSn
			,@RequestParam(value="filePath", required=false) String filePath
			,ModelMap model) throws Exception {

		if(atchFileId != null){
			AtchFileVo fieldDownItem = new AtchFileVo();
			fieldDownItem.setAtchFileId(atchFileId);
			AtchFileVo fieldDownFile = atchFileService.atchFileOneData(fieldDownItem);
			if ((fieldDownFile == null) || (fieldDownFile.getAtchFileId().equals(""))) {
				throw new Exception("8000 파일이 존재하지 않습니다.");
			}
			
		
			File uFile = new File(fieldDownFile.getAtchFilePath(), fieldDownFile.getAtchFileSavNm());
			int fSize = (int) uFile.length();

			if (fSize > 0) {
				String mimetype = "application/x-msdownload";

				response.setContentType(mimetype);
				WebSupportUtil.setDisposition(fieldDownFile.getAtchFileOgcpNm(), request, response);
				response.setContentLength(fSize);

				BufferedInputStream in = null;
				BufferedOutputStream out = null;

				try {
					in = new BufferedInputStream(new FileInputStream(uFile));
					out = new BufferedOutputStream(response.getOutputStream());

					FileCopyUtils.copy(in, out);
					out.flush();
				} catch (IOException ex) {
					throw new Exception(ex.getMessage());
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException ignore) {}
					}			
					if (out != null) {
						try {
							out.close();
						} catch (IOException ignore) {}
					}						
				}
			}

		}else if(filePath != null){
			//파일 경로 append 부분 수정
			String fileName = fileDir + filePath.toString();
//			String fileName = prop.getProperty("file.store.root") + "/" + request.getParameter("filePath");
			fileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

			response.setContentType("application/x-msdownload");

			FileInputStream inputStream = new FileInputStream(fileName);
			int c;
			try {
				while ((c = inputStream.read()) != -1) {
		        	response.getWriter().write(c);
		        }
		        response.getWriter().flush();
		        response.getWriter().close();
			} finally {
				inputStream.close();
			}

		}

	}
	
	@RequestMapping(value = "/common/fileDelete.do", method=RequestMethod.GET)
	public void fileDeelte(
			HttpServletRequest request
			,@RequestParam(value="atchFileId", required=false) String atchFileId
			,ModelMap model) throws Exception {

		if(atchFileId != null){
			AtchFileVo fieldDownItem = new AtchFileVo();
			fieldDownItem.setAtchFileId(atchFileId);
			AtchFileVo fieldDownFile = atchFileService.atchFileOneData(fieldDownItem);
			if ((fieldDownFile == null) || (fieldDownFile.getAtchFileId().equals(""))) {
				throw new Exception("8000 파일이 존재하지 않습니다.");
			}
			
		
			File uFile = new File(fieldDownFile.getAtchFilePath(), fieldDownFile.getAtchFileSavNm());
			if (uFile.delete()) {
				AtchFileVo atchFileVo = new AtchFileVo();
				atchFileVo.setAtchFileId(atchFileId);				
				int iResult = atchFileService.deleteAtchFile(atchFileVo);	
			}
		}

	}	
	
	@RequestMapping(value = "/Version/filedonload", method=RequestMethod.POST)
	public void Version_filedonload(
			HttpServletRequest request
			,HttpServletResponse response
			,@RequestParam(value="filename", required=false) String filename
			,@RequestParam(value="sendType", required=false) String sendType
			,@RequestParam(value="filepath", required=false) String filepath
			,@RequestParam(value="FileDate", required=false) String fileDate
			,@RequestParam(value="listType", required=false) String listType
			,ModelMap model) throws Exception {
		
		String fileName = null;
		if ((sendType != null) && (sendType.equalsIgnoreCase("loader"))){
			if ((filepath != null) && (!filepath.equals(""))) 
			  fileName = 	fileDir + sendType.toString() +"/"+ filepath.toString() + filename.toString();
			else 
			  fileName = 	fileDir + sendType.toString() +"/"+ filename.toString();
			
			File SendFile = new File(fileName);
			if (SendFile.exists() == true) {
				Date Filetime = new Date(SendFile.lastModified());
				SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
				String fileServerDate = fmDt.format(Filetime);
				if (! fileDate.equalsIgnoreCase(fileServerDate)) {
					ServletOutputStream sos =response.getOutputStream();
					DataInputStream dis = new DataInputStream(new FileInputStream(SendFile));
					response.addHeader("MessageCode", "0");
					response.addHeader("MessageText", "Fileload");
					response.addHeader("FileName", fileName);
					response.addHeader("FileDateTime", fileServerDate);
					
					byte[] barray = new byte[(int) SendFile.length()];
					try {
						dis.readFully(barray);
					}
					catch (Exception e) {
						barray = null; 
					} 
					finally {
					  dis.close();
					}
				   sos.write(barray);
				   sos.close();
				}
				else
				{
					response.addHeader("MessageCode", "1");						
				}					
		    }
			else
			{
				response.addHeader("MessageCode", "2");						
			}				
		}
	}	

	@RequestMapping(value = "/Version/filedonload2", method=RequestMethod.POST)
	public void Version_filedonload2(
			HttpServletRequest request
			,HttpServletResponse response
			,@RequestParam(value="filename", required=false) String filename
			,@RequestParam(value="sendType", required=false) String sendType
			,@RequestParam(value="filepath", required=false) String filepath
			,@RequestParam(value="listType", required=false) String listType
			,ModelMap model) throws Exception {

		String fileName = null;
		if (listType != null){
			fileName = 	fileDir + filename.toString() + "/" + listType.toString()+ ".lis";
		}
		else if(filename != null){
			 fileName = fileDir + filepath.toString() + filename.toString();
		}
		
		if(fileName != null){
			//파일 경로 append 부분 수정
			
			fileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

			response.setContentType("application/x-msdownload");

			FileInputStream inputStream = new FileInputStream(fileName);
			int c;
			try {
				while ((c = inputStream.read()) != -1) {
		        	response.getWriter().write(c);
		        }
		        response.getWriter().flush();
		        response.getWriter().close();
			} finally {
				inputStream.close();
			}

		}

	}	
	
	public StringBuffer FileDateLoadList(String listFilePath, String sPath) throws IOException{
		File listFile = new File(listFilePath);
		boolean isExists = listFile.exists();
		if (!isExists) {
			return null;
		}
		StringBuffer buff_query = new StringBuffer();
		try {
			SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
			if (listFile.isDirectory()) {
				File[] file_List = listFile.listFiles();
				for (File tFile : file_List) {
					if (!tFile.isDirectory() && (tFile.getName().lastIndexOf(".~") <= 0)) {
						Date Filetime = new Date(tFile.lastModified());
						String fileServerDate = fmDt.format(Filetime);
						buff_query.append(sPath+"/"+tFile.getName() +"="+ fileServerDate+"\n");
					}
		            else if( tFile.isDirectory() ) { 
		            	buff_query.append(FileDateLoadList(tFile.getPath(),tFile.getName()) );  // 재귀함수 호출 
		            } 					
				}
			}
		} catch (Exception e) {
		}
		return buff_query;
	}	
		
	
	@RequestMapping(value = "/Version/fileloaderList", method=RequestMethod.POST)
	public void fileloaderList(
			HttpServletRequest request
			,HttpServletResponse response
			,@RequestParam(value="listType", required=false) String listType
			,@RequestParam(value="filename", required=false) String filename
			,ModelMap model) throws Exception {
		
		
		String filePaht = null;
		if (filename != null){
			filePaht = 	fileDir + filename.toString();
		}
		else if(filename != null){
			filePaht = fileDir;
		}
		String userFileName;
		if ((filePaht != null) && (!filePaht.equalsIgnoreCase(""))) { // Upload에서 리스트에 서버파일 시간
		    try {
		      //response.setContentType("application/octet-stream");
			  StringBuffer buff_query = FileDateLoadList(filePaht,"");	
			  //ServletOutputStream listsos = response.getOutputStream();
			  //listsos.println(buff_query.toString());
			  
			    response.setContentType("application/x-msdownload");  
				response.getWriter().write(buff_query.toString());
				response.getWriter().flush();
				response.getWriter().close();
			  
		    }
			catch (Exception e) {
			} finally {
				//listsos.close();
			}		    
		}		
		
	}
	
	
	@RequestMapping(value = "/Version/fileupload", method=RequestMethod.POST)
	public void fileDownload(
			MultipartHttpServletRequest request
			,HttpServletResponse response
			,ModelMap model) throws Exception {

		// web.xml에서 디렉토리 정보 호축
		
		// 파일을 저장할 디렉토리 경로
        String uploadDirectory = fileDir;
        File dir = new File(uploadDirectory);
        if (!dir.exists()) {
            dir.mkdirs(); // 디렉토리가 없으면 생성
        }
        String filedate = null;  
        String SavePath = null;  
        String serverPath = null;  
        String server_SavePath = "";  
        
        int downloadType = 0;  
        Iterator<String> infoFileValue = request.getParameterNames().asIterator();
        int iparm = 0;
        while (infoFileValue.hasNext()) {
        	String sValue = infoFileValue.next();
        	if (iparm == 1) 
        		filedate = sValue;	  
        	if (iparm == 2) 
        		SavePath = sValue;
        	if (iparm == 3) 
        		serverPath =  sValue;        	        		        		
        	if (iparm == 4) 
        		downloadType =  Integer.parseInt(sValue);        	        		        		
        	iparm = iparm + 1;
        }
       
        if (((SavePath != null) && (!SavePath.equals(""))) &&
        	((serverPath != null) && (!serverPath.equals("")))) {
            server_SavePath = SavePath + "/" + serverPath;
         }
        else if (((SavePath != null) && (!SavePath.equals("")))) {
                server_SavePath = SavePath;
        }
        else if (((serverPath != null) && (!serverPath.equals("")))) {
            server_SavePath = serverPath;
        }
        
        File uerDir = new File(uploadDirectory+server_SavePath);
        if (!uerDir.exists()) {
        	uerDir.mkdirs(); // 디렉토리가 없으면 생성
        }       
       

        // Iterator를 사용하여 모든 파일 이름(폼 필드 이름)을 순회
        Iterator<String> fileNames = request.getFileNames();
        int ii=0;
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
			String fielde_name = new String(fileName.getBytes("iso-8859-1"),Charset.defaultCharset().name());		

            //----------------------------------------------
            ii = ii + 1;     
            // MultipartFile 객체를 가져옴
            MultipartFile file = request.getFile(fileName);
            if (file != null && !file.isEmpty()) {
            	// vo 입력
                String originalFilename = file.getOriginalFilename();
                // File destFile = new File(uploadDirectory + originalFilename);
                //--------------------------
                File destFile = new File(uploadDirectory +server_SavePath +"/"+originalFilename);
                 try {
                    // 파일을 지정된 경로에 저장
                    file.transferTo(destFile);
                    
                 // 마지막 수정일자 변경
					if (filedate != null && !filedate.equalsIgnoreCase(""))
					{
						SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
						Date ADate = sf.parse(filedate);
						long filet_Time = ADate.getTime();
						destFile.setLastModified(filet_Time);
						if (downloadType == 0) {
						 //  versionUtils.MakeDownLoadList(fielde_name,File_Path);
							versionUtils.MakeOneDownLoadList(SavePath,destFile.getPath(),serverPath, uploadDirectory + SavePath);
						}   
					}                    
                    
                    response.addHeader("MessageCode", "0");
                    response.addHeader("MessageText", "upload");
					
				} catch (FileNotFoundException ex){
					response.addHeader("MessageCode", "-1");
					response.addHeader("MessageText", ex.getMessage());
				} catch (Exception ex){
					response.addHeader("MessageCode", "-1");
					response.addHeader("MessageText", ex.getMessage());
			    }finally {
					
				}	                    
                    
                 
            }
            
        }
        
	}
		
}
