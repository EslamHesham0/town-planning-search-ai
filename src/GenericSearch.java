import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class GenericSearch<T, U> {
    static String input = "21;" +
            "15,19,13;" +
            "50,50,50;" +
            "12,2;16,2;9,2;" +
            "3076,15,26,28,40;" +
            "5015,25,15,15,38;";
    static String Answer = "";
    static TownState initialStatee;
    static int BFSCounter = 0;

    public GenericSearch() {
    }

    public static void main(String[] args) {

        initialStatee = TownState.fromString(input);

        String solution = breadthFirstSearch(initialStatee, true);

        System.out.println(solution);
    }

    private static String reconstructPlan(NodeH goalNode) {
        StringBuilder plan = new StringBuilder();
        NodeH current = goalNode;
        int moneySpent = 0;
        boolean isFirst = true;

        while (current.parent != null) {
            if (!isFirst) {
                plan.insert(0, ",");
            } else {
                isFirst = false;
            }
            plan.insert(0, current.action);
            current = current.parent;
        }

        moneySpent = 100000 - goalNode.state.getMoney();

        return plan.toString() + ";" + moneySpent;
    }

    private static void getPathtoGoal(NodeH goalNode) {
        NodeH current = goalNode;
        List<NodeH> path = new ArrayList<>();

        // Traverse to the root and store the path in a list
        while (current != null) {
            path.add(current);
            current = current.parent;
        }

        // Print the town status for each node in reverse order (from initial to goal)
        Collections.reverse(path);
        for (NodeH node : path) {
            node.state.GetTownStatus();
            System.out.println("\n---------------------\n"); // Add space between town statuses
        }

    }

    public static String breadthFirstSearch(TownState initialState, boolean visualize) {

        Action actionn = new Action(initialState);

        NodeH rootNode = new NodeH(initialState, null, null);
        Set<TownState> visitedNodes = new HashSet<>();
        Queue<NodeH> Tree = new LinkedList<>();
        Tree.add(rootNode);
        visitedNodes.add(rootNode.state);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.poll();
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {

                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(children);
            BFSCounter += children.size();
        }
        return "NOSOLUTION";

    }

    public static String depthFirstSearch(TownState initialState, boolean visualize) {
        Action actionn = new Action(initialState);

        NodeH rootNode = new NodeH(initialState, null, null);

        List<NodeH> Tree = new LinkedList<>();
        Set<TownState> visitedNodes = new HashSet<>();
        Tree.add(0, rootNode);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.remove(0);
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {

                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(0, children);
            BFSCounter += children.size();

        }

        return "NOSOLUTION";
    }

    public static String iterativeDeepeningSearch(TownState initialState, boolean visualize) {
        NodeH initialNode = new NodeH(initialState, null,null);
        int depth = 0;
        while (true) {
            String resultNode = getNodesInDepth(initialNode, depth ,visualize);
            if (resultNode != null) {
                return resultNode;
            }
            depth++;
        }
    }

    private static List<NodeH> getChildren(NodeH node, Set<TownState> visitedNodes) {
    	List<NodeH> children = new LinkedList<>();
    	TownState currentState = node.state;
    	Action actionn = new Action(currentState);
    	
        for (String actionType : getValidActions(currentState)) {
            if (actionn.isValidAction(actionType)) {
            	BFSCounter++;
            	TownState copyCurrent = new TownState(currentState);
                TownState nextState = applyAction(copyCurrent, actionType);
                NodeH childNode = new NodeH(nextState, actionType, node);
                if (!visitedNodes.contains(childNode.state)) {
                    visitedNodes.add(childNode.state);
                    children.add(childNode);
                }
            }
        }
        return children;
    }

    private static String getNodesInDepth(NodeH initialNode, int depthLimit, boolean visualize) {
	    Stack<NodeH> Tree = new Stack<>();
        Set<TownState> visitedNodes = new HashSet<>();
	    Tree.add(initialNode);
	    int nodeCount = 0;

	    while (!Tree.isEmpty()) {
	        NodeH node = Tree.pop();
	        nodeCount++;
	        if (isGoalState(node.getState())) {
            	if(visualize)
            		getPathtoGoal(node);
                return reconstructPlan(node)+ ";" + nodeCount;
	        }

	        if (node.depth < depthLimit) {
	        	
	            List<NodeH> children = getChildren(node, visitedNodes);
	            Tree.addAll(children);
	        }
	    }
	    return null;
    }

    public static String UCSSearch(TownState initialState, boolean visualize) {

        Action actionn = new Action(initialState);
        NodeH rootNode = new NodeH(initialState, null, null);
        Set<TownState> visitedNodes = new HashSet<>();
        PriorityQueue<NodeH> Tree = new PriorityQueue<>(Comparator.comparingInt(NodeH::getPathCost));
        Tree.add(rootNode);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.remove();
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {
                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(children);
            BFSCounter += children.size();
        }
        return "NOSOLUTION";

    }

    public static String GR1Search(TownState initialState, boolean visualize) {

        Action actionn = new Action(initialState);
        NodeH rootNode = new NodeH(initialState, null, null);
        Set<TownState> visitedNodes = new HashSet<>();
        PriorityQueue<NodeH> Tree = new PriorityQueue<>(Comparator.comparingInt(NodeH::getGreedy1));
        Tree.add(rootNode);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.remove();
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {

                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(children);
            BFSCounter += children.size();

        }
        return "NOSOLUTION";

    }

    public static String GR2Search(TownState initialState, boolean visualize) {

        Action actionn = new Action(initialState);
        NodeH rootNode = new NodeH(initialState, null, null);
        Set<TownState> visitedNodes = new HashSet<>();
        PriorityQueue<NodeH> Tree = new PriorityQueue<>(Comparator.comparingInt(NodeH::getGreedy2));
        Tree.add(rootNode);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.remove();
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {

                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(children);
            BFSCounter += children.size();

        }
        return "NOSOLUTION";

    }

    public static String AS1Search(TownState initialState, boolean visualize) {

        Action actionn = new Action(initialState);
        NodeH rootNode = new NodeH(initialState, null, null);
        Set<TownState> visitedNodes = new HashSet<>();
        PriorityQueue<NodeH> Tree = new PriorityQueue<>(Comparator.comparingInt(NodeH::getAstar1));
        Tree.add(rootNode);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.remove();
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {

                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(children);
            BFSCounter += children.size();
        }
        return "NOSOLUTION";

    }

    public static String AS2Search(TownState initialState, boolean visualize) {

        Action actionn = new Action(initialState);
        NodeH rootNode = new NodeH(initialState, null, null);
        Set<TownState> visitedNodes = new HashSet<>();
        PriorityQueue<NodeH> Tree = new PriorityQueue<>(Comparator.comparingInt(NodeH::getAstar2));
        Tree.add(rootNode);

        while (!Tree.isEmpty()) {
            NodeH currentNode = Tree.remove();
            TownState currentState = currentNode.state;

            if (isGoalState(currentState)) {

                if (visualize)
                    getPathtoGoal(currentNode);
                return reconstructPlan(currentNode) + ";" + BFSCounter;
            }

            List<NodeH> children = getChildren(currentNode, visitedNodes);
            Tree.addAll(children);
            BFSCounter += children.size();
        }
        return "NOSOLUTION";

    }

    private static boolean isGoalState(TownState state) {
        if (state != null)
            return state.getProsperity() >= 100;
        return false;
    }

    private static List<String> getValidActions(TownState state) {
        List<String> validActions = new ArrayList<>();
        Action action = new Action(state);
        // Check each action type and add to the list if it's a valid action
        if (action.isValidAction("RequestFood")) {
            validActions.add("RequestFood");
            state.getDelayRequestFood();
        }
        if (action.isValidAction("RequestMaterials")) {
            validActions.add("RequestMaterials");
            state.getDelayRequestMaterials();
        }
        if (action.isValidAction("RequestEnergy")) {
            validActions.add("RequestEnergy");
            state.getDelayRequestEnergy();
        }
        if (action.isValidAction("WAIT")) {
            validActions.add("WAIT");
        }
        if (action.isValidAction("BUILD1")) {
            validActions.add("BUILD1");
        }
        if (action.isValidAction("BUILD2")) {
            validActions.add("BUILD2");
        }
        return validActions;
    }

    private static TownState applyAction(TownState state, String actionType) {
        // Create an Action object to perform action
    	TownState copy = new TownState(state);
    	Action action = new Action(copy);
    	
        // Use the Action object to perform the specified action
        switch (actionType) {
            case "RequestFood":
                action.RequestFood();
                copy.Request=true;
                break;
            case "RequestMaterials":
                action.RequestMaterials();
                copy.Request=true;
                break;
            case "RequestEnergy":
                action.RequestEnergy();
                copy.Request=true;
                break;
            case "WAIT":
                action.WAIT();
                break;
            case "BUILD1":
                action.BUILD1();
                break;
            case "BUILD2":
                action.BUILD2();
                break;
        }
    
        // Return the updated state after applying the action
        return copy;
    }
}
