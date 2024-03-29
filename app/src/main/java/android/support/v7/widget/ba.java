package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class ba extends Drawable {
  private float a;
  
  private final Paint b;
  
  private final RectF c;
  
  private final Rect d;
  
  private float e;
  
  private boolean f = false;
  
  private boolean g = true;
  
  private ColorStateList h;
  
  private PorterDuffColorFilter i;
  
  private ColorStateList j;
  
  private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
  
  ba(ColorStateList paramColorStateList, float paramFloat) {
    this.a = paramFloat;
    this.b = new Paint(5);
    b(paramColorStateList);
    this.c = new RectF();
    this.d = new Rect();
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode) { return (paramColorStateList == null || paramMode == null) ? null : new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode); }
  
  private void a(Rect paramRect) {
    if (paramRect == null)
      paramRect = getBounds(); 
    this.c.set(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    this.d.set(paramRect);
    if (this.f) {
      float f1 = bb.a(this.e, this.a, this.g);
      float f2 = bb.b(this.e, this.a, this.g);
      this.d.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.c.set(this.d);
    } 
  }
  
  private void b(ColorStateList paramColorStateList) {
    if (paramColorStateList == null)
      paramColorStateList = ColorStateList.valueOf(0); 
    this.h = paramColorStateList;
    this.b.setColor(this.h.getColorForState(getState(), this.h.getDefaultColor()));
  }
  
  float a() { return this.e; }
  
  void a(float paramFloat) {
    if (paramFloat == this.a)
      return; 
    this.a = paramFloat;
    a(null);
    invalidateSelf();
  }
  
  void a(float paramFloat, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramFloat == this.e && this.f == paramBoolean1 && this.g == paramBoolean2)
      return; 
    this.e = paramFloat;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    a(null);
    invalidateSelf();
  }
  
  public void a(ColorStateList paramColorStateList) {
    b(paramColorStateList);
    invalidateSelf();
  }
  
  public float b() { return this.a; }
  
  public ColorStateList c() { return this.h; }
  
  public void draw(Canvas paramCanvas) {
    boolean bool;
    Paint paint = this.b;
    if (this.i != null && paint.getColorFilter() == null) {
      paint.setColorFilter(this.i);
      bool = true;
    } else {
      bool = false;
    } 
    RectF rectF = this.c;
    float f1 = this.a;
    paramCanvas.drawRoundRect(rectF, f1, f1, paint);
    if (bool)
      paint.setColorFilter(null); 
  }
  
  public int getOpacity() { return -3; }
  
  public void getOutline(Outline paramOutline) { paramOutline.setRoundRect(this.d, this.a); }
  
  public boolean isStateful() {
    ColorStateList colorStateList = this.j;
    if (colorStateList == null || !colorStateList.isStateful()) {
      ColorStateList colorStateList1 = this.h;
      if ((colorStateList1 == null || !colorStateList1.isStateful()) && !super.isStateful())
        return false; 
    } 
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    a(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    boolean bool;
    ColorStateList colorStateList1 = this.h;
    int m = colorStateList1.getColorForState(paramArrayOfInt, colorStateList1.getDefaultColor());
    if (m != this.b.getColor()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      this.b.setColor(m); 
    ColorStateList colorStateList2 = this.j;
    if (colorStateList2 != null) {
      PorterDuff.Mode mode = this.k;
      if (mode != null) {
        this.i = a(colorStateList2, mode);
        return true;
      } 
    } 
    return bool;
  }
  
  public void setAlpha(int paramInt) { this.b.setAlpha(paramInt); }
  
  public void setColorFilter(ColorFilter paramColorFilter) { this.b.setColorFilter(paramColorFilter); }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.j = paramColorStateList;
    this.i = a(this.j, this.k);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    this.k = paramMode;
    this.i = a(this.j, this.k);
    invalidateSelf();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */