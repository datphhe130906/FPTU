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

    /*
    void addLast(String xColor, int xArea, int xPeri) - check if xColor.charAt(0) == 'B' then do
    nothing, otherwise add new node with color=xColor, area=xArea, peri=xPeri to the end of
    the list. (area and peri can get negative value).
     */
    void addLast(String xColor, int xArea, int xPeri) {//You should write here appropriate statements to complete this function.
        if (xColor.charAt(0) == 'B') {
            return;
        }

        Box b = new Box(xColor, xArea, xPeri);
        if (isEmpty()) {
            head = tail = new Node(b);
        } else {
            Node node = new Node(b);
            tail.next = node;
            tail = node;
        }
    }

    /*
    void f1() — This method is used to test the addLast method above. You do not need to edit
    this function. Output in the file f1.txt must be the following:
    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
     */
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(3);
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
    void f2() -There are 2 given Box objects x, y in this function. Suppose the list contains at
    least 3 elements. Write statements to insert x and y to the list so that x will be the first, y
    will be before the last node. Output in the file f2.txt must be the following:
    (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
    (X,1,2) (C,9,8) (D,6,3) (E,8,5) (F,5,4) (Y,3,4) (I,4,9)
     */
    void f2() throws Exception {
        clear();
        loadData(7);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Box x, y;
        x = new Box("X", 1, 2);
        y = new Box("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(x);
        insertKeCuoi(y);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void insertKeCuoi(Box x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }

        Node p = head;
        while (p != null) {
            p = p.next;

            if (p.next == tail) {
                break;
            }
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }

    public void addFirst(Box x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

//==================================================================

    /*
    void f3() — Suppose the list contains at least 5 elements. Swap the element at position 2 with
    the element at position 4 (the head’s position is 0).. Output in the file {3.tx¢ must be the
    following:
    (C,9,2) (D,2,5) (E,8,7) (F,1,6) (G,5,9) (H,6,4)
    (C,9,2) (D,2,5) (G,5,9) (F,1,6) (E,8,7) (H,6,4)
     */
    void f3() throws Exception {
        clear();
        loadData(11);
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
        swap(getNode(2), getNode(4));
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void swap(Node i, Node j) {
        Box p = i.info;
        i.info = j.info;
        j.info = p;
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
    void f4() — Supose the list contains at least 5 elements. Reverse the first 4 elements. The
    content of the output file f4.txt must be the following:
    (C,7,6) (D,12,5) (E,6,11) (F,5,4) (I,4,3) (J,3,2) (K,2,1)
    (F,5,4) (E,6,11) (D,12,5) (C,7,6) (I,4,3) (J,3,2) (K,2,1)
     */
    void f4() throws Exception {
        clear();
        loadData(15);
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
        reverse();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    public void reverse() {
        int n = 4, i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = getNode(j);// create a node = getnode index j
            Box temp = pi.info;// Note: change value of node, not change node
            pi.info = pj.info;
            pj.info = temp;
        }
    }
}
