package Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;

public class AVLTreeDic {
    private class AvlNode {
        private int height;
        private String value;
        private AvlNode left;
        private AvlNode right;

        public AvlNode(String value) {
            this.value = value;
        }
    }
    private int f,flag;
    private AvlNode root;

    ///////////////////////FILE READER/////////////////////////////////////////////////

    public void load(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            String line;
            while ((line=br.readLine()) != null){
                insert(line);
            }
        } catch (Exception e) {
            System.out.print("\nCan not read the file");
            System.out.println(e.getMessage());
        }
    }
    public void lookUp(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            String line;
            int c=0;
            while ((line=br.readLine()) != null){
                if(search(line)=="YES"){
                    c++;
                    System.out.print(" ----> " + line.toLowerCase());
                }else{
                    System.out.print(", Word Not Found!!");
                }

            }
            System.out.print("\n"+c+" Words Found!!");
        } catch (Exception e) {
            System.out.print("\nCan not read the file");
            System.out.println(e.getMessage());
        }
    }
    public void batchDelete(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + file))) {
            String line;
            while ((line=br.readLine()) != null){
                delete(line);

            }
        } catch (Exception e) {
            System.out.print("\nCan not read the file");
            System.out.print(e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////


    public void insert(String value){
        flag=0;
        root= insert(root, value);
        if(flag==0){
            System.out.print("\nERROR: \""+value.toLowerCase()+"\" already in the dictionary!");
        }
    }

    private AvlNode insert(AvlNode root,String value){
       if(root==null) {
           flag=1;
           return new AvlNode(value);
       }

       if(value.compareToIgnoreCase(root.value)>0)
          root.right= insert(root.right,value);
       else if(value.compareToIgnoreCase(root.value)<0)
           root.left= insert(root.left,value);
       //to get height of each node
       setHeight(root);
       //to check if balanced

       return balance(root);
    }
    //////////////////////////////FOR Delete////////////////////////////
    
     public void delete(String value){
       f=0;
       root= delete(root, value);
       if(f==0){
           System.out.print("\nERROR!! \""+value+"\" not Found!!");
       }
    }
    private AvlNode delete(AvlNode root,String value){
        if(root ==null)
            return root;
        if(value.compareToIgnoreCase(root.value)>0)
          root.right= delete(root.right,value);
       else if(value.compareToIgnoreCase(root.value)<0)
           root.left= delete(root.left,value);
        //the node to be deleted found
        else{
            f=1;
            if(root.right==null || root.left==null){
                AvlNode temp=null;
                //1 -> if node has only on child
                if(root.left==temp)
                    temp=root.right;
                else
                    temp=root.left;

                //2 -> if it has no child
                if(temp==null){
                    temp=root;
                    root=null;
                }
                else
                    //case of one child copy it to the root
                    root=temp;
            }
            else{
                //3 -> if it has 2 children
                //put the smallest in the right subtree
                AvlNode temp=minNode(root.right);
                root.value= temp.value;
                // Delete
                root.right = delete(root.right, temp.value);

            }
        }
        if (root == null)
            return root;

        //to get height of each node
        setHeight(root);
        //to check if balanced
        return balance(root);
    }
    
     private AvlNode minNode(AvlNode root){
        if(root==null)
            throw new IllegalStateException();
        AvlNode current=root;
        //loop till the left most node to get the min value
        while(current.left!=null)
            current=current.left;
        return current;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    private AvlNode balance(AvlNode root){
        //leftheavy
        if(balanceFactor(root)>1){
            //leftheavy
            //this means it is unbalanced in left right subtree
            //this if for double rotation
            if(balanceFactor(root.left)<0)
               root.left= rotateLeft(root.left);
         return rotateRight(root);
        }
        //RightHeavy
        else if(balanceFactor(root)<-1){
            //right heavy
            if(balanceFactor(root.right)>0)
                root.right=rotateRight(root.right);
          return  rotateLeft(root);
        }
        //if is already balanced
        return root;
    }

  
     private AvlNode rotateLeft(AvlNode root){
        //right heavy
        AvlNode newRoot =root.right;
        AvlNode temp=newRoot.left;

        newRoot.left=root;
        root.right=temp;

        //updating height of each node
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }
    private AvlNode rotateRight(AvlNode root){
        AvlNode newRoot=root.left;
        AvlNode temp=newRoot.right;
        newRoot.right=root;
        root.left=temp;

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AvlNode root){
        root.height= Math.max(height(root.left),height(root.right))+1;
    }

    private int balanceFactor(AvlNode root){
        return height(root.left)-height(root.right);
    }

    public void height(){

         System.out.print("\nThe AVL Tree's Height is "+ height(root));
    }

    private int height(AvlNode root){
        return (root==null) ? -1 : root.height;
    }

    public String search(String value){
        var current=root;
        while(current!=null){
            if(value.compareToIgnoreCase(current.value)>0)
                current=current.right;
            else if(value.compareToIgnoreCase(current.value)<0)
                current=current.left;
            else {
                System.out.print("\nYES");
                return "YES";
            }
        }
        System.out.print("\nNO");
        return "NO";
    }

    //printing
    public void traversePreOrder(){
        System.out.print("\n");
         traversePreOrder(root);
    }
    private void traversePreOrder(AvlNode root){

        if(root!=null) {
            System.out.print(root.value + " ");
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }




}
