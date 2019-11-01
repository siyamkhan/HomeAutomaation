package android.support.c;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.e;
import java.util.ArrayList;

public final class c {
  public final Intent a;
  
  public final Bundle b;
  
  private c(Intent paramIntent, Bundle paramBundle) {
    this.a = paramIntent;
    this.b = paramBundle;
  }
  
  public static final class a {
    private final Intent a = new Intent("android.intent.action.VIEW");
    
    private ArrayList<Bundle> b = null;
    
    private Bundle c = null;
    
    private ArrayList<Bundle> d = null;
    
    private boolean e = true;
    
    public a() { this(null); }
    
    public a(e param1e) {
      if (param1e != null)
        this.a.setPackage(param1e.b().getPackageName()); 
      Bundle bundle = new Bundle();
      if (param1e == null) {
        iBinder = null;
      } else {
        iBinder = param1e.a();
      } 
      e.a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
      this.a.putExtras(bundle);
    }
    
    public c a() {
      ArrayList arrayList1 = this.b;
      if (arrayList1 != null)
        this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList1); 
      ArrayList arrayList2 = this.d;
      if (arrayList2 != null)
        this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2); 
      this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
      return new c(this.a, this.c, null);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */