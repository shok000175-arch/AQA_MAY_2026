package org.prog.session5;
import java.util.Random;
public class Main2  {
public static void main2(String[] args) {
    Random random = new Random();
    Plane[] planes = new Plane[50];
    for (int i = 0; i < planes.length; i++) {
        int passengers = random.nextInt(200);
        planes[i] = new Plane("P" + (i+1), passengers);
    }
    for (int i = 0; i < planes.length; i++) {
        System.out.println(planes[i].info());
    }
}
}
