package a.a.a.a;

import a.a.a.a.a.b.g;
import a.a.a.a.a.b.i;
import a.a.a.a.a.b.l;
import a.a.a.a.a.b.m;
import a.a.a.a.a.e.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.d;
import a.a.a.a.a.g.e;
import a.a.a.a.a.g.h;
import a.a.a.a.a.g.n;
import a.a.a.a.a.g.q;
import a.a.a.a.a.g.t;
import a.a.a.a.a.g.y;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class m extends i<Boolean> {
  private final e a = new b();
  
  private PackageManager b;
  
  private String c;
  
  private PackageInfo d;
  
  private String k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private String o;
  
  private final Future<Map<String, k>> p;
  
  private final Collection<i> q;
  
  public m(Future<Map<String, k>> paramFuture, Collection<i> paramCollection) {
    this.p = paramFuture;
    this.q = paramCollection;
  }
  
  private d a(n paramn, Collection<k> paramCollection) {
    Context context = r();
    String str1 = (new g()).a(context);
    String str2 = i.a(new String[] { i.m(context) });
    int j = m.a(this.m).a();
    String str3 = q().c();
    return new d(str1, str3, this.l, this.k, str2, this.n, j, this.o, "0", paramn, paramCollection);
  }
  
  private boolean a(e parame, n paramn, Collection<k> paramCollection) {
    d d1 = a(paramn, paramCollection);
    return (new y(this, f(), parame.c, this.a)).a(d1);
  }
  
  private boolean a(String paramString, e parame, Collection<k> paramCollection) {
    if ("new".equals(parame.b)) {
      if (!b(paramString, parame, paramCollection)) {
        c.g().e("Fabric", "Failed to create app with Crashlytics service.", null);
        return false;
      } 
    } else if (!"configured".equals(parame.b)) {
      if (parame.f) {
        c.g().a("Fabric", "Server says an update is required - forcing a full App update.");
        c(paramString, parame, paramCollection);
      } 
      return true;
    } 
    return q.a().d();
  }
  
  private boolean b(String paramString, e parame, Collection<k> paramCollection) {
    d d1 = a(n.a(r(), paramString), paramCollection);
    return (new h(this, f(), parame.c, this.a)).a(d1);
  }
  
  private boolean c(String paramString, e parame, Collection<k> paramCollection) { return a(parame, n.a(r(), paramString), paramCollection); }
  
  private t g() {
    try {
      q.a().a(this, this.i, this.a, this.k, this.l, f(), l.a(r())).c();
      return q.a().b();
    } catch (Exception exception) {
      c.g().e("Fabric", "Error dealing with settings", exception);
      return null;
    } 
  }
  
  public String a() { return "1.4.8.32"; }
  
  Map<String, k> a(Map<String, k> paramMap, Collection<i> paramCollection) {
    for (i i1 : paramCollection) {
      if (!paramMap.containsKey(i1.b()))
        paramMap.put(i1.b(), new k(i1.b(), i1.a(), "binary")); 
    } 
    return paramMap;
  }
  
  public String b() { return "io.fabric.sdk.android:fabric"; }
  
  protected boolean b_() {
    try {
      String str;
      this.m = q().i();
      this.b = r().getPackageManager();
      this.c = r().getPackageName();
      this.d = this.b.getPackageInfo(this.c, 0);
      this.k = Integer.toString(this.d.versionCode);
      if (this.d.versionName == null) {
        str = "0.0";
      } else {
        str = this.d.versionName;
      } 
      this.l = str;
      this.n = this.b.getApplicationLabel(r().getApplicationInfo()).toString();
      this.o = Integer.toString((r().getApplicationInfo()).targetSdkVersion);
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      c.g().e("Fabric", "Failed init", nameNotFoundException);
      return false;
    } 
  }
  
  protected Boolean d() {
    String str = i.k(r());
    t t = g();
    if (t != null) {
      boolean bool1;
      try {
        HashMap hashMap;
        if (this.p != null) {
          hashMap = (Map)this.p.get();
        } else {
          hashMap = new HashMap();
        } 
        Map map = a(hashMap, this.q);
        bool1 = a(str, t.a, map.values());
      } catch (Exception exception) {
        c.g().e("Fabric", "Error performing auto configuration.", exception);
        bool1 = false;
      } 
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
  }
  
  String f() { return i.b(r(), "com.crashlytics.ApiEndpoint"); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */