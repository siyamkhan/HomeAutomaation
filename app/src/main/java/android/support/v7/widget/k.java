package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;
import android.support.v4.widget.c;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class k {
  private final CompoundButton a;
  
  private ColorStateList b = null;
  
  private PorterDuff.Mode c = null;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private boolean f;
  
  k(CompoundButton paramCompoundButton) { this.a = paramCompoundButton; }
  
  int a(int paramInt) {
    if (Build.VERSION.SDK_INT < 17) {
      Drawable drawable = c.a(this.a);
      if (drawable != null)
        paramInt += drawable.getIntrinsicWidth(); 
    } 
    return paramInt;
  }
  
  ColorStateList a() { return this.b; }
  
  void a(ColorStateList paramColorStateList) {
    this.b = paramColorStateList;
    this.d = true;
    d();
  }
  
  void a(PorterDuff.Mode paramMode) {
    this.c = paramMode;
    this.e = true;
    d();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    typedArray = this.a.getContext().obtainStyledAttributes(paramAttributeSet, a.j.CompoundButton, paramInt, 0);
    try {
      if (typedArray.hasValue(a.j.CompoundButton_android_button)) {
        int i = typedArray.getResourceId(a.j.CompoundButton_android_button, 0);
        if (i != 0)
          this.a.setButtonDrawable(a.b(this.a.getContext(), i)); 
      } 
      if (typedArray.hasValue(a.j.CompoundButton_buttonTint))
        c.a(this.a, typedArray.getColorStateList(a.j.CompoundButton_buttonTint)); 
      if (typedArray.hasValue(a.j.CompoundButton_buttonTintMode))
        c.a(this.a, al.a(typedArray.getInt(a.j.CompoundButton_buttonTintMode, -1), null)); 
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  PorterDuff.Mode b() { return this.c; }
  
  void c() {
    if (this.f) {
      this.f = false;
      return;
    } 
    this.f = true;
    d();
  }
  
  void d() {
    Drawable drawable = c.a(this.a);
    if (drawable != null && (this.d || this.e)) {
      Drawable drawable1 = a.g(drawable).mutate();
      if (this.d)
        a.a(drawable1, this.b); 
      if (this.e)
        a.a(drawable1, this.c); 
      if (drawable1.isStateful())
        drawable1.setState(this.a.getDrawableState()); 
      this.a.setButtonDrawable(drawable1);
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */