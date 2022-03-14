


public class LinkedListDeque <T>{
    private  class staffnode{
        private T item;
        private staffnode pre;
        private staffnode next;

        private staffnode(T x) {
            item=x;


        }
    }
    private int size=1;
    private staffnode first;
    private staffnode last;
    private staffnode standf;

    private LinkedListDeque(T x) {
        first=new staffnode(x);
        standf=new staffnode(x);
        first.next=standf;
        first.pre=standf;
        standf.next=first;
        standf.pre=first;
        last=first;
        size=1;

    }

    public LinkedListDeque() {
        standf=new staffnode(null);
        first=standf;
        last=first;
        size=0;
    }

    public void addFirst(T x) {


        if(size==0) {
            first=new staffnode(x);
            standf.next=first;
            standf.pre=first;
            first.pre=standf;
            first.next=standf;
            last.pre=standf;
            last.next=standf;
            last=first;

            size++;

        }
        else {
            size++;
            if(size==2) {
                last.pre=first;
            }
            staffnode first1=new staffnode(x);
            standf.next=first1;
            first1.next=first;
            first1.pre=standf;
            first.pre=first1;

            first=first1;
            first.pre=first1.pre;
            first.next=first1.next;





        }

    }
    public void addLast(T x) {

        if(isEmpty()) {
            last=new staffnode(x);
            standf.pre=last;
            standf.next=last;
            last.next=standf;
            last.pre=standf;
            first=last;
            first.next=standf;
            first.pre=standf;
            size++;

        }

        else {
           staffnode v=last;
            last=new staffnode(x);
            last.pre=v;
            v.next=last;
            last.next=standf;
            standf.pre=last;
            size++;
        }


    }
    public T removeFirst() {
        if(size>=1) {
            T e=first.item;
            first=first.next;
            standf.next=first;
            size--;
            return e;}
        else
            return null;
    }




    public T getRecursive(int index){
        if (index>=size)
            return null;

        else
            return getRecursive(first,index,0);

    }

    private  T getRecursive(staffnode p,int index,int t){
        if(t==index) return p.item;
        else {
            return getRecursive(p.next,index,t+1);
        }
    }
    public T removeLast() {
        if(size>=1) {

            T r=last.item;
            last=last.pre;
            last.next=standf;

            size--;

            return r;
        }

        else return null;

    }

    public boolean isEmpty() {

        if(size==0) return true;
        else return false;
    }
    public T get(int index) {
        int t=0;

        staffnode a=first;
        while(a!=standf) {

            if(index==t) return a.item;
            a=a.next;
            t++;
        }
        return null;
    }
    public void printDeque() {
        staffnode p=first;


        while(p!=standf) {
            System.out.print(p.item);
            System.out.print(" ");
            p=p.next;
        }
        System.out.print("\n");
    }
    public int size() {
        return size;
    }


}