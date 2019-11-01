package a.a.a.a.a.b;

import a.a.a.a.c;
import a.a.a.a.l;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.jd.gui.api.API;

public class i {
  public static final Comparator<File> a;
  
  private static Boolean b;
  
  private static final char[] c = { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static long d = -1L;
  
  static  {
    a = new Comparator<File>() {
        public int a(File param1File1, File param1File2) { return (int)(param1File1.lastModified() - param1File2.lastModified()); }
      };
  }
  
  public static int a() { return a.a().ordinal(); }
  
  public static int a(Context paramContext, String paramString1, String paramString2) { return paramContext.getResources().getIdentifier(paramString1, paramString2, j(paramContext)); }
  
  public static int a(Context paramContext, boolean paramBoolean) {
    Float float = c(paramContext);
    return (!paramBoolean || float == null) ? 1 : ((float.floatValue() >= 99.0D) ? 3 : ((float.floatValue() < 99.0D) ? 2 : 0));
  }
  
  static long a(String paramString1, String paramString2, int paramInt) { return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt; }
  
  public static ActivityManager.RunningAppProcessInfo a(String paramString, Context paramContext) {
    List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (list != null)
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
        if (runningAppProcessInfo.processName.equals(paramString))
          return runningAppProcessInfo; 
      }  
    return null;
  }
  
  public static SharedPreferences a(Context paramContext) { return paramContext.getSharedPreferences("com.crashlytics.prefs", 0); }
  
  public static String a(int paramInt) {
    switch (paramInt) {
      default:
        return "?";
      case 7:
        return "A";
      case 6:
        return "E";
      case 5:
        return "W";
      case 4:
        return "I";
      case 3:
        return "D";
      case 2:
        break;
    } 
    return "V";
  }
  
  public static String a(File paramFile, String paramString) {
    if (paramFile.exists()) {
      try {
        closeable = new BufferedReader(new FileReader(paramFile), 1024);
      } catch (Exception exception) {
      
      } finally {
        API aPI = null;
      } 
    } else {
      return null;
    } 
    l l = c.g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Error parsing ");
    stringBuilder.append(paramFile);
    l.e("Fabric", stringBuilder.toString(), exception);
    String str = null;
    a(closeable, "Failed to close system file reader.");
    return str;
  }
  
  public static String a(InputStream paramInputStream) {
    Scanner scanner = (new Scanner(paramInputStream)).useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }
  
  private static String a(InputStream paramInputStream, String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int j = paramInputStream.read(arrayOfByte);
        if (j != -1) {
          messageDigest.update(arrayOfByte, 0, j);
          continue;
        } 
        break;
      } 
      return a(messageDigest.digest());
    } catch (Exception exception) {
      c.g().e("Fabric", "Could not calculate hash for app icon.", exception);
      return "";
    } 
  }
  
  public static String a(String paramString) { return a(paramString, "SHA-1"); }
  
  private static String a(String paramString1, String paramString2) { return a(paramString1.getBytes(), paramString2); }
  
  public static String a(byte[] paramArrayOfByte) {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    for (byte b1 = 0; b1 < paramArrayOfByte.length; b1++) {
      char c1 = 0xFF & paramArrayOfByte[b1];
      byte b2 = b1 * 2;
      char[] arrayOfChar1 = c;
      arrayOfChar[b2] = arrayOfChar1[c1 >>> '\004'];
      arrayOfChar[b2 + 1] = arrayOfChar1[c1 & 0xF];
    } 
    return new String(arrayOfChar);
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(paramString);
      messageDigest.update(paramArrayOfByte);
      return a(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      l l = c.g();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not create hashing algorithm: ");
      stringBuilder.append(paramString);
      stringBuilder.append(", returning empty string.");
      l.e("Fabric", stringBuilder.toString(), noSuchAlgorithmException);
      return "";
    } 
  }
  
  public static String a(String... paramVarArgs) {
    String str = null;
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0)
        return null; 
      ArrayList arrayList = new ArrayList();
      int j = paramVarArgs.length;
      for (byte b1 = 0; b1 < j; b1++) {
        String str2 = paramVarArgs[b1];
        if (str2 != null)
          arrayList.add(str2.replace("-", "").toLowerCase(Locale.US)); 
      } 
      Collections.sort(arrayList);
      StringBuilder stringBuilder = new StringBuilder();
      Iterator iterator = arrayList.iterator();
      while (iterator.hasNext())
        stringBuilder.append((String)iterator.next()); 
      String str1 = stringBuilder.toString();
      int k = str1.length();
      str = null;
      if (k > 0)
        str = a(str1); 
    } 
    return str;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2) {
    if (e(paramContext))
      c.g().a(paramInt, "Fabric", paramString2); 
  }
  
  public static void a(Context paramContext, String paramString) {
    if (e(paramContext))
      c.g().a("Fabric", paramString); 
  }
  
  public static void a(Context paramContext, String paramString, Throwable paramThrowable) {
    if (e(paramContext))
      c.g().e("Fabric", paramString); 
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void a(Closeable paramCloseable, String paramString) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        c.g().e("Fabric", paramString, iOException);
      }  
  }
  
  public static void a(Flushable paramFlushable, String paramString) {
    if (paramFlushable != null)
      try {
        paramFlushable.flush();
        return;
      } catch (IOException iOException) {
        c.g().e("Fabric", paramString, iOException);
      }  
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte) {
    while (true) {
      int j = paramInputStream.read(paramArrayOfByte);
      if (j != -1) {
        paramOutputStream.write(paramArrayOfByte, 0, j);
        continue;
      } 
      break;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean) {
    if (paramContext != null) {
      Resources resources = paramContext.getResources();
      if (resources != null) {
        int j = a(paramContext, paramString, "bool");
        if (j > 0)
          return resources.getBoolean(j); 
        int k = a(paramContext, paramString, "string");
        if (k > 0)
          return Boolean.parseBoolean(paramContext.getString(k)); 
      } 
    } 
    return paramBoolean;
  }
  
  public static long b() { // Byte code:
    //   0: ldc a/a/a/a/a/b/i
    //   2: monitorenter
    //   3: getstatic a/a/a/a/a/b/i.d : J
    //   6: ldc2_w -1
    //   9: lcmp
    //   10: ifne -> 227
    //   13: lconst_0
    //   14: lstore_1
    //   15: new java/io/File
    //   18: dup
    //   19: ldc_w '/proc/meminfo'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: ldc_w 'MemTotal'
    //   28: invokestatic a : (Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   36: ifne -> 223
    //   39: aload_3
    //   40: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   43: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   46: astore #6
    //   48: aload #6
    //   50: ldc_w 'KB'
    //   53: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   56: ifeq -> 74
    //   59: aload #6
    //   61: ldc_w 'KB'
    //   64: sipush #1024
    //   67: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)J
    //   70: lstore_1
    //   71: goto -> 223
    //   74: aload #6
    //   76: ldc_w 'MB'
    //   79: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   82: ifeq -> 100
    //   85: aload #6
    //   87: ldc_w 'MB'
    //   90: ldc_w 1048576
    //   93: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)J
    //   96: lstore_1
    //   97: goto -> 223
    //   100: aload #6
    //   102: ldc_w 'GB'
    //   105: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   108: ifeq -> 126
    //   111: aload #6
    //   113: ldc_w 'GB'
    //   116: ldc_w 1073741824
    //   119: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)J
    //   122: lstore_1
    //   123: goto -> 223
    //   126: invokestatic g : ()La/a/a/a/l;
    //   129: astore #12
    //   131: new java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: astore #13
    //   140: aload #13
    //   142: ldc_w 'Unexpected meminfo format while computing RAM: '
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #13
    //   151: aload #6
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload #12
    //   159: ldc 'Fabric'
    //   161: aload #13
    //   163: invokevirtual toString : ()Ljava/lang/String;
    //   166: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)V
    //   171: goto -> 223
    //   174: astore #7
    //   176: invokestatic g : ()La/a/a/a/l;
    //   179: astore #8
    //   181: new java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial <init> : ()V
    //   188: astore #9
    //   190: aload #9
    //   192: ldc_w 'Unexpected meminfo format while computing RAM: '
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload #9
    //   201: aload #6
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #8
    //   209: ldc 'Fabric'
    //   211: aload #9
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: aload #7
    //   218: invokeinterface e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: lload_1
    //   224: putstatic a/a/a/a/a/b/i.d : J
    //   227: getstatic a/a/a/a/a/b/i.d : J
    //   230: lstore #4
    //   232: ldc a/a/a/a/a/b/i
    //   234: monitorexit
    //   235: lload #4
    //   237: lreturn
    //   238: astore_0
    //   239: ldc a/a/a/a/a/b/i
    //   241: monitorexit
    //   242: aload_0
    //   243: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	238	finally
    //   15	48	238	finally
    //   48	71	174	java/lang/NumberFormatException
    //   48	71	238	finally
    //   74	97	174	java/lang/NumberFormatException
    //   74	97	238	finally
    //   100	123	174	java/lang/NumberFormatException
    //   100	123	238	finally
    //   126	171	174	java/lang/NumberFormatException
    //   126	171	238	finally
    //   176	223	238	finally
    //   223	227	238	finally
    //   227	232	238	finally }
  
  public static long b(Context paramContext) {
    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(memoryInfo);
    return memoryInfo.availMem;
  }
  
  public static String b(Context paramContext, String paramString) {
    int j = a(paramContext, paramString, "string");
    return (j > 0) ? paramContext.getString(j) : "";
  }
  
  public static String b(InputStream paramInputStream) { return a(paramInputStream, "SHA-1"); }
  
  public static String b(String paramString) { return a(paramString, "SHA-256"); }
  
  public static long c(String paramString) {
    StatFs statFs = new StatFs(paramString);
    long l = statFs.getBlockSize();
    return l * statFs.getBlockCount() - l * statFs.getAvailableBlocks();
  }
  
  public static Float c(Context paramContext) {
    Intent intent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (intent == null)
      return null; 
    int j = intent.getIntExtra("level", -1);
    int k = intent.getIntExtra("scale", -1);
    return Float.valueOf(j / k);
  }
  
  public static boolean c() { return (Debug.isDebuggerConnected() || Debug.waitingForDebugger()); }
  
  public static boolean c(Context paramContext, String paramString) { return (paramContext.checkCallingOrSelfPermission(paramString) == 0); }
  
  public static boolean d(Context paramContext) {
    if (f(paramContext))
      return false; 
    Sensor sensor = ((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8);
    boolean bool = false;
    if (sensor != null)
      bool = true; 
    return bool;
  }
  
  public static boolean d(String paramString) { return (paramString == null || paramString.length() == 0); }
  
  public static boolean e(Context paramContext) {
    if (b == null)
      b = Boolean.valueOf(a(paramContext, "com.crashlytics.Trace", false)); 
    return b.booleanValue();
  }
  
  public static boolean f(Context paramContext) {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    return ("sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || str == null);
  }
  
  public static boolean g(Context paramContext) {
    boolean bool = f(paramContext);
    String str = Build.TAGS;
    if (!bool && str != null && str.contains("test-keys"))
      return true; 
    if ((new File("/system/app/Superuser.apk")).exists())
      return true; 
    File file = new File("/system/xbin/su");
    return (!bool && file.exists());
  }
  
  public static int h(Context paramContext) {
    byte b1;
    if (f(paramContext)) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    if (g(paramContext))
      b1 |= 0x2; 
    if (c())
      b1 |= 0x4; 
    return b1;
  }
  
  public static boolean i(Context paramContext) { return ((0x2 & (paramContext.getApplicationInfo()).flags) != 0); }
  
  public static String j(Context paramContext) {
    int j = (paramContext.getApplicationContext().getApplicationInfo()).icon;
    return (j > 0) ? paramContext.getResources().getResourcePackageName(j) : paramContext.getPackageName();
  }
  
  public static String k(Context paramContext) {
    try {
    
    } catch (Exception exception) {
    
    } finally {
      API aPI2 = null;
      API aPI1 = aPI2;
    } 
    l l = c.g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not calculate hash for app icon:");
    stringBuilder.append(exception.getMessage());
    l.d("Fabric", stringBuilder.toString());
    a(closeable, "Failed to close icon input stream.");
    return null;
  }
  
  public static int l(Context paramContext) { return (paramContext.getApplicationContext().getApplicationInfo()).icon; }
  
  public static String m(Context paramContext) {
    int j = a(paramContext, "io.fabric.android.build_id", "string");
    if (j == 0)
      j = a(paramContext, "com.crashlytics.android.build_id", "string"); 
    if (j != 0) {
      String str = paramContext.getResources().getString(j);
      l l = c.g();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Build ID is: ");
      stringBuilder.append(str);
      l.a("Fabric", stringBuilder.toString());
      return str;
    } 
    return null;
  }
  
  public static String n(Context paramContext) {
    int j = a(paramContext, "com.google.firebase.crashlytics.unity_version", "string");
    if (j != 0) {
      String str = paramContext.getResources().getString(j);
      l l = c.g();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unity Editor version is: ");
      stringBuilder.append(str);
      l.a("Fabric", stringBuilder.toString());
      return str;
    } 
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean o(Context paramContext) {
    boolean bool1 = c(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    boolean bool2 = true;
    if (bool1) {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnectedOrConnecting())
        return bool2; 
      bool2 = false;
    } 
    return bool2;
  }
  
  enum a {
    a, b, c, d, e, f, g, h, i, j;
    
    private static final Map<String, a> k;
    
    static  {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      l = arrayOfa;
      k = new HashMap(4);
      k.put("armeabi-v7a", g);
      k.put("armeabi", f);
      k.put("arm64-v8a", j);
      k.put("x86", a);
    }
    
    static a a() {
      String str1 = Build.CPU_ABI;
      if (TextUtils.isEmpty(str1)) {
        c.g().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
        return h;
      } 
      String str2 = str1.toLowerCase(Locale.US);
      a a1 = (a)k.get(str2);
      if (a1 == null)
        a1 = h; 
      return a1;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */