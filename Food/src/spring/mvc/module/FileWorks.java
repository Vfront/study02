package spring.mvc.module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("fileWorks")
public class FileWorks {
	private String filePath = "D:\\Spring_workspace\\Food\\WebContent\\files";	

	public String uploadAndGetSysName(MultipartFile upfile){
		
		if(upfile.isEmpty()){
			return null;
		}

		String orgName = upfile.getOriginalFilename();
		String sysName = orgName;
					
		File uploadFile = new File(filePath+"\\"+orgName);
		
		int addNum = 1;
		while(uploadFile.exists()){
			String extName = sysName.substring(sysName.lastIndexOf("."));
			String fName = sysName.substring(0, sysName.lastIndexOf("."));
		
			if(fName.contains("_")){
				fName = fName.substring(0, fName.lastIndexOf("_"));
				
			}
			sysName = fName+"_"+addNum+extName;
			addNum++;

			uploadFile = new File(filePath + "\\" + sysName);
		}
		System.out.println("sysName comp : " + sysName);
		
		try{
			byte[] byteArrays = upfile.getBytes();
			OutputStream os = new FileOutputStream(uploadFile);
			os.write(byteArrays);
			os.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sysName;
	}
	
}
