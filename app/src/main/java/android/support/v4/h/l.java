package android.support.v4.h;

import android.view.View;
import android.view.ViewParent;

public class l {
  private ViewParent a;
  
  private ViewParent b;
  
  private final View c;
  
  private boolean d;
  
  private int[] e;
  
  public l(View paramView) { this.c = paramView; }
  
  private void a(int paramInt, ViewParent paramViewParent) {
    switch (paramInt) {
      default:
        return;
      case 1:
        this.b = paramViewParent;
        return;
      case 0:
        break;
    } 
    this.a = paramViewParent;
  }
  
  private ViewParent d(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 1:
        return this.b;
      case 0:
        break;
    } 
    return this.a;
  }
  
  public void a(boolean paramBoolean) {
    if (this.d)
      r.w(this.c); 
    this.d = paramBoolean;
  }
  
  public boolean a() { return this.d; }
  
  public boolean a(float paramFloat1, float paramFloat2) {
    if (a()) {
      ViewParent viewParent = d(0);
      if (viewParent != null)
        return u.a(viewParent, this.c, paramFloat1, paramFloat2); 
    } 
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (a()) {
      ViewParent viewParent = d(0);
      if (viewParent != null)
        return u.a(viewParent, this.c, paramFloat1, paramFloat2, paramBoolean); 
    } 
    return false;
  }
  
  public boolean a(int paramInt) { return (d(paramInt) != null); }
  
  public boolean a(int paramInt1, int paramInt2) {
    if (a(paramInt2))
      return true; 
    if (a()) {
      ViewParent viewParent = this.c.getParent();
      View view = this.c;
      while (viewParent != null) {
        if (u.a(viewParent, view, this.c, paramInt1, paramInt2)) {
          a(paramInt2, viewParent);
          u.b(viewParent, view, this.c, paramInt1, paramInt2);
          return true;
        } 
        if (viewParent instanceof View)
          view = (View)viewParent; 
        viewParent = viewParent.getParent();
      } 
    } 
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt) { return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0); }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5) {
    if (a()) {
      ViewParent viewParent = d(paramInt5);
      if (viewParent == null)
        return false; 
      if (paramInt1 != 0 || paramInt2 != 0 || paramInt3 != 0 || paramInt4 != 0) {
        int j;
        int i;
        if (paramArrayOfInt != null) {
          this.c.getLocationInWindow(paramArrayOfInt);
          int k = paramArrayOfInt[0];
          int m = paramArrayOfInt[1];
          i = k;
          j = m;
        } else {
          i = 0;
          j = 0;
        } 
        u.a(viewParent, this.c, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        if (paramArrayOfInt != null) {
          this.c.getLocationInWindow(paramArrayOfInt);
          paramArrayOfInt[0] = paramArrayOfInt[0] - i;
          paramArrayOfInt[1] = paramArrayOfInt[1] - j;
        } 
        return true;
      } 
      if (paramArrayOfInt != null) {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        return false;
      } 
    } 
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) { return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0); }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3) {
    if (a()) {
      ViewParent viewParent = d(paramInt3);
      if (viewParent == null)
        return false; 
      boolean bool = true;
      if (paramInt1 != 0 || paramInt2 != 0) {
        int j;
        int i;
        if (paramArrayOfInt2 != null) {
          this.c.getLocationInWindow(paramArrayOfInt2);
          int k = paramArrayOfInt2[0];
          int m = paramArrayOfInt2[bool];
          i = k;
          j = m;
        } else {
          i = 0;
          j = 0;
        } 
        if (paramArrayOfInt1 == null) {
          if (this.e == null)
            this.e = new int[2]; 
          paramArrayOfInt1 = this.e;
        } 
        paramArrayOfInt1[0] = 0;
        paramArrayOfInt1[bool] = 0;
        u.a(viewParent, this.c, paramInt1, paramInt2, paramArrayOfInt1, paramInt3);
        if (paramArrayOfInt2 != null) {
          this.c.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] = paramArrayOfInt2[0] - i;
          paramArrayOfInt2[bool] = paramArrayOfInt2[bool] - j;
        } 
        if (paramArrayOfInt1[0] == 0) {
          if (paramArrayOfInt1[bool] != 0)
            return bool; 
          bool = false;
        } 
        return bool;
      } 
      if (paramArrayOfInt2 != null) {
        paramArrayOfInt2[0] = 0;
        paramArrayOfInt2[bool] = 0;
        return false;
      } 
    } 
    return false;
  }
  
  public boolean b() { return a(0); }
  
  public boolean b(int paramInt) { return a(paramInt, 0); }
  
  public void c() { c(0); }
  
  public void c(int paramInt) {
    ViewParent viewParent = d(paramInt);
    if (viewParent != null) {
      u.a(viewParent, this.c, paramInt);
      a(paramInt, null);
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */