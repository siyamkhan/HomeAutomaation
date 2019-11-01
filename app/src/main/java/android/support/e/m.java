package android.support.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.support.v4.g.a;
import android.support.v4.g.f;
import android.support.v4.h.r;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class m implements Cloneable {
  private static ThreadLocal<a<Animator, a>> A;
  
  private static final int[] h = { 2, 1, 3, 4 };
  
  private static final g i = new g() {
      public Path a(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        Path path = new Path();
        path.moveTo(param1Float1, param1Float2);
        path.lineTo(param1Float3, param1Float4);
        return path;
      }
    };
  
  private ViewGroup B = null;
  
  private int C = 0;
  
  private boolean D = false;
  
  private boolean E = false;
  
  private ArrayList<c> F = null;
  
  private ArrayList<Animator> G = new ArrayList();
  
  private b H;
  
  private a<String, String> I;
  
  private g J = i;
  
  long a = -1L;
  
  ArrayList<Integer> b = new ArrayList();
  
  ArrayList<View> c = new ArrayList();
  
  q d = null;
  
  boolean e = false;
  
  ArrayList<Animator> f = new ArrayList();
  
  p g;
  
  private String j = getClass().getName();
  
  private long k = -1L;
  
  private TimeInterpolator l = null;
  
  private ArrayList<String> m = null;
  
  private ArrayList<Class> n = null;
  
  private ArrayList<Integer> o = null;
  
  private ArrayList<View> p = null;
  
  private ArrayList<Class> q = null;
  
  private ArrayList<String> r = null;
  
  private ArrayList<Integer> s = null;
  
  private ArrayList<View> t = null;
  
  private ArrayList<Class> u = null;
  
  private t v = new t();
  
  private t w = new t();
  
  private int[] x = h;
  
  private ArrayList<s> y;
  
  private ArrayList<s> z;
  
  static  {
    A = new ThreadLocal();
  }
  
  private void a(Animator paramAnimator, a<Animator, a> parama) {
    if (paramAnimator != null) {
      paramAnimator.addListener(new AnimatorListenerAdapter(this, parama) {
            public void onAnimationEnd(Animator param1Animator) {
              this.a.remove(param1Animator);
              this.b.f.remove(param1Animator);
            }
            
            public void onAnimationStart(Animator param1Animator) { this.b.f.add(param1Animator); }
          });
      a(paramAnimator);
    } 
  }
  
  private void a(t paramt1, t paramt2) {
    a a1 = new a(paramt1.a);
    a a2 = new a(paramt2.a);
    byte b1 = 0;
    while (true) {
      int[] arrayOfInt = this.x;
      if (b1 < arrayOfInt.length) {
        switch (arrayOfInt[b1]) {
          case 4:
            a(a1, a2, paramt1.c, paramt2.c);
            break;
          case 3:
            a(a1, a2, paramt1.b, paramt2.b);
            break;
          case 2:
            a(a1, a2, paramt1.d, paramt2.d);
            break;
          case 1:
            a(a1, a2);
            break;
        } 
        b1++;
        continue;
      } 
      break;
    } 
    b(a1, a2);
  }
  
  private static void a(t paramt, View paramView, s params) {
    paramt.a.put(paramView, params);
    int i1 = paramView.getId();
    if (i1 >= 0)
      if (paramt.b.indexOfKey(i1) >= 0) {
        paramt.b.put(i1, null);
      } else {
        paramt.b.put(i1, paramView);
      }  
    String str = r.n(paramView);
    if (str != null)
      if (paramt.d.containsKey(str)) {
        paramt.d.put(str, null);
      } else {
        paramt.d.put(str, paramView);
      }  
    if (paramView.getParent() instanceof ListView) {
      ListView listView = (ListView)paramView.getParent();
      if (listView.getAdapter().hasStableIds()) {
        long l1 = listView.getItemIdAtPosition(listView.getPositionForView(paramView));
        if (paramt.c.c(l1) >= 0) {
          View view = (View)paramt.c.a(l1);
          if (view != null) {
            r.a(view, false);
            paramt.c.b(l1, null);
            return;
          } 
        } else {
          r.a(paramView, true);
          paramt.c.b(l1, paramView);
        } 
      } 
    } 
  }
  
  private void a(a<View, s> parama1, a<View, s> parama2) {
    for (int i1 = -1 + parama1.size(); i1 >= 0; i1--) {
      View view = (View)parama1.b(i1);
      if (view != null && a(view)) {
        s s1 = (s)parama2.remove(view);
        if (s1 != null && s1.b != null && a(s1.b)) {
          s s2 = (s)parama1.d(i1);
          this.y.add(s2);
          this.z.add(s1);
        } 
      } 
    } 
  }
  
  private void a(a<View, s> parama1, a<View, s> parama2, a<String, View> parama3, a<String, View> parama4) {
    int i1 = parama3.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = (View)parama3.c(b1);
      if (view != null && a(view)) {
        View view1 = (View)parama4.get(parama3.b(b1));
        if (view1 != null && a(view1)) {
          s s1 = (s)parama1.get(view);
          s s2 = (s)parama2.get(view1);
          if (s1 != null && s2 != null) {
            this.y.add(s1);
            this.z.add(s2);
            parama1.remove(view);
            parama2.remove(view1);
          } 
        } 
      } 
    } 
  }
  
  private void a(a<View, s> parama1, a<View, s> parama2, f<View> paramf1, f<View> paramf2) {
    int i1 = paramf1.b();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = (View)paramf1.c(b1);
      if (view != null && a(view)) {
        View view1 = (View)paramf2.a(paramf1.b(b1));
        if (view1 != null && a(view1)) {
          s s1 = (s)parama1.get(view);
          s s2 = (s)parama2.get(view1);
          if (s1 != null && s2 != null) {
            this.y.add(s1);
            this.z.add(s2);
            parama1.remove(view);
            parama2.remove(view1);
          } 
        } 
      } 
    } 
  }
  
  private void a(a<View, s> parama1, a<View, s> parama2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2) {
    int i1 = paramSparseArray1.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = (View)paramSparseArray1.valueAt(b1);
      if (view != null && a(view)) {
        View view1 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(b1));
        if (view1 != null && a(view1)) {
          s s1 = (s)parama1.get(view);
          s s2 = (s)parama2.get(view1);
          if (s1 != null && s2 != null) {
            this.y.add(s1);
            this.z.add(s2);
            parama1.remove(view);
            parama2.remove(view1);
          } 
        } 
      } 
    } 
  }
  
  private static boolean a(s params1, s params2, String paramString) {
    Object object1 = params1.a.get(paramString);
    Object object2 = params2.a.get(paramString);
    boolean bool = true;
    if (object1 == null && object2 == null)
      return false; 
    if (object1 != null) {
      if (object2 == null)
        return bool; 
      bool ^= object1.equals(object2);
    } 
    return bool;
  }
  
  private void b(a<View, s> parama1, a<View, s> parama2) {
    byte b2;
    byte b1 = 0;
    while (true) {
      int i1 = parama1.size();
      b2 = 0;
      if (b1 < i1) {
        s s1 = (s)parama1.c(b1);
        if (a(s1.b)) {
          this.y.add(s1);
          this.z.add(null);
        } 
        b1++;
        continue;
      } 
      break;
    } 
    while (b2 < parama2.size()) {
      s s1 = (s)parama2.c(b2);
      if (a(s1.b)) {
        this.z.add(s1);
        this.y.add(null);
      } 
      b2++;
    } 
  }
  
  private void c(View paramView, boolean paramBoolean) {
    if (paramView == null)
      return; 
    int i1 = paramView.getId();
    ArrayList arrayList1 = this.o;
    if (arrayList1 != null && arrayList1.contains(Integer.valueOf(i1)))
      return; 
    ArrayList arrayList2 = this.p;
    if (arrayList2 != null && arrayList2.contains(paramView))
      return; 
    ArrayList arrayList3 = this.q;
    byte b1 = 0;
    if (arrayList3 != null) {
      int i2 = arrayList3.size();
      for (byte b2 = 0; b2 < i2; b2++) {
        if (((Class)this.q.get(b2)).isInstance(paramView))
          return; 
      } 
    } 
    if (paramView.getParent() instanceof ViewGroup) {
      t t1;
      s s1 = new s();
      s1.b = paramView;
      if (paramBoolean) {
        a(s1);
      } else {
        b(s1);
      } 
      s1.c.add(this);
      c(s1);
      if (paramBoolean) {
        t1 = this.v;
      } else {
        t1 = this.w;
      } 
      a(t1, paramView, s1);
    } 
    if (paramView instanceof ViewGroup) {
      ArrayList arrayList4 = this.s;
      if (arrayList4 != null && arrayList4.contains(Integer.valueOf(i1)))
        return; 
      ArrayList arrayList5 = this.t;
      if (arrayList5 != null && arrayList5.contains(paramView))
        return; 
      ArrayList arrayList6 = this.u;
      if (arrayList6 != null) {
        int i2 = arrayList6.size();
        for (byte b2 = 0; b2 < i2; b2++) {
          if (((Class)this.u.get(b2)).isInstance(paramView))
            return; 
        } 
      } 
      ViewGroup viewGroup = (ViewGroup)paramView;
      while (b1 < viewGroup.getChildCount()) {
        c(viewGroup.getChildAt(b1), paramBoolean);
        b1++;
      } 
    } 
  }
  
  private static a<Animator, a> q() {
    a a1 = (a)A.get();
    if (a1 == null) {
      a1 = new a();
      A.set(a1);
    } 
    return a1;
  }
  
  public Animator a(ViewGroup paramViewGroup, s params1, s params2) { return null; }
  
  public m a(long paramLong) {
    this.a = paramLong;
    return this;
  }
  
  public m a(TimeInterpolator paramTimeInterpolator) {
    this.l = paramTimeInterpolator;
    return this;
  }
  
  public m a(c paramc) {
    if (this.F == null)
      this.F = new ArrayList(); 
    this.F.add(paramc);
    return this;
  }
  
  public s a(View paramView, boolean paramBoolean) {
    t t1;
    q q1 = this.d;
    if (q1 != null)
      return q1.a(paramView, paramBoolean); 
    if (paramBoolean) {
      t1 = this.v;
    } else {
      t1 = this.w;
    } 
    return (s)t1.a.get(paramView);
  }
  
  String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("@");
    stringBuilder.append(Integer.toHexString(hashCode()));
    stringBuilder.append(": ");
    String str = stringBuilder.toString();
    if (this.a != -1L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("dur(");
      stringBuilder1.append(this.a);
      stringBuilder1.append(") ");
      str = stringBuilder1.toString();
    } 
    if (this.k != -1L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("dly(");
      stringBuilder1.append(this.k);
      stringBuilder1.append(") ");
      str = stringBuilder1.toString();
    } 
    if (this.l != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("interp(");
      stringBuilder1.append(this.l);
      stringBuilder1.append(") ");
      str = stringBuilder1.toString();
    } 
    if (this.b.size() > 0 || this.c.size() > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("tgts(");
      String str1 = stringBuilder1.toString();
      if (this.b.size() > 0) {
        String str2 = str1;
        for (byte b2 = 0; b2 < this.b.size(); b2++) {
          if (b2) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str2);
            stringBuilder4.append(", ");
            str2 = stringBuilder4.toString();
          } 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(str2);
          stringBuilder3.append(this.b.get(b2));
          str2 = stringBuilder3.toString();
        } 
        str1 = str2;
      } 
      int i1 = this.c.size();
      byte b1 = 0;
      if (i1 > 0)
        while (b1 < this.c.size()) {
          if (b1) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str1);
            stringBuilder4.append(", ");
            str1 = stringBuilder4.toString();
          } 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(str1);
          stringBuilder3.append(this.c.get(b1));
          str1 = stringBuilder3.toString();
          b1++;
        }  
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(")");
      str = stringBuilder2.toString();
    } 
    return str;
  }
  
  protected void a(Animator paramAnimator) {
    if (paramAnimator == null) {
      k();
      return;
    } 
    if (b() >= 0L)
      paramAnimator.setDuration(b()); 
    if (c() >= 0L)
      paramAnimator.setStartDelay(c()); 
    if (d() != null)
      paramAnimator.setInterpolator(d()); 
    paramAnimator.addListener(new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.k();
            param1Animator.removeListener(this);
          }
        });
    paramAnimator.start();
  }
  
  public void a(g paramg) {
    if (paramg == null)
      paramg = i; 
    this.J = paramg;
  }
  
  public void a(b paramb) { this.H = paramb; }
  
  public void a(p paramp) { this.g = paramp; }
  
  public abstract void a(s params);
  
  void a(ViewGroup paramViewGroup) {
    this.y = new ArrayList();
    this.z = new ArrayList();
    a(this.v, this.w);
    a a1 = q();
    int i1 = a1.size();
    al al = ad.b(paramViewGroup);
    for (int i2 = i1 - 1; i2 >= 0; i2--) {
      Animator animator = (Animator)a1.b(i2);
      if (animator != null) {
        a a2 = (a)a1.get(animator);
        if (a2 != null && a2.a != null && al.equals(a2.d)) {
          boolean bool;
          s s1 = a2.c;
          View view = a2.a;
          s s2 = a(view, true);
          s s3 = b(view, true);
          if ((s2 != null || s3 != null) && a2.e.a(s1, s3)) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool)
            if (animator.isRunning() || animator.isStarted()) {
              animator.cancel();
            } else {
              a1.remove(animator);
            }  
        } 
      } 
    } 
    a(paramViewGroup, this.v, this.w, this.y, this.z);
    e();
  }
  
  protected void a(ViewGroup paramViewGroup, t paramt1, t paramt2, ArrayList<s> paramArrayList1, ArrayList<s> paramArrayList2) { // Byte code:
    //   0: invokestatic q : ()Landroid/support/v4/g/a;
    //   3: astore #6
    //   5: new android/util/SparseIntArray
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #7
    //   14: aload #4
    //   16: invokevirtual size : ()I
    //   19: istore #8
    //   21: ldc2_w 9223372036854775807
    //   24: lstore #9
    //   26: iconst_0
    //   27: istore #11
    //   29: iload #11
    //   31: iload #8
    //   33: if_icmpge -> 602
    //   36: aload #4
    //   38: iload #11
    //   40: invokevirtual get : (I)Ljava/lang/Object;
    //   43: checkcast android/support/e/s
    //   46: astore #15
    //   48: aload #5
    //   50: iload #11
    //   52: invokevirtual get : (I)Ljava/lang/Object;
    //   55: checkcast android/support/e/s
    //   58: astore #16
    //   60: aload #15
    //   62: ifnull -> 80
    //   65: aload #15
    //   67: getfield c : Ljava/util/ArrayList;
    //   70: aload_0
    //   71: invokevirtual contains : (Ljava/lang/Object;)Z
    //   74: ifne -> 80
    //   77: aconst_null
    //   78: astore #15
    //   80: aload #16
    //   82: ifnull -> 100
    //   85: aload #16
    //   87: getfield c : Ljava/util/ArrayList;
    //   90: aload_0
    //   91: invokevirtual contains : (Ljava/lang/Object;)Z
    //   94: ifne -> 100
    //   97: aconst_null
    //   98: astore #16
    //   100: aload #15
    //   102: ifnonnull -> 121
    //   105: aload #16
    //   107: ifnonnull -> 121
    //   110: iload #8
    //   112: istore #19
    //   114: iload #11
    //   116: istore #20
    //   118: goto -> 589
    //   121: aload #15
    //   123: ifnull -> 151
    //   126: aload #16
    //   128: ifnull -> 151
    //   131: aload_0
    //   132: aload #15
    //   134: aload #16
    //   136: invokevirtual a : (Landroid/support/e/s;Landroid/support/e/s;)Z
    //   139: ifeq -> 145
    //   142: goto -> 151
    //   145: iconst_0
    //   146: istore #17
    //   148: goto -> 154
    //   151: iconst_1
    //   152: istore #17
    //   154: iload #17
    //   156: ifeq -> 110
    //   159: aload_0
    //   160: aload_1
    //   161: aload #15
    //   163: aload #16
    //   165: invokevirtual a : (Landroid/view/ViewGroup;Landroid/support/e/s;Landroid/support/e/s;)Landroid/animation/Animator;
    //   168: astore #18
    //   170: aload #18
    //   172: ifnull -> 110
    //   175: aload #16
    //   177: ifnull -> 456
    //   180: aload #16
    //   182: getfield b : Landroid/view/View;
    //   185: astore #21
    //   187: aload_0
    //   188: invokevirtual a : ()[Ljava/lang/String;
    //   191: astore #34
    //   193: aload #21
    //   195: ifnull -> 430
    //   198: aload #34
    //   200: ifnull -> 430
    //   203: aload #34
    //   205: arraylength
    //   206: ifle -> 430
    //   209: new android/support/e/s
    //   212: dup
    //   213: invokespecial <init> : ()V
    //   216: astore #36
    //   218: aload #36
    //   220: aload #21
    //   222: putfield b : Landroid/view/View;
    //   225: iload #8
    //   227: istore #19
    //   229: aload_3
    //   230: getfield a : Landroid/support/v4/g/a;
    //   233: aload #21
    //   235: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   238: checkcast android/support/e/s
    //   241: astore #37
    //   243: aload #37
    //   245: ifnull -> 324
    //   248: iconst_0
    //   249: istore #41
    //   251: iload #41
    //   253: aload #34
    //   255: arraylength
    //   256: if_icmpge -> 324
    //   259: aload #36
    //   261: getfield a : Ljava/util/Map;
    //   264: astore #42
    //   266: aload #34
    //   268: iload #41
    //   270: aaload
    //   271: astore #43
    //   273: iload #11
    //   275: istore #44
    //   277: aload #37
    //   279: getfield a : Ljava/util/Map;
    //   282: astore #45
    //   284: aload #37
    //   286: astore #46
    //   288: aload #42
    //   290: aload #43
    //   292: aload #45
    //   294: aload #34
    //   296: iload #41
    //   298: aaload
    //   299: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   304: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: pop
    //   310: iinc #41, 1
    //   313: iload #44
    //   315: istore #11
    //   317: aload #46
    //   319: astore #37
    //   321: goto -> 251
    //   324: iload #11
    //   326: istore #20
    //   328: aload #6
    //   330: invokevirtual size : ()I
    //   333: istore #38
    //   335: iconst_0
    //   336: istore #39
    //   338: iload #39
    //   340: iload #38
    //   342: if_icmpge -> 423
    //   345: aload #6
    //   347: aload #6
    //   349: iload #39
    //   351: invokevirtual b : (I)Ljava/lang/Object;
    //   354: checkcast android/animation/Animator
    //   357: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast android/support/e/m$a
    //   363: astore #40
    //   365: aload #40
    //   367: getfield c : Landroid/support/e/s;
    //   370: ifnull -> 417
    //   373: aload #40
    //   375: getfield a : Landroid/view/View;
    //   378: aload #21
    //   380: if_acmpne -> 417
    //   383: aload #40
    //   385: getfield b : Ljava/lang/String;
    //   388: aload_0
    //   389: invokevirtual p : ()Ljava/lang/String;
    //   392: invokevirtual equals : (Ljava/lang/Object;)Z
    //   395: ifeq -> 417
    //   398: aload #40
    //   400: getfield c : Landroid/support/e/s;
    //   403: aload #36
    //   405: invokevirtual equals : (Ljava/lang/Object;)Z
    //   408: ifeq -> 417
    //   411: aconst_null
    //   412: astore #35
    //   414: goto -> 445
    //   417: iinc #39, 1
    //   420: goto -> 338
    //   423: aload #18
    //   425: astore #35
    //   427: goto -> 445
    //   430: iload #8
    //   432: istore #19
    //   434: iload #11
    //   436: istore #20
    //   438: aload #18
    //   440: astore #35
    //   442: aconst_null
    //   443: astore #36
    //   445: aload #35
    //   447: astore #22
    //   449: aload #36
    //   451: astore #23
    //   453: goto -> 478
    //   456: iload #8
    //   458: istore #19
    //   460: iload #11
    //   462: istore #20
    //   464: aload #15
    //   466: getfield b : Landroid/view/View;
    //   469: astore #21
    //   471: aload #18
    //   473: astore #22
    //   475: aconst_null
    //   476: astore #23
    //   478: aload #22
    //   480: ifnull -> 589
    //   483: aload_0
    //   484: getfield g : Landroid/support/e/p;
    //   487: astore #24
    //   489: aload #24
    //   491: ifnull -> 531
    //   494: aload #24
    //   496: aload_1
    //   497: aload_0
    //   498: aload #15
    //   500: aload #16
    //   502: invokevirtual a : (Landroid/view/ViewGroup;Landroid/support/e/m;Landroid/support/e/s;Landroid/support/e/s;)J
    //   505: lstore #32
    //   507: aload #7
    //   509: aload_0
    //   510: getfield G : Ljava/util/ArrayList;
    //   513: invokevirtual size : ()I
    //   516: lload #32
    //   518: l2i
    //   519: invokevirtual put : (II)V
    //   522: lload #32
    //   524: lload #9
    //   526: invokestatic min : (JJ)J
    //   529: lstore #9
    //   531: lload #9
    //   533: lstore #25
    //   535: aload_0
    //   536: invokevirtual p : ()Ljava/lang/String;
    //   539: astore #27
    //   541: aload_1
    //   542: invokestatic b : (Landroid/view/View;)Landroid/support/e/al;
    //   545: astore #28
    //   547: new android/support/e/m$a
    //   550: dup
    //   551: aload #21
    //   553: aload #27
    //   555: aload_0
    //   556: aload #28
    //   558: aload #23
    //   560: invokespecial <init> : (Landroid/view/View;Ljava/lang/String;Landroid/support/e/m;Landroid/support/e/al;Landroid/support/e/s;)V
    //   563: astore #29
    //   565: aload #6
    //   567: aload #22
    //   569: aload #29
    //   571: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   574: pop
    //   575: aload_0
    //   576: getfield G : Ljava/util/ArrayList;
    //   579: aload #22
    //   581: invokevirtual add : (Ljava/lang/Object;)Z
    //   584: pop
    //   585: lload #25
    //   587: lstore #9
    //   589: iload #20
    //   591: iconst_1
    //   592: iadd
    //   593: istore #11
    //   595: iload #19
    //   597: istore #8
    //   599: goto -> 29
    //   602: lload #9
    //   604: lconst_0
    //   605: lcmp
    //   606: ifeq -> 673
    //   609: iconst_0
    //   610: istore #12
    //   612: iload #12
    //   614: aload #7
    //   616: invokevirtual size : ()I
    //   619: if_icmpge -> 673
    //   622: aload #7
    //   624: iload #12
    //   626: invokevirtual keyAt : (I)I
    //   629: istore #13
    //   631: aload_0
    //   632: getfield G : Ljava/util/ArrayList;
    //   635: iload #13
    //   637: invokevirtual get : (I)Ljava/lang/Object;
    //   640: checkcast android/animation/Animator
    //   643: astore #14
    //   645: aload #14
    //   647: aload #7
    //   649: iload #12
    //   651: invokevirtual valueAt : (I)I
    //   654: i2l
    //   655: lload #9
    //   657: lsub
    //   658: aload #14
    //   660: invokevirtual getStartDelay : ()J
    //   663: ladd
    //   664: invokevirtual setStartDelay : (J)V
    //   667: iinc #12, 1
    //   670: goto -> 612
    //   673: return }
  
  void a(ViewGroup paramViewGroup, boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: invokevirtual a : (Z)V
    //   5: aload_0
    //   6: getfield b : Ljava/util/ArrayList;
    //   9: invokevirtual size : ()I
    //   12: ifgt -> 25
    //   15: aload_0
    //   16: getfield c : Ljava/util/ArrayList;
    //   19: invokevirtual size : ()I
    //   22: ifle -> 63
    //   25: aload_0
    //   26: getfield m : Ljava/util/ArrayList;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull -> 41
    //   34: aload_3
    //   35: invokevirtual isEmpty : ()Z
    //   38: ifeq -> 63
    //   41: aload_0
    //   42: getfield n : Ljava/util/ArrayList;
    //   45: astore #4
    //   47: aload #4
    //   49: ifnull -> 72
    //   52: aload #4
    //   54: invokevirtual isEmpty : ()Z
    //   57: ifeq -> 63
    //   60: goto -> 72
    //   63: aload_0
    //   64: aload_1
    //   65: iload_2
    //   66: invokespecial c : (Landroid/view/View;Z)V
    //   69: goto -> 312
    //   72: iconst_0
    //   73: istore #5
    //   75: iload #5
    //   77: aload_0
    //   78: getfield b : Ljava/util/ArrayList;
    //   81: invokevirtual size : ()I
    //   84: if_icmpge -> 198
    //   87: aload_1
    //   88: aload_0
    //   89: getfield b : Ljava/util/ArrayList;
    //   92: iload #5
    //   94: invokevirtual get : (I)Ljava/lang/Object;
    //   97: checkcast java/lang/Integer
    //   100: invokevirtual intValue : ()I
    //   103: invokevirtual findViewById : (I)Landroid/view/View;
    //   106: astore #21
    //   108: aload #21
    //   110: ifnull -> 192
    //   113: new android/support/e/s
    //   116: dup
    //   117: invokespecial <init> : ()V
    //   120: astore #22
    //   122: aload #22
    //   124: aload #21
    //   126: putfield b : Landroid/view/View;
    //   129: iload_2
    //   130: ifeq -> 142
    //   133: aload_0
    //   134: aload #22
    //   136: invokevirtual a : (Landroid/support/e/s;)V
    //   139: goto -> 148
    //   142: aload_0
    //   143: aload #22
    //   145: invokevirtual b : (Landroid/support/e/s;)V
    //   148: aload #22
    //   150: getfield c : Ljava/util/ArrayList;
    //   153: aload_0
    //   154: invokevirtual add : (Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_0
    //   159: aload #22
    //   161: invokevirtual c : (Landroid/support/e/s;)V
    //   164: iload_2
    //   165: ifeq -> 177
    //   168: aload_0
    //   169: getfield v : Landroid/support/e/t;
    //   172: astore #24
    //   174: goto -> 183
    //   177: aload_0
    //   178: getfield w : Landroid/support/e/t;
    //   181: astore #24
    //   183: aload #24
    //   185: aload #21
    //   187: aload #22
    //   189: invokestatic a : (Landroid/support/e/t;Landroid/view/View;Landroid/support/e/s;)V
    //   192: iinc #5, 1
    //   195: goto -> 75
    //   198: iconst_0
    //   199: istore #6
    //   201: iload #6
    //   203: aload_0
    //   204: getfield c : Ljava/util/ArrayList;
    //   207: invokevirtual size : ()I
    //   210: if_icmpge -> 312
    //   213: aload_0
    //   214: getfield c : Ljava/util/ArrayList;
    //   217: iload #6
    //   219: invokevirtual get : (I)Ljava/lang/Object;
    //   222: checkcast android/view/View
    //   225: astore #17
    //   227: new android/support/e/s
    //   230: dup
    //   231: invokespecial <init> : ()V
    //   234: astore #18
    //   236: aload #18
    //   238: aload #17
    //   240: putfield b : Landroid/view/View;
    //   243: iload_2
    //   244: ifeq -> 256
    //   247: aload_0
    //   248: aload #18
    //   250: invokevirtual a : (Landroid/support/e/s;)V
    //   253: goto -> 262
    //   256: aload_0
    //   257: aload #18
    //   259: invokevirtual b : (Landroid/support/e/s;)V
    //   262: aload #18
    //   264: getfield c : Ljava/util/ArrayList;
    //   267: aload_0
    //   268: invokevirtual add : (Ljava/lang/Object;)Z
    //   271: pop
    //   272: aload_0
    //   273: aload #18
    //   275: invokevirtual c : (Landroid/support/e/s;)V
    //   278: iload_2
    //   279: ifeq -> 291
    //   282: aload_0
    //   283: getfield v : Landroid/support/e/t;
    //   286: astore #20
    //   288: goto -> 297
    //   291: aload_0
    //   292: getfield w : Landroid/support/e/t;
    //   295: astore #20
    //   297: aload #20
    //   299: aload #17
    //   301: aload #18
    //   303: invokestatic a : (Landroid/support/e/t;Landroid/view/View;Landroid/support/e/s;)V
    //   306: iinc #6, 1
    //   309: goto -> 201
    //   312: iload_2
    //   313: ifne -> 455
    //   316: aload_0
    //   317: getfield I : Landroid/support/v4/g/a;
    //   320: astore #7
    //   322: aload #7
    //   324: ifnull -> 455
    //   327: aload #7
    //   329: invokevirtual size : ()I
    //   332: istore #8
    //   334: new java/util/ArrayList
    //   337: dup
    //   338: iload #8
    //   340: invokespecial <init> : (I)V
    //   343: astore #9
    //   345: iconst_0
    //   346: istore #10
    //   348: iconst_0
    //   349: istore #11
    //   351: iload #10
    //   353: iload #8
    //   355: if_icmpge -> 396
    //   358: aload_0
    //   359: getfield I : Landroid/support/v4/g/a;
    //   362: iload #10
    //   364: invokevirtual b : (I)Ljava/lang/Object;
    //   367: checkcast java/lang/String
    //   370: astore #15
    //   372: aload #9
    //   374: aload_0
    //   375: getfield v : Landroid/support/e/t;
    //   378: getfield d : Landroid/support/v4/g/a;
    //   381: aload #15
    //   383: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   386: invokevirtual add : (Ljava/lang/Object;)Z
    //   389: pop
    //   390: iinc #10, 1
    //   393: goto -> 348
    //   396: iload #11
    //   398: iload #8
    //   400: if_icmpge -> 455
    //   403: aload #9
    //   405: iload #11
    //   407: invokevirtual get : (I)Ljava/lang/Object;
    //   410: checkcast android/view/View
    //   413: astore #12
    //   415: aload #12
    //   417: ifnull -> 449
    //   420: aload_0
    //   421: getfield I : Landroid/support/v4/g/a;
    //   424: iload #11
    //   426: invokevirtual c : (I)Ljava/lang/Object;
    //   429: checkcast java/lang/String
    //   432: astore #13
    //   434: aload_0
    //   435: getfield v : Landroid/support/e/t;
    //   438: getfield d : Landroid/support/v4/g/a;
    //   441: aload #13
    //   443: aload #12
    //   445: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   448: pop
    //   449: iinc #11, 1
    //   452: goto -> 396
    //   455: return }
  
  void a(boolean paramBoolean) {
    t t1;
    if (paramBoolean) {
      this.v.a.clear();
      this.v.b.clear();
      t1 = this.v;
    } else {
      this.w.a.clear();
      this.w.b.clear();
      t1 = this.w;
    } 
    t1.c.c();
  }
  
  public boolean a(s params1, s params2) { // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull -> 114
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_2
    //   9: ifnull -> 114
    //   12: aload_0
    //   13: invokevirtual a : ()[Ljava/lang/String;
    //   16: astore #4
    //   18: aload #4
    //   20: ifnull -> 62
    //   23: aload #4
    //   25: arraylength
    //   26: istore #7
    //   28: iconst_0
    //   29: istore #8
    //   31: iconst_0
    //   32: istore_3
    //   33: iload #8
    //   35: iload #7
    //   37: if_icmpge -> 114
    //   40: aload_1
    //   41: aload_2
    //   42: aload #4
    //   44: iload #8
    //   46: aaload
    //   47: invokestatic a : (Landroid/support/e/s;Landroid/support/e/s;Ljava/lang/String;)Z
    //   50: ifeq -> 56
    //   53: goto -> 112
    //   56: iinc #8, 1
    //   59: goto -> 31
    //   62: aload_1
    //   63: getfield a : Ljava/util/Map;
    //   66: invokeinterface keySet : ()Ljava/util/Set;
    //   71: invokeinterface iterator : ()Ljava/util/Iterator;
    //   76: astore #5
    //   78: aload #5
    //   80: invokeinterface hasNext : ()Z
    //   85: istore #6
    //   87: iconst_0
    //   88: istore_3
    //   89: iload #6
    //   91: ifeq -> 114
    //   94: aload_1
    //   95: aload_2
    //   96: aload #5
    //   98: invokeinterface next : ()Ljava/lang/Object;
    //   103: checkcast java/lang/String
    //   106: invokestatic a : (Landroid/support/e/s;Landroid/support/e/s;Ljava/lang/String;)Z
    //   109: ifeq -> 78
    //   112: iconst_1
    //   113: istore_3
    //   114: iload_3
    //   115: ireturn }
  
  boolean a(View paramView) {
    int i1 = paramView.getId();
    ArrayList arrayList1 = this.o;
    if (arrayList1 != null && arrayList1.contains(Integer.valueOf(i1)))
      return false; 
    ArrayList arrayList2 = this.p;
    if (arrayList2 != null && arrayList2.contains(paramView))
      return false; 
    ArrayList arrayList3 = this.q;
    if (arrayList3 != null) {
      int i2 = arrayList3.size();
      for (byte b1 = 0; b1 < i2; b1++) {
        if (((Class)this.q.get(b1)).isInstance(paramView))
          return false; 
      } 
    } 
    if (this.r != null && r.n(paramView) != null && this.r.contains(r.n(paramView)))
      return false; 
    if (this.b.size() == 0 && this.c.size() == 0) {
      ArrayList arrayList = this.n;
      if (arrayList == null || arrayList.isEmpty()) {
        ArrayList arrayList4 = this.m;
        if (arrayList4 == null || arrayList4.isEmpty())
          return true; 
      } 
    } 
    if (!this.b.contains(Integer.valueOf(i1))) {
      if (this.c.contains(paramView))
        return true; 
      ArrayList arrayList = this.m;
      if (arrayList != null && arrayList.contains(r.n(paramView)))
        return true; 
      if (this.n != null)
        for (byte b1 = 0; b1 < this.n.size(); b1++) {
          if (((Class)this.n.get(b1)).isInstance(paramView))
            return true; 
        }  
      return false;
    } 
    return true;
  }
  
  public String[] a() { return null; }
  
  public long b() { return this.a; }
  
  public m b(long paramLong) {
    this.k = paramLong;
    return this;
  }
  
  public m b(c paramc) {
    ArrayList arrayList = this.F;
    if (arrayList == null)
      return this; 
    arrayList.remove(paramc);
    if (this.F.size() == 0)
      this.F = null; 
    return this;
  }
  
  public m b(View paramView) {
    this.c.add(paramView);
    return this;
  }
  
  s b(View paramView, boolean paramBoolean) {
    ArrayList arrayList;
    q q1 = this.d;
    if (q1 != null)
      return q1.b(paramView, paramBoolean); 
    if (paramBoolean) {
      arrayList = this.y;
    } else {
      arrayList = this.z;
    } 
    if (arrayList == null)
      return null; 
    int i1 = arrayList.size();
    byte b1 = -1;
    for (byte b2 = 0; b2 < i1; b2++) {
      s s2 = (s)arrayList.get(b2);
      if (s2 == null)
        return null; 
      if (s2.b == paramView) {
        b1 = b2;
        break;
      } 
    } 
    s s1 = null;
    if (b1 >= 0) {
      ArrayList arrayList1;
      if (paramBoolean) {
        arrayList1 = this.z;
      } else {
        arrayList1 = this.y;
      } 
      s1 = (s)arrayList1.get(b1);
    } 
    return s1;
  }
  
  public abstract void b(s params);
  
  public long c() { return this.k; }
  
  public m c(View paramView) {
    this.c.remove(paramView);
    return this;
  }
  
  void c(s params) {
    if (this.g != null && !params.a.isEmpty()) {
      boolean bool;
      String[] arrayOfString = this.g.a();
      if (arrayOfString == null)
        return; 
      byte b1 = 0;
      while (true) {
        if (b1 < arrayOfString.length) {
          if (!params.a.containsKey(arrayOfString[b1])) {
            boolean bool1 = false;
            break;
          } 
          b1++;
          continue;
        } 
        bool = true;
        break;
      } 
      if (!bool)
        this.g.a(params); 
    } 
  }
  
  public TimeInterpolator d() { return this.l; }
  
  public void d(View paramView) {
    if (!this.E) {
      a a1 = q();
      int i1 = a1.size();
      al al = ad.b(paramView);
      for (int i2 = i1 - 1; i2 >= 0; i2--) {
        a a2 = (a)a1.c(i2);
        if (a2.a != null && al.equals(a2.d))
          a.a((Animator)a1.b(i2)); 
      } 
      ArrayList arrayList = this.F;
      if (arrayList != null && arrayList.size() > 0) {
        ArrayList arrayList1 = (ArrayList)this.F.clone();
        int i3 = arrayList1.size();
        for (byte b1 = 0; b1 < i3; b1++)
          ((c)arrayList1.get(b1)).b(this); 
      } 
      this.D = true;
    } 
  }
  
  protected void e() {
    j();
    a a1 = q();
    for (Animator animator : this.G) {
      if (a1.containsKey(animator)) {
        j();
        a(animator, a1);
      } 
    } 
    this.G.clear();
    k();
  }
  
  public void e(View paramView) {
    if (this.D) {
      if (!this.E) {
        a a1 = q();
        int i1 = a1.size();
        al al = ad.b(paramView);
        for (int i2 = i1 - 1; i2 >= 0; i2--) {
          a a2 = (a)a1.c(i2);
          if (a2.a != null && al.equals(a2.d))
            a.b((Animator)a1.b(i2)); 
        } 
        ArrayList arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
          ArrayList arrayList1 = (ArrayList)this.F.clone();
          int i3 = arrayList1.size();
          for (byte b1 = 0; b1 < i3; b1++)
            ((c)arrayList1.get(b1)).c(this); 
        } 
      } 
      this.D = false;
    } 
  }
  
  public List<Integer> f() { return this.b; }
  
  public List<View> g() { return this.c; }
  
  public List<String> h() { return this.m; }
  
  public List<Class> i() { return this.n; }
  
  protected void j() {
    if (this.C == 0) {
      ArrayList arrayList = this.F;
      if (arrayList != null && arrayList.size() > 0) {
        ArrayList arrayList1 = (ArrayList)this.F.clone();
        int i1 = arrayList1.size();
        for (byte b1 = 0; b1 < i1; b1++)
          ((c)arrayList1.get(b1)).d(this); 
      } 
      this.E = false;
    } 
    this.C = 1 + this.C;
  }
  
  protected void k() {
    this.C--;
    if (this.C == 0) {
      ArrayList arrayList = this.F;
      if (arrayList != null && arrayList.size() > 0) {
        ArrayList arrayList1 = (ArrayList)this.F.clone();
        int i1 = arrayList1.size();
        for (byte b3 = 0; b3 < i1; b3++)
          ((c)arrayList1.get(b3)).a(this); 
      } 
      for (byte b1 = 0; b1 < this.v.c.b(); b1++) {
        View view = (View)this.v.c.c(b1);
        if (view != null)
          r.a(view, false); 
      } 
      for (byte b2 = 0; b2 < this.w.c.b(); b2++) {
        View view = (View)this.w.c.c(b2);
        if (view != null)
          r.a(view, false); 
      } 
      this.E = true;
    } 
  }
  
  public g l() { return this.J; }
  
  public b m() { return this.H; }
  
  public p n() { return this.g; }
  
  public m o() {
    try {
      m m1 = (m)super.clone();
      m1.G = new ArrayList();
      m1.v = new t();
      m1.w = new t();
      m1.y = null;
      m1.z = null;
      return m1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  public String p() { return this.j; }
  
  public String toString() { return a(""); }
  
  private static class a {
    View a;
    
    String b;
    
    s c;
    
    al d;
    
    m e;
    
    a(View param1View, String param1String, m param1m, al param1al, s param1s) {
      this.a = param1View;
      this.b = param1String;
      this.c = param1s;
      this.d = param1al;
      this.e = param1m;
    }
  }
  
  public static abstract class b {}
  
  public static interface c {
    void a(m param1m);
    
    void b(m param1m);
    
    void c(m param1m);
    
    void d(m param1m);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */