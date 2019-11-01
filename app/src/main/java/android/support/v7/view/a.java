package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.a.a;
import android.view.ViewConfiguration;

public class a {
  private Context a;
  
  private a(Context paramContext) { this.a = paramContext; }
  
  public static a a(Context paramContext) { return new a(paramContext); }
  
  public int a() {
    Configuration configuration = this.a.getResources().getConfiguration();
    int i = configuration.screenWidthDp;
    int j = configuration.screenHeightDp;
    return (configuration.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && j > 720) || (i > 720 && j > 960)) ? 5 : ((i >= 500 || (i > 640 && j > 480) || (i > 480 && j > 640)) ? 4 : ((i >= 360) ? 3 : 2));
  }
  
  public boolean b() { return (Build.VERSION.SDK_INT >= 19) ? true : (true ^ ViewConfiguration.get(this.a).hasPermanentMenuKey()); }
  
  public int c() { return (this.a.getResources().getDisplayMetrics()).widthPixels / 2; }
  
  public boolean d() { return this.a.getResources().getBoolean(a.b.abc_action_bar_embed_tabs); }
  
  public int e() {
    TypedArray typedArray = this.a.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
    int i = typedArray.getLayoutDimension(a.j.ActionBar_height, 0);
    Resources resources = this.a.getResources();
    if (!d())
      i = Math.min(i, resources.getDimensionPixelSize(a.d.abc_action_bar_stacked_max_height)); 
    typedArray.recycle();
    return i;
  }
  
  public boolean f() { return ((this.a.getApplicationInfo()).targetSdkVersion < 14); }
  
  public int g() { return this.a.getResources().getDimensionPixelSize(a.d.abc_action_bar_stacked_tab_max_width); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */