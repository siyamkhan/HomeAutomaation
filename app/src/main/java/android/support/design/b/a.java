package android.support.design.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.a;
import android.support.design.e.a;
import android.support.design.internal.b;
import android.support.design.internal.c;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.r;
import android.support.v4.widget.n;
import android.support.v7.c.a.a;
import android.support.v7.widget.h;
import android.util.AttributeSet;
import android.util.Log;

public class a extends h {
  private final c b;
  
  private int c;
  
  private PorterDuff.Mode d;
  
  private ColorStateList e;
  
  private Drawable f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  public a(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.b.materialButtonStyle); }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = b.a(paramContext, paramAttributeSet, a.k.MaterialButton, paramInt, a.j.Widget_MaterialComponents_Button, new int[0]);
    this.c = typedArray.getDimensionPixelSize(a.k.MaterialButton_iconPadding, 0);
    this.d = c.a(typedArray.getInt(a.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.e = a.a(getContext(), typedArray, a.k.MaterialButton_iconTint);
    this.f = a.b(getContext(), typedArray, a.k.MaterialButton_icon);
    this.i = typedArray.getInteger(a.k.MaterialButton_iconGravity, 1);
    this.g = typedArray.getDimensionPixelSize(a.k.MaterialButton_iconSize, 0);
    this.b = new c(this);
    this.b.a(typedArray);
    typedArray.recycle();
    setCompoundDrawablePadding(this.c);
    b();
  }
  
  private boolean a() { return (r.f(this) == 1); }
  
  private void b() {
    Drawable drawable = this.f;
    if (drawable != null) {
      this.f = drawable.mutate();
      a.a(this.f, this.e);
      PorterDuff.Mode mode = this.d;
      if (mode != null)
        a.a(this.f, mode); 
      int j = this.g;
      if (j == 0)
        j = this.f.getIntrinsicWidth(); 
      int k = this.g;
      if (k == 0)
        k = this.f.getIntrinsicHeight(); 
      Drawable drawable1 = this.f;
      int m = this.h;
      drawable1.setBounds(m, 0, j + m, k);
    } 
    n.a(this, this.f, null, null, null);
  }
  
  private boolean c() {
    c c1 = this.b;
    return (c1 != null && !c1.b());
  }
  
  public ColorStateList getBackgroundTintList() { return getSupportBackgroundTintList(); }
  
  public PorterDuff.Mode getBackgroundTintMode() { return getSupportBackgroundTintMode(); }
  
  public int getCornerRadius() { return c() ? this.b.h() : 0; }
  
  public Drawable getIcon() { return this.f; }
  
  public int getIconGravity() { return this.i; }
  
  public int getIconPadding() { return this.c; }
  
  public int getIconSize() { return this.g; }
  
  public ColorStateList getIconTint() { return this.e; }
  
  public PorterDuff.Mode getIconTintMode() { return this.d; }
  
  public ColorStateList getRippleColor() { return c() ? this.b.e() : null; }
  
  public ColorStateList getStrokeColor() { return c() ? this.b.f() : null; }
  
  public int getStrokeWidth() { return c() ? this.b.g() : 0; }
  
  public ColorStateList getSupportBackgroundTintList() { return c() ? this.b.c() : super.getSupportBackgroundTintList(); }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() { return c() ? this.b.d() : super.getSupportBackgroundTintMode(); }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (Build.VERSION.SDK_INT < 21 && c())
      this.b.a(paramCanvas); 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21) {
      c c1 = this.b;
      if (c1 != null)
        c1.a(paramInt4 - paramInt2, paramInt3 - paramInt1); 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.f != null) {
      if (this.i != 2)
        return; 
      int j = (int)getPaint().measureText(getText().toString());
      int k = this.g;
      if (k == 0)
        k = this.f.getIntrinsicWidth(); 
      int m = (getMeasuredWidth() - j - r.i(this) - k - this.c - r.h(this)) / 2;
      if (a())
        m = -m; 
      if (this.h != m) {
        this.h = m;
        b();
      } 
    } 
  }
  
  public void setBackground(Drawable paramDrawable) { setBackgroundDrawable(paramDrawable); }
  
  public void setBackgroundColor(int paramInt) {
    if (c()) {
      this.b.a(paramInt);
      return;
    } 
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (c())
      if (paramDrawable != getBackground()) {
        Log.i("MaterialButton", "Setting a custom background is not supported.");
        this.b.a();
      } else {
        getBackground().setState(paramDrawable.getState());
        return;
      }  
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = a.b(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setBackgroundDrawable(drawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList) { setSupportBackgroundTintList(paramColorStateList); }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode) { setSupportBackgroundTintMode(paramMode); }
  
  public void setCornerRadius(int paramInt) {
    if (c())
      this.b.c(paramInt); 
  }
  
  public void setCornerRadiusResource(int paramInt) {
    if (c())
      setCornerRadius(getResources().getDimensionPixelSize(paramInt)); 
  }
  
  public void setIcon(Drawable paramDrawable) {
    if (this.f != paramDrawable) {
      this.f = paramDrawable;
      b();
    } 
  }
  
  public void setIconGravity(int paramInt) { this.i = paramInt; }
  
  public void setIconPadding(int paramInt) {
    if (this.c != paramInt) {
      this.c = paramInt;
      setCompoundDrawablePadding(paramInt);
    } 
  }
  
  public void setIconResource(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = a.b(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setIcon(drawable);
  }
  
  public void setIconSize(int paramInt) {
    if (paramInt >= 0) {
      if (this.g != paramInt) {
        this.g = paramInt;
        b();
      } 
      return;
    } 
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(ColorStateList paramColorStateList) {
    if (this.e != paramColorStateList) {
      this.e = paramColorStateList;
      b();
    } 
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode) {
    if (this.d != paramMode) {
      this.d = paramMode;
      b();
    } 
  }
  
  public void setIconTintResource(int paramInt) { setIconTint(a.a(getContext(), paramInt)); }
  
  void setInternalBackground(Drawable paramDrawable) { super.setBackgroundDrawable(paramDrawable); }
  
  public void setRippleColor(ColorStateList paramColorStateList) {
    if (c())
      this.b.b(paramColorStateList); 
  }
  
  public void setRippleColorResource(int paramInt) {
    if (c())
      setRippleColor(a.a(getContext(), paramInt)); 
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList) {
    if (c())
      this.b.c(paramColorStateList); 
  }
  
  public void setStrokeColorResource(int paramInt) {
    if (c())
      setStrokeColor(a.a(getContext(), paramInt)); 
  }
  
  public void setStrokeWidth(int paramInt) {
    if (c())
      this.b.b(paramInt); 
  }
  
  public void setStrokeWidthResource(int paramInt) {
    if (c())
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt)); 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    if (c()) {
      this.b.a(paramColorStateList);
      return;
    } 
    if (this.b != null)
      super.setSupportBackgroundTintList(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (c()) {
      this.b.a(paramMode);
      return;
    } 
    if (this.b != null)
      super.setSupportBackgroundTintMode(paramMode); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */