package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v7.d.a.c;

public class l extends c {
  static final double a = Math.cos(Math.toRadians(45.0D));
  
  final Paint b;
  
  final Paint c;
  
  final RectF d;
  
  float e;
  
  Path f;
  
  float g;
  
  float h;
  
  float i;
  
  float j;
  
  private boolean k;
  
  private final int l;
  
  private final int m;
  
  private final int n;
  
  private boolean o;
  
  private float p;
  
  private boolean q;
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (paramBoolean) {
      double d1 = (paramFloat1 * 1.5F);
      double d2 = 1.0D - a;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      double d4 = d2 * d3;
      Double.isNaN(d1);
      return (float)(d1 + d4);
    } 
    return paramFloat1 * 1.5F;
  }
  
  private void a(Canvas paramCanvas) {
    float f16;
    float f15;
    float f13;
    int i4;
    float f12;
    int i3;
    boolean bool2;
    boolean bool1;
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.p, this.d.centerX(), this.d.centerY());
    float f1 = this.e;
    float f2 = -f1 - this.i;
    float f3 = this.d.width();
    float f4 = f1 * 2.0F;
    if (f3 - f4 > 0.0F) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.d.height() - f4 > 0.0F) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    float f5 = this.j;
    float f6 = f5 - 0.25F * f5;
    float f7 = f5 - 0.5F * f5;
    float f8 = f5 - f5 * 1.0F;
    float f9 = f1 / (f7 + f1);
    float f10 = f1 / (f6 + f1);
    float f11 = f1 / (f8 + f1);
    int i2 = paramCanvas.save();
    paramCanvas.translate(f1 + this.d.left, f1 + this.d.top);
    paramCanvas.scale(f9, f10);
    paramCanvas.drawPath(this.f, this.b);
    if (bool1) {
      paramCanvas.scale(1.0F / f9, 1.0F);
      float f18 = this.d.width() - f4;
      float f19 = -this.e;
      Paint paint = this.c;
      i3 = i2;
      f12 = f11;
      i4 = i1;
      f13 = f10;
      paramCanvas.drawRect(0.0F, f2, f18, f19, paint);
    } else {
      i3 = i2;
      f12 = f11;
      i4 = i1;
      f13 = f10;
    } 
    paramCanvas.restoreToCount(i3);
    int i5 = paramCanvas.save();
    paramCanvas.translate(this.d.right - f1, this.d.bottom - f1);
    float f14 = f12;
    paramCanvas.scale(f9, f14);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (bool1) {
      paramCanvas.scale(1.0F / f9, 1.0F);
      float f18 = this.d.width() - f4;
      float f19 = -this.e + this.i;
      Paint paint = this.c;
      f15 = f13;
      f16 = f14;
      paramCanvas.drawRect(0.0F, f2, f18, f19, paint);
    } else {
      f15 = f13;
      f16 = f14;
    } 
    paramCanvas.restoreToCount(i5);
    int i6 = paramCanvas.save();
    paramCanvas.translate(f1 + this.d.left, this.d.bottom - f1);
    paramCanvas.scale(f9, f16);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (bool2) {
      paramCanvas.scale(1.0F / f16, 1.0F);
      paramCanvas.drawRect(0.0F, f2, this.d.height() - f4, -this.e, this.c);
    } 
    paramCanvas.restoreToCount(i6);
    int i7 = paramCanvas.save();
    paramCanvas.translate(this.d.right - f1, f1 + this.d.top);
    float f17 = f15;
    paramCanvas.scale(f9, f17);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (bool2) {
      paramCanvas.scale(1.0F / f17, 1.0F);
      paramCanvas.drawRect(0.0F, f2, this.d.height() - f4, -this.e, this.c);
    } 
    paramCanvas.restoreToCount(i7);
    paramCanvas.restoreToCount(i4);
  }
  
  private void a(Rect paramRect) {
    float f1 = 1.5F * this.h;
    this.d.set(paramRect.left + this.h, f1 + paramRect.top, paramRect.right - this.h, paramRect.bottom - f1);
    b().setBounds((int)this.d.left, (int)this.d.top, (int)this.d.right, (int)this.d.bottom);
    c();
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (paramBoolean) {
      double d1 = paramFloat1;
      double d2 = 1.0D - a;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      double d4 = d2 * d3;
      Double.isNaN(d1);
      paramFloat1 = (float)(d1 + d4);
    } 
    return paramFloat1;
  }
  
  private static int c(float paramFloat) {
    int i1 = Math.round(paramFloat);
    if (i1 % 2 == 1)
      i1--; 
    return i1;
  }
  
  private void c() {
    float f1 = this.e;
    RectF rectF1 = new RectF(-f1, -f1, f1, f1);
    RectF rectF2 = new RectF(rectF1);
    float f2 = this.i;
    rectF2.inset(-f2, -f2);
    Path path = this.f;
    if (path == null) {
      this.f = new Path();
    } else {
      path.reset();
    } 
    this.f.setFillType(Path.FillType.EVEN_ODD);
    this.f.moveTo(-this.e, 0.0F);
    this.f.rLineTo(-this.i, 0.0F);
    this.f.arcTo(rectF2, 180.0F, 90.0F, false);
    this.f.arcTo(rectF1, 270.0F, -90.0F, false);
    this.f.close();
    float f3 = -rectF2.top;
    if (f3 > 0.0F) {
      float f6 = this.e / f3;
      float f7 = f6 + (1.0F - f6) / 2.0F;
      Paint paint1 = this.b;
      int[] arrayOfInt1 = new int[4];
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = this.l;
      arrayOfInt1[2] = this.m;
      arrayOfInt1[3] = this.n;
      RadialGradient radialGradient = new RadialGradient(0.0F, 0.0F, f3, arrayOfInt1, new float[] { 0.0F, f6, f7, 1.0F }, Shader.TileMode.CLAMP);
      paint1.setShader(radialGradient);
    } 
    Paint paint = this.c;
    float f4 = rectF1.top;
    float f5 = rectF2.top;
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.l;
    arrayOfInt[1] = this.m;
    arrayOfInt[2] = this.n;
    LinearGradient linearGradient = new LinearGradient(0.0F, f4, 0.0F, f5, arrayOfInt, new float[] { 0.0F, 0.5F, 1.0F }, Shader.TileMode.CLAMP);
    paint.setShader(linearGradient);
    this.c.setAntiAlias(false);
  }
  
  public float a() { return this.j; }
  
  public void a(float paramFloat) { a(paramFloat, this.h); }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (paramFloat1 >= 0.0F && paramFloat2 >= 0.0F) {
      float f1 = c(paramFloat1);
      float f2 = c(paramFloat2);
      if (f1 > f2) {
        if (!this.q)
          this.q = true; 
        f1 = f2;
      } 
      if (this.j == f1 && this.h == f2)
        return; 
      this.j = f1;
      this.h = f2;
      this.i = Math.round(f1 * 1.5F);
      this.g = f2;
      this.k = true;
      invalidateSelf();
      return;
    } 
    throw new IllegalArgumentException("invalid shadow size");
  }
  
  public final void b(float paramFloat) {
    if (this.p != paramFloat) {
      this.p = paramFloat;
      invalidateSelf();
    } 
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.k) {
      a(getBounds());
      this.k = false;
    } 
    a(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public int getOpacity() { return -3; }
  
  public boolean getPadding(Rect paramRect) {
    int i1 = (int)Math.ceil(a(this.h, this.e, this.o));
    int i2 = (int)Math.ceil(b(this.h, this.e, this.o));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect) { this.k = true; }
  
  public void setAlpha(int paramInt) {
    super.setAlpha(paramInt);
    this.b.setAlpha(paramInt);
    this.c.setAlpha(paramInt);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */