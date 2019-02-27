//shraddha Bhise

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Result 
{
	
	static private String init_state = "463710825";
	//static private String init_state = "520863714";
	//static private String init_state = "651374082";
	//static private String init_state = "851340762";
	static private String goal_state = "123456780";
	//Tried for Initial states
	//520863714
	//463710825
	//651374082
	//851340762

	
	// to select appropriates moves as down, right, left, up
	public static Possibility.Move selectMove(String str1, String str2) 
	{
        int position = str2.indexOf('0') - str1.indexOf('0');
        switch (position) {
            case -3:
                return Possibility.Move.DOWN;
            case -1:
                return Possibility.Move.RIGHT;    
            case 1:
                return Possibility.Move.LEFT;
            case 3:
                return Possibility.Move.UP;    
            
        }
        return null;
    }
	
	public static List<String> finalResult(String node) 
	{
	        List<String> results = new ArrayList<String>();

	        switch (node.indexOf("0")) 
	        { 
	            // for corresponding positions of char at 0, using  1, 3
	            case 0: 
	            {
	                results.add(node.replace(node.charAt(0), '*').replace(node.charAt(1), node.charAt(0)).replace('*', node.charAt(1)));
	                results.add(node.replace(node.charAt(0), '*').replace(node.charAt(3), node.charAt(0)).replace('*', node.charAt(3)));
	                break;
	            }
	           // for corresponding positions of char at 1, using  0,2,4
	            case 1: 
	            {
	                results.add(node.replace(node.charAt(1), '*').replace(node.charAt(0), node.charAt(1)).replace('*', node.charAt(0)));
	                results.add(node.replace(node.charAt(1), '*').replace(node.charAt(2), node.charAt(1)).replace('*', node.charAt(2)));
	                results.add(node.replace(node.charAt(1), '*').replace(node.charAt(4), node.charAt(1)).replace('*', node.charAt(4)));
	                break;
	            }
	           // for corresponding positions of char at 2, using  1, 5
	            case 2: 
	            {
	                results.add(node.replace(node.charAt(2), '*').replace(node.charAt(1), node.charAt(2)).replace('*', node.charAt(1)));
	                results.add(node.replace(node.charAt(2), '*').replace(node.charAt(5), node.charAt(2)).replace('*', node.charAt(5)));
	                break;
	            }
	           // for corresponding positions of char at 3, using  0, 4, 6
	            case 3: 
	            {
	                results.add(node.replace(node.charAt(3), '*').replace(node.charAt(0), node.charAt(3)).replace('*', node.charAt(0)));
	                results.add(node.replace(node.charAt(3), '*').replace(node.charAt(4), node.charAt(3)).replace('*', node.charAt(4)));
	                results.add(node.replace(node.charAt(3), '*').replace(node.charAt(6), node.charAt(3)).replace('*', node.charAt(6)));
	                break;
	            }
	            // for corresponding positions of char at 4, using  1, 3, 5, 7
	            case 4: 
	            {
	                results.add(node.replace(node.charAt(4), '*').replace(node.charAt(1), node.charAt(4)).replace('*', node.charAt(1)));
	                results.add(node.replace(node.charAt(4), '*').replace(node.charAt(3), node.charAt(4)).replace('*', node.charAt(3)));
	                results.add(node.replace(node.charAt(4), '*').replace(node.charAt(5), node.charAt(4)).replace('*', node.charAt(5)));
	                results.add(node.replace(node.charAt(4), '*').replace(node.charAt(7), node.charAt(4)).replace('*', node.charAt(7)));
	                break;
	            }
	            // for corresponding positions of char at 5, using  2, 4, 8
	            case 5: 
	            {
	                results.add(node.replace(node.charAt(5), '*').replace(node.charAt(2), node.charAt(5)).replace('*', node.charAt(2)));
	                results.add(node.replace(node.charAt(5), '*').replace(node.charAt(4), node.charAt(5)).replace('*', node.charAt(4)));
	                results.add(node.replace(node.charAt(5), '*').replace(node.charAt(8), node.charAt(5)).replace('*', node.charAt(8)));
	                break;
	            }
	           // for corresponding positions of char at 6, using  3, 7
	            case 6: 
	            {
	                results.add(node.replace(node.charAt(6), '*').replace(node.charAt(3), node.charAt(6)).replace('*', node.charAt(3)));
	                results.add(node.replace(node.charAt(6), '*').replace(node.charAt(7), node.charAt(6)).replace('*', node.charAt(7)));
	                break;
	            }
	            // for corresponding positions of char at 7, using  4, 6, 8
	            case 7: 
	            {
	                results.add(node.replace(node.charAt(7), '*').replace(node.charAt(4), node.charAt(7)).replace('*', node.charAt(4)));
	                results.add(node.replace(node.charAt(7), '*').replace(node.charAt(6), node.charAt(7)).replace('*', node.charAt(6)));
	                results.add(node.replace(node.charAt(7), '*').replace(node.charAt(8), node.charAt(7)).replace('*', node.charAt(8)));
	                break;
	            }
	            // for corresponding positions of char at 8, using  5, 7
	            case 8: 
	            {
	                results.add(node.replace(node.charAt(8), '*').replace(node.charAt(5), node.charAt(8)).replace('*', node.charAt(5)));
	                results.add(node.replace(node.charAt(8), '*').replace(node.charAt(7), node.charAt(8)).replace('*', node.charAt(7)));
	                break;
	            }
	        }

	     return results;

	}
	
	// to print the results
	public static void Results(Node final_State, Set<String> nodeSet, Node startNode) 
	{

        // push the final state to stack
        Stack<Node> node_stack = new Stack<Node>();
        node_stack.push(final_State);
        List solutionspath =new ArrayList();
        
        // iterate till our final state equals our start state
        while (!final_State.getState().equals(startNode.getState())) 
        {
            node_stack.push(final_State.getParent());
            final_State = final_State.getParent();
        }
        
        String initial = startNode.getState();	
        String goal;						
        
        System.out.println("Solution: ");
        
        for (int i = node_stack.size() - 1; i >= 0; i--) 
        {
            System.out.println("---------------------------------------");
            System.out.println("       ");
            goal = node_stack.get(i).getState();
            
            // prints the moves
            if (!initial.equals(goal)) 
            {
                System.out.println("Move " + goal.charAt(initial.indexOf('0')) + " " + selectMove(initial, goal));
            }

            initial = goal;
           
            System.out.println("  " + node_stack.get(i).getState().substring(0, 3));
            System.out.println("  " + node_stack.get(i).getState().substring(3, 6));
            System.out.println("  " + node_stack.get(i).getState().substring(6, 9));
            
            System.out.println("     ");
            System.out.print("Path: ");
            System.out.println(" ( " + node_stack.get(i).getState().substring(0, 9) +" ) ");
            
            // create solution path
            solutionspath.add(""+ node_stack.get(i).getState().substring(0, 9)); 
        }
        
        System.out.println("       ");
        System.out.println("-----------------------------FINAL RESULTS------------------------------");
        System.out.println("       ");
        System.out.println("Number of steps to reach goal state :  " + (node_stack.size() - 1));
        System.out.println("Number of visited states:  " + (nodeSet.size()));
        System.out.println(solutionspath);

    }
	
	// main function to give calls to algorithms with different heuristics 	
	public static void main(String[] args) {
		//Heuristic used
		//MISSED 
		//MANHATTAN
		//COMBINATION
		
		Algorithms puzzle = new Algorithms(new Node(init_state), goal_state);
		
		// to call Best first with MISSED heuristics
		System.out.println("        ");
		System.out.println("Best first with MISSED heuristics");
	    puzzle.bestFirstSearch(Possibility.Heuristic.MISSED);
	    
	  //to call  Best first with MANHATTAN heuristics
	  	System.out.println("        ");
	  	System.out.println("Best first with MANHATTAN heuristics");
	  	puzzle.bestFirstSearch(Possibility.Heuristic.MANHATTAN);
	  	
	 // to call Best first with COMBINATION heuristics
	 	System.out.println("        ");
	 	System.out.println("Best first with COMBINATION heuristics");
	 	puzzle.bestFirstSearch(Possibility.Heuristic.COMBINATION);
	    
	   // to call A* with MISSED heuristics
	    System.out.println("        ");
	    System.out.println("A* with MISSED heuristics");
		puzzle.a_Star(Possibility.Heuristic.MISSED);
		
		// to call A* with MANHATTAN heuristics
		System.out.println("        ");
		System.out.println("A* with MANHATTAN heuristics");
		puzzle.a_Star(Possibility.Heuristic.MANHATTAN);
		
		// to call A* with COMBINATION heuristics
		System.out.println("        ");
		System.out.println("A* with COMBINATION heuristics");
		puzzle.a_Star(Possibility.Heuristic.COMBINATION);
	}
	
}
