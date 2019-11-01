package android.support.v4.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;
import org.jd.gui.api.API;

public class a {
  private static final Object a = new Object();
  
  private static TypedValue b;
  
  public static int a(Context paramContext, String paramString) {
    if (paramString != null)
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()); 
    throw new IllegalArgumentException("permission is null");
  }
  
  public static Drawable a(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramContext.getDrawable(paramInt); 
    if (Build.VERSION.SDK_INT < 16) {
      Object object = a;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      try {
        if (b == null)
          b = new TypedValue(); 
        paramContext.getResources().getValue(paramInt, b, true);
        paramInt = b.resourceId;
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      } finally {
        API aPI;
      } 
    } 
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  public static File a(Context paramContext) { return (Build.VERSION.SDK_INT >= 21) ? paramContext.getNoBackupFilesDir() : a(new File((paramContext.getApplicationInfo()).dataDir, "no_backup")); }
  
  private static File a(File paramFile) { // Byte code:
    //   0: ldc android/support/v4/a/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual exists : ()Z
    //   7: ifne -> 70
    //   10: aload_0
    //   11: invokevirtual mkdirs : ()Z
    //   14: ifne -> 70
    //   17: aload_0
    //   18: invokevirtual exists : ()Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq -> 31
    //   26: ldc android/support/v4/a/a
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore_3
    //   39: aload_3
    //   40: ldc 'Unable to create files subdir '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: aload_0
    //   48: invokevirtual getPath : ()Ljava/lang/String;
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 'ContextCompat'
    //   57: aload_3
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: ldc android/support/v4/a/a
    //   67: monitorexit
    //   68: aconst_null
    //   69: areturn
    //   70: ldc android/support/v4/a/a
    //   72: monitorexit
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: ldc android/support/v4/a/a
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	75	finally
    //   31	65	75	finally }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
    } else {
      paramContext.startActivities(paramArrayOfIntent);
    } 
    return true;
  }
  
  public static ColorStateList b(Context paramContext, int paramInt) { return (Build.VERSION.SDK_INT >= 23) ? paramContext.getColorStateList(paramInt) : paramContext.getResources().getColorStateList(paramInt); }
  
  public static boolean b(Context paramContext) { return (Build.VERSION.SDK_INT >= 24) ? paramContext.isDeviceProtectedStorage() : 0; }
  
  public static int c(Context paramContext, int paramInt) { return (Build.VERSION.SDK_INT >= 23) ? paramContext.getColor(paramInt) : paramContext.getResources().getColor(paramInt); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */