package android.support.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class v implements w {
  private final ViewGroupOverlay a;
  
  v(ViewGroup paramViewGroup) { this.a = paramViewGroup.getOverlay(); }
  
  public void a(Drawable paramDrawable) { this.a.add(paramDrawable); }
  
  public void a(View paramView) { this.a.add(paramView); }
  
  public void b(Drawable paramDrawable) { this.a.remove(paramDrawable); }
  
  public void b(View paramView) { this.a.remove(paramView); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */