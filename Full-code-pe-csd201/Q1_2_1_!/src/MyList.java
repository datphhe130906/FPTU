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

    void loadData(int k) //do not edit this function
    {
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
//==================================================================
    /*
    void addLast(String xOwner, int xColor, it xPrice) - check ¡f xOwner.charAt(0) == 'B' then
    do nothing, otherwise add new node with owner=xOwner, color=xColor, price=xPrice to
    the end of the list. (color and price can get arbitrary values, even negatIve).
     */
    void addLast(String xOwner, int xColor, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B') {
            return;
        }

        if (isEmpty()) {
            head = tail = new Node(new Dog(xOwner, xColor, xPrice), null);
        } else {
            Node q = new Node(new Dog(xOwner, xColor, xPrice), null);
            tail.next = q;
            tail = q;
        }
    }

    /*
    void f1()— This method 1s used to test the addLast method above. You do not need to edit
    this function. Qutput ¡in the file fI.txt must be the following:

    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
     */
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
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
        ftraverse(f);
        f.close();
    }

//==================================================================
    /*
    votd f2() -There are 2 given Dog obJects x, y ¡m this function. Suppose the list contains at
    least 3 elements. WriIte statements to mnsert x and y to the list so that x will be the first, y
    will be the third elements of the list. output in the file f2.txt must be the following:

    (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
    (X,1,2) (C,9,8) (Y,3,4) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
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
        Dog x, y;
        x = new Dog("X", 1, 2);
        y = new Dog("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//     Node p = head;
//     Node p1 = new Node(x, p);
//     head = p1;
//     Node p2 = new Node(y, p.next);
//     p.next = p2;
        addFirst(x);
        insertPositionK(y, 2);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void addFirst(Dog x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertPositionK(Dog x, int position) {
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
    void f3() — Suppose the list contains at least 3 clements. Delete the first and the third
    elements of the original list. Output in the file f3.txt must be the following:

    (C,9,2) (D,2,5) (E,8,7) (F,1,6) (I,5,9)
    (D,2,5) (F,1,6) (I,5,9)
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
//        Node p2 = head.next, p3 = p2.next;
//        head = p2;
//        p2.next = p3.next;
//        if (tail == p3) {
//            tail = p2;
//        }
        deleteAt(2);
        deleteAt(0);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void deleteAt(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {//check if node is head
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);//get node position k
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }

    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

//==================================================================
    /*
    void f4() — Sort the first 5 elements descendingly by color. The content of the output file
    f4.(xt must be the following:

    (C,1,2) (D,2,12) (E,11,3) (E,3,4) (I,4,5) (J,5,6) (K,6,7)
    (E,11,3) (I,4,5) (F,3,4) (D,2,12) (C.12) (J,5,6) (K,6,7)
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
        sort5();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    public void sort5() {
        Node pi, pj; pi = head; int count = 0; 
        while(pi != null) {
            count++; pj = pi.next; int count1 = 0;
            while(pj != null) {
                count1++;
                if(pi.info.color < pj.info.color ) {
                    Dog t = pi.info; pi.info = pj.info;pj.info = t;
                }
                pj = pj.next; if(count1 == 5 - count) break;
            }
            pi = pi.next; if(count == 4) break;
        }
    }

}
