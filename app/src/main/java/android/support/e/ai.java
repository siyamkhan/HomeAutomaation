package android.support.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class ai extends m {
  private static final String[] h = { "android:visibility:visibility", "android:visibility:parent" };
  
  private int i = 3;
  
  private b b(s params1, s params2) {
    b b = new b();
    b.a = false;
    b.b = false;
    ViewGroup viewGroup = null;
    if (params1 != null && params1.a.containsKey("android:visibility:visibility")) {
      b.c = ((Integer)params1.a.get("android:visibility:visibility")).intValue();
      b.e = (ViewGroup)params1.a.get("android:visibility:parent");
    } else {
      b.c = -1;
      b.e = null;
    } 
    if (params2 != null && params2.a.containsKey("android:visibility:visibility")) {
      b.d = ((Integer)params2.a.get("android:visibility:visibility")).intValue();
      viewGroup = (ViewGroup)params2.a.get("android:visibility:parent");
    } else {
      b.d = -1;
    } 
    b.f = viewGroup;
    if (params1 != null && params2 != null) {
      if (b.c == b.d && b.e == b.f)
        return b; 
      if (b.c != b.d) {
        if (b.c == 0) {
          b.b = false;
          b.a = true;
          return b;
        } 
        if (b.d == 0) {
          b.b = true;
          b.a = true;
          return b;
        } 
      } else {
        if (b.f == null) {
          b.b = false;
          b.a = true;
          return b;
        } 
        if (b.e == null) {
          b.b = true;
          b.a = true;
          return b;
        } 
      } 
    } else {
      if (params1 == null && b.d == 0) {
        b.b = true;
        b.a = true;
        return b;
      } 
      if (params2 == null && b.c == 0) {
        b.b = false;
        b.a = true;
        return b;
      } 
    } 
    return b;
  }
  
  private void d(s params) {
    int j = params.b.getVisibility();
    params.a.put("android:visibility:visibility", Integer.valueOf(j));
    params.a.put("android:visibility:parent", params.b.getParent());
    int[] arrayOfInt = new int[2];
    params.b.getLocationOnScreen(arrayOfInt);
    params.a.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public Animator a(ViewGroup paramViewGroup, s params1, int paramInt1, s params2, int paramInt2) {
    if ((true & this.i) == 1) {
      if (params2 == null)
        return null; 
      if (params1 == null) {
        View view = (View)params2.b.getParent();
        if ((b(b(view, false), a(view, false))).a)
          return null; 
      } 
      return a(paramViewGroup, params2.b, params1, params2);
    } 
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, s params1, s params2) {
    b b = b(params1, params2);
    return (b.a && (b.e != null || b.f != null)) ? (b.b ? a(paramViewGroup, params1, b.c, params2, b.d) : b(paramViewGroup, params1, b.c, params2, b.d)) : null;
  }
  
  public Animator a(ViewGroup paramViewGroup, View paramView, s params1, s params2) { return null; }
  
  public void a(int paramInt) {
    if ((paramInt & 0xFFFFFFFC) == 0) {
      this.i = paramInt;
      return;
    } 
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
  
  public void a(s params) { d(params); }
  
  public boolean a(s params1, s params2) {
    if (params1 == null && params2 == null)
      return false; 
    if (params1 != null && params2 != null && params2.a.containsKey("android:visibility:visibility") != params1.a.containsKey("android:visibility:visibility"))
      return false; 
    b b = b(params1, params2);
    boolean bool = b.a;
    null = false;
    if (bool) {
      if (b.c != 0) {
        int j = b.d;
        null = false;
        return (j == 0) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public String[] a() { return h; }
  
  public Animator b(ViewGroup paramViewGroup, s params1, int paramInt1, s params2, int paramInt2) { // Byte code:
    //   0: iconst_2
    //   1: aload_0
    //   2: getfield i : I
    //   5: iand
    //   6: iconst_2
    //   7: if_icmpeq -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_2
    //   13: ifnull -> 25
    //   16: aload_2
    //   17: getfield b : Landroid/view/View;
    //   20: astore #6
    //   22: goto -> 28
    //   25: aconst_null
    //   26: astore #6
    //   28: aload #4
    //   30: ifnull -> 43
    //   33: aload #4
    //   35: getfield b : Landroid/view/View;
    //   38: astore #7
    //   40: goto -> 46
    //   43: aconst_null
    //   44: astore #7
    //   46: aload #7
    //   48: ifnull -> 117
    //   51: aload #7
    //   53: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   56: ifnonnull -> 62
    //   59: goto -> 117
    //   62: iload #5
    //   64: iconst_4
    //   65: if_icmpne -> 71
    //   68: goto -> 78
    //   71: aload #6
    //   73: aload #7
    //   75: if_acmpne -> 84
    //   78: aconst_null
    //   79: astore #6
    //   81: goto -> 248
    //   84: aload_0
    //   85: getfield e : Z
    //   88: ifeq -> 94
    //   91: goto -> 145
    //   94: aload #6
    //   96: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   99: checkcast android/view/View
    //   102: astore #18
    //   104: aload_1
    //   105: aload #6
    //   107: aload #18
    //   109: invokestatic a : (Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/View;)Landroid/view/View;
    //   112: astore #6
    //   114: goto -> 126
    //   117: aload #7
    //   119: ifnull -> 132
    //   122: aload #7
    //   124: astore #6
    //   126: aconst_null
    //   127: astore #7
    //   129: goto -> 248
    //   132: aload #6
    //   134: ifnull -> 242
    //   137: aload #6
    //   139: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   142: ifnonnull -> 148
    //   145: goto -> 126
    //   148: aload #6
    //   150: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   153: instanceof android/view/View
    //   156: ifeq -> 242
    //   159: aload #6
    //   161: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   164: checkcast android/view/View
    //   167: astore #18
    //   169: aload_0
    //   170: aload_0
    //   171: aload #18
    //   173: iconst_1
    //   174: invokevirtual a : (Landroid/view/View;Z)Landroid/support/e/s;
    //   177: aload_0
    //   178: aload #18
    //   180: iconst_1
    //   181: invokevirtual b : (Landroid/view/View;Z)Landroid/support/e/s;
    //   184: invokespecial b : (Landroid/support/e/s;Landroid/support/e/s;)Landroid/support/e/ai$b;
    //   187: getfield a : Z
    //   190: ifne -> 196
    //   193: goto -> 104
    //   196: aload #18
    //   198: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   201: ifnonnull -> 236
    //   204: aload #18
    //   206: invokevirtual getId : ()I
    //   209: istore #19
    //   211: iload #19
    //   213: iconst_m1
    //   214: if_icmpeq -> 236
    //   217: aload_1
    //   218: iload #19
    //   220: invokevirtual findViewById : (I)Landroid/view/View;
    //   223: ifnull -> 236
    //   226: aload_0
    //   227: getfield e : Z
    //   230: ifeq -> 236
    //   233: goto -> 126
    //   236: aconst_null
    //   237: astore #6
    //   239: goto -> 126
    //   242: aconst_null
    //   243: astore #6
    //   245: aconst_null
    //   246: astore #7
    //   248: aload #6
    //   250: ifnull -> 396
    //   253: aload_2
    //   254: ifnull -> 396
    //   257: aload_2
    //   258: getfield a : Ljava/util/Map;
    //   261: ldc 'android:visibility:screenLocation'
    //   263: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   268: checkcast [I
    //   271: astore #12
    //   273: aload #12
    //   275: iconst_0
    //   276: iaload
    //   277: istore #13
    //   279: aload #12
    //   281: iconst_1
    //   282: iaload
    //   283: istore #14
    //   285: iconst_2
    //   286: newarray int
    //   288: astore #15
    //   290: aload_1
    //   291: aload #15
    //   293: invokevirtual getLocationOnScreen : ([I)V
    //   296: aload #6
    //   298: iload #13
    //   300: aload #15
    //   302: iconst_0
    //   303: iaload
    //   304: isub
    //   305: aload #6
    //   307: invokevirtual getLeft : ()I
    //   310: isub
    //   311: invokevirtual offsetLeftAndRight : (I)V
    //   314: aload #6
    //   316: iload #14
    //   318: aload #15
    //   320: iconst_1
    //   321: iaload
    //   322: isub
    //   323: aload #6
    //   325: invokevirtual getTop : ()I
    //   328: isub
    //   329: invokevirtual offsetTopAndBottom : (I)V
    //   332: aload_1
    //   333: invokestatic a : (Landroid/view/ViewGroup;)Landroid/support/e/w;
    //   336: astore #16
    //   338: aload #16
    //   340: aload #6
    //   342: invokeinterface a : (Landroid/view/View;)V
    //   347: aload_0
    //   348: aload_1
    //   349: aload #6
    //   351: aload_2
    //   352: aload #4
    //   354: invokevirtual b : (Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/e/s;Landroid/support/e/s;)Landroid/animation/Animator;
    //   357: astore #17
    //   359: aload #17
    //   361: ifnonnull -> 376
    //   364: aload #16
    //   366: aload #6
    //   368: invokeinterface b : (Landroid/view/View;)V
    //   373: aload #17
    //   375: areturn
    //   376: aload #17
    //   378: new android/support/e/ai$1
    //   381: dup
    //   382: aload_0
    //   383: aload #16
    //   385: aload #6
    //   387: invokespecial <init> : (Landroid/support/e/ai;Landroid/support/e/w;Landroid/view/View;)V
    //   390: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   393: aload #17
    //   395: areturn
    //   396: aload #7
    //   398: ifnull -> 479
    //   401: aload #7
    //   403: invokevirtual getVisibility : ()I
    //   406: istore #8
    //   408: aload #7
    //   410: iconst_0
    //   411: invokestatic a : (Landroid/view/View;I)V
    //   414: aload_0
    //   415: aload_1
    //   416: aload #7
    //   418: aload_2
    //   419: aload #4
    //   421: invokevirtual b : (Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/e/s;Landroid/support/e/s;)Landroid/animation/Animator;
    //   424: astore #9
    //   426: aload #9
    //   428: ifnull -> 469
    //   431: new android/support/e/ai$a
    //   434: dup
    //   435: aload #7
    //   437: iload #5
    //   439: iconst_1
    //   440: invokespecial <init> : (Landroid/view/View;IZ)V
    //   443: astore #10
    //   445: aload #9
    //   447: aload #10
    //   449: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   452: aload #9
    //   454: aload #10
    //   456: invokestatic a : (Landroid/animation/Animator;Landroid/animation/AnimatorListenerAdapter;)V
    //   459: aload_0
    //   460: aload #10
    //   462: invokevirtual a : (Landroid/support/e/m$c;)Landroid/support/e/m;
    //   465: pop
    //   466: aload #9
    //   468: areturn
    //   469: aload #7
    //   471: iload #8
    //   473: invokestatic a : (Landroid/view/View;I)V
    //   476: aload #9
    //   478: areturn
    //   479: aconst_null
    //   480: areturn }
  
  public Animator b(ViewGroup paramViewGroup, View paramView, s params1, s params2) { return null; }
  
  public void b(s params) { d(params); }
  
  private static class a extends AnimatorListenerAdapter implements a.a, m.c {
    boolean a = false;
    
    private final View b;
    
    private final int c;
    
    private final ViewGroup d;
    
    private final boolean e;
    
    private boolean f;
    
    a(View param1View, int param1Int, boolean param1Boolean) {
      this.b = param1View;
      this.c = param1Int;
      this.d = (ViewGroup)param1View.getParent();
      this.e = param1Boolean;
      a(true);
    }
    
    private void a() {
      if (!this.a) {
        ad.a(this.b, this.c);
        ViewGroup viewGroup = this.d;
        if (viewGroup != null)
          viewGroup.invalidate(); 
      } 
      a(false);
    }
    
    private void a(boolean param1Boolean) {
      if (this.e && this.f != param1Boolean) {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
          this.f = param1Boolean;
          x.a(viewGroup, param1Boolean);
        } 
      } 
    }
    
    public void a(m param1m) {
      a();
      param1m.b(this);
    }
    
    public void b(m param1m) { a(false); }
    
    public void c(m param1m) { a(true); }
    
    public void d(m param1m) {}
    
    public void onAnimationCancel(Animator param1Animator) { this.a = true; }
    
    public void onAnimationEnd(Animator param1Animator) { a(); }
    
    public void onAnimationPause(Animator param1Animator) {
      if (!this.a)
        ad.a(this.b, this.c); 
    }
    
    public void onAnimationRepeat(Animator param1Animator) {}
    
    public void onAnimationResume(Animator param1Animator) {
      if (!this.a)
        ad.a(this.b, 0); 
    }
    
    public void onAnimationStart(Animator param1Animator) {}
  }
  
  private static class b {
    boolean a;
    
    boolean b;
    
    int c;
    
    int d;
    
    ViewGroup e;
    
    ViewGroup f;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */