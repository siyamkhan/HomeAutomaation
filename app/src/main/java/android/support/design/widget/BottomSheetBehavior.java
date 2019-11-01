package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.v4.c.a;
import android.support.v4.h.a;
import android.support.v4.h.r;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {
  int a;
  
  int b;
  
  int c;
  
  boolean d;
  
  int e = 4;
  
  q f;
  
  int g;
  
  WeakReference<V> h;
  
  WeakReference<View> i;
  
  int j;
  
  boolean k;
  
  private boolean l = true;
  
  private float m;
  
  private int n;
  
  private boolean o;
  
  private int p;
  
  private int q;
  
  private boolean r;
  
  private boolean s;
  
  private int t;
  
  private boolean u;
  
  private a v;
  
  private VelocityTracker w;
  
  private int x;
  
  private Map<View, Integer> y;
  
  private final q.a z = new q.a(this) {
      public int a(View param1View) { return this.a.d ? this.a.g : this.a.c; }
      
      public int a(View param1View, int param1Int1, int param1Int2) {
        int j;
        int i = BottomSheetBehavior.b(this.a);
        if (this.a.d) {
          j = this.a.g;
        } else {
          j = this.a.c;
        } 
        return a.a(param1Int1, i, j);
      }
      
      public void a(int param1Int) {
        if (param1Int == 1)
          this.a.b(1); 
      }
      
      public void a(View param1View, float param1Float1, float param1Float2) { // Byte code:
        //   0: iconst_4
        //   1: istore #4
        //   3: fload_3
        //   4: fconst_0
        //   5: fcmpg
        //   6: ifge -> 70
        //   9: aload_0
        //   10: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   13: invokestatic a : (Landroid/support/design/widget/BottomSheetBehavior;)Z
        //   16: ifeq -> 34
        //   19: aload_0
        //   20: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   23: getfield a : I
        //   26: istore #6
        //   28: iconst_3
        //   29: istore #4
        //   31: goto -> 300
        //   34: aload_1
        //   35: invokevirtual getTop : ()I
        //   38: aload_0
        //   39: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   42: getfield b : I
        //   45: if_icmple -> 64
        //   48: aload_0
        //   49: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   52: getfield b : I
        //   55: istore #6
        //   57: bipush #6
        //   59: istore #4
        //   61: goto -> 300
        //   64: iconst_0
        //   65: istore #6
        //   67: goto -> 28
        //   70: aload_0
        //   71: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   74: getfield d : Z
        //   77: ifeq -> 133
        //   80: aload_0
        //   81: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   84: aload_1
        //   85: fload_3
        //   86: invokevirtual a : (Landroid/view/View;F)Z
        //   89: ifeq -> 133
        //   92: aload_1
        //   93: invokevirtual getTop : ()I
        //   96: aload_0
        //   97: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   100: getfield c : I
        //   103: if_icmpgt -> 118
        //   106: fload_2
        //   107: invokestatic abs : (F)F
        //   110: fload_3
        //   111: invokestatic abs : (F)F
        //   114: fcmpg
        //   115: ifge -> 133
        //   118: aload_0
        //   119: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   122: getfield g : I
        //   125: istore #6
        //   127: iconst_5
        //   128: istore #4
        //   130: goto -> 300
        //   133: fload_3
        //   134: fconst_0
        //   135: fcmpl
        //   136: ifeq -> 166
        //   139: fload_2
        //   140: invokestatic abs : (F)F
        //   143: fload_3
        //   144: invokestatic abs : (F)F
        //   147: fcmpl
        //   148: ifle -> 154
        //   151: goto -> 166
        //   154: aload_0
        //   155: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   158: getfield c : I
        //   161: istore #6
        //   163: goto -> 300
        //   166: aload_1
        //   167: invokevirtual getTop : ()I
        //   170: istore #5
        //   172: aload_0
        //   173: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   176: invokestatic a : (Landroid/support/design/widget/BottomSheetBehavior;)Z
        //   179: ifeq -> 235
        //   182: iload #5
        //   184: aload_0
        //   185: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   188: getfield a : I
        //   191: isub
        //   192: invokestatic abs : (I)I
        //   195: iload #5
        //   197: aload_0
        //   198: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   201: getfield c : I
        //   204: isub
        //   205: invokestatic abs : (I)I
        //   208: if_icmpge -> 223
        //   211: aload_0
        //   212: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   215: getfield a : I
        //   218: istore #6
        //   220: goto -> 28
        //   223: aload_0
        //   224: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   227: getfield c : I
        //   230: istore #6
        //   232: goto -> 300
        //   235: iload #5
        //   237: aload_0
        //   238: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   241: getfield b : I
        //   244: if_icmpge -> 268
        //   247: iload #5
        //   249: iload #5
        //   251: aload_0
        //   252: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   255: getfield c : I
        //   258: isub
        //   259: invokestatic abs : (I)I
        //   262: if_icmpge -> 48
        //   265: goto -> 64
        //   268: iload #5
        //   270: aload_0
        //   271: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   274: getfield b : I
        //   277: isub
        //   278: invokestatic abs : (I)I
        //   281: iload #5
        //   283: aload_0
        //   284: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   287: getfield c : I
        //   290: isub
        //   291: invokestatic abs : (I)I
        //   294: if_icmpge -> 223
        //   297: goto -> 48
        //   300: aload_0
        //   301: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   304: getfield f : Landroid/support/v4/widget/q;
        //   307: aload_1
        //   308: invokevirtual getLeft : ()I
        //   311: iload #6
        //   313: invokevirtual a : (II)Z
        //   316: ifeq -> 346
        //   319: aload_0
        //   320: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   323: iconst_2
        //   324: invokevirtual b : (I)V
        //   327: aload_1
        //   328: new android/support/design/widget/BottomSheetBehavior$c
        //   331: dup
        //   332: aload_0
        //   333: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   336: aload_1
        //   337: iload #4
        //   339: invokespecial <init> : (Landroid/support/design/widget/BottomSheetBehavior;Landroid/view/View;I)V
        //   342: invokestatic a : (Landroid/view/View;Ljava/lang/Runnable;)V
        //   345: return
        //   346: aload_0
        //   347: getfield a : Landroid/support/design/widget/BottomSheetBehavior;
        //   350: iload #4
        //   352: invokevirtual b : (I)V
        //   355: return }
      
      public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) { this.a.c(param1Int2); }
      
      public boolean a(View param1View, int param1Int) {
        if (this.a.e == 1)
          return false; 
        if (this.a.k)
          return false; 
        if (this.a.e == 3 && this.a.j == param1Int) {
          View view = (View)this.a.i.get();
          if (view != null && view.canScrollVertically(-1))
            return false; 
        } 
        return (this.a.h != null && this.a.h.get() == param1View);
      }
      
      public int b(View param1View, int param1Int1, int param1Int2) { return param1View.getLeft(); }
    };
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.BottomSheetBehavior_Layout);
    TypedValue typedValue = typedArray.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
    if (typedValue != null && typedValue.data == -1) {
      i1 = typedValue.data;
    } else {
      i1 = typedArray.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1);
    } 
    a(i1);
    b(typedArray.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false));
    a(typedArray.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
    c(typedArray.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
    typedArray.recycle();
    this.m = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private void a() {
    int i1;
    if (this.l) {
      i1 = Math.max(this.g - this.q, this.a);
    } else {
      i1 = this.g - this.q;
    } 
    this.c = i1;
  }
  
  private void b() {
    this.j = -1;
    VelocityTracker velocityTracker = this.w;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.w = null;
    } 
  }
  
  private float d() {
    VelocityTracker velocityTracker = this.w;
    if (velocityTracker == null)
      return 0.0F; 
    velocityTracker.computeCurrentVelocity(1000, this.m);
    return this.w.getYVelocity(this.j);
  }
  
  private void d(boolean paramBoolean) {
    WeakReference weakReference = this.h;
    if (weakReference == null)
      return; 
    ViewParent viewParent = ((View)weakReference.get()).getParent();
    if (!(viewParent instanceof CoordinatorLayout))
      return; 
    CoordinatorLayout coordinatorLayout = (CoordinatorLayout)viewParent;
    int i1 = coordinatorLayout.getChildCount();
    if (Build.VERSION.SDK_INT >= 16 && paramBoolean)
      if (this.y == null) {
        this.y = new HashMap(i1);
      } else {
        return;
      }  
    for (byte b1 = 0; b1 < i1; b1++) {
      byte b2;
      View view = coordinatorLayout.getChildAt(b1);
      if (view == this.h.get())
        continue; 
      if (!paramBoolean) {
        Map map = this.y;
        if (map != null && map.containsKey(view)) {
          b2 = ((Integer)this.y.get(view)).intValue();
        } else {
          continue;
        } 
      } else {
        if (Build.VERSION.SDK_INT >= 16)
          this.y.put(view, Integer.valueOf(view.getImportantForAccessibility())); 
        b2 = 4;
      } 
      r.b(view, b2);
      continue;
    } 
    if (!paramBoolean)
      this.y = null; 
  }
  
  private int e() { return this.l ? this.a : 0; }
  
  View a(View paramView) {
    if (r.v(paramView))
      return paramView; 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      byte b1 = 0;
      int i1 = viewGroup.getChildCount();
      while (b1 < i1) {
        View view = a(viewGroup.getChildAt(b1));
        if (view != null)
          return view; 
        b1++;
      } 
    } 
    return null;
  }
  
  public final void a(int paramInt) { // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iload_1
    //   3: iconst_m1
    //   4: if_icmpne -> 22
    //   7: aload_0
    //   8: getfield o : Z
    //   11: ifne -> 40
    //   14: aload_0
    //   15: iload_2
    //   16: putfield o : Z
    //   19: goto -> 69
    //   22: aload_0
    //   23: getfield o : Z
    //   26: ifne -> 45
    //   29: aload_0
    //   30: getfield n : I
    //   33: iload_1
    //   34: if_icmpeq -> 40
    //   37: goto -> 45
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -> 69
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield o : Z
    //   50: aload_0
    //   51: iconst_0
    //   52: iload_1
    //   53: invokestatic max : (II)I
    //   56: putfield n : I
    //   59: aload_0
    //   60: aload_0
    //   61: getfield g : I
    //   64: iload_1
    //   65: isub
    //   66: putfield c : I
    //   69: iload_2
    //   70: ifeq -> 109
    //   73: aload_0
    //   74: getfield e : I
    //   77: iconst_4
    //   78: if_icmpne -> 109
    //   81: aload_0
    //   82: getfield h : Ljava/lang/ref/WeakReference;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull -> 109
    //   90: aload_3
    //   91: invokevirtual get : ()Ljava/lang/Object;
    //   94: checkcast android/view/View
    //   97: astore #4
    //   99: aload #4
    //   101: ifnull -> 109
    //   104: aload #4
    //   106: invokevirtual requestLayout : ()V
    //   109: return }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {
    int i1;
    b b1 = (b)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, b1.a());
    if (b1.a == 1 || b1.a == 2) {
      i1 = 4;
    } else {
      i1 = b1.a;
    } 
    this.e = i1;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getTop : ()I
    //   4: istore #5
    //   6: aload_0
    //   7: invokespecial e : ()I
    //   10: istore #6
    //   12: iconst_3
    //   13: istore #7
    //   15: iload #5
    //   17: iload #6
    //   19: if_icmpne -> 29
    //   22: aload_0
    //   23: iload #7
    //   25: invokevirtual b : (I)V
    //   28: return
    //   29: aload_3
    //   30: aload_0
    //   31: getfield i : Ljava/lang/ref/WeakReference;
    //   34: invokevirtual get : ()Ljava/lang/Object;
    //   37: if_acmpne -> 275
    //   40: aload_0
    //   41: getfield u : Z
    //   44: ifne -> 48
    //   47: return
    //   48: aload_0
    //   49: getfield t : I
    //   52: ifle -> 64
    //   55: aload_0
    //   56: invokespecial e : ()I
    //   59: istore #8
    //   61: goto -> 224
    //   64: aload_0
    //   65: getfield d : Z
    //   68: ifeq -> 95
    //   71: aload_0
    //   72: aload_2
    //   73: aload_0
    //   74: invokespecial d : ()F
    //   77: invokevirtual a : (Landroid/view/View;F)Z
    //   80: ifeq -> 95
    //   83: aload_0
    //   84: getfield g : I
    //   87: istore #8
    //   89: iconst_5
    //   90: istore #7
    //   92: goto -> 224
    //   95: aload_0
    //   96: getfield t : I
    //   99: ifne -> 215
    //   102: aload_2
    //   103: invokevirtual getTop : ()I
    //   106: istore #9
    //   108: aload_0
    //   109: getfield l : Z
    //   112: ifeq -> 147
    //   115: iload #9
    //   117: aload_0
    //   118: getfield a : I
    //   121: isub
    //   122: invokestatic abs : (I)I
    //   125: iload #9
    //   127: aload_0
    //   128: getfield c : I
    //   131: isub
    //   132: invokestatic abs : (I)I
    //   135: if_icmpge -> 215
    //   138: aload_0
    //   139: getfield a : I
    //   142: istore #8
    //   144: goto -> 224
    //   147: aload_0
    //   148: getfield b : I
    //   151: istore #10
    //   153: iload #9
    //   155: iload #10
    //   157: if_icmpge -> 181
    //   160: iload #9
    //   162: iload #9
    //   164: aload_0
    //   165: getfield c : I
    //   168: isub
    //   169: invokestatic abs : (I)I
    //   172: if_icmpge -> 202
    //   175: iconst_0
    //   176: istore #8
    //   178: goto -> 224
    //   181: iload #9
    //   183: iload #10
    //   185: isub
    //   186: invokestatic abs : (I)I
    //   189: iload #9
    //   191: aload_0
    //   192: getfield c : I
    //   195: isub
    //   196: invokestatic abs : (I)I
    //   199: if_icmpge -> 215
    //   202: aload_0
    //   203: getfield b : I
    //   206: istore #8
    //   208: bipush #6
    //   210: istore #7
    //   212: goto -> 224
    //   215: aload_0
    //   216: getfield c : I
    //   219: istore #8
    //   221: iconst_4
    //   222: istore #7
    //   224: aload_0
    //   225: getfield f : Landroid/support/v4/widget/q;
    //   228: aload_2
    //   229: aload_2
    //   230: invokevirtual getLeft : ()I
    //   233: iload #8
    //   235: invokevirtual a : (Landroid/view/View;II)Z
    //   238: ifeq -> 264
    //   241: aload_0
    //   242: iconst_2
    //   243: invokevirtual b : (I)V
    //   246: aload_2
    //   247: new android/support/design/widget/BottomSheetBehavior$c
    //   250: dup
    //   251: aload_0
    //   252: aload_2
    //   253: iload #7
    //   255: invokespecial <init> : (Landroid/support/design/widget/BottomSheetBehavior;Landroid/view/View;I)V
    //   258: invokestatic a : (Landroid/view/View;Ljava/lang/Runnable;)V
    //   261: goto -> 270
    //   264: aload_0
    //   265: iload #7
    //   267: invokevirtual b : (I)V
    //   270: aload_0
    //   271: iconst_0
    //   272: putfield u : Z
    //   275: return }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3) { // Byte code:
    //   0: iload #7
    //   2: iconst_1
    //   3: if_icmpne -> 7
    //   6: return
    //   7: aload_3
    //   8: aload_0
    //   9: getfield i : Ljava/lang/ref/WeakReference;
    //   12: invokevirtual get : ()Ljava/lang/Object;
    //   15: checkcast android/view/View
    //   18: if_acmpeq -> 22
    //   21: return
    //   22: aload_2
    //   23: invokevirtual getTop : ()I
    //   26: istore #8
    //   28: iload #8
    //   30: iload #5
    //   32: isub
    //   33: istore #9
    //   35: iload #5
    //   37: ifle -> 102
    //   40: iload #9
    //   42: aload_0
    //   43: invokespecial e : ()I
    //   46: if_icmpge -> 81
    //   49: aload #6
    //   51: iconst_1
    //   52: iload #8
    //   54: aload_0
    //   55: invokespecial e : ()I
    //   58: isub
    //   59: iastore
    //   60: aload_2
    //   61: aload #6
    //   63: iconst_1
    //   64: iaload
    //   65: ineg
    //   66: invokestatic e : (Landroid/view/View;I)V
    //   69: iconst_3
    //   70: istore #11
    //   72: aload_0
    //   73: iload #11
    //   75: invokevirtual b : (I)V
    //   78: goto -> 171
    //   81: aload #6
    //   83: iconst_1
    //   84: iload #5
    //   86: iastore
    //   87: aload_2
    //   88: iload #5
    //   90: ineg
    //   91: invokestatic e : (Landroid/view/View;I)V
    //   94: aload_0
    //   95: iconst_1
    //   96: invokevirtual b : (I)V
    //   99: goto -> 171
    //   102: iload #5
    //   104: ifge -> 171
    //   107: aload_3
    //   108: iconst_m1
    //   109: invokevirtual canScrollVertically : (I)Z
    //   112: ifne -> 171
    //   115: aload_0
    //   116: getfield c : I
    //   119: istore #10
    //   121: iload #9
    //   123: iload #10
    //   125: if_icmple -> 162
    //   128: aload_0
    //   129: getfield d : Z
    //   132: ifeq -> 138
    //   135: goto -> 162
    //   138: aload #6
    //   140: iconst_1
    //   141: iload #8
    //   143: iload #10
    //   145: isub
    //   146: iastore
    //   147: aload_2
    //   148: aload #6
    //   150: iconst_1
    //   151: iaload
    //   152: ineg
    //   153: invokestatic e : (Landroid/view/View;I)V
    //   156: iconst_4
    //   157: istore #11
    //   159: goto -> 72
    //   162: aload #6
    //   164: iconst_1
    //   165: iload #5
    //   167: iastore
    //   168: goto -> 87
    //   171: aload_0
    //   172: aload_2
    //   173: invokevirtual getTop : ()I
    //   176: invokevirtual c : (I)V
    //   179: aload_0
    //   180: iload #5
    //   182: putfield t : I
    //   185: aload_0
    //   186: iconst_1
    //   187: putfield u : Z
    //   190: return }
  
  public void a(boolean paramBoolean) {
    int i1;
    if (this.l == paramBoolean)
      return; 
    this.l = paramBoolean;
    if (this.h != null)
      a(); 
    if (this.l && this.e == 6) {
      i1 = 3;
    } else {
      i1 = this.e;
    } 
    b(i1);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    int i4;
    int i2;
    if (r.q(paramCoordinatorLayout) && !r.q(paramV))
      paramV.setFitsSystemWindows(true); 
    int i1 = paramV.getTop();
    paramCoordinatorLayout.a(paramV, paramInt);
    this.g = paramCoordinatorLayout.getHeight();
    if (this.o) {
      if (this.p == 0)
        this.p = paramCoordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min); 
      i2 = Math.max(this.p, this.g - 9 * paramCoordinatorLayout.getWidth() / 16);
    } else {
      i2 = this.n;
    } 
    this.q = i2;
    this.a = Math.max(0, this.g - paramV.getHeight());
    this.b = this.g / 2;
    a();
    int i3 = this.e;
    if (i3 == 3) {
      i4 = e();
    } else if (i3 == 6) {
      i4 = this.b;
    } else if (this.d && i3 == 5) {
      i4 = this.g;
    } else {
      int i5 = this.e;
      if (i5 == 4) {
        i4 = this.c;
      } else {
        if (i5 == 1 || i5 == 2)
          r.e(paramV, i1 - paramV.getTop()); 
        if (this.f == null)
          this.f = q.a(paramCoordinatorLayout, this.z); 
      } 
    } 
    r.e(paramV, i4);
    if (this.f == null)
      this.f = q.a(paramCoordinatorLayout, this.z); 
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    if (!paramV.isShown())
      return false; 
    int i1 = paramMotionEvent.getActionMasked();
    if (this.e == 1 && i1 == 0)
      return true; 
    q q1 = this.f;
    if (q1 != null)
      q1.b(paramMotionEvent); 
    if (i1 == 0)
      b(); 
    if (this.w == null)
      this.w = VelocityTracker.obtain(); 
    this.w.addMovement(paramMotionEvent);
    if (i1 == 2 && !this.s && Math.abs(this.x - paramMotionEvent.getY()) > this.f.a())
      this.f.a(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())); 
    return true ^ this.s;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2) { return (paramView == this.i.get() && (this.e != 3 || super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2))); }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    this.t = 0;
    this.u = false;
    int i1 = paramInt1 & 0x2;
    boolean bool = false;
    if (i1 != 0)
      bool = true; 
    return bool;
  }
  
  boolean a(View paramView, float paramFloat) { return this.r ? true : ((paramView.getTop() < this.c) ? false : ((Math.abs(paramView.getTop() + paramFloat * 0.1F - this.c) / this.n > 0.5F))); }
  
  public Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV) { return new b(super.b(paramCoordinatorLayout, paramV), this.e); }
  
  void b(int paramInt) { // Byte code:
    //   0: aload_0
    //   1: getfield e : I
    //   4: iload_1
    //   5: if_icmpne -> 9
    //   8: return
    //   9: aload_0
    //   10: iload_1
    //   11: putfield e : I
    //   14: iload_1
    //   15: bipush #6
    //   17: if_icmpeq -> 43
    //   20: iload_1
    //   21: iconst_3
    //   22: if_icmpne -> 28
    //   25: goto -> 43
    //   28: iload_1
    //   29: iconst_5
    //   30: if_icmpeq -> 38
    //   33: iload_1
    //   34: iconst_4
    //   35: if_icmpne -> 50
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -> 45
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: invokespecial d : (Z)V
    //   50: aload_0
    //   51: getfield h : Ljava/lang/ref/WeakReference;
    //   54: invokevirtual get : ()Ljava/lang/Object;
    //   57: checkcast android/view/View
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull -> 83
    //   65: aload_0
    //   66: getfield v : Landroid/support/design/widget/BottomSheetBehavior$a;
    //   69: astore #4
    //   71: aload #4
    //   73: ifnull -> 83
    //   76: aload #4
    //   78: aload_3
    //   79: iload_1
    //   80: invokevirtual a : (Landroid/view/View;I)V
    //   83: return }
  
  public void b(boolean paramBoolean) { this.d = paramBoolean; }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    if (!paramV.isShown()) {
      this.s = true;
      return false;
    } 
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0)
      b(); 
    if (this.w == null)
      this.w = VelocityTracker.obtain(); 
    this.w.addMovement(paramMotionEvent);
    if (i1 != 3) {
      boolean bool1;
      View view2;
      WeakReference weakReference2;
      int i2;
      switch (i1) {
        case 0:
          i2 = (int)paramMotionEvent.getX();
          this.x = (int)paramMotionEvent.getY();
          weakReference2 = this.i;
          if (weakReference2 != null) {
            view2 = (View)weakReference2.get();
          } else {
            view2 = null;
          } 
          if (view2 != null && paramCoordinatorLayout.a(view2, i2, this.x)) {
            this.j = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.k = true;
          } 
          if (this.j == -1 && !paramCoordinatorLayout.a(paramV, i2, this.x)) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.s = bool1;
          break;
        case 1:
          this.k = false;
          this.j = -1;
          if (this.s) {
            this.s = false;
            return false;
          } 
          break;
      } 
      if (!this.s) {
        q q1 = this.f;
        if (q1 != null && q1.a(paramMotionEvent))
          return true; 
      } 
      WeakReference weakReference1 = this.i;
      View view1 = null;
      if (weakReference1 != null)
        view1 = (View)weakReference1.get(); 
      boolean bool = false;
      if (i1 == 2) {
        bool = false;
        if (view1 != null) {
          boolean bool2 = this.s;
          bool = false;
          if (!bool2) {
            int i3 = this.e;
            bool = false;
            if (i3 != 1) {
              boolean bool3 = paramCoordinatorLayout.a(view1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
              bool = false;
              if (!bool3) {
                q q1 = this.f;
                bool = false;
                if (q1 != null) {
                  int i4 = Math.abs(this.x - paramMotionEvent.getY()) cmp this.f.a();
                  bool = false;
                  if (i4 > 0)
                    bool = true; 
                } 
              } 
            } 
          } 
        } 
      } 
      return bool;
    } 
  }
  
  void c(int paramInt) {
    View view = (View)this.h.get();
    if (view != null) {
      a a1 = this.v;
      if (a1 != null) {
        float f2;
        float f1;
        int i1 = this.c;
        if (paramInt > i1) {
          f1 = (i1 - paramInt);
          f2 = (this.g - i1);
        } else {
          f1 = (i1 - paramInt);
          f2 = (i1 - e());
        } 
        a1.a(view, f1 / f2);
      } 
    } 
  }
  
  public void c(boolean paramBoolean) { this.r = paramBoolean; }
  
  public static abstract class a {
    public abstract void a(View param1View, float param1Float);
    
    public abstract void a(View param1View, int param1Int);
  }
  
  protected static class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() {
        public BottomSheetBehavior.b a(Parcel param2Parcel) { return new BottomSheetBehavior.b(param2Parcel, null); }
        
        public BottomSheetBehavior.b a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new BottomSheetBehavior.b(param2Parcel, param2ClassLoader); }
        
        public BottomSheetBehavior.b[] a(int param2Int) { return new BottomSheetBehavior.b[param2Int]; }
      };
    
    final int a;
    
    public b(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readInt();
    }
    
    public b(Parcelable param1Parcelable, int param1Int) {
      super(param1Parcelable);
      this.a = param1Int;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<b> {
    public BottomSheetBehavior.b a(Parcel param1Parcel) { return new BottomSheetBehavior.b(param1Parcel, null); }
    
    public BottomSheetBehavior.b a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new BottomSheetBehavior.b(param1Parcel, param1ClassLoader); }
    
    public BottomSheetBehavior.b[] a(int param1Int) { return new BottomSheetBehavior.b[param1Int]; }
  }
  
  private class c implements Runnable {
    private final View b;
    
    private final int c;
    
    c(BottomSheetBehavior this$0, View param1View, int param1Int) {
      this.b = param1View;
      this.c = param1Int;
    }
    
    public void run() {
      if (this.a.f != null && this.a.f.a(true)) {
        r.a(this.b, this);
        return;
      } 
      this.a.b(this.c);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\BottomSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */