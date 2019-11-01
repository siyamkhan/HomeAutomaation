package android.support.design.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

@TargetApi(21)
class b extends RippleDrawable {
  b(ColorStateList paramColorStateList, InsetDrawable paramInsetDrawable, Drawable paramDrawable) { super(paramColorStateList, paramInsetDrawable, paramDrawable); }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (getDrawable(false) != null)
      ((GradientDrawable)((LayerDrawable)((InsetDrawable)getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(paramColorFilter); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */