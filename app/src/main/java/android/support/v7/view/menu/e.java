package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.widget.au;
import android.support.v7.widget.av;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e extends m implements o, View.OnKeyListener, PopupWindow.OnDismissListener {
  private static final int g = a.g.abc_cascading_menu_item_layout;
  
  private PopupWindow.OnDismissListener A;
  
  final Handler a;
  
  final List<a> b = new ArrayList();
  
  final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener(this) {
      public void onGlobalLayout() {
        if (this.a.d() && this.a.b.size() > 0 && !((e.a)this.a.b.get(0)).a.g()) {
          View view = this.a.d;
          if (view == null || !view.isShown()) {
            this.a.c();
            return;
          } 
          Iterator iterator = this.a.b.iterator();
          while (iterator.hasNext())
            ((e.a)iterator.next()).a.a(); 
        } 
      }
    };
  
  View d;
  
  ViewTreeObserver e;
  
  boolean f;
  
  private final Context h;
  
  private final int i;
  
  private final int j;
  
  private final int k;
  
  private final boolean l;
  
  private final List<h> m = new ArrayList();
  
  private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener(this) {
      public void onViewAttachedToWindow(View param1View) {}
      
      public void onViewDetachedFromWindow(View param1View) {
        if (this.a.e != null) {
          if (!this.a.e.isAlive())
            this.a.e = param1View.getViewTreeObserver(); 
          this.a.e.removeGlobalOnLayoutListener(this.a.c);
        } 
        param1View.removeOnAttachStateChangeListener(this);
      }
    };
  
  private final au o = new au(this) {
      public void a(h param1h, MenuItem param1MenuItem) { this.a.a.removeCallbacksAndMessages(param1h); }
      
      public void b(h param1h, MenuItem param1MenuItem) { // Byte code:
        //   0: aload_0
        //   1: getfield a : Landroid/support/v7/view/menu/e;
        //   4: getfield a : Landroid/os/Handler;
        //   7: aconst_null
        //   8: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
        //   11: aload_0
        //   12: getfield a : Landroid/support/v7/view/menu/e;
        //   15: getfield b : Ljava/util/List;
        //   18: invokeinterface size : ()I
        //   23: istore_3
        //   24: iconst_0
        //   25: istore #4
        //   27: iload #4
        //   29: iload_3
        //   30: if_icmpge -> 66
        //   33: aload_1
        //   34: aload_0
        //   35: getfield a : Landroid/support/v7/view/menu/e;
        //   38: getfield b : Ljava/util/List;
        //   41: iload #4
        //   43: invokeinterface get : (I)Ljava/lang/Object;
        //   48: checkcast android/support/v7/view/menu/e$a
        //   51: getfield b : Landroid/support/v7/view/menu/h;
        //   54: if_acmpne -> 60
        //   57: goto -> 69
        //   60: iinc #4, 1
        //   63: goto -> 27
        //   66: iconst_m1
        //   67: istore #4
        //   69: iload #4
        //   71: iconst_m1
        //   72: if_icmpne -> 76
        //   75: return
        //   76: iload #4
        //   78: iconst_1
        //   79: iadd
        //   80: istore #5
        //   82: aload_0
        //   83: getfield a : Landroid/support/v7/view/menu/e;
        //   86: getfield b : Ljava/util/List;
        //   89: invokeinterface size : ()I
        //   94: istore #6
        //   96: aconst_null
        //   97: astore #7
        //   99: iload #5
        //   101: iload #6
        //   103: if_icmpge -> 125
        //   106: aload_0
        //   107: getfield a : Landroid/support/v7/view/menu/e;
        //   110: getfield b : Ljava/util/List;
        //   113: iload #5
        //   115: invokeinterface get : (I)Ljava/lang/Object;
        //   120: checkcast android/support/v7/view/menu/e$a
        //   123: astore #7
        //   125: new android/support/v7/view/menu/e$3$1
        //   128: dup
        //   129: aload_0
        //   130: aload #7
        //   132: aload_2
        //   133: aload_1
        //   134: invokespecial <init> : (Landroid/support/v7/view/menu/e$3;Landroid/support/v7/view/menu/e$a;Landroid/view/MenuItem;Landroid/support/v7/view/menu/h;)V
        //   137: astore #8
        //   139: ldc2_w 200
        //   142: invokestatic uptimeMillis : ()J
        //   145: ladd
        //   146: lstore #9
        //   148: aload_0
        //   149: getfield a : Landroid/support/v7/view/menu/e;
        //   152: getfield a : Landroid/os/Handler;
        //   155: aload #8
        //   157: aload_1
        //   158: lload #9
        //   160: invokevirtual postAtTime : (Ljava/lang/Runnable;Ljava/lang/Object;J)Z
        //   163: pop
        //   164: return }
    };
  
  private int p = 0;
  
  private int q = 0;
  
  private View r;
  
  private int s;
  
  private boolean t;
  
  private boolean u;
  
  private int v;
  
  private int w;
  
  private boolean x;
  
  private boolean y;
  
  private o.a z;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    this.h = paramContext;
    this.r = paramView;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramBoolean;
    this.x = false;
    this.s = i();
    Resources resources = paramContext.getResources();
    this.i = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.a = new Handler();
  }
  
  private MenuItem a(h paramh1, h paramh2) {
    int i1 = paramh1.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      MenuItem menuItem = paramh1.getItem(b1);
      if (menuItem.hasSubMenu() && paramh2 == menuItem.getSubMenu())
        return menuItem; 
    } 
    return null;
  }
  
  private View a(a parama, h paramh) { // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getfield b : Landroid/support/v7/view/menu/h;
    //   5: aload_2
    //   6: invokespecial a : (Landroid/support/v7/view/menu/h;Landroid/support/v7/view/menu/h;)Landroid/view/MenuItem;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnonnull -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual a : ()Landroid/widget/ListView;
    //   20: astore #4
    //   22: aload #4
    //   24: invokevirtual getAdapter : ()Landroid/widget/ListAdapter;
    //   27: astore #5
    //   29: aload #5
    //   31: instanceof android/widget/HeaderViewListAdapter
    //   34: istore #6
    //   36: iconst_0
    //   37: istore #7
    //   39: iload #6
    //   41: ifeq -> 71
    //   44: aload #5
    //   46: checkcast android/widget/HeaderViewListAdapter
    //   49: astore #12
    //   51: aload #12
    //   53: invokevirtual getHeadersCount : ()I
    //   56: istore #9
    //   58: aload #12
    //   60: invokevirtual getWrappedAdapter : ()Landroid/widget/ListAdapter;
    //   63: checkcast android/support/v7/view/menu/g
    //   66: astore #8
    //   68: goto -> 81
    //   71: aload #5
    //   73: checkcast android/support/v7/view/menu/g
    //   76: astore #8
    //   78: iconst_0
    //   79: istore #9
    //   81: aload #8
    //   83: invokevirtual getCount : ()I
    //   86: istore #10
    //   88: iload #7
    //   90: iload #10
    //   92: if_icmpge -> 115
    //   95: aload_3
    //   96: aload #8
    //   98: iload #7
    //   100: invokevirtual a : (I)Landroid/support/v7/view/menu/j;
    //   103: if_acmpne -> 109
    //   106: goto -> 118
    //   109: iinc #7, 1
    //   112: goto -> 88
    //   115: iconst_m1
    //   116: istore #7
    //   118: iload #7
    //   120: iconst_m1
    //   121: if_icmpne -> 126
    //   124: aconst_null
    //   125: areturn
    //   126: iload #7
    //   128: iload #9
    //   130: iadd
    //   131: aload #4
    //   133: invokevirtual getFirstVisiblePosition : ()I
    //   136: isub
    //   137: istore #11
    //   139: iload #11
    //   141: iflt -> 164
    //   144: iload #11
    //   146: aload #4
    //   148: invokevirtual getChildCount : ()I
    //   151: if_icmplt -> 156
    //   154: aconst_null
    //   155: areturn
    //   156: aload #4
    //   158: iload #11
    //   160: invokevirtual getChildAt : (I)Landroid/view/View;
    //   163: areturn
    //   164: aconst_null
    //   165: areturn }
  
  private void c(h paramh) { // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/content/Context;
    //   4: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   7: astore_2
    //   8: new android/support/v7/view/menu/g
    //   11: dup
    //   12: aload_1
    //   13: aload_2
    //   14: aload_0
    //   15: getfield l : Z
    //   18: getstatic android/support/v7/view/menu/e.g : I
    //   21: invokespecial <init> : (Landroid/support/v7/view/menu/h;Landroid/view/LayoutInflater;ZI)V
    //   24: astore_3
    //   25: aload_0
    //   26: invokevirtual d : ()Z
    //   29: ifne -> 47
    //   32: aload_0
    //   33: getfield x : Z
    //   36: ifeq -> 47
    //   39: aload_3
    //   40: iconst_1
    //   41: invokevirtual a : (Z)V
    //   44: goto -> 62
    //   47: aload_0
    //   48: invokevirtual d : ()Z
    //   51: ifeq -> 62
    //   54: aload_3
    //   55: aload_1
    //   56: invokestatic b : (Landroid/support/v7/view/menu/h;)Z
    //   59: invokevirtual a : (Z)V
    //   62: aload_3
    //   63: aconst_null
    //   64: aload_0
    //   65: getfield h : Landroid/content/Context;
    //   68: aload_0
    //   69: getfield i : I
    //   72: invokestatic a : (Landroid/widget/ListAdapter;Landroid/view/ViewGroup;Landroid/content/Context;I)I
    //   75: istore #4
    //   77: aload_0
    //   78: invokespecial h : ()Landroid/support/v7/widget/av;
    //   81: astore #5
    //   83: aload #5
    //   85: aload_3
    //   86: invokevirtual a : (Landroid/widget/ListAdapter;)V
    //   89: aload #5
    //   91: iload #4
    //   93: invokevirtual g : (I)V
    //   96: aload #5
    //   98: aload_0
    //   99: getfield q : I
    //   102: invokevirtual e : (I)V
    //   105: aload_0
    //   106: getfield b : Ljava/util/List;
    //   109: invokeinterface size : ()I
    //   114: ifle -> 156
    //   117: aload_0
    //   118: getfield b : Ljava/util/List;
    //   121: astore #20
    //   123: aload #20
    //   125: aload #20
    //   127: invokeinterface size : ()I
    //   132: iconst_1
    //   133: isub
    //   134: invokeinterface get : (I)Ljava/lang/Object;
    //   139: checkcast android/support/v7/view/menu/e$a
    //   142: astore #6
    //   144: aload_0
    //   145: aload #6
    //   147: aload_1
    //   148: invokespecial a : (Landroid/support/v7/view/menu/e$a;Landroid/support/v7/view/menu/h;)Landroid/view/View;
    //   151: astore #7
    //   153: goto -> 162
    //   156: aconst_null
    //   157: astore #6
    //   159: aconst_null
    //   160: astore #7
    //   162: aload #7
    //   164: ifnull -> 401
    //   167: aload #5
    //   169: iconst_0
    //   170: invokevirtual c : (Z)V
    //   173: aload #5
    //   175: aconst_null
    //   176: invokevirtual a : (Ljava/lang/Object;)V
    //   179: aload_0
    //   180: iload #4
    //   182: invokespecial d : (I)I
    //   185: istore #13
    //   187: iload #13
    //   189: iconst_1
    //   190: if_icmpne -> 199
    //   193: iconst_1
    //   194: istore #14
    //   196: goto -> 202
    //   199: iconst_0
    //   200: istore #14
    //   202: aload_0
    //   203: iload #13
    //   205: putfield s : I
    //   208: getstatic android/os/Build$VERSION.SDK_INT : I
    //   211: bipush #26
    //   213: if_icmplt -> 232
    //   216: aload #5
    //   218: aload #7
    //   220: invokevirtual b : (Landroid/view/View;)V
    //   223: iconst_0
    //   224: istore #18
    //   226: iconst_0
    //   227: istore #17
    //   229: goto -> 321
    //   232: iconst_2
    //   233: newarray int
    //   235: astore #15
    //   237: aload_0
    //   238: getfield r : Landroid/view/View;
    //   241: aload #15
    //   243: invokevirtual getLocationOnScreen : ([I)V
    //   246: iconst_2
    //   247: newarray int
    //   249: astore #16
    //   251: aload #7
    //   253: aload #16
    //   255: invokevirtual getLocationOnScreen : ([I)V
    //   258: bipush #7
    //   260: aload_0
    //   261: getfield q : I
    //   264: iand
    //   265: iconst_5
    //   266: if_icmpne -> 299
    //   269: aload #15
    //   271: iconst_0
    //   272: aload #15
    //   274: iconst_0
    //   275: iaload
    //   276: aload_0
    //   277: getfield r : Landroid/view/View;
    //   280: invokevirtual getWidth : ()I
    //   283: iadd
    //   284: iastore
    //   285: aload #16
    //   287: iconst_0
    //   288: aload #16
    //   290: iconst_0
    //   291: iaload
    //   292: aload #7
    //   294: invokevirtual getWidth : ()I
    //   297: iadd
    //   298: iastore
    //   299: aload #16
    //   301: iconst_0
    //   302: iaload
    //   303: aload #15
    //   305: iconst_0
    //   306: iaload
    //   307: isub
    //   308: istore #17
    //   310: aload #16
    //   312: iconst_1
    //   313: iaload
    //   314: aload #15
    //   316: iconst_1
    //   317: iaload
    //   318: isub
    //   319: istore #18
    //   321: iconst_5
    //   322: aload_0
    //   323: getfield q : I
    //   326: iand
    //   327: iconst_5
    //   328: if_icmpne -> 349
    //   331: iload #14
    //   333: ifeq -> 339
    //   336: goto -> 361
    //   339: aload #7
    //   341: invokevirtual getWidth : ()I
    //   344: istore #4
    //   346: goto -> 371
    //   349: iload #14
    //   351: ifeq -> 371
    //   354: aload #7
    //   356: invokevirtual getWidth : ()I
    //   359: istore #4
    //   361: iload #17
    //   363: iload #4
    //   365: iadd
    //   366: istore #19
    //   368: goto -> 378
    //   371: iload #17
    //   373: iload #4
    //   375: isub
    //   376: istore #19
    //   378: aload #5
    //   380: iload #19
    //   382: invokevirtual c : (I)V
    //   385: aload #5
    //   387: iconst_1
    //   388: invokevirtual b : (Z)V
    //   391: aload #5
    //   393: iload #18
    //   395: invokevirtual d : (I)V
    //   398: goto -> 442
    //   401: aload_0
    //   402: getfield t : Z
    //   405: ifeq -> 417
    //   408: aload #5
    //   410: aload_0
    //   411: getfield v : I
    //   414: invokevirtual c : (I)V
    //   417: aload_0
    //   418: getfield u : Z
    //   421: ifeq -> 433
    //   424: aload #5
    //   426: aload_0
    //   427: getfield w : I
    //   430: invokevirtual d : (I)V
    //   433: aload #5
    //   435: aload_0
    //   436: invokevirtual g : ()Landroid/graphics/Rect;
    //   439: invokevirtual a : (Landroid/graphics/Rect;)V
    //   442: new android/support/v7/view/menu/e$a
    //   445: dup
    //   446: aload #5
    //   448: aload_1
    //   449: aload_0
    //   450: getfield s : I
    //   453: invokespecial <init> : (Landroid/support/v7/widget/av;Landroid/support/v7/view/menu/h;I)V
    //   456: astore #8
    //   458: aload_0
    //   459: getfield b : Ljava/util/List;
    //   462: aload #8
    //   464: invokeinterface add : (Ljava/lang/Object;)Z
    //   469: pop
    //   470: aload #5
    //   472: invokevirtual a : ()V
    //   475: aload #5
    //   477: invokevirtual e : ()Landroid/widget/ListView;
    //   480: astore #10
    //   482: aload #10
    //   484: aload_0
    //   485: invokevirtual setOnKeyListener : (Landroid/view/View$OnKeyListener;)V
    //   488: aload #6
    //   490: ifnonnull -> 564
    //   493: aload_0
    //   494: getfield y : Z
    //   497: ifeq -> 564
    //   500: aload_1
    //   501: invokevirtual n : ()Ljava/lang/CharSequence;
    //   504: ifnull -> 564
    //   507: aload_2
    //   508: getstatic android/support/v7/a/a$g.abc_popup_menu_header_item_layout : I
    //   511: aload #10
    //   513: iconst_0
    //   514: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   517: checkcast android/widget/FrameLayout
    //   520: astore #11
    //   522: aload #11
    //   524: ldc_w 16908310
    //   527: invokevirtual findViewById : (I)Landroid/view/View;
    //   530: checkcast android/widget/TextView
    //   533: astore #12
    //   535: aload #11
    //   537: iconst_0
    //   538: invokevirtual setEnabled : (Z)V
    //   541: aload #12
    //   543: aload_1
    //   544: invokevirtual n : ()Ljava/lang/CharSequence;
    //   547: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   550: aload #10
    //   552: aload #11
    //   554: aconst_null
    //   555: iconst_0
    //   556: invokevirtual addHeaderView : (Landroid/view/View;Ljava/lang/Object;Z)V
    //   559: aload #5
    //   561: invokevirtual a : ()V
    //   564: return }
  
  private int d(int paramInt) {
    List list = this.b;
    ListView listView = ((a)list.get(list.size() - 1)).a();
    int[] arrayOfInt = new int[2];
    listView.getLocationOnScreen(arrayOfInt);
    Rect rect = new Rect();
    this.d.getWindowVisibleDisplayFrame(rect);
    return (this.s == 1) ? ((paramInt + arrayOfInt[0] + listView.getWidth() > rect.right) ? 0 : 1) : ((arrayOfInt[0] - paramInt < 0) ? 1 : 0);
  }
  
  private int d(h paramh) {
    int i1 = this.b.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      if (paramh == ((a)this.b.get(b1)).b)
        return b1; 
    } 
    return -1;
  }
  
  private av h() {
    av av = new av(this.h, null, this.j, this.k);
    av.a(this.o);
    av.a(this);
    av.a(this);
    av.b(this.r);
    av.e(this.q);
    av.a(true);
    av.h(2);
    return av;
  }
  
  private int i() {
    int i1 = r.f(this.r);
    byte b1 = 1;
    if (i1 == b1)
      b1 = 0; 
    return b1;
  }
  
  public void a() {
    if (d())
      return; 
    Iterator iterator = this.m.iterator();
    while (iterator.hasNext())
      c((h)iterator.next()); 
    this.m.clear();
    this.d = this.r;
    if (this.d != null) {
      boolean bool;
      if (this.e == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.e = this.d.getViewTreeObserver();
      if (bool)
        this.e.addOnGlobalLayoutListener(this.c); 
      this.d.addOnAttachStateChangeListener(this.n);
    } 
  }
  
  public void a(int paramInt) {
    if (this.p != paramInt) {
      this.p = paramInt;
      this.q = d.a(paramInt, r.f(this.r));
    } 
  }
  
  public void a(h paramh) {
    paramh.a(this, this.h);
    if (d()) {
      c(paramh);
      return;
    } 
    this.m.add(paramh);
  }
  
  public void a(h paramh, boolean paramBoolean) {
    int i4;
    int i1 = d(paramh);
    if (i1 < 0)
      return; 
    int i2 = i1 + 1;
    if (i2 < this.b.size())
      ((a)this.b.get(i2)).b.a(false); 
    a a1 = (a)this.b.remove(i1);
    a1.b.b(this);
    if (this.f) {
      a1.a.b(null);
      a1.a.b(0);
    } 
    a1.a.c();
    int i3 = this.b.size();
    if (i3 > 0) {
      i4 = ((a)this.b.get(i3 - 1)).c;
    } else {
      i4 = i();
    } 
    this.s = i4;
    if (i3 == 0) {
      c();
      o.a a2 = this.z;
      if (a2 != null)
        a2.a(paramh, true); 
      ViewTreeObserver viewTreeObserver = this.e;
      if (viewTreeObserver != null) {
        if (viewTreeObserver.isAlive())
          this.e.removeGlobalOnLayoutListener(this.c); 
        this.e = null;
      } 
      this.d.removeOnAttachStateChangeListener(this.n);
      this.A.onDismiss();
      return;
    } 
    if (paramBoolean)
      ((a)this.b.get(0)).b.a(false); 
  }
  
  public void a(o.a parama) { this.z = parama; }
  
  public void a(View paramView) {
    if (this.r != paramView) {
      this.r = paramView;
      this.q = d.a(this.p, r.f(this.r));
    } 
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener) { this.A = paramOnDismissListener; }
  
  public void a(boolean paramBoolean) { this.x = paramBoolean; }
  
  public boolean a(u paramu) {
    for (a a1 : this.b) {
      if (paramu == a1.b) {
        a1.a().requestFocus();
        return true;
      } 
    } 
    if (paramu.hasVisibleItems()) {
      a(paramu);
      o.a a1 = this.z;
      if (a1 != null)
        a1.a(paramu); 
      return true;
    } 
    return false;
  }
  
  public void b(int paramInt) {
    this.t = true;
    this.v = paramInt;
  }
  
  public void b(boolean paramBoolean) {
    Iterator iterator = this.b.iterator();
    while (iterator.hasNext())
      a(((a)iterator.next()).a().getAdapter()).notifyDataSetChanged(); 
  }
  
  public boolean b() { return false; }
  
  public void c() {
    int i1 = this.b.size();
    if (i1 > 0) {
      a[] arrayOfa = (a[])this.b.toArray(new a[i1]);
      for (int i2 = i1 - 1; i2 >= 0; i2--) {
        a a1 = arrayOfa[i2];
        if (a1.a.d())
          a1.a.c(); 
      } 
    } 
  }
  
  public void c(int paramInt) {
    this.u = true;
    this.w = paramInt;
  }
  
  public void c(boolean paramBoolean) { this.y = paramBoolean; }
  
  public boolean d() {
    int i1 = this.b.size();
    boolean bool = false;
    if (i1 > 0) {
      boolean bool1 = ((a)this.b.get(0)).a.d();
      bool = false;
      if (bool1)
        bool = true; 
    } 
    return bool;
  }
  
  public ListView e() {
    if (this.b.isEmpty())
      return null; 
    List list = this.b;
    return ((a)list.get(-1 + list.size())).a();
  }
  
  protected boolean f() { return false; }
  
  public void onDismiss() { // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: istore_1
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_1
    //   14: if_icmpge -> 50
    //   17: aload_0
    //   18: getfield b : Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface get : (I)Ljava/lang/Object;
    //   27: checkcast android/support/v7/view/menu/e$a
    //   30: astore_3
    //   31: aload_3
    //   32: getfield a : Landroid/support/v7/widget/av;
    //   35: invokevirtual d : ()Z
    //   38: ifne -> 44
    //   41: goto -> 52
    //   44: iinc #2, 1
    //   47: goto -> 12
    //   50: aconst_null
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull -> 64
    //   56: aload_3
    //   57: getfield b : Landroid/support/v7/view/menu/h;
    //   60: iconst_0
    //   61: invokevirtual a : (Z)V
    //   64: return }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramInt == 82) {
      c();
      return true;
    } 
    return false;
  }
  
  private static class a {
    public final av a;
    
    public final h b;
    
    public final int c;
    
    public a(av param1av, h param1h, int param1Int) {
      this.a = param1av;
      this.b = param1h;
      this.c = param1Int;
    }
    
    public ListView a() { return this.a.e(); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */