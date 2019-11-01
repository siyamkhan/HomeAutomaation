package android.support.v4.h.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class d {
  private final Object a;
  
  public d() {
    if (Build.VERSION.SDK_INT >= 19) {
      object = new b(this);
    } else if (Build.VERSION.SDK_INT >= 16) {
      object = new a(this);
    } else {
      object = null;
    } 
    this.a = object;
  }
  
  public d(Object paramObject) { this.a = paramObject; }
  
  public c a(int paramInt) { return null; }
  
  public Object a() { return this.a; }
  
  public List<c> a(String paramString, int paramInt) { return null; }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle) { return false; }
  
  public c b(int paramInt) { return null; }
  
  static class a extends AccessibilityNodeProvider {
    final d a;
    
    a(d param1d) { this.a = param1d; }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int param1Int) {
      c c = this.a.a(param1Int);
      return (c == null) ? null : c.a();
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String param1String, int param1Int) {
      List list = this.a.a(param1String, param1Int);
      if (list == null)
        return null; 
      ArrayList arrayList = new ArrayList();
      int i = list.size();
      for (byte b = 0; b < i; b++)
        arrayList.add(((c)list.get(b)).a()); 
      return arrayList;
    }
    
    public boolean performAction(int param1Int1, int param1Int2, Bundle param1Bundle) { return this.a.a(param1Int1, param1Int2, param1Bundle); }
  }
  
  static class b extends a {
    b(d param1d) { super(param1d); }
    
    public AccessibilityNodeInfo findFocus(int param1Int) {
      c c = this.a.b(param1Int);
      return (c == null) ? null : c.a();
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */