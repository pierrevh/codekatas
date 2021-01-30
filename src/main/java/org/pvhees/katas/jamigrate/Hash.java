package org.pvhees.katas.jamigrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hash {
    public static final String SEPARATOR = "#:#";

    public static void main(String[] args) throws IOException {
        Hash hash = new Hash();
        hash.doIt();
    }

    public void doIt() throws IOException {
        Map<String, Integer> countByHash = new HashMap<>();
        Path path = Paths.get("d:\\codekatas\\src\\main\\java\\org\\pvhees\\katas\\jamigrate\\aantekeningen.json");
        Path pathOut = Paths.get("d:\\codekatas\\src\\main\\java\\org\\pvhees\\katas\\jamigrate\\aantekeningen_hashed.txt");
        ObjectMapper mapper = new ObjectMapper();
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOut)) {
            List<FlowAant> flowAants = mapper.readValue(Files.newBufferedReader(path), new TypeReference<List<FlowAant>>() {
            });

            for (FlowAant node : flowAants) {
                String hashForNode = makeHash(node.getAantekening());
                bufferedWriter.write(hashForNode + "#:#" + mapper.writeValueAsString(node));
                bufferedWriter.newLine();
                Integer currentCount = countByHash.getOrDefault(hashForNode, 0);
                countByHash.put(hashForNode, ++currentCount);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("countByHash = " + countByHash);
    }

    private String makeHash(String originalString) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedhash = digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
