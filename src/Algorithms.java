//shraddha Bhise

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Algorithms 
{
	private Node startNode;
    private String finalState;

 // declares start and goal states
    public Algorithms(Node root, String goalState) {
        this.startNode = root;
        this.finalState = goalState;
    }
    
    // gets the root node/start node
    public Node getRoot() {
        return startNode;
    }
    
    // set the node as start node
    public void setRoot(Node root) {
        this.startNode = root;
    }
    
    // gets the final state
    public String getGoalSate() {
        return finalState;
    }

    // sets the final state 
    public void setGoalSate(String goalState) {
        this.finalState = goalState;
    }
    
    // Best First Search Algorithm
	public void bestFirstSearch(Possibility.Heuristic method) 
    {
    	//  set used to maintain States that are already visited
        Set<String> visited = new HashSet<String>();	 
    
        //  compares the cost values and make the priority queue 
        Select_Node compare = new Select_Node();
        
        //  queue which contains states and their sorted cost values.
        PriorityQueue<Node> nodequeue = new PriorityQueue<Node>(1000, compare);
        
        Node node = new Node(startNode.getState());
        node.setCost(0); // set cost of start state to 0
        
        Node current = node; // initialize a dummy pointer for iterations
        
        while (!current.getState().equals(finalState)) 
        {//till we reach our final state iterate from current state all other states considering the 
        	// add current state to visited
        	visited.add(current.getState());
        	    
            List<String> nodeSuccessors = Result.finalResult(current.getState());
            // add all nodes connected nodes of the current node, to the priority queue. 
            //but keeping in mind of adding the nodes with least distance first and which are not in visited.
            for (String n : nodeSuccessors) 
            {
                if (visited.contains(n))
                    continue;
                
                visited.add(n); // add to visited
                
                Node child = new Node(n);// make n as child of current
                current.addChild(child);
                child.setParent(current);// set current as parent of n  
                
                // calculate the cost depending on the heuristic passed by user
                if (method == Possibility.Heuristic.MISSED)
                	child.setTotalCost(0, mis_tiles(child.getState(), finalState));
                else if (method == Possibility.Heuristic.MANHATTAN)
                	child.setTotalCost(0, manhattan(child.getState(), finalState));
                else if (method == Possibility.Heuristic.COMBINATION)
                	child.setTotalCost(0, comb_heuristic(child.getState(), finalState));
                
                nodequeue.add(child);
            }    
            current = nodequeue.poll();   
        }
       
        Result.Results(current, visited, startNode);

    }
    
    // A* algorithm 
    public void a_Star(Possibility.Heuristic method) 
    {
    	    //  set used to contains States that are already visited
        Set<String> isvisited = new HashSet<String>();
        
        //  nodeCompare compare the cost values and make the priority queue 
        Select_Node compare = new Select_Node();

        //  queue which contains states and their sorted cost values.
        PriorityQueue<Node> nodequeue = new PriorityQueue<Node>(1000, compare);
       
        
        Node node = new Node(startNode.getState());
        node.setTotalCost(0);

        Node currentNode = node;
        
        while (!currentNode.getState().equals(finalState)) 
        { //till we reach our final state iterate from current state all other states considering the 
        	// add current state to visited
        	isvisited.add(currentNode.getState());
            List<String> nodeSuccessors = Result.finalResult(currentNode.getState());
            // add all nodes connected nodes of the current node, to the priority queue. 
            //but keeping in mind of adding the nodes with least distance first and which are not in visited.
            for (String n : nodeSuccessors) 
            {
                if (isvisited.contains(n))
                    continue;
                
                isvisited.add(n);
                
                Node child = new Node(n); // make n as child of current
                currentNode.addChild(child); // set current as parent of n 
                child.setParent(currentNode);
                 
                // calculate the cost depending on the heuristic passed by user
                // cost is calculated as cost of reaching state + cost of reaching goal from state
                if (method == Possibility.Heuristic.MISSED)
                    child.setTotalCost(currentNode.getTotalCost() + Character.getNumericValue(child.getState().charAt(child.getParent().getState().indexOf('0'))), mis_tiles(child.getState(), finalState));
                else if (method == Possibility.Heuristic.MANHATTAN)
                    child.setTotalCost(currentNode.getTotalCost() + Character.getNumericValue(child.getState().charAt(child.getParent().getState().indexOf('0'))), manhattan(child.getState(), finalState));
                else if (method == Possibility.Heuristic.COMBINATION)
                    child.setTotalCost(currentNode.getTotalCost() + Character.getNumericValue(child.getState().charAt(child.getParent().getState().indexOf('0'))), comb_heuristic(child.getState(), finalState));
               
                nodequeue.add(child);

            }
            currentNode = nodequeue.poll();
            
        }
        Result.Results(currentNode, isvisited, startNode);
    }

    // missing tiles heuristic
    private int mis_tiles(String current_State, String final_State) {
        int diff = 0;
        // calculate the difference of tiles till each char in current state reaches final state
        for (int i=0; i < current_State.length(); i++)
        {	
            if (current_State.charAt(i) != final_State.charAt(i))
                diff += 1;
        }    
        return diff;
    }
    
    // manhattan heuristics 
    private int manhattan(String current_State, String final_State) {
        int diff = 0;
        for (int i=0; i < current_State.length(); i++)
        {	
            for (int j=0; j < final_State.length(); j++)
            {	
                if (current_State.charAt(i) == final_State.charAt(j))
                	    // to calculate sum of manhattan distance for each digit
                    diff = diff + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 + j / 3));
            }    
        }    
        return diff;
    }
    
    // combination heuristics
    private int comb_heuristic(String current_State, String final_State) {
        int diff = 0;
        int distance = 0;
        
        for (int i=0; i < current_State.length(); i++)
        {	
            for (int j=0; j < final_State.length(); j++)
            {	
                if (current_State.charAt(i) == final_State.charAt(j))
                	 // to calculate sum of manhattan distance for each digit
                	distance = (Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 + j / 3);
            }    
        }  
        // generating the difference as below:
        diff = diff + 2 * distance - 1;
        return diff;
    }
     
}
