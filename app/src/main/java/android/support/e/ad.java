package android.support.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.h.r;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ad {
  static final Property<View, Float> a;
  
  static final Property<View, Rect> b;
  
  private static final ah c;
  
  private static Field d;
  
  private static boolean e;
  
  static  {
    ah ah1;
    if (Build.VERSION.SDK_INT >= 22) {
      ah1 = new ag();
    } else if (Build.VERSION.SDK_INT >= 21) {
      ah1 = new af();
    } else if (Build.VERSION.SDK_INT >= 19) {
      ah1 = new ae();
    } else {
      ah1 = new ah();
    } 
    c = ah1;
    a = new Property<View, Float>(Float.class, "translationAlpha") {
        public Float a(View param1View) { return Float.valueOf(ad.c(param1View)); }
        
        public void a(View param1View, Float param1Float) { ad.a(param1View, param1Float.floatValue()); }
      };
    b = new Property<View, Rect>(Rect.class, "clipBounds") {
        public Rect a(View param1View) { return r.z(param1View); }
        
        public void a(View param1View, Rect param1Rect) { r.a(param1View, param1Rect); }
      };
  }
  
  static ac a(View paramView) { return (Build.VERSION.SDK_INT >= 18) ? new ab(paramView) : aa.d(paramView); }
  
  private static void a() {
    if (!e) {
      try {
        d = View.class.getDeclaredField("mViewFlags");
        d.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.i("ViewUtils", "fetchViewFlagsField: ");
      } 
      e = true;
    } 
  }
  
  static void a(View paramView, float paramFloat) { c.a(paramView, paramFloat); }
  
  static void a(View paramView, int paramInt) { // Byte code:
    //   0: invokestatic a : ()V
    //   3: getstatic android/support/e/ad.d : Ljava/lang/reflect/Field;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 35
    //   11: aload_2
    //   12: aload_0
    //   13: invokevirtual getInt : (Ljava/lang/Object;)I
    //   16: istore #4
    //   18: getstatic android/support/e/ad.d : Ljava/lang/reflect/Field;
    //   21: aload_0
    //   22: iload_1
    //   23: iload #4
    //   25: bipush #-13
    //   27: iand
    //   28: ior
    //   29: invokevirtual setInt : (Ljava/lang/Object;I)V
    //   32: goto -> 36
    //   35: pop
    //   36: return
    // Exception table:
    //   from	to	target	type
    //   11	32	35	java/lang/IllegalAccessException }
  
  static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { c.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4); }
  
  static void a(View paramView, Matrix paramMatrix) { c.a(paramView, paramMatrix); }
  
  static al b(View paramView) { return (Build.VERSION.SDK_INT >= 18) ? new ak(paramView) : new aj(paramView.getWindowToken()); }
  
  static void b(View paramView, Matrix paramMatrix) { c.b(paramView, paramMatrix); }
  
  static float c(View paramView) { return c.a(paramView); }
  
  static void d(View paramView) { c.b(paramView); }
  
  static void e(View paramView) { c.c(paramView); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */