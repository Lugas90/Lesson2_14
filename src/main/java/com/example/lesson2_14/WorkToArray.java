package com.example.lesson2_14;

import com.example.lesson2_14.Exceptions.ArrayOutOfLimitException;
import com.example.lesson2_14.Exceptions.ItemNotFoundException;


public class WorkToArray implements StringList {

    private static final int DEFAULT_SIZE = 5;
    private String[] storage;

    public WorkToArray(int n) {
        this.storage = new String[n];
    }

    public WorkToArray() {
        this.storage = new String[DEFAULT_SIZE];
    }

    @Override
    public String add(String item) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = item;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        for (index = 0; index < storage.length; index++) {
            if (storage[index] == null) {
                if (index > DEFAULT_SIZE) {
                    throw new ArrayOutOfLimitException("В массиве места больше нет");
                }
                storage[index] = item;
            }
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        for (index = 0; index < storage.length; index++) {
            if (index > DEFAULT_SIZE) {
                throw new ArrayOutOfLimitException("В массиве места больше нет");
            }
            storage[index] = item;
        }
        return item;
    }

    @Override
    public String remove(String item) {
        String[] newArray = null;
        for (int i = 0; i < storage.length - 1; i++) {
            if (item == storage[i]) {
                if (i < 0 || i > storage.length || !storage[i].contains(item)) {
                    throw new ItemNotFoundException("Элемент не найден");
                }
                newArray = new String[storage.length - 1];
                for (int index = 0; index < i; index++) {
                    newArray[index] = storage[index];
                }
                for (int j = i; j < storage.length - 1; j++) {
                    newArray[j] = storage[j + 1];
                    break;
                }
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String item = new String();
        String[] newArray = null;
        if (index < 0 || index > storage.length) {
            throw new ItemNotFoundException("Элемент не найден");
        }
        for (int i = index + 1; index < storage.length - 1; index++) {
            storage[i - 1] = storage[i];
        }
        for (int j = index; j < storage.length - 1; j++) {
            newArray[j] = storage[j + 1];
            break;
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (String s : storage) {
            if (item.equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < storage.length && index == -1; i++) {
            if (storage[i] == item) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = storage.length; i != 0; i--) {
            if (storage[i] == item) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        String item = new String();
        index = -1;
        if (index < 0 || index > storage.length) {
            throw new ItemNotFoundException("Элемент не найден");
        }
        for (int i = 0; i < storage.length && index == -1; i++) {
            if (storage[i] == item) {
                index = i;
            }
        }
        return item;
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.equals(storage) == true) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (storage.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        String[] s = new String[]{};
        storage = s;
    }

    @Override
    public String[] toArray() {
        String[] s = new String[storage.length];
        for (int i = 0; i < storage.length; i++) {
            s[i] = storage[i];
        }
        return s;
    }
}
