package org.pvhees.katas.dynprog;

import java.util.HashMap;
import java.util.Map;

// how many ways can you travel a grid
// when you're only allowed to go 1 cell to the right or 1 cell down per step
//
// uses memoization
public class GridTravel {
    public long count(int n, int m) {
        return countrec(n, m, new HashMap<String, Long>());
    }

    private long countrec(int n, int m, Map<String, Long> memo) {
        // basecases for invalid grid and 1x1 grid
        if (n == 0 || m == 0) return 0;
        if (n == 1 && m == 1) return 1;

        // check memo if we already calculated this one
        String key = n + "," + m;
        Long value = memo.get(key);
        if (value != null) return value;

        // calculate and save to memo
        long possibilities = countrec(n - 1, m, memo) + countrec(n, m - 1, memo);
        memo.put(key, possibilities);

        return possibilities;
    }


}
