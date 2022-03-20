import org.junit.Test;
import static org.junit.Assert.*;
public class TestArrayDequeGold {
    static StudentArrayDeque<Integer> a = new StudentArrayDeque<>();
    static ArrayDequeSolution<Integer> excep = new ArrayDequeSolution<>();
    String m = "";
    @Test
    public void testStudentArray(){
        for (int i = 0; i < 1000; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                a.addLast(i);
                excep.addLast(i);
                m = m + "addLast" + "(" + i +")\n";
            } else if(numberBetweenZeroAndOne >= 0.25 && numberBetweenZeroAndOne < 0.5){
                a.addFirst(i);
                excep.addFirst(i);
                m = m + "addFirst" + "(" + i +")\n";
            }
            else if (numberBetweenZeroAndOne >= 0.5 && numberBetweenZeroAndOne < 0.75 && a.size() >= 1){
                Integer actual = a.removeLast();
                Integer expected = excep.removeLast();
                m = m + "removeLast()\n";
                assertEquals(m,expected, actual);

            }
            else if(numberBetweenZeroAndOne >= 0.75 && numberBetweenZeroAndOne < 1 && a.size() >= 1){
                Integer actual = a.removeFirst();
                Integer expected = excep.removeFirst();
                m = m + "removeFirst()\n";
                assertEquals(m,expected, actual);
            }
        }

    }


}
