package android.support.v7.widget;

import android.support.v4.g.a;
import android.support.v4.g.f;
import android.support.v4.g.j;

class bt {
  final a<RecyclerView.x, a> a = new a();
  
  final f<RecyclerView.x> b = new f();
  
  private RecyclerView.f.c a(RecyclerView.x paramx, int paramInt) {
    int i = this.a.a(paramx);
    if (i < 0)
      return null; 
    a a1 = (a)this.a.c(i);
    if (a1 != null && (paramInt & a1.a) != 0) {
      RecyclerView.f.c c;
      a1.a &= (paramInt ^ 0xFFFFFFFF);
      if (paramInt == 4) {
        c = a1.b;
      } else if (paramInt == 8) {
        c = a1.c;
      } else {
        throw new IllegalArgumentException("Must provide flag PRE or POST");
      } 
      if ((0xC & a1.a) == 0) {
        this.a.d(i);
        a.a(a1);
      } 
      return c;
    } 
    return null;
  }
  
  RecyclerView.x a(long paramLong) { return (RecyclerView.x)this.b.a(paramLong); }
  
  void a() {
    this.a.clear();
    this.b.c();
  }
  
  void a(long paramLong, RecyclerView.x paramx) { this.b.b(paramLong, paramx); }
  
  void a(RecyclerView.x paramx, RecyclerView.f.c paramc) {
    a a1 = (a)this.a.get(paramx);
    if (a1 == null) {
      a1 = a.a();
      this.a.put(paramx, a1);
    } 
    a1.b = paramc;
    a1.a = 0x4 | a1.a;
  }
  
  void a(b paramb) { // Byte code:
    //   0: iconst_m1
    //   1: aload_0
    //   2: getfield a : Landroid/support/v4/g/a;
    //   5: invokevirtual size : ()I
    //   8: iadd
    //   9: istore_2
    //   10: iload_2
    //   11: iflt -> 229
    //   14: aload_0
    //   15: getfield a : Landroid/support/v4/g/a;
    //   18: iload_2
    //   19: invokevirtual b : (I)Ljava/lang/Object;
    //   22: checkcast android/support/v7/widget/RecyclerView$x
    //   25: astore_3
    //   26: aload_0
    //   27: getfield a : Landroid/support/v4/g/a;
    //   30: iload_2
    //   31: invokevirtual d : (I)Ljava/lang/Object;
    //   34: checkcast android/support/v7/widget/bt$a
    //   37: astore #4
    //   39: iconst_3
    //   40: aload #4
    //   42: getfield a : I
    //   45: iand
    //   46: iconst_3
    //   47: if_icmpne -> 60
    //   50: aload_1
    //   51: aload_3
    //   52: invokeinterface a : (Landroid/support/v7/widget/RecyclerView$x;)V
    //   57: goto -> 218
    //   60: iconst_1
    //   61: aload #4
    //   63: getfield a : I
    //   66: iand
    //   67: ifeq -> 109
    //   70: aload #4
    //   72: getfield b : Landroid/support/v7/widget/RecyclerView$f$c;
    //   75: ifnonnull -> 81
    //   78: goto -> 50
    //   81: aload #4
    //   83: getfield b : Landroid/support/v7/widget/RecyclerView$f$c;
    //   86: astore #6
    //   88: aload #4
    //   90: getfield c : Landroid/support/v7/widget/RecyclerView$f$c;
    //   93: astore #7
    //   95: aload_1
    //   96: aload_3
    //   97: aload #6
    //   99: aload #7
    //   101: invokeinterface a : (Landroid/support/v7/widget/RecyclerView$x;Landroid/support/v7/widget/RecyclerView$f$c;Landroid/support/v7/widget/RecyclerView$f$c;)V
    //   106: goto -> 218
    //   109: bipush #14
    //   111: aload #4
    //   113: getfield a : I
    //   116: iand
    //   117: bipush #14
    //   119: if_icmpne -> 142
    //   122: aload_1
    //   123: aload_3
    //   124: aload #4
    //   126: getfield b : Landroid/support/v7/widget/RecyclerView$f$c;
    //   129: aload #4
    //   131: getfield c : Landroid/support/v7/widget/RecyclerView$f$c;
    //   134: invokeinterface b : (Landroid/support/v7/widget/RecyclerView$x;Landroid/support/v7/widget/RecyclerView$f$c;Landroid/support/v7/widget/RecyclerView$f$c;)V
    //   139: goto -> 218
    //   142: bipush #12
    //   144: aload #4
    //   146: getfield a : I
    //   149: iand
    //   150: bipush #12
    //   152: if_icmpne -> 175
    //   155: aload_1
    //   156: aload_3
    //   157: aload #4
    //   159: getfield b : Landroid/support/v7/widget/RecyclerView$f$c;
    //   162: aload #4
    //   164: getfield c : Landroid/support/v7/widget/RecyclerView$f$c;
    //   167: invokeinterface c : (Landroid/support/v7/widget/RecyclerView$x;Landroid/support/v7/widget/RecyclerView$f$c;Landroid/support/v7/widget/RecyclerView$f$c;)V
    //   172: goto -> 218
    //   175: iconst_4
    //   176: aload #4
    //   178: getfield a : I
    //   181: iand
    //   182: ifeq -> 198
    //   185: aload #4
    //   187: getfield b : Landroid/support/v7/widget/RecyclerView$f$c;
    //   190: astore #6
    //   192: aconst_null
    //   193: astore #7
    //   195: goto -> 95
    //   198: bipush #8
    //   200: aload #4
    //   202: getfield a : I
    //   205: iand
    //   206: ifeq -> 212
    //   209: goto -> 122
    //   212: aload #4
    //   214: getfield a : I
    //   217: pop
    //   218: aload #4
    //   220: invokestatic a : (Landroid/support/v7/widget/bt$a;)V
    //   223: iinc #2, -1
    //   226: goto -> 10
    //   229: return }
  
  boolean a(RecyclerView.x paramx) {
    a a1 = (a)this.a.get(paramx);
    return (a1 != null && (true & a1.a) != 0);
  }
  
  RecyclerView.f.c b(RecyclerView.x paramx) { return a(paramx, 4); }
  
  void b() { a.b(); }
  
  void b(RecyclerView.x paramx, RecyclerView.f.c paramc) {
    a a1 = (a)this.a.get(paramx);
    if (a1 == null) {
      a1 = a.a();
      this.a.put(paramx, a1);
    } 
    a1.a = 0x2 | a1.a;
    a1.b = paramc;
  }
  
  RecyclerView.f.c c(RecyclerView.x paramx) { return a(paramx, 8); }
  
  void c(RecyclerView.x paramx, RecyclerView.f.c paramc) {
    a a1 = (a)this.a.get(paramx);
    if (a1 == null) {
      a1 = a.a();
      this.a.put(paramx, a1);
    } 
    a1.c = paramc;
    a1.a = 0x8 | a1.a;
  }
  
  boolean d(RecyclerView.x paramx) {
    a a1 = (a)this.a.get(paramx);
    return (a1 != null && (0x4 & a1.a) != 0);
  }
  
  void e(RecyclerView.x paramx) {
    a a1 = (a)this.a.get(paramx);
    if (a1 == null) {
      a1 = a.a();
      this.a.put(paramx, a1);
    } 
    a1.a = true | a1.a;
  }
  
  void f(RecyclerView.x paramx) {
    a a1 = (a)this.a.get(paramx);
    if (a1 == null)
      return; 
    a1.a = 0xFFFFFFFE & a1.a;
  }
  
  void g(RecyclerView.x paramx) {
    for (int i = -1 + this.b.b(); i >= 0; i--) {
      if (paramx == this.b.c(i)) {
        this.b.a(i);
        break;
      } 
    } 
    a a1 = (a)this.a.remove(paramx);
    if (a1 != null)
      a.a(a1); 
  }
  
  public void h(RecyclerView.x paramx) { f(paramx); }
  
  static class a {
    static j.a<a> d = new j.b(20);
    
    int a;
    
    RecyclerView.f.c b;
    
    RecyclerView.f.c c;
    
    static a a() {
      a a1 = (a)d.a();
      if (a1 == null)
        a1 = new a(); 
      return a1;
    }
    
    static void a(a param1a) {
      param1a.a = 0;
      param1a.b = null;
      param1a.c = null;
      d.a(param1a);
    }
    
    static void b() {
      while (d.a() != null);
    }
  }
  
  static interface b {
    void a(RecyclerView.x param1x);
    
    void a(RecyclerView.x param1x, RecyclerView.f.c param1c1, RecyclerView.f.c param1c2);
    
    void b(RecyclerView.x param1x, RecyclerView.f.c param1c1, RecyclerView.f.c param1c2);
    
    void c(RecyclerView.x param1x, RecyclerView.f.c param1c1, RecyclerView.f.c param1c2);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */