/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================

    /*
    void addLast(String xOwner, int xPrice, int xColor) - check if xOwner.charAt(0) == 'B'
    then do nothing, otherwise add new node with owner=xOwner, price=xPrice,
    color=xColor to the end of the list. (price and color can get arbitrary, even negative
    values).
    */

    void addLast(String xOwner, int xPrice, int xColor) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B') {
            return;
        }

        Bat b = new Bat(xOwner, xPrice, xColor);
        if (isEmpty()) {
            head = tail = new Node(b);
        } else {
            Node node = new Node(b);
            tail.next = node;
            tail = node;
        }
    }
    
    /*
    void f1() - Do not edit this method. Your task is to complete the addLast(...) method
    above only, Output in the file f1.txt must be the following:
    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
    */

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================

    /*
    void f2() -There are 2 given Bat objects x, y in this function. Suppose the list contains
    at least 5 elements. Write statements to insert x and y to the list so that x will be the 1st
    (head), y will be the 2nd element in the list. Output in the file f2.txt must be the
    following:
    (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
    (X,1,2) (Y,3,4) (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
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
        ftraverse(f);
        Bat x, y;
        x = new Bat("X", 1, 2);
        y = new Bat("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(x);
        insertPositionK(y, 1);
       
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    public void addFirst(Bat x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertPositionK(Bat x, int position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }
        int count = 1;
        Node p = head;
        while (p != null && count < position) {
            p = p.next;
            count++;
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }
   

//==================================================================

    /*
    void f3() — Suppose the list is not empty. Remove the first node having price < 6. Output
    in the file f3.txt must be the following:
    (C,8,6) (D,6,7) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
    (C,8,6) (D,6,7) (E,9,2) (G,9,7) (H,6,8) (I,7,3)
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteFirstCondition();
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    public void deleteFirstCondition(){
		Node p = head;
		while(p != null){
			if(p.info.price<6) remove(p);
			p=p.next;
		}
    }
    public void remove(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }
    
  

//==================================================================

    /*
    void f4() — Suppose the list contains at least 4 elements. Sort the first 4 elements
    ascendingly by price. The content of the output file f4.txt must be the following:
    (C,7,9) (D,16,7) (E,6,16) (F,5,6) (I,4,5) (J,3,4) (K,2,3)
    (F,5,6) (E,6,16) (C,7,9) (D,16,7) (I,4,5) (J,3,4) (K,2,3)
    */

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sort4();
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    public void sort4() {
        Node pi, pj; pi = head; int count = 0; 
        while(pi != null) {
            count++; pj = pi.next; int count1 = 0;
            while(pj != null) {
                count1++;
                if(pi.info.price > pj.info.price ) {
                    Bat t = pi.info; pi.info = pj.info;pj.info = t;
                }
                pj = pj.next; if(count1 == 4 - count) break;
            }
            pi = pi.next; if(count == 3) break;
        }
    }
 

}
