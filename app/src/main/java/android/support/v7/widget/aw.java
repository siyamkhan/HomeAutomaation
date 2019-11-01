package android.support.v7.widget;

import java.util.List;

class aw {
  final a a;
  
  aw(a parama) { this.a = parama; }
  
  private void a(List<e.b> paramList, int paramInt1, int paramInt2) {
    e.b b1 = (e.b)paramList.get(paramInt1);
    e.b b2 = (e.b)paramList.get(paramInt2);
    int i = b2.a;
    if (i != 4) {
      switch (i) {
        default:
          return;
        case 2:
          a(paramList, paramInt1, b1, paramInt2, b2);
          return;
        case 1:
          break;
      } 
      c(paramList, paramInt1, b1, paramInt2, b2);
      return;
    } 
    b(paramList, paramInt1, b1, paramInt2, b2);
  }
  
  private int b(List<e.b> paramList) {
    int i = paramList.size() - 1;
    boolean bool = false;
    while (i >= 0) {
      if (((e.b)paramList.get(i)).a == 8) {
        if (bool)
          return i; 
      } else {
        bool = true;
      } 
      i--;
    } 
    return -1;
  }
  
  private void c(List<e.b> paramList, int paramInt1, e.b paramb1, int paramInt2, e.b paramb2) {
    int i;
    if (paramb1.d < paramb2.b) {
      i = -1;
    } else {
      i = 0;
    } 
    if (paramb1.b < paramb2.b)
      i++; 
    if (paramb2.b <= paramb1.b)
      paramb1.b += paramb2.d; 
    if (paramb2.b <= paramb1.d)
      paramb1.d += paramb2.d; 
    paramb2.b = i + paramb2.b;
    paramList.set(paramInt1, paramb2);
    paramList.set(paramInt2, paramb1);
  }
  
  void a(List<e.b> paramList) {
    while (true) {
      int i = b(paramList);
      if (i != -1) {
        a(paramList, i, i + 1);
        continue;
      } 
      break;
    } 
  }
  
  void a(List<e.b> paramList, int paramInt1, e.b paramb1, int paramInt2, e.b paramb2) { // Byte code:
    //   0: aload_3
    //   1: getfield b : I
    //   4: istore #6
    //   6: aload_3
    //   7: getfield d : I
    //   10: istore #7
    //   12: iconst_0
    //   13: istore #8
    //   15: iload #6
    //   17: iload #7
    //   19: if_icmpge -> 66
    //   22: aload #5
    //   24: getfield b : I
    //   27: aload_3
    //   28: getfield b : I
    //   31: if_icmpne -> 57
    //   34: aload #5
    //   36: getfield d : I
    //   39: aload_3
    //   40: getfield d : I
    //   43: aload_3
    //   44: getfield b : I
    //   47: isub
    //   48: if_icmpne -> 57
    //   51: iconst_0
    //   52: istore #9
    //   54: goto -> 100
    //   57: iconst_0
    //   58: istore #9
    //   60: iconst_0
    //   61: istore #8
    //   63: goto -> 109
    //   66: aload #5
    //   68: getfield b : I
    //   71: iconst_1
    //   72: aload_3
    //   73: getfield d : I
    //   76: iadd
    //   77: if_icmpne -> 106
    //   80: aload #5
    //   82: getfield d : I
    //   85: aload_3
    //   86: getfield b : I
    //   89: aload_3
    //   90: getfield d : I
    //   93: isub
    //   94: if_icmpne -> 106
    //   97: iconst_1
    //   98: istore #9
    //   100: iconst_1
    //   101: istore #8
    //   103: goto -> 109
    //   106: iconst_1
    //   107: istore #9
    //   109: aload_3
    //   110: getfield d : I
    //   113: aload #5
    //   115: getfield b : I
    //   118: if_icmpge -> 136
    //   121: aload #5
    //   123: aload #5
    //   125: getfield b : I
    //   128: iconst_1
    //   129: isub
    //   130: putfield b : I
    //   133: goto -> 205
    //   136: aload_3
    //   137: getfield d : I
    //   140: aload #5
    //   142: getfield b : I
    //   145: aload #5
    //   147: getfield d : I
    //   150: iadd
    //   151: if_icmpge -> 205
    //   154: aload #5
    //   156: aload #5
    //   158: getfield d : I
    //   161: iconst_1
    //   162: isub
    //   163: putfield d : I
    //   166: aload_3
    //   167: iconst_2
    //   168: putfield a : I
    //   171: aload_3
    //   172: iconst_1
    //   173: putfield d : I
    //   176: aload #5
    //   178: getfield d : I
    //   181: ifne -> 204
    //   184: aload_1
    //   185: iload #4
    //   187: invokeinterface remove : (I)Ljava/lang/Object;
    //   192: pop
    //   193: aload_0
    //   194: getfield a : Landroid/support/v7/widget/aw$a;
    //   197: aload #5
    //   199: invokeinterface a : (Landroid/support/v7/widget/e$b;)V
    //   204: return
    //   205: aload_3
    //   206: getfield b : I
    //   209: aload #5
    //   211: getfield b : I
    //   214: if_icmpgt -> 235
    //   217: aload #5
    //   219: iconst_1
    //   220: aload #5
    //   222: getfield b : I
    //   225: iadd
    //   226: putfield b : I
    //   229: aconst_null
    //   230: astore #12
    //   232: goto -> 318
    //   235: aload_3
    //   236: getfield b : I
    //   239: istore #10
    //   241: aload #5
    //   243: getfield b : I
    //   246: aload #5
    //   248: getfield d : I
    //   251: iadd
    //   252: istore #11
    //   254: aconst_null
    //   255: astore #12
    //   257: iload #10
    //   259: iload #11
    //   261: if_icmpge -> 318
    //   264: aload #5
    //   266: getfield b : I
    //   269: aload #5
    //   271: getfield d : I
    //   274: iadd
    //   275: aload_3
    //   276: getfield b : I
    //   279: isub
    //   280: istore #18
    //   282: aload_0
    //   283: getfield a : Landroid/support/v7/widget/aw$a;
    //   286: iconst_2
    //   287: iconst_1
    //   288: aload_3
    //   289: getfield b : I
    //   292: iadd
    //   293: iload #18
    //   295: aconst_null
    //   296: invokeinterface a : (IIILjava/lang/Object;)Landroid/support/v7/widget/e$b;
    //   301: astore #12
    //   303: aload #5
    //   305: aload_3
    //   306: getfield b : I
    //   309: aload #5
    //   311: getfield b : I
    //   314: isub
    //   315: putfield d : I
    //   318: iload #8
    //   320: ifeq -> 353
    //   323: aload_1
    //   324: iload_2
    //   325: aload #5
    //   327: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: aload_1
    //   334: iload #4
    //   336: invokeinterface remove : (I)Ljava/lang/Object;
    //   341: pop
    //   342: aload_0
    //   343: getfield a : Landroid/support/v7/widget/aw$a;
    //   346: aload_3
    //   347: invokeinterface a : (Landroid/support/v7/widget/e$b;)V
    //   352: return
    //   353: iload #9
    //   355: ifeq -> 456
    //   358: aload #12
    //   360: ifnull -> 415
    //   363: aload_3
    //   364: getfield b : I
    //   367: aload #12
    //   369: getfield b : I
    //   372: if_icmple -> 389
    //   375: aload_3
    //   376: aload_3
    //   377: getfield b : I
    //   380: aload #12
    //   382: getfield d : I
    //   385: isub
    //   386: putfield b : I
    //   389: aload_3
    //   390: getfield d : I
    //   393: aload #12
    //   395: getfield b : I
    //   398: if_icmple -> 415
    //   401: aload_3
    //   402: aload_3
    //   403: getfield d : I
    //   406: aload #12
    //   408: getfield d : I
    //   411: isub
    //   412: putfield d : I
    //   415: aload_3
    //   416: getfield b : I
    //   419: aload #5
    //   421: getfield b : I
    //   424: if_icmple -> 441
    //   427: aload_3
    //   428: aload_3
    //   429: getfield b : I
    //   432: aload #5
    //   434: getfield d : I
    //   437: isub
    //   438: putfield b : I
    //   441: aload_3
    //   442: getfield d : I
    //   445: aload #5
    //   447: getfield b : I
    //   450: if_icmple -> 565
    //   453: goto -> 551
    //   456: aload #12
    //   458: ifnull -> 513
    //   461: aload_3
    //   462: getfield b : I
    //   465: aload #12
    //   467: getfield b : I
    //   470: if_icmplt -> 487
    //   473: aload_3
    //   474: aload_3
    //   475: getfield b : I
    //   478: aload #12
    //   480: getfield d : I
    //   483: isub
    //   484: putfield b : I
    //   487: aload_3
    //   488: getfield d : I
    //   491: aload #12
    //   493: getfield b : I
    //   496: if_icmplt -> 513
    //   499: aload_3
    //   500: aload_3
    //   501: getfield d : I
    //   504: aload #12
    //   506: getfield d : I
    //   509: isub
    //   510: putfield d : I
    //   513: aload_3
    //   514: getfield b : I
    //   517: aload #5
    //   519: getfield b : I
    //   522: if_icmplt -> 539
    //   525: aload_3
    //   526: aload_3
    //   527: getfield b : I
    //   530: aload #5
    //   532: getfield d : I
    //   535: isub
    //   536: putfield b : I
    //   539: aload_3
    //   540: getfield d : I
    //   543: aload #5
    //   545: getfield b : I
    //   548: if_icmplt -> 565
    //   551: aload_3
    //   552: aload_3
    //   553: getfield d : I
    //   556: aload #5
    //   558: getfield d : I
    //   561: isub
    //   562: putfield d : I
    //   565: aload_1
    //   566: iload_2
    //   567: aload #5
    //   569: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   574: pop
    //   575: aload_3
    //   576: getfield b : I
    //   579: aload_3
    //   580: getfield d : I
    //   583: if_icmpeq -> 599
    //   586: aload_1
    //   587: iload #4
    //   589: aload_3
    //   590: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   595: pop
    //   596: goto -> 608
    //   599: aload_1
    //   600: iload #4
    //   602: invokeinterface remove : (I)Ljava/lang/Object;
    //   607: pop
    //   608: aload #12
    //   610: ifnull -> 622
    //   613: aload_1
    //   614: iload_2
    //   615: aload #12
    //   617: invokeinterface add : (ILjava/lang/Object;)V
    //   622: return }
  
  void b(List<e.b> paramList, int paramInt1, e.b paramb1, int paramInt2, e.b paramb2) { // Byte code:
    //   0: aload_3
    //   1: getfield d : I
    //   4: aload #5
    //   6: getfield b : I
    //   9: if_icmpge -> 27
    //   12: aload #5
    //   14: aload #5
    //   16: getfield b : I
    //   19: iconst_1
    //   20: isub
    //   21: putfield b : I
    //   24: goto -> 82
    //   27: aload_3
    //   28: getfield d : I
    //   31: aload #5
    //   33: getfield b : I
    //   36: aload #5
    //   38: getfield d : I
    //   41: iadd
    //   42: if_icmpge -> 82
    //   45: aload #5
    //   47: aload #5
    //   49: getfield d : I
    //   52: iconst_1
    //   53: isub
    //   54: putfield d : I
    //   57: aload_0
    //   58: getfield a : Landroid/support/v7/widget/aw$a;
    //   61: iconst_4
    //   62: aload_3
    //   63: getfield b : I
    //   66: iconst_1
    //   67: aload #5
    //   69: getfield c : Ljava/lang/Object;
    //   72: invokeinterface a : (IIILjava/lang/Object;)Landroid/support/v7/widget/e$b;
    //   77: astore #6
    //   79: goto -> 85
    //   82: aconst_null
    //   83: astore #6
    //   85: aload_3
    //   86: getfield b : I
    //   89: aload #5
    //   91: getfield b : I
    //   94: if_icmpgt -> 115
    //   97: aload #5
    //   99: iconst_1
    //   100: aload #5
    //   102: getfield b : I
    //   105: iadd
    //   106: putfield b : I
    //   109: aconst_null
    //   110: astore #9
    //   112: goto -> 200
    //   115: aload_3
    //   116: getfield b : I
    //   119: istore #7
    //   121: aload #5
    //   123: getfield b : I
    //   126: aload #5
    //   128: getfield d : I
    //   131: iadd
    //   132: istore #8
    //   134: aconst_null
    //   135: astore #9
    //   137: iload #7
    //   139: iload #8
    //   141: if_icmpge -> 200
    //   144: aload #5
    //   146: getfield b : I
    //   149: aload #5
    //   151: getfield d : I
    //   154: iadd
    //   155: aload_3
    //   156: getfield b : I
    //   159: isub
    //   160: istore #13
    //   162: aload_0
    //   163: getfield a : Landroid/support/v7/widget/aw$a;
    //   166: iconst_4
    //   167: iconst_1
    //   168: aload_3
    //   169: getfield b : I
    //   172: iadd
    //   173: iload #13
    //   175: aload #5
    //   177: getfield c : Ljava/lang/Object;
    //   180: invokeinterface a : (IIILjava/lang/Object;)Landroid/support/v7/widget/e$b;
    //   185: astore #9
    //   187: aload #5
    //   189: aload #5
    //   191: getfield d : I
    //   194: iload #13
    //   196: isub
    //   197: putfield d : I
    //   200: aload_1
    //   201: iload #4
    //   203: aload_3
    //   204: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload #5
    //   212: getfield d : I
    //   215: ifle -> 231
    //   218: aload_1
    //   219: iload_2
    //   220: aload #5
    //   222: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: goto -> 250
    //   231: aload_1
    //   232: iload_2
    //   233: invokeinterface remove : (I)Ljava/lang/Object;
    //   238: pop
    //   239: aload_0
    //   240: getfield a : Landroid/support/v7/widget/aw$a;
    //   243: aload #5
    //   245: invokeinterface a : (Landroid/support/v7/widget/e$b;)V
    //   250: aload #6
    //   252: ifnull -> 264
    //   255: aload_1
    //   256: iload_2
    //   257: aload #6
    //   259: invokeinterface add : (ILjava/lang/Object;)V
    //   264: aload #9
    //   266: ifnull -> 278
    //   269: aload_1
    //   270: iload_2
    //   271: aload #9
    //   273: invokeinterface add : (ILjava/lang/Object;)V
    //   278: return }
  
  static interface a {
    e.b a(int param1Int1, int param1Int2, int param1Int3, Object param1Object);
    
    void a(e.b param1b);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */