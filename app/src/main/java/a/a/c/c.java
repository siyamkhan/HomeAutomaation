package a.a.a.a.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class c<E extends b & l & i> extends PriorityBlockingQueue<E> {
  final Queue<E> a = new LinkedList();
  
  private final ReentrantLock b = new ReentrantLock();
  
  public E a() { return (E)b(0, null, null); }
  
  E a(int paramInt, Long paramLong, TimeUnit paramTimeUnit) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        object = super.poll(paramLong.longValue(), paramTimeUnit);
        return (E)(b)object;
      case 2:
        object = super.poll();
        return (E)(b)object;
      case 1:
        object = super.peek();
        return (E)(b)object;
      case 0:
        break;
    } 
    Object object = super.take();
    return (E)(b)object;
  }
  
  public E a(long paramLong, TimeUnit paramTimeUnit) { return (E)b(3, Long.valueOf(paramLong), paramTimeUnit); }
  
  boolean a(int paramInt, E paramE) {
    try {
      this.b.lock();
      if (paramInt == 1)
        super.remove(paramE); 
      return this.a.offer(paramE);
    } finally {
      this.b.unlock();
    } 
  }
  
  boolean a(E paramE) { return paramE.d(); }
  
  <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2) {
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, i, j);
    return (T[])arrayOfObject;
  }
  
  public E b() {
    try {
      return (E)b(1, null, null);
    } catch (InterruptedException interruptedException) {
      return null;
    } 
  }
  
  E b(int paramInt, Long paramLong, TimeUnit paramTimeUnit) {
    b b1;
    while (true) {
      b1 = a(paramInt, paramLong, paramTimeUnit);
      if (b1 != null) {
        if (a(b1))
          return (E)b1; 
        a(paramInt, b1);
        continue;
      } 
      break;
    } 
    return (E)b1;
  }
  
  public E c() {
    try {
      return (E)b(2, null, null);
    } catch (InterruptedException interruptedException) {
      return null;
    } 
  }
  
  public void clear() {
    try {
      this.b.lock();
      this.a.clear();
      super.clear();
      return;
    } finally {
      this.b.unlock();
    } 
  }
  
  public boolean contains(Object paramObject) {
    try {
      this.b.lock();
      if (!super.contains(paramObject)) {
        boolean bool = this.a.contains(paramObject);
        if (bool)
          return true; 
        return false;
      } 
      return true;
    } finally {
      this.b.unlock();
    } 
  }
  
  public void d() {
    try {
      this.b.lock();
      Iterator iterator = this.a.iterator();
      while (iterator.hasNext()) {
        b b1 = (b)iterator.next();
        if (a(b1)) {
          offer(b1);
          iterator.remove();
        } 
      } 
      return;
    } finally {
      this.b.unlock();
    } 
  }
  
  public int drainTo(Collection<? super E> paramCollection) {
    try {
      this.b.lock();
      i = super.drainTo(paramCollection) + this.a.size();
      while (!this.a.isEmpty())
        paramCollection.add(this.a.poll()); 
      return i;
    } finally {
      this.b.unlock();
    } 
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt) {
    try {
      this.b.lock();
      for (i = super.drainTo(paramCollection, paramInt); !this.a.isEmpty() && i <= paramInt; i++)
        paramCollection.add(this.a.poll()); 
      return i;
    } finally {
      this.b.unlock();
    } 
  }
  
  public boolean remove(Object paramObject) {
    try {
      this.b.lock();
      if (!super.remove(paramObject)) {
        boolean bool = this.a.remove(paramObject);
        if (bool)
          return true; 
        return false;
      } 
      return true;
    } finally {
      this.b.unlock();
    } 
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    try {
      this.b.lock();
      boolean bool1 = super.removeAll(paramCollection);
      boolean bool2 = this.a.removeAll(paramCollection);
      return bool2 | bool1;
    } finally {
      this.b.unlock();
    } 
  }
  
  public int size() {
    try {
      this.b.lock();
      int i = this.a.size();
      int j = super.size();
      return i + j;
    } finally {
      this.b.unlock();
    } 
  }
  
  public Object[] toArray() {
    try {
      this.b.lock();
      return a(super.toArray(), this.a.toArray());
    } finally {
      this.b.unlock();
    } 
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    try {
      this.b.lock();
      arrayOfObject = a(super.toArray(paramArrayOfT), this.a.toArray(paramArrayOfT));
      return (T[])arrayOfObject;
    } finally {
      this.b.unlock();
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */