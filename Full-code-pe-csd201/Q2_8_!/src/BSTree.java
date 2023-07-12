/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------------

class BSTree {

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

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void fvisitBal(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.name + "," + p.info.age + "," + p.bal + ") ");
        }
    }

    void fvisitLevel(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.name + "," + p.info.age + "," + p.level + ") ");
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
        MyQueue q = new MyQueue();
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

    void breadthBal(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitBal(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void breadthLevel(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitLevel(r, f);
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
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//===========================================================================
    
    /*
    void insert(String xName, int xAge) - check if the first letter of 
    xName is 'B' (i.e. xName.charAt(0) == 'B') then do nothing, otherwise
    insert new person with name=xName, age=xAge to the tree. 
    */

    void insert(String xName, int xAge) {
        if (xName.charAt(0) == 'B') {
            return;
        }
        Node q = new Node(new Person(xName, xAge));
        if (isEmpty()) {
            root = q;
            return;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.info.age == xAge) {
                return;
            }

            f = p;
            if (p.info.age > xAge) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (f.info.age > xAge) {
            f.left = q;
        } else {
            f.right = q;
        }
    }
    
    /*
    void f1() – Test insert function. You do not need to edit this function.
    Your task is to complete the insert(String xName, int xAge) function only. 
    With the given data, the content of  the file  f1.txt  must be the following:
    (A6,1) (A2,2) (A1,4) (A5,5) (A4,7) (A3,9) (A7,3) (A9,6) (A8,8)
    (A1,4) (A2,2) (A3,9) (A4,7) (A5,5) (A6,1) (A7,3) (A8,8) (A9,6) 
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
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        inOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    
    /*
    void f2() – create BSTree object  h  and using insert method to insert to h  all elements having age>4.
    You should visit elements by breadth-first traverse With the given data, the content of  the file  f2.txt
    must be the following:
    (C6,1) (C2,2) (C1,4) (C5,5) (C4,7) (C3,9) (C7,3) (C9,6) (C8,8)
    (C5,5) (C4,7) (C3,9) (C9,6) (C8,8)
    */
    
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        BSTree h = new BSTree();
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        breadth2(root, f123);
        

        //-------------------------------------------------------------------------------------
        h.preOrder(h.root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }
    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if(r.info.age < 5)  insert(r.info.name, r.info.age);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    

//===============================================================
    
    /*
    void f3() – calculate the height of the tree. You should use the given statement
    f123.writeBytes(“k = “ + k + “\r\n”);  to write this value to the file f3.txt. 
    With the given data, the content of  the file  f3.txt  must be the following:
    k = 5
    */

    void f3() throws Exception {
        clear();
        loadData(5);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        int k = 0;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
      

        //-------------------------------------------------------------------------------------
        f123.writeBytes(" k = " + k + "\r\n");
        f123.close();
    }
    
 

//===============================================================
    
    /*
    void f4() - calculate the number of nodes of the tree. You should use the given statement
    f123.writeBytes(" k = " + k + "\r\n"); to write this value to the file f4.txt.
    With the given data, the content of  the file  f4.txt  must be the following:
    k = 9
    */

    void f4() throws Exception {
        clear();
        loadData(5);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        int k = 0;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        
        //-------------------------------------------------------------------------------------
        f123.writeBytes(" k = " + k + "\r\n");
        f123.close();
    }
    
   

//===============================================================
    
    /*
    void f5() – Delete the root of  the tree by copying.
    With the given data, the content of  the file  f5.txt  must be the following:
    (C6,1) (C2,2) (C1,4) (C5,5) (C4,7) (C3,9) (C7,3) (C9,6) (C8,8)
    (C5,5) (C2,2) (C1,4) (C4,7) (C3,9) (C7,3) (C9,6) (C8,8) 
    */

    void f5() throws Exception {
        clear();
        loadData(5);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


        
        //-------------------------------------------------------------------------------------
        preOrder(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }
    
  

    

//===============================================================
    
    /*
    void f6() – Check if the root having non-empty left-son then rotate it to right about its
    left-son.With the given data, the content of  the file  f6.txt  must be the following:
    (C6,1) (C2,2) (C7,3) (C1,4) (C5,5) (C9,6) (C4,7) (C8,8) (C3,9)
    (C2,2) (C1,4) (C6,1) (C5,5) (C7,3) (C4,7) (C9,6) (C3,9) (C8,8)
    */

    void f6() throws Exception {
        clear();
        loadData(5);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     
        
        //-------------------------------------------------------------------------------------
        breadth(root, f123);
        f123.writeBytes("\r\n");
        f123.close();
    }
    
  

//===============================================================
    
    /*
    void f7() – Calculate balance factor of all nodes. Display all node with balance factor
    by breadth-first traverse. Display also the information about whether a given binary
    search tree is height balanced (AVL tree) or not.
    With the given data, the content of  the file  f7.txt  must be the following:
    (C6,1) (C2,2) (C7,3) (C1,4) (C5,5) (C9,6) (C4,7) (C8,8) (C3,9)
    (C6,1,-1) (C2,2,2) (C7,3,2) (C1,4,0) (C5,5,-2) (C9,6,-1) (C4,7,-1) (C8,8,0) (C3,9,0) 
    The tree is not an AVL tree
    */
    
    void f7() throws Exception {
        clear();
        loadData(5);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
     

       

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    
    /*
    void f8() – Calculate level of all nodes. Display all node with level by breadth-first traverse.
    With the given data, the content of  the file  f8.txt  must be the following:
    (C6,1) (C2,2) (C7,3) (C1,4) (C5,5) (C9,6) (C4,7) (C8,8) (C3,9)
    (C6,1,1) (C2,2,2) (C7,3,2) (C1,4,3) (C5,5,3) (C9,6,3) (C4,7,4) (C8,8,4) (C3,9,5) 
    */
    
    void f8() throws Exception {
        clear();
        loadData(5);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     

        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//===============================================================
    
    /*
    void f9() – Balance a binary search tree by simple balancing algorithm. Display all node 
    by breadth-first traverse.
    With the given data, the content of  the file  f9.txt  must be the following:
    (C6,1) (C2,2) (C7,3) (C1,4) (C5,5) (C9,6) (C4,7) (C8,8) (C3,9)
    (C5,5) (C2,2) (C7,3) (C1,4) (C3,9) (C6,1) (C8,8) (C4,7) (C9,6)
    */

    void f88() throws Exception {
        clear();
        loadData(5);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        breadth(root, f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       
        
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }
    
   

}
