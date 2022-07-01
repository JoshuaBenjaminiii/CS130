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
 

// Node Definition:
public class Node {

    String data;
    Node left;
    Node right;

    public Node() {
        this.data = "null";
        this.left = null;
        this.right = null;
    }

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node (String data, Node l, Node r) {
        this.data = data;
        this.left = l;
        this.right = r;

    }

    public String toString() {      // concatenates leaf nodes with operator parent nodes to make an expression

        String result = null;

        if (this.left == null && this.right == null) {   //checks if parent or leaf node
            result = this.data; //leaf
        } else {
            result = "( " + this.left.toString() +" " + this.data + " " + this.right.toString() + ") "; //group leaves together into expression
        }
        return result;
    }

    public Double evaluate() {   // switch statement works similar to toString,
                                    //however preforms the matching operation of the parent node
        double num = 0;

        switch (this.data) {
            case "+":
                num = left.evaluate() + right.evaluate();
                break;
            case "-":
                num = left.evaluate() - right.evaluate();
                break;
            case "*":
                num = left.evaluate() * right.evaluate();
                break;
            case "/":
                num = left.evaluate() / right.evaluate();
                break;
            case "%":
                num =  left.evaluate() % right.evaluate();
                break;
            case "^":
                num =  Math.pow(left.evaluate(),right.evaluate());
                break;
            default:
                num = Double.parseDouble(this.data); // if not an operator, strings are converted to float to perform arithmatic
        }
        return num;
    }


}


/*
	Part 2: Evaluate Tree Class
	
	While all the major logic will be found in the nodes, we need to have a single, centralized class. The purpose of the
	EvaluateTree class is to start recursion, store some global attributes (for future versions), and much more.
*/

public class EvaluateTree extends Node{   // This class should act as an interface for the user to the Node

    public Node root;

    public EvaluateTree() {
        root = new Node();
    }

    public EvaluateTree(Node x) {
        root.data = x.data;
        root.left = x.left;
        root.right = x.right;
    }

    public String toString() {

        String result = null;

        if (root.left == null && root.right == null) {
            result = root.data;
        } else {
            result = "( " + root.left.toString() +" " + root.data + " " + root.right.toString() + ") ";
        }

        return result;

    }

    public String about() {
        return " This program was written by Joshua Benjamin for Devin Cook's Data Structures" + "\n"
                + " and Algorithms Summer 2022 class.";
    }

    public Double evaluate() {

        double num = 0;

        switch (root.data) {
            case "+":
                num = root.left.evaluate() + root.right.evaluate();
                break;
            case "-":
                num = root.left.evaluate() - root.right.evaluate();
                break;
            case "*":
                num = root.left.evaluate() * root.right.evaluate();
                break;
            case "/":
                num = root.left.evaluate() / root.right.evaluate();
                break;
            case "%":
                num =  root.left.evaluate() % root.right.evaluate();
                break;
            case "^":
                num =  Math.pow(root.left.evaluate(),root.right.evaluate());
                break;
            default:
                num = Double.parseDouble(root.data);
        }
        return num;
    }

}

class MathExpressionMaker {


    public static void main(String[] args) {

        //Test 1
        EvaluateTree tree = new EvaluateTree();
        tree.root = new Node("+", new Node("5"), new Node("/", new Node("7"), new Node("2")));
        System.out.println(tree.toString());
        System.out.println(tree.evaluate());

        //Test 2
        EvaluateTree tree2 = new EvaluateTree();
        tree2.root =  new Node("+",new Node("*", new Node("5"),new Node("26")),new Node("/",new Node("-",new Node("20"),new Node("12")),new Node("2")));
        System.out.println(tree2.toString());
        System.out.println(tree2.evaluate());

        //Test 3
        EvaluateTree tree3 = new EvaluateTree();
        tree3.root =  new Node("^",new Node("5"),new Node("2"));
        System.out.println(tree3.toString());
        System.out.println(tree3.evaluate());

        //Test 4
        EvaluateTree tree4 = new EvaluateTree();
        tree4.root =  new Node("%",new Node("8"),new Node("3"));
        System.out.println(tree4);
        System.out.println(tree4.evaluate());

        /*Test Template
         EvaluateTree tree = new EvaluateTree();
         tree2.root =  new Node();
         System.out.println(tree.toString());
         System.out.println(tree.evaluate());
        */






        // End
        System.out.println(tree.about());
    }
}
