package mqexercise;

import java.util.HashMap;
import java.util.Map;

public class LRUTest {


    /**
     * KV存储抽象
     */
    public interface Storage<K, V> {
        /**
         * 根据提供的key来访问数据
         *
         * @param key 数据Key
         * @return 数据值
         */
        V get(K key);
    }

    /**
     * LRU缓存。你需要继承这个抽象类来实现LRU缓存。
     *
     * @param <K> 数据Key
     * @param <V> 数据值
     */
    public abstract class LruCache<K, V> implements Storage<K, V> {
        // 缓存容量
        protected final int capacity;
        // 低速存储，所有的数据都可以从这里读到
        protected final Storage<K, V> lowSpeedStorage;

        public LruCache(int capacity, Storage<K, V> lowSpeedStorage) {
            this.capacity = capacity;
            this.lowSpeedStorage = lowSpeedStorage;
        }
    }

    class LRU<K, V> extends LruCache {

        Map<Object, Node> nodeMap;

        class Node<V> {
            V val;
            K key;
            Node prev;
            Node next;
        }

        Node first;
        Node last;

        public LRU(int capacity, Storage lowSpeedStorage) {
            super(capacity, lowSpeedStorage);
            nodeMap = new HashMap<>(capacity);
        }

        @Override
        public Object get(Object key) {
            Node node;
            if ((node = nodeMap.get(key)) == null) {
                put(key, lowSpeedStorage.get(key));
            }
            moveToHead(node);
            return node.val;
        }

        private void moveToHead(Node node) {
            if (first == node) return;
            if (last == node) {
                last.prev.next = null;
                last = last.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.next = first;
            first.prev = node;
            first = node;
        }

        private void put(Object key, Object val) {
            Node node = nodeMap.get(key);
            if (node == null) {
                node = new Node();
                node.key = key;
                node.val = val;
                if (nodeMap.size() == capacity) {
                    removeLast();
                }
                addToHead(node);
                nodeMap.put(key, node);
            } else {
                node.val = val;
                moveToHead(node);
            }
        }

        private void addToHead(Node node) {
            if (nodeMap.isEmpty()) {
                first = node;
                last = node;
            } else {
                node.next = first;
                first.prev = node;
                first = node;
            }
        }

        private void removeLast() {
            nodeMap.remove(last.key);
            Node prevNode = last.prev;
            if (prevNode != null) {
                prevNode.next = null;
                last = prevNode;
            }

        }
    }
}
