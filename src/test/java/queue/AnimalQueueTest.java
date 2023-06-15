package queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static queue.AnimalQueue.AnimalNode;
import static queue.AnimalQueue.Species.CAT;
import static queue.AnimalQueue.Species.DOG;

class AnimalQueueTest {

    AnimalQueue queue;

    @BeforeEach
    void setUp() {
        queue = new AnimalQueue();
    }

    private void init() {
        queue.enqueue(new AnimalNode(DOG));
        queue.enqueue(new AnimalNode(CAT));
        queue.enqueue(new AnimalNode(CAT));
        queue.enqueue(new AnimalNode(CAT));
        queue.enqueue(new AnimalNode(DOG));
        queue.enqueue(new AnimalNode(DOG));
        queue.enqueue(new AnimalNode(CAT));
    }


    @Test
    void enqueue() {
        queue.enqueue(new AnimalNode(DOG));
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(DOG);

        queue.enqueue(new AnimalNode(CAT));
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        queue.enqueue(new AnimalNode(DOG));
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(DOG);

        queue.enqueue(new AnimalNode(CAT));
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);
    }

    @Test
    void dequeue() {
        init();

        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(DOG);
        Assertions.assertThat(queue.front().getSpecies()).isEqualTo(CAT);
        Assertions.assertThat(queue.rear().getSpecies()).isEqualTo(CAT);

        Assertions.assertThat(queue.dequeue().getSpecies()).isEqualTo(CAT);
        Assertions.assertThatThrownBy(() -> queue.front()).isInstanceOf(QueueEmptyException.class);
        Assertions.assertThatThrownBy(() -> queue.rear()).isInstanceOf(QueueEmptyException.class);
    }

    @Test
    void dequeueDogAndCat() {
        // DOG CAT CAT CAT DOG DOG CAT
        AnimalNode node1 = new AnimalNode(DOG);
        AnimalNode node2 = new AnimalNode(CAT);
        AnimalNode node3 = new AnimalNode(CAT);
        AnimalNode node4 = new AnimalNode(CAT);
        AnimalNode node5 = new AnimalNode(DOG);
        AnimalNode node6 = new AnimalNode(DOG);
        AnimalNode node7 = new AnimalNode(CAT);

        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        queue.enqueue(node4);
        queue.enqueue(node5);
        queue.enqueue(node6);
        queue.enqueue(node7);

        Assertions.assertThat(queue.dequeueDog()).isEqualTo(node1);
        Assertions.assertThat(queue.front()).isEqualTo(node2);
        Assertions.assertThat(queue.rear()).isEqualTo(node7);

        Assertions.assertThat(queue.dequeueDog()).isEqualTo(node5);
        Assertions.assertThat(queue.front()).isEqualTo(node2);
        Assertions.assertThat(queue.rear()).isEqualTo(node7);

        Assertions.assertThat(queue.dequeueDog()).isEqualTo(node6);
        Assertions.assertThat(queue.front()).isEqualTo(node2);
        Assertions.assertThat(queue.rear()).isEqualTo(node7);

        Assertions.assertThatThrownBy(() -> queue.dequeueDog()).isInstanceOf(NotExistingAnimalException.class);

        Assertions.assertThat(queue.dequeueCat()).isEqualTo(node2);
        Assertions.assertThat(queue.front()).isEqualTo(node3);
        Assertions.assertThat(queue.rear()).isEqualTo(node7);

        Assertions.assertThat(queue.dequeueCat()).isEqualTo(node3);
        Assertions.assertThat(queue.front()).isEqualTo(node4);
        Assertions.assertThat(queue.rear()).isEqualTo(node7);

        Assertions.assertThat(queue.dequeueCat()).isEqualTo(node4);
        Assertions.assertThat(queue.front()).isEqualTo(node7);
        Assertions.assertThat(queue.rear()).isEqualTo(node7);

        Assertions.assertThat(queue.dequeueCat()).isEqualTo(node7);

        Assertions.assertThatThrownBy(() -> queue.dequeueDog()).isInstanceOf(NotExistingAnimalException.class);
        Assertions.assertThatThrownBy(() -> queue.dequeueCat()).isInstanceOf(NotExistingAnimalException.class);
    }
}