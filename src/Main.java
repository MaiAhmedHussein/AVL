public class Main {
    public static void main (String[] args ){
        AVLTree tree =new  AVLTree();
        tree.insert("anD");
        tree.insert( "grass");
        tree.insert( "Greez");
        tree.insert( "Hand");
        //tree.insert( "zebra");
        tree.insert( "greEN");
        tree.insert( "Grass");


        tree.traversePreOrder();
        System.out.println(tree.height());




    }
}
