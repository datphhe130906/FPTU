/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {
    
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
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    /*
    void addLast(String xOwner, int xPrice) - check if xOwner.charAt(0) == 'B' or xPrice > 100 then do
    nothing, otherwise add new car with owner=xOwner, price=xPrice, price=xPrice to the end of the
    list. (price can get arbitrary value, even negative).
     */
    void addLast(String xOwner, int xPrice) {
        //You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        
        if (isEmpty()) {
            head = tail = new Node(new Car(xOwner, xPrice), null);
        } else {
            Node q = new Node(new Car(xOwner, xPrice), null);
            tail.next = q;
            tail = q;
        }
        
    }
    


/*
    void f1() - This method is used to test the addLast methode above. You do not need to edit this
    function. Output in the file f1.oct must be the following:
    (A,9) (C,7) (D,2) (E,6) (F,4)
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
    void f2() - There is a given objects x. You should write statements so that x will be the first
    element of the list. Output in the file f2.tct must be the following:
    (C,9) (D,6) {E,8) (F,2) (I,6)
    (X,1) (C,9) (D,6) (E,8) (F,2) (I,6)
    */

    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Car x = new Car("X", 1);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        addFirst(x);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    void addFirst(Car x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }


//==================================================================

    /*
    void f3() - Suppose the list contains at least 3 elements. Delete the first node having price=5.
    Output in the file f3.txt must be the following:
    (C,9) (D,5) (E,3) (F,5) (I,6)
    (C,9) (E,3) (F,5) (I,6)
    */

    void f3() throws Exception {
        clear();
        loadData(7);
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
        
        removeFirst();

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    public void removeFirst() {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (p.info.price == 5) {
                count++;
            }
            if (p.info.price == 5 && count == 1) {
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
    void f4() - Sort the list ascendingly by price. Output in the file f4.txt must be the following:
    (C,9) (D,6) (E,5) (F,13) (I,2) (J,1)
    (J,1) (I,2) (E,5) (D,6) (C,9) (F,13)
    */

    void f4() throws Exception {
        clear();
        loadData(10);
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
        
       sortByPrice();

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    void sortByPrice() {
        Node pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.price > pj.info.price) {
                    Car temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
  
    

}
