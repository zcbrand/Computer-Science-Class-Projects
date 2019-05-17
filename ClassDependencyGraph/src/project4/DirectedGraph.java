package project4;

import java.util.*;

/**
 * Name: DirectedGraph.java
 * Author: Zachary Brandenburg
 * Date: 30 04 2019
 * Description: This class is used for building a directed graph using an adjacency list for storing relationships.
 * It contains a sub class defining a Vertex
 */
public class DirectedGraph<T> {

    private HashMap<Vertex<T>, Integer> vertexIntegerHashMap;
    private ArrayList<LinkedList<Integer>> adjacencyList;
    private Stack<Vertex<T>> neighbor;
    private Set<T> vertexLabelNames;
    private Integer verticesCount;
    private StringBuilder output;

    /**
     * Constructor for DirectedGraph class
     */
    public DirectedGraph() {
        System.out.println("constructor");
        vertexIntegerHashMap = new HashMap<>();
        adjacencyList = new ArrayList<>();
        neighbor = new Stack<>();
        vertexLabelNames = new HashSet<>();
        verticesCount = 0;
        output = new StringBuilder();
    }

    /**
     * Builds the DirectedGraph
     * @param tokenList LinkedList of type T[]
     * @throws InvalidClassNameException throws when an invalid classname is detected
     */
    public void buildDirectedGraph(LinkedList<T[]> tokenList) throws InvalidClassNameException {
        System.out.println("buildGraph");
        for (T[] tokens : tokenList) {
            for (int i = 0; i < tokens.length; i++) {
                if (!vertexLabelNames.contains(tokens[i])) {
                    vertexLabelNames.add(tokens[i]);
                    addVertex(new Vertex<>(tokens[i]));
                }
                if (i != 0) {
                    addEdge(tokens[0], tokens[i]);
                }
            }
        }
    }

    /**
     * Builds the topological order from a stack based on the root class name
     * @param className name of class
     * @return String used for Topological order
     * @throws CycleDetectedException when a cycle is detected
     * @throws InvalidClassNameException when an invalid name is detected
     */
    public String topologicalOrder(String className) throws CycleDetectedException, InvalidClassNameException {
        System.out.println("topologicalOrder");
        depthFirstSearch(findVertex(className));
        while (!neighbor.isEmpty()) {
            output.append(neighbor.pop().toString()).append(" ");
        }
        return output.toString();
    }

    /**
     * Finds a vertex in a hash map from a class name
     * @param className name of class
     * @return Vertex
     * @throws InvalidClassNameException when an invalid name is detected
     */
    private Vertex<T> findVertex(String className) throws InvalidClassNameException {
        System.out.println("findVertex" + className);
        for (Vertex<T> currentVertex : vertexIntegerHashMap.keySet()) {
            if (currentVertex.getLabel().equals(className)) {
                return currentVertex;
            }
        }

        throw new InvalidClassNameException("Invalid Class Name!");
    }

    /**
     * Searches for and builds a stack based on a root vertex
     * @param root root vertex
     * @throws CycleDetectedException passes up this exception
     * @throws InvalidClassNameException passes up this exception
     */
    private void depthFirstSearch(Vertex<T> root) throws CycleDetectedException, InvalidClassNameException {
        System.out.println("depthFirstSearch");
        if (root.isDiscovered())
            throw new CycleDetectedException("Class cycle detected!");
        if (root.isFinished())
            return;
        root.setDiscovered(true);
        for (Integer i : adjacencyList.get(vertexIntegerHashMap.get(root))) {
            depthFirstSearch(getVertexFromIndex(i));
        }
        root.setFinished(true);
        neighbor.push(root);
    }

    /**
     *
     * @param value
     * @return
     * @throws InvalidClassNameException
     */
    private Vertex<T> getVertexFromIndex(int value) throws InvalidClassNameException{
        System.out.println("get vert from index");
        for (Vertex<T> vertex : vertexIntegerHashMap.keySet()) {
            if (vertexIntegerHashMap.get(vertex).equals(value)) {
                return vertex;
            }
        }
        throw new InvalidClassNameException("Couldn't find vertex");
    }

    /**
     * A new one way relationship
     * @param vertexFrom from vertex
     * @param vertexTo to vertex
     * @throws InvalidClassNameException passes up this exception
     */
    private void addEdge(T vertexFrom, T vertexTo) throws InvalidClassNameException {
        System.out.println("addEdge");
        Integer from = vertexIntegerHashMap.get(findVertex(vertexFrom.toString()));
        System.out.println("die after from " + from);
        Integer to = vertexIntegerHashMap.get(findVertex(vertexTo.toString()));
        System.out.println("die after to " + to);
        adjacencyList.get(from).add(to);
    }

    /**
     * Adds a vertex to the graph
     * @param vertex a new Vertex
     */
    private void addVertex(Vertex<T> vertex) {
        System.out.println("addVertex");
        vertexIntegerHashMap.put(vertex, verticesCount);
        adjacencyList.add(new LinkedList<>());
        verticesCount++;
    }

    /**
     * Vertex class
     * @param <E>
     */
    class Vertex<E> {

        private boolean isDiscovered;
        private boolean isFinished;
        private E label;

        Vertex(E label) {
            this.label = label;
            isDiscovered = false;
            isFinished = false;
        }

        boolean isDiscovered() {
            return isDiscovered;
        }

        void setDiscovered(boolean isDiscovered) {
            this.isDiscovered = isDiscovered;
        }

        boolean isFinished() {
            return isFinished;
        }

        void setFinished(boolean isFinished) {
            this.isFinished = isFinished;
        }

        E getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label.toString();
        }
    }
}
