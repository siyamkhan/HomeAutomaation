package a.a.a.a.a.b;

import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class g {
  protected String a() { return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>"; }
  
  public String a(Context paramContext) {
    String str = c(paramContext);
    if (TextUtils.isEmpty(str))
      str = d(paramContext); 
    if (TextUtils.isEmpty(str))
      str = b(paramContext); 
    if (TextUtils.isEmpty(str))
      e(paramContext); 
    return str;
  }
  
  protected String b(Context paramContext) { return (new r()).a(paramContext); }
  
  protected String c(Context paramContext) {
    String str = null;
    try {
      String str1 = paramContext.getPackageName();
      Bundle bundle = (paramContext.getPackageManager().getApplicationInfo(str1, 128)).metaData;
      str = null;
      if (bundle != null) {
        String str2 = bundle.getString("io.fabric.ApiKey");
        try {
          if ("@string/twitter_consumer_secret".equals(str2)) {
            c.g().a("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
            str = null;
          } else {
            str = str2;
          } 
          if (str == null) {
            c.g().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
            return bundle.getString("com.crashlytics.ApiKey");
          } 
        } catch (Exception exception) {
          str = str2;
          l l = c.g();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
          stringBuilder.append(exception);
          l.a("Fabric", stringBuilder.toString());
        } 
      } 
    } catch (Exception exception) {
      l l = c.g();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
      stringBuilder.append(exception);
      l.a("Fabric", stringBuilder.toString());
    } 
    return str;
  }
  
  protected String d(Context paramContext) {
    int i = i.a(paramContext, "io.fabric.ApiKey", "string");
    if (i == 0) {
      c.g().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
      i = i.a(paramContext, "com.crashlytics.ApiKey", "string");
    } 
    return (i != 0) ? paramContext.getResources().getString(i) : null;
  }
  
  protected void e(Context paramContext) {
    if (!c.h() && !i.i(paramContext)) {
      c.g().e("Fabric", a());
      return;
    } 
    throw new IllegalArgumentException(a());
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */