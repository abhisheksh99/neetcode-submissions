public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
        }

        for (String k : graph.keySet()) {
            for (String i : graph.get(k).keySet()) {
                for (String j : graph.get(k).keySet()) {
                    graph.computeIfAbsent(i, x -> new HashMap<>()).putIfAbsent(j, graph.get(i).get(k) * graph.get(k).get(j));
                }
            }
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (graph.containsKey(a) && graph.get(a).containsKey(b)) {
                result[i] = graph.get(a).get(b);
            } else {
                result[i] = -1.0;
            }
        }

        return result;
    }
}