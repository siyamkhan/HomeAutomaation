package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public class h {
  public static ColorStateList a(ImageView paramImageView) { return (Build.VERSION.SDK_INT >= 21) ? paramImageView.getImageTintList() : ((paramImageView instanceof p) ? ((p)paramImageView).getSupportImageTintList() : null); }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21) {
        boolean bool;
        Drawable drawable = paramImageView.getDrawable();
        if (paramImageView.getImageTintList() != null && paramImageView.getImageTintMode() != null) {
          bool = true;
        } else {
          bool = false;
        } 
        if (drawable != null && bool) {
          if (drawable.isStateful())
            drawable.setState(paramImageView.getDrawableState()); 
          paramImageView.setImageDrawable(drawable);
          return;
        } 
      } 
    } else if (paramImageView instanceof p) {
      ((p)paramImageView).setSupportImageTintList(paramColorStateList);
    } 
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21) {
        boolean bool;
        Drawable drawable = paramImageView.getDrawable();
        if (paramImageView.getImageTintList() != null && paramImageView.getImageTintMode() != null) {
          bool = true;
        } else {
          bool = false;
        } 
        if (drawable != null && bool) {
          if (drawable.isStateful())
            drawable.setState(paramImageView.getDrawableState()); 
          paramImageView.setImageDrawable(drawable);
          return;
        } 
      } 
    } else if (paramImageView instanceof p) {
      ((p)paramImageView).setSupportImageTintMode(paramMode);
    } 
  }
  
  public static PorterDuff.Mode b(ImageView paramImageView) { return (Build.VERSION.SDK_INT >= 21) ? paramImageView.getImageTintMode() : ((paramImageView instanceof p) ? ((p)paramImageView).getSupportImageTintMode() : null); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */