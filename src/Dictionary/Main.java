package Dictionary;
public class Main {
    public static void main (String[] args ){
        AVLTreeDic tree =new  AVLTreeDic();
        tree.load("/src/dictionary.txt");
        tree.size();
        tree.height();
        tree.search("and");
        tree.search("zebra");
        tree.batchDelete("/src/deletions.txt");
        tree.traversePreOrder();
        tree.lookUp("/src/queries.txt");
        tree.delete("and");
        tree.height();
        tree.size();



    }
}
