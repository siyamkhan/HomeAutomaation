package android.support.design.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.a;

public class a {
  public static ColorStateList a(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    if (paramTypedArray.hasValue(paramInt)) {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0) {
        ColorStateList colorStateList = a.a(paramContext, i);
        if (colorStateList != null)
          return colorStateList; 
      } 
    } 
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  public static Drawable b(Context paramContext, TypedArray paramTypedArray, int paramInt) {
    if (paramTypedArray.hasValue(paramInt)) {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0) {
        Drawable drawable = a.b(paramContext, i);
        if (drawable != null)
          return drawable; 
      } 
    } 
    return paramTypedArray.getDrawable(paramInt);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */