package android.support.v4.widget;

import android.support.v4.g.j;
import android.support.v4.g.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f<T> extends Object {
  private final j.a<ArrayList<T>> a = new j.b(10);
  
  private final l<T, ArrayList<T>> b = new l();
  
  private final ArrayList<T> c = new ArrayList();
  
  private final HashSet<T> d = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet) {
    if (paramArrayList.contains(paramT))
      return; 
    if (!paramHashSet.contains(paramT)) {
      paramHashSet.add(paramT);
      ArrayList arrayList = (ArrayList)this.b.get(paramT);
      if (arrayList != null) {
        byte b1 = 0;
        int i = arrayList.size();
        while (b1 < i) {
          a(arrayList.get(b1), paramArrayList, paramHashSet);
          b1++;
        } 
      } 
      paramHashSet.remove(paramT);
      paramArrayList.add(paramT);
      return;
    } 
    throw new RuntimeException("This graph contains cyclic dependencies");
  }
  
  private void a(ArrayList<T> paramArrayList) {
    paramArrayList.clear();
    this.a.a(paramArrayList);
  }
  
  private ArrayList<T> c() {
    ArrayList arrayList = (ArrayList)this.a.a();
    if (arrayList == null)
      arrayList = new ArrayList(); 
    return arrayList;
  }
  
  public void a() {
    int i = this.b.size();
    for (byte b1 = 0; b1 < i; b1++) {
      ArrayList arrayList = (ArrayList)this.b.c(b1);
      if (arrayList != null)
        a(arrayList); 
    } 
    this.b.clear();
  }
  
  public void a(T paramT) {
    if (!this.b.containsKey(paramT))
      this.b.put(paramT, null); 
  }
  
  public void a(T paramT1, T paramT2) {
    if (this.b.containsKey(paramT1) && this.b.containsKey(paramT2)) {
      ArrayList arrayList = (ArrayList)this.b.get(paramT1);
      if (arrayList == null) {
        arrayList = c();
        this.b.put(paramT1, arrayList);
      } 
      arrayList.add(paramT2);
      return;
    } 
    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
  }
  
  public ArrayList<T> b() {
    this.c.clear();
    this.d.clear();
    int i = this.b.size();
    for (byte b1 = 0; b1 < i; b1++)
      a(this.b.b(b1), this.c, this.d); 
    return this.c;
  }
  
  public boolean b(T paramT) { return this.b.containsKey(paramT); }
  
  public List c(T paramT) { return (List)this.b.get(paramT); }
  
  public List<T> d(T paramT) {
    int i = this.b.size();
    ArrayList arrayList = null;
    for (byte b1 = 0; b1 < i; b1++) {
      ArrayList arrayList1 = (ArrayList)this.b.c(b1);
      if (arrayList1 != null && arrayList1.contains(paramT)) {
        if (arrayList == null)
          arrayList = new ArrayList(); 
        arrayList.add(this.b.b(b1));
      } 
    } 
    return arrayList;
  }
  
  public boolean e(T paramT) {
    int i = this.b.size();
    for (byte b1 = 0; b1 < i; b1++) {
      ArrayList arrayList = (ArrayList)this.b.c(b1);
      if (arrayList != null && arrayList.contains(paramT))
        return true; 
    } 
    return false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */