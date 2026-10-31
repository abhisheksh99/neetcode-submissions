class TimeMap {
    // Map to store key-value pairs with timestamps
    private Map<String, TreeMap<Integer, String>> map;

    // Initialize the data structure with an empty HashMap
    public TimeMap() {
        map = new HashMap<>();
    }
    
    // Store key, value, and timestamp in the map
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    // Retrieve the most recent value for a key before or at the given timestamp
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}