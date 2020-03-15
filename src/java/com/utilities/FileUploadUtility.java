
package com.utilities;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtility {
 
      public static String getUploadedPath(ServletContext context, String filePath, HttpServletRequest request) {
        String imagePath = "";
        String photo = "";
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.getMessage();
        }

        Iterator itr = items.iterator();
        while (itr.hasNext()) {
            FileItem item = (FileItem) itr.next();
            if (!item.isFormField()) {
                try {
                    photo = item.getName();
                    imagePath = filePath+"/" + photo;
                    File savedFile = new File(context.getRealPath("/") + imagePath);
                    item.write(savedFile);
                    
                } catch (Exception e) {
                    System.out.println("File Upload Error  " + e.getMessage());
                }
            }
        }
        return imagePath;
    }
}
