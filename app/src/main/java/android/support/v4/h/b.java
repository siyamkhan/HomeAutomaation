package android.support.v4.h;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.h.a.c;
import android.support.v4.h.a.d;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class b {
  private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
  
  private final View.AccessibilityDelegate b = new a(this);
  
  public d a(View paramView) {
    if (Build.VERSION.SDK_INT >= 16) {
      AccessibilityNodeProvider accessibilityNodeProvider = a.getAccessibilityNodeProvider(paramView);
      if (accessibilityNodeProvider != null)
        return new d(accessibilityNodeProvider); 
    } 
    return null;
  }
  
  View.AccessibilityDelegate a() { return this.b; }
  
  public void a(View paramView, int paramInt) { a.sendAccessibilityEvent(paramView, paramInt); }
  
  public void a(View paramView, c paramc) { a.onInitializeAccessibilityNodeInfo(paramView, paramc.a()); }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent) { a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent); }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle) { return (Build.VERSION.SDK_INT >= 16) ? a.performAccessibilityAction(paramView, paramInt, paramBundle) : 0; }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) { return a.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent); }
  
  public void b(View paramView, AccessibilityEvent paramAccessibilityEvent) { a.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent); }
  
  public void c(View paramView, AccessibilityEvent paramAccessibilityEvent) { a.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent); }
  
  public boolean d(View paramView, AccessibilityEvent paramAccessibilityEvent) { return a.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent); }
  
  private static final class a extends View.AccessibilityDelegate {
    private final b a;
    
    a(b param1b) { this.a = param1b; }
    
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) { return this.a.d(param1View, param1AccessibilityEvent); }
    
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View param1View) {
      d d = this.a.a(param1View);
      return (d != null) ? (AccessibilityNodeProvider)d.a() : null;
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) { this.a.a(param1View, param1AccessibilityEvent); }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfo param1AccessibilityNodeInfo) { this.a.a(param1View, c.a(param1AccessibilityNodeInfo)); }
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) { this.a.b(param1View, param1AccessibilityEvent); }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) { return this.a.a(param1ViewGroup, param1View, param1AccessibilityEvent); }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) { return this.a.a(param1View, param1Int, param1Bundle); }
    
    public void sendAccessibilityEvent(View param1View, int param1Int) { this.a.a(param1View, param1Int); }
    
    public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) { this.a.c(param1View, param1AccessibilityEvent); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */