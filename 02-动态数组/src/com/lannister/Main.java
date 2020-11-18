package com.lannister;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(10,"Kat"));
        list.add(new Person(15,"Lyle"));
        list.add(new Person(20,"Rose"));
        list.clear();

        //提醒JVM进行垃圾回收,因为gc有不确定性
        System.gc();
        //System.out.println(list);
    }
}
