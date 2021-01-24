package suanfa.interview;

/**
 * @Author: zhanglin
 * @Date: 2019/6/28
 * @Time: 6:02 PM
 */
public class Ip2Long {

    /**
     * 使用Java针对ip转换成long
     *
     * @param ip ip地址
     * @return 以32位整数表示的ip地址
     */
    public static final long ip2Long(final String ip) {
        if (!ip.matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
            throw new IllegalArgumentException("[" + ip + "]不是有效的ip地址");
        }
        final String[] ipNums = ip.split("\\.");
        return (Long.parseLong(ipNums[0]) << 24)
                + (Long.parseLong(ipNums[1]) << 16)
                + (Long.parseLong(ipNums[2]) << 8)
                + (Long.parseLong(ipNums[3]));
    }

    public static void main(String[] args) {
        System.out.println(ip2Long("192.68.0.1"));
        System.out.println(ip2Long("192.189.2.1"));
        System.out.println(ip2Long("10.189.2.1"));
        System.out.println(ip2Long("10.10.2.1"));
    }

}
