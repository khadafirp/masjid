package com.example.masjid.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
 
public class FileDownloadUtil {
    private Path foundFile;
     
    public Resource getFileAsResource(String url) throws IOException {
        Path dirPath = Paths.get(url);
         
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(url)) {
                foundFile = file;
                return;
            }
        });
 
        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }
         
        return null;
    }
}