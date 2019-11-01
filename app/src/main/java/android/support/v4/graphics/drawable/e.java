package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

class e extends d {
  private static Method d;
  
  e(Drawable paramDrawable) {
    super(paramDrawable);
    d();
  }
  
  e(d.a parama, Resources paramResources) {
    super(parama, paramResources);
    d();
  }
  
  private void d() {
    if (d == null)
      try {
        d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        return;
      } catch (Exception exception) {
        Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", exception);
      }  
  }
  
  d.a b() { return new a(this.b, null); }
  
  protected boolean c() {
    int i = Build.VERSION.SDK_INT;
    null = false;
    if (i == 21) {
      Drawable drawable = this.c;
      if (!(drawable instanceof android.graphics.drawable.GradientDrawable) && !(drawable instanceof android.graphics.drawable.DrawableContainer) && !(drawable instanceof android.graphics.drawable.InsetDrawable)) {
        boolean bool = drawable instanceof android.graphics.drawable.RippleDrawable;
        null = false;
        return bool ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public Rect getDirtyBounds() { return this.c.getDirtyBounds(); }
  
  public void getOutline(Outline paramOutline) { this.c.getOutline(paramOutline); }
  
  public void setHotspot(float paramFloat1, float paramFloat2) { this.c.setHotspot(paramFloat1, paramFloat2); }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { this.c.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4); }
  
  public boolean setState(int[] paramArrayOfInt) {
    if (super.setState(paramArrayOfInt)) {
      invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public void setTint(int paramInt) {
    if (c()) {
      super.setTint(paramInt);
      return;
    } 
    this.c.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (c()) {
      super.setTintList(paramColorStateList);
      return;
    } 
    this.c.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (c()) {
      super.setTintMode(paramMode);
      return;
    } 
    this.c.setTintMode(paramMode);
  }
  
  private static class a extends d.a {
    a(d.a param1a, Resources param1Resources) { super(param1a, param1Resources); }
    
    public Drawable newDrawable(Resources param1Resources) { return new e(this, param1Resources); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\drawable\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */