package android.support.design.widget;

import android.support.v4.h.r;
import android.support.v4.widget.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {
  q a;
  
  a b;
  
  int c = 2;
  
  float d = 0.5F;
  
  float e = 0.0F;
  
  float f = 0.5F;
  
  private boolean g;
  
  private float h = 0.0F;
  
  private boolean i;
  
  private final q.a j = new q.a(this) {
      private int b;
      
      private int c = -1;
      
      private boolean a(View param1View, float param1Float) {
        if (param1Float != 0.0F) {
          boolean bool1;
          if (r.f(param1View) == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (this.a.c == 2)
            return true; 
          if (this.a.c == 0) {
            if (bool1) {
              int n = param1Float cmp 0.0F;
              boolean bool3 = false;
              if (n < 0)
                return true; 
            } else {
              int n = param1Float cmp 0.0F;
              boolean bool3 = false;
              if (n > 0)
                return true; 
            } 
            return SYNTHETIC_LOCAL_VARIABLE_13;
          } 
          int m = this.a.c;
          boolean bool2 = false;
          if (m == 1)
            if (bool1) {
              int n = param1Float cmp 0.0F;
              bool2 = false;
              if (n > 0)
                return true; 
            } else {
              int n = param1Float cmp 0.0F;
              bool2 = false;
              if (n < 0)
                return true; 
            }  
          return bool2;
        } 
        int i = param1View.getLeft() - this.b;
        int j = Math.round(param1View.getWidth() * this.a.d);
        int k = Math.abs(i);
        boolean bool = false;
        if (k >= j)
          bool = true; 
        return bool;
      }
      
      public int a(View param1View, int param1Int1, int param1Int2) { return param1View.getTop(); }
      
      public void a(int param1Int) {
        if (this.a.b != null)
          this.a.b.a(param1Int); 
      }
      
      public void a(View param1View, float param1Float1, float param1Float2) {
        boolean bool;
        int j;
        this.c = -1;
        int i = param1View.getWidth();
        if (a(param1View, param1Float1)) {
          int k = param1View.getLeft();
          int m = this.b;
          if (k < m) {
            j = m - i;
          } else {
            j = m + i;
          } 
          bool = true;
        } else {
          j = this.b;
          bool = false;
        } 
        if (this.a.a.a(j, param1View.getTop())) {
          r.a(param1View, new SwipeDismissBehavior.b(this.a, param1View, bool));
          return;
        } 
        if (bool && this.a.b != null)
          this.a.b.a(param1View); 
      }
      
      public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        float f1 = this.b + param1View.getWidth() * this.a.e;
        float f2 = this.b + param1View.getWidth() * this.a.f;
        float f3 = param1Int1;
        if (f3 <= f1) {
          param1View.setAlpha(1.0F);
          return;
        } 
        if (f3 >= f2) {
          param1View.setAlpha(0.0F);
          return;
        } 
        param1View.setAlpha(SwipeDismissBehavior.a(0.0F, 1.0F - SwipeDismissBehavior.b(f1, f2, f3), 1.0F));
      }
      
      public boolean a(View param1View, int param1Int) { return (this.c == -1 && this.a.a(param1View)); }
      
      public int b(View param1View) { return param1View.getWidth(); }
      
      public int b(View param1View, int param1Int1, int param1Int2) {
        boolean bool;
        if (r.f(param1View) == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        if (this.a.c == 0) {
          if (bool) {
            int k = this.b - param1View.getWidth();
            int m = this.b;
          } 
        } else {
          if (this.a.c == 1) {
            if (bool) {
              int n = this.b;
              int i1 = n + param1View.getWidth();
              return SwipeDismissBehavior.a(n, param1Int1, i1);
            } 
          } else {
            int n = this.b - param1View.getWidth();
            int i1 = this.b + param1View.getWidth();
            return SwipeDismissBehavior.a(n, param1Int1, i1);
          } 
          int k = this.b - param1View.getWidth();
          int m = this.b;
        } 
        int i = this.b;
        int j = i + param1View.getWidth();
        return SwipeDismissBehavior.a(i, param1Int1, j);
      }
      
      public void b(View param1View, int param1Int) {
        this.c = param1Int;
        this.b = param1View.getLeft();
        ViewParent viewParent = param1View.getParent();
        if (viewParent != null)
          viewParent.requestDisallowInterceptTouchEvent(true); 
      }
    };
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3) { return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3); }
  
  static int a(int paramInt1, int paramInt2, int paramInt3) { return Math.min(Math.max(paramInt1, paramInt2), paramInt3); }
  
  private void a(ViewGroup paramViewGroup) {
    if (this.a == null) {
      q q1;
      if (this.i) {
        q1 = q.a(paramViewGroup, this.h, this.j);
      } else {
        q1 = q.a(paramViewGroup, this.j);
      } 
      this.a = q1;
    } 
  }
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3) { return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1); }
  
  public void a(float paramFloat) { this.e = a(0.0F, paramFloat, 1.0F); }
  
  public void a(int paramInt) { this.c = paramInt; }
  
  public void a(a parama) { this.b = parama; }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    q q1 = this.a;
    if (q1 != null) {
      q1.b(paramMotionEvent);
      return true;
    } 
    return false;
  }
  
  public boolean a(View paramView) { return true; }
  
  public void b(float paramFloat) { this.f = a(0.0F, paramFloat, 1.0F); }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    boolean bool = this.g;
    int k = paramMotionEvent.getActionMasked();
    if (k != 3) {
      switch (k) {
        case 0:
          this.g = paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          bool = this.g;
          break;
        case 1:
          this.g = false;
          break;
      } 
      if (bool) {
        a(paramCoordinatorLayout);
        return this.a.a(paramMotionEvent);
      } 
      return false;
    } 
  }
  
  public static interface a {
    void a(int param1Int);
    
    void a(View param1View);
  }
  
  private class b implements Runnable {
    private final View b;
    
    private final boolean c;
    
    b(SwipeDismissBehavior this$0, View param1View, boolean param1Boolean) {
      this.b = param1View;
      this.c = param1Boolean;
    }
    
    public void run() {
      if (this.a.a != null && this.a.a.a(true)) {
        r.a(this.b, this);
        return;
      } 
      if (this.c && this.a.b != null)
        this.a.b.a(this.b); 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\SwipeDismissBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */