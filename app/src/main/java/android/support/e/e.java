package android.support.e;

import android.graphics.Rect;
import android.support.v4.app.t;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class e extends t {
  private static boolean a(m paramm) { return (!a(paramm.f()) || !a(paramm.h()) || !a(paramm.i())); }
  
  public Object a(Object paramObject1, Object paramObject2, Object paramObject3) {
    q q = new q();
    if (paramObject1 != null)
      q.a((m)paramObject1); 
    if (paramObject2 != null)
      q.a((m)paramObject2); 
    if (paramObject3 != null)
      q.a((m)paramObject3); 
    return q;
  }
  
  public void a(ViewGroup paramViewGroup, Object paramObject) { o.a(paramViewGroup, (m)paramObject); }
  
  public void a(Object paramObject, Rect paramRect) {
    if (paramObject != null)
      ((m)paramObject).a(new m.b(this, paramRect) {
          
          }); 
  }
  
  public void a(Object paramObject, View paramView) {
    if (paramView != null) {
      m m = (m)paramObject;
      Rect rect = new Rect();
      a(paramView, rect);
      m.a(new m.b(this, rect) {
          
          });
    } 
  }
  
  public void a(Object paramObject, View paramView, ArrayList<View> paramArrayList) {
    q q = (q)paramObject;
    List list = q.g();
    list.clear();
    int i = paramArrayList.size();
    for (byte b = 0; b < i; b++)
      a(list, (View)paramArrayList.get(b)); 
    list.add(paramView);
    paramArrayList.add(paramView);
    a(q, paramArrayList);
  }
  
  public void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3) {
    m m = (m)paramObject1;
    m.c c = new m.c(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3) {
        public void a(m param1m) {}
        
        public void b(m param1m) {}
        
        public void c(m param1m) {}
        
        public void d(m param1m) {
          Object object1 = this.a;
          if (object1 != null)
            this.g.b(object1, this.b, null); 
          Object object2 = this.c;
          if (object2 != null)
            this.g.b(object2, this.d, null); 
          Object object3 = this.e;
          if (object3 != null)
            this.g.b(object3, this.f, null); 
        }
      };
    m.a(c);
  }
  
  public void a(Object paramObject, ArrayList<View> paramArrayList) {
    m m = (m)paramObject;
    if (m == null)
      return; 
    boolean bool = m instanceof q;
    byte b = 0;
    if (bool) {
      q q = (q)m;
      int i = q.q();
      while (b < i) {
        a(q.b(b), paramArrayList);
        b++;
      } 
    } else if (!a(m) && a(m.g())) {
      int i = paramArrayList.size();
      while (b < i) {
        m.b((View)paramArrayList.get(b));
        b++;
      } 
    } 
  }
  
  public void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    q q = (q)paramObject;
    if (q != null) {
      q.g().clear();
      q.g().addAll(paramArrayList2);
      b(q, paramArrayList1, paramArrayList2);
    } 
  }
  
  public boolean a(Object paramObject) { return paramObject instanceof m; }
  
  public Object b(Object paramObject) { return (paramObject != null) ? ((m)paramObject).o() : null; }
  
  public Object b(Object paramObject1, Object paramObject2, Object paramObject3) {
    m m1 = (m)paramObject1;
    m m2 = (m)paramObject2;
    m m3 = (m)paramObject3;
    if (m1 != null && m2 != null) {
      m1 = (new q()).a(m1).a(m2).a(1);
    } else if (m1 == null) {
      if (m2 != null) {
        m1 = m2;
      } else {
        m1 = null;
      } 
    } 
    if (m3 != null) {
      q q = new q();
      if (m1 != null)
        q.a(m1); 
      q.a(m3);
      return q;
    } 
    return m1;
  }
  
  public void b(Object paramObject, View paramView) {
    if (paramObject != null)
      ((m)paramObject).b(paramView); 
  }
  
  public void b(Object paramObject, View paramView, ArrayList<View> paramArrayList) { ((m)paramObject).a(new m.c(this, paramView, paramArrayList) {
          public void a(m param1m) {
            param1m.b(this);
            this.a.setVisibility(8);
            int i = this.b.size();
            for (byte b1 = 0; b1 < i; b1++)
              ((View)this.b.get(b1)).setVisibility(0); 
          }
          
          public void b(m param1m) {}
          
          public void c(m param1m) {}
          
          public void d(m param1m) {}
        }); }
  
  public void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    m m = (m)paramObject;
    boolean bool = m instanceof q;
    byte b = 0;
    if (bool) {
      q q = (q)m;
      int i = q.q();
      while (b < i) {
        b(q.b(b), paramArrayList1, paramArrayList2);
        b++;
      } 
    } else if (!a(m)) {
      List list = m.g();
      if (list.size() == paramArrayList1.size() && list.containsAll(paramArrayList1)) {
        int i;
        if (paramArrayList2 == null) {
          i = 0;
          b = 0;
        } else {
          i = paramArrayList2.size();
        } 
        while (b < i) {
          m.b((View)paramArrayList2.get(b));
          b++;
        } 
        for (int j = -1 + paramArrayList1.size(); j >= 0; j--)
          m.c((View)paramArrayList1.get(j)); 
      } 
    } 
  }
  
  public Object c(Object paramObject) {
    if (paramObject == null)
      return null; 
    q q = new q();
    q.a((m)paramObject);
    return q;
  }
  
  public void c(Object paramObject, View paramView) {
    if (paramObject != null)
      ((m)paramObject).c(paramView); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */