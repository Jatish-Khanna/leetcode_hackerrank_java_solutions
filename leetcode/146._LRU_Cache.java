class LRUCache {

    class ListNode {
        int key;
        int value;
        int hash;
        ListNode next;
        ListNode prev;
        ListNode forward;
        ListNode(int key, int value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
    
    ListNode head;
    ListNode tail;
    ListNode []ar;
    int capacity;
    int count = 0;
    
    public LRUCache(int capacity) {
        ar = new ListNode[capacity];
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node = getEntry(key);
        
        if(node == null) {
            return -1;
        }
        remove(node);
        addFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        ListNode node = getEntry(key);
        if(node == null) {
            node = new ListNode(key, value, key % capacity);
            node.next = ar[key % capacity];
            ar[key % capacity] = node;
            if(count == capacity) {
                removeEntry(tail);
                remove(tail);
            } else {
                count++;
            }
        } else {
            remove(node);
            node.value = value;
        }
        addFront(node);
    }
    
    private void remove(ListNode node) {
        if(head == node) {
            head = head.forward;
            node.forward = null;
        } else if(node == tail) {
            tail = tail.prev;
            node.prev = null;
        } else {
            node.prev.forward = node.forward;
            node.forward.prev = node.prev;
            node.forward = null;
            node.prev = null;
        }
        
    }
    
    private void removeEntry(ListNode node) {
        ListNode front = ar[node.hash];
        if(front == node) {
            ar[node.hash] = front.next;
            return;
        } 
        
        while(front.next != node) {
            front = front.next;
        }
        front.next = node.next;
    }
    
    private void addFront(ListNode node) {
        if(head == null) {
            head = node;
            tail = head;
            return;
        } else {
            head.prev = node;
            node.forward = head;
            head = node;
            
        }
    }
    
    public ListNode getEntry(int key) {
        
        ListNode node = ar[key % capacity];
        
        while(node != null) {
            
            if(node.key == key) {
                break;
            }
            node = node.next;
        }
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
