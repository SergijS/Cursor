package HW5;

import java.util.ArrayList;
public class MyList <T extends Number> {
    ArrayList<T> workArrayList = new ArrayList<T>();
    public void add(T addArrayElemen) {
        workArrayList.add(addArrayElemen);
    }
    @Override
    public String toString() {
        return "New Array list:" +
                workArrayList;
    }
    public T largest() {
        T value = workArrayList.get(0);
        for (T i : workArrayList) {
            if (i.doubleValue() > value.doubleValue()) {
                value = i;
            }
        }
        return value;
    }
    public T smallest() {
        T value = workArrayList.get(0);
        for (T i : workArrayList) {
            if (i.doubleValue() < value.doubleValue()) {
                value = i;
            }
        }
        return value;
    }
}