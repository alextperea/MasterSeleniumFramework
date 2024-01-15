package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
        //In short, this generic method loads a JSON file, deserializes it into a Java object of the specified type,
        //and returns that object. You can use this method to deserialize different types of Java objects from JSON
        //files by providing the file name and the desired class type.
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, T);
    }
}
