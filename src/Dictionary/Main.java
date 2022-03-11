package Dictionary;

import java.util.Scanner;

public class Main {
    public static void main (String[] args ){
        AVLTreeDic tree =new  AVLTreeDic();
        Scanner input =new Scanner(System.in);
        System.out.println("1-load file");
        System.out.println("2-insert ");
        System.out.println("3-search");
        System.out.println("4-delete");
        System.out.println("5-print in preorder traverse");
        System.out.println("6-height of tree");
        System.out.println("7-size of tree");
        System.out.println("8-Batch Look-ups");
        System.out.println("9-Batch Deletions");
        System.out.println("10-EXIT");
        int op;
        boolean flag = true;
        while (flag) {

            System.out.println("--------------------------------");
            System.out.println("Enter number of what you need:");
            op = input.nextInt();
            switch (op) {
                case 1: {
                    tree.load("/src/dictionary.txt");
                    System.out.println(" file loaded successfully ");
                }
                break;
                case 2: {
                    System.out.println("insert the value :");
                    String value = input.next();
                    tree.insert(value);
                }
                break;

                case 3: {
                    System.out.println("search for the value :");
                    String value = input.next();
                    tree.search(value);

                }
                break;
                case 4: {
                    System.out.println("delete the value :");
                    String value = input.next();
                    tree.delete(value);
                }
                break;
                case 5: {
                    System.out.println("print in preorder traverse: ");
                    tree.traversePreOrder();
                    System.out.println();
                }
                break;
                case 6: {

                    tree.height();
                }
                break;
                case 7: {
                   tree.size();
                }
                break;
                case 8: {
                    tree.lookUp("/src/queries.txt");
                }
                break;
                case 9: {
                    tree.batchDelete("/src/deletions.txt");
                }
                break;

                case 10:
                    flag = false;
                    break;
                default:
                    System.out.print("INVALID INPUT!! ");

            }

        }

        /*
        tree.size();
        tree.height();
        tree.search("and");
        tree.search("zebra");
        tree.batchDelete("/src/deletions.txt");
        tree.traversePreOrder();
        tree.lookUp("/src/queries.txt");
        tree.delete("and");
        tree.height();
        tree.size();*/



    }
}
