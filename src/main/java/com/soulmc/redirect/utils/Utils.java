package com.soulmc.redirect.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Utils {

    public static void saveResource(String target) {
        Path currentPath = Paths.get("").toAbsolutePath();
        String configPath = "/" + target;
        File file = new File(currentPath.toString(), target);

        if (!file.exists()) {
            try {

                InputStream inputStream = Utils.class.getResourceAsStream(configPath);
                OutputStream outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getResourceFileContent(String resourceName) {
        try (InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                return null;
            }

            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                scanner.useDelimiter("\\A");
                return scanner.hasNext() ? scanner.next() : "";
            }
        } catch (IOException e) {
            return null;
        }
    }
}
