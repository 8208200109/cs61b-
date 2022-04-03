public class OffByN implements CharacterComparator{

   private int i;


    public boolean equalChars(char x, char y) {
        int dif=Math.abs(x-y);
        if(dif==i) return true;
         return false;
    }
    public OffByN(int j){
        this.i=j;
    }

}
