package AVLImplementation;

public class Main {
    public static void main (String[] args ){
        AVLTree tree =new  AVLTree();
        tree.insert(33);
        tree.insert( 13);
        tree.insert( 53);
        tree.insert( 9);
        tree.insert( 21);
        tree.insert( 61);
        tree.insert( 8);
        tree.insert(11);


       /* tree.insert( 1);
        tree.insert( 2);
        tree.insert( 3);
        tree.insert( 4);
        tree.insert( 5);
        tree.insert( 6);
        tree.insert( 7);*/
        /*tree.insert( 9);
        tree.insert( 5);
        tree.insert( 10);
        tree.insert( 0);
        tree.insert( 6);
        tree.insert( 11);
        tree.insert( -1);
        tree.insert( 1);
        tree.insert( 2);*/
        tree.traversePreOrder();
        //System.out.println(tree.search(10));
        //System.out.println("after delete ");
        System.out.println();
        System.out.println(tree.height());
        //tree.delete(13);
        //tree.traversePreOrder();



    }
}
