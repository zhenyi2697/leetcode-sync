/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // get all nodes
        List<Node> nodes = getNodes(node);

        // create new nodes and store mapping from old => new node
        Map<Node, Node> mapping = new HashMap();
        for(Node n : nodes) {
            mapping.put(n, new Node(n.val));
        }

        // copy edges
        for(Node n : nodes) {
            Node newNode = mapping.get(n);

            for(Node neighbor : n.neighbors) {
                newNode.neighbors.add(mapping.get(neighbor));
            }
        }

        return mapping.get(node);
    }

    private List<Node> getNodes(Node root) {
        Queue<Node> queue = new LinkedList();
        Set<Node> set = new HashSet();

        queue.add(root);
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            set.add(n);

            for(Node neighbor : n.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return new ArrayList(set);
    }
}