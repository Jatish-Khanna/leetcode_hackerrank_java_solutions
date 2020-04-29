class FirstUnique {
    
    HashMap<Integer, Integer> seen;
    ListNode head;
    ListNode tail;
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public FirstUnique(int[] nums) {
        seen = new HashMap<>();
        head = new ListNode(-1);
        tail = head;
        for(int num : nums) {
            add(num);
        }
        head = head.next;
    }
    
    public int showFirstUnique() {
        while(head != null) {
            if(seen.get(head.val) > 1) {
                head = head.next;
            } else {
                break;
            }
        }
        return head != null ? head.val : -1;
    }
    
    public void add(int num) {
            tail.next = new ListNode(num);
            tail = tail.next;
            if(head == null) {
                head = tail;
            }
            seen.put(num, seen.getOrDefault(num, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
