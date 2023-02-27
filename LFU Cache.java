/*Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.
*/

class LFUCache {
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }
    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }
        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }
    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }
    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
