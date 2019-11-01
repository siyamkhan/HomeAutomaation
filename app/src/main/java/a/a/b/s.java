package a.a.a.a.a.b;

import a.a.a.a.c;
import a.a.a.a.i;
import a.a.a.a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class s {
  private static final Pattern e;
  
  private static final String f = (e = Pattern.compile("[^\\p{Alnum}]")).quote("/");
  
  c a;
  
  b b;
  
  boolean c;
  
  r d;
  
  private final ReentrantLock g = new ReentrantLock();
  
  private final t h;
  
  private final boolean i;
  
  private final boolean j;
  
  private final Context k;
  
  private final String l;
  
  private final String m;
  
  private final Collection<i> n;
  
  public s(Context paramContext, String paramString1, String paramString2, Collection<i> paramCollection) {
    if (paramContext != null) {
      if (paramString1 != null) {
        if (paramCollection != null) {
          this.k = paramContext;
          this.l = paramString1;
          this.m = paramString2;
          this.n = paramCollection;
          this.h = new t();
          this.a = new c(paramContext);
          this.d = new r();
          this.i = i.a(paramContext, "com.crashlytics.CollectDeviceIdentifiers", true);
          if (!this.i) {
            l l1 = c.g();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Device ID collection disabled for ");
            stringBuilder.append(paramContext.getPackageName());
            l1.a("Fabric", stringBuilder.toString());
          } 
          this.j = i.a(paramContext, "com.crashlytics.CollectUserIdentifiers", true);
          if (!this.j) {
            l l1 = c.g();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("User information collection disabled for ");
            stringBuilder.append(paramContext.getPackageName());
            l1.a("Fabric", stringBuilder.toString());
          } 
          return;
        } 
        throw new IllegalArgumentException("kits must not be null");
      } 
      throw new IllegalArgumentException("appIdentifier must not be null");
    } 
    throw new IllegalArgumentException("appContext must not be null");
  }
  
  @SuppressLint({"CommitPrefEdits"})
  private String a(SharedPreferences paramSharedPreferences) {
    this.g.lock();
    try {
      str = paramSharedPreferences.getString("crashlytics.installation.id", null);
      if (str == null) {
        str = a(UUID.randomUUID().toString());
        paramSharedPreferences.edit().putString("crashlytics.installation.id", str).commit();
      } 
      return str;
    } finally {
      this.g.unlock();
    } 
  }
  
  private String a(String paramString) { return (paramString == null) ? null : e.matcher(paramString).replaceAll("").toLowerCase(Locale.US); }
  
  @SuppressLint({"CommitPrefEdits"})
  private void a(SharedPreferences paramSharedPreferences, String paramString) { // Byte code:
    //   0: aload_0
    //   1: getfield g : Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual lock : ()V
    //   7: aload_2
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: istore #4
    //   13: iload #4
    //   15: ifeq -> 26
    //   18: aload_0
    //   19: getfield g : Ljava/util/concurrent/locks/ReentrantLock;
    //   22: invokevirtual unlock : ()V
    //   25: return
    //   26: aload_1
    //   27: ldc 'crashlytics.advertising.id'
    //   29: aconst_null
    //   30: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: astore #5
    //   37: aload #5
    //   39: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   42: ifeq -> 72
    //   45: aload_1
    //   46: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   51: ldc 'crashlytics.advertising.id'
    //   53: aload_2
    //   54: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   59: astore #6
    //   61: aload #6
    //   63: invokeinterface commit : ()Z
    //   68: pop
    //   69: goto -> 107
    //   72: aload #5
    //   74: aload_2
    //   75: invokevirtual equals : (Ljava/lang/Object;)Z
    //   78: ifne -> 107
    //   81: aload_1
    //   82: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   87: ldc 'crashlytics.installation.id'
    //   89: invokeinterface remove : (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   94: ldc 'crashlytics.advertising.id'
    //   96: aload_2
    //   97: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   102: astore #6
    //   104: goto -> 61
    //   107: aload_0
    //   108: getfield g : Ljava/util/concurrent/locks/ReentrantLock;
    //   111: invokevirtual unlock : ()V
    //   114: return
    //   115: astore_3
    //   116: aload_0
    //   117: getfield g : Ljava/util/concurrent/locks/ReentrantLock;
    //   120: invokevirtual unlock : ()V
    //   123: aload_3
    //   124: athrow
    // Exception table:
    //   from	to	target	type
    //   7	13	115	finally
    //   26	61	115	finally
    //   61	69	115	finally
    //   72	104	115	finally }
  
  private void a(Map<a, String> paramMap, a parama, String paramString) {
    if (paramString != null)
      paramMap.put(parama, paramString); 
  }
  
  private String b(String paramString) { return paramString.replaceAll(f, ""); }
  
  private void b(SharedPreferences paramSharedPreferences) {
    b b1 = l();
    if (b1 != null)
      a(paramSharedPreferences, b1.a); 
  }
  
  private Boolean m() {
    b b1 = l();
    return (b1 != null) ? Boolean.valueOf(b1.b) : null;
  }
  
  public boolean a() { return this.j; }
  
  public String b() {
    String str = this.m;
    if (str == null) {
      SharedPreferences sharedPreferences = i.a(this.k);
      b(sharedPreferences);
      String str1 = sharedPreferences.getString("crashlytics.installation.id", null);
      if (str1 == null)
        return a(sharedPreferences); 
      str = str1;
    } 
    return str;
  }
  
  public String c() { return this.l; }
  
  public String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e());
    stringBuilder.append("/");
    stringBuilder.append(f());
    return stringBuilder.toString();
  }
  
  public String e() { return b(Build.VERSION.RELEASE); }
  
  public String f() { return b(Build.VERSION.INCREMENTAL); }
  
  public String g() {
    Locale locale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = b(Build.MANUFACTURER);
    arrayOfObject[1] = b(Build.MODEL);
    return String.format(locale, "%s/%s", arrayOfObject);
  }
  
  public Map<a, String> h() {
    HashMap hashMap = new HashMap();
    for (i i1 : this.n) {
      if (i1 instanceof n)
        for (Map.Entry entry : ((n)i1).f().entrySet())
          a(hashMap, (a)entry.getKey(), (String)entry.getValue());  
    } 
    return Collections.unmodifiableMap(hashMap);
  }
  
  public String i() { return this.h.a(this.k); }
  
  public Boolean j() { return k() ? m() : null; }
  
  protected boolean k() { return (this.i && !this.d.b(this.k)); }
  
  b l() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: ifne -> 25
    //   9: aload_0
    //   10: aload_0
    //   11: getfield a : La/a/a/a/a/b/c;
    //   14: invokevirtual a : ()La/a/a/a/a/b/b;
    //   17: putfield b : La/a/a/a/a/b/b;
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield c : Z
    //   25: aload_0
    //   26: getfield b : La/a/a/a/a/b/b;
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
    //   25	30	34	finally }
  
  public enum a {
    a(1),
    b(2),
    c(53),
    d(100),
    e(101),
    f(102),
    g(103);
    
    public final int h;
    
    static  {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      i = arrayOfa;
    }
    
    a(int param1Int1) { this.h = param1Int1; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */