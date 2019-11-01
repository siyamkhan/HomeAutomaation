package android.support.v7.app;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.v;
import android.support.v4.h.e;
import android.support.v4.h.f;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v4.h.x;
import android.support.v4.h.z;
import android.support.v4.widget.k;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.support.v7.view.b;
import android.support.v7.view.d;
import android.support.v7.view.e;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ai;
import android.support.v7.widget.ao;
import android.support.v7.widget.bm;
import android.support.v7.widget.bu;
import android.support.v7.widget.l;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.List;

class f extends e implements h.a, LayoutInflater.Factory2 {
  private static final boolean u;
  
  private static final int[] v;
  
  private static boolean w;
  
  private g A;
  
  private boolean B = true;
  
  private boolean C;
  
  private ViewGroup D;
  
  private TextView E;
  
  private View F;
  
  private boolean G;
  
  private boolean H;
  
  private boolean I;
  
  private f[] J;
  
  private f K;
  
  private boolean L;
  
  private int M = -100;
  
  private boolean N;
  
  private d O;
  
  private final Runnable P = new Runnable(this) {
      public void run() {
        if ((true & this.a.t) != 0)
          this.a.g(0); 
        if ((0x1000 & this.a.t) != 0)
          this.a.g(108); 
        f f1 = this.a;
        f1.s = false;
        f1.t = 0;
      }
    };
  
  private boolean Q;
  
  private Rect R;
  
  private Rect S;
  
  private AppCompatViewInflater T;
  
  final Context a;
  
  final Window b;
  
  final Window.Callback c;
  
  final Window.Callback d;
  
  final d e;
  
  a f;
  
  MenuInflater g;
  
  b h;
  
  ActionBarContextView i;
  
  PopupWindow j;
  
  Runnable k;
  
  v l = null;
  
  boolean m;
  
  boolean n;
  
  boolean o;
  
  boolean p;
  
  boolean q;
  
  boolean r;
  
  boolean s;
  
  int t;
  
  private CharSequence x;
  
  private ai y;
  
  private a z;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    } 
    u = bool;
    v = new int[] { 16842836 };
    if (u && !w) {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()) {
            private boolean a(Throwable param1Throwable) {
              boolean bool = param1Throwable instanceof Resources.NotFoundException;
              null = false;
              if (bool) {
                String str = param1Throwable.getMessage();
                null = false;
                if (str != null) {
                  if (!str.contains("drawable")) {
                    boolean bool1 = str.contains("Drawable");
                    null = false;
                    return bool1 ? true : null;
                  } 
                } else {
                  return null;
                } 
              } else {
                return null;
              } 
              return true;
            }
            
            public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
              if (a(param1Throwable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Throwable.getMessage());
                stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
                notFoundException.initCause(param1Throwable.getCause());
                notFoundException.setStackTrace(param1Throwable.getStackTrace());
                this.a.uncaughtException(param1Thread, notFoundException);
                return;
              } 
              this.a.uncaughtException(param1Thread, param1Throwable);
            }
          });
      w = true;
    } 
  }
  
  f(Context paramContext, Window paramWindow, d paramd) {
    this.a = paramContext;
    this.b = paramWindow;
    this.e = paramd;
    this.c = this.b.getCallback();
    Window.Callback callback = this.c;
    if (!(callback instanceof c)) {
      this.d = new c(this, callback);
      this.b.setCallback(this.d);
      bm bm = bm.a(paramContext, null, v);
      Drawable drawable = bm.b(0);
      if (drawable != null)
        this.b.setBackgroundDrawable(drawable); 
      bm.a();
      return;
    } 
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  private boolean A() {
    if (this.N) {
      Context context = this.a;
      if (context instanceof Activity) {
        PackageManager packageManager = context.getPackageManager();
        try {
          int i1 = (packageManager.getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0)).configChanges;
          int i2 = i1 & 0x200;
          boolean bool = false;
          if (i2 == 0)
            bool = true; 
          return bool;
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", nameNotFoundException);
          return true;
        } 
      } 
    } 
    return false;
  }
  
  private void a(f paramf, KeyEvent paramKeyEvent) { // Byte code:
    //   0: aload_1
    //   1: getfield o : Z
    //   4: ifne -> 417
    //   7: aload_0
    //   8: getfield r : Z
    //   11: ifeq -> 15
    //   14: return
    //   15: aload_1
    //   16: getfield a : I
    //   19: ifne -> 57
    //   22: bipush #15
    //   24: aload_0
    //   25: getfield a : Landroid/content/Context;
    //   28: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   31: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   34: getfield screenLayout : I
    //   37: iand
    //   38: iconst_4
    //   39: if_icmpne -> 48
    //   42: iconst_1
    //   43: istore #12
    //   45: goto -> 51
    //   48: iconst_0
    //   49: istore #12
    //   51: iload #12
    //   53: ifeq -> 57
    //   56: return
    //   57: aload_0
    //   58: invokevirtual l : ()Landroid/view/Window$Callback;
    //   61: astore_3
    //   62: aload_3
    //   63: ifnull -> 90
    //   66: aload_3
    //   67: aload_1
    //   68: getfield a : I
    //   71: aload_1
    //   72: getfield j : Landroid/support/v7/view/menu/h;
    //   75: invokeinterface onMenuOpened : (ILandroid/view/Menu;)Z
    //   80: ifne -> 90
    //   83: aload_0
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual a : (Landroid/support/v7/app/f$f;Z)V
    //   89: return
    //   90: aload_0
    //   91: getfield a : Landroid/content/Context;
    //   94: ldc 'window'
    //   96: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   99: checkcast android/view/WindowManager
    //   102: astore #4
    //   104: aload #4
    //   106: ifnonnull -> 110
    //   109: return
    //   110: aload_0
    //   111: aload_1
    //   112: aload_2
    //   113: invokespecial b : (Landroid/support/v7/app/f$f;Landroid/view/KeyEvent;)Z
    //   116: ifne -> 120
    //   119: return
    //   120: aload_1
    //   121: getfield g : Landroid/view/ViewGroup;
    //   124: ifnull -> 173
    //   127: aload_1
    //   128: getfield q : Z
    //   131: ifeq -> 137
    //   134: goto -> 173
    //   137: aload_1
    //   138: getfield i : Landroid/view/View;
    //   141: ifnull -> 343
    //   144: aload_1
    //   145: getfield i : Landroid/view/View;
    //   148: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   151: astore #11
    //   153: aload #11
    //   155: ifnull -> 343
    //   158: aload #11
    //   160: getfield width : I
    //   163: iconst_m1
    //   164: if_icmpne -> 343
    //   167: iconst_m1
    //   168: istore #8
    //   170: goto -> 347
    //   173: aload_1
    //   174: getfield g : Landroid/view/ViewGroup;
    //   177: ifnonnull -> 196
    //   180: aload_0
    //   181: aload_1
    //   182: invokespecial a : (Landroid/support/v7/app/f$f;)Z
    //   185: ifeq -> 195
    //   188: aload_1
    //   189: getfield g : Landroid/view/ViewGroup;
    //   192: ifnonnull -> 220
    //   195: return
    //   196: aload_1
    //   197: getfield q : Z
    //   200: ifeq -> 220
    //   203: aload_1
    //   204: getfield g : Landroid/view/ViewGroup;
    //   207: invokevirtual getChildCount : ()I
    //   210: ifle -> 220
    //   213: aload_1
    //   214: getfield g : Landroid/view/ViewGroup;
    //   217: invokevirtual removeAllViews : ()V
    //   220: aload_0
    //   221: aload_1
    //   222: invokespecial c : (Landroid/support/v7/app/f$f;)Z
    //   225: ifeq -> 417
    //   228: aload_1
    //   229: invokevirtual a : ()Z
    //   232: ifne -> 236
    //   235: return
    //   236: aload_1
    //   237: getfield h : Landroid/view/View;
    //   240: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   243: astore #5
    //   245: aload #5
    //   247: ifnonnull -> 263
    //   250: new android/view/ViewGroup$LayoutParams
    //   253: dup
    //   254: bipush #-2
    //   256: bipush #-2
    //   258: invokespecial <init> : (II)V
    //   261: astore #5
    //   263: aload_1
    //   264: getfield b : I
    //   267: istore #6
    //   269: aload_1
    //   270: getfield g : Landroid/view/ViewGroup;
    //   273: iload #6
    //   275: invokevirtual setBackgroundResource : (I)V
    //   278: aload_1
    //   279: getfield h : Landroid/view/View;
    //   282: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   285: astore #7
    //   287: aload #7
    //   289: ifnull -> 312
    //   292: aload #7
    //   294: instanceof android/view/ViewGroup
    //   297: ifeq -> 312
    //   300: aload #7
    //   302: checkcast android/view/ViewGroup
    //   305: aload_1
    //   306: getfield h : Landroid/view/View;
    //   309: invokevirtual removeView : (Landroid/view/View;)V
    //   312: aload_1
    //   313: getfield g : Landroid/view/ViewGroup;
    //   316: aload_1
    //   317: getfield h : Landroid/view/View;
    //   320: aload #5
    //   322: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   325: aload_1
    //   326: getfield h : Landroid/view/View;
    //   329: invokevirtual hasFocus : ()Z
    //   332: ifne -> 343
    //   335: aload_1
    //   336: getfield h : Landroid/view/View;
    //   339: invokevirtual requestFocus : ()Z
    //   342: pop
    //   343: bipush #-2
    //   345: istore #8
    //   347: aload_1
    //   348: iconst_0
    //   349: putfield n : Z
    //   352: new android/view/WindowManager$LayoutParams
    //   355: dup
    //   356: iload #8
    //   358: bipush #-2
    //   360: aload_1
    //   361: getfield d : I
    //   364: aload_1
    //   365: getfield e : I
    //   368: sipush #1002
    //   371: ldc_w 8519680
    //   374: bipush #-3
    //   376: invokespecial <init> : (IIIIIII)V
    //   379: astore #9
    //   381: aload #9
    //   383: aload_1
    //   384: getfield c : I
    //   387: putfield gravity : I
    //   390: aload #9
    //   392: aload_1
    //   393: getfield f : I
    //   396: putfield windowAnimations : I
    //   399: aload #4
    //   401: aload_1
    //   402: getfield g : Landroid/view/ViewGroup;
    //   405: aload #9
    //   407: invokeinterface addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   412: aload_1
    //   413: iconst_1
    //   414: putfield o : Z
    //   417: return }
  
  private void a(h paramh, boolean paramBoolean) {
    ai ai1 = this.y;
    if (ai1 != null && ai1.e() && (!ViewConfiguration.get(this.a).hasPermanentMenuKey() || this.y.g())) {
      Window.Callback callback = l();
      if (!this.y.f() || !paramBoolean) {
        if (callback != null && !this.r) {
          if (this.s && (true & this.t) != 0) {
            this.b.getDecorView().removeCallbacks(this.P);
            this.P.run();
          } 
          f f2 = a(0, true);
          if (f2.j != null && !f2.r && callback.onPreparePanel(0, f2.i, f2.j)) {
            callback.onMenuOpened(108, f2.j);
            this.y.h();
          } 
        } 
        return;
      } 
      this.y.i();
      if (!this.r) {
        callback.onPanelClosed(108, (a(0, true)).j);
        return;
      } 
      return;
    } 
    f f1 = a(0, true);
    f1.q = true;
    a(f1, false);
    a(f1, null);
  }
  
  private boolean a(f paramf) {
    paramf.a(m());
    paramf.g = new e(this, paramf.l);
    paramf.c = 81;
    return true;
  }
  
  private boolean a(f paramf, int paramInt1, KeyEvent paramKeyEvent, int paramInt2) { // Byte code:
    //   0: aload_3
    //   1: invokevirtual isSystem : ()Z
    //   4: ifeq -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: getfield m : Z
    //   13: ifne -> 32
    //   16: aload_0
    //   17: aload_1
    //   18: aload_3
    //   19: invokespecial b : (Landroid/support/v7/app/f$f;Landroid/view/KeyEvent;)Z
    //   22: istore #7
    //   24: iconst_0
    //   25: istore #6
    //   27: iload #7
    //   29: ifeq -> 59
    //   32: aload_1
    //   33: getfield j : Landroid/support/v7/view/menu/h;
    //   36: astore #5
    //   38: iconst_0
    //   39: istore #6
    //   41: aload #5
    //   43: ifnull -> 59
    //   46: aload_1
    //   47: getfield j : Landroid/support/v7/view/menu/h;
    //   50: iload_2
    //   51: aload_3
    //   52: iload #4
    //   54: invokevirtual performShortcut : (ILandroid/view/KeyEvent;I)Z
    //   57: istore #6
    //   59: iload #6
    //   61: ifeq -> 84
    //   64: iload #4
    //   66: iconst_1
    //   67: iand
    //   68: ifne -> 84
    //   71: aload_0
    //   72: getfield y : Landroid/support/v7/widget/ai;
    //   75: ifnonnull -> 84
    //   78: aload_0
    //   79: aload_1
    //   80: iconst_1
    //   81: invokevirtual a : (Landroid/support/v7/app/f$f;Z)V
    //   84: iload #6
    //   86: ireturn }
  
  private boolean a(ViewParent paramViewParent) {
    if (paramViewParent == null)
      return false; 
    View view = this.b.getDecorView();
    while (true) {
      if (paramViewParent == null)
        return true; 
      if (paramViewParent != view && paramViewParent instanceof View) {
        if (r.A((View)paramViewParent))
          return false; 
        paramViewParent = paramViewParent.getParent();
        continue;
      } 
      break;
    } 
    return false;
  }
  
  private boolean b(f paramf) {
    d d1 = this.a;
    if ((paramf.a == 0 || paramf.a == 108) && this.y != null) {
      TypedValue typedValue = new TypedValue();
      Resources.Theme theme1 = d1.getTheme();
      theme1.resolveAttribute(a.a.actionBarTheme, typedValue, true);
      Resources.Theme theme2 = null;
      if (typedValue.resourceId != 0) {
        theme2 = d1.getResources().newTheme();
        theme2.setTo(theme1);
        theme2.applyStyle(typedValue.resourceId, true);
        theme2.resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
      } else {
        theme1.resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
      } 
      if (typedValue.resourceId != 0) {
        if (theme2 == null) {
          theme2 = d1.getResources().newTheme();
          theme2.setTo(theme1);
        } 
        theme2.applyStyle(typedValue.resourceId, true);
      } 
      if (theme2 != null) {
        d d2 = new d(d1, 0);
        d2.getTheme().setTo(theme2);
        d1 = d2;
      } 
    } 
    h h1 = new h(d1);
    h1.a(this);
    paramf.a(h1);
    return true;
  }
  
  private boolean b(f paramf, KeyEvent paramKeyEvent) {
    boolean bool;
    if (this.r)
      return false; 
    if (paramf.m)
      return true; 
    f f1 = this.K;
    if (f1 != null && f1 != paramf)
      a(f1, false); 
    Window.Callback callback = l();
    if (callback != null)
      paramf.i = callback.onCreatePanelView(paramf.a); 
    if (paramf.a == 0 || paramf.a == 108) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      ai ai1 = this.y;
      if (ai1 != null)
        ai1.j(); 
    } 
    if (paramf.i == null && (!bool || !(k() instanceof i))) {
      boolean bool1;
      byte b1;
      if (paramf.j == null || paramf.r) {
        if (paramf.j == null && (!b(paramf) || paramf.j == null))
          return false; 
        if (bool && this.y != null) {
          if (this.z == null)
            this.z = new a(this); 
          this.y.a(paramf.j, this.z);
        } 
        paramf.j.h();
        if (!callback.onCreatePanelMenu(paramf.a, paramf.j)) {
          paramf.a(null);
          if (bool) {
            ai ai1 = this.y;
            if (ai1 != null)
              ai1.a(null, this.z); 
          } 
          return false;
        } 
        paramf.r = false;
      } 
      paramf.j.h();
      if (paramf.s != null) {
        paramf.j.b(paramf.s);
        paramf.s = null;
      } 
      if (!callback.onPreparePanel(0, paramf.i, paramf.j)) {
        if (bool) {
          ai ai1 = this.y;
          if (ai1 != null)
            ai1.a(null, this.z); 
        } 
        paramf.j.i();
        return false;
      } 
      if (paramKeyEvent != null) {
        b1 = paramKeyEvent.getDeviceId();
      } else {
        b1 = -1;
      } 
      if (KeyCharacterMap.load(b1).getKeyboardType() != 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      paramf.p = bool1;
      paramf.j.setQwertyMode(paramf.p);
      paramf.j.i();
    } 
    paramf.m = true;
    paramf.n = false;
    this.K = paramf;
    return true;
  }
  
  private boolean c(f paramf) {
    if (paramf.i != null) {
      paramf.h = paramf.i;
      return true;
    } 
    if (paramf.j == null)
      return false; 
    if (this.A == null)
      this.A = new g(this); 
    paramf.h = (View)paramf.a(this.A);
    return (paramf.h != null);
  }
  
  private boolean d(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() == 0) {
      f f1 = a(paramInt, true);
      if (!f1.o)
        return b(f1, paramKeyEvent); 
    } 
    return false;
  }
  
  private boolean e(int paramInt, KeyEvent paramKeyEvent) { // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/support/v7/view/b;
    //   4: ifnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: iload_1
    //   11: iconst_1
    //   12: invokevirtual a : (IZ)Landroid/support/v7/app/f$f;
    //   15: astore_3
    //   16: iload_1
    //   17: ifne -> 110
    //   20: aload_0
    //   21: getfield y : Landroid/support/v7/widget/ai;
    //   24: astore #8
    //   26: aload #8
    //   28: ifnull -> 110
    //   31: aload #8
    //   33: invokeinterface e : ()Z
    //   38: ifeq -> 110
    //   41: aload_0
    //   42: getfield a : Landroid/content/Context;
    //   45: invokestatic get : (Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   48: invokevirtual hasPermanentMenuKey : ()Z
    //   51: ifne -> 110
    //   54: aload_0
    //   55: getfield y : Landroid/support/v7/widget/ai;
    //   58: invokeinterface f : ()Z
    //   63: ifne -> 96
    //   66: aload_0
    //   67: getfield r : Z
    //   70: ifne -> 177
    //   73: aload_0
    //   74: aload_3
    //   75: aload_2
    //   76: invokespecial b : (Landroid/support/v7/app/f$f;Landroid/view/KeyEvent;)Z
    //   79: ifeq -> 177
    //   82: aload_0
    //   83: getfield y : Landroid/support/v7/widget/ai;
    //   86: invokeinterface h : ()Z
    //   91: istore #4
    //   93: goto -> 195
    //   96: aload_0
    //   97: getfield y : Landroid/support/v7/widget/ai;
    //   100: invokeinterface i : ()Z
    //   105: istore #4
    //   107: goto -> 195
    //   110: aload_3
    //   111: getfield o : Z
    //   114: ifne -> 183
    //   117: aload_3
    //   118: getfield n : Z
    //   121: ifeq -> 127
    //   124: goto -> 183
    //   127: aload_3
    //   128: getfield m : Z
    //   131: ifeq -> 177
    //   134: aload_3
    //   135: getfield r : Z
    //   138: ifeq -> 157
    //   141: aload_3
    //   142: iconst_0
    //   143: putfield m : Z
    //   146: aload_0
    //   147: aload_3
    //   148: aload_2
    //   149: invokespecial b : (Landroid/support/v7/app/f$f;Landroid/view/KeyEvent;)Z
    //   152: istore #7
    //   154: goto -> 160
    //   157: iconst_1
    //   158: istore #7
    //   160: iload #7
    //   162: ifeq -> 177
    //   165: aload_0
    //   166: aload_3
    //   167: aload_2
    //   168: invokespecial a : (Landroid/support/v7/app/f$f;Landroid/view/KeyEvent;)V
    //   171: iconst_1
    //   172: istore #4
    //   174: goto -> 195
    //   177: iconst_0
    //   178: istore #4
    //   180: goto -> 195
    //   183: aload_3
    //   184: getfield o : Z
    //   187: istore #4
    //   189: aload_0
    //   190: aload_3
    //   191: iconst_1
    //   192: invokevirtual a : (Landroid/support/v7/app/f$f;Z)V
    //   195: iload #4
    //   197: ifeq -> 238
    //   200: aload_0
    //   201: getfield a : Landroid/content/Context;
    //   204: ldc_w 'audio'
    //   207: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   210: checkcast android/media/AudioManager
    //   213: astore #5
    //   215: aload #5
    //   217: ifnull -> 229
    //   220: aload #5
    //   222: iconst_0
    //   223: invokevirtual playSoundEffect : (I)V
    //   226: iload #4
    //   228: ireturn
    //   229: ldc 'AppCompatDelegate'
    //   231: ldc_w 'Couldn't get audio manager'
    //   234: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   237: pop
    //   238: iload #4
    //   240: ireturn }
  
  private void j(int paramInt) {
    this.t |= 1 << paramInt;
    if (!this.s) {
      r.a(this.b.getDecorView(), this.P);
      this.s = true;
    } 
  }
  
  private int k(int paramInt) {
    if (paramInt == 8) {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    } 
    if (paramInt == 9) {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      paramInt = 109;
    } 
    return paramInt;
  }
  
  private boolean l(int paramInt) {
    int i2;
    Resources resources = this.a.getResources();
    Configuration configuration = resources.getConfiguration();
    int i1 = 0x30 & configuration.uiMode;
    if (paramInt == 2) {
      i2 = 32;
    } else {
      i2 = 16;
    } 
    if (i1 != i2) {
      if (A()) {
        ((Activity)this.a).recreate();
      } else {
        Configuration configuration1 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration1.uiMode = i2 | 0xFFFFFFCF & configuration1.uiMode;
        resources.updateConfiguration(configuration1, displayMetrics);
        if (Build.VERSION.SDK_INT < 26)
          h.a(resources); 
      } 
      return true;
    } 
    return false;
  }
  
  private void t() { // Byte code:
    //   0: aload_0
    //   1: invokespecial u : ()V
    //   4: aload_0
    //   5: getfield m : Z
    //   8: ifeq -> 94
    //   11: aload_0
    //   12: getfield f : Landroid/support/v7/app/a;
    //   15: ifnull -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield c : Landroid/view/Window$Callback;
    //   23: astore_1
    //   24: aload_1
    //   25: instanceof android/app/Activity
    //   28: ifeq -> 55
    //   31: new android/support/v7/app/l
    //   34: dup
    //   35: aload_1
    //   36: checkcast android/app/Activity
    //   39: aload_0
    //   40: getfield n : Z
    //   43: invokespecial <init> : (Landroid/app/Activity;Z)V
    //   46: astore_2
    //   47: aload_0
    //   48: aload_2
    //   49: putfield f : Landroid/support/v7/app/a;
    //   52: goto -> 77
    //   55: aload_1
    //   56: instanceof android/app/Dialog
    //   59: ifeq -> 77
    //   62: new android/support/v7/app/l
    //   65: dup
    //   66: aload_1
    //   67: checkcast android/app/Dialog
    //   70: invokespecial <init> : (Landroid/app/Dialog;)V
    //   73: astore_2
    //   74: goto -> 47
    //   77: aload_0
    //   78: getfield f : Landroid/support/v7/app/a;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull -> 94
    //   86: aload_3
    //   87: aload_0
    //   88: getfield Q : Z
    //   91: invokevirtual e : (Z)V
    //   94: return }
  
  private void u() {
    if (!this.C) {
      this.D = v();
      CharSequence charSequence = n();
      if (!TextUtils.isEmpty(charSequence)) {
        ai ai1 = this.y;
        if (ai1 != null) {
          ai1.setWindowTitle(charSequence);
        } else if (k() != null) {
          k().a(charSequence);
        } else {
          TextView textView = this.E;
          if (textView != null)
            textView.setText(charSequence); 
        } 
      } 
      w();
      a(this.D);
      this.C = true;
      f f1 = a(0, false);
      if (!this.r && (f1 == null || f1.j == null))
        j(108); 
    } 
  }
  
  private ViewGroup v() {
    TypedArray typedArray = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
    if (typedArray.hasValue(a.j.AppCompatTheme_windowActionBar)) {
      ViewGroup viewGroup;
      if (typedArray.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
        c(1);
      } else if (typedArray.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
        c(108);
      } 
      if (typedArray.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false))
        c(109); 
      if (typedArray.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false))
        c(10); 
      this.p = typedArray.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
      typedArray.recycle();
      this.b.getDecorView();
      LayoutInflater layoutInflater = LayoutInflater.from(this.a);
      if (!this.q) {
        if (this.p) {
          viewGroup = (ViewGroup)layoutInflater.inflate(a.g.abc_dialog_title_material, null);
          this.n = false;
          this.m = false;
        } else if (this.m) {
          Context context;
          TypedValue typedValue = new TypedValue();
          this.a.getTheme().resolveAttribute(a.a.actionBarTheme, typedValue, true);
          if (typedValue.resourceId != 0) {
            context = new d(this.a, typedValue.resourceId);
          } else {
            context = this.a;
          } 
          viewGroup = (ViewGroup)LayoutInflater.from(context).inflate(a.g.abc_screen_toolbar, null);
          this.y = (ai)viewGroup.findViewById(a.f.decor_content_parent);
          this.y.setWindowCallback(l());
          if (this.n)
            this.y.a(109); 
          if (this.G)
            this.y.a(2); 
          if (this.H)
            this.y.a(5); 
        } else {
          viewGroup = null;
        } 
      } else {
        int i1;
        if (this.o) {
          i1 = a.g.abc_screen_simple_overlay_action_mode;
        } else {
          i1 = a.g.abc_screen_simple;
        } 
        viewGroup = (ViewGroup)layoutInflater.inflate(i1, null);
        if (Build.VERSION.SDK_INT >= 21) {
          r.a(viewGroup, new p(this) {
                public z a(View param1View, z param1z) {
                  int i = param1z.b();
                  int j = this.a.h(i);
                  if (i != j)
                    param1z = param1z.a(param1z.a(), j, param1z.c(), param1z.d()); 
                  return r.a(param1View, param1z);
                }
              });
        } else {
          ((ao)viewGroup).setOnFitSystemWindowsListener(new ao.a(this) {
                public void a(Rect param1Rect) { param1Rect.top = this.a.h(param1Rect.top); }
              });
        } 
      } 
      if (viewGroup != null) {
        if (this.y == null)
          this.E = (TextView)viewGroup.findViewById(a.f.title); 
        bu.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)viewGroup.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup1 = (ViewGroup)this.b.findViewById(16908290);
        if (viewGroup1 != null) {
          while (viewGroup1.getChildCount() > 0) {
            View view = viewGroup1.getChildAt(0);
            viewGroup1.removeViewAt(0);
            contentFrameLayout.addView(view);
          } 
          viewGroup1.setId(-1);
          contentFrameLayout.setId(16908290);
          if (viewGroup1 instanceof FrameLayout)
            ((FrameLayout)viewGroup1).setForeground(null); 
        } 
        this.b.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a(this) {
              public void a() {}
              
              public void b() { this.a.s(); }
            });
        return viewGroup;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
      stringBuilder.append(this.m);
      stringBuilder.append(", windowActionBarOverlay: ");
      stringBuilder.append(this.n);
      stringBuilder.append(", android:windowIsFloating: ");
      stringBuilder.append(this.p);
      stringBuilder.append(", windowActionModeOverlay: ");
      stringBuilder.append(this.o);
      stringBuilder.append(", windowNoTitle: ");
      stringBuilder.append(this.q);
      stringBuilder.append(" }");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    typedArray.recycle();
    throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
  }
  
  private void w() {
    ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.D.findViewById(16908290);
    View view = this.b.getDecorView();
    contentFrameLayout.a(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    TypedArray typedArray = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
    typedArray.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
    typedArray.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
    if (typedArray.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor))
      typedArray.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor()); 
    if (typedArray.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor))
      typedArray.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor()); 
    if (typedArray.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor))
      typedArray.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor()); 
    if (typedArray.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor))
      typedArray.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor()); 
    typedArray.recycle();
    contentFrameLayout.requestLayout();
  }
  
  private void x() {
    if (!this.C)
      return; 
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  private int y() {
    int i1 = this.M;
    return (i1 != -100) ? i1 : j();
  }
  
  private void z() {
    if (this.O == null)
      this.O = new d(this, k.a(this.a)); 
  }
  
  public a a() {
    t();
    return this.f;
  }
  
  protected f a(int paramInt, boolean paramBoolean) {
    f[] arrayOff = this.J;
    if (arrayOff == null || arrayOff.length <= paramInt) {
      f[] arrayOff1 = new f[paramInt + 1];
      if (arrayOff != null)
        System.arraycopy(arrayOff, 0, arrayOff1, 0, arrayOff.length); 
      this.J = arrayOff1;
      arrayOff = arrayOff1;
    } 
    f f1 = arrayOff[paramInt];
    if (f1 == null) {
      f1 = new f(paramInt);
      arrayOff[paramInt] = f1;
    } 
    return f1;
  }
  
  f a(Menu paramMenu) {
    boolean bool;
    f[] arrayOff = this.J;
    byte b1 = 0;
    if (arrayOff != null) {
      bool = arrayOff.length;
      b1 = 0;
    } else {
      bool = false;
    } 
    while (b1 < bool) {
      f f1 = arrayOff[b1];
      if (f1 != null && f1.j == paramMenu)
        return f1; 
      b1++;
    } 
    return null;
  }
  
  public b a(b.a parama) {
    if (parama != null) {
      b b1 = this.h;
      if (b1 != null)
        b1.c(); 
      b b2 = new b(this, parama);
      a a1 = a();
      if (a1 != null) {
        this.h = a1.a(b2);
        b b3 = this.h;
        if (b3 != null) {
          d d1 = this.e;
          if (d1 != null)
            d1.a(b3); 
        } 
      } 
      if (this.h == null)
        this.h = b(b2); 
      return this.h;
    } 
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  public <T extends View> T a(int paramInt) {
    u();
    return (T)this.b.findViewById(paramInt);
  }
  
  public View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) { // Byte code:
    //   0: aload_0
    //   1: getfield T : Landroid/support/v7/app/AppCompatViewInflater;
    //   4: ifnonnull -> 153
    //   7: aload_0
    //   8: getfield a : Landroid/content/Context;
    //   11: getstatic android/support/v7/a/a$j.AppCompatTheme : [I
    //   14: invokevirtual obtainStyledAttributes : ([I)Landroid/content/res/TypedArray;
    //   17: getstatic android/support/v7/a/a$j.AppCompatTheme_viewInflaterClass : I
    //   20: invokevirtual getString : (I)Ljava/lang/String;
    //   23: astore #8
    //   25: aload #8
    //   27: ifnull -> 138
    //   30: ldc_w android/support/v7/app/AppCompatViewInflater
    //   33: invokevirtual getName : ()Ljava/lang/String;
    //   36: aload #8
    //   38: invokevirtual equals : (Ljava/lang/Object;)Z
    //   41: ifeq -> 47
    //   44: goto -> 138
    //   47: aload_0
    //   48: aload #8
    //   50: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   53: iconst_0
    //   54: anewarray java/lang/Class
    //   57: invokevirtual getDeclaredConstructor : ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   60: iconst_0
    //   61: anewarray java/lang/Object
    //   64: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast android/support/v7/app/AppCompatViewInflater
    //   70: putfield T : Landroid/support/v7/app/AppCompatViewInflater;
    //   73: goto -> 153
    //   76: astore #10
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore #11
    //   87: aload #11
    //   89: ldc_w 'Failed to instantiate custom view inflater '
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload #11
    //   98: aload #8
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload #11
    //   106: ldc_w '. Falling back to default.'
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 'AppCompatDelegate'
    //   115: aload #11
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: aload #10
    //   122: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   125: pop
    //   126: new android/support/v7/app/AppCompatViewInflater
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: astore #9
    //   135: goto -> 147
    //   138: new android/support/v7/app/AppCompatViewInflater
    //   141: dup
    //   142: invokespecial <init> : ()V
    //   145: astore #9
    //   147: aload_0
    //   148: aload #9
    //   150: putfield T : Landroid/support/v7/app/AppCompatViewInflater;
    //   153: getstatic android/support/v7/app/f.u : Z
    //   156: ifeq -> 211
    //   159: aload #4
    //   161: instanceof org/xmlpull/v1/XmlPullParser
    //   164: ifeq -> 194
    //   167: aload #4
    //   169: checkcast org/xmlpull/v1/XmlPullParser
    //   172: invokeinterface getDepth : ()I
    //   177: istore #7
    //   179: iconst_0
    //   180: istore #6
    //   182: iload #7
    //   184: iconst_1
    //   185: if_icmple -> 204
    //   188: iconst_1
    //   189: istore #6
    //   191: goto -> 204
    //   194: aload_0
    //   195: aload_1
    //   196: checkcast android/view/ViewParent
    //   199: invokespecial a : (Landroid/view/ViewParent;)Z
    //   202: istore #6
    //   204: iload #6
    //   206: istore #5
    //   208: goto -> 214
    //   211: iconst_0
    //   212: istore #5
    //   214: aload_0
    //   215: getfield T : Landroid/support/v7/app/AppCompatViewInflater;
    //   218: aload_1
    //   219: aload_2
    //   220: aload_3
    //   221: aload #4
    //   223: iload #5
    //   225: getstatic android/support/v7/app/f.u : Z
    //   228: iconst_1
    //   229: invokestatic a : ()Z
    //   232: invokevirtual createView : (Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;
    //   235: areturn
    // Exception table:
    //   from	to	target	type
    //   47	73	76	java/lang/Throwable }
  
  void a(int paramInt, f paramf, Menu paramMenu) {
    h h1;
    if (paramMenu == null) {
      if (paramf == null && paramInt >= 0) {
        f[] arrayOff = this.J;
        if (paramInt < arrayOff.length)
          paramf = arrayOff[paramInt]; 
      } 
      if (paramf != null)
        h1 = paramf.j; 
    } 
    if (paramf != null && !paramf.o)
      return; 
    if (!this.r)
      this.c.onPanelClosed(paramInt, h1); 
  }
  
  public void a(Configuration paramConfiguration) {
    if (this.m && this.C) {
      a a1 = a();
      if (a1 != null)
        a1.a(paramConfiguration); 
    } 
    l.a().a(this.a);
    i();
  }
  
  public void a(Bundle paramBundle) {
    Window.Callback callback = this.c;
    if (callback instanceof Activity) {
      String str = null;
      try {
        str = v.b((Activity)callback);
      } catch (IllegalArgumentException illegalArgumentException) {}
      if (str != null) {
        a a1 = k();
        if (a1 == null) {
          this.Q = true;
        } else {
          a1.e(true);
        } 
      } 
    } 
    if (paramBundle != null && this.M == -100)
      this.M = paramBundle.getInt("appcompat:local_night_mode", -100); 
  }
  
  void a(f paramf, boolean paramBoolean) {
    if (paramBoolean && paramf.a == 0) {
      ai ai1 = this.y;
      if (ai1 != null && ai1.f()) {
        b(paramf.j);
        return;
      } 
    } 
    WindowManager windowManager = (WindowManager)this.a.getSystemService("window");
    if (windowManager != null && paramf.o && paramf.g != null) {
      windowManager.removeView(paramf.g);
      if (paramBoolean)
        a(paramf.a, paramf, null); 
    } 
    paramf.m = false;
    paramf.n = false;
    paramf.o = false;
    paramf.h = null;
    paramf.q = true;
    if (this.K == paramf)
      this.K = null; 
  }
  
  public void a(h paramh) { a(paramh, true); }
  
  public void a(Toolbar paramToolbar) {
    if (!(this.c instanceof Activity))
      return; 
    a a1 = a();
    if (!(a1 instanceof l)) {
      Window.Callback callback;
      Window window;
      this.g = null;
      if (a1 != null)
        a1.g(); 
      if (paramToolbar != null) {
        i i1 = new i(paramToolbar, ((Activity)this.c).getTitle(), this.d);
        this.f = i1;
        window = this.b;
        callback = i1.h();
      } else {
        this.f = null;
        window = this.b;
        callback = this.d;
      } 
      window.setCallback(callback);
      f();
      return;
    } 
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public void a(View paramView) {
    u();
    ViewGroup viewGroup = (ViewGroup)this.D.findViewById(16908290);
    viewGroup.removeAllViews();
    viewGroup.addView(paramView);
    this.c.onContentChanged();
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    u();
    ViewGroup viewGroup = (ViewGroup)this.D.findViewById(16908290);
    viewGroup.removeAllViews();
    viewGroup.addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  public final void a(CharSequence paramCharSequence) {
    this.x = paramCharSequence;
    ai ai1 = this.y;
    if (ai1 != null) {
      ai1.setWindowTitle(paramCharSequence);
      return;
    } 
    if (k() != null) {
      k().a(paramCharSequence);
      return;
    } 
    TextView textView = this.E;
    if (textView != null)
      textView.setText(paramCharSequence); 
  }
  
  boolean a(int paramInt, KeyEvent paramKeyEvent) {
    a a1 = a();
    if (a1 != null && a1.a(paramInt, paramKeyEvent))
      return true; 
    f f1 = this.K;
    if (f1 != null && a(f1, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)) {
      f f2 = this.K;
      if (f2 != null)
        f2.n = true; 
      return true;
    } 
    if (this.K == null) {
      f f2 = a(0, true);
      b(f2, paramKeyEvent);
      boolean bool = a(f2, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      f2.m = false;
      if (bool)
        return true; 
    } 
    return false;
  }
  
  public boolean a(h paramh, MenuItem paramMenuItem) {
    Window.Callback callback = l();
    if (callback != null && !this.r) {
      f f1 = a(paramh.q());
      if (f1 != null)
        return callback.onMenuItemSelected(f1.a, paramMenuItem); 
    } 
    return false;
  }
  
  boolean a(KeyEvent paramKeyEvent) {
    Window.Callback callback = this.c;
    boolean bool1 = callback instanceof e.a;
    boolean bool2 = true;
    if (bool1 || callback instanceof g) {
      View view = this.b.getDecorView();
      if (view != null && e.a(view, paramKeyEvent))
        return bool2; 
    } 
    if (paramKeyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(paramKeyEvent))
      return bool2; 
    int i1 = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0)
      bool2 = false; 
    return bool2 ? c(i1, paramKeyEvent) : b(i1, paramKeyEvent);
  }
  
  b b(b.a parama) {
    Object object;
    q();
    b b1 = this.h;
    if (b1 != null)
      b1.c(); 
    if (!(parama instanceof b))
      parama = new b(this, parama); 
    d d1 = this.e;
    if (d1 != null && !this.r) {
      object = d1.a(parama);
    } else {
      object = null;
    } 
    if (object != null) {
      this.h = object;
    } else {
      ActionBarContextView actionBarContextView = this.i;
      boolean bool = true;
      if (actionBarContextView == null)
        if (this.p) {
          Context context;
          TypedValue typedValue = new TypedValue();
          Resources.Theme theme = this.a.getTheme();
          theme.resolveAttribute(a.a.actionBarTheme, typedValue, bool);
          if (typedValue.resourceId != 0) {
            Resources.Theme theme1 = this.a.getResources().newTheme();
            theme1.setTo(theme);
            theme1.applyStyle(typedValue.resourceId, bool);
            context = new d(this.a, 0);
            context.getTheme().setTo(theme1);
          } else {
            context = this.a;
          } 
          this.i = new ActionBarContextView(context);
          this.j = new PopupWindow(context, null, a.a.actionModePopupWindowStyle);
          k.a(this.j, 2);
          this.j.setContentView(this.i);
          this.j.setWidth(-1);
          context.getTheme().resolveAttribute(a.a.actionBarSize, typedValue, bool);
          int i1 = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
          this.i.setContentHeight(i1);
          this.j.setHeight(-2);
          this.k = new Runnable(this) {
              public void run() {
                this.a.j.showAtLocation(this.a.i, 55, 0, 0);
                this.a.q();
                if (this.a.o()) {
                  this.a.i.setAlpha(0.0F);
                  f f1 = this.a;
                  f1.l = r.l(f1.i).a(1.0F);
                  this.a.l.a(new x(this) {
                        public void a(View param2View) { this.a.a.i.setVisibility(0); }
                        
                        public void b(View param2View) {
                          this.a.a.i.setAlpha(1.0F);
                          this.a.a.l.a(null);
                          this.a.a.l = null;
                        }
                      });
                  return;
                } 
                this.a.i.setAlpha(1.0F);
                this.a.i.setVisibility(0);
              }
            };
        } else {
          ViewStubCompat viewStubCompat = (ViewStubCompat)this.D.findViewById(a.f.action_mode_bar_stub);
          if (viewStubCompat != null) {
            viewStubCompat.setLayoutInflater(LayoutInflater.from(m()));
            this.i = (ActionBarContextView)viewStubCompat.a();
          } 
        }  
      if (this.i != null) {
        q();
        this.i.c();
        Context context = this.i.getContext();
        ActionBarContextView actionBarContextView1 = this.i;
        if (this.j != null)
          bool = false; 
        e e1 = new e(context, actionBarContextView1, parama, bool);
        if (parama.a(e1, e1.b())) {
          e1.d();
          this.i.a(e1);
          this.h = e1;
          if (o()) {
            this.i.setAlpha(0.0F);
            this.l = r.l(this.i).a(1.0F);
            this.l.a(new x(this) {
                  public void a(View param1View) {
                    this.a.i.setVisibility(0);
                    this.a.i.sendAccessibilityEvent(32);
                    if (this.a.i.getParent() instanceof View)
                      r.p((View)this.a.i.getParent()); 
                  }
                  
                  public void b(View param1View) {
                    this.a.i.setAlpha(1.0F);
                    this.a.l.a(null);
                    this.a.l = null;
                  }
                });
          } else {
            this.i.setAlpha(1.0F);
            this.i.setVisibility(0);
            this.i.sendAccessibilityEvent(32);
            if (this.i.getParent() instanceof View)
              r.p((View)this.i.getParent()); 
          } 
          if (this.j != null)
            this.b.getDecorView().post(this.k); 
        } else {
          this.h = null;
        } 
      } 
    } 
    b b2 = this.h;
    if (b2 != null) {
      d d2 = this.e;
      if (d2 != null)
        d2.a(b2); 
    } 
    return this.h;
  }
  
  public MenuInflater b() {
    if (this.g == null) {
      Context context;
      t();
      a a1 = this.f;
      if (a1 != null) {
        context = a1.b();
      } else {
        context = this.a;
      } 
      this.g = new g(context);
    } 
    return this.g;
  }
  
  public void b(int paramInt) {
    u();
    ViewGroup viewGroup = (ViewGroup)this.D.findViewById(16908290);
    viewGroup.removeAllViews();
    LayoutInflater.from(this.a).inflate(paramInt, viewGroup);
    this.c.onContentChanged();
  }
  
  public void b(Bundle paramBundle) { u(); }
  
  void b(h paramh) {
    if (this.I)
      return; 
    this.I = true;
    this.y.k();
    Window.Callback callback = l();
    if (callback != null && !this.r)
      callback.onPanelClosed(108, paramh); 
    this.I = false;
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    u();
    ((ViewGroup)this.D.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  boolean b(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt != 4) {
      if (paramInt != 82)
        return false; 
      e(0, paramKeyEvent);
      return true;
    } 
    boolean bool = this.L;
    this.L = false;
    f f1 = a(0, false);
    if (f1 != null && f1.o) {
      if (!bool)
        a(f1, true); 
      return true;
    } 
    return r();
  }
  
  public void c() { i(); }
  
  public void c(Bundle paramBundle) {
    int i1 = this.M;
    if (i1 != -100)
      paramBundle.putInt("appcompat:local_night_mode", i1); 
  }
  
  public boolean c(int paramInt) {
    int i1 = k(paramInt);
    if (this.q && i1 == 108)
      return false; 
    if (this.m && i1 == 1)
      this.m = false; 
    switch (i1) {
      default:
        return this.b.requestFeature(i1);
      case 109:
        x();
        this.n = true;
        return true;
      case 108:
        x();
        this.m = true;
        return true;
      case 10:
        x();
        this.o = true;
        return true;
      case 5:
        x();
        this.H = true;
        return true;
      case 2:
        x();
        this.G = true;
        return true;
      case 1:
        break;
    } 
    x();
    this.q = true;
    return true;
  }
  
  boolean c(int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = true;
    if (paramInt != 4) {
      if (paramInt != 82)
        return false; 
      d(0, paramKeyEvent);
      return bool;
    } 
    if ((0x80 & paramKeyEvent.getFlags()) == 0)
      bool = false; 
    this.L = bool;
    return false;
  }
  
  public void d() {
    a a1 = a();
    if (a1 != null)
      a1.f(false); 
    d d1 = this.O;
    if (d1 != null)
      d1.d(); 
  }
  
  void d(int paramInt) {
    if (paramInt == 108) {
      a a1 = a();
      if (a1 != null) {
        a1.g(false);
        return;
      } 
    } else if (paramInt == 0) {
      f f1 = a(paramInt, true);
      if (f1.o)
        a(f1, false); 
    } 
  }
  
  public void e() {
    a a1 = a();
    if (a1 != null)
      a1.f(true); 
  }
  
  void e(int paramInt) {
    if (paramInt == 108) {
      a a1 = a();
      if (a1 != null)
        a1.g(true); 
    } 
  }
  
  public void f() {
    a a1 = a();
    if (a1 != null && a1.e())
      return; 
    j(0);
  }
  
  void f(int paramInt) { a(a(paramInt, true), true); }
  
  public void g() {
    if (this.s)
      this.b.getDecorView().removeCallbacks(this.P); 
    this.r = true;
    a a1 = this.f;
    if (a1 != null)
      a1.g(); 
    d d1 = this.O;
    if (d1 != null)
      d1.d(); 
  }
  
  void g(int paramInt) {
    f f1 = a(paramInt, true);
    if (f1.j != null) {
      Bundle bundle = new Bundle();
      f1.j.a(bundle);
      if (bundle.size() > 0)
        f1.s = bundle; 
      f1.j.h();
      f1.j.clear();
    } 
    f1.r = true;
    f1.q = true;
    if ((paramInt == 108 || paramInt == 0) && this.y != null) {
      f f2 = a(0, false);
      if (f2 != null) {
        f2.m = false;
        b(f2, null);
      } 
    } 
  }
  
  int h(int paramInt) {
    boolean bool;
    ActionBarContextView actionBarContextView = this.i;
    if (actionBarContextView != null && actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
      boolean bool2;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
      boolean bool1 = this.i.isShown();
      bool = true;
      if (bool1) {
        boolean bool3;
        if (this.R == null) {
          this.R = new Rect();
          this.S = new Rect();
        } 
        Rect rect1 = this.R;
        Rect rect2 = this.S;
        rect1.set(0, paramInt, 0, 0);
        bu.a(this.D, rect1, rect2);
        if (rect2.top == 0) {
          bool3 = paramInt;
        } else {
          bool3 = false;
        } 
        if (marginLayoutParams.topMargin != bool3) {
          marginLayoutParams.topMargin = paramInt;
          View view1 = this.F;
          if (view1 == null) {
            this.F = new View(this.a);
            this.F.setBackgroundColor(this.a.getResources().getColor(a.c.abc_input_method_navigation_guard));
            this.D.addView(this.F, -1, new ViewGroup.LayoutParams(-1, paramInt));
          } else {
            ViewGroup.LayoutParams layoutParams = view1.getLayoutParams();
            if (layoutParams.height != paramInt) {
              layoutParams.height = paramInt;
              this.F.setLayoutParams(layoutParams);
            } 
          } 
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (this.F == null)
          bool = false; 
        if (!this.o && bool)
          paramInt = 0; 
      } else {
        if (marginLayoutParams.topMargin != 0) {
          marginLayoutParams.topMargin = 0;
          bool2 = true;
        } else {
          bool2 = false;
        } 
        bool = false;
      } 
      if (bool2)
        this.i.setLayoutParams(marginLayoutParams); 
    } else {
      bool = false;
    } 
    View view = this.F;
    if (view != null) {
      byte b1;
      if (bool) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      view.setVisibility(b1);
    } 
    return paramInt;
  }
  
  public void h() {
    LayoutInflater layoutInflater = LayoutInflater.from(this.a);
    if (layoutInflater.getFactory() == null) {
      f.a(layoutInflater, this);
      return;
    } 
    if (!(layoutInflater.getFactory2() instanceof f))
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's"); 
  }
  
  int i(int paramInt) {
    if (paramInt != -100) {
      if (paramInt != 0)
        return paramInt; 
      if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager)this.a.getSystemService(UiModeManager.class)).getNightMode() == 0)
        return -1; 
      z();
      return this.O.a();
    } 
    return -1;
  }
  
  public boolean i() {
    boolean bool;
    int i1 = y();
    int i2 = i(i1);
    if (i2 != -1) {
      bool = l(i2);
    } else {
      bool = false;
    } 
    if (i1 == 0) {
      z();
      this.O.c();
    } 
    this.N = true;
    return bool;
  }
  
  final a k() { return this.f; }
  
  final Window.Callback l() { return this.b.getCallback(); }
  
  final Context m() {
    Context context;
    a a1 = a();
    if (a1 != null) {
      context = a1.b();
    } else {
      context = null;
    } 
    if (context == null)
      context = this.a; 
    return context;
  }
  
  final CharSequence n() {
    Window.Callback callback = this.c;
    return (callback instanceof Activity) ? ((Activity)callback).getTitle() : this.x;
  }
  
  final boolean o() {
    if (this.C) {
      ViewGroup viewGroup = this.D;
      if (viewGroup != null && r.x(viewGroup))
        return true; 
    } 
    return false;
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) { return a(paramView, paramString, paramContext, paramAttributeSet); }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) { return onCreateView(null, paramString, paramContext, paramAttributeSet); }
  
  public boolean p() { return this.B; }
  
  void q() {
    v v1 = this.l;
    if (v1 != null)
      v1.b(); 
  }
  
  boolean r() {
    b b1 = this.h;
    if (b1 != null) {
      b1.c();
      return true;
    } 
    a a1 = a();
    return (a1 != null && a1.f());
  }
  
  void s() { // Byte code:
    //   0: aload_0
    //   1: getfield y : Landroid/support/v7/widget/ai;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull -> 15
    //   9: aload_1
    //   10: invokeinterface k : ()V
    //   15: aload_0
    //   16: getfield j : Landroid/widget/PopupWindow;
    //   19: ifnull -> 63
    //   22: aload_0
    //   23: getfield b : Landroid/view/Window;
    //   26: invokevirtual getDecorView : ()Landroid/view/View;
    //   29: aload_0
    //   30: getfield k : Ljava/lang/Runnable;
    //   33: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)Z
    //   36: pop
    //   37: aload_0
    //   38: getfield j : Landroid/widget/PopupWindow;
    //   41: invokevirtual isShowing : ()Z
    //   44: ifeq -> 57
    //   47: aload_0
    //   48: getfield j : Landroid/widget/PopupWindow;
    //   51: invokevirtual dismiss : ()V
    //   54: goto -> 58
    //   57: pop
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield j : Landroid/widget/PopupWindow;
    //   63: aload_0
    //   64: invokevirtual q : ()V
    //   67: aload_0
    //   68: iconst_0
    //   69: iconst_0
    //   70: invokevirtual a : (IZ)Landroid/support/v7/app/f$f;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull -> 92
    //   78: aload_2
    //   79: getfield j : Landroid/support/v7/view/menu/h;
    //   82: ifnull -> 92
    //   85: aload_2
    //   86: getfield j : Landroid/support/v7/view/menu/h;
    //   89: invokevirtual close : ()V
    //   92: return
    // Exception table:
    //   from	to	target	type
    //   47	54	57	java/lang/IllegalArgumentException }
  
  private final class a implements o.a {
    a(f this$0) {}
    
    public void a(h param1h, boolean param1Boolean) { this.a.b(param1h); }
    
    public boolean a(h param1h) {
      Window.Callback callback = this.a.l();
      if (callback != null)
        callback.onMenuOpened(108, param1h); 
      return true;
    }
  }
  
  class b implements b.a {
    private b.a b;
    
    public b(f this$0, b.a param1a) { this.b = param1a; }
    
    public void a(b param1b) {
      this.b.a(param1b);
      if (this.a.j != null)
        this.a.b.getDecorView().removeCallbacks(this.a.k); 
      if (this.a.i != null) {
        this.a.q();
        f f1 = this.a;
        f1.l = r.l(f1.i).a(0.0F);
        this.a.l.a(new x(this) {
              public void b(View param2View) {
                this.a.a.i.setVisibility(8);
                if (this.a.a.j != null) {
                  this.a.a.j.dismiss();
                } else if (this.a.a.i.getParent() instanceof View) {
                  r.p((View)this.a.a.i.getParent());
                } 
                this.a.a.i.removeAllViews();
                this.a.a.l.a(null);
                this.a.a.l = null;
              }
            });
      } 
      if (this.a.e != null)
        this.a.e.b(this.a.h); 
      this.a.h = null;
    }
    
    public boolean a(b param1b, Menu param1Menu) { return this.b.a(param1b, param1Menu); }
    
    public boolean a(b param1b, MenuItem param1MenuItem) { return this.b.a(param1b, param1MenuItem); }
    
    public boolean b(b param1b, Menu param1Menu) { return this.b.b(param1b, param1Menu); }
  }
  
  class null extends x {
    null(f this$0) {}
    
    public void b(View param1View) {
      this.a.a.i.setVisibility(8);
      if (this.a.a.j != null) {
        this.a.a.j.dismiss();
      } else if (this.a.a.i.getParent() instanceof View) {
        r.p((View)this.a.a.i.getParent());
      } 
      this.a.a.i.removeAllViews();
      this.a.a.l.a(null);
      this.a.a.l = null;
    }
  }
  
  class c extends i {
    c(f this$0, Window.Callback param1Callback) { super(param1Callback); }
    
    final ActionMode a(ActionMode.Callback param1Callback) {
      f.a a1 = new f.a(this.a.a, param1Callback);
      b b = this.a.a(a1);
      return (b != null) ? a1.b(b) : null;
    }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) { return (this.a.a(param1KeyEvent) || super.dispatchKeyEvent(param1KeyEvent)); }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent param1KeyEvent) { return (super.dispatchKeyShortcutEvent(param1KeyEvent) || this.a.a(param1KeyEvent.getKeyCode(), param1KeyEvent)); }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int param1Int, Menu param1Menu) { return (param1Int == 0 && !(param1Menu instanceof h)) ? false : super.onCreatePanelMenu(param1Int, param1Menu); }
    
    public boolean onMenuOpened(int param1Int, Menu param1Menu) {
      super.onMenuOpened(param1Int, param1Menu);
      this.a.e(param1Int);
      return true;
    }
    
    public void onPanelClosed(int param1Int, Menu param1Menu) {
      super.onPanelClosed(param1Int, param1Menu);
      this.a.d(param1Int);
    }
    
    public boolean onPreparePanel(int param1Int, View param1View, Menu param1Menu) {
      Object object;
      if (param1Menu instanceof h) {
        object = (h)param1Menu;
      } else {
        object = null;
      } 
      if (param1Int == 0 && object == null)
        return false; 
      if (object != null)
        object.c(true); 
      boolean bool = super.onPreparePanel(param1Int, param1View, param1Menu);
      if (object != null)
        object.c(false); 
      return bool;
    }
    
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> param1List, Menu param1Menu, int param1Int) {
      h h;
      f.f f1 = this.a.a(0, true);
      if (f1 != null && f1.j != null)
        h = f1.j; 
      super.onProvideKeyboardShortcuts(param1List, h, param1Int);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback) { return (Build.VERSION.SDK_INT >= 23) ? null : (this.a.p() ? a(param1Callback) : super.onWindowStartingActionMode(param1Callback)); }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback param1Callback, int param1Int) { return (!this.a.p() || param1Int != 0) ? super.onWindowStartingActionMode(param1Callback, param1Int) : a(param1Callback); }
  }
  
  final class d {
    private k b;
    
    private boolean c;
    
    private BroadcastReceiver d;
    
    private IntentFilter e;
    
    d(f this$0, k param1k) {
      this.b = param1k;
      this.c = param1k.a();
    }
    
    int a() {
      this.c = this.b.a();
      return this.c ? 2 : 1;
    }
    
    void b() {
      boolean bool = this.b.a();
      if (bool != this.c) {
        this.c = bool;
        this.a.i();
      } 
    }
    
    void c() {
      d();
      if (this.d == null)
        this.d = new BroadcastReceiver(this) {
            public void onReceive(Context param2Context, Intent param2Intent) { this.a.b(); }
          }; 
      if (this.e == null) {
        this.e = new IntentFilter();
        this.e.addAction("android.intent.action.TIME_SET");
        this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.e.addAction("android.intent.action.TIME_TICK");
      } 
      this.a.a.registerReceiver(this.d, this.e);
    }
    
    void d() {
      if (this.d != null) {
        this.a.a.unregisterReceiver(this.d);
        this.d = null;
      } 
    }
  }
  
  class null extends BroadcastReceiver {
    null(f this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) { this.a.b(); }
  }
  
  private class e extends ContentFrameLayout {
    public e(f this$0, Context param1Context) { super(param1Context); }
    
    private boolean a(int param1Int1, int param1Int2) { return (param1Int1 < -5 || param1Int2 < -5 || param1Int1 > 5 + getWidth() || param1Int2 > 5 + getHeight()); }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) { return (this.a.a(param1KeyEvent) || super.dispatchKeyEvent(param1KeyEvent)); }
    
    public boolean onInterceptTouchEvent(MotionEvent param1MotionEvent) {
      if (param1MotionEvent.getAction() == 0 && a((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY())) {
        this.a.f(0);
        return true;
      } 
      return super.onInterceptTouchEvent(param1MotionEvent);
    }
    
    public void setBackgroundResource(int param1Int) { setBackgroundDrawable(a.b(getContext(), param1Int)); }
  }
  
  protected static final class f {
    int a;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    ViewGroup g;
    
    View h;
    
    View i;
    
    h j;
    
    f k;
    
    Context l;
    
    boolean m;
    
    boolean n;
    
    boolean o;
    
    public boolean p;
    
    boolean q;
    
    boolean r;
    
    Bundle s;
    
    f(int param1Int) {
      this.a = param1Int;
      this.q = false;
    }
    
    p a(o.a param1a) {
      if (this.j == null)
        return null; 
      if (this.k == null) {
        this.k = new f(this.l, a.g.abc_list_menu_item_layout);
        this.k.a(param1a);
        this.j.a(this.k);
      } 
      return this.k.a(this.g);
    }
    
    void a(Context param1Context) {
      int i1;
      TypedValue typedValue = new TypedValue();
      Resources.Theme theme = param1Context.getResources().newTheme();
      theme.setTo(param1Context.getTheme());
      theme.resolveAttribute(a.a.actionBarPopupTheme, typedValue, true);
      if (typedValue.resourceId != 0)
        theme.applyStyle(typedValue.resourceId, true); 
      theme.resolveAttribute(a.a.panelMenuListTheme, typedValue, true);
      if (typedValue.resourceId != 0) {
        i1 = typedValue.resourceId;
      } else {
        i1 = a.i.Theme_AppCompat_CompactMenu;
      } 
      theme.applyStyle(i1, true);
      d d1 = new d(param1Context, 0);
      d1.getTheme().setTo(theme);
      this.l = d1;
      TypedArray typedArray = d1.obtainStyledAttributes(a.j.AppCompatTheme);
      this.b = typedArray.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
      this.f = typedArray.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
      typedArray.recycle();
    }
    
    void a(h param1h) {
      h h1 = this.j;
      if (param1h == h1)
        return; 
      if (h1 != null)
        h1.b(this.k); 
      this.j = param1h;
      if (param1h != null) {
        f f1 = this.k;
        if (f1 != null)
          param1h.a(f1); 
      } 
    }
    
    public boolean a() {
      if (this.h == null)
        return false; 
      if (this.i != null)
        return true; 
      int i1 = this.k.a().getCount();
      boolean bool = false;
      if (i1 > 0)
        bool = true; 
      return bool;
    }
  }
  
  private final class g implements o.a {
    g(f this$0) {}
    
    public void a(h param1h, boolean param1Boolean) {
      boolean bool;
      h h1 = param1h.q();
      if (h1 != param1h) {
        bool = true;
      } else {
        bool = false;
      } 
      f f1 = this.a;
      if (bool)
        param1h = h1; 
      f.f f2 = f1.a(param1h);
      if (f2 != null) {
        if (bool) {
          this.a.a(f2.a, f2, h1);
          this.a.a(f2, true);
          return;
        } 
        this.a.a(f2, param1Boolean);
      } 
    }
    
    public boolean a(h param1h) {
      if (param1h == null && this.a.m) {
        Window.Callback callback = this.a.l();
        if (callback != null && !this.a.r)
          callback.onMenuOpened(108, param1h); 
      } 
      return true;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */