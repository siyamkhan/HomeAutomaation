package android.support.e;

import android.support.v4.g.a;
import android.support.v4.h.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class o {
  static ArrayList<ViewGroup> a;
  
  private static m b = new b();
  
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<m>>>> c = new ThreadLocal();
  
  static  {
    a = new ArrayList();
  }
  
  static a<ViewGroup, ArrayList<m>> a() {
    WeakReference weakReference1 = (WeakReference)c.get();
    if (weakReference1 != null) {
      a a2 = (a)weakReference1.get();
      if (a2 != null)
        return a2; 
    } 
    a a1 = new a();
    WeakReference weakReference2 = new WeakReference(a1);
    c.set(weakReference2);
    return a1;
  }
  
  public static void a(ViewGroup paramViewGroup, m paramm) {
    if (!a.contains(paramViewGroup) && r.x(paramViewGroup)) {
      a.add(paramViewGroup);
      if (paramm == null)
        paramm = b; 
      m m1 = paramm.o();
      c(paramViewGroup, m1);
      l.a(paramViewGroup, null);
      b(paramViewGroup, m1);
    } 
  }
  
  private static void b(ViewGroup paramViewGroup, m paramm) {
    if (paramm != null && paramViewGroup != null) {
      a a1 = new a(paramm, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(a1);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(a1);
    } 
  }
  
  private static void c(ViewGroup paramViewGroup, m paramm) {
    ArrayList arrayList = (ArrayList)a().get(paramViewGroup);
    if (arrayList != null && arrayList.size() > 0) {
      Iterator iterator = arrayList.iterator();
      while (iterator.hasNext())
        ((m)iterator.next()).d(paramViewGroup); 
    } 
    if (paramm != null)
      paramm.a(paramViewGroup, true); 
    l l = l.a(paramViewGroup);
    if (l != null)
      l.a(); 
  }
  
  private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    m a;
    
    ViewGroup b;
    
    a(m param1m, ViewGroup param1ViewGroup) {
      this.a = param1m;
      this.b = param1ViewGroup;
    }
    
    private void a() {
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
      this.b.removeOnAttachStateChangeListener(this);
    }
    
    public boolean onPreDraw() {
      ArrayList arrayList2;
      a();
      if (!o.a.remove(this.b))
        return true; 
      a a1 = o.a();
      ArrayList arrayList1 = (ArrayList)a1.get(this.b);
      if (arrayList1 == null) {
        arrayList1 = new ArrayList();
        a1.put(this.b, arrayList1);
        arrayList2 = null;
      } else {
        int i = arrayList1.size();
        arrayList2 = null;
        if (i > 0)
          arrayList2 = new ArrayList(arrayList1); 
      } 
      arrayList1.add(this.a);
      this.a.a(new n(this, a1) {
            public void a(m param2m) { ((ArrayList)this.a.get(this.b.b)).remove(param2m); }
          });
      this.a.a(this.b, false);
      if (arrayList2 != null) {
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext())
          ((m)iterator.next()).e(this.b); 
      } 
      this.a.a(this.b);
      return true;
    }
    
    public void onViewAttachedToWindow(View param1View) {}
    
    public void onViewDetachedFromWindow(View param1View) {
      a();
      o.a.remove(this.b);
      ArrayList arrayList = (ArrayList)o.a().get(this.b);
      if (arrayList != null && arrayList.size() > 0) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((m)iterator.next()).e(this.b); 
      } 
      this.a.a(true);
    }
  }
  
  class null extends n {
    null(o this$0, a param1a) {}
    
    public void a(m param1m) { ((ArrayList)this.a.get(this.b.b)).remove(param1m); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */