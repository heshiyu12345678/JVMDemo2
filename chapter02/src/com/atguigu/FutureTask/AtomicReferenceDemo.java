package com.atguigu.FutureTask;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
class User{
    String userName;
    int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public User(String userName,int age){
        this.userName=userName;
        this.age=age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference=new AtomicReference<>();
        User zs = new User("zs", 18);
        User ls = new User("ls", 20);
        atomicReference.set(zs);
        System.out.println(atomicReference.compareAndSet(zs, ls)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zs, ls)+"\t"+atomicReference.get().toString());
    }
}
