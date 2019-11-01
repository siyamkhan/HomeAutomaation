package a.a.a.a.a.d;

import a.a.a.a.a.b.i;
import android.content.Context;

public class i implements Runnable {
  private final Context a;
  
  private final e b;
  
  public i(Context paramContext, e parame) {
    this.a = paramContext;
    this.b = parame;
  }
  
  public void run() {
    try {
      i.a(this.a, "Performing time based file roll over.");
      if (!this.b.c()) {
        this.b.d();
        return;
      } 
    } catch (Exception exception) {
      i.a(this.a, "Failed to roll over file", exception);
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */