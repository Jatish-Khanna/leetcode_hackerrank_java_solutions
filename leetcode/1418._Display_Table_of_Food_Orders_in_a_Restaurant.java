class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, HashMap<String, Integer>> tables = new TreeMap<String, HashMap<String, Integer>>((e1, e2) -> {
            return Integer.parseInt(e1) - Integer.parseInt(e2);
        });
        HashSet<String> foodItems = new HashSet();
        String item;
        for(List<String> order : orders) {
            item = order.get(2);
            foodItems.add(item);
            tables.computeIfAbsent(order.get(1), k -> new HashMap<>());
            HashMap<String, Integer> counts = tables.get(order.get(1));
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        List<String> foodList = new ArrayList<>(foodItems);
        Collections.sort(foodList);
        // System.out.println(tables);
        List<List<String>> display = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodList);
        display.add(header);
        List<String> rowList;
        for(Map.Entry<String, HashMap<String, Integer>> row : tables.entrySet()) {
            rowList = new ArrayList<>();
            rowList.add(row.getKey());
            Map<String, Integer> values = row.getValue();
            for(String food : foodList) {
                if(!values.containsKey(food)) {
                    rowList.add("0");
                } else {
                    rowList.add(String.valueOf(values.get(food)));
                }
            }
            display.add(rowList);
        }
        
        return display;
    }
}
