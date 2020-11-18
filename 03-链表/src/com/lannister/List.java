package com.lannister;

public interface List<E> {
    //
    static final int ELEMENT_NOT_FOUND = -1;

    public void clear();

    public int size();

    public boolean isEmpty();

    public boolean contains(E element);

    public E get(int index);

    public void set(int index, E element);


    public void add(E element);

    public void add(int index, E element);

    public void remove(int index);

    public int indexOf(E element);


}
