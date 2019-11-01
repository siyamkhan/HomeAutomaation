package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class d extends Drawable implements Drawable.Callback, b, c {
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  
  a b = b();
  
  Drawable c;
  
  private int d;
  
  private PorterDuff.Mode e;
  
  private boolean f;
  
  private boolean g;
  
  d(Drawable paramDrawable) { a(paramDrawable); }
  
  d(a parama, Resources paramResources) { a(paramResources); }
  
  private void a(Resources paramResources) {
    a a1 = this.b;
    if (a1 != null && a1.b != null)
      a(this.b.b.newDrawable(paramResources)); 
  }
  
  private boolean a(int[] paramArrayOfInt) {
    if (!c())
      return false; 
    ColorStateList colorStateList = this.b.c;
    PorterDuff.Mode mode = this.b.d;
    if (colorStateList != null && mode != null) {
      int i = colorStateList.getColorForState(paramArrayOfInt, colorStateList.getDefaultColor());
      if (!this.f || i != this.d || mode != this.e) {
        setColorFilter(i, mode);
        this.d = i;
        this.e = mode;
        this.f = true;
        return true;
      } 
    } else {
      this.f = false;
      clearColorFilter();
    } 
    return false;
  }
  
  public final Drawable a() { return this.c; }
  
  public final void a(Drawable paramDrawable) {
    Drawable drawable = this.c;
    if (drawable != null)
      drawable.setCallback(null); 
    this.c = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      a a1 = this.b;
      if (a1 != null)
        a1.b = paramDrawable.getConstantState(); 
    } 
    invalidateSelf();
  }
  
  a b() { return new b(this.b, null); }
  
  protected boolean c() { return true; }
  
  public void draw(Canvas paramCanvas) { this.c.draw(paramCanvas); }
  
  public int getChangingConfigurations() {
    int j;
    int i = super.getChangingConfigurations();
    a a1 = this.b;
    if (a1 != null) {
      j = a1.getChangingConfigurations();
    } else {
      j = 0;
    } 
    return i | j | this.c.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState() {
    a a1 = this.b;
    if (a1 != null && a1.a()) {
      this.b.a = getChangingConfigurations();
      return this.b;
    } 
    return null;
  }
  
  public Drawable getCurrent() { return this.c.getCurrent(); }
  
  public int getIntrinsicHeight() { return this.c.getIntrinsicHeight(); }
  
  public int getIntrinsicWidth() { return this.c.getIntrinsicWidth(); }
  
  public int getMinimumHeight() { return this.c.getMinimumHeight(); }
  
  public int getMinimumWidth() { return this.c.getMinimumWidth(); }
  
  public int getOpacity() { return this.c.getOpacity(); }
  
  public boolean getPadding(Rect paramRect) { return this.c.getPadding(paramRect); }
  
  public int[] getState() { return this.c.getState(); }
  
  public Region getTransparentRegion() { return this.c.getTransparentRegion(); }
  
  public void invalidateDrawable(Drawable paramDrawable) { invalidateSelf(); }
  
  public boolean isAutoMirrored() { return this.c.isAutoMirrored(); }
  
  public boolean isStateful() { // Byte code:
    //   0: aload_0
    //   1: invokevirtual c : ()Z
    //   4: ifeq -> 24
    //   7: aload_0
    //   8: getfield b : Landroid/support/v4/graphics/drawable/d$a;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull -> 24
    //   16: aload_2
    //   17: getfield c : Landroid/content/res/ColorStateList;
    //   20: astore_1
    //   21: goto -> 26
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull -> 37
    //   30: aload_1
    //   31: invokevirtual isStateful : ()Z
    //   34: ifne -> 47
    //   37: aload_0
    //   38: getfield c : Landroid/graphics/drawable/Drawable;
    //   41: invokevirtual isStateful : ()Z
    //   44: ifeq -> 49
    //   47: iconst_1
    //   48: ireturn
    //   49: iconst_0
    //   50: ireturn }
  
  public void jumpToCurrentState() { this.c.jumpToCurrentState(); }
  
  public Drawable mutate() {
    if (!this.g && super.mutate() == this) {
      this.b = b();
      Drawable drawable = this.c;
      if (drawable != null)
        drawable.mutate(); 
      a a1 = this.b;
      if (a1 != null) {
        Object object;
        Drawable drawable1 = this.c;
        if (drawable1 != null) {
          object = drawable1.getConstantState();
        } else {
          object = null;
        } 
        a1.b = object;
      } 
      this.g = true;
    } 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    Drawable drawable = this.c;
    if (drawable != null)
      drawable.setBounds(paramRect); 
  }
  
  protected boolean onLevelChange(int paramInt) { return this.c.setLevel(paramInt); }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) { scheduleSelf(paramRunnable, paramLong); }
  
  public void setAlpha(int paramInt) { this.c.setAlpha(paramInt); }
  
  public void setAutoMirrored(boolean paramBoolean) { this.c.setAutoMirrored(paramBoolean); }
  
  public void setChangingConfigurations(int paramInt) { this.c.setChangingConfigurations(paramInt); }
  
  public void setColorFilter(ColorFilter paramColorFilter) { this.c.setColorFilter(paramColorFilter); }
  
  public void setDither(boolean paramBoolean) { this.c.setDither(paramBoolean); }
  
  public void setFilterBitmap(boolean paramBoolean) { this.c.setFilterBitmap(paramBoolean); }
  
  public boolean setState(int[] paramArrayOfInt) {
    boolean bool = this.c.setState(paramArrayOfInt);
    return (a(paramArrayOfInt) || bool);
  }
  
  public void setTint(int paramInt) { setTintList(ColorStateList.valueOf(paramInt)); }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.b.c = paramColorStateList;
    a(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    this.b.d = paramMode;
    a(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) { return (super.setVisible(paramBoolean1, paramBoolean2) || this.c.setVisible(paramBoolean1, paramBoolean2)); }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) { unscheduleSelf(paramRunnable); }
  
  protected static abstract class a extends Drawable.ConstantState {
    int a;
    
    Drawable.ConstantState b;
    
    ColorStateList c = null;
    
    PorterDuff.Mode d = d.a;
    
    a(a param1a, Resources param1Resources) {
      if (param1a != null) {
        this.a = param1a.a;
        this.b = param1a.b;
        this.c = param1a.c;
        this.d = param1a.d;
      } 
    }
    
    boolean a() { return (this.b != null); }
    
    public int getChangingConfigurations() {
      int j;
      int i = this.a;
      Drawable.ConstantState constantState = this.b;
      if (constantState != null) {
        j = constantState.getChangingConfigurations();
      } else {
        j = 0;
      } 
      return i | j;
    }
    
    public Drawable newDrawable() { return newDrawable(null); }
    
    public abstract Drawable newDrawable(Resources param1Resources);
  }
  
  private static class b extends a {
    b(d.a param1a, Resources param1Resources) { super(param1a, param1Resources); }
    
    public Drawable newDrawable(Resources param1Resources) { return new d(this, param1Resources); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\drawable\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */