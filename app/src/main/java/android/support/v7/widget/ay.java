package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.h.a.c;
import android.support.v4.h.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ay extends b {
  final RecyclerView a;
  
  final b b;
  
  public ay(RecyclerView paramRecyclerView) {
    this.a = paramRecyclerView;
    this.b = new a(this);
  }
  
  public void a(View paramView, c paramc) {
    super.a(paramView, paramc);
    paramc.a(RecyclerView.class.getName());
    if (!b() && this.a.getLayoutManager() != null)
      this.a.getLayoutManager().a(paramc); 
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (paramView instanceof RecyclerView && !b()) {
      RecyclerView recyclerView = (RecyclerView)paramView;
      if (recyclerView.getLayoutManager() != null)
        recyclerView.getLayoutManager().a(paramAccessibilityEvent); 
    } 
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle) { return super.a(paramView, paramInt, paramBundle) ? true : ((!b() && this.a.getLayoutManager() != null) ? this.a.getLayoutManager().a(paramInt, paramBundle) : 0); }
  
  boolean b() { return this.a.v(); }
  
  public b c() { return this.b; }
  
  public static class a extends b {
    final ay a;
    
    public a(ay param1ay) { this.a = param1ay; }
    
    public void a(View param1View, c param1c) {
      super.a(param1View, param1c);
      if (!this.a.b() && this.a.a.getLayoutManager() != null)
        this.a.a.getLayoutManager().a(param1View, param1c); 
    }
    
    public boolean a(View param1View, int param1Int, Bundle param1Bundle) { return super.a(param1View, param1Int, param1Bundle) ? true : ((!this.a.b() && this.a.a.getLayoutManager() != null) ? this.a.a.getLayoutManager().a(param1View, param1Int, param1Bundle) : 0); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */