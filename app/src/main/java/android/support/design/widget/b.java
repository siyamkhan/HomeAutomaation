package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.design.a.a;
import android.support.v4.c.a;
import android.support.v4.f.c;
import android.support.v4.f.d;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.widget.bm;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

public final class b {
  private static final boolean a;
  
  private static final Paint b;
  
  private boolean A;
  
  private Bitmap B;
  
  private Paint C;
  
  private float D;
  
  private float E;
  
  private float F;
  
  private float G;
  
  private int[] H;
  
  private boolean I;
  
  private final TextPaint J;
  
  private final TextPaint K;
  
  private TimeInterpolator L;
  
  private TimeInterpolator M;
  
  private float N;
  
  private float O;
  
  private float P;
  
  private int Q;
  
  private float R;
  
  private float S;
  
  private float T;
  
  private int U;
  
  private final View c;
  
  private boolean d;
  
  private float e;
  
  private final Rect f;
  
  private final Rect g;
  
  private final RectF h;
  
  private int i = 16;
  
  private int j = 16;
  
  private float k = 15.0F;
  
  private float l = 15.0F;
  
  private ColorStateList m;
  
  private ColorStateList n;
  
  private float o;
  
  private float p;
  
  private float q;
  
  private float r;
  
  private float s;
  
  private float t;
  
  private Typeface u;
  
  private Typeface v;
  
  private Typeface w;
  
  private CharSequence x;
  
  private CharSequence y;
  
  private boolean z;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
    b = null;
    Paint paint = b;
    if (paint != null) {
      paint.setAntiAlias(true);
      b.setColor(-65281);
    } 
  }
  
  public b(View paramView) {
    this.c = paramView;
    this.J = new TextPaint(129);
    this.K = new TextPaint(this.J);
    this.g = new Rect();
    this.f = new Rect();
    this.h = new RectF();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator) {
    if (paramTimeInterpolator != null)
      paramFloat3 = paramTimeInterpolator.getInterpolation(paramFloat3); 
    return a.a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat) {
    float f1 = 1.0F - paramFloat;
    float f2 = f1 * Color.alpha(paramInt1) + paramFloat * Color.alpha(paramInt2);
    float f3 = f1 * Color.red(paramInt1) + paramFloat * Color.red(paramInt2);
    float f4 = f1 * Color.green(paramInt1) + paramFloat * Color.green(paramInt2);
    float f5 = f1 * Color.blue(paramInt1) + paramFloat * Color.blue(paramInt2);
    return Color.argb((int)f2, (int)f3, (int)f4, (int)f5);
  }
  
  private void a(TextPaint paramTextPaint) {
    paramTextPaint.setTextSize(this.l);
    paramTextPaint.setTypeface(this.u);
  }
  
  private static boolean a(float paramFloat1, float paramFloat2) { return (Math.abs(paramFloat1 - paramFloat2) < 0.001F); }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return (paramRect.left == paramInt1 && paramRect.top == paramInt2 && paramRect.right == paramInt3 && paramRect.bottom == paramInt4); }
  
  private boolean b(CharSequence paramCharSequence) {
    c c1;
    int i1 = r.f(this.c);
    boolean bool = true;
    if (i1 != bool)
      bool = false; 
    if (bool) {
      c1 = d.d;
    } else {
      c1 = d.c;
    } 
    return c1.a(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void c(float paramFloat) {
    int i1;
    TextPaint textPaint;
    d(paramFloat);
    this.s = a(this.q, this.r, paramFloat, this.L);
    this.t = a(this.o, this.p, paramFloat, this.L);
    e(a(this.k, this.l, paramFloat, this.M));
    if (this.n != this.m) {
      textPaint = this.J;
      i1 = a(j(), f(), paramFloat);
    } else {
      textPaint = this.J;
      i1 = f();
    } 
    textPaint.setColor(i1);
    this.J.setShadowLayer(a(this.R, this.N, paramFloat, null), a(this.S, this.O, paramFloat, null), a(this.T, this.P, paramFloat, null), a(this.U, this.Q, paramFloat));
    r.d(this.c);
  }
  
  private Typeface d(int paramInt) {
    typedArray = this.c.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try {
      String str = typedArray.getString(0);
      if (str != null)
        return Typeface.create(str, 0); 
      return null;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private void d(float paramFloat) {
    this.h.left = a(this.f.left, this.g.left, paramFloat, this.L);
    this.h.top = a(this.o, this.p, paramFloat, this.L);
    this.h.right = a(this.f.right, this.g.right, paramFloat, this.L);
    this.h.bottom = a(this.f.bottom, this.g.bottom, paramFloat, this.L);
  }
  
  private void e(float paramFloat) {
    boolean bool;
    f(paramFloat);
    if (a && this.F != 1.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    this.A = bool;
    if (this.A)
      l(); 
    r.d(this.c);
  }
  
  private void f(float paramFloat) {
    boolean bool;
    float f3;
    if (this.x == null)
      return; 
    float f1 = this.g.width();
    float f2 = this.f.width();
    boolean bool1 = a(paramFloat, this.l);
    boolean bool2 = true;
    if (bool1) {
      boolean bool3;
      float f4 = this.l;
      this.F = 1.0F;
      Typeface typeface1 = this.w;
      Typeface typeface2 = this.u;
      if (typeface1 != typeface2) {
        this.w = typeface2;
        bool3 = true;
      } else {
        bool3 = false;
      } 
      f3 = f4;
      bool = bool3;
    } else {
      f3 = this.k;
      Typeface typeface1 = this.w;
      Typeface typeface2 = this.v;
      if (typeface1 != typeface2) {
        this.w = typeface2;
        bool = true;
      } else {
        bool = false;
      } 
      if (a(paramFloat, this.k)) {
        this.F = 1.0F;
      } else {
        this.F = paramFloat / this.k;
      } 
      float f4 = this.l / this.k;
      if (f2 * f4 > f1) {
        f1 = Math.min(f1 / f4, f2);
      } else {
        f1 = f2;
      } 
    } 
    if (f1 > 0.0F) {
      if (this.G != f3 || this.I || bool) {
        bool = true;
      } else {
        bool = false;
      } 
      this.G = f3;
      this.I = false;
    } 
    if (this.y == null || bool) {
      this.J.setTextSize(this.G);
      this.J.setTypeface(this.w);
      TextPaint textPaint = this.J;
      if (this.F == 1.0F)
        bool2 = false; 
      textPaint.setLinearText(bool2);
      CharSequence charSequence = TextUtils.ellipsize(this.x, this.J, f1, TextUtils.TruncateAt.END);
      if (!TextUtils.equals(charSequence, this.y)) {
        this.y = charSequence;
        this.z = b(this.y);
      } 
    } 
  }
  
  private void i() { c(this.e); }
  
  private int j() {
    int[] arrayOfInt = this.H;
    return (arrayOfInt != null) ? this.m.getColorForState(arrayOfInt, 0) : this.m.getDefaultColor();
  }
  
  private void k() {
    float f2;
    float f1 = this.G;
    f(this.l);
    CharSequence charSequence1 = this.y;
    if (charSequence1 != null) {
      f2 = this.J.measureText(charSequence1, 0, charSequence1.length());
    } else {
      f2 = 0.0F;
    } 
    int i1 = d.a(this.j, this.z);
    int i2 = i1 & 0x70;
    if (i2 != 48) {
      if (i2 != 80) {
        this.p = (this.J.descent() - this.J.ascent()) / 2.0F - this.J.descent() + this.g.centerY();
      } else {
        float f4 = this.g.bottom;
        this.p = f4;
      } 
    } else {
      float f4 = this.g.top - this.J.ascent();
      this.p = f4;
    } 
    int i3 = i1 & 0x800007;
    if (i3 != 1) {
      if (i3 != 5) {
        this.r = this.g.left;
      } else {
        float f4 = this.g.right;
        this.r = f4 - f2;
      } 
    } else {
      float f4 = this.g.centerX();
      f2 /= 2.0F;
      this.r = f4 - f2;
    } 
    f(this.k);
    CharSequence charSequence2 = this.y;
    float f3 = 0.0F;
    if (charSequence2 != null)
      f3 = this.J.measureText(charSequence2, 0, charSequence2.length()); 
    int i4 = d.a(this.i, this.z);
    int i5 = i4 & 0x70;
    if (i5 != 48) {
      if (i5 != 80) {
        this.o = (this.J.descent() - this.J.ascent()) / 2.0F - this.J.descent() + this.f.centerY();
      } else {
        float f4 = this.f.bottom;
        this.o = f4;
      } 
    } else {
      float f4 = this.f.top - this.J.ascent();
      this.o = f4;
    } 
    int i6 = i4 & 0x800007;
    if (i6 != 1) {
      float f4;
      if (i6 != 5) {
        f4 = this.f.left;
      } else {
        float f5 = this.f.right;
        f4 = f5 - f3;
      } 
      this.q = f4;
    } else {
      float f4 = this.f.centerX();
      f3 /= 2.0F;
      float f5 = f4 - f3;
    } 
    m();
    e(f1);
  }
  
  private void l() {
    if (this.B == null && !this.f.isEmpty()) {
      if (TextUtils.isEmpty(this.y))
        return; 
      c(0.0F);
      this.D = this.J.ascent();
      this.E = this.J.descent();
      TextPaint textPaint = this.J;
      CharSequence charSequence = this.y;
      int i1 = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
      int i2 = Math.round(this.E - this.D);
      if (i1 > 0) {
        if (i2 <= 0)
          return; 
        this.B = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        CharSequence charSequence1 = this.y;
        canvas.drawText(charSequence1, 0, charSequence1.length(), 0.0F, i2 - this.J.descent(), this.J);
        if (this.C == null)
          this.C = new Paint(3); 
      } 
    } 
  }
  
  private void m() {
    Bitmap bitmap = this.B;
    if (bitmap != null) {
      bitmap.recycle();
      this.B = null;
    } 
  }
  
  public float a() {
    if (this.x == null)
      return 0.0F; 
    a(this.K);
    TextPaint textPaint = this.K;
    CharSequence charSequence = this.x;
    return textPaint.measureText(charSequence, 0, charSequence.length());
  }
  
  public void a(float paramFloat) {
    if (this.k != paramFloat) {
      this.k = paramFloat;
      g();
    } 
  }
  
  public void a(int paramInt) {
    if (this.i != paramInt) {
      this.i = paramInt;
      g();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!a(this.f, paramInt1, paramInt2, paramInt3, paramInt4)) {
      this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      c();
    } 
  }
  
  public void a(TimeInterpolator paramTimeInterpolator) {
    this.M = paramTimeInterpolator;
    g();
  }
  
  public void a(ColorStateList paramColorStateList) {
    if (this.n != paramColorStateList) {
      this.n = paramColorStateList;
      g();
    } 
  }
  
  public void a(Canvas paramCanvas) {
    int i1 = paramCanvas.save();
    if (this.y != null && this.d) {
      float f3;
      boolean bool;
      float f1 = this.s;
      float f2 = this.t;
      if (this.A && this.B != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        f3 = this.D * this.F;
        this.E;
      } else {
        f3 = this.J.ascent() * this.F;
        this.J.descent();
        this.F;
      } 
      if (bool)
        f2 += f3; 
      float f4 = f2;
      float f5 = this.F;
      if (f5 != 1.0F)
        paramCanvas.scale(f5, f5, f1, f4); 
      if (bool) {
        paramCanvas.drawBitmap(this.B, f1, f4, this.C);
      } else {
        CharSequence charSequence = this.y;
        paramCanvas.drawText(charSequence, 0, charSequence.length(), f1, f4, this.J);
      } 
    } 
    paramCanvas.restoreToCount(i1);
  }
  
  public void a(RectF paramRectF) {
    float f2;
    float f1;
    boolean bool = b(this.x);
    if (!bool) {
      f1 = this.g.left;
    } else {
      f1 = this.g.right - a();
    } 
    paramRectF.left = f1;
    paramRectF.top = this.g.top;
    if (!bool) {
      f2 = paramRectF.left + a();
    } else {
      f2 = this.g.right;
    } 
    paramRectF.right = f2;
    paramRectF.bottom = this.g.top + b();
  }
  
  public void a(Typeface paramTypeface) {
    this.v = paramTypeface;
    this.u = paramTypeface;
    g();
  }
  
  public void a(CharSequence paramCharSequence) {
    if (paramCharSequence == null || !paramCharSequence.equals(this.x)) {
      this.x = paramCharSequence;
      this.y = null;
      m();
      g();
    } 
  }
  
  public final boolean a(int[] paramArrayOfInt) {
    this.H = paramArrayOfInt;
    if (d()) {
      g();
      return true;
    } 
    return false;
  }
  
  public float b() {
    a(this.K);
    return -this.K.ascent();
  }
  
  public void b(float paramFloat) {
    float f1 = a.a(paramFloat, 0.0F, 1.0F);
    if (f1 != this.e) {
      this.e = f1;
      i();
    } 
  }
  
  public void b(int paramInt) {
    if (this.j != paramInt) {
      this.j = paramInt;
      g();
    } 
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!a(this.g, paramInt1, paramInt2, paramInt3, paramInt4)) {
      this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      c();
    } 
  }
  
  public void b(TimeInterpolator paramTimeInterpolator) {
    this.L = paramTimeInterpolator;
    g();
  }
  
  public void b(ColorStateList paramColorStateList) {
    if (this.m != paramColorStateList) {
      this.m = paramColorStateList;
      g();
    } 
  }
  
  void c() {
    boolean bool;
    if (this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.d = bool;
  }
  
  public void c(int paramInt) {
    bm bm = bm.a(this.c.getContext(), paramInt, a.j.TextAppearance);
    if (bm.g(a.j.TextAppearance_android_textColor))
      this.n = bm.e(a.j.TextAppearance_android_textColor); 
    if (bm.g(a.j.TextAppearance_android_textSize))
      this.l = bm.e(a.j.TextAppearance_android_textSize, (int)this.l); 
    this.Q = bm.a(a.j.TextAppearance_android_shadowColor, 0);
    this.O = bm.a(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.P = bm.a(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.N = bm.a(a.j.TextAppearance_android_shadowRadius, 0.0F);
    bm.a();
    if (Build.VERSION.SDK_INT >= 16)
      this.u = d(paramInt); 
    g();
  }
  
  public final boolean d() {
    ColorStateList colorStateList = this.n;
    if (colorStateList == null || !colorStateList.isStateful()) {
      ColorStateList colorStateList1 = this.m;
      if (colorStateList1 == null || !colorStateList1.isStateful())
        return false; 
    } 
    return true;
  }
  
  public float e() { return this.e; }
  
  public int f() {
    int[] arrayOfInt = this.H;
    return (arrayOfInt != null) ? this.n.getColorForState(arrayOfInt, 0) : this.n.getDefaultColor();
  }
  
  public void g() {
    if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
      k();
      i();
    } 
  }
  
  public ColorStateList h() { return this.n; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */