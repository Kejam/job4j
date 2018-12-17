package ru.job4j.monitore;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynContList;
import ru.job4j.list.DynContListS;

import java.util.Iterator;
@ThreadSafe
public class Wrapper<E> implements Iterable<E>{
    @GuardedBy("this")
    DynContListS<E> list = new DynContListS<E>();

    public synchronized void add(E value) {
        list.add(value);
    }

    public synchronized void delete() {
        list.delete();
    }

    public synchronized E get(int index) {
        return list.get(index);
    }

    public synchronized int getSize() {
        return list.getSize();
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.list).iterator();
    }

    private DynContListS<E> copy(DynContListS<E> from){
        DynContListS<E> copy = new DynContListS<E>();
        for (int i = 0; i < from.getSize(); i++) {
            copy.add(from.get(i));
        }
        return copy;
    }
}
