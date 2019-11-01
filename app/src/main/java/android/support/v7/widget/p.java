package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.h;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.ImageView;

public class p {
  private final ImageView a;
  
  private bk b;
  
  private bk c;
  
  private bk d;
  
  public p(ImageView paramImageView) { this.a = paramImageView; }
  
  private boolean a(Drawable paramDrawable) {
    if (this.d == null)
      this.d = new bk(); 
    bk bk1 = this.d;
    bk1.a();
    ColorStateList colorStateList = h.a(this.a);
    if (colorStateList != null) {
      bk1.d = true;
      bk1.a = colorStateList;
    } 
    PorterDuff.Mode mode = h.b(this.a);
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
  
  private boolean e() {
    int i = Build.VERSION.SDK_INT;
    return (i > 21) ? ((this.b != null)) : ((i == 21));
  }
  
  public void a(int paramInt) {
    if (paramInt != 0) {
      Drawable drawable = a.b(this.a.getContext(), paramInt);
      if (drawable != null)
        al.a(drawable); 
      this.a.setImageDrawable(drawable);
    } else {
      this.a.setImageDrawable(null);
    } 
    d();
  }
  
  void a(ColorStateList paramColorStateList) {
    if (this.c == null)
      this.c = new bk(); 
    bk bk1 = this.c;
    bk1.a = paramColorStateList;
    bk1.d = true;
    d();
  }
  
  void a(PorterDuff.Mode paramMode) {
    if (this.c == null)
      this.c = new bk(); 
    bk bk1 = this.c;
    bk1.b = paramMode;
    bk1.c = true;
    d();
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt) {
    bm = bm.a(this.a.getContext(), paramAttributeSet, a.j.AppCompatImageView, paramInt, 0);
    try {
      Drawable drawable = this.a.getDrawable();
      if (drawable == null) {
        int i = bm.g(a.j.AppCompatImageView_srcCompat, -1);
        if (i != -1) {
          drawable = a.b(this.a.getContext(), i);
          if (drawable != null)
            this.a.setImageDrawable(drawable); 
        } 
      } 
      if (drawable != null)
        al.a(drawable); 
      if (bm.g(a.j.AppCompatImageView_tint))
        h.a(this.a, bm.e(a.j.AppCompatImageView_tint)); 
      if (bm.g(a.j.AppCompatImageView_tintMode))
        h.a(this.a, al.a(bm.a(a.j.AppCompatImageView_tintMode, -1), null)); 
      return;
    } finally {
      bm.a();
    } 
  }
  
  boolean a() {
    Drawable drawable = this.a.getBackground();
    return !(Build.VERSION.SDK_INT >= 21 && drawable instanceof android.graphics.drawable.RippleDrawable);
  }
  
  ColorStateList b() {
    bk bk1 = this.c;
    return (bk1 != null) ? bk1.a : null;
  }
  
  PorterDuff.Mode c() {
    bk bk1 = this.c;
    return (bk1 != null) ? bk1.b : null;
  }
  
  void d() {
    Drawable drawable = this.a.getDrawable();
    if (drawable != null)
      al.a(drawable); 
    if (drawable != null) {
      if (e() && a(drawable))
        return; 
      bk bk1 = this.c;
      if (bk1 != null) {
        l.a(drawable, bk1, this.a.getDrawableState());
        return;
      } 
      bk1 = this.b;
      if (bk1 != null) {
        l.a(drawable, bk1, this.a.getDrawableState());
        return;
      } 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */