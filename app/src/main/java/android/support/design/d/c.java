package android.support.design.d;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewParent;

public final class c {
  private final View a;
  
  private boolean b;
  
  private int c;
  
  private void d() {
    ViewParent viewParent = this.a.getParent();
    if (viewParent instanceof CoordinatorLayout)
      ((CoordinatorLayout)viewParent).b(this.a); 
  }
  
  public void a(int paramInt) { this.c = paramInt; }
  
  public void a(Bundle paramBundle) {
    this.b = paramBundle.getBoolean("expanded", false);
    this.c = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.b)
      d(); 
  }
  
  public boolean a() { return this.b; }
  
  public Bundle b() {
    Bundle bundle = new Bundle();
    bundle.putBoolean("expanded", this.b);
    bundle.putInt("expandedComponentIdHint", this.c);
    return bundle;
  }
  
  public int c() { return this.c; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */