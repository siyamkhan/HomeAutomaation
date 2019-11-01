package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class br extends Resources {
  private static boolean a = false;
  
  private final WeakReference<Context> b;
  
  static  {
  
  }
  
  public br(Context paramContext, Resources paramResources) {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.b = new WeakReference(paramContext);
  }
  
  public static boolean a() { return (b() && Build.VERSION.SDK_INT <= 20); }
  
  public static boolean b() { return a; }
  
  final Drawable a(int paramInt) { return super.getDrawable(paramInt); }
  
  public Drawable getDrawable(int paramInt) {
    Context context = (Context)this.b.get();
    return (context != null) ? l.a().a(context, this, paramInt) : super.getDrawable(paramInt);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */