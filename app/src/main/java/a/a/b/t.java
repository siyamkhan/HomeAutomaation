package a.a.a.a.a.b;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.d;
import a.a.a.a.c;
import android.content.Context;

public class t {
  private final d<String> a = new d<String>(this) {
      public String b(Context param1Context) {
        String str = param1Context.getPackageManager().getInstallerPackageName(param1Context.getPackageName());
        if (str == null)
          str = ""; 
        return str;
      }
    };
  
  private final b<String> b = new b();
  
  public String a(Context paramContext) {
    try {
      String str = (String)this.b.a(paramContext, this.a);
      boolean bool = "".equals(str);
      if (bool)
        str = null; 
      return str;
    } catch (Exception exception) {
      c.g().e("Fabric", "Failed to determine installer package name", exception);
      return null;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */