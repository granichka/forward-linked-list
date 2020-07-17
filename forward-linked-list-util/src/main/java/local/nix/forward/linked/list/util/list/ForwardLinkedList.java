package local.nix.forward.linked.list.util.list;
import local.nix.forward.linked.list.util.node.Node;

import java.util.AbstractList;

public class ForwardLinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public boolean add(E value) {
        linkLast(value);
        return true;
    }


    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldValue = node.getValue();
        node.setValue(element);
        return oldValue;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);

        if(index == size) {
            linkLast(element);
        } else {
            Node<E> newNode = new Node<>();
            newNode.setValue(element);
            Node<E> node = node(index);
            newNode.setNext(node);
            Node<E> previous = node(index - 1);
            if(previous == first) {
                first = newNode;
            } else {
                previous.setNext(newNode);
            }

            size++;
        }
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).getValue();
    }


    @Override
    public int size() {
        return size;
    }


    public boolean rmv(E e) {
        Node<E> previous = null;
        Node<E> current = first; //смещаем указатель на 1 элемент

        while(current != null) {
            if(current.getValue().equals(e)) {
                //узел в середине или в конце
                if(previous != null) {
                    previous.setNext(current.getNext());
                    if(current.getNext() == null) {
                        last = previous;
                    }
                } else {
                    first = first.getNext();
                    if(first == null) {
                        last = null;
                    }
                }

                size--;
                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;

    }

    public void clear() {
        for(Node<E> node = first; node != null;) {
            Node<E> next = node.getNext();
            node.setValue(null);
            node.setNext(null);
            node = next;

        }

        first = last = null;
        size = 0;
    }

    public boolean containsElement(E o) {
        Node<E> current = first;
        while(current != null) {
            if(current.getValue().equals(o)) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    private Node<E> node(int index) {
        Node<E> node = first;
        for(int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>();
        newNode.setValue(e);
        last = newNode;

        if(l == null) {
            first = newNode;
        } else {
            l.setNext(newNode);
        }
        size++;
    }

}


