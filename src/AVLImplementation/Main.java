package AVLImplementation;

import java.util.Scanner;

public class Main {
    public static void main (String[] args ){
        AVLTree tree =new  AVLTree();
        Scanner input =new Scanner(System.in);
        System.out.println("1-insert ");
        System.out.println("2-search");
        System.out.println("3-delete");
        System.out.println("4-print in preorder traverse");
        System.out.println("5-height of tree");
        System.out.println("6-EXIT");
        int op;
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("Enter number of what you need:");
            op = input.nextInt();
            switch (op) {
                case 1: {
                    System.out.println("insert:");
                    System.out.println("Enter the value :");
                    int value = input.nextInt();
                    tree.insert(value);
                }
                break;

                case 2: {
                    System.out.println("search");
                    System.out.println("Enter the value :");
                    int value= input.nextInt();
                    tree.search(value);

                }
                break;
                case 3: {
                    System.out.println("delete");
                    System.out.println("Enter the value :");
                    int value= input.nextInt();
                    tree.delete(value);
                }
                break;
                case 4: {
                    System.out.println("print in preorder traverse: ");
                    tree.traversePreOrder();
                }
                break;
                case 5: {
                    System.out.println("height of tree:");
                    System.out.println();
                    tree.height();

                }
                break;

                case 6:
                    flag = false;
                    break;
                default:
                    System.out.print("INVALID INPUT!! ");

            }

        }

        /*tree.insert(33);
        tree.insert( 13);
        tree.insert( 53);
        tree.insert( 9);
        tree.insert( 21);
        tree.insert( 61);
        tree.insert( 8);
        tree.insert(11);*/


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
        //tree.traversePreOrder();
        //System.out.println(tree.search(10));
        //System.out.println("after delete ");

        //tree.delete(13);
        //tree.traversePreOrder();



    }
}
