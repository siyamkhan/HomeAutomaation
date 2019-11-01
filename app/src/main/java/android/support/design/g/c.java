package android.support.design.g;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;

public class c extends Drawable implements b {
  private final Paint a;
  
  private final Matrix[] b;
  
  private final Matrix[] c;
  
  private final d[] d;
  
  private final Matrix e;
  
  private final Path f;
  
  private final PointF g;
  
  private final d h;
  
  private final Region i;
  
  private final Region j;
  
  private final float[] k;
  
  private final float[] l;
  
  private e m;
  
  private boolean n;
  
  private boolean o;
  
  private float p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private float u;
  
  private float v;
  
  private Paint.Style w;
  
  private PorterDuffColorFilter x;
  
  private PorterDuff.Mode y;
  
  private ColorStateList z;
  
  private static int a(int paramInt1, int paramInt2) { return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8; }
  
  private a a(int paramInt) {
    switch (paramInt) {
      default:
        return this.m.a();
      case 3:
        return this.m.d();
      case 2:
        return this.m.c();
      case 1:
        break;
    } 
    return this.m.b();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    a(paramInt1, paramInt2, paramInt3, this.g);
    float f1 = c(paramInt1, paramInt2, paramInt3);
    a(paramInt1).a(f1, this.p, this.d[paramInt1]);
    float f2 = 1.5707964F + d((4 + paramInt1 - 1) % 4, paramInt2, paramInt3);
    this.b[paramInt1].reset();
    this.b[paramInt1].setTranslate(this.g.x, this.g.y);
    this.b[paramInt1].preRotate((float)Math.toDegrees(f2));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF) {
    switch (paramInt1) {
      default:
        paramPointF.set(0.0F, 0.0F);
        return;
      case 3:
        paramPointF.set(0.0F, paramInt3);
        return;
      case 2:
        paramPointF.set(paramInt2, paramInt3);
        return;
      case 1:
        break;
    } 
    paramPointF.set(paramInt2, 0.0F);
  }
  
  private void a(int paramInt, Path paramPath) {
    this.k[0] = (this.d[paramInt]).a;
    this.k[1] = (this.d[paramInt]).b;
    this.b[paramInt].mapPoints(this.k);
    if (paramInt == 0) {
      float[] arrayOfFloat = this.k;
      paramPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    } else {
      float[] arrayOfFloat = this.k;
      paramPath.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    } 
    this.d[paramInt].a(this.b[paramInt], paramPath);
  }
  
  private b b(int paramInt) {
    switch (paramInt) {
      default:
        return this.m.e();
      case 3:
        return this.m.h();
      case 2:
        return this.m.g();
      case 1:
        break;
    } 
    return this.m.f();
  }
  
  private void b() {
    ColorStateList colorStateList = this.z;
    if (colorStateList == null || this.y == null) {
      this.x = null;
      return;
    } 
    int i1 = colorStateList.getColorForState(getState(), 0);
    this.x = new PorterDuffColorFilter(i1, this.y);
    if (this.o)
      this.q = i1; 
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3) {
    this.k[0] = (this.d[paramInt1]).c;
    this.k[1] = (this.d[paramInt1]).d;
    this.b[paramInt1].mapPoints(this.k);
    float f1 = d(paramInt1, paramInt2, paramInt3);
    this.c[paramInt1].reset();
    Matrix matrix = this.c[paramInt1];
    float[] arrayOfFloat = this.k;
    matrix.setTranslate(arrayOfFloat[0], arrayOfFloat[1]);
    this.c[paramInt1].preRotate((float)Math.toDegrees(f1));
  }
  
  private void b(int paramInt1, int paramInt2, Path paramPath) {
    a(paramInt1, paramInt2, paramPath);
    if (this.u == 1.0F)
      return; 
    this.e.reset();
    Matrix matrix = this.e;
    float f1 = this.u;
    matrix.setScale(f1, f1, (paramInt1 / 2), (paramInt2 / 2));
    paramPath.transform(this.e);
  }
  
  private void b(int paramInt, Path paramPath) {
    int i1 = (paramInt + 1) % 4;
    this.k[0] = (this.d[paramInt]).c;
    this.k[1] = (this.d[paramInt]).d;
    this.b[paramInt].mapPoints(this.k);
    this.l[0] = (this.d[i1]).a;
    this.l[1] = (this.d[i1]).b;
    this.b[i1].mapPoints(this.l);
    float[] arrayOfFloat1 = this.k;
    float f1 = arrayOfFloat1[0];
    float[] arrayOfFloat2 = this.l;
    float f2 = (float)Math.hypot((f1 - arrayOfFloat2[0]), (arrayOfFloat1[1] - arrayOfFloat2[1]));
    this.h.a(0.0F, 0.0F);
    b(paramInt).a(f2, this.p, this.h);
    this.h.a(this.c[paramInt], paramPath);
  }
  
  private float c(int paramInt1, int paramInt2, int paramInt3) {
    a((4 + paramInt1 - 1) % 4, paramInt2, paramInt3, this.g);
    float f1 = this.g.x;
    float f2 = this.g.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.g);
    float f3 = this.g.x;
    float f4 = this.g.y;
    a(paramInt1, paramInt2, paramInt3, this.g);
    float f5 = this.g.x;
    float f6 = this.g.y;
    float f7 = f1 - f5;
    float f8 = f2 - f6;
    float f9 = f3 - f5;
    float f10 = f4 - f6;
    float f11 = (float)Math.atan2(f8, f7) - (float)Math.atan2(f10, f9);
    if (f11 < 0.0F) {
      double d1 = f11;
      Double.isNaN(d1);
      f11 = (float)(d1 + 6.283185307179586D);
    } 
    return f11;
  }
  
  private float d(int paramInt1, int paramInt2, int paramInt3) {
    int i1 = (paramInt1 + 1) % 4;
    a(paramInt1, paramInt2, paramInt3, this.g);
    float f1 = this.g.x;
    float f2 = this.g.y;
    a(i1, paramInt2, paramInt3, this.g);
    float f3 = this.g.x;
    float f4 = this.g.y;
    float f5 = f3 - f1;
    return (float)Math.atan2((f4 - f2), f5);
  }
  
  public ColorStateList a() { return this.z; }
  
  public void a(float paramFloat) {
    this.p = paramFloat;
    invalidateSelf();
  }
  
  public void a(int paramInt1, int paramInt2, Path paramPath) {
    byte b2;
    paramPath.rewind();
    if (this.m == null)
      return; 
    byte b1 = 0;
    while (true) {
      b2 = 0;
      if (b1 < 4) {
        a(b1, paramInt1, paramInt2);
        b(b1, paramInt1, paramInt2);
        b1++;
        continue;
      } 
      break;
    } 
    while (b2 < 4) {
      a(b2, paramPath);
      b(b2, paramPath);
      b2++;
    } 
    paramPath.close();
  }
  
  public void draw(Canvas paramCanvas) {
    this.a.setColorFilter(this.x);
    int i1 = this.a.getAlpha();
    this.a.setAlpha(a(i1, this.t));
    this.a.setStrokeWidth(this.v);
    this.a.setStyle(this.w);
    int i2 = this.r;
    if (i2 > 0 && this.n)
      this.a.setShadowLayer(this.s, 0.0F, i2, this.q); 
    if (this.m != null) {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.f);
      paramCanvas.drawPath(this.f, this.a);
    } else {
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.a);
    } 
    this.a.setAlpha(i1);
  }
  
  public int getOpacity() { return -3; }
  
  public Region getTransparentRegion() {
    Rect rect = getBounds();
    this.i.set(rect);
    b(rect.width(), rect.height(), this.f);
    this.j.setPath(this.f, this.i);
    this.i.op(this.j, Region.Op.DIFFERENCE);
    return this.i;
  }
  
  public void setAlpha(int paramInt) {
    this.t = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setTint(int paramInt) { setTintList(ColorStateList.valueOf(paramInt)); }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.z = paramColorStateList;
    b();
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    this.y = paramMode;
    b();
    invalidateSelf();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */