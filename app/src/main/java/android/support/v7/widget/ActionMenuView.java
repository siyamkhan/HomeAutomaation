package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends as implements h.b, p {
  h.a a;
  
  e b;
  
  private h c;
  
  private Context d;
  
  private int e;
  
  private boolean f;
  
  private c g;
  
  private o.a h;
  
  private boolean i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  public ActionMenuView(Context paramContext) { this(paramContext, null); }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f1 = (paramContext.getResources().getDisplayMetrics()).density;
    this.k = (int)(56.0F * f1);
    this.l = (int)(f1 * 4.0F);
    this.d = paramContext;
    this.e = 0;
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    boolean bool2;
    Object object;
    c c1 = (c)paramView.getLayoutParams();
    int m = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    if (paramView instanceof ActionMenuItemView) {
      object = (ActionMenuItemView)paramView;
    } else {
      object = null;
    } 
    boolean bool1 = true;
    if (object != null && object.b()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    int n = 2;
    if (paramInt2 > 0 && (!bool2 || paramInt2 >= n)) {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, -2147483648), m);
      int i1 = paramView.getMeasuredWidth();
      int i2 = i1 / paramInt1;
      if (i1 % paramInt1 != 0)
        i2++; 
      if (!bool2 || i2 >= n)
        n = i2; 
    } else {
      n = 0;
    } 
    if (c1.a || !bool2)
      bool1 = false; 
    c1.d = bool1;
    c1.b = n;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * n, 1073741824), m);
    return n;
  }
  
  private void c(int paramInt1, int paramInt2) { // Byte code:
    //   0: iload_2
    //   1: invokestatic getMode : (I)I
    //   4: istore_3
    //   5: iload_1
    //   6: invokestatic getSize : (I)I
    //   9: istore #4
    //   11: iload_2
    //   12: invokestatic getSize : (I)I
    //   15: istore #5
    //   17: aload_0
    //   18: invokevirtual getPaddingLeft : ()I
    //   21: aload_0
    //   22: invokevirtual getPaddingRight : ()I
    //   25: iadd
    //   26: istore #6
    //   28: aload_0
    //   29: invokevirtual getPaddingTop : ()I
    //   32: aload_0
    //   33: invokevirtual getPaddingBottom : ()I
    //   36: iadd
    //   37: istore #7
    //   39: iload_2
    //   40: iload #7
    //   42: bipush #-2
    //   44: invokestatic getChildMeasureSpec : (III)I
    //   47: istore #8
    //   49: iload #4
    //   51: iload #6
    //   53: isub
    //   54: istore #9
    //   56: aload_0
    //   57: getfield k : I
    //   60: istore #10
    //   62: iload #9
    //   64: iload #10
    //   66: idiv
    //   67: istore #11
    //   69: iload #9
    //   71: iload #10
    //   73: irem
    //   74: istore #12
    //   76: iload #11
    //   78: ifne -> 89
    //   81: aload_0
    //   82: iload #9
    //   84: iconst_0
    //   85: invokevirtual setMeasuredDimension : (II)V
    //   88: return
    //   89: iload #10
    //   91: iload #12
    //   93: iload #11
    //   95: idiv
    //   96: iadd
    //   97: istore #13
    //   99: aload_0
    //   100: invokevirtual getChildCount : ()I
    //   103: istore #14
    //   105: iload #11
    //   107: istore #15
    //   109: iconst_0
    //   110: istore #16
    //   112: iconst_0
    //   113: istore #17
    //   115: iconst_0
    //   116: istore #18
    //   118: iconst_0
    //   119: istore #19
    //   121: iconst_0
    //   122: istore #20
    //   124: iconst_0
    //   125: istore #21
    //   127: lconst_0
    //   128: lstore #22
    //   130: iload #16
    //   132: iload #14
    //   134: if_icmpge -> 425
    //   137: aload_0
    //   138: iload #16
    //   140: invokevirtual getChildAt : (I)Landroid/view/View;
    //   143: astore #64
    //   145: aload #64
    //   147: invokevirtual getVisibility : ()I
    //   150: istore #65
    //   152: iload #5
    //   154: istore #66
    //   156: iload #65
    //   158: bipush #8
    //   160: if_icmpne -> 166
    //   163: goto -> 415
    //   166: aload #64
    //   168: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   171: istore #67
    //   173: iload #19
    //   175: iconst_1
    //   176: iadd
    //   177: istore #68
    //   179: iload #67
    //   181: ifeq -> 208
    //   184: aload_0
    //   185: getfield l : I
    //   188: istore #78
    //   190: iload #68
    //   192: istore #69
    //   194: aload #64
    //   196: iload #78
    //   198: iconst_0
    //   199: iload #78
    //   201: iconst_0
    //   202: invokevirtual setPadding : (IIII)V
    //   205: goto -> 212
    //   208: iload #68
    //   210: istore #69
    //   212: aload #64
    //   214: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   217: checkcast android/support/v7/widget/ActionMenuView$c
    //   220: astore #70
    //   222: aload #70
    //   224: iconst_0
    //   225: putfield f : Z
    //   228: aload #70
    //   230: iconst_0
    //   231: putfield c : I
    //   234: aload #70
    //   236: iconst_0
    //   237: putfield b : I
    //   240: aload #70
    //   242: iconst_0
    //   243: putfield d : Z
    //   246: aload #70
    //   248: iconst_0
    //   249: putfield leftMargin : I
    //   252: aload #70
    //   254: iconst_0
    //   255: putfield rightMargin : I
    //   258: iload #67
    //   260: ifeq -> 280
    //   263: aload #64
    //   265: checkcast android/support/v7/view/menu/ActionMenuItemView
    //   268: invokevirtual b : ()Z
    //   271: ifeq -> 280
    //   274: iconst_1
    //   275: istore #71
    //   277: goto -> 283
    //   280: iconst_0
    //   281: istore #71
    //   283: aload #70
    //   285: iload #71
    //   287: putfield e : Z
    //   290: aload #70
    //   292: getfield a : Z
    //   295: ifeq -> 304
    //   298: iconst_1
    //   299: istore #72
    //   301: goto -> 308
    //   304: iload #15
    //   306: istore #72
    //   308: aload #64
    //   310: iload #13
    //   312: iload #72
    //   314: iload #8
    //   316: iload #7
    //   318: invokestatic a : (Landroid/view/View;IIII)I
    //   321: istore #73
    //   323: iload #20
    //   325: iload #73
    //   327: invokestatic max : (II)I
    //   330: istore #74
    //   332: aload #70
    //   334: getfield d : Z
    //   337: ifeq -> 343
    //   340: iinc #21, 1
    //   343: aload #70
    //   345: getfield a : Z
    //   348: ifeq -> 354
    //   351: iconst_1
    //   352: istore #18
    //   354: iload #15
    //   356: iload #73
    //   358: isub
    //   359: istore #15
    //   361: iload #17
    //   363: aload #64
    //   365: invokevirtual getMeasuredHeight : ()I
    //   368: invokestatic max : (II)I
    //   371: istore #17
    //   373: iload #73
    //   375: iconst_1
    //   376: if_icmpne -> 404
    //   379: iconst_1
    //   380: iload #16
    //   382: ishl
    //   383: istore #76
    //   385: iload #17
    //   387: istore #77
    //   389: lload #22
    //   391: iload #76
    //   393: i2l
    //   394: lor
    //   395: lstore #22
    //   397: iload #77
    //   399: istore #17
    //   401: goto -> 407
    //   404: iload #17
    //   406: pop
    //   407: iload #74
    //   409: istore #20
    //   411: iload #69
    //   413: istore #19
    //   415: iinc #16, 1
    //   418: iload #66
    //   420: istore #5
    //   422: goto -> 130
    //   425: iload #5
    //   427: istore #24
    //   429: iload #18
    //   431: ifeq -> 446
    //   434: iload #19
    //   436: iconst_2
    //   437: if_icmpne -> 446
    //   440: iconst_1
    //   441: istore #25
    //   443: goto -> 449
    //   446: iconst_0
    //   447: istore #25
    //   449: iconst_0
    //   450: istore #26
    //   452: iload #21
    //   454: ifle -> 804
    //   457: iload #15
    //   459: ifle -> 804
    //   462: ldc 2147483647
    //   464: istore #43
    //   466: iconst_0
    //   467: istore #44
    //   469: iconst_0
    //   470: istore #45
    //   472: lconst_0
    //   473: lstore #46
    //   475: iload #44
    //   477: iload #14
    //   479: if_icmpge -> 584
    //   482: aload_0
    //   483: iload #44
    //   485: invokevirtual getChildAt : (I)Landroid/view/View;
    //   488: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   491: astore #60
    //   493: iload #26
    //   495: istore #61
    //   497: aload #60
    //   499: checkcast android/support/v7/widget/ActionMenuView$c
    //   502: astore #62
    //   504: iload #17
    //   506: istore #63
    //   508: aload #62
    //   510: getfield d : Z
    //   513: ifne -> 519
    //   516: goto -> 570
    //   519: aload #62
    //   521: getfield b : I
    //   524: iload #43
    //   526: if_icmpge -> 548
    //   529: aload #62
    //   531: getfield b : I
    //   534: istore #43
    //   536: lconst_1
    //   537: iload #44
    //   539: lshl
    //   540: lstore #46
    //   542: iconst_1
    //   543: istore #45
    //   545: goto -> 570
    //   548: aload #62
    //   550: getfield b : I
    //   553: iload #43
    //   555: if_icmpne -> 570
    //   558: lload #46
    //   560: lconst_1
    //   561: iload #44
    //   563: lshl
    //   564: lor
    //   565: lstore #46
    //   567: iinc #45, 1
    //   570: iinc #44, 1
    //   573: iload #63
    //   575: istore #17
    //   577: iload #61
    //   579: istore #26
    //   581: goto -> 475
    //   584: iload #26
    //   586: istore #29
    //   588: iload #17
    //   590: istore #30
    //   592: lload #22
    //   594: lload #46
    //   596: lor
    //   597: lstore #22
    //   599: iload #45
    //   601: iload #15
    //   603: if_icmple -> 616
    //   606: iload_3
    //   607: istore #27
    //   609: iload #9
    //   611: istore #28
    //   613: goto -> 819
    //   616: iload #43
    //   618: iconst_1
    //   619: iadd
    //   620: istore #48
    //   622: iconst_0
    //   623: istore #49
    //   625: iload #49
    //   627: iload #14
    //   629: if_icmpge -> 794
    //   632: aload_0
    //   633: iload #49
    //   635: invokevirtual getChildAt : (I)Landroid/view/View;
    //   638: astore #50
    //   640: aload #50
    //   642: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   645: checkcast android/support/v7/widget/ActionMenuView$c
    //   648: astore #51
    //   650: iload #9
    //   652: istore #52
    //   654: iconst_1
    //   655: iload #49
    //   657: ishl
    //   658: istore #53
    //   660: iload_3
    //   661: istore #54
    //   663: iload #53
    //   665: i2l
    //   666: lstore #55
    //   668: lload #46
    //   670: lload #55
    //   672: land
    //   673: lconst_0
    //   674: lcmp
    //   675: ifne -> 702
    //   678: aload #51
    //   680: getfield b : I
    //   683: iload #48
    //   685: if_icmpne -> 695
    //   688: lload #22
    //   690: lload #55
    //   692: lor
    //   693: lstore #22
    //   695: iload #48
    //   697: istore #57
    //   699: goto -> 777
    //   702: iload #25
    //   704: ifeq -> 752
    //   707: aload #51
    //   709: getfield e : Z
    //   712: ifeq -> 752
    //   715: iload #15
    //   717: iconst_1
    //   718: if_icmpne -> 752
    //   721: aload_0
    //   722: getfield l : I
    //   725: istore #58
    //   727: iload #58
    //   729: iload #13
    //   731: iadd
    //   732: istore #59
    //   734: iload #48
    //   736: istore #57
    //   738: aload #50
    //   740: iload #59
    //   742: iconst_0
    //   743: iload #58
    //   745: iconst_0
    //   746: invokevirtual setPadding : (IIII)V
    //   749: goto -> 756
    //   752: iload #48
    //   754: istore #57
    //   756: aload #51
    //   758: iconst_1
    //   759: aload #51
    //   761: getfield b : I
    //   764: iadd
    //   765: putfield b : I
    //   768: aload #51
    //   770: iconst_1
    //   771: putfield f : Z
    //   774: iinc #15, -1
    //   777: iinc #49, 1
    //   780: iload #54
    //   782: istore_3
    //   783: iload #57
    //   785: istore #48
    //   787: iload #52
    //   789: istore #9
    //   791: goto -> 625
    //   794: iload #30
    //   796: istore #17
    //   798: iconst_1
    //   799: istore #26
    //   801: goto -> 452
    //   804: iload_3
    //   805: istore #27
    //   807: iload #9
    //   809: istore #28
    //   811: iload #26
    //   813: istore #29
    //   815: iload #17
    //   817: istore #30
    //   819: iload #18
    //   821: ifne -> 840
    //   824: iconst_1
    //   825: istore #31
    //   827: iload #19
    //   829: iload #31
    //   831: if_icmpne -> 843
    //   834: iconst_1
    //   835: istore #32
    //   837: goto -> 846
    //   840: iconst_1
    //   841: istore #31
    //   843: iconst_0
    //   844: istore #32
    //   846: iload #15
    //   848: ifle -> 1170
    //   851: lload #22
    //   853: lconst_0
    //   854: lcmp
    //   855: ifeq -> 1170
    //   858: iload #15
    //   860: iload #19
    //   862: iload #31
    //   864: isub
    //   865: if_icmplt -> 880
    //   868: iload #32
    //   870: ifne -> 880
    //   873: iload #20
    //   875: iload #31
    //   877: if_icmple -> 1170
    //   880: lload #22
    //   882: invokestatic bitCount : (J)I
    //   885: i2f
    //   886: fstore #37
    //   888: iload #32
    //   890: ifne -> 976
    //   893: lload #22
    //   895: lconst_1
    //   896: land
    //   897: lconst_0
    //   898: lcmp
    //   899: ifeq -> 929
    //   902: aload_0
    //   903: iconst_0
    //   904: invokevirtual getChildAt : (I)Landroid/view/View;
    //   907: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   910: checkcast android/support/v7/widget/ActionMenuView$c
    //   913: getfield e : Z
    //   916: ifne -> 929
    //   919: fload #37
    //   921: ldc 0.5
    //   923: fsub
    //   924: fstore #37
    //   926: goto -> 929
    //   929: iload #14
    //   931: iconst_1
    //   932: isub
    //   933: istore #42
    //   935: lload #22
    //   937: iconst_1
    //   938: iload #42
    //   940: ishl
    //   941: i2l
    //   942: land
    //   943: lconst_0
    //   944: lcmp
    //   945: ifeq -> 976
    //   948: aload_0
    //   949: iload #42
    //   951: invokevirtual getChildAt : (I)Landroid/view/View;
    //   954: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   957: checkcast android/support/v7/widget/ActionMenuView$c
    //   960: getfield e : Z
    //   963: ifne -> 976
    //   966: fload #37
    //   968: ldc 0.5
    //   970: fsub
    //   971: fstore #37
    //   973: goto -> 976
    //   976: fload #37
    //   978: fconst_0
    //   979: fcmpl
    //   980: ifle -> 998
    //   983: iload #15
    //   985: iload #13
    //   987: imul
    //   988: i2f
    //   989: fload #37
    //   991: fdiv
    //   992: f2i
    //   993: istore #38
    //   995: goto -> 1001
    //   998: iconst_0
    //   999: istore #38
    //   1001: iconst_0
    //   1002: istore #39
    //   1004: iload #39
    //   1006: iload #14
    //   1008: if_icmpge -> 1170
    //   1011: lload #22
    //   1013: iconst_1
    //   1014: iload #39
    //   1016: ishl
    //   1017: i2l
    //   1018: land
    //   1019: lconst_0
    //   1020: lcmp
    //   1021: ifne -> 1027
    //   1024: goto -> 1164
    //   1027: aload_0
    //   1028: iload #39
    //   1030: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1033: astore #40
    //   1035: aload #40
    //   1037: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1040: checkcast android/support/v7/widget/ActionMenuView$c
    //   1043: astore #41
    //   1045: aload #40
    //   1047: instanceof android/support/v7/view/menu/ActionMenuItemView
    //   1050: ifeq -> 1095
    //   1053: aload #41
    //   1055: iload #38
    //   1057: putfield c : I
    //   1060: aload #41
    //   1062: iconst_1
    //   1063: putfield f : Z
    //   1066: iload #39
    //   1068: ifne -> 1092
    //   1071: aload #41
    //   1073: getfield e : Z
    //   1076: ifne -> 1092
    //   1079: aload #41
    //   1081: iload #38
    //   1083: ineg
    //   1084: iconst_2
    //   1085: idiv
    //   1086: putfield leftMargin : I
    //   1089: goto -> 1092
    //   1092: goto -> 1126
    //   1095: aload #41
    //   1097: getfield a : Z
    //   1100: ifeq -> 1132
    //   1103: aload #41
    //   1105: iload #38
    //   1107: putfield c : I
    //   1110: aload #41
    //   1112: iconst_1
    //   1113: putfield f : Z
    //   1116: aload #41
    //   1118: iload #38
    //   1120: ineg
    //   1121: iconst_2
    //   1122: idiv
    //   1123: putfield rightMargin : I
    //   1126: iconst_1
    //   1127: istore #29
    //   1129: goto -> 1164
    //   1132: iload #39
    //   1134: ifeq -> 1146
    //   1137: aload #41
    //   1139: iload #38
    //   1141: iconst_2
    //   1142: idiv
    //   1143: putfield leftMargin : I
    //   1146: iload #39
    //   1148: iload #14
    //   1150: iconst_1
    //   1151: isub
    //   1152: if_icmpeq -> 1164
    //   1155: aload #41
    //   1157: iload #38
    //   1159: iconst_2
    //   1160: idiv
    //   1161: putfield rightMargin : I
    //   1164: iinc #39, 1
    //   1167: goto -> 1004
    //   1170: iconst_0
    //   1171: istore #33
    //   1173: iload #29
    //   1175: ifeq -> 1246
    //   1178: iload #33
    //   1180: iload #14
    //   1182: if_icmpge -> 1246
    //   1185: aload_0
    //   1186: iload #33
    //   1188: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1191: astore #35
    //   1193: aload #35
    //   1195: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1198: checkcast android/support/v7/widget/ActionMenuView$c
    //   1201: astore #36
    //   1203: aload #36
    //   1205: getfield f : Z
    //   1208: ifne -> 1214
    //   1211: goto -> 1240
    //   1214: aload #35
    //   1216: iload #13
    //   1218: aload #36
    //   1220: getfield b : I
    //   1223: imul
    //   1224: aload #36
    //   1226: getfield c : I
    //   1229: iadd
    //   1230: ldc 1073741824
    //   1232: invokestatic makeMeasureSpec : (II)I
    //   1235: iload #8
    //   1237: invokevirtual measure : (II)V
    //   1240: iinc #33, 1
    //   1243: goto -> 1178
    //   1246: iload #27
    //   1248: ldc 1073741824
    //   1250: if_icmpeq -> 1260
    //   1253: iload #30
    //   1255: istore #34
    //   1257: goto -> 1264
    //   1260: iload #24
    //   1262: istore #34
    //   1264: aload_0
    //   1265: iload #28
    //   1267: iload #34
    //   1269: invokevirtual setMeasuredDimension : (II)V
    //   1272: return }
  
  public c a(AttributeSet paramAttributeSet) { return new c(getContext(), paramAttributeSet); }
  
  protected c a(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null) {
      c c1;
      if (paramLayoutParams instanceof c) {
        c1 = new c((c)paramLayoutParams);
      } else {
        c1 = new c(paramLayoutParams);
      } 
      if (c1.h <= 0)
        c1.h = 16; 
      return c1;
    } 
    return b();
  }
  
  public void a(h paramh) { this.c = paramh; }
  
  public void a(o.a parama, h.a parama1) {
    this.h = parama;
    this.a = parama1;
  }
  
  public boolean a() { return this.f; }
  
  protected boolean a(int paramInt) {
    if (paramInt == 0)
      return false; 
    View view1 = getChildAt(paramInt - 1);
    View view2 = getChildAt(paramInt);
    int m = getChildCount();
    boolean bool = false;
    if (paramInt < m) {
      boolean bool1 = view1 instanceof a;
      bool = false;
      if (bool1)
        bool = false | ((a)view1).d(); 
    } 
    if (paramInt > 0 && view2 instanceof a)
      bool |= ((a)view2).c(); 
    return bool;
  }
  
  public boolean a(j paramj) { return this.c.a(paramj, 0); }
  
  protected c b() {
    c c1 = new c(-2, -2);
    c1.h = 16;
    return c1;
  }
  
  public c c() {
    c c1 = b();
    c1.a = true;
    return c1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams != null && paramLayoutParams instanceof c); }
  
  public h d() { return this.c; }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) { return false; }
  
  public boolean e() {
    c c1 = this.g;
    return (c1 != null && c1.d());
  }
  
  public boolean f() {
    c c1 = this.g;
    return (c1 != null && c1.e());
  }
  
  public boolean g() {
    c c1 = this.g;
    return (c1 != null && c1.h());
  }
  
  public Menu getMenu() {
    if (this.c == null) {
      Context context = getContext();
      this.c = new h(context);
      this.c.a(new d(this));
      this.g = new c(context);
      this.g.c(true);
      c c1 = this.g;
      o.a a1 = this.h;
      if (a1 == null)
        a1 = new b(); 
      c1.a(a1);
      this.c.a(this.g, this.d);
      this.g.a(this);
    } 
    return this.c;
  }
  
  public Drawable getOverflowIcon() {
    getMenu();
    return this.g.c();
  }
  
  public int getPopupTheme() { return this.e; }
  
  public int getWindowAnimations() { return 0; }
  
  public boolean h() {
    c c1 = this.g;
    return (c1 != null && c1.i());
  }
  
  public void i() {
    c c1 = this.g;
    if (c1 != null)
      c1.f(); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    c c1 = this.g;
    if (c1 != null) {
      c1.b(false);
      if (this.g.h()) {
        this.g.e();
        this.g.d();
      } 
    } 
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    i();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b4;
    byte b3;
    if (!this.i) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    int m = getChildCount();
    int n = (paramInt4 - paramInt2) / 2;
    int i1 = getDividerWidth();
    int i2 = paramInt3 - paramInt1;
    int i3 = i2 - getPaddingRight() - getPaddingLeft();
    boolean bool = bu.a(this);
    int i4 = i3;
    byte b1 = 0;
    boolean bool1 = false;
    byte b2 = 0;
    while (b1 < m) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        c c1 = (c)view.getLayoutParams();
        if (c1.a) {
          int i10;
          int i9;
          int i7 = view.getMeasuredWidth();
          if (a(b1))
            i7 += i1; 
          int i8 = view.getMeasuredHeight();
          if (bool) {
            i10 = getPaddingLeft() + c1.leftMargin;
            i9 = i10 + i7;
          } else {
            i9 = getWidth() - getPaddingRight() - c1.rightMargin;
            i10 = i9 - i7;
          } 
          int i11 = n - i8 / 2;
          view.layout(i10, i11, i9, i8 + i11);
          i4 -= i7;
          bool1 = true;
        } else {
          i4 -= view.getMeasuredWidth() + c1.leftMargin + c1.rightMargin;
          a(b1);
          b2++;
        } 
      } 
      b1++;
    } 
    if (m == 1 && !bool1) {
      View view = getChildAt(0);
      int i7 = view.getMeasuredWidth();
      int i8 = view.getMeasuredHeight();
      int i9 = i2 / 2 - i7 / 2;
      int i10 = n - i8 / 2;
      view.layout(i9, i10, i7 + i9, i8 + i10);
      return;
    } 
    int i5 = b2 - (bool1 ^ true);
    if (i5 > 0) {
      b4 = i4 / i5;
      b3 = 0;
    } else {
      b3 = 0;
      b4 = 0;
    } 
    int i6 = Math.max(0, b4);
    if (bool) {
      int i7 = getWidth() - getPaddingRight();
      while (b3 < m) {
        View view = getChildAt(b3);
        c c1 = (c)view.getLayoutParams();
        if (view.getVisibility() != 8 && !c1.a) {
          int i8 = i7 - c1.rightMargin;
          int i9 = view.getMeasuredWidth();
          int i10 = view.getMeasuredHeight();
          int i11 = n - i10 / 2;
          view.layout(i8 - i9, i11, i8, i10 + i11);
          i7 = i8 - i6 + i9 + c1.leftMargin;
        } 
        b3++;
      } 
    } else {
      int i7 = getPaddingLeft();
      while (b3 < m) {
        View view = getChildAt(b3);
        c c1 = (c)view.getLayoutParams();
        if (view.getVisibility() != 8 && !c1.a) {
          int i8 = i7 + c1.leftMargin;
          int i9 = view.getMeasuredWidth();
          int i10 = view.getMeasuredHeight();
          int i11 = n - i10 / 2;
          view.layout(i8, i11, i8 + i9, i10 + i11);
          i7 = i8 + i6 + i9 + c1.rightMargin;
        } 
        b3++;
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool1;
    boolean bool = this.i;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.i = bool1;
    if (bool != this.i)
      this.j = 0; 
    int m = View.MeasureSpec.getSize(paramInt1);
    if (this.i) {
      h h1 = this.c;
      if (h1 != null && m != this.j) {
        this.j = m;
        h1.b(true);
      } 
    } 
    int n = getChildCount();
    if (this.i && n > 0) {
      c(paramInt1, paramInt2);
      return;
    } 
    for (byte b1 = 0; b1 < n; b1++) {
      c c1 = (c)getChildAt(b1).getLayoutParams();
      c1.rightMargin = 0;
      c1.leftMargin = 0;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean) { this.g.d(paramBoolean); }
  
  public void setOnMenuItemClickListener(e parame) { this.b = parame; }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    getMenu();
    this.g.a(paramDrawable);
  }
  
  public void setOverflowReserved(boolean paramBoolean) { this.f = paramBoolean; }
  
  public void setPopupTheme(int paramInt) {
    if (this.e != paramInt) {
      this.e = paramInt;
      if (paramInt == 0) {
        this.d = getContext();
        return;
      } 
      this.d = new ContextThemeWrapper(getContext(), paramInt);
    } 
  }
  
  public void setPresenter(c paramc) {
    this.g = paramc;
    this.g.a(this);
  }
  
  public static interface a {
    boolean c();
    
    boolean d();
  }
  
  private static class b implements o.a {
    public void a(h param1h, boolean param1Boolean) {}
    
    public boolean a(h param1h) { return false; }
  }
  
  public static class c extends as.a {
    @ExportedProperty
    public boolean a;
    
    @ExportedProperty
    public int b;
    
    @ExportedProperty
    public int c;
    
    @ExportedProperty
    public boolean d;
    
    @ExportedProperty
    public boolean e;
    
    boolean f;
    
    public c(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.a = false;
    }
    
    public c(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    public c(c param1c) {
      super(param1c);
      this.a = param1c.a;
    }
    
    public c(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
  }
  
  private class d implements h.a {
    d(ActionMenuView this$0) {}
    
    public void a(h param1h) {
      if (this.a.a != null)
        this.a.a.a(param1h); 
    }
    
    public boolean a(h param1h, MenuItem param1MenuItem) { return (this.a.b != null && this.a.b.a(param1MenuItem)); }
  }
  
  public static interface e {
    boolean a(MenuItem param1MenuItem);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */