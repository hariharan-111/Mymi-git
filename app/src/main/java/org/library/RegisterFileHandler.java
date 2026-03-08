package org.library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RegisterFileHandler extends LibrarySystem {

    public static void writeUser(LibrarySystem userDetails) throws IOException {
        try(BufferedWriter out = new BufferedWriter(new FileWriter("./resources/users.json"))) {
            ObjectMapper mapper = new ObjectMapper();
            String userInfo = mapper.writeValueAsString(userDetails);
            out.write(userInfo);
        } catch (Exception e) {
            throw e;
        }
    }
}
