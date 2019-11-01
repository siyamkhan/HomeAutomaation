package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class as extends ViewGroup {
  private boolean a = true;
  
  private int b = -1;
  
  private int c = 0;
  
  private int d;
  
  private int e = 8388659;
  
  private int f;
  
  private float g;
  
  private boolean h;
  
  private int[] i;
  
  private int[] j;
  
  private Drawable k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  public as(Context paramContext) { this(paramContext, null); }
  
  public as(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public as(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    bm bm = bm.a(paramContext, paramAttributeSet, a.j.LinearLayoutCompat, paramInt, 0);
    int i1 = bm.a(a.j.LinearLayoutCompat_android_orientation, -1);
    if (i1 >= 0)
      setOrientation(i1); 
    int i2 = bm.a(a.j.LinearLayoutCompat_android_gravity, -1);
    if (i2 >= 0)
      setGravity(i2); 
    boolean bool = bm.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool)
      setBaselineAligned(bool); 
    this.g = bm.a(a.j.LinearLayoutCompat_android_weightSum, -1.0F);
    this.b = bm.a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.h = bm.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(bm.a(a.j.LinearLayoutCompat_divider));
    this.n = bm.a(a.j.LinearLayoutCompat_showDividers, 0);
    this.o = bm.e(a.j.LinearLayoutCompat_dividerPadding, 0);
    bm.a();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2); }
  
  private void c(int paramInt1, int paramInt2) {
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (byte b1 = 0; b1 < paramInt1; b1++) {
      View view = b(b1);
      if (view.getVisibility() != 8) {
        a a1 = (a)view.getLayoutParams();
        if (a1.width == -1) {
          int i2 = a1.height;
          a1.height = view.getMeasuredHeight();
          measureChildWithMargins(view, i1, 0, paramInt2, 0);
          a1.height = i2;
        } 
      } 
    } 
  }
  
  private void d(int paramInt1, int paramInt2) {
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (byte b1 = 0; b1 < paramInt1; b1++) {
      View view = b(b1);
      if (view.getVisibility() != 8) {
        a a1 = (a)view.getLayoutParams();
        if (a1.height == -1) {
          int i2 = a1.width;
          a1.width = view.getMeasuredWidth();
          measureChildWithMargins(view, paramInt2, 0, i1, 0);
          a1.width = i2;
        } 
      } 
    } 
  }
  
  int a(View paramView) { return 0; }
  
  int a(View paramView, int paramInt) { return 0; }
  
  void a(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield f : I
    //   5: aload_0
    //   6: invokevirtual getVirtualChildCount : ()I
    //   9: istore_3
    //   10: iload_1
    //   11: invokestatic getMode : (I)I
    //   14: istore #4
    //   16: iload_2
    //   17: invokestatic getMode : (I)I
    //   20: istore #5
    //   22: aload_0
    //   23: getfield b : I
    //   26: istore #6
    //   28: aload_0
    //   29: getfield h : Z
    //   32: istore #7
    //   34: fconst_0
    //   35: fstore #8
    //   37: iconst_0
    //   38: istore #9
    //   40: iconst_0
    //   41: istore #10
    //   43: iconst_0
    //   44: istore #11
    //   46: iconst_0
    //   47: istore #12
    //   49: iconst_0
    //   50: istore #13
    //   52: iconst_0
    //   53: istore #14
    //   55: iconst_0
    //   56: istore #15
    //   58: iconst_1
    //   59: istore #16
    //   61: iconst_0
    //   62: istore #17
    //   64: bipush #8
    //   66: istore #18
    //   68: iload #12
    //   70: istore #19
    //   72: iload #14
    //   74: iload_3
    //   75: if_icmpge -> 769
    //   78: aload_0
    //   79: iload #14
    //   81: invokevirtual b : (I)Landroid/view/View;
    //   84: astore #66
    //   86: aload #66
    //   88: ifnonnull -> 120
    //   91: aload_0
    //   92: aload_0
    //   93: getfield f : I
    //   96: aload_0
    //   97: iload #14
    //   99: invokevirtual d : (I)I
    //   102: iadd
    //   103: putfield f : I
    //   106: iload_3
    //   107: istore #78
    //   109: iload #19
    //   111: istore #12
    //   113: iload #5
    //   115: istore #79
    //   117: goto -> 756
    //   120: iload #9
    //   122: istore #67
    //   124: aload #66
    //   126: invokevirtual getVisibility : ()I
    //   129: iload #18
    //   131: if_icmpne -> 161
    //   134: iload #14
    //   136: aload_0
    //   137: aload #66
    //   139: iload #14
    //   141: invokevirtual a : (Landroid/view/View;I)I
    //   144: iadd
    //   145: istore #14
    //   147: iload_3
    //   148: istore #78
    //   150: iload #19
    //   152: istore #12
    //   154: iload #67
    //   156: istore #9
    //   158: goto -> 113
    //   161: aload_0
    //   162: iload #14
    //   164: invokevirtual c : (I)Z
    //   167: ifeq -> 183
    //   170: aload_0
    //   171: aload_0
    //   172: getfield f : I
    //   175: aload_0
    //   176: getfield m : I
    //   179: iadd
    //   180: putfield f : I
    //   183: aload #66
    //   185: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   188: checkcast android/support/v7/widget/as$a
    //   191: astore #68
    //   193: fload #8
    //   195: aload #68
    //   197: getfield g : F
    //   200: fadd
    //   201: fstore #69
    //   203: iload #5
    //   205: ldc 1073741824
    //   207: if_icmpne -> 306
    //   210: aload #68
    //   212: getfield height : I
    //   215: ifne -> 306
    //   218: aload #68
    //   220: getfield g : F
    //   223: fconst_0
    //   224: fcmpl
    //   225: ifle -> 306
    //   228: aload_0
    //   229: getfield f : I
    //   232: istore #96
    //   234: iload #96
    //   236: aload #68
    //   238: getfield topMargin : I
    //   241: iadd
    //   242: istore #97
    //   244: iload #10
    //   246: istore #98
    //   248: aload_0
    //   249: iload #96
    //   251: iload #97
    //   253: aload #68
    //   255: getfield bottomMargin : I
    //   258: iadd
    //   259: invokestatic max : (II)I
    //   262: putfield f : I
    //   265: iload #11
    //   267: istore #87
    //   269: aload #66
    //   271: astore #86
    //   273: iload #13
    //   275: istore #81
    //   277: iload_3
    //   278: istore #78
    //   280: iload #67
    //   282: istore #73
    //   284: iload #98
    //   286: istore #75
    //   288: iconst_1
    //   289: istore #15
    //   291: iload #14
    //   293: istore #82
    //   295: iload #5
    //   297: istore #79
    //   299: iload #19
    //   301: istore #80
    //   303: goto -> 505
    //   306: iload #10
    //   308: istore #70
    //   310: aload #68
    //   312: getfield height : I
    //   315: ifne -> 341
    //   318: aload #68
    //   320: getfield g : F
    //   323: fconst_0
    //   324: fcmpl
    //   325: ifle -> 341
    //   328: aload #68
    //   330: bipush #-2
    //   332: putfield height : I
    //   335: iconst_0
    //   336: istore #71
    //   338: goto -> 345
    //   341: ldc -2147483648
    //   343: istore #71
    //   345: fload #69
    //   347: fconst_0
    //   348: fcmpl
    //   349: ifne -> 361
    //   352: aload_0
    //   353: getfield f : I
    //   356: istore #72
    //   358: goto -> 364
    //   361: iconst_0
    //   362: istore #72
    //   364: iload #67
    //   366: istore #73
    //   368: iload #71
    //   370: istore #74
    //   372: iload #70
    //   374: istore #75
    //   376: iload #14
    //   378: istore #76
    //   380: iload #11
    //   382: istore #77
    //   384: iload_3
    //   385: istore #78
    //   387: iload #5
    //   389: istore #79
    //   391: iload #19
    //   393: istore #80
    //   395: iload #13
    //   397: istore #81
    //   399: iload #14
    //   401: istore #82
    //   403: aload_0
    //   404: aload #66
    //   406: iload #76
    //   408: iload_1
    //   409: iconst_0
    //   410: iload_2
    //   411: iload #72
    //   413: invokevirtual a : (Landroid/view/View;IIIII)V
    //   416: iload #74
    //   418: ldc -2147483648
    //   420: if_icmpeq -> 430
    //   423: aload #68
    //   425: iload #74
    //   427: putfield height : I
    //   430: aload #66
    //   432: invokevirtual getMeasuredHeight : ()I
    //   435: istore #83
    //   437: aload_0
    //   438: getfield f : I
    //   441: istore #84
    //   443: iload #84
    //   445: iload #83
    //   447: iadd
    //   448: aload #68
    //   450: getfield topMargin : I
    //   453: iadd
    //   454: aload #68
    //   456: getfield bottomMargin : I
    //   459: iadd
    //   460: istore #85
    //   462: aload #66
    //   464: astore #86
    //   466: aload_0
    //   467: iload #84
    //   469: iload #85
    //   471: aload_0
    //   472: aload #86
    //   474: invokevirtual b : (Landroid/view/View;)I
    //   477: iadd
    //   478: invokestatic max : (II)I
    //   481: putfield f : I
    //   484: iload #7
    //   486: ifeq -> 501
    //   489: iload #83
    //   491: iload #77
    //   493: invokestatic max : (II)I
    //   496: istore #87
    //   498: goto -> 505
    //   501: iload #77
    //   503: istore #87
    //   505: iload #6
    //   507: iflt -> 527
    //   510: iload #6
    //   512: iload #82
    //   514: iconst_1
    //   515: iadd
    //   516: if_icmpne -> 527
    //   519: aload_0
    //   520: aload_0
    //   521: getfield f : I
    //   524: putfield c : I
    //   527: iload #82
    //   529: iload #6
    //   531: if_icmpge -> 557
    //   534: aload #68
    //   536: getfield g : F
    //   539: fconst_0
    //   540: fcmpl
    //   541: ifgt -> 547
    //   544: goto -> 557
    //   547: new java/lang/RuntimeException
    //   550: dup
    //   551: ldc 'A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.'
    //   553: invokespecial <init> : (Ljava/lang/String;)V
    //   556: athrow
    //   557: iload #4
    //   559: ldc 1073741824
    //   561: if_icmpeq -> 582
    //   564: aload #68
    //   566: getfield width : I
    //   569: iconst_m1
    //   570: if_icmpne -> 582
    //   573: iconst_1
    //   574: istore #88
    //   576: iconst_1
    //   577: istore #17
    //   579: goto -> 585
    //   582: iconst_0
    //   583: istore #88
    //   585: aload #68
    //   587: getfield leftMargin : I
    //   590: aload #68
    //   592: getfield rightMargin : I
    //   595: iadd
    //   596: istore #89
    //   598: iload #89
    //   600: aload #86
    //   602: invokevirtual getMeasuredWidth : ()I
    //   605: iadd
    //   606: istore #90
    //   608: iload #75
    //   610: iload #90
    //   612: invokestatic max : (II)I
    //   615: istore #91
    //   617: iload #73
    //   619: aload #86
    //   621: invokevirtual getMeasuredState : ()I
    //   624: invokestatic combineMeasuredStates : (II)I
    //   627: istore #92
    //   629: iload #16
    //   631: ifeq -> 649
    //   634: aload #68
    //   636: getfield width : I
    //   639: iconst_m1
    //   640: if_icmpne -> 649
    //   643: iconst_1
    //   644: istore #93
    //   646: goto -> 652
    //   649: iconst_0
    //   650: istore #93
    //   652: aload #68
    //   654: getfield g : F
    //   657: fconst_0
    //   658: fcmpl
    //   659: ifle -> 690
    //   662: iload #88
    //   664: ifeq -> 670
    //   667: goto -> 674
    //   670: iload #90
    //   672: istore #89
    //   674: iload #80
    //   676: iload #89
    //   678: invokestatic max : (II)I
    //   681: istore #80
    //   683: iload #81
    //   685: istore #94
    //   687: goto -> 711
    //   690: iload #88
    //   692: ifeq -> 698
    //   695: goto -> 702
    //   698: iload #90
    //   700: istore #89
    //   702: iload #81
    //   704: iload #89
    //   706: invokestatic max : (II)I
    //   709: istore #94
    //   711: iload #82
    //   713: aload_0
    //   714: aload #86
    //   716: iload #82
    //   718: invokevirtual a : (Landroid/view/View;I)I
    //   721: iadd
    //   722: istore #95
    //   724: iload #87
    //   726: istore #11
    //   728: iload #93
    //   730: istore #16
    //   732: iload #80
    //   734: istore #12
    //   736: fload #69
    //   738: fstore #8
    //   740: iload #94
    //   742: istore #13
    //   744: iload #92
    //   746: istore #9
    //   748: iload #95
    //   750: istore #14
    //   752: iload #91
    //   754: istore #10
    //   756: iinc #14, 1
    //   759: iload #79
    //   761: istore #5
    //   763: iload #78
    //   765: istore_3
    //   766: goto -> 64
    //   769: iload #9
    //   771: istore #20
    //   773: iload #11
    //   775: istore #21
    //   777: iload #13
    //   779: istore #22
    //   781: iload_3
    //   782: istore #23
    //   784: iload #10
    //   786: istore #24
    //   788: iload #5
    //   790: istore #25
    //   792: aload_0
    //   793: getfield f : I
    //   796: ifle -> 828
    //   799: iload #23
    //   801: istore #26
    //   803: aload_0
    //   804: iload #26
    //   806: invokevirtual c : (I)Z
    //   809: ifeq -> 832
    //   812: aload_0
    //   813: aload_0
    //   814: getfield f : I
    //   817: aload_0
    //   818: getfield m : I
    //   821: iadd
    //   822: putfield f : I
    //   825: goto -> 832
    //   828: iload #23
    //   830: istore #26
    //   832: iload #7
    //   834: ifeq -> 989
    //   837: iload #25
    //   839: istore #27
    //   841: iload #27
    //   843: ldc -2147483648
    //   845: if_icmpeq -> 853
    //   848: iload #27
    //   850: ifne -> 993
    //   853: aload_0
    //   854: iconst_0
    //   855: putfield f : I
    //   858: iconst_0
    //   859: istore #61
    //   861: iload #61
    //   863: iload #26
    //   865: if_icmpge -> 993
    //   868: aload_0
    //   869: iload #61
    //   871: invokevirtual b : (I)Landroid/view/View;
    //   874: astore #62
    //   876: aload #62
    //   878: ifnonnull -> 903
    //   881: aload_0
    //   882: getfield f : I
    //   885: aload_0
    //   886: iload #61
    //   888: invokevirtual d : (I)I
    //   891: iadd
    //   892: istore #65
    //   894: aload_0
    //   895: iload #65
    //   897: putfield f : I
    //   900: goto -> 979
    //   903: aload #62
    //   905: invokevirtual getVisibility : ()I
    //   908: iload #18
    //   910: if_icmpne -> 929
    //   913: iload #61
    //   915: aload_0
    //   916: aload #62
    //   918: iload #61
    //   920: invokevirtual a : (Landroid/view/View;I)I
    //   923: iadd
    //   924: istore #61
    //   926: goto -> 979
    //   929: aload #62
    //   931: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   934: checkcast android/support/v7/widget/as$a
    //   937: astore #63
    //   939: aload_0
    //   940: getfield f : I
    //   943: istore #64
    //   945: iload #64
    //   947: iload #64
    //   949: iload #21
    //   951: iadd
    //   952: aload #63
    //   954: getfield topMargin : I
    //   957: iadd
    //   958: aload #63
    //   960: getfield bottomMargin : I
    //   963: iadd
    //   964: aload_0
    //   965: aload #62
    //   967: invokevirtual b : (Landroid/view/View;)I
    //   970: iadd
    //   971: invokestatic max : (II)I
    //   974: istore #65
    //   976: goto -> 894
    //   979: iinc #61, 1
    //   982: bipush #8
    //   984: istore #18
    //   986: goto -> 861
    //   989: iload #25
    //   991: istore #27
    //   993: aload_0
    //   994: aload_0
    //   995: getfield f : I
    //   998: aload_0
    //   999: invokevirtual getPaddingTop : ()I
    //   1002: aload_0
    //   1003: invokevirtual getPaddingBottom : ()I
    //   1006: iadd
    //   1007: iadd
    //   1008: putfield f : I
    //   1011: aload_0
    //   1012: getfield f : I
    //   1015: aload_0
    //   1016: invokevirtual getSuggestedMinimumHeight : ()I
    //   1019: invokestatic max : (II)I
    //   1022: iload_2
    //   1023: iconst_0
    //   1024: invokestatic resolveSizeAndState : (III)I
    //   1027: istore #28
    //   1029: ldc 16777215
    //   1031: iload #28
    //   1033: iand
    //   1034: aload_0
    //   1035: getfield f : I
    //   1038: isub
    //   1039: istore #29
    //   1041: iload #15
    //   1043: ifne -> 1172
    //   1046: iload #29
    //   1048: ifeq -> 1061
    //   1051: fload #8
    //   1053: fconst_0
    //   1054: fcmpl
    //   1055: ifle -> 1061
    //   1058: goto -> 1172
    //   1061: iload #22
    //   1063: iload #19
    //   1065: invokestatic max : (II)I
    //   1068: istore #36
    //   1070: iload #7
    //   1072: ifeq -> 1162
    //   1075: iload #27
    //   1077: ldc 1073741824
    //   1079: if_icmpeq -> 1162
    //   1082: iconst_0
    //   1083: istore #59
    //   1085: iload #59
    //   1087: iload #26
    //   1089: if_icmpge -> 1162
    //   1092: aload_0
    //   1093: iload #59
    //   1095: invokevirtual b : (I)Landroid/view/View;
    //   1098: astore #60
    //   1100: aload #60
    //   1102: ifnull -> 1156
    //   1105: aload #60
    //   1107: invokevirtual getVisibility : ()I
    //   1110: bipush #8
    //   1112: if_icmpne -> 1118
    //   1115: goto -> 1156
    //   1118: aload #60
    //   1120: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1123: checkcast android/support/v7/widget/as$a
    //   1126: getfield g : F
    //   1129: fconst_0
    //   1130: fcmpl
    //   1131: ifle -> 1156
    //   1134: aload #60
    //   1136: aload #60
    //   1138: invokevirtual getMeasuredWidth : ()I
    //   1141: ldc 1073741824
    //   1143: invokestatic makeMeasureSpec : (II)I
    //   1146: iload #21
    //   1148: ldc 1073741824
    //   1150: invokestatic makeMeasureSpec : (II)I
    //   1153: invokevirtual measure : (II)V
    //   1156: iinc #59, 1
    //   1159: goto -> 1085
    //   1162: iload #20
    //   1164: istore #34
    //   1166: iload_1
    //   1167: istore #35
    //   1169: goto -> 1650
    //   1172: aload_0
    //   1173: getfield g : F
    //   1176: fstore #30
    //   1178: fload #30
    //   1180: fconst_0
    //   1181: fcmpl
    //   1182: ifle -> 1189
    //   1185: fload #30
    //   1187: fstore #8
    //   1189: aload_0
    //   1190: iconst_0
    //   1191: putfield f : I
    //   1194: fload #8
    //   1196: fstore #31
    //   1198: iconst_0
    //   1199: istore #32
    //   1201: iload #22
    //   1203: istore #33
    //   1205: iload #20
    //   1207: istore #34
    //   1209: iload #32
    //   1211: iload #26
    //   1213: if_icmpge -> 1625
    //   1216: aload_0
    //   1217: iload #32
    //   1219: invokevirtual b : (I)Landroid/view/View;
    //   1222: astore #37
    //   1224: aload #37
    //   1226: invokevirtual getVisibility : ()I
    //   1229: bipush #8
    //   1231: if_icmpne -> 1241
    //   1234: fload #31
    //   1236: fstore #42
    //   1238: goto -> 1615
    //   1241: aload #37
    //   1243: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1246: checkcast android/support/v7/widget/as$a
    //   1249: astore #38
    //   1251: aload #38
    //   1253: getfield g : F
    //   1256: fstore #39
    //   1258: fload #39
    //   1260: fconst_0
    //   1261: fcmpl
    //   1262: ifle -> 1428
    //   1265: fload #39
    //   1267: iload #29
    //   1269: i2f
    //   1270: fmul
    //   1271: fload #31
    //   1273: fdiv
    //   1274: f2i
    //   1275: istore #51
    //   1277: fload #31
    //   1279: fload #39
    //   1281: fsub
    //   1282: fstore #52
    //   1284: iload #29
    //   1286: iload #51
    //   1288: isub
    //   1289: istore #53
    //   1291: aload_0
    //   1292: invokevirtual getPaddingLeft : ()I
    //   1295: aload_0
    //   1296: invokevirtual getPaddingRight : ()I
    //   1299: iadd
    //   1300: istore #54
    //   1302: iload #53
    //   1304: istore #41
    //   1306: iload #54
    //   1308: aload #38
    //   1310: getfield leftMargin : I
    //   1313: iadd
    //   1314: aload #38
    //   1316: getfield rightMargin : I
    //   1319: iadd
    //   1320: istore #55
    //   1322: aload #38
    //   1324: getfield width : I
    //   1327: istore #56
    //   1329: fload #52
    //   1331: fstore #42
    //   1333: iload_1
    //   1334: iload #55
    //   1336: iload #56
    //   1338: invokestatic getChildMeasureSpec : (III)I
    //   1341: istore #57
    //   1343: aload #38
    //   1345: getfield height : I
    //   1348: ifne -> 1373
    //   1351: ldc 1073741824
    //   1353: istore #58
    //   1355: iload #27
    //   1357: iload #58
    //   1359: if_icmpeq -> 1365
    //   1362: goto -> 1377
    //   1365: iload #51
    //   1367: ifle -> 1392
    //   1370: goto -> 1395
    //   1373: ldc 1073741824
    //   1375: istore #58
    //   1377: iload #51
    //   1379: aload #37
    //   1381: invokevirtual getMeasuredHeight : ()I
    //   1384: iadd
    //   1385: istore #51
    //   1387: iload #51
    //   1389: ifge -> 1395
    //   1392: iconst_0
    //   1393: istore #51
    //   1395: aload #37
    //   1397: iload #57
    //   1399: iload #51
    //   1401: iload #58
    //   1403: invokestatic makeMeasureSpec : (II)I
    //   1406: invokevirtual measure : (II)V
    //   1409: iload #34
    //   1411: sipush #-256
    //   1414: aload #37
    //   1416: invokevirtual getMeasuredState : ()I
    //   1419: iand
    //   1420: invokestatic combineMeasuredStates : (II)I
    //   1423: istore #34
    //   1425: goto -> 1440
    //   1428: fload #31
    //   1430: fstore #40
    //   1432: iload #29
    //   1434: istore #41
    //   1436: fload #40
    //   1438: fstore #42
    //   1440: aload #38
    //   1442: getfield leftMargin : I
    //   1445: aload #38
    //   1447: getfield rightMargin : I
    //   1450: iadd
    //   1451: istore #43
    //   1453: iload #43
    //   1455: aload #37
    //   1457: invokevirtual getMeasuredWidth : ()I
    //   1460: iadd
    //   1461: istore #44
    //   1463: iload #24
    //   1465: iload #44
    //   1467: invokestatic max : (II)I
    //   1470: istore #24
    //   1472: iload #4
    //   1474: ldc 1073741824
    //   1476: if_icmpeq -> 1506
    //   1479: aload #38
    //   1481: getfield width : I
    //   1484: istore #50
    //   1486: iload #34
    //   1488: istore #45
    //   1490: iconst_m1
    //   1491: istore #46
    //   1493: iload #50
    //   1495: iload #46
    //   1497: if_icmpne -> 1513
    //   1500: iconst_1
    //   1501: istore #47
    //   1503: goto -> 1516
    //   1506: iload #34
    //   1508: istore #45
    //   1510: iconst_m1
    //   1511: istore #46
    //   1513: iconst_0
    //   1514: istore #47
    //   1516: iload #47
    //   1518: ifeq -> 1524
    //   1521: goto -> 1528
    //   1524: iload #44
    //   1526: istore #43
    //   1528: iload #33
    //   1530: iload #43
    //   1532: invokestatic max : (II)I
    //   1535: istore #33
    //   1537: iload #16
    //   1539: ifeq -> 1558
    //   1542: aload #38
    //   1544: getfield width : I
    //   1547: iload #46
    //   1549: if_icmpne -> 1558
    //   1552: iconst_1
    //   1553: istore #48
    //   1555: goto -> 1561
    //   1558: iconst_0
    //   1559: istore #48
    //   1561: aload_0
    //   1562: getfield f : I
    //   1565: istore #49
    //   1567: aload_0
    //   1568: iload #49
    //   1570: iload #49
    //   1572: aload #37
    //   1574: invokevirtual getMeasuredHeight : ()I
    //   1577: iadd
    //   1578: aload #38
    //   1580: getfield topMargin : I
    //   1583: iadd
    //   1584: aload #38
    //   1586: getfield bottomMargin : I
    //   1589: iadd
    //   1590: aload_0
    //   1591: aload #37
    //   1593: invokevirtual b : (Landroid/view/View;)I
    //   1596: iadd
    //   1597: invokestatic max : (II)I
    //   1600: putfield f : I
    //   1603: iload #48
    //   1605: istore #16
    //   1607: iload #41
    //   1609: istore #29
    //   1611: iload #45
    //   1613: istore #34
    //   1615: iinc #32, 1
    //   1618: fload #42
    //   1620: fstore #31
    //   1622: goto -> 1209
    //   1625: iload_1
    //   1626: istore #35
    //   1628: aload_0
    //   1629: aload_0
    //   1630: getfield f : I
    //   1633: aload_0
    //   1634: invokevirtual getPaddingTop : ()I
    //   1637: aload_0
    //   1638: invokevirtual getPaddingBottom : ()I
    //   1641: iadd
    //   1642: iadd
    //   1643: putfield f : I
    //   1646: iload #33
    //   1648: istore #36
    //   1650: iload #16
    //   1652: ifne -> 1665
    //   1655: iload #4
    //   1657: ldc 1073741824
    //   1659: if_icmpeq -> 1665
    //   1662: goto -> 1669
    //   1665: iload #24
    //   1667: istore #36
    //   1669: aload_0
    //   1670: iload #36
    //   1672: aload_0
    //   1673: invokevirtual getPaddingLeft : ()I
    //   1676: aload_0
    //   1677: invokevirtual getPaddingRight : ()I
    //   1680: iadd
    //   1681: iadd
    //   1682: aload_0
    //   1683: invokevirtual getSuggestedMinimumWidth : ()I
    //   1686: invokestatic max : (II)I
    //   1689: iload #35
    //   1691: iload #34
    //   1693: invokestatic resolveSizeAndState : (III)I
    //   1696: iload #28
    //   1698: invokevirtual setMeasuredDimension : (II)V
    //   1701: iload #17
    //   1703: ifeq -> 1713
    //   1706: aload_0
    //   1707: iload #26
    //   1709: iload_2
    //   1710: invokespecial c : (II)V
    //   1713: return }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i9;
    int i1 = getPaddingLeft();
    int i2 = paramInt3 - paramInt1;
    int i3 = i2 - getPaddingRight();
    int i4 = i2 - i1 - getPaddingRight();
    int i5 = getVirtualChildCount();
    int i6 = this.e;
    int i7 = i6 & 0x70;
    int i8 = i6 & 0x800007;
    if (i7 != 16) {
      if (i7 != 80) {
        i9 = getPaddingTop();
      } else {
        i9 = paramInt4 + getPaddingTop() - paramInt2 - this.f;
      } 
    } else {
      i9 = getPaddingTop() + (paramInt4 - paramInt2 - this.f) / 2;
    } 
    for (int i10 = 0; i10 < i5; i10++) {
      View view = b(i10);
      if (view == null) {
        i9 += d(i10);
      } else if (view.getVisibility() != 8) {
        int i15;
        int i11 = view.getMeasuredWidth();
        int i12 = view.getMeasuredHeight();
        a a1 = (a)view.getLayoutParams();
        int i13 = a1.h;
        if (i13 < 0)
          i13 = i8; 
        int i14 = 0x7 & d.a(i13, r.f(this));
        if (i14 != 1) {
          int i18;
          if (i14 != 5) {
            i18 = i1 + a1.leftMargin;
          } else {
            int i19 = i3 - i11;
            i18 = i19 - a1.rightMargin;
          } 
          i15 = i18;
        } else {
          int i18 = i1 + (i4 - i11) / 2 + a1.leftMargin;
          int i19 = i18 - a1.rightMargin;
        } 
        if (c(i10))
          i9 += this.m; 
        int i16 = i9 + a1.topMargin;
        a(view, i15, i16 + a(view), i11, i12);
        int i17 = i16 + i12 + a1.bottomMargin + b(view);
        i10 += a(view, i10);
        i9 = i17;
      } 
    } 
  }
  
  void a(Canvas paramCanvas) {
    int i1 = getVirtualChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = b(b1);
      if (view != null && view.getVisibility() != 8 && c(b1)) {
        a a1 = (a)view.getLayoutParams();
        a(paramCanvas, view.getTop() - a1.topMargin - this.m);
      } 
    } 
    if (c(i1)) {
      int i2;
      View view = b(i1 - 1);
      if (view == null) {
        i2 = getHeight() - getPaddingBottom() - this.m;
      } else {
        a a1 = (a)view.getLayoutParams();
        i2 = view.getBottom() + a1.bottomMargin;
      } 
      a(paramCanvas, i2);
    } 
  }
  
  void a(Canvas paramCanvas, int paramInt) {
    this.k.setBounds(getPaddingLeft() + this.o, paramInt, getWidth() - getPaddingRight() - this.o, paramInt + this.m);
    this.k.draw(paramCanvas);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) { measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5); }
  
  int b(View paramView) { return 0; }
  
  public a b(AttributeSet paramAttributeSet) { return new a(getContext(), paramAttributeSet); }
  
  protected a b(ViewGroup.LayoutParams paramLayoutParams) { return new a(paramLayoutParams); }
  
  View b(int paramInt) { return getChildAt(paramInt); }
  
  void b(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield f : I
    //   5: aload_0
    //   6: invokevirtual getVirtualChildCount : ()I
    //   9: istore_3
    //   10: iload_1
    //   11: invokestatic getMode : (I)I
    //   14: istore #4
    //   16: iload_2
    //   17: invokestatic getMode : (I)I
    //   20: istore #5
    //   22: aload_0
    //   23: getfield i : [I
    //   26: ifnull -> 36
    //   29: aload_0
    //   30: getfield j : [I
    //   33: ifnonnull -> 50
    //   36: aload_0
    //   37: iconst_4
    //   38: newarray int
    //   40: putfield i : [I
    //   43: aload_0
    //   44: iconst_4
    //   45: newarray int
    //   47: putfield j : [I
    //   50: aload_0
    //   51: getfield i : [I
    //   54: astore #6
    //   56: aload_0
    //   57: getfield j : [I
    //   60: astore #7
    //   62: aload #6
    //   64: iconst_3
    //   65: iconst_m1
    //   66: iastore
    //   67: aload #6
    //   69: iconst_2
    //   70: iconst_m1
    //   71: iastore
    //   72: aload #6
    //   74: iconst_1
    //   75: iconst_m1
    //   76: iastore
    //   77: aload #6
    //   79: iconst_0
    //   80: iconst_m1
    //   81: iastore
    //   82: aload #7
    //   84: iconst_3
    //   85: iconst_m1
    //   86: iastore
    //   87: aload #7
    //   89: iconst_2
    //   90: iconst_m1
    //   91: iastore
    //   92: aload #7
    //   94: iconst_1
    //   95: iconst_m1
    //   96: iastore
    //   97: aload #7
    //   99: iconst_0
    //   100: iconst_m1
    //   101: iastore
    //   102: aload_0
    //   103: getfield a : Z
    //   106: istore #8
    //   108: aload_0
    //   109: getfield h : Z
    //   112: istore #9
    //   114: ldc 1073741824
    //   116: istore #10
    //   118: iload #4
    //   120: iload #10
    //   122: if_icmpne -> 131
    //   125: iconst_1
    //   126: istore #11
    //   128: goto -> 134
    //   131: iconst_0
    //   132: istore #11
    //   134: fconst_0
    //   135: fstore #12
    //   137: iconst_0
    //   138: istore #13
    //   140: iconst_0
    //   141: istore #14
    //   143: iconst_0
    //   144: istore #15
    //   146: iconst_0
    //   147: istore #16
    //   149: iconst_0
    //   150: istore #17
    //   152: iconst_0
    //   153: istore #18
    //   155: iconst_0
    //   156: istore #19
    //   158: iconst_1
    //   159: istore #20
    //   161: iconst_0
    //   162: istore #21
    //   164: aload #7
    //   166: astore #22
    //   168: iload #13
    //   170: iload_3
    //   171: if_icmpge -> 959
    //   174: aload_0
    //   175: iload #13
    //   177: invokevirtual b : (I)Landroid/view/View;
    //   180: astore #82
    //   182: aload #82
    //   184: ifnonnull -> 213
    //   187: aload_0
    //   188: aload_0
    //   189: getfield f : I
    //   192: aload_0
    //   193: iload #13
    //   195: invokevirtual d : (I)I
    //   198: iadd
    //   199: putfield f : I
    //   202: iload #9
    //   204: istore #90
    //   206: iload #8
    //   208: istore #91
    //   210: goto -> 937
    //   213: aload #82
    //   215: invokevirtual getVisibility : ()I
    //   218: bipush #8
    //   220: if_icmpne -> 239
    //   223: iload #13
    //   225: aload_0
    //   226: aload #82
    //   228: iload #13
    //   230: invokevirtual a : (Landroid/view/View;I)I
    //   233: iadd
    //   234: istore #13
    //   236: goto -> 202
    //   239: aload_0
    //   240: iload #13
    //   242: invokevirtual c : (I)Z
    //   245: ifeq -> 261
    //   248: aload_0
    //   249: aload_0
    //   250: getfield f : I
    //   253: aload_0
    //   254: getfield l : I
    //   257: iadd
    //   258: putfield f : I
    //   261: aload #82
    //   263: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   266: checkcast android/support/v7/widget/as$a
    //   269: astore #83
    //   271: fload #12
    //   273: aload #83
    //   275: getfield g : F
    //   278: fadd
    //   279: fstore #84
    //   281: iload #4
    //   283: iload #10
    //   285: if_icmpne -> 431
    //   288: aload #83
    //   290: getfield width : I
    //   293: ifne -> 431
    //   296: aload #83
    //   298: getfield g : F
    //   301: fconst_0
    //   302: fcmpl
    //   303: ifle -> 431
    //   306: iload #11
    //   308: ifeq -> 332
    //   311: aload_0
    //   312: getfield f : I
    //   315: aload #83
    //   317: getfield leftMargin : I
    //   320: aload #83
    //   322: getfield rightMargin : I
    //   325: iadd
    //   326: iadd
    //   327: istore #113
    //   329: goto -> 359
    //   332: aload_0
    //   333: getfield f : I
    //   336: istore #112
    //   338: iload #112
    //   340: iload #112
    //   342: aload #83
    //   344: getfield leftMargin : I
    //   347: iadd
    //   348: aload #83
    //   350: getfield rightMargin : I
    //   353: iadd
    //   354: invokestatic max : (II)I
    //   357: istore #113
    //   359: aload_0
    //   360: iload #113
    //   362: putfield f : I
    //   365: iload #8
    //   367: ifeq -> 405
    //   370: iconst_0
    //   371: iconst_0
    //   372: invokestatic makeMeasureSpec : (II)I
    //   375: istore #114
    //   377: aload #82
    //   379: iload #114
    //   381: iload #114
    //   383: invokevirtual measure : (II)V
    //   386: iload #13
    //   388: istore #87
    //   390: iload #9
    //   392: istore #90
    //   394: iload #8
    //   396: istore #91
    //   398: aload #82
    //   400: astore #93
    //   402: goto -> 648
    //   405: iload #13
    //   407: istore #87
    //   409: iload #9
    //   411: istore #90
    //   413: iload #8
    //   415: istore #91
    //   417: aload #82
    //   419: astore #93
    //   421: ldc 1073741824
    //   423: istore #96
    //   425: iconst_1
    //   426: istore #18
    //   428: goto -> 652
    //   431: aload #83
    //   433: getfield width : I
    //   436: ifne -> 462
    //   439: aload #83
    //   441: getfield g : F
    //   444: fconst_0
    //   445: fcmpl
    //   446: ifle -> 462
    //   449: aload #83
    //   451: bipush #-2
    //   453: putfield width : I
    //   456: iconst_0
    //   457: istore #85
    //   459: goto -> 466
    //   462: ldc -2147483648
    //   464: istore #85
    //   466: fload #84
    //   468: fconst_0
    //   469: fcmpl
    //   470: ifne -> 482
    //   473: aload_0
    //   474: getfield f : I
    //   477: istore #86
    //   479: goto -> 485
    //   482: iconst_0
    //   483: istore #86
    //   485: iload #13
    //   487: istore #87
    //   489: iload #85
    //   491: istore #88
    //   493: iload #87
    //   495: istore #89
    //   497: iload #9
    //   499: istore #90
    //   501: iload #8
    //   503: istore #91
    //   505: aload_0
    //   506: aload #82
    //   508: iload #89
    //   510: iload_1
    //   511: iload #86
    //   513: iload_2
    //   514: iconst_0
    //   515: invokevirtual a : (Landroid/view/View;IIIII)V
    //   518: iload #88
    //   520: ldc -2147483648
    //   522: if_icmpeq -> 532
    //   525: aload #83
    //   527: iload #88
    //   529: putfield width : I
    //   532: aload #82
    //   534: invokevirtual getMeasuredWidth : ()I
    //   537: istore #92
    //   539: iload #11
    //   541: ifeq -> 587
    //   544: aload_0
    //   545: getfield f : I
    //   548: istore #110
    //   550: iload #92
    //   552: aload #83
    //   554: getfield leftMargin : I
    //   557: iadd
    //   558: aload #83
    //   560: getfield rightMargin : I
    //   563: iadd
    //   564: istore #111
    //   566: aload #82
    //   568: astore #93
    //   570: iload #110
    //   572: iload #111
    //   574: aload_0
    //   575: aload #93
    //   577: invokevirtual b : (Landroid/view/View;)I
    //   580: iadd
    //   581: iadd
    //   582: istore #95
    //   584: goto -> 628
    //   587: aload #82
    //   589: astore #93
    //   591: aload_0
    //   592: getfield f : I
    //   595: istore #94
    //   597: iload #94
    //   599: iload #94
    //   601: iload #92
    //   603: iadd
    //   604: aload #83
    //   606: getfield leftMargin : I
    //   609: iadd
    //   610: aload #83
    //   612: getfield rightMargin : I
    //   615: iadd
    //   616: aload_0
    //   617: aload #93
    //   619: invokevirtual b : (Landroid/view/View;)I
    //   622: iadd
    //   623: invokestatic max : (II)I
    //   626: istore #95
    //   628: aload_0
    //   629: iload #95
    //   631: putfield f : I
    //   634: iload #90
    //   636: ifeq -> 648
    //   639: iload #92
    //   641: iload #14
    //   643: invokestatic max : (II)I
    //   646: istore #14
    //   648: ldc 1073741824
    //   650: istore #96
    //   652: iload #5
    //   654: iload #96
    //   656: if_icmpeq -> 677
    //   659: aload #83
    //   661: getfield height : I
    //   664: iconst_m1
    //   665: if_icmpne -> 677
    //   668: iconst_1
    //   669: istore #97
    //   671: iconst_1
    //   672: istore #21
    //   674: goto -> 680
    //   677: iconst_0
    //   678: istore #97
    //   680: aload #83
    //   682: getfield topMargin : I
    //   685: aload #83
    //   687: getfield bottomMargin : I
    //   690: iadd
    //   691: istore #98
    //   693: iload #98
    //   695: aload #93
    //   697: invokevirtual getMeasuredHeight : ()I
    //   700: iadd
    //   701: istore #99
    //   703: aload #93
    //   705: invokevirtual getMeasuredState : ()I
    //   708: istore #100
    //   710: iload #19
    //   712: iload #100
    //   714: invokestatic combineMeasuredStates : (II)I
    //   717: istore #101
    //   719: iload #91
    //   721: ifeq -> 808
    //   724: aload #93
    //   726: invokevirtual getBaseline : ()I
    //   729: istore #107
    //   731: iload #107
    //   733: iconst_m1
    //   734: if_icmpeq -> 808
    //   737: aload #83
    //   739: getfield h : I
    //   742: ifge -> 754
    //   745: aload_0
    //   746: getfield e : I
    //   749: istore #108
    //   751: goto -> 761
    //   754: aload #83
    //   756: getfield h : I
    //   759: istore #108
    //   761: bipush #-2
    //   763: iload #108
    //   765: bipush #112
    //   767: iand
    //   768: iconst_4
    //   769: ishr
    //   770: iand
    //   771: iconst_1
    //   772: ishr
    //   773: istore #109
    //   775: aload #6
    //   777: iload #109
    //   779: aload #6
    //   781: iload #109
    //   783: iaload
    //   784: iload #107
    //   786: invokestatic max : (II)I
    //   789: iastore
    //   790: aload #22
    //   792: iload #109
    //   794: aload #22
    //   796: iload #109
    //   798: iaload
    //   799: iload #99
    //   801: iload #107
    //   803: isub
    //   804: invokestatic max : (II)I
    //   807: iastore
    //   808: iload #15
    //   810: iload #99
    //   812: invokestatic max : (II)I
    //   815: istore #102
    //   817: iload #20
    //   819: ifeq -> 837
    //   822: aload #83
    //   824: getfield height : I
    //   827: iconst_m1
    //   828: if_icmpne -> 837
    //   831: iconst_1
    //   832: istore #103
    //   834: goto -> 840
    //   837: iconst_0
    //   838: istore #103
    //   840: aload #83
    //   842: getfield g : F
    //   845: fconst_0
    //   846: fcmpl
    //   847: ifle -> 874
    //   850: iload #97
    //   852: ifeq -> 858
    //   855: goto -> 862
    //   858: iload #99
    //   860: istore #98
    //   862: iload #17
    //   864: iload #98
    //   866: invokestatic max : (II)I
    //   869: istore #17
    //   871: goto -> 900
    //   874: iload #17
    //   876: istore #104
    //   878: iload #97
    //   880: ifeq -> 887
    //   883: iload #98
    //   885: istore #99
    //   887: iload #16
    //   889: iload #99
    //   891: invokestatic max : (II)I
    //   894: istore #16
    //   896: iload #104
    //   898: istore #17
    //   900: iload #87
    //   902: istore #105
    //   904: iload #105
    //   906: aload_0
    //   907: aload #93
    //   909: iload #105
    //   911: invokevirtual a : (Landroid/view/View;I)I
    //   914: iadd
    //   915: istore #106
    //   917: iload #102
    //   919: istore #15
    //   921: iload #101
    //   923: istore #19
    //   925: iload #103
    //   927: istore #20
    //   929: iload #106
    //   931: istore #13
    //   933: fload #84
    //   935: fstore #12
    //   937: iinc #13, 1
    //   940: aload #22
    //   942: astore #7
    //   944: iload #90
    //   946: istore #9
    //   948: iload #91
    //   950: istore #8
    //   952: ldc 1073741824
    //   954: istore #10
    //   956: goto -> 164
    //   959: iload #9
    //   961: istore #23
    //   963: iload #8
    //   965: istore #24
    //   967: iload #15
    //   969: istore #25
    //   971: iload #16
    //   973: istore #26
    //   975: iload #17
    //   977: istore #27
    //   979: iload #19
    //   981: istore #28
    //   983: aload_0
    //   984: getfield f : I
    //   987: ifle -> 1011
    //   990: aload_0
    //   991: iload_3
    //   992: invokevirtual c : (I)Z
    //   995: ifeq -> 1011
    //   998: aload_0
    //   999: aload_0
    //   1000: getfield f : I
    //   1003: aload_0
    //   1004: getfield l : I
    //   1007: iadd
    //   1008: putfield f : I
    //   1011: aload #6
    //   1013: iconst_1
    //   1014: iaload
    //   1015: iconst_m1
    //   1016: if_icmpne -> 1053
    //   1019: aload #6
    //   1021: iconst_0
    //   1022: iaload
    //   1023: iconst_m1
    //   1024: if_icmpne -> 1053
    //   1027: aload #6
    //   1029: iconst_2
    //   1030: iaload
    //   1031: iconst_m1
    //   1032: if_icmpne -> 1053
    //   1035: aload #6
    //   1037: iconst_3
    //   1038: iaload
    //   1039: iconst_m1
    //   1040: if_icmpeq -> 1046
    //   1043: goto -> 1053
    //   1046: iload #28
    //   1048: istore #33
    //   1050: goto -> 1131
    //   1053: aload #6
    //   1055: iconst_3
    //   1056: iaload
    //   1057: aload #6
    //   1059: iconst_0
    //   1060: iaload
    //   1061: aload #6
    //   1063: iconst_1
    //   1064: iaload
    //   1065: aload #6
    //   1067: iconst_2
    //   1068: iaload
    //   1069: invokestatic max : (II)I
    //   1072: invokestatic max : (II)I
    //   1075: invokestatic max : (II)I
    //   1078: istore #29
    //   1080: aload #22
    //   1082: iconst_3
    //   1083: iaload
    //   1084: istore #30
    //   1086: aload #22
    //   1088: iconst_0
    //   1089: iaload
    //   1090: istore #31
    //   1092: aload #22
    //   1094: iconst_1
    //   1095: iaload
    //   1096: istore #32
    //   1098: iload #28
    //   1100: istore #33
    //   1102: iload #25
    //   1104: iload #29
    //   1106: iload #30
    //   1108: iload #31
    //   1110: iload #32
    //   1112: aload #22
    //   1114: iconst_2
    //   1115: iaload
    //   1116: invokestatic max : (II)I
    //   1119: invokestatic max : (II)I
    //   1122: invokestatic max : (II)I
    //   1125: iadd
    //   1126: invokestatic max : (II)I
    //   1129: istore #25
    //   1131: iload #23
    //   1133: ifeq -> 1328
    //   1136: iload #4
    //   1138: ldc -2147483648
    //   1140: if_icmpeq -> 1148
    //   1143: iload #4
    //   1145: ifne -> 1328
    //   1148: aload_0
    //   1149: iconst_0
    //   1150: putfield f : I
    //   1153: iconst_0
    //   1154: istore #76
    //   1156: iload #76
    //   1158: iload_3
    //   1159: if_icmpge -> 1328
    //   1162: aload_0
    //   1163: iload #76
    //   1165: invokevirtual b : (I)Landroid/view/View;
    //   1168: astore #77
    //   1170: aload #77
    //   1172: ifnonnull -> 1193
    //   1175: aload_0
    //   1176: aload_0
    //   1177: getfield f : I
    //   1180: aload_0
    //   1181: iload #76
    //   1183: invokevirtual d : (I)I
    //   1186: iadd
    //   1187: putfield f : I
    //   1190: goto -> 1216
    //   1193: aload #77
    //   1195: invokevirtual getVisibility : ()I
    //   1198: bipush #8
    //   1200: if_icmpne -> 1223
    //   1203: iload #76
    //   1205: aload_0
    //   1206: aload #77
    //   1208: iload #76
    //   1210: invokevirtual a : (Landroid/view/View;I)I
    //   1213: iadd
    //   1214: istore #76
    //   1216: iload #25
    //   1218: istore #81
    //   1220: goto -> 1318
    //   1223: aload #77
    //   1225: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1228: checkcast android/support/v7/widget/as$a
    //   1231: astore #78
    //   1233: iload #11
    //   1235: ifeq -> 1271
    //   1238: aload_0
    //   1239: aload_0
    //   1240: getfield f : I
    //   1243: iload #14
    //   1245: aload #78
    //   1247: getfield leftMargin : I
    //   1250: iadd
    //   1251: aload #78
    //   1253: getfield rightMargin : I
    //   1256: iadd
    //   1257: aload_0
    //   1258: aload #77
    //   1260: invokevirtual b : (Landroid/view/View;)I
    //   1263: iadd
    //   1264: iadd
    //   1265: putfield f : I
    //   1268: goto -> 1216
    //   1271: aload_0
    //   1272: getfield f : I
    //   1275: istore #79
    //   1277: iload #79
    //   1279: iload #14
    //   1281: iadd
    //   1282: istore #80
    //   1284: iload #25
    //   1286: istore #81
    //   1288: aload_0
    //   1289: iload #79
    //   1291: iload #80
    //   1293: aload #78
    //   1295: getfield leftMargin : I
    //   1298: iadd
    //   1299: aload #78
    //   1301: getfield rightMargin : I
    //   1304: iadd
    //   1305: aload_0
    //   1306: aload #77
    //   1308: invokevirtual b : (Landroid/view/View;)I
    //   1311: iadd
    //   1312: invokestatic max : (II)I
    //   1315: putfield f : I
    //   1318: iinc #76, 1
    //   1321: iload #81
    //   1323: istore #25
    //   1325: goto -> 1156
    //   1328: iload #25
    //   1330: istore #34
    //   1332: aload_0
    //   1333: aload_0
    //   1334: getfield f : I
    //   1337: aload_0
    //   1338: invokevirtual getPaddingLeft : ()I
    //   1341: aload_0
    //   1342: invokevirtual getPaddingRight : ()I
    //   1345: iadd
    //   1346: iadd
    //   1347: putfield f : I
    //   1350: aload_0
    //   1351: getfield f : I
    //   1354: aload_0
    //   1355: invokevirtual getSuggestedMinimumWidth : ()I
    //   1358: invokestatic max : (II)I
    //   1361: iload_1
    //   1362: iconst_0
    //   1363: invokestatic resolveSizeAndState : (III)I
    //   1366: istore #35
    //   1368: ldc 16777215
    //   1370: iload #35
    //   1372: iand
    //   1373: aload_0
    //   1374: getfield f : I
    //   1377: isub
    //   1378: istore #36
    //   1380: iload #18
    //   1382: ifne -> 1513
    //   1385: iload #36
    //   1387: ifeq -> 1400
    //   1390: fload #12
    //   1392: fconst_0
    //   1393: fcmpl
    //   1394: ifle -> 1400
    //   1397: goto -> 1513
    //   1400: iload #26
    //   1402: iload #27
    //   1404: invokestatic max : (II)I
    //   1407: istore #47
    //   1409: iload #23
    //   1411: ifeq -> 1500
    //   1414: iload #4
    //   1416: ldc 1073741824
    //   1418: if_icmpeq -> 1500
    //   1421: iconst_0
    //   1422: istore #74
    //   1424: iload #74
    //   1426: iload_3
    //   1427: if_icmpge -> 1500
    //   1430: aload_0
    //   1431: iload #74
    //   1433: invokevirtual b : (I)Landroid/view/View;
    //   1436: astore #75
    //   1438: aload #75
    //   1440: ifnull -> 1494
    //   1443: aload #75
    //   1445: invokevirtual getVisibility : ()I
    //   1448: bipush #8
    //   1450: if_icmpne -> 1456
    //   1453: goto -> 1494
    //   1456: aload #75
    //   1458: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1461: checkcast android/support/v7/widget/as$a
    //   1464: getfield g : F
    //   1467: fconst_0
    //   1468: fcmpl
    //   1469: ifle -> 1494
    //   1472: aload #75
    //   1474: iload #14
    //   1476: ldc 1073741824
    //   1478: invokestatic makeMeasureSpec : (II)I
    //   1481: aload #75
    //   1483: invokevirtual getMeasuredHeight : ()I
    //   1486: ldc 1073741824
    //   1488: invokestatic makeMeasureSpec : (II)I
    //   1491: invokevirtual measure : (II)V
    //   1494: iinc #74, 1
    //   1497: goto -> 1424
    //   1500: iload_3
    //   1501: istore #43
    //   1503: iload #34
    //   1505: istore #46
    //   1507: iload_2
    //   1508: istore #44
    //   1510: goto -> 2289
    //   1513: aload_0
    //   1514: getfield g : F
    //   1517: fstore #37
    //   1519: fload #37
    //   1521: fconst_0
    //   1522: fcmpl
    //   1523: ifle -> 1530
    //   1526: fload #37
    //   1528: fstore #12
    //   1530: aload #6
    //   1532: iconst_3
    //   1533: iconst_m1
    //   1534: iastore
    //   1535: aload #6
    //   1537: iconst_2
    //   1538: iconst_m1
    //   1539: iastore
    //   1540: aload #6
    //   1542: iconst_1
    //   1543: iconst_m1
    //   1544: iastore
    //   1545: aload #6
    //   1547: iconst_0
    //   1548: iconst_m1
    //   1549: iastore
    //   1550: aload #22
    //   1552: iconst_3
    //   1553: iconst_m1
    //   1554: iastore
    //   1555: aload #22
    //   1557: iconst_2
    //   1558: iconst_m1
    //   1559: iastore
    //   1560: aload #22
    //   1562: iconst_1
    //   1563: iconst_m1
    //   1564: iastore
    //   1565: aload #22
    //   1567: iconst_0
    //   1568: iconst_m1
    //   1569: iastore
    //   1570: aload_0
    //   1571: iconst_0
    //   1572: putfield f : I
    //   1575: iload #26
    //   1577: istore #38
    //   1579: iload #33
    //   1581: istore #39
    //   1583: iconst_m1
    //   1584: istore #40
    //   1586: fload #12
    //   1588: fstore #41
    //   1590: iconst_0
    //   1591: istore #42
    //   1593: iload #42
    //   1595: iload_3
    //   1596: if_icmpge -> 2153
    //   1599: aload_0
    //   1600: iload #42
    //   1602: invokevirtual b : (I)Landroid/view/View;
    //   1605: astore #49
    //   1607: aload #49
    //   1609: ifnull -> 2133
    //   1612: aload #49
    //   1614: invokevirtual getVisibility : ()I
    //   1617: bipush #8
    //   1619: if_icmpne -> 1625
    //   1622: goto -> 2133
    //   1625: aload #49
    //   1627: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1630: checkcast android/support/v7/widget/as$a
    //   1633: astore #52
    //   1635: aload #52
    //   1637: getfield g : F
    //   1640: fstore #53
    //   1642: fload #53
    //   1644: fconst_0
    //   1645: fcmpl
    //   1646: ifle -> 1811
    //   1649: fload #53
    //   1651: iload #36
    //   1653: i2f
    //   1654: fmul
    //   1655: fload #41
    //   1657: fdiv
    //   1658: f2i
    //   1659: istore #67
    //   1661: fload #41
    //   1663: fload #53
    //   1665: fsub
    //   1666: fstore #68
    //   1668: iload #36
    //   1670: iload #67
    //   1672: isub
    //   1673: istore #69
    //   1675: aload_0
    //   1676: invokevirtual getPaddingTop : ()I
    //   1679: aload_0
    //   1680: invokevirtual getPaddingBottom : ()I
    //   1683: iadd
    //   1684: aload #52
    //   1686: getfield topMargin : I
    //   1689: iadd
    //   1690: aload #52
    //   1692: getfield bottomMargin : I
    //   1695: iadd
    //   1696: istore #70
    //   1698: aload #52
    //   1700: getfield height : I
    //   1703: istore #71
    //   1705: iload_3
    //   1706: istore #51
    //   1708: iload_2
    //   1709: iload #70
    //   1711: iload #71
    //   1713: invokestatic getChildMeasureSpec : (III)I
    //   1716: istore #72
    //   1718: aload #52
    //   1720: getfield width : I
    //   1723: ifne -> 1748
    //   1726: ldc 1073741824
    //   1728: istore #73
    //   1730: iload #4
    //   1732: iload #73
    //   1734: if_icmpeq -> 1740
    //   1737: goto -> 1752
    //   1740: iload #67
    //   1742: ifle -> 1767
    //   1745: goto -> 1770
    //   1748: ldc 1073741824
    //   1750: istore #73
    //   1752: iload #67
    //   1754: aload #49
    //   1756: invokevirtual getMeasuredWidth : ()I
    //   1759: iadd
    //   1760: istore #67
    //   1762: iload #67
    //   1764: ifge -> 1770
    //   1767: iconst_0
    //   1768: istore #67
    //   1770: aload #49
    //   1772: iload #67
    //   1774: iload #73
    //   1776: invokestatic makeMeasureSpec : (II)I
    //   1779: iload #72
    //   1781: invokevirtual measure : (II)V
    //   1784: iload #39
    //   1786: ldc_w -16777216
    //   1789: aload #49
    //   1791: invokevirtual getMeasuredState : ()I
    //   1794: iand
    //   1795: invokestatic combineMeasuredStates : (II)I
    //   1798: istore #39
    //   1800: fload #68
    //   1802: fstore #41
    //   1804: iload #69
    //   1806: istore #50
    //   1808: goto -> 1818
    //   1811: iload #36
    //   1813: istore #50
    //   1815: iload_3
    //   1816: istore #51
    //   1818: iload #11
    //   1820: ifeq -> 1863
    //   1823: aload_0
    //   1824: aload_0
    //   1825: getfield f : I
    //   1828: aload #49
    //   1830: invokevirtual getMeasuredWidth : ()I
    //   1833: aload #52
    //   1835: getfield leftMargin : I
    //   1838: iadd
    //   1839: aload #52
    //   1841: getfield rightMargin : I
    //   1844: iadd
    //   1845: aload_0
    //   1846: aload #49
    //   1848: invokevirtual b : (Landroid/view/View;)I
    //   1851: iadd
    //   1852: iadd
    //   1853: putfield f : I
    //   1856: fload #41
    //   1858: fstore #56
    //   1860: goto -> 1913
    //   1863: aload_0
    //   1864: getfield f : I
    //   1867: istore #54
    //   1869: iload #54
    //   1871: aload #49
    //   1873: invokevirtual getMeasuredWidth : ()I
    //   1876: iadd
    //   1877: istore #55
    //   1879: fload #41
    //   1881: fstore #56
    //   1883: aload_0
    //   1884: iload #54
    //   1886: iload #55
    //   1888: aload #52
    //   1890: getfield leftMargin : I
    //   1893: iadd
    //   1894: aload #52
    //   1896: getfield rightMargin : I
    //   1899: iadd
    //   1900: aload_0
    //   1901: aload #49
    //   1903: invokevirtual b : (Landroid/view/View;)I
    //   1906: iadd
    //   1907: invokestatic max : (II)I
    //   1910: putfield f : I
    //   1913: iload #5
    //   1915: ldc 1073741824
    //   1917: if_icmpeq -> 1935
    //   1920: aload #52
    //   1922: getfield height : I
    //   1925: iconst_m1
    //   1926: if_icmpne -> 1935
    //   1929: iconst_1
    //   1930: istore #57
    //   1932: goto -> 1938
    //   1935: iconst_0
    //   1936: istore #57
    //   1938: aload #52
    //   1940: getfield topMargin : I
    //   1943: aload #52
    //   1945: getfield bottomMargin : I
    //   1948: iadd
    //   1949: istore #58
    //   1951: iload #58
    //   1953: aload #49
    //   1955: invokevirtual getMeasuredHeight : ()I
    //   1958: iadd
    //   1959: istore #59
    //   1961: iload #40
    //   1963: iload #59
    //   1965: invokestatic max : (II)I
    //   1968: istore #40
    //   1970: iload #57
    //   1972: ifeq -> 1978
    //   1975: goto -> 1982
    //   1978: iload #59
    //   1980: istore #58
    //   1982: iload #38
    //   1984: iload #58
    //   1986: invokestatic max : (II)I
    //   1989: istore #60
    //   1991: iload #20
    //   1993: ifeq -> 2019
    //   1996: aload #52
    //   1998: getfield height : I
    //   2001: istore #66
    //   2003: iconst_m1
    //   2004: istore #61
    //   2006: iload #66
    //   2008: iload #61
    //   2010: if_icmpne -> 2022
    //   2013: iconst_1
    //   2014: istore #62
    //   2016: goto -> 2025
    //   2019: iconst_m1
    //   2020: istore #61
    //   2022: iconst_0
    //   2023: istore #62
    //   2025: iload #24
    //   2027: ifeq -> 2118
    //   2030: aload #49
    //   2032: invokevirtual getBaseline : ()I
    //   2035: istore #63
    //   2037: iload #63
    //   2039: iload #61
    //   2041: if_icmpeq -> 2118
    //   2044: aload #52
    //   2046: getfield h : I
    //   2049: ifge -> 2061
    //   2052: aload_0
    //   2053: getfield e : I
    //   2056: istore #64
    //   2058: goto -> 2068
    //   2061: aload #52
    //   2063: getfield h : I
    //   2066: istore #64
    //   2068: bipush #-2
    //   2070: iload #64
    //   2072: bipush #112
    //   2074: iand
    //   2075: iconst_4
    //   2076: ishr
    //   2077: iand
    //   2078: iconst_1
    //   2079: ishr
    //   2080: istore #65
    //   2082: aload #6
    //   2084: iload #65
    //   2086: aload #6
    //   2088: iload #65
    //   2090: iaload
    //   2091: iload #63
    //   2093: invokestatic max : (II)I
    //   2096: iastore
    //   2097: aload #22
    //   2099: iload #65
    //   2101: aload #22
    //   2103: iload #65
    //   2105: iaload
    //   2106: iload #59
    //   2108: iload #63
    //   2110: isub
    //   2111: invokestatic max : (II)I
    //   2114: iastore
    //   2115: goto -> 2118
    //   2118: iload #60
    //   2120: istore #38
    //   2122: iload #62
    //   2124: istore #20
    //   2126: fload #56
    //   2128: fstore #41
    //   2130: goto -> 2140
    //   2133: iload #36
    //   2135: istore #50
    //   2137: iload_3
    //   2138: istore #51
    //   2140: iinc #42, 1
    //   2143: iload #50
    //   2145: istore #36
    //   2147: iload #51
    //   2149: istore_3
    //   2150: goto -> 1593
    //   2153: iload_3
    //   2154: istore #43
    //   2156: iload_2
    //   2157: istore #44
    //   2159: aload_0
    //   2160: aload_0
    //   2161: getfield f : I
    //   2164: aload_0
    //   2165: invokevirtual getPaddingLeft : ()I
    //   2168: aload_0
    //   2169: invokevirtual getPaddingRight : ()I
    //   2172: iadd
    //   2173: iadd
    //   2174: putfield f : I
    //   2177: aload #6
    //   2179: iconst_1
    //   2180: iaload
    //   2181: iconst_m1
    //   2182: if_icmpne -> 2219
    //   2185: aload #6
    //   2187: iconst_0
    //   2188: iaload
    //   2189: iconst_m1
    //   2190: if_icmpne -> 2219
    //   2193: aload #6
    //   2195: iconst_2
    //   2196: iaload
    //   2197: iconst_m1
    //   2198: if_icmpne -> 2219
    //   2201: aload #6
    //   2203: iconst_3
    //   2204: iaload
    //   2205: iconst_m1
    //   2206: if_icmpeq -> 2212
    //   2209: goto -> 2219
    //   2212: iload #40
    //   2214: istore #45
    //   2216: goto -> 2277
    //   2219: iload #40
    //   2221: aload #6
    //   2223: iconst_3
    //   2224: iaload
    //   2225: aload #6
    //   2227: iconst_0
    //   2228: iaload
    //   2229: aload #6
    //   2231: iconst_1
    //   2232: iaload
    //   2233: aload #6
    //   2235: iconst_2
    //   2236: iaload
    //   2237: invokestatic max : (II)I
    //   2240: invokestatic max : (II)I
    //   2243: invokestatic max : (II)I
    //   2246: aload #22
    //   2248: iconst_3
    //   2249: iaload
    //   2250: aload #22
    //   2252: iconst_0
    //   2253: iaload
    //   2254: aload #22
    //   2256: iconst_1
    //   2257: iaload
    //   2258: aload #22
    //   2260: iconst_2
    //   2261: iaload
    //   2262: invokestatic max : (II)I
    //   2265: invokestatic max : (II)I
    //   2268: invokestatic max : (II)I
    //   2271: iadd
    //   2272: invokestatic max : (II)I
    //   2275: istore #45
    //   2277: iload #45
    //   2279: istore #46
    //   2281: iload #39
    //   2283: istore #33
    //   2285: iload #38
    //   2287: istore #47
    //   2289: iload #20
    //   2291: ifne -> 2304
    //   2294: iload #5
    //   2296: ldc 1073741824
    //   2298: if_icmpeq -> 2304
    //   2301: goto -> 2308
    //   2304: iload #46
    //   2306: istore #47
    //   2308: iload #47
    //   2310: aload_0
    //   2311: invokevirtual getPaddingTop : ()I
    //   2314: aload_0
    //   2315: invokevirtual getPaddingBottom : ()I
    //   2318: iadd
    //   2319: iadd
    //   2320: aload_0
    //   2321: invokevirtual getSuggestedMinimumHeight : ()I
    //   2324: invokestatic max : (II)I
    //   2327: istore #48
    //   2329: aload_0
    //   2330: iload #35
    //   2332: iload #33
    //   2334: ldc_w -16777216
    //   2337: iand
    //   2338: ior
    //   2339: iload #48
    //   2341: iload #44
    //   2343: iload #33
    //   2345: bipush #16
    //   2347: ishl
    //   2348: invokestatic resolveSizeAndState : (III)I
    //   2351: invokevirtual setMeasuredDimension : (II)V
    //   2354: iload #21
    //   2356: ifeq -> 2366
    //   2359: aload_0
    //   2360: iload #43
    //   2362: iload_1
    //   2363: invokespecial d : (II)V
    //   2366: return }
  
  void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { // Byte code:
    //   0: aload_0
    //   1: invokestatic a : (Landroid/view/View;)Z
    //   4: istore #5
    //   6: aload_0
    //   7: invokevirtual getPaddingTop : ()I
    //   10: istore #6
    //   12: iload #4
    //   14: iload_2
    //   15: isub
    //   16: istore #7
    //   18: iload #7
    //   20: aload_0
    //   21: invokevirtual getPaddingBottom : ()I
    //   24: isub
    //   25: istore #8
    //   27: iload #7
    //   29: iload #6
    //   31: isub
    //   32: aload_0
    //   33: invokevirtual getPaddingBottom : ()I
    //   36: isub
    //   37: istore #9
    //   39: aload_0
    //   40: invokevirtual getVirtualChildCount : ()I
    //   43: istore #10
    //   45: aload_0
    //   46: getfield e : I
    //   49: istore #11
    //   51: ldc_w 8388615
    //   54: iload #11
    //   56: iand
    //   57: istore #12
    //   59: iload #11
    //   61: bipush #112
    //   63: iand
    //   64: istore #13
    //   66: aload_0
    //   67: getfield a : Z
    //   70: istore #14
    //   72: aload_0
    //   73: getfield i : [I
    //   76: astore #15
    //   78: aload_0
    //   79: getfield j : [I
    //   82: astore #16
    //   84: iload #12
    //   86: aload_0
    //   87: invokestatic f : (Landroid/view/View;)I
    //   90: invokestatic a : (II)I
    //   93: istore #17
    //   95: iload #17
    //   97: iconst_1
    //   98: if_icmpeq -> 134
    //   101: iload #17
    //   103: iconst_5
    //   104: if_icmpeq -> 116
    //   107: aload_0
    //   108: invokevirtual getPaddingLeft : ()I
    //   111: istore #18
    //   113: goto -> 151
    //   116: iload_3
    //   117: aload_0
    //   118: invokevirtual getPaddingLeft : ()I
    //   121: iadd
    //   122: iload_1
    //   123: isub
    //   124: aload_0
    //   125: getfield f : I
    //   128: isub
    //   129: istore #18
    //   131: goto -> 151
    //   134: aload_0
    //   135: invokevirtual getPaddingLeft : ()I
    //   138: iload_3
    //   139: iload_1
    //   140: isub
    //   141: aload_0
    //   142: getfield f : I
    //   145: isub
    //   146: iconst_2
    //   147: idiv
    //   148: iadd
    //   149: istore #18
    //   151: iload #5
    //   153: ifeq -> 168
    //   156: iload #10
    //   158: iconst_1
    //   159: isub
    //   160: istore #19
    //   162: iconst_m1
    //   163: istore #20
    //   165: goto -> 174
    //   168: iconst_0
    //   169: istore #19
    //   171: iconst_1
    //   172: istore #20
    //   174: iconst_0
    //   175: istore #21
    //   177: iload #21
    //   179: iload #10
    //   181: if_icmpge -> 597
    //   184: iload #19
    //   186: iload #20
    //   188: iload #21
    //   190: imul
    //   191: iadd
    //   192: istore #22
    //   194: aload_0
    //   195: iload #22
    //   197: invokevirtual b : (I)Landroid/view/View;
    //   200: astore #23
    //   202: aload #23
    //   204: ifnonnull -> 221
    //   207: iload #18
    //   209: aload_0
    //   210: iload #22
    //   212: invokevirtual d : (I)I
    //   215: iadd
    //   216: istore #18
    //   218: goto -> 567
    //   221: aload #23
    //   223: invokevirtual getVisibility : ()I
    //   226: bipush #8
    //   228: if_icmpeq -> 564
    //   231: aload #23
    //   233: invokevirtual getMeasuredWidth : ()I
    //   236: istore #28
    //   238: aload #23
    //   240: invokevirtual getMeasuredHeight : ()I
    //   243: istore #29
    //   245: aload #23
    //   247: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   250: checkcast android/support/v7/widget/as$a
    //   253: astore #30
    //   255: iload #14
    //   257: ifeq -> 291
    //   260: iload #21
    //   262: istore #31
    //   264: aload #30
    //   266: getfield height : I
    //   269: istore #42
    //   271: iload #10
    //   273: istore #26
    //   275: iload #42
    //   277: iconst_m1
    //   278: if_icmpeq -> 299
    //   281: aload #23
    //   283: invokevirtual getBaseline : ()I
    //   286: istore #32
    //   288: goto -> 302
    //   291: iload #21
    //   293: istore #31
    //   295: iload #10
    //   297: istore #26
    //   299: iconst_m1
    //   300: istore #32
    //   302: aload #30
    //   304: getfield h : I
    //   307: istore #33
    //   309: iload #33
    //   311: ifge -> 318
    //   314: iload #13
    //   316: istore #33
    //   318: iload #33
    //   320: bipush #112
    //   322: iand
    //   323: istore #34
    //   325: iload #13
    //   327: istore #27
    //   329: iload #34
    //   331: bipush #16
    //   333: if_icmpeq -> 443
    //   336: iload #34
    //   338: bipush #48
    //   340: if_icmpeq -> 405
    //   343: iload #34
    //   345: bipush #80
    //   347: if_icmpeq -> 357
    //   350: iload #6
    //   352: istore #35
    //   354: goto -> 467
    //   357: iload #8
    //   359: iload #29
    //   361: isub
    //   362: aload #30
    //   364: getfield bottomMargin : I
    //   367: isub
    //   368: istore #40
    //   370: iload #32
    //   372: iconst_m1
    //   373: if_icmpeq -> 398
    //   376: aload #23
    //   378: invokevirtual getMeasuredHeight : ()I
    //   381: iload #32
    //   383: isub
    //   384: istore #41
    //   386: iload #40
    //   388: aload #16
    //   390: iconst_2
    //   391: iaload
    //   392: iload #41
    //   394: isub
    //   395: isub
    //   396: istore #40
    //   398: iload #40
    //   400: istore #35
    //   402: goto -> 354
    //   405: iload #6
    //   407: aload #30
    //   409: getfield topMargin : I
    //   412: iadd
    //   413: istore #39
    //   415: iload #32
    //   417: iconst_m1
    //   418: if_icmpeq -> 436
    //   421: iload #39
    //   423: aload #15
    //   425: iconst_1
    //   426: iaload
    //   427: iload #32
    //   429: isub
    //   430: iadd
    //   431: istore #39
    //   433: goto -> 436
    //   436: iload #39
    //   438: istore #35
    //   440: goto -> 467
    //   443: iload #6
    //   445: iload #9
    //   447: iload #29
    //   449: isub
    //   450: iconst_2
    //   451: idiv
    //   452: iadd
    //   453: aload #30
    //   455: getfield topMargin : I
    //   458: iadd
    //   459: aload #30
    //   461: getfield bottomMargin : I
    //   464: isub
    //   465: istore #35
    //   467: aload_0
    //   468: iload #22
    //   470: invokevirtual c : (I)Z
    //   473: ifeq -> 485
    //   476: iload #18
    //   478: aload_0
    //   479: getfield l : I
    //   482: iadd
    //   483: istore #18
    //   485: iload #18
    //   487: aload #30
    //   489: getfield leftMargin : I
    //   492: iadd
    //   493: istore #36
    //   495: iload #36
    //   497: aload_0
    //   498: aload #23
    //   500: invokevirtual a : (Landroid/view/View;)I
    //   503: iadd
    //   504: istore #37
    //   506: iload #6
    //   508: istore #25
    //   510: aload_0
    //   511: aload #23
    //   513: iload #37
    //   515: iload #35
    //   517: iload #28
    //   519: iload #29
    //   521: invokespecial a : (Landroid/view/View;IIII)V
    //   524: iload #36
    //   526: iload #28
    //   528: aload #30
    //   530: getfield rightMargin : I
    //   533: iadd
    //   534: aload_0
    //   535: aload #23
    //   537: invokevirtual b : (Landroid/view/View;)I
    //   540: iadd
    //   541: iadd
    //   542: istore #38
    //   544: iload #31
    //   546: aload_0
    //   547: aload #23
    //   549: iload #22
    //   551: invokevirtual a : (Landroid/view/View;I)I
    //   554: iadd
    //   555: istore #21
    //   557: iload #38
    //   559: istore #18
    //   561: goto -> 579
    //   564: iload #21
    //   566: pop
    //   567: iload #6
    //   569: istore #25
    //   571: iload #10
    //   573: istore #26
    //   575: iload #13
    //   577: istore #27
    //   579: iinc #21, 1
    //   582: iload #26
    //   584: istore #10
    //   586: iload #27
    //   588: istore #13
    //   590: iload #25
    //   592: istore #6
    //   594: goto -> 177
    //   597: return }
  
  void b(Canvas paramCanvas) {
    int i2;
    int i1 = getVirtualChildCount();
    boolean bool = bu.a(this);
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = b(b1);
      if (view != null && view.getVisibility() != 8 && c(b1)) {
        int i3;
        a a1 = (a)view.getLayoutParams();
        if (bool) {
          i3 = view.getRight() + a1.rightMargin;
        } else {
          i3 = view.getLeft() - a1.leftMargin - this.l;
        } 
        b(paramCanvas, i3);
      } 
    } 
    if (c(i1)) {
      View view = b(i1 - 1);
      if (view == null) {
        if (bool) {
          i2 = getPaddingLeft();
        } else {
          int i3 = getWidth();
          int i4 = getPaddingRight();
          i2 = i3 - i4 - this.l;
        } 
      } else {
        int i4;
        int i3;
        a a1 = (a)view.getLayoutParams();
        if (bool) {
          i3 = view.getLeft();
          i4 = a1.leftMargin;
        } else {
          int i5 = view.getRight() + a1.rightMargin;
          b(paramCanvas, i5);
        } 
        i2 = i3 - i4 - this.l;
      } 
    } else {
      return;
    } 
    b(paramCanvas, i2);
  }
  
  void b(Canvas paramCanvas, int paramInt) {
    this.k.setBounds(paramInt, getPaddingTop() + this.o, paramInt + this.l, getHeight() - getPaddingBottom() - this.o);
    this.k.draw(paramCanvas);
  }
  
  protected boolean c(int paramInt) {
    if (paramInt == 0) {
      int i1 = true & this.n;
      boolean bool = false;
      if (i1 != 0)
        bool = true; 
      return bool;
    } 
    if (paramInt == getChildCount()) {
      int i1 = 0x4 & this.n;
      boolean bool = false;
      if (i1 != 0)
        bool = true; 
      return bool;
    } 
    if ((0x2 & this.n) != 0)
      for (int i1 = paramInt - 1; i1 >= 0; i1--) {
        if (getChildAt(i1).getVisibility() != 8)
          return true; 
      }  
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return paramLayoutParams instanceof a; }
  
  int d(int paramInt) { return 0; }
  
  public int getBaseline() {
    if (this.b < 0)
      return super.getBaseline(); 
    int i1 = getChildCount();
    int i2 = this.b;
    if (i1 > i2) {
      View view = getChildAt(i2);
      int i3 = view.getBaseline();
      if (i3 == -1) {
        if (this.b == 0)
          return -1; 
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      } 
      int i4 = this.c;
      if (this.d == 1) {
        int i5 = 0x70 & this.e;
        if (i5 != 48)
          if (i5 != 16) {
            if (i5 == 80)
              i4 = getBottom() - getTop() - getPaddingBottom() - this.f; 
          } else {
            i4 += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.f) / 2;
          }  
      } 
      return i3 + i4 + ((a)view.getLayoutParams()).topMargin;
    } 
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex() { return this.b; }
  
  public Drawable getDividerDrawable() { return this.k; }
  
  public int getDividerPadding() { return this.o; }
  
  public int getDividerWidth() { return this.l; }
  
  public int getGravity() { return this.e; }
  
  public int getOrientation() { return this.d; }
  
  public int getShowDividers() { return this.n; }
  
  int getVirtualChildCount() { return getChildCount(); }
  
  public float getWeightSum() { return this.g; }
  
  protected a j() {
    int i1 = this.d;
    return (i1 == 0) ? new a(-2, -2) : ((i1 == 1) ? new a(-1, -2) : null);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.k == null)
      return; 
    if (this.d == 1) {
      a(paramCanvas);
      return;
    } 
    b(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(as.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(as.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.d == 1) {
      a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.d == 1) {
      a(paramInt1, paramInt2);
      return;
    } 
    b(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean) { this.a = paramBoolean; }
  
  public void setBaselineAlignedChildIndex(int paramInt) {
    if (paramInt >= 0 && paramInt < getChildCount()) {
      this.b = paramInt;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("base aligned child index out of range (0, ");
    stringBuilder.append(getChildCount());
    stringBuilder.append(")");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable) {
    if (paramDrawable == this.k)
      return; 
    this.k = paramDrawable;
    if (paramDrawable != null) {
      this.l = paramDrawable.getIntrinsicWidth();
      this.m = paramDrawable.getIntrinsicHeight();
    } else {
      this.l = 0;
      this.m = 0;
    } 
    boolean bool = false;
    if (paramDrawable == null)
      bool = true; 
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt) { this.o = paramInt; }
  
  public void setGravity(int paramInt) {
    if (this.e != paramInt) {
      if ((0x800007 & paramInt) == 0)
        paramInt |= 0x800003; 
      if ((paramInt & 0x70) == 0)
        paramInt |= 0x30; 
      this.e = paramInt;
      requestLayout();
    } 
  }
  
  public void setHorizontalGravity(int paramInt) {
    int i1 = paramInt & 0x800007;
    int i2 = this.e;
    if ((0x800007 & i2) != i1) {
      this.e = i1 | 0xFF7FFFF8 & i2;
      requestLayout();
    } 
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean) { this.h = paramBoolean; }
  
  public void setOrientation(int paramInt) {
    if (this.d != paramInt) {
      this.d = paramInt;
      requestLayout();
    } 
  }
  
  public void setShowDividers(int paramInt) {
    if (paramInt != this.n)
      requestLayout(); 
    this.n = paramInt;
  }
  
  public void setVerticalGravity(int paramInt) {
    int i1 = paramInt & 0x70;
    int i2 = this.e;
    if ((i2 & 0x70) != i1) {
      this.e = i1 | i2 & 0xFFFFFF8F;
      requestLayout();
    } 
  }
  
  public void setWeightSum(float paramFloat) { this.g = Math.max(0.0F, paramFloat); }
  
  public boolean shouldDelayChildPressedState() { return false; }
  
  public static class a extends ViewGroup.MarginLayoutParams {
    public float g;
    
    public int h = -1;
    
    public a(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.g = 0.0F;
    }
    
    public a(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.j.LinearLayoutCompat_Layout);
      this.g = typedArray.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.h = typedArray.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      typedArray.recycle();
    }
    
    public a(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */