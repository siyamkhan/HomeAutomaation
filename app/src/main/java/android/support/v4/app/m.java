package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.p;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.b;
import android.support.v4.g.d;
import android.support.v4.g.e;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class m extends l implements LayoutInflater.Factory2 {
  static final Interpolator F = new DecelerateInterpolator(2.5F);
  
  static final Interpolator G = new DecelerateInterpolator(1.5F);
  
  static final Interpolator H = new AccelerateInterpolator(2.5F);
  
  static final Interpolator I = new AccelerateInterpolator(1.5F);
  
  static boolean a = false;
  
  static Field q;
  
  Bundle A = null;
  
  SparseArray<Parcelable> B = null;
  
  ArrayList<j> C;
  
  n D;
  
  Runnable E = new Runnable(this) {
      public void run() { this.a.g(); }
    };
  
  private final CopyOnWriteArrayList<f> J = new CopyOnWriteArrayList();
  
  ArrayList<h> b;
  
  boolean c;
  
  int d = 0;
  
  final ArrayList<g> e = new ArrayList();
  
  SparseArray<g> f;
  
  ArrayList<c> g;
  
  ArrayList<g> h;
  
  ArrayList<c> i;
  
  ArrayList<Integer> j;
  
  ArrayList<l.b> k;
  
  int l = 0;
  
  k m;
  
  i n;
  
  g o;
  
  g p;
  
  boolean r;
  
  boolean s;
  
  boolean t;
  
  boolean u;
  
  String v;
  
  boolean w;
  
  ArrayList<c> x;
  
  ArrayList<Boolean> y;
  
  ArrayList<g> z;
  
  private void A() {
    if (this.C != null)
      while (!this.C.isEmpty())
        ((j)this.C.remove(0)).d();  
  }
  
  private void B() {
    int i1;
    SparseArray sparseArray = this.f;
    byte b1 = 0;
    if (sparseArray == null) {
      i1 = 0;
      b1 = 0;
    } else {
      i1 = sparseArray.size();
    } 
    while (b1 < i1) {
      g g1 = (g)this.f.valueAt(b1);
      if (g1 != null)
        if (g1.V() != null) {
          int i2 = g1.X();
          View view = g1.V();
          Animation animation = view.getAnimation();
          if (animation != null) {
            animation.cancel();
            view.clearAnimation();
          } 
          g1.a(null);
          a(g1, i2, 0, 0, false);
        } else if (g1.W() != null) {
          g1.W().end();
        }  
      b1++;
    } 
  }
  
  private void C() {
    SparseArray sparseArray = this.f;
    if (sparseArray != null)
      for (int i1 = -1 + sparseArray.size(); i1 >= 0; i1--) {
        if (this.f.valueAt(i1) == null) {
          SparseArray sparseArray1 = this.f;
          sparseArray1.delete(sparseArray1.keyAt(i1));
        } 
      }  
  }
  
  private int a(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2, b<g> paramb) {
    int i1 = paramInt2 - 1;
    int i2 = paramInt2;
    while (i1 >= paramInt1) {
      boolean bool1;
      c c1 = (c)paramArrayList1.get(i1);
      boolean bool = ((Boolean)paramArrayList2.get(i1)).booleanValue();
      if (c1.e() && !c1.a(paramArrayList1, i1 + 1, paramInt2)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1) {
        if (this.C == null)
          this.C = new ArrayList(); 
        j j1 = new j(c1, bool);
        this.C.add(j1);
        c1.a(j1);
        if (bool) {
          c1.d();
        } else {
          c1.b(false);
        } 
        if (i1 != --i2) {
          paramArrayList1.remove(i1);
          paramArrayList1.add(i2, c1);
        } 
        b(paramb);
      } 
      i1--;
    } 
    return i2;
  }
  
  static c a(Context paramContext, float paramFloat1, float paramFloat2) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    alphaAnimation.setInterpolator(G);
    alphaAnimation.setDuration(220L);
    return new c(alphaAnimation);
  }
  
  static c a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    AnimationSet animationSet = new AnimationSet(false);
    ScaleAnimation scaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator(F);
    scaleAnimation.setDuration(220L);
    animationSet.addAnimation(scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    alphaAnimation.setInterpolator(G);
    alphaAnimation.setDuration(220L);
    animationSet.addAnimation(alphaAnimation);
    return new c(animationSet);
  }
  
  private static Animation.AnimationListener a(Animation paramAnimation) {
    String str2;
    String str1;
    try {
      if (q == null) {
        q = Animation.class.getDeclaredField("mListener");
        q.setAccessible(true);
      } 
      return (Animation.AnimationListener)q.get(paramAnimation);
    } catch (NoSuchFieldException null) {
      str1 = "FragmentManager";
      str2 = "No field with the name mListener is found in Animation class";
    } catch (IllegalAccessException illegalAccessException) {
      str1 = "FragmentManager";
      str2 = "Cannot access Animation's mListener field";
    } 
    Log.e(str1, str2, illegalAccessException);
    return null;
  }
  
  private void a(g paramg, c paramc, int paramInt) {
    View view = paramg.S;
    ViewGroup viewGroup = paramg.R;
    viewGroup.startViewTransition(view);
    paramg.b(paramInt);
    if (paramc.a != null) {
      e e1 = new e(paramc.a, viewGroup, view);
      paramg.a(paramg.S);
      e1.setAnimationListener(new b(this, a(e1), viewGroup, paramg) {
            public void onAnimationEnd(Animation param1Animation) {
              super.onAnimationEnd(param1Animation);
              this.a.post(new Runnable(this) {
                    public void run() {
                      if (this.a.b.V() != null) {
                        this.a.b.a(null);
                        this.a.c.a(this.a.b, this.a.b.X(), 0, 0, false);
                      } 
                    }
                  });
            }
          });
      b(view, paramc);
      paramg.S.startAnimation(e1);
      return;
    } 
    Animator animator = paramc.b;
    paramg.a(paramc.b);
    animator.addListener(new AnimatorListenerAdapter(this, viewGroup, view, paramg) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.endViewTransition(this.b);
            Animator animator = this.c.W();
            this.c.a(null);
            if (animator != null && this.a.indexOfChild(this.b) < 0) {
              m m1 = this.d;
              g g1 = this.c;
              m1.a(g1, g1.X(), 0, 0, false);
            } 
          }
        });
    animator.setTarget(paramg.S);
    b(paramg.S, paramc);
    animator.start();
  }
  
  private static void a(n paramn) {
    if (paramn == null)
      return; 
    List list1 = paramn.a();
    if (list1 != null) {
      Iterator iterator = list1.iterator();
      while (iterator.hasNext())
        ((g)iterator.next()).N = true; 
    } 
    List list2 = paramn.b();
    if (list2 != null) {
      Iterator iterator = list2.iterator();
      while (iterator.hasNext())
        a((n)iterator.next()); 
    } 
  }
  
  private void a(b<g> paramb) {
    int i1 = paramb.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      g g1 = (g)paramb.b(b1);
      if (!g1.u) {
        View view = g1.q();
        g1.Z = view.getAlpha();
        view.setAlpha(0.0F);
      } 
    } 
  }
  
  private void a(RuntimeException paramRuntimeException) {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
    k k1 = this.m;
    if (k1 != null) {
      try {
        k1.a("  ", null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
    } else {
      a("  ", null, printWriter, new String[0]);
    } 
    throw paramRuntimeException;
  }
  
  private void a(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2) { // Byte code:
    //   0: aload_0
    //   1: getfield C : Ljava/util/ArrayList;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull -> 15
    //   9: iconst_0
    //   10: istore #4
    //   12: goto -> 21
    //   15: aload_3
    //   16: invokevirtual size : ()I
    //   19: istore #4
    //   21: iload #4
    //   23: istore #5
    //   25: iconst_0
    //   26: istore #6
    //   28: iload #6
    //   30: iload #5
    //   32: if_icmpge -> 204
    //   35: aload_0
    //   36: getfield C : Ljava/util/ArrayList;
    //   39: iload #6
    //   41: invokevirtual get : (I)Ljava/lang/Object;
    //   44: checkcast android/support/v4/app/m$j
    //   47: astore #7
    //   49: aload_1
    //   50: ifnull -> 101
    //   53: aload #7
    //   55: getfield a : Z
    //   58: ifne -> 101
    //   61: aload_1
    //   62: aload #7
    //   64: getfield b : Landroid/support/v4/app/c;
    //   67: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   70: istore #10
    //   72: iload #10
    //   74: iconst_m1
    //   75: if_icmpeq -> 101
    //   78: aload_2
    //   79: iload #10
    //   81: invokevirtual get : (I)Ljava/lang/Object;
    //   84: checkcast java/lang/Boolean
    //   87: invokevirtual booleanValue : ()Z
    //   90: ifeq -> 101
    //   93: aload #7
    //   95: invokevirtual e : ()V
    //   98: goto -> 198
    //   101: aload #7
    //   103: invokevirtual c : ()Z
    //   106: ifne -> 130
    //   109: aload_1
    //   110: ifnull -> 198
    //   113: aload #7
    //   115: getfield b : Landroid/support/v4/app/c;
    //   118: aload_1
    //   119: iconst_0
    //   120: aload_1
    //   121: invokevirtual size : ()I
    //   124: invokevirtual a : (Ljava/util/ArrayList;II)Z
    //   127: ifeq -> 198
    //   130: aload_0
    //   131: getfield C : Ljava/util/ArrayList;
    //   134: iload #6
    //   136: invokevirtual remove : (I)Ljava/lang/Object;
    //   139: pop
    //   140: iinc #6, -1
    //   143: iinc #5, -1
    //   146: aload_1
    //   147: ifnull -> 193
    //   150: aload #7
    //   152: getfield a : Z
    //   155: ifne -> 193
    //   158: aload_1
    //   159: aload #7
    //   161: getfield b : Landroid/support/v4/app/c;
    //   164: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   167: istore #9
    //   169: iload #9
    //   171: iconst_m1
    //   172: if_icmpeq -> 193
    //   175: aload_2
    //   176: iload #9
    //   178: invokevirtual get : (I)Ljava/lang/Object;
    //   181: checkcast java/lang/Boolean
    //   184: invokevirtual booleanValue : ()Z
    //   187: ifeq -> 193
    //   190: goto -> 93
    //   193: aload #7
    //   195: invokevirtual d : ()V
    //   198: iinc #6, 1
    //   201: goto -> 28
    //   204: return }
  
  private void a(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2) {
    int i3;
    int i1 = paramInt1;
    boolean bool = ((c)paramArrayList1.get(i1)).t;
    ArrayList arrayList = this.z;
    if (arrayList == null) {
      this.z = new ArrayList();
    } else {
      arrayList.clear();
    } 
    this.z.addAll(this.e);
    g g1 = w();
    int i2 = i1;
    boolean bool1 = false;
    while (i2 < paramInt2) {
      c c1 = (c)paramArrayList1.get(i2);
      if (!((Boolean)paramArrayList2.get(i2)).booleanValue()) {
        g1 = c1.a(this.z, g1);
      } else {
        g1 = c1.b(this.z, g1);
      } 
      if (bool1 || c1.i) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      i2++;
    } 
    this.z.clear();
    if (!bool)
      r.a(this, paramArrayList1, paramArrayList2, paramInt1, paramInt2, false); 
    b(paramArrayList1, paramArrayList2, paramInt1, paramInt2);
    if (bool) {
      b b1 = new b();
      b(b1);
      int i4 = a(paramArrayList1, paramArrayList2, paramInt1, paramInt2, b1);
      a(b1);
      i3 = i4;
    } else {
      i3 = paramInt2;
    } 
    if (i3 != i1 && bool) {
      r.a(this, paramArrayList1, paramArrayList2, paramInt1, i3, true);
      a(this.l, true);
    } 
    while (i1 < paramInt2) {
      c c1 = (c)paramArrayList1.get(i1);
      if (((Boolean)paramArrayList2.get(i1)).booleanValue() && c1.m >= 0) {
        c(c1.m);
        c1.m = -1;
      } 
      c1.a();
      i1++;
    } 
    if (bool1)
      i(); 
  }
  
  static boolean a(Animator paramAnimator) {
    if (paramAnimator == null)
      return false; 
    if (paramAnimator instanceof ValueAnimator) {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = ((ValueAnimator)paramAnimator).getValues();
      for (byte b1 = 0; b1 < arrayOfPropertyValuesHolder.length; b1++) {
        if ("alpha".equals(arrayOfPropertyValuesHolder[b1].getPropertyName()))
          return true; 
      } 
    } else if (paramAnimator instanceof AnimatorSet) {
      ArrayList arrayList = ((AnimatorSet)paramAnimator).getChildAnimations();
      for (byte b1 = 0; b1 < arrayList.size(); b1++) {
        if (a((Animator)arrayList.get(b1)))
          return true; 
      } 
    } 
    return false;
  }
  
  static boolean a(c paramc) {
    if (paramc.a instanceof AlphaAnimation)
      return true; 
    if (paramc.a instanceof AnimationSet) {
      List list = ((AnimationSet)paramc.a).getAnimations();
      for (byte b1 = 0; b1 < list.size(); b1++) {
        if (list.get(b1) instanceof AlphaAnimation)
          return true; 
      } 
      return false;
    } 
    return a(paramc.b);
  }
  
  static boolean a(View paramView, c paramc) {
    boolean bool = false;
    if (paramView != null) {
      if (paramc == null)
        return false; 
      int i1 = Build.VERSION.SDK_INT;
      bool = false;
      if (i1 >= 19) {
        int i2 = paramView.getLayerType();
        bool = false;
        if (i2 == 0) {
          boolean bool1 = r.r(paramView);
          bool = false;
          if (bool1) {
            boolean bool2 = a(paramc);
            bool = false;
            if (bool2)
              bool = true; 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2) {
    g();
    c(true);
    g g1 = this.p;
    if (g1 != null && paramInt1 < 0 && paramString == null) {
      l l1 = g1.p();
      if (l1 != null && l1.b())
        return true; 
    } 
    boolean bool = a(this.x, this.y, paramString, paramInt1, paramInt2);
    if (bool) {
      this.c = true;
      try {
        b(this.x, this.y);
      } finally {
        z();
      } 
    } 
    h();
    C();
    return bool;
  }
  
  public static int b(int paramInt, boolean paramBoolean) { return (paramInt != 4097) ? ((paramInt != 4099) ? ((paramInt != 8194) ? -1 : (paramBoolean ? 3 : 4)) : (paramBoolean ? 5 : 6)) : (paramBoolean ? 1 : 2); }
  
  private void b(b<g> paramb) {
    int i1 = this.l;
    if (i1 < 1)
      return; 
    int i2 = Math.min(i1, 3);
    int i3 = this.e.size();
    for (byte b1 = 0; b1 < i3; b1++) {
      g g1 = (g)this.e.get(b1);
      if (g1.k < i2) {
        a(g1, i2, g1.Q(), g1.R(), false);
        if (g1.S != null && !g1.K && g1.X)
          paramb.add(g1); 
      } 
    } 
  }
  
  private static void b(View paramView, c paramc) {
    if (paramView != null) {
      if (paramc == null)
        return; 
      if (a(paramView, paramc)) {
        if (paramc.b != null) {
          paramc.b.addListener(new d(paramView));
          return;
        } 
        Animation.AnimationListener animationListener = a(paramc.a);
        paramView.setLayerType(2, null);
        paramc.a.setAnimationListener(new a(paramView, animationListener));
      } 
    } 
  }
  
  private void b(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2) {
    if (paramArrayList1 != null) {
      if (paramArrayList1.isEmpty())
        return; 
      if (paramArrayList2 != null && paramArrayList1.size() == paramArrayList2.size()) {
        a(paramArrayList1, paramArrayList2);
        int i1 = paramArrayList1.size();
        byte b1 = 0;
        byte b2 = 0;
        while (b1 < i1) {
          if (!((c)paramArrayList1.get(b1)).t) {
            if (b2 != b1)
              a(paramArrayList1, paramArrayList2, b2, b1); 
            b2 = b1 + 1;
            if (((Boolean)paramArrayList2.get(b1)).booleanValue())
              while (b2 < i1 && ((Boolean)paramArrayList2.get(b2)).booleanValue() && !((c)paramArrayList1.get(b2)).t)
                b2++;  
            a(paramArrayList1, paramArrayList2, b1, b2);
            b1 = b2 - 1;
          } 
          b1++;
        } 
        if (b2 != i1)
          a(paramArrayList1, paramArrayList2, b2, i1); 
        return;
      } 
      throw new IllegalStateException("Internal error with the back stack records");
    } 
  }
  
  private static void b(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      c c1 = (c)paramArrayList1.get(paramInt1);
      boolean bool = ((Boolean)paramArrayList2.get(paramInt1)).booleanValue();
      int i1 = 1;
      if (bool) {
        c1.a(-1);
        if (paramInt1 != paramInt2 - 1)
          i1 = 0; 
        c1.b(i1);
      } else {
        c1.a(i1);
        c1.d();
      } 
      paramInt1++;
    } 
  }
  
  private void c(boolean paramBoolean) {
    if (!this.c) {
      if (this.m != null) {
        if (Looper.myLooper() == this.m.h().getLooper()) {
          if (!paramBoolean)
            y(); 
          if (this.x == null) {
            this.x = new ArrayList();
            this.y = new ArrayList();
          } 
          this.c = true;
          try {
            a(null, null);
            return;
          } finally {
            this.c = false;
          } 
        } 
        throw new IllegalStateException("Must be called from main thread of fragment host");
      } 
      throw new IllegalStateException("Fragment host has been destroyed");
    } 
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private boolean c(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: astore #4
    //   8: iconst_0
    //   9: istore #5
    //   11: aload #4
    //   13: ifnull -> 104
    //   16: aload_0
    //   17: getfield b : Ljava/util/ArrayList;
    //   20: invokevirtual size : ()I
    //   23: ifne -> 29
    //   26: goto -> 104
    //   29: aload_0
    //   30: getfield b : Ljava/util/ArrayList;
    //   33: invokevirtual size : ()I
    //   36: istore #6
    //   38: iconst_0
    //   39: istore #7
    //   41: iload #5
    //   43: iload #6
    //   45: if_icmpge -> 78
    //   48: iload #7
    //   50: aload_0
    //   51: getfield b : Ljava/util/ArrayList;
    //   54: iload #5
    //   56: invokevirtual get : (I)Ljava/lang/Object;
    //   59: checkcast android/support/v4/app/m$h
    //   62: aload_1
    //   63: aload_2
    //   64: invokeinterface a : (Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   69: ior
    //   70: istore #7
    //   72: iinc #5, 1
    //   75: goto -> 41
    //   78: aload_0
    //   79: getfield b : Ljava/util/ArrayList;
    //   82: invokevirtual clear : ()V
    //   85: aload_0
    //   86: getfield m : Landroid/support/v4/app/k;
    //   89: invokevirtual h : ()Landroid/os/Handler;
    //   92: aload_0
    //   93: getfield E : Ljava/lang/Runnable;
    //   96: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   99: aload_0
    //   100: monitorexit
    //   101: iload #7
    //   103: ireturn
    //   104: aload_0
    //   105: monitorexit
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	108	finally
    //   16	26	108	finally
    //   29	38	108	finally
    //   48	72	108	finally
    //   78	101	108	finally
    //   104	106	108	finally
    //   109	111	108	finally }
  
  public static int d(int paramInt) {
    char c1 = ' ';
    if (paramInt != 4097) {
      if (paramInt != 4099)
        return (paramInt != c1) ? 0 : 4097; 
      c1 = 'ဃ';
    } 
    return c1;
  }
  
  private void e(int paramInt) {
    try {
      this.c = true;
      a(paramInt, false);
      this.c = false;
      return;
    } finally {
      this.c = false;
    } 
  }
  
  private g p(g paramg) {
    ViewGroup viewGroup = paramg.R;
    View view = paramg.S;
    if (viewGroup != null) {
      if (view == null)
        return null; 
      for (int i1 = -1 + this.e.indexOf(paramg); i1 >= 0; i1--) {
        g g1 = (g)this.e.get(i1);
        if (g1.R == viewGroup && g1.S != null)
          return g1; 
      } 
    } 
    return null;
  }
  
  private void y() {
    if (!d()) {
      if (this.v == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can not perform this action inside of ");
      stringBuilder.append(this.v);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void z() {
    this.c = false;
    this.y.clear();
    this.x.clear();
  }
  
  public int a(c paramc) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/util/ArrayList;
    //   6: ifnull -> 122
    //   9: aload_0
    //   10: getfield j : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifgt -> 22
    //   19: goto -> 122
    //   22: aload_0
    //   23: getfield j : Ljava/util/ArrayList;
    //   26: iconst_m1
    //   27: aload_0
    //   28: getfield j : Ljava/util/ArrayList;
    //   31: invokevirtual size : ()I
    //   34: iadd
    //   35: invokevirtual remove : (I)Ljava/lang/Object;
    //   38: checkcast java/lang/Integer
    //   41: invokevirtual intValue : ()I
    //   44: istore #11
    //   46: getstatic android/support/v4/app/m.a : Z
    //   49: ifeq -> 106
    //   52: new java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial <init> : ()V
    //   59: astore #12
    //   61: aload #12
    //   63: ldc_w 'Adding back stack index '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #12
    //   72: iload #11
    //   74: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #12
    //   80: ldc_w ' with '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #12
    //   89: aload_1
    //   90: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc_w 'FragmentManager'
    //   97: aload #12
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   105: pop
    //   106: aload_0
    //   107: getfield i : Ljava/util/ArrayList;
    //   110: iload #11
    //   112: aload_1
    //   113: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_0
    //   118: monitorexit
    //   119: iload #11
    //   121: ireturn
    //   122: aload_0
    //   123: getfield i : Ljava/util/ArrayList;
    //   126: ifnonnull -> 140
    //   129: aload_0
    //   130: new java/util/ArrayList
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: putfield i : Ljava/util/ArrayList;
    //   140: aload_0
    //   141: getfield i : Ljava/util/ArrayList;
    //   144: invokevirtual size : ()I
    //   147: istore_3
    //   148: getstatic android/support/v4/app/m.a : Z
    //   151: ifeq -> 207
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: astore #4
    //   163: aload #4
    //   165: ldc_w 'Setting back stack index '
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #4
    //   174: iload_3
    //   175: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #4
    //   181: ldc_w ' to '
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload #4
    //   190: aload_1
    //   191: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc_w 'FragmentManager'
    //   198: aload #4
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   206: pop
    //   207: aload_0
    //   208: getfield i : Ljava/util/ArrayList;
    //   211: aload_1
    //   212: invokevirtual add : (Ljava/lang/Object;)Z
    //   215: pop
    //   216: aload_0
    //   217: monitorexit
    //   218: iload_3
    //   219: ireturn
    //   220: astore_2
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_2
    //   224: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	220	finally
    //   22	106	220	finally
    //   106	119	220	finally
    //   122	140	220	finally
    //   140	207	220	finally
    //   207	218	220	finally
    //   221	223	220	finally }
  
  public g a(Bundle paramBundle, String paramString) {
    int i1 = paramBundle.getInt(paramString, -1);
    if (i1 == -1)
      return null; 
    g g1 = (g)this.f.get(i1);
    if (g1 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment no longer exists for key ");
      stringBuilder.append(paramString);
      stringBuilder.append(": index ");
      stringBuilder.append(i1);
      a(new IllegalStateException(stringBuilder.toString()));
    } 
    return g1;
  }
  
  public g a(String paramString) {
    if (paramString != null)
      for (int i1 = -1 + this.e.size(); i1 >= 0; i1--) {
        g g1 = (g)this.e.get(i1);
        if (g1 != null && paramString.equals(g1.J))
          return g1; 
      }  
    SparseArray sparseArray = this.f;
    if (sparseArray != null && paramString != null)
      for (int i1 = -1 + sparseArray.size(); i1 >= 0; i1--) {
        g g1 = (g)this.f.valueAt(i1);
        if (g1 != null && paramString.equals(g1.J))
          return g1; 
      }  
    return null;
  }
  
  c a(g paramg, int paramInt1, boolean paramBoolean, int paramInt2) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual Q : ()I
    //   4: istore #5
    //   6: aload_1
    //   7: iload_2
    //   8: iload_3
    //   9: iload #5
    //   11: invokevirtual a : (IZI)Landroid/view/animation/Animation;
    //   14: astore #6
    //   16: aload #6
    //   18: ifnull -> 31
    //   21: new android/support/v4/app/m$c
    //   24: dup
    //   25: aload #6
    //   27: invokespecial <init> : (Landroid/view/animation/Animation;)V
    //   30: areturn
    //   31: aload_1
    //   32: iload_2
    //   33: iload_3
    //   34: iload #5
    //   36: invokevirtual b : (IZI)Landroid/animation/Animator;
    //   39: astore #7
    //   41: aload #7
    //   43: ifnull -> 56
    //   46: new android/support/v4/app/m$c
    //   49: dup
    //   50: aload #7
    //   52: invokespecial <init> : (Landroid/animation/Animator;)V
    //   55: areturn
    //   56: iload #5
    //   58: ifeq -> 216
    //   61: ldc_w 'anim'
    //   64: aload_0
    //   65: getfield m : Landroid/support/v4/app/k;
    //   68: invokevirtual g : ()Landroid/content/Context;
    //   71: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   74: iload #5
    //   76: invokevirtual getResourceTypeName : (I)Ljava/lang/String;
    //   79: invokevirtual equals : (Ljava/lang/Object;)Z
    //   82: istore #9
    //   84: iconst_0
    //   85: istore #10
    //   87: iload #9
    //   89: ifeq -> 139
    //   92: aload_0
    //   93: getfield m : Landroid/support/v4/app/k;
    //   96: invokevirtual g : ()Landroid/content/Context;
    //   99: iload #5
    //   101: invokestatic loadAnimation : (Landroid/content/Context;I)Landroid/view/animation/Animation;
    //   104: astore #16
    //   106: iconst_0
    //   107: istore #10
    //   109: aload #16
    //   111: ifnull -> 128
    //   114: new android/support/v4/app/m$c
    //   117: dup
    //   118: aload #16
    //   120: invokespecial <init> : (Landroid/view/animation/Animation;)V
    //   123: astore #17
    //   125: aload #17
    //   127: areturn
    //   128: iconst_1
    //   129: istore #10
    //   131: goto -> 139
    //   134: astore #15
    //   136: aload #15
    //   138: athrow
    //   139: iload #10
    //   141: ifne -> 216
    //   144: aload_0
    //   145: getfield m : Landroid/support/v4/app/k;
    //   148: invokevirtual g : ()Landroid/content/Context;
    //   151: iload #5
    //   153: invokestatic loadAnimator : (Landroid/content/Context;I)Landroid/animation/Animator;
    //   156: astore #13
    //   158: aload #13
    //   160: ifnull -> 216
    //   163: new android/support/v4/app/m$c
    //   166: dup
    //   167: aload #13
    //   169: invokespecial <init> : (Landroid/animation/Animator;)V
    //   172: astore #14
    //   174: aload #14
    //   176: areturn
    //   177: astore #11
    //   179: iload #9
    //   181: ifne -> 213
    //   184: aload_0
    //   185: getfield m : Landroid/support/v4/app/k;
    //   188: invokevirtual g : ()Landroid/content/Context;
    //   191: iload #5
    //   193: invokestatic loadAnimation : (Landroid/content/Context;I)Landroid/view/animation/Animation;
    //   196: astore #12
    //   198: aload #12
    //   200: ifnull -> 216
    //   203: new android/support/v4/app/m$c
    //   206: dup
    //   207: aload #12
    //   209: invokespecial <init> : (Landroid/view/animation/Animation;)V
    //   212: areturn
    //   213: aload #11
    //   215: athrow
    //   216: iload_2
    //   217: ifne -> 222
    //   220: aconst_null
    //   221: areturn
    //   222: iload_2
    //   223: iload_3
    //   224: invokestatic b : (IZ)I
    //   227: istore #8
    //   229: iload #8
    //   231: ifge -> 236
    //   234: aconst_null
    //   235: areturn
    //   236: iload #8
    //   238: tableswitch default -> 276, 1 -> 380, 2 -> 363, 3 -> 346, 4 -> 329, 5 -> 316, 6 -> 303
    //   276: iload #4
    //   278: ifne -> 397
    //   281: aload_0
    //   282: getfield m : Landroid/support/v4/app/k;
    //   285: invokevirtual d : ()Z
    //   288: ifeq -> 397
    //   291: aload_0
    //   292: getfield m : Landroid/support/v4/app/k;
    //   295: invokevirtual e : ()I
    //   298: istore #4
    //   300: goto -> 397
    //   303: aload_0
    //   304: getfield m : Landroid/support/v4/app/k;
    //   307: invokevirtual g : ()Landroid/content/Context;
    //   310: fconst_1
    //   311: fconst_0
    //   312: invokestatic a : (Landroid/content/Context;FF)Landroid/support/v4/app/m$c;
    //   315: areturn
    //   316: aload_0
    //   317: getfield m : Landroid/support/v4/app/k;
    //   320: invokevirtual g : ()Landroid/content/Context;
    //   323: fconst_0
    //   324: fconst_1
    //   325: invokestatic a : (Landroid/content/Context;FF)Landroid/support/v4/app/m$c;
    //   328: areturn
    //   329: aload_0
    //   330: getfield m : Landroid/support/v4/app/k;
    //   333: invokevirtual g : ()Landroid/content/Context;
    //   336: fconst_1
    //   337: ldc_w 1.075
    //   340: fconst_1
    //   341: fconst_0
    //   342: invokestatic a : (Landroid/content/Context;FFFF)Landroid/support/v4/app/m$c;
    //   345: areturn
    //   346: aload_0
    //   347: getfield m : Landroid/support/v4/app/k;
    //   350: invokevirtual g : ()Landroid/content/Context;
    //   353: ldc_w 0.975
    //   356: fconst_1
    //   357: fconst_0
    //   358: fconst_1
    //   359: invokestatic a : (Landroid/content/Context;FFFF)Landroid/support/v4/app/m$c;
    //   362: areturn
    //   363: aload_0
    //   364: getfield m : Landroid/support/v4/app/k;
    //   367: invokevirtual g : ()Landroid/content/Context;
    //   370: fconst_1
    //   371: ldc_w 0.975
    //   374: fconst_1
    //   375: fconst_0
    //   376: invokestatic a : (Landroid/content/Context;FFFF)Landroid/support/v4/app/m$c;
    //   379: areturn
    //   380: aload_0
    //   381: getfield m : Landroid/support/v4/app/k;
    //   384: invokevirtual g : ()Landroid/content/Context;
    //   387: ldc_w 1.125
    //   390: fconst_1
    //   391: fconst_0
    //   392: fconst_1
    //   393: invokestatic a : (Landroid/content/Context;FFFF)Landroid/support/v4/app/m$c;
    //   396: areturn
    //   397: iload #4
    //   399: ifne -> 402
    //   402: aconst_null
    //   403: areturn
    // Exception table:
    //   from	to	target	type
    //   92	106	134	android/content/res/Resources$NotFoundException
    //   92	106	139	java/lang/RuntimeException
    //   114	125	134	android/content/res/Resources$NotFoundException
    //   114	125	139	java/lang/RuntimeException
    //   144	158	177	java/lang/RuntimeException
    //   163	174	177	java/lang/RuntimeException }
  
  public q a() { return new c(this); }
  
  public void a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      a(new i(this, null, paramInt1, paramInt2), false);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad id: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void a(int paramInt, c paramc) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Ljava/util/ArrayList;
    //   6: ifnonnull -> 20
    //   9: aload_0
    //   10: new java/util/ArrayList
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield i : Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield i : Ljava/util/ArrayList;
    //   24: invokevirtual size : ()I
    //   27: istore #4
    //   29: iload_1
    //   30: iload #4
    //   32: if_icmpge -> 107
    //   35: getstatic android/support/v4/app/m.a : Z
    //   38: ifeq -> 94
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #5
    //   50: aload #5
    //   52: ldc_w 'Setting back stack index '
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: iload_1
    //   62: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: ldc_w ' to '
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload #5
    //   77: aload_2
    //   78: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc_w 'FragmentManager'
    //   85: aload #5
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: aload_0
    //   95: getfield i : Ljava/util/ArrayList;
    //   98: iload_1
    //   99: aload_2
    //   100: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -> 271
    //   107: iload #4
    //   109: iload_1
    //   110: if_icmpge -> 203
    //   113: aload_0
    //   114: getfield i : Ljava/util/ArrayList;
    //   117: aconst_null
    //   118: invokevirtual add : (Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield j : Ljava/util/ArrayList;
    //   126: ifnonnull -> 140
    //   129: aload_0
    //   130: new java/util/ArrayList
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: putfield j : Ljava/util/ArrayList;
    //   140: getstatic android/support/v4/app/m.a : Z
    //   143: ifeq -> 184
    //   146: new java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial <init> : ()V
    //   153: astore #13
    //   155: aload #13
    //   157: ldc_w 'Adding available back stack index '
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload #13
    //   166: iload #4
    //   168: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc_w 'FragmentManager'
    //   175: aload #13
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: aload_0
    //   185: getfield j : Ljava/util/ArrayList;
    //   188: iload #4
    //   190: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   193: invokevirtual add : (Ljava/lang/Object;)Z
    //   196: pop
    //   197: iinc #4, 1
    //   200: goto -> 107
    //   203: getstatic android/support/v4/app/m.a : Z
    //   206: ifeq -> 262
    //   209: new java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial <init> : ()V
    //   216: astore #18
    //   218: aload #18
    //   220: ldc_w 'Adding back stack index '
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload #18
    //   229: iload_1
    //   230: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload #18
    //   236: ldc_w ' with '
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload #18
    //   245: aload_2
    //   246: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc_w 'FragmentManager'
    //   253: aload #18
    //   255: invokevirtual toString : ()Ljava/lang/String;
    //   258: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   261: pop
    //   262: aload_0
    //   263: getfield i : Ljava/util/ArrayList;
    //   266: aload_2
    //   267: invokevirtual add : (Ljava/lang/Object;)Z
    //   270: pop
    //   271: aload_0
    //   272: monitorexit
    //   273: return
    //   274: astore_3
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_3
    //   278: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	274	finally
    //   20	29	274	finally
    //   35	94	274	finally
    //   94	104	274	finally
    //   113	140	274	finally
    //   140	184	274	finally
    //   184	197	274	finally
    //   203	262	274	finally
    //   262	271	274	finally
    //   271	273	274	finally
    //   275	277	274	finally }
  
  void a(int paramInt, boolean paramBoolean) {
    if (this.m != null || paramInt == 0) {
      if (!paramBoolean && paramInt == this.l)
        return; 
      this.l = paramInt;
      if (this.f != null) {
        int i1 = this.e.size();
        for (byte b1 = 0; b1 < i1; b1++)
          e((g)this.e.get(b1)); 
        int i2 = this.f.size();
        for (byte b2 = 0; b2 < i2; b2++) {
          g g1 = (g)this.f.valueAt(b2);
          if (g1 != null && (g1.v || g1.L) && !g1.X)
            e(g1); 
        } 
        e();
        if (this.r) {
          k k1 = this.m;
          if (k1 != null && this.l == 4) {
            k1.c();
            this.r = false;
          } 
        } 
      } 
      return;
    } 
    throw new IllegalStateException("No activity");
  }
  
  public void a(Configuration paramConfiguration) {
    for (byte b1 = 0; b1 < this.e.size(); b1++) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null)
        g1.a(paramConfiguration); 
    } 
  }
  
  public void a(Bundle paramBundle, String paramString, g paramg) {
    if (paramg.o < 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment ");
      stringBuilder.append(paramg);
      stringBuilder.append(" is not currently in the FragmentManager");
      a(new IllegalStateException(stringBuilder.toString()));
    } 
    paramBundle.putInt(paramString, paramg.o);
  }
  
  void a(Parcelable paramParcelable, n paramn) {
    Object object2;
    Object object1;
    if (paramParcelable == null)
      return; 
    o o1 = (o)paramParcelable;
    if (o1.a == null)
      return; 
    if (paramn != null) {
      boolean bool;
      List list = paramn.a();
      object1 = paramn.b();
      object2 = paramn.c();
      if (list != null) {
        bool = list.size();
      } else {
        bool = false;
      } 
      for (byte b2 = 0; b2 < bool; b2++) {
        g g1 = (g)list.get(b2);
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: re-attaching retained ");
          stringBuilder.append(g1);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        byte b3;
        for (b3 = 0; b3 < o1.a.length && (o1.a[b3]).b != g1.o; b3++);
        if (b3 == o1.a.length) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Could not find active fragment with index ");
          stringBuilder.append(g1.o);
          a(new IllegalStateException(stringBuilder.toString()));
        } 
        p p1 = o1.a[b3];
        p1.l = g1;
        g1.m = null;
        g1.A = 0;
        g1.x = false;
        g1.u = false;
        g1.r = null;
        if (p1.k != null) {
          p1.k.setClassLoader(this.m.g().getClassLoader());
          g1.m = p1.k.getSparseParcelableArray("android:view_state");
          g1.l = p1.k;
        } 
      } 
    } else {
      object1 = null;
      object2 = null;
    } 
    this.f = new SparseArray(o1.a.length);
    for (byte b1 = 0; b1 < o1.a.length; b1++) {
      p p1 = o1.a[b1];
      if (p1 != null) {
        p p2;
        n n1;
        if (object1 != null && b1 < object1.size()) {
          n1 = (n)object1.get(b1);
        } else {
          n1 = null;
        } 
        if (object2 != null && b1 < object2.size()) {
          p2 = (p)object2.get(b1);
        } else {
          p2 = null;
        } 
        g g1 = p1.a(this.m, this.n, this.o, n1, p2);
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: active #");
          stringBuilder.append(b1);
          stringBuilder.append(": ");
          stringBuilder.append(g1);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        this.f.put(g1.o, g1);
        p1.l = null;
      } 
    } 
    if (paramn != null) {
      boolean bool;
      List list = paramn.a();
      if (list != null) {
        bool = list.size();
      } else {
        bool = false;
      } 
      for (byte b2 = 0; b2 < bool; b2++) {
        g g1 = (g)list.get(b2);
        if (g1.s >= 0) {
          g1.r = (g)this.f.get(g1.s);
          if (g1.r == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Re-attaching retained fragment ");
            stringBuilder.append(g1);
            stringBuilder.append(" target no longer exists: ");
            stringBuilder.append(g1.s);
            Log.w("FragmentManager", stringBuilder.toString());
          } 
        } 
      } 
    } 
    this.e.clear();
    if (o1.b != null) {
      byte b2 = 0;
      while (b2 < o1.b.length) {
        g g1 = (g)this.f.get(o1.b[b2]);
        if (g1 == null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("No instantiated fragment for index #");
          stringBuilder.append(o1.b[b2]);
          a(new IllegalStateException(stringBuilder.toString()));
        } 
        g1.u = true;
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: added #");
          stringBuilder.append(b2);
          stringBuilder.append(": ");
          stringBuilder.append(g1);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        if (!this.e.contains(g1))
          synchronized (this.e) {
            this.e.add(g1);
            b2++;
            continue;
          }  
        throw new IllegalStateException("Already added!");
      } 
    } 
    if (o1.c != null) {
      this.g = new ArrayList(o1.c.length);
      for (byte b2 = 0; b2 < o1.c.length; b2++) {
        c c1 = o1.c[b2].a(this);
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restoreAllState: back stack #");
          stringBuilder.append(b2);
          stringBuilder.append(" (index ");
          stringBuilder.append(c1.m);
          stringBuilder.append("): ");
          stringBuilder.append(c1);
          Log.v("FragmentManager", stringBuilder.toString());
          PrintWriter printWriter = new PrintWriter(new e("FragmentManager"));
          c1.a("  ", printWriter, false);
          printWriter.close();
        } 
        this.g.add(c1);
        if (c1.m >= 0)
          a(c1.m, c1); 
      } 
    } else {
      this.g = null;
    } 
    if (o1.d >= 0)
      this.p = (g)this.f.get(o1.d); 
    this.d = o1.e;
  }
  
  void a(c paramc, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramBoolean1) {
      paramc.b(paramBoolean3);
    } else {
      paramc.d();
    } 
    ArrayList arrayList1 = new ArrayList(1);
    ArrayList arrayList2 = new ArrayList(1);
    arrayList1.add(paramc);
    arrayList2.add(Boolean.valueOf(paramBoolean1));
    if (paramBoolean2)
      r.a(this, arrayList1, arrayList2, 0, 1, true); 
    if (paramBoolean3)
      a(this.l, true); 
    SparseArray sparseArray = this.f;
    if (sparseArray != null) {
      int i1 = sparseArray.size();
      for (byte b1 = 0; b1 < i1; b1++) {
        g g1 = (g)this.f.valueAt(b1);
        if (g1 != null && g1.S != null && g1.X && paramc.b(g1.I)) {
          if (g1.Z > 0.0F)
            g1.S.setAlpha(g1.Z); 
          if (paramBoolean3) {
            g1.Z = 0.0F;
          } else {
            g1.Z = -1.0F;
            g1.X = false;
          } 
        } 
      } 
    } 
  }
  
  public void a(g paramg) {
    if (paramg.U) {
      if (this.c) {
        this.w = true;
        return;
      } 
      paramg.U = false;
      a(paramg, this.l, 0, 0, false);
    } 
  }
  
  void a(g paramg, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i4;
    int i3;
    boolean bool = paramg.u;
    int i2 = 1;
    if (!bool || paramg.L) {
      i3 = paramInt1;
      if (i3 > i2)
        i3 = 1; 
    } else {
      i3 = paramInt1;
    } 
    if (paramg.v && i3 > paramg.k)
      if (paramg.k == 0 && paramg.h()) {
        i3 = 1;
      } else {
        i3 = paramg.k;
      }  
    if (paramg.U && paramg.k < 3 && i3 > 2) {
      i4 = 2;
    } else {
      i4 = i3;
    } 
    if (paramg.k <= i4) {
      if (paramg.w && !paramg.x)
        return; 
      if (paramg.V() != null || paramg.W() != null) {
        paramg.a(null);
        paramg.a(null);
        a(paramg, paramg.X(), 0, 0, true);
      } 
      switch (paramg.k) {
        case 0:
          if (i4 > 0) {
            m m1;
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto CREATED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            if (paramg.l != null) {
              paramg.l.setClassLoader(this.m.g().getClassLoader());
              paramg.m = paramg.l.getSparseParcelableArray("android:view_state");
              paramg.r = a(paramg.l, "android:target_state");
              if (paramg.r != null)
                paramg.t = paramg.l.getInt("android:target_req_state", 0); 
              if (paramg.n != null) {
                paramg.V = paramg.n.booleanValue();
                paramg.n = null;
              } else {
                paramg.V = paramg.l.getBoolean("android:user_visible_hint", i2);
              } 
              if (!paramg.V) {
                paramg.U = i2;
                if (i4 > 2)
                  i4 = 2; 
              } 
            } 
            k k1 = this.m;
            paramg.C = k1;
            g g1 = this.o;
            paramg.G = g1;
            if (g1 != null) {
              m1 = g1.D;
            } else {
              m1 = k1.i();
            } 
            paramg.B = m1;
            if (paramg.r != null)
              if (this.f.get(paramg.r.o) == paramg.r) {
                if (paramg.r.k < i2)
                  a(paramg.r, 1, 0, 0, true); 
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment ");
                stringBuilder.append(paramg);
                stringBuilder.append(" declared target fragment ");
                stringBuilder.append(paramg.r);
                stringBuilder.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(stringBuilder.toString());
              }  
            a(paramg, this.m.g(), false);
            paramg.Q = false;
            paramg.a(this.m.g());
            if (paramg.Q) {
              if (paramg.G == null) {
                this.m.b(paramg);
              } else {
                paramg.G.a(paramg);
              } 
              b(paramg, this.m.g(), false);
              if (!paramg.ab) {
                a(paramg, paramg.l, false);
                paramg.l(paramg.l);
                b(paramg, paramg.l, false);
              } else {
                paramg.j(paramg.l);
                paramg.k = i2;
              } 
              paramg.N = false;
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Fragment ");
              stringBuilder.append(paramg);
              stringBuilder.append(" did not call through to super.onAttach()");
              throw new ad(stringBuilder.toString());
            } 
          } 
        case 1:
          c(paramg);
          if (i4 > i2) {
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto ACTIVITY_CREATED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            if (!paramg.w) {
              ViewGroup viewGroup;
              if (paramg.I != 0) {
                if (paramg.I == -1) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Cannot create fragment ");
                  stringBuilder.append(paramg);
                  stringBuilder.append(" for a container view with no id");
                  a(new IllegalArgumentException(stringBuilder.toString()));
                } 
                viewGroup = (ViewGroup)this.n.a(paramg.I);
                if (viewGroup == null && !paramg.y) {
                  String str;
                  try {
                    str = paramg.m().getResourceName(paramg.I);
                  } catch (android.content.res.Resources.NotFoundException notFoundException) {
                    str = "unknown";
                  } 
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("No view found for id 0x");
                  stringBuilder.append(Integer.toHexString(paramg.I));
                  stringBuilder.append(" (");
                  stringBuilder.append(str);
                  stringBuilder.append(") for fragment ");
                  stringBuilder.append(paramg);
                  a(new IllegalArgumentException(stringBuilder.toString()));
                } 
              } else {
                viewGroup = null;
              } 
              paramg.R = viewGroup;
              paramg.b(paramg.h(paramg.l), viewGroup, paramg.l);
              if (paramg.S != null) {
                paramg.T = paramg.S;
                paramg.S.setSaveFromParentEnabled(false);
                if (viewGroup != null)
                  viewGroup.addView(paramg.S); 
                if (paramg.K)
                  paramg.S.setVisibility(8); 
                paramg.a(paramg.S, paramg.l);
                a(paramg, paramg.S, paramg.l, false);
                if (paramg.S.getVisibility() != 0 || paramg.R == null)
                  i2 = 0; 
                paramg.X = i2;
              } else {
                paramg.T = null;
              } 
            } 
            paramg.m(paramg.l);
            c(paramg, paramg.l, false);
            if (paramg.S != null)
              paramg.f(paramg.l); 
            paramg.l = null;
          } 
        case 2:
          if (i4 > 2) {
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto STARTED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramg.H();
            b(paramg, false);
          } 
        case 3:
          if (i4 > 3) {
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("moveto RESUMED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramg.I();
            c(paramg, false);
            paramg.l = null;
            paramg.m = null;
          } 
          break;
      } 
    } else if (paramg.k > i4) {
      switch (paramg.k) {
        case 4:
          if (i4 < 4) {
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom RESUMED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramg.L();
            d(paramg, false);
          } 
        case 3:
          if (i4 < 3) {
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom STARTED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            paramg.M();
            e(paramg, false);
          } 
        case 2:
          if (i4 < 2) {
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("movefrom ACTIVITY_CREATED: ");
              stringBuilder.append(paramg);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            if (paramg.S != null && this.m.a(paramg) && paramg.m == null)
              m(paramg); 
            paramg.N();
            f(paramg, false);
            if (paramg.S != null && paramg.R != null) {
              c c1;
              paramg.R.endViewTransition(paramg.S);
              paramg.S.clearAnimation();
              if (this.l > 0 && !this.u && paramg.S.getVisibility() == 0 && paramg.Z >= 0.0F) {
                c1 = a(paramg, paramInt2, false, paramInt3);
              } else {
                c1 = null;
              } 
              paramg.Z = 0.0F;
              if (c1 != null)
                a(paramg, c1, i4); 
              paramg.R.removeView(paramg.S);
            } 
            paramg.R = null;
            paramg.S = null;
            paramg.ae = null;
            paramg.af.a(null);
            paramg.T = null;
            paramg.x = false;
          } 
        case 1:
          if (i4 < i2) {
            if (this.u)
              if (paramg.V() != null) {
                View view = paramg.V();
                paramg.a(null);
                view.clearAnimation();
              } else if (paramg.W() != null) {
                Animator animator = paramg.W();
                paramg.a(null);
                animator.cancel();
              }  
            if (paramg.V() != null || paramg.W() != null) {
              paramg.b(i4);
            } else {
              if (a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("movefrom CREATED: ");
                stringBuilder.append(paramg);
                Log.v("FragmentManager", stringBuilder.toString());
              } 
              if (!paramg.N) {
                paramg.O();
                g(paramg, false);
              } else {
                paramg.k = 0;
              } 
              paramg.P();
              h(paramg, false);
              if (!paramBoolean) {
                if (!paramg.N) {
                  g(paramg);
                  break;
                } 
                paramg.C = null;
                paramg.G = null;
                paramg.B = null;
              } 
              break;
            } 
          } else {
            break;
          } 
          if (paramg.k != i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveToState: Fragment state for ");
            stringBuilder.append(paramg);
            stringBuilder.append(" not updated inline; ");
            stringBuilder.append("expected state ");
            stringBuilder.append(i2);
            stringBuilder.append(" found ");
            stringBuilder.append(paramg.k);
            Log.w("FragmentManager", stringBuilder.toString());
            paramg.k = i2;
          } 
          return;
      } 
    } 
    int i1 = i4;
    if (paramg.k != i1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("moveToState: Fragment state for ");
      stringBuilder.append(paramg);
      stringBuilder.append(" not updated inline; ");
      stringBuilder.append("expected state ");
      stringBuilder.append(i1);
      stringBuilder.append(" found ");
      stringBuilder.append(paramg.k);
      Log.w("FragmentManager", stringBuilder.toString());
      paramg.k = i1;
    } 
  }
  
  void a(g paramg, Context paramContext, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).a(paramg, paramContext, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.a(this, paramg, paramContext); 
    } 
  }
  
  void a(g paramg, Bundle paramBundle, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).a(paramg, paramBundle, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.a(this, paramg, paramBundle); 
    } 
  }
  
  void a(g paramg, View paramView, Bundle paramBundle, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).a(paramg, paramView, paramBundle, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.a(this, paramg, paramView, paramBundle); 
    } 
  }
  
  public void a(g paramg, boolean paramBoolean) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("add: ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    f(paramg);
    if (!paramg.L)
      if (!this.e.contains(paramg)) {
        synchronized (this.e) {
          this.e.add(paramg);
          paramg.u = true;
          paramg.v = false;
          if (paramg.S == null)
            paramg.Y = false; 
          if (paramg.O && paramg.P)
            this.r = true; 
          if (paramBoolean) {
            b(paramg);
            return;
          } 
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment already added: ");
        stringBuilder.append(paramg);
        throw new IllegalStateException(stringBuilder.toString());
      }  
  }
  
  public void a(k paramk, i parami, g paramg) {
    if (this.m == null) {
      this.m = paramk;
      this.n = parami;
      this.o = paramg;
      return;
    } 
    throw new IllegalStateException("Already attached");
  }
  
  public void a(h paramh, boolean paramBoolean) { // Byte code:
    //   0: iload_2
    //   1: ifne -> 8
    //   4: aload_0
    //   5: invokespecial y : ()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield u : Z
    //   14: ifne -> 61
    //   17: aload_0
    //   18: getfield m : Landroid/support/v4/app/k;
    //   21: ifnonnull -> 27
    //   24: goto -> 61
    //   27: aload_0
    //   28: getfield b : Ljava/util/ArrayList;
    //   31: ifnonnull -> 45
    //   34: aload_0
    //   35: new java/util/ArrayList
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: putfield b : Ljava/util/ArrayList;
    //   45: aload_0
    //   46: getfield b : Ljava/util/ArrayList;
    //   49: aload_1
    //   50: invokevirtual add : (Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: invokevirtual f : ()V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: iload_2
    //   62: ifeq -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: new java/lang/IllegalStateException
    //   71: dup
    //   72: ldc_w 'Activity has been destroyed'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: athrow
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	79	finally
    //   27	45	79	finally
    //   45	60	79	finally
    //   65	67	79	finally
    //   68	79	79	finally
    //   80	82	79	finally }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) { // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload #5
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload #5
    //   18: ldc_w '    '
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #5
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: astore #8
    //   32: aload_0
    //   33: getfield f : Landroid/util/SparseArray;
    //   36: astore #9
    //   38: iconst_0
    //   39: istore #10
    //   41: aload #9
    //   43: ifnull -> 165
    //   46: aload #9
    //   48: invokevirtual size : ()I
    //   51: istore #29
    //   53: iload #29
    //   55: ifle -> 165
    //   58: aload_3
    //   59: aload_1
    //   60: invokevirtual print : (Ljava/lang/String;)V
    //   63: aload_3
    //   64: ldc_w 'Active Fragments in '
    //   67: invokevirtual print : (Ljava/lang/String;)V
    //   70: aload_3
    //   71: aload_0
    //   72: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   75: invokestatic toHexString : (I)Ljava/lang/String;
    //   78: invokevirtual print : (Ljava/lang/String;)V
    //   81: aload_3
    //   82: ldc_w ':'
    //   85: invokevirtual println : (Ljava/lang/String;)V
    //   88: iconst_0
    //   89: istore #30
    //   91: iload #30
    //   93: iload #29
    //   95: if_icmpge -> 165
    //   98: aload_0
    //   99: getfield f : Landroid/util/SparseArray;
    //   102: iload #30
    //   104: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   107: checkcast android/support/v4/app/g
    //   110: astore #31
    //   112: aload_3
    //   113: aload_1
    //   114: invokevirtual print : (Ljava/lang/String;)V
    //   117: aload_3
    //   118: ldc_w '  #'
    //   121: invokevirtual print : (Ljava/lang/String;)V
    //   124: aload_3
    //   125: iload #30
    //   127: invokevirtual print : (I)V
    //   130: aload_3
    //   131: ldc_w ': '
    //   134: invokevirtual print : (Ljava/lang/String;)V
    //   137: aload_3
    //   138: aload #31
    //   140: invokevirtual println : (Ljava/lang/Object;)V
    //   143: aload #31
    //   145: ifnull -> 159
    //   148: aload #31
    //   150: aload #8
    //   152: aload_2
    //   153: aload_3
    //   154: aload #4
    //   156: invokevirtual a : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   159: iinc #30, 1
    //   162: goto -> 91
    //   165: aload_0
    //   166: getfield e : Ljava/util/ArrayList;
    //   169: invokevirtual size : ()I
    //   172: istore #11
    //   174: iload #11
    //   176: ifle -> 255
    //   179: aload_3
    //   180: aload_1
    //   181: invokevirtual print : (Ljava/lang/String;)V
    //   184: aload_3
    //   185: ldc_w 'Added Fragments:'
    //   188: invokevirtual println : (Ljava/lang/String;)V
    //   191: iconst_0
    //   192: istore #27
    //   194: iload #27
    //   196: iload #11
    //   198: if_icmpge -> 255
    //   201: aload_0
    //   202: getfield e : Ljava/util/ArrayList;
    //   205: iload #27
    //   207: invokevirtual get : (I)Ljava/lang/Object;
    //   210: checkcast android/support/v4/app/g
    //   213: astore #28
    //   215: aload_3
    //   216: aload_1
    //   217: invokevirtual print : (Ljava/lang/String;)V
    //   220: aload_3
    //   221: ldc_w '  #'
    //   224: invokevirtual print : (Ljava/lang/String;)V
    //   227: aload_3
    //   228: iload #27
    //   230: invokevirtual print : (I)V
    //   233: aload_3
    //   234: ldc_w ': '
    //   237: invokevirtual print : (Ljava/lang/String;)V
    //   240: aload_3
    //   241: aload #28
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: invokevirtual println : (Ljava/lang/String;)V
    //   249: iinc #27, 1
    //   252: goto -> 194
    //   255: aload_0
    //   256: getfield h : Ljava/util/ArrayList;
    //   259: astore #12
    //   261: aload #12
    //   263: ifnull -> 354
    //   266: aload #12
    //   268: invokevirtual size : ()I
    //   271: istore #24
    //   273: iload #24
    //   275: ifle -> 354
    //   278: aload_3
    //   279: aload_1
    //   280: invokevirtual print : (Ljava/lang/String;)V
    //   283: aload_3
    //   284: ldc_w 'Fragments Created Menus:'
    //   287: invokevirtual println : (Ljava/lang/String;)V
    //   290: iconst_0
    //   291: istore #25
    //   293: iload #25
    //   295: iload #24
    //   297: if_icmpge -> 354
    //   300: aload_0
    //   301: getfield h : Ljava/util/ArrayList;
    //   304: iload #25
    //   306: invokevirtual get : (I)Ljava/lang/Object;
    //   309: checkcast android/support/v4/app/g
    //   312: astore #26
    //   314: aload_3
    //   315: aload_1
    //   316: invokevirtual print : (Ljava/lang/String;)V
    //   319: aload_3
    //   320: ldc_w '  #'
    //   323: invokevirtual print : (Ljava/lang/String;)V
    //   326: aload_3
    //   327: iload #25
    //   329: invokevirtual print : (I)V
    //   332: aload_3
    //   333: ldc_w ': '
    //   336: invokevirtual print : (Ljava/lang/String;)V
    //   339: aload_3
    //   340: aload #26
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: invokevirtual println : (Ljava/lang/String;)V
    //   348: iinc #25, 1
    //   351: goto -> 293
    //   354: aload_0
    //   355: getfield g : Ljava/util/ArrayList;
    //   358: astore #13
    //   360: aload #13
    //   362: ifnull -> 464
    //   365: aload #13
    //   367: invokevirtual size : ()I
    //   370: istore #21
    //   372: iload #21
    //   374: ifle -> 464
    //   377: aload_3
    //   378: aload_1
    //   379: invokevirtual print : (Ljava/lang/String;)V
    //   382: aload_3
    //   383: ldc_w 'Back Stack:'
    //   386: invokevirtual println : (Ljava/lang/String;)V
    //   389: iconst_0
    //   390: istore #22
    //   392: iload #22
    //   394: iload #21
    //   396: if_icmpge -> 464
    //   399: aload_0
    //   400: getfield g : Ljava/util/ArrayList;
    //   403: iload #22
    //   405: invokevirtual get : (I)Ljava/lang/Object;
    //   408: checkcast android/support/v4/app/c
    //   411: astore #23
    //   413: aload_3
    //   414: aload_1
    //   415: invokevirtual print : (Ljava/lang/String;)V
    //   418: aload_3
    //   419: ldc_w '  #'
    //   422: invokevirtual print : (Ljava/lang/String;)V
    //   425: aload_3
    //   426: iload #22
    //   428: invokevirtual print : (I)V
    //   431: aload_3
    //   432: ldc_w ': '
    //   435: invokevirtual print : (Ljava/lang/String;)V
    //   438: aload_3
    //   439: aload #23
    //   441: invokevirtual toString : ()Ljava/lang/String;
    //   444: invokevirtual println : (Ljava/lang/String;)V
    //   447: aload #23
    //   449: aload #8
    //   451: aload_2
    //   452: aload_3
    //   453: aload #4
    //   455: invokevirtual a : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   458: iinc #22, 1
    //   461: goto -> 392
    //   464: aload_0
    //   465: monitorenter
    //   466: aload_0
    //   467: getfield i : Ljava/util/ArrayList;
    //   470: ifnull -> 560
    //   473: aload_0
    //   474: getfield i : Ljava/util/ArrayList;
    //   477: invokevirtual size : ()I
    //   480: istore #18
    //   482: iload #18
    //   484: ifle -> 560
    //   487: aload_3
    //   488: aload_1
    //   489: invokevirtual print : (Ljava/lang/String;)V
    //   492: aload_3
    //   493: ldc_w 'Back Stack Indices:'
    //   496: invokevirtual println : (Ljava/lang/String;)V
    //   499: iconst_0
    //   500: istore #19
    //   502: iload #19
    //   504: iload #18
    //   506: if_icmpge -> 560
    //   509: aload_0
    //   510: getfield i : Ljava/util/ArrayList;
    //   513: iload #19
    //   515: invokevirtual get : (I)Ljava/lang/Object;
    //   518: checkcast android/support/v4/app/c
    //   521: astore #20
    //   523: aload_3
    //   524: aload_1
    //   525: invokevirtual print : (Ljava/lang/String;)V
    //   528: aload_3
    //   529: ldc_w '  #'
    //   532: invokevirtual print : (Ljava/lang/String;)V
    //   535: aload_3
    //   536: iload #19
    //   538: invokevirtual print : (I)V
    //   541: aload_3
    //   542: ldc_w ': '
    //   545: invokevirtual print : (Ljava/lang/String;)V
    //   548: aload_3
    //   549: aload #20
    //   551: invokevirtual println : (Ljava/lang/Object;)V
    //   554: iinc #19, 1
    //   557: goto -> 502
    //   560: aload_0
    //   561: getfield j : Ljava/util/ArrayList;
    //   564: ifnull -> 603
    //   567: aload_0
    //   568: getfield j : Ljava/util/ArrayList;
    //   571: invokevirtual size : ()I
    //   574: ifle -> 603
    //   577: aload_3
    //   578: aload_1
    //   579: invokevirtual print : (Ljava/lang/String;)V
    //   582: aload_3
    //   583: ldc_w 'mAvailBackStackIndices: '
    //   586: invokevirtual print : (Ljava/lang/String;)V
    //   589: aload_3
    //   590: aload_0
    //   591: getfield j : Ljava/util/ArrayList;
    //   594: invokevirtual toArray : ()[Ljava/lang/Object;
    //   597: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   600: invokevirtual println : (Ljava/lang/String;)V
    //   603: aload_0
    //   604: monitorexit
    //   605: aload_0
    //   606: getfield b : Ljava/util/ArrayList;
    //   609: astore #15
    //   611: aload #15
    //   613: ifnull -> 698
    //   616: aload #15
    //   618: invokevirtual size : ()I
    //   621: istore #16
    //   623: iload #16
    //   625: ifle -> 698
    //   628: aload_3
    //   629: aload_1
    //   630: invokevirtual print : (Ljava/lang/String;)V
    //   633: aload_3
    //   634: ldc_w 'Pending Actions:'
    //   637: invokevirtual println : (Ljava/lang/String;)V
    //   640: iload #10
    //   642: iload #16
    //   644: if_icmpge -> 698
    //   647: aload_0
    //   648: getfield b : Ljava/util/ArrayList;
    //   651: iload #10
    //   653: invokevirtual get : (I)Ljava/lang/Object;
    //   656: checkcast android/support/v4/app/m$h
    //   659: astore #17
    //   661: aload_3
    //   662: aload_1
    //   663: invokevirtual print : (Ljava/lang/String;)V
    //   666: aload_3
    //   667: ldc_w '  #'
    //   670: invokevirtual print : (Ljava/lang/String;)V
    //   673: aload_3
    //   674: iload #10
    //   676: invokevirtual print : (I)V
    //   679: aload_3
    //   680: ldc_w ': '
    //   683: invokevirtual print : (Ljava/lang/String;)V
    //   686: aload_3
    //   687: aload #17
    //   689: invokevirtual println : (Ljava/lang/Object;)V
    //   692: iinc #10, 1
    //   695: goto -> 640
    //   698: aload_3
    //   699: aload_1
    //   700: invokevirtual print : (Ljava/lang/String;)V
    //   703: aload_3
    //   704: ldc_w 'FragmentManager misc state:'
    //   707: invokevirtual println : (Ljava/lang/String;)V
    //   710: aload_3
    //   711: aload_1
    //   712: invokevirtual print : (Ljava/lang/String;)V
    //   715: aload_3
    //   716: ldc_w '  mHost='
    //   719: invokevirtual print : (Ljava/lang/String;)V
    //   722: aload_3
    //   723: aload_0
    //   724: getfield m : Landroid/support/v4/app/k;
    //   727: invokevirtual println : (Ljava/lang/Object;)V
    //   730: aload_3
    //   731: aload_1
    //   732: invokevirtual print : (Ljava/lang/String;)V
    //   735: aload_3
    //   736: ldc_w '  mContainer='
    //   739: invokevirtual print : (Ljava/lang/String;)V
    //   742: aload_3
    //   743: aload_0
    //   744: getfield n : Landroid/support/v4/app/i;
    //   747: invokevirtual println : (Ljava/lang/Object;)V
    //   750: aload_0
    //   751: getfield o : Landroid/support/v4/app/g;
    //   754: ifnull -> 777
    //   757: aload_3
    //   758: aload_1
    //   759: invokevirtual print : (Ljava/lang/String;)V
    //   762: aload_3
    //   763: ldc_w '  mParent='
    //   766: invokevirtual print : (Ljava/lang/String;)V
    //   769: aload_3
    //   770: aload_0
    //   771: getfield o : Landroid/support/v4/app/g;
    //   774: invokevirtual println : (Ljava/lang/Object;)V
    //   777: aload_3
    //   778: aload_1
    //   779: invokevirtual print : (Ljava/lang/String;)V
    //   782: aload_3
    //   783: ldc_w '  mCurState='
    //   786: invokevirtual print : (Ljava/lang/String;)V
    //   789: aload_3
    //   790: aload_0
    //   791: getfield l : I
    //   794: invokevirtual print : (I)V
    //   797: aload_3
    //   798: ldc_w ' mStateSaved='
    //   801: invokevirtual print : (Ljava/lang/String;)V
    //   804: aload_3
    //   805: aload_0
    //   806: getfield s : Z
    //   809: invokevirtual print : (Z)V
    //   812: aload_3
    //   813: ldc_w ' mStopped='
    //   816: invokevirtual print : (Ljava/lang/String;)V
    //   819: aload_3
    //   820: aload_0
    //   821: getfield t : Z
    //   824: invokevirtual print : (Z)V
    //   827: aload_3
    //   828: ldc_w ' mDestroyed='
    //   831: invokevirtual print : (Ljava/lang/String;)V
    //   834: aload_3
    //   835: aload_0
    //   836: getfield u : Z
    //   839: invokevirtual println : (Z)V
    //   842: aload_0
    //   843: getfield r : Z
    //   846: ifeq -> 869
    //   849: aload_3
    //   850: aload_1
    //   851: invokevirtual print : (Ljava/lang/String;)V
    //   854: aload_3
    //   855: ldc_w '  mNeedMenuInvalidate='
    //   858: invokevirtual print : (Ljava/lang/String;)V
    //   861: aload_3
    //   862: aload_0
    //   863: getfield r : Z
    //   866: invokevirtual println : (Z)V
    //   869: aload_0
    //   870: getfield v : Ljava/lang/String;
    //   873: ifnull -> 896
    //   876: aload_3
    //   877: aload_1
    //   878: invokevirtual print : (Ljava/lang/String;)V
    //   881: aload_3
    //   882: ldc_w '  mNoTransactionsBecause='
    //   885: invokevirtual print : (Ljava/lang/String;)V
    //   888: aload_3
    //   889: aload_0
    //   890: getfield v : Ljava/lang/String;
    //   893: invokevirtual println : (Ljava/lang/String;)V
    //   896: return
    //   897: astore #14
    //   899: aload_0
    //   900: monitorexit
    //   901: aload #14
    //   903: athrow
    // Exception table:
    //   from	to	target	type
    //   466	482	897	finally
    //   487	499	897	finally
    //   509	554	897	finally
    //   560	603	897	finally
    //   603	605	897	finally
    //   899	901	897	finally }
  
  public void a(boolean paramBoolean) {
    for (int i1 = -1 + this.e.size(); i1 >= 0; i1--) {
      g g1 = (g)this.e.get(i1);
      if (g1 != null)
        g1.f(paramBoolean); 
    } 
  }
  
  boolean a(int paramInt) { return (this.l >= paramInt); }
  
  public boolean a(Menu paramMenu) {
    int i1 = this.l;
    byte b1 = 0;
    if (i1 < 1)
      return false; 
    boolean bool = false;
    while (b1 < this.e.size()) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null && g1.c(paramMenu))
        bool = true; 
      b1++;
    } 
    return bool;
  }
  
  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater) {
    if (this.l < 1)
      return false; 
    ArrayList arrayList1 = null;
    byte b1 = 0;
    boolean bool = false;
    while (b1 < this.e.size()) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null && g1.b(paramMenu, paramMenuInflater)) {
        if (arrayList1 == null)
          arrayList1 = new ArrayList(); 
        arrayList1.add(g1);
        bool = true;
      } 
      b1++;
    } 
    ArrayList arrayList2 = this.h;
    byte b2 = 0;
    if (arrayList2 != null)
      while (b2 < this.h.size()) {
        g g1 = (g)this.h.get(b2);
        if (arrayList1 == null || !arrayList1.contains(g1))
          g1.v(); 
        b2++;
      }  
    this.h = arrayList1;
    return bool;
  }
  
  public boolean a(MenuItem paramMenuItem) {
    if (this.l < 1)
      return false; 
    for (byte b1 = 0; b1 < this.e.size(); b1++) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null && g1.c(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  boolean a(ArrayList<c> paramArrayList1, ArrayList<Boolean> paramArrayList2, String paramString, int paramInt1, int paramInt2) {
    byte b1;
    ArrayList arrayList = this.g;
    if (arrayList == null)
      return false; 
    if (paramString == null && paramInt1 < 0 && (paramInt2 & true) == 0) {
      int i2 = arrayList.size() - 1;
      if (i2 < 0)
        return false; 
      paramArrayList1.add(this.g.remove(i2));
      paramArrayList2.add(Boolean.valueOf(true));
      return true;
    } 
    if (paramString != null || paramInt1 >= 0) {
      for (b1 = this.g.size() - 1; b1 >= 0; b1--) {
        c c1 = (c)this.g.get(b1);
        if ((paramString != null && paramString.equals(c1.f())) || (paramInt1 >= 0 && paramInt1 == c1.m))
          break; 
      } 
      if (b1 < 0)
        return false; 
      if ((paramInt2 & true) != 0)
        while (--b1 >= 0) {
          c c1 = (c)this.g.get(b1);
          if ((paramString != null && paramString.equals(c1.f())) || (paramInt1 >= 0 && paramInt1 == c1.m));
        }  
    } else {
      b1 = -1;
    } 
    if (b1 == this.g.size() - 1)
      return false; 
    for (int i1 = this.g.size() - 1; i1 > b1; i1--) {
      paramArrayList1.add(this.g.remove(i1));
      paramArrayList2.add(Boolean.valueOf(true));
    } 
    return true;
  }
  
  public g b(int paramInt) {
    for (int i1 = -1 + this.e.size(); i1 >= 0; i1--) {
      g g1 = (g)this.e.get(i1);
      if (g1 != null && g1.H == paramInt)
        return g1; 
    } 
    SparseArray sparseArray = this.f;
    if (sparseArray != null)
      for (int i2 = -1 + sparseArray.size(); i2 >= 0; i2--) {
        g g1 = (g)this.f.valueAt(i2);
        if (g1 != null && g1.H == paramInt)
          return g1; 
      }  
    return null;
  }
  
  public g b(String paramString) {
    SparseArray sparseArray = this.f;
    if (sparseArray != null && paramString != null)
      for (int i1 = -1 + sparseArray.size(); i1 >= 0; i1--) {
        g g1 = (g)this.f.valueAt(i1);
        if (g1 != null) {
          g g2 = g1.a(paramString);
          if (g2 != null)
            return g2; 
        } 
      }  
    return null;
  }
  
  void b(c paramc) {
    if (this.g == null)
      this.g = new ArrayList(); 
    this.g.add(paramc);
  }
  
  void b(g paramg) { a(paramg, this.l, 0, 0, false); }
  
  void b(g paramg, Context paramContext, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).b(paramg, paramContext, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.b(this, paramg, paramContext); 
    } 
  }
  
  void b(g paramg, Bundle paramBundle, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).b(paramg, paramBundle, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.b(this, paramg, paramBundle); 
    } 
  }
  
  void b(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).b(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.a(this, paramg); 
    } 
  }
  
  public void b(Menu paramMenu) {
    if (this.l < 1)
      return; 
    for (byte b1 = 0; b1 < this.e.size(); b1++) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null)
        g1.d(paramMenu); 
    } 
  }
  
  public void b(boolean paramBoolean) {
    for (int i1 = -1 + this.e.size(); i1 >= 0; i1--) {
      g g1 = (g)this.e.get(i1);
      if (g1 != null)
        g1.g(paramBoolean); 
    } 
  }
  
  public boolean b() {
    y();
    return a(null, -1, 0);
  }
  
  public boolean b(MenuItem paramMenuItem) {
    if (this.l < 1)
      return false; 
    for (byte b1 = 0; b1 < this.e.size(); b1++) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null && g1.d(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public List<g> c() {
    if (this.e.isEmpty())
      return Collections.emptyList(); 
    synchronized (this.e) {
      return (List)this.e.clone();
    } 
  }
  
  public void c(int paramInt) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Ljava/util/ArrayList;
    //   6: iload_1
    //   7: aconst_null
    //   8: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield j : Ljava/util/ArrayList;
    //   16: ifnonnull -> 30
    //   19: aload_0
    //   20: new java/util/ArrayList
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: putfield j : Ljava/util/ArrayList;
    //   30: getstatic android/support/v4/app/m.a : Z
    //   33: ifeq -> 73
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #4
    //   45: aload #4
    //   47: ldc_w 'Freeing back stack index '
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #4
    //   56: iload_1
    //   57: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc_w 'FragmentManager'
    //   64: aload #4
    //   66: invokevirtual toString : ()Ljava/lang/String;
    //   69: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: aload_0
    //   74: getfield j : Ljava/util/ArrayList;
    //   77: iload_1
    //   78: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   81: invokevirtual add : (Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	88	finally
    //   30	73	88	finally
    //   73	87	88	finally
    //   89	91	88	finally }
  
  void c(g paramg) {
    if (paramg.w && !paramg.z) {
      paramg.b(paramg.h(paramg.l), null, paramg.l);
      if (paramg.S != null) {
        paramg.T = paramg.S;
        paramg.S.setSaveFromParentEnabled(false);
        if (paramg.K)
          paramg.S.setVisibility(8); 
        paramg.a(paramg.S, paramg.l);
        a(paramg, paramg.S, paramg.l, false);
        return;
      } 
      paramg.T = null;
    } 
  }
  
  void c(g paramg, Bundle paramBundle, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).c(paramg, paramBundle, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.c(this, paramg, paramBundle); 
    } 
  }
  
  void c(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).c(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.b(this, paramg); 
    } 
  }
  
  void d(g paramg) {
    if (paramg.S != null) {
      c c1 = a(paramg, paramg.R(), true ^ paramg.K, paramg.S());
      if (c1 != null && c1.b != null) {
        c1.b.setTarget(paramg.S);
        if (paramg.K) {
          if (paramg.Z()) {
            paramg.h(false);
          } else {
            ViewGroup viewGroup = paramg.R;
            View view = paramg.S;
            viewGroup.startViewTransition(view);
            c1.b.addListener(new AnimatorListenerAdapter(this, viewGroup, view, paramg) {
                  public void onAnimationEnd(Animator param1Animator) {
                    this.a.endViewTransition(this.b);
                    param1Animator.removeListener(this);
                    if (this.c.S != null)
                      this.c.S.setVisibility(8); 
                  }
                });
          } 
        } else {
          paramg.S.setVisibility(0);
        } 
        b(paramg.S, c1);
        c1.b.start();
      } else {
        byte b1;
        if (c1 != null) {
          b(paramg.S, c1);
          paramg.S.startAnimation(c1.a);
          c1.a.start();
        } 
        if (paramg.K && !paramg.Z()) {
          b1 = 8;
        } else {
          b1 = 0;
        } 
        paramg.S.setVisibility(b1);
        if (paramg.Z())
          paramg.h(false); 
      } 
    } 
    if (paramg.u && paramg.O && paramg.P)
      this.r = true; 
    paramg.Y = false;
    paramg.c(paramg.K);
  }
  
  void d(g paramg, Bundle paramBundle, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).d(paramg, paramBundle, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.d(this, paramg, paramBundle); 
    } 
  }
  
  void d(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).d(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.c(this, paramg); 
    } 
  }
  
  public boolean d() { return (this.s || this.t); }
  
  void e() {
    if (this.f == null)
      return; 
    for (byte b1 = 0; b1 < this.f.size(); b1++) {
      g g1 = (g)this.f.valueAt(b1);
      if (g1 != null)
        a(g1); 
    } 
  }
  
  void e(g paramg) {
    if (paramg == null)
      return; 
    int i1 = this.l;
    if (paramg.v)
      if (paramg.h()) {
        i1 = Math.min(i1, 1);
      } else {
        i1 = Math.min(i1, 0);
      }  
    a(paramg, i1, paramg.R(), paramg.S(), false);
    if (paramg.S != null) {
      g g1 = p(paramg);
      if (g1 != null) {
        View view = g1.S;
        ViewGroup viewGroup = paramg.R;
        int i2 = viewGroup.indexOfChild(view);
        int i3 = viewGroup.indexOfChild(paramg.S);
        if (i3 < i2) {
          viewGroup.removeViewAt(i3);
          viewGroup.addView(paramg.S, i2);
        } 
      } 
      if (paramg.X && paramg.R != null) {
        if (paramg.Z > 0.0F)
          paramg.S.setAlpha(paramg.Z); 
        paramg.Z = 0.0F;
        paramg.X = false;
        c c1 = a(paramg, paramg.R(), true, paramg.S());
        if (c1 != null) {
          b(paramg.S, c1);
          if (c1.a != null) {
            paramg.S.startAnimation(c1.a);
          } else {
            c1.b.setTarget(paramg.S);
            c1.b.start();
          } 
        } 
      } 
    } 
    if (paramg.Y)
      d(paramg); 
  }
  
  void e(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).e(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.d(this, paramg); 
    } 
  }
  
  void f() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield C : Ljava/util/ArrayList;
    //   6: ifnull -> 97
    //   9: aload_0
    //   10: getfield C : Ljava/util/ArrayList;
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifne -> 97
    //   19: iconst_1
    //   20: istore_2
    //   21: goto -> 24
    //   24: aload_0
    //   25: getfield b : Ljava/util/ArrayList;
    //   28: astore_3
    //   29: iconst_0
    //   30: istore #4
    //   32: aload_3
    //   33: ifnull -> 102
    //   36: aload_0
    //   37: getfield b : Ljava/util/ArrayList;
    //   40: invokevirtual size : ()I
    //   43: istore #5
    //   45: iconst_0
    //   46: istore #4
    //   48: iload #5
    //   50: iconst_1
    //   51: if_icmpne -> 102
    //   54: iconst_1
    //   55: istore #4
    //   57: goto -> 102
    //   60: aload_0
    //   61: getfield m : Landroid/support/v4/app/k;
    //   64: invokevirtual h : ()Landroid/os/Handler;
    //   67: aload_0
    //   68: getfield E : Ljava/lang/Runnable;
    //   71: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   74: aload_0
    //   75: getfield m : Landroid/support/v4/app/k;
    //   78: invokevirtual h : ()Landroid/os/Handler;
    //   81: aload_0
    //   82: getfield E : Ljava/lang/Runnable;
    //   85: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   88: pop
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -> 24
    //   102: iload_2
    //   103: ifne -> 60
    //   106: iload #4
    //   108: ifeq -> 89
    //   111: goto -> 60
    // Exception table:
    //   from	to	target	type
    //   2	19	92	finally
    //   24	29	92	finally
    //   36	45	92	finally
    //   60	89	92	finally
    //   89	91	92	finally
    //   93	95	92	finally }
  
  void f(g paramg) {
    if (paramg.o >= 0)
      return; 
    int i1 = this.d;
    this.d = i1 + 1;
    paramg.a(i1, this.o);
    if (this.f == null)
      this.f = new SparseArray(); 
    this.f.put(paramg.o, paramg);
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Allocated fragment index ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
  }
  
  void f(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).f(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.e(this, paramg); 
    } 
  }
  
  void g(g paramg) {
    if (paramg.o < 0)
      return; 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Freeing fragment index ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    this.f.put(paramg.o, null);
    paramg.u();
  }
  
  void g(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).g(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.f(this, paramg); 
    } 
  }
  
  public boolean g() {
    c(true);
    bool = false;
    while (c(this.x, this.y)) {
      this.c = true;
      try {
        b(this.x, this.y);
        z();
      } finally {
        z();
      } 
    } 
    h();
    C();
    return bool;
  }
  
  void h() {
    if (this.w) {
      this.w = false;
      e();
    } 
  }
  
  public void h(g paramg) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("remove: ");
      stringBuilder.append(paramg);
      stringBuilder.append(" nesting=");
      stringBuilder.append(paramg.A);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    boolean bool = true ^ paramg.h();
    if (!paramg.L || bool)
      synchronized (this.e) {
        this.e.remove(paramg);
        if (paramg.O && paramg.P)
          this.r = true; 
        paramg.u = false;
        paramg.v = true;
        return;
      }  
  }
  
  void h(g paramg, boolean paramBoolean) {
    g g1 = this.o;
    if (g1 != null) {
      l l1 = g1.n();
      if (l1 instanceof m)
        ((m)l1).h(paramg, true); 
    } 
    for (f f1 : this.J) {
      if (!paramBoolean || f1.b)
        f1.a.g(this, paramg); 
    } 
  }
  
  void i() {
    if (this.k != null)
      for (byte b1 = 0; b1 < this.k.size(); b1++)
        ((l.b)this.k.get(b1)).a();  
  }
  
  public void i(g paramg) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("hide: ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (!paramg.K) {
      paramg.K = true;
      paramg.Y = true ^ paramg.Y;
    } 
  }
  
  n j() {
    a(this.D);
    return this.D;
  }
  
  public void j(g paramg) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("show: ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (paramg.K) {
      paramg.K = false;
      paramg.Y = true ^ paramg.Y;
    } 
  }
  
  void k() {
    List list3;
    List list2;
    List list1;
    if (this.f != null) {
      list1 = null;
      list2 = null;
      list3 = null;
      for (byte b1 = 0; b1 < this.f.size(); b1++) {
        g g1 = (g)this.f.valueAt(b1);
        if (g1 != null) {
          n n1;
          if (g1.M) {
            byte b2;
            if (list1 == null)
              list1 = new ArrayList(); 
            list1.add(g1);
            if (g1.r != null) {
              b2 = g1.r.o;
            } else {
              b2 = -1;
            } 
            g1.s = b2;
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("retainNonConfig: keeping retained ");
              stringBuilder.append(g1);
              Log.v("FragmentManager", stringBuilder.toString());
            } 
          } 
          if (g1.D != null) {
            g1.D.k();
            n1 = g1.D.D;
          } else {
            n1 = g1.E;
          } 
          if (list2 == null && n1 != null) {
            list2 = new ArrayList(this.f.size());
            for (byte b2 = 0; b2 < b1; b2++)
              list2.add(null); 
          } 
          if (list2 != null)
            list2.add(n1); 
          if (list3 == null && g1.F != null) {
            list3 = new ArrayList(this.f.size());
            for (byte b2 = 0; b2 < b1; b2++)
              list3.add(null); 
          } 
          if (list3 != null)
            list3.add(g1.F); 
        } 
      } 
    } else {
      list1 = null;
      list2 = null;
      list3 = null;
    } 
    if (list1 == null && list2 == null && list3 == null) {
      this.D = null;
      return;
    } 
    this.D = new n(list1, list2, list3);
  }
  
  public void k(g paramg) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("detach: ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (!paramg.L) {
      paramg.L = true;
      if (paramg.u) {
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("remove from detach: ");
          stringBuilder.append(paramg);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        synchronized (this.e) {
          this.e.remove(paramg);
          if (paramg.O && paramg.P)
            this.r = true; 
          paramg.u = false;
          return;
        } 
      } 
    } 
  }
  
  Parcelable l() {
    A();
    B();
    g();
    this.s = true;
    this.D = null;
    SparseArray sparseArray = this.f;
    if (sparseArray != null) {
      Object object;
      if (sparseArray.size() <= 0)
        return null; 
      int i1 = this.f.size();
      p[] arrayOfp = new p[i1];
      byte b1 = 0;
      byte b2 = 0;
      boolean bool = false;
      while (b2 < i1) {
        g g2 = (g)this.f.valueAt(b2);
        if (g2 != null) {
          if (g2.o < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failure saving state: active ");
            stringBuilder.append(g2);
            stringBuilder.append(" has cleared index: ");
            stringBuilder.append(g2.o);
            a(new IllegalStateException(stringBuilder.toString()));
          } 
          p p1 = new p(g2);
          arrayOfp[b2] = p1;
          if (g2.k > 0 && p1.k == null) {
            p1.k = n(g2);
            if (g2.r != null) {
              if (g2.r.o < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failure saving state: ");
                stringBuilder.append(g2);
                stringBuilder.append(" has target not in fragment manager: ");
                stringBuilder.append(g2.r);
                a(new IllegalStateException(stringBuilder.toString()));
              } 
              if (p1.k == null)
                p1.k = new Bundle(); 
              a(p1.k, "android:target_state", g2.r);
              if (g2.t != 0)
                p1.k.putInt("android:target_req_state", g2.t); 
            } 
          } else {
            p1.k = g2.l;
          } 
          if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Saved state of ");
            stringBuilder.append(g2);
            stringBuilder.append(": ");
            stringBuilder.append(p1.k);
            Log.v("FragmentManager", stringBuilder.toString());
          } 
          bool = true;
        } 
        b2++;
      } 
      if (!bool) {
        if (a)
          Log.v("FragmentManager", "saveAllState: no fragments!"); 
        return null;
      } 
      int i2 = this.e.size();
      if (i2 > 0) {
        object = new int[i2];
        for (byte b3 = 0; b3 < i2; b3++) {
          object[b3] = ((g)this.e.get(b3)).o;
          if (object[b3] < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failure saving state: active ");
            stringBuilder.append(this.e.get(b3));
            stringBuilder.append(" has cleared index: ");
            stringBuilder.append(object[b3]);
            a(new IllegalStateException(stringBuilder.toString()));
          } 
          if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("saveAllState: adding fragment #");
            stringBuilder.append(b3);
            stringBuilder.append(": ");
            stringBuilder.append(this.e.get(b3));
            Log.v("FragmentManager", stringBuilder.toString());
          } 
        } 
      } else {
        object = null;
      } 
      ArrayList arrayList = this.g;
      d[] arrayOfd = null;
      if (arrayList != null) {
        int i3 = arrayList.size();
        arrayOfd = null;
        if (i3 > 0) {
          arrayOfd = new d[i3];
          while (b1 < i3) {
            arrayOfd[b1] = new d((c)this.g.get(b1));
            if (a) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("saveAllState: adding back stack #");
              stringBuilder.append(b1);
              stringBuilder.append(": ");
              stringBuilder.append(this.g.get(b1));
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            b1++;
          } 
        } 
      } 
      o o1 = new o();
      o1.a = arrayOfp;
      o1.b = object;
      o1.c = arrayOfd;
      g g1 = this.p;
      if (g1 != null)
        o1.d = g1.o; 
      o1.e = this.d;
      k();
      return o1;
    } 
    return null;
  }
  
  public void l(g paramg) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("attach: ");
      stringBuilder.append(paramg);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (paramg.L) {
      paramg.L = false;
      if (!paramg.u)
        if (!this.e.contains(paramg)) {
          if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add from attach: ");
            stringBuilder.append(paramg);
            Log.v("FragmentManager", stringBuilder.toString());
          } 
          synchronized (this.e) {
            this.e.add(paramg);
            paramg.u = true;
            if (paramg.O && paramg.P) {
              this.r = true;
              return;
            } 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Fragment already added: ");
          stringBuilder.append(paramg);
          throw new IllegalStateException(stringBuilder.toString());
        }  
    } 
  }
  
  public void m() {
    this.D = null;
    byte b1 = 0;
    this.s = false;
    this.t = false;
    int i1 = this.e.size();
    while (b1 < i1) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null)
        g1.J(); 
      b1++;
    } 
  }
  
  void m(g paramg) {
    if (paramg.T == null)
      return; 
    SparseArray sparseArray = this.B;
    if (sparseArray == null) {
      this.B = new SparseArray();
    } else {
      sparseArray.clear();
    } 
    paramg.T.saveHierarchyState(this.B);
    if (this.B.size() > 0) {
      paramg.m = this.B;
      this.B = null;
    } 
  }
  
  Bundle n(g paramg) {
    Bundle bundle;
    if (this.A == null)
      this.A = new Bundle(); 
    paramg.n(this.A);
    d(paramg, this.A, false);
    if (!this.A.isEmpty()) {
      bundle = this.A;
      this.A = null;
    } else {
      bundle = null;
    } 
    if (paramg.S != null)
      m(paramg); 
    if (paramg.m != null) {
      if (bundle == null)
        bundle = new Bundle(); 
      bundle.putSparseParcelableArray("android:view_state", paramg.m);
    } 
    if (!paramg.V) {
      if (bundle == null)
        bundle = new Bundle(); 
      bundle.putBoolean("android:user_visible_hint", paramg.V);
    } 
    return bundle;
  }
  
  public void n() {
    this.s = false;
    this.t = false;
    e(1);
  }
  
  public void o() {
    this.s = false;
    this.t = false;
    e(2);
  }
  
  public void o(g paramg) {
    if (paramg == null || (this.f.get(paramg.o) == paramg && (paramg.C == null || paramg.n() == this))) {
      this.p = paramg;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(paramg);
    stringBuilder.append(" is not an active fragment of FragmentManager ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    if (!"fragment".equals(paramString))
      return null; 
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, g.a);
    if (str1 == null)
      str1 = typedArray.getString(0); 
    String str2 = str1;
    int i1 = typedArray.getResourceId(1, -1);
    String str3 = typedArray.getString(2);
    typedArray.recycle();
    if (!g.a(this.m.g(), str2))
      return null; 
    int i2 = 0;
    if (paramView != null)
      i2 = paramView.getId(); 
    if (i2 != -1 || i1 != -1 || str3 != null) {
      g g2;
      g g1;
      if (i1 != -1) {
        g1 = b(i1);
      } else {
        g1 = null;
      } 
      if (g1 == null && str3 != null)
        g1 = a(str3); 
      if (g1 == null && i2 != -1)
        g1 = b(i2); 
      if (a) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("onCreateView: id=0x");
        stringBuilder2.append(Integer.toHexString(i1));
        stringBuilder2.append(" fname=");
        stringBuilder2.append(str2);
        stringBuilder2.append(" existing=");
        stringBuilder2.append(g1);
        Log.v("FragmentManager", stringBuilder2.toString());
      } 
      if (g1 == null) {
        int i3;
        g g3 = this.n.a(paramContext, str2, null);
        g3.w = true;
        if (i1 != 0) {
          i3 = i1;
        } else {
          i3 = i2;
        } 
        g3.H = i3;
        g3.I = i2;
        g3.J = str3;
        g3.x = true;
        g3.B = this;
        k k1 = this.m;
        g3.C = k1;
        g3.a(k1.g(), paramAttributeSet, g3.l);
        a(g3, true);
        g2 = g3;
      } else if (!g1.x) {
        g1.x = true;
        g1.C = this.m;
        if (!g1.N)
          g1.a(this.m.g(), paramAttributeSet, g1.l); 
        g2 = g1;
      } else {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramAttributeSet.getPositionDescription());
        stringBuilder2.append(": Duplicate id 0x");
        stringBuilder2.append(Integer.toHexString(i1));
        stringBuilder2.append(", tag ");
        stringBuilder2.append(str3);
        stringBuilder2.append(", or parent id 0x");
        stringBuilder2.append(Integer.toHexString(i2));
        stringBuilder2.append(" with another fragment for ");
        stringBuilder2.append(str2);
        throw new IllegalArgumentException(stringBuilder2.toString());
      } 
      if (this.l < 1 && g2.w) {
        a(g2, 1, 0, 0, false);
      } else {
        b(g2);
      } 
      if (g2.S != null) {
        if (i1 != 0)
          g2.S.setId(i1); 
        if (g2.S.getTag() == null)
          g2.S.setTag(str3); 
        return g2.S;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Fragment ");
      stringBuilder1.append(str2);
      stringBuilder1.append(" did not create a view.");
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramAttributeSet.getPositionDescription());
    stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
    stringBuilder.append(str2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) { return onCreateView(null, paramString, paramContext, paramAttributeSet); }
  
  public void p() {
    this.s = false;
    this.t = false;
    e(3);
  }
  
  public void q() {
    this.s = false;
    this.t = false;
    e(4);
  }
  
  public void r() { e(3); }
  
  public void s() {
    this.t = true;
    e(2);
  }
  
  public void t() { e(1); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    k k1 = this.o;
    if (k1 == null)
      k1 = this.m; 
    d.a(k1, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  public void u() {
    this.u = true;
    g();
    e(0);
    this.m = null;
    this.n = null;
    this.o = null;
  }
  
  public void v() {
    for (byte b1 = 0; b1 < this.e.size(); b1++) {
      g g1 = (g)this.e.get(b1);
      if (g1 != null)
        g1.K(); 
    } 
  }
  
  public g w() { return this.p; }
  
  LayoutInflater.Factory2 x() { return this; }
  
  private static class a extends b {
    View a;
    
    a(View param1View, Animation.AnimationListener param1AnimationListener) {
      super(param1AnimationListener);
      this.a = param1View;
    }
    
    public void onAnimationEnd(Animation param1Animation) {
      if (r.A(this.a) || Build.VERSION.SDK_INT >= 24) {
        this.a.post(new Runnable(this) {
              public void run() { this.a.a.setLayerType(0, null); }
            });
      } else {
        this.a.setLayerType(0, null);
      } 
      super.onAnimationEnd(param1Animation);
    }
  }
  
  class null implements Runnable {
    null(m this$0) {}
    
    public void run() { this.a.a.setLayerType(0, null); }
  }
  
  private static class b implements Animation.AnimationListener {
    private final Animation.AnimationListener a;
    
    b(Animation.AnimationListener param1AnimationListener) { this.a = param1AnimationListener; }
    
    public void onAnimationEnd(Animation param1Animation) {
      Animation.AnimationListener animationListener = this.a;
      if (animationListener != null)
        animationListener.onAnimationEnd(param1Animation); 
    }
    
    public void onAnimationRepeat(Animation param1Animation) {
      Animation.AnimationListener animationListener = this.a;
      if (animationListener != null)
        animationListener.onAnimationRepeat(param1Animation); 
    }
    
    public void onAnimationStart(Animation param1Animation) {
      Animation.AnimationListener animationListener = this.a;
      if (animationListener != null)
        animationListener.onAnimationStart(param1Animation); 
    }
  }
  
  private static class c {
    public final Animation a = null;
    
    public final Animator b;
    
    c(Animator param1Animator) {
      this.b = param1Animator;
      if (param1Animator != null)
        return; 
      throw new IllegalStateException("Animator cannot be null");
    }
    
    c(Animation param1Animation) {
      this.b = null;
      if (param1Animation != null)
        return; 
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  private static class d extends AnimatorListenerAdapter {
    View a;
    
    d(View param1View) { this.a = param1View; }
    
    public void onAnimationEnd(Animator param1Animator) {
      this.a.setLayerType(0, null);
      param1Animator.removeListener(this);
    }
    
    public void onAnimationStart(Animator param1Animator) { this.a.setLayerType(2, null); }
  }
  
  private static class e extends AnimationSet implements Runnable {
    private final ViewGroup a;
    
    private final View b;
    
    private boolean c;
    
    private boolean d;
    
    private boolean e = true;
    
    e(Animation param1Animation, ViewGroup param1ViewGroup, View param1View) {
      super(false);
      this.a = param1ViewGroup;
      this.b = param1View;
      addAnimation(param1Animation);
      this.a.post(this);
    }
    
    public boolean getTransformation(long param1Long, Transformation param1Transformation) {
      this.e = true;
      if (this.c)
        return true ^ this.d; 
      if (!super.getTransformation(param1Long, param1Transformation)) {
        this.c = true;
        aa.a(this.a, this);
      } 
      return true;
    }
    
    public boolean getTransformation(long param1Long, Transformation param1Transformation, float param1Float) {
      this.e = true;
      if (this.c)
        return true ^ this.d; 
      if (!super.getTransformation(param1Long, param1Transformation, param1Float)) {
        this.c = true;
        aa.a(this.a, this);
      } 
      return true;
    }
    
    public void run() {
      if (!this.c && this.e) {
        this.e = false;
        this.a.post(this);
        return;
      } 
      this.a.endViewTransition(this.b);
      this.d = true;
    }
  }
  
  private static final class f {
    final l.a a;
    
    final boolean b;
  }
  
  static class g {
    public static final int[] a = { 16842755, 16842960, 16842961 };
  }
  
  static interface h {
    boolean a(ArrayList<c> param1ArrayList1, ArrayList<Boolean> param1ArrayList2);
  }
  
  private class i implements h {
    final String a;
    
    final int b;
    
    final int c;
    
    i(m this$0, String param1String, int param1Int1, int param1Int2) {
      this.a = param1String;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public boolean a(ArrayList<c> param1ArrayList1, ArrayList<Boolean> param1ArrayList2) {
      if (this.d.p != null && this.b < 0 && this.a == null) {
        l l = this.d.p.p();
        if (l != null && l.b())
          return false; 
      } 
      return this.d.a(param1ArrayList1, param1ArrayList2, this.a, this.b, this.c);
    }
  }
  
  static class j implements g.c {
    final boolean a;
    
    final c b;
    
    private int c;
    
    j(c param1c, boolean param1Boolean) {
      this.a = param1Boolean;
      this.b = param1c;
    }
    
    public void a() {
      this.c = -1 + this.c;
      if (this.c != 0)
        return; 
      this.b.a.f();
    }
    
    public void b() { this.c = 1 + this.c; }
    
    public boolean c() { return (this.c == 0); }
    
    public void d() {
      boolean bool;
      int i = this.c;
      byte b1 = 0;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      m m = this.b.a;
      int k = m.e.size();
      while (b1 < k) {
        g g = (g)m.e.get(b1);
        g.a(null);
        if (bool && g.Y())
          g.E(); 
        b1++;
      } 
      this.b.a.a(this.b, this.a, bool ^ true, true);
    }
    
    public void e() { this.b.a.a(this.b, this.a, false, false); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */