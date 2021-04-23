package suanfa;

import java.util.BitSet;

public class BitSetDemo {

    public static void main(String[] args) {

        //创建一个具有10000000位的bitset　初始所有位的值为false
        BitSet bitSet = new BitSet(10000000);
        //将指定位的值设为true
        bitSet.set(9999);
        //或者bitSet.set(9999,true);
        //输出指定位的值
        System.out.println("9999:" + bitSet.get(9999));
        System.out.println("9998:" + bitSet.get(9998));

    }
}