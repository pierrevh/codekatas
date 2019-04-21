package org.pvhees.katas.codility.countriesrecursive;

public class ComponentCounter {
    /**
     * @param components 2D int-array die een verzameling componenten voorstelt waarin
     *                   een component word gedefinieerd als die elementen:
     *                   - die dezelfde waarde hebben;
     *                   - die volgens de windrichtingen N-O-Z-W aan elkaar grenzen (dwz diagonaal telt niet).
     * @return aantal componenten
     */
    public int count(int[][] components) {
        int aantalComponenten = 0;

        // sanitycheck van de input
        if (components == null || components.length == 0 || components[0].length == 0) {
            return aantalComponenten;
        }

        // Hou bij welk element al gezien is
        boolean[][] visited = new boolean[components.length][components[0].length];

        // Ga alle elementen na
        for (int x = 0; x < components.length; x++) {
            for (int y = 0; y < components[0].length; y++) {
                if (!visited[x][y]) {
                    // onbekend component gevonden
                    aantalComponenten++;

                    // markeer alle elementen van dit component
                    markComponent(x, y, components[x][y], components, visited);
                }
            }
        }

        return aantalComponenten;
    }

    private void markComponent(int x, int y, int currentComponentId, int[][] componenten, boolean[][] visited) {
        // Check dat x,y:
        // - verwijst naar huidige component
        // - binnen de grenzen van de input valt;
        // - niet al is gezien
        if (x < 0 || x >= componenten.length || y < 0 || y >= componenten[0].length || visited[x][y] || componenten[x][y] != currentComponentId) {
            return;
        }

        visited[x][y] = true;

        // Bezoek de mogelijk geldige buren (West, Oost, Noord, Zuid). Impliciete DFS via callstack
        markComponent(x, y-1, currentComponentId, componenten, visited);
        markComponent(x, y+1, currentComponentId, componenten, visited);
        markComponent(x-1, y, currentComponentId, componenten, visited);
        markComponent(x+1, y, currentComponentId, componenten, visited);
    }
}
