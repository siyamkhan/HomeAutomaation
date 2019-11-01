package android.support.v7.widget;

import android.support.v4.d.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class aq implements Runnable {
  static final ThreadLocal<aq> a = new ThreadLocal();
  
  static Comparator<b> e = new Comparator<b>() {
      public int a(aq.b param1b1, aq.b param1b2) {
        boolean bool2;
        boolean bool1;
        RecyclerView recyclerView = param1b1.d;
        byte b1 = 1;
        if (recyclerView == null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (param1b2.d == null) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (bool1 != bool2)
          return (param1b1.d == null) ? b1 : -1; 
        if (param1b1.a != param1b2.a) {
          if (param1b1.a)
            b1 = -1; 
          return b1;
        } 
        int i = param1b2.b - param1b1.b;
        if (i != 0)
          return i; 
        int j = param1b1.c - param1b2.c;
        return (j != 0) ? j : 0;
      }
    };
  
  ArrayList<RecyclerView> b = new ArrayList();
  
  long c;
  
  long d;
  
  private ArrayList<b> f = new ArrayList();
  
  private RecyclerView.x a(RecyclerView paramRecyclerView, int paramInt, long paramLong) {
    if (a(paramRecyclerView, paramInt))
      return null; 
    RecyclerView.p p = paramRecyclerView.e;
    try {
      paramRecyclerView.l();
      x = p.a(paramInt, false, paramLong);
      if (x != null)
        if (x.p() && !x.n()) {
          p.a(x.a);
        } else {
          p.a(x, false);
        }  
      return x;
    } finally {
      paramRecyclerView.b(false);
    } 
  }
  
  private void a() {
    int i = this.b.size();
    byte b1 = 0;
    int j = 0;
    while (b1 < i) {
      RecyclerView recyclerView = (RecyclerView)this.b.get(b1);
      if (recyclerView.getWindowVisibility() == 0) {
        recyclerView.C.a(recyclerView, false);
        j += recyclerView.C.d;
      } 
      b1++;
    } 
    this.f.ensureCapacity(j);
    byte b2 = 0;
    byte b3 = 0;
    while (b2 < i) {
      RecyclerView recyclerView = (RecyclerView)this.b.get(b2);
      if (recyclerView.getWindowVisibility() == 0) {
        a a1 = recyclerView.C;
        int k = Math.abs(a1.a) + Math.abs(a1.b);
        byte b4 = b3;
        for (boolean bool = false; bool < 2 * a1.d; bool += true) {
          boolean bool1;
          b b5;
          if (b4 >= this.f.size()) {
            b5 = new b();
            this.f.add(b5);
          } else {
            b5 = (b)this.f.get(b4);
          } 
          int m = a1.c[bool + true];
          if (m <= k) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          b5.a = bool1;
          b5.b = k;
          b5.c = m;
          b5.d = recyclerView;
          b5.e = a1.c[bool];
          b4++;
        } 
        b3 = b4;
      } 
      b2++;
    } 
    Collections.sort(this.f, e);
  }
  
  private void a(RecyclerView paramRecyclerView, long paramLong) {
    if (paramRecyclerView == null)
      return; 
    if (paramRecyclerView.x && paramRecyclerView.g.c() != 0)
      paramRecyclerView.c(); 
    a a1 = paramRecyclerView.C;
    a1.a(paramRecyclerView, true);
    if (a1.d != 0)
      try {
        c.a("RV Nested Prefetch");
        paramRecyclerView.D.a(paramRecyclerView.m);
        for (boolean bool = false; bool < 2 * a1.d; bool += true)
          a(paramRecyclerView, a1.c[bool], paramLong); 
        return;
      } finally {
        c.a();
      }  
  }
  
  private void a(b paramb, long paramLong) {
    long l;
    if (paramb.a) {
      l = Float.MAX_VALUE;
    } else {
      l = paramLong;
    } 
    RecyclerView.x x = a(paramb.d, paramb.e, l);
    if (x != null && x.b != null && x.p() && !x.n())
      a((RecyclerView)x.b.get(), paramLong); 
  }
  
  static boolean a(RecyclerView paramRecyclerView, int paramInt) {
    int i = paramRecyclerView.g.c();
    for (byte b1 = 0; b1 < i; b1++) {
      RecyclerView.x x = RecyclerView.e(paramRecyclerView.g.d(b1));
      if (x.c == paramInt && !x.n())
        return true; 
    } 
    return false;
  }
  
  private void b(long paramLong) {
    for (byte b1 = 0; b1 < this.f.size(); b1++) {
      b b2 = (b)this.f.get(b1);
      if (b2.d == null)
        return; 
      a(b2, paramLong);
      b2.a();
    } 
  }
  
  void a(long paramLong) {
    a();
    b(paramLong);
  }
  
  public void a(RecyclerView paramRecyclerView) { this.b.add(paramRecyclerView); }
  
  void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    if (paramRecyclerView.isAttachedToWindow() && this.c == 0L) {
      this.c = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    } 
    paramRecyclerView.C.a(paramInt1, paramInt2);
  }
  
  public void b(RecyclerView paramRecyclerView) { this.b.remove(paramRecyclerView); }
  
  public void run() {
    try {
      c.a("RV Prefetch");
      boolean bool = this.b.isEmpty();
      if (!bool) {
        int i = this.b.size();
        byte b1 = 0;
        long l = 0L;
        while (b1 < i) {
          RecyclerView recyclerView = (RecyclerView)this.b.get(b1);
          if (recyclerView.getWindowVisibility() == 0)
            l = Math.max(recyclerView.getDrawingTime(), l); 
          b1++;
        } 
        if (l != 0L) {
          a(TimeUnit.MILLISECONDS.toNanos(l) + this.d);
          return;
        } 
      } 
      return;
    } finally {
      this.c = 0L;
      c.a();
    } 
  }
  
  static class a implements RecyclerView.i.a {
    int a;
    
    int b;
    
    int[] c;
    
    int d;
    
    void a() {
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
      this.d = 0;
    }
    
    void a(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    void a(RecyclerView param1RecyclerView, boolean param1Boolean) {
      this.d = 0;
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
      RecyclerView.i i = param1RecyclerView.n;
      if (param1RecyclerView.m != null && i != null && i.p()) {
        if (param1Boolean) {
          if (!param1RecyclerView.f.d())
            i.a(param1RecyclerView.m.a(), this); 
        } else if (!param1RecyclerView.v()) {
          i.a(this.a, this.b, param1RecyclerView.D, this);
        } 
        if (this.d > i.x) {
          i.x = this.d;
          i.y = param1Boolean;
          param1RecyclerView.e.b();
        } 
      } 
    }
    
    boolean a(int param1Int) {
      if (this.c != null) {
        int i = 2 * this.d;
        for (boolean bool = false; bool < i; bool += true) {
          if (this.c[bool] == param1Int)
            return true; 
        } 
      } 
      return false;
    }
    
    public void b(int param1Int1, int param1Int2) {
      if (param1Int1 >= 0) {
        if (param1Int2 >= 0) {
          int i = 2 * this.d;
          int[] arrayOfInt1 = this.c;
          if (arrayOfInt1 == null) {
            this.c = new int[4];
            Arrays.fill(this.c, -1);
          } else if (i >= arrayOfInt1.length) {
            this.c = new int[i * 2];
            System.arraycopy(arrayOfInt1, 0, this.c, 0, arrayOfInt1.length);
          } 
          int[] arrayOfInt2 = this.c;
          arrayOfInt2[i] = param1Int1;
          arrayOfInt2[i + 1] = param1Int2;
          this.d = 1 + this.d;
          return;
        } 
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      } 
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
  }
  
  static class b {
    public boolean a;
    
    public int b;
    
    public int c;
    
    public RecyclerView d;
    
    public int e;
    
    public void a() {
      this.a = false;
      this.b = 0;
      this.c = 0;
      this.d = null;
      this.e = 0;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */