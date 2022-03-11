package AVLImplementation;

public class AVLTree {
    private class AvlNode{
        private int height;
        private int value;
        private AvlNode left;
        private AvlNode right;
        public AvlNode(int value){
            this.value=value;
        }
        //to see value while debugging
        @Override
        public String toString(){
            return "Node" + value;
        }
    }
    private int size=0;
    private AvlNode root;
    public void insert(int value){
        root= insert(root, value);
    }

    private AvlNode insert(AvlNode root,int value){
        if(root==null)
            return new AvlNode(value);

        if(value>root.value)
            root.right= insert(root.right,value);
        else if(value<root.value)
            root.left= insert(root.left,value);
        //to get height of each node
        setHeight(root);
        //to check if balanced
        size++;
        return balance(root);
    }

    public void delete(int value){
        root= delete(root, value);
    }
    private AvlNode delete(AvlNode root,int value){
        if(root ==null)
            return root;
        if(value>root.value)
            root.right= delete(root.right,value);
        else if(value<root.value)
            root.left= delete(root.left,value);
            //the node to be deleted found
        else{

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
        size--;
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

    //to print height of tree
    public void height(){

        System.out.print("\nThe AVL Tree's Height is "+ height(root));
    }

    public void size(){
        System.out.print("\nThe Size of the Dictionary is "+size);
    }
    private int height(AvlNode root){
        return (root==null) ? -1 : root.height;
    }
    public boolean search(int value){
        var current=root;
        while(current!=null){
            if(value>current.value)
                current=current.right;
            else if(value< current.value)
                current=current.left;
            else
                return true;
        }
        return false;
    }


    //printing
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(AvlNode root){
        if(root!=null) {
            System.out.print (root.value +" ");
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }




   /*  10  root
           20 new root
        15      30
    * rightheavy -> leftrotation
    * newroot=root.right
    *root.right=new root.left //for 15 as smaller than 20 greater than 10
    newroot.left=root

           20
       10       30
          15
    */

}
