package a.a.a.a.a.b;

import a.a.a.a.c;
import android.content.Context;
import android.text.TextUtils;

public class r {
  String a(Context paramContext) {
    int i = i.a(paramContext, "google_app_id", "string");
    if (i != 0) {
      c.g().a("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
      return a(paramContext.getResources().getString(i));
    } 
    return null;
  }
  
  String a(String paramString) { return i.b(paramString).substring(0, 40); }
  
  public boolean b(Context paramContext) {
    if (i.a(paramContext, "com.crashlytics.useFirebaseAppId", false))
      return true; 
    boolean bool1 = e(paramContext);
    boolean bool2 = false;
    if (bool1) {
      boolean bool = c(paramContext);
      bool2 = false;
      if (!bool)
        bool2 = true; 
    } 
    return bool2;
  }
  
  boolean c(Context paramContext) { return !TextUtils.isEmpty((new g()).c(paramContext)) ? true : (true ^ TextUtils.isEmpty((new g()).d(paramContext))); }
  
  public boolean d(Context paramContext) {
    int i = i.a(paramContext, "io.fabric.auto_initialize", "bool");
    if (i == 0)
      return false; 
    boolean bool = paramContext.getResources().getBoolean(i);
    if (bool)
      c.g().a("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers"); 
    return bool;
  }
  
  boolean e(Context paramContext) {
    int i = i.a(paramContext, "google_app_id", "string");
    return (i == 0) ? false : (true ^ TextUtils.isEmpty(paramContext.getResources().getString(i)));
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */