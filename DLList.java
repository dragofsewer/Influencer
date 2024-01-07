// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a Doubly Linked List.
 * 
 * @param <E>
 *            The type of object stored in the DLList.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.16
 */
public class DLList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Creates a DLList object.
     */
    public DLList() {
        init();
    }


    /**
     * Initializes an empty DLList.
     */
    private void init() {
        head = new Node<E>(null);
        tail = new Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Getter for size.
     * 
     * @return The int value stored in size.
     */
    public int size() {
        return size;
    }


    /**
     * Determines whether or not the DLList is empty.
     * 
     * @return True if the DLList is empty. Otherwise, False.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Removes all elements stored in the DLList.
     */
    public void clear() {
        init();
    }


    /**
     * Determines whether or the DLList contains the given
     * Type E object.
     * 
     * @param obj
     *            The object to check for
     * @return True if the DLList contains the given object. Otherwise,
     *         False.
     */
    public boolean contains(E obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Gets the object stored at the given index in the DLList.
     * 
     * @param index
     *            The location the object is stored in the DLList.
     * @return The object at the given index
     * @throws IndexOutOfBoundsException
     *             if there is no Node at the given
     *             index.
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Finds the String representation of the DLList.
     * 
     * @return The String representation of the current DLList.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            Node<E> current = head.next();
            while (current != tail) {
                E element = current.getData();
                builder.append(element.toString());
                if (current.next != tail) {
                    builder.append(", ");
                }
                current = current.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * Adds a given object to the end of the DLList.
     * 
     * @param obj
     *            Type E object that will be added to the DLList.
     */
    public void add(E obj) {
        add(size(), obj);
    }


    /**
     * Adds a given object to a given index in the DLList.
     * 
     * @param index
     *            The location the object will be added to.
     * @param obj
     *            The Type E object that will be added to the DLList.
     * @throws IndexOutOfBoundsException
     *             If the given index is negative
     *             or greater than the DLList size.
     * @throws IllegalArgumentException
     *             If the given object is null.
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;
    }


    /**
     * Removes the Node at the given index from the DLList.
     * 
     * @param index
     *            The location of the object that will be removed.
     * @return True if the removal was successful.
     */
    public boolean remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes a given Node from the DLList.
     * 
     * @param obj
     *            Type E object that will be removed from the DLList.
     * @return True if the removal was successful.
     */
    public boolean remove(E obj) {
        Node<E> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(obj)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Finds the last index of a given object in the DLList.
     * 
     * @param obj
     *            Type E object that whose index will be searched for.
     * @return The last position of the given object. If the object
     *         is not in the DLList, then -1 is returned.
     */
    public int lastIndexOf(E obj) {
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1;
    }


    /**
     * Finds the Node at a given index in the DLList.
     * 
     * @param index
     *            location of the Node in the DLList.
     * @return The Node at the given index.
     */
    public Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Returns an iterator over elements of type E.
     * 
     * @return An iterator object for the DLList.
     */
    public Iterator<E> iterator() {
        return new DLListIterator();
    }

    /**
     * Iterator implementation for a DLList.
     * 
     * @author Aixa Atoa Ortiz (aixa)
     * @author Jack Yang
     * @author Stephen Ye
     * @version 2022.11.16
     */
    private class DLListIterator implements Iterator<E> {
        private Node<E> next;
        private boolean newCurr;

        /**
         * Creates a new DLListIterator.
         */
        public DLListIterator() {
            next = head;
            newCurr = false;
        }


        /**
         * Checks if there are more elements in the DLlist.
         *
         * @return True if there are more elements in the DLList. Otherwise,
         *         False.
         */
        @Override
        public boolean hasNext() {
            return (next.next().getData() != null);
        }


        /**
         * Gets the next value in the DLList.
         *
         * @return the next value in the DLList.
         * @throws NoSuchElementException
         *             if there are no nodes left in
         *             the list.
         */
        @Override
        public E next() {
            if (next.next().getData() == null) {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            E value = next.next.getData();
            next = next.next();
            newCurr = true;
            return value;
        }
    }


    /**
     * Represents a Node in the DLList.
     * 
     * @param <E>
     *            The type of object stored in the Node.
     * 
     * @author Aixa Atoa Ortiz (aixa)
     * @author Jack Yang
     * @author Stephen Ye
     * @version 2022.11.16
     */
    public static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        /**
         * Initializes a Node that stores a given type E object.
         * 
         * @param data
         *            The data that will be stored in the Node.
         */
        public Node(E data) {
            this.data = data;
        }


        /**
         * Setter for previous.
         * 
         * @param node
         *            The Node object that previous will store.
         */
        public void setPrevious(Node<E> node) {
            previous = node;
        }


        /**
         * Setter for next.
         * 
         * @param node The
         *            Node object that next will store.
         */
        public void setNext(Node<E> node) {
            next = node;
        }


        /**
         * Getter for previous
         * 
         * @return The Node object stored in previous.
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * Getter for next
         * 
         * @return The Node object stored in next.
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Getter for data
         * 
         * @return The Type E object stored in data.
         */
        public E getData() {
            return data;
        }
    }
}