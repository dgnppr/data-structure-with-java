# Stack

### 구현

#### [Array Stack](./ArrayStack.java)

- Stack with array

#### [Node Stack](./NodeStack.java)

- Stack element with Pointer

#### [Queue Stack](./QueueStack.java)

- Stack With Queue

#### [Min Array Stack](./MinArrayStack.java)

- Top of stack is minimum

#### [Min Node Stack](./MinNodeStack.java)

- Top of stack is minimum

#### [Three Stack Using One Array](./ThreeStackUsingOneArray.java)

- Three Stack Using One Array

#### [Sorting Stack](./SortingStack.java)

- sort with using stack
- merge sort with using stack

#### [StackOfStack](./StackOfStack.java)

- Stack Of Stack which operates same as a single stack

#### [SetOfStack](./SetOfStack.java)

- Set Of Stack which operates same as a single stack

#### [StackConverter](./StackConverter.java)

- impl stack that converts infix notation to prefix/suffix notation
    - Infix notation ex = `1+2*3`
    - Prefix notation ex = `*+123`
    - Suffix notation ex = `123*+`

```java
public interface MyStack<E> {
    void push(E data);

    E pop();

    E top();

    void clear();

    boolean isFull();

    boolean isEmpty();
}
```