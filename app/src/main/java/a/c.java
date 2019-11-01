package a.a.a.a;

import a.a.a.a.a.b.l;
import a.a.a.a.a.b.s;
import a.a.a.a.a.c.d;
import a.a.a.a.a.c.k;
import a.a.a.a.a.c.m;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {
  static final l b = new b();
  
  final l c;
  
  final boolean d;
  
  private final Context e;
  
  private final Map<Class<? extends i>, i> f;
  
  private final ExecutorService g;
  
  private final Handler h;
  
  private final f<c> i;
  
  private final f<?> j;
  
  private final s k;
  
  private a l;
  
  private WeakReference<Activity> m;
  
  private AtomicBoolean n;
  
  c(Context paramContext, Map<Class<? extends i>, i> paramMap, k paramk, Handler paramHandler, l paraml, boolean paramBoolean, f paramf, s params, Activity paramActivity) {
    this.e = paramContext;
    this.f = paramMap;
    this.g = paramk;
    this.h = paramHandler;
    this.c = paraml;
    this.d = paramBoolean;
    this.i = paramf;
    this.n = new AtomicBoolean(false);
    this.j = a(paramMap.size());
    this.k = params;
    a(paramActivity);
  }
  
  static c a() {
    if (a != null)
      return a; 
    throw new IllegalStateException("Must Initialize Fabric before using singleton()");
  }
  
  public static c a(Context paramContext, i... paramVarArgs) { // Byte code:
    //   0: getstatic a/a/a/a/c.a : La/a/a/a/c;
    //   3: ifnonnull -> 45
    //   6: ldc a/a/a/a/c
    //   8: monitorenter
    //   9: getstatic a/a/a/a/c.a : La/a/a/a/c;
    //   12: ifnonnull -> 33
    //   15: new a/a/a/a/c$a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: aload_1
    //   24: invokevirtual a : ([La/a/a/a/i;)La/a/a/a/c$a;
    //   27: invokevirtual a : ()La/a/a/a/c;
    //   30: invokestatic c : (La/a/a/a/c;)V
    //   33: ldc a/a/a/a/c
    //   35: monitorexit
    //   36: goto -> 45
    //   39: astore_2
    //   40: ldc a/a/a/a/c
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    //   45: getstatic a/a/a/a/c.a : La/a/a/a/c;
    //   48: areturn
    // Exception table:
    //   from	to	target	type
    //   9	33	39	finally
    //   33	36	39	finally
    //   40	43	39	finally }
  
  public static <T extends i> T a(Class<T> paramClass) { return (T)(i)(a()).f.get(paramClass); }
  
  private static void a(Map<Class<? extends i>, i> paramMap, Collection<? extends i> paramCollection) {
    for (i i1 : paramCollection) {
      paramMap.put(i1.getClass(), i1);
      if (i1 instanceof j)
        a(paramMap, ((j)i1).c()); 
    } 
  }
  
  private static Map<Class<? extends i>, i> b(Collection<? extends i> paramCollection) {
    HashMap hashMap = new HashMap(paramCollection.size());
    a(hashMap, paramCollection);
    return hashMap;
  }
  
  private static void c(c paramc) {
    a = paramc;
    paramc.i();
  }
  
  private static Activity d(Context paramContext) { return (paramContext instanceof Activity) ? (Activity)paramContext : null; }
  
  public static l g() { return (a == null) ? b : a.c; }
  
  public static boolean h() { return (a == null) ? false : a.d; }
  
  private void i() {
    this.l = new a(this.e);
    this.l.a(new a.b(this) {
          public void a(Activity param1Activity) { this.a.a(param1Activity); }
          
          public void a(Activity param1Activity, Bundle param1Bundle) { this.a.a(param1Activity); }
          
          public void b(Activity param1Activity) { this.a.a(param1Activity); }
        });
    a(this.e);
  }
  
  public c a(Activity paramActivity) {
    this.m = new WeakReference(paramActivity);
    return this;
  }
  
  f<?> a(int paramInt) { return new f(this, paramInt) {
        final CountDownLatch a = new CountDownLatch(this.b);
        
        public void a(Exception param1Exception) { c.b(this.c).a(param1Exception); }
        
        public void a(Object param1Object) {
          this.a.countDown();
          if (this.a.getCount() == 0L) {
            c.a(this.c).set(true);
            c.b(this.c).a(this.c);
          } 
        }
      }; }
  
  void a(Context paramContext) {
    Object object;
    Future future = b(paramContext);
    Collection collection = f();
    m m1 = new m(future, collection);
    ArrayList arrayList = new ArrayList(collection);
    Collections.sort(arrayList);
    m1.a(paramContext, this, f.d, this.k);
    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext())
      ((i)iterator.next()).a(paramContext, this, this.j, this.k); 
    m1.p();
    if (g().a("Fabric", 3)) {
      object = new StringBuilder("Initializing ");
      object.append(d());
      object.append(" [Version: ");
      object.append(c());
      object.append("], with the following kits:\n");
    } else {
      object = null;
    } 
    for (i i1 : arrayList) {
      i1.f.a(m1.f);
      a(this.f, i1);
      i1.p();
      if (object != null) {
        object.append(i1.b());
        object.append(" [Version: ");
        object.append(i1.a());
        object.append("]\n");
      } 
    } 
    if (object != null)
      g().a("Fabric", object.toString()); 
  }
  
  void a(Map<Class<? extends i>, i> paramMap, i parami) {
    d d1 = parami.j;
    if (d1 != null)
      for (Class clazz : d1.a()) {
        if (clazz.isInterface()) {
          for (i i1 : paramMap.values()) {
            if (clazz.isAssignableFrom(i1.getClass()))
              parami.f.a(i1.f); 
          } 
        } else if ((i)paramMap.get(clazz) != null) {
          parami.f.a(((i)paramMap.get(clazz)).f);
        } else {
          throw new m("Referenced Kit was null, does the kit exist?");
        } 
      }  
  }
  
  public Activity b() {
    WeakReference weakReference = this.m;
    return (weakReference != null) ? (Activity)weakReference.get() : null;
  }
  
  Future<Map<String, k>> b(Context paramContext) {
    e e1 = new e(paramContext.getPackageCodePath());
    return e().submit(e1);
  }
  
  public String c() { return "1.4.8.32"; }
  
  public String d() { return "io.fabric.sdk.android:fabric"; }
  
  public ExecutorService e() { return this.g; }
  
  public Collection<i> f() { return this.f.values(); }
  
  public static class a {
    private final Context a;
    
    private i[] b;
    
    private k c;
    
    private Handler d;
    
    private l e;
    
    private boolean f;
    
    private String g;
    
    private String h;
    
    private f<c> i;
    
    public a(Context param1Context) {
      if (param1Context != null) {
        this.a = param1Context;
        return;
      } 
      throw new IllegalArgumentException("Context must not be null.");
    }
    
    public a a(i... param1VarArgs) {
      if (this.b == null) {
        if (!l.a(this.a).a()) {
          ArrayList arrayList = new ArrayList();
          int j = param1VarArgs.length;
          byte b1 = 0;
          boolean bool = false;
          while (b1 < j) {
            i i1 = param1VarArgs[b1];
            String str = i1.b();
            byte b2 = -1;
            int m = str.hashCode();
            if (m != 607220212) {
              if (m == 1830452504 && str.equals("com.crashlytics.sdk.android:crashlytics"))
                b2 = 0; 
            } else if (str.equals("com.crashlytics.sdk.android:answers")) {
              b2 = 1;
            } 
            switch (b2) {
              default:
                if (!bool) {
                  c.g().d("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                  bool = true;
                } 
                break;
              case 0:
              case 1:
                arrayList.add(i1);
                break;
            } 
            b1++;
          } 
          param1VarArgs = (i[])arrayList.toArray(new i[0]);
        } 
        this.b = param1VarArgs;
        return this;
      } 
      throw new IllegalStateException("Kits already set.");
    }
    
    public c a() {
      Map map1;
      if (this.c == null)
        this.c = k.a(); 
      if (this.d == null)
        this.d = new Handler(Looper.getMainLooper()); 
      if (this.e == null) {
        b b1;
        if (this.f) {
          b1 = new b(3);
        } else {
          b1 = new b();
        } 
        this.e = b1;
      } 
      if (this.h == null)
        this.h = this.a.getPackageName(); 
      if (this.i == null)
        this.i = f.d; 
      i[] arrayOfi = this.b;
      if (arrayOfi == null) {
        map1 = new HashMap();
      } else {
        map1 = c.a(Arrays.asList(arrayOfi));
      } 
      Map map2 = map1;
      Context context = this.a.getApplicationContext();
      s s = new s(context, this.h, this.g, map2.values());
      return new c(context, map2, this.c, this.d, this.e, this.f, this.i, s, c.c(this.a));
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */