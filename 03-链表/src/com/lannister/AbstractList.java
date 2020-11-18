package com.lannister;

/**
声明为抽象类，因为不会实现List接口的所有方法
 */
public abstract class AbstractList<E> implements List<E>{

    //List的容量大小
    protected int size;

    //范围检查
    protected void rangeCheck(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:" + index + ",size:" + size);
        }
    }
    //这个RangeCheck用于index能取到数组的最大容量下一位的cases
    protected void rangeCheckForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index:" + index + ",size:" + size);
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
        // return size == 0
    }

    @Override
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element){
        add(size,element);
    }

}
