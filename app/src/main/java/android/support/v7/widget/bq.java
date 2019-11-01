package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.a.a;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

class bq {
  private final Context a;
  
  private final View b;
  
  private final TextView c;
  
  private final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
  
  private final Rect e = new Rect();
  
  private final int[] f = new int[2];
  
  private final int[] g = new int[2];
  
  bq(Context paramContext) {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a).inflate(a.g.abc_tooltip, null);
    this.c = (TextView)this.b.findViewById(a.f.message);
    this.d.setTitle(getClass().getSimpleName());
    this.d.packageName = this.a.getPackageName();
    WindowManager.LayoutParams layoutParams = this.d;
    layoutParams.type = 1002;
    layoutParams.width = -2;
    layoutParams.height = -2;
    layoutParams.format = -3;
    layoutParams.windowAnimations = a.i.Animation_AppCompat_Tooltip;
    this.d.flags = 24;
  }
  
  private static View a(View paramView) {
    View view = paramView.getRootView();
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (layoutParams instanceof WindowManager.LayoutParams && ((WindowManager.LayoutParams)layoutParams).type == 2)
      return view; 
    for (Context context = paramView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper)context).getBaseContext()) {
      if (context instanceof Activity)
        return ((Activity)context).getWindow().getDecorView(); 
    } 
    return view;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams) {
    int m;
    int k;
    int j;
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
    if (paramView.getWidth() < i)
      paramInt1 = paramView.getWidth() / 2; 
    if (paramView.getHeight() >= i) {
      int i6 = this.a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
      j = paramInt2 + i6;
      k = paramInt2 - i6;
    } else {
      j = paramView.getHeight();
      k = 0;
    } 
    paramLayoutParams.gravity = 49;
    Resources resources = this.a.getResources();
    if (paramBoolean) {
      m = a.d.tooltip_y_offset_touch;
    } else {
      m = a.d.tooltip_y_offset_non_touch;
    } 
    int n = resources.getDimensionPixelOffset(m);
    View view = a(paramView);
    if (view == null) {
      Log.e("TooltipPopup", "Cannot find app view");
      return;
    } 
    view.getWindowVisibleDisplayFrame(this.e);
    if (this.e.left < 0 && this.e.top < 0) {
      byte b1;
      Resources resources1 = this.a.getResources();
      int i6 = resources1.getIdentifier("status_bar_height", "dimen", "android");
      if (i6 != 0) {
        b1 = resources1.getDimensionPixelSize(i6);
      } else {
        b1 = 0;
      } 
      DisplayMetrics displayMetrics = resources1.getDisplayMetrics();
      this.e.set(0, b1, displayMetrics.widthPixels, displayMetrics.heightPixels);
    } 
    view.getLocationOnScreen(this.g);
    paramView.getLocationOnScreen(this.f);
    int[] arrayOfInt1 = this.f;
    int i1 = arrayOfInt1[0];
    int[] arrayOfInt2 = this.g;
    arrayOfInt1[0] = i1 - arrayOfInt2[0];
    arrayOfInt1[1] = arrayOfInt1[1] - arrayOfInt2[1];
    paramLayoutParams.x = paramInt1 + arrayOfInt1[0] - view.getWidth() / 2;
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.b.measure(i2, i2);
    int i3 = this.b.getMeasuredHeight();
    int[] arrayOfInt3 = this.f;
    int i4 = k + arrayOfInt3[1] - n - i3;
    int i5 = n + j + arrayOfInt3[1];
    if (paramBoolean ? (i4 >= 0) : (i3 + i5 > this.e.height())) {
      paramLayoutParams.y = i4;
      return;
    } 
    paramLayoutParams.y = i5;
  }
  
  void a() {
    if (!b())
      return; 
    ((WindowManager)this.a.getSystemService("window")).removeView(this.b);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence) {
    if (b())
      a(); 
    this.c.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.d);
    ((WindowManager)this.a.getSystemService("window")).addView(this.b, this.d);
  }
  
  boolean b() { return (this.b.getParent() != null); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */