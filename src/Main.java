public class Main {
    public static void main (String[] args ){
        AVLTree tree =new  AVLTree();
        tree.load("/src/dictionary.txt");
        tree.height();
        tree.search("and");
        tree.search("zebra");
        tree.batchDelete("/src/deletions.txt");
        tree.traversePreOrder();
        tree.lookUp("/src/queries.txt");
        tree.delete("and");
        tree.height();



    }
}
