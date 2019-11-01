package a.a.a.a.a.g;

import a.a.a.a.a.b.a;
import a.a.a.a.a.b.i;
import a.a.a.a.a.b.v;
import a.a.a.a.a.e.c;
import a.a.a.a.a.e.d;
import a.a.a.a.a.e.e;
import a.a.a.a.c;
import a.a.a.a.i;
import a.a.a.a.k;
import a.a.a.a.l;
import android.content.res.Resources;
import java.io.InputStream;
import java.util.Locale;
import org.jd.gui.api.API;

abstract class a extends a {
  public a(i parami, String paramString1, String paramString2, e parame, c paramc) { super(parami, paramString1, paramString2, parame, paramc); }
  
  private d a(d paramd, d paramd1) { return paramd.a("X-CRASHLYTICS-API-KEY", paramd1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()); }
  
  private d b(d paramd, d paramd1) {
    d d1 = paramd.e("app[identifier]", paramd1.b).e("app[name]", paramd1.f).e("app[display_version]", paramd1.c).e("app[build_version]", paramd1.d).a("app[source]", Integer.valueOf(paramd1.g)).e("app[minimum_sdk_version]", paramd1.h).e("app[built_sdk_version]", paramd1.i);
    if (!i.d(paramd1.e))
      d1.e("app[instance_identifier]", paramd1.e); 
    if (paramd1.j != null) {
      InputStream inputStream = null;
      try {
        inputStream = this.a.r().getResources().openRawResource(paramd1.j.b);
        d1.e("app[icon][hash]", paramd1.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", inputStream).a("app[icon][width]", Integer.valueOf(paramd1.j.c)).a("app[icon][height]", Integer.valueOf(paramd1.j.d));
      } catch (android.content.res.Resources.NotFoundException notFoundException) {
        l l = c.g();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find app icon with resource ID: ");
        stringBuilder.append(paramd1.j.b);
        l.e("Fabric", stringBuilder.toString(), notFoundException);
      } finally {
        API aPI;
      } 
      i.a(inputStream, "Failed to close app icon InputStream.");
    } 
    if (paramd1.k != null)
      for (k k : paramd1.k) {
        d1.e(a(k), k.b());
        d1.e(b(k), k.c());
      }  
    return d1;
  }
  
  String a(k paramk) {
    Locale locale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramk.a();
    return String.format(locale, "app[build][libraries][%s][version]", arrayOfObject);
  }
  
  public boolean a(d paramd) {
    String str;
    d d1 = b(a(b(), paramd), paramd);
    l l1 = c.g();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Sending app info to ");
    stringBuilder1.append(a());
    l1.a("Fabric", stringBuilder1.toString());
    if (paramd.j != null) {
      l l4 = c.g();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("App icon hash is ");
      stringBuilder4.append(paramd.j.a);
      l4.a("Fabric", stringBuilder4.toString());
      l l5 = c.g();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append("App icon size is ");
      stringBuilder5.append(paramd.j.c);
      stringBuilder5.append("x");
      stringBuilder5.append(paramd.j.d);
      l5.a("Fabric", stringBuilder5.toString());
    } 
    int i = d1.b();
    if ("POST".equals(d1.o())) {
      str = "Create";
    } else {
      str = "Update";
    } 
    l l2 = c.g();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append(" app request ID: ");
    stringBuilder2.append(d1.b("X-REQUEST-ID"));
    l2.a("Fabric", stringBuilder2.toString());
    l l3 = c.g();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Result was ");
    stringBuilder3.append(i);
    l3.a("Fabric", stringBuilder3.toString());
    return (v.a(i) == 0);
  }
  
  String b(k paramk) {
    Locale locale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramk.a();
    return String.format(locale, "app[build][libraries][%s][type]", arrayOfObject);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */