package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.support.design.a.a;
import android.support.design.a.b;
import android.support.design.a.f;
import android.support.design.a.g;
import android.support.design.a.h;
import android.support.design.f.a;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.r;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

class f {
  static final TimeInterpolator a = a.c;
  
  static final int[] p = { 16842919, 16842910 };
  
  static final int[] q = { 16843623, 16842908, 16842910 };
  
  static final int[] r = { 16842908, 16842910 };
  
  static final int[] s = { 16843623, 16842910 };
  
  static final int[] t = { 16842910 };
  
  static final int[] u = new int[0];
  
  private float A;
  
  private ArrayList<Animator.AnimatorListener> B;
  
  private ArrayList<Animator.AnimatorListener> C;
  
  private final Rect D = new Rect();
  
  private final RectF E = new RectF();
  
  private final RectF F = new RectF();
  
  private final Matrix G = new Matrix();
  
  private ViewTreeObserver.OnPreDrawListener H;
  
  int b = 0;
  
  Animator c;
  
  h d;
  
  h e;
  
  l f;
  
  Drawable g;
  
  Drawable h;
  
  a i;
  
  Drawable j;
  
  float k;
  
  float l;
  
  float m;
  
  int n;
  
  float o = 1.0F;
  
  final t v;
  
  final m w;
  
  private h x;
  
  private h y;
  
  private final o z;
  
  f(t paramt, m paramm) {
    this.v = paramt;
    this.w = paramm;
    this.z = new o();
    this.z.a(p, a(new c(this)));
    this.z.a(q, a(new b(this)));
    this.z.a(r, a(new b(this)));
    this.z.a(s, a(new b(this)));
    this.z.a(t, a(new e(this)));
    this.z.a(u, a(new a(this)));
    this.A = this.v.getRotation();
  }
  
  private AnimatorSet a(h paramh, float paramFloat1, float paramFloat2, float paramFloat3) {
    ArrayList arrayList = new ArrayList();
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this.v, View.ALPHA, new float[] { paramFloat1 });
    paramh.b("opacity").a(objectAnimator1);
    arrayList.add(objectAnimator1);
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this.v, View.SCALE_X, new float[] { paramFloat2 });
    paramh.b("scale").a(objectAnimator2);
    arrayList.add(objectAnimator2);
    ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(this.v, View.SCALE_Y, new float[] { paramFloat2 });
    paramh.b("scale").a(objectAnimator3);
    arrayList.add(objectAnimator3);
    a(paramFloat3, this.G);
    t t1 = this.v;
    f f1 = new f();
    g g1 = new g();
    Matrix[] arrayOfMatrix = new Matrix[1];
    arrayOfMatrix[0] = new Matrix(this.G);
    ObjectAnimator objectAnimator4 = ObjectAnimator.ofObject(t1, f1, g1, arrayOfMatrix);
    paramh.b("iconScale").a(objectAnimator4);
    arrayList.add(objectAnimator4);
    AnimatorSet animatorSet = new AnimatorSet();
    b.a(animatorSet, arrayList);
    return animatorSet;
  }
  
  private ValueAnimator a(f paramf) {
    ValueAnimator valueAnimator = new ValueAnimator();
    valueAnimator.setInterpolator(a);
    valueAnimator.setDuration(100L);
    valueAnimator.addListener(paramf);
    valueAnimator.addUpdateListener(paramf);
    valueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return valueAnimator;
  }
  
  private void a(float paramFloat, Matrix paramMatrix) {
    paramMatrix.reset();
    Drawable drawable = this.v.getDrawable();
    if (drawable != null && this.n != 0) {
      RectF rectF1 = this.E;
      RectF rectF2 = this.F;
      rectF1.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
      int i1 = this.n;
      rectF2.set(0.0F, 0.0F, i1, i1);
      paramMatrix.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.CENTER);
      int i2 = this.n;
      paramMatrix.postScale(paramFloat, paramFloat, i2 / 2.0F, i2 / 2.0F);
    } 
  }
  
  private h q() {
    if (this.x == null)
      this.x = h.a(this.v.getContext(), a.a.design_fab_show_motion_spec); 
    return this.x;
  }
  
  private h r() {
    if (this.y == null)
      this.y = h.a(this.v.getContext(), a.a.design_fab_hide_motion_spec); 
    return this.y;
  }
  
  private void s() {
    if (this.H == null)
      this.H = new ViewTreeObserver.OnPreDrawListener(this) {
          public boolean onPreDraw() {
            this.a.n();
            return true;
          }
        }; 
  }
  
  private boolean t() { return (r.x(this.v) && !this.v.isInEditMode()); }
  
  private void u() { // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #19
    //   5: if_icmpne -> 73
    //   8: aload_0
    //   9: getfield A : F
    //   12: ldc_w 90.0
    //   15: frem
    //   16: fconst_0
    //   17: fcmpl
    //   18: ifeq -> 48
    //   21: aload_0
    //   22: getfield v : Landroid/support/design/widget/t;
    //   25: invokevirtual getLayerType : ()I
    //   28: istore #5
    //   30: iconst_1
    //   31: istore #4
    //   33: iload #5
    //   35: iload #4
    //   37: if_icmpeq -> 73
    //   40: aload_0
    //   41: getfield v : Landroid/support/design/widget/t;
    //   44: astore_3
    //   45: goto -> 66
    //   48: aload_0
    //   49: getfield v : Landroid/support/design/widget/t;
    //   52: invokevirtual getLayerType : ()I
    //   55: ifeq -> 73
    //   58: aload_0
    //   59: getfield v : Landroid/support/design/widget/t;
    //   62: astore_3
    //   63: iconst_0
    //   64: istore #4
    //   66: aload_3
    //   67: iload #4
    //   69: aconst_null
    //   70: invokevirtual setLayerType : (ILandroid/graphics/Paint;)V
    //   73: aload_0
    //   74: getfield f : Landroid/support/design/widget/l;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnull -> 91
    //   82: aload_1
    //   83: aload_0
    //   84: getfield A : F
    //   87: fneg
    //   88: invokevirtual b : (F)V
    //   91: aload_0
    //   92: getfield i : Landroid/support/design/widget/a;
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull -> 109
    //   100: aload_2
    //   101: aload_0
    //   102: getfield A : F
    //   105: fneg
    //   106: invokevirtual a : (F)V
    //   109: return }
  
  float a() { return this.k; }
  
  final void a(float paramFloat) {
    if (this.k != paramFloat) {
      this.k = paramFloat;
      a(this.k, this.l, this.m);
    } 
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    l l1 = this.f;
    if (l1 != null) {
      l1.a(paramFloat1, paramFloat1 + this.m);
      j();
    } 
  }
  
  void a(Animator.AnimatorListener paramAnimatorListener) {
    if (this.B == null)
      this.B = new ArrayList(); 
    this.B.add(paramAnimatorListener);
  }
  
  void a(ColorStateList paramColorStateList) {
    Drawable drawable = this.g;
    if (drawable != null)
      a.a(drawable, paramColorStateList); 
    a a1 = this.i;
    if (a1 != null)
      a1.a(paramColorStateList); 
  }
  
  void a(PorterDuff.Mode paramMode) {
    Drawable drawable = this.g;
    if (drawable != null)
      a.a(drawable, paramMode); 
  }
  
  void a(Rect paramRect) { this.f.getPadding(paramRect); }
  
  final void a(h paramh) { this.d = paramh; }
  
  void a(d paramd, boolean paramBoolean) {
    byte b1;
    if (p())
      return; 
    Animator animator = this.c;
    if (animator != null)
      animator.cancel(); 
    if (t()) {
      h h1 = this.e;
      if (h1 == null)
        h1 = r(); 
      AnimatorSet animatorSet = a(h1, 0.0F, 0.0F, 0.0F);
      animatorSet.addListener(new AnimatorListenerAdapter(this, paramBoolean, paramd) {
            private boolean d;
            
            public void onAnimationCancel(Animator param1Animator) { this.d = true; }
            
            public void onAnimationEnd(Animator param1Animator) {
              f f1 = this.c;
              f1.b = 0;
              f1.c = null;
              if (!this.d) {
                byte b1;
                t t = f1.v;
                if (this.a) {
                  b1 = 8;
                } else {
                  b1 = 4;
                } 
                t.a(b1, this.a);
                f.d d1 = this.b;
                if (d1 != null)
                  d1.b(); 
              } 
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.c.v.a(0, this.a);
              f f1 = this.c;
              f1.b = 1;
              f1.c = param1Animator;
              this.d = false;
            }
          });
      ArrayList arrayList = this.C;
      if (arrayList != null) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
          animatorSet.addListener((Animator.AnimatorListener)iterator.next()); 
      } 
      animatorSet.start();
      return;
    } 
    t t1 = this.v;
    if (paramBoolean) {
      b1 = 8;
    } else {
      b1 = 4;
    } 
    t1.a(b1, paramBoolean);
    if (paramd != null)
      paramd.b(); 
  }
  
  void a(int[] paramArrayOfInt) { this.z.a(paramArrayOfInt); }
  
  float b() { return this.l; }
  
  final void b(float paramFloat) {
    if (this.l != paramFloat) {
      this.l = paramFloat;
      a(this.k, this.l, this.m);
    } 
  }
  
  void b(Animator.AnimatorListener paramAnimatorListener) {
    ArrayList arrayList = this.B;
    if (arrayList == null)
      return; 
    arrayList.remove(paramAnimatorListener);
  }
  
  void b(ColorStateList paramColorStateList) {
    Drawable drawable = this.h;
    if (drawable != null)
      a.a(drawable, a.a(paramColorStateList)); 
  }
  
  void b(Rect paramRect) {}
  
  final void b(h paramh) { this.e = paramh; }
  
  void b(d paramd, boolean paramBoolean) {
    if (o())
      return; 
    Animator animator = this.c;
    if (animator != null)
      animator.cancel(); 
    if (t()) {
      if (this.v.getVisibility() != 0) {
        this.v.setAlpha(0.0F);
        this.v.setScaleY(0.0F);
        this.v.setScaleX(0.0F);
        d(0.0F);
      } 
      h h1 = this.d;
      if (h1 == null)
        h1 = q(); 
      AnimatorSet animatorSet = a(h1, 1.0F, 1.0F, 1.0F);
      animatorSet.addListener(new AnimatorListenerAdapter(this, paramBoolean, paramd) {
            public void onAnimationEnd(Animator param1Animator) {
              f f1 = this.c;
              f1.b = 0;
              f1.c = null;
              f.d d1 = this.b;
              if (d1 != null)
                d1.a(); 
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.c.v.a(0, this.a);
              f f1 = this.c;
              f1.b = 2;
              f1.c = param1Animator;
            }
          });
      ArrayList arrayList = this.B;
      if (arrayList != null) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
          animatorSet.addListener((Animator.AnimatorListener)iterator.next()); 
      } 
      animatorSet.start();
      return;
    } 
    this.v.a(0, paramBoolean);
    this.v.setAlpha(1.0F);
    this.v.setScaleY(1.0F);
    this.v.setScaleX(1.0F);
    d(1.0F);
    if (paramd != null)
      paramd.a(); 
  }
  
  float c() { return this.m; }
  
  final void c(float paramFloat) {
    if (this.m != paramFloat) {
      this.m = paramFloat;
      a(this.k, this.l, this.m);
    } 
  }
  
  public void c(Animator.AnimatorListener paramAnimatorListener) {
    if (this.C == null)
      this.C = new ArrayList(); 
    this.C.add(paramAnimatorListener);
  }
  
  final void d() { d(this.o); }
  
  final void d(float paramFloat) {
    this.o = paramFloat;
    Matrix matrix = this.G;
    a(paramFloat, matrix);
    this.v.setImageMatrix(matrix);
  }
  
  public void d(Animator.AnimatorListener paramAnimatorListener) {
    ArrayList arrayList = this.C;
    if (arrayList == null)
      return; 
    arrayList.remove(paramAnimatorListener);
  }
  
  final h e() { return this.d; }
  
  final h f() { return this.e; }
  
  void g() { this.z.a(); }
  
  final Drawable h() { return this.j; }
  
  void i() {}
  
  final void j() {
    Rect rect = this.D;
    a(rect);
    b(rect);
    this.w.a(rect.left, rect.top, rect.right, rect.bottom);
  }
  
  void k() {
    if (m()) {
      s();
      this.v.getViewTreeObserver().addOnPreDrawListener(this.H);
    } 
  }
  
  void l() {
    if (this.H != null) {
      this.v.getViewTreeObserver().removeOnPreDrawListener(this.H);
      this.H = null;
    } 
  }
  
  boolean m() { return true; }
  
  void n() {
    float f1 = this.v.getRotation();
    if (this.A != f1) {
      this.A = f1;
      u();
    } 
  }
  
  boolean o() {
    if (this.v.getVisibility() != 0) {
      int i2 = this.b;
      boolean bool1 = false;
      if (i2 == 2)
        bool1 = true; 
      return bool1;
    } 
    int i1 = this.b;
    boolean bool = false;
    if (i1 != 1)
      bool = true; 
    return bool;
  }
  
  boolean p() {
    if (this.v.getVisibility() == 0) {
      int i2 = this.b;
      boolean bool1 = false;
      if (i2 == 1)
        bool1 = true; 
      return bool1;
    } 
    int i1 = this.b;
    boolean bool = false;
    if (i1 != 2)
      bool = true; 
    return bool;
  }
  
  private class a extends f {
    a(f this$0) { super(this$0, null); }
    
    protected float a() { return 0.0F; }
  }
  
  private class b extends f {
    b(f this$0) { super(this$0, null); }
    
    protected float a() { return this.a.k + this.a.l; }
  }
  
  private class c extends f {
    c(f this$0) { super(this$0, null); }
    
    protected float a() { return this.a.k + this.a.m; }
  }
  
  static interface d {
    void a();
    
    void b();
  }
  
  private class e extends f {
    e(f this$0) { super(this$0, null); }
    
    protected float a() { return this.a.k; }
  }
  
  private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    private boolean a;
    
    private float c;
    
    private float d;
    
    private f(f this$0) {}
    
    protected abstract float a();
    
    public void onAnimationEnd(Animator param1Animator) {
      this.b.f.a(this.d);
      this.a = false;
    }
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      if (!this.a) {
        this.c = this.b.f.a();
        this.d = a();
        this.a = true;
      } 
      l l = this.b.f;
      float f1 = this.c;
      l.a(f1 + (this.d - f1) * param1ValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */