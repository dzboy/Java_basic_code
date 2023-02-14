package com.ysoyso.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListWrapper<E extends Comparable<E> & Serializable> {
    List<E> list = new ArrayList<>();

    public void sort() {
        Collections.sort(list);
    }
}
