package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chopin
 * Description: TODO
 * Date: 2017/9/11
 * Time: 12:06
 */
public class MagicKingdom {
    static private int[] visitedCount;
    static private int maxVisitedCount;

    public static void main(String[] args) {
        int cityNum = 5, maxStep = 5;
        int[] lines = {0, 1, 2, 3, 4};
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>(cityNum);
        for (int i = 0; i < lines.length; i++) {
            if (!adjacencyList.containsKey(i + 1)){
                adjacencyList.put(i + 1, new ArrayList<>());
            }
            if (!adjacencyList.containsKey(lines[i])){
                adjacencyList.put(lines[i], new ArrayList<>());
            }
            adjacencyList.get(i + 1).add(lines[i]);
            adjacencyList.get(lines[i]).add(i + 1);
        }
        int result = getMaxCityNum(adjacencyList, cityNum, 0, maxStep);
        System.out.println(result);
    }

    static public int getMaxCityNum(int[][] matrix, final int origin,final int maxStep){
        if (matrix.length <=0 || matrix.length != matrix[0].length){return 0;}
        init(matrix.length);
        getMaxCityNum(matrixToAdjacencyList(matrix), matrix.length, origin, maxStep, 0);
        return maxVisitedCount;
    }

    static public int getMaxCityNum(Map<Integer, List<Integer>> adjacencyList, final int cityNum, final int origin,final int maxStep){
        if (cityNum <=0){return 0;}
        init(cityNum);
        getMaxCityNum(adjacencyList, cityNum, origin, maxStep, 0);
        return maxVisitedCount;
    }

    static private void init(final int cityNum){
        visitedCount = new int[cityNum];
        maxVisitedCount = 0;
    }

    static private void getMaxCityNum(Map<Integer, List<Integer>> adjacencyList, final int cityNum, final int origin, final int maxStep, int count){
        if (!adjacencyList.containsKey(origin)){
            maxVisitedCount = 0;
            return;
        }
        if (maxStep <= 0){
            if (count > maxVisitedCount){maxVisitedCount = count;}
            return;
        }
        if (visitedCount[origin] <= 0){count++;}
        visitedCount[origin]++;
        for (int curCity : adjacencyList.get(origin)) {
            getMaxCityNum(adjacencyList, cityNum, curCity, maxStep - 1, count);
        }
        visitedCount[origin]--;
    }

    static private Map<Integer, List<Integer>> matrixToAdjacencyList(int[][] matrix){
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] >= 0){
                    if (!adjacencyList.containsKey(i)){
                        adjacencyList.put(i, new ArrayList<>());
                    }
                    adjacencyList.get(i).add(j);
                }
            }
        }
        return adjacencyList;
    }
}
