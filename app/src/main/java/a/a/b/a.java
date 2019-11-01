package a.a.a.a.a.b;

import a.a.a.a.a.e.c;
import a.a.a.a.a.e.d;
import a.a.a.a.a.e.e;
import a.a.a.a.i;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class a {
  private static final Pattern b = Pattern.compile("http(s?)://[^\\/]+", 2);
  
  protected final i a;
  
  private final String c;
  
  private final e d;
  
  private final c e;
  
  private final String f;
  
  public a(i parami, String paramString1, String paramString2, e parame, c paramc) {
    if (paramString2 != null) {
      if (parame != null) {
        this.a = parami;
        this.f = paramString1;
        this.c = a(paramString2);
        this.d = parame;
        this.e = paramc;
        return;
      } 
      throw new IllegalArgumentException("requestFactory must not be null.");
    } 
    throw new IllegalArgumentException("url must not be null.");
  }
  
  private String a(String paramString) {
    if (!i.d(this.f))
      paramString = b.matcher(paramString).replaceFirst(this.f); 
    return paramString;
  }
  
  protected d a(Map<String, String> paramMap) {
    d d1 = this.d.a(this.e, a(), paramMap).a(false).a(10000);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Crashlytics Android SDK/");
    stringBuilder.append(this.a.a());
    return d1.a("User-Agent", stringBuilder.toString()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
  }
  
  protected String a() { return this.c; }
  
  protected d b() { return a(Collections.emptyMap()); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */