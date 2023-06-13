package bbst;

import java.util.List;

public interface BBSTree<K, V> {

    void add(K key, V value);

    boolean remove(K key);

    V search(K key);

    List<K> preOrderTraversal();

    List<K> inOrderTraversal();

    List<K> postOrderTraversal();

    K getMinKey();

    K getMaxKey();

    V getValueWithMinKey();

    V getValueWithMaxKey();
}
