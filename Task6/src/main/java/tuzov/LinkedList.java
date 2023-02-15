package tuzov;

public class LinkedList<T> {

    /**
     * @param <T> Type
     */
    static class Node<T> {
        Node<T> prev, next;
        T value;

        /**
         * @param value actual element to be stored
         * @param prev previous node
         */
        Node(T value, Node<T> prev){
            this.value = value;
            this.prev = prev;
            this.next = null;
        }
    }

    Node<T> lastNode = null;
    Node<T> firstNode = null;

    /**
     * @param element add Node to end of the list
     */
    public void addLast(T element) {
        if (firstNode == null) {
            lastNode = new Node<>(element, null);
            firstNode = lastNode;
        }
        else {
            lastNode = new Node<>(element, lastNode);
            lastNode.prev.next = lastNode;
        }
    }

    /**
     * @param element add Node to start of the list
     */
    public void addFirst(T element){
        if (firstNode == null) {
            lastNode = new Node<>(element, null);
            firstNode = lastNode;
        }
        else{
            firstNode.prev = new Node<>(element, null);
            firstNode.prev.next = firstNode;
            firstNode = firstNode.prev;
        }
    }

    /**
     * @return last Node value or null
     */
    public T getLast(){
        return lastNode != null ? lastNode.value : null;
    }

    /**
     * @return first Node value or null
     */
    public T getFirst(){
        return firstNode != null ? firstNode.value : null;
    }

    /**
     * @param index index of the Node element
     * @return Node object or null
     */
    private Node<T> getNode(int index){
        int c = 0;
        Node<T> currentNode = firstNode;
        while (currentNode != null && c != index) {
            currentNode = currentNode.next;
            c++;
        }
        return currentNode;
    }

    /**
     * @param index index of the Node element
     * @return Node value or null
     */
    public T get(int index){
        Node<T> node = getNode(index);

        return node != null ? node.value : null;
    }

    /**
     * @param element value of the Node
     * @param index index at which new Node should be places. If out of bounds, Node will be added to end
     */
    public void add(T element, int index){
        Node<T> node = getNode(index);

        if (node == null)
            addLast(element);
        else{
            if (node == firstNode){
                addFirst(element);
            }
            else if (node == lastNode){
                addLast(element);
            }
            else {
                Node<T> newNode = new Node<>(element, node.prev);
                newNode.next = node;
                node.prev.next = newNode;
                node.prev = newNode;
            }
        }
    }

    /**
     * @param index index of the Node to be removed
     * handles removing of last, first or single Node
     */
    public void remove(int index){
        Node<T> node = getNode(index);

        if (node != null){
            if (node == lastNode && node == firstNode){
                firstNode = null;
                lastNode = null;
            }
            else if (node == lastNode) {
                node.prev.next = null;
                lastNode = node.prev;
            }
            else if (node == firstNode) {
                node.next.prev = null;
                firstNode = node.next;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }
}
