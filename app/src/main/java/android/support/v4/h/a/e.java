package android.support.v4.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

public class e {
  private final AccessibilityRecord a;
  
  public static void a(AccessibilityRecord paramAccessibilityRecord, int paramInt) {
    if (Build.VERSION.SDK_INT >= 15)
      paramAccessibilityRecord.setMaxScrollX(paramInt); 
  }
  
  public static void b(AccessibilityRecord paramAccessibilityRecord, int paramInt) {
    if (Build.VERSION.SDK_INT >= 15)
      paramAccessibilityRecord.setMaxScrollY(paramInt); 
  }
  
  @Deprecated
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    e e1 = (e)paramObject;
    AccessibilityRecord accessibilityRecord = this.a;
    if (accessibilityRecord == null) {
      if (e1.a != null)
        return false; 
    } else if (!accessibilityRecord.equals(e1.a)) {
      return false;
    } 
    return true;
  }
  
  @Deprecated
  public int hashCode() {
    AccessibilityRecord accessibilityRecord = this.a;
    return (accessibilityRecord == null) ? 0 : accessibilityRecord.hashCode();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */