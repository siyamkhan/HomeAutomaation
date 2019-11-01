package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.v7.widget.bm;
import android.util.AttributeSet;

public final class b {
  private static final int[] a;
  
  private static final int[] b;
  
  static  {
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = a.b.colorPrimary;
    a = arrayOfInt1;
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = a.b.colorSecondary;
    b = arrayOfInt2;
  }
  
  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs1);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static void a(Context paramContext) { a(paramContext, a, "Theme.AppCompat"); }
  
  private static void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = typedArray.getBoolean(a.k.ThemeEnforcement_enforceMaterialTheme, false);
    typedArray.recycle();
    if (bool)
      b(paramContext); 
    a(paramContext);
  }
  
  private static void a(Context paramContext, int[] paramArrayOfInt, String paramString) {
    if (a(paramContext, paramArrayOfInt))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The style on this component requires your app theme to be ");
    stringBuilder.append(paramString);
    stringBuilder.append(" (or a descendant).");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static boolean a(Context paramContext, int[] paramArrayOfInt) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = typedArray.hasValue(0);
    typedArray.recycle();
    return bool;
  }
  
  public static bm b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs1);
    return bm.a(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static void b(Context paramContext) { a(paramContext, b, "Theme.MaterialComponents"); }
  
  private static void c(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    boolean bool;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ThemeEnforcement, paramInt1, paramInt2);
    if (!typedArray.getBoolean(a.k.ThemeEnforcement_enforceTextAppearance, false)) {
      typedArray.recycle();
      return;
    } 
    if (paramVarArgs1 == null || paramVarArgs1.length == 0) {
      if (typedArray.getResourceId(a.k.ThemeEnforcement_android_textAppearance, -1) != -1) {
        bool = true;
      } else {
        bool = false;
      } 
    } else {
      bool = d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs1);
    } 
    typedArray.recycle();
    if (bool)
      return; 
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  private static boolean d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs1) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    int i = paramVarArgs1.length;
    for (byte b1 = 0; b1 < i; b1++) {
      if (typedArray.getResourceId(paramVarArgs1[b1], -1) == -1) {
        typedArray.recycle();
        return false;
      } 
    } 
    typedArray.recycle();
    return true;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */