package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Properties;

public class ValueConfig {
    private static final Properties properties = new Properties();
    private static final String PATH = "src/main/resources";
    private static final String FormatFile = ".properties";

    public static File getFile(String formatFile) {
        File directory = new File(PATH);

        if (directory.exists()){
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(formatFile.toLowerCase()));

            if (files != null && files.length > 0) {
                return files[0];
            }
        }

        return null;
    }

    public static String getApplicationData(String key) throws IOException {
        properties.load(new FileReader(Objects.requireNonNull(getFile(FormatFile))));
        return properties.getProperty(key);
    }

    public void processAnnotations(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields){
            Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                try {
                    String value = annotation.value().toLowerCase();
                    field.setAccessible(true);
                    if (value.startsWith("$")){
                        field.set(object, getApplicationData(value.substring(2, value.length()-1)));
                    } else {
                        field.set(object, value);
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
