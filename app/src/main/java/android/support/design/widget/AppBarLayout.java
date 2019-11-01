package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.a;
import android.support.design.a.a;
import android.support.v4.c.a;
import android.support.v4.h.a;
import android.support.v4.h.r;
import android.support.v4.h.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.List;

@c(a = "Landroid/support/design/widget/AppBarLayout$Behavior;")
public class AppBarLayout extends LinearLayout {
  private int a;
  
  private int b;
  
  private int c;
  
  private boolean d;
  
  private int e;
  
  private z f;
  
  private List<a> g;
  
  private boolean h;
  
  private boolean i;
  
  private boolean j;
  
  private boolean k;
  
  private int[] l;
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    byte b2;
    byte b1;
    if (paramBoolean1) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    if (paramBoolean2) {
      b2 = 4;
    } else {
      b2 = 0;
    } 
    byte b3 = b1 | b2;
    byte b4 = 0;
    if (paramBoolean3)
      b4 = 8; 
    this.e = b3 | b4;
    requestLayout();
  }
  
  private boolean b(boolean paramBoolean) {
    if (this.i != paramBoolean) {
      this.i = paramBoolean;
      refreshDrawableState();
      return true;
    } 
    return false;
  }
  
  private boolean f() {
    int m = getChildCount();
    for (byte b1 = 0; b1 < m; b1++) {
      if (((b)getChildAt(b1).getLayoutParams()).c())
        return true; 
    } 
    return false;
  }
  
  private void g() {
    this.a = -1;
    this.b = -1;
    this.c = -1;
  }
  
  protected b a() { return new b(-1, -2); }
  
  public b a(AttributeSet paramAttributeSet) { return new b(getContext(), paramAttributeSet); }
  
  protected b a(ViewGroup.LayoutParams paramLayoutParams) { return (Build.VERSION.SDK_INT >= 19 && paramLayoutParams instanceof LinearLayout.LayoutParams) ? new b((LinearLayout.LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new b((ViewGroup.MarginLayoutParams)paramLayoutParams) : new b(paramLayoutParams)); }
  
  void a(int paramInt) {
    List list = this.g;
    if (list != null) {
      byte b1 = 0;
      int m = list.size();
      while (b1 < m) {
        a a1 = (a)this.g.get(b1);
        if (a1 != null)
          a1.a(this, paramInt); 
        b1++;
      } 
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) { a(paramBoolean1, paramBoolean2, true); }
  
  boolean a(boolean paramBoolean) {
    if (this.j != paramBoolean) {
      this.j = paramBoolean;
      refreshDrawableState();
      return true;
    } 
    return false;
  }
  
  boolean b() { return this.d; }
  
  boolean c() { return (getTotalScrollRange() != 0); }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return paramLayoutParams instanceof b; }
  
  public boolean d() { return this.k; }
  
  void e() { this.e = 0; }
  
  int getDownNestedPreScrollRange() {
    int m = this.b;
    if (m != -1)
      return m; 
    int n = -1 + getChildCount();
    int i1 = 0;
    while (n >= 0) {
      View view = getChildAt(n);
      b b1 = (b)view.getLayoutParams();
      int i3 = view.getMeasuredHeight();
      int i4 = b1.a;
      if ((i4 & 0x5) == 5) {
        int i5 = i1 + b1.topMargin + b1.bottomMargin;
        if ((i4 & 0x8) != 0) {
          i1 = i5 + r.k(view);
        } else {
          int i6;
          if ((i4 & 0x2) != 0) {
            i6 = r.k(view);
          } else {
            i6 = getTopInset();
          } 
          i1 = i5 + i3 - i6;
        } 
      } else if (i1 > 0) {
        break;
      } 
      n--;
    } 
    int i2 = Math.max(0, i1);
    this.b = i2;
    return i2;
  }
  
  int getDownNestedScrollRange() {
    int m = this.c;
    if (m != -1)
      return m; 
    int n = getChildCount();
    byte b1 = 0;
    int i1 = 0;
    while (b1 < n) {
      View view = getChildAt(b1);
      b b2 = (b)view.getLayoutParams();
      int i3 = view.getMeasuredHeight() + b2.topMargin + b2.bottomMargin;
      int i4 = b2.a;
      if ((i4 & true) != 0) {
        i1 += i3;
        if ((i4 & 0x2) != 0) {
          i1 -= r.k(view) + getTopInset();
          break;
        } 
        b1++;
      } 
    } 
    int i2 = Math.max(0, i1);
    this.c = i2;
    return i2;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent() {
    int m = getTopInset();
    int n = r.k(this);
    if (n == 0) {
      int i1 = getChildCount();
      if (i1 >= 1) {
        n = r.k(getChildAt(i1 - 1));
      } else {
        n = 0;
      } 
      if (n == 0)
        return getHeight() / 3; 
    } 
    return m + n * 2;
  }
  
  int getPendingAction() { return this.e; }
  
  @Deprecated
  public float getTargetElevation() { return 0.0F; }
  
  final int getTopInset() {
    z z1 = this.f;
    return (z1 != null) ? z1.b() : 0;
  }
  
  public final int getTotalScrollRange() {
    int m = this.a;
    if (m != -1)
      return m; 
    int n = getChildCount();
    byte b1 = 0;
    int i1 = 0;
    while (b1 < n) {
      View view = getChildAt(b1);
      b b2 = (b)view.getLayoutParams();
      int i3 = view.getMeasuredHeight();
      int i4 = b2.a;
      if ((i4 & true) != 0) {
        i1 += i3 + b2.topMargin + b2.bottomMargin;
        if ((i4 & 0x2) != 0) {
          i1 -= r.k(view);
          break;
        } 
        b1++;
      } 
    } 
    int i2 = Math.max(0, i1 - getTopInset());
    this.a = i2;
    return i2;
  }
  
  int getUpNestedPreScrollRange() { return getTotalScrollRange(); }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int i2;
    int i1;
    int n;
    int m;
    if (this.l == null)
      this.l = new int[4]; 
    int[] arrayOfInt1 = this.l;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    if (this.i) {
      m = a.b.state_liftable;
    } else {
      m = -a.b.state_liftable;
    } 
    arrayOfInt1[0] = m;
    if (this.i && this.j) {
      n = a.b.state_lifted;
    } else {
      n = -a.b.state_lifted;
    } 
    arrayOfInt1[1] = n;
    if (this.i) {
      i1 = a.b.state_collapsible;
    } else {
      i1 = -a.b.state_collapsible;
    } 
    arrayOfInt1[2] = i1;
    if (this.i && this.j) {
      i2 = a.b.state_collapsed;
    } else {
      i2 = -a.b.state_collapsed;
    } 
    arrayOfInt1[3] = i2;
    return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload #4
    //   6: iload #5
    //   8: invokespecial onLayout : (ZIIII)V
    //   11: aload_0
    //   12: invokespecial g : ()V
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield d : Z
    //   20: aload_0
    //   21: invokevirtual getChildCount : ()I
    //   24: istore #6
    //   26: iconst_0
    //   27: istore #7
    //   29: iload #7
    //   31: iload #6
    //   33: if_icmpge -> 68
    //   36: aload_0
    //   37: iload #7
    //   39: invokevirtual getChildAt : (I)Landroid/view/View;
    //   42: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   45: checkcast android/support/design/widget/AppBarLayout$b
    //   48: invokevirtual b : ()Landroid/view/animation/Interpolator;
    //   51: ifnull -> 62
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield d : Z
    //   59: goto -> 68
    //   62: iinc #7, 1
    //   65: goto -> 29
    //   68: aload_0
    //   69: getfield h : Z
    //   72: ifne -> 106
    //   75: aload_0
    //   76: getfield k : Z
    //   79: ifne -> 96
    //   82: aload_0
    //   83: invokespecial f : ()Z
    //   86: istore #10
    //   88: iconst_0
    //   89: istore #8
    //   91: iload #10
    //   93: ifeq -> 99
    //   96: iconst_1
    //   97: istore #8
    //   99: aload_0
    //   100: iload #8
    //   102: invokespecial b : (Z)Z
    //   105: pop
    //   106: return }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    g();
  }
  
  public void setExpanded(boolean paramBoolean) { a(paramBoolean, r.x(this)); }
  
  public void setLiftOnScroll(boolean paramBoolean) { this.k = paramBoolean; }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 1) {
      super.setOrientation(paramInt);
      return;
    } 
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat) {
    if (Build.VERSION.SDK_INT >= 21)
      s.a(this, paramFloat); 
  }
  
  protected static class BaseBehavior<T extends AppBarLayout> extends h<T> {
    private int b;
    
    private int c;
    
    private ValueAnimator d;
    
    private int e = -1;
    
    private boolean f;
    
    private float g;
    
    private WeakReference<View> h;
    
    private a i;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    private int a(T param1T, int param1Int) {
      int j = param1T.getChildCount();
      for (byte b1 = 0; b1 < j; b1++) {
        View view = param1T.getChildAt(b1);
        int k = view.getTop();
        int m = view.getBottom();
        AppBarLayout.b b2 = (AppBarLayout.b)view.getLayoutParams();
        if (a(b2.a(), 32)) {
          k -= b2.topMargin;
          m += b2.bottomMargin;
        } 
        int n = -param1Int;
        if (k <= n && m >= n)
          return b1; 
      } 
      return -1;
    }
    
    private View a(CoordinatorLayout param1CoordinatorLayout) {
      int j = param1CoordinatorLayout.getChildCount();
      for (byte b1 = 0; b1 < j; b1++) {
        View view = param1CoordinatorLayout.getChildAt(b1);
        if (view instanceof android.support.v4.h.j)
          return view; 
      } 
      return null;
    }
    
    private void a(int param1Int1, T param1T, View param1View, int param1Int2) {
      if (param1Int2 == 1) {
        int j = a();
        if ((param1Int1 < 0 && j == 0) || (param1Int1 > 0 && j == -param1T.getDownNestedScrollRange()))
          r.d(param1View, 1); 
      } 
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int, float param1Float) {
      int k;
      int j = Math.abs(a() - param1Int);
      float f1 = Math.abs(param1Float);
      if (f1 > 0.0F) {
        k = 3 * Math.round(1000.0F * j / f1);
      } else {
        k = (int)(150.0F * (1.0F + j / param1T.getHeight()));
      } 
      a(param1CoordinatorLayout, param1T, param1Int, k);
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2) {
      int j = a();
      if (j == param1Int1) {
        ValueAnimator valueAnimator1 = this.d;
        if (valueAnimator1 != null && valueAnimator1.isRunning())
          this.d.cancel(); 
        return;
      } 
      ValueAnimator valueAnimator = this.d;
      if (valueAnimator == null) {
        this.d = new ValueAnimator();
        this.d.setInterpolator(a.e);
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, param1CoordinatorLayout, param1T) {
              public void onAnimationUpdate(ValueAnimator param2ValueAnimator) { this.c.a_(this.a, this.b, ((Integer)param2ValueAnimator.getAnimatedValue()).intValue()); }
            });
      } else {
        valueAnimator.cancel();
      } 
      this.d.setDuration(Math.min(param1Int2, 600));
      this.d.setIntValues(new int[] { j, param1Int1 });
      this.d.start();
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2, boolean param1Boolean) { // Byte code:
      //   0: aload_2
      //   1: iload_3
      //   2: invokestatic c : (Landroid/support/design/widget/AppBarLayout;I)Landroid/view/View;
      //   5: astore #6
      //   7: aload #6
      //   9: ifnull -> 182
      //   12: aload #6
      //   14: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   17: checkcast android/support/design/widget/AppBarLayout$b
      //   20: invokevirtual a : ()I
      //   23: istore #7
      //   25: iload #7
      //   27: iconst_1
      //   28: iand
      //   29: ifeq -> 104
      //   32: aload #6
      //   34: invokestatic k : (Landroid/view/View;)I
      //   37: istore #11
      //   39: iload #4
      //   41: ifle -> 76
      //   44: iload #7
      //   46: bipush #12
      //   48: iand
      //   49: ifeq -> 76
      //   52: iload_3
      //   53: ineg
      //   54: aload #6
      //   56: invokevirtual getBottom : ()I
      //   59: iload #11
      //   61: isub
      //   62: aload_2
      //   63: invokevirtual getTopInset : ()I
      //   66: isub
      //   67: if_icmplt -> 104
      //   70: iconst_1
      //   71: istore #8
      //   73: goto -> 107
      //   76: iload #7
      //   78: iconst_2
      //   79: iand
      //   80: ifeq -> 104
      //   83: iload_3
      //   84: ineg
      //   85: aload #6
      //   87: invokevirtual getBottom : ()I
      //   90: iload #11
      //   92: isub
      //   93: aload_2
      //   94: invokevirtual getTopInset : ()I
      //   97: isub
      //   98: if_icmplt -> 104
      //   101: goto -> 70
      //   104: iconst_0
      //   105: istore #8
      //   107: aload_2
      //   108: invokevirtual d : ()Z
      //   111: ifeq -> 143
      //   114: aload_0
      //   115: aload_1
      //   116: invokespecial a : (Landroid/support/design/widget/CoordinatorLayout;)Landroid/view/View;
      //   119: astore #10
      //   121: aload #10
      //   123: ifnull -> 143
      //   126: aload #10
      //   128: invokevirtual getScrollY : ()I
      //   131: ifle -> 140
      //   134: iconst_1
      //   135: istore #8
      //   137: goto -> 143
      //   140: iconst_0
      //   141: istore #8
      //   143: aload_2
      //   144: iload #8
      //   146: invokevirtual a : (Z)Z
      //   149: istore #9
      //   151: getstatic android/os/Build$VERSION.SDK_INT : I
      //   154: bipush #11
      //   156: if_icmplt -> 182
      //   159: iload #5
      //   161: ifne -> 178
      //   164: iload #9
      //   166: ifeq -> 182
      //   169: aload_0
      //   170: aload_1
      //   171: aload_2
      //   172: invokespecial d : (Landroid/support/design/widget/CoordinatorLayout;Landroid/support/design/widget/AppBarLayout;)Z
      //   175: ifeq -> 182
      //   178: aload_2
      //   179: invokevirtual jumpDrawablesToCurrentState : ()V
      //   182: return }
    
    private static boolean a(int param1Int1, int param1Int2) { return ((param1Int1 & param1Int2) == param1Int2); }
    
    private boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View) { return (param1T.c() && param1CoordinatorLayout.getHeight() - param1View.getHeight() <= param1T.getHeight()); }
    
    private int b(T param1T, int param1Int) {
      int j = Math.abs(param1Int);
      int k = param1T.getChildCount();
      for (byte b1 = 0; b1 < k; b1++) {
        View view = param1T.getChildAt(b1);
        AppBarLayout.b b2 = (AppBarLayout.b)view.getLayoutParams();
        Interpolator interpolator = b2.b();
        if (j >= view.getTop() && j <= view.getBottom()) {
          if (interpolator != null) {
            int m = b2.a();
            int n = m & true;
            int i1 = 0;
            if (n != 0) {
              i1 = 0 + view.getHeight() + b2.topMargin + b2.bottomMargin;
              if ((m & 0x2) != 0)
                i1 -= r.k(view); 
            } 
            if (r.q(view))
              i1 -= param1T.getTopInset(); 
            if (i1 > 0) {
              int i2 = j - view.getTop();
              float f1 = i1;
              int i3 = Math.round(f1 * interpolator.getInterpolation(i2 / f1));
              return Integer.signum(param1Int) * (i3 + view.getTop());
            } 
          } 
          break;
        } 
      } 
      return param1Int;
    }
    
    private static View c(AppBarLayout param1AppBarLayout, int param1Int) {
      int j = Math.abs(param1Int);
      int k = param1AppBarLayout.getChildCount();
      for (byte b1 = 0; b1 < k; b1++) {
        View view = param1AppBarLayout.getChildAt(b1);
        if (j >= view.getTop() && j <= view.getBottom())
          return view; 
      } 
      return null;
    }
    
    private void c(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      int j = a();
      int k = a(param1T, j);
      if (k >= 0) {
        View view = param1T.getChildAt(k);
        AppBarLayout.b b1 = (AppBarLayout.b)view.getLayoutParams();
        int m = b1.a();
        if ((m & 0x11) == 17) {
          int n = -view.getTop();
          int i1 = -view.getBottom();
          if (k == -1 + param1T.getChildCount())
            i1 += param1T.getTopInset(); 
          if (a(m, 2)) {
            i1 += r.k(view);
          } else if (a(m, 5)) {
            int i2 = i1 + r.k(view);
            if (j < i2) {
              n = i2;
            } else {
              i1 = i2;
            } 
          } 
          if (a(m, 32)) {
            n += b1.topMargin;
            i1 -= b1.bottomMargin;
          } 
          if (j < (i1 + n) / 2)
            n = i1; 
          a(param1CoordinatorLayout, param1T, a.a(n, -param1T.getTotalScrollRange(), 0), 0.0F);
        } 
      } 
    }
    
    private boolean d(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      List list = param1CoordinatorLayout.d(param1T);
      int j = list.size();
      for (byte b1 = 0; b1 < j; b1++) {
        CoordinatorLayout.b b2 = ((CoordinatorLayout.e)((View)list.get(b1)).getLayoutParams()).b();
        if (b2 instanceof AppBarLayout.ScrollingViewBehavior) {
          int k = ((AppBarLayout.ScrollingViewBehavior)b2).d();
          boolean bool = false;
          if (k != 0)
            bool = true; 
          return bool;
        } 
      } 
      return false;
    }
    
    int a() { return b() + this.b; }
    
    int a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2, int param1Int3) {
      int j = a();
      if (param1Int2 != 0 && j >= param1Int2 && j <= param1Int3) {
        int k = a.a(param1Int1, param1Int2, param1Int3);
        if (j != k) {
          byte b1;
          int m;
          if (param1T.b()) {
            m = b(param1T, k);
          } else {
            m = k;
          } 
          boolean bool = a(m);
          int n = j - k;
          this.b = k - m;
          if (!bool && param1T.b())
            param1CoordinatorLayout.b(param1T); 
          param1T.a(b());
          if (k < j) {
            b1 = -1;
          } else {
            b1 = 1;
          } 
          a(param1CoordinatorLayout, param1T, k, b1, false);
          return n;
        } 
      } else {
        this.b = 0;
      } 
      return 0;
    }
    
    void a(CoordinatorLayout param1CoordinatorLayout, T param1T) { c(param1CoordinatorLayout, param1T); }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, Parcelable param1Parcelable) {
      if (param1Parcelable instanceof b) {
        b b1 = (b)param1Parcelable;
        super.a(param1CoordinatorLayout, param1T, b1.a());
        this.e = b1.a;
        this.g = b1.b;
        this.f = b1.c;
        return;
      } 
      super.a(param1CoordinatorLayout, param1T, param1Parcelable);
      this.e = -1;
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View, int param1Int) {
      if (this.c == 0 || param1Int == 1)
        c(param1CoordinatorLayout, param1T); 
      this.h = new WeakReference(param1View);
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      if (param1Int4 < 0) {
        b(param1CoordinatorLayout, param1T, param1Int4, -param1T.getDownNestedScrollRange(), 0);
        a(param1Int4, param1T, param1View, param1Int5);
      } 
      if (param1T.d()) {
        boolean bool;
        if (param1View.getScrollY() > 0) {
          bool = true;
        } else {
          bool = false;
        } 
        param1T.a(bool);
      } 
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfInt, int param1Int3) {
      if (param1Int2 != 0) {
        byte b1;
        int j;
        if (param1Int2 < 0) {
          int k = -param1T.getTotalScrollRange();
          int m = k + param1T.getDownNestedPreScrollRange();
          j = k;
          b1 = m;
        } else {
          j = -param1T.getUpNestedPreScrollRange();
          b1 = 0;
        } 
        if (j != b1) {
          param1ArrayOfInt[1] = b(param1CoordinatorLayout, param1T, param1Int2, j, b1);
          a(param1Int2, param1T, param1View, param1Int3);
        } 
      } 
    }
    
    boolean a(T param1T) {
      a a1 = this.i;
      if (a1 != null)
        return a1.a(param1T); 
      WeakReference weakReference = this.h;
      boolean bool = true;
      if (weakReference != null) {
        View view = (View)weakReference.get();
        if (view != null && view.isShown() && !view.canScrollVertically(-1))
          return bool; 
        bool = false;
      } 
      return bool;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int) {
      boolean bool = super.a(param1CoordinatorLayout, param1T, param1Int);
      int j = param1T.getPendingAction();
      int k = this.e;
      if (k >= 0 && (j & 0x8) == 0) {
        int n;
        View view = param1T.getChildAt(k);
        int m = -view.getBottom();
        if (this.f) {
          n = r.k(view) + param1T.getTopInset();
        } else {
          n = Math.round(view.getHeight() * this.g);
        } 
        a_(param1CoordinatorLayout, param1T, m + n);
      } else if (j != 0) {
        boolean bool1;
        if ((j & 0x4) != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if ((j & 0x2) != 0) {
          int m = -param1T.getUpNestedPreScrollRange();
          if (bool1) {
            a(param1CoordinatorLayout, param1T, m, 0.0F);
          } else {
            a_(param1CoordinatorLayout, param1T, m);
          } 
        } else if ((j & true) != 0) {
          if (bool1) {
            a(param1CoordinatorLayout, param1T, 0, 0.0F);
          } else {
            a_(param1CoordinatorLayout, param1T, 0);
          } 
        } 
      } 
      param1T.e();
      this.e = -1;
      a(a.a(b(), -param1T.getTotalScrollRange(), 0));
      a(param1CoordinatorLayout, param1T, b(), 0, true);
      param1T.a(b());
      return bool;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (((CoordinatorLayout.e)param1T.getLayoutParams()).height == -2) {
        param1CoordinatorLayout.a(param1T, param1Int1, param1Int2, View.MeasureSpec.makeMeasureSpec(0, 0), param1Int4);
        return true;
      } 
      return super.a(param1CoordinatorLayout, param1T, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View1, View param1View2, int param1Int1, int param1Int2) {
      boolean bool;
      if ((param1Int1 & 0x2) != 0 && (param1T.d() || a(param1CoordinatorLayout, param1T, param1View1))) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null)
          valueAnimator.cancel(); 
      } 
      this.h = null;
      this.c = param1Int2;
      return bool;
    }
    
    int b(T param1T) { return -param1T.getDownNestedScrollRange(); }
    
    public Parcelable b(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      Parcelable parcelable = super.b(param1CoordinatorLayout, param1T);
      int j = b();
      int k = param1T.getChildCount();
      for (byte b1 = 0; b1 < k; b1++) {
        View view = param1T.getChildAt(b1);
        int m = j + view.getBottom();
        if (j + view.getTop() <= 0 && m >= 0) {
          b b2 = new b(parcelable);
          b2.a = b1;
          int n = r.k(view) + param1T.getTopInset();
          boolean bool = false;
          if (m == n)
            bool = true; 
          b2.c = bool;
          b2.b = m / view.getHeight();
          return b2;
        } 
      } 
      return parcelable;
    }
    
    int c(T param1T) { return param1T.getTotalScrollRange(); }
    
    public static abstract class a<T extends AppBarLayout> extends Object {
      public abstract boolean a(T param2T);
    }
    
    protected static class b extends a {
      public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() {
          public AppBarLayout.BaseBehavior.b a(Parcel param3Parcel) { return new AppBarLayout.BaseBehavior.b(param3Parcel, null); }
          
          public AppBarLayout.BaseBehavior.b a(Parcel param3Parcel, ClassLoader param3ClassLoader) { return new AppBarLayout.BaseBehavior.b(param3Parcel, param3ClassLoader); }
          
          public AppBarLayout.BaseBehavior.b[] a(int param3Int) { return new AppBarLayout.BaseBehavior.b[param3Int]; }
        };
      
      int a;
      
      float b;
      
      boolean c;
      
      public b(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        super(param2Parcel, param2ClassLoader);
        this.a = param2Parcel.readInt();
        this.b = param2Parcel.readFloat();
        if (param2Parcel.readByte() != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.c = bool;
      }
      
      public b(Parcelable param2Parcelable) { super(param2Parcelable); }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        super.writeToParcel(param2Parcel, param2Int);
        param2Parcel.writeInt(this.a);
        param2Parcel.writeFloat(this.b);
        param2Parcel.writeByte((byte)this.c);
      }
    }
    
    static final class null extends Object implements Parcelable.ClassLoaderCreator<b> {
      public AppBarLayout.BaseBehavior.b a(Parcel param2Parcel) { return new AppBarLayout.BaseBehavior.b(param2Parcel, null); }
      
      public AppBarLayout.BaseBehavior.b a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new AppBarLayout.BaseBehavior.b(param2Parcel, param2ClassLoader); }
      
      public AppBarLayout.BaseBehavior.b[] a(int param2Int) { return new AppBarLayout.BaseBehavior.b[param2Int]; }
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    null(AppBarLayout this$0, CoordinatorLayout param1CoordinatorLayout, AppBarLayout param1AppBarLayout) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) { this.c.a_(this.a, this.b, ((Integer)param1ValueAnimator.getAnimatedValue()).intValue()); }
  }
  
  public static abstract class a<T extends AppBarLayout> extends Object {
    public abstract boolean a(T param1T);
  }
  
  protected static class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() {
        public AppBarLayout.BaseBehavior.b a(Parcel param3Parcel) { return new AppBarLayout.BaseBehavior.b(param3Parcel, null); }
        
        public AppBarLayout.BaseBehavior.b a(Parcel param3Parcel, ClassLoader param3ClassLoader) { return new AppBarLayout.BaseBehavior.b(param3Parcel, param3ClassLoader); }
        
        public AppBarLayout.BaseBehavior.b[] a(int param3Int) { return new AppBarLayout.BaseBehavior.b[param3Int]; }
      };
    
    int a;
    
    float b;
    
    boolean c;
    
    public b(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readFloat();
      if (param1Parcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.c = bool;
    }
    
    public b(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeFloat(this.b);
      param1Parcel.writeByte((byte)this.c);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<BaseBehavior.b> {
    public AppBarLayout.BaseBehavior.b a(Parcel param1Parcel) { return new AppBarLayout.BaseBehavior.b(param1Parcel, null); }
    
    public AppBarLayout.BaseBehavior.b a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new AppBarLayout.BaseBehavior.b(param1Parcel, param1ClassLoader); }
    
    public AppBarLayout.BaseBehavior.b[] a(int param1Int) { return new AppBarLayout.BaseBehavior.b[param1Int]; }
  }
  
  public static class Behavior extends BaseBehavior<AppBarLayout> {
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
  }
  
  public static class ScrollingViewBehavior extends i {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.k.ScrollingViewBehavior_Layout);
      b(typedArray.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
      typedArray.recycle();
    }
    
    private static int a(AppBarLayout param1AppBarLayout) {
      CoordinatorLayout.b b = ((CoordinatorLayout.e)param1AppBarLayout.getLayoutParams()).b();
      return (b instanceof AppBarLayout.BaseBehavior) ? ((AppBarLayout.BaseBehavior)b).a() : 0;
    }
    
    private void a(View param1View1, View param1View2) {
      CoordinatorLayout.b b = ((CoordinatorLayout.e)param1View2.getLayoutParams()).b();
      if (b instanceof AppBarLayout.BaseBehavior) {
        AppBarLayout.BaseBehavior baseBehavior;
        r.e(param1View1, param1View2.getBottom() - param1View1.getTop() + (baseBehavior = (AppBarLayout.BaseBehavior)b).a(baseBehavior) + a() - c(param1View2));
      } 
    }
    
    private void b(View param1View1, View param1View2) {
      if (param1View2 instanceof AppBarLayout) {
        AppBarLayout appBarLayout = (AppBarLayout)param1View2;
        if (appBarLayout.d()) {
          boolean bool;
          if (param1View1.getScrollY() > 0) {
            bool = true;
          } else {
            bool = false;
          } 
          appBarLayout.a(bool);
        } 
      } 
    }
    
    float a(View param1View) {
      if (param1View instanceof AppBarLayout) {
        AppBarLayout appBarLayout = (AppBarLayout)param1View;
        int j = appBarLayout.getTotalScrollRange();
        int k = appBarLayout.getDownNestedPreScrollRange();
        int m = a(appBarLayout);
        if (k != 0 && j + m <= k)
          return 0.0F; 
        int n = j - k;
        if (n != 0)
          return 1.0F + m / n; 
      } 
      return 0.0F;
    }
    
    AppBarLayout a(List<View> param1List) {
      int j = param1List.size();
      for (byte b = 0; b < j; b++) {
        View view = (View)param1List.get(b);
        if (view instanceof AppBarLayout)
          return (AppBarLayout)view; 
      } 
      return null;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, View param1View, Rect param1Rect, boolean param1Boolean) {
      AppBarLayout appBarLayout = a(param1CoordinatorLayout.c(param1View));
      if (appBarLayout != null) {
        param1Rect.offset(param1View.getLeft(), param1View.getTop());
        Rect rect = this.a;
        rect.set(0, 0, param1CoordinatorLayout.getWidth(), param1CoordinatorLayout.getHeight());
        if (!rect.contains(param1Rect)) {
          appBarLayout.a(false, param1Boolean ^ true);
          return true;
        } 
      } 
      return false;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) { return param1View2 instanceof AppBarLayout; }
    
    int b(View param1View) { return (param1View instanceof AppBarLayout) ? ((AppBarLayout)param1View).getTotalScrollRange() : super.b(param1View); }
    
    public boolean b(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) {
      a(param1View1, param1View2);
      b(param1View1, param1View2);
      return false;
    }
  }
  
  public static interface a<T extends AppBarLayout> {
    void a(T param1T, int param1Int);
  }
  
  public static class b extends LinearLayout.LayoutParams {
    int a = 1;
    
    Interpolator b;
    
    public b(int param1Int1, int param1Int2) { super(param1Int1, param1Int2); }
    
    public b(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.k.AppBarLayout_Layout);
      this.a = typedArray.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (typedArray.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator))
        this.b = AnimationUtils.loadInterpolator(param1Context, typedArray.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0)); 
      typedArray.recycle();
    }
    
    public b(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public b(ViewGroup.MarginLayoutParams param1MarginLayoutParams) { super(param1MarginLayoutParams); }
    
    public b(LinearLayout.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public int a() { return this.a; }
    
    public Interpolator b() { return this.b; }
    
    boolean c() {
      int i = this.a;
      return ((i & true) == 1 && (i & 0xA) != 0);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */