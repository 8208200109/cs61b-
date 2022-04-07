package synthesizer;

import static org.junit.Assert.*;

import org.junit.Test;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        arb.enqueue(9);
        arb.enqueue(10);
        arb.enqueue(10);
        arb.dequeue();
        arb.peek();
        ArrayRingBuffer exp = new ArrayRingBuffer(3);
        exp.enqueue(9);
        exp.enqueue(10);
        assertEquals(arb, exp);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
