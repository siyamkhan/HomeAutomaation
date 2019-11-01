package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a;
import android.support.v4.a.a.f;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.a.c;
import android.support.v4.h.b;
import android.support.v4.h.r;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.support.v7.widget.as;
import android.support.v7.widget.bo;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends a implements p.a {
  private static final int[] d = { 16842912 };
  
  boolean c;
  
  private final int e;
  
  private boolean f;
  
  private final CheckedTextView g;
  
  private FrameLayout h;
  
  private j i;
  
  private ColorStateList j;
  
  private boolean k;
  
  private Drawable l;
  
  private final b m = new b(this) {
      public void a(View param1View, c param1c) {
        super.a(param1View, param1c);
        param1c.a(this.a.c);
      }
    };
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(a.h.design_navigation_menu_item, this, true);
    this.e = paramContext.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
    this.g = (CheckedTextView)findViewById(a.f.design_menu_item_text);
    this.g.setDuplicateParentStateEnabled(true);
    r.a(this.g, this.m);
  }
  
  private boolean b() { return (this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null); }
  
  private void c() {
    byte b1;
    as.a a1;
    if (b()) {
      this.g.setVisibility(8);
      FrameLayout frameLayout = this.h;
      if (frameLayout != null) {
        a1 = (as.a)frameLayout.getLayoutParams();
        b1 = -1;
      } else {
        return;
      } 
    } else {
      this.g.setVisibility(0);
      FrameLayout frameLayout = this.h;
      if (frameLayout != null) {
        a1 = (as.a)frameLayout.getLayoutParams();
        b1 = -2;
      } else {
        return;
      } 
    } 
    a1.width = b1;
    this.h.setLayoutParams(a1);
  }
  
  private StateListDrawable d() {
    TypedValue typedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(a.a.colorControlHighlight, typedValue, true)) {
      StateListDrawable stateListDrawable = new StateListDrawable();
      stateListDrawable.addState(d, new ColorDrawable(typedValue.data));
      stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return stateListDrawable;
    } 
    return null;
  }
  
  private void setActionView(View paramView) {
    if (paramView != null) {
      if (this.h == null)
        this.h = (FrameLayout)((ViewStub)findViewById(a.f.design_menu_item_action_area_stub)).inflate(); 
      this.h.removeAllViews();
      this.h.addView(paramView);
    } 
  }
  
  public void a(j paramj, int paramInt) {
    byte b1;
    this.i = paramj;
    if (paramj.isVisible()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    setVisibility(b1);
    if (getBackground() == null)
      r.a(this, d()); 
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setTitle(paramj.getTitle());
    setIcon(paramj.getIcon());
    setActionView(paramj.getActionView());
    setContentDescription(paramj.getContentDescription());
    bo.a(this, paramj.getTooltipText());
    c();
  }
  
  public boolean a() { return false; }
  
  public j getItemData() { return this.i; }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    j j1 = this.i;
    if (j1 != null && j1.isCheckable() && this.i.isChecked())
      mergeDrawableStates(arrayOfInt, d); 
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean) {
    refreshDrawableState();
    if (this.c != paramBoolean) {
      this.c = paramBoolean;
      this.m.a(this.g, 2048);
    } 
  }
  
  public void setChecked(boolean paramBoolean) {
    refreshDrawableState();
    this.g.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt) { setPadding(paramInt, 0, paramInt, 0); }
  
  public void setIcon(Drawable paramDrawable) {
    if (paramDrawable != null) {
      if (this.k) {
        Drawable.ConstantState constantState = paramDrawable.getConstantState();
        if (constantState != null)
          paramDrawable = constantState.newDrawable(); 
        paramDrawable = a.g(paramDrawable).mutate();
        a.a(paramDrawable, this.j);
      } 
      int n = this.e;
      paramDrawable.setBounds(0, 0, n, n);
    } else if (this.f) {
      if (this.l == null) {
        this.l = f.a(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
        Drawable drawable = this.l;
        if (drawable != null) {
          int n = this.e;
          drawable.setBounds(0, 0, n, n);
        } 
      } 
      paramDrawable = this.l;
    } 
    n.a(this.g, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt) { this.g.setCompoundDrawablePadding(paramInt); }
  
  void setIconTintList(ColorStateList paramColorStateList) {
    boolean bool;
    this.j = paramColorStateList;
    if (this.j != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.k = bool;
    j j1 = this.i;
    if (j1 != null)
      setIcon(j1.getIcon()); 
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean) { this.f = paramBoolean; }
  
  public void setTextAppearance(int paramInt) { n.a(this.g, paramInt); }
  
  public void setTextColor(ColorStateList paramColorStateList) { this.g.setTextColor(paramColorStateList); }
  
  public void setTitle(CharSequence paramCharSequence) { this.g.setText(paramCharSequence); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\internal\NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */