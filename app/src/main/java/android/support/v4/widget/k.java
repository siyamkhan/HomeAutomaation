package android.support.v4.widget;

import android.os.Build;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class k {
  private static Method a;
  
  private static boolean b;
  
  private static Field c;
  
  private static boolean d;
  
  public static void a(PopupWindow paramPopupWindow, int paramInt) { // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmplt -> 14
    //   8: aload_0
    //   9: iload_1
    //   10: invokevirtual setWindowLayoutType : (I)V
    //   13: return
    //   14: getstatic android/support/v4/widget/k.b : Z
    //   17: ifne -> 60
    //   20: iconst_1
    //   21: anewarray java/lang/Class
    //   24: astore #7
    //   26: aload #7
    //   28: iconst_0
    //   29: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   32: aastore
    //   33: ldc android/widget/PopupWindow
    //   35: ldc 'setWindowLayoutType'
    //   37: aload #7
    //   39: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   42: putstatic android/support/v4/widget/k.a : Ljava/lang/reflect/Method;
    //   45: getstatic android/support/v4/widget/k.a : Ljava/lang/reflect/Method;
    //   48: iconst_1
    //   49: invokevirtual setAccessible : (Z)V
    //   52: goto -> 56
    //   55: pop
    //   56: iconst_1
    //   57: putstatic android/support/v4/widget/k.b : Z
    //   60: getstatic android/support/v4/widget/k.a : Ljava/lang/reflect/Method;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull -> 93
    //   68: iconst_1
    //   69: anewarray java/lang/Object
    //   72: astore #4
    //   74: aload #4
    //   76: iconst_0
    //   77: iload_1
    //   78: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   81: aastore
    //   82: aload_2
    //   83: aload_0
    //   84: aload #4
    //   86: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: goto -> 94
    //   93: pop
    //   94: return
    // Exception table:
    //   from	to	target	type
    //   20	52	55	java/lang/Exception
    //   68	90	93	java/lang/Exception }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
      return;
    } 
    if ((0x7 & d.a(paramInt3, r.f(paramView))) == 5)
      paramInt1 -= paramPopupWindow.getWidth() - paramView.getWidth(); 
    paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      if (!d) {
        try {
          c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          c.setAccessible(true);
        } catch (NoSuchFieldException noSuchFieldException) {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", noSuchFieldException);
        } 
        d = true;
      } 
      Field field = c;
      if (field != null)
        try {
          field.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        } catch (IllegalAccessException illegalAccessException) {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", illegalAccessException);
        }  
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */