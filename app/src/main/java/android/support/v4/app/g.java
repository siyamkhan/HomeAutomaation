package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.c;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.j;
import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.d;
import android.support.v4.g.l;
import android.support.v4.h.f;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class g implements e, q, ComponentCallbacks, View.OnCreateContextMenuListener {
  private static final l<String, Class<?>> a = new l();
  
  static final Object j = new Object();
  
  int A;
  
  m B;
  
  k C;
  
  m D;
  
  n E;
  
  p F;
  
  g G;
  
  int H;
  
  int I;
  
  String J;
  
  boolean K;
  
  boolean L;
  
  boolean M;
  
  boolean N;
  
  boolean O;
  
  boolean P = true;
  
  boolean Q;
  
  ViewGroup R;
  
  View S;
  
  View T;
  
  boolean U;
  
  boolean V = true;
  
  a W;
  
  boolean X;
  
  boolean Y;
  
  float Z;
  
  LayoutInflater aa;
  
  boolean ab;
  
  f ac = new f(this);
  
  f ad;
  
  e ae;
  
  j<e> af = new j();
  
  int k = 0;
  
  Bundle l;
  
  SparseArray<Parcelable> m;
  
  Boolean n;
  
  int o = -1;
  
  String p;
  
  Bundle q;
  
  g r;
  
  int s = -1;
  
  int t;
  
  boolean u;
  
  boolean v;
  
  boolean w;
  
  boolean x;
  
  boolean y;
  
  boolean z;
  
  public static g a(Context paramContext, String paramString, Bundle paramBundle) {
    try {
      Class clazz = (Class)a.get(paramString);
      if (clazz == null) {
        clazz = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, clazz);
      } 
      g g1 = (g)clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null) {
        paramBundle.setClassLoader(g1.getClass().getClassLoader());
        g1.g(paramBundle);
      } 
      return g1;
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to instantiate fragment ");
      stringBuilder.append(paramString);
      stringBuilder.append(": make sure class name exists, is public, and has an");
      stringBuilder.append(" empty constructor that is public");
      throw new b(stringBuilder.toString(), classNotFoundException);
    } catch (InstantiationException instantiationException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to instantiate fragment ");
      stringBuilder.append(paramString);
      stringBuilder.append(": make sure class name exists, is public, and has an");
      stringBuilder.append(" empty constructor that is public");
      throw new b(stringBuilder.toString(), instantiationException);
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to instantiate fragment ");
      stringBuilder.append(paramString);
      stringBuilder.append(": make sure class name exists, is public, and has an");
      stringBuilder.append(" empty constructor that is public");
      throw new b(stringBuilder.toString(), illegalAccessException);
    } catch (NoSuchMethodException noSuchMethodException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to instantiate fragment ");
      stringBuilder.append(paramString);
      stringBuilder.append(": could not find Fragment constructor");
      throw new b(stringBuilder.toString(), noSuchMethodException);
    } catch (InvocationTargetException invocationTargetException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to instantiate fragment ");
      stringBuilder.append(paramString);
      stringBuilder.append(": calling Fragment constructor caused an exception");
      throw new b(stringBuilder.toString(), invocationTargetException);
    } 
  }
  
  static boolean a(Context paramContext, String paramString) {
    try {
      Class clazz = (Class)a.get(paramString);
      if (clazz == null) {
        clazz = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, clazz);
      } 
      return g.class.isAssignableFrom(clazz);
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  private a c() {
    if (this.W == null)
      this.W = new a(); 
    return this.W;
  }
  
  public Object A() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.k;
  }
  
  public Object B() {
    a a1 = this.W;
    return (a1 == null) ? null : ((a1.l == j) ? A() : this.W.l);
  }
  
  public boolean C() {
    a a1 = this.W;
    return (a1 == null || a1.n == null) ? true : this.W.n.booleanValue();
  }
  
  public boolean D() {
    a a1 = this.W;
    return (a1 == null || a1.m == null) ? true : this.W.m.booleanValue();
  }
  
  public void E() {
    m m1 = this.B;
    if (m1 == null || m1.m == null) {
      (c()).q = false;
      return;
    } 
    if (Looper.myLooper() != this.B.m.h().getLooper()) {
      this.B.m.h().postAtFrontOfQueue(new Runnable(this) {
            public void run() { this.a.F(); }
          });
      return;
    } 
    F();
  }
  
  void F() {
    c c;
    a a1 = this.W;
    if (a1 == null) {
      c = null;
    } else {
      a1.q = false;
      c = a1.r;
      this.W.r = null;
    } 
    if (c != null)
      c.a(); 
  }
  
  void G() {
    if (this.C != null) {
      this.D = new m();
      this.D.a(this.C, new i(this) {
            public g a(Context param1Context, String param1String, Bundle param1Bundle) { return this.a.C.a(param1Context, param1String, param1Bundle); }
            
            public View a(int param1Int) {
              if (this.a.S != null)
                return this.a.S.findViewById(param1Int); 
              throw new IllegalStateException("Fragment does not have a view");
            }
            
            public boolean a() { return (this.a.S != null); }
          }this);
      return;
    } 
    throw new IllegalStateException("Fragment has not been attached yet.");
  }
  
  void H() {
    m m1 = this.D;
    if (m1 != null) {
      m1.m();
      this.D.g();
    } 
    this.k = 3;
    this.Q = false;
    e();
    if (this.Q) {
      m m2 = this.D;
      if (m2 != null)
        m2.p(); 
      this.ac.a(c.a.ON_START);
      if (this.S != null)
        this.ad.a(c.a.ON_START); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onStart()");
    throw new ad(stringBuilder.toString());
  }
  
  void I() {
    m m1 = this.D;
    if (m1 != null) {
      m1.m();
      this.D.g();
    } 
    this.k = 4;
    this.Q = false;
    r();
    if (this.Q) {
      m m2 = this.D;
      if (m2 != null) {
        m2.q();
        this.D.g();
      } 
      this.ac.a(c.a.ON_RESUME);
      if (this.S != null)
        this.ad.a(c.a.ON_RESUME); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onResume()");
    throw new ad(stringBuilder.toString());
  }
  
  void J() {
    m m1 = this.D;
    if (m1 != null)
      m1.m(); 
  }
  
  void K() {
    onLowMemory();
    m m1 = this.D;
    if (m1 != null)
      m1.v(); 
  }
  
  void L() {
    if (this.S != null)
      this.ad.a(c.a.ON_PAUSE); 
    this.ac.a(c.a.ON_PAUSE);
    m m1 = this.D;
    if (m1 != null)
      m1.r(); 
    this.k = 3;
    this.Q = false;
    s();
    if (this.Q)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onPause()");
    throw new ad(stringBuilder.toString());
  }
  
  void M() {
    if (this.S != null)
      this.ad.a(c.a.ON_STOP); 
    this.ac.a(c.a.ON_STOP);
    m m1 = this.D;
    if (m1 != null)
      m1.s(); 
    this.k = 2;
    this.Q = false;
    f();
    if (this.Q)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onStop()");
    throw new ad(stringBuilder.toString());
  }
  
  void N() {
    if (this.S != null)
      this.ad.a(c.a.ON_DESTROY); 
    m m1 = this.D;
    if (m1 != null)
      m1.t(); 
    this.k = 1;
    this.Q = false;
    g();
    if (this.Q) {
      u.a(this).a();
      this.z = false;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onDestroyView()");
    throw new ad(stringBuilder.toString());
  }
  
  void O() {
    this.ac.a(c.a.ON_DESTROY);
    m m1 = this.D;
    if (m1 != null)
      m1.u(); 
    this.k = 0;
    this.Q = false;
    this.ab = false;
    t();
    if (this.Q) {
      this.D = null;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onDestroy()");
    throw new ad(stringBuilder.toString());
  }
  
  void P() {
    this.Q = false;
    d();
    this.aa = null;
    if (this.Q) {
      m m1 = this.D;
      if (m1 != null) {
        if (this.N) {
          m1.u();
          this.D = null;
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Child FragmentManager of ");
        stringBuilder1.append(this);
        stringBuilder1.append(" was not ");
        stringBuilder1.append(" destroyed and this fragment is not retaining instance");
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onDetach()");
    throw new ad(stringBuilder.toString());
  }
  
  int Q() {
    a a1 = this.W;
    return (a1 == null) ? 0 : a1.d;
  }
  
  int R() {
    a a1 = this.W;
    return (a1 == null) ? 0 : a1.e;
  }
  
  int S() {
    a a1 = this.W;
    return (a1 == null) ? 0 : a1.f;
  }
  
  ac T() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.o;
  }
  
  ac U() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.p;
  }
  
  View V() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.a;
  }
  
  Animator W() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.b;
  }
  
  int X() {
    a a1 = this.W;
    return (a1 == null) ? 0 : a1.c;
  }
  
  boolean Y() {
    a a1 = this.W;
    return (a1 == null) ? false : a1.q;
  }
  
  boolean Z() {
    a a1 = this.W;
    return (a1 == null) ? false : a1.s;
  }
  
  public c a() { return this.ac; }
  
  g a(String paramString) {
    if (paramString.equals(this.p))
      return this; 
    m m1 = this.D;
    return (m1 != null) ? m1.b(paramString) : null;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return null; }
  
  public Animation a(int paramInt1, boolean paramBoolean, int paramInt2) { return null; }
  
  void a(int paramInt) {
    if (this.W == null && paramInt == 0)
      return; 
    (c()).d = paramInt;
  }
  
  void a(int paramInt1, int paramInt2) {
    if (this.W == null && paramInt1 == 0 && paramInt2 == 0)
      return; 
    c();
    a a1 = this.W;
    a1.e = paramInt1;
    a1.f = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void a(int paramInt, g paramg) {
    String str;
    StringBuilder stringBuilder;
    this.o = paramInt;
    if (paramg != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramg.p);
      str = ":";
    } else {
      stringBuilder = new StringBuilder();
      str = "android:fragment:";
    } 
    stringBuilder.append(str);
    stringBuilder.append(this.o);
    this.p = stringBuilder.toString();
  }
  
  public void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  void a(Animator paramAnimator) { (c()).b = paramAnimator; }
  
  @Deprecated
  public void a(Activity paramActivity) { this.Q = true; }
  
  @Deprecated
  public void a(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) { this.Q = true; }
  
  public void a(Context paramContext) {
    Activity activity;
    this.Q = true;
    k k1 = this.C;
    if (k1 == null) {
      activity = null;
    } else {
      activity = k1.f();
    } 
    if (activity != null) {
      this.Q = false;
      a(activity);
    } 
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle) {
    Activity activity;
    this.Q = true;
    k k1 = this.C;
    if (k1 == null) {
      activity = null;
    } else {
      activity = k1.f();
    } 
    if (activity != null) {
      this.Q = false;
      a(activity, paramAttributeSet, paramBundle);
    } 
  }
  
  public void a(Intent paramIntent, int paramInt) { a(paramIntent, paramInt, null); }
  
  public void a(Intent paramIntent, int paramInt, Bundle paramBundle) {
    k k1 = this.C;
    if (k1 != null) {
      k1.a(this, paramIntent, paramInt, paramBundle);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" not attached to Activity");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  void a(Configuration paramConfiguration) {
    onConfigurationChanged(paramConfiguration);
    m m1 = this.D;
    if (m1 != null)
      m1.a(paramConfiguration); 
  }
  
  public void a(Bundle paramBundle) {
    this.Q = true;
    j(paramBundle);
    m m1 = this.D;
    if (m1 != null && !m1.a(1))
      this.D.n(); 
  }
  
  void a(c paramc) {
    c();
    if (paramc == this.W.r)
      return; 
    if (paramc == null || this.W.r == null) {
      if (this.W.q)
        this.W.r = paramc; 
      if (paramc != null)
        paramc.b(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Trying to set a replacement startPostponedEnterTransition on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void a(g paramg) {}
  
  public void a(Menu paramMenu) {}
  
  public void a(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  void a(View paramView) { (c()).a = paramView; }
  
  public void a(View paramView, Bundle paramBundle) {}
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.H));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.I));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.J);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.k);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.p);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.A);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.u);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.v);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.w);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.x);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.K);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.L);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.P);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.O);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.M);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.N);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.V);
    if (this.B != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.B);
    } 
    if (this.C != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.C);
    } 
    if (this.G != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.G);
    } 
    if (this.q != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.q);
    } 
    if (this.l != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.l);
    } 
    if (this.m != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.m);
    } 
    if (this.r != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.r);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.t);
    } 
    if (Q() != 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(Q());
    } 
    if (this.R != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.R);
    } 
    if (this.S != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.S);
    } 
    if (this.T != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.S);
    } 
    if (V() != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(V());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(X());
    } 
    if (j() != null)
      u.a(this).a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
    if (this.D != null) {
      paramPrintWriter.print(paramString);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Child ");
      stringBuilder1.append(this.D);
      stringBuilder1.append(":");
      paramPrintWriter.println(stringBuilder1.toString());
      m m1 = this.D;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString);
      stringBuilder2.append("  ");
      m1.a(stringBuilder2.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    } 
  }
  
  public boolean a(MenuItem paramMenuItem) { return false; }
  
  public Animator b(int paramInt1, boolean paramBoolean, int paramInt2) { return null; }
  
  public p b() {
    if (j() != null) {
      if (this.F == null)
        this.F = new p(); 
      return this.F;
    } 
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  public LayoutInflater b(Bundle paramBundle) { return i(paramBundle); }
  
  void b(int paramInt) { (c()).c = paramInt; }
  
  void b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    m m1 = this.D;
    if (m1 != null)
      m1.m(); 
    this.z = true;
    this.ae = new e(this) {
        public c a() {
          if (this.a.ad == null) {
            g g1 = this.a;
            g1.ad = new f(g1.ae);
          } 
          return this.a.ad;
        }
      };
    this.ad = null;
    this.S = a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.S != null) {
      this.ae.a();
      this.af.a(this.ae);
      return;
    } 
    if (this.ad == null) {
      this.ae = null;
      return;
    } 
    throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
  }
  
  public void b(Menu paramMenu) {}
  
  boolean b(Menu paramMenu, MenuInflater paramMenuInflater) {
    boolean bool1 = this.K;
    boolean bool2 = false;
    if (!bool1) {
      boolean bool = this.O;
      bool2 = false;
      if (bool) {
        boolean bool3 = this.P;
        bool2 = false;
        if (bool3) {
          a(paramMenu, paramMenuInflater);
          bool2 = true;
        } 
      } 
      m m1 = this.D;
      if (m1 != null)
        bool2 |= m1.a(paramMenu, paramMenuInflater); 
    } 
    return bool2;
  }
  
  public boolean b(MenuItem paramMenuItem) { return false; }
  
  public void c(boolean paramBoolean) {}
  
  boolean c(Menu paramMenu) {
    boolean bool1 = this.K;
    boolean bool2 = false;
    if (!bool1) {
      boolean bool = this.O;
      bool2 = false;
      if (bool) {
        boolean bool3 = this.P;
        bool2 = false;
        if (bool3) {
          a(paramMenu);
          bool2 = true;
        } 
      } 
      m m1 = this.D;
      if (m1 != null)
        bool2 |= m1.a(paramMenu); 
    } 
    return bool2;
  }
  
  boolean c(MenuItem paramMenuItem) {
    if (!this.K) {
      if (this.O && this.P && a(paramMenuItem))
        return true; 
      m m1 = this.D;
      if (m1 != null && m1.a(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public void d() { this.Q = true; }
  
  public void d(Bundle paramBundle) { this.Q = true; }
  
  void d(Menu paramMenu) {
    if (!this.K) {
      if (this.O && this.P)
        b(paramMenu); 
      m m1 = this.D;
      if (m1 != null)
        m1.b(paramMenu); 
    } 
  }
  
  public void d(boolean paramBoolean) {}
  
  boolean d(MenuItem paramMenuItem) {
    if (!this.K) {
      if (b(paramMenuItem))
        return true; 
      m m1 = this.D;
      if (m1 != null && m1.b(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public void e() { this.Q = true; }
  
  public void e(Bundle paramBundle) {}
  
  public void e(boolean paramBoolean) {}
  
  public final boolean equals(Object paramObject) { return super.equals(paramObject); }
  
  public void f() { this.Q = true; }
  
  final void f(Bundle paramBundle) {
    SparseArray sparseArray = this.m;
    if (sparseArray != null) {
      this.T.restoreHierarchyState(sparseArray);
      this.m = null;
    } 
    this.Q = false;
    k(paramBundle);
    if (this.Q) {
      if (this.S != null)
        this.ad.a(c.a.ON_CREATE); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onViewStateRestored()");
    throw new ad(stringBuilder.toString());
  }
  
  void f(boolean paramBoolean) {
    d(paramBoolean);
    m m1 = this.D;
    if (m1 != null)
      m1.a(paramBoolean); 
  }
  
  public void g() { this.Q = true; }
  
  public void g(Bundle paramBundle) {
    if (this.o < 0 || !i()) {
      this.q = paramBundle;
      return;
    } 
    throw new IllegalStateException("Fragment already active and state has been saved");
  }
  
  void g(boolean paramBoolean) {
    e(paramBoolean);
    m m1 = this.D;
    if (m1 != null)
      m1.b(paramBoolean); 
  }
  
  LayoutInflater h(Bundle paramBundle) {
    this.aa = b(paramBundle);
    return this.aa;
  }
  
  void h(boolean paramBoolean) { (c()).s = paramBoolean; }
  
  final boolean h() { return (this.A > 0); }
  
  public final int hashCode() { return super.hashCode(); }
  
  @Deprecated
  public LayoutInflater i(Bundle paramBundle) {
    k k1 = this.C;
    if (k1 != null) {
      LayoutInflater layoutInflater = k1.b();
      o();
      f.a(layoutInflater, this.D.x());
      return layoutInflater;
    } 
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public final boolean i() {
    m m1 = this.B;
    return (m1 == null) ? false : m1.d();
  }
  
  public Context j() {
    k k1 = this.C;
    return (k1 == null) ? null : k1.g();
  }
  
  void j(Bundle paramBundle) {
    if (paramBundle != null) {
      Parcelable parcelable = paramBundle.getParcelable("android:support:fragments");
      if (parcelable != null) {
        if (this.D == null)
          G(); 
        this.D.a(parcelable, this.E);
        this.E = null;
        this.D.n();
      } 
    } 
  }
  
  public final Context k() {
    Context context = j();
    if (context != null)
      return context; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" not attached to a context.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void k(Bundle paramBundle) { this.Q = true; }
  
  public final h l() {
    k k1 = this.C;
    return (k1 == null) ? null : (h)k1.f();
  }
  
  void l(Bundle paramBundle) {
    m m1 = this.D;
    if (m1 != null)
      m1.m(); 
    this.k = 1;
    this.Q = false;
    a(paramBundle);
    this.ab = true;
    if (this.Q) {
      this.ac.a(c.a.ON_CREATE);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onCreate()");
    throw new ad(stringBuilder.toString());
  }
  
  public final Resources m() { return k().getResources(); }
  
  void m(Bundle paramBundle) {
    m m1 = this.D;
    if (m1 != null)
      m1.m(); 
    this.k = 2;
    this.Q = false;
    d(paramBundle);
    if (this.Q) {
      m m2 = this.D;
      if (m2 != null)
        m2.o(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onActivityCreated()");
    throw new ad(stringBuilder.toString());
  }
  
  public final l n() { return this.B; }
  
  void n(Bundle paramBundle) {
    e(paramBundle);
    m m1 = this.D;
    if (m1 != null) {
      Parcelable parcelable = m1.l();
      if (parcelable != null)
        paramBundle.putParcelable("android:support:fragments", parcelable); 
    } 
  }
  
  public final l o() {
    if (this.D == null) {
      G();
      int i = this.k;
      if (i >= 4) {
        this.D.q();
      } else if (i >= 3) {
        this.D.p();
      } else if (i >= 2) {
        this.D.o();
      } else if (i >= 1) {
        this.D.n();
      } 
    } 
    return this.D;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) { this.Q = true; }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) { l().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo); }
  
  public void onLowMemory() { this.Q = true; }
  
  l p() { return this.D; }
  
  public View q() { return this.S; }
  
  public void r() { this.Q = true; }
  
  public void s() { this.Q = true; }
  
  public void t() {
    boolean bool = true;
    this.Q = bool;
    h h = l();
    if (h == null || !h.isChangingConfigurations())
      bool = false; 
    p p1 = this.F;
    if (p1 != null && !bool)
      p1.a(); 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    d.a(this, stringBuilder);
    if (this.o >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.o);
    } 
    if (this.H != 0) {
      stringBuilder.append(" id=0x");
      stringBuilder.append(Integer.toHexString(this.H));
    } 
    if (this.J != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.J);
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  void u() {
    this.o = -1;
    this.p = null;
    this.u = false;
    this.v = false;
    this.w = false;
    this.x = false;
    this.y = false;
    this.A = 0;
    this.B = null;
    this.D = null;
    this.C = null;
    this.H = 0;
    this.I = 0;
    this.J = null;
    this.K = false;
    this.L = false;
    this.N = false;
  }
  
  public void v() {}
  
  public Object w() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.g;
  }
  
  public Object x() {
    a a1 = this.W;
    return (a1 == null) ? null : ((a1.h == j) ? w() : this.W.h);
  }
  
  public Object y() {
    a a1 = this.W;
    return (a1 == null) ? null : a1.i;
  }
  
  public Object z() {
    a a1 = this.W;
    return (a1 == null) ? null : ((a1.j == j) ? y() : this.W.j);
  }
  
  static class a {
    View a;
    
    Animator b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    Object g = null;
    
    Object h = g.j;
    
    Object i = null;
    
    Object j = g.j;
    
    Object k = null;
    
    Object l = g.j;
    
    Boolean m;
    
    Boolean n;
    
    ac o = null;
    
    ac p = null;
    
    boolean q;
    
    g.c r;
    
    boolean s;
  }
  
  public static class b extends RuntimeException {
    public b(String param1String, Exception param1Exception) { super(param1String, param1Exception); }
  }
  
  static interface c {
    void a();
    
    void b();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */