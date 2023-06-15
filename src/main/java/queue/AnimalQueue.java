package queue;

import static queue.AnimalQueue.Species.CAT;
import static queue.AnimalQueue.Species.DOG;


public class AnimalQueue {

    private AnimalNode front;
    private AnimalNode rear;
    private AnimalNode frontDog;
    private AnimalNode frontCat;

    public AnimalQueue() {
        this.front = this.rear = this.frontDog = this.frontCat = null;
    }

    public void enqueue(AnimalNode node) {
        if (isEmpty()) {
            if (node.species == DOG) this.front = this.rear = this.frontDog = node;
            else this.front = this.frontCat = this.rear = node;
        } else {
            if (this.frontDog == null && node.species == DOG) this.frontDog = node;
            else if (this.frontCat == null && node.species == CAT) this.frontCat = node;
            this.rear.nxt = node;
            this.rear = node;
        }
    }

    public AnimalNode dequeue() {
        if (isEmpty()) throw new QueueEmptyException();
        AnimalNode animal = this.front;
        if (animal.species == DOG) this.frontDog = searchNextAnimal(this.front, DOG);
        else this.frontCat = searchNextAnimal(this.front, CAT);

        if (animal == rear) this.rear = null;
        this.front = this.front.nxt;

        return animal;
    }


    public AnimalNode dequeueDog() {
        if (isEmpty() || this.frontDog == null) throw new NotExistingAnimalException();

        if (front().species == DOG) return dequeue();
        else if (this.frontDog == this.rear) {
            AnimalNode ptr = this.front;
            while (ptr.nxt != rear) {
                ptr = ptr.nxt;
            }
            this.rear = ptr;
            AnimalNode ret = this.frontDog;
            this.frontDog = null;
            return ret;
        } else {
            AnimalNode ret = this.frontDog;
            AnimalNode ptr = this.front;
            while (ptr.nxt != ret) {
                ptr = ptr.nxt;
            }
            ptr.nxt = ret.nxt;
            this.frontDog = searchNextAnimal(this.frontDog, DOG);
            return ret;
        }
    }

    public AnimalNode dequeueCat() {
        if (isEmpty() || this.frontCat == null) throw new NotExistingAnimalException();

        if (front().species == CAT) return dequeue();
        else if (this.frontCat == this.rear) {
            AnimalNode ptr = this.front;
            while (ptr.nxt != rear) {
                ptr = ptr.nxt;
            }
            AnimalNode ret = this.frontCat;
            this.rear = ptr;
            this.frontCat = null;
            return ret;
        } else {
            AnimalNode ret = this.frontCat;
            AnimalNode ptr = this.front;
            while (ptr.nxt != ret) {
                ptr = ptr.nxt;
            }
            ptr.nxt = ret.nxt;
            this.frontCat = searchNextAnimal(this.frontCat, CAT);
            return ret;
        }

    }

    public AnimalNode front() {
        if (isEmpty()) throw new QueueEmptyException();
        return this.front;
    }

    private AnimalNode searchNextAnimal(AnimalNode node, Species species) {
        AnimalNode ptr = node.nxt;
        while (ptr != null) {
            if (ptr.species == species) return ptr;
            ptr = ptr.nxt;
        }
        return null;
    }

    public AnimalNode rear() {
        if (isEmpty()) throw new QueueEmptyException();
        return this.rear;
    }

    private boolean isEmpty() {
        return this.front == null;
    }

    enum Species {
        DOG, CAT;
    }

    static class AnimalNode {

        private Species species;
        private AnimalNode nxt;

        public AnimalNode(Species species) {
            this.species = species;
            this.nxt = null;
        }

        public Species getSpecies() {
            return species;
        }
    }
}
