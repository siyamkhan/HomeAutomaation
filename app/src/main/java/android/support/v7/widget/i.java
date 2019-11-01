package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.o;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class i extends CheckBox implements o {
  private final k a = new k(this);
  
  public i(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.checkboxStyle); }
  
  public i(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(bj.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft() {
    int j = super.getCompoundPaddingLeft();
    k k1 = this.a;
    if (k1 != null)
      j = k1.a(j); 
    return j;
  }
  
  public ColorStateList getSupportButtonTintList() {
    k k1 = this.a;
    return (k1 != null) ? k1.a() : null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode() {
    k k1 = this.a;
    return (k1 != null) ? k1.b() : null;
  }
  
  public void setButtonDrawable(int paramInt) { setButtonDrawable(a.b(getContext(), paramInt)); }
  
  public void setButtonDrawable(Drawable paramDrawable) {
    super.setButtonDrawable(paramDrawable);
    k k1 = this.a;
    if (k1 != null)
      k1.c(); 
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList) {
    k k1 = this.a;
    if (k1 != null)
      k1.a(paramColorStateList); 
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode) {
    k k1 = this.a;
    if (k1 != null)
      k1.a(paramMode); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */