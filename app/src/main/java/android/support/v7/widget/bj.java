package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bj extends ContextWrapper {
  private static final Object a = new Object();
  
  private static ArrayList<WeakReference<bj>> b;
  
  private final Resources c;
  
  private final Resources.Theme d;
  
  private bj(Context paramContext) {
    super(paramContext);
    if (br.a()) {
      this.c = new br(this, paramContext.getResources());
      this.d = this.c.newTheme();
      this.d.setTo(paramContext.getTheme());
      return;
    } 
    this.c = new bl(this, paramContext.getResources());
    this.d = null;
  }
  
  public static Context a(Context paramContext) {
    if (b(paramContext))
      synchronized (a) {
        if (b == null) {
          b = new ArrayList();
        } else {
          int j;
          for (int i = -1 + b.size();; i--) {
            if (i >= 0) {
              WeakReference weakReference = (WeakReference)b.get(i);
              if (weakReference == null || weakReference.get() == null)
                b.remove(i); 
            } else {
              for (j = -1 + b.size();; j--) {
                if (j >= 0) {
                  Context context;
                  WeakReference weakReference = (WeakReference)b.get(j);
                  if (weakReference != null) {
                    context = (bj)weakReference.get();
                  } else {
                    context = null;
                  } 
                  if (context != null && context.getBaseContext() == paramContext)
                    return context; 
                } else {
                  bj bj2 = new bj(paramContext);
                  b.add(new WeakReference(bj2));
                  return bj2;
                } 
              } 
            } 
          } 
          j--;
        } 
        bj bj1 = new bj(paramContext);
        b.add(new WeakReference(bj1));
        return bj1;
      }  
    return paramContext;
  }
  
  private static boolean b(Context paramContext) {
    boolean bool = paramContext instanceof bj;
    null = false;
    if (!bool) {
      boolean bool1 = paramContext.getResources() instanceof bl;
      null = false;
      if (!bool1) {
        if (paramContext.getResources() instanceof br)
          return false; 
        if (Build.VERSION.SDK_INT >= 21) {
          boolean bool2 = br.a();
          null = false;
          return bool2 ? true : null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public AssetManager getAssets() { return this.c.getAssets(); }
  
  public Resources getResources() { return this.c; }
  
  public Resources.Theme getTheme() {
    Resources.Theme theme = this.d;
    if (theme == null)
      theme = super.getTheme(); 
    return theme;
  }
  
  public void setTheme(int paramInt) {
    Resources.Theme theme = this.d;
    if (theme == null) {
      super.setTheme(paramInt);
      return;
    } 
    theme.applyStyle(paramInt, true);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */