import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    private final static int inf = Integer.MAX_VALUE;
    private final static int vNum = 20;
    public static List<Structure> graph = new ArrayList<>();

    public static void dijkstra(int start, int last) {
        boolean[] used = new boolean[vNum];
        int[] dist = new int[vNum];
        String[] prev = new String[vNum];

        for (int i = 0; i < vNum; i++) {
            used[i] = false;
            dist[i] = inf;
            prev[i] = "";
        }

        dist[start - 1] = 0;
        prev[start - 1] = start + "";
        int v = -1;

        while (!checkArray(used)) {
            for (int j = 0; j < dist.length; j++) {
                if ((!used[j] && (v == -1 || dist[j] < dist[v])) || used[v])
                    v = j;
            }
            if (dist[v] == inf)
                break;
            used[v] = true;
            for (Structure struct : graph) {
                if (struct.getV() == v + 1) {
                    if (dist[struct.getU() - 1] > dist[v] + struct.getCost()) {
                        dist[struct.getU() - 1] = dist[v] + struct.getCost();
                        prev[struct.getU() - 1] = prev[struct.getV() - 1] + " -> " + struct.getU();
                    }

                }
            }
        }

        System.out.println(" Стоимость пути: " + dist[last - 1]);
        System.out.println(" Путь: " + prev[last - 1]);


    }

    private static boolean checkArray(boolean[] checked) {
        for (boolean b : checked) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

}

