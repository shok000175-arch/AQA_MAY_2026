package org.prog.session7.Iphone;

public class Main {
    public static void main(String[] args) {

        Android samsung = new Android("Galaxy S25", "Black");
        Apple iphone = new Apple("iPhone 16", "White");

        samsung.unlock();
        samsung.call("John");

        iphone.unlock();
        iphone.call("Kate");

        Android samsung2 = new Android("Galaxy S25", "Black");

        System.out.println(samsung.equals(samsung2));
    }
}
