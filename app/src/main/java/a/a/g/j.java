package a.a.a.a.a.g;

import a.a.a.a.a.b.i;
import a.a.a.a.a.b.k;
import a.a.a.a.a.b.l;
import a.a.a.a.a.f.c;
import a.a.a.a.a.f.d;
import a.a.a.a.c;
import a.a.a.a.i;
import a.a.a.a.l;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.json.JSONObject;

class j implements s {
  private final w a;
  
  private final v b;
  
  private final k c;
  
  private final g d;
  
  private final x e;
  
  private final i f;
  
  private final c g;
  
  private final l h;
  
  public j(i parami, w paramw, k paramk, v paramv, g paramg, x paramx, l paraml) {
    this.f = parami;
    this.a = paramw;
    this.c = paramk;
    this.b = paramv;
    this.d = paramg;
    this.e = paramx;
    this.h = paraml;
    this.g = new d(this.f);
  }
  
  private void a(JSONObject paramJSONObject, String paramString) {
    l l1 = c.g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramJSONObject.toString());
    l1.a("Fabric", stringBuilder.toString());
  }
  
  private t b(r paramr) {
    t t = null;
    try {
      boolean bool = r.b.equals(paramr);
      t = null;
      if (!bool) {
        JSONObject jSONObject = this.d.a();
        if (jSONObject != null) {
          t t1 = this.b.a(this.c, jSONObject);
          if (t1 != null) {
            a(jSONObject, "Loaded cached settings: ");
            long l1 = this.c.a();
            if (r.c.equals(paramr) || !t1.a(l1)) {
              try {
                c.g().a("Fabric", "Returning cached settings.");
                return t1;
              } catch (Exception null) {
                t = t1;
              } 
            } else {
              l l2 = c.g();
              String str1 = "Fabric";
              String str2 = "Cached settings have expired.";
              l2.a(str1, str2);
              return null;
            } 
          } else {
            c.g().e("Fabric", "Failed to transform cached settings data.", null);
            return null;
          } 
        } else {
          l l1 = c.g();
          String str1 = "Fabric";
          String str2 = "No cached settings data found.";
          l1.a(str1, str2);
          return null;
        } 
      } else {
        return t;
      } 
    } catch (Exception exception) {}
    c.g().e("Fabric", "Failed to get cached settings", exception);
    return t;
  }
  
  public t a() { return a(r.a); }
  
  public t a(r paramr) {
    boolean bool = this.h.a();
    t t = null;
    if (!bool) {
      c.g().a("Fabric", "Not fetching settings, because data collection is disabled by Firebase.");
      return null;
    } 
    try {
      boolean bool1 = c.h();
      t = null;
      if (!bool1) {
        boolean bool2 = d();
        t = null;
        if (!bool2)
          t = b(paramr); 
      } 
      if (t == null) {
        JSONObject jSONObject = this.e.a(this.a);
        if (jSONObject != null) {
          t = this.b.a(this.c, jSONObject);
          this.d.a(t.g, jSONObject);
          a(jSONObject, "Loaded settings: ");
          a(b());
        } 
      } 
      if (t == null)
        return b(r.c); 
    } catch (Exception exception) {
      c.g().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", exception);
    } 
    return t;
  }
  
  @SuppressLint({"CommitPrefEdits"})
  boolean a(String paramString) {
    SharedPreferences.Editor editor = this.g.b();
    editor.putString("existing_instance_identifier", paramString);
    return this.g.a(editor);
  }
  
  String b() {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = i.m(this.f.r());
    return i.a(arrayOfString);
  }
  
  String c() { return this.g.a().getString("existing_instance_identifier", ""); }
  
  boolean d() { return true ^ c().equals(b()); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */