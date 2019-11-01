package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.h.a.c;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
  boolean a = false;
  
  int b = -1;
  
  int[] c;
  
  View[] d;
  
  final SparseIntArray e = new SparseIntArray();
  
  final SparseIntArray f = new SparseIntArray();
  
  c g = new a();
  
  final Rect h = new Rect();
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a((a(paramContext, paramAttributeSet, paramInt1, paramInt2)).b);
  }
  
  private void K() {
    this.e.clear();
    this.f.clear();
  }
  
  private void L() {
    int i = v();
    for (byte b1 = 0; b1 < i; b1++) {
      b b2 = (b)i(b1).getLayoutParams();
      int j = b2.f();
      this.e.put(j, b2.b());
      this.f.put(j, b2.a());
    } 
  }
  
  private void M() {
    int j;
    int i;
    if (g() == 1) {
      i = y() - C();
      j = A();
    } else {
      i = z() - D();
      j = B();
    } 
    m(i - j);
  }
  
  private void N() {
    View[] arrayOfView = this.d;
    if (arrayOfView == null || arrayOfView.length != this.b)
      this.d = new View[this.b]; 
  }
  
  private int a(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt) {
    if (!paramu.a())
      return this.g.c(paramInt, this.b); 
    int i = paramp.b(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. ");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 0;
    } 
    return this.g.c(i, this.b);
  }
  
  private void a(float paramFloat, int paramInt) { m(Math.max(Math.round(paramFloat * this.b), paramInt)); }
  
  private void a(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt1, int paramInt2, boolean paramBoolean) {
    int m;
    int k;
    int i = 0;
    int j = -1;
    if (paramBoolean) {
      j = paramInt1;
      m = 1;
      k = 0;
      i = 0;
    } else {
      k = paramInt1 - 1;
      m = -1;
    } 
    while (k != j) {
      View view = this.d[k];
      b b1 = (b)view.getLayoutParams();
      b1.b = c(paramp, paramu, d(view));
      b1.a = i;
      i += b1.b;
      k += m;
    } 
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    boolean bool;
    RecyclerView.j j = (RecyclerView.j)paramView.getLayoutParams();
    if (paramBoolean) {
      bool = a(paramView, paramInt1, paramInt2, j);
    } else {
      bool = b(paramView, paramInt1, paramInt2, j);
    } 
    if (bool)
      paramView.measure(paramInt1, paramInt2); 
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean) {
    int n;
    int m;
    b b1 = (b)paramView.getLayoutParams();
    Rect rect = b1.d;
    int i = rect.top + rect.bottom + b1.topMargin + b1.bottomMargin;
    int j = rect.left + rect.right + b1.leftMargin + b1.rightMargin;
    int k = a(b1.a, b1.b);
    if (this.i == 1) {
      n = a(k, paramInt, j, b1.width, false);
      m = a(this.j.f(), x(), i, b1.height, true);
    } else {
      int i1 = a(k, paramInt, i, b1.height, false);
      int i2 = a(this.j.f(), w(), j, b1.width, true);
      m = i1;
      n = i2;
    } 
    a(paramView, n, m, paramBoolean);
  }
  
  static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {
    int i = 1;
    if (paramArrayOfInt == null || paramArrayOfInt.length != paramInt1 + 1 || paramArrayOfInt[paramArrayOfInt.length - i] != paramInt2)
      paramArrayOfInt = new int[paramInt1 + 1]; 
    int j = 0;
    paramArrayOfInt[0] = 0;
    int k = paramInt2 / paramInt1;
    int m = paramInt2 % paramInt1;
    int n = 0;
    while (i <= paramInt1) {
      int i1;
      j += m;
      if (j > 0 && paramInt1 - j < m) {
        i1 = k + 1;
        j -= paramInt1;
      } else {
        i1 = k;
      } 
      n += i1;
      paramArrayOfInt[i] = n;
      i++;
    } 
    return paramArrayOfInt;
  }
  
  private int b(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt) {
    if (!paramu.a())
      return this.g.b(paramInt, this.b); 
    int i = this.f.get(paramInt, -1);
    if (i != -1)
      return i; 
    int j = paramp.b(paramInt);
    if (j == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 0;
    } 
    return this.g.b(j, this.b);
  }
  
  private void b(RecyclerView.p paramp, RecyclerView.u paramu, LinearLayoutManager.a parama, int paramInt) {
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = b(paramp, paramu, parama.b);
    if (bool) {
      while (i > 0 && parama.b > 0) {
        parama.b--;
        i = b(paramp, paramu, parama.b);
      } 
    } else {
      int j = paramu.e() - 1;
      int k = parama.b;
      while (k < j) {
        int m = k + 1;
        int n = b(paramp, paramu, m);
        if (n > i) {
          k = m;
          i = n;
        } 
      } 
      parama.b = k;
    } 
  }
  
  private int c(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt) {
    if (!paramu.a())
      return this.g.a(paramInt); 
    int i = this.e.get(paramInt, -1);
    if (i != -1)
      return i; 
    int j = paramp.b(paramInt);
    if (j == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 1;
    } 
    return this.g.a(j);
  }
  
  private void m(int paramInt) { this.c = a(this.c, this.b, paramInt); }
  
  int a(int paramInt1, int paramInt2) {
    if (this.i == 1 && h()) {
      int[] arrayOfInt1 = this.c;
      int i = this.b;
      return arrayOfInt1[i - paramInt1] - arrayOfInt1[i - paramInt1 - paramInt2];
    } 
    int[] arrayOfInt = this.c;
    return arrayOfInt[paramInt2 + paramInt1] - arrayOfInt[paramInt1];
  }
  
  public int a(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) {
    M();
    N();
    return super.a(paramInt, paramp, paramu);
  }
  
  public int a(RecyclerView.p paramp, RecyclerView.u paramu) { return (this.i == 0) ? this.b : ((paramu.e() < 1) ? 0 : (1 + a(paramp, paramu, paramu.e() - 1))); }
  
  public RecyclerView.j a() { return (this.i == 0) ? new b(-2, -1) : new b(-1, -2); }
  
  public RecyclerView.j a(Context paramContext, AttributeSet paramAttributeSet) { return new b(paramContext, paramAttributeSet); }
  
  public RecyclerView.j a(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new b((ViewGroup.MarginLayoutParams)paramLayoutParams) : new b(paramLayoutParams); }
  
  View a(RecyclerView.p paramp, RecyclerView.u paramu, int paramInt1, int paramInt2, int paramInt3) {
    int k;
    i();
    int i = this.j.c();
    int j = this.j.d();
    if (paramInt2 > paramInt1) {
      k = 1;
    } else {
      k = -1;
    } 
    View view1 = null;
    View view2 = null;
    while (paramInt1 != paramInt2) {
      View view = i(paramInt1);
      int m = d(view);
      if (m >= 0 && m < paramInt3 && b(paramp, paramu, m) == 0)
        if (((RecyclerView.j)view.getLayoutParams()).d()) {
          if (view2 == null)
            view2 = view; 
        } else if (this.j.a(view) >= j || this.j.b(view) < i) {
          if (view1 == null)
            view1 = view; 
        } else {
          return view;
        }  
      paramInt1 += k;
    } 
    return (view1 != null) ? view1 : view2;
  }
  
  public View a(View paramView, int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) { // Byte code:
    //   0: aload_3
    //   1: astore #5
    //   3: aload #4
    //   5: astore #6
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual e : (Landroid/view/View;)Landroid/view/View;
    //   12: astore #7
    //   14: aconst_null
    //   15: astore #8
    //   17: aload #7
    //   19: ifnonnull -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload #7
    //   26: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   29: checkcast android/support/v7/widget/GridLayoutManager$b
    //   32: astore #9
    //   34: aload #9
    //   36: getfield a : I
    //   39: istore #10
    //   41: aload #9
    //   43: getfield a : I
    //   46: aload #9
    //   48: getfield b : I
    //   51: iadd
    //   52: istore #11
    //   54: aload_0
    //   55: aload_1
    //   56: iload_2
    //   57: aload_3
    //   58: aload #4
    //   60: invokespecial a : (Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;)Landroid/view/View;
    //   63: ifnonnull -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: aload_0
    //   69: iload_2
    //   70: invokevirtual f : (I)I
    //   73: iconst_1
    //   74: if_icmpne -> 83
    //   77: iconst_1
    //   78: istore #12
    //   80: goto -> 86
    //   83: iconst_0
    //   84: istore #12
    //   86: iload #12
    //   88: aload_0
    //   89: getfield k : Z
    //   92: if_icmpeq -> 101
    //   95: iconst_1
    //   96: istore #13
    //   98: goto -> 104
    //   101: iconst_0
    //   102: istore #13
    //   104: iload #13
    //   106: ifeq -> 126
    //   109: aload_0
    //   110: invokevirtual v : ()I
    //   113: iconst_1
    //   114: isub
    //   115: istore #15
    //   117: iconst_m1
    //   118: istore #14
    //   120: iconst_m1
    //   121: istore #16
    //   123: goto -> 138
    //   126: aload_0
    //   127: invokevirtual v : ()I
    //   130: istore #14
    //   132: iconst_0
    //   133: istore #15
    //   135: iconst_1
    //   136: istore #16
    //   138: aload_0
    //   139: getfield i : I
    //   142: iconst_1
    //   143: if_icmpne -> 159
    //   146: aload_0
    //   147: invokevirtual h : ()Z
    //   150: ifeq -> 159
    //   153: iconst_1
    //   154: istore #17
    //   156: goto -> 162
    //   159: iconst_0
    //   160: istore #17
    //   162: aload_0
    //   163: aload #5
    //   165: aload #6
    //   167: iload #15
    //   169: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;I)I
    //   172: istore #18
    //   174: aconst_null
    //   175: astore #19
    //   177: iconst_m1
    //   178: istore #20
    //   180: iconst_0
    //   181: istore #21
    //   183: iconst_0
    //   184: istore #22
    //   186: iconst_m1
    //   187: istore #23
    //   189: iload #15
    //   191: iload #14
    //   193: if_icmpeq -> 694
    //   196: aload_0
    //   197: aload #5
    //   199: aload #6
    //   201: iload #15
    //   203: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;I)I
    //   206: istore #25
    //   208: aload_0
    //   209: iload #15
    //   211: invokevirtual i : (I)Landroid/view/View;
    //   214: astore #26
    //   216: aload #26
    //   218: aload #7
    //   220: if_acmpne -> 226
    //   223: goto -> 694
    //   226: aload #26
    //   228: invokevirtual hasFocusable : ()Z
    //   231: ifeq -> 276
    //   234: iload #25
    //   236: iload #18
    //   238: if_icmpeq -> 276
    //   241: aload #8
    //   243: ifnull -> 249
    //   246: goto -> 694
    //   249: aload #7
    //   251: astore #29
    //   253: iload #20
    //   255: istore #35
    //   257: aload #19
    //   259: astore #36
    //   261: iload #14
    //   263: istore #31
    //   265: iload #22
    //   267: istore #37
    //   269: iload #23
    //   271: istore #38
    //   273: goto -> 653
    //   276: aload #26
    //   278: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   281: checkcast android/support/v7/widget/GridLayoutManager$b
    //   284: astore #27
    //   286: aload #27
    //   288: getfield a : I
    //   291: istore #28
    //   293: aload #7
    //   295: astore #29
    //   297: aload #27
    //   299: getfield a : I
    //   302: istore #30
    //   304: iload #14
    //   306: istore #31
    //   308: iload #30
    //   310: aload #27
    //   312: getfield b : I
    //   315: iadd
    //   316: istore #32
    //   318: aload #26
    //   320: invokevirtual hasFocusable : ()Z
    //   323: ifeq -> 343
    //   326: iload #28
    //   328: iload #10
    //   330: if_icmpne -> 343
    //   333: iload #32
    //   335: iload #11
    //   337: if_icmpne -> 343
    //   340: aload #26
    //   342: areturn
    //   343: aload #26
    //   345: invokevirtual hasFocusable : ()Z
    //   348: ifeq -> 356
    //   351: aload #8
    //   353: ifnull -> 369
    //   356: aload #26
    //   358: invokevirtual hasFocusable : ()Z
    //   361: ifne -> 391
    //   364: aload #19
    //   366: ifnonnull -> 391
    //   369: iload #20
    //   371: istore #35
    //   373: aload #19
    //   375: astore #36
    //   377: iload #22
    //   379: istore #37
    //   381: iload #23
    //   383: istore #38
    //   385: iconst_1
    //   386: istore #39
    //   388: goto -> 554
    //   391: iload #28
    //   393: iload #10
    //   395: invokestatic max : (II)I
    //   398: istore #33
    //   400: iload #32
    //   402: iload #11
    //   404: invokestatic min : (II)I
    //   407: iload #33
    //   409: isub
    //   410: istore #34
    //   412: aload #26
    //   414: invokevirtual hasFocusable : ()Z
    //   417: ifeq -> 463
    //   420: iload #34
    //   422: iload #21
    //   424: if_icmple -> 430
    //   427: goto -> 369
    //   430: iload #34
    //   432: iload #21
    //   434: if_icmpne -> 535
    //   437: iload #28
    //   439: iload #20
    //   441: if_icmple -> 450
    //   444: iconst_1
    //   445: istore #45
    //   447: goto -> 453
    //   450: iconst_0
    //   451: istore #45
    //   453: iload #17
    //   455: iload #45
    //   457: if_icmpne -> 535
    //   460: goto -> 369
    //   463: aload #8
    //   465: ifnonnull -> 535
    //   468: iload #20
    //   470: istore #35
    //   472: aload #19
    //   474: astore #36
    //   476: aload_0
    //   477: aload #26
    //   479: iconst_0
    //   480: iconst_1
    //   481: invokevirtual a : (Landroid/view/View;ZZ)Z
    //   484: ifeq -> 543
    //   487: iload #22
    //   489: istore #37
    //   491: iload #34
    //   493: iload #37
    //   495: if_icmple -> 501
    //   498: goto -> 381
    //   501: iload #34
    //   503: iload #37
    //   505: if_icmpne -> 547
    //   508: iload #23
    //   510: istore #38
    //   512: iconst_0
    //   513: istore #44
    //   515: iload #28
    //   517: iload #38
    //   519: if_icmple -> 525
    //   522: iconst_1
    //   523: istore #44
    //   525: iload #17
    //   527: iload #44
    //   529: if_icmpne -> 551
    //   532: goto -> 385
    //   535: iload #20
    //   537: istore #35
    //   539: aload #19
    //   541: astore #36
    //   543: iload #22
    //   545: istore #37
    //   547: iload #23
    //   549: istore #38
    //   551: iconst_0
    //   552: istore #39
    //   554: iload #39
    //   556: ifeq -> 653
    //   559: aload #26
    //   561: invokevirtual hasFocusable : ()Z
    //   564: ifeq -> 614
    //   567: aload #27
    //   569: getfield a : I
    //   572: istore #42
    //   574: iload #32
    //   576: iload #11
    //   578: invokestatic min : (II)I
    //   581: iload #28
    //   583: iload #10
    //   585: invokestatic max : (II)I
    //   588: isub
    //   589: istore #43
    //   591: aload #36
    //   593: astore #19
    //   595: iload #43
    //   597: istore #21
    //   599: iload #42
    //   601: istore #35
    //   603: iload #38
    //   605: istore #23
    //   607: aload #26
    //   609: astore #8
    //   611: goto -> 661
    //   614: aload #27
    //   616: getfield a : I
    //   619: istore #40
    //   621: iload #32
    //   623: iload #11
    //   625: invokestatic min : (II)I
    //   628: iload #28
    //   630: iload #10
    //   632: invokestatic max : (II)I
    //   635: isub
    //   636: istore #41
    //   638: aload #26
    //   640: astore #19
    //   642: iload #40
    //   644: istore #23
    //   646: iload #41
    //   648: istore #37
    //   650: goto -> 661
    //   653: aload #36
    //   655: astore #19
    //   657: iload #38
    //   659: istore #23
    //   661: iload #15
    //   663: iload #16
    //   665: iadd
    //   666: istore #15
    //   668: iload #37
    //   670: istore #22
    //   672: aload #29
    //   674: astore #7
    //   676: iload #31
    //   678: istore #14
    //   680: iload #35
    //   682: istore #20
    //   684: aload_3
    //   685: astore #5
    //   687: aload #4
    //   689: astore #6
    //   691: goto -> 189
    //   694: aload #19
    //   696: astore #24
    //   698: aload #8
    //   700: ifnull -> 706
    //   703: aload #8
    //   705: areturn
    //   706: aload #24
    //   708: areturn }
  
  public void a(int paramInt) {
    if (paramInt == this.b)
      return; 
    this.a = true;
    if (paramInt >= 1) {
      this.b = paramInt;
      this.g.a();
      o();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Span count should be at least 1. Provided ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2) {
    int m;
    int k;
    if (this.c == null)
      super.a(paramRect, paramInt1, paramInt2); 
    int i = A() + C();
    int j = B() + D();
    if (this.i == 1) {
      m = a(paramInt2, j + paramRect.height(), G());
      int[] arrayOfInt = this.c;
      k = a(paramInt1, i + arrayOfInt[arrayOfInt.length - 1], F());
    } else {
      k = a(paramInt1, i + paramRect.width(), F());
      int[] arrayOfInt = this.c;
      m = a(paramInt2, j + arrayOfInt[arrayOfInt.length - 1], G());
    } 
    f(k, m);
  }
  
  void a(RecyclerView.p paramp, RecyclerView.u paramu, LinearLayoutManager.a parama, int paramInt) {
    super.a(paramp, paramu, parama, paramInt);
    M();
    if (paramu.e() > 0 && !paramu.a())
      b(paramp, paramu, parama, paramInt); 
    N();
  }
  
  void a(RecyclerView.p paramp, RecyclerView.u paramu, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb) {
    boolean bool1;
    byte b1;
    boolean bool;
    int i = this.j.i();
    if (i != 1073741824) {
      bool = true;
    } else {
      bool = false;
    } 
    if (v() > 0) {
      b1 = this.c[this.b];
    } else {
      b1 = 0;
    } 
    if (bool)
      M(); 
    if (paramc.e == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int j = this.b;
    if (!bool1)
      j = b(paramp, paramu, paramc.d) + c(paramp, paramu, paramc.d); 
    int k = 0;
    byte b2 = 0;
    while (b2 < this.b && paramc.a(paramu) && j > 0) {
      int n = paramc.d;
      int i1 = c(paramp, paramu, n);
      if (i1 <= this.b) {
        j -= i1;
        if (j < 0)
          break; 
        View view = paramc.a(paramp);
        if (view == null)
          break; 
        k += i1;
        this.d[b2] = view;
        b2++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Item at position ");
      stringBuilder.append(n);
      stringBuilder.append(" requires ");
      stringBuilder.append(i1);
      stringBuilder.append(" spans but GridLayoutManager has only ");
      stringBuilder.append(this.b);
      stringBuilder.append(" spans.");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    if (b2 == 0) {
      paramb.b = true;
      return;
    } 
    float f1 = 0.0F;
    byte b3 = b2;
    byte b4 = b2;
    a(paramp, paramu, b3, k, bool1);
    byte b5 = 0;
    int m = 0;
    while (b5 < b4) {
      View view = this.d[b5];
      if (paramc.k == null) {
        if (bool1) {
          b(view);
        } else {
          b(view, 0);
        } 
      } else if (bool1) {
        a(view);
      } else {
        a(view, 0);
      } 
      b(view, this.h);
      a(view, i, false);
      int n = this.j.e(view);
      if (n > m)
        m = n; 
      b b8 = (b)view.getLayoutParams();
      float f2 = 1.0F * this.j.f(view) / b8.b;
      if (f2 > f1)
        f1 = f2; 
      b5++;
    } 
    if (bool) {
      a(f1, b1);
      byte b8 = 0;
      m = 0;
      while (b8 < b4) {
        View view = this.d[b8];
        a(view, 1073741824, true);
        int n = this.j.e(view);
        if (n > m)
          m = n; 
        b8++;
      } 
    } 
    for (byte b6 = 0; b6 < b4; b6++) {
      View view = this.d[b6];
      if (this.j.e(view) != m) {
        int i4;
        int i3;
        b b8 = (b)view.getLayoutParams();
        Rect rect = b8.d;
        int n = rect.top + rect.bottom + b8.topMargin + b8.bottomMargin;
        int i1 = rect.left + rect.right + b8.leftMargin + b8.rightMargin;
        int i2 = a(b8.a, b8.b);
        if (this.i == 1) {
          i4 = a(i2, 1073741824, i1, b8.width, false);
          i3 = View.MeasureSpec.makeMeasureSpec(m - n, 1073741824);
        } else {
          int i5 = View.MeasureSpec.makeMeasureSpec(m - i1, 1073741824);
          i3 = a(i2, 1073741824, n, b8.height, false);
          i4 = i5;
        } 
        a(view, i4, i3, true);
      } 
    } 
    byte b7 = 0;
    paramb.a = m;
    if (this.i == 1) {
      if (paramc.f == -1) {
        int i2 = paramc.b;
        int i3 = i2 - m;
        int i1 = i2;
        int n = i3;
      } else {
        int i2 = paramc.b;
        int i3 = m + i2;
        int n = i2;
        int i1 = i3;
      } 
      boolean bool2 = false;
      boolean bool3 = false;
      b7 = 0;
    } else if (paramc.f == -1) {
      int i2 = paramc.b;
      int i3 = i2 - m;
      int i1 = i2;
      int n = i3;
      boolean bool2 = false;
      boolean bool3 = false;
      b7 = 0;
    } else {
      int n = paramc.b;
      int i1 = m + n;
      boolean bool2 = false;
      boolean bool3 = false;
    } 
    while (b7 < b4) {
      int i5;
      int i4;
      View view = this.d[b7];
      b b8 = (b)view.getLayoutParams();
      if (this.i == 1) {
        if (h()) {
          int i8 = A() + this.c[this.b - b8.a];
          int i9 = i8 - this.j.f(view);
          i5 = i8;
          i4 = i9;
        } else {
          n = A() + this.c[b8.a];
          i1 = n + this.j.f(view);
          i4 = n;
          i5 = i1;
        } 
      } else {
        i2 = B() + this.c[b8.a];
        i3 = i2 + this.j.f(view);
        i4 = n;
        i5 = i1;
      } 
      int i6 = i2;
      int i7 = i3;
      a(view, i4, i6, i5, i7);
      if (b8.d() || b8.e())
        paramb.c = true; 
      paramb.d |= view.hasFocusable();
      b7++;
      int n = i4;
      int i2 = i6;
      int i1 = i5;
      int i3 = i7;
    } 
    Arrays.fill(this.d, null);
  }
  
  public void a(RecyclerView.p paramp, RecyclerView.u paramu, View paramView, c paramc) {
    int m;
    boolean bool;
    int k;
    int j;
    byte b2;
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (!(layoutParams instanceof b)) {
      a(paramView, paramc);
      return;
    } 
    b b1 = (b)layoutParams;
    int i = a(paramp, paramu, b1.f());
    if (this.i == 0) {
      int n = b1.a();
      b2 = b1.b();
      k = 1;
      if (this.b > 1 && b1.b() == this.b) {
        bool = true;
      } else {
        bool = false;
      } 
      m = n;
      j = i;
    } else {
      b2 = 1;
      j = b1.a();
      k = b1.b();
      if (this.b > 1 && b1.b() == this.b) {
        bool = true;
      } else {
        bool = false;
      } 
      m = i;
    } 
    paramc.b(c.b.a(m, b2, j, k, bool, false));
  }
  
  public void a(RecyclerView.u paramu) {
    super.a(paramu);
    this.a = false;
  }
  
  void a(RecyclerView.u paramu, LinearLayoutManager.c paramc, RecyclerView.i.a parama) {
    int i = this.b;
    for (byte b1 = 0; b1 < this.b && paramc.a(paramu) && i > 0; b1++) {
      int j = paramc.d;
      parama.b(j, Math.max(0, paramc.g));
      i -= this.g.a(j);
      paramc.d += paramc.e;
    } 
  }
  
  public void a(RecyclerView paramRecyclerView) { this.g.a(); }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) { this.g.a(); }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) { this.g.a(); }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) { this.g.a(); }
  
  public void a(boolean paramBoolean) {
    if (!paramBoolean) {
      super.a(false);
      return;
    } 
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public boolean a(RecyclerView.j paramj) { return paramj instanceof b; }
  
  public int b(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) {
    M();
    N();
    return super.b(paramInt, paramp, paramu);
  }
  
  public int b(RecyclerView.p paramp, RecyclerView.u paramu) { return (this.i == 1) ? this.b : ((paramu.e() < 1) ? 0 : (1 + a(paramp, paramu, paramu.e() - 1))); }
  
  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) { this.g.a(); }
  
  public boolean b() { return (this.n == null && !this.a); }
  
  public void c(RecyclerView.p paramp, RecyclerView.u paramu) {
    if (paramu.a())
      L(); 
    super.c(paramp, paramu);
    K();
  }
  
  public static final class a extends c {
    public int a(int param1Int) { return 1; }
    
    public int a(int param1Int1, int param1Int2) { return param1Int1 % param1Int2; }
  }
  
  public static class b extends RecyclerView.j {
    int a = -1;
    
    int b = 0;
    
    public b(int param1Int1, int param1Int2) { super(param1Int1, param1Int2); }
    
    public b(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    public b(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public b(ViewGroup.MarginLayoutParams param1MarginLayoutParams) { super(param1MarginLayoutParams); }
    
    public int a() { return this.a; }
    
    public int b() { return this.b; }
  }
  
  public static abstract class c {
    final SparseIntArray a = new SparseIntArray();
    
    private boolean b = false;
    
    public abstract int a(int param1Int);
    
    public int a(int param1Int1, int param1Int2) { // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual a : (I)I
      //   5: istore_3
      //   6: iload_3
      //   7: iload_2
      //   8: if_icmpne -> 13
      //   11: iconst_0
      //   12: ireturn
      //   13: aload_0
      //   14: getfield b : Z
      //   17: ifeq -> 63
      //   20: aload_0
      //   21: getfield a : Landroid/util/SparseIntArray;
      //   24: invokevirtual size : ()I
      //   27: ifle -> 63
      //   30: aload_0
      //   31: iload_1
      //   32: invokevirtual b : (I)I
      //   35: istore #4
      //   37: iload #4
      //   39: iflt -> 63
      //   42: aload_0
      //   43: getfield a : Landroid/util/SparseIntArray;
      //   46: iload #4
      //   48: invokevirtual get : (I)I
      //   51: aload_0
      //   52: iload #4
      //   54: invokevirtual a : (I)I
      //   57: iadd
      //   58: istore #5
      //   60: goto -> 112
      //   63: iconst_0
      //   64: istore #4
      //   66: iconst_0
      //   67: istore #5
      //   69: iload #4
      //   71: iload_1
      //   72: if_icmpge -> 118
      //   75: aload_0
      //   76: iload #4
      //   78: invokevirtual a : (I)I
      //   81: istore #6
      //   83: iload #5
      //   85: iload #6
      //   87: iadd
      //   88: istore #5
      //   90: iload #5
      //   92: iload_2
      //   93: if_icmpne -> 102
      //   96: iconst_0
      //   97: istore #5
      //   99: goto -> 112
      //   102: iload #5
      //   104: iload_2
      //   105: if_icmple -> 112
      //   108: iload #6
      //   110: istore #5
      //   112: iinc #4, 1
      //   115: goto -> 69
      //   118: iload_3
      //   119: iload #5
      //   121: iadd
      //   122: iload_2
      //   123: if_icmpgt -> 129
      //   126: iload #5
      //   128: ireturn
      //   129: iconst_0
      //   130: ireturn }
    
    public void a() { this.a.clear(); }
    
    int b(int param1Int) {
      int i = -1 + this.a.size();
      int j = 0;
      while (j <= i) {
        int m = j + i >>> 1;
        if (this.a.keyAt(m) < param1Int) {
          j = m + 1;
          continue;
        } 
        i = m - 1;
      } 
      int k = j - 1;
      return (k >= 0 && k < this.a.size()) ? this.a.keyAt(k) : -1;
    }
    
    int b(int param1Int1, int param1Int2) {
      if (!this.b)
        return a(param1Int1, param1Int2); 
      int i = this.a.get(param1Int1, -1);
      if (i != -1)
        return i; 
      int j = a(param1Int1, param1Int2);
      this.a.put(param1Int1, j);
      return j;
    }
    
    public int c(int param1Int1, int param1Int2) {
      int i = a(param1Int1);
      byte b1 = 0;
      int j = 0;
      byte b2 = 0;
      while (b1 < param1Int1) {
        int k = a(b1);
        j += k;
        if (j == param1Int2) {
          b2++;
          j = 0;
        } else if (j > param1Int2) {
          b2++;
          j = k;
        } 
        b1++;
      } 
      if (j + i > param1Int2)
        b2++; 
      return b2;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */