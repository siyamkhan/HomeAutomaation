package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.a.a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class af extends Object implements Iterable<Intent> {
  private final ArrayList<Intent> a = new ArrayList();
  
  private final Context b;
  
  private af(Context paramContext) { this.b = paramContext; }
  
  public static af a(Context paramContext) { return new af(paramContext); }
  
  public af a(Activity paramActivity) {
    Intent intent;
    if (paramActivity instanceof a) {
      intent = ((a)paramActivity).a_();
    } else {
      intent = null;
    } 
    if (intent == null)
      intent = v.a(paramActivity); 
    if (intent != null) {
      ComponentName componentName = intent.getComponent();
      if (componentName == null)
        componentName = intent.resolveActivity(this.b.getPackageManager()); 
      a(componentName);
      a(intent);
    } 
    return this;
  }
  
  public af a(ComponentName paramComponentName) {
    int i = this.a.size();
    try {
      Context context = this.b;
      while (true) {
        Intent intent = v.a(context, paramComponentName);
        if (intent != null) {
          this.a.add(i, intent);
          context = this.b;
          paramComponentName = intent.getComponent();
          continue;
        } 
        break;
      } 
      return this;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(nameNotFoundException);
    } 
  }
  
  public af a(Intent paramIntent) {
    this.a.add(paramIntent);
    return this;
  }
  
  public void a() { a(null); }
  
  public void a(Bundle paramBundle) {
    if (!this.a.isEmpty()) {
      ArrayList arrayList = this.a;
      Intent[] arrayOfIntent = (Intent[])arrayList.toArray(new Intent[arrayList.size()]);
      arrayOfIntent[0] = (new Intent(arrayOfIntent[0])).addFlags(268484608);
      if (!a.a(this.b, arrayOfIntent, paramBundle)) {
        Intent intent = new Intent(arrayOfIntent[-1 + arrayOfIntent.length]);
        intent.addFlags(268435456);
        this.b.startActivity(intent);
      } 
      return;
    } 
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
  }
  
  @Deprecated
  public Iterator<Intent> iterator() { return this.a.iterator(); }
  
  public static interface a {
    Intent a_();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */