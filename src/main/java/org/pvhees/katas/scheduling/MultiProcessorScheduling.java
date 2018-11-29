package org.pvhees.katas.scheduling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiProcessorScheduling {

    public List<Integer> verdeel(int aantalProcessors, List<Integer> totalLoad) {
        List<Integer> sortedTotal = new ArrayList<>(totalLoad);
        sortedTotal.sort(Collections.reverseOrder());

        // Use a class, Processor, to encapsulate assigned load so we can update its load
        // without having to extract and re-insert into result list
        List<Processor> processors = new ArrayList<>();
        for (int i = 0; i < aantalProcessors; i++) {
            processors.add(new Processor());
        }

        for (int load : sortedTotal) {
            Processor lowest = processors.stream().min(Comparator.comparingInt(Processor::getLoad)).get();
            lowest.addLoad(load);
        }

        List<Integer> collectedResult = processors.stream()
                .map(Processor::getLoad)
                .collect(Collectors.toList());
        collectedResult.sort(Collections.reverseOrder()); // highest load first

        return collectedResult;
    }

    private static class Processor {
        private int load;

        public void addLoad(int load) {
            this.load += load;
        }

        public int getLoad() {
            return load;
        }
    }


    /**
     * <pre>
     * A text file contains one value we call P and N other values we will call {V}. All values
     * are positive integers, separated by new-lines. The number of elements in {V}, N, is
     * unspecified.
     *
     * The N elements of set {V} represent the number of seconds needed to complete a task.
     * Compute the minimal time T in which all N tasks in {V} can be completed on P
     * processors.
     *
     * For instance, in case P=4 and {V}={3,5,5,9,12,6,8} the result T would be 13, because the
     * following mapping is possible:
     *
     * Processor     Tasks		 		 Sum
     * P1		 	 8, 5		  		 13 (maximum)
     * P2		 	 12		 	     	 12
     * P3		 	 5, 6		 		 11
     * P4		 	 9, 3		 		 12
     * <pre/>
     */
    public static void main(String[] args) {
        List<Integer> data = readFile("src/test/resources/mptest1.txt");
        int aantalProcessors = data.get(0);
        data.remove(0);

        MultiProcessorScheduling scheduler = new MultiProcessorScheduling();
        List<Integer> verdeling = scheduler.verdeel(aantalProcessors, data);

        System.out.println("verdeling: "+verdeling);
    }

    private static List<Integer> readFile(String filename) {
        try (Stream<String> lines = Files.lines(Paths.get(filename).toAbsolutePath())) {
            return lines
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Oeps: " + e.getMessage());
        }
        return Collections.emptyList();
    }
}
