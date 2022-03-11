public class Main {
    public static void main (String[] args ){
        AVLTree tree =new  AVLTree();
        tree.load("C:\\Users\\Dell\\OneDrive\\Desktop\\AVL\\src\\dictionary.txt");
        tree.traversePreOrder();
        tree.lookUp("C:\\Users\\Dell\\OneDrive\\Desktop\\AVL\\src\\queries.txt");

        System.out.println(tree.height());




    }
}
