package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.m;
import android.support.v4.h.o;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.view.menu.o;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements m, ai {
  static final int[] e;
  
  private final Runnable A = new Runnable(this) {
      public void run() {
        this.a.d();
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = actionBarOverlayLayout.a.animate().translationY(-this.a.a.getHeight()).setListener(this.a.d);
      }
    };
  
  private final o B;
  
  ActionBarContainer a;
  
  boolean b;
  
  ViewPropertyAnimator c;
  
  final AnimatorListenerAdapter d = new AnimatorListenerAdapter(this) {
      public void onAnimationCancel(Animator param1Animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = null;
        actionBarOverlayLayout.b = false;
      }
      
      public void onAnimationEnd(Animator param1Animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = null;
        actionBarOverlayLayout.b = false;
      }
    };
  
  private int f;
  
  private int g = 0;
  
  private ContentFrameLayout h;
  
  private aj i;
  
  private Drawable j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private final Rect q = new Rect();
  
  private final Rect r = new Rect();
  
  private final Rect s = new Rect();
  
  private final Rect t = new Rect();
  
  private final Rect u = new Rect();
  
  private final Rect v = new Rect();
  
  private final Rect w = new Rect();
  
  private a x;
  
  private OverScroller y;
  
  private final Runnable z = new Runnable(this) {
      public void run() {
        this.a.d();
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = actionBarOverlayLayout.a.animate().translationY(0.0F).setListener(this.a.d);
      }
    };
  
  static  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = a.a.actionBarSize;
    arrayOfInt[1] = 16842841;
    e = arrayOfInt;
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.B = new o(this);
  }
  
  private aj a(View paramView) {
    if (paramView instanceof aj)
      return (aj)paramView; 
    if (paramView instanceof Toolbar)
      return ((Toolbar)paramView).getWrapper(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't make a decor toolbar out of ");
    stringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void a(Context paramContext) {
    boolean bool;
    TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(e);
    this.f = typedArray.getDimensionPixelSize(0, 0);
    this.j = typedArray.getDrawable(1);
    if (this.j == null) {
      bool = true;
    } else {
      bool = false;
    } 
    setWillNotDraw(bool);
    typedArray.recycle();
    int i1 = (paramContext.getApplicationInfo()).targetSdkVersion;
    boolean bool1 = false;
    if (i1 < 19)
      bool1 = true; 
    this.k = bool1;
    this.y = new OverScroller(paramContext);
  }
  
  private boolean a(float paramFloat1, float paramFloat2) {
    this.y.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    return (this.y.getFinalY() > this.a.getHeight());
  }
  
  private boolean a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    boolean bool;
    b b1 = (b)paramView.getLayoutParams();
    if (paramBoolean1 && b1.leftMargin != paramRect.left) {
      b1.leftMargin = paramRect.left;
      bool = true;
    } else {
      bool = false;
    } 
    if (paramBoolean2 && b1.topMargin != paramRect.top) {
      b1.topMargin = paramRect.top;
      bool = true;
    } 
    if (paramBoolean4 && b1.rightMargin != paramRect.right) {
      b1.rightMargin = paramRect.right;
      bool = true;
    } 
    if (paramBoolean3 && b1.bottomMargin != paramRect.bottom) {
      b1.bottomMargin = paramRect.bottom;
      bool = true;
    } 
    return bool;
  }
  
  private void l() {
    d();
    postDelayed(this.z, 600L);
  }
  
  private void m() {
    d();
    postDelayed(this.A, 600L);
  }
  
  private void n() {
    d();
    this.z.run();
  }
  
  private void o() {
    d();
    this.A.run();
  }
  
  public b a(AttributeSet paramAttributeSet) { return new b(getContext(), paramAttributeSet); }
  
  public void a(int paramInt) {
    c();
    if (paramInt != 2) {
      if (paramInt != 5) {
        if (paramInt != 109)
          return; 
        setOverlayMode(true);
        return;
      } 
      this.i.g();
      return;
    } 
    this.i.f();
  }
  
  public void a(Menu paramMenu, o.a parama) {
    c();
    this.i.a(paramMenu, parama);
  }
  
  public boolean a() { return this.l; }
  
  protected b b() { return new b(-1, -1); }
  
  void c() {
    if (this.h == null) {
      this.h = (ContentFrameLayout)findViewById(a.f.action_bar_activity_content);
      this.a = (ActionBarContainer)findViewById(a.f.action_bar_container);
      this.i = a(findViewById(a.f.action_bar));
    } 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return paramLayoutParams instanceof b; }
  
  void d() {
    removeCallbacks(this.z);
    removeCallbacks(this.A);
    ViewPropertyAnimator viewPropertyAnimator = this.c;
    if (viewPropertyAnimator != null)
      viewPropertyAnimator.cancel(); 
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    if (this.j != null && !this.k) {
      int i1;
      if (this.a.getVisibility() == 0) {
        i1 = (int)(0.5F + this.a.getBottom() + this.a.getTranslationY());
      } else {
        i1 = 0;
      } 
      this.j.setBounds(0, i1, getWidth(), i1 + this.j.getIntrinsicHeight());
      this.j.draw(paramCanvas);
    } 
  }
  
  public boolean e() {
    c();
    return this.i.h();
  }
  
  public boolean f() {
    c();
    return this.i.i();
  }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    c();
    0x100 & r.o(this);
    boolean bool = a(this.a, paramRect, true, true, false, true);
    this.t.set(paramRect);
    bu.a(this, this.t, this.q);
    if (!this.u.equals(this.t)) {
      this.u.set(this.t);
      bool = true;
    } 
    if (!this.r.equals(this.q)) {
      this.r.set(this.q);
      bool = true;
    } 
    if (bool)
      requestLayout(); 
    return true;
  }
  
  public boolean g() {
    c();
    return this.i.j();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return new b(paramLayoutParams); }
  
  public int getActionBarHideOffset() {
    ActionBarContainer actionBarContainer = this.a;
    return (actionBarContainer != null) ? -((int)actionBarContainer.getTranslationY()) : 0;
  }
  
  public int getNestedScrollAxes() { return this.B.a(); }
  
  public CharSequence getTitle() {
    c();
    return this.i.e();
  }
  
  public boolean h() {
    c();
    return this.i.k();
  }
  
  public boolean i() {
    c();
    return this.i.l();
  }
  
  public void j() {
    c();
    this.i.m();
  }
  
  public void k() {
    c();
    this.i.n();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    a(getContext());
    r.p(this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    d();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i1 = getChildCount();
    int i2 = getPaddingLeft();
    getPaddingRight();
    int i3 = getPaddingTop();
    getPaddingBottom();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        b b2 = (b)view.getLayoutParams();
        int i4 = view.getMeasuredWidth();
        int i5 = view.getMeasuredHeight();
        int i6 = i2 + b2.leftMargin;
        int i7 = i3 + b2.topMargin;
        view.layout(i6, i7, i4 + i6, i5 + i7);
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    Rect rect;
    int i4;
    boolean bool;
    c();
    measureChildWithMargins(this.a, paramInt1, 0, paramInt2, 0);
    b b1 = (b)this.a.getLayoutParams();
    int i1 = Math.max(0, this.a.getMeasuredWidth() + b1.leftMargin + b1.rightMargin);
    int i2 = Math.max(0, this.a.getMeasuredHeight() + b1.topMargin + b1.bottomMargin);
    int i3 = View.combineMeasuredStates(0, this.a.getMeasuredState());
    if ((0x100 & r.o(this)) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      i4 = this.f;
      if (this.m && this.a.getTabContainer() != null)
        i4 += this.f; 
    } else if (this.a.getVisibility() != 8) {
      i4 = this.a.getMeasuredHeight();
    } else {
      i4 = 0;
    } 
    this.s.set(this.q);
    this.v.set(this.t);
    if (!this.l && !bool) {
      Rect rect1 = this.s;
      rect1.top = i4 + rect1.top;
      rect = this.s;
    } else {
      Rect rect1 = this.v;
      rect1.top = i4 + rect1.top;
      rect = this.v;
    } 
    rect.bottom = 0 + rect.bottom;
    a(this.h, this.s, true, true, true, true);
    if (!this.w.equals(this.v)) {
      this.w.set(this.v);
      this.h.a(this.v);
    } 
    measureChildWithMargins(this.h, paramInt1, 0, paramInt2, 0);
    b b2 = (b)this.h.getLayoutParams();
    int i5 = Math.max(i1, this.h.getMeasuredWidth() + b2.leftMargin + b2.rightMargin);
    int i6 = Math.max(i2, this.h.getMeasuredHeight() + b2.topMargin + b2.bottomMargin);
    int i7 = View.combineMeasuredStates(i3, this.h.getMeasuredState());
    int i8 = i5 + getPaddingLeft() + getPaddingRight();
    int i9 = Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumWidth()), paramInt1, i7), View.resolveSizeAndState(i9, paramInt2, i7 << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (!this.n || !paramBoolean)
      return false; 
    if (a(paramFloat1, paramFloat2)) {
      o();
    } else {
      n();
    } 
    this.b = true;
    return true;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) { return false; }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.o = paramInt2 + this.o;
    setActionBarHideOffset(this.o);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.B.a(paramView1, paramView2, paramInt);
    this.o = getActionBarHideOffset();
    d();
    a a1 = this.x;
    if (a1 != null)
      a1.l(); 
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) { return ((paramInt & 0x2) == 0 || this.a.getVisibility() != 0) ? false : this.n; }
  
  public void onStopNestedScroll(View paramView) {
    if (this.n && !this.b)
      if (this.o <= this.a.getHeight()) {
        l();
      } else {
        m();
      }  
    a a1 = this.x;
    if (a1 != null)
      a1.m(); 
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt) {
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 16)
      super.onWindowSystemUiVisibilityChanged(paramInt); 
    c();
    int i1 = paramInt ^ this.p;
    this.p = paramInt;
    if ((paramInt & 0x4) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int i2 = paramInt & 0x100;
    boolean bool2 = false;
    if (i2 != 0)
      bool2 = true; 
    a a1 = this.x;
    if (a1 != null) {
      a1.h(bool2 ^ true);
      if (bool1 || !bool2) {
        this.x.j();
      } else {
        this.x.k();
      } 
    } 
    if ((i1 & 0x100) != 0 && this.x != null)
      r.p(this); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    this.g = paramInt;
    a a1 = this.x;
    if (a1 != null)
      a1.a(paramInt); 
  }
  
  public void setActionBarHideOffset(int paramInt) {
    d();
    int i1 = Math.max(0, Math.min(paramInt, this.a.getHeight()));
    this.a.setTranslationY(-i1);
  }
  
  public void setActionBarVisibilityCallback(a parama) {
    this.x = parama;
    if (getWindowToken() != null) {
      this.x.a(this.g);
      int i1 = this.p;
      if (i1 != 0) {
        onWindowSystemUiVisibilityChanged(i1);
        r.p(this);
      } 
    } 
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean) { this.m = paramBoolean; }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean) {
    if (paramBoolean != this.n) {
      this.n = paramBoolean;
      if (!paramBoolean) {
        d();
        setActionBarHideOffset(0);
      } 
    } 
  }
  
  public void setIcon(int paramInt) {
    c();
    this.i.a(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable) {
    c();
    this.i.a(paramDrawable);
  }
  
  public void setLogo(int paramInt) {
    c();
    this.i.b(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean) {
    boolean bool;
    this.l = paramBoolean;
    if (paramBoolean && (getContext().getApplicationInfo()).targetSdkVersion < 19) {
      bool = true;
    } else {
      bool = false;
    } 
    this.k = bool;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback) {
    c();
    this.i.a(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence) {
    c();
    this.i.a(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState() { return false; }
  
  public static interface a {
    void a(int param1Int);
    
    void h(boolean param1Boolean);
    
    void j();
    
    void k();
    
    void l();
    
    void m();
  }
  
  public static class b extends ViewGroup.MarginLayoutParams {
    public b(int param1Int1, int param1Int2) { super(param1Int1, param1Int2); }
    
    public b(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    public b(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */