package android.support.v4.h.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

public class c {
  public int a = -1;
  
  private final AccessibilityNodeInfo b;
  
  private c(AccessibilityNodeInfo paramAccessibilityNodeInfo) { this.b = paramAccessibilityNodeInfo; }
  
  public static c a(AccessibilityNodeInfo paramAccessibilityNodeInfo) { return new c(paramAccessibilityNodeInfo); }
  
  private void a(int paramInt, boolean paramBoolean) {
    Bundle bundle = r();
    if (bundle != null) {
      int i = bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (paramInt ^ 0xFFFFFFFF);
      if (!paramBoolean)
        paramInt = 0; 
      bundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", paramInt | i);
    } 
  }
  
  private static String b(int paramInt) {
    switch (paramInt) {
      default:
        return "ACTION_UNKNOWN";
      case 131072:
        return "ACTION_SET_SELECTION";
      case 65536:
        return "ACTION_CUT";
      case 32768:
        return "ACTION_PASTE";
      case 16384:
        return "ACTION_COPY";
      case 8192:
        return "ACTION_SCROLL_BACKWARD";
      case 4096:
        return "ACTION_SCROLL_FORWARD";
      case 2048:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
      case 1024:
        return "ACTION_NEXT_HTML_ELEMENT";
      case 512:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
      case 256:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
      case 128:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
      case 64:
        return "ACTION_ACCESSIBILITY_FOCUS";
      case 32:
        return "ACTION_LONG_CLICK";
      case 16:
        return "ACTION_CLICK";
      case 8:
        return "ACTION_CLEAR_SELECTION";
      case 4:
        return "ACTION_SELECT";
      case 2:
        return "ACTION_CLEAR_FOCUS";
      case 1:
        break;
    } 
    return "ACTION_FOCUS";
  }
  
  public AccessibilityNodeInfo a() { return this.b; }
  
  public void a(int paramInt) { this.b.addAction(paramInt); }
  
  public void a(Rect paramRect) { this.b.getBoundsInParent(paramRect); }
  
  public void a(CharSequence paramCharSequence) { this.b.setClassName(paramCharSequence); }
  
  public void a(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo.CollectionInfo collectionInfo;
      AccessibilityNodeInfo accessibilityNodeInfo = this.b;
      if (paramObject == null) {
        collectionInfo = null;
      } else {
        collectionInfo = (AccessibilityNodeInfo.CollectionInfo)((a)paramObject).a;
      } 
      accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    } 
  }
  
  public void a(boolean paramBoolean) { this.b.setCheckable(paramBoolean); }
  
  public int b() { return this.b.getActions(); }
  
  public void b(Rect paramRect) { this.b.getBoundsInScreen(paramRect); }
  
  public void b(CharSequence paramCharSequence) { this.b.setText(paramCharSequence); }
  
  public void b(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
      AccessibilityNodeInfo accessibilityNodeInfo = this.b;
      if (paramObject == null) {
        collectionItemInfo = null;
      } else {
        collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo)((b)paramObject).a;
      } 
      accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    } 
  }
  
  public void b(boolean paramBoolean) { this.b.setChecked(paramBoolean); }
  
  public void c(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 26) {
      this.b.setHintText(paramCharSequence);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19)
      this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", paramCharSequence); 
  }
  
  public void c(boolean paramBoolean) { this.b.setScrollable(paramBoolean); }
  
  public boolean c() { return this.b.isCheckable(); }
  
  public void d(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 21)
      this.b.setError(paramCharSequence); 
  }
  
  public void d(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      this.b.setContentInvalid(paramBoolean); 
  }
  
  public boolean d() { return this.b.isChecked(); }
  
  public void e(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 26) {
      this.b.setShowingHintText(paramBoolean);
      return;
    } 
    a(4, paramBoolean);
  }
  
  public boolean e() { return this.b.isFocusable(); }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    c c1 = (c)paramObject;
    AccessibilityNodeInfo accessibilityNodeInfo = this.b;
    if (accessibilityNodeInfo == null) {
      if (c1.b != null)
        return false; 
    } else if (!accessibilityNodeInfo.equals(c1.b)) {
      return false;
    } 
    return true;
  }
  
  public boolean f() { return this.b.isFocused(); }
  
  public boolean g() { return this.b.isSelected(); }
  
  public boolean h() { return this.b.isClickable(); }
  
  public int hashCode() {
    AccessibilityNodeInfo accessibilityNodeInfo = this.b;
    return (accessibilityNodeInfo == null) ? 0 : accessibilityNodeInfo.hashCode();
  }
  
  public boolean i() { return this.b.isLongClickable(); }
  
  public boolean j() { return this.b.isEnabled(); }
  
  public boolean k() { return this.b.isPassword(); }
  
  public boolean l() { return this.b.isScrollable(); }
  
  public CharSequence m() { return this.b.getPackageName(); }
  
  public CharSequence n() { return this.b.getClassName(); }
  
  public CharSequence o() { return this.b.getText(); }
  
  public CharSequence p() { return this.b.getContentDescription(); }
  
  public String q() { return (Build.VERSION.SDK_INT >= 18) ? this.b.getViewIdResourceName() : null; }
  
  public Bundle r() { return (Build.VERSION.SDK_INT >= 19) ? this.b.getExtras() : new Bundle(); }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(super.toString());
    Rect rect = new Rect();
    a(rect);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("; boundsInParent: ");
    stringBuilder2.append(rect);
    stringBuilder1.append(stringBuilder2.toString());
    b(rect);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("; boundsInScreen: ");
    stringBuilder3.append(rect);
    stringBuilder1.append(stringBuilder3.toString());
    stringBuilder1.append("; packageName: ");
    stringBuilder1.append(m());
    stringBuilder1.append("; className: ");
    stringBuilder1.append(n());
    stringBuilder1.append("; text: ");
    stringBuilder1.append(o());
    stringBuilder1.append("; contentDescription: ");
    stringBuilder1.append(p());
    stringBuilder1.append("; viewId: ");
    stringBuilder1.append(q());
    stringBuilder1.append("; checkable: ");
    stringBuilder1.append(c());
    stringBuilder1.append("; checked: ");
    stringBuilder1.append(d());
    stringBuilder1.append("; focusable: ");
    stringBuilder1.append(e());
    stringBuilder1.append("; focused: ");
    stringBuilder1.append(f());
    stringBuilder1.append("; selected: ");
    stringBuilder1.append(g());
    stringBuilder1.append("; clickable: ");
    stringBuilder1.append(h());
    stringBuilder1.append("; longClickable: ");
    stringBuilder1.append(i());
    stringBuilder1.append("; enabled: ");
    stringBuilder1.append(j());
    stringBuilder1.append("; password: ");
    stringBuilder1.append(k());
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("; scrollable: ");
    stringBuilder4.append(l());
    stringBuilder1.append(stringBuilder4.toString());
    stringBuilder1.append("; [");
    int i = b();
    while (i != 0) {
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i &= (j ^ 0xFFFFFFFF);
      stringBuilder1.append(b(j));
      if (i != 0)
        stringBuilder1.append(", "); 
    } 
    stringBuilder1.append("]");
    return stringBuilder1.toString();
  }
  
  public static class a {
    final Object a;
    
    a(Object param1Object) { this.a = param1Object; }
    
    public static a a(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) { return (Build.VERSION.SDK_INT >= 21) ? new a(AccessibilityNodeInfo.CollectionInfo.obtain(param1Int1, param1Int2, param1Boolean, param1Int3)) : ((Build.VERSION.SDK_INT >= 19) ? new a(AccessibilityNodeInfo.CollectionInfo.obtain(param1Int1, param1Int2, param1Boolean)) : new a(null)); }
  }
  
  public static class b {
    final Object a;
    
    b(Object param1Object) { this.a = param1Object; }
    
    public static b a(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2) { return (Build.VERSION.SDK_INT >= 21) ? new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1, param1Boolean2)) : ((Build.VERSION.SDK_INT >= 19) ? new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1)) : new b(null)); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */