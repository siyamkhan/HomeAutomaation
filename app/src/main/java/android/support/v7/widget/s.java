package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.k;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class s extends PopupWindow {
  private static final boolean a;
  
  private boolean b;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
  
  public s(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    bm bm = bm.a(paramContext, paramAttributeSet, a.j.PopupWindow, paramInt1, paramInt2);
    if (bm.g(a.j.PopupWindow_overlapAnchor))
      a(bm.a(a.j.PopupWindow_overlapAnchor, false)); 
    setBackgroundDrawable(bm.a(a.j.PopupWindow_android_popupBackground));
    bm.a();
  }
  
  private void a(boolean paramBoolean) {
    if (a) {
      this.b = paramBoolean;
      return;
    } 
    k.a(this, paramBoolean);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2) {
    if (a && this.b)
      paramInt2 -= paramView.getHeight(); 
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    if (a && this.b)
      paramInt2 -= paramView.getHeight(); 
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (a && this.b)
      paramInt2 -= paramView.getHeight(); 
    super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */