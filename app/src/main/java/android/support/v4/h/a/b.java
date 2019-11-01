package android.support.v4.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

public final class b {
  public static boolean a(AccessibilityManager paramAccessibilityManager, a parama) { return (Build.VERSION.SDK_INT >= 19) ? ((parama == null) ? false : paramAccessibilityManager.addTouchExplorationStateChangeListener(new b(parama))) : false; }
  
  public static boolean b(AccessibilityManager paramAccessibilityManager, a parama) { return (Build.VERSION.SDK_INT >= 19) ? ((parama == null) ? false : paramAccessibilityManager.removeTouchExplorationStateChangeListener(new b(parama))) : false; }
  
  public static interface a {
    void a(boolean param1Boolean);
  }
  
  private static class b implements AccessibilityManager.TouchExplorationStateChangeListener {
    final b.a a;
    
    b(b.a param1a) { this.a = param1a; }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null || getClass() != param1Object.getClass())
        return false; 
      b b1 = (b)param1Object;
      return this.a.equals(b1.a);
    }
    
    public int hashCode() { return this.a.hashCode(); }
    
    public void onTouchExplorationStateChanged(boolean param1Boolean) { this.a.a(param1Boolean); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */