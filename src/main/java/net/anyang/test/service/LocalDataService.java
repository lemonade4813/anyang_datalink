package net.anyang.test.service;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
@Service
public class LocalDataService {
    @Autowired
    ApiInterface apiInterface;

    @Autowired
    GetDateService getDateService;

    public String findFolderPath(String path) {

        File Folder = new File(path);

        if(!Folder.exists()){
            try{
                Folder.mkdirs();
            }
            catch (Exception e){
                e.getStackTrace();
            }
        }
        return path;
    }

    public String findFilePath(String path) {
        StringBuilder sb = new StringBuilder();
         sb.append(path).append("/").append("download.zip");
        return sb.toString();
    }


    public boolean downLoad(final String address, final String filePath, final String unzipFolder){
        try {
            URL url = new URL(address);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();

            Path source = Paths.get(filePath);
            Path target = Paths.get(unzipFolder);
            unzipFile(source, target);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void unzipFile(Path sourceZip, Path targetDir) {

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(sourceZip.toFile()), Charset.forName("EUC-KR"))) {

            // list files in zip
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {

                boolean isDirectory = false;
                if (zipEntry.getName().endsWith(File.separator)) {
                    isDirectory = true;
                }

                Path newPath = zipSlipProtect(zipEntry, targetDir);
                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {
                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }
                    // copy files
                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
                }

                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            deleteFile(targetDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {

        // test zip slip vulnerability
        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        // make sure normalized file still has targetDir as its prefix
        // else throws exception
        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }
        return normalizePath;
    }

    public static void deleteFile(Path targetDir){
        File file = new File(String.valueOf(targetDir));
        File[] fileList =  file.listFiles();
        for(File fileName : fileList){
            String name = fileName.getName();
            String a = name.substring(name.lastIndexOf(".")+1).toLowerCase();

            if (a.contains("zip")){
                fileName.delete();
            }
        }
    }
}
