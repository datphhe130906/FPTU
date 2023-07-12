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
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
 /*
    void addLast(String xMaker, int xType, int xRadius) - check ¡f xMaker.char At(0) — 'B'
    then do nothing, otherwise add new node with maker=xMaker, type=xType,
    radius=xRadius to the end of the list. (type and radius can get arbitrary, even negative
    values).
    
    void f1() - Do not edit this method. Your task is to complete the addLast(...) method
    above only. Qutput in the file fl.txt must be the following:
    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
     */
    void addLast(Ball x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addLast(String xMaker, int xType, int xRadius) {
        //You should write here appropriate statements to complete this function.
        if (xMaker.charAt(0) == 'B') {
            return;
        }

        if (isEmpty()) {
            head = tail = new Node(new Ball(xMaker, xType, xRadius), null);
        } else {
            Node q = new Node(new Ball(xMaker, xType, xRadius), null);
            tail.next = q;
            tail = q;
        }
    }

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
    void f2() -There are 2 given Ball objects x, y ¡n this function. Suppose the list contains
    at least 5 elements. Write statements to insert x and y to the list so that x wIll be the 3rd,
    y wIll be the 4th element in the list. Output in the file f2.txt must be the following:

    (C.9,8) (D,6,3) (E,8,5) (F.5.4) (I.4.9)
    (C,9,8) (D,6,3) (X,1,2) (Y,3,4) (E,8,5) (F.5,4) (4.9)
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
        Ball x, y;
        x = new Ball("X", 1, 2);
        y = new Ball("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insertPositionK(x, 2);
        insertPositionK(y, 3);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void insertPositionK(Ball x, int position) {
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
    void f3() - Suppose the list contains at least 4 elements. Remove the second node having
    maximum type (thus If only one node having maximum type then do nothing). Ôutput in
    the file f3.txt must be the following:

    (C,8,6) (D,3,5) (E,9,2) (F,5,6) (G,9,7) (H,6,2) (I,7,8)
    (C.8,6) (D.3,5) (E.9,2) (F,5,6) (H,6,2) (I,7,8)
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
        removeSecond();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public Ball getMaxPerson() {
        if (isEmpty()) {
            return null;
        }
        Ball max = head.info;
        Node p = head;
        while (p != null) {
            if (p.info.type > max.type) {
                max = p.info;
            }
            p = p.next;
        }
        return max;
    }

    public void removeSecond() {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.info.type == getMaxPerson().type) {
                count++;
            }
            if (p.info.type == getMaxPerson().type && count == 2) {
                break;
            }
            p = p.next;
        }
        remove(p);
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
    void f4) - Suppose the list contains at least 4 elements. Sort the first 4 elements
    descendingly by type. The content of the output file f4.txt must be the following:
    (C,2,1) (D,12,2) (E,3,11) (F.4,3) (I,5,4) (J,6,5) (K,7,6)
    (D,12,2) (F.4.3) (E.3,1 1) (C.2,L) (I,5,4) (J,6,5) (K.7,6)
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
                if(pi.info.type < pj.info.type ) {
                    Ball t = pi.info; pi.info = pj.info;pj.info = t;
                }
                pj = pj.next; if(count1 == 4 - count) break;
            }
            pi = pi.next; if(count == 3) break;
        }
    }

}
