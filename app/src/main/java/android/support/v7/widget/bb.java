package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;

class bb extends Drawable {
  static a a;
  
  private static final double b = Math.cos(Math.toRadians(45.0D));
  
  private final int c;
  
  private Paint d;
  
  private Paint e;
  
  private Paint f;
  
  private final RectF g;
  
  private float h;
  
  private Path i;
  
  private float j;
  
  private float k;
  
  private float l;
  
  private ColorStateList m;
  
  private boolean n = true;
  
  private final int o;
  
  private final int p;
  
  private boolean q = true;
  
  private boolean r = false;
  
  bb(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) {
    this.o = paramResources.getColor(a.b.cardview_shadow_start_color);
    this.p = paramResources.getColor(a.b.cardview_shadow_end_color);
    this.c = paramResources.getDimensionPixelSize(a.c.cardview_compat_inset_shadow);
    this.d = new Paint(5);
    b(paramColorStateList);
    this.e = new Paint(5);
    this.e.setStyle(Paint.Style.FILL);
    this.h = (int)(paramFloat1 + 0.5F);
    this.g = new RectF();
    this.f = new Paint(this.e);
    this.f.setAntiAlias(false);
    a(paramFloat2, paramFloat3);
  }
  
  static float a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (paramBoolean) {
      double d1 = (paramFloat1 * 1.5F);
      double d2 = 1.0D - b;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      double d4 = d2 * d3;
      Double.isNaN(d1);
      return (float)(d1 + d4);
    } 
    return paramFloat1 * 1.5F;
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    if (paramFloat1 >= 0.0F) {
      if (paramFloat2 >= 0.0F) {
        float f1 = d(paramFloat1);
        float f2 = d(paramFloat2);
        if (f1 > f2) {
          if (!this.r)
            this.r = true; 
          f1 = f2;
        } 
        if (this.l == f1 && this.j == f2)
          return; 
        this.l = f1;
        this.j = f2;
        this.k = (int)(0.5F + f1 * 1.5F + this.c);
        this.n = true;
        invalidateSelf();
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid max shadow size ");
      stringBuilder1.append(paramFloat2);
      stringBuilder1.append(". Must be >= 0");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid shadow size ");
    stringBuilder.append(paramFloat1);
    stringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private void a(Canvas paramCanvas) {
    boolean bool2;
    boolean bool1;
    float f1 = this.h;
    float f2 = -f1 - this.k;
    float f3 = f1 + this.c + this.l / 2.0F;
    float f4 = this.g.width();
    float f5 = f3 * 2.0F;
    if (f4 - f5 > 0.0F) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.g.height() - f5 > 0.0F) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    int i1 = paramCanvas.save();
    paramCanvas.translate(f3 + this.g.left, f3 + this.g.top);
    paramCanvas.drawPath(this.i, this.e);
    if (bool1)
      paramCanvas.drawRect(0.0F, f2, this.g.width() - f5, -this.h, this.f); 
    paramCanvas.restoreToCount(i1);
    int i2 = paramCanvas.save();
    paramCanvas.translate(this.g.right - f3, this.g.bottom - f3);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.i, this.e);
    if (bool1)
      paramCanvas.drawRect(0.0F, f2, this.g.width() - f5, -this.h + this.k, this.f); 
    paramCanvas.restoreToCount(i2);
    int i3 = paramCanvas.save();
    paramCanvas.translate(f3 + this.g.left, this.g.bottom - f3);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.i, this.e);
    if (bool2)
      paramCanvas.drawRect(0.0F, f2, this.g.height() - f5, -this.h, this.f); 
    paramCanvas.restoreToCount(i3);
    int i4 = paramCanvas.save();
    paramCanvas.translate(this.g.right - f3, f3 + this.g.top);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.i, this.e);
    if (bool2)
      paramCanvas.drawRect(0.0F, f2, this.g.height() - f5, -this.h, this.f); 
    paramCanvas.restoreToCount(i4);
  }
  
  static float b(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (paramBoolean) {
      double d1 = paramFloat1;
      double d2 = 1.0D - b;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      double d4 = d2 * d3;
      Double.isNaN(d1);
      paramFloat1 = (float)(d1 + d4);
    } 
    return paramFloat1;
  }
  
  private void b(ColorStateList paramColorStateList) {
    if (paramColorStateList == null)
      paramColorStateList = ColorStateList.valueOf(0); 
    this.m = paramColorStateList;
    this.d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
  }
  
  private void b(Rect paramRect) {
    float f1 = 1.5F * this.j;
    this.g.set(paramRect.left + this.j, f1 + paramRect.top, paramRect.right - this.j, paramRect.bottom - f1);
    g();
  }
  
  private int d(float paramFloat) {
    int i1 = (int)(paramFloat + 0.5F);
    if (i1 % 2 == 1)
      i1--; 
    return i1;
  }
  
  private void g() {
    float f1 = this.h;
    RectF rectF1 = new RectF(-f1, -f1, f1, f1);
    RectF rectF2 = new RectF(rectF1);
    float f2 = this.k;
    rectF2.inset(-f2, -f2);
    Path path = this.i;
    if (path == null) {
      this.i = new Path();
    } else {
      path.reset();
    } 
    this.i.setFillType(Path.FillType.EVEN_ODD);
    this.i.moveTo(-this.h, 0.0F);
    this.i.rLineTo(-this.k, 0.0F);
    this.i.arcTo(rectF2, 180.0F, 90.0F, false);
    this.i.arcTo(rectF1, 270.0F, -90.0F, false);
    this.i.close();
    float f3 = this.h;
    float f4 = this.k;
    float f5 = f3 / (f3 + f4);
    Paint paint1 = this.e;
    float f6 = f3 + f4;
    int[] arrayOfInt1 = new int[3];
    int i1 = this.o;
    arrayOfInt1[0] = i1;
    arrayOfInt1[1] = i1;
    arrayOfInt1[2] = this.p;
    RadialGradient radialGradient = new RadialGradient(0.0F, 0.0F, f6, arrayOfInt1, new float[] { 0.0F, f5, 1.0F }, Shader.TileMode.CLAMP);
    paint1.setShader(radialGradient);
    Paint paint2 = this.f;
    float f7 = this.h;
    float f8 = -f7;
    float f9 = this.k;
    float f10 = f8 + f9;
    float f11 = -f7 - f9;
    int[] arrayOfInt2 = new int[3];
    int i2 = this.o;
    arrayOfInt2[0] = i2;
    arrayOfInt2[1] = i2;
    arrayOfInt2[2] = this.p;
    LinearGradient linearGradient = new LinearGradient(0.0F, f10, 0.0F, f11, arrayOfInt2, new float[] { 0.0F, 0.5F, 1.0F }, Shader.TileMode.CLAMP);
    paint2.setShader(linearGradient);
    this.f.setAntiAlias(false);
  }
  
  float a() { return this.h; }
  
  void a(float paramFloat) {
    if (paramFloat >= 0.0F) {
      float f1 = (int)(paramFloat + 0.5F);
      if (this.h == f1)
        return; 
      this.h = f1;
      this.n = true;
      invalidateSelf();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid radius ");
    stringBuilder.append(paramFloat);
    stringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  void a(ColorStateList paramColorStateList) {
    b(paramColorStateList);
    invalidateSelf();
  }
  
  void a(Rect paramRect) { getPadding(paramRect); }
  
  void a(boolean paramBoolean) {
    this.q = paramBoolean;
    invalidateSelf();
  }
  
  float b() { return this.l; }
  
  void b(float paramFloat) { a(paramFloat, this.j); }
  
  float c() { return this.j; }
  
  void c(float paramFloat) { a(this.l, paramFloat); }
  
  float d() {
    float f1 = this.j;
    return 2.0F * Math.max(f1, this.h + this.c + f1 / 2.0F) + 2.0F * (this.j + this.c);
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.n) {
      b(getBounds());
      this.n = false;
    } 
    paramCanvas.translate(0.0F, this.l / 2.0F);
    a(paramCanvas);
    paramCanvas.translate(0.0F, -this.l / 2.0F);
    a.a(paramCanvas, this.g, this.h, this.d);
  }
  
  float e() {
    float f1 = this.j;
    return 2.0F * Math.max(f1, this.h + this.c + f1 * 1.5F / 2.0F) + 2.0F * (1.5F * this.j + this.c);
  }
  
  ColorStateList f() { return this.m; }
  
  public int getOpacity() { return -3; }
  
  public boolean getPadding(Rect paramRect) {
    int i1 = (int)Math.ceil(a(this.j, this.h, this.q));
    int i2 = (int)Math.ceil(b(this.j, this.h, this.q));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }
  
  public boolean isStateful() {
    ColorStateList colorStateList = this.m;
    return ((colorStateList != null && colorStateList.isStateful()) || super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    this.n = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    ColorStateList colorStateList = this.m;
    int i1 = colorStateList.getColorForState(paramArrayOfInt, colorStateList.getDefaultColor());
    if (this.d.getColor() == i1)
      return false; 
    this.d.setColor(i1);
    this.n = true;
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt) {
    this.d.setAlpha(paramInt);
    this.e.setAlpha(paramInt);
    this.f.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) { this.d.setColorFilter(paramColorFilter); }
  
  static interface a {
    void a(Canvas param1Canvas, RectF param1RectF, float param1Float, Paint param1Paint);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */