package org.pvhees.katas.jamigrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Merge {

    FlowAant line1;
    FlowAant line2;
    Boolean done = false;
    List<FlowAant> collected;
    int index = 0;

    public static void main(String[] args) throws IOException {
        Merge merge = new Merge();
        merge.doIt();
    }

    public void doIt() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get("d:\\codekatas\\src\\main\\java\\org\\pvhees\\katas\\jamigrate\\aantekeningen_hashed.txt");
        Path pathOut = Paths.get("d:\\codekatas\\src\\main\\java\\org\\pvhees\\katas\\jamigrate\\aantekeningen_merged.json");
        collected = Files.lines(path).map(line -> {
            String[] split = line.split(Hash.SEPARATOR);
            return toFlowAant(mapper, split[0], split[1]);
        }).collect(Collectors.toList());

        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOut)) {
            readTwoLines(bufferedWriter, mapper);
            while (!done) {
                if (line1.getHashForKeyFields().equalsIgnoreCase(line2.getHashForKeyFields())) {
                    mergeAndWrite(bufferedWriter, mapper);
                    readTwoLines(bufferedWriter, mapper);
                } else {
                    writeLine1(bufferedWriter, mapper);
                    readOneLine();
                }
            }
        } catch (IOException e) {

        }
    }

    private void writeLine1(Writer writer, ObjectMapper mapper) throws IOException {
        writer.write(mapper.writeValueAsString(line1));
    }

    private void mergeAndWrite(BufferedWriter writer, ObjectMapper mapper) throws IOException {
        if(line1.getLidnummer() == null) {
            // line1 has voertuig
            line1.setLidnummer(line2.getLidnummer());
            line1.setPostcode(line2.getPostcode());
        } else {
            // line1 has lid
            line1.setVoertuig(line2.getVoertuig());
        }
        writeLine1(writer, mapper);
    }

    private void readTwoLines(Writer writer, ObjectMapper mapper) throws IOException {
        if (index == collected.size()) {
            done = true;
            return;
        }
        line1 = collected.get(index);
        index++;
        if (index == collected.size()) {
            writeLine1(writer, mapper);
            done = true;
            return;
        }
        line2 = collected.get(index);
        index++;
    }

    private void readOneLine() {
        line1 = line2;
        if (index == collected.size()) {
            done = true;
            return;
        }
        line2 = collected.get(index);
        index++;
    }


    private FlowAant toFlowAant(ObjectMapper mapper, String hash, String content) {
        try {
            FlowAant flowAant = mapper.readValue(content, FlowAant.class);
            flowAant.setHashForKeyFields(hash);
            return flowAant;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
