package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.a.a.c;
import android.support.v4.a.a.f;
import android.support.v4.e.b;
import android.support.v4.g.g;

public class c {
  private static final h a;
  
  private static final g<String, Typeface> b;
  
  static  {
    h h1;
    if (Build.VERSION.SDK_INT >= 28) {
      h1 = new g();
    } else if (Build.VERSION.SDK_INT >= 26) {
      h1 = new f();
    } else if (Build.VERSION.SDK_INT >= 24 && e.a()) {
      h1 = new e();
    } else if (Build.VERSION.SDK_INT >= 21) {
      h1 = new d();
    } else {
      h1 = new h();
    } 
    a = h1;
    b = new g(16);
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    Typeface typeface = a.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (typeface != null) {
      String str = b(paramResources, paramInt1, paramInt2);
      b.a(str, typeface);
    } 
    return typeface;
  }
  
  public static Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.b[] paramArrayOfb, int paramInt) { return a.a(paramContext, paramCancellationSignal, paramArrayOfb, paramInt); }
  
  public static Typeface a(Context paramContext, c.a parama, Resources paramResources, int paramInt1, int paramInt2, f.a parama1, Handler paramHandler, boolean paramBoolean) { // Byte code:
    //   0: aload_1
    //   1: instanceof android/support/v4/a/a/c$d
    //   4: ifeq -> 89
    //   7: aload_1
    //   8: checkcast android/support/v4/a/a/c$d
    //   11: astore #10
    //   13: iload #7
    //   15: ifeq -> 36
    //   18: aload #10
    //   20: invokevirtual b : ()I
    //   23: istore #13
    //   25: iconst_0
    //   26: istore #11
    //   28: iload #13
    //   30: ifne -> 47
    //   33: goto -> 44
    //   36: iconst_0
    //   37: istore #11
    //   39: aload #5
    //   41: ifnonnull -> 47
    //   44: iconst_1
    //   45: istore #11
    //   47: iload #7
    //   49: ifeq -> 62
    //   52: aload #10
    //   54: invokevirtual c : ()I
    //   57: istore #12
    //   59: goto -> 65
    //   62: iconst_m1
    //   63: istore #12
    //   65: aload_0
    //   66: aload #10
    //   68: invokevirtual a : ()Landroid/support/v4/e/a;
    //   71: aload #5
    //   73: aload #6
    //   75: iload #11
    //   77: iload #12
    //   79: iload #4
    //   81: invokestatic a : (Landroid/content/Context;Landroid/support/v4/e/a;Landroid/support/v4/a/a/f$a;Landroid/os/Handler;ZII)Landroid/graphics/Typeface;
    //   84: astore #8
    //   86: goto -> 136
    //   89: getstatic android/support/v4/graphics/c.a : Landroid/support/v4/graphics/h;
    //   92: aload_0
    //   93: aload_1
    //   94: checkcast android/support/v4/a/a/c$b
    //   97: aload_2
    //   98: iload #4
    //   100: invokevirtual a : (Landroid/content/Context;Landroid/support/v4/a/a/c$b;Landroid/content/res/Resources;I)Landroid/graphics/Typeface;
    //   103: astore #8
    //   105: aload #5
    //   107: ifnull -> 136
    //   110: aload #8
    //   112: ifnull -> 127
    //   115: aload #5
    //   117: aload #8
    //   119: aload #6
    //   121: invokevirtual a : (Landroid/graphics/Typeface;Landroid/os/Handler;)V
    //   124: goto -> 136
    //   127: aload #5
    //   129: bipush #-3
    //   131: aload #6
    //   133: invokevirtual a : (ILandroid/os/Handler;)V
    //   136: aload #8
    //   138: ifnull -> 157
    //   141: getstatic android/support/v4/graphics/c.b : Landroid/support/v4/g/g;
    //   144: aload_2
    //   145: iload_3
    //   146: iload #4
    //   148: invokestatic b : (Landroid/content/res/Resources;II)Ljava/lang/String;
    //   151: aload #8
    //   153: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload #8
    //   159: areturn }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2) { return (Typeface)b.a(b(paramResources, paramInt1, paramInt2)); }
  
  private static String b(Resources paramResources, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    stringBuilder.append("-");
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */