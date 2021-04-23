package 设计模式.bulider;

//构造者（Builder）模式
//Builder模式是为了弥补Java语言设计上的不足
public class BuilderUser1 {

    String name;
    int age;
    String email;
    String address;

    public BuilderUser1() {
    }

    //想要有名字和邮箱的构造器
    public BuilderUser1(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //想要有名字和地址的构造器
//    public BuilderUser1(String name, String address){
//        this.name = name;
//        this.address = address;
//    }
}