package org.prog.session2;

public class Main2 {
    public static void main(String[] args) {
        String text = "thisstringhas$some fragment$thathastobeextracted";

        int Start = text.indexOf("$");
        int Finish = text.lastIndexOf("$");
        System.out.println("thisstringhassome fragmentthathastobeextracted");

    }
}
