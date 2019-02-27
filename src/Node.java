//shraddha Bhise

import java.util.ArrayList;
import java.util.Comparator;

public class Node 
{
	 	
		private String nodeState;
	    private ArrayList<Node> children;
	    private Node parent;
	    
	    private int cost;
	    private int goal_Cost;
	    private int totalCost;
	    
	    private int depth;
	    private boolean visited;
	    
	 // gets depth
	    public int getDepth() 
	    {
	        return depth;
	    }
	    	 // sets visited   
	    public void setVisited(boolean visited) 
	    {
	        this.visited = visited;
	    }
	    // checks if visited
	    public boolean isVisited() 
	    {
	        return visited;
	    }
	    
	    // sets depth 
	    public void setDepth(int depth) 
	    {
	        this.depth = depth;
	    }
	    
	    // sets total cost by adding cost + estimated cost   
	    public void setTotalCost(int cost, int esti_Cost) 
	    {
	        this.totalCost = cost + esti_Cost;
	    }

	    public void setTotalCost(int totalCost) 
	    {
	        this.totalCost = totalCost;
	    }
	    //gets the toal cost 
	    public int getTotalCost() 
	    {
	        return totalCost;
	    }
	    // sets the estimated cost required to reach goal
	    public void setEstimatedCostToGoal(int esti_Cost_Goal) 
	    {
	        this.goal_Cost = esti_Cost_Goal;
	    }
	    // gets the estimated cost required to reach goal
	    public int getEstimatedCostToGoal() 
	    {
	        return goal_Cost;
	    }

	    public void setCost(int cost) 
	    {
	        this.cost = cost;
	    }
	    
	    public int getCost() 
	    {
	        return cost;
	    }
	    // sets the desired state 
	    public void setState(String myState) 
	    {
	        this.nodeState = myState;
	    }
	   // gets the desired state 
	    public String getState() 
	    {
	        return nodeState;
	    }
	    
	    //sets a current node as parent
	    public void setParent(Node parent) 
	    {
	        this.parent = parent;
	    }
	    //gets parent
	    public Node getParent() 
	    {
	        return parent;
	    }
	    // creates new node with attributes of state and children array
	    public Node(String myState) 
	    {
	        this.nodeState = myState;
	        children = new ArrayList<Node>();
	    }
        // gets childrens 
	    public ArrayList<Node> getChildren() 
	    {
	        return children;
	    }
        // adds child to a parent
	    public void addChild(Node child) 
	    {
	        children.add(child);
	    }
	    
}
 class Select_Node implements Comparator<Node> 
{
    // this functions is responsible to compare the costs of 2 nodes
    public int compare(Node n1, Node n2) 
    {
        if (n1.getTotalCost() < n2.getTotalCost()) 
        {
            return -1;
        }
        else if (n1.getTotalCost() > n2.getTotalCost()) 
        {
            return 1;
        }
        else return 0;
    }
}
 
 class Possibility {
        // declares the enums for heuristics
		public enum Heuristic {
			MISSED, MANHATTAN, COMBINATION;

		}
        // declares the enums for moves
		public enum Move {
			RIGHT, LEFT, UP, DOWN;
		}

	}

