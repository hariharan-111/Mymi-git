package org.library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegisterFileHandler {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void writeUser(LibrarySystem userDetails) throws IOException {

        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        File file = new File(dataDir, "users.json");

        List<LibrarySystem> users = new ArrayList<>();

        if (file.exists() && file.length() > 0) {
            users = mapper.readValue(file, new TypeReference<List<LibrarySystem>>() {});
        }

        users.add(userDetails);

        mapper.writerWithDefaultPrettyPrinter().writeValue(file, users);
    }
}
