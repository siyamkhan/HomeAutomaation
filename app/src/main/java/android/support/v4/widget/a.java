package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.h.r;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements View.OnTouchListener {
  private static final int r = ViewConfiguration.getTapTimeout();
  
  final a a = new a();
  
  final View b;
  
  boolean c;
  
  boolean d;
  
  boolean e;
  
  private final Interpolator f = new AccelerateInterpolator();
  
  private Runnable g;
  
  private float[] h = { 0.0F, 0.0F };
  
  private float[] i = { Float.MAX_VALUE, Float.MAX_VALUE };
  
  private int j;
  
  private int k;
  
  private float[] l = { 0.0F, 0.0F };
  
  private float[] m = { 0.0F, 0.0F };
  
  private float[] n = { Float.MAX_VALUE, Float.MAX_VALUE };
  
  private boolean o;
  
  private boolean p;
  
  private boolean q;
  
  public a(View paramView) {
    this.b = paramView;
    DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
    int i1 = (int)(0.5F + 1575.0F * displayMetrics.density);
    int i2 = (int)(0.5F + 315.0F * displayMetrics.density);
    float f1 = i1;
    a(f1, f1);
    float f2 = i2;
    b(f2, f2);
    a(1);
    e(Float.MAX_VALUE, Float.MAX_VALUE);
    d(0.2F, 0.2F);
    c(1.0F, 1.0F);
    b(r);
    c(500);
    d(500);
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3) { return (paramFloat1 > paramFloat3) ? paramFloat3 : ((paramFloat1 < paramFloat2) ? paramFloat2 : paramFloat1); }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float f4;
    float f1 = a(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    float f2 = f(paramFloat4, f1);
    float f3 = f(paramFloat2 - paramFloat4, f1) - f2;
    if (f3 < 0.0F) {
      f4 = -this.f.getInterpolation(-f3);
    } else {
      if (f3 > 0.0F) {
        f4 = this.f.getInterpolation(f3);
        return a(f4, -1.0F, 1.0F);
      } 
      return 0.0F;
    } 
    return a(f4, -1.0F, 1.0F);
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    float f1 = a(this.h[paramInt], paramFloat2, this.i[paramInt], paramFloat1);
    if (f1 == 0.0F)
      return 0.0F; 
    float f2 = this.l[paramInt];
    float f3 = this.m[paramInt];
    float f4 = this.n[paramInt];
    float f5 = f2 * paramFloat3;
    return (f1 > 0.0F) ? a(f1 * f5, f3, f4) : -a(f5 * -f1, f3, f4);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3) { return (paramInt1 > paramInt3) ? paramInt3 : ((paramInt1 < paramInt2) ? paramInt2 : paramInt1); }
  
  private void c() { // Byte code:
    //   0: aload_0
    //   1: getfield g : Ljava/lang/Runnable;
    //   4: ifnonnull -> 19
    //   7: aload_0
    //   8: new android/support/v4/widget/a$b
    //   11: dup
    //   12: aload_0
    //   13: invokespecial <init> : (Landroid/support/v4/widget/a;)V
    //   16: putfield g : Ljava/lang/Runnable;
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield e : Z
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield c : Z
    //   29: aload_0
    //   30: getfield o : Z
    //   33: ifne -> 61
    //   36: aload_0
    //   37: getfield k : I
    //   40: istore_1
    //   41: iload_1
    //   42: ifle -> 61
    //   45: aload_0
    //   46: getfield b : Landroid/view/View;
    //   49: aload_0
    //   50: getfield g : Ljava/lang/Runnable;
    //   53: iload_1
    //   54: i2l
    //   55: invokestatic a : (Landroid/view/View;Ljava/lang/Runnable;J)V
    //   58: goto -> 70
    //   61: aload_0
    //   62: getfield g : Ljava/lang/Runnable;
    //   65: invokeinterface run : ()V
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield o : Z
    //   75: return }
  
  private void d() {
    if (this.c) {
      this.e = false;
      return;
    } 
    this.a.b();
  }
  
  private float f(float paramFloat1, float paramFloat2) {
    if (paramFloat2 == 0.0F)
      return 0.0F; 
    int i1 = this.j;
    switch (i1) {
      default:
        return 0.0F;
      case 2:
        return (paramFloat1 < 0.0F) ? (paramFloat1 / -paramFloat2) : 0.0F;
      case 0:
      case 1:
        break;
    } 
    if (paramFloat1 < paramFloat2) {
      if (paramFloat1 >= 0.0F)
        return 1.0F - paramFloat1 / paramFloat2; 
      if (this.e && i1 == 1)
        return 1.0F; 
    } 
    return 0.0F;
  }
  
  public a a(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.n;
    arrayOfFloat[0] = paramFloat1 / 1000.0F;
    arrayOfFloat[1] = paramFloat2 / 1000.0F;
    return this;
  }
  
  public a a(int paramInt) {
    this.j = paramInt;
    return this;
  }
  
  public a a(boolean paramBoolean) {
    if (this.p && !paramBoolean)
      d(); 
    this.p = paramBoolean;
    return this;
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  boolean a() {
    a a1 = this.a;
    int i1 = a1.f();
    int i2 = a1.e();
    return ((i1 != 0 && f(i1)) || (i2 != 0 && e(i2)));
  }
  
  public a b(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.m;
    arrayOfFloat[0] = paramFloat1 / 1000.0F;
    arrayOfFloat[1] = paramFloat2 / 1000.0F;
    return this;
  }
  
  public a b(int paramInt) {
    this.k = paramInt;
    return this;
  }
  
  void b() {
    long l1 = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
    this.b.onTouchEvent(motionEvent);
    motionEvent.recycle();
  }
  
  public a c(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.l;
    arrayOfFloat[0] = paramFloat1 / 1000.0F;
    arrayOfFloat[1] = paramFloat2 / 1000.0F;
    return this;
  }
  
  public a c(int paramInt) {
    this.a.a(paramInt);
    return this;
  }
  
  public a d(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.h;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  public a d(int paramInt) {
    this.a.b(paramInt);
    return this;
  }
  
  public a e(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    return this;
  }
  
  public abstract boolean e(int paramInt);
  
  public abstract boolean f(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    float f2;
    float f1;
    if (!this.p)
      return false; 
    switch (paramMotionEvent.getActionMasked()) {
      case 1:
      case 3:
        d();
        break;
      case 0:
        this.d = true;
        this.o = false;
      case 2:
        f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.b.getWidth());
        f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.b.getHeight());
        this.a.a(f1, f2);
        if (!this.e && a())
          c(); 
        break;
    } 
    boolean bool1 = this.q;
    boolean bool2 = false;
    if (bool1) {
      boolean bool = this.e;
      bool2 = false;
      if (bool)
        bool2 = true; 
    } 
    return bool2;
  }
  
  private static class a {
    private int a;
    
    private int b;
    
    private float c;
    
    private float d;
    
    private long e = Float.MIN_VALUE;
    
    private long f = 0L;
    
    private int g = 0;
    
    private int h = 0;
    
    private long i = -1L;
    
    private float j;
    
    private int k;
    
    private float a(float param1Float) { return param1Float * -4.0F * param1Float + param1Float * 4.0F; }
    
    private float a(long param1Long) {
      if (param1Long < this.e)
        return 0.0F; 
      long l1 = this.i;
      if (l1 < 0L || param1Long < l1)
        return 0.5F * a.a((float)(param1Long - this.e) / this.a, 0.0F, 1.0F); 
      long l2 = param1Long - l1;
      float f1 = this.j;
      return 1.0F - f1 + f1 * a.a((float)l2 / this.k, 0.0F, 1.0F);
    }
    
    public void a() {
      this.e = AnimationUtils.currentAnimationTimeMillis();
      this.i = -1L;
      this.f = this.e;
      this.j = 0.5F;
      this.g = 0;
      this.h = 0;
    }
    
    public void a(float param1Float1, float param1Float2) {
      this.c = param1Float1;
      this.d = param1Float2;
    }
    
    public void a(int param1Int) { this.a = param1Int; }
    
    public void b() {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.k = a.a((int)(l - this.e), 0, this.b);
      this.j = a(l);
      this.i = l;
    }
    
    public void b(int param1Int) { this.b = param1Int; }
    
    public boolean c() { return (this.i > 0L && AnimationUtils.currentAnimationTimeMillis() > this.i + this.k); }
    
    public void d() {
      if (this.f != 0L) {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        float f1 = a(a(l1));
        long l2 = l1 - this.f;
        this.f = l1;
        float f2 = f1 * (float)l2;
        this.g = (int)(f2 * this.c);
        this.h = (int)(f2 * this.d);
        return;
      } 
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    
    public int e() {
      float f1 = this.c;
      return (int)(f1 / Math.abs(f1));
    }
    
    public int f() {
      float f1 = this.d;
      return (int)(f1 / Math.abs(f1));
    }
    
    public int g() { return this.g; }
    
    public int h() { return this.h; }
  }
  
  private class b implements Runnable {
    b(a this$0) {}
    
    public void run() {
      if (!this.a.e)
        return; 
      if (this.a.c) {
        a a2 = this.a;
        a2.c = false;
        a2.a.a();
      } 
      a.a a1 = this.a.a;
      if (a1.c() || !this.a.a()) {
        this.a.e = false;
        return;
      } 
      if (this.a.d) {
        a a2 = this.a;
        a2.d = false;
        a2.b();
      } 
      a1.d();
      int i = a1.g();
      int j = a1.h();
      this.a.a(i, j);
      r.a(this.a.b, this);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */