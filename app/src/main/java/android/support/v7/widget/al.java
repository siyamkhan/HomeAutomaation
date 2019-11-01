package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.c;
import android.support.v7.d.a.c;

public class al {
  public static final Rect a;
  
  private static Class<?> b;
  
  static  {
    // Byte code:
    //   0: new android/graphics/Rect
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: putstatic android/support/v7/widget/al.a : Landroid/graphics/Rect;
    //   10: getstatic android/os/Build$VERSION.SDK_INT : I
    //   13: bipush #18
    //   15: if_icmplt -> 29
    //   18: ldc 'android.graphics.Insets'
    //   20: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   23: putstatic android/support/v7/widget/al.b : Ljava/lang/Class;
    //   26: goto -> 30
    //   29: pop
    //   30: return
    // Exception table:
    //   from	to	target	type
    //   18	26	29	java/lang/ClassNotFoundException
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 9) {
          switch (paramInt) {
            default:
              return paramMode;
            case 16:
              return PorterDuff.Mode.ADD;
            case 15:
              return PorterDuff.Mode.SCREEN;
            case 14:
              break;
          } 
          return PorterDuff.Mode.MULTIPLY;
        } 
        return PorterDuff.Mode.SRC_ATOP;
      } 
      return PorterDuff.Mode.SRC_IN;
    } 
    return PorterDuff.Mode.SRC_OVER;
  }
  
  static void a(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))
      c(paramDrawable); 
  }
  
  public static boolean b(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT < 15 && paramDrawable instanceof android.graphics.drawable.InsetDrawable)
      return false; 
    if (Build.VERSION.SDK_INT < 15 && paramDrawable instanceof android.graphics.drawable.GradientDrawable)
      return false; 
    if (Build.VERSION.SDK_INT < 17 && paramDrawable instanceof android.graphics.drawable.LayerDrawable)
      return false; 
    if (paramDrawable instanceof DrawableContainer) {
      Drawable.ConstantState constantState = paramDrawable.getConstantState();
      if (constantState instanceof DrawableContainer.DrawableContainerState) {
        Drawable[] arrayOfDrawable = ((DrawableContainer.DrawableContainerState)constantState).getChildren();
        int i = arrayOfDrawable.length;
        for (byte b1 = 0; b1 < i; b1++) {
          if (!b(arrayOfDrawable[b1]))
            return false; 
        } 
      } 
    } else {
      if (paramDrawable instanceof c) {
        Drawable drawable = ((c)paramDrawable).a();
        return b(drawable);
      } 
      if (paramDrawable instanceof c) {
        Drawable drawable = ((c)paramDrawable).b();
        return b(drawable);
      } 
      if (paramDrawable instanceof ScaleDrawable) {
        Drawable drawable = ((ScaleDrawable)paramDrawable).getDrawable();
        return b(drawable);
      } 
    } 
    return true;
  }
  
  private static void c(Drawable paramDrawable) {
    int[] arrayOfInt2;
    int[] arrayOfInt1 = paramDrawable.getState();
    if (arrayOfInt1 == null || arrayOfInt1.length == 0) {
      arrayOfInt2 = bh.e;
    } else {
      arrayOfInt2 = bh.h;
    } 
    paramDrawable.setState(arrayOfInt2);
    paramDrawable.setState(arrayOfInt1);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */