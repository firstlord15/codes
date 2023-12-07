package org.example;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class ValueConfig {
    private static final Properties properties = new Properties();
    private static final HashMap<String, String> hashMapData = new HashMap<>();
    private static final String PATH = "src/main/resources";
    private static final String FormatFileProperties = ".properties";
    private static final String FormatFileSuch = ".fff"; // тут формат других файлов

    public static File getFile(String formatFile) {
        File directory = new File(PATH);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(formatFile.toLowerCase()));
            if (files != null && files.length > 0) {
                return files[0];
            }
        }
        return null;
    }

    public static String getApplicationData(String key, boolean status) throws IOException {
        if (status) {
            hashMapData.putAll(load(new FileReader(Objects.requireNonNull(getFile(FormatFileSuch)))));
            return hashMapData.get(key);
        } else {
            properties.load(new FileReader(Objects.requireNonNull(getFile(FormatFileProperties))));
            return properties.getProperty(key);
        }
    }


    public static HashMap<String, String> load(Reader reader) {
        HashMap<String, String> hashMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(Objects.requireNonNull(reader))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("=");

                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    hashMap.put(key, value);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return hashMap;
    }

    public static boolean isProperties(String format) {
        return format.equalsIgnoreCase(FormatFileProperties);
    }

    public static void processAnnotations(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                try {
                    String value = annotation.value().toLowerCase();
                    field.setAccessible(true);
                    if (value.startsWith("$")) {
                        field.set(object, getApplicationData(value.substring(2, value.length() - 1), true));
                        // тут просто пишите true если хотите properties, false для других.
                    } else {
                        field.set(object, value);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
