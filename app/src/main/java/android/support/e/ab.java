package android.support.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ab implements ac {
  private final ViewOverlay a;
  
  ab(View paramView) { this.a = paramView.getOverlay(); }
  
  public void a(Drawable paramDrawable) { this.a.add(paramDrawable); }
  
  public void b(Drawable paramDrawable) { this.a.remove(paramDrawable); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */