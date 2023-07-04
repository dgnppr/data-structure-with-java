# BST

### 특징

- 모든 노드의 왼쪽 서브 트리는 해당 노드의 값보다 작은 값들만 가지고, 모든 노드의 오른쪽 서브 트리는 해당 노드의 값보다 큰 값들만 가진다.
- 이진 탐색 트리의 최소값은 트리의 가장 왼쪽에 존재한다.
- 이진 탐색 트리의 최대값 트리의 가장 오른쪽에 존재한다.

### 시간 복잡도

|        | Avg Case | Worst Case |
|--------|----------|------------|
| Add    | O(logN)  | O(N)       |
| Remove | O(logN)  | O(N)       |
| Search | O(logN)  | O(N)       |

### 장점

- 보통은 삽입,삭제, 검색이 빠르다.
- 값의 순서대로 순회 가능하다.(inOrder 순회)

### 단점

- 트리가 구조적으로 한쪽으로 편향되면 삽입,삭제, 검색 등등 여러 동작들의 수행 시간이 악화된다.

### Successor

- 해당 노드보다 값이 큰 노드들 중에서 가장 값이 작은 노드

### Predecessor

- 해당 노드보다 값이 작은 노드들 중에서 가장 값이 큰 노드

### 구현

[Binary Search Tree](./BSTree.java)

```java
public interface MyTree<K, V> {

    Node<K, V> search(K key);

    boolean contains(K key);

    boolean add(K key, V value);

    boolean remove(K key);

    Node<K, V> getSuccessor(K key);

    Node<K, V> getPredecessor(K key);

    List<K> postOrderTraversal();

    List<K> inOrderTraversal();

    List<K> preOrderTraversal();
}
```

**BST에서 삭제**

- 자녀가 없는 노드 삭제
    - 삭제될 노드를 가리키는 레퍼런스를 가리키는 것이 없도록 처리
- 자녀가 하나인 노드 삭제
    - 삭제될 노드를 가리키던 레퍼런스를 삭제될 노드의 자녀를 가리키게 변경
- 자녀가 2개인 노드 삭제
    - 삭제 노드의 Successor 혹은 Predecessor를 삭제 노드로 이동 후
    - 이동할 노드의 자식 노드는 부모 노드의 자식 노드로 변경
