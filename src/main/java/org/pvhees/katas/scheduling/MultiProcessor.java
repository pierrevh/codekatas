package org.pvhees.katas.scheduling;

import java.util.*;
import java.util.stream.Collectors;

public class MultiProcessor {

    public List<Integer> verdeel(int aantalProcessors, List<Integer> totalLoad) {
        List<Integer> sortedTotal = new ArrayList<>(totalLoad);
        sortedTotal.sort(Collections.reverseOrder());

        // Using class Processor that encapsulates assigned load so we can update its load
        // without having to extract and re-insert into result list
        List<Processor> result = new ArrayList<>();
        for (int i = 0; i < aantalProcessors; i++) {
            result.add(new Processor());
        }

        for (int load: sortedTotal) {
            Processor lowest = result.stream().min(Comparator.comparingInt(Processor::getLoad)).get();
            lowest.addLoad(load);
        }

        return result.stream()
                .map(Processor::getLoad)
                .collect(Collectors.toList());
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
}
