package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class q<V extends View> extends CoordinatorLayout.b<V> {
  private r a;
  
  private int b = 0;
  
  private int c = 0;
  
  public q() {}
  
  public q(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public boolean a(int paramInt) {
    r r1 = this.a;
    if (r1 != null)
      return r1.a(paramInt); 
    this.b = paramInt;
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    b(paramCoordinatorLayout, paramV, paramInt);
    if (this.a == null)
      this.a = new r(paramV); 
    this.a.a();
    int i = this.b;
    if (i != 0) {
      this.a.a(i);
      this.b = 0;
    } 
    int j = this.c;
    if (j != 0) {
      this.a.b(j);
      this.c = 0;
    } 
    return true;
  }
  
  public int b() {
    r r1 = this.a;
    return (r1 != null) ? r1.b() : 0;
  }
  
  protected void b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) { paramCoordinatorLayout.a(paramV, paramInt); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */