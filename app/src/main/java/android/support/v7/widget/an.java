package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.h.r;
import android.view.MotionEvent;

class an extends RecyclerView.h implements RecyclerView.m {
  private static final int[] k = { 16842919 };
  
  private static final int[] l = new int[0];
  
  private int A = 0;
  
  private final int[] B = new int[2];
  
  private final int[] C = new int[2];
  
  private final Runnable D = new Runnable(this) {
      public void run() { this.a.b(500); }
    };
  
  private final RecyclerView.n E = new RecyclerView.n(this) {
      public void a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) { this.a.a(param1RecyclerView.computeHorizontalScrollOffset(), param1RecyclerView.computeVerticalScrollOffset()); }
    };
  
  final StateListDrawable a;
  
  final Drawable b;
  
  int c;
  
  int d;
  
  float e;
  
  int f;
  
  int g;
  
  float h;
  
  final ValueAnimator i = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  
  int j = 0;
  
  private final int m;
  
  private final int n;
  
  private final int o;
  
  private final int p;
  
  private final StateListDrawable q;
  
  private final Drawable r;
  
  private final int s;
  
  private final int t;
  
  private int u = 0;
  
  private int v = 0;
  
  private RecyclerView w;
  
  private boolean x = false;
  
  private boolean y = false;
  
  private int z = 0;
  
  an(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3) {
    this.a = paramStateListDrawable1;
    this.b = paramDrawable1;
    this.q = paramStateListDrawable2;
    this.r = paramDrawable2;
    this.o = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.p = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.s = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.t = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.m = paramInt2;
    this.n = paramInt3;
    this.a.setAlpha(255);
    this.b.setAlpha(255);
    this.i.addListener(new a(this));
    this.i.addUpdateListener(new b(this));
    a(paramRecyclerView);
  }
  
  private int a(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3) {
    int i1 = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i1 == 0)
      return 0; 
    float f1 = (paramFloat2 - paramFloat1) / i1;
    int i2 = paramInt1 - paramInt3;
    int i3 = (int)(f1 * i2);
    int i4 = paramInt2 + i3;
    return (i4 < i2 && i4 >= 0) ? i3 : 0;
  }
  
  private void a(float paramFloat) {
    int[] arrayOfInt = g();
    float f1 = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.d - f1) < 2.0F)
      return; 
    int i1 = a(this.e, f1, arrayOfInt, this.w.computeVerticalScrollRange(), this.w.computeVerticalScrollOffset(), this.v);
    if (i1 != 0)
      this.w.scrollBy(0, i1); 
    this.e = f1;
  }
  
  private void a(Canvas paramCanvas) {
    int i1 = this.u;
    int i2 = this.o;
    int i3 = i1 - i2;
    int i4 = this.d;
    int i5 = this.c;
    int i6 = i4 - i5 / 2;
    this.a.setBounds(0, 0, i2, i5);
    this.b.setBounds(0, 0, this.p, this.v);
    if (e()) {
      this.b.draw(paramCanvas);
      paramCanvas.translate(this.o, i6);
      paramCanvas.scale(-1.0F, 1.0F);
      this.a.draw(paramCanvas);
      paramCanvas.scale(1.0F, 1.0F);
      i3 = this.o;
    } else {
      paramCanvas.translate(i3, 0.0F);
      this.b.draw(paramCanvas);
      paramCanvas.translate(0.0F, i6);
      this.a.draw(paramCanvas);
    } 
    paramCanvas.translate(-i3, -i6);
  }
  
  private void b(float paramFloat) {
    int[] arrayOfInt = h();
    float f1 = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(this.g - f1) < 2.0F)
      return; 
    int i1 = a(this.h, f1, arrayOfInt, this.w.computeHorizontalScrollRange(), this.w.computeHorizontalScrollOffset(), this.u);
    if (i1 != 0)
      this.w.scrollBy(i1, 0); 
    this.h = f1;
  }
  
  private void b(Canvas paramCanvas) {
    int i1 = this.v;
    int i2 = this.s;
    int i3 = i1 - i2;
    int i4 = this.g;
    int i5 = this.f;
    int i6 = i4 - i5 / 2;
    this.q.setBounds(0, 0, i5, i2);
    this.r.setBounds(0, 0, this.u, this.t);
    paramCanvas.translate(0.0F, i3);
    this.r.draw(paramCanvas);
    paramCanvas.translate(i6, 0.0F);
    this.q.draw(paramCanvas);
    paramCanvas.translate(-i6, -i3);
  }
  
  private void c() {
    this.w.a(this);
    this.w.a(this);
    this.w.a(this.E);
  }
  
  private void c(int paramInt) {
    f();
    this.w.postDelayed(this.D, paramInt);
  }
  
  private void d() {
    this.w.b(this);
    this.w.b(this);
    this.w.b(this.E);
    f();
  }
  
  private boolean e() { return (r.f(this.w) == 1); }
  
  private void f() { this.w.removeCallbacks(this.D); }
  
  private int[] g() {
    int[] arrayOfInt = this.B;
    int i1 = this.n;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = this.v - i1;
    return arrayOfInt;
  }
  
  private int[] h() {
    int[] arrayOfInt = this.C;
    int i1 = this.n;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = this.u - i1;
    return arrayOfInt;
  }
  
  void a() { this.w.invalidate(); }
  
  void a(int paramInt) { // Byte code:
    //   0: iload_1
    //   1: iconst_2
    //   2: if_icmpne -> 28
    //   5: aload_0
    //   6: getfield z : I
    //   9: iconst_2
    //   10: if_icmpeq -> 28
    //   13: aload_0
    //   14: getfield a : Landroid/graphics/drawable/StateListDrawable;
    //   17: getstatic android/support/v7/widget/an.k : [I
    //   20: invokevirtual setState : ([I)Z
    //   23: pop
    //   24: aload_0
    //   25: invokespecial f : ()V
    //   28: iload_1
    //   29: ifne -> 39
    //   32: aload_0
    //   33: invokevirtual a : ()V
    //   36: goto -> 43
    //   39: aload_0
    //   40: invokevirtual b : ()V
    //   43: aload_0
    //   44: getfield z : I
    //   47: iconst_2
    //   48: if_icmpne -> 74
    //   51: iload_1
    //   52: iconst_2
    //   53: if_icmpeq -> 74
    //   56: aload_0
    //   57: getfield a : Landroid/graphics/drawable/StateListDrawable;
    //   60: getstatic android/support/v7/widget/an.l : [I
    //   63: invokevirtual setState : ([I)Z
    //   66: pop
    //   67: sipush #1200
    //   70: istore_2
    //   71: goto -> 83
    //   74: iload_1
    //   75: iconst_1
    //   76: if_icmpne -> 88
    //   79: sipush #1500
    //   82: istore_2
    //   83: aload_0
    //   84: iload_2
    //   85: invokespecial c : (I)V
    //   88: aload_0
    //   89: iload_1
    //   90: putfield z : I
    //   93: return }
  
  void a(int paramInt1, int paramInt2) {
    boolean bool2;
    boolean bool1;
    int i1 = this.w.computeVerticalScrollRange();
    int i2 = this.v;
    if (i1 - i2 > 0 && i2 >= this.m) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.x = bool1;
    int i3 = this.w.computeHorizontalScrollRange();
    int i4 = this.u;
    if (i3 - i4 > 0 && i4 >= this.m) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.y = bool2;
    if (!this.x && !this.y) {
      if (this.z != 0)
        a(0); 
      return;
    } 
    if (this.x) {
      float f1 = paramInt2;
      float f2 = i2;
      this.d = (int)(f2 * (f1 + f2 / 2.0F) / i1);
      this.c = Math.min(i2, i2 * i2 / i1);
    } 
    if (this.y) {
      float f1 = paramInt1;
      float f2 = i4;
      this.g = (int)(f2 * (f1 + f2 / 2.0F) / i3);
      this.f = Math.min(i4, i4 * i4 / i3);
    } 
    int i5 = this.z;
    if (i5 == 0 || i5 == 1)
      a(1); 
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.u paramu) {
    if (this.u != this.w.getWidth() || this.v != this.w.getHeight()) {
      this.u = this.w.getWidth();
      this.v = this.w.getHeight();
      a(0);
      return;
    } 
    if (this.j != 0) {
      if (this.x)
        a(paramCanvas); 
      if (this.y)
        b(paramCanvas); 
    } 
  }
  
  public void a(RecyclerView paramRecyclerView) {
    RecyclerView recyclerView = this.w;
    if (recyclerView == paramRecyclerView)
      return; 
    if (recyclerView != null)
      d(); 
    this.w = paramRecyclerView;
    if (this.w != null)
      c(); 
  }
  
  public void a(boolean paramBoolean) {}
  
  boolean a(float paramFloat1, float paramFloat2) {
    if (e() ? (paramFloat1 <= (this.o / 2)) : (paramFloat1 >= (this.u - this.o))) {
      int i1 = this.d;
      int i2 = this.c;
      if (paramFloat2 >= (i1 - i2 / 2) && paramFloat2 <= (i1 + i2 / 2))
        return true; 
    } 
    return false;
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) { // Byte code:
    //   0: aload_0
    //   1: getfield z : I
    //   4: istore_3
    //   5: iload_3
    //   6: iconst_1
    //   7: if_icmpne -> 116
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual getX : ()F
    //   15: aload_2
    //   16: invokevirtual getY : ()F
    //   19: invokevirtual a : (FF)Z
    //   22: istore #5
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual getX : ()F
    //   29: aload_2
    //   30: invokevirtual getY : ()F
    //   33: invokevirtual b : (FF)Z
    //   36: istore #6
    //   38: aload_2
    //   39: invokevirtual getAction : ()I
    //   42: istore #7
    //   44: iconst_0
    //   45: istore #4
    //   47: iload #7
    //   49: ifne -> 127
    //   52: iload #5
    //   54: ifne -> 65
    //   57: iconst_0
    //   58: istore #4
    //   60: iload #6
    //   62: ifeq -> 127
    //   65: iload #6
    //   67: ifeq -> 88
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield A : I
    //   75: aload_0
    //   76: aload_2
    //   77: invokevirtual getX : ()F
    //   80: f2i
    //   81: i2f
    //   82: putfield h : F
    //   85: goto -> 108
    //   88: iload #5
    //   90: ifeq -> 108
    //   93: aload_0
    //   94: iconst_2
    //   95: putfield A : I
    //   98: aload_0
    //   99: aload_2
    //   100: invokevirtual getY : ()F
    //   103: f2i
    //   104: i2f
    //   105: putfield e : F
    //   108: aload_0
    //   109: iconst_2
    //   110: invokevirtual a : (I)V
    //   113: goto -> 124
    //   116: iconst_0
    //   117: istore #4
    //   119: iload_3
    //   120: iconst_2
    //   121: if_icmpne -> 127
    //   124: iconst_1
    //   125: istore #4
    //   127: iload #4
    //   129: ireturn }
  
  public void b() {
    int i1 = this.j;
    if (i1 != 0) {
      if (i1 != 3)
        return; 
      this.i.cancel();
    } 
    this.j = 1;
    ValueAnimator valueAnimator = this.i;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = ((Float)valueAnimator.getAnimatedValue()).floatValue();
    arrayOfFloat[1] = 1.0F;
    valueAnimator.setFloatValues(arrayOfFloat);
    this.i.setDuration(500L);
    this.i.setStartDelay(0L);
    this.i.start();
  }
  
  void b(int paramInt) {
    switch (this.j) {
      default:
        return;
      case 1:
        this.i.cancel();
        break;
      case 2:
        break;
    } 
    this.j = 3;
    ValueAnimator valueAnimator = this.i;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = ((Float)valueAnimator.getAnimatedValue()).floatValue();
    arrayOfFloat[1] = 0.0F;
    valueAnimator.setFloatValues(arrayOfFloat);
    this.i.setDuration(paramInt);
    this.i.start();
  }
  
  public void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {
    if (this.z == 0)
      return; 
    if (paramMotionEvent.getAction() == 0) {
      boolean bool1 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (bool1 || bool2) {
        if (bool2) {
          this.A = 1;
          this.h = (int)paramMotionEvent.getX();
        } else if (bool1) {
          this.A = 2;
          this.e = (int)paramMotionEvent.getY();
        } 
        a(2);
        return;
      } 
    } else {
      if (paramMotionEvent.getAction() == 1 && this.z == 2) {
        this.e = 0.0F;
        this.h = 0.0F;
        a(1);
        this.A = 0;
        return;
      } 
      if (paramMotionEvent.getAction() == 2 && this.z == 2) {
        b();
        if (this.A == 1)
          b(paramMotionEvent.getX()); 
        if (this.A == 2)
          a(paramMotionEvent.getY()); 
      } 
    } 
  }
  
  boolean b(float paramFloat1, float paramFloat2) {
    if (paramFloat2 >= (this.v - this.s)) {
      int i1 = this.g;
      int i2 = this.f;
      if (paramFloat1 >= (i1 - i2 / 2) && paramFloat1 <= (i1 + i2 / 2))
        return true; 
    } 
    return false;
  }
  
  private class a extends AnimatorListenerAdapter {
    private boolean b = false;
    
    a(an this$0) {}
    
    public void onAnimationCancel(Animator param1Animator) { this.b = true; }
    
    public void onAnimationEnd(Animator param1Animator) {
      if (this.b) {
        this.b = false;
        return;
      } 
      if (((Float)this.a.i.getAnimatedValue()).floatValue() == 0.0F) {
        an an2 = this.a;
        an2.j = 0;
        an2.a(0);
        return;
      } 
      an an1 = this.a;
      an1.j = 2;
      an1.a();
    }
  }
  
  private class b implements ValueAnimator.AnimatorUpdateListener {
    b(an this$0) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      int i = (int)(255.0F * ((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
      this.a.a.setAlpha(i);
      this.a.b.setAlpha(i);
      this.a.a();
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */