package a.a.a.a.a.b;

import a.a.a.a.a.f.c;
import a.a.a.a.a.f.d;
import a.a.a.a.c;
import a.a.a.a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

class c {
  private final Context a;
  
  private final c b;
  
  public c(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    this.b = new d(paramContext, "TwitterAdvertisingInfoPreferences");
  }
  
  private void a(b paramb) { (new Thread(new h(this, paramb) {
          public void a() {
            b b1 = c.a(this.b);
            if (!this.a.equals(b1)) {
              c.g().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
              c.a(this.b, b1);
            } 
          }
        })).start(); }
  
  @SuppressLint({"CommitPrefEdits"})
  private void b(b paramb) {
    if (c(paramb)) {
      c c2 = this.b;
      c2.a(c2.b().putString("advertising_id", paramb.a).putBoolean("limit_ad_tracking_enabled", paramb.b));
      return;
    } 
    c c1 = this.b;
    c1.a(c1.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
  }
  
  private boolean c(b paramb) { return (paramb != null && !TextUtils.isEmpty(paramb.a)); }
  
  private b e() {
    String str2;
    String str1;
    l l;
    b b1 = c().a();
    if (!c(b1)) {
      b1 = d().a();
      if (!c(b1)) {
        l = c.g();
        str1 = "Fabric";
        str2 = "AdvertisingInfo not present";
      } else {
        l = c.g();
        str1 = "Fabric";
        str2 = "Using AdvertisingInfo from Service Provider";
      } 
    } else {
      l = c.g();
      str1 = "Fabric";
      str2 = "Using AdvertisingInfo from Reflection Provider";
    } 
    l.a(str1, str2);
    return b1;
  }
  
  public b a() {
    b b1 = b();
    if (c(b1)) {
      c.g().a("Fabric", "Using AdvertisingInfo from Preference Store");
      a(b1);
      return b1;
    } 
    b b2 = e();
    b(b2);
    return b2;
  }
  
  protected b b() { return new b(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false)); }
  
  public f c() { return new d(this.a); }
  
  public f d() { return new e(this.a); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */