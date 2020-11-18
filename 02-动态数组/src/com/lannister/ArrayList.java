package com.lannister;

public class ArrayList<E> {
    private int size;
    private E[] elements;
    //动态数组的默认大小
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity){
        //默认容量为10
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
        //这里是不能直接new <E>[capacity]的
    }
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity) {
            return;
        }

        //这里扩容为之前的1.5倍，没有直接写*1.5，因为
        //浮点数运算比位运算符慢
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0; i< size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为：" + newCapacity);
    }

    //范围检查
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:" + index + ",size:" + size);
        }
    }
    //这个RangeCheck用于index能取到数组的最大容量下一位的cases
    private void rangeCheckForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index:" + index + ",size:" + size);
        }
    }


    public void clear(){
        //clear的功能是清空数组中存放的数据，而不是把数组也销毁了
        //不用清空数组，让逻辑上数组的大小为0就是清空了
        //size = 0;  //如果存放的是基本数据类型，那可以这样清空数组
        //如果存放引用数据类型数据，只是size=0的话，堆空间的对象还存在
        //所以需要清空数组中存放的地址值
        for(int i = 0; i < size; i++)  {
            elements[i] = null;
        }
        size = 0;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
        // return size == 0
    }
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    public void set(int index,E element){
        rangeCheck(index);
        elements[index] = element;
    }
    //添加元素到尾部，即索引为size的位置
    public void add(E element){
        add(size,element);
    }

    public void add(int index, E element){
        //是可以插入到数组最大容量的下一个位置的
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for(int i = size-1; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public void remove(int index){
        rangeCheck(index);
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }

        size--;
        elements[size-1] = null;
    }

    public int indexOf(E element){
        //基本数据类型
       /* for(int i = 0; i < elements.length; i++){
            if(element == elements[i]){
                return i;
            }
        }*/
        for(int i = 0; i < elements.length; i++) {
            //不重新equals的话，默认是比较内存地址
            if(elements[i].equals(element)) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    //toString默认是输出全类名，这里自己实现一下想要的效果
    @Override
    public String toString(){
        StringBuilder myString = new StringBuilder();
        myString.append("size=").append(size).append(",[");
        for(int i = 0; i < size; i++){
            myString.append(elements[i]);
            if(i == size-1){
                myString.append("]");
                return myString.toString();
            }
            myString.append(",");
        }
        myString.append("]");
        //这是啥
        return myString.toString();
    }



}
