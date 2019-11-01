package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.h.a.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.t.b {
  private d A;
  
  private int B;
  
  private final Rect C = new Rect();
  
  private final a D = new a(this);
  
  private boolean E = false;
  
  private boolean F = true;
  
  private int[] G;
  
  private final Runnable H = new Runnable(this) {
      public void run() { this.a.g(); }
    };
  
  e[] a;
  
  ax b;
  
  ax c;
  
  boolean d = false;
  
  boolean e = false;
  
  int f = -1;
  
  int g = Integer.MIN_VALUE;
  
  c h = new c();
  
  private int i = -1;
  
  private int j;
  
  private int k;
  
  private final ar l;
  
  private BitSet m;
  
  private int n = 2;
  
  private boolean o;
  
  private boolean z;
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    RecyclerView.i.b b1 = a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(b1.a);
    a(b1.b);
    a(b1.c);
    this.l = new ar();
    M();
  }
  
  private void M() { this.c = (this.b = ax.a(this, this.j)).a(this, 1 - this.j); }
  
  private void N() {
    boolean bool;
    if (this.j == 1 || !j()) {
      bool = this.d;
    } else {
      bool = true ^ this.d;
    } 
    this.e = bool;
  }
  
  private void O() {
    if (this.c.h() == 1073741824)
      return; 
    int i1 = v();
    byte b1 = 0;
    float f1 = 0.0F;
    while (b1 < i1) {
      View view = i(b1);
      float f2 = this.c.e(view);
      if (f2 >= f1) {
        if (((b)view.getLayoutParams()).a())
          f2 = f2 * 1.0F / this.i; 
        f1 = Math.max(f1, f2);
      } 
      b1++;
    } 
    int i2 = this.k;
    int i3 = Math.round(f1 * this.i);
    if (this.c.h() == Integer.MIN_VALUE)
      i3 = Math.min(i3, this.c.f()); 
    f(i3);
    int i4 = this.k;
    byte b2 = 0;
    if (i4 == i2)
      return; 
    while (b2 < i1) {
      int i6;
      int i5;
      View view = i(b2);
      b b3 = (b)view.getLayoutParams();
      if (b3.b)
        continue; 
      if (j() && this.j == 1) {
        i5 = -(this.i - 1 - b3.a.e) * this.k;
        i6 = i2 * -(this.i - 1 - b3.a.e);
      } else {
        i5 = b3.a.e * this.k;
        i6 = i2 * b3.a.e;
        if (this.j != 1) {
          view.offsetTopAndBottom(i5 - i6);
          continue;
        } 
      } 
      view.offsetLeftAndRight(i5 - i6);
      continue;
      b2++;
    } 
  }
  
  private int a(RecyclerView.p paramp, ar paramar, RecyclerView.u paramu) { // Byte code:
    //   0: aload_0
    //   1: getfield m : Ljava/util/BitSet;
    //   4: iconst_0
    //   5: aload_0
    //   6: getfield i : I
    //   9: iconst_1
    //   10: invokevirtual set : (IIZ)V
    //   13: aload_0
    //   14: getfield l : Landroid/support/v7/widget/ar;
    //   17: getfield i : Z
    //   20: ifeq -> 45
    //   23: aload_2
    //   24: getfield e : I
    //   27: iconst_1
    //   28: if_icmpne -> 38
    //   31: ldc 2147483647
    //   33: istore #5
    //   35: goto -> 82
    //   38: ldc -2147483648
    //   40: istore #5
    //   42: goto -> 82
    //   45: aload_2
    //   46: getfield e : I
    //   49: iconst_1
    //   50: if_icmpne -> 67
    //   53: aload_2
    //   54: getfield g : I
    //   57: aload_2
    //   58: getfield b : I
    //   61: iadd
    //   62: istore #4
    //   64: goto -> 78
    //   67: aload_2
    //   68: getfield f : I
    //   71: aload_2
    //   72: getfield b : I
    //   75: isub
    //   76: istore #4
    //   78: iload #4
    //   80: istore #5
    //   82: aload_0
    //   83: aload_2
    //   84: getfield e : I
    //   87: iload #5
    //   89: invokespecial a : (II)V
    //   92: aload_0
    //   93: getfield e : Z
    //   96: ifeq -> 111
    //   99: aload_0
    //   100: getfield b : Landroid/support/v7/widget/ax;
    //   103: invokevirtual d : ()I
    //   106: istore #6
    //   108: goto -> 120
    //   111: aload_0
    //   112: getfield b : Landroid/support/v7/widget/ax;
    //   115: invokevirtual c : ()I
    //   118: istore #6
    //   120: iload #6
    //   122: istore #7
    //   124: iconst_0
    //   125: istore #8
    //   127: aload_2
    //   128: aload_3
    //   129: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$u;)Z
    //   132: ifeq -> 908
    //   135: aload_0
    //   136: getfield l : Landroid/support/v7/widget/ar;
    //   139: getfield i : Z
    //   142: ifne -> 155
    //   145: aload_0
    //   146: getfield m : Ljava/util/BitSet;
    //   149: invokevirtual isEmpty : ()Z
    //   152: ifne -> 908
    //   155: aload_2
    //   156: aload_1
    //   157: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$p;)Landroid/view/View;
    //   160: astore #12
    //   162: aload #12
    //   164: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   167: checkcast android/support/v7/widget/StaggeredGridLayoutManager$b
    //   170: astore #13
    //   172: aload #13
    //   174: invokevirtual f : ()I
    //   177: istore #14
    //   179: aload_0
    //   180: getfield h : Landroid/support/v7/widget/StaggeredGridLayoutManager$c;
    //   183: iload #14
    //   185: invokevirtual c : (I)I
    //   188: istore #15
    //   190: iload #15
    //   192: iconst_m1
    //   193: if_icmpne -> 202
    //   196: iconst_1
    //   197: istore #16
    //   199: goto -> 205
    //   202: iconst_0
    //   203: istore #16
    //   205: iload #16
    //   207: ifeq -> 250
    //   210: aload #13
    //   212: getfield b : Z
    //   215: ifeq -> 229
    //   218: aload_0
    //   219: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   222: iconst_0
    //   223: aaload
    //   224: astore #17
    //   226: goto -> 236
    //   229: aload_0
    //   230: aload_2
    //   231: invokespecial a : (Landroid/support/v7/widget/ar;)Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   234: astore #17
    //   236: aload_0
    //   237: getfield h : Landroid/support/v7/widget/StaggeredGridLayoutManager$c;
    //   240: iload #14
    //   242: aload #17
    //   244: invokevirtual a : (ILandroid/support/v7/widget/StaggeredGridLayoutManager$e;)V
    //   247: goto -> 259
    //   250: aload_0
    //   251: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   254: iload #15
    //   256: aaload
    //   257: astore #17
    //   259: aload #17
    //   261: astore #18
    //   263: aload #13
    //   265: aload #18
    //   267: putfield a : Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   270: aload_2
    //   271: getfield e : I
    //   274: iconst_1
    //   275: if_icmpne -> 287
    //   278: aload_0
    //   279: aload #12
    //   281: invokevirtual b : (Landroid/view/View;)V
    //   284: goto -> 294
    //   287: aload_0
    //   288: aload #12
    //   290: iconst_0
    //   291: invokevirtual b : (Landroid/view/View;I)V
    //   294: aload_0
    //   295: aload #12
    //   297: aload #13
    //   299: iconst_0
    //   300: invokespecial a : (Landroid/view/View;Landroid/support/v7/widget/StaggeredGridLayoutManager$b;Z)V
    //   303: aload_2
    //   304: getfield e : I
    //   307: iconst_1
    //   308: if_icmpne -> 407
    //   311: aload #13
    //   313: getfield b : Z
    //   316: ifeq -> 330
    //   319: aload_0
    //   320: iload #7
    //   322: invokespecial r : (I)I
    //   325: istore #35
    //   327: goto -> 339
    //   330: aload #18
    //   332: iload #7
    //   334: invokevirtual b : (I)I
    //   337: istore #35
    //   339: iload #35
    //   341: aload_0
    //   342: getfield b : Landroid/support/v7/widget/ax;
    //   345: aload #12
    //   347: invokevirtual e : (Landroid/view/View;)I
    //   350: iadd
    //   351: istore #36
    //   353: iload #16
    //   355: ifeq -> 396
    //   358: aload #13
    //   360: getfield b : Z
    //   363: ifeq -> 396
    //   366: aload_0
    //   367: iload #35
    //   369: invokespecial n : (I)Landroid/support/v7/widget/StaggeredGridLayoutManager$c$a;
    //   372: astore #37
    //   374: aload #37
    //   376: iconst_m1
    //   377: putfield b : I
    //   380: aload #37
    //   382: iload #14
    //   384: putfield a : I
    //   387: aload_0
    //   388: getfield h : Landroid/support/v7/widget/StaggeredGridLayoutManager$c;
    //   391: aload #37
    //   393: invokevirtual a : (Landroid/support/v7/widget/StaggeredGridLayoutManager$c$a;)V
    //   396: iload #36
    //   398: istore #21
    //   400: iload #35
    //   402: istore #20
    //   404: goto -> 496
    //   407: aload #13
    //   409: getfield b : Z
    //   412: ifeq -> 426
    //   415: aload_0
    //   416: iload #7
    //   418: invokespecial q : (I)I
    //   421: istore #19
    //   423: goto -> 435
    //   426: aload #18
    //   428: iload #7
    //   430: invokevirtual a : (I)I
    //   433: istore #19
    //   435: iload #19
    //   437: aload_0
    //   438: getfield b : Landroid/support/v7/widget/ax;
    //   441: aload #12
    //   443: invokevirtual e : (Landroid/view/View;)I
    //   446: isub
    //   447: istore #20
    //   449: iload #16
    //   451: ifeq -> 492
    //   454: aload #13
    //   456: getfield b : Z
    //   459: ifeq -> 492
    //   462: aload_0
    //   463: iload #19
    //   465: invokespecial o : (I)Landroid/support/v7/widget/StaggeredGridLayoutManager$c$a;
    //   468: astore #34
    //   470: aload #34
    //   472: iconst_1
    //   473: putfield b : I
    //   476: aload #34
    //   478: iload #14
    //   480: putfield a : I
    //   483: aload_0
    //   484: getfield h : Landroid/support/v7/widget/StaggeredGridLayoutManager$c;
    //   487: aload #34
    //   489: invokevirtual a : (Landroid/support/v7/widget/StaggeredGridLayoutManager$c$a;)V
    //   492: iload #19
    //   494: istore #21
    //   496: aload #13
    //   498: getfield b : Z
    //   501: ifeq -> 580
    //   504: aload_2
    //   505: getfield d : I
    //   508: iconst_m1
    //   509: if_icmpne -> 580
    //   512: iload #16
    //   514: ifeq -> 525
    //   517: aload_0
    //   518: iconst_1
    //   519: putfield E : Z
    //   522: goto -> 580
    //   525: aload_2
    //   526: getfield e : I
    //   529: iconst_1
    //   530: if_icmpne -> 542
    //   533: aload_0
    //   534: invokevirtual m : ()Z
    //   537: istore #32
    //   539: goto -> 548
    //   542: aload_0
    //   543: invokevirtual n : ()Z
    //   546: istore #32
    //   548: iload #32
    //   550: iconst_1
    //   551: ixor
    //   552: ifeq -> 580
    //   555: aload_0
    //   556: getfield h : Landroid/support/v7/widget/StaggeredGridLayoutManager$c;
    //   559: iload #14
    //   561: invokevirtual f : (I)Landroid/support/v7/widget/StaggeredGridLayoutManager$c$a;
    //   564: astore #33
    //   566: aload #33
    //   568: ifnull -> 517
    //   571: aload #33
    //   573: iconst_1
    //   574: putfield d : Z
    //   577: goto -> 517
    //   580: aload_0
    //   581: aload #12
    //   583: aload #13
    //   585: aload_2
    //   586: invokespecial a : (Landroid/view/View;Landroid/support/v7/widget/StaggeredGridLayoutManager$b;Landroid/support/v7/widget/ar;)V
    //   589: aload_0
    //   590: invokevirtual j : ()Z
    //   593: ifeq -> 676
    //   596: aload_0
    //   597: getfield j : I
    //   600: iconst_1
    //   601: if_icmpne -> 676
    //   604: aload #13
    //   606: getfield b : Z
    //   609: ifeq -> 624
    //   612: aload_0
    //   613: getfield c : Landroid/support/v7/widget/ax;
    //   616: invokevirtual d : ()I
    //   619: istore #30
    //   621: goto -> 651
    //   624: aload_0
    //   625: getfield c : Landroid/support/v7/widget/ax;
    //   628: invokevirtual d : ()I
    //   631: aload_0
    //   632: getfield i : I
    //   635: iconst_1
    //   636: isub
    //   637: aload #18
    //   639: getfield e : I
    //   642: isub
    //   643: aload_0
    //   644: getfield k : I
    //   647: imul
    //   648: isub
    //   649: istore #30
    //   651: iload #30
    //   653: aload_0
    //   654: getfield c : Landroid/support/v7/widget/ax;
    //   657: aload #12
    //   659: invokevirtual e : (Landroid/view/View;)I
    //   662: isub
    //   663: istore #31
    //   665: iload #30
    //   667: istore #25
    //   669: iload #31
    //   671: istore #24
    //   673: goto -> 738
    //   676: aload #13
    //   678: getfield b : Z
    //   681: ifeq -> 696
    //   684: aload_0
    //   685: getfield c : Landroid/support/v7/widget/ax;
    //   688: invokevirtual c : ()I
    //   691: istore #22
    //   693: goto -> 716
    //   696: aload #18
    //   698: getfield e : I
    //   701: aload_0
    //   702: getfield k : I
    //   705: imul
    //   706: aload_0
    //   707: getfield c : Landroid/support/v7/widget/ax;
    //   710: invokevirtual c : ()I
    //   713: iadd
    //   714: istore #22
    //   716: iload #22
    //   718: aload_0
    //   719: getfield c : Landroid/support/v7/widget/ax;
    //   722: aload #12
    //   724: invokevirtual e : (Landroid/view/View;)I
    //   727: iadd
    //   728: istore #23
    //   730: iload #22
    //   732: istore #24
    //   734: iload #23
    //   736: istore #25
    //   738: aload_0
    //   739: getfield j : I
    //   742: iconst_1
    //   743: if_icmpne -> 768
    //   746: aload_0
    //   747: astore #26
    //   749: aload #12
    //   751: astore #27
    //   753: iload #24
    //   755: istore #28
    //   757: iload #20
    //   759: istore #24
    //   761: iload #25
    //   763: istore #29
    //   765: goto -> 787
    //   768: aload_0
    //   769: astore #26
    //   771: aload #12
    //   773: astore #27
    //   775: iload #20
    //   777: istore #28
    //   779: iload #21
    //   781: istore #29
    //   783: iload #25
    //   785: istore #21
    //   787: aload #26
    //   789: aload #27
    //   791: iload #28
    //   793: iload #24
    //   795: iload #29
    //   797: iload #21
    //   799: invokevirtual a : (Landroid/view/View;IIII)V
    //   802: aload #13
    //   804: getfield b : Z
    //   807: ifeq -> 826
    //   810: aload_0
    //   811: aload_0
    //   812: getfield l : Landroid/support/v7/widget/ar;
    //   815: getfield e : I
    //   818: iload #5
    //   820: invokespecial a : (II)V
    //   823: goto -> 841
    //   826: aload_0
    //   827: aload #18
    //   829: aload_0
    //   830: getfield l : Landroid/support/v7/widget/ar;
    //   833: getfield e : I
    //   836: iload #5
    //   838: invokespecial a : (Landroid/support/v7/widget/StaggeredGridLayoutManager$e;II)V
    //   841: aload_0
    //   842: aload_1
    //   843: aload_0
    //   844: getfield l : Landroid/support/v7/widget/ar;
    //   847: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/ar;)V
    //   850: aload_0
    //   851: getfield l : Landroid/support/v7/widget/ar;
    //   854: getfield h : Z
    //   857: ifeq -> 902
    //   860: aload #12
    //   862: invokevirtual hasFocusable : ()Z
    //   865: ifeq -> 902
    //   868: aload #13
    //   870: getfield b : Z
    //   873: ifeq -> 886
    //   876: aload_0
    //   877: getfield m : Ljava/util/BitSet;
    //   880: invokevirtual clear : ()V
    //   883: goto -> 902
    //   886: aload_0
    //   887: getfield m : Ljava/util/BitSet;
    //   890: aload #18
    //   892: getfield e : I
    //   895: iconst_0
    //   896: invokevirtual set : (IZ)V
    //   899: goto -> 902
    //   902: iconst_1
    //   903: istore #8
    //   905: goto -> 127
    //   908: iload #8
    //   910: ifne -> 922
    //   913: aload_0
    //   914: aload_1
    //   915: aload_0
    //   916: getfield l : Landroid/support/v7/widget/ar;
    //   919: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/ar;)V
    //   922: aload_0
    //   923: getfield l : Landroid/support/v7/widget/ar;
    //   926: getfield e : I
    //   929: iconst_m1
    //   930: if_icmpne -> 961
    //   933: aload_0
    //   934: aload_0
    //   935: getfield b : Landroid/support/v7/widget/ax;
    //   938: invokevirtual c : ()I
    //   941: invokespecial q : (I)I
    //   944: istore #11
    //   946: aload_0
    //   947: getfield b : Landroid/support/v7/widget/ax;
    //   950: invokevirtual c : ()I
    //   953: iload #11
    //   955: isub
    //   956: istore #9
    //   958: goto -> 982
    //   961: aload_0
    //   962: aload_0
    //   963: getfield b : Landroid/support/v7/widget/ax;
    //   966: invokevirtual d : ()I
    //   969: invokespecial r : (I)I
    //   972: aload_0
    //   973: getfield b : Landroid/support/v7/widget/ax;
    //   976: invokevirtual d : ()I
    //   979: isub
    //   980: istore #9
    //   982: iconst_0
    //   983: istore #10
    //   985: iload #9
    //   987: ifle -> 1001
    //   990: aload_2
    //   991: getfield b : I
    //   994: iload #9
    //   996: invokestatic min : (II)I
    //   999: istore #10
    //   1001: iload #10
    //   1003: ireturn }
  
  private e a(ar paramar) {
    byte b2;
    byte b1;
    boolean bool = t(paramar.e);
    int i1 = -1;
    if (bool) {
      b1 = this.i - 1;
      b2 = -1;
    } else {
      b1 = 0;
      i1 = this.i;
      b2 = 1;
    } 
    int i2 = paramar.e;
    e e1 = null;
    if (i2 == 1) {
      int i5 = Integer.MAX_VALUE;
      int i6 = this.b.c();
      while (b1 != i1) {
        e e2 = this.a[b1];
        int i7 = e2.b(i6);
        if (i7 < i5) {
          e1 = e2;
          i5 = i7;
        } 
        b1 += b2;
      } 
      return e1;
    } 
    int i3 = Integer.MIN_VALUE;
    int i4 = this.b.d();
    while (b1 != i1) {
      e e2 = this.a[b1];
      int i5 = e2.a(i4);
      if (i5 > i3) {
        e1 = e2;
        i3 = i5;
      } 
      b1 += b2;
    } 
    return e1;
  }
  
  private void a(int paramInt1, int paramInt2) {
    for (byte b1 = 0; b1 < this.i; b1++) {
      if (!(this.a[b1]).a.isEmpty())
        a(this.a[b1], paramInt1, paramInt2); 
    } 
  }
  
  private void a(RecyclerView.p paramp, int paramInt) {
    while (v() > 0) {
      View view = i(0);
      if (this.b.b(view) <= paramInt && this.b.c(view) <= paramInt) {
        b b1 = (b)view.getLayoutParams();
        if (b1.b) {
          byte b3;
          byte b2 = 0;
          while (true) {
            int i1 = this.i;
            b3 = 0;
            if (b2 < i1) {
              if ((this.a[b2]).a.size() == 1)
                return; 
              b2++;
              continue;
            } 
            break;
          } 
          while (b3 < this.i) {
            this.a[b3].h();
            b3++;
          } 
        } else {
          if (b1.a.a.size() == 1)
            return; 
          b1.a.h();
        } 
        a(view, paramp);
      } 
    } 
  }
  
  private void a(RecyclerView.p paramp, RecyclerView.u paramu, boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: getfield D : Landroid/support/v7/widget/StaggeredGridLayoutManager$a;
    //   4: astore #4
    //   6: aload_0
    //   7: getfield A : Landroid/support/v7/widget/StaggeredGridLayoutManager$d;
    //   10: ifnonnull -> 21
    //   13: aload_0
    //   14: getfield f : I
    //   17: iconst_m1
    //   18: if_icmpeq -> 39
    //   21: aload_2
    //   22: invokevirtual e : ()I
    //   25: ifne -> 39
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual c : (Landroid/support/v7/widget/RecyclerView$p;)V
    //   33: aload #4
    //   35: invokevirtual a : ()V
    //   38: return
    //   39: aload #4
    //   41: getfield e : Z
    //   44: istore #5
    //   46: iconst_1
    //   47: istore #6
    //   49: iload #5
    //   51: ifeq -> 78
    //   54: aload_0
    //   55: getfield f : I
    //   58: iconst_m1
    //   59: if_icmpne -> 78
    //   62: aload_0
    //   63: getfield A : Landroid/support/v7/widget/StaggeredGridLayoutManager$d;
    //   66: ifnull -> 72
    //   69: goto -> 78
    //   72: iconst_0
    //   73: istore #7
    //   75: goto -> 81
    //   78: iconst_1
    //   79: istore #7
    //   81: iload #7
    //   83: ifeq -> 134
    //   86: aload #4
    //   88: invokevirtual a : ()V
    //   91: aload_0
    //   92: getfield A : Landroid/support/v7/widget/StaggeredGridLayoutManager$d;
    //   95: ifnull -> 107
    //   98: aload_0
    //   99: aload #4
    //   101: invokespecial a : (Landroid/support/v7/widget/StaggeredGridLayoutManager$a;)V
    //   104: goto -> 120
    //   107: aload_0
    //   108: invokespecial N : ()V
    //   111: aload #4
    //   113: aload_0
    //   114: getfield e : Z
    //   117: putfield c : Z
    //   120: aload_0
    //   121: aload_2
    //   122: aload #4
    //   124: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$u;Landroid/support/v7/widget/StaggeredGridLayoutManager$a;)V
    //   127: aload #4
    //   129: iload #6
    //   131: putfield e : Z
    //   134: aload_0
    //   135: getfield A : Landroid/support/v7/widget/StaggeredGridLayoutManager$d;
    //   138: ifnonnull -> 186
    //   141: aload_0
    //   142: getfield f : I
    //   145: iconst_m1
    //   146: if_icmpne -> 186
    //   149: aload #4
    //   151: getfield c : Z
    //   154: aload_0
    //   155: getfield o : Z
    //   158: if_icmpne -> 172
    //   161: aload_0
    //   162: invokevirtual j : ()Z
    //   165: aload_0
    //   166: getfield z : Z
    //   169: if_icmpeq -> 186
    //   172: aload_0
    //   173: getfield h : Landroid/support/v7/widget/StaggeredGridLayoutManager$c;
    //   176: invokevirtual a : ()V
    //   179: aload #4
    //   181: iload #6
    //   183: putfield d : Z
    //   186: aload_0
    //   187: invokevirtual v : ()I
    //   190: ifle -> 388
    //   193: aload_0
    //   194: getfield A : Landroid/support/v7/widget/StaggeredGridLayoutManager$d;
    //   197: astore #13
    //   199: aload #13
    //   201: ifnull -> 214
    //   204: aload #13
    //   206: getfield c : I
    //   209: iload #6
    //   211: if_icmpge -> 388
    //   214: aload #4
    //   216: getfield d : Z
    //   219: ifeq -> 275
    //   222: iconst_0
    //   223: istore #17
    //   225: iload #17
    //   227: aload_0
    //   228: getfield i : I
    //   231: if_icmpge -> 388
    //   234: aload_0
    //   235: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   238: iload #17
    //   240: aaload
    //   241: invokevirtual e : ()V
    //   244: aload #4
    //   246: getfield b : I
    //   249: ldc -2147483648
    //   251: if_icmpeq -> 269
    //   254: aload_0
    //   255: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   258: iload #17
    //   260: aaload
    //   261: aload #4
    //   263: getfield b : I
    //   266: invokevirtual c : (I)V
    //   269: iinc #17, 1
    //   272: goto -> 225
    //   275: iload #7
    //   277: ifne -> 340
    //   280: aload_0
    //   281: getfield D : Landroid/support/v7/widget/StaggeredGridLayoutManager$a;
    //   284: getfield f : [I
    //   287: ifnonnull -> 293
    //   290: goto -> 340
    //   293: iconst_0
    //   294: istore #15
    //   296: iload #15
    //   298: aload_0
    //   299: getfield i : I
    //   302: if_icmpge -> 388
    //   305: aload_0
    //   306: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   309: iload #15
    //   311: aaload
    //   312: astore #16
    //   314: aload #16
    //   316: invokevirtual e : ()V
    //   319: aload #16
    //   321: aload_0
    //   322: getfield D : Landroid/support/v7/widget/StaggeredGridLayoutManager$a;
    //   325: getfield f : [I
    //   328: iload #15
    //   330: iaload
    //   331: invokevirtual c : (I)V
    //   334: iinc #15, 1
    //   337: goto -> 296
    //   340: iconst_0
    //   341: istore #14
    //   343: iload #14
    //   345: aload_0
    //   346: getfield i : I
    //   349: if_icmpge -> 377
    //   352: aload_0
    //   353: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   356: iload #14
    //   358: aaload
    //   359: aload_0
    //   360: getfield e : Z
    //   363: aload #4
    //   365: getfield b : I
    //   368: invokevirtual a : (ZI)V
    //   371: iinc #14, 1
    //   374: goto -> 343
    //   377: aload_0
    //   378: getfield D : Landroid/support/v7/widget/StaggeredGridLayoutManager$a;
    //   381: aload_0
    //   382: getfield a : [Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   385: invokevirtual a : ([Landroid/support/v7/widget/StaggeredGridLayoutManager$e;)V
    //   388: aload_0
    //   389: aload_1
    //   390: invokevirtual a : (Landroid/support/v7/widget/RecyclerView$p;)V
    //   393: aload_0
    //   394: getfield l : Landroid/support/v7/widget/ar;
    //   397: iconst_0
    //   398: putfield a : Z
    //   401: aload_0
    //   402: iconst_0
    //   403: putfield E : Z
    //   406: aload_0
    //   407: aload_0
    //   408: getfield c : Landroid/support/v7/widget/ax;
    //   411: invokevirtual f : ()I
    //   414: invokevirtual f : (I)V
    //   417: aload_0
    //   418: aload #4
    //   420: getfield a : I
    //   423: aload_2
    //   424: invokespecial b : (ILandroid/support/v7/widget/RecyclerView$u;)V
    //   427: aload #4
    //   429: getfield c : Z
    //   432: ifeq -> 460
    //   435: aload_0
    //   436: iconst_m1
    //   437: invokespecial m : (I)V
    //   440: aload_0
    //   441: aload_1
    //   442: aload_0
    //   443: getfield l : Landroid/support/v7/widget/ar;
    //   446: aload_2
    //   447: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/ar;Landroid/support/v7/widget/RecyclerView$u;)I
    //   450: pop
    //   451: aload_0
    //   452: iload #6
    //   454: invokespecial m : (I)V
    //   457: goto -> 482
    //   460: aload_0
    //   461: iload #6
    //   463: invokespecial m : (I)V
    //   466: aload_0
    //   467: aload_1
    //   468: aload_0
    //   469: getfield l : Landroid/support/v7/widget/ar;
    //   472: aload_2
    //   473: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/ar;Landroid/support/v7/widget/RecyclerView$u;)I
    //   476: pop
    //   477: aload_0
    //   478: iconst_m1
    //   479: invokespecial m : (I)V
    //   482: aload_0
    //   483: getfield l : Landroid/support/v7/widget/ar;
    //   486: aload #4
    //   488: getfield a : I
    //   491: aload_0
    //   492: getfield l : Landroid/support/v7/widget/ar;
    //   495: getfield d : I
    //   498: iadd
    //   499: putfield c : I
    //   502: aload_0
    //   503: aload_1
    //   504: aload_0
    //   505: getfield l : Landroid/support/v7/widget/ar;
    //   508: aload_2
    //   509: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/ar;Landroid/support/v7/widget/RecyclerView$u;)I
    //   512: pop
    //   513: aload_0
    //   514: invokespecial O : ()V
    //   517: aload_0
    //   518: invokevirtual v : ()I
    //   521: ifle -> 564
    //   524: aload_0
    //   525: getfield e : Z
    //   528: ifeq -> 549
    //   531: aload_0
    //   532: aload_1
    //   533: aload_2
    //   534: iload #6
    //   536: invokespecial b : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;Z)V
    //   539: aload_0
    //   540: aload_1
    //   541: aload_2
    //   542: iconst_0
    //   543: invokespecial c : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;Z)V
    //   546: goto -> 564
    //   549: aload_0
    //   550: aload_1
    //   551: aload_2
    //   552: iload #6
    //   554: invokespecial c : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;Z)V
    //   557: aload_0
    //   558: aload_1
    //   559: aload_2
    //   560: iconst_0
    //   561: invokespecial b : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;Z)V
    //   564: iload_3
    //   565: ifeq -> 636
    //   568: aload_2
    //   569: invokevirtual a : ()Z
    //   572: ifne -> 636
    //   575: aload_0
    //   576: getfield n : I
    //   579: ifeq -> 609
    //   582: aload_0
    //   583: invokevirtual v : ()I
    //   586: ifle -> 609
    //   589: aload_0
    //   590: getfield E : Z
    //   593: ifne -> 603
    //   596: aload_0
    //   597: invokevirtual h : ()Landroid/view/View;
    //   600: ifnull -> 609
    //   603: iconst_1
    //   604: istore #10
    //   606: goto -> 612
    //   609: iconst_0
    //   610: istore #10
    //   612: iload #10
    //   614: ifeq -> 636
    //   617: aload_0
    //   618: aload_0
    //   619: getfield H : Ljava/lang/Runnable;
    //   622: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   625: pop
    //   626: aload_0
    //   627: invokevirtual g : ()Z
    //   630: ifeq -> 636
    //   633: goto -> 639
    //   636: iconst_0
    //   637: istore #6
    //   639: aload_2
    //   640: invokevirtual a : ()Z
    //   643: ifeq -> 653
    //   646: aload_0
    //   647: getfield D : Landroid/support/v7/widget/StaggeredGridLayoutManager$a;
    //   650: invokevirtual a : ()V
    //   653: aload_0
    //   654: aload #4
    //   656: getfield c : Z
    //   659: putfield o : Z
    //   662: aload_0
    //   663: aload_0
    //   664: invokevirtual j : ()Z
    //   667: putfield z : Z
    //   670: iload #6
    //   672: ifeq -> 689
    //   675: aload_0
    //   676: getfield D : Landroid/support/v7/widget/StaggeredGridLayoutManager$a;
    //   679: invokevirtual a : ()V
    //   682: aload_0
    //   683: aload_1
    //   684: aload_2
    //   685: iconst_0
    //   686: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;Landroid/support/v7/widget/RecyclerView$u;Z)V
    //   689: return }
  
  private void a(RecyclerView.p paramp, ar paramar) { // Byte code:
    //   0: aload_2
    //   1: getfield a : Z
    //   4: ifeq -> 147
    //   7: aload_2
    //   8: getfield i : Z
    //   11: ifeq -> 15
    //   14: return
    //   15: aload_2
    //   16: getfield b : I
    //   19: ifne -> 58
    //   22: aload_2
    //   23: getfield e : I
    //   26: iconst_m1
    //   27: if_icmpne -> 44
    //   30: aload_2
    //   31: getfield g : I
    //   34: istore #6
    //   36: aload_0
    //   37: aload_1
    //   38: iload #6
    //   40: invokespecial b : (Landroid/support/v7/widget/RecyclerView$p;I)V
    //   43: return
    //   44: aload_2
    //   45: getfield f : I
    //   48: istore #4
    //   50: aload_0
    //   51: aload_1
    //   52: iload #4
    //   54: invokespecial a : (Landroid/support/v7/widget/RecyclerView$p;I)V
    //   57: return
    //   58: aload_2
    //   59: getfield e : I
    //   62: iconst_m1
    //   63: if_icmpne -> 108
    //   66: aload_2
    //   67: getfield f : I
    //   70: aload_0
    //   71: aload_2
    //   72: getfield f : I
    //   75: invokespecial p : (I)I
    //   78: isub
    //   79: istore #5
    //   81: iload #5
    //   83: ifge -> 89
    //   86: goto -> 30
    //   89: aload_2
    //   90: getfield g : I
    //   93: iload #5
    //   95: aload_2
    //   96: getfield b : I
    //   99: invokestatic min : (II)I
    //   102: isub
    //   103: istore #6
    //   105: goto -> 36
    //   108: aload_0
    //   109: aload_2
    //   110: getfield g : I
    //   113: invokespecial s : (I)I
    //   116: aload_2
    //   117: getfield g : I
    //   120: isub
    //   121: istore_3
    //   122: iload_3
    //   123: ifge -> 129
    //   126: goto -> 44
    //   129: aload_2
    //   130: getfield f : I
    //   133: iload_3
    //   134: aload_2
    //   135: getfield b : I
    //   138: invokestatic min : (II)I
    //   141: iadd
    //   142: istore #4
    //   144: goto -> 50
    //   147: return }
  
  private void a(a parama) {
    boolean bool;
    if (this.A.c > 0)
      if (this.A.c == this.i) {
        for (byte b1 = 0; b1 < this.i; b1++) {
          this.a[b1].e();
          int i1 = this.A.d[b1];
          if (i1 != Integer.MIN_VALUE) {
            int i2;
            if (this.A.i) {
              i2 = this.b.d();
            } else {
              i2 = this.b.c();
            } 
            i1 += i2;
          } 
          this.a[b1].c(i1);
        } 
      } else {
        this.A.a();
        d d1 = this.A;
        d1.a = d1.b;
      }  
    this.z = this.A.j;
    a(this.A.h);
    N();
    if (this.A.a != -1) {
      this.f = this.A.a;
      bool = this.A.i;
    } else {
      bool = this.e;
    } 
    parama.c = bool;
    if (this.A.e > 1) {
      this.h.a = this.A.f;
      this.h.b = this.A.g;
    } 
  }
  
  private void a(e parame, int paramInt1, int paramInt2) {
    int i1 = parame.i();
    if ((paramInt1 == -1) ? (i1 + parame.b() <= paramInt2) : (parame.d() - i1 >= paramInt2))
      this.m.set(parame.e, false); 
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    boolean bool;
    b(paramView, this.C);
    b b1 = (b)paramView.getLayoutParams();
    int i1 = b(paramInt1, b1.leftMargin + this.C.left, b1.rightMargin + this.C.right);
    int i2 = b(paramInt2, b1.topMargin + this.C.top, b1.bottomMargin + this.C.bottom);
    if (paramBoolean) {
      bool = a(paramView, i1, i2, b1);
    } else {
      bool = b(paramView, i1, i2, b1);
    } 
    if (bool)
      paramView.measure(i1, i2); 
  }
  
  private void a(View paramView, b paramb, ar paramar) {
    if (paramar.e == 1) {
      if (paramb.b) {
        p(paramView);
        return;
      } 
      paramb.a.b(paramView);
      return;
    } 
    if (paramb.b) {
      q(paramView);
      return;
    } 
    paramb.a.a(paramView);
  }
  
  private void a(View paramView, b paramb, boolean paramBoolean) {
    int i1;
    if (paramb.b) {
      if (this.j == 1) {
        i1 = this.B;
      } else {
        a(paramView, a(y(), w(), A() + C(), paramb.width, true), this.B, paramBoolean);
        return;
      } 
    } else if (this.j == 1) {
      i1 = a(this.k, w(), 0, paramb.width, false);
    } else {
      i1 = a(y(), w(), A() + C(), paramb.width, true);
      int i3 = a(this.k, x(), 0, paramb.height, false);
      a(paramView, i1, i3, paramBoolean);
    } 
    int i2 = a(z(), x(), B() + D(), paramb.height, true);
    a(paramView, i1, i2, paramBoolean);
  }
  
  private boolean a(e parame) {
    if (this.e) {
      if (parame.d() < this.b.d())
        return true ^ (parame.c((View)parame.a.get(-1 + parame.a.size()))).b; 
    } else if (parame.b() > this.b.c()) {
      return true ^ (parame.c((View)parame.a.get(0))).b;
    } 
    return false;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == 0 && paramInt3 == 0)
      return paramInt1; 
    int i1 = View.MeasureSpec.getMode(paramInt1);
    return (i1 == Integer.MIN_VALUE || i1 == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i1) : paramInt1;
  }
  
  private int b(RecyclerView.u paramu) { return (v() == 0) ? 0 : bd.a(paramu, this.b, b(true ^ this.F), c(true ^ this.F), this, this.F, this.e); }
  
  private void b(int paramInt, RecyclerView.u paramu) { // Byte code:
    //   0: aload_0
    //   1: getfield l : Landroid/support/v7/widget/ar;
    //   4: astore_3
    //   5: aload_3
    //   6: iconst_0
    //   7: putfield b : I
    //   10: aload_3
    //   11: iload_1
    //   12: putfield c : I
    //   15: aload_0
    //   16: invokevirtual s : ()Z
    //   19: ifeq -> 89
    //   22: aload_2
    //   23: invokevirtual c : ()I
    //   26: istore #10
    //   28: iload #10
    //   30: iconst_m1
    //   31: if_icmpeq -> 89
    //   34: aload_0
    //   35: getfield e : Z
    //   38: istore #11
    //   40: iload #10
    //   42: iload_1
    //   43: if_icmpge -> 52
    //   46: iconst_1
    //   47: istore #12
    //   49: goto -> 55
    //   52: iconst_0
    //   53: istore #12
    //   55: iload #11
    //   57: iload #12
    //   59: if_icmpne -> 74
    //   62: aload_0
    //   63: getfield b : Landroid/support/v7/widget/ax;
    //   66: invokevirtual f : ()I
    //   69: istore #4
    //   71: goto -> 92
    //   74: aload_0
    //   75: getfield b : Landroid/support/v7/widget/ax;
    //   78: invokevirtual f : ()I
    //   81: istore #5
    //   83: iconst_0
    //   84: istore #4
    //   86: goto -> 95
    //   89: iconst_0
    //   90: istore #4
    //   92: iconst_0
    //   93: istore #5
    //   95: aload_0
    //   96: invokevirtual r : ()Z
    //   99: ifeq -> 139
    //   102: aload_0
    //   103: getfield l : Landroid/support/v7/widget/ar;
    //   106: aload_0
    //   107: getfield b : Landroid/support/v7/widget/ax;
    //   110: invokevirtual c : ()I
    //   113: iload #5
    //   115: isub
    //   116: putfield f : I
    //   119: aload_0
    //   120: getfield l : Landroid/support/v7/widget/ar;
    //   123: iload #4
    //   125: aload_0
    //   126: getfield b : Landroid/support/v7/widget/ax;
    //   129: invokevirtual d : ()I
    //   132: iadd
    //   133: putfield g : I
    //   136: goto -> 166
    //   139: aload_0
    //   140: getfield l : Landroid/support/v7/widget/ar;
    //   143: iload #4
    //   145: aload_0
    //   146: getfield b : Landroid/support/v7/widget/ax;
    //   149: invokevirtual e : ()I
    //   152: iadd
    //   153: putfield g : I
    //   156: aload_0
    //   157: getfield l : Landroid/support/v7/widget/ar;
    //   160: iload #5
    //   162: ineg
    //   163: putfield f : I
    //   166: aload_0
    //   167: getfield l : Landroid/support/v7/widget/ar;
    //   170: astore #6
    //   172: aload #6
    //   174: iconst_0
    //   175: putfield h : Z
    //   178: aload #6
    //   180: iconst_1
    //   181: putfield a : Z
    //   184: aload_0
    //   185: getfield b : Landroid/support/v7/widget/ax;
    //   188: invokevirtual h : ()I
    //   191: istore #7
    //   193: iconst_0
    //   194: istore #8
    //   196: iload #7
    //   198: ifne -> 221
    //   201: aload_0
    //   202: getfield b : Landroid/support/v7/widget/ax;
    //   205: invokevirtual e : ()I
    //   208: istore #9
    //   210: iconst_0
    //   211: istore #8
    //   213: iload #9
    //   215: ifne -> 221
    //   218: iconst_1
    //   219: istore #8
    //   221: aload #6
    //   223: iload #8
    //   225: putfield i : Z
    //   228: return }
  
  private void b(RecyclerView.p paramp, int paramInt) {
    int i1 = v() - 1;
    while (i1 >= 0) {
      View view = i(i1);
      if (this.b.a(view) >= paramInt && this.b.d(view) >= paramInt) {
        b b1 = (b)view.getLayoutParams();
        if (b1.b) {
          byte b3;
          byte b2 = 0;
          while (true) {
            int i2 = this.i;
            b3 = 0;
            if (b2 < i2) {
              if ((this.a[b2]).a.size() == 1)
                return; 
              b2++;
              continue;
            } 
            break;
          } 
          while (b3 < this.i) {
            this.a[b3].g();
            b3++;
          } 
        } else {
          if (b1.a.a.size() == 1)
            return; 
          b1.a.g();
        } 
        a(view, paramp);
        i1--;
      } 
    } 
  }
  
  private void b(RecyclerView.p paramp, RecyclerView.u paramu, boolean paramBoolean) {
    int i1 = r(-2147483648);
    if (i1 == Integer.MIN_VALUE)
      return; 
    int i2 = this.b.d() - i1;
    if (i2 > 0) {
      int i3 = i2 - -c(-i2, paramp, paramu);
      if (paramBoolean && i3 > 0)
        this.b.a(i3); 
    } 
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3) {
    int i1;
    if (this.e) {
      int i4 = K();
    } else {
      int i4 = L();
    } 
    if (paramInt3 == 8) {
      if (paramInt1 < paramInt2) {
        i1 = paramInt2 + 1;
      } else {
        int i4 = paramInt1 + 1;
        int i5 = paramInt2;
        this.h.b(i5);
      } 
    } else {
      i1 = paramInt1 + paramInt2;
    } 
    int i2 = i1;
    int i3 = paramInt1;
    this.h.b(i3);
  }
  
  private void c(RecyclerView.p paramp, RecyclerView.u paramu, boolean paramBoolean) {
    int i1 = q(2147483647);
    if (i1 == Integer.MAX_VALUE)
      return; 
    int i2 = i1 - this.b.c();
    if (i2 > 0) {
      int i3 = i2 - c(i2, paramp, paramu);
      if (paramBoolean && i3 > 0)
        this.b.a(-i3); 
    } 
  }
  
  private boolean c(RecyclerView.u paramu, a parama) {
    int i1;
    if (this.o) {
      i1 = w(paramu.e());
    } else {
      i1 = v(paramu.e());
    } 
    parama.a = i1;
    parama.b = Integer.MIN_VALUE;
    return true;
  }
  
  private int i(RecyclerView.u paramu) { return (v() == 0) ? 0 : bd.a(paramu, this.b, b(true ^ this.F), c(true ^ this.F), this, this.F); }
  
  private int j(RecyclerView.u paramu) { return (v() == 0) ? 0 : bd.b(paramu, this.b, b(true ^ this.F), c(true ^ this.F), this, this.F); }
  
  private void m(int paramInt) {
    boolean bool1;
    ar ar1 = this.l;
    ar1.e = paramInt;
    boolean bool = this.e;
    byte b1 = 1;
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool != bool1)
      b1 = -1; 
    ar1.d = b1;
  }
  
  private c.a n(int paramInt) {
    c.a a1 = new c.a();
    a1.c = new int[this.i];
    for (byte b1 = 0; b1 < this.i; b1++)
      a1.c[b1] = paramInt - this.a[b1].b(paramInt); 
    return a1;
  }
  
  private c.a o(int paramInt) {
    c.a a1 = new c.a();
    a1.c = new int[this.i];
    for (byte b1 = 0; b1 < this.i; b1++)
      a1.c[b1] = this.a[b1].a(paramInt) - paramInt; 
    return a1;
  }
  
  private int p(int paramInt) {
    int i1 = this.a[0].a(paramInt);
    for (byte b1 = 1; b1 < this.i; b1++) {
      int i2 = this.a[b1].a(paramInt);
      if (i2 > i1)
        i1 = i2; 
    } 
    return i1;
  }
  
  private void p(View paramView) {
    for (int i1 = -1 + this.i; i1 >= 0; i1--)
      this.a[i1].b(paramView); 
  }
  
  private int q(int paramInt) {
    int i1 = this.a[0].a(paramInt);
    for (byte b1 = 1; b1 < this.i; b1++) {
      int i2 = this.a[b1].a(paramInt);
      if (i2 < i1)
        i1 = i2; 
    } 
    return i1;
  }
  
  private void q(View paramView) {
    for (int i1 = -1 + this.i; i1 >= 0; i1--)
      this.a[i1].a(paramView); 
  }
  
  private int r(int paramInt) {
    int i1 = this.a[0].b(paramInt);
    for (byte b1 = 1; b1 < this.i; b1++) {
      int i2 = this.a[b1].b(paramInt);
      if (i2 > i1)
        i1 = i2; 
    } 
    return i1;
  }
  
  private int s(int paramInt) {
    int i1 = this.a[0].b(paramInt);
    for (byte b1 = 1; b1 < this.i; b1++) {
      int i2 = this.a[b1].b(paramInt);
      if (i2 < i1)
        i1 = i2; 
    } 
    return i1;
  }
  
  private boolean t(int paramInt) {
    boolean bool2;
    boolean bool1;
    if (this.j == 0) {
      boolean bool;
      if (paramInt == -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return (bool != this.e);
    } 
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1 == this.e) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    return (bool2 == j());
  }
  
  private int u(int paramInt) {
    boolean bool;
    int i1 = v();
    byte b1 = -1;
    if (i1 == 0) {
      if (this.e)
        b1 = 1; 
      return b1;
    } 
    if (paramInt < L()) {
      bool = true;
    } else {
      bool = false;
    } 
    return (bool != this.e) ? b1 : 1;
  }
  
  private int v(int paramInt) {
    int i1 = v();
    for (byte b1 = 0; b1 < i1; b1++) {
      int i2 = d(i(b1));
      if (i2 >= 0 && i2 < paramInt)
        return i2; 
    } 
    return 0;
  }
  
  private int w(int paramInt) {
    for (int i1 = -1 + v(); i1 >= 0; i1--) {
      int i2 = d(i(i1));
      if (i2 >= 0 && i2 < paramInt)
        return i2; 
    } 
    return 0;
  }
  
  private int x(int paramInt) {
    int i1 = Integer.MIN_VALUE;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt != 130) {
            switch (paramInt) {
              default:
                return i1;
              case 2:
                return (this.j == 1) ? 1 : (j() ? -1 : 1);
              case 1:
                break;
            } 
            return (this.j == 1) ? -1 : (j() ? 1 : -1);
          } 
          if (this.j == 1)
            i1 = 1; 
          return i1;
        } 
        if (this.j == 0)
          i1 = 1; 
        return i1;
      } 
      return (this.j == 1) ? -1 : Integer.MIN_VALUE;
    } 
    return (this.j == 0) ? -1 : Integer.MIN_VALUE;
  }
  
  int K() {
    int i1 = v();
    return (i1 == 0) ? 0 : d(i(i1 - 1));
  }
  
  int L() { return (v() == 0) ? 0 : d(i(0)); }
  
  public int a(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) { return c(paramInt, paramp, paramu); }
  
  public int a(RecyclerView.p paramp, RecyclerView.u paramu) { return (this.j == 0) ? this.i : super.a(paramp, paramu); }
  
  public RecyclerView.j a() { return (this.j == 0) ? new b(-2, -1) : new b(-1, -2); }
  
  public RecyclerView.j a(Context paramContext, AttributeSet paramAttributeSet) { return new b(paramContext, paramAttributeSet); }
  
  public RecyclerView.j a(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new b((ViewGroup.MarginLayoutParams)paramLayoutParams) : new b(paramLayoutParams); }
  
  public View a(View paramView, int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) {
    boolean bool4;
    boolean bool3;
    int i2;
    if (v() == 0)
      return null; 
    View view = e(paramView);
    if (view == null)
      return null; 
    N();
    int i1 = x(paramInt);
    if (i1 == Integer.MIN_VALUE)
      return null; 
    b b1 = (b)view.getLayoutParams();
    boolean bool1 = b1.b;
    e e1 = b1.a;
    if (i1 == 1) {
      i2 = K();
    } else {
      i2 = L();
    } 
    b(i2, paramu);
    m(i1);
    ar ar1 = this.l;
    ar1.c = i2 + ar1.d;
    this.l.b = (int)(0.33333334F * this.b.f());
    ar ar2 = this.l;
    ar2.h = true;
    ar2.a = false;
    a(paramp, ar2, paramu);
    this.o = this.e;
    if (!bool1) {
      View view1 = e1.a(i2, i1);
      if (view1 != null && view1 != view)
        return view1; 
    } 
    if (t(i1)) {
      for (int i3 = this.i - 1; i3 >= 0; i3--) {
        View view1 = this.a[i3].a(i2, i1);
        if (view1 != null && view1 != view)
          return view1; 
      } 
    } else {
      for (byte b3 = 0; b3 < this.i; b3++) {
        View view1 = this.a[b3].a(i2, i1);
        if (view1 != null && view1 != view)
          return view1; 
      } 
    } 
    boolean bool2 = true ^ this.d;
    if (i1 == -1) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool2 == bool3) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    if (!bool1) {
      int i3;
      if (bool4) {
        i3 = e1.j();
      } else {
        i3 = e1.k();
      } 
      View view1 = c(i3);
      if (view1 != null && view1 != view)
        return view1; 
    } 
    boolean bool5 = t(i1);
    byte b2 = 0;
    if (bool5) {
      for (int i3 = this.i - 1; i3 >= 0; i3--) {
        if (i3 != e1.e) {
          int i4;
          if (bool4) {
            i4 = this.a[i3].j();
          } else {
            i4 = this.a[i3].k();
          } 
          View view1 = c(i4);
          if (view1 != null && view1 != view)
            return view1; 
        } 
      } 
    } else {
      while (b2 < this.i) {
        int i3;
        if (bool4) {
          i3 = this.a[b2].j();
        } else {
          i3 = this.a[b2].k();
        } 
        View view1 = c(i3);
        if (view1 != null && view1 != view)
          return view1; 
        b2++;
      } 
    } 
    return null;
  }
  
  public void a(int paramInt) {
    a(null);
    if (paramInt != this.i) {
      i();
      this.i = paramInt;
      this.m = new BitSet(this.i);
      this.a = new e[this.i];
      for (byte b1 = 0; b1 < this.i; b1++)
        this.a[b1] = new e(this, b1); 
      o();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, RecyclerView.u paramu, RecyclerView.i.a parama) {
    if (this.j != 0)
      paramInt1 = paramInt2; 
    if (v() != 0) {
      if (paramInt1 == 0)
        return; 
      a(paramInt1, paramu);
      int[] arrayOfInt = this.G;
      if (arrayOfInt == null || arrayOfInt.length < this.i)
        this.G = new int[this.i]; 
      byte b1 = 0;
      byte b2 = 0;
      byte b3 = 0;
      while (b2 < this.i) {
        int i2;
        int i1;
        if (this.l.d == -1) {
          i1 = this.l.f;
          i2 = this.a[b2].a(this.l.f);
        } else {
          i1 = this.a[b2].b(this.l.g);
          i2 = this.l.g;
        } 
        int i3 = i1 - i2;
        if (i3 >= 0) {
          this.G[b3] = i3;
          b3++;
        } 
        b2++;
      } 
      Arrays.sort(this.G, 0, b3);
      while (b1 < b3 && this.l.a(paramu)) {
        parama.b(this.l.c, this.G[b1]);
        ar ar1 = this.l;
        ar1.c += this.l.d;
        b1++;
      } 
    } 
  }
  
  void a(int paramInt, RecyclerView.u paramu) {
    byte b1;
    int i1;
    if (paramInt > 0) {
      i1 = K();
      b1 = 1;
    } else {
      i1 = L();
      b1 = -1;
    } 
    this.l.a = true;
    b(i1, paramu);
    m(b1);
    ar ar1 = this.l;
    ar1.c = i1 + ar1.d;
    this.l.b = Math.abs(paramInt);
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2) {
    int i4;
    int i3;
    int i1 = A() + C();
    int i2 = B() + D();
    if (this.j == 1) {
      i4 = a(paramInt2, i2 + paramRect.height(), G());
      i3 = a(paramInt1, i1 + this.k * this.i, F());
    } else {
      i3 = a(paramInt1, i1 + paramRect.width(), F());
      i4 = a(paramInt2, i2 + this.k * this.i, G());
    } 
    f(i3, i4);
  }
  
  public void a(Parcelable paramParcelable) {
    if (paramParcelable instanceof d) {
      this.A = (d)paramParcelable;
      o();
    } 
  }
  
  public void a(RecyclerView.p paramp, RecyclerView.u paramu, View paramView, c paramc) {
    byte b4;
    int i1;
    byte b3;
    byte b2;
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (!(layoutParams instanceof b)) {
      a(paramView, paramc);
      return;
    } 
    b b1 = (b)layoutParams;
    if (this.j == 0) {
      b2 = b1.b();
      if (b1.b) {
        b3 = this.i;
      } else {
        b3 = 1;
      } 
      i1 = -1;
      b4 = -1;
    } else {
      b2 = -1;
      b3 = -1;
      i1 = b1.b();
      if (b1.b) {
        b4 = this.i;
      } else {
        b4 = 1;
      } 
    } 
    paramc.b(c.b.a(b2, b3, i1, b4, b1.b, false));
  }
  
  public void a(RecyclerView.u paramu) {
    super.a(paramu);
    this.f = -1;
    this.g = Integer.MIN_VALUE;
    this.A = null;
    this.D.a();
  }
  
  void a(RecyclerView.u paramu, a parama) {
    if (b(paramu, parama))
      return; 
    if (c(paramu, parama))
      return; 
    parama.b();
    parama.a = 0;
  }
  
  public void a(RecyclerView paramRecyclerView) {
    this.h.a();
    o();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) { c(paramInt1, paramInt2, 1); }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) { c(paramInt1, paramInt2, 8); }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) { c(paramInt1, paramInt2, 4); }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.p paramp) {
    super.a(paramRecyclerView, paramp);
    a(this.H);
    for (byte b1 = 0; b1 < this.i; b1++)
      this.a[b1].e(); 
    paramRecyclerView.requestLayout();
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent) {
    super.a(paramAccessibilityEvent);
    if (v() > 0) {
      View view1 = b(false);
      View view2 = c(false);
      if (view1 != null) {
        if (view2 == null)
          return; 
        int i1 = d(view1);
        int i2 = d(view2);
        if (i1 < i2) {
          paramAccessibilityEvent.setFromIndex(i1);
          paramAccessibilityEvent.setToIndex(i2);
          return;
        } 
        paramAccessibilityEvent.setFromIndex(i2);
        paramAccessibilityEvent.setToIndex(i1);
      } 
    } 
  }
  
  public void a(String paramString) {
    if (this.A == null)
      super.a(paramString); 
  }
  
  public void a(boolean paramBoolean) {
    a(null);
    d d1 = this.A;
    if (d1 != null && d1.h != paramBoolean)
      this.A.h = paramBoolean; 
    this.d = paramBoolean;
    o();
  }
  
  public boolean a(RecyclerView.j paramj) { return paramj instanceof b; }
  
  public int b(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) { return c(paramInt, paramp, paramu); }
  
  public int b(RecyclerView.p paramp, RecyclerView.u paramu) { return (this.j == 1) ? this.i : super.b(paramp, paramu); }
  
  View b(boolean paramBoolean) {
    int i1 = this.b.c();
    int i2 = this.b.d();
    int i3 = v();
    View view = null;
    for (byte b1 = 0; b1 < i3; b1++) {
      View view1 = i(b1);
      int i4 = this.b.a(view1);
      if (this.b.b(view1) > i1 && i4 < i2)
        if (i4 < i1) {
          if (!paramBoolean)
            return view1; 
          if (view == null)
            view = view1; 
        } else {
          return view1;
        }  
    } 
    return view;
  }
  
  public void b(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      a(null);
      if (paramInt == this.j)
        return; 
      this.j = paramInt;
      ax ax1 = this.b;
      this.b = this.c;
      this.c = ax1;
      o();
      return;
    } 
    throw new IllegalArgumentException("invalid orientation.");
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) { c(paramInt1, paramInt2, 2); }
  
  public boolean b() { return (this.A == null); }
  
  boolean b(RecyclerView.u paramu, a parama) {
    if (!paramu.a()) {
      int i1 = this.f;
      if (i1 == -1)
        return false; 
      if (i1 < 0 || i1 >= paramu.e()) {
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        return false;
      } 
      d d1 = this.A;
      if (d1 == null || d1.a == -1 || this.A.c < 1) {
        View view = c(this.f);
        if (view != null) {
          int i3;
          if (this.e) {
            i3 = K();
          } else {
            i3 = L();
          } 
          parama.a = i3;
          if (this.g != Integer.MIN_VALUE) {
            int i7;
            int i6;
            if (parama.c) {
              i6 = this.b.d() - this.g;
              i7 = this.b.b(view);
            } else {
              i6 = this.b.c() + this.g;
              i7 = this.b.a(view);
            } 
            parama.b = i6 - i7;
            return true;
          } 
          if (this.b.e(view) > this.b.f()) {
            int i6;
            if (parama.c) {
              i6 = this.b.d();
            } else {
              i6 = this.b.c();
            } 
            parama.b = i6;
            return true;
          } 
          int i4 = this.b.a(view) - this.b.c();
          if (i4 < 0) {
            parama.b = -i4;
            return true;
          } 
          int i5 = this.b.d() - this.b.b(view);
          if (i5 < 0) {
            parama.b = i5;
            return true;
          } 
          parama.b = Integer.MIN_VALUE;
          return true;
        } 
        parama.a = this.f;
        int i2 = this.g;
        if (i2 == Integer.MIN_VALUE) {
          int i3 = u(parama.a);
          boolean bool = false;
          if (i3 == 1)
            bool = true; 
          parama.c = bool;
          parama.b();
        } else {
          parama.a(i2);
        } 
        parama.d = true;
        return true;
      } 
      parama.b = Integer.MIN_VALUE;
      parama.a = this.f;
      return true;
    } 
    return false;
  }
  
  int c(int paramInt, RecyclerView.p paramp, RecyclerView.u paramu) {
    if (v() != 0) {
      if (paramInt == 0)
        return 0; 
      a(paramInt, paramu);
      int i1 = a(paramp, this.l, paramu);
      if (this.l.b >= i1)
        if (paramInt < 0) {
          paramInt = -i1;
        } else {
          paramInt = i1;
        }  
      this.b.a(-paramInt);
      this.o = this.e;
      ar ar1 = this.l;
      ar1.b = 0;
      a(paramp, ar1);
      return paramInt;
    } 
    return 0;
  }
  
  public int c(RecyclerView.u paramu) { return b(paramu); }
  
  View c(boolean paramBoolean) {
    int i1 = this.b.c();
    int i2 = this.b.d();
    int i3 = -1 + v();
    View view = null;
    while (i3 >= 0) {
      View view1 = i(i3);
      int i4 = this.b.a(view1);
      int i5 = this.b.b(view1);
      if (i5 > i1 && i4 < i2)
        if (i5 > i2) {
          if (!paramBoolean)
            return view1; 
          if (view == null)
            view = view1; 
        } else {
          return view1;
        }  
      i3--;
    } 
    return view;
  }
  
  public void c(RecyclerView.p paramp, RecyclerView.u paramu) { a(paramp, paramu, true); }
  
  public boolean c() { return (this.n != 0); }
  
  public int d(RecyclerView.u paramu) { return b(paramu); }
  
  public PointF d(int paramInt) {
    int i1 = u(paramInt);
    PointF pointF = new PointF();
    if (i1 == 0)
      return null; 
    if (this.j == 0) {
      pointF.x = i1;
      pointF.y = 0.0F;
      return pointF;
    } 
    pointF.x = 0.0F;
    pointF.y = i1;
    return pointF;
  }
  
  public Parcelable d() {
    d d1 = this.A;
    if (d1 != null)
      return new d(d1); 
    d d2 = new d();
    d2.h = this.d;
    d2.i = this.o;
    d2.j = this.z;
    c c1 = this.h;
    byte b1 = 0;
    if (c1 != null && c1.a != null) {
      d2.f = this.h.a;
      d2.e = d2.f.length;
      d2.g = this.h.b;
    } else {
      d2.e = 0;
    } 
    if (v() > 0) {
      int i1;
      if (this.o) {
        i1 = K();
      } else {
        i1 = L();
      } 
      d2.a = i1;
      d2.b = k();
      int i2 = this.i;
      d2.c = i2;
      d2.d = new int[i2];
      while (b1 < this.i) {
        int i4;
        int i3;
        if (this.o) {
          i3 = this.a[b1].b(-2147483648);
          if (i3 != Integer.MIN_VALUE) {
            i4 = this.b.d();
          } else {
            continue;
          } 
        } else {
          i3 = this.a[b1].a(-2147483648);
          if (i3 != Integer.MIN_VALUE) {
            i4 = this.b.c();
          } else {
            continue;
          } 
        } 
        i3 -= i4;
        continue;
        d2.d[b1] = SYNTHETIC_LOCAL_VARIABLE_7;
        b1++;
      } 
    } else {
      d2.a = -1;
      d2.b = -1;
      d2.c = 0;
    } 
    return d2;
  }
  
  public int e(RecyclerView.u paramu) { return i(paramu); }
  
  public void e(int paramInt) {
    d d1 = this.A;
    if (d1 != null && d1.a != paramInt)
      this.A.b(); 
    this.f = paramInt;
    this.g = Integer.MIN_VALUE;
    o();
  }
  
  public boolean e() { return (this.j == 0); }
  
  public int f(RecyclerView.u paramu) { return i(paramu); }
  
  void f(int paramInt) {
    this.k = paramInt / this.i;
    this.B = View.MeasureSpec.makeMeasureSpec(paramInt, this.c.h());
  }
  
  public boolean f() { return (this.j == 1); }
  
  public int g(RecyclerView.u paramu) { return j(paramu); }
  
  boolean g() {
    if (v() != 0 && this.n != 0) {
      byte b1;
      int i2;
      int i1;
      if (!q())
        return false; 
      if (this.e) {
        i1 = K();
        i2 = L();
      } else {
        i1 = L();
        i2 = K();
      } 
      if (i1 == 0 && h() != null) {
        this.h.a();
        I();
        o();
        return true;
      } 
      if (!this.E)
        return false; 
      if (this.e) {
        b1 = -1;
      } else {
        b1 = 1;
      } 
      c c1 = this.h;
      int i3 = i2 + 1;
      c.a a1 = c1.a(i1, i3, b1, true);
      if (a1 == null) {
        this.E = false;
        this.h.a(i3);
        return false;
      } 
      c.a a2 = this.h.a(i1, a1.a, b1 * -1, true);
      if (a2 == null) {
        this.h.a(a1.a);
        I();
        o();
        return true;
      } 
      this.h.a(1 + a2.a);
      I();
      o();
      return true;
    } 
    return false;
  }
  
  public int h(RecyclerView.u paramu) { return j(paramu); }
  
  View h() { // Byte code:
    //   0: aload_0
    //   1: invokevirtual v : ()I
    //   4: iconst_1
    //   5: isub
    //   6: istore_1
    //   7: new java/util/BitSet
    //   10: dup
    //   11: aload_0
    //   12: getfield i : I
    //   15: invokespecial <init> : (I)V
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield i : I
    //   25: iconst_1
    //   26: invokevirtual set : (IIZ)V
    //   29: aload_0
    //   30: getfield j : I
    //   33: istore_3
    //   34: iconst_m1
    //   35: istore #4
    //   37: iload_3
    //   38: iconst_1
    //   39: if_icmpne -> 55
    //   42: aload_0
    //   43: invokevirtual j : ()Z
    //   46: ifeq -> 55
    //   49: iconst_1
    //   50: istore #5
    //   52: goto -> 58
    //   55: iconst_m1
    //   56: istore #5
    //   58: aload_0
    //   59: getfield e : Z
    //   62: ifeq -> 71
    //   65: iconst_m1
    //   66: istore #6
    //   68: goto -> 78
    //   71: iload_1
    //   72: iconst_1
    //   73: iadd
    //   74: istore #6
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_1
    //   79: iload #6
    //   81: if_icmpge -> 87
    //   84: iconst_1
    //   85: istore #4
    //   87: iload_1
    //   88: iload #6
    //   90: if_icmpeq -> 357
    //   93: aload_0
    //   94: iload_1
    //   95: invokevirtual i : (I)Landroid/view/View;
    //   98: astore #7
    //   100: aload #7
    //   102: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   105: checkcast android/support/v7/widget/StaggeredGridLayoutManager$b
    //   108: astore #8
    //   110: aload_2
    //   111: aload #8
    //   113: getfield a : Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   116: getfield e : I
    //   119: invokevirtual get : (I)Z
    //   122: ifeq -> 152
    //   125: aload_0
    //   126: aload #8
    //   128: getfield a : Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   131: invokespecial a : (Landroid/support/v7/widget/StaggeredGridLayoutManager$e;)Z
    //   134: ifeq -> 140
    //   137: aload #7
    //   139: areturn
    //   140: aload_2
    //   141: aload #8
    //   143: getfield a : Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   146: getfield e : I
    //   149: invokevirtual clear : (I)V
    //   152: aload #8
    //   154: getfield b : Z
    //   157: ifeq -> 163
    //   160: goto -> 349
    //   163: iload_1
    //   164: iload #4
    //   166: iadd
    //   167: istore #9
    //   169: iload #9
    //   171: iload #6
    //   173: if_icmpeq -> 349
    //   176: aload_0
    //   177: iload #9
    //   179: invokevirtual i : (I)Landroid/view/View;
    //   182: astore #10
    //   184: aload_0
    //   185: getfield e : Z
    //   188: ifeq -> 233
    //   191: aload_0
    //   192: getfield b : Landroid/support/v7/widget/ax;
    //   195: aload #7
    //   197: invokevirtual b : (Landroid/view/View;)I
    //   200: istore #17
    //   202: aload_0
    //   203: getfield b : Landroid/support/v7/widget/ax;
    //   206: aload #10
    //   208: invokevirtual b : (Landroid/view/View;)I
    //   211: istore #18
    //   213: iload #17
    //   215: iload #18
    //   217: if_icmpge -> 223
    //   220: aload #7
    //   222: areturn
    //   223: iload #17
    //   225: iload #18
    //   227: if_icmpne -> 278
    //   230: goto -> 272
    //   233: aload_0
    //   234: getfield b : Landroid/support/v7/widget/ax;
    //   237: aload #7
    //   239: invokevirtual a : (Landroid/view/View;)I
    //   242: istore #11
    //   244: aload_0
    //   245: getfield b : Landroid/support/v7/widget/ax;
    //   248: aload #10
    //   250: invokevirtual a : (Landroid/view/View;)I
    //   253: istore #12
    //   255: iload #11
    //   257: iload #12
    //   259: if_icmple -> 265
    //   262: aload #7
    //   264: areturn
    //   265: iload #11
    //   267: iload #12
    //   269: if_icmpne -> 278
    //   272: iconst_1
    //   273: istore #13
    //   275: goto -> 281
    //   278: iconst_0
    //   279: istore #13
    //   281: iload #13
    //   283: ifeq -> 349
    //   286: aload #10
    //   288: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   291: checkcast android/support/v7/widget/StaggeredGridLayoutManager$b
    //   294: astore #14
    //   296: aload #8
    //   298: getfield a : Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   301: getfield e : I
    //   304: aload #14
    //   306: getfield a : Landroid/support/v7/widget/StaggeredGridLayoutManager$e;
    //   309: getfield e : I
    //   312: isub
    //   313: ifge -> 322
    //   316: iconst_1
    //   317: istore #15
    //   319: goto -> 325
    //   322: iconst_0
    //   323: istore #15
    //   325: iload #5
    //   327: ifge -> 336
    //   330: iconst_1
    //   331: istore #16
    //   333: goto -> 339
    //   336: iconst_0
    //   337: istore #16
    //   339: iload #15
    //   341: iload #16
    //   343: if_icmpeq -> 349
    //   346: aload #7
    //   348: areturn
    //   349: iload_1
    //   350: iload #4
    //   352: iadd
    //   353: istore_1
    //   354: goto -> 87
    //   357: aconst_null
    //   358: areturn }
  
  public void i() {
    this.h.a();
    o();
  }
  
  public void j(int paramInt) {
    super.j(paramInt);
    for (byte b1 = 0; b1 < this.i; b1++)
      this.a[b1].d(paramInt); 
  }
  
  boolean j() { return (t() == 1); }
  
  int k() {
    View view;
    if (this.e) {
      view = c(true);
    } else {
      view = b(true);
    } 
    return (view == null) ? -1 : d(view);
  }
  
  public void k(int paramInt) {
    super.k(paramInt);
    for (byte b1 = 0; b1 < this.i; b1++)
      this.a[b1].d(paramInt); 
  }
  
  public void l(int paramInt) {
    if (paramInt == 0)
      g(); 
  }
  
  boolean m() {
    int i1 = this.a[0].b(-2147483648);
    for (byte b1 = 1; b1 < this.i; b1++) {
      if (this.a[b1].b(-2147483648) != i1)
        return false; 
    } 
    return true;
  }
  
  boolean n() {
    int i1 = this.a[0].a(-2147483648);
    for (byte b1 = 1; b1 < this.i; b1++) {
      if (this.a[b1].a(-2147483648) != i1)
        return false; 
    } 
    return true;
  }
  
  class a {
    int a;
    
    int b;
    
    boolean c;
    
    boolean d;
    
    boolean e;
    
    int[] f;
    
    a(StaggeredGridLayoutManager this$0) { a(); }
    
    void a() {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
      this.d = false;
      this.e = false;
      int[] arrayOfInt = this.f;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
    }
    
    void a(int param1Int) {
      int i;
      if (this.c) {
        i = this.g.b.d() - param1Int;
      } else {
        i = param1Int + this.g.b.c();
      } 
      this.b = i;
    }
    
    void a(StaggeredGridLayoutManager.e[] param1ArrayOfe) {
      int i = param1ArrayOfe.length;
      int[] arrayOfInt = this.f;
      if (arrayOfInt == null || arrayOfInt.length < i)
        this.f = new int[this.g.a.length]; 
      for (byte b1 = 0; b1 < i; b1++)
        this.f[b1] = param1ArrayOfe[b1].a(-2147483648); 
    }
    
    void b() {
      int i;
      if (this.c) {
        i = this.g.b.d();
      } else {
        i = this.g.b.c();
      } 
      this.b = i;
    }
  }
  
  public static class b extends RecyclerView.j {
    StaggeredGridLayoutManager.e a;
    
    boolean b;
    
    public b(int param1Int1, int param1Int2) { super(param1Int1, param1Int2); }
    
    public b(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    public b(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public b(ViewGroup.MarginLayoutParams param1MarginLayoutParams) { super(param1MarginLayoutParams); }
    
    public boolean a() { return this.b; }
    
    public final int b() {
      StaggeredGridLayoutManager.e e1 = this.a;
      return (e1 == null) ? -1 : e1.e;
    }
  }
  
  static class c {
    int[] a;
    
    List<a> b;
    
    private void c(int param1Int1, int param1Int2) {
      List list = this.b;
      if (list == null)
        return; 
      int i = param1Int1 + param1Int2;
      for (int j = -1 + list.size(); j >= 0; j--) {
        a a1 = (a)this.b.get(j);
        if (a1.a >= param1Int1)
          if (a1.a < i) {
            this.b.remove(j);
          } else {
            a1.a -= param1Int2;
          }  
      } 
    }
    
    private void d(int param1Int1, int param1Int2) {
      List list = this.b;
      if (list == null)
        return; 
      for (int i = -1 + list.size(); i >= 0; i--) {
        a a1 = (a)this.b.get(i);
        if (a1.a >= param1Int1)
          a1.a = param1Int2 + a1.a; 
      } 
    }
    
    private int g(int param1Int) { // Byte code:
      //   0: aload_0
      //   1: getfield b : Ljava/util/List;
      //   4: ifnonnull -> 9
      //   7: iconst_m1
      //   8: ireturn
      //   9: aload_0
      //   10: iload_1
      //   11: invokevirtual f : (I)Landroid/support/v7/widget/StaggeredGridLayoutManager$c$a;
      //   14: astore_2
      //   15: aload_2
      //   16: ifnull -> 30
      //   19: aload_0
      //   20: getfield b : Ljava/util/List;
      //   23: aload_2
      //   24: invokeinterface remove : (Ljava/lang/Object;)Z
      //   29: pop
      //   30: aload_0
      //   31: getfield b : Ljava/util/List;
      //   34: invokeinterface size : ()I
      //   39: istore_3
      //   40: iconst_0
      //   41: istore #4
      //   43: iload #4
      //   45: iload_3
      //   46: if_icmpge -> 79
      //   49: aload_0
      //   50: getfield b : Ljava/util/List;
      //   53: iload #4
      //   55: invokeinterface get : (I)Ljava/lang/Object;
      //   60: checkcast android/support/v7/widget/StaggeredGridLayoutManager$c$a
      //   63: getfield a : I
      //   66: iload_1
      //   67: if_icmplt -> 73
      //   70: goto -> 82
      //   73: iinc #4, 1
      //   76: goto -> 43
      //   79: iconst_m1
      //   80: istore #4
      //   82: iload #4
      //   84: iconst_m1
      //   85: if_icmpeq -> 122
      //   88: aload_0
      //   89: getfield b : Ljava/util/List;
      //   92: iload #4
      //   94: invokeinterface get : (I)Ljava/lang/Object;
      //   99: checkcast android/support/v7/widget/StaggeredGridLayoutManager$c$a
      //   102: astore #5
      //   104: aload_0
      //   105: getfield b : Ljava/util/List;
      //   108: iload #4
      //   110: invokeinterface remove : (I)Ljava/lang/Object;
      //   115: pop
      //   116: aload #5
      //   118: getfield a : I
      //   121: ireturn
      //   122: iconst_m1
      //   123: ireturn }
    
    int a(int param1Int) {
      List list = this.b;
      if (list != null)
        for (int i = -1 + list.size(); i >= 0; i--) {
          if (((a)this.b.get(i)).a >= param1Int)
            this.b.remove(i); 
        }  
      return b(param1Int);
    }
    
    public a a(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      List list = this.b;
      if (list == null)
        return null; 
      int i = list.size();
      for (byte b1 = 0; b1 < i; b1++) {
        a a1 = (a)this.b.get(b1);
        if (a1.a >= param1Int2)
          return null; 
        if (a1.a >= param1Int1 && (param1Int3 == 0 || a1.b == param1Int3 || (param1Boolean && a1.d)))
          return a1; 
      } 
      return null;
    }
    
    void a() {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null)
        Arrays.fill(arrayOfInt, -1); 
      this.b = null;
    }
    
    void a(int param1Int1, int param1Int2) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null) {
        if (param1Int1 >= arrayOfInt.length)
          return; 
        int i = param1Int1 + param1Int2;
        e(i);
        int[] arrayOfInt1 = this.a;
        System.arraycopy(arrayOfInt1, i, arrayOfInt1, param1Int1, arrayOfInt1.length - param1Int1 - param1Int2);
        int[] arrayOfInt2 = this.a;
        Arrays.fill(arrayOfInt2, arrayOfInt2.length - param1Int2, arrayOfInt2.length, -1);
        c(param1Int1, param1Int2);
      } 
    }
    
    void a(int param1Int, StaggeredGridLayoutManager.e param1e) {
      e(param1Int);
      this.a[param1Int] = param1e.e;
    }
    
    public void a(a param1a) {
      if (this.b == null)
        this.b = new ArrayList(); 
      int i = this.b.size();
      for (byte b1 = 0; b1 < i; b1++) {
        a a1 = (a)this.b.get(b1);
        if (a1.a == param1a.a)
          this.b.remove(b1); 
        if (a1.a >= param1a.a) {
          this.b.add(b1, param1a);
          return;
        } 
      } 
      this.b.add(param1a);
    }
    
    int b(int param1Int) {
      int[] arrayOfInt1 = this.a;
      if (arrayOfInt1 == null)
        return -1; 
      if (param1Int >= arrayOfInt1.length)
        return -1; 
      int i = g(param1Int);
      if (i == -1) {
        int[] arrayOfInt = this.a;
        Arrays.fill(arrayOfInt, param1Int, arrayOfInt.length, -1);
        return this.a.length;
      } 
      int[] arrayOfInt2 = this.a;
      int j = i + 1;
      Arrays.fill(arrayOfInt2, param1Int, j, -1);
      return j;
    }
    
    void b(int param1Int1, int param1Int2) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null) {
        if (param1Int1 >= arrayOfInt.length)
          return; 
        int i = param1Int1 + param1Int2;
        e(i);
        int[] arrayOfInt1 = this.a;
        System.arraycopy(arrayOfInt1, param1Int1, arrayOfInt1, i, arrayOfInt1.length - param1Int1 - param1Int2);
        Arrays.fill(this.a, param1Int1, i, -1);
        d(param1Int1, param1Int2);
      } 
    }
    
    int c(int param1Int) {
      int[] arrayOfInt = this.a;
      return (arrayOfInt == null || param1Int >= arrayOfInt.length) ? -1 : arrayOfInt[param1Int];
    }
    
    int d(int param1Int) {
      int i;
      for (i = this.a.length; i <= param1Int; i *= 2);
      return i;
    }
    
    void e(int param1Int) {
      int[] arrayOfInt = this.a;
      if (arrayOfInt == null) {
        this.a = new int[1 + Math.max(param1Int, 10)];
        Arrays.fill(this.a, -1);
        return;
      } 
      if (param1Int >= arrayOfInt.length) {
        this.a = new int[d(param1Int)];
        System.arraycopy(arrayOfInt, 0, this.a, 0, arrayOfInt.length);
        int[] arrayOfInt1 = this.a;
        Arrays.fill(arrayOfInt1, arrayOfInt.length, arrayOfInt1.length, -1);
      } 
    }
    
    public a f(int param1Int) {
      List list = this.b;
      if (list == null)
        return null; 
      for (int i = -1 + list.size(); i >= 0; i--) {
        a a1 = (a)this.b.get(i);
        if (a1.a == param1Int)
          return a1; 
      } 
      return null;
    }
    
    static class a implements Parcelable {
      public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
          public StaggeredGridLayoutManager.c.a a(Parcel param3Parcel) { return new StaggeredGridLayoutManager.c.a(param3Parcel); }
          
          public StaggeredGridLayoutManager.c.a[] a(int param3Int) { return new StaggeredGridLayoutManager.c.a[param3Int]; }
        };
      
      int a;
      
      int b;
      
      int[] c;
      
      boolean d;
      
      a() {}
      
      a(Parcel param2Parcel) {
        this.a = param2Parcel.readInt();
        this.b = param2Parcel.readInt();
        int i = param2Parcel.readInt();
        boolean bool = true;
        if (i != bool)
          bool = false; 
        this.d = bool;
        int j = param2Parcel.readInt();
        if (j > 0) {
          this.c = new int[j];
          param2Parcel.readIntArray(this.c);
        } 
      }
      
      int a(int param2Int) {
        int[] arrayOfInt = this.c;
        return (arrayOfInt == null) ? 0 : arrayOfInt[param2Int];
      }
      
      public int describeContents() { return 0; }
      
      public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FullSpanItem{mPosition=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mGapDir=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mHasUnwantedGapAfter=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mGapPerSpan=");
        stringBuilder.append(Arrays.toString(this.c));
        stringBuilder.append('}');
        return stringBuilder.toString();
      }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        param2Parcel.writeInt(this.a);
        param2Parcel.writeInt(this.b);
        param2Parcel.writeInt(this.d);
        int[] arrayOfInt = this.c;
        if (arrayOfInt != null && arrayOfInt.length > 0) {
          param2Parcel.writeInt(arrayOfInt.length);
          param2Parcel.writeIntArray(this.c);
          return;
        } 
        param2Parcel.writeInt(0);
      }
    }
    
    static final class null extends Object implements Parcelable.Creator<a> {
      public StaggeredGridLayoutManager.c.a a(Parcel param2Parcel) { return new StaggeredGridLayoutManager.c.a(param2Parcel); }
      
      public StaggeredGridLayoutManager.c.a[] a(int param2Int) { return new StaggeredGridLayoutManager.c.a[param2Int]; }
    }
  }
  
  static class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        public StaggeredGridLayoutManager.c.a a(Parcel param3Parcel) { return new StaggeredGridLayoutManager.c.a(param3Parcel); }
        
        public StaggeredGridLayoutManager.c.a[] a(int param3Int) { return new StaggeredGridLayoutManager.c.a[param3Int]; }
      };
    
    int a;
    
    int b;
    
    int[] c;
    
    boolean d;
    
    a() {}
    
    a(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != bool)
        bool = false; 
      this.d = bool;
      int j = param1Parcel.readInt();
      if (j > 0) {
        this.c = new int[j];
        param1Parcel.readIntArray(this.c);
      } 
    }
    
    int a(int param1Int) {
      int[] arrayOfInt = this.c;
      return (arrayOfInt == null) ? 0 : arrayOfInt[param1Int];
    }
    
    public int describeContents() { return 0; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FullSpanItem{mPosition=");
      stringBuilder.append(this.a);
      stringBuilder.append(", mGapDir=");
      stringBuilder.append(this.b);
      stringBuilder.append(", mHasUnwantedGapAfter=");
      stringBuilder.append(this.d);
      stringBuilder.append(", mGapPerSpan=");
      stringBuilder.append(Arrays.toString(this.c));
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeInt(this.d);
      int[] arrayOfInt = this.c;
      if (arrayOfInt != null && arrayOfInt.length > 0) {
        param1Parcel.writeInt(arrayOfInt.length);
        param1Parcel.writeIntArray(this.c);
        return;
      } 
      param1Parcel.writeInt(0);
    }
  }
  
  static final class null extends Object implements Parcelable.Creator<c.a> {
    public StaggeredGridLayoutManager.c.a a(Parcel param1Parcel) { return new StaggeredGridLayoutManager.c.a(param1Parcel); }
    
    public StaggeredGridLayoutManager.c.a[] a(int param1Int) { return new StaggeredGridLayoutManager.c.a[param1Int]; }
  }
  
  public static class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        public StaggeredGridLayoutManager.d a(Parcel param2Parcel) { return new StaggeredGridLayoutManager.d(param2Parcel); }
        
        public StaggeredGridLayoutManager.d[] a(int param2Int) { return new StaggeredGridLayoutManager.d[param2Int]; }
      };
    
    int a;
    
    int b;
    
    int c;
    
    int[] d;
    
    int e;
    
    int[] f;
    
    List<StaggeredGridLayoutManager.c.a> g;
    
    boolean h;
    
    boolean i;
    
    boolean j;
    
    public d() {}
    
    d(Parcel param1Parcel) {
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readInt();
      int k = this.c;
      if (k > 0) {
        this.d = new int[k];
        param1Parcel.readIntArray(this.d);
      } 
      this.e = param1Parcel.readInt();
      int m = this.e;
      if (m > 0) {
        this.f = new int[m];
        param1Parcel.readIntArray(this.f);
      } 
      if (param1Parcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.h = bool1;
      if (param1Parcel.readInt() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      this.i = bool2;
      int n = param1Parcel.readInt();
      boolean bool3 = false;
      if (n == 1)
        bool3 = true; 
      this.j = bool3;
      this.g = param1Parcel.readArrayList(StaggeredGridLayoutManager.c.a.class.getClassLoader());
    }
    
    public d(d param1d) {
      this.c = param1d.c;
      this.a = param1d.a;
      this.b = param1d.b;
      this.d = param1d.d;
      this.e = param1d.e;
      this.f = param1d.f;
      this.h = param1d.h;
      this.i = param1d.i;
      this.j = param1d.j;
      this.g = param1d.g;
    }
    
    void a() {
      this.d = null;
      this.c = 0;
      this.e = 0;
      this.f = null;
      this.g = null;
    }
    
    void b() {
      this.d = null;
      this.c = 0;
      this.a = -1;
      this.b = -1;
    }
    
    public int describeContents() { return 0; }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeInt(this.c);
      if (this.c > 0)
        param1Parcel.writeIntArray(this.d); 
      param1Parcel.writeInt(this.e);
      if (this.e > 0)
        param1Parcel.writeIntArray(this.f); 
      param1Parcel.writeInt(this.h);
      param1Parcel.writeInt(this.i);
      param1Parcel.writeInt(this.j);
      param1Parcel.writeList(this.g);
    }
  }
  
  static final class null extends Object implements Parcelable.Creator<d> {
    public StaggeredGridLayoutManager.d a(Parcel param1Parcel) { return new StaggeredGridLayoutManager.d(param1Parcel); }
    
    public StaggeredGridLayoutManager.d[] a(int param1Int) { return new StaggeredGridLayoutManager.d[param1Int]; }
  }
  
  class e {
    ArrayList<View> a = new ArrayList();
    
    int b = Integer.MIN_VALUE;
    
    int c = Integer.MIN_VALUE;
    
    int d = 0;
    
    final int e;
    
    e(StaggeredGridLayoutManager this$0, int param1Int) { this.e = param1Int; }
    
    int a(int param1Int) {
      int i = this.b;
      if (i != Integer.MIN_VALUE)
        return i; 
      if (this.a.size() == 0)
        return param1Int; 
      a();
      return this.b;
    }
    
    int a(int param1Int1, int param1Int2, boolean param1Boolean) { return a(param1Int1, param1Int2, false, false, param1Boolean); }
    
    int a(int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3) { // Byte code:
      //   0: aload_0
      //   1: getfield f : Landroid/support/v7/widget/StaggeredGridLayoutManager;
      //   4: getfield b : Landroid/support/v7/widget/ax;
      //   7: invokevirtual c : ()I
      //   10: istore #6
      //   12: aload_0
      //   13: getfield f : Landroid/support/v7/widget/StaggeredGridLayoutManager;
      //   16: getfield b : Landroid/support/v7/widget/ax;
      //   19: invokevirtual d : ()I
      //   22: istore #7
      //   24: iload_2
      //   25: iload_1
      //   26: if_icmple -> 35
      //   29: iconst_1
      //   30: istore #8
      //   32: goto -> 38
      //   35: iconst_m1
      //   36: istore #8
      //   38: iload_1
      //   39: iload_2
      //   40: if_icmpeq -> 222
      //   43: aload_0
      //   44: getfield a : Ljava/util/ArrayList;
      //   47: iload_1
      //   48: invokevirtual get : (I)Ljava/lang/Object;
      //   51: checkcast android/view/View
      //   54: astore #9
      //   56: aload_0
      //   57: getfield f : Landroid/support/v7/widget/StaggeredGridLayoutManager;
      //   60: getfield b : Landroid/support/v7/widget/ax;
      //   63: aload #9
      //   65: invokevirtual a : (Landroid/view/View;)I
      //   68: istore #10
      //   70: aload_0
      //   71: getfield f : Landroid/support/v7/widget/StaggeredGridLayoutManager;
      //   74: getfield b : Landroid/support/v7/widget/ax;
      //   77: aload #9
      //   79: invokevirtual b : (Landroid/view/View;)I
      //   82: istore #11
      //   84: iload #5
      //   86: ifeq -> 99
      //   89: iload #10
      //   91: iload #7
      //   93: if_icmpgt -> 112
      //   96: goto -> 106
      //   99: iload #10
      //   101: iload #7
      //   103: if_icmpge -> 112
      //   106: iconst_1
      //   107: istore #12
      //   109: goto -> 115
      //   112: iconst_0
      //   113: istore #12
      //   115: iload #5
      //   117: ifeq -> 133
      //   120: iconst_0
      //   121: istore #13
      //   123: iload #11
      //   125: iload #6
      //   127: if_icmplt -> 146
      //   130: goto -> 143
      //   133: iconst_0
      //   134: istore #13
      //   136: iload #11
      //   138: iload #6
      //   140: if_icmple -> 146
      //   143: iconst_1
      //   144: istore #13
      //   146: iload #12
      //   148: ifeq -> 214
      //   151: iload #13
      //   153: ifeq -> 214
      //   156: iload_3
      //   157: ifeq -> 189
      //   160: iload #4
      //   162: ifeq -> 189
      //   165: iload #10
      //   167: iload #6
      //   169: if_icmplt -> 214
      //   172: iload #11
      //   174: iload #7
      //   176: if_icmpgt -> 214
      //   179: aload_0
      //   180: getfield f : Landroid/support/v7/widget/StaggeredGridLayoutManager;
      //   183: aload #9
      //   185: invokevirtual d : (Landroid/view/View;)I
      //   188: ireturn
      //   189: iload #4
      //   191: ifeq -> 197
      //   194: goto -> 179
      //   197: iload #10
      //   199: iload #6
      //   201: if_icmplt -> 179
      //   204: iload #11
      //   206: iload #7
      //   208: if_icmple -> 214
      //   211: goto -> 179
      //   214: iload_1
      //   215: iload #8
      //   217: iadd
      //   218: istore_1
      //   219: goto -> 38
      //   222: iconst_m1
      //   223: ireturn }
    
    public View a(int param1Int1, int param1Int2) {
      View view = null;
      if (param1Int2 == -1) {
        int i = this.a.size();
        byte b1 = 0;
        while (b1 < i) {
          View view1 = (View)this.a.get(b1);
          if (!this.f.d || this.f.d(view1) > param1Int1) {
            if (!this.f.d && this.f.d(view1) >= param1Int1)
              return view; 
            if (view1.hasFocusable()) {
              b1++;
              view = view1;
            } 
          } 
        } 
      } else {
        int i = -1 + this.a.size();
        while (i >= 0) {
          View view1 = (View)this.a.get(i);
          if (!this.f.d || this.f.d(view1) < param1Int1) {
            if (!this.f.d && this.f.d(view1) <= param1Int1)
              return view; 
            if (view1.hasFocusable()) {
              i--;
              view = view1;
            } 
          } 
        } 
      } 
      return view;
    }
    
    void a() {
      View view = (View)this.a.get(0);
      StaggeredGridLayoutManager.b b1 = c(view);
      this.b = this.f.b.a(view);
      if (b1.b) {
        StaggeredGridLayoutManager.c.a a1 = this.f.h.f(b1.f());
        if (a1 != null && a1.b == -1)
          this.b -= a1.a(this.e); 
      } 
    }
    
    void a(View param1View) {
      StaggeredGridLayoutManager.b b1 = c(param1View);
      b1.a = this;
      this.a.add(0, param1View);
      this.b = Integer.MIN_VALUE;
      if (this.a.size() == 1)
        this.c = Integer.MIN_VALUE; 
      if (b1.d() || b1.e())
        this.d += this.f.b.e(param1View); 
    }
    
    void a(boolean param1Boolean, int param1Int) {
      int i;
      if (param1Boolean) {
        i = b(-2147483648);
      } else {
        i = a(-2147483648);
      } 
      e();
      if (i == Integer.MIN_VALUE)
        return; 
      if ((param1Boolean && i < this.f.b.d()) || (!param1Boolean && i > this.f.b.c()))
        return; 
      if (param1Int != Integer.MIN_VALUE)
        i += param1Int; 
      this.c = i;
      this.b = i;
    }
    
    int b() {
      int i = this.b;
      if (i != Integer.MIN_VALUE)
        return i; 
      a();
      return this.b;
    }
    
    int b(int param1Int) {
      int i = this.c;
      if (i != Integer.MIN_VALUE)
        return i; 
      if (this.a.size() == 0)
        return param1Int; 
      c();
      return this.c;
    }
    
    void b(View param1View) {
      StaggeredGridLayoutManager.b b1 = c(param1View);
      b1.a = this;
      this.a.add(param1View);
      this.c = Integer.MIN_VALUE;
      if (this.a.size() == 1)
        this.b = Integer.MIN_VALUE; 
      if (b1.d() || b1.e())
        this.d += this.f.b.e(param1View); 
    }
    
    StaggeredGridLayoutManager.b c(View param1View) { return (StaggeredGridLayoutManager.b)param1View.getLayoutParams(); }
    
    void c() {
      ArrayList arrayList = this.a;
      View view = (View)arrayList.get(arrayList.size() - 1);
      StaggeredGridLayoutManager.b b1 = c(view);
      this.c = this.f.b.b(view);
      if (b1.b) {
        StaggeredGridLayoutManager.c.a a1 = this.f.h.f(b1.f());
        if (a1 != null && a1.b == 1)
          this.c += a1.a(this.e); 
      } 
    }
    
    void c(int param1Int) {
      this.b = param1Int;
      this.c = param1Int;
    }
    
    int d() {
      int i = this.c;
      if (i != Integer.MIN_VALUE)
        return i; 
      c();
      return this.c;
    }
    
    void d(int param1Int) {
      int i = this.b;
      if (i != Integer.MIN_VALUE)
        this.b = i + param1Int; 
      int j = this.c;
      if (j != Integer.MIN_VALUE)
        this.c = j + param1Int; 
    }
    
    void e() {
      this.a.clear();
      f();
      this.d = 0;
    }
    
    void f() {
      this.b = Integer.MIN_VALUE;
      this.c = Integer.MIN_VALUE;
    }
    
    void g() {
      int i = this.a.size();
      View view = (View)this.a.remove(i - 1);
      StaggeredGridLayoutManager.b b1 = c(view);
      b1.a = null;
      if (b1.d() || b1.e())
        this.d -= this.f.b.e(view); 
      if (i == 1)
        this.b = Integer.MIN_VALUE; 
      this.c = Integer.MIN_VALUE;
    }
    
    void h() {
      View view = (View)this.a.remove(0);
      StaggeredGridLayoutManager.b b1 = c(view);
      b1.a = null;
      if (this.a.size() == 0)
        this.c = Integer.MIN_VALUE; 
      if (b1.d() || b1.e())
        this.d -= this.f.b.e(view); 
      this.b = Integer.MIN_VALUE;
    }
    
    public int i() { return this.d; }
    
    public int j() {
      int i;
      byte b1;
      if (this.f.d) {
        b1 = this.a.size() - 1;
        i = -1;
      } else {
        b1 = 0;
        i = this.a.size();
      } 
      return a(b1, i, true);
    }
    
    public int k() {
      byte b1;
      int i;
      if (this.f.d) {
        b1 = this.a.size();
        i = 0;
      } else {
        i = this.a.size() - 1;
        b1 = -1;
      } 
      return a(i, b1, true);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */