package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.aa;
import android.support.v7.widget.ap;
import android.support.v7.widget.bo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ActionMenuItemView extends aa implements p.a, ActionMenuView.a, View.OnClickListener {
  j b;
  
  h.b c;
  
  b d;
  
  private CharSequence e;
  
  private Drawable f;
  
  private ap g;
  
  private boolean h;
  
  private boolean i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = paramContext.getResources();
    this.h = e();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionMenuItemView, paramInt, 0);
    this.j = typedArray.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
    typedArray.recycle();
    this.l = (int)(0.5F + 32.0F * (resources.getDisplayMetrics()).density);
    setOnClickListener(this);
    this.k = -1;
    setSaveEnabled(false);
  }
  
  private boolean e() {
    Configuration configuration = getContext().getResources().getConfiguration();
    int m = configuration.screenWidthDp;
    int n = configuration.screenHeightDp;
    return (m >= 480 || (m >= 640 && n >= 480) || configuration.orientation == 2);
  }
  
  private void f() {
    CharSequence charSequence1;
    boolean bool1 = TextUtils.isEmpty(this.e);
    boolean bool = true;
    boolean bool2 = bool1 ^ bool;
    if (this.f != null && (!this.b.m() || (!this.h && !this.i)))
      bool = false; 
    boolean bool3 = bool2 & bool;
    if (bool3) {
      charSequence1 = this.e;
    } else {
      charSequence1 = null;
    } 
    setText(charSequence1);
    CharSequence charSequence2 = this.b.getContentDescription();
    if (TextUtils.isEmpty(charSequence2))
      if (bool3) {
        charSequence2 = null;
      } else {
        charSequence2 = this.b.getTitle();
      }  
    setContentDescription(charSequence2);
    CharSequence charSequence3 = this.b.getTooltipText();
    if (TextUtils.isEmpty(charSequence3)) {
      CharSequence charSequence;
      if (bool3) {
        charSequence = null;
      } else {
        charSequence = this.b.getTitle();
      } 
      bo.a(this, charSequence);
      return;
    } 
    bo.a(this, charSequence3);
  }
  
  public void a(j paramj, int paramInt) {
    byte b1;
    this.b = paramj;
    setIcon(paramj.getIcon());
    setTitle(paramj.a(this));
    setId(paramj.getItemId());
    if (paramj.isVisible()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    setVisibility(b1);
    setEnabled(paramj.isEnabled());
    if (paramj.hasSubMenu() && this.g == null)
      this.g = new a(this); 
  }
  
  public boolean a() { return true; }
  
  public boolean b() { return true ^ TextUtils.isEmpty(getText()); }
  
  public boolean c() { return (b() && this.b.getIcon() == null); }
  
  public boolean d() { return b(); }
  
  public j getItemData() { return this.b; }
  
  public void onClick(View paramView) {
    h.b b1 = this.c;
    if (b1 != null)
      b1.a(this.b); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.h = e();
    f();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i2;
    boolean bool = b();
    if (bool) {
      int i3 = this.k;
      if (i3 >= 0)
        super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
    } 
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = getMeasuredWidth();
    if (m == Integer.MIN_VALUE) {
      i2 = Math.min(n, this.j);
    } else {
      i2 = this.j;
    } 
    if (m != 1073741824 && this.j > 0 && i1 < i2)
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), paramInt2); 
    if (!bool && this.f != null)
      super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) { super.onRestoreInstanceState(null); }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.b.hasSubMenu()) {
      ap ap1 = this.g;
      if (ap1 != null && ap1.onTouch(this, paramMotionEvent))
        return true; 
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean) {
    if (this.i != paramBoolean) {
      this.i = paramBoolean;
      j j1 = this.b;
      if (j1 != null)
        j1.h(); 
    } 
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.f = paramDrawable;
    if (paramDrawable != null) {
      int m = paramDrawable.getIntrinsicWidth();
      int n = paramDrawable.getIntrinsicHeight();
      int i1 = this.l;
      if (m > i1) {
        n = (int)(i1 / m * n);
        m = i1;
      } 
      int i2 = this.l;
      if (n > i2) {
        m = (int)(i2 / n * m);
        n = i2;
      } 
      paramDrawable.setBounds(0, 0, m, n);
    } 
    setCompoundDrawables(paramDrawable, null, null, null);
    f();
  }
  
  public void setItemInvoker(h.b paramb) { this.c = paramb; }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.k = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb) { this.d = paramb; }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.e = paramCharSequence;
    f();
  }
  
  private class a extends ap {
    public a(ActionMenuItemView this$0) { super(this$0); }
    
    public s a() { return (this.a.d != null) ? this.a.d.a() : null; }
    
    protected boolean b() {
      h.b b = this.a.c;
      boolean bool = false;
      if (b != null) {
        boolean bool1 = this.a.c.a(this.a.b);
        bool = false;
        if (bool1) {
          s s = a();
          bool = false;
          if (s != null) {
            boolean bool2 = s.d();
            bool = false;
            if (bool2)
              bool = true; 
          } 
        } 
      } 
      return bool;
    }
  }
  
  public static abstract class b {
    public abstract s a();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */