class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list = new LinkedList<>();
        int depth = (int)(Math.log(label) / Math.log(2));
        //System.out.println(depth);
        list.addFirst(label);
        while(label > 1) {
            label = getParent(label, depth);
            list.addFirst(label);
            depth--;
            
        }
        return list;
    }
    
    private int getParent(int label, int depth) {
        // (max at last level) + (min at last level - 1) - [expected parent]
        return (1 << depth) - 1 + (1 << (depth - 1)) - (label / 2);
    }
}
