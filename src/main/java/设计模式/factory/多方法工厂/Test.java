package 设计模式.factory.多方法工厂;

public class Test {
    public static void main(String[] args) {
         /**
         * 多方法静态工厂(模仿Executor类）
         */
        System.out.println("==============================模仿Executor类==============================" +
                "\n 这种我比较青睐，增加一个新面条，只要去增加一个static方法即可,也不修改原方法逻辑");
        INoodles lz2 = MulWayNoodlesFactory.createLz();
        lz2.desc();

        INoodles gk2 = MulWayNoodlesFactory.createGk();
        gk2.desc();
    }
}
