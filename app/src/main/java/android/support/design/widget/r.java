package android.support.design.widget;

import android.support.v4.h.r;
import android.view.View;

class r {
  private final View a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  public r(View paramView) { this.a = paramView; }
  
  private void c() {
    View view1 = this.a;
    r.e(view1, this.d - view1.getTop() - this.b);
    View view2 = this.a;
    r.f(view2, this.e - view2.getLeft() - this.c);
  }
  
  public void a() {
    this.b = this.a.getTop();
    this.c = this.a.getLeft();
    c();
  }
  
  public boolean a(int paramInt) {
    if (this.d != paramInt) {
      this.d = paramInt;
      c();
      return true;
    } 
    return false;
  }
  
  public int b() { return this.d; }
  
  public boolean b(int paramInt) {
    if (this.e != paramInt) {
      this.e = paramInt;
      c();
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */