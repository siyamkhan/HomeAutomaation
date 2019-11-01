package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;

class g {
  private final View a;
  
  private final l b;
  
  private int c = -1;
  
  private bk d;
  
  private bk e;
  
  private bk f;
  
  g(View paramView) {
    this.a = paramView;
    this.b = l.a();
  }
  
  private boolean b(Drawable paramDrawable) {
    if (this.f == null)
      this.f = new bk(); 
    bk bk1 = this.f;
    bk1.a();
    ColorStateList colorStateList = r.t(this.a);
    if (colorStateList != null) {
      bk1.d = true;
      bk1.a = colorStateList;
    } 
    PorterDuff.Mode mode = r.u(this.a);
    if (mode != null) {
      bk1.c = true;
      bk1.b = mode;
    } 
    if (bk1.d || bk1.c) {
      l.a(paramDrawable, bk1, this.a.getDrawableState());
      return true;
    } 
    return false;
  }
  
  private boolean d() {
    int i = Build.VERSION.SDK_INT;
    return (i > 21) ? ((this.d != null)) : ((i == 21));
  }
  
  ColorStateList a() {
    bk bk1 = this.e;
    return (bk1 != null) ? bk1.a : null;
  }
  
  void a(int paramInt) {
    ColorStateList colorStateList;
    this.c = paramInt;
    l l1 = this.b;
    if (l1 != null) {
      colorStateList = l1.b(this.a.getContext(), paramInt);
    } else {
      colorStateList = null;
    } 
    b(colorStateList);
    c();
  }
  
  void a(ColorStateList paramColorStateList) {
    if (this.e == null)
      this.e = new bk(); 
    bk bk1 = this.e;
    bk1.a = paramColorStateList;
    bk1.d = true;
    c();
  }
  
  void a(PorterDuff.Mode paramMode) {
    if (this.e == null)
      this.e = new bk(); 
    bk bk1 = this.e;
    bk1.b = paramMode;
    bk1.c = true;
    c();
  }
  
  void a(Drawable paramDrawable) {
    this.c = -1;
    b(null);
    c();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    bm = bm.a(this.a.getContext(), paramAttributeSet, a.j.ViewBackgroundHelper, paramInt, 0);
    try {
      if (bm.g(a.j.ViewBackgroundHelper_android_background)) {
        this.c = bm.g(a.j.ViewBackgroundHelper_android_background, -1);
        ColorStateList colorStateList = this.b.b(this.a.getContext(), this.c);
        if (colorStateList != null)
          b(colorStateList); 
      } 
      if (bm.g(a.j.ViewBackgroundHelper_backgroundTint))
        r.a(this.a, bm.e(a.j.ViewBackgroundHelper_backgroundTint)); 
      if (bm.g(a.j.ViewBackgroundHelper_backgroundTintMode))
        r.a(this.a, al.a(bm.a(a.j.ViewBackgroundHelper_backgroundTintMode, -1), null)); 
      return;
    } finally {
      bm.a();
    } 
  }
  
  PorterDuff.Mode b() {
    bk bk1 = this.e;
    return (bk1 != null) ? bk1.b : null;
  }
  
  void b(ColorStateList paramColorStateList) {
    if (paramColorStateList != null) {
      if (this.d == null)
        this.d = new bk(); 
      bk bk1 = this.d;
      bk1.a = paramColorStateList;
      bk1.d = true;
    } else {
      this.d = null;
    } 
    c();
  }
  
  void c() {
    Drawable drawable = this.a.getBackground();
    if (drawable != null) {
      if (d() && b(drawable))
        return; 
      bk bk1 = this.e;
      if (bk1 != null) {
        l.a(drawable, bk1, this.a.getDrawableState());
        return;
      } 
      bk1 = this.d;
      if (bk1 != null) {
        l.a(drawable, bk1, this.a.getDrawableState());
        return;
      } 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */