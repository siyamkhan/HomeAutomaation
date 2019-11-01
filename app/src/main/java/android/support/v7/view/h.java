package android.support.v7.view;

import android.support.v4.h.v;
import android.support.v4.h.w;
import android.support.v4.h.x;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
  final ArrayList<v> a = new ArrayList();
  
  w b;
  
  private long c = -1L;
  
  private Interpolator d;
  
  private boolean e;
  
  private final x f = new x(this) {
      private boolean b = false;
      
      private int c = 0;
      
      void a() {
        this.c = 0;
        this.b = false;
        this.a.b();
      }
      
      public void a(View param1View) {
        if (this.b)
          return; 
        this.b = true;
        if (this.a.b != null)
          this.a.b.a(null); 
      }
      
      public void b(View param1View) {
        int i = 1 + this.c;
        this.c = i;
        if (i == this.a.a.size()) {
          if (this.a.b != null)
            this.a.b.b(null); 
          a();
        } 
      }
    };
  
  public h a(long paramLong) {
    if (!this.e)
      this.c = paramLong; 
    return this;
  }
  
  public h a(v paramv) {
    if (!this.e)
      this.a.add(paramv); 
    return this;
  }
  
  public h a(v paramv1, v paramv2) {
    this.a.add(paramv1);
    paramv2.b(paramv1.a());
    this.a.add(paramv2);
    return this;
  }
  
  public h a(w paramw) {
    if (!this.e)
      this.b = paramw; 
    return this;
  }
  
  public h a(Interpolator paramInterpolator) {
    if (!this.e)
      this.d = paramInterpolator; 
    return this;
  }
  
  public void a() {
    if (this.e)
      return; 
    for (v v : this.a) {
      long l = this.c;
      if (l >= 0L)
        v.a(l); 
      Interpolator interpolator = this.d;
      if (interpolator != null)
        v.a(interpolator); 
      if (this.b != null)
        v.a(this.f); 
      v.c();
    } 
    this.e = true;
  }
  
  void b() { this.e = false; }
  
  public void c() {
    if (!this.e)
      return; 
    Iterator iterator = this.a.iterator();
    while (iterator.hasNext())
      ((v)iterator.next()).b(); 
    this.e = false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */