public interface Deque <Character>{
    public void addLast(Character item) ;
    public  void addFirst(Character item);
    public Character removeLast();
    public Character removeFirst();
    public int size();
    public void  printDeque();
    public boolean isEmpty();
}
