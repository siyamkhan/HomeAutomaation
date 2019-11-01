package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.d.c;
import android.support.v4.g.k;
import android.support.v4.h.a;
import android.support.v4.h.a.a;
import android.support.v4.h.a.c;
import android.support.v4.h.k;
import android.support.v4.h.l;
import android.support.v4.h.r;
import android.support.v4.h.s;
import android.support.v7.e.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements k {
  static final Interpolator L;
  
  private static final int[] M;
  
  private static final int[] N;
  
  private static final boolean O;
  
  private static final boolean P;
  
  private static final Class<?>[] Q;
  
  static final boolean a;
  
  static final boolean b;
  
  static final boolean c;
  
  static final boolean d;
  
  final w A;
  
  aq B;
  
  aq.a C;
  
  final u D;
  
  boolean E;
  
  boolean F;
  
  boolean G;
  
  ay H;
  
  final int[] I;
  
  final int[] J;
  
  final List<x> K;
  
  private final r R = new r(this);
  
  private s S;
  
  private final Rect T = new Rect();
  
  private final ArrayList<m> U = new ArrayList();
  
  private m V;
  
  private int W = 0;
  
  private List<n> aA;
  
  private f.b aB;
  
  private d aC;
  
  private final int[] aD;
  
  private l aE;
  
  private final int[] aF;
  
  private final int[] aG;
  
  private Runnable aH;
  
  private final bt.b aI;
  
  private boolean aa;
  
  private int ab;
  
  private final AccessibilityManager ac;
  
  private List<k> ad;
  
  private int ae = 0;
  
  private int af = 0;
  
  private e ag = new e();
  
  private EdgeEffect ah;
  
  private EdgeEffect ai;
  
  private EdgeEffect aj;
  
  private EdgeEffect ak;
  
  private int al = 0;
  
  private int am = -1;
  
  private VelocityTracker an;
  
  private int ao;
  
  private int ap;
  
  private int aq;
  
  private int ar;
  
  private int as;
  
  private l at;
  
  private final int au;
  
  private final int av;
  
  private float aw = Float.MIN_VALUE;
  
  private float ax = Float.MIN_VALUE;
  
  private boolean ay;
  
  private n az;
  
  final p e = new p(this);
  
  e f;
  
  ah g;
  
  final bt h = new bt();
  
  boolean i;
  
  final Runnable j = new Runnable(this) {
      public void run() {
        if (this.a.t) {
          if (this.a.isLayoutRequested())
            return; 
          if (!this.a.q) {
            this.a.requestLayout();
            return;
          } 
          if (this.a.v) {
            this.a.u = true;
            return;
          } 
          this.a.d();
        } 
      }
    };
  
  final Rect k = new Rect();
  
  final RectF l = new RectF();
  
  a m;
  
  i n;
  
  q o;
  
  final ArrayList<h> p = new ArrayList();
  
  boolean q;
  
  boolean r;
  
  boolean s;
  
  boolean t;
  
  boolean u;
  
  boolean v;
  
  boolean w;
  
  boolean x = false;
  
  boolean y = false;
  
  f z = new ak();
  
  static  {
    boolean bool6;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    M = new int[] { 16843830 };
    N = new int[] { 16842987 };
    if (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    a = bool1;
    if (Build.VERSION.SDK_INT >= 23) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    b = bool2;
    if (Build.VERSION.SDK_INT >= 16) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    c = bool3;
    if (Build.VERSION.SDK_INT >= 21) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    d = bool4;
    if (Build.VERSION.SDK_INT <= 15) {
      bool5 = true;
    } else {
      bool5 = false;
    } 
    O = bool5;
    if (Build.VERSION.SDK_INT <= 15) {
      bool6 = true;
    } else {
      bool6 = false;
    } 
    P = bool6;
    Class[] arrayOfClass = new Class[4];
    arrayOfClass[0] = Context.class;
    arrayOfClass[1] = AttributeSet.class;
    arrayOfClass[2] = int.class;
    arrayOfClass[3] = int.class;
    Q = arrayOfClass;
    L = new Interpolator() {
        public float getInterpolation(float param1Float) {
          float f = param1Float - 1.0F;
          return 1.0F + f * f * f * f * f;
        }
      };
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool1 = true;
    this.ay = bool1;
    this.A = new w(this);
    if (d) {
      object = new aq.a();
    } else {
      object = null;
    } 
    this.C = object;
    this.D = new u();
    this.E = false;
    this.F = false;
    this.aB = new g(this);
    this.G = false;
    this.aD = new int[2];
    this.aF = new int[2];
    this.I = new int[2];
    this.aG = new int[2];
    this.J = new int[2];
    this.K = new ArrayList();
    this.aH = new Runnable(this) {
        public void run() {
          if (this.a.z != null)
            this.a.z.a(); 
          this.a.G = false;
        }
      };
    this.aI = new bt.b(this) {
        public void a(RecyclerView.x param1x) { this.a.n.a(param1x.a, this.a.e); }
        
        public void a(RecyclerView.x param1x, RecyclerView.f.c param1c1, RecyclerView.f.c param1c2) {
          this.a.e.c(param1x);
          this.a.b(param1x, param1c1, param1c2);
        }
        
        public void b(RecyclerView.x param1x, RecyclerView.f.c param1c1, RecyclerView.f.c param1c2) { this.a.a(param1x, param1c1, param1c2); }
        
        public void c(RecyclerView.x param1x, RecyclerView.f.c param1c1, RecyclerView.f.c param1c2) {
          param1x.a(false);
          if (this.a.x ? this.a.z.a(param1x, param1x, param1c1, param1c2) : this.a.z.c(param1x, param1c1, param1c2))
            this.a.p(); 
        }
      };
    if (paramAttributeSet != null) {
      TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, N, paramInt, 0);
      this.i = typedArray.getBoolean(0, bool1);
      typedArray.recycle();
    } else {
      this.i = bool1;
    } 
    setScrollContainer(bool1);
    setFocusableInTouchMode(bool1);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.as = viewConfiguration.getScaledTouchSlop();
    this.aw = s.a(viewConfiguration, paramContext);
    this.ax = s.b(viewConfiguration, paramContext);
    this.au = viewConfiguration.getScaledMinimumFlingVelocity();
    this.av = viewConfiguration.getScaledMaximumFlingVelocity();
    if (getOverScrollMode() == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    setWillNotDraw(bool2);
    this.z.a(this.aB);
    b();
    z();
    y();
    if (r.e(this) == 0)
      r.b(this, bool1); 
    this.ac = (AccessibilityManager)getContext().getSystemService("accessibility");
    setAccessibilityDelegateCompat(new ay(this));
    if (paramAttributeSet != null) {
      TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.b.RecyclerView, paramInt, 0);
      String str = typedArray.getString(a.b.RecyclerView_layoutManager);
      if (typedArray.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1)
        setDescendantFocusability(262144); 
      this.s = typedArray.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
      if (this.s)
        a((StateListDrawable)typedArray.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), typedArray.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)typedArray.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), typedArray.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable)); 
      typedArray.recycle();
      a(paramContext, str, paramAttributeSet, paramInt, 0);
      if (Build.VERSION.SDK_INT >= 21) {
        TypedArray typedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, M, paramInt, 0);
        boolean bool = typedArray1.getBoolean(0, bool1);
        typedArray1.recycle();
        bool1 = bool;
      } 
    } else {
      setDescendantFocusability(262144);
    } 
    setNestedScrollingEnabled(bool1);
  }
  
  private boolean A() {
    int i1 = this.g.b();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x1 = e(this.g.b(b1));
      if (x1 != null && !x1.c() && x1.z())
        return true; 
    } 
    return false;
  }
  
  private void B() {
    this.A.b();
    i i1 = this.n;
    if (i1 != null)
      i1.H(); 
  }
  
  private void C() {
    boolean bool;
    EdgeEffect edgeEffect1 = this.ah;
    if (edgeEffect1 != null) {
      edgeEffect1.onRelease();
      bool = this.ah.isFinished();
    } else {
      bool = false;
    } 
    EdgeEffect edgeEffect2 = this.ai;
    if (edgeEffect2 != null) {
      edgeEffect2.onRelease();
      bool |= this.ai.isFinished();
    } 
    EdgeEffect edgeEffect3 = this.aj;
    if (edgeEffect3 != null) {
      edgeEffect3.onRelease();
      bool |= this.aj.isFinished();
    } 
    EdgeEffect edgeEffect4 = this.ak;
    if (edgeEffect4 != null) {
      edgeEffect4.onRelease();
      bool |= this.ak.isFinished();
    } 
    if (bool)
      r.d(this); 
  }
  
  private void D() {
    VelocityTracker velocityTracker = this.an;
    if (velocityTracker != null)
      velocityTracker.clear(); 
    a(0);
    C();
  }
  
  private void E() {
    D();
    setScrollState(0);
  }
  
  private void F() {
    int i1 = this.ab;
    this.ab = 0;
    if (i1 != 0 && n()) {
      AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
      accessibilityEvent.setEventType(2048);
      a.a(accessibilityEvent, i1);
      sendAccessibilityEventUnchecked(accessibilityEvent);
    } 
  }
  
  private boolean G() { return (this.z != null && this.n.b()); }
  
  private void H() {
    boolean bool2;
    boolean bool1;
    if (this.x) {
      this.f.a();
      if (this.y)
        this.n.a(this); 
    } 
    if (G()) {
      this.f.b();
    } else {
      this.f.e();
    } 
    if (this.E || this.F) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    u u1 = this.D;
    if (this.t && this.z != null && (this.x || bool1 || this.n.u) && (!this.x || this.m.b())) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    u1.j = bool2;
    u u2 = this.D;
    boolean bool = u2.j;
    boolean bool3 = false;
    if (bool) {
      bool3 = false;
      if (bool1) {
        boolean bool4 = this.x;
        bool3 = false;
        if (!bool4) {
          boolean bool5 = G();
          bool3 = false;
          if (bool5)
            bool3 = true; 
        } 
      } 
    } 
    u2.k = bool3;
  }
  
  private void I() {
    int i1;
    long l1;
    x x1;
    View view;
    if (this.ay && hasFocus() && this.m != null) {
      view = getFocusedChild();
    } else {
      view = null;
    } 
    if (view == null) {
      x1 = null;
    } else {
      x1 = d(view);
    } 
    if (x1 == null) {
      J();
      return;
    } 
    u u1 = this.D;
    if (this.m.b()) {
      l1 = x1.g();
    } else {
      l1 = -1L;
    } 
    u1.m = l1;
    u u2 = this.D;
    if (this.x) {
      i1 = -1;
    } else if (x1.q()) {
      i1 = x1.d;
    } else {
      i1 = x1.e();
    } 
    u2.l = i1;
    this.D.n = m(x1.a);
  }
  
  private void J() {
    u u1 = this.D;
    u1.m = -1L;
    u1.l = -1;
    u1.n = -1;
  }
  
  private View K() {
    byte b1;
    if (this.D.l != -1) {
      b1 = this.D.l;
    } else {
      b1 = 0;
    } 
    int i1 = this.D.e();
    for (byte b2 = b1; b2 < i1; b2++) {
      x x1 = c(b2);
      if (x1 == null)
        break; 
      if (x1.a.hasFocusable())
        return x1.a; 
    } 
    for (int i2 = -1 + Math.min(i1, b1); i2 >= 0; i2--) {
      x x1 = c(i2);
      if (x1 == null)
        return null; 
      if (x1.a.hasFocusable())
        return x1.a; 
    } 
    return null;
  }
  
  private void L() {
    View view;
    if (this.ay && this.m != null && hasFocus() && getDescendantFocusability() != 393216) {
      View view1;
      Object object;
      if (getDescendantFocusability() == 131072 && isFocused())
        return; 
      if (!isFocused()) {
        View view2 = getFocusedChild();
        if (P && (view2.getParent() == null || !view2.hasFocus())) {
          if (this.g.b() == 0) {
            requestFocus();
            return;
          } 
        } else if (!this.g.c(view2)) {
          return;
        } 
      } 
      if (this.D.m != -1L && this.m.b()) {
        object = a(this.D.m);
      } else {
        object = null;
      } 
      if (object == null || this.g.c(object.a) || !object.a.hasFocusable()) {
        int i1 = this.g.b();
        view1 = null;
        if (i1 > 0)
          view1 = K(); 
      } else {
        view1 = object.a;
      } 
      if (view1 != null) {
        if (this.D.n != -1L) {
          View view2 = view1.findViewById(this.D.n);
          if (view2 != null && view2.isFocusable()) {
            view2.requestFocus();
            return;
          } 
        } 
        view = view1;
      } else {
        return;
      } 
    } else {
      return;
    } 
    view.requestFocus();
  }
  
  private void M() {
    u u1 = this.D;
    byte b1 = 1;
    u1.a(b1);
    a(this.D);
    this.D.i = false;
    e();
    this.h.a();
    l();
    H();
    I();
    u u2 = this.D;
    if (!u2.j || !this.F)
      b1 = 0; 
    u2.h = b1;
    this.F = false;
    this.E = false;
    u u3 = this.D;
    u3.g = u3.k;
    this.D.e = this.m.a();
    a(this.aD);
    if (this.D.j) {
      int i1 = this.g.b();
      for (byte b2 = 0; b2 < i1; b2++) {
        x x1 = e(this.g.b(b2));
        if (!x1.c() && (!x1.n() || this.m.b())) {
          f.c c1 = this.z.a(this.D, x1, f.e(x1), x1.u());
          this.h.a(x1, c1);
          if (this.D.h && x1.z() && !x1.q() && !x1.c() && !x1.n()) {
            long l1 = a(x1);
            this.h.a(l1, x1);
          } 
        } 
      } 
    } 
    if (this.D.k) {
      s();
      boolean bool = this.D.f;
      u u4 = this.D;
      u4.f = false;
      this.n.c(this.e, u4);
      this.D.f = bool;
      for (byte b2 = 0; b2 < this.g.b(); b2++) {
        x x1 = e(this.g.b(b2));
        if (!x1.c() && !this.h.d(x1)) {
          int i1 = f.e(x1);
          boolean bool1 = x1.a(8192);
          if (!bool1)
            i1 |= 0x1000; 
          f.c c1 = this.z.a(this.D, x1, i1, x1.u());
          if (bool1) {
            a(x1, c1);
          } else {
            this.h.b(x1, c1);
          } 
        } 
      } 
    } 
    t();
    m();
    a(false);
    this.D.d = 2;
  }
  
  private void N() {
    boolean bool;
    e();
    l();
    this.D.a(6);
    this.f.e();
    this.D.e = this.m.a();
    u u1 = this.D;
    u1.c = 0;
    u1.g = false;
    this.n.c(this.e, u1);
    u u2 = this.D;
    u2.f = false;
    this.S = null;
    if (u2.j && this.z != null) {
      bool = true;
    } else {
      bool = false;
    } 
    u2.j = bool;
    this.D.d = 4;
    m();
    a(false);
  }
  
  private void O() {
    this.D.a(4);
    e();
    l();
    u u1 = this.D;
    u1.d = 1;
    if (u1.j) {
      for (int i1 = this.g.b() - 1; i1 >= 0; i1--) {
        x x1 = e(this.g.b(i1));
        if (x1.c())
          continue; 
        long l1 = a(x1);
        f.c c1 = this.z.a(this.D, x1);
        x x2 = this.h.a(l1);
        if (x2 != null && !x2.c()) {
          boolean bool1 = this.h.a(x2);
          boolean bool2 = this.h.a(x1);
          if (!bool1 || x2 != x1) {
            f.c c2 = this.h.b(x2);
            this.h.c(x1, c1);
            f.c c3 = this.h.c(x1);
            if (c2 == null) {
              a(l1, x1, x2);
            } else {
              a(x2, x1, c2, c3, bool1, bool2);
            } 
            continue;
          } 
        } 
        this.h.c(x1, c1);
        continue;
      } 
      this.h.a(this.aI);
    } 
    this.n.b(this.e);
    u u2 = this.D;
    u2.b = u2.e;
    this.x = false;
    this.y = false;
    u u3 = this.D;
    u3.j = false;
    u3.k = false;
    this.n.u = false;
    if (this.e.b != null)
      this.e.b.clear(); 
    if (this.n.y) {
      i i1 = this.n;
      i1.x = 0;
      i1.y = false;
      this.e.b();
    } 
    this.n.a(this.D);
    m();
    a(false);
    this.h.a();
    int[] arrayOfInt = this.aD;
    if (k(arrayOfInt[0], arrayOfInt[1]))
      i(0, 0); 
    L();
    J();
  }
  
  private String a(Context paramContext, String paramString) {
    if (paramString.charAt(0) == '.') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramContext.getPackageName());
      stringBuilder1.append(paramString);
      return stringBuilder1.toString();
    } 
    if (paramString.contains("."))
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RecyclerView.class.getPackage().getName());
    stringBuilder.append('.');
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) { // Byte code:
    //   0: iconst_1
    //   1: istore #5
    //   3: fload_2
    //   4: fconst_0
    //   5: fcmpg
    //   6: ifge -> 55
    //   9: aload_0
    //   10: invokevirtual g : ()V
    //   13: aload_0
    //   14: getfield ah : Landroid/widget/EdgeEffect;
    //   17: astore #7
    //   19: fload_2
    //   20: fneg
    //   21: aload_0
    //   22: invokevirtual getWidth : ()I
    //   25: i2f
    //   26: fdiv
    //   27: fstore #8
    //   29: fconst_1
    //   30: fload_3
    //   31: aload_0
    //   32: invokevirtual getHeight : ()I
    //   35: i2f
    //   36: fdiv
    //   37: fsub
    //   38: fstore #9
    //   40: aload #7
    //   42: fload #8
    //   44: fload #9
    //   46: invokestatic a : (Landroid/widget/EdgeEffect;FF)V
    //   49: iconst_1
    //   50: istore #6
    //   52: goto -> 95
    //   55: fload_2
    //   56: fconst_0
    //   57: fcmpl
    //   58: ifle -> 92
    //   61: aload_0
    //   62: invokevirtual h : ()V
    //   65: aload_0
    //   66: getfield aj : Landroid/widget/EdgeEffect;
    //   69: astore #7
    //   71: fload_2
    //   72: aload_0
    //   73: invokevirtual getWidth : ()I
    //   76: i2f
    //   77: fdiv
    //   78: fstore #8
    //   80: fload_3
    //   81: aload_0
    //   82: invokevirtual getHeight : ()I
    //   85: i2f
    //   86: fdiv
    //   87: fstore #9
    //   89: goto -> 40
    //   92: iconst_0
    //   93: istore #6
    //   95: fload #4
    //   97: fconst_0
    //   98: fcmpg
    //   99: ifge -> 132
    //   102: aload_0
    //   103: invokevirtual i : ()V
    //   106: aload_0
    //   107: getfield ai : Landroid/widget/EdgeEffect;
    //   110: fload #4
    //   112: fneg
    //   113: aload_0
    //   114: invokevirtual getHeight : ()I
    //   117: i2f
    //   118: fdiv
    //   119: fload_1
    //   120: aload_0
    //   121: invokevirtual getWidth : ()I
    //   124: i2f
    //   125: fdiv
    //   126: invokestatic a : (Landroid/widget/EdgeEffect;FF)V
    //   129: goto -> 174
    //   132: fload #4
    //   134: fconst_0
    //   135: fcmpl
    //   136: ifle -> 170
    //   139: aload_0
    //   140: invokevirtual j : ()V
    //   143: aload_0
    //   144: getfield ak : Landroid/widget/EdgeEffect;
    //   147: fload #4
    //   149: aload_0
    //   150: invokevirtual getHeight : ()I
    //   153: i2f
    //   154: fdiv
    //   155: fconst_1
    //   156: fload_1
    //   157: aload_0
    //   158: invokevirtual getWidth : ()I
    //   161: i2f
    //   162: fdiv
    //   163: fsub
    //   164: invokestatic a : (Landroid/widget/EdgeEffect;FF)V
    //   167: goto -> 174
    //   170: iload #6
    //   172: istore #5
    //   174: iload #5
    //   176: ifne -> 192
    //   179: fload_2
    //   180: fconst_0
    //   181: fcmpl
    //   182: ifne -> 192
    //   185: fload #4
    //   187: fconst_0
    //   188: fcmpl
    //   189: ifeq -> 196
    //   192: aload_0
    //   193: invokestatic d : (Landroid/view/View;)V
    //   196: return }
  
  private void a(long paramLong, x paramx1, x paramx2) {
    int i1 = this.g.b();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x1 = e(this.g.b(b1));
      if (x1 != paramx1 && a(x1) == paramLong) {
        a a1 = this.m;
        if (a1 != null && a1.b()) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          stringBuilder2.append(x1);
          stringBuilder2.append(" \n View Holder 2:");
          stringBuilder2.append(paramx1);
          stringBuilder2.append(a());
          throw new IllegalStateException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        stringBuilder1.append(x1);
        stringBuilder1.append(" \n View Holder 2:");
        stringBuilder1.append(paramx1);
        stringBuilder1.append(a());
        throw new IllegalStateException(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    stringBuilder.append(paramx2);
    stringBuilder.append(" cannot be found but it is necessary for ");
    stringBuilder.append(paramx1);
    stringBuilder.append(a());
    Log.e("RecyclerView", stringBuilder.toString());
  }
  
  private void a(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    if (paramString != null) {
      String str = paramString.trim();
      if (!str.isEmpty()) {
        String str1 = a(paramContext, str);
        try {
          Constructor constructor;
          ClassLoader classLoader;
          if (isInEditMode()) {
            classLoader = getClass().getClassLoader();
          } else {
            classLoader = paramContext.getClassLoader();
          } 
          Class clazz = classLoader.loadClass(str1).asSubclass(i.class);
          Object[] arrayOfObject = null;
          try {
            constructor = clazz.getConstructor(Q);
            Object[] arrayOfObject1 = new Object[4];
            arrayOfObject1[0] = paramContext;
            arrayOfObject1[1] = paramAttributeSet;
            arrayOfObject1[2] = Integer.valueOf(paramInt1);
            arrayOfObject1[3] = Integer.valueOf(paramInt2);
            arrayOfObject = arrayOfObject1;
          } catch (NoSuchMethodException noSuchMethodException) {
            try {
              constructor = clazz.getConstructor(new Class[0]);
              constructor.setAccessible(true);
              setLayoutManager((i)constructor.newInstance(arrayOfObject));
              return;
            } catch (NoSuchMethodException noSuchMethodException1) {
              noSuchMethodException1.initCause(noSuchMethodException);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(paramAttributeSet.getPositionDescription());
              stringBuilder.append(": Error creating LayoutManager ");
              stringBuilder.append(str1);
              throw new IllegalStateException(stringBuilder.toString(), noSuchMethodException1);
            } 
          } 
          constructor.setAccessible(true);
          setLayoutManager((i)constructor.newInstance(arrayOfObject));
          return;
        } catch (ClassNotFoundException classNotFoundException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Unable to find LayoutManager ");
          stringBuilder.append(str1);
          throw new IllegalStateException(stringBuilder.toString(), classNotFoundException);
        } catch (InvocationTargetException invocationTargetException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Could not instantiate the LayoutManager: ");
          stringBuilder.append(str1);
          throw new IllegalStateException(stringBuilder.toString(), invocationTargetException);
        } catch (InstantiationException instantiationException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Could not instantiate the LayoutManager: ");
          stringBuilder.append(str1);
          throw new IllegalStateException(stringBuilder.toString(), instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Cannot access non-public constructor ");
          stringBuilder.append(str1);
          throw new IllegalStateException(stringBuilder.toString(), illegalAccessException);
        } catch (ClassCastException classCastException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Class is not a LayoutManager ");
          stringBuilder.append(str1);
          throw new IllegalStateException(stringBuilder.toString(), classCastException);
        } 
      } 
    } 
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2) {
    a a1 = this.m;
    if (a1 != null) {
      a1.b(this.R);
      this.m.b(this);
    } 
    if (!paramBoolean1 || paramBoolean2)
      c(); 
    this.f.a();
    a a2 = this.m;
    this.m = parama;
    if (parama != null) {
      parama.a(this.R);
      parama.a(this);
    } 
    i i1 = this.n;
    if (i1 != null)
      i1.a(a2, this.m); 
    this.e.a(a2, this.m, paramBoolean1);
    this.D.f = true;
  }
  
  private void a(x paramx1, x paramx2, f.c paramc1, f.c paramc2, boolean paramBoolean1, boolean paramBoolean2) {
    paramx1.a(false);
    if (paramBoolean1)
      e(paramx1); 
    if (paramx1 != paramx2) {
      if (paramBoolean2)
        e(paramx2); 
      paramx1.h = paramx2;
      e(paramx1);
      this.e.c(paramx1);
      paramx2.a(false);
      paramx2.i = paramx1;
    } 
    if (this.z.a(paramx1, paramx2, paramc1, paramc2))
      p(); 
  }
  
  static void a(View paramView, Rect paramRect) {
    j j1 = (j)paramView.getLayoutParams();
    Rect rect = j1.d;
    paramRect.set(paramView.getLeft() - rect.left - j1.leftMargin, paramView.getTop() - rect.top - j1.topMargin, paramView.getRight() + rect.right + j1.rightMargin, paramView.getBottom() + rect.bottom + j1.bottomMargin);
  }
  
  private void a(View paramView1, View paramView2) {
    boolean bool2;
    View view;
    if (paramView2 != null) {
      view = paramView2;
    } else {
      view = paramView1;
    } 
    this.k.set(0, 0, view.getWidth(), view.getHeight());
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (layoutParams instanceof j) {
      j j1 = (j)layoutParams;
      if (!j1.e) {
        Rect rect1 = j1.d;
        Rect rect2 = this.k;
        rect2.left -= rect1.left;
        Rect rect3 = this.k;
        rect3.right += rect1.right;
        Rect rect4 = this.k;
        rect4.top -= rect1.top;
        Rect rect5 = this.k;
        rect5.bottom += rect1.bottom;
      } 
    } 
    if (paramView2 != null) {
      offsetDescendantRectToMyCoords(paramView2, this.k);
      offsetRectIntoDescendantCoords(paramView1, this.k);
    } 
    i i1 = this.n;
    Rect rect = this.k;
    boolean bool1 = true ^ this.t;
    if (paramView2 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    i1.a(this, paramView1, rect, bool1, bool2);
  }
  
  private void a(int[] paramArrayOfInt) {
    int i1 = this.g.b();
    if (i1 == 0) {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    } 
    byte b1 = 0;
    int i2 = Integer.MAX_VALUE;
    int i3 = Integer.MIN_VALUE;
    while (b1 < i1) {
      x x1 = e(this.g.b(b1));
      if (!x1.c()) {
        int i4 = x1.d();
        if (i4 < i2)
          i2 = i4; 
        if (i4 > i3)
          i3 = i4; 
      } 
      b1++;
    } 
    paramArrayOfInt[0] = i2;
    paramArrayOfInt[1] = i3;
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getAction();
    if (i1 == 3 || i1 == 0)
      this.V = null; 
    int i2 = this.U.size();
    for (byte b1 = 0; b1 < i2; b1++) {
      m m1 = (m)this.U.get(b1);
      if (m1.a(this, paramMotionEvent) && i1 != 3) {
        this.V = m1;
        return true;
      } 
    } 
    return false;
  }
  
  private boolean a(View paramView1, View paramView2, int paramInt) {
    boolean bool = false;
    if (paramView2 != null) {
      byte b3;
      byte b2;
      if (paramView2 == this)
        return false; 
      if (c(paramView2) == null)
        return false; 
      if (paramView1 == null)
        return true; 
      if (c(paramView1) == null)
        return true; 
      this.k.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
      this.T.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView1, this.k);
      offsetDescendantRectToMyCoords(paramView2, this.T);
      int i1 = this.n.t();
      byte b1 = -1;
      if (i1 == 1) {
        b2 = -1;
      } else {
        b2 = 1;
      } 
      if ((this.k.left < this.T.left || this.k.right <= this.T.left) && this.k.right < this.T.right) {
        b3 = 1;
      } else if ((this.k.right > this.T.right || this.k.left >= this.T.right) && this.k.left > this.T.left) {
        b3 = -1;
      } else {
        b3 = 0;
      } 
      if ((this.k.top < this.T.top || this.k.bottom <= this.T.top) && this.k.bottom < this.T.bottom) {
        b1 = 1;
      } else if ((this.k.bottom <= this.T.bottom && this.k.top < this.T.bottom) || this.k.top <= this.T.top) {
        b1 = 0;
      } 
      if (paramInt != 17) {
        if (paramInt != 33) {
          if (paramInt != 66) {
            if (paramInt != 130) {
              StringBuilder stringBuilder;
              switch (paramInt) {
                default:
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("Invalid direction: ");
                  stringBuilder.append(paramInt);
                  stringBuilder.append(a());
                  throw new IllegalArgumentException(stringBuilder.toString());
                case 2:
                  if (b1 <= 0) {
                    boolean bool1 = false;
                    if (b1 == 0) {
                      boolean bool2 = b3 * b2;
                      bool1 = false;
                      if (bool2)
                        return true; 
                    } 
                    return bool1;
                  } 
                  return true;
                case 1:
                  break;
              } 
              if (b1 >= 0) {
                boolean bool1 = false;
                if (b1 == 0) {
                  byte b4 = b3 * b2;
                  bool1 = false;
                  if (b4 <= 0)
                    return true; 
                } 
                return bool1;
              } 
            } else {
              boolean bool1 = false;
              if (b1 > 0)
                bool1 = true; 
              return bool1;
            } 
          } else {
            boolean bool1 = false;
            if (b3 > 0)
              bool1 = true; 
            return bool1;
          } 
        } else {
          boolean bool1 = false;
          if (b1 < 0)
            bool1 = true; 
          return bool1;
        } 
      } else {
        bool = false;
        if (b3 < 0)
          bool = true; 
        return bool;
      } 
    } else {
      return bool;
    } 
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getAction();
    m m1 = this.V;
    if (m1 != null)
      if (i1 == 0) {
        this.V = null;
      } else {
        m1.b(this, paramMotionEvent);
        if (i1 == 3 || i1 == 1)
          this.V = null; 
        return true;
      }  
    if (i1 != 0) {
      int i2 = this.U.size();
      for (byte b1 = 0; b1 < i2; b1++) {
        m m2 = (m)this.U.get(b1);
        if (m2.a(this, paramMotionEvent)) {
          this.V = m2;
          return true;
        } 
      } 
    } 
    return false;
  }
  
  static void c(x paramx) {
    if (paramx.b != null) {
      Object object = paramx.b.get();
      label16: while (true) {
        for (View view = (View)object; view != null; view = null) {
          if (view == paramx.a)
            return; 
          object = view.getParent();
          if (object instanceof View)
            continue label16; 
        } 
        break;
      } 
      paramx.b = null;
    } 
  }
  
  private void c(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.am) {
      byte b1;
      if (i1 == 0) {
        b1 = 1;
      } else {
        b1 = 0;
      } 
      this.am = paramMotionEvent.getPointerId(b1);
      int i2 = (int)(0.5F + paramMotionEvent.getX(b1));
      this.aq = i2;
      this.ao = i2;
      int i3 = (int)(0.5F + paramMotionEvent.getY(b1));
      this.ar = i3;
      this.ap = i3;
    } 
  }
  
  static x e(View paramView) { return (paramView == null) ? null : ((j)paramView.getLayoutParams()).c; }
  
  private void e(x paramx) {
    boolean bool;
    View view = paramx.a;
    if (view.getParent() == this) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e.c(b(view));
    if (paramx.r()) {
      this.g.a(view, -1, view.getLayoutParams(), true);
      return;
    } 
    if (!bool) {
      this.g.a(view, true);
      return;
    } 
    this.g.d(view);
  }
  
  private l getScrollingChildHelper() {
    if (this.aE == null)
      this.aE = new l(this); 
    return this.aE;
  }
  
  static RecyclerView j(View paramView) {
    if (!(paramView instanceof ViewGroup))
      return null; 
    if (paramView instanceof RecyclerView)
      return (RecyclerView)paramView; 
    ViewGroup viewGroup = (ViewGroup)paramView;
    int i1 = viewGroup.getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      RecyclerView recyclerView = j(viewGroup.getChildAt(b1));
      if (recyclerView != null)
        return recyclerView; 
    } 
    return null;
  }
  
  private boolean k(int paramInt1, int paramInt2) {
    a(this.aD);
    int[] arrayOfInt = this.aD;
    if (arrayOfInt[0] == paramInt1) {
      int i1 = arrayOfInt[1];
      boolean bool = false;
      return (i1 != paramInt2) ? true : bool;
    } 
    return true;
  }
  
  private int m(View paramView) {
    int i1;
    label11: while (true) {
      i1 = paramView.getId();
      while (!paramView.isFocused() && paramView instanceof ViewGroup && paramView.hasFocus()) {
        paramView = ((ViewGroup)paramView).getFocusedChild();
        if (paramView.getId() != -1)
          continue label11; 
      } 
      break;
    } 
    return i1;
  }
  
  @SuppressLint({"InlinedApi"})
  private void y() {
    if (r.a(this) == 0)
      r.a(this, 8); 
  }
  
  private void z() { this.g = new ah(new ah.b(this) {
          public int a() { return this.a.getChildCount(); }
          
          public int a(View param1View) { return this.a.indexOfChild(param1View); }
          
          public void a(int param1Int) {
            View view = this.a.getChildAt(param1Int);
            if (view != null) {
              this.a.k(view);
              view.clearAnimation();
            } 
            this.a.removeViewAt(param1Int);
          }
          
          public void a(View param1View, int param1Int) {
            this.a.addView(param1View, param1Int);
            this.a.l(param1View);
          }
          
          public void a(View param1View, int param1Int, ViewGroup.LayoutParams param1LayoutParams) {
            RecyclerView.x x = RecyclerView.e(param1View);
            if (x != null)
              if (x.r() || x.c()) {
                x.m();
              } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Called attach on a child which is not detached: ");
                stringBuilder.append(x);
                stringBuilder.append(this.a.a());
                throw new IllegalArgumentException(stringBuilder.toString());
              }  
            RecyclerView.a(this.a, param1View, param1Int, param1LayoutParams);
          }
          
          public RecyclerView.x b(View param1View) { return RecyclerView.e(param1View); }
          
          public View b(int param1Int) { return this.a.getChildAt(param1Int); }
          
          public void b() {
            int i = a();
            for (byte b1 = 0; b1 < i; b1++) {
              View view = b(b1);
              this.a.k(view);
              view.clearAnimation();
            } 
            this.a.removeAllViews();
          }
          
          public void c(int param1Int) {
            View view = b(param1Int);
            if (view != null) {
              RecyclerView.x x = RecyclerView.e(view);
              if (x != null)
                if (!x.r() || x.c()) {
                  x.b(256);
                } else {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("called detach on an already detached child ");
                  stringBuilder.append(x);
                  stringBuilder.append(this.a.a());
                  throw new IllegalArgumentException(stringBuilder.toString());
                }  
            } 
            RecyclerView.a(this.a, param1Int);
          }
          
          public void c(View param1View) {
            RecyclerView.x x = RecyclerView.e(param1View);
            if (x != null)
              x.a(this.a); 
          }
          
          public void d(View param1View) {
            RecyclerView.x x = RecyclerView.e(param1View);
            if (x != null)
              x.b(this.a); 
          }
        }); }
  
  long a(x paramx) { return this.m.b() ? paramx.g() : paramx.c; }
  
  x a(int paramInt, boolean paramBoolean) {
    int i1 = this.g.c();
    x x1 = null;
    for (byte b1 = 0; b1 < i1; b1++) {
      x x2 = e(this.g.d(b1));
      if (x2 != null && !x2.q() && (paramBoolean ? (x2.c != paramInt) : (x2.d() != paramInt)))
        if (this.g.c(x2.a)) {
          x1 = x2;
        } else {
          return x2;
        }  
    } 
    return x1;
  }
  
  public x a(long paramLong) {
    a a1 = this.m;
    x x1 = null;
    if (a1 != null) {
      if (!a1.b())
        return null; 
      int i1 = this.g.c();
      for (byte b1 = 0; b1 < i1; b1++) {
        x x2 = e(this.g.d(b1));
        if (x2 != null && !x2.q() && x2.g() == paramLong)
          if (this.g.c(x2.a)) {
            x1 = x2;
          } else {
            return x2;
          }  
      } 
    } 
    return x1;
  }
  
  String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ");
    stringBuilder.append(toString());
    stringBuilder.append(", adapter:");
    stringBuilder.append(this.m);
    stringBuilder.append(", layout:");
    stringBuilder.append(this.n);
    stringBuilder.append(", context:");
    stringBuilder.append(getContext());
    return stringBuilder.toString();
  }
  
  public void a(int paramInt) { getScrollingChildHelper().c(paramInt); }
  
  public void a(int paramInt1, int paramInt2) { a(paramInt1, paramInt2, null); }
  
  public void a(int paramInt1, int paramInt2, Interpolator paramInterpolator) {
    i i1 = this.n;
    if (i1 == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    if (this.v)
      return; 
    if (!i1.e())
      paramInt1 = 0; 
    if (!this.n.f())
      paramInt2 = 0; 
    if (paramInt1 != 0 || paramInt2 != 0)
      this.A.a(paramInt1, paramInt2, paramInterpolator); 
  }
  
  void a(int paramInt1, int paramInt2, Object paramObject) {
    int i1 = this.g.c();
    int i2 = paramInt1 + paramInt2;
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = this.g.d(b1);
      x x1 = e(view);
      if (x1 != null && !x1.c() && x1.c >= paramInt1 && x1.c < i2) {
        x1.b(2);
        x1.a(paramObject);
        ((j)view.getLayoutParams()).e = true;
      } 
    } 
    this.e.c(paramInt1, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    int i1 = paramInt1 + paramInt2;
    int i2 = this.g.c();
    for (byte b1 = 0; b1 < i2; b1++) {
      x x1 = e(this.g.d(b1));
      if (x1 != null && !x1.c()) {
        if (x1.c >= i1) {
          x1.a(-paramInt2, paramBoolean);
        } else if (x1.c >= paramInt1) {
          x1.a(paramInt1 - 1, -paramInt2, paramBoolean);
        } else {
          continue;
        } 
        this.D.f = true;
      } 
      continue;
    } 
    this.e.a(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfInt) {
    boolean bool2;
    boolean bool1;
    e();
    l();
    c.a("RV Scroll");
    a(this.D);
    if (paramInt1 != 0) {
      bool1 = this.n.a(paramInt1, this.e, this.D);
    } else {
      bool1 = false;
    } 
    if (paramInt2 != 0) {
      bool2 = this.n.b(paramInt2, this.e, this.D);
    } else {
      bool2 = false;
    } 
    c.a();
    w();
    m();
    a(false);
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = bool1;
      paramArrayOfInt[1] = bool2;
    } 
  }
  
  void a(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2) {
    if (paramStateListDrawable1 != null && paramDrawable1 != null && paramStateListDrawable2 != null && paramDrawable2 != null) {
      Resources resources = getContext().getResources();
      new an(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, resources.getDimensionPixelSize(a.a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.a.fastscroll_margin));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Trying to set fast scroller without both required drawables.");
    stringBuilder.append(a());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void a(h paramh) { a(paramh, -1); }
  
  public void a(h paramh, int paramInt) {
    i i1 = this.n;
    if (i1 != null)
      i1.a("Cannot add item decoration during a scroll  or layout"); 
    if (this.p.isEmpty())
      setWillNotDraw(false); 
    if (paramInt < 0) {
      this.p.add(paramh);
    } else {
      this.p.add(paramInt, paramh);
    } 
    r();
    requestLayout();
  }
  
  public void a(m paramm) { this.U.add(paramm); }
  
  public void a(n paramn) {
    if (this.aA == null)
      this.aA = new ArrayList(); 
    this.aA.add(paramn);
  }
  
  final void a(u paramu) {
    if (getScrollState() == 2) {
      OverScroller overScroller = this.A.a;
      paramu.o = overScroller.getFinalX() - overScroller.getCurrX();
      paramu.p = overScroller.getFinalY() - overScroller.getCurrY();
      return;
    } 
    paramu.o = 0;
    paramu.p = 0;
  }
  
  void a(x paramx, f.c paramc) {
    paramx.a(0, 8192);
    if (this.D.h && paramx.z() && !paramx.q() && !paramx.c()) {
      long l1 = a(paramx);
      this.h.a(l1, paramx);
    } 
    this.h.a(paramx, paramc);
  }
  
  void a(x paramx, f.c paramc1, f.c paramc2) {
    paramx.a(false);
    if (this.z.b(paramx, paramc1, paramc2))
      p(); 
  }
  
  void a(String paramString) {
    if (o()) {
      if (paramString == null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        stringBuilder.append(a());
        throw new IllegalStateException(stringBuilder.toString());
      } 
      throw new IllegalStateException(paramString);
    } 
    if (this.af > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(a());
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(stringBuilder.toString()));
    } 
  }
  
  void a(boolean paramBoolean) {
    if (this.W < 1)
      this.W = 1; 
    if (!paramBoolean && !this.v)
      this.u = false; 
    if (this.W == 1) {
      if (paramBoolean && this.u && !this.v && this.n != null && this.m != null)
        q(); 
      if (!this.v)
        this.u = false; 
    } 
    this.W--;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5) { return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5); }
  
  boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual d : ()V
    //   4: aload_0
    //   5: getfield m : Landroid/support/v7/widget/RecyclerView$a;
    //   8: ifnull -> 70
    //   11: aload_0
    //   12: iload_1
    //   13: iload_2
    //   14: aload_0
    //   15: getfield J : [I
    //   18: invokevirtual a : (II[I)V
    //   21: aload_0
    //   22: getfield J : [I
    //   25: astore #21
    //   27: aload #21
    //   29: iconst_0
    //   30: iaload
    //   31: istore #22
    //   33: aload #21
    //   35: iconst_1
    //   36: iaload
    //   37: istore #23
    //   39: iload_1
    //   40: iload #22
    //   42: isub
    //   43: istore #24
    //   45: iload_2
    //   46: iload #23
    //   48: isub
    //   49: istore #25
    //   51: iload #23
    //   53: istore #4
    //   55: iload #22
    //   57: istore #7
    //   59: iload #24
    //   61: istore #5
    //   63: iload #25
    //   65: istore #6
    //   67: goto -> 82
    //   70: iconst_0
    //   71: istore #4
    //   73: iconst_0
    //   74: istore #5
    //   76: iconst_0
    //   77: istore #6
    //   79: iconst_0
    //   80: istore #7
    //   82: aload_0
    //   83: getfield p : Ljava/util/ArrayList;
    //   86: invokevirtual isEmpty : ()Z
    //   89: ifne -> 96
    //   92: aload_0
    //   93: invokevirtual invalidate : ()V
    //   96: aload_0
    //   97: getfield aF : [I
    //   100: astore #8
    //   102: iload #7
    //   104: istore #9
    //   106: iload #4
    //   108: istore #10
    //   110: iload #5
    //   112: istore #11
    //   114: iload #6
    //   116: istore #12
    //   118: iload #4
    //   120: istore #13
    //   122: aload_0
    //   123: iload #9
    //   125: iload #10
    //   127: iload #11
    //   129: iload #12
    //   131: aload #8
    //   133: iconst_0
    //   134: invokevirtual a : (IIII[II)Z
    //   137: ifeq -> 239
    //   140: aload_0
    //   141: getfield aq : I
    //   144: istore #16
    //   146: aload_0
    //   147: getfield aF : [I
    //   150: astore #17
    //   152: aload_0
    //   153: iload #16
    //   155: aload #17
    //   157: iconst_0
    //   158: iaload
    //   159: isub
    //   160: putfield aq : I
    //   163: aload_0
    //   164: aload_0
    //   165: getfield ar : I
    //   168: aload #17
    //   170: iconst_1
    //   171: iaload
    //   172: isub
    //   173: putfield ar : I
    //   176: aload_3
    //   177: ifnull -> 194
    //   180: aload_3
    //   181: aload #17
    //   183: iconst_0
    //   184: iaload
    //   185: i2f
    //   186: aload #17
    //   188: iconst_1
    //   189: iaload
    //   190: i2f
    //   191: invokevirtual offsetLocation : (FF)V
    //   194: aload_0
    //   195: getfield aG : [I
    //   198: astore #18
    //   200: aload #18
    //   202: iconst_0
    //   203: iaload
    //   204: istore #19
    //   206: aload_0
    //   207: getfield aF : [I
    //   210: astore #20
    //   212: aload #18
    //   214: iconst_0
    //   215: iload #19
    //   217: aload #20
    //   219: iconst_0
    //   220: iaload
    //   221: iadd
    //   222: iastore
    //   223: aload #18
    //   225: iconst_1
    //   226: aload #18
    //   228: iconst_1
    //   229: iaload
    //   230: aload #20
    //   232: iconst_1
    //   233: iaload
    //   234: iadd
    //   235: iastore
    //   236: goto -> 285
    //   239: aload_0
    //   240: invokevirtual getOverScrollMode : ()I
    //   243: iconst_2
    //   244: if_icmpeq -> 285
    //   247: aload_3
    //   248: ifnull -> 279
    //   251: aload_3
    //   252: sipush #8194
    //   255: invokestatic a : (Landroid/view/MotionEvent;I)Z
    //   258: ifne -> 279
    //   261: aload_0
    //   262: aload_3
    //   263: invokevirtual getX : ()F
    //   266: iload #5
    //   268: i2f
    //   269: aload_3
    //   270: invokevirtual getY : ()F
    //   273: iload #6
    //   275: i2f
    //   276: invokespecial a : (FFFF)V
    //   279: aload_0
    //   280: iload_1
    //   281: iload_2
    //   282: invokevirtual c : (II)V
    //   285: iload #7
    //   287: ifne -> 302
    //   290: iload #13
    //   292: istore #14
    //   294: iload #14
    //   296: ifeq -> 314
    //   299: goto -> 306
    //   302: iload #13
    //   304: istore #14
    //   306: aload_0
    //   307: iload #7
    //   309: iload #14
    //   311: invokevirtual i : (II)V
    //   314: aload_0
    //   315: invokevirtual awakenScrollBars : ()Z
    //   318: ifne -> 325
    //   321: aload_0
    //   322: invokevirtual invalidate : ()V
    //   325: iload #7
    //   327: ifne -> 338
    //   330: iconst_0
    //   331: istore #15
    //   333: iload #14
    //   335: ifeq -> 341
    //   338: iconst_1
    //   339: istore #15
    //   341: iload #15
    //   343: ireturn }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3) { return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3); }
  
  boolean a(x paramx, int paramInt) {
    if (o()) {
      paramx.o = paramInt;
      this.K.add(paramx);
      return false;
    } 
    r.b(paramx.a, paramInt);
    return true;
  }
  
  boolean a(View paramView) {
    e();
    boolean bool = this.g.f(paramView);
    if (bool) {
      x x1 = e(paramView);
      this.e.c(x1);
      this.e.b(x1);
    } 
    a(bool ^ true);
    return bool;
  }
  
  boolean a(AccessibilityEvent paramAccessibilityEvent) {
    if (o()) {
      int i1;
      if (paramAccessibilityEvent != null) {
        i1 = a.a(paramAccessibilityEvent);
      } else {
        i1 = 0;
      } 
      if (!i1)
        i1 = 0; 
      this.ab = i1 | this.ab;
      return true;
    } 
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    i i1 = this.n;
    if (i1 == null || !i1.a(this, paramArrayList, paramInt1, paramInt2))
      super.addFocusables(paramArrayList, paramInt1, paramInt2); 
  }
  
  public x b(View paramView) {
    ViewParent viewParent = paramView.getParent();
    if (viewParent == null || viewParent == this)
      return e(paramView); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a direct child of ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  void b() { this.f = new e(new e.a(this) {
          public RecyclerView.x a(int param1Int) {
            RecyclerView.x x = this.a.a(param1Int, true);
            return (x == null) ? null : (this.a.g.c(x.a) ? null : x);
          }
          
          public void a(int param1Int1, int param1Int2) {
            this.a.a(param1Int1, param1Int2, true);
            RecyclerView recyclerView = this.a;
            recyclerView.E = true;
            RecyclerView.u u = recyclerView.D;
            u.c = param1Int2 + u.c;
          }
          
          public void a(int param1Int1, int param1Int2, Object param1Object) {
            this.a.a(param1Int1, param1Int2, param1Object);
            this.a.F = true;
          }
          
          public void a(e.b param1b) { c(param1b); }
          
          public void b(int param1Int1, int param1Int2) {
            this.a.a(param1Int1, param1Int2, false);
            this.a.E = true;
          }
          
          public void b(e.b param1b) { c(param1b); }
          
          public void c(int param1Int1, int param1Int2) {
            this.a.g(param1Int1, param1Int2);
            this.a.E = true;
          }
          
          void c(e.b param1b) {
            int i = param1b.a;
            if (i != 4) {
              if (i != 8) {
                switch (i) {
                  default:
                    return;
                  case 2:
                    this.a.n.b(this.a, param1b.b, param1b.d);
                    return;
                  case 1:
                    break;
                } 
                this.a.n.a(this.a, param1b.b, param1b.d);
                return;
              } 
              this.a.n.a(this.a, param1b.b, param1b.d, 1);
              return;
            } 
            this.a.n.a(this.a, param1b.b, param1b.d, param1b.c);
          }
          
          public void d(int param1Int1, int param1Int2) {
            this.a.f(param1Int1, param1Int2);
            this.a.E = true;
          }
        }); }
  
  void b(int paramInt) {
    i i1 = this.n;
    if (i1 == null)
      return; 
    i1.e(paramInt);
    awakenScrollBars();
  }
  
  public void b(h paramh) {
    i i1 = this.n;
    if (i1 != null)
      i1.a("Cannot remove item decoration during a scroll  or layout"); 
    this.p.remove(paramh);
    if (this.p.isEmpty()) {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      setWillNotDraw(bool);
    } 
    r();
    requestLayout();
  }
  
  public void b(m paramm) {
    this.U.remove(paramm);
    if (this.V == paramm)
      this.V = null; 
  }
  
  public void b(n paramn) {
    List list = this.aA;
    if (list != null)
      list.remove(paramn); 
  }
  
  void b(x paramx, f.c paramc1, f.c paramc2) {
    e(paramx);
    paramx.a(false);
    if (this.z.a(paramx, paramc1, paramc2))
      p(); 
  }
  
  void b(boolean paramBoolean) {
    this.ae--;
    if (this.ae < 1) {
      this.ae = 0;
      if (paramBoolean) {
        F();
        x();
      } 
    } 
  }
  
  public boolean b(int paramInt1, int paramInt2) {
    i i1 = this.n;
    if (i1 == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return false;
    } 
    if (this.v)
      return false; 
    boolean bool1 = i1.e();
    boolean bool2 = this.n.f();
    if (!bool1 || Math.abs(paramInt1) < this.au)
      paramInt1 = 0; 
    if (!bool2 || Math.abs(paramInt2) < this.au)
      paramInt2 = 0; 
    if (paramInt1 == 0 && paramInt2 == 0)
      return false; 
    float f1 = paramInt1;
    float f2 = paramInt2;
    if (!dispatchNestedPreFling(f1, f2)) {
      boolean bool;
      if (bool1 || bool2) {
        bool = true;
      } else {
        bool = false;
      } 
      dispatchNestedFling(f1, f2, bool);
      l l1 = this.at;
      if (l1 != null && l1.a(paramInt1, paramInt2))
        return true; 
      if (bool) {
        byte b1 = 0;
        if (bool1)
          b1 = 1; 
        if (bool2)
          b1 |= 0x2; 
        j(b1, 1);
        int i2 = this.av;
        int i3 = Math.max(-i2, Math.min(paramInt1, i2));
        int i4 = this.av;
        int i5 = Math.max(-i4, Math.min(paramInt2, i4));
        this.A.a(i3, i5);
        return true;
      } 
    } 
    return false;
  }
  
  boolean b(x paramx) {
    f f1 = this.z;
    return (f1 == null || f1.a(paramx, paramx.u()));
  }
  
  public x c(int paramInt) {
    boolean bool = this.x;
    x x1 = null;
    if (bool)
      return null; 
    int i1 = this.g.c();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x2 = e(this.g.d(b1));
      if (x2 != null && !x2.q() && d(x2) == paramInt)
        if (this.g.c(x2.a)) {
          x1 = x2;
        } else {
          return x2;
        }  
    } 
    return x1;
  }
  
  public View c(View paramView) {
    ViewParent viewParent;
    while (true) {
      viewParent = paramView.getParent();
      if (viewParent != null && viewParent != this && viewParent instanceof View) {
        paramView = (View)viewParent;
        continue;
      } 
      break;
    } 
    return (viewParent == this) ? paramView : null;
  }
  
  void c() {
    f f1 = this.z;
    if (f1 != null)
      f1.d(); 
    i i1 = this.n;
    if (i1 != null) {
      i1.c(this.e);
      this.n.b(this.e);
    } 
    this.e.a();
  }
  
  void c(int paramInt1, int paramInt2) {
    boolean bool;
    EdgeEffect edgeEffect1 = this.ah;
    if (edgeEffect1 != null && !edgeEffect1.isFinished() && paramInt1 > 0) {
      this.ah.onRelease();
      bool = this.ah.isFinished();
    } else {
      bool = false;
    } 
    EdgeEffect edgeEffect2 = this.aj;
    if (edgeEffect2 != null && !edgeEffect2.isFinished() && paramInt1 < 0) {
      this.aj.onRelease();
      bool |= this.aj.isFinished();
    } 
    EdgeEffect edgeEffect3 = this.ai;
    if (edgeEffect3 != null && !edgeEffect3.isFinished() && paramInt2 > 0) {
      this.ai.onRelease();
      bool |= this.ai.isFinished();
    } 
    EdgeEffect edgeEffect4 = this.ak;
    if (edgeEffect4 != null && !edgeEffect4.isFinished() && paramInt2 < 0) {
      this.ak.onRelease();
      bool |= this.ak.isFinished();
    } 
    if (bool)
      r.d(this); 
  }
  
  void c(boolean paramBoolean) {
    this.y = paramBoolean | this.y;
    this.x = true;
    u();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams instanceof j && this.n.a((j)paramLayoutParams)); }
  
  public int computeHorizontalScrollExtent() {
    i i1 = this.n;
    if (i1 == null)
      return 0; 
    boolean bool = i1.e();
    int i2 = 0;
    if (bool)
      i2 = this.n.e(this.D); 
    return i2;
  }
  
  public int computeHorizontalScrollOffset() {
    i i1 = this.n;
    if (i1 == null)
      return 0; 
    boolean bool = i1.e();
    int i2 = 0;
    if (bool)
      i2 = this.n.c(this.D); 
    return i2;
  }
  
  public int computeHorizontalScrollRange() {
    i i1 = this.n;
    if (i1 == null)
      return 0; 
    boolean bool = i1.e();
    int i2 = 0;
    if (bool)
      i2 = this.n.g(this.D); 
    return i2;
  }
  
  public int computeVerticalScrollExtent() {
    i i1 = this.n;
    if (i1 == null)
      return 0; 
    boolean bool = i1.f();
    int i2 = 0;
    if (bool)
      i2 = this.n.f(this.D); 
    return i2;
  }
  
  public int computeVerticalScrollOffset() {
    i i1 = this.n;
    if (i1 == null)
      return 0; 
    boolean bool = i1.f();
    int i2 = 0;
    if (bool)
      i2 = this.n.d(this.D); 
    return i2;
  }
  
  public int computeVerticalScrollRange() {
    i i1 = this.n;
    if (i1 == null)
      return 0; 
    boolean bool = i1.f();
    int i2 = 0;
    if (bool)
      i2 = this.n.h(this.D); 
    return i2;
  }
  
  int d(x paramx) { return (paramx.a(524) || !paramx.p()) ? -1 : this.f.c(paramx.c); }
  
  public x d(View paramView) {
    View view = c(paramView);
    return (view == null) ? null : b(view);
  }
  
  void d() {
    if (!this.t || this.x) {
      c.a("RV FullInvalidate");
      q();
      c.a();
      return;
    } 
    if (!this.f.d())
      return; 
    if (this.f.a(4) && !this.f.a(11)) {
      c.a("RV PartialInvalidate");
      e();
      l();
      this.f.b();
      if (!this.u)
        if (A()) {
          q();
        } else {
          this.f.c();
        }  
      a(true);
      m();
    } else if (this.f.d()) {
      c.a("RV FullInvalidate");
      q();
    } else {
      return;
    } 
    c.a();
  }
  
  public void d(int paramInt) {
    int i1 = this.g.b();
    for (byte b1 = 0; b1 < i1; b1++)
      this.g.b(b1).offsetTopAndBottom(paramInt); 
  }
  
  void d(int paramInt1, int paramInt2) {
    if (paramInt1 < 0) {
      g();
      this.ah.onAbsorb(-paramInt1);
    } else if (paramInt1 > 0) {
      h();
      this.aj.onAbsorb(paramInt1);
    } 
    if (paramInt2 < 0) {
      i();
      this.ai.onAbsorb(-paramInt2);
    } else if (paramInt2 > 0) {
      j();
      this.ak.onAbsorb(paramInt2);
    } 
    if (paramInt1 != 0 || paramInt2 != 0)
      r.d(this); 
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) { return getScrollingChildHelper().a(paramFloat1, paramFloat2, paramBoolean); }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) { return getScrollingChildHelper().a(paramFloat1, paramFloat2); }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) { return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2); }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt) { return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt); }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) { dispatchThawSelfOnly(paramSparseArray); }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) { dispatchFreezeSelfOnly(paramSparseArray); }
  
  public void draw(Canvas paramCanvas) {
    byte b3;
    byte b2;
    super.draw(paramCanvas);
    int i1 = this.p.size();
    for (byte b1 = 0; b1 < i1; b1++)
      ((h)this.p.get(b1)).a(paramCanvas, this, this.D); 
    EdgeEffect edgeEffect1 = this.ah;
    if (edgeEffect1 != null && !edgeEffect1.isFinished()) {
      int i3;
      int i2 = paramCanvas.save();
      if (this.i) {
        i3 = getPaddingBottom();
      } else {
        i3 = 0;
      } 
      paramCanvas.rotate(270.0F);
      paramCanvas.translate((i3 + -getHeight()), 0.0F);
      EdgeEffect edgeEffect = this.ah;
      if (edgeEffect != null && edgeEffect.draw(paramCanvas)) {
        b2 = 1;
      } else {
        b2 = 0;
      } 
      paramCanvas.restoreToCount(i2);
    } else {
      b2 = 0;
    } 
    EdgeEffect edgeEffect2 = this.ai;
    if (edgeEffect2 != null && !edgeEffect2.isFinished()) {
      byte b4;
      int i2 = paramCanvas.save();
      if (this.i)
        paramCanvas.translate(getPaddingLeft(), getPaddingTop()); 
      EdgeEffect edgeEffect = this.ai;
      if (edgeEffect != null && edgeEffect.draw(paramCanvas)) {
        b4 = 1;
      } else {
        b4 = 0;
      } 
      b2 |= b4;
      paramCanvas.restoreToCount(i2);
    } 
    EdgeEffect edgeEffect3 = this.aj;
    if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
      byte b5;
      byte b4;
      int i2 = paramCanvas.save();
      int i3 = getWidth();
      if (this.i) {
        b4 = getPaddingTop();
      } else {
        b4 = 0;
      } 
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-b4, -i3);
      EdgeEffect edgeEffect = this.aj;
      if (edgeEffect != null && edgeEffect.draw(paramCanvas)) {
        b5 = 1;
      } else {
        b5 = 0;
      } 
      b2 |= b5;
      paramCanvas.restoreToCount(i2);
    } 
    EdgeEffect edgeEffect4 = this.ak;
    if (edgeEffect4 != null && !edgeEffect4.isFinished()) {
      int i3;
      float f1;
      int i2 = paramCanvas.save();
      paramCanvas.rotate(180.0F);
      if (this.i) {
        f1 = (-getWidth() + getPaddingRight());
        i3 = -getHeight() + getPaddingBottom();
      } else {
        f1 = -getWidth();
        i3 = -getHeight();
      } 
      paramCanvas.translate(f1, i3);
      EdgeEffect edgeEffect = this.ak;
      byte b4 = 0;
      if (edgeEffect != null) {
        boolean bool = edgeEffect.draw(paramCanvas);
        b4 = 0;
        if (bool)
          b4 = 1; 
      } 
      b3 = b4 | b2;
      paramCanvas.restoreToCount(i2);
    } else {
      b3 = b2;
    } 
    if (b3 == 0 && this.z != null && this.p.size() > 0 && this.z.b())
      b3 = 1; 
    if (b3 != 0)
      r.d(this); 
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) { return super.drawChild(paramCanvas, paramView, paramLong); }
  
  void e() {
    this.W = 1 + this.W;
    if (this.W == 1 && !this.v)
      this.u = false; 
  }
  
  public void e(int paramInt) {
    int i1 = this.g.b();
    for (byte b1 = 0; b1 < i1; b1++)
      this.g.b(b1).offsetLeftAndRight(paramInt); 
  }
  
  void e(int paramInt1, int paramInt2) { setMeasuredDimension(i.a(paramInt1, getPaddingLeft() + getPaddingRight(), r.j(this)), i.a(paramInt2, getPaddingTop() + getPaddingBottom(), r.k(this))); }
  
  public int f(View paramView) {
    x x1 = e(paramView);
    return (x1 != null) ? x1.d() : -1;
  }
  
  public void f() {
    setScrollState(0);
    B();
  }
  
  public void f(int paramInt) {}
  
  void f(int paramInt1, int paramInt2) {
    byte b1;
    int i3;
    int i2;
    int i1 = this.g.c();
    if (paramInt1 < paramInt2) {
      i3 = paramInt1;
      i2 = paramInt2;
      b1 = -1;
    } else {
      i2 = paramInt1;
      i3 = paramInt2;
      b1 = 1;
    } 
    for (byte b2 = 0; b2 < i1; b2++) {
      x x1 = e(this.g.d(b2));
      if (x1 != null && x1.c >= i3 && x1.c <= i2) {
        if (x1.c == paramInt1) {
          x1.a(paramInt2 - paramInt1, false);
        } else {
          x1.a(b1, false);
        } 
        this.D.f = true;
      } 
    } 
    this.e.a(paramInt1, paramInt2);
    requestLayout();
  }
  
  public View focusSearch(View paramView, int paramInt) {
    View view2;
    boolean bool;
    View view1 = this.n.d(paramView, paramInt);
    if (view1 != null)
      return view1; 
    if (this.m != null && this.n != null && !o() && !this.v) {
      bool = true;
    } else {
      bool = false;
    } 
    FocusFinder focusFinder = FocusFinder.getInstance();
    if (bool && (paramInt == 2 || paramInt == 1)) {
      boolean bool1;
      if (this.n.f()) {
        int i1;
        if (paramInt == 2) {
          i1 = 130;
        } else {
          i1 = 33;
        } 
        if (focusFinder.findNextFocus(this, paramView, i1) == null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (O)
          paramInt = i1; 
      } else {
        bool1 = false;
      } 
      if (!bool1 && this.n.e()) {
        int i1;
        byte b2;
        byte b1;
        if (this.n.t() == 1) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        if (paramInt == 2) {
          b2 = 1;
        } else {
          b2 = 0;
        } 
        if (b1 ^ b2) {
          i1 = 66;
        } else {
          i1 = 17;
        } 
        if (focusFinder.findNextFocus(this, paramView, i1) == null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (O)
          paramInt = i1; 
      } 
      if (bool1) {
        d();
        if (c(paramView) == null)
          return null; 
        e();
        this.n.a(paramView, paramInt, this.e, this.D);
        a(false);
      } 
      view2 = focusFinder.findNextFocus(this, paramView, paramInt);
    } else {
      View view = focusFinder.findNextFocus(this, paramView, paramInt);
      if (view == null && bool) {
        d();
        if (c(paramView) == null)
          return null; 
        e();
        view2 = this.n.a(paramView, paramInt, this.e, this.D);
        a(false);
      } else {
        view2 = view;
      } 
    } 
    if (view2 != null && !view2.hasFocusable()) {
      if (getFocusedChild() == null)
        return super.focusSearch(paramView, paramInt); 
      a(view2, null);
      return paramView;
    } 
    return a(paramView, view2, paramInt) ? view2 : super.focusSearch(paramView, paramInt);
  }
  
  void g() {
    int i2;
    int i1;
    EdgeEffect edgeEffect;
    if (this.ah != null)
      return; 
    this.ah = this.ag.a(this, 0);
    if (this.i) {
      edgeEffect = this.ah;
      i1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
      i2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    } else {
      edgeEffect = this.ah;
      i1 = getMeasuredHeight();
      i2 = getMeasuredWidth();
    } 
    edgeEffect.setSize(i1, i2);
  }
  
  void g(int paramInt) {
    i i1 = this.n;
    if (i1 != null)
      i1.l(paramInt); 
    f(paramInt);
    n n1 = this.az;
    if (n1 != null)
      n1.a(this, paramInt); 
    List list = this.aA;
    if (list != null)
      for (int i2 = -1 + list.size(); i2 >= 0; i2--)
        ((n)this.aA.get(i2)).a(this, paramInt);  
  }
  
  void g(int paramInt1, int paramInt2) {
    int i1 = this.g.c();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x1 = e(this.g.d(b1));
      if (x1 != null && !x1.c() && x1.c >= paramInt1) {
        x1.a(paramInt2, false);
        this.D.f = true;
      } 
    } 
    this.e.b(paramInt1, paramInt2);
    requestLayout();
  }
  
  public void g(View paramView) {}
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    i i1 = this.n;
    if (i1 != null)
      return i1.a(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RecyclerView has no LayoutManager");
    stringBuilder.append(a());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    i i1 = this.n;
    if (i1 != null)
      return i1.a(getContext(), paramAttributeSet); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RecyclerView has no LayoutManager");
    stringBuilder.append(a());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    i i1 = this.n;
    if (i1 != null)
      return i1.a(paramLayoutParams); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RecyclerView has no LayoutManager");
    stringBuilder.append(a());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public a getAdapter() { return this.m; }
  
  public int getBaseline() {
    i i1 = this.n;
    return (i1 != null) ? i1.u() : super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    d d1 = this.aC;
    return (d1 == null) ? super.getChildDrawingOrder(paramInt1, paramInt2) : d1.a(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding() { return this.i; }
  
  public ay getCompatAccessibilityDelegate() { return this.H; }
  
  public e getEdgeEffectFactory() { return this.ag; }
  
  public f getItemAnimator() { return this.z; }
  
  public int getItemDecorationCount() { return this.p.size(); }
  
  public i getLayoutManager() { return this.n; }
  
  public int getMaxFlingVelocity() { return this.av; }
  
  public int getMinFlingVelocity() { return this.au; }
  
  long getNanoTime() { return d ? System.nanoTime() : 0L; }
  
  public l getOnFlingListener() { return this.at; }
  
  public boolean getPreserveFocusAfterLayout() { return this.ay; }
  
  public o getRecycledViewPool() { return this.e.g(); }
  
  public int getScrollState() { return this.al; }
  
  void h() {
    int i2;
    int i1;
    EdgeEffect edgeEffect;
    if (this.aj != null)
      return; 
    this.aj = this.ag.a(this, 2);
    if (this.i) {
      edgeEffect = this.aj;
      i1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
      i2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    } else {
      edgeEffect = this.aj;
      i1 = getMeasuredHeight();
      i2 = getMeasuredWidth();
    } 
    edgeEffect.setSize(i1, i2);
  }
  
  public void h(int paramInt1, int paramInt2) {}
  
  public void h(View paramView) {}
  
  public boolean h(int paramInt) { return getScrollingChildHelper().a(paramInt); }
  
  public boolean hasNestedScrollingParent() { return getScrollingChildHelper().b(); }
  
  Rect i(View paramView) {
    j j1 = (j)paramView.getLayoutParams();
    if (!j1.e)
      return j1.d; 
    if (this.D.a() && (j1.e() || j1.c()))
      return j1.d; 
    Rect rect = j1.d;
    rect.set(0, 0, 0, 0);
    int i1 = this.p.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      this.k.set(0, 0, 0, 0);
      ((h)this.p.get(b1)).a(this.k, paramView, this, this.D);
      rect.left += this.k.left;
      rect.top += this.k.top;
      rect.right += this.k.right;
      rect.bottom += this.k.bottom;
    } 
    j1.e = false;
    return rect;
  }
  
  void i() {
    int i2;
    int i1;
    EdgeEffect edgeEffect;
    if (this.ai != null)
      return; 
    this.ai = this.ag.a(this, 1);
    if (this.i) {
      edgeEffect = this.ai;
      i1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
      i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    } else {
      edgeEffect = this.ai;
      i1 = getMeasuredWidth();
      i2 = getMeasuredHeight();
    } 
    edgeEffect.setSize(i1, i2);
  }
  
  void i(int paramInt1, int paramInt2) {
    this.af = 1 + this.af;
    int i1 = getScrollX();
    int i2 = getScrollY();
    onScrollChanged(i1, i2, i1, i2);
    h(paramInt1, paramInt2);
    n n1 = this.az;
    if (n1 != null)
      n1.a(this, paramInt1, paramInt2); 
    List list = this.aA;
    if (list != null)
      for (int i3 = -1 + list.size(); i3 >= 0; i3--)
        ((n)this.aA.get(i3)).a(this, paramInt1, paramInt2);  
    this.af = -1 + this.af;
  }
  
  public boolean isAttachedToWindow() { return this.q; }
  
  public boolean isNestedScrollingEnabled() { return getScrollingChildHelper().a(); }
  
  void j() {
    int i2;
    int i1;
    EdgeEffect edgeEffect;
    if (this.ak != null)
      return; 
    this.ak = this.ag.a(this, 3);
    if (this.i) {
      edgeEffect = this.ak;
      i1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
      i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    } else {
      edgeEffect = this.ak;
      i1 = getMeasuredWidth();
      i2 = getMeasuredHeight();
    } 
    edgeEffect.setSize(i1, i2);
  }
  
  public boolean j(int paramInt1, int paramInt2) { return getScrollingChildHelper().a(paramInt1, paramInt2); }
  
  void k() {
    this.ak = null;
    this.ai = null;
    this.aj = null;
    this.ah = null;
  }
  
  void k(View paramView) {
    x x1 = e(paramView);
    h(paramView);
    a a1 = this.m;
    if (a1 != null && x1 != null)
      a1.d(x1); 
    List list = this.ad;
    if (list != null)
      for (int i1 = -1 + list.size(); i1 >= 0; i1--)
        ((k)this.ad.get(i1)).b(paramView);  
  }
  
  void l() { this.ae = 1 + this.ae; }
  
  void l(View paramView) {
    x x1 = e(paramView);
    g(paramView);
    a a1 = this.m;
    if (a1 != null && x1 != null)
      a1.c(x1); 
    List list = this.ad;
    if (list != null)
      for (int i1 = -1 + list.size(); i1 >= 0; i1--)
        ((k)this.ad.get(i1)).a(paramView);  
  }
  
  void m() { b(true); }
  
  boolean n() {
    AccessibilityManager accessibilityManager = this.ac;
    return (accessibilityManager != null && accessibilityManager.isEnabled());
  }
  
  public boolean o() { return (this.ae > 0); }
  
  protected void onAttachedToWindow() { // Byte code:
    //   0: aload_0
    //   1: invokespecial onAttachedToWindow : ()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield ae : I
    //   9: iconst_1
    //   10: istore_1
    //   11: aload_0
    //   12: iload_1
    //   13: putfield q : Z
    //   16: aload_0
    //   17: getfield t : Z
    //   20: ifeq -> 33
    //   23: aload_0
    //   24: invokevirtual isLayoutRequested : ()Z
    //   27: ifne -> 33
    //   30: goto -> 35
    //   33: iconst_0
    //   34: istore_1
    //   35: aload_0
    //   36: iload_1
    //   37: putfield t : Z
    //   40: aload_0
    //   41: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull -> 54
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual c : (Landroid/support/v7/widget/RecyclerView;)V
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield G : Z
    //   59: getstatic android/support/v7/widget/RecyclerView.d : Z
    //   62: ifeq -> 167
    //   65: aload_0
    //   66: getstatic android/support/v7/widget/aq.a : Ljava/lang/ThreadLocal;
    //   69: invokevirtual get : ()Ljava/lang/Object;
    //   72: checkcast android/support/v7/widget/aq
    //   75: putfield B : Landroid/support/v7/widget/aq;
    //   78: aload_0
    //   79: getfield B : Landroid/support/v7/widget/aq;
    //   82: ifnonnull -> 159
    //   85: aload_0
    //   86: new android/support/v7/widget/aq
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: putfield B : Landroid/support/v7/widget/aq;
    //   96: aload_0
    //   97: invokestatic C : (Landroid/view/View;)Landroid/view/Display;
    //   100: astore_3
    //   101: aload_0
    //   102: invokevirtual isInEditMode : ()Z
    //   105: ifne -> 130
    //   108: aload_3
    //   109: ifnull -> 130
    //   112: aload_3
    //   113: invokevirtual getRefreshRate : ()F
    //   116: fstore #4
    //   118: fload #4
    //   120: ldc_w 30.0
    //   123: fcmpl
    //   124: iflt -> 130
    //   127: goto -> 135
    //   130: ldc_w 60.0
    //   133: fstore #4
    //   135: aload_0
    //   136: getfield B : Landroid/support/v7/widget/aq;
    //   139: ldc_w 1.0E9
    //   142: fload #4
    //   144: fdiv
    //   145: f2l
    //   146: putfield d : J
    //   149: getstatic android/support/v7/widget/aq.a : Ljava/lang/ThreadLocal;
    //   152: aload_0
    //   153: getfield B : Landroid/support/v7/widget/aq;
    //   156: invokevirtual set : (Ljava/lang/Object;)V
    //   159: aload_0
    //   160: getfield B : Landroid/support/v7/widget/aq;
    //   163: aload_0
    //   164: invokevirtual a : (Landroid/support/v7/widget/RecyclerView;)V
    //   167: return }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    f f1 = this.z;
    if (f1 != null)
      f1.d(); 
    f();
    this.q = false;
    i i1 = this.n;
    if (i1 != null)
      i1.b(this, this.e); 
    this.K.clear();
    removeCallbacks(this.aH);
    this.h.b();
    if (d) {
      aq aq1 = this.B;
      if (aq1 != null) {
        aq1.b(this);
        this.B = null;
      } 
    } 
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i1 = this.p.size();
    for (byte b1 = 0; b1 < i1; b1++)
      ((h)this.p.get(b1)).b(paramCanvas, this, this.D); 
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) { // Byte code:
    //   0: aload_0
    //   1: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   4: ifnonnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield v : Z
    //   13: ifeq -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual getAction : ()I
    //   22: bipush #8
    //   24: if_icmpne -> 169
    //   27: iconst_2
    //   28: aload_1
    //   29: invokevirtual getSource : ()I
    //   32: iand
    //   33: ifeq -> 79
    //   36: aload_0
    //   37: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   40: invokevirtual f : ()Z
    //   43: ifeq -> 57
    //   46: aload_1
    //   47: bipush #9
    //   49: invokevirtual getAxisValue : (I)F
    //   52: fneg
    //   53: fstore_2
    //   54: goto -> 59
    //   57: fconst_0
    //   58: fstore_2
    //   59: aload_0
    //   60: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   63: invokevirtual e : ()Z
    //   66: ifeq -> 135
    //   69: aload_1
    //   70: bipush #10
    //   72: invokevirtual getAxisValue : (I)F
    //   75: fstore_3
    //   76: goto -> 137
    //   79: ldc_w 4194304
    //   82: aload_1
    //   83: invokevirtual getSource : ()I
    //   86: iand
    //   87: ifeq -> 133
    //   90: aload_1
    //   91: bipush #26
    //   93: invokevirtual getAxisValue : (I)F
    //   96: fstore #5
    //   98: aload_0
    //   99: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   102: invokevirtual f : ()Z
    //   105: ifeq -> 115
    //   108: fload #5
    //   110: fneg
    //   111: fstore_2
    //   112: goto -> 135
    //   115: aload_0
    //   116: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   119: invokevirtual e : ()Z
    //   122: ifeq -> 133
    //   125: fload #5
    //   127: fstore_3
    //   128: fconst_0
    //   129: fstore_2
    //   130: goto -> 137
    //   133: fconst_0
    //   134: fstore_2
    //   135: fconst_0
    //   136: fstore_3
    //   137: fload_2
    //   138: fconst_0
    //   139: fcmpl
    //   140: ifne -> 149
    //   143: fload_3
    //   144: fconst_0
    //   145: fcmpl
    //   146: ifeq -> 169
    //   149: aload_0
    //   150: fload_3
    //   151: aload_0
    //   152: getfield aw : F
    //   155: fmul
    //   156: f2i
    //   157: fload_2
    //   158: aload_0
    //   159: getfield ax : F
    //   162: fmul
    //   163: f2i
    //   164: aload_1
    //   165: invokevirtual a : (IILandroid/view/MotionEvent;)Z
    //   168: pop
    //   169: iconst_0
    //   170: ireturn }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i11;
    int i10;
    int i9;
    int i8;
    int i7;
    byte b1;
    int[] arrayOfInt;
    int i5;
    int i4;
    if (this.v)
      return false; 
    if (a(paramMotionEvent)) {
      E();
      return true;
    } 
    i i1 = this.n;
    if (i1 == null)
      return false; 
    boolean bool1 = i1.e();
    boolean bool2 = this.n.f();
    if (this.an == null)
      this.an = VelocityTracker.obtain(); 
    this.an.addMovement(paramMotionEvent);
    int i2 = paramMotionEvent.getActionMasked();
    int i3 = paramMotionEvent.getActionIndex();
    switch (i2) {
      case 6:
        c(paramMotionEvent);
        break;
      case 5:
        this.am = paramMotionEvent.getPointerId(i3);
        i10 = (int)(0.5F + paramMotionEvent.getX(i3));
        this.aq = i10;
        this.ao = i10;
        i11 = (int)(0.5F + paramMotionEvent.getY(i3));
        this.ar = i11;
        this.ap = i11;
        break;
      case 3:
        E();
        break;
      case 2:
        i7 = paramMotionEvent.findPointerIndex(this.am);
        if (i7 < 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Error processing scroll; pointer index for id ");
          stringBuilder.append(this.am);
          stringBuilder.append(" not found. Did any MotionEvents get skipped?");
          Log.e("RecyclerView", stringBuilder.toString());
          return false;
        } 
        i8 = (int)(0.5F + paramMotionEvent.getX(i7));
        i9 = (int)(0.5F + paramMotionEvent.getY(i7));
        if (this.al != 1) {
          boolean bool;
          int i12 = i8 - this.ao;
          int i13 = i9 - this.ap;
          if (bool1 && Math.abs(i12) > this.as) {
            this.aq = i8;
            bool = true;
          } else {
            bool = false;
          } 
          if (bool2 && Math.abs(i13) > this.as) {
            this.ar = i9;
            bool = true;
          } 
          if (bool)
            setScrollState(1); 
        } 
        break;
      case 1:
        this.an.clear();
        a(0);
        break;
      case 0:
        if (this.aa)
          this.aa = false; 
        this.am = paramMotionEvent.getPointerId(0);
        i4 = (int)(0.5F + paramMotionEvent.getX());
        this.aq = i4;
        this.ao = i4;
        i5 = (int)(0.5F + paramMotionEvent.getY());
        this.ar = i5;
        this.ap = i5;
        if (this.al == 2) {
          getParent().requestDisallowInterceptTouchEvent(true);
          setScrollState(1);
        } 
        arrayOfInt = this.aG;
        arrayOfInt[1] = 0;
        arrayOfInt[0] = 0;
        if (bool1) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        if (bool2)
          b1 |= 0x2; 
        j(b1, 0);
        break;
    } 
    int i6 = this.al;
    boolean bool3 = false;
    if (i6 == 1)
      bool3 = true; 
    return bool3;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    c.a("RV OnLayout");
    q();
    c.a();
    this.t = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    i i1 = this.n;
    if (i1 == null) {
      e(paramInt1, paramInt2);
      return;
    } 
    if (i1.c()) {
      int i2 = View.MeasureSpec.getMode(paramInt1);
      int i3 = View.MeasureSpec.getMode(paramInt2);
      this.n.a(this.e, this.D, paramInt1, paramInt2);
      boolean bool = false;
      if (i2 == 1073741824) {
        bool = false;
        if (i3 == 1073741824)
          bool = true; 
      } 
      if (!bool) {
        if (this.m == null)
          return; 
        if (this.D.d == 1)
          M(); 
        this.n.c(paramInt1, paramInt2);
        this.D.i = true;
        N();
        this.n.d(paramInt1, paramInt2);
        if (this.n.l()) {
          this.n.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
          this.D.i = true;
          N();
          this.n.d(paramInt1, paramInt2);
          return;
        } 
      } else {
        return;
      } 
    } else {
      if (this.r) {
        this.n.a(this.e, this.D, paramInt1, paramInt2);
        return;
      } 
      if (this.w) {
        e();
        l();
        H();
        m();
        if (this.D.k) {
          this.D.g = true;
        } else {
          this.f.e();
          this.D.g = false;
        } 
        this.w = false;
        a(false);
      } else if (this.D.k) {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        return;
      } 
      a a1 = this.m;
      if (a1 != null) {
        this.D.e = a1.a();
      } else {
        this.D.e = 0;
      } 
      e();
      this.n.a(this.e, this.D, paramInt1, paramInt2);
      a(false);
      this.D.g = false;
    } 
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) { return o() ? false : super.onRequestFocusInDescendants(paramInt, paramRect); }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof s)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    this.S = (s)paramParcelable;
    super.onRestoreInstanceState(this.S.a());
    if (this.n != null && this.S.a != null)
      this.n.a(this.S.a); 
  }
  
  protected Parcelable onSaveInstanceState() {
    Object object;
    s s1 = new s(super.onSaveInstanceState());
    s s2 = this.S;
    if (s2 != null) {
      s1.a(s2);
      return s1;
    } 
    i i1 = this.n;
    if (i1 != null) {
      object = i1.d();
    } else {
      object = null;
    } 
    s1.a = object;
    return s1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3 || paramInt2 != paramInt4)
      k(); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) { // Byte code:
    //   0: aload_0
    //   1: getfield v : Z
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_2
    //   8: ifne -> 978
    //   11: aload_0
    //   12: getfield aa : Z
    //   15: ifeq -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial b : (Landroid/view/MotionEvent;)Z
    //   25: ifeq -> 34
    //   28: aload_0
    //   29: invokespecial E : ()V
    //   32: iconst_1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   38: astore #4
    //   40: aload #4
    //   42: ifnonnull -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: aload #4
    //   49: invokevirtual e : ()Z
    //   52: istore #5
    //   54: aload_0
    //   55: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   58: invokevirtual f : ()Z
    //   61: istore #6
    //   63: aload_0
    //   64: getfield an : Landroid/view/VelocityTracker;
    //   67: ifnonnull -> 77
    //   70: aload_0
    //   71: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   74: putfield an : Landroid/view/VelocityTracker;
    //   77: aload_1
    //   78: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   81: astore #7
    //   83: aload_1
    //   84: invokevirtual getActionMasked : ()I
    //   87: istore #8
    //   89: aload_1
    //   90: invokevirtual getActionIndex : ()I
    //   93: istore #9
    //   95: iload #8
    //   97: ifne -> 116
    //   100: aload_0
    //   101: getfield aG : [I
    //   104: astore #46
    //   106: aload #46
    //   108: iconst_1
    //   109: iconst_0
    //   110: iastore
    //   111: aload #46
    //   113: iconst_0
    //   114: iconst_0
    //   115: iastore
    //   116: aload_0
    //   117: getfield aG : [I
    //   120: astore #10
    //   122: aload #7
    //   124: aload #10
    //   126: iconst_0
    //   127: iaload
    //   128: i2f
    //   129: aload #10
    //   131: iconst_1
    //   132: iaload
    //   133: i2f
    //   134: invokevirtual offsetLocation : (FF)V
    //   137: iload #8
    //   139: tableswitch default -> 180, 0 -> 870, 1 -> 755, 2 -> 269, 3 -> 260, 4 -> 180, 5 -> 195, 6 -> 185
    //   180: iconst_0
    //   181: istore_3
    //   182: goto -> 958
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial c : (Landroid/view/MotionEvent;)V
    //   190: iconst_0
    //   191: istore_3
    //   192: goto -> 958
    //   195: aload_0
    //   196: aload_1
    //   197: iload #9
    //   199: invokevirtual getPointerId : (I)I
    //   202: putfield am : I
    //   205: ldc_w 0.5
    //   208: aload_1
    //   209: iload #9
    //   211: invokevirtual getX : (I)F
    //   214: fadd
    //   215: f2i
    //   216: istore #44
    //   218: aload_0
    //   219: iload #44
    //   221: putfield aq : I
    //   224: aload_0
    //   225: iload #44
    //   227: putfield ao : I
    //   230: ldc_w 0.5
    //   233: aload_1
    //   234: iload #9
    //   236: invokevirtual getY : (I)F
    //   239: fadd
    //   240: f2i
    //   241: istore #45
    //   243: aload_0
    //   244: iload #45
    //   246: putfield ar : I
    //   249: aload_0
    //   250: iload #45
    //   252: putfield ap : I
    //   255: iconst_0
    //   256: istore_3
    //   257: goto -> 958
    //   260: aload_0
    //   261: invokespecial E : ()V
    //   264: iconst_0
    //   265: istore_3
    //   266: goto -> 958
    //   269: aload_1
    //   270: aload_0
    //   271: getfield am : I
    //   274: invokevirtual findPointerIndex : (I)I
    //   277: istore #17
    //   279: iload #17
    //   281: ifge -> 335
    //   284: new java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial <init> : ()V
    //   291: astore #18
    //   293: aload #18
    //   295: ldc_w 'Error processing scroll; pointer index for id '
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #18
    //   304: aload_0
    //   305: getfield am : I
    //   308: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload #18
    //   314: ldc_w ' not found. Did any MotionEvents get skipped?'
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc_w 'RecyclerView'
    //   324: aload #18
    //   326: invokevirtual toString : ()Ljava/lang/String;
    //   329: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   332: pop
    //   333: iconst_0
    //   334: ireturn
    //   335: ldc_w 0.5
    //   338: aload_1
    //   339: iload #17
    //   341: invokevirtual getX : (I)F
    //   344: fadd
    //   345: f2i
    //   346: istore #23
    //   348: ldc_w 0.5
    //   351: aload_1
    //   352: iload #17
    //   354: invokevirtual getY : (I)F
    //   357: fadd
    //   358: f2i
    //   359: istore #24
    //   361: aload_0
    //   362: getfield aq : I
    //   365: iload #23
    //   367: isub
    //   368: istore #25
    //   370: aload_0
    //   371: getfield ar : I
    //   374: iload #24
    //   376: isub
    //   377: istore #26
    //   379: aload_0
    //   380: getfield I : [I
    //   383: astore #27
    //   385: aload_0
    //   386: getfield aF : [I
    //   389: astore #28
    //   391: aload_0
    //   392: iload #25
    //   394: iload #26
    //   396: aload #27
    //   398: aload #28
    //   400: iconst_0
    //   401: invokevirtual a : (II[I[II)Z
    //   404: ifeq -> 494
    //   407: aload_0
    //   408: getfield I : [I
    //   411: astore #39
    //   413: iload #25
    //   415: aload #39
    //   417: iconst_0
    //   418: iaload
    //   419: isub
    //   420: istore #25
    //   422: iload #26
    //   424: aload #39
    //   426: iconst_1
    //   427: iaload
    //   428: isub
    //   429: istore #26
    //   431: aload_0
    //   432: getfield aF : [I
    //   435: astore #40
    //   437: aload #7
    //   439: aload #40
    //   441: iconst_0
    //   442: iaload
    //   443: i2f
    //   444: aload #40
    //   446: iconst_1
    //   447: iaload
    //   448: i2f
    //   449: invokevirtual offsetLocation : (FF)V
    //   452: aload_0
    //   453: getfield aG : [I
    //   456: astore #41
    //   458: aload #41
    //   460: iconst_0
    //   461: iaload
    //   462: istore #42
    //   464: aload_0
    //   465: getfield aF : [I
    //   468: astore #43
    //   470: aload #41
    //   472: iconst_0
    //   473: iload #42
    //   475: aload #43
    //   477: iconst_0
    //   478: iaload
    //   479: iadd
    //   480: iastore
    //   481: aload #41
    //   483: iconst_1
    //   484: aload #41
    //   486: iconst_1
    //   487: iaload
    //   488: aload #43
    //   490: iconst_1
    //   491: iaload
    //   492: iadd
    //   493: iastore
    //   494: aload_0
    //   495: getfield al : I
    //   498: iconst_1
    //   499: if_icmpeq -> 618
    //   502: iload #5
    //   504: ifeq -> 555
    //   507: iload #25
    //   509: invokestatic abs : (I)I
    //   512: istore #37
    //   514: aload_0
    //   515: getfield as : I
    //   518: istore #38
    //   520: iload #37
    //   522: iload #38
    //   524: if_icmple -> 555
    //   527: iload #25
    //   529: ifle -> 542
    //   532: iload #25
    //   534: iload #38
    //   536: isub
    //   537: istore #25
    //   539: goto -> 549
    //   542: iload #25
    //   544: iload #38
    //   546: iadd
    //   547: istore #25
    //   549: iconst_1
    //   550: istore #34
    //   552: goto -> 558
    //   555: iconst_0
    //   556: istore #34
    //   558: iload #6
    //   560: ifeq -> 608
    //   563: iload #26
    //   565: invokestatic abs : (I)I
    //   568: istore #35
    //   570: aload_0
    //   571: getfield as : I
    //   574: istore #36
    //   576: iload #35
    //   578: iload #36
    //   580: if_icmple -> 608
    //   583: iload #26
    //   585: ifle -> 598
    //   588: iload #26
    //   590: iload #36
    //   592: isub
    //   593: istore #26
    //   595: goto -> 605
    //   598: iload #26
    //   600: iload #36
    //   602: iadd
    //   603: istore #26
    //   605: iconst_1
    //   606: istore #34
    //   608: iload #34
    //   610: ifeq -> 618
    //   613: aload_0
    //   614: iconst_1
    //   615: invokevirtual setScrollState : (I)V
    //   618: aload_0
    //   619: getfield al : I
    //   622: istore #29
    //   624: iconst_0
    //   625: istore_3
    //   626: iload #29
    //   628: iconst_1
    //   629: if_icmpne -> 958
    //   632: aload_0
    //   633: getfield aF : [I
    //   636: astore #30
    //   638: aload_0
    //   639: iload #23
    //   641: aload #30
    //   643: iconst_0
    //   644: iaload
    //   645: isub
    //   646: putfield aq : I
    //   649: aload_0
    //   650: iload #24
    //   652: aload #30
    //   654: iconst_1
    //   655: iaload
    //   656: isub
    //   657: putfield ar : I
    //   660: iload #5
    //   662: ifeq -> 672
    //   665: iload #25
    //   667: istore #31
    //   669: goto -> 675
    //   672: iconst_0
    //   673: istore #31
    //   675: iload #6
    //   677: ifeq -> 687
    //   680: iload #26
    //   682: istore #32
    //   684: goto -> 690
    //   687: iconst_0
    //   688: istore #32
    //   690: aload_0
    //   691: iload #31
    //   693: iload #32
    //   695: aload #7
    //   697: invokevirtual a : (IILandroid/view/MotionEvent;)Z
    //   700: ifeq -> 713
    //   703: aload_0
    //   704: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   707: iconst_1
    //   708: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   713: aload_0
    //   714: getfield B : Landroid/support/v7/widget/aq;
    //   717: astore #33
    //   719: iconst_0
    //   720: istore_3
    //   721: aload #33
    //   723: ifnull -> 958
    //   726: iload #25
    //   728: ifne -> 738
    //   731: iconst_0
    //   732: istore_3
    //   733: iload #26
    //   735: ifeq -> 958
    //   738: aload_0
    //   739: getfield B : Landroid/support/v7/widget/aq;
    //   742: aload_0
    //   743: iload #25
    //   745: iload #26
    //   747: invokevirtual a : (Landroid/support/v7/widget/RecyclerView;II)V
    //   750: iconst_0
    //   751: istore_3
    //   752: goto -> 958
    //   755: aload_0
    //   756: getfield an : Landroid/view/VelocityTracker;
    //   759: aload #7
    //   761: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   764: aload_0
    //   765: getfield an : Landroid/view/VelocityTracker;
    //   768: sipush #1000
    //   771: aload_0
    //   772: getfield av : I
    //   775: i2f
    //   776: invokevirtual computeCurrentVelocity : (IF)V
    //   779: iload #5
    //   781: ifeq -> 801
    //   784: aload_0
    //   785: getfield an : Landroid/view/VelocityTracker;
    //   788: aload_0
    //   789: getfield am : I
    //   792: invokevirtual getXVelocity : (I)F
    //   795: fneg
    //   796: fstore #15
    //   798: goto -> 804
    //   801: fconst_0
    //   802: fstore #15
    //   804: iload #6
    //   806: ifeq -> 826
    //   809: aload_0
    //   810: getfield an : Landroid/view/VelocityTracker;
    //   813: aload_0
    //   814: getfield am : I
    //   817: invokevirtual getYVelocity : (I)F
    //   820: fneg
    //   821: fstore #16
    //   823: goto -> 829
    //   826: fconst_0
    //   827: fstore #16
    //   829: fload #15
    //   831: fconst_0
    //   832: fcmpl
    //   833: ifne -> 843
    //   836: fload #16
    //   838: fconst_0
    //   839: fcmpl
    //   840: ifeq -> 856
    //   843: aload_0
    //   844: fload #15
    //   846: f2i
    //   847: fload #16
    //   849: f2i
    //   850: invokevirtual b : (II)Z
    //   853: ifne -> 861
    //   856: aload_0
    //   857: iconst_0
    //   858: invokevirtual setScrollState : (I)V
    //   861: aload_0
    //   862: invokespecial D : ()V
    //   865: iconst_1
    //   866: istore_3
    //   867: goto -> 958
    //   870: aload_0
    //   871: aload_1
    //   872: iconst_0
    //   873: invokevirtual getPointerId : (I)I
    //   876: putfield am : I
    //   879: ldc_w 0.5
    //   882: aload_1
    //   883: invokevirtual getX : ()F
    //   886: fadd
    //   887: f2i
    //   888: istore #11
    //   890: aload_0
    //   891: iload #11
    //   893: putfield aq : I
    //   896: aload_0
    //   897: iload #11
    //   899: putfield ao : I
    //   902: ldc_w 0.5
    //   905: aload_1
    //   906: invokevirtual getY : ()F
    //   909: fadd
    //   910: f2i
    //   911: istore #12
    //   913: aload_0
    //   914: iload #12
    //   916: putfield ar : I
    //   919: aload_0
    //   920: iload #12
    //   922: putfield ap : I
    //   925: iload #5
    //   927: ifeq -> 936
    //   930: iconst_1
    //   931: istore #13
    //   933: goto -> 939
    //   936: iconst_0
    //   937: istore #13
    //   939: iload #6
    //   941: ifeq -> 950
    //   944: iload #13
    //   946: iconst_2
    //   947: ior
    //   948: istore #13
    //   950: aload_0
    //   951: iload #13
    //   953: iconst_0
    //   954: invokevirtual j : (II)Z
    //   957: pop
    //   958: iload_3
    //   959: ifne -> 971
    //   962: aload_0
    //   963: getfield an : Landroid/view/VelocityTracker;
    //   966: aload #7
    //   968: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   971: aload #7
    //   973: invokevirtual recycle : ()V
    //   976: iconst_1
    //   977: ireturn
    //   978: iconst_0
    //   979: ireturn }
  
  void p() {
    if (!this.G && this.q) {
      r.a(this, this.aH);
      this.G = true;
    } 
  }
  
  void q() { // Byte code:
    //   0: aload_0
    //   1: getfield m : Landroid/support/v7/widget/RecyclerView$a;
    //   4: ifnonnull -> 22
    //   7: ldc_w 'RecyclerView'
    //   10: astore_2
    //   11: ldc_w 'No adapter attached; skipping layout'
    //   14: astore_3
    //   15: aload_2
    //   16: aload_3
    //   17: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   20: pop
    //   21: return
    //   22: aload_0
    //   23: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   26: ifnonnull -> 40
    //   29: ldc_w 'RecyclerView'
    //   32: astore_2
    //   33: ldc_w 'No layout manager attached; skipping layout'
    //   36: astore_3
    //   37: goto -> 15
    //   40: aload_0
    //   41: getfield D : Landroid/support/v7/widget/RecyclerView$u;
    //   44: astore_1
    //   45: aload_1
    //   46: iconst_0
    //   47: putfield i : Z
    //   50: aload_1
    //   51: getfield d : I
    //   54: iconst_1
    //   55: if_icmpne -> 77
    //   58: aload_0
    //   59: invokespecial M : ()V
    //   62: aload_0
    //   63: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   66: aload_0
    //   67: invokevirtual f : (Landroid/support/v7/widget/RecyclerView;)V
    //   70: aload_0
    //   71: invokespecial N : ()V
    //   74: goto -> 126
    //   77: aload_0
    //   78: getfield f : Landroid/support/v7/widget/e;
    //   81: invokevirtual f : ()Z
    //   84: ifne -> 62
    //   87: aload_0
    //   88: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   91: invokevirtual y : ()I
    //   94: aload_0
    //   95: invokevirtual getWidth : ()I
    //   98: if_icmpne -> 62
    //   101: aload_0
    //   102: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   105: invokevirtual z : ()I
    //   108: aload_0
    //   109: invokevirtual getHeight : ()I
    //   112: if_icmpeq -> 118
    //   115: goto -> 62
    //   118: aload_0
    //   119: getfield n : Landroid/support/v7/widget/RecyclerView$i;
    //   122: aload_0
    //   123: invokevirtual f : (Landroid/support/v7/widget/RecyclerView;)V
    //   126: aload_0
    //   127: invokespecial O : ()V
    //   130: return }
  
  void r() {
    int i1 = this.g.c();
    for (byte b1 = 0; b1 < i1; b1++)
      ((j)this.g.d(b1).getLayoutParams()).e = true; 
    this.e.j();
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean) {
    x x1 = e(paramView);
    if (x1 != null)
      if (x1.r()) {
        x1.m();
      } else if (!x1.c()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        stringBuilder.append(x1);
        stringBuilder.append(a());
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    paramView.clearAnimation();
    k(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    if (!this.n.a(this, this.D, paramView1, paramView2) && paramView2 != null)
      a(paramView1, paramView2); 
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) { return this.n.a(this, paramView, paramRect, paramBoolean); }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    int i1 = this.U.size();
    for (byte b1 = 0; b1 < i1; b1++)
      ((m)this.U.get(b1)).a(paramBoolean); 
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout() {
    if (this.W == 0 && !this.v) {
      super.requestLayout();
      return;
    } 
    this.u = true;
  }
  
  void s() {
    int i1 = this.g.c();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x1 = e(this.g.d(b1));
      if (!x1.c())
        x1.b(); 
    } 
  }
  
  public void scrollBy(int paramInt1, int paramInt2) {
    i i1 = this.n;
    if (i1 == null) {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    if (this.v)
      return; 
    boolean bool1 = i1.e();
    boolean bool2 = this.n.f();
    if (bool1 || bool2) {
      if (!bool1)
        paramInt1 = 0; 
      if (!bool2)
        paramInt2 = 0; 
      a(paramInt1, paramInt2, null);
    } 
  }
  
  public void scrollTo(int paramInt1, int paramInt2) { Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead"); }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent) {
    if (a(paramAccessibilityEvent))
      return; 
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(ay paramay) {
    this.H = paramay;
    r.a(this, this.H);
  }
  
  public void setAdapter(a parama) {
    setLayoutFrozen(false);
    a(parama, false, true);
    c(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(d paramd) {
    boolean bool;
    if (paramd == this.aC)
      return; 
    this.aC = paramd;
    if (this.aC != null) {
      bool = true;
    } else {
      bool = false;
    } 
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    if (paramBoolean != this.i)
      k(); 
    this.i = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.t)
      requestLayout(); 
  }
  
  public void setEdgeEffectFactory(e parame) {
    k.a(parame);
    this.ag = parame;
    k();
  }
  
  public void setHasFixedSize(boolean paramBoolean) { this.r = paramBoolean; }
  
  public void setItemAnimator(f paramf) {
    f f1 = this.z;
    if (f1 != null) {
      f1.d();
      this.z.a(null);
    } 
    this.z = paramf;
    f f2 = this.z;
    if (f2 != null)
      f2.a(this.aB); 
  }
  
  public void setItemViewCacheSize(int paramInt) { this.e.a(paramInt); }
  
  public void setLayoutFrozen(boolean paramBoolean) {
    if (paramBoolean != this.v) {
      a("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean) {
        this.v = false;
        if (this.u && this.n != null && this.m != null)
          requestLayout(); 
        this.u = false;
        return;
      } 
      long l1 = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0));
      this.v = true;
      this.aa = true;
      f();
    } 
  }
  
  public void setLayoutManager(i parami) {
    if (parami == this.n)
      return; 
    f();
    if (this.n != null) {
      f f1 = this.z;
      if (f1 != null)
        f1.d(); 
      this.n.c(this.e);
      this.n.b(this.e);
      this.e.a();
      if (this.q)
        this.n.b(this, this.e); 
      this.n.b(null);
      this.n = null;
    } else {
      this.e.a();
    } 
    this.g.a();
    this.n = parami;
    if (parami != null)
      if (parami.q == null) {
        this.n.b(this);
        if (this.q)
          this.n.c(this); 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutManager ");
        stringBuilder.append(parami);
        stringBuilder.append(" is already attached to a RecyclerView:");
        stringBuilder.append(parami.q.a());
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    this.e.b();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) { getScrollingChildHelper().a(paramBoolean); }
  
  public void setOnFlingListener(l paraml) { this.at = paraml; }
  
  @Deprecated
  public void setOnScrollListener(n paramn) { this.az = paramn; }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean) { this.ay = paramBoolean; }
  
  public void setRecycledViewPool(o paramo) { this.e.a(paramo); }
  
  public void setRecyclerListener(q paramq) { this.o = paramq; }
  
  void setScrollState(int paramInt) {
    if (paramInt == this.al)
      return; 
    this.al = paramInt;
    if (paramInt != 2)
      B(); 
    g(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt) {
    StringBuilder stringBuilder;
    int i1;
    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        stringBuilder.append(paramInt);
        stringBuilder.append("; using default value");
        Log.w("RecyclerView", stringBuilder.toString());
      case 1:
        i1 = viewConfiguration.getScaledPagingTouchSlop();
        break;
      case 0:
        i1 = viewConfiguration.getScaledTouchSlop();
        break;
    } 
    this.as = i1;
  }
  
  public void setViewCacheExtension(v paramv) { this.e.a(paramv); }
  
  public boolean startNestedScroll(int paramInt) { return getScrollingChildHelper().b(paramInt); }
  
  public void stopNestedScroll() { getScrollingChildHelper().c(); }
  
  void t() {
    int i1 = this.g.c();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x1 = e(this.g.d(b1));
      if (!x1.c())
        x1.a(); 
    } 
    this.e.i();
  }
  
  void u() {
    int i1 = this.g.c();
    for (byte b1 = 0; b1 < i1; b1++) {
      x x1 = e(this.g.d(b1));
      if (x1 != null && !x1.c())
        x1.b(6); 
    } 
    r();
    this.e.h();
  }
  
  public boolean v() { return (!this.t || this.x || this.f.d()); }
  
  void w() {
    int i1 = this.g.b();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = this.g.b(b1);
      x x1 = b(view);
      if (x1 != null && x1.i != null) {
        View view1 = x1.i.a;
        int i2 = view.getLeft();
        int i3 = view.getTop();
        if (i2 != view1.getLeft() || i3 != view1.getTop())
          view1.layout(i2, i3, i2 + view1.getWidth(), i3 + view1.getHeight()); 
      } 
    } 
  }
  
  void x() {
    for (int i1 = -1 + this.K.size(); i1 >= 0; i1--) {
      x x1 = (x)this.K.get(i1);
      if (x1.a.getParent() == this && !x1.c()) {
        int i2 = x1.o;
        if (i2 != -1) {
          r.b(x1.a, i2);
          x1.o = -1;
        } 
      } 
    } 
    this.K.clear();
  }
  
  public static abstract class a<VH extends x> extends Object {
    private final RecyclerView.b a = new RecyclerView.b();
    
    private boolean b = false;
    
    public abstract int a();
    
    public int a(int param1Int) { return 0; }
    
    public abstract VH a(ViewGroup param1ViewGroup, int param1Int);
    
    public void a(RecyclerView.c param1c) { this.a.registerObserver(param1c); }
    
    public void a(VH param1VH) {}
    
    public abstract void a(VH param1VH, int param1Int);
    
    public void a(VH param1VH, int param1Int, List<Object> param1List) { a(param1VH, param1Int); }
    
    public void a(RecyclerView param1RecyclerView) {}
    
    public long b(int param1Int) { return -1L; }
    
    public final VH b(ViewGroup param1ViewGroup, int param1Int) {
      try {
        c.a("RV CreateView");
        x = a(param1ViewGroup, param1Int);
        if (x.a.getParent() == null) {
          x.f = param1Int;
          return (VH)x;
        } 
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      } finally {
        c.a();
      } 
    }
    
    public void b(RecyclerView.c param1c) { this.a.unregisterObserver(param1c); }
    
    public final void b(VH param1VH, int param1Int) {
      param1VH.c = param1Int;
      if (b())
        param1VH.e = b(param1Int); 
      param1VH.a(1, 519);
      c.a("RV OnBindView");
      a(param1VH, param1Int, param1VH.u());
      param1VH.t();
      ViewGroup.LayoutParams layoutParams = param1VH.a.getLayoutParams();
      if (layoutParams instanceof RecyclerView.j)
        ((RecyclerView.j)layoutParams).e = true; 
      c.a();
    }
    
    public void b(RecyclerView param1RecyclerView) {}
    
    public final boolean b() { return this.b; }
    
    public boolean b(VH param1VH) { return false; }
    
    public final void c() { this.a.a(); }
    
    public void c(VH param1VH) {}
    
    public void d(VH param1VH) {}
  }
  
  static class b extends Observable<c> {
    public void a() {
      for (int i = -1 + this.mObservers.size(); i >= 0; i--)
        ((RecyclerView.c)this.mObservers.get(i)).a(); 
    }
  }
  
  public static abstract class c {
    public void a() {}
  }
  
  public static interface d {
    int a(int param1Int1, int param1Int2);
  }
  
  public static class e {
    protected EdgeEffect a(RecyclerView param1RecyclerView, int param1Int) { return new EdgeEffect(param1RecyclerView.getContext()); }
  }
  
  public static abstract class f {
    private b a = null;
    
    private ArrayList<a> b = new ArrayList();
    
    private long c = 120L;
    
    private long d = 120L;
    
    private long e = 250L;
    
    private long f = 250L;
    
    static int e(RecyclerView.x param1x) {
      int i = 0xE & param1x.j;
      if (param1x.n())
        return 4; 
      if ((i & 0x4) == 0) {
        int j = param1x.f();
        int k = param1x.e();
        if (j != -1 && k != -1 && j != k)
          i |= 0x800; 
      } 
      return i;
    }
    
    public c a(RecyclerView.u param1u, RecyclerView.x param1x) { return j().a(param1x); }
    
    public c a(RecyclerView.u param1u, RecyclerView.x param1x, int param1Int, List<Object> param1List) { return j().a(param1x); }
    
    public abstract void a();
    
    void a(b param1b) { this.a = param1b; }
    
    public abstract boolean a(RecyclerView.x param1x, c param1c1, c param1c2);
    
    public abstract boolean a(RecyclerView.x param1x1, RecyclerView.x param1x2, c param1c1, c param1c2);
    
    public boolean a(RecyclerView.x param1x, List<Object> param1List) { return h(param1x); }
    
    public abstract boolean b();
    
    public abstract boolean b(RecyclerView.x param1x, c param1c1, c param1c2);
    
    public abstract boolean c(RecyclerView.x param1x, c param1c1, c param1c2);
    
    public abstract void d();
    
    public abstract void d(RecyclerView.x param1x);
    
    public long e() { return this.e; }
    
    public long f() { return this.c; }
    
    public final void f(RecyclerView.x param1x) {
      g(param1x);
      b b1 = this.a;
      if (b1 != null)
        b1.a(param1x); 
    }
    
    public long g() { return this.d; }
    
    public void g(RecyclerView.x param1x) {}
    
    public long h() { return this.f; }
    
    public boolean h(RecyclerView.x param1x) { return true; }
    
    public final void i() {
      int i = this.b.size();
      for (byte b1 = 0; b1 < i; b1++)
        ((a)this.b.get(b1)).a(); 
      this.b.clear();
    }
    
    public c j() { return new c(); }
    
    public static interface a {
      void a();
    }
    
    static interface b {
      void a(RecyclerView.x param2x);
    }
    
    public static class c {
      public int a;
      
      public int b;
      
      public int c;
      
      public int d;
      
      public c a(RecyclerView.x param2x) { return a(param2x, 0); }
      
      public c a(RecyclerView.x param2x, int param2Int) {
        View view = param2x.a;
        this.a = view.getLeft();
        this.b = view.getTop();
        this.c = view.getRight();
        this.d = view.getBottom();
        return this;
      }
    }
  }
  
  public static interface a {
    void a();
  }
  
  static interface b {
    void a(RecyclerView.x param1x);
  }
  
  public static class c {
    public int a;
    
    public int b;
    
    public int c;
    
    public int d;
    
    public c a(RecyclerView.x param1x) { return a(param1x, 0); }
    
    public c a(RecyclerView.x param1x, int param1Int) {
      View view = param1x.a;
      this.a = view.getLeft();
      this.b = view.getTop();
      this.c = view.getRight();
      this.d = view.getBottom();
      return this;
    }
  }
  
  private class g implements f.b {
    g(RecyclerView this$0) {}
    
    public void a(RecyclerView.x param1x) {
      param1x.a(true);
      if (param1x.h != null && param1x.i == null)
        param1x.h = null; 
      param1x.i = null;
      if (!param1x.x() && !this.a.a(param1x.a) && param1x.r())
        this.a.removeDetachedView(param1x.a, false); 
    }
  }
  
  public static abstract class h {
    @Deprecated
    public void a(Canvas param1Canvas, RecyclerView param1RecyclerView) {}
    
    public void a(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.u param1u) { b(param1Canvas, param1RecyclerView); }
    
    @Deprecated
    public void a(Rect param1Rect, int param1Int, RecyclerView param1RecyclerView) { param1Rect.set(0, 0, 0, 0); }
    
    public void a(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.u param1u) { a(param1Rect, ((RecyclerView.j)param1View.getLayoutParams()).f(), param1RecyclerView); }
    
    @Deprecated
    public void b(Canvas param1Canvas, RecyclerView param1RecyclerView) {}
    
    public void b(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.u param1u) { a(param1Canvas, param1RecyclerView); }
  }
  
  public static abstract class i {
    private final bs.b a = new bs.b(this) {
        public int a() { return this.a.A(); }
        
        public int a(View param2View) {
          RecyclerView.j j = (RecyclerView.j)param2View.getLayoutParams();
          return this.a.h(param2View) - j.leftMargin;
        }
        
        public View a(int param2Int) { return this.a.i(param2Int); }
        
        public int b() { return this.a.y() - this.a.C(); }
        
        public int b(View param2View) {
          RecyclerView.j j = (RecyclerView.j)param2View.getLayoutParams();
          return this.a.j(param2View) + j.rightMargin;
        }
      };
    
    private final bs.b b = new bs.b(this) {
        public int a() { return this.a.B(); }
        
        public int a(View param2View) {
          RecyclerView.j j = (RecyclerView.j)param2View.getLayoutParams();
          return this.a.i(param2View) - j.topMargin;
        }
        
        public View a(int param2Int) { return this.a.i(param2Int); }
        
        public int b() { return this.a.z() - this.a.D(); }
        
        public int b(View param2View) {
          RecyclerView.j j = (RecyclerView.j)param2View.getLayoutParams();
          return this.a.k(param2View) + j.bottomMargin;
        }
      };
    
    private boolean c = true;
    
    private boolean d = true;
    
    private int e;
    
    private int f;
    
    private int g;
    
    private int h;
    
    ah p;
    
    RecyclerView q;
    
    bs r = new bs(this.a);
    
    bs s = new bs(this.b);
    
    RecyclerView.t t;
    
    boolean u = false;
    
    boolean v = false;
    
    boolean w = false;
    
    int x;
    
    boolean y;
    
    public static int a(int param1Int1, int param1Int2, int param1Int3) {
      int j = View.MeasureSpec.getMode(param1Int1);
      int k = View.MeasureSpec.getSize(param1Int1);
      if (j != Integer.MIN_VALUE) {
        if (j != 1073741824)
          k = Math.max(param1Int2, param1Int3); 
        return k;
      } 
      return Math.min(k, Math.max(param1Int2, param1Int3));
    }
    
    public static int a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) { // Byte code:
      //   0: iload_0
      //   1: iload_2
      //   2: isub
      //   3: istore #5
      //   5: iconst_0
      //   6: istore #6
      //   8: iconst_0
      //   9: iload #5
      //   11: invokestatic max : (II)I
      //   14: istore #7
      //   16: iload #4
      //   18: ifeq -> 71
      //   21: iload_3
      //   22: iflt -> 28
      //   25: goto -> 75
      //   28: iload_3
      //   29: iconst_m1
      //   30: if_icmpne -> 124
      //   33: iload_1
      //   34: ldc -2147483648
      //   36: if_icmpeq -> 57
      //   39: iload_1
      //   40: ifeq -> 49
      //   43: iload_1
      //   44: ldc 1073741824
      //   46: if_icmpeq -> 57
      //   49: iconst_0
      //   50: istore_1
      //   51: iconst_0
      //   52: istore #8
      //   54: goto -> 61
      //   57: iload #7
      //   59: istore #8
      //   61: iload_1
      //   62: istore #6
      //   64: iload #8
      //   66: istore #7
      //   68: goto -> 127
      //   71: iload_3
      //   72: iflt -> 85
      //   75: iload_3
      //   76: istore #7
      //   78: ldc 1073741824
      //   80: istore #6
      //   82: goto -> 127
      //   85: iload_3
      //   86: iconst_m1
      //   87: if_icmpne -> 96
      //   90: iload_1
      //   91: istore #6
      //   93: goto -> 127
      //   96: iload_3
      //   97: bipush #-2
      //   99: if_icmpne -> 124
      //   102: iload_1
      //   103: ldc -2147483648
      //   105: if_icmpeq -> 117
      //   108: iconst_0
      //   109: istore #6
      //   111: iload_1
      //   112: ldc 1073741824
      //   114: if_icmpne -> 127
      //   117: ldc -2147483648
      //   119: istore #6
      //   121: goto -> 127
      //   124: iconst_0
      //   125: istore #7
      //   127: iload #7
      //   129: iload #6
      //   131: invokestatic makeMeasureSpec : (II)I
      //   134: ireturn }
    
    public static b a(Context param1Context, AttributeSet param1AttributeSet, int param1Int1, int param1Int2) {
      b b1 = new b();
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.b.RecyclerView, param1Int1, param1Int2);
      b1.a = typedArray.getInt(a.b.RecyclerView_android_orientation, 1);
      b1.b = typedArray.getInt(a.b.RecyclerView_spanCount, 1);
      b1.c = typedArray.getBoolean(a.b.RecyclerView_reverseLayout, false);
      b1.d = typedArray.getBoolean(a.b.RecyclerView_stackFromEnd, false);
      typedArray.recycle();
      return b1;
    }
    
    private void a(int param1Int, View param1View) { this.p.e(param1Int); }
    
    private void a(RecyclerView.p param1p, int param1Int, View param1View) {
      RecyclerView.x x1 = RecyclerView.e(param1View);
      if (x1.c())
        return; 
      if (x1.n() && !x1.q() && !this.q.m.b()) {
        g(param1Int);
        param1p.b(x1);
        return;
      } 
      h(param1Int);
      param1p.c(param1View);
      this.q.h.h(x1);
    }
    
    private void a(View param1View, int param1Int, boolean param1Boolean) {
      RecyclerView.x x1 = RecyclerView.e(param1View);
      if (param1Boolean || x1.q()) {
        this.q.h.e(x1);
      } else {
        this.q.h.f(x1);
      } 
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      if (x1.k() || x1.i()) {
        if (x1.i()) {
          x1.j();
        } else {
          x1.l();
        } 
        this.p.a(param1View, param1Int, param1View.getLayoutParams(), false);
      } else if (param1View.getParent() == this.q) {
        int k = this.p.b(param1View);
        if (param1Int == -1)
          param1Int = this.p.b(); 
        if (k != -1) {
          if (k != param1Int)
            this.q.n.e(k, param1Int); 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
          stringBuilder.append(this.q.indexOfChild(param1View));
          stringBuilder.append(this.q.a());
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        this.p.a(param1View, param1Int, false);
        j.e = true;
        RecyclerView.t t1 = this.t;
        if (t1 != null && t1.d())
          this.t.b(param1View); 
      } 
      if (j.f) {
        x1.a.invalidate();
        j.f = false;
      } 
    }
    
    private static boolean b(int param1Int1, int param1Int2, int param1Int3) {
      int j = View.MeasureSpec.getMode(param1Int2);
      int k = View.MeasureSpec.getSize(param1Int2);
      if (param1Int3 > 0 && param1Int1 != param1Int3)
        return false; 
      if (j != Integer.MIN_VALUE) {
        if (j != 0) {
          if (j != 1073741824)
            return false; 
          boolean bool1 = false;
          if (k == param1Int1)
            bool1 = true; 
          return bool1;
        } 
        return true;
      } 
      boolean bool = false;
      if (k >= param1Int1)
        bool = true; 
      return bool;
    }
    
    private int[] b(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean) {
      int[] arrayOfInt = new int[2];
      int j = A();
      int k = B();
      int m = y() - C();
      int n = z() - D();
      int i1 = param1View.getLeft() + param1Rect.left - param1View.getScrollX();
      int i2 = param1View.getTop() + param1Rect.top - param1View.getScrollY();
      int i3 = i1 + param1Rect.width();
      int i4 = i2 + param1Rect.height();
      int i5 = i1 - j;
      int i6 = Math.min(0, i5);
      int i7 = i2 - k;
      int i8 = Math.min(0, i7);
      int i9 = i3 - m;
      int i10 = Math.max(0, i9);
      int i11 = Math.max(0, i4 - n);
      if (t() == 1) {
        if (i10 == 0)
          i10 = Math.max(i6, i9); 
      } else {
        if (i6 == 0)
          i6 = Math.min(i5, i10); 
        i10 = i6;
      } 
      if (i8 == 0)
        i8 = Math.min(i7, i11); 
      arrayOfInt[0] = i10;
      arrayOfInt[1] = i8;
      return arrayOfInt;
    }
    
    private boolean d(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
      View view = param1RecyclerView.getFocusedChild();
      if (view == null)
        return false; 
      int j = A();
      int k = B();
      int m = y() - C();
      int n = z() - D();
      Rect rect = this.q.k;
      a(view, rect);
      return (rect.left - param1Int1 < m && rect.right - param1Int1 > j && rect.top - param1Int2 < n) ? (!(rect.bottom - param1Int2 <= k)) : false;
    }
    
    public int A() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingLeft() : 0;
    }
    
    public int B() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingTop() : 0;
    }
    
    public int C() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingRight() : 0;
    }
    
    public int D() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingBottom() : 0;
    }
    
    public View E() {
      RecyclerView recyclerView = this.q;
      if (recyclerView == null)
        return null; 
      View view = recyclerView.getFocusedChild();
      return (view != null) ? (this.p.c(view) ? null : view) : null;
    }
    
    public int F() { return r.j(this.q); }
    
    public int G() { return r.k(this.q); }
    
    void H() {
      RecyclerView.t t1 = this.t;
      if (t1 != null)
        t1.b(); 
    }
    
    public void I() { this.u = true; }
    
    boolean J() {
      int j = v();
      for (byte b1 = 0; b1 < j; b1++) {
        ViewGroup.LayoutParams layoutParams = i(b1).getLayoutParams();
        if (layoutParams.width < 0 && layoutParams.height < 0)
          return true; 
      } 
      return false;
    }
    
    public int a(int param1Int, RecyclerView.p param1p, RecyclerView.u param1u) { return 0; }
    
    public int a(RecyclerView.p param1p, RecyclerView.u param1u) {
      RecyclerView recyclerView = this.q;
      int j = 1;
      if (recyclerView != null) {
        if (recyclerView.m == null)
          return j; 
        if (f())
          j = this.q.m.a(); 
      } 
      return j;
    }
    
    public abstract RecyclerView.j a();
    
    public RecyclerView.j a(Context param1Context, AttributeSet param1AttributeSet) { return new RecyclerView.j(param1Context, param1AttributeSet); }
    
    public RecyclerView.j a(ViewGroup.LayoutParams param1LayoutParams) { return (param1LayoutParams instanceof RecyclerView.j) ? new RecyclerView.j((RecyclerView.j)param1LayoutParams) : ((param1LayoutParams instanceof ViewGroup.MarginLayoutParams) ? new RecyclerView.j((ViewGroup.MarginLayoutParams)param1LayoutParams) : new RecyclerView.j(param1LayoutParams)); }
    
    public View a(View param1View, int param1Int, RecyclerView.p param1p, RecyclerView.u param1u) { return null; }
    
    public void a(int param1Int1, int param1Int2, RecyclerView.u param1u, a param1a) {}
    
    public void a(int param1Int, a param1a) {}
    
    public void a(int param1Int, RecyclerView.p param1p) {
      View view = i(param1Int);
      g(param1Int);
      param1p.a(view);
    }
    
    public void a(Rect param1Rect, int param1Int1, int param1Int2) {
      int j = param1Rect.width() + A() + C();
      int k = param1Rect.height() + B() + D();
      f(a(param1Int1, j, F()), a(param1Int2, k, G()));
    }
    
    public void a(Parcelable param1Parcelable) {}
    
    void a(c param1c) { a(this.q.e, this.q.D, param1c); }
    
    public void a(RecyclerView.a param1a1, RecyclerView.a param1a2) {}
    
    public void a(RecyclerView.p param1p) {
      for (int j = -1 + v(); j >= 0; j--)
        a(param1p, j, i(j)); 
    }
    
    public void a(RecyclerView.p param1p, RecyclerView.u param1u, int param1Int1, int param1Int2) { this.q.e(param1Int1, param1Int2); }
    
    public void a(RecyclerView.p param1p, RecyclerView.u param1u, c param1c) {
      if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
        param1c.a(8192);
        param1c.c(true);
      } 
      if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
        param1c.a(4096);
        param1c.c(true);
      } 
      param1c.a(c.a.a(a(param1p, param1u), b(param1p, param1u), e(param1p, param1u), d(param1p, param1u)));
    }
    
    public void a(RecyclerView.p param1p, RecyclerView.u param1u, View param1View, c param1c) {
      byte b2;
      byte b1;
      if (f()) {
        b1 = d(param1View);
      } else {
        b1 = 0;
      } 
      if (e()) {
        b2 = d(param1View);
      } else {
        b2 = 0;
      } 
      param1c.b(c.b.a(b1, 1, b2, 1, false, false));
    }
    
    public void a(RecyclerView.p param1p, RecyclerView.u param1u, AccessibilityEvent param1AccessibilityEvent) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null) {
        if (param1AccessibilityEvent == null)
          return; 
        int j = 1;
        if (!recyclerView.canScrollVertically(j) && !this.q.canScrollVertically(-1) && !this.q.canScrollHorizontally(-1) && !this.q.canScrollHorizontally(j))
          j = 0; 
        param1AccessibilityEvent.setScrollable(j);
        if (this.q.m != null)
          param1AccessibilityEvent.setItemCount(this.q.m.a()); 
      } 
    }
    
    void a(RecyclerView.t param1t) {
      if (this.t == param1t)
        this.t = null; 
    }
    
    public void a(RecyclerView.u param1u) {}
    
    public void a(RecyclerView param1RecyclerView) {}
    
    public void a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, Object param1Object) { c(param1RecyclerView, param1Int1, param1Int2); }
    
    public void a(RecyclerView param1RecyclerView, RecyclerView.p param1p) { e(param1RecyclerView); }
    
    public void a(View param1View) { a(param1View, -1); }
    
    public void a(View param1View, int param1Int) { a(param1View, param1Int, true); }
    
    public void a(View param1View, int param1Int1, int param1Int2) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      Rect rect = this.q.i(param1View);
      int k = param1Int1 + rect.left + rect.right;
      int m = param1Int2 + rect.top + rect.bottom;
      int n = a(y(), w(), k + A() + C() + j.leftMargin + j.rightMargin, j.width, e());
      int i1 = a(z(), x(), m + B() + D() + j.topMargin + j.bottomMargin, j.height, f());
      if (b(param1View, n, i1, j))
        param1View.measure(n, i1); 
    }
    
    public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      Rect rect = j.d;
      param1View.layout(param1Int1 + rect.left + j.leftMargin, param1Int2 + rect.top + j.topMargin, param1Int3 - rect.right - j.rightMargin, param1Int4 - rect.bottom - j.bottomMargin);
    }
    
    public void a(View param1View, int param1Int, RecyclerView.j param1j) {
      RecyclerView.x x1 = RecyclerView.e(param1View);
      if (x1.q()) {
        this.q.h.e(x1);
      } else {
        this.q.h.f(x1);
      } 
      this.p.a(param1View, param1Int, param1j, x1.q());
    }
    
    public void a(View param1View, Rect param1Rect) { RecyclerView.a(param1View, param1Rect); }
    
    void a(View param1View, c param1c) {
      RecyclerView.x x1 = RecyclerView.e(param1View);
      if (x1 != null && !x1.q() && !this.p.c(x1.a))
        a(this.q.e, this.q.D, param1View, param1c); 
    }
    
    public void a(View param1View, RecyclerView.p param1p) {
      c(param1View);
      param1p.a(param1View);
    }
    
    public void a(View param1View, boolean param1Boolean, Rect param1Rect) {
      if (param1Boolean) {
        Rect rect = ((RecyclerView.j)param1View.getLayoutParams()).d;
        param1Rect.set(-rect.left, -rect.top, param1View.getWidth() + rect.right, param1View.getHeight() + rect.bottom);
      } else {
        param1Rect.set(0, 0, param1View.getWidth(), param1View.getHeight());
      } 
      if (this.q != null) {
        Matrix matrix = param1View.getMatrix();
        if (matrix != null && !matrix.isIdentity()) {
          RectF rectF = this.q.l;
          rectF.set(param1Rect);
          matrix.mapRect(rectF);
          param1Rect.set((int)Math.floor(rectF.left), (int)Math.floor(rectF.top), (int)Math.ceil(rectF.right), (int)Math.ceil(rectF.bottom));
        } 
      } 
      param1Rect.offset(param1View.getLeft(), param1View.getTop());
    }
    
    public void a(AccessibilityEvent param1AccessibilityEvent) { a(this.q.e, this.q.D, param1AccessibilityEvent); }
    
    public void a(String param1String) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.a(param1String); 
    }
    
    boolean a(int param1Int, Bundle param1Bundle) { return a(this.q.e, this.q.D, param1Int, param1Bundle); }
    
    public boolean a(RecyclerView.j param1j) { return (param1j != null); }
    
    public boolean a(RecyclerView.p param1p, RecyclerView.u param1u, int param1Int, Bundle param1Bundle) { // Byte code:
      //   0: aload_0
      //   1: getfield q : Landroid/support/v7/widget/RecyclerView;
      //   4: astore #5
      //   6: aload #5
      //   8: ifnonnull -> 13
      //   11: iconst_0
      //   12: ireturn
      //   13: iload_3
      //   14: sipush #4096
      //   17: if_icmpeq -> 99
      //   20: iload_3
      //   21: sipush #8192
      //   24: if_icmpeq -> 36
      //   27: iconst_0
      //   28: istore #6
      //   30: iconst_0
      //   31: istore #7
      //   33: goto -> 157
      //   36: aload #5
      //   38: iconst_m1
      //   39: invokevirtual canScrollVertically : (I)Z
      //   42: ifeq -> 65
      //   45: aload_0
      //   46: invokevirtual z : ()I
      //   49: aload_0
      //   50: invokevirtual B : ()I
      //   53: isub
      //   54: aload_0
      //   55: invokevirtual D : ()I
      //   58: isub
      //   59: ineg
      //   60: istore #6
      //   62: goto -> 68
      //   65: iconst_0
      //   66: istore #6
      //   68: aload_0
      //   69: getfield q : Landroid/support/v7/widget/RecyclerView;
      //   72: iconst_m1
      //   73: invokevirtual canScrollHorizontally : (I)Z
      //   76: ifeq -> 30
      //   79: aload_0
      //   80: invokevirtual y : ()I
      //   83: aload_0
      //   84: invokevirtual A : ()I
      //   87: isub
      //   88: aload_0
      //   89: invokevirtual C : ()I
      //   92: isub
      //   93: ineg
      //   94: istore #7
      //   96: goto -> 157
      //   99: aload #5
      //   101: iconst_1
      //   102: invokevirtual canScrollVertically : (I)Z
      //   105: ifeq -> 127
      //   108: aload_0
      //   109: invokevirtual z : ()I
      //   112: aload_0
      //   113: invokevirtual B : ()I
      //   116: isub
      //   117: aload_0
      //   118: invokevirtual D : ()I
      //   121: isub
      //   122: istore #6
      //   124: goto -> 130
      //   127: iconst_0
      //   128: istore #6
      //   130: aload_0
      //   131: getfield q : Landroid/support/v7/widget/RecyclerView;
      //   134: iconst_1
      //   135: invokevirtual canScrollHorizontally : (I)Z
      //   138: ifeq -> 30
      //   141: aload_0
      //   142: invokevirtual y : ()I
      //   145: aload_0
      //   146: invokevirtual A : ()I
      //   149: isub
      //   150: aload_0
      //   151: invokevirtual C : ()I
      //   154: isub
      //   155: istore #7
      //   157: iload #6
      //   159: ifne -> 169
      //   162: iload #7
      //   164: ifne -> 169
      //   167: iconst_0
      //   168: ireturn
      //   169: aload_0
      //   170: getfield q : Landroid/support/v7/widget/RecyclerView;
      //   173: iload #7
      //   175: iload #6
      //   177: invokevirtual a : (II)V
      //   180: iconst_1
      //   181: ireturn }
    
    public boolean a(RecyclerView.p param1p, RecyclerView.u param1u, View param1View, int param1Int, Bundle param1Bundle) { return false; }
    
    public boolean a(RecyclerView param1RecyclerView, RecyclerView.u param1u, View param1View1, View param1View2) { return a(param1RecyclerView, param1View1, param1View2); }
    
    public boolean a(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean) { return a(param1RecyclerView, param1View, param1Rect, param1Boolean, false); }
    
    public boolean a(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean1, boolean param1Boolean2) {
      int[] arrayOfInt = b(param1RecyclerView, param1View, param1Rect, param1Boolean1);
      int j = arrayOfInt[0];
      int k = arrayOfInt[1];
      if ((!param1Boolean2 || d(param1RecyclerView, j, k)) && (j != 0 || k != 0)) {
        if (param1Boolean1) {
          param1RecyclerView.scrollBy(j, k);
          return true;
        } 
        param1RecyclerView.a(j, k);
        return true;
      } 
      return false;
    }
    
    @Deprecated
    public boolean a(RecyclerView param1RecyclerView, View param1View1, View param1View2) { return (s() || param1RecyclerView.o()); }
    
    public boolean a(RecyclerView param1RecyclerView, ArrayList<View> param1ArrayList, int param1Int1, int param1Int2) { return false; }
    
    boolean a(View param1View, int param1Int1, int param1Int2, RecyclerView.j param1j) { return (!this.c || !b(param1View.getMeasuredWidth(), param1Int1, param1j.width) || !b(param1View.getMeasuredHeight(), param1Int2, param1j.height)); }
    
    boolean a(View param1View, int param1Int, Bundle param1Bundle) { return a(this.q.e, this.q.D, param1View, param1Int, param1Bundle); }
    
    public boolean a(View param1View, boolean param1Boolean1, boolean param1Boolean2) {
      boolean bool;
      if (this.r.a(param1View, 24579) && this.s.a(param1View, 24579)) {
        bool = true;
      } else {
        bool = false;
      } 
      return param1Boolean1 ? bool : (bool ^ true);
    }
    
    public boolean a(Runnable param1Runnable) {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.removeCallbacks(param1Runnable) : 0;
    }
    
    public int b(int param1Int, RecyclerView.p param1p, RecyclerView.u param1u) { return 0; }
    
    public int b(RecyclerView.p param1p, RecyclerView.u param1u) {
      RecyclerView recyclerView = this.q;
      int j = 1;
      if (recyclerView != null) {
        if (recyclerView.m == null)
          return j; 
        if (e())
          j = this.q.m.a(); 
      } 
      return j;
    }
    
    void b(RecyclerView.p param1p) {
      int j = param1p.e();
      for (int k = j - 1; k >= 0; k--) {
        View view = param1p.e(k);
        RecyclerView.x x1 = RecyclerView.e(view);
        if (!x1.c()) {
          x1.a(false);
          if (x1.r())
            this.q.removeDetachedView(view, false); 
          if (this.q.z != null)
            this.q.z.d(x1); 
          x1.a(true);
          param1p.b(view);
        } 
      } 
      param1p.f();
      if (j > 0)
        this.q.invalidate(); 
    }
    
    void b(RecyclerView param1RecyclerView) {
      int j;
      if (param1RecyclerView == null) {
        this.q = null;
        this.p = null;
        this.g = 0;
        j = 0;
      } else {
        this.q = param1RecyclerView;
        this.p = param1RecyclerView.g;
        this.g = param1RecyclerView.getWidth();
        j = param1RecyclerView.getHeight();
      } 
      this.h = j;
      this.e = 1073741824;
      this.f = 1073741824;
    }
    
    public void b(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    void b(RecyclerView param1RecyclerView, RecyclerView.p param1p) {
      this.v = false;
      a(param1RecyclerView, param1p);
    }
    
    public void b(View param1View) { b(param1View, -1); }
    
    public void b(View param1View, int param1Int) { a(param1View, param1Int, false); }
    
    public void b(View param1View, Rect param1Rect) {
      RecyclerView recyclerView = this.q;
      if (recyclerView == null) {
        param1Rect.set(0, 0, 0, 0);
        return;
      } 
      param1Rect.set(recyclerView.i(param1View));
    }
    
    public boolean b() { return false; }
    
    boolean b(View param1View, int param1Int1, int param1Int2, RecyclerView.j param1j) { return (param1View.isLayoutRequested() || !this.c || !b(param1View.getWidth(), param1Int1, param1j.width) || !b(param1View.getHeight(), param1Int2, param1j.height)); }
    
    public int c(RecyclerView.u param1u) { return 0; }
    
    public View c(int param1Int) {
      int j = v();
      for (byte b1 = 0; b1 < j; b1++) {
        View view = i(b1);
        RecyclerView.x x1 = RecyclerView.e(view);
        if (x1 != null && x1.d() == param1Int && !x1.c() && (this.q.D.a() || !x1.q()))
          return view; 
      } 
      return null;
    }
    
    void c(int param1Int1, int param1Int2) {
      this.g = View.MeasureSpec.getSize(param1Int1);
      this.e = View.MeasureSpec.getMode(param1Int1);
      if (this.e == 0 && !RecyclerView.b)
        this.g = 0; 
      this.h = View.MeasureSpec.getSize(param1Int2);
      this.f = View.MeasureSpec.getMode(param1Int2);
      if (this.f == 0 && !RecyclerView.b)
        this.h = 0; 
    }
    
    public void c(RecyclerView.p param1p) {
      for (int j = -1 + v(); j >= 0; j--) {
        if (!RecyclerView.e(i(j)).c())
          a(j, param1p); 
      } 
    }
    
    public void c(RecyclerView.p param1p, RecyclerView.u param1u) { Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) "); }
    
    void c(RecyclerView param1RecyclerView) {
      this.v = true;
      d(param1RecyclerView);
    }
    
    public void c(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void c(View param1View) { this.p.a(param1View); }
    
    public void c(View param1View, int param1Int) { a(param1View, param1Int, (RecyclerView.j)param1View.getLayoutParams()); }
    
    public boolean c() { return this.w; }
    
    public int d(RecyclerView.p param1p, RecyclerView.u param1u) { return 0; }
    
    public int d(RecyclerView.u param1u) { return 0; }
    
    public int d(View param1View) { return ((RecyclerView.j)param1View.getLayoutParams()).f(); }
    
    public Parcelable d() { return null; }
    
    public View d(View param1View, int param1Int) { return null; }
    
    void d(int param1Int1, int param1Int2) {
      int j = v();
      if (j == 0) {
        this.q.e(param1Int1, param1Int2);
        return;
      } 
      byte b1 = 0;
      int k = Integer.MAX_VALUE;
      int m = Integer.MAX_VALUE;
      int n = Integer.MIN_VALUE;
      int i1 = Integer.MIN_VALUE;
      while (b1 < j) {
        View view = i(b1);
        Rect rect = this.q.k;
        a(view, rect);
        if (rect.left < k)
          k = rect.left; 
        if (rect.right > n)
          n = rect.right; 
        if (rect.top < m)
          m = rect.top; 
        if (rect.bottom > i1)
          i1 = rect.bottom; 
        b1++;
      } 
      this.q.k.set(k, m, n, i1);
      a(this.q.k, param1Int1, param1Int2);
    }
    
    public void d(RecyclerView param1RecyclerView) {}
    
    public int e(RecyclerView.u param1u) { return 0; }
    
    public View e(View param1View) {
      RecyclerView recyclerView = this.q;
      if (recyclerView == null)
        return null; 
      View view = recyclerView.c(param1View);
      return (view == null) ? null : (this.p.c(view) ? null : view);
    }
    
    public void e(int param1Int) {}
    
    public void e(int param1Int1, int param1Int2) {
      View view = i(param1Int1);
      if (view != null) {
        h(param1Int1);
        c(view, param1Int2);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot move a child from non-existing index:");
      stringBuilder.append(param1Int1);
      stringBuilder.append(this.q.toString());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    @Deprecated
    public void e(RecyclerView param1RecyclerView) {}
    
    public boolean e() { return false; }
    
    public boolean e(RecyclerView.p param1p, RecyclerView.u param1u) { return false; }
    
    public int f(RecyclerView.u param1u) { return 0; }
    
    public int f(View param1View) {
      Rect rect = ((RecyclerView.j)param1View.getLayoutParams()).d;
      return param1View.getMeasuredWidth() + rect.left + rect.right;
    }
    
    public void f(int param1Int1, int param1Int2) { RecyclerView.a(this.q, param1Int1, param1Int2); }
    
    void f(RecyclerView param1RecyclerView) { c(View.MeasureSpec.makeMeasureSpec(param1RecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(param1RecyclerView.getHeight(), 1073741824)); }
    
    public boolean f() { return false; }
    
    public int g(RecyclerView.u param1u) { return 0; }
    
    public int g(View param1View) {
      Rect rect = ((RecyclerView.j)param1View.getLayoutParams()).d;
      return param1View.getMeasuredHeight() + rect.top + rect.bottom;
    }
    
    public void g(int param1Int) {
      if (i(param1Int) != null)
        this.p.a(param1Int); 
    }
    
    public int h(RecyclerView.u param1u) { return 0; }
    
    public int h(View param1View) { return param1View.getLeft() - n(param1View); }
    
    public void h(int param1Int) { a(param1Int, i(param1Int)); }
    
    public int i(View param1View) { return param1View.getTop() - l(param1View); }
    
    public View i(int param1Int) {
      ah ah1 = this.p;
      return (ah1 != null) ? ah1.b(param1Int) : null;
    }
    
    public int j(View param1View) { return param1View.getRight() + o(param1View); }
    
    public void j(int param1Int) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.e(param1Int); 
    }
    
    public int k(View param1View) { return param1View.getBottom() + m(param1View); }
    
    public void k(int param1Int) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.d(param1Int); 
    }
    
    public int l(View param1View) { return ((RecyclerView.j)param1View.getLayoutParams()).d.top; }
    
    public void l(int param1Int) {}
    
    boolean l() { return false; }
    
    public int m(View param1View) { return ((RecyclerView.j)param1View.getLayoutParams()).d.bottom; }
    
    public int n(View param1View) { return ((RecyclerView.j)param1View.getLayoutParams()).d.left; }
    
    public int o(View param1View) { return ((RecyclerView.j)param1View.getLayoutParams()).d.right; }
    
    public void o() {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.requestLayout(); 
    }
    
    public final boolean p() { return this.d; }
    
    public boolean q() { return this.v; }
    
    public boolean r() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null && recyclerView.i);
    }
    
    public boolean s() {
      RecyclerView.t t1 = this.t;
      return (t1 != null && t1.d());
    }
    
    public int t() { return r.f(this.q); }
    
    public int u() { return -1; }
    
    public int v() {
      ah ah1 = this.p;
      return (ah1 != null) ? ah1.b() : 0;
    }
    
    public int w() { return this.e; }
    
    public int x() { return this.f; }
    
    public int y() { return this.g; }
    
    public int z() { return this.h; }
    
    public static interface a {
      void b(int param2Int1, int param2Int2);
    }
    
    public static class b {
      public int a;
      
      public int b;
      
      public boolean c;
      
      public boolean d;
    }
  }
  
  class null implements bs.b {
    null(RecyclerView this$0) {}
    
    public int a() { return this.a.A(); }
    
    public int a(View param1View) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      return this.a.h(param1View) - j.leftMargin;
    }
    
    public View a(int param1Int) { return this.a.i(param1Int); }
    
    public int b() { return this.a.y() - this.a.C(); }
    
    public int b(View param1View) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      return this.a.j(param1View) + j.rightMargin;
    }
  }
  
  class null implements bs.b {
    null(RecyclerView this$0) {}
    
    public int a() { return this.a.B(); }
    
    public int a(View param1View) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      return this.a.i(param1View) - j.topMargin;
    }
    
    public View a(int param1Int) { return this.a.i(param1Int); }
    
    public int b() { return this.a.z() - this.a.D(); }
    
    public int b(View param1View) {
      RecyclerView.j j = (RecyclerView.j)param1View.getLayoutParams();
      return this.a.k(param1View) + j.bottomMargin;
    }
  }
  
  public static interface a {
    void b(int param1Int1, int param1Int2);
  }
  
  public static class b {
    public int a;
    
    public int b;
    
    public boolean c;
    
    public boolean d;
  }
  
  public static class j extends ViewGroup.MarginLayoutParams {
    RecyclerView.x c;
    
    final Rect d = new Rect();
    
    boolean e = true;
    
    boolean f = false;
    
    public j(int param1Int1, int param1Int2) { super(param1Int1, param1Int2); }
    
    public j(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    public j(j param1j) { super(param1j); }
    
    public j(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public j(ViewGroup.MarginLayoutParams param1MarginLayoutParams) { super(param1MarginLayoutParams); }
    
    public boolean c() { return this.c.n(); }
    
    public boolean d() { return this.c.q(); }
    
    public boolean e() { return this.c.z(); }
    
    public int f() { return this.c.d(); }
  }
  
  public static interface k {
    void a(View param1View);
    
    void b(View param1View);
  }
  
  public static abstract class l {
    public abstract boolean a(int param1Int1, int param1Int2);
  }
  
  public static interface m {
    void a(boolean param1Boolean);
    
    boolean a(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent);
    
    void b(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent);
  }
  
  public static abstract class n {
    public void a(RecyclerView param1RecyclerView, int param1Int) {}
    
    public void a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
  }
  
  public static class o {
    SparseArray<a> a = new SparseArray();
    
    private int b = 0;
    
    private a b(int param1Int) {
      a a1 = (a)this.a.get(param1Int);
      if (a1 == null) {
        a1 = new a();
        this.a.put(param1Int, a1);
      } 
      return a1;
    }
    
    long a(long param1Long1, long param1Long2) { return (param1Long1 == 0L) ? param1Long2 : (3L * param1Long1 / 4L + param1Long2 / 4L); }
    
    public RecyclerView.x a(int param1Int) {
      a a1 = (a)this.a.get(param1Int);
      if (a1 != null && !a1.a.isEmpty()) {
        ArrayList arrayList = a1.a;
        return (RecyclerView.x)arrayList.remove(-1 + arrayList.size());
      } 
      return null;
    }
    
    public void a() {
      for (byte b1 = 0; b1 < this.a.size(); b1++)
        ((a)this.a.valueAt(b1)).a.clear(); 
    }
    
    void a(int param1Int, long param1Long) {
      a a1 = b(param1Int);
      a1.c = a(a1.c, param1Long);
    }
    
    void a(RecyclerView.a param1a1, RecyclerView.a param1a2, boolean param1Boolean) {
      if (param1a1 != null)
        c(); 
      if (!param1Boolean && this.b == 0)
        a(); 
      if (param1a2 != null)
        b(); 
    }
    
    public void a(RecyclerView.x param1x) {
      int i = param1x.h();
      ArrayList arrayList = (b(i)).a;
      if (((a)this.a.get(i)).b <= arrayList.size())
        return; 
      param1x.v();
      arrayList.add(param1x);
    }
    
    boolean a(int param1Int, long param1Long1, long param1Long2) {
      long l = (b(param1Int)).c;
      return (l == 0L || param1Long1 + l < param1Long2);
    }
    
    void b() { this.b = 1 + this.b; }
    
    void b(int param1Int, long param1Long) {
      a a1 = b(param1Int);
      a1.d = a(a1.d, param1Long);
    }
    
    boolean b(int param1Int, long param1Long1, long param1Long2) {
      long l = (b(param1Int)).d;
      return (l == 0L || param1Long1 + l < param1Long2);
    }
    
    void c() { this.b = -1 + this.b; }
    
    static class a {
      final ArrayList<RecyclerView.x> a = new ArrayList();
      
      int b = 5;
      
      long c = 0L;
      
      long d = 0L;
    }
  }
  
  static class a {
    final ArrayList<RecyclerView.x> a = new ArrayList();
    
    int b = 5;
    
    long c = 0L;
    
    long d = 0L;
  }
  
  public final class p {
    final ArrayList<RecyclerView.x> a = new ArrayList();
    
    ArrayList<RecyclerView.x> b = null;
    
    final ArrayList<RecyclerView.x> c = new ArrayList();
    
    int d = 2;
    
    RecyclerView.o e;
    
    private final List<RecyclerView.x> g = Collections.unmodifiableList(this.a);
    
    private int h = 2;
    
    private RecyclerView.v i;
    
    public p(RecyclerView this$0) {}
    
    private void a(ViewGroup param1ViewGroup, boolean param1Boolean) {
      for (int j = param1ViewGroup.getChildCount() - 1; j >= 0; j--) {
        View view = param1ViewGroup.getChildAt(j);
        if (view instanceof ViewGroup)
          a((ViewGroup)view, true); 
      } 
      if (!param1Boolean)
        return; 
      if (param1ViewGroup.getVisibility() == 4) {
        param1ViewGroup.setVisibility(0);
        param1ViewGroup.setVisibility(4);
        return;
      } 
      int k = param1ViewGroup.getVisibility();
      param1ViewGroup.setVisibility(4);
      param1ViewGroup.setVisibility(k);
    }
    
    private boolean a(RecyclerView.x param1x, int param1Int1, int param1Int2, long param1Long) {
      param1x.p = this.f;
      int j = param1x.h();
      long l1 = this.f.getNanoTime();
      if (param1Long != Float.MAX_VALUE && !this.e.b(j, l1, param1Long))
        return false; 
      this.f.m.b(param1x, param1Int1);
      long l2 = this.f.getNanoTime();
      this.e.b(param1x.h(), l2 - l1);
      e(param1x);
      if (this.f.D.a())
        param1x.g = param1Int2; 
      return true;
    }
    
    private void e(RecyclerView.x param1x) {
      if (this.f.n()) {
        View view = param1x.a;
        if (r.e(view) == 0)
          r.b(view, 1); 
        if (!r.b(view)) {
          param1x.b(16384);
          r.a(view, this.f.H.c());
        } 
      } 
    }
    
    private void f(RecyclerView.x param1x) {
      if (param1x.a instanceof ViewGroup)
        a((ViewGroup)param1x.a, false); 
    }
    
    RecyclerView.x a(int param1Int, boolean param1Boolean, long param1Long) { // Byte code:
      //   0: iload_1
      //   1: iflt -> 971
      //   4: iload_1
      //   5: aload_0
      //   6: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   9: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   12: invokevirtual e : ()I
      //   15: if_icmpge -> 971
      //   18: aload_0
      //   19: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   22: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   25: invokevirtual a : ()Z
      //   28: istore #13
      //   30: iconst_1
      //   31: istore #14
      //   33: iload #13
      //   35: ifeq -> 56
      //   38: aload_0
      //   39: iload_1
      //   40: invokevirtual f : (I)Landroid/support/v7/widget/RecyclerView$x;
      //   43: astore #15
      //   45: aload #15
      //   47: ifnull -> 59
      //   50: iconst_1
      //   51: istore #16
      //   53: goto -> 62
      //   56: aconst_null
      //   57: astore #15
      //   59: iconst_0
      //   60: istore #16
      //   62: aload #15
      //   64: ifnonnull -> 156
      //   67: aload_0
      //   68: iload_1
      //   69: iload_2
      //   70: invokevirtual b : (IZ)Landroid/support/v7/widget/RecyclerView$x;
      //   73: astore #15
      //   75: aload #15
      //   77: ifnull -> 156
      //   80: aload_0
      //   81: aload #15
      //   83: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$x;)Z
      //   86: ifne -> 153
      //   89: iload_2
      //   90: ifne -> 147
      //   93: aload #15
      //   95: iconst_4
      //   96: invokevirtual b : (I)V
      //   99: aload #15
      //   101: invokevirtual i : ()Z
      //   104: ifeq -> 128
      //   107: aload_0
      //   108: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   111: aload #15
      //   113: getfield a : Landroid/view/View;
      //   116: iconst_0
      //   117: invokevirtual removeDetachedView : (Landroid/view/View;Z)V
      //   120: aload #15
      //   122: invokevirtual j : ()V
      //   125: goto -> 141
      //   128: aload #15
      //   130: invokevirtual k : ()Z
      //   133: ifeq -> 141
      //   136: aload #15
      //   138: invokevirtual l : ()V
      //   141: aload_0
      //   142: aload #15
      //   144: invokevirtual b : (Landroid/support/v7/widget/RecyclerView$x;)V
      //   147: aconst_null
      //   148: astore #15
      //   150: goto -> 156
      //   153: iconst_1
      //   154: istore #16
      //   156: aload #15
      //   158: ifnonnull -> 664
      //   161: aload_0
      //   162: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   165: getfield f : Landroid/support/v7/widget/e;
      //   168: iload_1
      //   169: invokevirtual b : (I)I
      //   172: istore #26
      //   174: iload #26
      //   176: iflt -> 562
      //   179: iload #26
      //   181: aload_0
      //   182: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   185: getfield m : Landroid/support/v7/widget/RecyclerView$a;
      //   188: invokevirtual a : ()I
      //   191: if_icmpge -> 562
      //   194: aload_0
      //   195: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   198: getfield m : Landroid/support/v7/widget/RecyclerView$a;
      //   201: iload #26
      //   203: invokevirtual a : (I)I
      //   206: istore #36
      //   208: aload_0
      //   209: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   212: getfield m : Landroid/support/v7/widget/RecyclerView$a;
      //   215: invokevirtual b : ()Z
      //   218: ifeq -> 257
      //   221: aload_0
      //   222: aload_0
      //   223: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   226: getfield m : Landroid/support/v7/widget/RecyclerView$a;
      //   229: iload #26
      //   231: invokevirtual b : (I)J
      //   234: iload #36
      //   236: iload_2
      //   237: invokevirtual a : (JIZ)Landroid/support/v7/widget/RecyclerView$x;
      //   240: astore #15
      //   242: aload #15
      //   244: ifnull -> 257
      //   247: aload #15
      //   249: iload #26
      //   251: putfield c : I
      //   254: iconst_1
      //   255: istore #16
      //   257: aload #15
      //   259: ifnonnull -> 402
      //   262: aload_0
      //   263: getfield i : Landroid/support/v7/widget/RecyclerView$v;
      //   266: astore #43
      //   268: aload #43
      //   270: ifnull -> 402
      //   273: aload #43
      //   275: aload_0
      //   276: iload_1
      //   277: iload #36
      //   279: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$p;II)Landroid/view/View;
      //   282: astore #44
      //   284: aload #44
      //   286: ifnull -> 402
      //   289: aload_0
      //   290: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   293: aload #44
      //   295: invokevirtual b : (Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$x;
      //   298: astore #15
      //   300: aload #15
      //   302: ifnull -> 359
      //   305: aload #15
      //   307: invokevirtual c : ()Z
      //   310: ifne -> 316
      //   313: goto -> 402
      //   316: new java/lang/StringBuilder
      //   319: dup
      //   320: invokespecial <init> : ()V
      //   323: astore #48
      //   325: aload #48
      //   327: ldc 'getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.'
      //   329: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   332: pop
      //   333: aload #48
      //   335: aload_0
      //   336: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   339: invokevirtual a : ()Ljava/lang/String;
      //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   345: pop
      //   346: new java/lang/IllegalArgumentException
      //   349: dup
      //   350: aload #48
      //   352: invokevirtual toString : ()Ljava/lang/String;
      //   355: invokespecial <init> : (Ljava/lang/String;)V
      //   358: athrow
      //   359: new java/lang/StringBuilder
      //   362: dup
      //   363: invokespecial <init> : ()V
      //   366: astore #45
      //   368: aload #45
      //   370: ldc 'getViewForPositionAndType returned a view which does not have a ViewHolder'
      //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: pop
      //   376: aload #45
      //   378: aload_0
      //   379: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   382: invokevirtual a : ()Ljava/lang/String;
      //   385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   388: pop
      //   389: new java/lang/IllegalArgumentException
      //   392: dup
      //   393: aload #45
      //   395: invokevirtual toString : ()Ljava/lang/String;
      //   398: invokespecial <init> : (Ljava/lang/String;)V
      //   401: athrow
      //   402: aload #15
      //   404: ifnonnull -> 440
      //   407: aload_0
      //   408: invokevirtual g : ()Landroid/support/v7/widget/RecyclerView$o;
      //   411: iload #36
      //   413: invokevirtual a : (I)Landroid/support/v7/widget/RecyclerView$x;
      //   416: astore #15
      //   418: aload #15
      //   420: ifnull -> 440
      //   423: aload #15
      //   425: invokevirtual v : ()V
      //   428: getstatic android/support/v7/widget/RecyclerView.a : Z
      //   431: ifeq -> 440
      //   434: aload_0
      //   435: aload #15
      //   437: invokespecial f : (Landroid/support/v7/widget/RecyclerView$x;)V
      //   440: aload #15
      //   442: ifnonnull -> 664
      //   445: aload_0
      //   446: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   449: invokevirtual getNanoTime : ()J
      //   452: lstore #37
      //   454: lload_3
      //   455: ldc2_w 9223372036854775807
      //   458: lcmp
      //   459: ifeq -> 479
      //   462: aload_0
      //   463: getfield e : Landroid/support/v7/widget/RecyclerView$o;
      //   466: iload #36
      //   468: lload #37
      //   470: lload_3
      //   471: invokevirtual a : (IJJ)Z
      //   474: ifne -> 479
      //   477: aconst_null
      //   478: areturn
      //   479: aload_0
      //   480: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   483: getfield m : Landroid/support/v7/widget/RecyclerView$a;
      //   486: aload_0
      //   487: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   490: iload #36
      //   492: invokevirtual b : (Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$x;
      //   495: astore #39
      //   497: getstatic android/support/v7/widget/RecyclerView.d : Z
      //   500: ifeq -> 532
      //   503: aload #39
      //   505: getfield a : Landroid/view/View;
      //   508: invokestatic j : (Landroid/view/View;)Landroid/support/v7/widget/RecyclerView;
      //   511: astore #42
      //   513: aload #42
      //   515: ifnull -> 532
      //   518: aload #39
      //   520: new java/lang/ref/WeakReference
      //   523: dup
      //   524: aload #42
      //   526: invokespecial <init> : (Ljava/lang/Object;)V
      //   529: putfield b : Ljava/lang/ref/WeakReference;
      //   532: aload_0
      //   533: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   536: invokevirtual getNanoTime : ()J
      //   539: lstore #40
      //   541: aload_0
      //   542: getfield e : Landroid/support/v7/widget/RecyclerView$o;
      //   545: iload #36
      //   547: lload #40
      //   549: lload #37
      //   551: lsub
      //   552: invokevirtual a : (IJ)V
      //   555: aload #39
      //   557: astore #17
      //   559: goto -> 668
      //   562: new java/lang/StringBuilder
      //   565: dup
      //   566: invokespecial <init> : ()V
      //   569: astore #27
      //   571: aload #27
      //   573: ldc_w 'Inconsistency detected. Invalid item position '
      //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   579: pop
      //   580: aload #27
      //   582: iload_1
      //   583: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   586: pop
      //   587: aload #27
      //   589: ldc_w '(offset:'
      //   592: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   595: pop
      //   596: aload #27
      //   598: iload #26
      //   600: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   603: pop
      //   604: aload #27
      //   606: ldc_w ').'
      //   609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   612: pop
      //   613: aload #27
      //   615: ldc_w 'state:'
      //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   621: pop
      //   622: aload #27
      //   624: aload_0
      //   625: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   628: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   631: invokevirtual e : ()I
      //   634: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   637: pop
      //   638: aload #27
      //   640: aload_0
      //   641: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   644: invokevirtual a : ()Ljava/lang/String;
      //   647: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   650: pop
      //   651: new java/lang/IndexOutOfBoundsException
      //   654: dup
      //   655: aload #27
      //   657: invokevirtual toString : ()Ljava/lang/String;
      //   660: invokespecial <init> : (Ljava/lang/String;)V
      //   663: athrow
      //   664: aload #15
      //   666: astore #17
      //   668: iload #16
      //   670: istore #18
      //   672: iload #18
      //   674: ifeq -> 773
      //   677: aload_0
      //   678: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   681: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   684: invokevirtual a : ()Z
      //   687: ifne -> 773
      //   690: aload #17
      //   692: sipush #8192
      //   695: invokevirtual a : (I)Z
      //   698: ifeq -> 773
      //   701: aload #17
      //   703: iconst_0
      //   704: sipush #8192
      //   707: invokevirtual a : (II)V
      //   710: aload_0
      //   711: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   714: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   717: getfield j : Z
      //   720: ifeq -> 773
      //   723: sipush #4096
      //   726: aload #17
      //   728: invokestatic e : (Landroid/support/v7/widget/RecyclerView$x;)I
      //   731: ior
      //   732: istore #24
      //   734: aload_0
      //   735: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   738: getfield z : Landroid/support/v7/widget/RecyclerView$f;
      //   741: aload_0
      //   742: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   745: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   748: aload #17
      //   750: iload #24
      //   752: aload #17
      //   754: invokevirtual u : ()Ljava/util/List;
      //   757: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$u;Landroid/support/v7/widget/RecyclerView$x;ILjava/util/List;)Landroid/support/v7/widget/RecyclerView$f$c;
      //   760: astore #25
      //   762: aload_0
      //   763: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   766: aload #17
      //   768: aload #25
      //   770: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$x;Landroid/support/v7/widget/RecyclerView$f$c;)V
      //   773: aload_0
      //   774: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   777: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   780: invokevirtual a : ()Z
      //   783: ifeq -> 803
      //   786: aload #17
      //   788: invokevirtual p : ()Z
      //   791: ifeq -> 803
      //   794: aload #17
      //   796: iload_1
      //   797: putfield g : I
      //   800: goto -> 830
      //   803: aload #17
      //   805: invokevirtual p : ()Z
      //   808: ifeq -> 836
      //   811: aload #17
      //   813: invokevirtual o : ()Z
      //   816: ifne -> 836
      //   819: aload #17
      //   821: invokevirtual n : ()Z
      //   824: ifeq -> 830
      //   827: goto -> 836
      //   830: iconst_0
      //   831: istore #20
      //   833: goto -> 861
      //   836: aload_0
      //   837: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   840: getfield f : Landroid/support/v7/widget/e;
      //   843: iload_1
      //   844: invokevirtual b : (I)I
      //   847: istore #19
      //   849: aload_0
      //   850: aload #17
      //   852: iload #19
      //   854: iload_1
      //   855: lload_3
      //   856: invokespecial a : (Landroid/support/v7/widget/RecyclerView$x;IIJ)Z
      //   859: istore #20
      //   861: aload #17
      //   863: getfield a : Landroid/view/View;
      //   866: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   869: astore #21
      //   871: aload #21
      //   873: ifnonnull -> 905
      //   876: aload_0
      //   877: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   880: invokevirtual generateDefaultLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   883: astore #23
      //   885: aload #23
      //   887: checkcast android/support/v7/widget/RecyclerView$j
      //   890: astore #22
      //   892: aload #17
      //   894: getfield a : Landroid/view/View;
      //   897: aload #22
      //   899: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
      //   902: goto -> 938
      //   905: aload_0
      //   906: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   909: aload #21
      //   911: invokevirtual checkLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)Z
      //   914: ifne -> 931
      //   917: aload_0
      //   918: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   921: aload #21
      //   923: invokevirtual generateLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
      //   926: astore #23
      //   928: goto -> 885
      //   931: aload #21
      //   933: checkcast android/support/v7/widget/RecyclerView$j
      //   936: astore #22
      //   938: aload #22
      //   940: aload #17
      //   942: putfield c : Landroid/support/v7/widget/RecyclerView$x;
      //   945: iload #18
      //   947: ifeq -> 958
      //   950: iload #20
      //   952: ifeq -> 958
      //   955: goto -> 961
      //   958: iconst_0
      //   959: istore #14
      //   961: aload #22
      //   963: iload #14
      //   965: putfield f : Z
      //   968: aload #17
      //   970: areturn
      //   971: new java/lang/StringBuilder
      //   974: dup
      //   975: invokespecial <init> : ()V
      //   978: astore #5
      //   980: aload #5
      //   982: ldc_w 'Invalid item position '
      //   985: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   988: pop
      //   989: aload #5
      //   991: iload_1
      //   992: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   995: pop
      //   996: aload #5
      //   998: ldc_w '('
      //   1001: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1004: pop
      //   1005: aload #5
      //   1007: iload_1
      //   1008: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1011: pop
      //   1012: aload #5
      //   1014: ldc_w '). Item count:'
      //   1017: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1020: pop
      //   1021: aload #5
      //   1023: aload_0
      //   1024: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   1027: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   1030: invokevirtual e : ()I
      //   1033: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1036: pop
      //   1037: aload #5
      //   1039: aload_0
      //   1040: getfield f : Landroid/support/v7/widget/RecyclerView;
      //   1043: invokevirtual a : ()Ljava/lang/String;
      //   1046: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1049: pop
      //   1050: new java/lang/IndexOutOfBoundsException
      //   1053: dup
      //   1054: aload #5
      //   1056: invokevirtual toString : ()Ljava/lang/String;
      //   1059: invokespecial <init> : (Ljava/lang/String;)V
      //   1062: athrow }
    
    RecyclerView.x a(long param1Long, int param1Int, boolean param1Boolean) {
      for (int j = -1 + this.a.size(); j >= 0; j--) {
        RecyclerView.x x = (RecyclerView.x)this.a.get(j);
        if (x.g() == param1Long && !x.k()) {
          if (param1Int == x.h()) {
            x.b(32);
            if (x.q() && !this.f.D.a())
              x.a(2, 14); 
            return x;
          } 
          if (!param1Boolean) {
            this.a.remove(j);
            this.f.removeDetachedView(x.a, false);
            b(x.a);
          } 
        } 
      } 
      for (int k = -1 + this.c.size(); k >= 0; k--) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(k);
        if (x.g() == param1Long) {
          if (param1Int == x.h()) {
            if (!param1Boolean)
              this.c.remove(k); 
            return x;
          } 
          if (!param1Boolean) {
            d(k);
            return null;
          } 
        } 
      } 
      return null;
    }
    
    View a(int param1Int, boolean param1Boolean) { return (a(param1Int, param1Boolean, Float.MAX_VALUE)).a; }
    
    public void a() {
      this.a.clear();
      d();
    }
    
    public void a(int param1Int) {
      this.h = param1Int;
      b();
    }
    
    void a(int param1Int1, int param1Int2) {
      byte b1;
      int k;
      int j;
      if (param1Int1 < param1Int2) {
        k = param1Int1;
        j = param1Int2;
        b1 = -1;
      } else {
        j = param1Int1;
        k = param1Int2;
        b1 = 1;
      } 
      int m = this.c.size();
      for (byte b2 = 0; b2 < m; b2++) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(b2);
        if (x != null && x.c >= k && x.c <= j)
          if (x.c == param1Int1) {
            x.a(param1Int2 - param1Int1, false);
          } else {
            x.a(b1, false);
          }  
      } 
    }
    
    void a(int param1Int1, int param1Int2, boolean param1Boolean) {
      int j = param1Int1 + param1Int2;
      for (int k = -1 + this.c.size(); k >= 0; k--) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(k);
        if (x != null)
          if (x.c >= j) {
            x.a(-param1Int2, param1Boolean);
          } else if (x.c >= param1Int1) {
            x.b(8);
            d(k);
          }  
      } 
    }
    
    void a(RecyclerView.a param1a1, RecyclerView.a param1a2, boolean param1Boolean) {
      a();
      g().a(param1a1, param1a2, param1Boolean);
    }
    
    void a(RecyclerView.o param1o) {
      RecyclerView.o o1 = this.e;
      if (o1 != null)
        o1.c(); 
      this.e = param1o;
      if (this.e != null && this.f.getAdapter() != null)
        this.e.b(); 
    }
    
    void a(RecyclerView.v param1v) { this.i = param1v; }
    
    void a(RecyclerView.x param1x, boolean param1Boolean) {
      RecyclerView.c(param1x);
      if (param1x.a(16384)) {
        param1x.a(0, 16384);
        r.a(param1x.a, null);
      } 
      if (param1Boolean)
        d(param1x); 
      param1x.p = null;
      g().a(param1x);
    }
    
    public void a(View param1View) {
      RecyclerView.x x = RecyclerView.e(param1View);
      if (x.r())
        this.f.removeDetachedView(param1View, false); 
      if (x.i()) {
        x.j();
      } else if (x.k()) {
        x.l();
      } 
      b(x);
    }
    
    boolean a(RecyclerView.x param1x) {
      if (param1x.q())
        return this.f.D.a(); 
      if (param1x.c >= 0 && param1x.c < this.f.m.a()) {
        if (!this.f.D.a() && this.f.m.a(param1x.c) != param1x.h())
          return false; 
        if (this.f.m.b()) {
          int j = param1x.g() cmp this.f.m.b(param1x.c);
          boolean bool = false;
          if (j == 0)
            bool = true; 
          return bool;
        } 
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
      stringBuilder.append(param1x);
      stringBuilder.append(this.f.a());
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    public int b(int param1Int) {
      if (param1Int >= 0 && param1Int < this.f.D.e())
        return !this.f.D.a() ? param1Int : this.f.f.b(param1Int); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("invalid position ");
      stringBuilder.append(param1Int);
      stringBuilder.append(". State ");
      stringBuilder.append("item count is ");
      stringBuilder.append(this.f.D.e());
      stringBuilder.append(this.f.a());
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    RecyclerView.x b(int param1Int, boolean param1Boolean) {
      int j = this.a.size();
      byte b1 = 0;
      for (byte b2 = 0; b2 < j; b2++) {
        RecyclerView.x x = (RecyclerView.x)this.a.get(b2);
        if (!x.k() && x.d() == param1Int && !x.n() && (this.f.D.g || !x.q())) {
          x.b(32);
          return x;
        } 
      } 
      if (!param1Boolean) {
        View view = this.f.g.c(param1Int);
        if (view != null) {
          RecyclerView.x x = RecyclerView.e(view);
          this.f.g.e(view);
          int m = this.f.g.b(view);
          if (m != -1) {
            this.f.g.e(m);
            c(view);
            x.b(8224);
            return x;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("layout index should not be -1 after unhiding a view:");
          stringBuilder.append(x);
          stringBuilder.append(this.f.a());
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } 
      int k = this.c.size();
      while (b1 < k) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(b1);
        if (!x.n() && x.d() == param1Int) {
          if (!param1Boolean)
            this.c.remove(b1); 
          return x;
        } 
        b1++;
      } 
      return null;
    }
    
    void b() {
      int j;
      if (this.f.n != null) {
        j = this.f.n.x;
      } else {
        j = 0;
      } 
      this.d = j + this.h;
      for (int k = -1 + this.c.size(); k >= 0 && this.c.size() > this.d; k--)
        d(k); 
    }
    
    void b(int param1Int1, int param1Int2) {
      int j = this.c.size();
      for (byte b1 = 0; b1 < j; b1++) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(b1);
        if (x != null && x.c >= param1Int1)
          x.a(param1Int2, true); 
      } 
    }
    
    void b(RecyclerView.x param1x) {
      if (param1x.i() || param1x.a.getParent() != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Scrapped or attached views may not be recycled. isScrap:");
        stringBuilder1.append(param1x.i());
        stringBuilder1.append(" isAttached:");
        ViewParent viewParent = param1x.a.getParent();
        boolean bool = false;
        if (viewParent != null)
          bool = true; 
        stringBuilder1.append(bool);
        stringBuilder1.append(this.f.a());
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      if (!param1x.r()) {
        if (!param1x.c()) {
          boolean bool3;
          boolean bool2;
          boolean bool1;
          boolean bool = param1x.y();
          if (this.f.m != null && bool && this.f.m.b(param1x)) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (bool1 || param1x.w()) {
            if (this.d > 0 && !param1x.a(526)) {
              int j = this.c.size();
              if (j >= this.d && j > 0) {
                d(0);
                j--;
              } 
              if (RecyclerView.d && j > 0 && !this.f.C.a(param1x.c)) {
                int k;
                for (k = j - 1; k >= 0; k--) {
                  int m = ((RecyclerView.x)this.c.get(k)).c;
                  if (!this.f.C.a(m))
                    break; 
                } 
                j = k + 1;
              } 
              this.c.add(j, param1x);
              bool2 = true;
            } else {
              bool2 = false;
            } 
            bool3 = false;
            if (!bool2) {
              a(param1x, true);
              bool3 = true;
            } 
          } else {
            bool3 = false;
            bool2 = false;
          } 
          this.f.h.g(param1x);
          if (!bool2 && !bool3 && bool)
            param1x.p = null; 
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        stringBuilder1.append(this.f.a());
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
      stringBuilder.append(param1x);
      stringBuilder.append(this.f.a());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    void b(View param1View) {
      RecyclerView.x x = RecyclerView.e(param1View);
      x.m = null;
      x.n = false;
      x.l();
      b(x);
    }
    
    public View c(int param1Int) { return a(param1Int, false); }
    
    public List<RecyclerView.x> c() { return this.g; }
    
    void c(int param1Int1, int param1Int2) {
      int j = param1Int2 + param1Int1;
      for (int k = -1 + this.c.size(); k >= 0; k--) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(k);
        if (x != null) {
          int m = x.c;
          if (m >= param1Int1 && m < j) {
            x.b(2);
            d(k);
          } 
        } 
      } 
    }
    
    void c(RecyclerView.x param1x) {
      ArrayList arrayList;
      if (param1x.n) {
        arrayList = this.b;
      } else {
        arrayList = this.a;
      } 
      arrayList.remove(param1x);
      param1x.m = null;
      param1x.n = false;
      param1x.l();
    }
    
    void c(View param1View) {
      ArrayList arrayList;
      RecyclerView.x x = RecyclerView.e(param1View);
      if (x.a(12) || !x.z() || this.f.b(x)) {
        if (!x.n() || x.q() || this.f.m.b()) {
          x.a(this, false);
          arrayList = this.a;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
          stringBuilder.append(this.f.a());
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        if (this.b == null)
          this.b = new ArrayList(); 
        x.a(this, true);
        arrayList = this.b;
      } 
      arrayList.add(x);
    }
    
    void d() {
      for (int j = -1 + this.c.size(); j >= 0; j--)
        d(j); 
      this.c.clear();
      if (RecyclerView.d)
        this.f.C.a(); 
    }
    
    void d(int param1Int) {
      a((RecyclerView.x)this.c.get(param1Int), true);
      this.c.remove(param1Int);
    }
    
    void d(RecyclerView.x param1x) {
      if (this.f.o != null)
        this.f.o.a(param1x); 
      if (this.f.m != null)
        this.f.m.a(param1x); 
      if (this.f.D != null)
        this.f.h.g(param1x); 
    }
    
    int e() { return this.a.size(); }
    
    View e(int param1Int) { return ((RecyclerView.x)this.a.get(param1Int)).a; }
    
    RecyclerView.x f(int param1Int) {
      ArrayList arrayList = this.b;
      if (arrayList != null) {
        int j = arrayList.size();
        if (j == 0)
          return null; 
        byte b1 = 0;
        for (byte b2 = 0; b2 < j; b2++) {
          RecyclerView.x x = (RecyclerView.x)this.b.get(b2);
          if (!x.k() && x.d() == param1Int) {
            x.b(32);
            return x;
          } 
        } 
        if (this.f.m.b()) {
          int k = this.f.f.b(param1Int);
          if (k > 0 && k < this.f.m.a()) {
            long l = this.f.m.b(k);
            while (b1 < j) {
              RecyclerView.x x = (RecyclerView.x)this.b.get(b1);
              if (!x.k() && x.g() == l) {
                x.b(32);
                return x;
              } 
              b1++;
            } 
          } 
        } 
      } 
      return null;
    }
    
    void f() {
      this.a.clear();
      ArrayList arrayList = this.b;
      if (arrayList != null)
        arrayList.clear(); 
    }
    
    RecyclerView.o g() {
      if (this.e == null)
        this.e = new RecyclerView.o(); 
      return this.e;
    }
    
    void h() {
      int j = this.c.size();
      for (byte b1 = 0; b1 < j; b1++) {
        RecyclerView.x x = (RecyclerView.x)this.c.get(b1);
        if (x != null) {
          x.b(6);
          x.a(null);
        } 
      } 
      if (this.f.m == null || !this.f.m.b())
        d(); 
    }
    
    void i() {
      int j = this.c.size();
      byte b1 = 0;
      for (byte b2 = 0; b2 < j; b2++)
        ((RecyclerView.x)this.c.get(b2)).a(); 
      int k = this.a.size();
      for (byte b3 = 0; b3 < k; b3++)
        ((RecyclerView.x)this.a.get(b3)).a(); 
      ArrayList arrayList = this.b;
      if (arrayList != null) {
        int m = arrayList.size();
        while (b1 < m) {
          ((RecyclerView.x)this.b.get(b1)).a();
          b1++;
        } 
      } 
    }
    
    void j() {
      int j = this.c.size();
      for (byte b1 = 0; b1 < j; b1++) {
        RecyclerView.j j1 = (RecyclerView.j)((RecyclerView.x)this.c.get(b1)).a.getLayoutParams();
        if (j1 != null)
          j1.e = true; 
      } 
    }
  }
  
  public static interface q {
    void a(RecyclerView.x param1x);
  }
  
  private class r extends c {
    r(RecyclerView this$0) {}
    
    public void a() {
      this.a.a(null);
      this.a.D.f = true;
      this.a.c(true);
      if (!this.a.f.d())
        this.a.requestLayout(); 
    }
  }
  
  public static class s extends a {
    public static final Parcelable.Creator<s> CREATOR = new Parcelable.ClassLoaderCreator<s>() {
        public RecyclerView.s a(Parcel param2Parcel) { return new RecyclerView.s(param2Parcel, null); }
        
        public RecyclerView.s a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new RecyclerView.s(param2Parcel, param2ClassLoader); }
        
        public RecyclerView.s[] a(int param2Int) { return new RecyclerView.s[param2Int]; }
      };
    
    Parcelable a;
    
    s(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      if (param1ClassLoader == null)
        param1ClassLoader = RecyclerView.i.class.getClassLoader(); 
      this.a = param1Parcel.readParcelable(param1ClassLoader);
    }
    
    s(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    void a(s param1s) { this.a = param1s.a; }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeParcelable(this.a, 0);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<s> {
    public RecyclerView.s a(Parcel param1Parcel) { return new RecyclerView.s(param1Parcel, null); }
    
    public RecyclerView.s a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new RecyclerView.s(param1Parcel, param1ClassLoader); }
    
    public RecyclerView.s[] a(int param1Int) { return new RecyclerView.s[param1Int]; }
  }
  
  public static abstract class t {
    private int a;
    
    private RecyclerView b;
    
    private RecyclerView.i c;
    
    private boolean d;
    
    private boolean e;
    
    private View f;
    
    private final a g;
    
    public int a(View param1View) { return this.b.f(param1View); }
    
    public RecyclerView.i a() { return this.c; }
    
    public void a(int param1Int) { this.a = param1Int; }
    
    void a(int param1Int1, int param1Int2) {
      RecyclerView recyclerView = this.b;
      if (!this.e || this.a == -1 || recyclerView == null)
        b(); 
      if (this.d && this.f == null && this.c != null) {
        PointF pointF = b(this.a);
        if (pointF != null && (pointF.x != 0.0F || pointF.y != 0.0F))
          recyclerView.a((int)Math.signum(pointF.x), (int)Math.signum(pointF.y), null); 
      } 
      this.d = false;
      View view = this.f;
      if (view != null)
        if (a(view) == this.a) {
          a(this.f, recyclerView.D, this.g);
          this.g.a(recyclerView);
          b();
        } else {
          Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          this.f = null;
        }  
      if (this.e) {
        a(param1Int1, param1Int2, recyclerView.D, this.g);
        boolean bool = this.g.a();
        this.g.a(recyclerView);
        if (bool) {
          if (this.e) {
            this.d = true;
            recyclerView.A.a();
            return;
          } 
          b();
        } 
      } 
    }
    
    protected abstract void a(int param1Int1, int param1Int2, RecyclerView.u param1u, a param1a);
    
    protected abstract void a(View param1View, RecyclerView.u param1u, a param1a);
    
    public PointF b(int param1Int) {
      RecyclerView.i i1 = a();
      if (i1 instanceof b)
        return ((b)i1).d(param1Int); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
      stringBuilder.append(b.class.getCanonicalName());
      Log.w("RecyclerView", stringBuilder.toString());
      return null;
    }
    
    protected final void b() {
      if (!this.e)
        return; 
      this.e = false;
      f();
      this.b.D.a = -1;
      this.f = null;
      this.a = -1;
      this.d = false;
      this.c.a(this);
      this.c = null;
      this.b = null;
    }
    
    protected void b(View param1View) {
      if (a(param1View) == e())
        this.f = param1View; 
    }
    
    public boolean c() { return this.d; }
    
    public boolean d() { return this.e; }
    
    public int e() { return this.a; }
    
    protected abstract void f();
    
    public static class a {
      private int a;
      
      private int b;
      
      private int c;
      
      private int d;
      
      private Interpolator e;
      
      private boolean f;
      
      private int g;
      
      private void b() {
        if (this.e == null || this.c >= 1) {
          if (this.c >= 1)
            return; 
          throw new IllegalStateException("Scroll duration must be a positive number");
        } 
        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      }
      
      void a(RecyclerView param2RecyclerView) {
        int i = this.d;
        if (i >= 0) {
          this.d = -1;
          param2RecyclerView.b(i);
          this.f = false;
          return;
        } 
        if (this.f) {
          b();
          if (this.e == null) {
            if (this.c == Integer.MIN_VALUE) {
              param2RecyclerView.A.b(this.a, this.b);
            } else {
              param2RecyclerView.A.a(this.a, this.b, this.c);
            } 
          } else {
            param2RecyclerView.A.a(this.a, this.b, this.c, this.e);
          } 
          this.g = 1 + this.g;
          if (this.g > 10)
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary"); 
          this.f = false;
          return;
        } 
        this.g = 0;
      }
      
      boolean a() { return (this.d >= 0); }
    }
    
    public static interface b {
      PointF d(int param2Int);
    }
  }
  
  public static class a {
    private int a;
    
    private int b;
    
    private int c;
    
    private int d;
    
    private Interpolator e;
    
    private boolean f;
    
    private int g;
    
    private void b() {
      if (this.e == null || this.c >= 1) {
        if (this.c >= 1)
          return; 
        throw new IllegalStateException("Scroll duration must be a positive number");
      } 
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    }
    
    void a(RecyclerView param1RecyclerView) {
      int i = this.d;
      if (i >= 0) {
        this.d = -1;
        param1RecyclerView.b(i);
        this.f = false;
        return;
      } 
      if (this.f) {
        b();
        if (this.e == null) {
          if (this.c == Integer.MIN_VALUE) {
            param1RecyclerView.A.b(this.a, this.b);
          } else {
            param1RecyclerView.A.a(this.a, this.b, this.c);
          } 
        } else {
          param1RecyclerView.A.a(this.a, this.b, this.c, this.e);
        } 
        this.g = 1 + this.g;
        if (this.g > 10)
          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary"); 
        this.f = false;
        return;
      } 
      this.g = 0;
    }
    
    boolean a() { return (this.d >= 0); }
  }
  
  public static interface b {
    PointF d(int param1Int);
  }
  
  public static class u {
    int a = -1;
    
    int b = 0;
    
    int c = 0;
    
    int d = 1;
    
    int e = 0;
    
    boolean f = false;
    
    boolean g = false;
    
    boolean h = false;
    
    boolean i = false;
    
    boolean j = false;
    
    boolean k = false;
    
    int l;
    
    long m;
    
    int n;
    
    int o;
    
    int p;
    
    private SparseArray<Object> q;
    
    void a(int param1Int) {
      if ((param1Int & this.d) != 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Layout state should be one of ");
      stringBuilder.append(Integer.toBinaryString(param1Int));
      stringBuilder.append(" but it is ");
      stringBuilder.append(Integer.toBinaryString(this.d));
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    void a(RecyclerView.a param1a) {
      this.d = 1;
      this.e = param1a.a();
      this.g = false;
      this.h = false;
      this.i = false;
    }
    
    public boolean a() { return this.g; }
    
    public boolean b() { return this.k; }
    
    public int c() { return this.a; }
    
    public boolean d() { return (this.a != -1); }
    
    public int e() { return this.g ? (this.b - this.c) : this.e; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("State{mTargetPosition=");
      stringBuilder.append(this.a);
      stringBuilder.append(", mData=");
      stringBuilder.append(this.q);
      stringBuilder.append(", mItemCount=");
      stringBuilder.append(this.e);
      stringBuilder.append(", mIsMeasuring=");
      stringBuilder.append(this.i);
      stringBuilder.append(", mPreviousLayoutItemCount=");
      stringBuilder.append(this.b);
      stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      stringBuilder.append(this.c);
      stringBuilder.append(", mStructureChanged=");
      stringBuilder.append(this.f);
      stringBuilder.append(", mInPreLayout=");
      stringBuilder.append(this.g);
      stringBuilder.append(", mRunSimpleAnimations=");
      stringBuilder.append(this.j);
      stringBuilder.append(", mRunPredictiveAnimations=");
      stringBuilder.append(this.k);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static abstract class v {
    public abstract View a(RecyclerView.p param1p, int param1Int1, int param1Int2);
  }
  
  class w implements Runnable {
    OverScroller a;
    
    Interpolator b = RecyclerView.L;
    
    private int d;
    
    private int e;
    
    private boolean f = false;
    
    private boolean g = false;
    
    w(RecyclerView this$0) { this.a = new OverScroller(this$0.getContext(), RecyclerView.L); }
    
    private float a(float param1Float) { return (float)Math.sin((0.47123894F * (param1Float - 0.5F))); }
    
    private int b(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      int i2;
      int n;
      boolean bool;
      int i = Math.abs(param1Int1);
      int j = Math.abs(param1Int2);
      if (i > j) {
        bool = true;
      } else {
        bool = false;
      } 
      int k = (int)Math.sqrt((param1Int3 * param1Int3 + param1Int4 * param1Int4));
      int m = (int)Math.sqrt((param1Int1 * param1Int1 + param1Int2 * param1Int2));
      if (bool) {
        n = this.c.getWidth();
      } else {
        n = this.c.getHeight();
      } 
      int i1 = n / 2;
      float f1 = 1.0F * m;
      float f2 = n;
      float f3 = Math.min(1.0F, f1 / f2);
      float f4 = i1;
      float f5 = f4 + f4 * a(f3);
      if (k > 0) {
        i2 = 4 * Math.round(1000.0F * Math.abs(f5 / k));
      } else {
        if (!bool)
          i = j; 
        i2 = (int)(300.0F * (1.0F + i / f2));
      } 
      return Math.min(i2, 2000);
    }
    
    private void c() {
      this.g = false;
      this.f = true;
    }
    
    private void d() {
      this.f = false;
      if (this.g)
        a(); 
    }
    
    void a() {
      if (this.f) {
        this.g = true;
        return;
      } 
      this.c.removeCallbacks(this);
      r.a(this.c, this);
    }
    
    public void a(int param1Int1, int param1Int2) {
      this.c.setScrollState(2);
      this.e = 0;
      this.d = 0;
      this.a.fling(0, 0, param1Int1, param1Int2, -2147483648, 2147483647, -2147483648, 2147483647);
      a();
    }
    
    public void a(int param1Int1, int param1Int2, int param1Int3) { a(param1Int1, param1Int2, param1Int3, RecyclerView.L); }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) { a(param1Int1, param1Int2, b(param1Int1, param1Int2, param1Int3, param1Int4)); }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      if (this.b != param1Interpolator) {
        this.b = param1Interpolator;
        this.a = new OverScroller(this.c.getContext(), param1Interpolator);
      } 
      this.c.setScrollState(2);
      this.e = 0;
      this.d = 0;
      this.a.startScroll(0, 0, param1Int1, param1Int2, param1Int3);
      if (Build.VERSION.SDK_INT < 23)
        this.a.computeScrollOffset(); 
      a();
    }
    
    public void a(int param1Int1, int param1Int2, Interpolator param1Interpolator) {
      int i = b(param1Int1, param1Int2, 0, 0);
      if (param1Interpolator == null)
        param1Interpolator = RecyclerView.L; 
      a(param1Int1, param1Int2, i, param1Interpolator);
    }
    
    public void b() {
      this.c.removeCallbacks(this);
      this.a.abortAnimation();
    }
    
    public void b(int param1Int1, int param1Int2) { a(param1Int1, param1Int2, 0, 0); }
    
    public void run() { // Byte code:
      //   0: aload_0
      //   1: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   4: getfield n : Landroid/support/v7/widget/RecyclerView$i;
      //   7: ifnonnull -> 15
      //   10: aload_0
      //   11: invokevirtual b : ()V
      //   14: return
      //   15: aload_0
      //   16: invokespecial c : ()V
      //   19: aload_0
      //   20: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   23: invokevirtual d : ()V
      //   26: aload_0
      //   27: getfield a : Landroid/widget/OverScroller;
      //   30: astore_1
      //   31: aload_0
      //   32: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   35: getfield n : Landroid/support/v7/widget/RecyclerView$i;
      //   38: getfield t : Landroid/support/v7/widget/RecyclerView$t;
      //   41: astore_2
      //   42: aload_1
      //   43: invokevirtual computeScrollOffset : ()Z
      //   46: ifeq -> 726
      //   49: aload_0
      //   50: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   53: getfield I : [I
      //   56: astore_3
      //   57: aload_1
      //   58: invokevirtual getCurrX : ()I
      //   61: istore #4
      //   63: aload_1
      //   64: invokevirtual getCurrY : ()I
      //   67: istore #5
      //   69: iload #4
      //   71: aload_0
      //   72: getfield d : I
      //   75: isub
      //   76: istore #6
      //   78: iload #5
      //   80: aload_0
      //   81: getfield e : I
      //   84: isub
      //   85: istore #7
      //   87: aload_0
      //   88: iload #4
      //   90: putfield d : I
      //   93: aload_0
      //   94: iload #5
      //   96: putfield e : I
      //   99: aload_0
      //   100: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   103: iload #6
      //   105: iload #7
      //   107: aload_3
      //   108: aconst_null
      //   109: iconst_1
      //   110: invokevirtual a : (II[I[II)Z
      //   113: ifeq -> 132
      //   116: iload #6
      //   118: aload_3
      //   119: iconst_0
      //   120: iaload
      //   121: isub
      //   122: istore #6
      //   124: iload #7
      //   126: aload_3
      //   127: iconst_1
      //   128: iaload
      //   129: isub
      //   130: istore #7
      //   132: aload_0
      //   133: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   136: getfield m : Landroid/support/v7/widget/RecyclerView$a;
      //   139: ifnull -> 274
      //   142: aload_0
      //   143: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   146: astore #17
      //   148: aload #17
      //   150: iload #6
      //   152: iload #7
      //   154: aload #17
      //   156: getfield J : [I
      //   159: invokevirtual a : (II[I)V
      //   162: aload_0
      //   163: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   166: getfield J : [I
      //   169: iconst_0
      //   170: iaload
      //   171: istore #8
      //   173: aload_0
      //   174: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   177: getfield J : [I
      //   180: iconst_1
      //   181: iaload
      //   182: istore #9
      //   184: iload #6
      //   186: iload #8
      //   188: isub
      //   189: istore #10
      //   191: iload #7
      //   193: iload #9
      //   195: isub
      //   196: istore #11
      //   198: aload_2
      //   199: ifnull -> 286
      //   202: aload_2
      //   203: invokevirtual c : ()Z
      //   206: ifne -> 286
      //   209: aload_2
      //   210: invokevirtual d : ()Z
      //   213: ifeq -> 286
      //   216: aload_0
      //   217: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   220: getfield D : Landroid/support/v7/widget/RecyclerView$u;
      //   223: invokevirtual e : ()I
      //   226: istore #18
      //   228: iload #18
      //   230: ifne -> 240
      //   233: aload_2
      //   234: invokevirtual b : ()V
      //   237: goto -> 286
      //   240: aload_2
      //   241: invokevirtual e : ()I
      //   244: iload #18
      //   246: if_icmplt -> 257
      //   249: aload_2
      //   250: iload #18
      //   252: iconst_1
      //   253: isub
      //   254: invokevirtual a : (I)V
      //   257: aload_2
      //   258: iload #6
      //   260: iload #10
      //   262: isub
      //   263: iload #7
      //   265: iload #11
      //   267: isub
      //   268: invokevirtual a : (II)V
      //   271: goto -> 286
      //   274: iconst_0
      //   275: istore #8
      //   277: iconst_0
      //   278: istore #9
      //   280: iconst_0
      //   281: istore #10
      //   283: iconst_0
      //   284: istore #11
      //   286: aload_0
      //   287: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   290: getfield p : Ljava/util/ArrayList;
      //   293: invokevirtual isEmpty : ()Z
      //   296: ifne -> 306
      //   299: aload_0
      //   300: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   303: invokevirtual invalidate : ()V
      //   306: aload_0
      //   307: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   310: invokevirtual getOverScrollMode : ()I
      //   313: iconst_2
      //   314: if_icmpeq -> 328
      //   317: aload_0
      //   318: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   321: iload #6
      //   323: iload #7
      //   325: invokevirtual c : (II)V
      //   328: aload_0
      //   329: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   332: iload #8
      //   334: iload #9
      //   336: iload #10
      //   338: iload #11
      //   340: aconst_null
      //   341: iconst_1
      //   342: invokevirtual a : (IIII[II)Z
      //   345: ifne -> 495
      //   348: iload #10
      //   350: ifne -> 358
      //   353: iload #11
      //   355: ifeq -> 495
      //   358: aload_1
      //   359: invokevirtual getCurrVelocity : ()F
      //   362: f2i
      //   363: istore #15
      //   365: iload #10
      //   367: iload #4
      //   369: if_icmpeq -> 397
      //   372: iload #10
      //   374: ifge -> 385
      //   377: iload #15
      //   379: ineg
      //   380: istore #16
      //   382: goto -> 400
      //   385: iload #10
      //   387: ifle -> 397
      //   390: iload #15
      //   392: istore #16
      //   394: goto -> 400
      //   397: iconst_0
      //   398: istore #16
      //   400: iload #11
      //   402: iload #5
      //   404: if_icmpeq -> 428
      //   407: iload #11
      //   409: ifge -> 420
      //   412: iload #15
      //   414: ineg
      //   415: istore #15
      //   417: goto -> 431
      //   420: iload #11
      //   422: ifle -> 428
      //   425: goto -> 431
      //   428: iconst_0
      //   429: istore #15
      //   431: aload_0
      //   432: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   435: invokevirtual getOverScrollMode : ()I
      //   438: iconst_2
      //   439: if_icmpeq -> 453
      //   442: aload_0
      //   443: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   446: iload #16
      //   448: iload #15
      //   450: invokevirtual d : (II)V
      //   453: iload #16
      //   455: ifne -> 472
      //   458: iload #10
      //   460: iload #4
      //   462: if_icmpeq -> 472
      //   465: aload_1
      //   466: invokevirtual getFinalX : ()I
      //   469: ifne -> 495
      //   472: iload #15
      //   474: ifne -> 491
      //   477: iload #11
      //   479: iload #5
      //   481: if_icmpeq -> 491
      //   484: aload_1
      //   485: invokevirtual getFinalY : ()I
      //   488: ifne -> 495
      //   491: aload_1
      //   492: invokevirtual abortAnimation : ()V
      //   495: iload #8
      //   497: ifne -> 505
      //   500: iload #9
      //   502: ifeq -> 516
      //   505: aload_0
      //   506: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   509: iload #8
      //   511: iload #9
      //   513: invokevirtual i : (II)V
      //   516: aload_0
      //   517: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   520: invokestatic a : (Landroid/support/v7/widget/RecyclerView;)Z
      //   523: ifne -> 533
      //   526: aload_0
      //   527: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   530: invokevirtual invalidate : ()V
      //   533: iload #7
      //   535: ifeq -> 564
      //   538: aload_0
      //   539: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   542: getfield n : Landroid/support/v7/widget/RecyclerView$i;
      //   545: invokevirtual f : ()Z
      //   548: ifeq -> 564
      //   551: iload #9
      //   553: iload #7
      //   555: if_icmpne -> 564
      //   558: iconst_1
      //   559: istore #12
      //   561: goto -> 567
      //   564: iconst_0
      //   565: istore #12
      //   567: iload #6
      //   569: ifeq -> 598
      //   572: aload_0
      //   573: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   576: getfield n : Landroid/support/v7/widget/RecyclerView$i;
      //   579: invokevirtual e : ()Z
      //   582: ifeq -> 598
      //   585: iload #8
      //   587: iload #6
      //   589: if_icmpne -> 598
      //   592: iconst_1
      //   593: istore #13
      //   595: goto -> 601
      //   598: iconst_0
      //   599: istore #13
      //   601: iload #6
      //   603: ifne -> 611
      //   606: iload #7
      //   608: ifeq -> 630
      //   611: iload #13
      //   613: ifne -> 630
      //   616: iload #12
      //   618: ifeq -> 624
      //   621: goto -> 630
      //   624: iconst_0
      //   625: istore #14
      //   627: goto -> 633
      //   630: iconst_1
      //   631: istore #14
      //   633: aload_1
      //   634: invokevirtual isFinished : ()Z
      //   637: ifne -> 694
      //   640: iload #14
      //   642: ifne -> 659
      //   645: aload_0
      //   646: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   649: iconst_1
      //   650: invokevirtual h : (I)Z
      //   653: ifne -> 659
      //   656: goto -> 694
      //   659: aload_0
      //   660: invokevirtual a : ()V
      //   663: aload_0
      //   664: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   667: getfield B : Landroid/support/v7/widget/aq;
      //   670: ifnull -> 726
      //   673: aload_0
      //   674: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   677: getfield B : Landroid/support/v7/widget/aq;
      //   680: aload_0
      //   681: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   684: iload #6
      //   686: iload #7
      //   688: invokevirtual a : (Landroid/support/v7/widget/RecyclerView;II)V
      //   691: goto -> 726
      //   694: aload_0
      //   695: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   698: iconst_0
      //   699: invokevirtual setScrollState : (I)V
      //   702: getstatic android/support/v7/widget/RecyclerView.d : Z
      //   705: ifeq -> 718
      //   708: aload_0
      //   709: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   712: getfield C : Landroid/support/v7/widget/aq$a;
      //   715: invokevirtual a : ()V
      //   718: aload_0
      //   719: getfield c : Landroid/support/v7/widget/RecyclerView;
      //   722: iconst_1
      //   723: invokevirtual a : (I)V
      //   726: aload_2
      //   727: ifnull -> 754
      //   730: aload_2
      //   731: invokevirtual c : ()Z
      //   734: ifeq -> 743
      //   737: aload_2
      //   738: iconst_0
      //   739: iconst_0
      //   740: invokevirtual a : (II)V
      //   743: aload_0
      //   744: getfield g : Z
      //   747: ifne -> 754
      //   750: aload_2
      //   751: invokevirtual b : ()V
      //   754: aload_0
      //   755: invokespecial d : ()V
      //   758: return }
  }
  
  public static abstract class x {
    private static final List<Object> q = Collections.emptyList();
    
    public final View a;
    
    WeakReference<RecyclerView> b;
    
    int c = -1;
    
    int d = -1;
    
    long e = -1L;
    
    int f = -1;
    
    int g = -1;
    
    x h = null;
    
    x i = null;
    
    int j;
    
    List<Object> k = null;
    
    List<Object> l = null;
    
    RecyclerView.p m = null;
    
    boolean n = false;
    
    int o = -1;
    
    RecyclerView p;
    
    private int r = 0;
    
    private int s = 0;
    
    public x(View param1View) {
      if (param1View != null) {
        this.a = param1View;
        return;
      } 
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void A() {
      if (this.k == null) {
        this.k = new ArrayList();
        this.l = Collections.unmodifiableList(this.k);
      } 
    }
    
    void a() {
      this.d = -1;
      this.g = -1;
    }
    
    void a(int param1Int1, int param1Int2) { this.j = this.j & (param1Int2 ^ 0xFFFFFFFF) | param1Int1 & param1Int2; }
    
    void a(int param1Int1, int param1Int2, boolean param1Boolean) {
      b(8);
      a(param1Int2, param1Boolean);
      this.c = param1Int1;
    }
    
    void a(int param1Int, boolean param1Boolean) {
      if (this.d == -1)
        this.d = this.c; 
      if (this.g == -1)
        this.g = this.c; 
      if (param1Boolean)
        this.g = param1Int + this.g; 
      this.c = param1Int + this.c;
      if (this.a.getLayoutParams() != null)
        ((RecyclerView.j)this.a.getLayoutParams()).e = true; 
    }
    
    void a(RecyclerView.p param1p, boolean param1Boolean) {
      this.m = param1p;
      this.n = param1Boolean;
    }
    
    void a(RecyclerView param1RecyclerView) {
      int i1 = this.o;
      if (i1 == -1)
        i1 = r.e(this.a); 
      this.s = i1;
      param1RecyclerView.a(this, 4);
    }
    
    void a(Object param1Object) {
      if (param1Object == null) {
        b(1024);
        return;
      } 
      if ((0x400 & this.j) == 0) {
        A();
        this.k.add(param1Object);
      } 
    }
    
    public final void a(boolean param1Boolean) {
      int i3;
      int i1;
      if (param1Boolean) {
        i1 = this.r - 1;
      } else {
        i1 = 1 + this.r;
      } 
      this.r = i1;
      int i2 = this.r;
      if (i2 < 0) {
        this.r = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        stringBuilder.append(this);
        Log.e("View", stringBuilder.toString());
        return;
      } 
      if (!param1Boolean && i2 == 1) {
        i3 = 0x10 | this.j;
      } else if (param1Boolean && this.r == 0) {
        i3 = 0xFFFFFFEF & this.j;
      } else {
        return;
      } 
      this.j = i3;
    }
    
    boolean a(int param1Int) { return ((param1Int & this.j) != 0); }
    
    void b() {
      if (this.d == -1)
        this.d = this.c; 
    }
    
    void b(int param1Int) { this.j = param1Int | this.j; }
    
    void b(RecyclerView param1RecyclerView) {
      param1RecyclerView.a(this, this.s);
      this.s = 0;
    }
    
    boolean c() { return ((0x80 & this.j) != 0); }
    
    public final int d() {
      int i1 = this.g;
      if (i1 == -1)
        i1 = this.c; 
      return i1;
    }
    
    public final int e() {
      RecyclerView recyclerView = this.p;
      return (recyclerView == null) ? -1 : recyclerView.d(this);
    }
    
    public final int f() { return this.d; }
    
    public final long g() { return this.e; }
    
    public final int h() { return this.f; }
    
    boolean i() { return (this.m != null); }
    
    void j() { this.m.c(this); }
    
    boolean k() { return ((0x20 & this.j) != 0); }
    
    void l() { this.j = 0xFFFFFFDF & this.j; }
    
    void m() { this.j = 0xFFFFFEFF & this.j; }
    
    boolean n() { return ((0x4 & this.j) != 0); }
    
    boolean o() { return ((0x2 & this.j) != 0); }
    
    boolean p() { return ((true & this.j) != 0); }
    
    boolean q() { return ((0x8 & this.j) != 0); }
    
    boolean r() { return ((0x100 & this.j) != 0); }
    
    boolean s() { return ((0x200 & this.j) != 0 || n()); }
    
    void t() {
      List list = this.k;
      if (list != null)
        list.clear(); 
      this.j = 0xFFFFFBFF & this.j;
    }
    
    public String toString() {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ViewHolder{");
      stringBuilder1.append(Integer.toHexString(hashCode()));
      stringBuilder1.append(" position=");
      stringBuilder1.append(this.c);
      stringBuilder1.append(" id=");
      stringBuilder1.append(this.e);
      stringBuilder1.append(", oldPos=");
      stringBuilder1.append(this.d);
      stringBuilder1.append(", pLpos:");
      stringBuilder1.append(this.g);
      StringBuilder stringBuilder2 = new StringBuilder(stringBuilder1.toString());
      if (i()) {
        String str;
        stringBuilder2.append(" scrap ");
        if (this.n) {
          str = "[changeScrap]";
        } else {
          str = "[attachedScrap]";
        } 
        stringBuilder2.append(str);
      } 
      if (n())
        stringBuilder2.append(" invalid"); 
      if (!p())
        stringBuilder2.append(" unbound"); 
      if (o())
        stringBuilder2.append(" update"); 
      if (q())
        stringBuilder2.append(" removed"); 
      if (c())
        stringBuilder2.append(" ignored"); 
      if (r())
        stringBuilder2.append(" tmpDetached"); 
      if (!w()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" not recyclable(");
        stringBuilder.append(this.r);
        stringBuilder.append(")");
        stringBuilder2.append(stringBuilder.toString());
      } 
      if (s())
        stringBuilder2.append(" undefined adapter position"); 
      if (this.a.getParent() == null)
        stringBuilder2.append(" no parent"); 
      stringBuilder2.append("}");
      return stringBuilder2.toString();
    }
    
    List<Object> u() {
      if ((0x400 & this.j) == 0) {
        List list = this.k;
        return (list == null || list.size() == 0) ? q : this.l;
      } 
      return q;
    }
    
    void v() {
      this.j = 0;
      this.c = -1;
      this.d = -1;
      this.e = -1L;
      this.g = -1;
      this.r = 0;
      this.h = null;
      this.i = null;
      t();
      this.s = 0;
      this.o = -1;
      RecyclerView.c(this);
    }
    
    public final boolean w() { return ((0x10 & this.j) == 0 && !r.c(this.a)); }
    
    boolean x() { return ((0x10 & this.j) != 0); }
    
    boolean y() { return ((0x10 & this.j) == 0 && r.c(this.a)); }
    
    boolean z() { return ((0x2 & this.j) != 0); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */