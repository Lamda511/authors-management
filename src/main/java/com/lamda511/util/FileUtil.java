package com.lamda511.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUtil {

    public static final String IMG_DIR = "images";

    final static Logger logger = Logger.getLogger(FileUtil.class);

    public void copyFileToServer(File fileToCopy, String rootPath, String destFileName) throws IOException {
        Path srcFile = fileToCopy.toPath();
        Path destFile = getImageDir(rootPath).resolve(destFileName);

        Files.copy(srcFile, destFile);
        logger.debug(String.format("File \"%s\" copied successfully to \"%s\"", srcFile.toString(), destFile.toString()));
    }

    public Path getImageDir(String rootPath) throws IOException {
        Path imgDir = Paths.get(rootPath, IMG_DIR);
        if (Files.notExists(imgDir)) {
            logger.debug(String.format("%s directory does not exist. Creating it...", IMG_DIR));
            Files.createDirectory(imgDir);
            logger.debug(String.format("Created %s directory!", IMG_DIR));
        }

        return imgDir;
    }

    public String generateUniqueName(String initialName) {
        return initialName + System.currentTimeMillis();
    }

}
