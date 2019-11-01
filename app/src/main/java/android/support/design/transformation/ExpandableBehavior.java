package android.support.design.transformation;

import android.content.Context;
import android.support.design.d.b;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.b<View> {
  private int a = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private boolean a(boolean paramBoolean) {
    if (paramBoolean) {
      int i = this.a;
      if (i != 0) {
        boolean bool = false;
        return (i == 2) ? true : bool;
      } 
    } else {
      int i = this.a;
      boolean bool = false;
      if (i == 1)
        bool = true; 
      return bool;
    } 
    return true;
  }
  
  protected b a(CoordinatorLayout paramCoordinatorLayout, View paramView) {
    List list = paramCoordinatorLayout.c(paramView);
    int i = list.size();
    for (byte b1 = 0; b1 < i; b1++) {
      View view = (View)list.get(b1);
      if (a(paramCoordinatorLayout, paramView, view))
        return (b)view; 
    } 
    return null;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt) {
    if (!r.x(paramView)) {
      b b1 = a(paramCoordinatorLayout, paramView);
      if (b1 != null && a(b1.a())) {
        byte b2;
        if (b1.a()) {
          b2 = 1;
        } else {
          b2 = 2;
        } 
        this.a = b2;
        int i = this.a;
        paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this, paramView, i, b1) {
              public boolean onPreDraw() {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.a(this.d) == this.b) {
                  ExpandableBehavior expandableBehavior = this.d;
                  b b1 = this.c;
                  expandableBehavior.a((View)b1, this.a, b1.a(), false);
                } 
                return false;
              }
            });
      } 
    } 
    return false;
  }
  
  public abstract boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  protected abstract boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {
    b b1 = (b)paramView2;
    if (a(b1.a())) {
      byte b2;
      if (b1.a()) {
        b2 = 1;
      } else {
        b2 = 2;
      } 
      this.a = b2;
      return a((View)b1, paramView1, b1.a(), true);
    } 
    return false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\transformation\ExpandableBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */