package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

public final class v {
  public static Intent a(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 16) {
      Intent intent = paramActivity.getParentActivityIntent();
      if (intent != null)
        return intent; 
    } 
    String str = b(paramActivity);
    if (str == null)
      return null; 
    ComponentName componentName = new ComponentName(paramActivity, str);
    try {
      return (b(paramActivity, componentName) == null) ? Intent.makeMainActivity(componentName) : (new Intent()).setComponent(componentName);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getParentActivityIntent: bad parentActivityName '");
      stringBuilder.append(str);
      stringBuilder.append("' in manifest");
      Log.e("NavUtils", stringBuilder.toString());
      return null;
    } 
  }
  
  public static Intent a(Context paramContext, ComponentName paramComponentName) {
    String str = b(paramContext, paramComponentName);
    if (str == null)
      return null; 
    ComponentName componentName = new ComponentName(paramComponentName.getPackageName(), str);
    return (b(paramContext, componentName) == null) ? Intent.makeMainActivity(componentName) : (new Intent()).setComponent(componentName);
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent) {
    if (Build.VERSION.SDK_INT >= 16)
      return paramActivity.shouldUpRecreateTask(paramIntent); 
    String str = paramActivity.getIntent().getAction();
    return (str != null && !str.equals("android.intent.action.MAIN"));
  }
  
  public static String b(Activity paramActivity) {
    try {
      return b(paramActivity, paramActivity.getComponentName());
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new IllegalArgumentException(nameNotFoundException);
    } 
  }
  
  public static String b(Context paramContext, ComponentName paramComponentName) {
    ActivityInfo activityInfo = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    if (Build.VERSION.SDK_INT >= 16) {
      String str1 = activityInfo.parentActivityName;
      if (str1 != null)
        return str1; 
    } 
    if (activityInfo.metaData == null)
      return null; 
    String str = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
    if (str == null)
      return null; 
    if (str.charAt(0) == '.') {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(str);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public static void b(Activity paramActivity, Intent paramIntent) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.navigateUpTo(paramIntent);
      return;
    } 
    paramIntent.addFlags(67108864);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */