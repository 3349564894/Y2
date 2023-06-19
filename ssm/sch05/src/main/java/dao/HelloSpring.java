package dao;

public class HelloSpring {
    private String hello = null;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void print() {
        System.out.println("Spring say:," + this.getHello() + "!");
    }

}
