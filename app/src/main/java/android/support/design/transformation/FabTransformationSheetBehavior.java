package android.support.design.transformation;

import android.content.Context;
import android.os.Build;
import android.support.design.a;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior extends FabTransformationBehavior {
  private Map<View, Integer> a;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private void a(View paramView, boolean paramBoolean) {
    ViewParent viewParent = paramView.getParent();
    if (!(viewParent instanceof CoordinatorLayout))
      return; 
    CoordinatorLayout coordinatorLayout = (CoordinatorLayout)viewParent;
    int i = coordinatorLayout.getChildCount();
    if (Build.VERSION.SDK_INT >= 16 && paramBoolean)
      this.a = new HashMap(i); 
    for (byte b = 0; b < i; b++) {
      byte b1;
      boolean bool;
      View view = coordinatorLayout.getChildAt(b);
      if (view.getLayoutParams() instanceof CoordinatorLayout.e && ((CoordinatorLayout.e)view.getLayoutParams()).b() instanceof FabTransformationScrimBehavior) {
        bool = true;
      } else {
        bool = false;
      } 
      if (view == paramView || bool)
        continue; 
      if (!paramBoolean) {
        Map map = this.a;
        if (map != null && map.containsKey(view)) {
          b1 = ((Integer)this.a.get(view)).intValue();
        } else {
          continue;
        } 
      } else {
        if (Build.VERSION.SDK_INT >= 16)
          this.a.put(view, Integer.valueOf(view.getImportantForAccessibility())); 
        b1 = 4;
      } 
      r.b(view, b1);
      continue;
    } 
    if (!paramBoolean)
      this.a = null; 
  }
  
  protected FabTransformationBehavior.a a(Context paramContext, boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = a.a.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      i = a.a.mtrl_fab_transformation_sheet_collapse_spec;
    } 
    FabTransformationBehavior.a a1 = new FabTransformationBehavior.a();
    a1.a = h.a(paramContext, i);
    a1.b = new j(17, 0.0F, 0.0F);
    return a1;
  }
  
  protected boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    a(paramView2, paramBoolean1);
    return super.a(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\transformation\FabTransformationSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */