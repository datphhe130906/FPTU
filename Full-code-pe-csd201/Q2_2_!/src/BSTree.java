/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

    int compare(Node a, Node b) {
        return Integer.compare(a.info.price, b.info.price);
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//=============================================================
    
    /*
    void insert(string xOwner, int xColor, int xPrice) - check if xOwner.charAt(0) == 'A' then
    do nothing, otherwise insert new cat with owner=xOwner, color=xColor, price=xPrice to
    the tree. (color and price can get arbitrary values, even negative).
    */
    
    void insert(String xOwner, int xColor, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        Node q = new Node(new Dog(xOwner, xColor, xPrice));
        if (isEmpty()) {
            root = q;
            return;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.info.price == xPrice) {
                return;
            }

            f = p;
            if (p.info.price > xPrice) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (f.info.price > xPrice) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    /*
    void f1() — You do not need to edit this function. Your task is to complete the insert(...)
    function above only. Output in the file f1.txt must be the following:
    (B,9,5) (C,1,2) (D,5,6) (E,3,4) (F,6,7) (G,2,3)
    (C,1,2) (G,2,3) (E,3,4) (B,9,5) (D,5,6) (F,6,7)
    */
    
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
     void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if(p.info.color < 5)
            fvisit(p, f);
        inOrder2(p.right, f);
    }

//=============================================================
    
    /*
    void f2() — Perform in-order traversal from the root but display to file f2.txt nodes with
    color<5 only. Hint: Copy the function inOrder(...) to function inOrder2(...) and modify it.
    Output in the file f2.txt must be the following:

    (C,5,1) (G,6,2) (H,2,3) (E,7,4) (I,4,5) (D,1,6) (F,3,8)
    (H,2,3) (I,4,5) (D,1,6) (F,3,8)
    */

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        inOrder2(root, f);

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
   

//=============================================================
    
    /*
    void f3Q — Search the node having price=6 in the tree. If the node found is p then calculate
    the number of nodes in the sub-tree with root p. If this number of nodes is k then change
    p.info.color to 100+k. Output in the file f3.txt must be the following:
    (C,9,2) (D,5,1) (E,10,6) (F,3,4) (G,7,8) (H,2,3) (I,4,5) (J,6,7)
    (C,9,2) (D,5,1) (E,106,6) (F,3,4) (G,7,8) (H,2,3) (I,4,5) (J,6,7)
    */
    
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = search(root, 6);
        int n = count(p);
        if(p!= null)
            p.info.color = n+100;
       

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    public int count(Node p){
	 if(p==null) return(0);
	   int k,h,r;
	   k = count(p.left);
	   h = count(p.right);
	   r = k+h+1;
	   return(r);
	 }
    
    public Node search(Node p, int key){
		if(p == null) return null;
		 if(p.info.price == key) return p;
		 else if(p.info.price > key) return search(p.left, key);
		 else return search(p.right, key);
		}

//=============================================================

    /*
    void f4() — Search the node having price = 6 and if the node found is p then delete p by
    copying. Output in the file f4.txt must be the following:
    (C,9,2) (D,5,1) (E,10,6) (F,3,4) (G,7,8) (H,2,3) (I,4,5) J,6,7)
    (C,9,2) (D,5,1) (I,4,5) (F,3,4) (G,7,8) (H,2,3) (J,6,7)
    */

    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      Node p = search(root, 6);
        deleteByCopy(p);
        
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if(p == null){
          
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while(q != p){
            if(q.info.price > p.info.price){         // Changed
                f = q;
                q = q.left;
            }
            else{
                f = q;
                q = q.right;
            }
        }
        // 1. p is a leaf (no right and left child)
        if (p.left == null && p.right == null) {
            // a BST has a Node only
            if (f == null) {
                root = null;
            } 
            else if (f.left == p) {
                f.left = null;
            }
            else if(f.right == p){
                f.right = null;
            }
        }
        // 2. p has a left child only
        else if(p.left != null && p.right == null){
            if(f == null){// remove root
                root = p.left;
            }
            else if(f.right == p){
                f.right = p.left;
            }
            else if(f.left == p){
                f.left = p.left;
            }
        }
        // 3. p has a right child only
        else if(p.right != null && p.left == null){
            if(f == null){// remove root
                root = p.right;
            }
            else if(f.right == p){
                f.right = p.right;
            }
            else if(f.left == p){
                f.left = p.right;
            }
        }
        // 4. Both of right and left child 
        else if(p.left != null && p.right != null){
            f = null;
            Node rp = p.left;
            while(rp.right != null){
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if(f == null){// rp has no right child 
                p.left = rp.left;
            }
            else{
                f.right = rp.left;
            }
        }
        
    }   
    
      
}
