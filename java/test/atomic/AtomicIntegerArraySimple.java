package test.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArraySimple {

    public static void main(String[] args) {
        int[] array = {1, 2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        atomicIntegerArray.set(0, 3);
        System.out.println(array[0]);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(array[0] == atomicIntegerArray.get(0));
    }
}
