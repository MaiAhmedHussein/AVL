public class AVLTree {
    private class AvlNode{
        private int height;
        private String value;
        private AvlNode left;
        private AvlNode right;
        public AvlNode(String value){
            this.value=value;
        }
        //to see value while debugging
        @Override
        public String toString(){
            return "Node" + value;
        }

    }

    private AvlNode root;
    public void insert(String value){
      root= insert(root, value);
    }

    private AvlNode insert(AvlNode root,String value){
       if(root==null)
           return new AvlNode(value);

       if(value.compareToIgnoreCase(root.value)>0)
          root.right= insert(root.right,value);
       else if(value.compareToIgnoreCase(root.value)<0)
           root.left= insert(root.left,value);
       //to get height of each node
       setHeight(root);
       //to check if balanced

       return balance(root);
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

   /* private AvlNode rotateLeft(AvlNode root){
        //right heavy
        AvlNode newRoot =root.right;
        root.right=newRoot.left;
        newRoot.left=root;
        //updating height of each node
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }*/
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

    public int height(){
         return height(root);
    }

    private int height(AvlNode root){
        return (root==null) ? -1 : root.height;
    }
    public boolean search(String value){
        var current=root;
        while(current!=null){
            if(value.compareToIgnoreCase(current.value)>0)
                current=current.right;
            else if(value.compareToIgnoreCase(current.value)<0)
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
            System.out.println(root.value);
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
