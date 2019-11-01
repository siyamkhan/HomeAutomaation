package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.support.v4.b.a.a;
import android.support.v4.b.a.b;
import android.support.v4.b.a.c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class q {
  public static Menu a(Context paramContext, a parama) { return new r(paramContext, parama); }
  
  public static MenuItem a(Context paramContext, b paramb) { return (Build.VERSION.SDK_INT >= 16) ? new l(paramContext, paramb) : new k(paramContext, paramb); }
  
  public static SubMenu a(Context paramContext, c paramc) { return new v(paramContext, paramc); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */