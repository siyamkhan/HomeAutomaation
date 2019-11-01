package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

class x extends t {
  private final SeekBar a;
  
  private Drawable b;
  
  private ColorStateList c = null;
  
  private PorterDuff.Mode d = null;
  
  private boolean e = false;
  
  private boolean f = false;
  
  x(SeekBar paramSeekBar) {
    super(paramSeekBar);
    this.a = paramSeekBar;
  }
  
  private void d() {
    if (this.b != null && (this.e || this.f)) {
      this.b = a.g(this.b.mutate());
      if (this.e)
        a.a(this.b, this.c); 
      if (this.f)
        a.a(this.b, this.d); 
      if (this.b.isStateful())
        this.b.setState(this.a.getDrawableState()); 
    } 
  }
  
  void a(Canvas paramCanvas) {
    if (this.b != null) {
      int i = this.a.getMax();
      int j = 1;
      if (i > j) {
        byte b1;
        int k = this.b.getIntrinsicWidth();
        int m = this.b.getIntrinsicHeight();
        if (k >= 0) {
          b1 = k / 2;
        } else {
          b1 = 1;
        } 
        if (m >= 0)
          j = m / 2; 
        this.b.setBounds(-b1, -j, b1, j);
        float f1 = (this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight()) / i;
        int n = paramCanvas.save();
        paramCanvas.translate(this.a.getPaddingLeft(), (this.a.getHeight() / 2));
        for (byte b2 = 0; b2 <= i; b2++) {
          this.b.draw(paramCanvas);
          paramCanvas.translate(f1, 0.0F);
        } 
        paramCanvas.restoreToCount(n);
      } 
    } 
  }
  
  void a(Drawable paramDrawable) {
    Drawable drawable = this.b;
    if (drawable != null)
      drawable.setCallback(null); 
    this.b = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this.a);
      a.b(paramDrawable, r.f(this.a));
      if (paramDrawable.isStateful())
        paramDrawable.setState(this.a.getDrawableState()); 
      d();
    } 
    this.a.invalidate();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    super.a(paramAttributeSet, paramInt);
    bm bm = bm.a(this.a.getContext(), paramAttributeSet, a.j.AppCompatSeekBar, paramInt, 0);
    Drawable drawable = bm.b(a.j.AppCompatSeekBar_android_thumb);
    if (drawable != null)
      this.a.setThumb(drawable); 
    a(bm.a(a.j.AppCompatSeekBar_tickMark));
    if (bm.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
      this.d = al.a(bm.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
      this.f = true;
    } 
    if (bm.g(a.j.AppCompatSeekBar_tickMarkTint)) {
      this.c = bm.e(a.j.AppCompatSeekBar_tickMarkTint);
      this.e = true;
    } 
    bm.a();
    d();
  }
  
  void b() {
    Drawable drawable = this.b;
    if (drawable != null)
      drawable.jumpToCurrentState(); 
  }
  
  void c() {
    Drawable drawable = this.b;
    if (drawable != null && drawable.isStateful() && drawable.setState(this.a.getDrawableState()))
      this.a.invalidateDrawable(drawable); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */