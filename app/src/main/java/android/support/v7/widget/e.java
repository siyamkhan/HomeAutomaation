package android.support.v7.widget;

import android.support.v4.g.j;
import java.util.ArrayList;
import java.util.List;

class e implements aw.a {
  final ArrayList<b> a = new ArrayList();
  
  final ArrayList<b> b = new ArrayList();
  
  final a c;
  
  Runnable d;
  
  final boolean e;
  
  final aw f;
  
  private j.a<b> g = new j.b(30);
  
  private int h = 0;
  
  e(a parama) { this(parama, false); }
  
  e(a parama, boolean paramBoolean) {
    this.c = parama;
    this.e = paramBoolean;
    this.f = new aw(this);
  }
  
  private int b(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: iconst_1
    //   8: isub
    //   9: istore_3
    //   10: iload_3
    //   11: iflt -> 367
    //   14: aload_0
    //   15: getfield b : Ljava/util/ArrayList;
    //   18: iload_3
    //   19: invokevirtual get : (I)Ljava/lang/Object;
    //   22: checkcast android/support/v7/widget/e$b
    //   25: astore #7
    //   27: aload #7
    //   29: getfield a : I
    //   32: bipush #8
    //   34: if_icmpne -> 271
    //   37: aload #7
    //   39: getfield b : I
    //   42: aload #7
    //   44: getfield d : I
    //   47: if_icmpge -> 67
    //   50: aload #7
    //   52: getfield b : I
    //   55: istore #9
    //   57: aload #7
    //   59: getfield d : I
    //   62: istore #10
    //   64: goto -> 81
    //   67: aload #7
    //   69: getfield d : I
    //   72: istore #9
    //   74: aload #7
    //   76: getfield b : I
    //   79: istore #10
    //   81: iload_1
    //   82: iload #9
    //   84: if_icmplt -> 197
    //   87: iload_1
    //   88: iload #10
    //   90: if_icmpgt -> 197
    //   93: iload #9
    //   95: aload #7
    //   97: getfield b : I
    //   100: if_icmpne -> 150
    //   103: iload_2
    //   104: iconst_1
    //   105: if_icmpne -> 127
    //   108: iconst_1
    //   109: aload #7
    //   111: getfield d : I
    //   114: iadd
    //   115: istore #13
    //   117: aload #7
    //   119: iload #13
    //   121: putfield d : I
    //   124: goto -> 144
    //   127: iload_2
    //   128: iconst_2
    //   129: if_icmpne -> 144
    //   132: aload #7
    //   134: getfield d : I
    //   137: iconst_1
    //   138: isub
    //   139: istore #13
    //   141: goto -> 117
    //   144: iinc #1, 1
    //   147: goto -> 361
    //   150: iload_2
    //   151: iconst_1
    //   152: if_icmpne -> 174
    //   155: iconst_1
    //   156: aload #7
    //   158: getfield b : I
    //   161: iadd
    //   162: istore #12
    //   164: aload #7
    //   166: iload #12
    //   168: putfield b : I
    //   171: goto -> 191
    //   174: iload_2
    //   175: iconst_2
    //   176: if_icmpne -> 191
    //   179: aload #7
    //   181: getfield b : I
    //   184: iconst_1
    //   185: isub
    //   186: istore #12
    //   188: goto -> 164
    //   191: iinc #1, -1
    //   194: goto -> 361
    //   197: iload_1
    //   198: aload #7
    //   200: getfield b : I
    //   203: if_icmpge -> 361
    //   206: iload_2
    //   207: iconst_1
    //   208: if_icmpne -> 242
    //   211: aload #7
    //   213: iconst_1
    //   214: aload #7
    //   216: getfield b : I
    //   219: iadd
    //   220: putfield b : I
    //   223: iconst_1
    //   224: aload #7
    //   226: getfield d : I
    //   229: iadd
    //   230: istore #11
    //   232: aload #7
    //   234: iload #11
    //   236: putfield d : I
    //   239: goto -> 361
    //   242: iload_2
    //   243: iconst_2
    //   244: if_icmpne -> 361
    //   247: aload #7
    //   249: aload #7
    //   251: getfield b : I
    //   254: iconst_1
    //   255: isub
    //   256: putfield b : I
    //   259: aload #7
    //   261: getfield d : I
    //   264: iconst_1
    //   265: isub
    //   266: istore #11
    //   268: goto -> 232
    //   271: aload #7
    //   273: getfield b : I
    //   276: iload_1
    //   277: if_icmpgt -> 320
    //   280: aload #7
    //   282: getfield a : I
    //   285: iconst_1
    //   286: if_icmpne -> 300
    //   289: iload_1
    //   290: aload #7
    //   292: getfield d : I
    //   295: isub
    //   296: istore_1
    //   297: goto -> 361
    //   300: aload #7
    //   302: getfield a : I
    //   305: iconst_2
    //   306: if_icmpne -> 361
    //   309: iload_1
    //   310: aload #7
    //   312: getfield d : I
    //   315: iadd
    //   316: istore_1
    //   317: goto -> 361
    //   320: iload_2
    //   321: iconst_1
    //   322: if_icmpne -> 344
    //   325: iconst_1
    //   326: aload #7
    //   328: getfield b : I
    //   331: iadd
    //   332: istore #8
    //   334: aload #7
    //   336: iload #8
    //   338: putfield b : I
    //   341: goto -> 361
    //   344: iload_2
    //   345: iconst_2
    //   346: if_icmpne -> 361
    //   349: aload #7
    //   351: getfield b : I
    //   354: iconst_1
    //   355: isub
    //   356: istore #8
    //   358: goto -> 334
    //   361: iinc #3, -1
    //   364: goto -> 10
    //   367: aload_0
    //   368: getfield b : Ljava/util/ArrayList;
    //   371: invokevirtual size : ()I
    //   374: iconst_1
    //   375: isub
    //   376: istore #4
    //   378: iload #4
    //   380: iflt -> 461
    //   383: aload_0
    //   384: getfield b : Ljava/util/ArrayList;
    //   387: iload #4
    //   389: invokevirtual get : (I)Ljava/lang/Object;
    //   392: checkcast android/support/v7/widget/e$b
    //   395: astore #5
    //   397: aload #5
    //   399: getfield a : I
    //   402: bipush #8
    //   404: if_icmpne -> 431
    //   407: aload #5
    //   409: getfield d : I
    //   412: aload #5
    //   414: getfield b : I
    //   417: if_icmpeq -> 439
    //   420: aload #5
    //   422: getfield d : I
    //   425: ifge -> 455
    //   428: goto -> 439
    //   431: aload #5
    //   433: getfield d : I
    //   436: ifgt -> 455
    //   439: aload_0
    //   440: getfield b : Ljava/util/ArrayList;
    //   443: iload #4
    //   445: invokevirtual remove : (I)Ljava/lang/Object;
    //   448: pop
    //   449: aload_0
    //   450: aload #5
    //   452: invokevirtual a : (Landroid/support/v7/widget/e$b;)V
    //   455: iinc #4, -1
    //   458: goto -> 378
    //   461: iload_1
    //   462: ireturn }
  
  private void b(b paramb) { g(paramb); }
  
  private void c(b paramb) {
    int i = paramb.b;
    int j = paramb.b + paramb.d;
    int k = paramb.b;
    int m = 0;
    byte b1;
    for (b1 = -1; k < j; b1 = b2) {
      byte b2;
      boolean bool;
      if (this.c.a(k) != null || d(k)) {
        if (b1 == 0) {
          e(a(2, i, m, null));
          bool = true;
        } else {
          bool = false;
        } 
        b2 = 1;
      } else {
        if (b1 == 1) {
          g(a(2, i, m, null));
          bool = true;
        } else {
          bool = false;
        } 
        b2 = 0;
      } 
      if (bool) {
        k -= m;
        j -= m;
        m = 1;
      } else {
        m++;
      } 
      k++;
    } 
    if (m != paramb.d) {
      a(paramb);
      paramb = a(2, i, m, null);
    } 
    if (b1 == 0) {
      e(paramb);
      return;
    } 
    g(paramb);
  }
  
  private void d(b paramb) {
    int i = paramb.b;
    int j = paramb.b + paramb.d;
    int k = paramb.b;
    int m = i;
    byte b1 = 0;
    byte b2 = -1;
    while (k < j) {
      if (this.c.a(k) != null || d(k)) {
        if (b2 == 0) {
          e(a(4, m, b1, paramb.c));
          m = k;
          b1 = 0;
        } 
        b2 = 1;
      } else {
        if (b2 == 1) {
          g(a(4, m, b1, paramb.c));
          m = k;
          b1 = 0;
        } 
        b2 = 0;
      } 
      b1++;
      k++;
    } 
    if (b1 != paramb.d) {
      Object object = paramb.c;
      a(paramb);
      paramb = a(4, m, b1, object);
    } 
    if (b2 == 0) {
      e(paramb);
      return;
    } 
    g(paramb);
  }
  
  private boolean d(int paramInt) {
    int i = this.b.size();
    for (byte b1 = 0; b1 < i; b1++) {
      b b2 = (b)this.b.get(b1);
      if (b2.a == 8) {
        if (a(b2.d, b1 + 1) == paramInt)
          return true; 
      } else if (b2.a == 1) {
        int j = b2.b + b2.d;
        for (int k = b2.b; k < j; k++) {
          if (a(k, b1 + 1) == paramInt)
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  private void e(b paramb) {
    if (paramb.a != 1 && paramb.a != 8) {
      byte b1;
      int i = b(paramb.b, paramb.a);
      int j = paramb.b;
      int k = paramb.a;
      if (k != 2) {
        if (k == 4) {
          b1 = 1;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("op should be remove or update.");
          stringBuilder.append(paramb);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        b1 = 0;
      } 
      int m = i;
      int n = j;
      byte b2 = 1;
      int i1 = 1;
      while (b2 < paramb.d) {
        boolean bool;
        int i2 = b(paramb.b + b1 * b2, paramb.a);
        int i3 = paramb.a;
        if ((i3 != 2) ? (i3 == 4 && i2 == m + 1) : (i2 == m)) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          i1++;
        } else {
          b b3 = a(paramb.a, m, i1, paramb.c);
          a(b3, n);
          a(b3);
          if (paramb.a == 4)
            n += i1; 
          m = i2;
          i1 = 1;
        } 
        b2++;
      } 
      Object object = paramb.c;
      a(paramb);
      if (i1 > 0) {
        b b3 = a(paramb.a, m, i1, object);
        a(b3, n);
        a(b3);
      } 
      return;
    } 
    throw new IllegalArgumentException("should not dispatch add or move for pre layout");
  }
  
  private void f(b paramb) { g(paramb); }
  
  private void g(b paramb) {
    this.b.add(paramb);
    int i = paramb.a;
    if (i != 4) {
      if (i != 8) {
        StringBuilder stringBuilder;
        switch (i) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown update op type for ");
            stringBuilder.append(paramb);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 2:
            this.c.b(paramb.b, paramb.d);
            return;
          case 1:
            break;
        } 
        this.c.c(paramb.b, paramb.d);
        return;
      } 
      this.c.d(paramb.b, paramb.d);
      return;
    } 
    this.c.a(paramb.b, paramb.d, paramb.c);
  }
  
  int a(int paramInt1, int paramInt2) {
    int i = this.b.size();
    while (paramInt2 < i) {
      b b1 = (b)this.b.get(paramInt2);
      if (b1.a == 8) {
        if (b1.b == paramInt1) {
          paramInt1 = b1.d;
        } else {
          if (b1.b < paramInt1)
            paramInt1--; 
          if (b1.d <= paramInt1)
            paramInt1++; 
        } 
      } else if (b1.b <= paramInt1) {
        if (b1.a == 2) {
          if (paramInt1 < b1.b + b1.d)
            return -1; 
          paramInt1 -= b1.d;
        } else if (b1.a == 1) {
          paramInt1 += b1.d;
        } 
      } 
      paramInt2++;
    } 
    return paramInt1;
  }
  
  public b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
    b b1 = (b)this.g.a();
    if (b1 == null)
      return new b(paramInt1, paramInt2, paramInt3, paramObject); 
    b1.a = paramInt1;
    b1.b = paramInt2;
    b1.d = paramInt3;
    b1.c = paramObject;
    return b1;
  }
  
  void a() {
    a(this.a);
    a(this.b);
    this.h = 0;
  }
  
  public void a(b paramb) {
    if (!this.e) {
      paramb.c = null;
      this.g.a(paramb);
    } 
  }
  
  void a(b paramb, int paramInt) {
    this.c.a(paramb);
    int i = paramb.a;
    if (i != 2) {
      if (i == 4) {
        this.c.a(paramInt, paramb.d, paramb.c);
        return;
      } 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    } 
    this.c.a(paramInt, paramb.d);
  }
  
  void a(List<b> paramList) {
    int i = paramList.size();
    for (byte b1 = 0; b1 < i; b1++)
      a((b)paramList.get(b1)); 
    paramList.clear();
  }
  
  boolean a(int paramInt) { return ((paramInt & this.h) != 0); }
  
  int b(int paramInt) { return a(paramInt, 0); }
  
  void b() {
    this.f.a(this.a);
    int i = this.a.size();
    for (byte b1 = 0; b1 < i; b1++) {
      b b2 = (b)this.a.get(b1);
      int j = b2.a;
      if (j != 4) {
        if (j != 8) {
          switch (j) {
            case 2:
              c(b2);
              break;
            case 1:
              f(b2);
              break;
          } 
        } else {
          b(b2);
        } 
      } else {
        d(b2);
      } 
      Runnable runnable = this.d;
      if (runnable != null)
        runnable.run(); 
    } 
    this.a.clear();
  }
  
  public int c(int paramInt) {
    int i = this.a.size();
    for (byte b1 = 0; b1 < i; b1++) {
      b b2 = (b)this.a.get(b1);
      int j = b2.a;
      if (j != 8) {
        switch (j) {
          case 2:
            if (b2.b <= paramInt) {
              if (b2.b + b2.d > paramInt)
                return -1; 
              paramInt -= b2.d;
            } 
            break;
          case 1:
            if (b2.b <= paramInt)
              paramInt += b2.d; 
            break;
        } 
      } else if (b2.b == paramInt) {
        paramInt = b2.d;
      } else {
        if (b2.b < paramInt)
          paramInt--; 
        if (b2.d <= paramInt)
          paramInt++; 
      } 
    } 
    return paramInt;
  }
  
  void c() {
    int i = this.b.size();
    for (byte b1 = 0; b1 < i; b1++)
      this.c.b((b)this.b.get(b1)); 
    a(this.b);
    this.h = 0;
  }
  
  boolean d() { return (this.a.size() > 0); }
  
  void e() {
    c();
    int i = this.a.size();
    for (byte b1 = 0; b1 < i; b1++) {
      b b2 = (b)this.a.get(b1);
      int j = b2.a;
      if (j != 4) {
        if (j != 8) {
          switch (j) {
            case 2:
              this.c.b(b2);
              this.c.a(b2.b, b2.d);
              break;
            case 1:
              this.c.b(b2);
              this.c.c(b2.b, b2.d);
              break;
          } 
        } else {
          this.c.b(b2);
          this.c.d(b2.b, b2.d);
        } 
      } else {
        this.c.b(b2);
        this.c.a(b2.b, b2.d, b2.c);
      } 
      Runnable runnable = this.d;
      if (runnable != null)
        runnable.run(); 
    } 
    a(this.a);
    this.h = 0;
  }
  
  boolean f() { return (!this.b.isEmpty() && !this.a.isEmpty()); }
  
  static interface a {
    RecyclerView.x a(int param1Int);
    
    void a(int param1Int1, int param1Int2);
    
    void a(int param1Int1, int param1Int2, Object param1Object);
    
    void a(e.b param1b);
    
    void b(int param1Int1, int param1Int2);
    
    void b(e.b param1b);
    
    void c(int param1Int1, int param1Int2);
    
    void d(int param1Int1, int param1Int2);
  }
  
  static class b {
    int a;
    
    int b;
    
    Object c;
    
    int d;
    
    b(int param1Int1, int param1Int2, int param1Int3, Object param1Object) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.d = param1Int3;
      this.c = param1Object;
    }
    
    String a() {
      int i = this.a;
      if (i != 4) {
        if (i != 8) {
          switch (i) {
            default:
              return "??";
            case 2:
              return "rm";
            case 1:
              break;
          } 
          return "add";
        } 
        return "mv";
      } 
      return "up";
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        b b1 = (b)param1Object;
        int i = this.a;
        if (i != b1.a)
          return false; 
        if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == b1.b && this.b == b1.d)
          return true; 
        if (this.d != b1.d)
          return false; 
        if (this.b != b1.b)
          return false; 
        Object object = this.c;
        if (object != null) {
          if (!object.equals(b1.c))
            return false; 
        } else if (b1.c != null) {
          return false;
        } 
        return true;
      } 
      return false;
    }
    
    public int hashCode() { return 31 * (31 * this.a + this.b) + this.d; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append("[");
      stringBuilder.append(a());
      stringBuilder.append(",s:");
      stringBuilder.append(this.b);
      stringBuilder.append("c:");
      stringBuilder.append(this.d);
      stringBuilder.append(",p:");
      stringBuilder.append(this.c);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */