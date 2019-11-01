package a.a.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class a {
  private final Application a;
  
  private a b;
  
  public a(Context paramContext) {
    this.a = (Application)paramContext.getApplicationContext();
    if (Build.VERSION.SDK_INT >= 14)
      this.b = new a(this.a); 
  }
  
  public void a() {
    a a1 = this.b;
    if (a1 != null)
      a.a(a1); 
  }
  
  public boolean a(b paramb) {
    a a1;
    return (a1 != null && (a1 = this.b).a(a1, paramb));
  }
  
  private static class a {
    private final Set<Application.ActivityLifecycleCallbacks> a = new HashSet();
    
    private final Application b;
    
    a(Application param1Application) { this.b = param1Application; }
    
    @TargetApi(14)
    private void a() {
      for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.a)
        this.b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks); 
    }
    
    @TargetApi(14)
    private boolean a(a.b param1b) {
      if (this.b != null) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(this, param1b) {
            public void onActivityCreated(Activity param2Activity, Bundle param2Bundle) { this.a.a(param2Activity, param2Bundle); }
            
            public void onActivityDestroyed(Activity param2Activity) { this.a.e(param2Activity); }
            
            public void onActivityPaused(Activity param2Activity) { this.a.c(param2Activity); }
            
            public void onActivityResumed(Activity param2Activity) { this.a.b(param2Activity); }
            
            public void onActivitySaveInstanceState(Activity param2Activity, Bundle param2Bundle) { this.a.b(param2Activity, param2Bundle); }
            
            public void onActivityStarted(Activity param2Activity) { this.a.a(param2Activity); }
            
            public void onActivityStopped(Activity param2Activity) { this.a.d(param2Activity); }
          };
        this.b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        this.a.add(activityLifecycleCallbacks);
        return true;
      } 
      return false;
    }
  }
  
  class null implements Application.ActivityLifecycleCallbacks {
    null(a this$0, a.b param1b) {}
    
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) { this.a.a(param1Activity, param1Bundle); }
    
    public void onActivityDestroyed(Activity param1Activity) { this.a.e(param1Activity); }
    
    public void onActivityPaused(Activity param1Activity) { this.a.c(param1Activity); }
    
    public void onActivityResumed(Activity param1Activity) { this.a.b(param1Activity); }
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) { this.a.b(param1Activity, param1Bundle); }
    
    public void onActivityStarted(Activity param1Activity) { this.a.a(param1Activity); }
    
    public void onActivityStopped(Activity param1Activity) { this.a.d(param1Activity); }
  }
  
  public static abstract class b {
    public void a(Activity param1Activity) {}
    
    public void a(Activity param1Activity, Bundle param1Bundle) {}
    
    public void b(Activity param1Activity) {}
    
    public void b(Activity param1Activity, Bundle param1Bundle) {}
    
    public void c(Activity param1Activity) {}
    
    public void d(Activity param1Activity) {}
    
    public void e(Activity param1Activity) {}
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */