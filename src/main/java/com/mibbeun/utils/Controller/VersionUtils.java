package com.mibbeun.utils.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class VersionUtils {
	private final String LIST_VER_FILE = "version.lst";
	private final String LIST_DOWNLOAD_FILE = "downloadlist.lis";
	
	//리스트에 파일이름이 있는지 확인
	public String ReadFileCheck(String fileNmae, String listFilePath){
		String result = "";
		try {
			File listFile = new File(listFilePath + LIST_DOWNLOAD_FILE);
			FileReader filereader = new FileReader(listFile);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			String fileData = "";
			while ((line = bufReader.readLine()) != null) {
				fileData = line.replaceAll("\\\\", "/");
				if (fileData.toLowerCase().lastIndexOf(fileNmae.toLowerCase()) >= 0) {
					result = fileData;
					break;
				}
			}
			bufReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return ""; 
		}catch (IOException e) {
			System.out.println(e);
			return ""; 
		}
		return result;
	}
	
//다운로드 리스트에 파일 수정  "downloadlist.lis"
	public boolean MakeOneDownLoadList(String filePaht, String fileNmae, String serverPath, String listFilePath){
		File listFile = new File(listFilePath +"/"+ LIST_DOWNLOAD_FILE);
		File listFile_write = new File(listFilePath +"/"+ LIST_DOWNLOAD_FILE+".tmp");
		FileReader filereader = null;
		FileWriter filewriter = null;
		BufferedReader bufReader = null;
		BufferedWriter bufWriter = null;
		
		String lineFileName = fileNmae.replaceAll("\\\\", "/");
        int lastSlashIndex = lineFileName.lastIndexOf("/"); // '/' 문자의 마지막 위치를 찾습니다.
        lineFileName = lineFileName.substring(lastSlashIndex + 1); // 마지막 '/' 다음부터 문자열을 가져옵니다.
		
		boolean result =  false;
		try {
			filewriter = new FileWriter(listFile_write);
			bufWriter = new BufferedWriter(filewriter);
			if (listFile.isFile() == true ) { 
				filereader = new FileReader(listFile);
				bufReader = new BufferedReader(filereader);
					
				String line = "";
				String fileData = "";
				int iPos = -1;
				while ((line = bufReader.readLine()) != null) {
					fileData = line.replaceAll("\\\\", "/");
					iPos = fileData.toLowerCase().lastIndexOf(lineFileName.toLowerCase());
					if (iPos >= 0) {
						iPos = fileData.toLowerCase().lastIndexOf(",");
						fileData = fileData.substring(1,iPos); 
						iPos = fileData.toLowerCase().lastIndexOf("=");
						fileData = fileData.substring(iPos+1); 
						
						File dateFile = new File( fileNmae);
						Date Filetime = new Date(dateFile.lastModified());
						SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
						String fileServerDate = fmDt.format(Filetime);
						String FileInfo = serverPath + "/"+dateFile.getName() + "=" + fileData +"," +  fileServerDate;
						// FileInfo = FileInfo.replaceAll("/","\\\\");
						bufWriter.append(FileInfo+"\r\n");
						result = true;
					} else	{
						bufWriter.append(line+"\r\n");
					}
				}
			}
			
			if (result == false) {
				File dateFile = new File(fileNmae);
				Date Filetime = new Date(dateFile.lastModified());
				SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
				String fileServerDate = fmDt.format(Filetime);
				//String FileInfo = fileNmae + "=" + fileData +"," +  fileServerDate;
				String FileInfo = serverPath + "/"+dateFile.getName() + "=" +"," +  fileServerDate;
				// FileInfo = FileInfo.replaceAll("/","\\\\");
				bufWriter.append(FileInfo+"\r\n");
			}
				
				
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			
			listFile.delete();
			listFile_write.renameTo(listFile);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		}catch (IOException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		} finally {
		}
		
		return result;
	
	}	
	
	//다운로드 리스트에 파일 수정  "downloadlist.lis"
	public boolean MakeDownLoadList(String fileNmae, String listFilePath){
		File listFile = new File(listFilePath + LIST_DOWNLOAD_FILE);
		File listFile_write = new File(listFilePath + LIST_DOWNLOAD_FILE+".tmp");
		FileReader filereader = null;
		FileWriter filewriter = null;
		BufferedReader bufReader = null;
		BufferedWriter bufWriter = null;
		boolean result =  false;
		try {
			filereader = new FileReader(listFile);
			filewriter = new FileWriter(listFile_write);
			bufReader = new BufferedReader(filereader);
			bufWriter = new BufferedWriter(filewriter);
				
			String line = "";
			String fileData = "";
			int iPos = -1;
			while ((line = bufReader.readLine()) != null) {
				fileData = line.replaceAll("\\\\", "/");
				iPos = fileData.toLowerCase().lastIndexOf(fileNmae.toLowerCase());
				if (iPos >= 0) {
					
					iPos = fileData.toLowerCase().lastIndexOf(",");
					fileData = fileData.substring(1,iPos); 
					iPos = fileData.toLowerCase().lastIndexOf("=");
					fileData = fileData.substring(iPos+1); 
					
					File dateFile = new File(listFilePath + fileData+fileNmae);
					Date Filetime = new Date(dateFile.lastModified());
					SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
					String fileServerDate = fmDt.format(Filetime);
					String FileInfo = fileNmae + "=" + fileData +"," +  fileServerDate;
					FileInfo = FileInfo.replaceAll("/","\\\\");
					bufWriter.append(FileInfo+"\r\n");
					result = true;
				} else	{
					bufWriter.append(line+"\r\n");
				}
				
			}
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			
			listFile.delete();
			listFile_write.renameTo(listFile);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		}catch (IOException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		} finally {
		}
		
		return result;
	
	}	
	
	//전체 일자  다운로드 리스트에 파일 작성
	public boolean MakeDownLoadListAll(String listFilePath){
		File listFile = new File(listFilePath + LIST_VER_FILE);
		File listFile_old = new File(listFilePath + LIST_DOWNLOAD_FILE);
		File listFile_write = new File(listFilePath + LIST_DOWNLOAD_FILE+".tmp");
		FileReader filereader = null;
		FileWriter filewriter = null;
		BufferedReader bufReader = null;
		BufferedWriter bufWriter = null;
		boolean result =  false;
		try {
			filereader = new FileReader(listFile);
			filewriter = new FileWriter(listFile_write);
			bufReader = new BufferedReader(filereader);
			bufWriter = new BufferedWriter(filewriter);
				
			String line = "";
			String fileData = "";
			while ((line = bufReader.readLine()) != null) {
				if (line.substring(0,1).equalsIgnoreCase("*"))
					continue;
				fileData = line.replaceAll("\\\\", "/");
				
				int iPos = fileData.toLowerCase().lastIndexOf("/");
				
				File dateFile = new File(listFilePath + fileData);
				Date Filetime = new Date(dateFile.lastModified());
				SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
				String fileServerDate = fmDt.format(Filetime);
				String FileInfo;
				if (iPos >= 0)
				  FileInfo = fileData.substring(iPos+1) + "=" + fileData.substring(0,iPos +1) +"," +  fileServerDate;
				else
				  FileInfo = fileData + "=" + "," +  fileServerDate;
					
				FileInfo = FileInfo.replaceAll("/","\\\\");
				bufWriter.append(FileInfo + "\r\n");
			}
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			
			listFile_old.delete();
			listFile_write.renameTo(listFile_old);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		}catch (IOException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		} finally {
		}
		
		return result;
	
	}	
	
	//전체 일자  다운로드 리스트에 파일 작성
	public boolean MakeDownLoadListAllValue(String listFilePath){
		File listFile = new File(listFilePath + LIST_VER_FILE);
		File listFile_old = new File(listFilePath + LIST_DOWNLOAD_FILE);
		File listFile_write = new File(listFilePath + LIST_DOWNLOAD_FILE+".tmp");
		FileReader filereader = null;
		FileWriter filewriter = null;
		BufferedReader bufReader = null;
		BufferedWriter bufWriter = null;
		boolean result =  false;
		try {
			filereader = new FileReader(listFile);
			filewriter = new FileWriter(listFile_write);
			bufReader = new BufferedReader(filereader);
			bufWriter = new BufferedWriter(filewriter);
				
			String line = "";
			String fileData = "";
			while ((line = bufReader.readLine()) != null) {
				if (line.substring(0,1).equalsIgnoreCase("*"))
					continue;
				fileData = line.replaceAll("\\\\", "/");
				
				int iPos = fileData.toLowerCase().lastIndexOf("/");
				
				File dateFile = new File(listFilePath + fileData);
				Date Filetime = new Date(dateFile.lastModified());
				SimpleDateFormat  fmDt = new SimpleDateFormat("yyyyMMddHHmmss");
				String fileServerDate = fmDt.format(Filetime);
				String FileInfo;
				if (iPos >= 0)
				  FileInfo = fileData.substring(iPos+1) + "=" + fileData.substring(0,iPos +1) +"," +  fileServerDate;
				else
				  FileInfo = fileData + "=" + "," +  fileServerDate;
					
				FileInfo = FileInfo.replaceAll("/","\\\\");
				bufWriter.append(FileInfo + "\r\n");
			}
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			
			listFile_old.delete();
			listFile_write.renameTo(listFile_old);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		}catch (IOException e) {
			System.out.println(e);
			try { if (bufReader != null) bufReader.close();	} catch (IOException e1) {}
			try { if (bufWriter != null) bufWriter.close();	} catch (IOException e1) {}
			try { if (filereader != null) filereader.close();	} catch (IOException e1) {}
			try { if (filewriter != null) filewriter.close();	} catch (IOException e1) {}
			return result; 
		} finally {
		}
		
		return result;
	
	}	

}
