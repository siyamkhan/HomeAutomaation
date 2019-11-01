package android.support.e;

import android.view.View;
import android.view.ViewGroup;

public class l {
  private ViewGroup a;
  
  private Runnable b;
  
  static l a(View paramView) { return (l)paramView.getTag(j.a.transition_current_scene); }
  
  static void a(View paramView, l paraml) { paramView.setTag(j.a.transition_current_scene, paraml); }
  
  public void a() {
    if (a(this.a) == this) {
      Runnable runnable = this.b;
      if (runnable != null)
        runnable.run(); 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */