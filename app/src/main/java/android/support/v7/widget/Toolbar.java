package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.h.a;
import android.support.v4.h.d;
import android.support.v4.h.g;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.c.a.a;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
  private int A;
  
  private int B;
  
  private boolean C;
  
  private boolean D;
  
  private final ArrayList<View> E = new ArrayList();
  
  private final ArrayList<View> F = new ArrayList();
  
  private final int[] G = new int[2];
  
  private final ActionMenuView.e H = new ActionMenuView.e(this) {
      public boolean a(MenuItem param1MenuItem) { return (this.a.e != null) ? this.a.e.a(param1MenuItem) : 0; }
    };
  
  private bn I;
  
  private c J;
  
  private a K;
  
  private o.a L;
  
  private h.a M;
  
  private boolean N;
  
  private final Runnable O = new Runnable(this) {
      public void run() { this.a.d(); }
    };
  
  private ActionMenuView a;
  
  ImageButton b;
  
  View c;
  
  int d;
  
  c e;
  
  private TextView f;
  
  private TextView g;
  
  private ImageButton h;
  
  private ImageView i;
  
  private Drawable j;
  
  private CharSequence k;
  
  private Context l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private bc u;
  
  private int v;
  
  private int w;
  
  private int x = 8388627;
  
  private CharSequence y;
  
  private CharSequence z;
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.toolbarStyle); }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    bm bm = bm.a(getContext(), paramAttributeSet, a.j.Toolbar, paramInt, 0);
    this.n = bm.g(a.j.Toolbar_titleTextAppearance, 0);
    this.o = bm.g(a.j.Toolbar_subtitleTextAppearance, 0);
    this.x = bm.c(a.j.Toolbar_android_gravity, this.x);
    this.d = bm.c(a.j.Toolbar_buttonGravity, 48);
    int i1 = bm.d(a.j.Toolbar_titleMargin, 0);
    if (bm.g(a.j.Toolbar_titleMargins))
      i1 = bm.d(a.j.Toolbar_titleMargins, i1); 
    this.t = i1;
    this.s = i1;
    this.r = i1;
    this.q = i1;
    int i2 = bm.d(a.j.Toolbar_titleMarginStart, -1);
    if (i2 >= 0)
      this.q = i2; 
    int i3 = bm.d(a.j.Toolbar_titleMarginEnd, -1);
    if (i3 >= 0)
      this.r = i3; 
    int i4 = bm.d(a.j.Toolbar_titleMarginTop, -1);
    if (i4 >= 0)
      this.s = i4; 
    int i5 = bm.d(a.j.Toolbar_titleMarginBottom, -1);
    if (i5 >= 0)
      this.t = i5; 
    this.p = bm.e(a.j.Toolbar_maxButtonHeight, -1);
    int i6 = bm.d(a.j.Toolbar_contentInsetStart, -2147483648);
    int i7 = bm.d(a.j.Toolbar_contentInsetEnd, -2147483648);
    int i8 = bm.e(a.j.Toolbar_contentInsetLeft, 0);
    int i9 = bm.e(a.j.Toolbar_contentInsetRight, 0);
    s();
    this.u.b(i8, i9);
    if (i6 != Integer.MIN_VALUE || i7 != Integer.MIN_VALUE)
      this.u.a(i6, i7); 
    this.v = bm.d(a.j.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.w = bm.d(a.j.Toolbar_contentInsetEndWithActions, -2147483648);
    this.j = bm.a(a.j.Toolbar_collapseIcon);
    this.k = bm.c(a.j.Toolbar_collapseContentDescription);
    CharSequence charSequence1 = bm.c(a.j.Toolbar_title);
    if (!TextUtils.isEmpty(charSequence1))
      setTitle(charSequence1); 
    CharSequence charSequence2 = bm.c(a.j.Toolbar_subtitle);
    if (!TextUtils.isEmpty(charSequence2))
      setSubtitle(charSequence2); 
    this.l = getContext();
    setPopupTheme(bm.g(a.j.Toolbar_popupTheme, 0));
    Drawable drawable1 = bm.a(a.j.Toolbar_navigationIcon);
    if (drawable1 != null)
      setNavigationIcon(drawable1); 
    CharSequence charSequence3 = bm.c(a.j.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(charSequence3))
      setNavigationContentDescription(charSequence3); 
    Drawable drawable2 = bm.a(a.j.Toolbar_logo);
    if (drawable2 != null)
      setLogo(drawable2); 
    CharSequence charSequence4 = bm.c(a.j.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(charSequence4))
      setLogoDescription(charSequence4); 
    if (bm.g(a.j.Toolbar_titleTextColor))
      setTitleTextColor(bm.b(a.j.Toolbar_titleTextColor, -1)); 
    if (bm.g(a.j.Toolbar_subtitleTextColor))
      setSubtitleTextColor(bm.b(a.j.Toolbar_subtitleTextColor, -1)); 
    bm.a();
  }
  
  private int a(int paramInt) {
    int i1 = paramInt & 0x70;
    if (i1 != 16 && i1 != 48 && i1 != 80)
      i1 = 0x70 & this.x; 
    return i1;
  }
  
  private int a(View paramView, int paramInt) {
    int i2;
    b b1 = (b)paramView.getLayoutParams();
    int i1 = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      i2 = (i1 - paramInt) / 2;
    } else {
      i2 = 0;
    } 
    int i3 = a(b1.a);
    if (i3 != 48) {
      if (i3 != 80) {
        int i4 = getPaddingTop();
        int i5 = getPaddingBottom();
        int i6 = getHeight();
        int i7 = (i6 - i4 - i5 - i1) / 2;
        if (i7 < b1.topMargin) {
          i7 = b1.topMargin;
        } else {
          int i8 = i6 - i5 - i1 - i7 - i4;
          if (i8 < b1.bottomMargin)
            i7 = Math.max(0, i7 - b1.bottomMargin - i8); 
        } 
        return i4 + i7;
      } 
      return getHeight() - getPaddingBottom() - i1 - b1.bottomMargin - i2;
    } 
    return getPaddingTop() - i2;
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = marginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = marginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, paramInt2 + i3 + getPaddingLeft() + getPaddingRight(), marginLayoutParams.width), getChildMeasureSpec(paramInt3, paramInt4 + getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
    return i3 + paramView.getMeasuredWidth();
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2) {
    b b1 = (b)paramView.getLayoutParams();
    int i1 = b1.leftMargin - paramArrayOfInt[0];
    int i2 = paramInt1 + Math.max(0, i1);
    paramArrayOfInt[0] = Math.max(0, -i1);
    int i3 = a(paramView, paramInt2);
    int i4 = paramView.getMeasuredWidth();
    paramView.layout(i2, i3, i2 + i4, i3 + paramView.getMeasuredHeight());
    return i2 + i4 + b1.rightMargin;
  }
  
  private int a(List<View> paramList, int[] paramArrayOfInt) {
    int i1 = paramArrayOfInt[0];
    int i2 = paramArrayOfInt[1];
    int i3 = paramList.size();
    int i4 = i2;
    int i5 = i1;
    byte b1 = 0;
    int i6 = 0;
    while (b1 < i3) {
      View view = (View)paramList.get(b1);
      b b2 = (b)view.getLayoutParams();
      int i7 = b2.leftMargin - i5;
      int i8 = b2.rightMargin - i4;
      int i9 = Math.max(0, i7);
      int i10 = Math.max(0, i8);
      int i11 = Math.max(0, -i7);
      int i12 = Math.max(0, -i8);
      i6 += i10 + i9 + view.getMeasuredWidth();
      b1++;
      i4 = i12;
      i5 = i11;
    } 
    return i6;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, paramInt2 + getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
    int i2 = getChildMeasureSpec(paramInt3, paramInt4 + getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
    int i3 = View.MeasureSpec.getMode(i2);
    if (i3 != 1073741824 && paramInt5 >= 0) {
      if (i3 != 0)
        paramInt5 = Math.min(View.MeasureSpec.getSize(i2), paramInt5); 
      i2 = View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824);
    } 
    paramView.measure(i1, i2);
  }
  
  private void a(View paramView, boolean paramBoolean) {
    b b1;
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (layoutParams == null) {
      b1 = j();
    } else if (!checkLayoutParams(layoutParams)) {
      b1 = a(layoutParams);
    } else {
      b1 = (b)layoutParams;
    } 
    b1.b = 1;
    if (paramBoolean && this.c != null) {
      paramView.setLayoutParams(b1);
      this.F.add(paramView);
      return;
    } 
    addView(paramView, b1);
  }
  
  private void a(List<View> paramList, int paramInt) {
    boolean bool;
    if (r.f(this) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int i1 = getChildCount();
    int i2 = d.a(paramInt, r.f(this));
    paramList.clear();
    byte b1 = 0;
    if (bool) {
      for (int i3 = i1 - 1; i3 >= 0; i3--) {
        View view = getChildAt(i3);
        b b2 = (b)view.getLayoutParams();
        if (b2.b == 0 && a(view) && b(b2.a) == i2)
          paramList.add(view); 
      } 
    } else {
      while (b1 < i1) {
        View view = getChildAt(b1);
        b b2 = (b)view.getLayoutParams();
        if (b2.b == 0 && a(view) && b(b2.a) == i2)
          paramList.add(view); 
        b1++;
      } 
    } 
  }
  
  private boolean a(View paramView) { return (paramView != null && paramView.getParent() == this && paramView.getVisibility() != 8); }
  
  private int b(int paramInt) {
    int i1 = r.f(this);
    int i2 = 0x7 & d.a(paramInt, i1);
    if (i2 != 1) {
      byte b1 = 3;
      if (i2 != b1 && i2 != 5) {
        if (i1 == 1)
          b1 = 5; 
        return b1;
      } 
    } 
    return i2;
  }
  
  private int b(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return g.a(marginLayoutParams) + g.b(marginLayoutParams);
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2) {
    b b1 = (b)paramView.getLayoutParams();
    int i1 = b1.rightMargin - paramArrayOfInt[1];
    int i2 = paramInt1 - Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    int i3 = a(paramView, paramInt2);
    int i4 = paramView.getMeasuredWidth();
    paramView.layout(i2 - i4, i3, i2, i3 + paramView.getMeasuredHeight());
    return i2 - i4 + b1.leftMargin;
  }
  
  private int c(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
  }
  
  private boolean d(View paramView) { return (paramView.getParent() == this || this.F.contains(paramView)); }
  
  private MenuInflater getMenuInflater() { return new g(getContext()); }
  
  private void m() {
    if (this.i == null)
      this.i = new q(getContext()); 
  }
  
  private void n() {
    o();
    if (this.a.d() == null) {
      h h1 = (h)this.a.getMenu();
      if (this.K == null)
        this.K = new a(this); 
      this.a.setExpandedActionViewsExclusive(true);
      h1.a(this.K, this.l);
    } 
  }
  
  private void o() {
    if (this.a == null) {
      this.a = new ActionMenuView(getContext());
      this.a.setPopupTheme(this.m);
      this.a.setOnMenuItemClickListener(this.H);
      this.a.a(this.L, this.M);
      b b1 = j();
      b1.a = 0x800005 | 0x70 & this.d;
      this.a.setLayoutParams(b1);
      a(this.a, false);
    } 
  }
  
  private void p() {
    if (this.h == null) {
      this.h = new o(getContext(), null, a.a.toolbarNavigationButtonStyle);
      b b1 = j();
      b1.a = 0x800003 | 0x70 & this.d;
      this.h.setLayoutParams(b1);
    } 
  }
  
  private void q() {
    removeCallbacks(this.O);
    post(this.O);
  }
  
  private boolean r() {
    if (!this.N)
      return false; 
    int i1 = getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      if (a(view) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0)
        return false; 
    } 
    return true;
  }
  
  private void s() {
    if (this.u == null)
      this.u = new bc(); 
  }
  
  public b a(AttributeSet paramAttributeSet) { return new b(getContext(), paramAttributeSet); }
  
  protected b a(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams instanceof b) ? new b((b)paramLayoutParams) : ((paramLayoutParams instanceof a.a) ? new b((a.a)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new b((ViewGroup.MarginLayoutParams)paramLayoutParams) : new b(paramLayoutParams))); }
  
  public void a(int paramInt1, int paramInt2) {
    s();
    this.u.a(paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, int paramInt) {
    this.n = paramInt;
    TextView textView = this.f;
    if (textView != null)
      textView.setTextAppearance(paramContext, paramInt); 
  }
  
  public void a(h paramh, c paramc) {
    if (paramh == null && this.a == null)
      return; 
    o();
    h h1 = this.a.d();
    if (h1 == paramh)
      return; 
    if (h1 != null) {
      h1.b(this.J);
      h1.b(this.K);
    } 
    if (this.K == null)
      this.K = new a(this); 
    paramc.d(true);
    if (paramh != null) {
      paramh.a(paramc, this.l);
      paramh.a(this.K, this.l);
    } else {
      paramc.a(this.l, null);
      this.K.a(this.l, null);
      paramc.b(true);
      this.K.b(true);
    } 
    this.a.setPopupTheme(this.m);
    this.a.setPresenter(paramc);
    this.J = paramc;
  }
  
  public void a(o.a parama, h.a parama1) {
    this.L = parama;
    this.M = parama1;
    ActionMenuView actionMenuView = this.a;
    if (actionMenuView != null)
      actionMenuView.a(parama, parama1); 
  }
  
  public boolean a() {
    if (getVisibility() == 0) {
      ActionMenuView actionMenuView = this.a;
      if (actionMenuView != null && actionMenuView.a())
        return true; 
    } 
    return false;
  }
  
  public void b(Context paramContext, int paramInt) {
    this.o = paramInt;
    TextView textView = this.g;
    if (textView != null)
      textView.setTextAppearance(paramContext, paramInt); 
  }
  
  public boolean b() {
    ActionMenuView actionMenuView = this.a;
    return (actionMenuView != null && actionMenuView.g());
  }
  
  public boolean c() {
    ActionMenuView actionMenuView = this.a;
    return (actionMenuView != null && actionMenuView.h());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return (super.checkLayoutParams(paramLayoutParams) && paramLayoutParams instanceof b); }
  
  public boolean d() {
    ActionMenuView actionMenuView = this.a;
    return (actionMenuView != null && actionMenuView.e());
  }
  
  public boolean e() {
    ActionMenuView actionMenuView = this.a;
    return (actionMenuView != null && actionMenuView.f());
  }
  
  public void f() {
    ActionMenuView actionMenuView = this.a;
    if (actionMenuView != null)
      actionMenuView.i(); 
  }
  
  public boolean g() {
    a a1 = this.K;
    return (a1 != null && a1.b != null);
  }
  
  public int getContentInsetEnd() {
    bc bc1 = this.u;
    return (bc1 != null) ? bc1.d() : 0;
  }
  
  public int getContentInsetEndWithActions() {
    int i1 = this.w;
    return (i1 != Integer.MIN_VALUE) ? i1 : getContentInsetEnd();
  }
  
  public int getContentInsetLeft() {
    bc bc1 = this.u;
    return (bc1 != null) ? bc1.a() : 0;
  }
  
  public int getContentInsetRight() {
    bc bc1 = this.u;
    return (bc1 != null) ? bc1.b() : 0;
  }
  
  public int getContentInsetStart() {
    bc bc1 = this.u;
    return (bc1 != null) ? bc1.c() : 0;
  }
  
  public int getContentInsetStartWithNavigation() {
    int i1 = this.v;
    return (i1 != Integer.MIN_VALUE) ? i1 : getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd() { // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroid/support/v7/widget/ActionMenuView;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull -> 30
    //   9: aload_1
    //   10: invokevirtual d : ()Landroid/support/v7/view/menu/h;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -> 30
    //   18: aload_3
    //   19: invokevirtual hasVisibleItems : ()Z
    //   22: ifeq -> 30
    //   25: iconst_1
    //   26: istore_2
    //   27: goto -> 32
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq -> 52
    //   36: aload_0
    //   37: invokevirtual getContentInsetEnd : ()I
    //   40: aload_0
    //   41: getfield w : I
    //   44: iconst_0
    //   45: invokestatic max : (II)I
    //   48: invokestatic max : (II)I
    //   51: ireturn
    //   52: aload_0
    //   53: invokevirtual getContentInsetEnd : ()I
    //   56: ireturn }
  
  public int getCurrentContentInsetLeft() { return (r.f(this) == 1) ? getCurrentContentInsetEnd() : getCurrentContentInsetStart(); }
  
  public int getCurrentContentInsetRight() { return (r.f(this) == 1) ? getCurrentContentInsetStart() : getCurrentContentInsetEnd(); }
  
  public int getCurrentContentInsetStart() { return (getNavigationIcon() != null) ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart(); }
  
  public Drawable getLogo() {
    ImageView imageView = this.i;
    return (imageView != null) ? imageView.getDrawable() : null;
  }
  
  public CharSequence getLogoDescription() {
    ImageView imageView = this.i;
    return (imageView != null) ? imageView.getContentDescription() : null;
  }
  
  public Menu getMenu() {
    n();
    return this.a.getMenu();
  }
  
  public CharSequence getNavigationContentDescription() {
    ImageButton imageButton = this.h;
    return (imageButton != null) ? imageButton.getContentDescription() : null;
  }
  
  public Drawable getNavigationIcon() {
    ImageButton imageButton = this.h;
    return (imageButton != null) ? imageButton.getDrawable() : null;
  }
  
  c getOuterActionMenuPresenter() { return this.J; }
  
  public Drawable getOverflowIcon() {
    n();
    return this.a.getOverflowIcon();
  }
  
  Context getPopupContext() { return this.l; }
  
  public int getPopupTheme() { return this.m; }
  
  public CharSequence getSubtitle() { return this.z; }
  
  public CharSequence getTitle() { return this.y; }
  
  public int getTitleMarginBottom() { return this.t; }
  
  public int getTitleMarginEnd() { return this.r; }
  
  public int getTitleMarginStart() { return this.q; }
  
  public int getTitleMarginTop() { return this.s; }
  
  public aj getWrapper() {
    if (this.I == null)
      this.I = new bn(this, true); 
    return this.I;
  }
  
  public void h() {
    j j1;
    a a1 = this.K;
    if (a1 == null) {
      j1 = null;
    } else {
      j1 = a1.b;
    } 
    if (j1 != null)
      j1.collapseActionView(); 
  }
  
  void i() {
    if (this.b == null) {
      this.b = new o(getContext(), null, a.a.toolbarNavigationButtonStyle);
      this.b.setImageDrawable(this.j);
      this.b.setContentDescription(this.k);
      b b1 = j();
      b1.a = 0x800003 | 0x70 & this.d;
      b1.b = 2;
      this.b.setLayoutParams(b1);
      this.b.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) { this.a.h(); }
          });
    } 
  }
  
  protected b j() { return new b(-2, -2); }
  
  void k() {
    for (int i1 = -1 + getChildCount(); i1 >= 0; i1--) {
      View view = getChildAt(i1);
      if (((b)view.getLayoutParams()).b != 2 && view != this.a) {
        removeViewAt(i1);
        this.F.add(view);
      } 
    } 
  }
  
  void l() {
    for (int i1 = -1 + this.F.size(); i1 >= 0; i1--)
      addView((View)this.F.get(i1)); 
    this.F.clear();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    removeCallbacks(this.O);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 9)
      this.D = false; 
    if (!this.D) {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if (i1 == 9 && !bool)
        this.D = true; 
    } 
    if (i1 == 10 || i1 == 3)
      this.D = false; 
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i15;
    int i10;
    int i9;
    byte b1;
    boolean bool1;
    if (r.f(this) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int i1 = getWidth();
    int i2 = getHeight();
    int i3 = getPaddingLeft();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int i6 = getPaddingBottom();
    int i7 = i1 - i4;
    int[] arrayOfInt = this.G;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    int i8 = r.k(this);
    if (i8 >= 0) {
      b1 = Math.min(i8, paramInt4 - paramInt2);
    } else {
      b1 = 0;
    } 
    if (a(this.h)) {
      if (bool1) {
        i10 = b(this.h, i7, arrayOfInt, b1);
        i9 = i3;
      } else {
        i9 = a(this.h, i3, arrayOfInt, b1);
        i10 = i7;
      } 
    } else {
      i9 = i3;
      i10 = i7;
    } 
    if (a(this.b))
      if (bool1) {
        i10 = b(this.b, i10, arrayOfInt, b1);
      } else {
        i9 = a(this.b, i9, arrayOfInt, b1);
      }  
    if (a(this.a))
      if (bool1) {
        i9 = a(this.a, i9, arrayOfInt, b1);
      } else {
        i10 = b(this.a, i10, arrayOfInt, b1);
      }  
    int i11 = getCurrentContentInsetLeft();
    int i12 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, i11 - i9);
    arrayOfInt[1] = Math.max(0, i12 - i7 - i10);
    int i13 = Math.max(i9, i11);
    int i14 = Math.min(i10, i7 - i12);
    if (a(this.c))
      if (bool1) {
        i14 = b(this.c, i14, arrayOfInt, b1);
      } else {
        i13 = a(this.c, i13, arrayOfInt, b1);
      }  
    if (a(this.i))
      if (bool1) {
        i14 = b(this.i, i14, arrayOfInt, b1);
      } else {
        i13 = a(this.i, i13, arrayOfInt, b1);
      }  
    boolean bool2 = a(this.f);
    boolean bool3 = a(this.g);
    if (bool2) {
      b b2 = (b)this.f.getLayoutParams();
      int i19 = b2.topMargin;
      int i18 = i4;
      i15 = 0 + i19 + this.f.getMeasuredHeight() + b2.bottomMargin;
    } else {
      int i18 = i4;
      i15 = 0;
    } 
    if (bool3) {
      b b2 = (b)this.g.getLayoutParams();
      int i19 = b2.topMargin;
      int i18 = i1;
      i15 += i19 + this.g.getMeasuredHeight() + b2.bottomMargin;
    } else {
      int i18 = i1;
    } 
    if (bool2 || bool3) {
      int i20;
      int i19;
      boolean bool;
      TextView textView2;
      TextView textView1;
      if (bool2) {
        textView1 = this.f;
      } else {
        textView1 = this.g;
      } 
      if (bool3) {
        textView2 = this.g;
      } else {
        textView2 = this.f;
      } 
      b b2 = (b)textView1.getLayoutParams();
      b b3 = (b)textView2.getLayoutParams();
      if ((bool2 && this.f.getMeasuredWidth() > 0) || (bool3 && this.g.getMeasuredWidth() > 0)) {
        int i21 = i3;
        bool = true;
      } else {
        int i21 = i3;
        bool = false;
      } 
      int i18 = 0x70 & this.x;
      byte b4 = b1;
      if (i18 != 48) {
        if (i18 != 80) {
          int i21 = (i2 - i5 - i6 - i15) / 2;
          int i22 = b2.topMargin;
          i19 = i13;
          if (i21 < i22 + this.s) {
            i21 = b2.topMargin + this.s;
          } else {
            int i23 = i2 - i6 - i15 - i21 - i5;
            if (i23 < b2.bottomMargin + this.t)
              i21 = Math.max(0, i21 - b3.bottomMargin + this.t - i23); 
          } 
          i20 = i5 + i21;
        } else {
          i19 = i13;
          i20 = i2 - i6 - b3.bottomMargin - this.t - i15;
        } 
      } else {
        i19 = i13;
        i20 = getPaddingTop() + b2.topMargin + this.s;
      } 
      if (bool1) {
        int i24;
        int i23;
        int i21;
        boolean bool6;
        if (bool) {
          i21 = this.q;
          bool6 = true;
        } else {
          bool6 = true;
          i21 = 0;
        } 
        int i22 = i21 - arrayOfInt[bool6];
        i14 -= Math.max(0, i22);
        arrayOfInt[bool6] = Math.max(0, -i22);
        if (bool2) {
          b b5 = (b)this.f.getLayoutParams();
          int i25 = i14 - this.f.getMeasuredWidth();
          int i26 = i20 + this.f.getMeasuredHeight();
          this.f.layout(i25, i20, i14, i26);
          i23 = i25 - this.r;
          i20 = i26 + b5.bottomMargin;
        } else {
          i23 = i14;
        } 
        if (bool3) {
          b b5 = (b)this.g.getLayoutParams();
          int i25 = i20 + b5.topMargin;
          int i26 = i14 - this.g.getMeasuredWidth();
          int i27 = i25 + this.g.getMeasuredHeight();
          this.g.layout(i26, i25, i14, i27);
          i24 = i14 - this.r;
          b5.bottomMargin;
        } else {
          i24 = i14;
        } 
        if (bool)
          i14 = Math.min(i23, i24); 
        i13 = i19;
      } else {
        int i24;
        int i23;
        int i21;
        if (bool) {
          i21 = this.q;
        } else {
          i21 = 0;
        } 
        boolean bool6 = false;
        int i22 = i21 - arrayOfInt[0];
        i13 = i19 + Math.max(0, i22);
        arrayOfInt[0] = Math.max(0, -i22);
        if (bool2) {
          b b5 = (b)this.f.getLayoutParams();
          int i27 = i13 + this.f.getMeasuredWidth();
          int i28 = i20 + this.f.getMeasuredHeight();
          this.f.layout(i13, i20, i27, i28);
          i23 = i27 + this.r;
          i20 = i28 + b5.bottomMargin;
        } else {
          i23 = i13;
        } 
        if (bool3) {
          b b5 = (b)this.g.getLayoutParams();
          int i27 = i20 + b5.topMargin;
          int i28 = i13 + this.g.getMeasuredWidth();
          int i29 = i27 + this.g.getMeasuredHeight();
          this.g.layout(i13, i27, i28, i29);
          i24 = i28 + this.r;
          b5.bottomMargin;
        } else {
          i24 = i13;
        } 
        if (bool)
          i13 = Math.max(i23, i24); 
        a(this.E, 3);
        int i25 = this.E.size();
        int i26 = i13;
        boolean bool7 = false;
      } 
    } else {
      int i18 = i3;
      byte b2 = b1;
    } 
    boolean bool4 = false;
    a(this.E, 3);
    int i16 = this.E.size();
    int i17 = i13;
    boolean bool5 = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i16;
    int i15;
    int i14;
    int i6;
    int i3;
    int i2;
    int i1;
    boolean bool2;
    boolean bool1;
    int[] arrayOfInt = this.G;
    if (bu.a(this)) {
      bool1 = true;
      bool2 = false;
    } else {
      bool1 = false;
      bool2 = true;
    } 
    if (a(this.h)) {
      a(this.h, paramInt1, 0, paramInt2, 0, this.p);
      i1 = this.h.getMeasuredWidth() + b(this.h);
      int i23 = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
      int i24 = View.combineMeasuredStates(0, this.h.getMeasuredState());
      i2 = i23;
      i3 = i24;
    } else {
      i1 = 0;
      i2 = 0;
      i3 = 0;
    } 
    if (a(this.b)) {
      a(this.b, paramInt1, 0, paramInt2, 0, this.p);
      i1 = this.b.getMeasuredWidth() + b(this.b);
      i2 = Math.max(i2, this.b.getMeasuredHeight() + c(this.b));
      i3 = View.combineMeasuredStates(i3, this.b.getMeasuredState());
    } 
    int i4 = getCurrentContentInsetStart();
    int i5 = 0 + Math.max(i4, i1);
    arrayOfInt[bool1] = Math.max(0, i4 - i1);
    if (a(this.a)) {
      a(this.a, paramInt1, i5, paramInt2, 0, this.p);
      i6 = this.a.getMeasuredWidth() + b(this.a);
      i2 = Math.max(i2, this.a.getMeasuredHeight() + c(this.a));
      i3 = View.combineMeasuredStates(i3, this.a.getMeasuredState());
    } else {
      i6 = 0;
    } 
    int i7 = getCurrentContentInsetEnd();
    int i8 = i5 + Math.max(i7, i6);
    arrayOfInt[bool2] = Math.max(0, i7 - i6);
    if (a(this.c)) {
      i8 += a(this.c, paramInt1, i8, paramInt2, 0, arrayOfInt);
      i2 = Math.max(i2, this.c.getMeasuredHeight() + c(this.c));
      i3 = View.combineMeasuredStates(i3, this.c.getMeasuredState());
    } 
    if (a(this.i)) {
      i8 += a(this.i, paramInt1, i8, paramInt2, 0, arrayOfInt);
      i2 = Math.max(i2, this.i.getMeasuredHeight() + c(this.i));
      i3 = View.combineMeasuredStates(i3, this.i.getMeasuredState());
    } 
    int i9 = getChildCount();
    int i10 = i2;
    int i11 = i8;
    for (byte b1 = 0; b1 < i9; b1++) {
      View view = getChildAt(b1);
      if (((b)view.getLayoutParams()).b == 0 && a(view)) {
        i11 += a(view, paramInt1, i11, paramInt2, 0, arrayOfInt);
        int i23 = Math.max(i10, view.getMeasuredHeight() + c(view));
        int i24 = View.combineMeasuredStates(i3, view.getMeasuredState());
        i10 = i23;
        i3 = i24;
      } 
    } 
    int i12 = this.s + this.t;
    int i13 = this.q + this.r;
    if (a(this.f)) {
      a(this.f, paramInt1, i11 + i13, paramInt2, i12, arrayOfInt);
      int i23 = this.f.getMeasuredWidth() + b(this.f);
      int i24 = this.f.getMeasuredHeight() + c(this.f);
      int i25 = View.combineMeasuredStates(i3, this.f.getMeasuredState());
      i16 = i24;
      i14 = i25;
      i15 = i23;
    } else {
      i14 = i3;
      i15 = 0;
      i16 = 0;
    } 
    if (a(this.g)) {
      TextView textView = this.g;
      int i23 = i11 + i13;
      int i24 = i16 + i12;
      int i25 = i14;
      i15 = Math.max(i15, a(textView, paramInt1, i23, paramInt2, i24, arrayOfInt));
      i16 += this.g.getMeasuredHeight() + c(this.g);
      i14 = View.combineMeasuredStates(i25, this.g.getMeasuredState());
    } else {
      i14;
    } 
    int i17 = i11 + i15;
    int i18 = Math.max(i10, i16);
    int i19 = i17 + getPaddingLeft() + getPaddingRight();
    int i20 = i18 + getPaddingTop() + getPaddingBottom();
    int i21 = View.resolveSizeAndState(Math.max(i19, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i14);
    int i22 = View.resolveSizeAndState(Math.max(i20, getSuggestedMinimumHeight()), paramInt2, i14 << 16);
    if (r())
      i22 = 0; 
    setMeasuredDimension(i21, i22);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    Object object;
    if (!(paramParcelable instanceof d)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    d d1 = (d)paramParcelable;
    super.onRestoreInstanceState(d1.a());
    ActionMenuView actionMenuView = this.a;
    if (actionMenuView != null) {
      object = actionMenuView.d();
    } else {
      object = null;
    } 
    if (d1.a != 0 && this.K != null && object != null) {
      MenuItem menuItem = object.findItem(d1.a);
      if (menuItem != null)
        menuItem.expandActionView(); 
    } 
    if (d1.b)
      q(); 
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      super.onRtlPropertiesChanged(paramInt); 
    s();
    bc bc1 = this.u;
    boolean bool = true;
    if (paramInt != bool)
      bool = false; 
    bc1.a(bool);
  }
  
  protected Parcelable onSaveInstanceState() {
    d d1 = new d(super.onSaveInstanceState());
    a a1 = this.K;
    if (a1 != null && a1.b != null)
      d1.a = this.K.b.getItemId(); 
    d1.b = b();
    return d1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0)
      this.C = false; 
    if (!this.C) {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (i1 == 0 && !bool)
        this.C = true; 
    } 
    if (i1 == 1 || i1 == 3)
      this.C = false; 
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean) {
    this.N = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt) {
    if (paramInt < 0)
      paramInt = Integer.MIN_VALUE; 
    if (paramInt != this.w) {
      this.w = paramInt;
      if (getNavigationIcon() != null)
        requestLayout(); 
    } 
  }
  
  public void setContentInsetStartWithNavigation(int paramInt) {
    if (paramInt < 0)
      paramInt = Integer.MIN_VALUE; 
    if (paramInt != this.v) {
      this.v = paramInt;
      if (getNavigationIcon() != null)
        requestLayout(); 
    } 
  }
  
  public void setLogo(int paramInt) { setLogo(a.b(getContext(), paramInt)); }
  
  public void setLogo(Drawable paramDrawable) {
    if (paramDrawable != null) {
      m();
      if (!d(this.i))
        a(this.i, true); 
    } else {
      ImageView imageView1 = this.i;
      if (imageView1 != null && d(imageView1)) {
        removeView(this.i);
        this.F.remove(this.i);
      } 
    } 
    ImageView imageView = this.i;
    if (imageView != null)
      imageView.setImageDrawable(paramDrawable); 
  }
  
  public void setLogoDescription(int paramInt) { setLogoDescription(getContext().getText(paramInt)); }
  
  public void setLogoDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      m(); 
    ImageView imageView = this.i;
    if (imageView != null)
      imageView.setContentDescription(paramCharSequence); 
  }
  
  public void setNavigationContentDescription(int paramInt) {
    CharSequence charSequence;
    if (paramInt != 0) {
      charSequence = getContext().getText(paramInt);
    } else {
      charSequence = null;
    } 
    setNavigationContentDescription(charSequence);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      p(); 
    ImageButton imageButton = this.h;
    if (imageButton != null)
      imageButton.setContentDescription(paramCharSequence); 
  }
  
  public void setNavigationIcon(int paramInt) { setNavigationIcon(a.b(getContext(), paramInt)); }
  
  public void setNavigationIcon(Drawable paramDrawable) {
    if (paramDrawable != null) {
      p();
      if (!d(this.h))
        a(this.h, true); 
    } else {
      ImageButton imageButton1 = this.h;
      if (imageButton1 != null && d(imageButton1)) {
        removeView(this.h);
        this.F.remove(this.h);
      } 
    } 
    ImageButton imageButton = this.h;
    if (imageButton != null)
      imageButton.setImageDrawable(paramDrawable); 
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener) {
    p();
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(c paramc) { this.e = paramc; }
  
  public void setOverflowIcon(Drawable paramDrawable) {
    n();
    this.a.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt) {
    if (this.m != paramInt) {
      this.m = paramInt;
      if (paramInt == 0) {
        this.l = getContext();
        return;
      } 
      this.l = new ContextThemeWrapper(getContext(), paramInt);
    } 
  }
  
  public void setSubtitle(int paramInt) { setSubtitle(getContext().getText(paramInt)); }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.g == null) {
        Context context = getContext();
        this.g = new aa(context);
        this.g.setSingleLine();
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.o;
        if (i1 != 0)
          this.g.setTextAppearance(context, i1); 
        int i2 = this.B;
        if (i2 != 0)
          this.g.setTextColor(i2); 
      } 
      if (!d(this.g))
        a(this.g, true); 
    } else {
      TextView textView1 = this.g;
      if (textView1 != null && d(textView1)) {
        removeView(this.g);
        this.F.remove(this.g);
      } 
    } 
    TextView textView = this.g;
    if (textView != null)
      textView.setText(paramCharSequence); 
    this.z = paramCharSequence;
  }
  
  public void setSubtitleTextColor(int paramInt) {
    this.B = paramInt;
    TextView textView = this.g;
    if (textView != null)
      textView.setTextColor(paramInt); 
  }
  
  public void setTitle(int paramInt) { setTitle(getContext().getText(paramInt)); }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.f == null) {
        Context context = getContext();
        this.f = new aa(context);
        this.f.setSingleLine();
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.n;
        if (i1 != 0)
          this.f.setTextAppearance(context, i1); 
        int i2 = this.A;
        if (i2 != 0)
          this.f.setTextColor(i2); 
      } 
      if (!d(this.f))
        a(this.f, true); 
    } else {
      TextView textView1 = this.f;
      if (textView1 != null && d(textView1)) {
        removeView(this.f);
        this.F.remove(this.f);
      } 
    } 
    TextView textView = this.f;
    if (textView != null)
      textView.setText(paramCharSequence); 
    this.y = paramCharSequence;
  }
  
  public void setTitleMarginBottom(int paramInt) {
    this.t = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt) {
    this.r = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt) {
    this.q = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt) {
    this.s = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt) {
    this.A = paramInt;
    TextView textView = this.f;
    if (textView != null)
      textView.setTextColor(paramInt); 
  }
  
  private class a implements o {
    h a;
    
    j b;
    
    a(Toolbar this$0) {}
    
    public void a(Context param1Context, h param1h) {
      h h1 = this.a;
      if (h1 != null) {
        j j1 = this.b;
        if (j1 != null)
          h1.d(j1); 
      } 
      this.a = param1h;
    }
    
    public void a(h param1h, boolean param1Boolean) {}
    
    public void a(o.a param1a) {}
    
    public boolean a(h param1h, j param1j) {
      this.c.i();
      ViewParent viewParent1 = this.c.b.getParent();
      Toolbar toolbar1 = this.c;
      if (viewParent1 != toolbar1) {
        if (viewParent1 instanceof ViewGroup)
          ((ViewGroup)viewParent1).removeView(toolbar1.b); 
        Toolbar toolbar = this.c;
        toolbar.addView(toolbar.b);
      } 
      this.c.c = param1j.getActionView();
      this.b = param1j;
      ViewParent viewParent2 = this.c.c.getParent();
      Toolbar toolbar2 = this.c;
      if (viewParent2 != toolbar2) {
        if (viewParent2 instanceof ViewGroup)
          ((ViewGroup)viewParent2).removeView(toolbar2.c); 
        Toolbar.b b1 = this.c.j();
        b1.a = 0x800003 | 0x70 & this.c.d;
        b1.b = 2;
        this.c.c.setLayoutParams(b1);
        Toolbar toolbar = this.c;
        toolbar.addView(toolbar.c);
      } 
      this.c.k();
      this.c.requestLayout();
      param1j.e(true);
      if (this.c.c instanceof c)
        ((c)this.c.c).a(); 
      return true;
    }
    
    public boolean a(u param1u) { return false; }
    
    public void b(boolean param1Boolean) {
      if (this.b != null) {
        h h1 = this.a;
        boolean bool = false;
        if (h1 != null) {
          int i = h1.size();
          byte b1 = 0;
          while (true) {
            bool = false;
            if (b1 < i) {
              if (this.a.getItem(b1) == this.b) {
                bool = true;
                break;
              } 
              b1++;
              continue;
            } 
            break;
          } 
        } 
        if (!bool)
          b(this.a, this.b); 
      } 
    }
    
    public boolean b() { return false; }
    
    public boolean b(h param1h, j param1j) {
      if (this.c.c instanceof c)
        ((c)this.c.c).b(); 
      Toolbar toolbar1 = this.c;
      toolbar1.removeView(toolbar1.c);
      Toolbar toolbar2 = this.c;
      toolbar2.removeView(toolbar2.b);
      Toolbar toolbar3 = this.c;
      toolbar3.c = null;
      toolbar3.l();
      this.b = null;
      this.c.requestLayout();
      param1j.e(false);
      return true;
    }
  }
  
  public static class b extends a.a {
    int b = 0;
    
    public b(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.a = 8388627;
    }
    
    public b(Context param1Context, AttributeSet param1AttributeSet) { super(param1Context, param1AttributeSet); }
    
    public b(a.a param1a) { super(param1a); }
    
    public b(b param1b) {
      super(param1b);
      this.b = param1b.b;
    }
    
    public b(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public b(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
      a(param1MarginLayoutParams);
    }
    
    void a(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      this.leftMargin = param1MarginLayoutParams.leftMargin;
      this.topMargin = param1MarginLayoutParams.topMargin;
      this.rightMargin = param1MarginLayoutParams.rightMargin;
      this.bottomMargin = param1MarginLayoutParams.bottomMargin;
    }
  }
  
  public static interface c {
    boolean a(MenuItem param1MenuItem);
  }
  
  public static class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() {
        public Toolbar.d a(Parcel param2Parcel) { return new Toolbar.d(param2Parcel, null); }
        
        public Toolbar.d a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new Toolbar.d(param2Parcel, param2ClassLoader); }
        
        public Toolbar.d[] a(int param2Int) { return new Toolbar.d[param2Int]; }
      };
    
    int a;
    
    boolean b;
    
    public d(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readInt();
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.b = bool;
    }
    
    public d(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<d> {
    public Toolbar.d a(Parcel param1Parcel) { return new Toolbar.d(param1Parcel, null); }
    
    public Toolbar.d a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new Toolbar.d(param1Parcel, param1ClassLoader); }
    
    public Toolbar.d[] a(int param1Int) { return new Toolbar.d[param1Int]; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */