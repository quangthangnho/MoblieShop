package com.fsoft.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Part;

public class UploadFileUtil {


	public String getSavedFileURL(int id, int idcategory, String name, Part partSever, String pathSever) throws IOException, ServletException {
        Part part = partSever;
        String fileName = extractFileName(part);
        fileName = new File(fileName).getName();
        if(fileName.length()!=0) {
            fileName = "" + id + "_" + idcategory + "_" + name + ".jpg";
            String path = pathSever + fileName;
            part.write(path);// Save the File path
            System.out.println(path);
            return fileName;
        }else {
            return "";
        }
    }
	
	  private static String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	          if (s.trim().startsWith("filename")) {
	            return s.substring(s.indexOf("=") + 2, s.length() - 1);
	          }
	        }
	        return "";
	    }
}
