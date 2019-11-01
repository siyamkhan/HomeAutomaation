package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.h.a.c;
import android.support.v4.h.a.e;
import android.support.v4.h.b;
import android.support.v4.h.k;
import android.support.v4.h.l;
import android.support.v4.h.n;
import android.support.v4.h.o;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;

public class NestedScrollView extends FrameLayout implements k, n {
  private static final a w = new a();
  
  private static final int[] x = { 16843130 };
  
  private float A;
  
  private b B;
  
  private long a;
  
  private final Rect b = new Rect();
  
  private OverScroller c;
  
  private EdgeEffect d;
  
  private EdgeEffect e;
  
  private int f;
  
  private boolean g = true;
  
  private boolean h = false;
  
  private View i = null;
  
  private boolean j = false;
  
  private VelocityTracker k;
  
  private boolean l;
  
  private boolean m = true;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q = -1;
  
  private final int[] r = new int[2];
  
  private final int[] s = new int[2];
  
  private int t;
  
  private int u;
  
  private c v;
  
  private final o y;
  
  private final l z;
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, x, paramInt, 0);
    setFillViewport(typedArray.getBoolean(0, false));
    typedArray.recycle();
    this.y = new o(this);
    this.z = new l(this);
    setNestedScrollingEnabled(true);
    r.a(this, w);
  }
  
  private View a(boolean paramBoolean, int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokevirtual getFocusables : (I)Ljava/util/ArrayList;
    //   5: astore #4
    //   7: aload #4
    //   9: invokeinterface size : ()I
    //   14: istore #5
    //   16: aconst_null
    //   17: astore #6
    //   19: iconst_0
    //   20: istore #7
    //   22: iconst_0
    //   23: istore #8
    //   25: iload #7
    //   27: iload #5
    //   29: if_icmpge -> 194
    //   32: aload #4
    //   34: iload #7
    //   36: invokeinterface get : (I)Ljava/lang/Object;
    //   41: checkcast android/view/View
    //   44: astore #9
    //   46: aload #9
    //   48: invokevirtual getTop : ()I
    //   51: istore #10
    //   53: aload #9
    //   55: invokevirtual getBottom : ()I
    //   58: istore #11
    //   60: iload_2
    //   61: iload #11
    //   63: if_icmpge -> 188
    //   66: iload #10
    //   68: iload_3
    //   69: if_icmpge -> 188
    //   72: iload_2
    //   73: iload #10
    //   75: if_icmpge -> 90
    //   78: iload #11
    //   80: iload_3
    //   81: if_icmpge -> 90
    //   84: iconst_1
    //   85: istore #12
    //   87: goto -> 93
    //   90: iconst_0
    //   91: istore #12
    //   93: aload #6
    //   95: ifnonnull -> 109
    //   98: aload #9
    //   100: astore #6
    //   102: iload #12
    //   104: istore #8
    //   106: goto -> 188
    //   109: iload_1
    //   110: ifeq -> 123
    //   113: iload #10
    //   115: aload #6
    //   117: invokevirtual getTop : ()I
    //   120: if_icmplt -> 137
    //   123: iload_1
    //   124: ifne -> 143
    //   127: iload #11
    //   129: aload #6
    //   131: invokevirtual getBottom : ()I
    //   134: if_icmple -> 143
    //   137: iconst_1
    //   138: istore #13
    //   140: goto -> 146
    //   143: iconst_0
    //   144: istore #13
    //   146: iload #8
    //   148: ifeq -> 164
    //   151: iload #12
    //   153: ifeq -> 188
    //   156: iload #13
    //   158: ifeq -> 188
    //   161: goto -> 184
    //   164: iload #12
    //   166: ifeq -> 179
    //   169: aload #9
    //   171: astore #6
    //   173: iconst_1
    //   174: istore #8
    //   176: goto -> 188
    //   179: iload #13
    //   181: ifeq -> 188
    //   184: aload #9
    //   186: astore #6
    //   188: iinc #7, 1
    //   191: goto -> 25
    //   194: aload #6
    //   196: areturn }
  
  private void a() {
    this.c = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
    this.n = viewConfiguration.getScaledTouchSlop();
    this.o = viewConfiguration.getScaledMinimumFlingVelocity();
    this.p = viewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void a(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.q) {
      byte b1;
      if (i1 == 0) {
        b1 = 1;
      } else {
        b1 = 0;
      } 
      this.f = (int)paramMotionEvent.getY(b1);
      this.q = paramMotionEvent.getPointerId(b1);
      VelocityTracker velocityTracker = this.k;
      if (velocityTracker != null)
        velocityTracker.clear(); 
    } 
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool2;
    boolean bool1;
    int i1 = getHeight();
    int i2 = getScrollY();
    int i3 = i1 + i2;
    if (paramInt1 == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    NestedScrollView nestedScrollView = a(bool1, paramInt2, paramInt3);
    if (nestedScrollView == null)
      nestedScrollView = this; 
    if (paramInt2 >= i2 && paramInt3 <= i3) {
      bool2 = false;
    } else {
      int i4;
      if (bool1) {
        i4 = paramInt2 - i2;
      } else {
        i4 = paramInt3 - i3;
      } 
      g(i4);
      bool2 = true;
    } 
    if (nestedScrollView != findFocus())
      nestedScrollView.requestFocus(paramInt1); 
    return bool2;
  }
  
  private boolean a(Rect paramRect, boolean paramBoolean) {
    boolean bool;
    int i1 = a(paramRect);
    if (i1 != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      if (paramBoolean) {
        scrollBy(0, i1);
        return bool;
      } 
      b(0, i1);
    } 
    return bool;
  }
  
  private boolean a(View paramView) { return true ^ a(paramView, 0, getHeight()); }
  
  private boolean a(View paramView, int paramInt1, int paramInt2) {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    return (paramInt1 + this.b.bottom >= getScrollY() && this.b.top - paramInt1 <= paramInt2 + getScrollY());
  }
  
  private static boolean a(View paramView1, View paramView2) {
    if (paramView1 == paramView2)
      return true; 
    ViewParent viewParent = paramView1.getParent();
    return (viewParent instanceof ViewGroup && a((View)viewParent, paramView2));
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3) { return (paramInt2 >= paramInt3 || paramInt1 < 0) ? 0 : ((paramInt2 + paramInt1 > paramInt3) ? (paramInt3 - paramInt2) : paramInt1); }
  
  private void b(View paramView) {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    int i1 = a(this.b);
    if (i1 != 0)
      scrollBy(0, i1); 
  }
  
  private boolean b() {
    int i1 = getChildCount();
    boolean bool = false;
    if (i1 > 0) {
      View view = getChildAt(0);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
      int i2 = view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      int i3 = getHeight() - getPaddingTop() - getPaddingBottom();
      bool = false;
      if (i2 > i3)
        bool = true; 
    } 
    return bool;
  }
  
  private void c() {
    VelocityTracker velocityTracker = this.k;
    if (velocityTracker == null) {
      this.k = VelocityTracker.obtain();
      return;
    } 
    velocityTracker.clear();
  }
  
  private void d() {
    if (this.k == null)
      this.k = VelocityTracker.obtain(); 
  }
  
  private boolean d(int paramInt1, int paramInt2) {
    int i1 = getChildCount();
    boolean bool = false;
    if (i1 > 0) {
      int i2 = getScrollY();
      View view = getChildAt(0);
      int i3 = view.getTop() - i2;
      bool = false;
      if (paramInt2 >= i3) {
        int i4 = view.getBottom() - i2;
        bool = false;
        if (paramInt2 < i4) {
          int i5 = view.getLeft();
          bool = false;
          if (paramInt1 >= i5) {
            int i6 = view.getRight();
            bool = false;
            if (paramInt1 < i6)
              bool = true; 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  private void e() {
    VelocityTracker velocityTracker = this.k;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.k = null;
    } 
  }
  
  private void f() {
    this.j = false;
    e();
    a(0);
    EdgeEffect edgeEffect = this.d;
    if (edgeEffect != null) {
      edgeEffect.onRelease();
      this.e.onRelease();
    } 
  }
  
  private void g() {
    if (getOverScrollMode() != 2) {
      if (this.d == null) {
        Context context = getContext();
        this.d = new EdgeEffect(context);
        this.e = new EdgeEffect(context);
        return;
      } 
    } else {
      this.d = null;
      this.e = null;
    } 
  }
  
  private void g(int paramInt) {
    if (paramInt != 0) {
      if (this.m) {
        b(0, paramInt);
        return;
      } 
      scrollBy(0, paramInt);
    } 
  }
  
  private float getVerticalScrollFactorCompat() {
    if (this.A == 0.0F) {
      TypedValue typedValue = new TypedValue();
      Context context = getContext();
      if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
        this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      } 
    } 
    return this.A;
  }
  
  private void h(int paramInt) {
    boolean bool;
    int i1 = getScrollY();
    if ((i1 > 0 || paramInt > 0) && (i1 < getScrollRange() || paramInt < 0)) {
      bool = true;
    } else {
      bool = false;
    } 
    float f1 = paramInt;
    if (!dispatchNestedPreFling(0.0F, f1)) {
      dispatchNestedFling(0.0F, f1, bool);
      f(paramInt);
    } 
  }
  
  protected int a(Rect paramRect) {
    int i5;
    if (getChildCount() == 0)
      return 0; 
    int i1 = getHeight();
    int i2 = getScrollY();
    int i3 = i2 + i1;
    int i4 = getVerticalFadingEdgeLength();
    if (paramRect.top > 0)
      i2 += i4; 
    View view = getChildAt(0);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
    if (paramRect.bottom < view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
      i5 = i3 - i4;
    } else {
      i5 = i3;
    } 
    if (paramRect.bottom > i5 && paramRect.top > i2) {
      int i8;
      if (paramRect.height() > i1) {
        i8 = paramRect.top - i2;
      } else {
        i8 = paramRect.bottom - i5;
      } 
      return Math.min(i8 + 0, view.getBottom() + layoutParams.bottomMargin - i3);
    } 
    int i6 = paramRect.top;
    int i7 = 0;
    if (i6 < i2) {
      int i8 = paramRect.bottom;
      i7 = 0;
      if (i8 < i5) {
        int i9;
        if (paramRect.height() > i1) {
          i9 = 0 - i5 - paramRect.bottom;
        } else {
          i9 = 0 - i2 - paramRect.top;
        } 
        i7 = Math.max(i9, -getScrollY());
      } 
    } 
    return i7;
  }
  
  public void a(int paramInt) { this.z.c(paramInt); }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i1 = getScrollY();
    scrollBy(0, paramInt4);
    int i2 = getScrollY() - i1;
    a(0, i2, 0, paramInt4 - i2, null, paramInt5);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3) { a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3); }
  
  public boolean a(int paramInt1, int paramInt2) { return this.z.a(paramInt1, paramInt2); }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual getOverScrollMode : ()I
    //   4: istore #10
    //   6: aload_0
    //   7: invokevirtual computeHorizontalScrollRange : ()I
    //   10: aload_0
    //   11: invokevirtual computeHorizontalScrollExtent : ()I
    //   14: if_icmple -> 23
    //   17: iconst_1
    //   18: istore #11
    //   20: goto -> 26
    //   23: iconst_0
    //   24: istore #11
    //   26: aload_0
    //   27: invokevirtual computeVerticalScrollRange : ()I
    //   30: aload_0
    //   31: invokevirtual computeVerticalScrollExtent : ()I
    //   34: if_icmple -> 43
    //   37: iconst_1
    //   38: istore #12
    //   40: goto -> 46
    //   43: iconst_0
    //   44: istore #12
    //   46: iload #10
    //   48: ifeq -> 71
    //   51: iload #10
    //   53: iconst_1
    //   54: if_icmpne -> 65
    //   57: iload #11
    //   59: ifeq -> 65
    //   62: goto -> 71
    //   65: iconst_0
    //   66: istore #13
    //   68: goto -> 74
    //   71: iconst_1
    //   72: istore #13
    //   74: iload #10
    //   76: ifeq -> 99
    //   79: iload #10
    //   81: iconst_1
    //   82: if_icmpne -> 93
    //   85: iload #12
    //   87: ifeq -> 93
    //   90: goto -> 99
    //   93: iconst_0
    //   94: istore #14
    //   96: goto -> 102
    //   99: iconst_1
    //   100: istore #14
    //   102: iload_3
    //   103: iload_1
    //   104: iadd
    //   105: istore #15
    //   107: iload #13
    //   109: ifne -> 118
    //   112: iconst_0
    //   113: istore #16
    //   115: goto -> 122
    //   118: iload #7
    //   120: istore #16
    //   122: iload #4
    //   124: iload_2
    //   125: iadd
    //   126: istore #17
    //   128: iload #14
    //   130: ifne -> 139
    //   133: iconst_0
    //   134: istore #18
    //   136: goto -> 143
    //   139: iload #8
    //   141: istore #18
    //   143: iload #16
    //   145: ineg
    //   146: istore #19
    //   148: iload #16
    //   150: iload #5
    //   152: iadd
    //   153: istore #20
    //   155: iload #18
    //   157: ineg
    //   158: istore #21
    //   160: iload #18
    //   162: iload #6
    //   164: iadd
    //   165: istore #22
    //   167: iload #15
    //   169: iload #20
    //   171: if_icmple -> 184
    //   174: iload #20
    //   176: istore #19
    //   178: iconst_1
    //   179: istore #23
    //   181: goto -> 201
    //   184: iload #15
    //   186: iload #19
    //   188: if_icmpge -> 194
    //   191: goto -> 178
    //   194: iload #15
    //   196: istore #19
    //   198: iconst_0
    //   199: istore #23
    //   201: iload #17
    //   203: iload #22
    //   205: if_icmple -> 218
    //   208: iload #22
    //   210: istore #17
    //   212: iconst_1
    //   213: istore #24
    //   215: goto -> 235
    //   218: iload #17
    //   220: iload #21
    //   222: if_icmpge -> 232
    //   225: iload #21
    //   227: istore #17
    //   229: goto -> 212
    //   232: iconst_0
    //   233: istore #24
    //   235: iload #24
    //   237: ifeq -> 275
    //   240: aload_0
    //   241: iconst_1
    //   242: invokevirtual b : (I)Z
    //   245: ifne -> 275
    //   248: aload_0
    //   249: getfield c : Landroid/widget/OverScroller;
    //   252: astore #26
    //   254: aload_0
    //   255: invokevirtual getScrollRange : ()I
    //   258: istore #27
    //   260: aload #26
    //   262: iload #19
    //   264: iload #17
    //   266: iconst_0
    //   267: iconst_0
    //   268: iconst_0
    //   269: iload #27
    //   271: invokevirtual springBack : (IIIIII)Z
    //   274: pop
    //   275: aload_0
    //   276: iload #19
    //   278: iload #17
    //   280: iload #23
    //   282: iload #24
    //   284: invokevirtual onOverScrolled : (IIZZ)V
    //   287: iload #23
    //   289: ifne -> 300
    //   292: iconst_0
    //   293: istore #25
    //   295: iload #24
    //   297: ifeq -> 303
    //   300: iconst_1
    //   301: istore #25
    //   303: iload #25
    //   305: ireturn }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5) { return this.z.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5); }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3) { return this.z.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3); }
  
  public boolean a(KeyEvent paramKeyEvent) {
    this.b.setEmpty();
    boolean bool = b();
    char c1 = '';
    if (!bool) {
      boolean bool1 = isFocused();
      boolean bool2 = false;
      if (bool1) {
        int i1 = paramKeyEvent.getKeyCode();
        bool2 = false;
        if (i1 != 4) {
          View view1 = findFocus();
          if (view1 == this)
            view1 = null; 
          View view2 = FocusFinder.getInstance().findNextFocus(this, view1, c1);
          bool2 = false;
          if (view2 != null) {
            bool2 = false;
            if (view2 != this) {
              boolean bool3 = view2.requestFocus(c1);
              bool2 = false;
              if (bool3)
                bool2 = true; 
            } 
          } 
        } 
      } 
      return bool2;
    } 
    if (paramKeyEvent.getAction() == 0) {
      int i1 = paramKeyEvent.getKeyCode();
      if (i1 != 62) {
        switch (i1) {
          default:
            return false;
          case 20:
            return !paramKeyEvent.isAltPressed() ? e(c1) : d(c1);
          case 19:
            break;
        } 
        return !paramKeyEvent.isAltPressed() ? e(33) : d(33);
      } 
      if (paramKeyEvent.isShiftPressed())
        c1 = '!'; 
      c(c1);
    } 
    return false;
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2) { return ((paramInt1 & 0x2) != 0); }
  
  public void addView(View paramView) {
    if (getChildCount() <= 0) {
      super.addView(paramView);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt) {
    if (getChildCount() <= 0) {
      super.addView(paramView, paramInt);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (getChildCount() <= 0) {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    if (getChildCount() <= 0) {
      super.addView(paramView, paramLayoutParams);
      return;
    } 
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public final void b(int paramInt1, int paramInt2) {
    if (getChildCount() == 0)
      return; 
    if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L) {
      View view = getChildAt(0);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
      int i1 = view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      int i2 = getHeight() - getPaddingTop() - getPaddingBottom();
      int i3 = getScrollY();
      int i4 = Math.max(0, i1 - i2);
      int i5 = Math.max(0, Math.min(paramInt2 + i3, i4)) - i3;
      this.u = getScrollY();
      this.c.startScroll(getScrollX(), i3, 0, i5);
      r.d(this);
    } else {
      if (!this.c.isFinished())
        this.c.abortAnimation(); 
      scrollBy(paramInt1, paramInt2);
    } 
    this.a = AnimationUtils.currentAnimationTimeMillis();
  }
  
  public void b(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    this.y.a(paramView1, paramView2, paramInt1, paramInt2);
    a(2, paramInt2);
  }
  
  public boolean b(int paramInt) { return this.z.a(paramInt); }
  
  public final void c(int paramInt1, int paramInt2) { b(paramInt1 - getScrollX(), paramInt2 - getScrollY()); }
  
  public void c(View paramView, int paramInt) {
    this.y.a(paramView, paramInt);
    a(paramInt);
  }
  
  public boolean c(int paramInt) {
    boolean bool;
    if (paramInt == 130) {
      bool = true;
    } else {
      bool = false;
    } 
    int i1 = getHeight();
    if (bool) {
      this.b.top = i1 + getScrollY();
      int i2 = getChildCount();
      if (i2 > 0) {
        View view = getChildAt(i2 - 1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int i3 = view.getBottom() + layoutParams.bottomMargin + getPaddingBottom();
        if (i1 + this.b.top > i3)
          this.b.top = i3 - i1; 
      } 
    } else {
      this.b.top = getScrollY() - i1;
      if (this.b.top < 0)
        this.b.top = 0; 
    } 
    Rect rect = this.b;
    rect.bottom = i1 + rect.top;
    return a(paramInt, this.b.top, this.b.bottom);
  }
  
  public int computeHorizontalScrollExtent() { return super.computeHorizontalScrollExtent(); }
  
  public int computeHorizontalScrollOffset() { return super.computeHorizontalScrollOffset(); }
  
  public int computeHorizontalScrollRange() { return super.computeHorizontalScrollRange(); }
  
  public void computeScroll() { // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/widget/OverScroller;
    //   4: invokevirtual computeScrollOffset : ()Z
    //   7: ifeq -> 234
    //   10: aload_0
    //   11: getfield c : Landroid/widget/OverScroller;
    //   14: invokevirtual getCurrX : ()I
    //   17: pop
    //   18: aload_0
    //   19: getfield c : Landroid/widget/OverScroller;
    //   22: invokevirtual getCurrY : ()I
    //   25: istore_2
    //   26: iload_2
    //   27: aload_0
    //   28: getfield u : I
    //   31: isub
    //   32: istore_3
    //   33: aload_0
    //   34: getfield s : [I
    //   37: astore #4
    //   39: aload_0
    //   40: iconst_0
    //   41: iload_3
    //   42: aload #4
    //   44: aconst_null
    //   45: iconst_1
    //   46: invokevirtual a : (II[I[II)Z
    //   49: ifeq -> 61
    //   52: iload_3
    //   53: aload_0
    //   54: getfield s : [I
    //   57: iconst_1
    //   58: iaload
    //   59: isub
    //   60: istore_3
    //   61: iload_3
    //   62: istore #5
    //   64: iload #5
    //   66: ifeq -> 224
    //   69: aload_0
    //   70: invokevirtual getScrollRange : ()I
    //   73: istore #6
    //   75: aload_0
    //   76: invokevirtual getScrollY : ()I
    //   79: istore #7
    //   81: aload_0
    //   82: iconst_0
    //   83: iload #5
    //   85: aload_0
    //   86: invokevirtual getScrollX : ()I
    //   89: iload #7
    //   91: iconst_0
    //   92: iload #6
    //   94: iconst_0
    //   95: iconst_0
    //   96: iconst_0
    //   97: invokevirtual a : (IIIIIIIIZ)Z
    //   100: pop
    //   101: aload_0
    //   102: invokevirtual getScrollY : ()I
    //   105: iload #7
    //   107: isub
    //   108: istore #9
    //   110: aload_0
    //   111: iconst_0
    //   112: iload #9
    //   114: iconst_0
    //   115: iload #5
    //   117: iload #9
    //   119: isub
    //   120: aconst_null
    //   121: iconst_1
    //   122: invokevirtual a : (IIII[II)Z
    //   125: ifne -> 224
    //   128: aload_0
    //   129: invokevirtual getOverScrollMode : ()I
    //   132: istore #10
    //   134: iload #10
    //   136: ifeq -> 159
    //   139: iload #10
    //   141: iconst_1
    //   142: if_icmpne -> 153
    //   145: iload #6
    //   147: ifle -> 153
    //   150: goto -> 159
    //   153: iconst_0
    //   154: istore #11
    //   156: goto -> 162
    //   159: iconst_1
    //   160: istore #11
    //   162: iload #11
    //   164: ifeq -> 224
    //   167: aload_0
    //   168: invokespecial g : ()V
    //   171: iload_2
    //   172: ifgt -> 202
    //   175: iload #7
    //   177: ifle -> 202
    //   180: aload_0
    //   181: getfield d : Landroid/widget/EdgeEffect;
    //   184: astore #12
    //   186: aload #12
    //   188: aload_0
    //   189: getfield c : Landroid/widget/OverScroller;
    //   192: invokevirtual getCurrVelocity : ()F
    //   195: f2i
    //   196: invokevirtual onAbsorb : (I)V
    //   199: goto -> 224
    //   202: iload_2
    //   203: iload #6
    //   205: if_icmplt -> 224
    //   208: iload #7
    //   210: iload #6
    //   212: if_icmpge -> 224
    //   215: aload_0
    //   216: getfield e : Landroid/widget/EdgeEffect;
    //   219: astore #12
    //   221: goto -> 186
    //   224: aload_0
    //   225: iload_2
    //   226: putfield u : I
    //   229: aload_0
    //   230: invokestatic d : (Landroid/view/View;)V
    //   233: return
    //   234: aload_0
    //   235: iconst_1
    //   236: invokevirtual b : (I)Z
    //   239: ifeq -> 247
    //   242: aload_0
    //   243: iconst_1
    //   244: invokevirtual a : (I)V
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield u : I
    //   252: return }
  
  public int computeVerticalScrollExtent() { return super.computeVerticalScrollExtent(); }
  
  public int computeVerticalScrollOffset() { return Math.max(0, super.computeVerticalScrollOffset()); }
  
  public int computeVerticalScrollRange() {
    int i1 = getChildCount();
    int i2 = getHeight() - getPaddingBottom() - getPaddingTop();
    if (i1 == 0)
      return i2; 
    View view = getChildAt(0);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
    int i3 = view.getBottom() + layoutParams.bottomMargin;
    int i4 = getScrollY();
    int i5 = Math.max(0, i3 - i2);
    if (i4 < 0)
      return i3 - i4; 
    if (i4 > i5)
      i3 += i4 - i5; 
    return i3;
  }
  
  public boolean d(int paramInt) {
    boolean bool;
    if (paramInt == 130) {
      bool = true;
    } else {
      bool = false;
    } 
    int i1 = getHeight();
    Rect rect = this.b;
    rect.top = 0;
    rect.bottom = i1;
    if (bool) {
      int i2 = getChildCount();
      if (i2 > 0) {
        View view = getChildAt(i2 - 1);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        this.b.bottom = view.getBottom() + layoutParams.bottomMargin + getPaddingBottom();
        Rect rect1 = this.b;
        rect1.top = rect1.bottom - i1;
      } 
    } 
    return a(paramInt, this.b.top, this.b.bottom);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) { return (super.dispatchKeyEvent(paramKeyEvent) || a(paramKeyEvent)); }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) { return this.z.a(paramFloat1, paramFloat2, paramBoolean); }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) { return this.z.a(paramFloat1, paramFloat2); }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) { return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0); }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt) { return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0); }
  
  public void draw(Canvas paramCanvas) { // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial draw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield d : Landroid/widget/EdgeEffect;
    //   9: ifnull -> 355
    //   12: aload_0
    //   13: invokevirtual getScrollY : ()I
    //   16: istore_2
    //   17: aload_0
    //   18: getfield d : Landroid/widget/EdgeEffect;
    //   21: invokevirtual isFinished : ()Z
    //   24: ifne -> 178
    //   27: aload_1
    //   28: invokevirtual save : ()I
    //   31: istore #9
    //   33: aload_0
    //   34: invokevirtual getWidth : ()I
    //   37: istore #10
    //   39: aload_0
    //   40: invokevirtual getHeight : ()I
    //   43: istore #11
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic min : (II)I
    //   50: istore #12
    //   52: getstatic android/os/Build$VERSION.SDK_INT : I
    //   55: bipush #21
    //   57: if_icmplt -> 76
    //   60: aload_0
    //   61: invokevirtual getClipToPadding : ()Z
    //   64: ifeq -> 70
    //   67: goto -> 76
    //   70: iconst_0
    //   71: istore #13
    //   73: goto -> 98
    //   76: iload #10
    //   78: aload_0
    //   79: invokevirtual getPaddingLeft : ()I
    //   82: aload_0
    //   83: invokevirtual getPaddingRight : ()I
    //   86: iadd
    //   87: isub
    //   88: istore #10
    //   90: iconst_0
    //   91: aload_0
    //   92: invokevirtual getPaddingLeft : ()I
    //   95: iadd
    //   96: istore #13
    //   98: getstatic android/os/Build$VERSION.SDK_INT : I
    //   101: bipush #21
    //   103: if_icmplt -> 136
    //   106: aload_0
    //   107: invokevirtual getClipToPadding : ()Z
    //   110: ifeq -> 136
    //   113: iload #11
    //   115: aload_0
    //   116: invokevirtual getPaddingTop : ()I
    //   119: aload_0
    //   120: invokevirtual getPaddingBottom : ()I
    //   123: iadd
    //   124: isub
    //   125: istore #11
    //   127: iload #12
    //   129: aload_0
    //   130: invokevirtual getPaddingTop : ()I
    //   133: iadd
    //   134: istore #12
    //   136: aload_1
    //   137: iload #13
    //   139: i2f
    //   140: iload #12
    //   142: i2f
    //   143: invokevirtual translate : (FF)V
    //   146: aload_0
    //   147: getfield d : Landroid/widget/EdgeEffect;
    //   150: iload #10
    //   152: iload #11
    //   154: invokevirtual setSize : (II)V
    //   157: aload_0
    //   158: getfield d : Landroid/widget/EdgeEffect;
    //   161: aload_1
    //   162: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   165: ifeq -> 172
    //   168: aload_0
    //   169: invokestatic d : (Landroid/view/View;)V
    //   172: aload_1
    //   173: iload #9
    //   175: invokevirtual restoreToCount : (I)V
    //   178: aload_0
    //   179: getfield e : Landroid/widget/EdgeEffect;
    //   182: invokevirtual isFinished : ()Z
    //   185: ifne -> 355
    //   188: aload_1
    //   189: invokevirtual save : ()I
    //   192: istore_3
    //   193: aload_0
    //   194: invokevirtual getWidth : ()I
    //   197: istore #4
    //   199: aload_0
    //   200: invokevirtual getHeight : ()I
    //   203: istore #5
    //   205: iload #5
    //   207: aload_0
    //   208: invokevirtual getScrollRange : ()I
    //   211: iload_2
    //   212: invokestatic max : (II)I
    //   215: iadd
    //   216: istore #6
    //   218: getstatic android/os/Build$VERSION.SDK_INT : I
    //   221: bipush #21
    //   223: if_icmplt -> 240
    //   226: aload_0
    //   227: invokevirtual getClipToPadding : ()Z
    //   230: istore #8
    //   232: iconst_0
    //   233: istore #7
    //   235: iload #8
    //   237: ifeq -> 262
    //   240: iload #4
    //   242: aload_0
    //   243: invokevirtual getPaddingLeft : ()I
    //   246: aload_0
    //   247: invokevirtual getPaddingRight : ()I
    //   250: iadd
    //   251: isub
    //   252: istore #4
    //   254: iconst_0
    //   255: aload_0
    //   256: invokevirtual getPaddingLeft : ()I
    //   259: iadd
    //   260: istore #7
    //   262: getstatic android/os/Build$VERSION.SDK_INT : I
    //   265: bipush #21
    //   267: if_icmplt -> 300
    //   270: aload_0
    //   271: invokevirtual getClipToPadding : ()Z
    //   274: ifeq -> 300
    //   277: iload #5
    //   279: aload_0
    //   280: invokevirtual getPaddingTop : ()I
    //   283: aload_0
    //   284: invokevirtual getPaddingBottom : ()I
    //   287: iadd
    //   288: isub
    //   289: istore #5
    //   291: iload #6
    //   293: aload_0
    //   294: invokevirtual getPaddingBottom : ()I
    //   297: isub
    //   298: istore #6
    //   300: aload_1
    //   301: iload #7
    //   303: iload #4
    //   305: isub
    //   306: i2f
    //   307: iload #6
    //   309: i2f
    //   310: invokevirtual translate : (FF)V
    //   313: aload_1
    //   314: ldc_w 180.0
    //   317: iload #4
    //   319: i2f
    //   320: fconst_0
    //   321: invokevirtual rotate : (FFF)V
    //   324: aload_0
    //   325: getfield e : Landroid/widget/EdgeEffect;
    //   328: iload #4
    //   330: iload #5
    //   332: invokevirtual setSize : (II)V
    //   335: aload_0
    //   336: getfield e : Landroid/widget/EdgeEffect;
    //   339: aload_1
    //   340: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   343: ifeq -> 350
    //   346: aload_0
    //   347: invokestatic d : (Landroid/view/View;)V
    //   350: aload_1
    //   351: iload_3
    //   352: invokevirtual restoreToCount : (I)V
    //   355: return }
  
  public boolean e(int paramInt) {
    View view1 = findFocus();
    if (view1 == this)
      view1 = null; 
    View view2 = FocusFinder.getInstance().findNextFocus(this, view1, paramInt);
    int i1 = getMaxScrollAmount();
    if (view2 != null && a(view2, i1, getHeight())) {
      view2.getDrawingRect(this.b);
      offsetDescendantRectToMyCoords(view2, this.b);
      g(a(this.b));
      view2.requestFocus(paramInt);
    } else {
      if (paramInt == 33 && getScrollY() < i1) {
        i1 = getScrollY();
      } else if (paramInt == 130 && getChildCount() > 0) {
        View view = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        i1 = Math.min(view.getBottom() + layoutParams.bottomMargin - getScrollY() + getHeight() - getPaddingBottom(), i1);
      } 
      if (i1 == 0)
        return false; 
      if (paramInt != 130)
        i1 = -i1; 
      g(i1);
    } 
    if (view1 != null && view1.isFocused() && a(view1)) {
      int i2 = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(i2);
    } 
    return true;
  }
  
  public void f(int paramInt) {
    if (getChildCount() > 0) {
      a(2, 1);
      this.c.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      this.u = getScrollY();
      r.d(this);
    } 
  }
  
  protected float getBottomFadingEdgeStrength() {
    if (getChildCount() == 0)
      return 0.0F; 
    View view = getChildAt(0);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getHeight() - getPaddingBottom();
    int i3 = view.getBottom() + layoutParams.bottomMargin - getScrollY() - i2;
    return (i3 < i1) ? (i3 / i1) : 1.0F;
  }
  
  public int getMaxScrollAmount() { return (int)(0.5F * getHeight()); }
  
  public int getNestedScrollAxes() { return this.y.a(); }
  
  int getScrollRange() {
    int i1 = getChildCount();
    int i2 = 0;
    if (i1 > 0) {
      View view = getChildAt(0);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
      i2 = Math.max(0, view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin - getHeight() - getPaddingTop() - getPaddingBottom());
    } 
    return i2;
  }
  
  protected float getTopFadingEdgeStrength() {
    if (getChildCount() == 0)
      return 0.0F; 
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getScrollY();
    return (i2 < i1) ? (i2 / i1) : 1.0F;
  }
  
  public boolean hasNestedScrollingParent() { return b(0); }
  
  public boolean isNestedScrollingEnabled() { return this.z.a(); }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, paramInt2 + getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.h = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    if ((0x2 & paramMotionEvent.getSource()) != 0) {
      if (paramMotionEvent.getAction() != 8)
        return false; 
      if (!this.j) {
        float f1 = paramMotionEvent.getAxisValue(9);
        if (f1 != 0.0F) {
          int i1 = (int)(f1 * getVerticalScrollFactorCompat());
          int i2 = getScrollRange();
          int i3 = getScrollY();
          int i4 = i3 - i1;
          if (i4 < 0) {
            i4 = 0;
          } else if (i4 > i2) {
            i4 = i2;
          } 
          if (i4 != i3) {
            super.scrollTo(getScrollX(), i4);
            return true;
          } 
        } 
      } 
    } 
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getAction();
    if (i1 == 2 && this.j)
      return true; 
    int i2 = i1 & 0xFF;
    if (i2 != 6) {
      int i4;
      switch (i2) {
        default:
          return this.j;
        case 2:
          i4 = this.q;
          if (i4 != -1) {
            int i5 = paramMotionEvent.findPointerIndex(i4);
            if (i5 == -1) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Invalid pointerId=");
              stringBuilder.append(i4);
              stringBuilder.append(" in onInterceptTouchEvent");
              Log.e("NestedScrollView", stringBuilder.toString());
            } else {
              int i6 = (int)paramMotionEvent.getY(i5);
              if (Math.abs(i6 - this.f) > this.n && (0x2 & getNestedScrollAxes()) == 0) {
                this.j = true;
                this.f = i6;
                d();
                this.k.addMovement(paramMotionEvent);
                this.t = 0;
                ViewParent viewParent = getParent();
                if (viewParent != null)
                  viewParent.requestDisallowInterceptTouchEvent(true); 
              } 
            } 
          } 
        case 1:
        case 3:
          this.j = false;
          this.q = -1;
          e();
          if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))
            r.d(this); 
          a(0);
        case 0:
          break;
      } 
      int i3 = (int)paramMotionEvent.getY();
      if (!d((int)paramMotionEvent.getX(), i3)) {
        this.j = false;
        e();
      } 
      this.f = i3;
      this.q = paramMotionEvent.getPointerId(0);
      c();
      this.k.addMovement(paramMotionEvent);
      this.c.computeScrollOffset();
      this.j = true ^ this.c.isFinished();
      a(2, 0);
    } 
    a(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = false;
    View view = this.i;
    if (view != null && a(view, this))
      b(this.i); 
    this.i = null;
    if (!this.h) {
      if (this.v != null) {
        scrollTo(getScrollX(), this.v.a);
        this.v = null;
      } 
      int i1 = getChildCount();
      int i2 = 0;
      if (i1 > 0) {
        View view1 = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view1.getLayoutParams();
        i2 = view1.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      } 
      int i3 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      int i4 = getScrollY();
      int i5 = b(i4, i3, i2);
      if (i5 != i4)
        scrollTo(getScrollX(), i5); 
    } 
    scrollTo(getScrollX(), getScrollY());
    this.h = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.l)
      return; 
    if (View.MeasureSpec.getMode(paramInt2) == 0)
      return; 
    if (getChildCount() > 0) {
      View view = getChildAt(0);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
      int i1 = view.getMeasuredHeight();
      int i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - layoutParams.topMargin - layoutParams.bottomMargin;
      if (i1 < i2)
        view.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(i2, 1073741824)); 
    } 
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (!paramBoolean) {
      h((int)paramFloat2);
      return true;
    } 
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) { return dispatchNestedPreFling(paramFloat1, paramFloat2); }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) { a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0); }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0); }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) { b(paramView1, paramView2, paramInt, 0); }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) { super.scrollTo(paramInt1, paramInt2); }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    View view;
    if (paramInt == 2) {
      paramInt = 130;
    } else if (paramInt == 1) {
      paramInt = 33;
    } 
    if (paramRect == null) {
      view = FocusFinder.getInstance().findNextFocus(this, null, paramInt);
    } else {
      view = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, paramInt);
    } 
    return (view == null) ? false : (a(view) ? false : view.requestFocus(paramInt, paramRect));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof c)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    c c1 = (c)paramParcelable;
    super.onRestoreInstanceState(c1.getSuperState());
    this.v = c1;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState() {
    c c1 = new c(super.onSaveInstanceState());
    c1.a = getScrollY();
    return c1;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b b1 = this.B;
    if (b1 != null)
      b1.a(this, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View view = findFocus();
    if (view != null) {
      if (this == view)
        return; 
      if (a(view, 0, paramInt4)) {
        view.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(view, this.b);
        g(a(this.b));
      } 
    } 
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) { return a(paramView1, paramView2, paramInt, 0); }
  
  public void onStopNestedScroll(View paramView) { c(paramView, 0); }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) { // Byte code:
    //   0: aload_0
    //   1: invokespecial d : ()V
    //   4: aload_1
    //   5: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   8: astore_2
    //   9: aload_1
    //   10: invokevirtual getActionMasked : ()I
    //   13: istore_3
    //   14: iload_3
    //   15: ifne -> 23
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield t : I
    //   23: aload_2
    //   24: fconst_0
    //   25: aload_0
    //   26: getfield t : I
    //   29: i2f
    //   30: invokevirtual offsetLocation : (FF)V
    //   33: iload_3
    //   34: tableswitch default -> 76, 0 -> 842, 1 -> 761, 2 -> 189, 3 -> 134, 4 -> 76, 5 -> 104, 6 -> 79
    //   76: goto -> 934
    //   79: aload_0
    //   80: aload_1
    //   81: invokespecial a : (Landroid/view/MotionEvent;)V
    //   84: aload_0
    //   85: aload_1
    //   86: aload_1
    //   87: aload_0
    //   88: getfield q : I
    //   91: invokevirtual findPointerIndex : (I)I
    //   94: invokevirtual getY : (I)F
    //   97: f2i
    //   98: putfield f : I
    //   101: goto -> 934
    //   104: aload_1
    //   105: invokevirtual getActionIndex : ()I
    //   108: istore #32
    //   110: aload_0
    //   111: aload_1
    //   112: iload #32
    //   114: invokevirtual getY : (I)F
    //   117: f2i
    //   118: putfield f : I
    //   121: aload_0
    //   122: aload_1
    //   123: iload #32
    //   125: invokevirtual getPointerId : (I)I
    //   128: putfield q : I
    //   131: goto -> 934
    //   134: aload_0
    //   135: getfield j : Z
    //   138: ifeq -> 177
    //   141: aload_0
    //   142: invokevirtual getChildCount : ()I
    //   145: ifle -> 177
    //   148: aload_0
    //   149: getfield c : Landroid/widget/OverScroller;
    //   152: aload_0
    //   153: invokevirtual getScrollX : ()I
    //   156: aload_0
    //   157: invokevirtual getScrollY : ()I
    //   160: iconst_0
    //   161: iconst_0
    //   162: iconst_0
    //   163: aload_0
    //   164: invokevirtual getScrollRange : ()I
    //   167: invokevirtual springBack : (IIIIII)Z
    //   170: ifeq -> 177
    //   173: aload_0
    //   174: invokestatic d : (Landroid/view/View;)V
    //   177: aload_0
    //   178: iconst_m1
    //   179: putfield q : I
    //   182: aload_0
    //   183: invokespecial f : ()V
    //   186: goto -> 934
    //   189: aload_1
    //   190: aload_0
    //   191: getfield q : I
    //   194: invokevirtual findPointerIndex : (I)I
    //   197: istore #10
    //   199: iload #10
    //   201: iconst_m1
    //   202: if_icmpne -> 257
    //   205: new java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial <init> : ()V
    //   212: astore #11
    //   214: aload #11
    //   216: ldc_w 'Invalid pointerId='
    //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload #11
    //   225: aload_0
    //   226: getfield q : I
    //   229: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload #11
    //   235: ldc_w ' in onTouchEvent'
    //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc_w 'NestedScrollView'
    //   245: aload #11
    //   247: invokevirtual toString : ()Ljava/lang/String;
    //   250: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   253: pop
    //   254: goto -> 934
    //   257: aload_1
    //   258: iload #10
    //   260: invokevirtual getY : (I)F
    //   263: f2i
    //   264: istore #16
    //   266: aload_0
    //   267: getfield f : I
    //   270: iload #16
    //   272: isub
    //   273: istore #17
    //   275: aload_0
    //   276: getfield s : [I
    //   279: astore #18
    //   281: aload_0
    //   282: getfield r : [I
    //   285: astore #19
    //   287: aload_0
    //   288: iconst_0
    //   289: iload #17
    //   291: aload #18
    //   293: aload #19
    //   295: iconst_0
    //   296: invokevirtual a : (II[I[II)Z
    //   299: ifeq -> 340
    //   302: iload #17
    //   304: aload_0
    //   305: getfield s : [I
    //   308: iconst_1
    //   309: iaload
    //   310: isub
    //   311: istore #17
    //   313: aload_2
    //   314: fconst_0
    //   315: aload_0
    //   316: getfield r : [I
    //   319: iconst_1
    //   320: iaload
    //   321: i2f
    //   322: invokevirtual offsetLocation : (FF)V
    //   325: aload_0
    //   326: aload_0
    //   327: getfield t : I
    //   330: aload_0
    //   331: getfield r : [I
    //   334: iconst_1
    //   335: iaload
    //   336: iadd
    //   337: putfield t : I
    //   340: aload_0
    //   341: getfield j : Z
    //   344: ifne -> 409
    //   347: iload #17
    //   349: invokestatic abs : (I)I
    //   352: aload_0
    //   353: getfield n : I
    //   356: if_icmple -> 409
    //   359: aload_0
    //   360: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   363: astore #31
    //   365: aload #31
    //   367: ifnull -> 378
    //   370: aload #31
    //   372: iconst_1
    //   373: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   378: aload_0
    //   379: iconst_1
    //   380: putfield j : Z
    //   383: iload #17
    //   385: ifle -> 400
    //   388: iload #17
    //   390: aload_0
    //   391: getfield n : I
    //   394: isub
    //   395: istore #17
    //   397: goto -> 409
    //   400: iload #17
    //   402: aload_0
    //   403: getfield n : I
    //   406: iadd
    //   407: istore #17
    //   409: iload #17
    //   411: istore #20
    //   413: aload_0
    //   414: getfield j : Z
    //   417: ifeq -> 934
    //   420: aload_0
    //   421: iload #16
    //   423: aload_0
    //   424: getfield r : [I
    //   427: iconst_1
    //   428: iaload
    //   429: isub
    //   430: putfield f : I
    //   433: aload_0
    //   434: invokevirtual getScrollY : ()I
    //   437: istore #21
    //   439: aload_0
    //   440: invokevirtual getScrollRange : ()I
    //   443: istore #22
    //   445: aload_0
    //   446: invokevirtual getOverScrollMode : ()I
    //   449: istore #23
    //   451: iload #23
    //   453: ifeq -> 476
    //   456: iload #23
    //   458: iconst_1
    //   459: if_icmpne -> 470
    //   462: iload #22
    //   464: ifle -> 470
    //   467: goto -> 476
    //   470: iconst_0
    //   471: istore #24
    //   473: goto -> 479
    //   476: iconst_1
    //   477: istore #24
    //   479: aload_0
    //   480: iconst_0
    //   481: iload #20
    //   483: iconst_0
    //   484: aload_0
    //   485: invokevirtual getScrollY : ()I
    //   488: iconst_0
    //   489: iload #22
    //   491: iconst_0
    //   492: iconst_0
    //   493: iconst_1
    //   494: invokevirtual a : (IIIIIIIIZ)Z
    //   497: ifeq -> 515
    //   500: aload_0
    //   501: iconst_0
    //   502: invokevirtual b : (I)Z
    //   505: ifne -> 515
    //   508: aload_0
    //   509: getfield k : Landroid/view/VelocityTracker;
    //   512: invokevirtual clear : ()V
    //   515: aload_0
    //   516: invokevirtual getScrollY : ()I
    //   519: iload #21
    //   521: isub
    //   522: istore #25
    //   524: aload_0
    //   525: iconst_0
    //   526: iload #25
    //   528: iconst_0
    //   529: iload #20
    //   531: iload #25
    //   533: isub
    //   534: aload_0
    //   535: getfield r : [I
    //   538: iconst_0
    //   539: invokevirtual a : (IIII[II)Z
    //   542: ifeq -> 596
    //   545: aload_0
    //   546: getfield f : I
    //   549: istore #29
    //   551: aload_0
    //   552: getfield r : [I
    //   555: astore #30
    //   557: aload_0
    //   558: iload #29
    //   560: aload #30
    //   562: iconst_1
    //   563: iaload
    //   564: isub
    //   565: putfield f : I
    //   568: aload_2
    //   569: fconst_0
    //   570: aload #30
    //   572: iconst_1
    //   573: iaload
    //   574: i2f
    //   575: invokevirtual offsetLocation : (FF)V
    //   578: aload_0
    //   579: aload_0
    //   580: getfield t : I
    //   583: aload_0
    //   584: getfield r : [I
    //   587: iconst_1
    //   588: iaload
    //   589: iadd
    //   590: putfield t : I
    //   593: goto -> 934
    //   596: iload #24
    //   598: ifeq -> 934
    //   601: aload_0
    //   602: invokespecial g : ()V
    //   605: iload #21
    //   607: iload #20
    //   609: iadd
    //   610: istore #26
    //   612: iload #26
    //   614: ifge -> 669
    //   617: aload_0
    //   618: getfield d : Landroid/widget/EdgeEffect;
    //   621: iload #20
    //   623: i2f
    //   624: aload_0
    //   625: invokevirtual getHeight : ()I
    //   628: i2f
    //   629: fdiv
    //   630: aload_1
    //   631: iload #10
    //   633: invokevirtual getX : (I)F
    //   636: aload_0
    //   637: invokevirtual getWidth : ()I
    //   640: i2f
    //   641: fdiv
    //   642: invokestatic a : (Landroid/widget/EdgeEffect;FF)V
    //   645: aload_0
    //   646: getfield e : Landroid/widget/EdgeEffect;
    //   649: invokevirtual isFinished : ()Z
    //   652: ifne -> 725
    //   655: aload_0
    //   656: getfield e : Landroid/widget/EdgeEffect;
    //   659: astore #28
    //   661: aload #28
    //   663: invokevirtual onRelease : ()V
    //   666: goto -> 725
    //   669: iload #26
    //   671: iload #22
    //   673: if_icmple -> 725
    //   676: aload_0
    //   677: getfield e : Landroid/widget/EdgeEffect;
    //   680: iload #20
    //   682: i2f
    //   683: aload_0
    //   684: invokevirtual getHeight : ()I
    //   687: i2f
    //   688: fdiv
    //   689: fconst_1
    //   690: aload_1
    //   691: iload #10
    //   693: invokevirtual getX : (I)F
    //   696: aload_0
    //   697: invokevirtual getWidth : ()I
    //   700: i2f
    //   701: fdiv
    //   702: fsub
    //   703: invokestatic a : (Landroid/widget/EdgeEffect;FF)V
    //   706: aload_0
    //   707: getfield d : Landroid/widget/EdgeEffect;
    //   710: invokevirtual isFinished : ()Z
    //   713: ifne -> 725
    //   716: aload_0
    //   717: getfield d : Landroid/widget/EdgeEffect;
    //   720: astore #28
    //   722: goto -> 661
    //   725: aload_0
    //   726: getfield d : Landroid/widget/EdgeEffect;
    //   729: astore #27
    //   731: aload #27
    //   733: ifnull -> 934
    //   736: aload #27
    //   738: invokevirtual isFinished : ()Z
    //   741: ifeq -> 754
    //   744: aload_0
    //   745: getfield e : Landroid/widget/EdgeEffect;
    //   748: invokevirtual isFinished : ()Z
    //   751: ifne -> 934
    //   754: aload_0
    //   755: invokestatic d : (Landroid/view/View;)V
    //   758: goto -> 934
    //   761: aload_0
    //   762: getfield k : Landroid/view/VelocityTracker;
    //   765: astore #8
    //   767: aload #8
    //   769: sipush #1000
    //   772: aload_0
    //   773: getfield p : I
    //   776: i2f
    //   777: invokevirtual computeCurrentVelocity : (IF)V
    //   780: aload #8
    //   782: aload_0
    //   783: getfield q : I
    //   786: invokevirtual getYVelocity : (I)F
    //   789: f2i
    //   790: istore #9
    //   792: iload #9
    //   794: invokestatic abs : (I)I
    //   797: aload_0
    //   798: getfield o : I
    //   801: if_icmple -> 814
    //   804: aload_0
    //   805: iload #9
    //   807: ineg
    //   808: invokespecial h : (I)V
    //   811: goto -> 177
    //   814: aload_0
    //   815: getfield c : Landroid/widget/OverScroller;
    //   818: aload_0
    //   819: invokevirtual getScrollX : ()I
    //   822: aload_0
    //   823: invokevirtual getScrollY : ()I
    //   826: iconst_0
    //   827: iconst_0
    //   828: iconst_0
    //   829: aload_0
    //   830: invokevirtual getScrollRange : ()I
    //   833: invokevirtual springBack : (IIIIII)Z
    //   836: ifeq -> 177
    //   839: goto -> 173
    //   842: aload_0
    //   843: invokevirtual getChildCount : ()I
    //   846: ifne -> 851
    //   849: iconst_0
    //   850: ireturn
    //   851: iconst_1
    //   852: aload_0
    //   853: getfield c : Landroid/widget/OverScroller;
    //   856: invokevirtual isFinished : ()Z
    //   859: ixor
    //   860: istore #4
    //   862: aload_0
    //   863: iload #4
    //   865: putfield j : Z
    //   868: iload #4
    //   870: ifeq -> 892
    //   873: aload_0
    //   874: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   877: astore #7
    //   879: aload #7
    //   881: ifnull -> 892
    //   884: aload #7
    //   886: iconst_1
    //   887: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   892: aload_0
    //   893: getfield c : Landroid/widget/OverScroller;
    //   896: invokevirtual isFinished : ()Z
    //   899: ifne -> 909
    //   902: aload_0
    //   903: getfield c : Landroid/widget/OverScroller;
    //   906: invokevirtual abortAnimation : ()V
    //   909: aload_0
    //   910: aload_1
    //   911: invokevirtual getY : ()F
    //   914: f2i
    //   915: putfield f : I
    //   918: aload_0
    //   919: aload_1
    //   920: iconst_0
    //   921: invokevirtual getPointerId : (I)I
    //   924: putfield q : I
    //   927: aload_0
    //   928: iconst_2
    //   929: iconst_0
    //   930: invokevirtual a : (II)Z
    //   933: pop
    //   934: aload_0
    //   935: getfield k : Landroid/view/VelocityTracker;
    //   938: astore #6
    //   940: aload #6
    //   942: ifnull -> 951
    //   945: aload #6
    //   947: aload_2
    //   948: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   951: aload_2
    //   952: invokevirtual recycle : ()V
    //   955: iconst_1
    //   956: ireturn }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    if (!this.g) {
      b(paramView2);
    } else {
      this.i = paramView2;
    } 
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return a(paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    if (paramBoolean)
      e(); 
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout() {
    this.g = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {
    if (getChildCount() > 0) {
      View view = getChildAt(0);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
      int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
      int i2 = view.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
      int i3 = getHeight() - getPaddingTop() - getPaddingBottom();
      int i4 = view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      int i5 = b(paramInt1, i1, i2);
      int i6 = b(paramInt2, i3, i4);
      if (i5 != getScrollX() || i6 != getScrollY())
        super.scrollTo(i5, i6); 
    } 
  }
  
  public void setFillViewport(boolean paramBoolean) {
    if (paramBoolean != this.l) {
      this.l = paramBoolean;
      requestLayout();
    } 
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) { this.z.a(paramBoolean); }
  
  public void setOnScrollChangeListener(b paramb) { this.B = paramb; }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean) { this.m = paramBoolean; }
  
  public boolean shouldDelayChildPressedState() { return true; }
  
  public boolean startNestedScroll(int paramInt) { return a(paramInt, 0); }
  
  public void stopNestedScroll() { a(0); }
  
  static class a extends b {
    public void a(View param1View, c param1c) {
      super.a(param1View, param1c);
      NestedScrollView nestedScrollView = (NestedScrollView)param1View;
      param1c.a(android.widget.ScrollView.class.getName());
      if (nestedScrollView.isEnabled()) {
        int i = nestedScrollView.getScrollRange();
        if (i > 0) {
          param1c.c(true);
          if (nestedScrollView.getScrollY() > 0)
            param1c.a(8192); 
          if (nestedScrollView.getScrollY() < i)
            param1c.a(4096); 
        } 
      } 
    }
    
    public void a(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      boolean bool;
      super.a(param1View, param1AccessibilityEvent);
      NestedScrollView nestedScrollView = (NestedScrollView)param1View;
      param1AccessibilityEvent.setClassName(android.widget.ScrollView.class.getName());
      if (nestedScrollView.getScrollRange() > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1AccessibilityEvent.setScrollable(bool);
      param1AccessibilityEvent.setScrollX(nestedScrollView.getScrollX());
      param1AccessibilityEvent.setScrollY(nestedScrollView.getScrollY());
      e.a(param1AccessibilityEvent, nestedScrollView.getScrollX());
      e.b(param1AccessibilityEvent, nestedScrollView.getScrollRange());
    }
    
    public boolean a(View param1View, int param1Int, Bundle param1Bundle) {
      if (super.a(param1View, param1Int, param1Bundle))
        return true; 
      NestedScrollView nestedScrollView = (NestedScrollView)param1View;
      if (!nestedScrollView.isEnabled())
        return false; 
      if (param1Int != 4096) {
        if (param1Int != 8192)
          return false; 
        int j = nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom() - nestedScrollView.getPaddingTop();
        int k = Math.max(nestedScrollView.getScrollY() - j, 0);
        if (k != nestedScrollView.getScrollY()) {
          nestedScrollView.c(0, k);
          return true;
        } 
        return false;
      } 
      int i = Math.min(nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom() - nestedScrollView.getPaddingTop() + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
      if (i != nestedScrollView.getScrollY()) {
        nestedScrollView.c(0, i);
        return true;
      } 
      return false;
    }
  }
  
  public static interface b {
    void a(NestedScrollView param1NestedScrollView, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
  
  static class c extends View.BaseSavedState {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        public NestedScrollView.c a(Parcel param2Parcel) { return new NestedScrollView.c(param2Parcel); }
        
        public NestedScrollView.c[] a(int param2Int) { return new NestedScrollView.c[param2Int]; }
      };
    
    public int a;
    
    c(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readInt();
    }
    
    c(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("HorizontalScrollView.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" scrollPosition=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
    }
  }
  
  static final class null extends Object implements Parcelable.Creator<c> {
    public NestedScrollView.c a(Parcel param1Parcel) { return new NestedScrollView.c(param1Parcel); }
    
    public NestedScrollView.c[] a(int param1Int) { return new NestedScrollView.c[param1Int]; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\NestedScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */