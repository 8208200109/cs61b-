
public class ArrayDeque<T> {
    private T[] items;
    private int begin;
    private int size;
    private int last;
    private double rate;
    private int start;
    private int s1;
    private int s2;
    private int end;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        begin=items.length-1;
        size=0;
        rate=0;
        start=0;
        last=0;
        end=items.length;
        s1=0;
        s2=0;
    }


    public void addLast(T item) {

        if(last<=begin&&last<items.length) {
            items[last]=item;
            size++;
            last++;
            rate=size/items.length;
            s2++;
        }
        else {
            T[] a = (T[]) new Object[items.length*2];
            if(s2>0)
                System.arraycopy(items, start, a, 0,s2);
            if(begin<items.length-1)
                System.arraycopy(items, begin+1, a, a.length-s1, s1);
            items = a;
            end=items.length;
            start=0;
            last=s2;
            begin=items.length-s1-1;
            items[last]=item;
            last++;
            size = size + 1;
            s2++;
        }

    }
    public  void addFirst(T item) {

        if(begin>=0&&begin>=last) {
            items[begin]=item;
            begin--;
            size++;
            s1++;
            rate=(double) size/items.length;
        }
        else {
            T[] a = (T[]) new Object[items.length*2];
            if(s2>0)
                System.arraycopy(items, start, a, 0, s2);
            if(s1>0)
                System.arraycopy(items, begin+1, a, a.length-s1, s1);
            items = a;
            end=items.length;
            begin=items.length-s1-1;
            if(begin>=0&&begin<items.length)
                items[begin]=item;
            begin--;
            start=0;
            last=s2;
            size = size + 1;
            rate=(double) size/items.length;
            s1++;
        }



    }
    private T d;
    public T removeLast() {
        if(s2>0) {
            s2--;
            size--;
            last--;
            d=items[last];
            rate=(double) size/items.length;
            if(rate<0.25&&items.length>16) {
                recycle();
            }
            return d;

        }
        else if(s1>0){
            s1--;
            end--;
            size--;
            d=items[end];
            rate=(double) size/items.length;
            if(rate<0.25&&items.length>16) {
                recycle();
            }
            return d;
        }
        else
            return  null;
    }
    private int c;
    public T removeFirst() {
        if(s1>0) {
            s1--;
            size--;
            begin++;
            d=items[begin];
            rate=(double) size/items.length;
            if(rate<0.25&&items.length>16) {
                recycle();
            }
            return d;
        }
        else if(s2>0) {
            s2--;
            d=items[start];
            start=start+1;
            size--;
            rate=(double) size/items.length;
            if(rate<0.25&&items.length>16) {
                recycle();
            }
            return d;
        }
        else return  null;
    }
    private void recycle() {
        if (size > 0) {
            T[] a = (T[]) new Object[size];
            if (s1 > 0)
                System.arraycopy(items, begin + 1, a, 0, s1);
            if (s2 > 0)
                System.arraycopy(items, start, a, s1, s2);
            items = a;
            s2 = size;
            s1 = 0;
            begin = items.length - 1;
            end = items.length;
            start = 0;
            last = s2;
        }
        else {
            T[] a = (T[]) new Object[1];

            //if(begin+1<=items.length-1)
            if (s1 > 0)
                System.arraycopy(items, begin + 1, a, 0, s1);
            if (s2 > 0)
                System.arraycopy(items, start, a, s1, s2);
            items = a;
            s2 = size;
            s1 = 0;
            begin = items.length - 1;
            end = items.length;
            start = 0;
            last = s2;
        }
    }
    public int size() {
        return size;
    }
    public 	T get(int index) {
        if(index<s1)
            return items[begin+index+1];
        if(index>=s1&&index<size)
            return  items[start+(index-s1)];
        else return  null;
    }

    public void  printDeque() {

        for(int i=begin+1;i<end;i++) {
            System.out.print(items[i]);
            System.out.print(' ');
        }
        for(int j=start;j<last;j++) {
            System.out.print(items[j]);
            System.out.print(' ');
        }
        System.out.print("\n");
    }
    public boolean isEmpty() {
        return size==0;
    }





}
