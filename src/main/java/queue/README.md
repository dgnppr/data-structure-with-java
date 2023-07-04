# Queue

### 구현

#### [Array Queue](./ArrayQueue.java)

- Queue with array

#### [Node Queue](./NodeQueue.java)

- Queue with node

#### [Stack Queue](./StackQueue.java)

- Queue using two stacks

#### [Animal Queue](./AnimalQueue.java)

- Basic Queue function + specific type dequeue

```java
public interface MyQueue<E> {

    void enqueue(E data);

    E dequeue();

    E front();

    E rear();

    int size();

    boolean isEmpty();

    boolean isFull();
}

```
