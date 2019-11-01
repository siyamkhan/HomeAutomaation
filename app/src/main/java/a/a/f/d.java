package a.a.a.a.a.f;

import a.a.a.a.i;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class d implements c {
  private final SharedPreferences a;
  
  private final String b;
  
  private final Context c;
  
  @Deprecated
  public d(i parami) { this(parami.r(), parami.getClass().getName()); }
  
  public d(Context paramContext, String paramString) {
    if (paramContext != null) {
      this.c = paramContext;
      this.b = paramString;
      this.a = this.c.getSharedPreferences(this.b, 0);
      return;
    } 
    throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
  }
  
  public SharedPreferences a() { return this.a; }
  
  @TargetApi(9)
  public boolean a(SharedPreferences.Editor paramEditor) {
    if (Build.VERSION.SDK_INT >= 9) {
      paramEditor.apply();
      return true;
    } 
    return paramEditor.commit();
  }
  
  public SharedPreferences.Editor b() { return this.a.edit(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */