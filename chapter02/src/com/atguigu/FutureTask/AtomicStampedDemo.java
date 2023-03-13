package com.atguigu.FutureTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
class Book{
    private int id;
    private String bookName;
    public Book(int id,String bookName){
        this.id=id;
        this.bookName=bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
public class AtomicStampedDemo {
    public static void main(String[] args) {
        Book book=new Book(1,"qq");
        AtomicStampedReference<Book> atomicStampedReference=new AtomicStampedReference<>(book,1);
        System.out.println(atomicStampedReference.getReference()+"\t"+atomicStampedReference.getStamp());
        Book book1=new Book(2,"mysql");
        boolean b = atomicStampedReference.compareAndSet(book, book1,
                atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        System.out.println(b+"\t"+atomicStampedReference.getReference()+"\t"+atomicStampedReference.getStamp());
        boolean b1 = atomicStampedReference.compareAndSet(book1, book,
                1, atomicStampedReference.getStamp() + 1);
        System.out.println(b1+"\t"+atomicStampedReference.getReference()+"\t"+atomicStampedReference.getStamp());
    }
}
