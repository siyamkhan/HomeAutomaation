package a.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;

public class l {
  private static l a;
  
  private static Object b = new Object();
  
  private final SharedPreferences c;
  
  private final p f;
  
  private boolean g;
  
  private l(Context paramContext) { // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield g : Z
    //   9: aload_1
    //   10: ifnull -> 184
    //   13: aload_0
    //   14: aload_1
    //   15: ldc 'com.google.firebase.crashlytics.prefs'
    //   17: iconst_0
    //   18: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   21: putfield c : Landroid/content/SharedPreferences;
    //   24: aload_0
    //   25: aload_1
    //   26: invokestatic a : (Landroid/content/Context;)La/a/a/a/a/b/p;
    //   29: putfield f : La/a/a/a/a/b/p;
    //   32: aload_0
    //   33: getfield c : Landroid/content/SharedPreferences;
    //   36: ldc 'firebase_crashlytics_collection_enabled'
    //   38: invokeinterface contains : (Ljava/lang/String;)Z
    //   43: ifeq -> 65
    //   46: aload_0
    //   47: getfield c : Landroid/content/SharedPreferences;
    //   50: ldc 'firebase_crashlytics_collection_enabled'
    //   52: iconst_1
    //   53: invokeinterface getBoolean : (Ljava/lang/String;Z)Z
    //   58: istore_3
    //   59: iconst_1
    //   60: istore #4
    //   62: goto -> 149
    //   65: aload_1
    //   66: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   69: astore #7
    //   71: aload #7
    //   73: ifnull -> 144
    //   76: aload #7
    //   78: aload_1
    //   79: invokevirtual getPackageName : ()Ljava/lang/String;
    //   82: sipush #128
    //   85: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   88: astore #8
    //   90: aload #8
    //   92: ifnull -> 144
    //   95: aload #8
    //   97: getfield metaData : Landroid/os/Bundle;
    //   100: ifnull -> 144
    //   103: aload #8
    //   105: getfield metaData : Landroid/os/Bundle;
    //   108: ldc 'firebase_crashlytics_collection_enabled'
    //   110: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   113: ifeq -> 144
    //   116: aload #8
    //   118: getfield metaData : Landroid/os/Bundle;
    //   121: ldc 'firebase_crashlytics_collection_enabled'
    //   123: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   126: istore_3
    //   127: goto -> 59
    //   130: astore_2
    //   131: invokestatic g : ()La/a/a/a/l;
    //   134: ldc 'Fabric'
    //   136: ldc 'Unable to get PackageManager. Falling through'
    //   138: aload_2
    //   139: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: iconst_1
    //   145: istore_3
    //   146: iconst_0
    //   147: istore #4
    //   149: aload_0
    //   150: iload_3
    //   151: putfield e : Z
    //   154: aload_0
    //   155: iload #4
    //   157: putfield d : Z
    //   160: aload_1
    //   161: invokestatic n : (Landroid/content/Context;)Ljava/lang/String;
    //   164: astore #5
    //   166: iconst_0
    //   167: istore #6
    //   169: aload #5
    //   171: ifnull -> 177
    //   174: iconst_1
    //   175: istore #6
    //   177: aload_0
    //   178: iload #6
    //   180: putfield g : Z
    //   183: return
    //   184: new java/lang/RuntimeException
    //   187: dup
    //   188: ldc 'null context'
    //   190: invokespecial <init> : (Ljava/lang/String;)V
    //   193: athrow
    // Exception table:
    //   from	to	target	type
    //   65	71	130	android/content/pm/PackageManager$NameNotFoundException
    //   76	90	130	android/content/pm/PackageManager$NameNotFoundException
    //   95	127	130	android/content/pm/PackageManager$NameNotFoundException }
  
  public static l a(Context paramContext) {
    synchronized (b) {
      if (a == null)
        a = new l(paramContext); 
      return a;
    } 
  }
  
  public boolean a() {
    if (this.g && this.d)
      return this.e; 
    p p1 = this.f;
    return (p1 != null) ? p1.a() : 1;
  }
  
  public boolean b() { return this.e; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */