package android.support.v4.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class CoreComponentFactory extends AppComponentFactory {
  static <T> T a(T paramT) {
    if (paramT instanceof a) {
      Object object = ((a)paramT).a();
      if (object != null)
        return (T)object; 
    } 
    return paramT;
  }
  
  public Activity instantiateActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent) { return (Activity)a(super.instantiateActivity(paramClassLoader, paramString, paramIntent)); }
  
  public Application instantiateApplication(ClassLoader paramClassLoader, String paramString) { return (Application)a(super.instantiateApplication(paramClassLoader, paramString)); }
  
  public ContentProvider instantiateProvider(ClassLoader paramClassLoader, String paramString) { return (ContentProvider)a(super.instantiateProvider(paramClassLoader, paramString)); }
  
  public BroadcastReceiver instantiateReceiver(ClassLoader paramClassLoader, String paramString, Intent paramIntent) { return (BroadcastReceiver)a(super.instantiateReceiver(paramClassLoader, paramString, paramIntent)); }
  
  public Service instantiateService(ClassLoader paramClassLoader, String paramString, Intent paramIntent) { return (Service)a(super.instantiateService(paramClassLoader, paramString, paramIntent)); }
  
  public static interface a {
    Object a();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\CoreComponentFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */