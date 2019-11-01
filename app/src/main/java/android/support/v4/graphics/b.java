package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class b {
  private static int a(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (((c - 'A') * (c - 'Z') <= '\000' || (c - 'a') * (c - 'z') <= '\000') && c != 'e' && c != 'E')
        return paramInt; 
      paramInt++;
    } 
    return paramInt;
  }
  
  public static Path a(String paramString) {
    Path path = new Path();
    b[] arrayOfb = b(paramString);
    if (arrayOfb != null)
      try {
        b.a(arrayOfb, path);
        return path;
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error in parsing ");
        stringBuilder.append(paramString);
        throw new RuntimeException(stringBuilder.toString(), runtimeException);
      }  
    return null;
  }
  
  private static void a(String paramString, int paramInt, a parama) {
    parama.b = false;
    int i = paramInt;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    while (i < paramString.length()) {
      char c = paramString.charAt(i);
      if (c != ' ') {
        if (c != 'E' && c != 'e') {
          switch (c) {
            default:
              bool1 = false;
              break;
            case '.':
              if (!bool2) {
                bool2 = true;
                bool1 = false;
                break;
              } 
              parama.b = true;
            case '-':
            
            case ',':
              bool1 = false;
              bool3 = true;
              break;
          } 
        } else {
          bool1 = true;
        } 
        if (bool3)
          break; 
        continue;
      } 
      i++;
    } 
    parama.a = i;
  }
  
  private static void a(ArrayList<b> paramArrayList, char paramChar, float[] paramArrayOfFloat) { paramArrayList.add(new b(paramChar, paramArrayOfFloat)); }
  
  public static boolean a(b[] paramArrayOfb1, b[] paramArrayOfb2) {
    if (paramArrayOfb1 != null) {
      if (paramArrayOfb2 == null)
        return false; 
      if (paramArrayOfb1.length != paramArrayOfb2.length)
        return false; 
      byte b1 = 0;
      while (b1 < paramArrayOfb1.length) {
        if ((paramArrayOfb1[b1]).a == (paramArrayOfb2[b1]).a) {
          if ((paramArrayOfb1[b1]).b.length != (paramArrayOfb2[b1]).b.length)
            return false; 
          b1++;
          continue;
        } 
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  static float[] a(float[] paramArrayOfFloat, int paramInt1, int paramInt2) {
    if (paramInt1 <= paramInt2) {
      int i = paramArrayOfFloat.length;
      if (paramInt1 >= 0 && paramInt1 <= i) {
        int j = paramInt2 - paramInt1;
        int k = Math.min(j, i - paramInt1);
        float[] arrayOfFloat = new float[j];
        System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, k);
        return arrayOfFloat;
      } 
      throw new ArrayIndexOutOfBoundsException();
    } 
    throw new IllegalArgumentException();
  }
  
  public static b[] a(b[] paramArrayOfb) {
    if (paramArrayOfb == null)
      return null; 
    b[] arrayOfb = new b[paramArrayOfb.length];
    for (byte b1 = 0; b1 < paramArrayOfb.length; b1++)
      arrayOfb[b1] = new b(paramArrayOfb[b1]); 
    return arrayOfb;
  }
  
  public static void b(b[] paramArrayOfb1, b[] paramArrayOfb2) {
    for (byte b1 = 0; b1 < paramArrayOfb2.length; b1++) {
      (paramArrayOfb1[b1]).a = (paramArrayOfb2[b1]).a;
      for (byte b2 = 0; b2 < (paramArrayOfb2[b1]).b.length; b2++)
        (paramArrayOfb1[b1]).b[b2] = (paramArrayOfb2[b1]).b[b2]; 
    } 
  }
  
  public static b[] b(String paramString) {
    if (paramString == null)
      return null; 
    ArrayList arrayList = new ArrayList();
    int i = 1;
    int j = 0;
    while (i < paramString.length()) {
      int k = a(paramString, i);
      String str = paramString.substring(j, k).trim();
      if (str.length() > 0) {
        float[] arrayOfFloat = c(str);
        a(arrayList, str.charAt(0), arrayOfFloat);
      } 
      int m = k + 1;
      j = k;
      i = m;
    } 
    if (i - j == 1 && j < paramString.length())
      a(arrayList, paramString.charAt(j), new float[0]); 
    return (b[])arrayList.toArray(new b[arrayList.size()]);
  }
  
  private static float[] c(String paramString) {
    if (paramString.charAt(0) == 'z' || paramString.charAt(0) == 'Z')
      return new float[0]; 
    try {
      float[] arrayOfFloat = new float[paramString.length()];
      a a = new a();
      int i = paramString.length();
      int j = 1;
      byte b1 = 0;
      while (true) {
        int k;
        if (j < i) {
          a(paramString, j, a);
          k = a.a;
          if (j < k) {
            byte b2 = b1 + true;
            arrayOfFloat[b1] = Float.parseFloat(paramString.substring(j, k));
            b1 = b2;
          } 
          if (a.b) {
            j = k;
            continue;
          } 
        } else {
          return a(arrayOfFloat, 0, b1);
        } 
        j = k + 1;
      } 
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error in parsing \"");
      stringBuilder.append(paramString);
      stringBuilder.append("\"");
      throw new RuntimeException(stringBuilder.toString(), numberFormatException);
    } 
  }
  
  private static class a {
    int a;
    
    boolean b;
  }
  
  public static class b {
    public char a;
    
    public float[] b;
    
    b(char param1Char, float[] param1ArrayOfFloat) {
      this.a = param1Char;
      this.b = param1ArrayOfFloat;
    }
    
    b(b param1b) {
      this.a = param1b.a;
      float[] arrayOfFloat = param1b.b;
      this.b = b.a(arrayOfFloat, 0, arrayOfFloat.length);
    }
    
    private static void a(Path param1Path, double param1Double1, double param1Double2, double param1Double3, double param1Double4, double param1Double5, double param1Double6, double param1Double7, double param1Double8, double param1Double9) {
      double d1 = param1Double3;
      int i = (int)Math.ceil(Math.abs(param1Double9 * 4.0D / Math.PI));
      double d2 = Math.cos(param1Double7);
      double d3 = Math.sin(param1Double7);
      double d4 = Math.cos(param1Double8);
      double d5 = Math.sin(param1Double8);
      double d6 = -d1;
      double d7 = d6 * d2;
      double d8 = d7 * d5;
      double d9 = param1Double4 * d3;
      double d10 = d8 - d9 * d4;
      double d11 = d6 * d3;
      double d12 = d5 * d11;
      double d13 = param1Double4 * d2;
      double d14 = d12 + d4 * d13;
      double d15 = i;
      Double.isNaN(d15);
      double d16 = param1Double9 / d15;
      double d17 = param1Double5;
      double d18 = param1Double6;
      double d19 = d14;
      double d20 = d10;
      byte b1 = 0;
      double d21 = param1Double8;
      while (b1 < i) {
        double d22 = d21 + d16;
        double d23 = Math.sin(d22);
        double d24 = Math.cos(d22);
        double d25 = param1Double1 + d24 * d1 * d2 - d9 * d23;
        double d26 = param1Double2 + d24 * d1 * d3 + d13 * d23;
        double d27 = d7 * d23 - d9 * d24;
        double d28 = d23 * d11 + d24 * d13;
        double d29 = d22 - d21;
        double d30 = Math.tan(d29 / 2.0D);
        double d31 = Math.sin(d29) * (Math.sqrt(4.0D + d30 * d30 * 3.0D) - 1.0D) / 3.0D;
        double d32 = d20 * d31;
        int j = i;
        double d33 = d2;
        double d34 = d17 + d32;
        double d35 = d19 * d31;
        double d36 = d3;
        double d37 = d18 + d35;
        double d38 = d31 * d27;
        double d39 = d16;
        double d40 = d25 - d38;
        double d41 = d31 * d28;
        double d42 = d11;
        double d43 = d26 - d41;
        param1Path.rLineTo(0.0F, 0.0F);
        param1Path.cubicTo((float)d34, (float)d37, (float)d40, (float)d43, (float)d25, (float)d26);
        b1++;
        d16 = d39;
        i = j;
        d3 = d36;
        d18 = d26;
        d11 = d42;
        d21 = d22;
        d19 = d28;
        d20 = d27;
        d2 = d33;
        d1 = param1Double3;
        d17 = d25;
      } 
    }
    
    private static void a(Path param1Path, float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, boolean param1Boolean1, boolean param1Boolean2) {
      boolean bool;
      double d34;
      double d33;
      double d1 = Math.toRadians(param1Float7);
      double d2 = Math.cos(d1);
      double d3 = Math.sin(d1);
      double d4 = param1Float1;
      Double.isNaN(d4);
      double d5 = d4 * d2;
      double d6 = param1Float2;
      Double.isNaN(d6);
      double d7 = d5 + d6 * d3;
      double d8 = param1Float5;
      Double.isNaN(d8);
      double d9 = d7 / d8;
      double d10 = -param1Float1;
      Double.isNaN(d10);
      double d11 = d10 * d3;
      Double.isNaN(d6);
      double d12 = d11 + d6 * d2;
      double d13 = param1Float6;
      Double.isNaN(d13);
      double d14 = d12 / d13;
      double d15 = param1Float3;
      Double.isNaN(d15);
      double d16 = d15 * d2;
      double d17 = param1Float4;
      Double.isNaN(d17);
      double d18 = d16 + d17 * d3;
      Double.isNaN(d8);
      double d19 = d18 / d8;
      double d20 = -param1Float3;
      Double.isNaN(d20);
      double d21 = d20 * d3;
      Double.isNaN(d17);
      double d22 = d21 + d17 * d2;
      Double.isNaN(d13);
      double d23 = d22 / d13;
      double d24 = d9 - d19;
      double d25 = d14 - d23;
      double d26 = (d9 + d19) / 2.0D;
      double d27 = (d14 + d23) / 2.0D;
      double d28 = d24 * d24 + d25 * d25;
      if (d28 == 0.0D) {
        Log.w("PathParser", " Points are coincident");
        return;
      } 
      double d29 = 1.0D / d28 - 0.25D;
      if (d29 < 0.0D) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Points are too far apart ");
        stringBuilder.append(d28);
        Log.w("PathParser", stringBuilder.toString());
        float f = (float)(Math.sqrt(d28) / 1.99999D);
        a(param1Path, param1Float1, param1Float2, param1Float3, param1Float4, param1Float5 * f, param1Float6 * f, param1Float7, param1Boolean1, param1Boolean2);
        return;
      } 
      double d30 = Math.sqrt(d29);
      double d31 = d24 * d30;
      double d32 = d30 * d25;
      if (param1Boolean1 == param1Boolean2) {
        d33 = d26 - d32;
        d34 = d27 + d31;
      } else {
        d33 = d26 + d32;
        d34 = d27 - d31;
      } 
      double d35 = Math.atan2(d14 - d34, d9 - d33);
      double d36 = Math.atan2(d23 - d34, d19 - d33) - d35;
      if (d36 >= 0.0D) {
        bool = true;
      } else {
        bool = false;
      } 
      if (param1Boolean2 != bool)
        if (d36 > 0.0D) {
          d36 -= 6.283185307179586D;
        } else {
          d36 += 6.283185307179586D;
        }  
      Double.isNaN(d8);
      double d37 = d33 * d8;
      Double.isNaN(d13);
      double d38 = d34 * d13;
      a(param1Path, d37 * d2 - d38 * d3, d37 * d3 + d38 * d2, d8, d13, d4, d6, d1, d35, d36);
    }
    
    private static void a(Path param1Path, float[] param1ArrayOfFloat1, char param1Char1, char param1Char2, float[] param1ArrayOfFloat2) { // Byte code:
      //   0: aload_0
      //   1: astore #5
      //   3: aload_1
      //   4: iconst_0
      //   5: faload
      //   6: fstore #6
      //   8: aload_1
      //   9: iconst_1
      //   10: faload
      //   11: fstore #7
      //   13: aload_1
      //   14: iconst_2
      //   15: faload
      //   16: fstore #8
      //   18: aload_1
      //   19: iconst_3
      //   20: faload
      //   21: fstore #9
      //   23: aload_1
      //   24: iconst_4
      //   25: faload
      //   26: fstore #10
      //   28: aload_1
      //   29: iconst_5
      //   30: faload
      //   31: fstore #11
      //   33: iload_3
      //   34: lookupswitch default -> 204, 65 -> 261, 67 -> 254, 72 -> 248, 76 -> 204, 77 -> 204, 81 -> 242, 83 -> 242, 84 -> 204, 86 -> 248, 90 -> 210, 97 -> 261, 99 -> 254, 104 -> 248, 108 -> 204, 109 -> 204, 113 -> 242, 115 -> 242, 116 -> 204, 118 -> 248, 122 -> 210
      //   204: iconst_2
      //   205: istore #12
      //   207: goto -> 265
      //   210: aload_0
      //   211: invokevirtual close : ()V
      //   214: aload #5
      //   216: fload #10
      //   218: fload #11
      //   220: invokevirtual moveTo : (FF)V
      //   223: fload #10
      //   225: fstore #6
      //   227: fload #6
      //   229: fstore #8
      //   231: fload #11
      //   233: fstore #7
      //   235: fload #7
      //   237: fstore #9
      //   239: goto -> 204
      //   242: iconst_4
      //   243: istore #12
      //   245: goto -> 265
      //   248: iconst_1
      //   249: istore #12
      //   251: goto -> 265
      //   254: bipush #6
      //   256: istore #12
      //   258: goto -> 265
      //   261: bipush #7
      //   263: istore #12
      //   265: fload #6
      //   267: fstore #13
      //   269: fload #7
      //   271: fstore #14
      //   273: fload #10
      //   275: fstore #15
      //   277: fload #11
      //   279: fstore #16
      //   281: iconst_0
      //   282: istore #17
      //   284: iload_2
      //   285: istore #18
      //   287: iload #17
      //   289: aload #4
      //   291: arraylength
      //   292: if_icmpge -> 2299
      //   295: iload_3
      //   296: lookupswitch default -> 452, 65 -> 2134, 67 -> 2005, 72 -> 1969, 76 -> 1917, 77 -> 1838, 81 -> 1734, 83 -> 1563, 84 -> 1441, 86 -> 1390, 97 -> 1208, 99 -> 1067, 104 -> 1037, 108 -> 979, 109 -> 898, 113 -> 797, 115 -> 635, 116 -> 497, 118 -> 470
      //   452: fload #14
      //   454: fstore #140
      //   456: fload #13
      //   458: pop
      //   459: iload #17
      //   461: istore #22
      //   463: fload #140
      //   465: fstore #14
      //   467: goto -> 2286
      //   470: iload #17
      //   472: iconst_0
      //   473: iadd
      //   474: istore #139
      //   476: aload #5
      //   478: fconst_0
      //   479: aload #4
      //   481: iload #139
      //   483: faload
      //   484: invokevirtual rLineTo : (FF)V
      //   487: aload #4
      //   489: iload #139
      //   491: faload
      //   492: fstore #112
      //   494: goto -> 1027
      //   497: iload #18
      //   499: bipush #113
      //   501: if_icmpeq -> 537
      //   504: iload #18
      //   506: bipush #116
      //   508: if_icmpeq -> 537
      //   511: iload #18
      //   513: bipush #81
      //   515: if_icmpeq -> 537
      //   518: iload #18
      //   520: bipush #84
      //   522: if_icmpne -> 528
      //   525: goto -> 537
      //   528: fconst_0
      //   529: fstore #133
      //   531: fconst_0
      //   532: fstore #132
      //   534: goto -> 551
      //   537: fload #13
      //   539: fload #8
      //   541: fsub
      //   542: fstore #132
      //   544: fload #14
      //   546: fload #9
      //   548: fsub
      //   549: fstore #133
      //   551: iload #17
      //   553: iconst_0
      //   554: iadd
      //   555: istore #134
      //   557: aload #4
      //   559: iload #134
      //   561: faload
      //   562: fstore #135
      //   564: iload #17
      //   566: iconst_1
      //   567: iadd
      //   568: istore #136
      //   570: aload #5
      //   572: fload #132
      //   574: fload #133
      //   576: fload #135
      //   578: aload #4
      //   580: iload #136
      //   582: faload
      //   583: invokevirtual rQuadTo : (FFFF)V
      //   586: fload #132
      //   588: fload #13
      //   590: fadd
      //   591: fstore #137
      //   593: fload #133
      //   595: fload #14
      //   597: fadd
      //   598: fstore #138
      //   600: fload #13
      //   602: aload #4
      //   604: iload #134
      //   606: faload
      //   607: fadd
      //   608: fstore #13
      //   610: fload #14
      //   612: aload #4
      //   614: iload #136
      //   616: faload
      //   617: fadd
      //   618: fstore #14
      //   620: fload #138
      //   622: fstore #9
      //   624: iload #17
      //   626: istore #22
      //   628: fload #137
      //   630: fstore #8
      //   632: goto -> 2286
      //   635: iload #18
      //   637: bipush #99
      //   639: if_icmpeq -> 675
      //   642: iload #18
      //   644: bipush #115
      //   646: if_icmpeq -> 675
      //   649: iload #18
      //   651: bipush #67
      //   653: if_icmpeq -> 675
      //   656: iload #18
      //   658: bipush #83
      //   660: if_icmpne -> 666
      //   663: goto -> 675
      //   666: fconst_0
      //   667: fstore #124
      //   669: fconst_0
      //   670: fstore #123
      //   672: goto -> 693
      //   675: fload #13
      //   677: fload #8
      //   679: fsub
      //   680: fstore #122
      //   682: fload #14
      //   684: fload #9
      //   686: fsub
      //   687: fstore #123
      //   689: fload #122
      //   691: fstore #124
      //   693: iload #17
      //   695: iconst_0
      //   696: iadd
      //   697: istore #125
      //   699: aload #4
      //   701: iload #125
      //   703: faload
      //   704: fstore #126
      //   706: iload #17
      //   708: iconst_1
      //   709: iadd
      //   710: istore #127
      //   712: aload #4
      //   714: iload #127
      //   716: faload
      //   717: fstore #128
      //   719: iload #17
      //   721: iconst_2
      //   722: iadd
      //   723: istore #129
      //   725: aload #4
      //   727: iload #129
      //   729: faload
      //   730: fstore #130
      //   732: iload #17
      //   734: iconst_3
      //   735: iadd
      //   736: istore #131
      //   738: aload_0
      //   739: fload #124
      //   741: fload #123
      //   743: fload #126
      //   745: fload #128
      //   747: fload #130
      //   749: aload #4
      //   751: iload #131
      //   753: faload
      //   754: invokevirtual rCubicTo : (FFFFFF)V
      //   757: fload #13
      //   759: aload #4
      //   761: iload #125
      //   763: faload
      //   764: fadd
      //   765: fstore #105
      //   767: fload #14
      //   769: aload #4
      //   771: iload #127
      //   773: faload
      //   774: fadd
      //   775: fstore #106
      //   777: fload #13
      //   779: aload #4
      //   781: iload #129
      //   783: faload
      //   784: fadd
      //   785: fstore #13
      //   787: aload #4
      //   789: iload #131
      //   791: faload
      //   792: fstore #107
      //   794: goto -> 1186
      //   797: iload #17
      //   799: iconst_0
      //   800: iadd
      //   801: istore #115
      //   803: aload #4
      //   805: iload #115
      //   807: faload
      //   808: fstore #116
      //   810: iload #17
      //   812: iconst_1
      //   813: iadd
      //   814: istore #117
      //   816: aload #4
      //   818: iload #117
      //   820: faload
      //   821: fstore #118
      //   823: iload #17
      //   825: iconst_2
      //   826: iadd
      //   827: istore #119
      //   829: aload #4
      //   831: iload #119
      //   833: faload
      //   834: fstore #120
      //   836: iload #17
      //   838: iconst_3
      //   839: iadd
      //   840: istore #121
      //   842: aload #5
      //   844: fload #116
      //   846: fload #118
      //   848: fload #120
      //   850: aload #4
      //   852: iload #121
      //   854: faload
      //   855: invokevirtual rQuadTo : (FFFF)V
      //   858: fload #13
      //   860: aload #4
      //   862: iload #115
      //   864: faload
      //   865: fadd
      //   866: fstore #105
      //   868: fload #14
      //   870: aload #4
      //   872: iload #117
      //   874: faload
      //   875: fadd
      //   876: fstore #106
      //   878: fload #13
      //   880: aload #4
      //   882: iload #119
      //   884: faload
      //   885: fadd
      //   886: fstore #13
      //   888: aload #4
      //   890: iload #121
      //   892: faload
      //   893: fstore #107
      //   895: goto -> 1186
      //   898: iload #17
      //   900: iconst_0
      //   901: iadd
      //   902: istore #113
      //   904: fload #13
      //   906: aload #4
      //   908: iload #113
      //   910: faload
      //   911: fadd
      //   912: fstore #13
      //   914: iload #17
      //   916: iconst_1
      //   917: iadd
      //   918: istore #114
      //   920: fload #14
      //   922: aload #4
      //   924: iload #114
      //   926: faload
      //   927: fadd
      //   928: fstore #14
      //   930: iload #17
      //   932: ifle -> 953
      //   935: aload #5
      //   937: aload #4
      //   939: iload #113
      //   941: faload
      //   942: aload #4
      //   944: iload #114
      //   946: faload
      //   947: invokevirtual rLineTo : (FF)V
      //   950: goto -> 1201
      //   953: aload #5
      //   955: aload #4
      //   957: iload #113
      //   959: faload
      //   960: aload #4
      //   962: iload #114
      //   964: faload
      //   965: invokevirtual rMoveTo : (FF)V
      //   968: fload #14
      //   970: fstore #16
      //   972: fload #13
      //   974: fstore #15
      //   976: goto -> 1201
      //   979: iload #17
      //   981: iconst_0
      //   982: iadd
      //   983: istore #109
      //   985: aload #4
      //   987: iload #109
      //   989: faload
      //   990: fstore #110
      //   992: iload #17
      //   994: iconst_1
      //   995: iadd
      //   996: istore #111
      //   998: aload #5
      //   1000: fload #110
      //   1002: aload #4
      //   1004: iload #111
      //   1006: faload
      //   1007: invokevirtual rLineTo : (FF)V
      //   1010: fload #13
      //   1012: aload #4
      //   1014: iload #109
      //   1016: faload
      //   1017: fadd
      //   1018: fstore #13
      //   1020: aload #4
      //   1022: iload #111
      //   1024: faload
      //   1025: fstore #112
      //   1027: fload #14
      //   1029: fload #112
      //   1031: fadd
      //   1032: fstore #14
      //   1034: goto -> 1201
      //   1037: iload #17
      //   1039: iconst_0
      //   1040: iadd
      //   1041: istore #108
      //   1043: aload #5
      //   1045: aload #4
      //   1047: iload #108
      //   1049: faload
      //   1050: fconst_0
      //   1051: invokevirtual rLineTo : (FF)V
      //   1054: fload #13
      //   1056: aload #4
      //   1058: iload #108
      //   1060: faload
      //   1061: fadd
      //   1062: fstore #13
      //   1064: goto -> 1201
      //   1067: aload #4
      //   1069: iload #17
      //   1071: iconst_0
      //   1072: iadd
      //   1073: faload
      //   1074: fstore #96
      //   1076: aload #4
      //   1078: iload #17
      //   1080: iconst_1
      //   1081: iadd
      //   1082: faload
      //   1083: fstore #97
      //   1085: iload #17
      //   1087: iconst_2
      //   1088: iadd
      //   1089: istore #98
      //   1091: aload #4
      //   1093: iload #98
      //   1095: faload
      //   1096: fstore #99
      //   1098: iload #17
      //   1100: iconst_3
      //   1101: iadd
      //   1102: istore #100
      //   1104: aload #4
      //   1106: iload #100
      //   1108: faload
      //   1109: fstore #101
      //   1111: iload #17
      //   1113: iconst_4
      //   1114: iadd
      //   1115: istore #102
      //   1117: aload #4
      //   1119: iload #102
      //   1121: faload
      //   1122: fstore #103
      //   1124: iload #17
      //   1126: iconst_5
      //   1127: iadd
      //   1128: istore #104
      //   1130: aload_0
      //   1131: fload #96
      //   1133: fload #97
      //   1135: fload #99
      //   1137: fload #101
      //   1139: fload #103
      //   1141: aload #4
      //   1143: iload #104
      //   1145: faload
      //   1146: invokevirtual rCubicTo : (FFFFFF)V
      //   1149: fload #13
      //   1151: aload #4
      //   1153: iload #98
      //   1155: faload
      //   1156: fadd
      //   1157: fstore #105
      //   1159: fload #14
      //   1161: aload #4
      //   1163: iload #100
      //   1165: faload
      //   1166: fadd
      //   1167: fstore #106
      //   1169: fload #13
      //   1171: aload #4
      //   1173: iload #102
      //   1175: faload
      //   1176: fadd
      //   1177: fstore #13
      //   1179: aload #4
      //   1181: iload #104
      //   1183: faload
      //   1184: fstore #107
      //   1186: fload #14
      //   1188: fload #107
      //   1190: fadd
      //   1191: fstore #14
      //   1193: fload #105
      //   1195: fstore #8
      //   1197: fload #106
      //   1199: fstore #9
      //   1201: iload #17
      //   1203: istore #22
      //   1205: goto -> 2286
      //   1208: iload #17
      //   1210: iconst_5
      //   1211: iadd
      //   1212: istore #82
      //   1214: fload #13
      //   1216: aload #4
      //   1218: iload #82
      //   1220: faload
      //   1221: fadd
      //   1222: fstore #83
      //   1224: iload #17
      //   1226: bipush #6
      //   1228: iadd
      //   1229: istore #84
      //   1231: fload #14
      //   1233: aload #4
      //   1235: iload #84
      //   1237: faload
      //   1238: fadd
      //   1239: fstore #85
      //   1241: aload #4
      //   1243: iload #17
      //   1245: iconst_0
      //   1246: iadd
      //   1247: faload
      //   1248: fstore #86
      //   1250: aload #4
      //   1252: iload #17
      //   1254: iconst_1
      //   1255: iadd
      //   1256: faload
      //   1257: fstore #87
      //   1259: aload #4
      //   1261: iload #17
      //   1263: iconst_2
      //   1264: iadd
      //   1265: faload
      //   1266: fstore #88
      //   1268: aload #4
      //   1270: iload #17
      //   1272: iconst_3
      //   1273: iadd
      //   1274: faload
      //   1275: fconst_0
      //   1276: fcmpl
      //   1277: ifeq -> 1286
      //   1280: iconst_1
      //   1281: istore #89
      //   1283: goto -> 1289
      //   1286: iconst_0
      //   1287: istore #89
      //   1289: aload #4
      //   1291: iload #17
      //   1293: iconst_4
      //   1294: iadd
      //   1295: faload
      //   1296: fconst_0
      //   1297: fcmpl
      //   1298: ifeq -> 1307
      //   1301: iconst_1
      //   1302: istore #90
      //   1304: goto -> 1310
      //   1307: iconst_0
      //   1308: istore #90
      //   1310: fload #13
      //   1312: fstore #91
      //   1314: fload #14
      //   1316: fstore #92
      //   1318: fload #14
      //   1320: fstore #93
      //   1322: fload #13
      //   1324: fstore #94
      //   1326: iload #89
      //   1328: istore #95
      //   1330: iload #17
      //   1332: istore #22
      //   1334: aload_0
      //   1335: fload #91
      //   1337: fload #92
      //   1339: fload #83
      //   1341: fload #85
      //   1343: fload #86
      //   1345: fload #87
      //   1347: fload #88
      //   1349: iload #95
      //   1351: iload #90
      //   1353: invokestatic a : (Landroid/graphics/Path;FFFFFFFZZ)V
      //   1356: fload #94
      //   1358: aload #4
      //   1360: iload #82
      //   1362: faload
      //   1363: fadd
      //   1364: fstore #13
      //   1366: fload #93
      //   1368: aload #4
      //   1370: iload #84
      //   1372: faload
      //   1373: fadd
      //   1374: fstore #14
      //   1376: fload #14
      //   1378: fstore #9
      //   1380: fload #13
      //   1382: fstore #8
      //   1384: aload_0
      //   1385: astore #5
      //   1387: goto -> 2286
      //   1390: fload #13
      //   1392: fstore #79
      //   1394: iload #17
      //   1396: istore #22
      //   1398: iload #22
      //   1400: iconst_0
      //   1401: iadd
      //   1402: istore #80
      //   1404: aload #4
      //   1406: iload #80
      //   1408: faload
      //   1409: fstore #81
      //   1411: aload_0
      //   1412: astore #5
      //   1414: aload #5
      //   1416: fload #79
      //   1418: fload #81
      //   1420: invokevirtual lineTo : (FF)V
      //   1423: aload #4
      //   1425: iload #80
      //   1427: faload
      //   1428: fstore #78
      //   1430: fload #79
      //   1432: fstore #13
      //   1434: fload #78
      //   1436: fstore #14
      //   1438: goto -> 2286
      //   1441: fload #14
      //   1443: fstore #72
      //   1445: fload #13
      //   1447: fstore #73
      //   1449: iload #17
      //   1451: istore #22
      //   1453: iload #18
      //   1455: bipush #113
      //   1457: if_icmpeq -> 1481
      //   1460: iload #18
      //   1462: bipush #116
      //   1464: if_icmpeq -> 1481
      //   1467: iload #18
      //   1469: bipush #81
      //   1471: if_icmpeq -> 1481
      //   1474: iload #18
      //   1476: bipush #84
      //   1478: if_icmpne -> 1503
      //   1481: fload #73
      //   1483: fconst_2
      //   1484: fmul
      //   1485: fload #8
      //   1487: fsub
      //   1488: fstore #74
      //   1490: fload #72
      //   1492: fconst_2
      //   1493: fmul
      //   1494: fload #9
      //   1496: fsub
      //   1497: fstore #72
      //   1499: fload #74
      //   1501: fstore #73
      //   1503: iload #22
      //   1505: iconst_0
      //   1506: iadd
      //   1507: istore #75
      //   1509: aload #4
      //   1511: iload #75
      //   1513: faload
      //   1514: fstore #76
      //   1516: iload #22
      //   1518: iconst_1
      //   1519: iadd
      //   1520: istore #77
      //   1522: aload #5
      //   1524: fload #73
      //   1526: fload #72
      //   1528: fload #76
      //   1530: aload #4
      //   1532: iload #77
      //   1534: faload
      //   1535: invokevirtual quadTo : (FFFF)V
      //   1538: aload #4
      //   1540: iload #75
      //   1542: faload
      //   1543: fstore #13
      //   1545: aload #4
      //   1547: iload #77
      //   1549: faload
      //   1550: fstore #78
      //   1552: fload #73
      //   1554: fstore #8
      //   1556: fload #72
      //   1558: fstore #9
      //   1560: goto -> 1434
      //   1563: fload #14
      //   1565: fstore #60
      //   1567: fload #13
      //   1569: fstore #61
      //   1571: iload #17
      //   1573: istore #22
      //   1575: iload #18
      //   1577: bipush #99
      //   1579: if_icmpeq -> 1617
      //   1582: iload #18
      //   1584: bipush #115
      //   1586: if_icmpeq -> 1617
      //   1589: iload #18
      //   1591: bipush #67
      //   1593: if_icmpeq -> 1617
      //   1596: iload #18
      //   1598: bipush #83
      //   1600: if_icmpne -> 1606
      //   1603: goto -> 1617
      //   1606: fload #61
      //   1608: fstore #64
      //   1610: fload #60
      //   1612: fstore #63
      //   1614: goto -> 1639
      //   1617: fload #61
      //   1619: fconst_2
      //   1620: fmul
      //   1621: fload #8
      //   1623: fsub
      //   1624: fstore #62
      //   1626: fload #60
      //   1628: fconst_2
      //   1629: fmul
      //   1630: fload #9
      //   1632: fsub
      //   1633: fstore #63
      //   1635: fload #62
      //   1637: fstore #64
      //   1639: iload #22
      //   1641: iconst_0
      //   1642: iadd
      //   1643: istore #65
      //   1645: aload #4
      //   1647: iload #65
      //   1649: faload
      //   1650: fstore #66
      //   1652: iload #22
      //   1654: iconst_1
      //   1655: iadd
      //   1656: istore #67
      //   1658: aload #4
      //   1660: iload #67
      //   1662: faload
      //   1663: fstore #68
      //   1665: iload #22
      //   1667: iconst_2
      //   1668: iadd
      //   1669: istore #69
      //   1671: aload #4
      //   1673: iload #69
      //   1675: faload
      //   1676: fstore #70
      //   1678: iload #22
      //   1680: iconst_3
      //   1681: iadd
      //   1682: istore #71
      //   1684: aload_0
      //   1685: fload #64
      //   1687: fload #63
      //   1689: fload #66
      //   1691: fload #68
      //   1693: fload #70
      //   1695: aload #4
      //   1697: iload #71
      //   1699: faload
      //   1700: invokevirtual cubicTo : (FFFFFF)V
      //   1703: aload #4
      //   1705: iload #65
      //   1707: faload
      //   1708: fstore #58
      //   1710: aload #4
      //   1712: iload #67
      //   1714: faload
      //   1715: fstore #59
      //   1717: aload #4
      //   1719: iload #69
      //   1721: faload
      //   1722: fstore #13
      //   1724: aload #4
      //   1726: iload #71
      //   1728: faload
      //   1729: fstore #14
      //   1731: goto -> 1827
      //   1734: iload #17
      //   1736: istore #22
      //   1738: iload #22
      //   1740: iconst_0
      //   1741: iadd
      //   1742: istore #51
      //   1744: aload #4
      //   1746: iload #51
      //   1748: faload
      //   1749: fstore #52
      //   1751: iload #22
      //   1753: iconst_1
      //   1754: iadd
      //   1755: istore #53
      //   1757: aload #4
      //   1759: iload #53
      //   1761: faload
      //   1762: fstore #54
      //   1764: iload #22
      //   1766: iconst_2
      //   1767: iadd
      //   1768: istore #55
      //   1770: aload #4
      //   1772: iload #55
      //   1774: faload
      //   1775: fstore #56
      //   1777: iload #22
      //   1779: iconst_3
      //   1780: iadd
      //   1781: istore #57
      //   1783: aload #5
      //   1785: fload #52
      //   1787: fload #54
      //   1789: fload #56
      //   1791: aload #4
      //   1793: iload #57
      //   1795: faload
      //   1796: invokevirtual quadTo : (FFFF)V
      //   1799: aload #4
      //   1801: iload #51
      //   1803: faload
      //   1804: fstore #58
      //   1806: aload #4
      //   1808: iload #53
      //   1810: faload
      //   1811: fstore #59
      //   1813: aload #4
      //   1815: iload #55
      //   1817: faload
      //   1818: fstore #13
      //   1820: aload #4
      //   1822: iload #57
      //   1824: faload
      //   1825: fstore #14
      //   1827: fload #58
      //   1829: fstore #8
      //   1831: fload #59
      //   1833: fstore #9
      //   1835: goto -> 2286
      //   1838: iload #17
      //   1840: istore #22
      //   1842: iload #22
      //   1844: iconst_0
      //   1845: iadd
      //   1846: istore #49
      //   1848: aload #4
      //   1850: iload #49
      //   1852: faload
      //   1853: fstore #13
      //   1855: iload #22
      //   1857: iconst_1
      //   1858: iadd
      //   1859: istore #50
      //   1861: aload #4
      //   1863: iload #50
      //   1865: faload
      //   1866: fstore #14
      //   1868: iload #22
      //   1870: ifle -> 1891
      //   1873: aload #5
      //   1875: aload #4
      //   1877: iload #49
      //   1879: faload
      //   1880: aload #4
      //   1882: iload #50
      //   1884: faload
      //   1885: invokevirtual lineTo : (FF)V
      //   1888: goto -> 2286
      //   1891: aload #5
      //   1893: aload #4
      //   1895: iload #49
      //   1897: faload
      //   1898: aload #4
      //   1900: iload #50
      //   1902: faload
      //   1903: invokevirtual moveTo : (FF)V
      //   1906: fload #14
      //   1908: fstore #16
      //   1910: fload #13
      //   1912: fstore #15
      //   1914: goto -> 2286
      //   1917: iload #17
      //   1919: istore #22
      //   1921: iload #22
      //   1923: iconst_0
      //   1924: iadd
      //   1925: istore #46
      //   1927: aload #4
      //   1929: iload #46
      //   1931: faload
      //   1932: fstore #47
      //   1934: iload #22
      //   1936: iconst_1
      //   1937: iadd
      //   1938: istore #48
      //   1940: aload #5
      //   1942: fload #47
      //   1944: aload #4
      //   1946: iload #48
      //   1948: faload
      //   1949: invokevirtual lineTo : (FF)V
      //   1952: aload #4
      //   1954: iload #46
      //   1956: faload
      //   1957: fstore #13
      //   1959: aload #4
      //   1961: iload #48
      //   1963: faload
      //   1964: fstore #14
      //   1966: goto -> 2286
      //   1969: fload #14
      //   1971: fstore #44
      //   1973: iload #17
      //   1975: istore #22
      //   1977: iload #22
      //   1979: iconst_0
      //   1980: iadd
      //   1981: istore #45
      //   1983: aload #5
      //   1985: aload #4
      //   1987: iload #45
      //   1989: faload
      //   1990: fload #44
      //   1992: invokevirtual lineTo : (FF)V
      //   1995: aload #4
      //   1997: iload #45
      //   1999: faload
      //   2000: fstore #13
      //   2002: goto -> 2286
      //   2005: iload #17
      //   2007: istore #22
      //   2009: aload #4
      //   2011: iload #22
      //   2013: iconst_0
      //   2014: iadd
      //   2015: faload
      //   2016: fstore #32
      //   2018: aload #4
      //   2020: iload #22
      //   2022: iconst_1
      //   2023: iadd
      //   2024: faload
      //   2025: fstore #33
      //   2027: iload #22
      //   2029: iconst_2
      //   2030: iadd
      //   2031: istore #34
      //   2033: aload #4
      //   2035: iload #34
      //   2037: faload
      //   2038: fstore #35
      //   2040: iload #22
      //   2042: iconst_3
      //   2043: iadd
      //   2044: istore #36
      //   2046: aload #4
      //   2048: iload #36
      //   2050: faload
      //   2051: fstore #37
      //   2053: iload #22
      //   2055: iconst_4
      //   2056: iadd
      //   2057: istore #38
      //   2059: aload #4
      //   2061: iload #38
      //   2063: faload
      //   2064: fstore #39
      //   2066: iload #22
      //   2068: iconst_5
      //   2069: iadd
      //   2070: istore #40
      //   2072: aload_0
      //   2073: fload #32
      //   2075: fload #33
      //   2077: fload #35
      //   2079: fload #37
      //   2081: fload #39
      //   2083: aload #4
      //   2085: iload #40
      //   2087: faload
      //   2088: invokevirtual cubicTo : (FFFFFF)V
      //   2091: aload #4
      //   2093: iload #38
      //   2095: faload
      //   2096: fstore #13
      //   2098: aload #4
      //   2100: iload #40
      //   2102: faload
      //   2103: fstore #41
      //   2105: aload #4
      //   2107: iload #34
      //   2109: faload
      //   2110: fstore #42
      //   2112: aload #4
      //   2114: iload #36
      //   2116: faload
      //   2117: fstore #43
      //   2119: fload #41
      //   2121: fstore #14
      //   2123: fload #43
      //   2125: fstore #9
      //   2127: fload #42
      //   2129: fstore #8
      //   2131: goto -> 2286
      //   2134: fload #14
      //   2136: fstore #20
      //   2138: fload #13
      //   2140: fstore #21
      //   2142: iload #17
      //   2144: istore #22
      //   2146: iload #22
      //   2148: iconst_5
      //   2149: iadd
      //   2150: istore #23
      //   2152: aload #4
      //   2154: iload #23
      //   2156: faload
      //   2157: fstore #24
      //   2159: iload #22
      //   2161: bipush #6
      //   2163: iadd
      //   2164: istore #25
      //   2166: aload #4
      //   2168: iload #25
      //   2170: faload
      //   2171: fstore #26
      //   2173: aload #4
      //   2175: iload #22
      //   2177: iconst_0
      //   2178: iadd
      //   2179: faload
      //   2180: fstore #27
      //   2182: aload #4
      //   2184: iload #22
      //   2186: iconst_1
      //   2187: iadd
      //   2188: faload
      //   2189: fstore #28
      //   2191: aload #4
      //   2193: iload #22
      //   2195: iconst_2
      //   2196: iadd
      //   2197: faload
      //   2198: fstore #29
      //   2200: aload #4
      //   2202: iload #22
      //   2204: iconst_3
      //   2205: iadd
      //   2206: faload
      //   2207: fconst_0
      //   2208: fcmpl
      //   2209: ifeq -> 2218
      //   2212: iconst_1
      //   2213: istore #30
      //   2215: goto -> 2221
      //   2218: iconst_0
      //   2219: istore #30
      //   2221: aload #4
      //   2223: iload #22
      //   2225: iconst_4
      //   2226: iadd
      //   2227: faload
      //   2228: fconst_0
      //   2229: fcmpl
      //   2230: ifeq -> 2239
      //   2233: iconst_1
      //   2234: istore #31
      //   2236: goto -> 2242
      //   2239: iconst_0
      //   2240: istore #31
      //   2242: aload_0
      //   2243: fload #21
      //   2245: fload #20
      //   2247: fload #24
      //   2249: fload #26
      //   2251: fload #27
      //   2253: fload #28
      //   2255: fload #29
      //   2257: iload #30
      //   2259: iload #31
      //   2261: invokestatic a : (Landroid/graphics/Path;FFFFFFFZZ)V
      //   2264: aload #4
      //   2266: iload #23
      //   2268: faload
      //   2269: fstore #13
      //   2271: aload #4
      //   2273: iload #25
      //   2275: faload
      //   2276: fstore #14
      //   2278: fload #14
      //   2280: fstore #9
      //   2282: fload #13
      //   2284: fstore #8
      //   2286: iload #22
      //   2288: iload #12
      //   2290: iadd
      //   2291: istore #17
      //   2293: iload_3
      //   2294: istore #18
      //   2296: goto -> 287
      //   2299: fload #14
      //   2301: fstore #19
      //   2303: aload_1
      //   2304: iconst_0
      //   2305: fload #13
      //   2307: fastore
      //   2308: aload_1
      //   2309: iconst_1
      //   2310: fload #19
      //   2312: fastore
      //   2313: aload_1
      //   2314: iconst_2
      //   2315: fload #8
      //   2317: fastore
      //   2318: aload_1
      //   2319: iconst_3
      //   2320: fload #9
      //   2322: fastore
      //   2323: aload_1
      //   2324: iconst_4
      //   2325: fload #15
      //   2327: fastore
      //   2328: aload_1
      //   2329: iconst_5
      //   2330: fload #16
      //   2332: fastore
      //   2333: return }
    
    public static void a(b[] param1ArrayOfb, Path param1Path) {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      for (byte b1 = 0; b1 < param1ArrayOfb.length; b1++) {
        a(param1Path, arrayOfFloat, c, (param1ArrayOfb[b1]).a, (param1ArrayOfb[b1]).b);
        c = (param1ArrayOfb[b1]).a;
      } 
    }
    
    public void a(b param1b1, b param1b2, float param1Float) {
      byte b1 = 0;
      while (true) {
        float[] arrayOfFloat = param1b1.b;
        if (b1 < arrayOfFloat.length) {
          this.b[b1] = arrayOfFloat[b1] * (1.0F - param1Float) + param1Float * param1b2.b[b1];
          b1++;
          continue;
        } 
        break;
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */