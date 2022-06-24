//Joshua Benjamin
//CS 130 Data Structures
//Binary Tree Evaluator


/*
	Prompt
	
	For this assignment, you are going to a very basic binary tree that
	can be used to evaluate mathematical expressions.

	This can be a tad complex. So, please do each of the "parts" in order
	and test your results as you go. The best way to write any large
	program in through "incremental design". Start modest, add features,
	and test as you go.
	
*/

/*
	Part 1: Node Class
	
	Create a very basic node class. All this requires is a left and right link (to another node) and a generic data field. It should also
	have a few constructors. You need one that will create a node with links to two other nodes.
	
	toString():
	
	To convert the tree to an infix string, we need to construct a string using the sub-strings from the left and right children. Of
	course, if the node is a leaf, the expression is node itself. Don't worry, it is not hard.
	
	function toString() returns String
		if the node is a leaf then
			result = this.value
		else
			result = "(" + left.ToString() + this.value with spaces + right.ToString() + ")"
		end if
 
		return result
	end function
*/
 
public class Node {
 
	public String data;
	private Node left;
	private Node right;
 
	public Node(String data) {
		this.data = data;
		left = null;
		right = null;
	}
 
	public Node (String data, Node l, Node r) {
		this.data = data;
		left = l;
		right = r;
	
	}

	public String toString() {
		
		String result = null;
		
		if (this.left == null && this.right == null) {
			result = this.data;
		} else {
			result = "(" + left.toString() + this.data + " " + right.toString() + ")";
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
    
    }
	
}



/*
	Part 2: Evaluate Tree Class
	
	While all the major logic will be found in the nodes, we need to have a single, centralized class. The purpose of the
	EvaluateTree class is to start recursion, store some global attributes (for future versions), and much more.
*/
