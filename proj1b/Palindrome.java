public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> r = new LinkedListDeque<>();
        int l = word.length();
        char[] myCharArray;
        myCharArray = word.toCharArray();
        if (l >= 1) {
            for (int i = 0; i < l; i++) {
                r.addLast(myCharArray[i]);
            }
            return r;
        } else {
            return null;

        }
    }
    public boolean isPalindrome(String word){
        Deque<Character> s=wordToDeque(word);
        int l = word.length();
        while(s.size()>0){
            Character t1=s.removeFirst();
            Character t2=s.removeLast();
            if(t1!=null&&t2!=null&&!t1.equals(t2)){
                return false;
            }

        }
       return  true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        int l = word.length();
        char[] myCharArray;
        myCharArray = word.toCharArray();
        for(int i=0,j=l-1;i<j;i++,j--){
            if(!cc.equalChars(myCharArray[i],myCharArray[j])){
                return false;
            }
        }
        return true;
    }



}
