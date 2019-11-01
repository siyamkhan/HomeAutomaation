package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.a;

public class a extends Drawable {
  final Paint a;
  
  final Rect b;
  
  final RectF c;
  
  final a d;
  
  float e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private ColorStateList j;
  
  private int k;
  
  private boolean l;
  
  private float m;
  
  private Shader a() {
    Rect rect = this.b;
    copyBounds(rect);
    float f1 = this.e / rect.height();
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = a.a(this.f, this.k);
    arrayOfInt[1] = a.a(this.g, this.k);
    arrayOfInt[2] = a.a(a.b(this.g, 0), this.k);
    arrayOfInt[3] = a.a(a.b(this.i, 0), this.k);
    arrayOfInt[4] = a.a(this.i, this.k);
    arrayOfInt[5] = a.a(this.h, this.k);
    float[] arrayOfFloat = new float[6];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = f1;
    arrayOfFloat[2] = 0.5F;
    arrayOfFloat[3] = 0.5F;
    arrayOfFloat[4] = 1.0F - f1;
    arrayOfFloat[5] = 1.0F;
    return new LinearGradient(0.0F, rect.top, 0.0F, rect.bottom, arrayOfInt, arrayOfFloat, Shader.TileMode.CLAMP);
  }
  
  public final void a(float paramFloat) {
    if (paramFloat != this.m) {
      this.m = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void a(ColorStateList paramColorStateList) {
    if (paramColorStateList != null)
      this.k = paramColorStateList.getColorForState(getState(), this.k); 
    this.j = paramColorStateList;
    this.l = true;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.l) {
      this.a.setShader(a());
      this.l = false;
    } 
    float f1 = this.a.getStrokeWidth() / 2.0F;
    RectF rectF = this.c;
    copyBounds(this.b);
    rectF.set(this.b);
    rectF.left = f1 + rectF.left;
    rectF.top = f1 + rectF.top;
    rectF.right -= f1;
    rectF.bottom -= f1;
    paramCanvas.save();
    paramCanvas.rotate(this.m, rectF.centerX(), rectF.centerY());
    paramCanvas.drawOval(rectF, this.a);
    paramCanvas.restore();
  }
  
  public Drawable.ConstantState getConstantState() { return this.d; }
  
  public int getOpacity() { return (this.e > 0.0F) ? -3 : -2; }
  
  public boolean getPadding(Rect paramRect) {
    int n = Math.round(this.e);
    paramRect.set(n, n, n, n);
    return true;
  }
  
  public boolean isStateful() {
    ColorStateList colorStateList = this.j;
    return ((colorStateList != null && colorStateList.isStateful()) || super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect) { this.l = true; }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    ColorStateList colorStateList = this.j;
    if (colorStateList != null) {
      int n = colorStateList.getColorForState(paramArrayOfInt, this.k);
      if (n != this.k) {
        this.l = true;
        this.k = n;
      } 
    } 
    if (this.l)
      invalidateSelf(); 
    return this.l;
  }
  
  public void setAlpha(int paramInt) {
    this.a.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  private class a extends Drawable.ConstantState {
    public int getChangingConfigurations() { return 0; }
    
    public Drawable newDrawable() { return this.a; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */