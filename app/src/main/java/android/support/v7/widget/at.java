package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.h.r;
import android.support.v4.widget.k;
import android.support.v7.a.a;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class at implements s {
  private static Method a;
  
  private static Method b;
  
  private static Method h;
  
  private Drawable A;
  
  private AdapterView.OnItemClickListener B;
  
  private AdapterView.OnItemSelectedListener C;
  
  private final d D = new d(this);
  
  private final c E = new c(this);
  
  private final a F = new a(this);
  
  private Runnable G;
  
  private final Rect H = new Rect();
  
  private Rect I;
  
  private boolean J;
  
  am c;
  
  int d = Integer.MAX_VALUE;
  
  final e e = new e(this);
  
  final Handler f;
  
  PopupWindow g;
  
  private Context i;
  
  private ListAdapter j;
  
  private int k = -2;
  
  private int l = -2;
  
  private int m;
  
  private int n;
  
  private int o = 1002;
  
  private boolean p;
  
  private boolean q = true;
  
  private boolean r;
  
  private boolean s;
  
  private int t = 0;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private View w;
  
  private int x = 0;
  
  private DataSetObserver y;
  
  private View z;
  
  static  {
    try {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = boolean.class;
      a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", arrayOfClass);
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    } 
    try {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = View.class;
      arrayOfClass[1] = int.class;
      arrayOfClass[2] = boolean.class;
      b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", arrayOfClass);
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
    } 
    try {
      h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
      return;
    } 
  }
  
  public at(Context paramContext) { this(paramContext, null, a.a.listPopupWindowStyle); }
  
  public at(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { this(paramContext, paramAttributeSet, paramInt, 0); }
  
  public at(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this.i = paramContext;
    this.f = new Handler(paramContext.getMainLooper());
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ListPopupWindow, paramInt1, paramInt2);
    this.m = typedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.n = typedArray.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.n != 0)
      this.p = true; 
    typedArray.recycle();
    this.g = new s(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.g.setInputMethodMode(1);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean) {
    Method method = b;
    if (method != null)
      try {
        PopupWindow popupWindow = this.g;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramView;
        arrayOfObject[1] = Integer.valueOf(paramInt);
        arrayOfObject[2] = Boolean.valueOf(paramBoolean);
        return ((Integer)method.invoke(popupWindow, arrayOfObject)).intValue();
      } catch (Exception exception) {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }  
    return this.g.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private void b() {
    View view = this.w;
    if (view != null) {
      ViewParent viewParent = view.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(this.w); 
    } 
  }
  
  private void c(boolean paramBoolean) {
    Method method = a;
    if (method != null)
      try {
        PopupWindow popupWindow = this.g;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(paramBoolean);
        method.invoke(popupWindow, arrayOfObject);
        return;
      } catch (Exception exception) {
        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
      }  
  }
  
  private int f() {
    int i6;
    int i5;
    int i2;
    int i1;
    am am1 = this.c;
    boolean bool = true;
    if (am1 == null) {
      Context context = this.i;
      this.G = new Runnable(this) {
          public void run() {
            View view = this.a.i();
            if (view != null && view.getWindowToken() != null)
              this.a.a(); 
          }
        };
      this.c = a(context, bool ^ this.J);
      Drawable drawable1 = this.A;
      if (drawable1 != null)
        this.c.setSelector(drawable1); 
      this.c.setAdapter(this.j);
      this.c.setOnItemClickListener(this.B);
      this.c.setFocusable(bool);
      this.c.setFocusableInTouchMode(bool);
      this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) {
            public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
              if (param1Int != -1) {
                am am = this.a.c;
                if (am != null)
                  am.setListSelectionHidden(false); 
              } 
            }
            
            public void onNothingSelected(AdapterView<?> param1AdapterView) {}
          });
      this.c.setOnScrollListener(this.E);
      AdapterView.OnItemSelectedListener onItemSelectedListener = this.C;
      if (onItemSelectedListener != null)
        this.c.setOnItemSelectedListener(onItemSelectedListener); 
      LinearLayout linearLayout = this.c;
      View view = this.w;
      if (view != null) {
        StringBuilder stringBuilder;
        byte b1;
        LinearLayout linearLayout1 = new LinearLayout(context);
        linearLayout1.setOrientation(bool);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.x) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid hint position ");
            stringBuilder.append(this.x);
            Log.e("ListPopupWindow", stringBuilder.toString());
            break;
          case 1:
            linearLayout1.addView(linearLayout, layoutParams1);
            linearLayout1.addView(view);
            break;
          case 0:
            linearLayout1.addView(view);
            linearLayout1.addView(linearLayout, layoutParams1);
            break;
        } 
        int i8 = this.l;
        if (i8 >= 0) {
          b1 = -2147483648;
        } else {
          i8 = 0;
          b1 = 0;
        } 
        view.measure(View.MeasureSpec.makeMeasureSpec(i8, b1), 0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)view.getLayoutParams();
        i1 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
        linearLayout = linearLayout1;
      } else {
        i1 = 0;
      } 
      this.g.setContentView(linearLayout);
    } else {
      (ViewGroup)this.g.getContentView();
      View view = this.w;
      if (view != null) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
        i1 = view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      } else {
        i1 = 0;
      } 
    } 
    Drawable drawable = this.g.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.H);
      i2 = this.H.top + this.H.bottom;
      if (!this.p)
        this.n = -this.H.top; 
    } else {
      this.H.setEmpty();
      i2 = 0;
    } 
    if (this.g.getInputMethodMode() != 2)
      bool = false; 
    int i3 = a(i(), this.n, bool);
    if (this.u || this.k == -1)
      return i3 + i2; 
    int i4 = this.l;
    switch (i4) {
      default:
        i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        i6 = i5;
        break;
      case -1:
        i5 = View.MeasureSpec.makeMeasureSpec((this.i.getResources().getDisplayMetrics()).widthPixels - this.H.left + this.H.right, 1073741824);
        i6 = i5;
        break;
      case -2:
        i5 = View.MeasureSpec.makeMeasureSpec((this.i.getResources().getDisplayMetrics()).widthPixels - this.H.left + this.H.right, -2147483648);
        i6 = i5;
        break;
    } 
    int i7 = this.c.a(i6, 0, -1, i3 - i1, -1);
    if (i7 > 0)
      i1 += i2 + this.c.getPaddingTop() + this.c.getPaddingBottom(); 
    return i7 + i1;
  }
  
  am a(Context paramContext, boolean paramBoolean) { return new am(paramContext, paramBoolean); }
  
  public void a() {
    boolean bool4;
    int i1 = f();
    boolean bool1 = n();
    k.a(this.g, this.o);
    boolean bool2 = this.g.isShowing();
    boolean bool3 = true;
    if (bool2) {
      int i9;
      int i8;
      if (!r.A(i()))
        return; 
      int i4 = this.l;
      if (i4 == -1) {
        i4 = -1;
      } else if (i4 == -2) {
        i4 = i().getWidth();
      } 
      int i5 = this.k;
      if (i5 == -1) {
        if (!bool1)
          i1 = -1; 
        if (bool1) {
          byte b1;
          PopupWindow popupWindow3 = this.g;
          if (this.l == -1) {
            b1 = -1;
          } else {
            b1 = 0;
          } 
          popupWindow3.setWidth(b1);
          this.g.setHeight(0);
        } else {
          byte b1;
          PopupWindow popupWindow3 = this.g;
          if (this.l == -1) {
            b1 = -1;
          } else {
            b1 = 0;
          } 
          popupWindow3.setWidth(b1);
          this.g.setHeight(-1);
        } 
      } else if (i5 != -2) {
        i1 = i5;
      } 
      PopupWindow popupWindow1 = this.g;
      if (this.v || this.u)
        bool3 = false; 
      popupWindow1.setOutsideTouchable(bool3);
      PopupWindow popupWindow2 = this.g;
      View view = i();
      int i6 = this.m;
      int i7 = this.n;
      if (i4 < 0) {
        i8 = -1;
      } else {
        i8 = i4;
      } 
      if (i1 < 0) {
        i9 = -1;
      } else {
        i9 = i1;
      } 
      popupWindow2.update(view, i6, i7, i8, i9);
      return;
    } 
    int i2 = this.l;
    if (i2 == -1) {
      i2 = -1;
    } else if (i2 == -2) {
      i2 = i().getWidth();
    } 
    int i3 = this.k;
    if (i3 == -1) {
      i1 = -1;
    } else if (i3 != -2) {
      i1 = i3;
    } 
    this.g.setWidth(i2);
    this.g.setHeight(i1);
    c(bool3);
    PopupWindow popupWindow = this.g;
    if (!this.v && !this.u) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    popupWindow.setOutsideTouchable(bool4);
    this.g.setTouchInterceptor(this.D);
    if (this.s)
      k.a(this.g, this.r); 
    Method method = h;
    if (method != null)
      try {
        PopupWindow popupWindow1 = this.g;
        Object[] arrayOfObject = new Object[bool3];
        arrayOfObject[0] = this.I;
        method.invoke(popupWindow1, arrayOfObject);
      } catch (Exception exception) {
        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", exception);
      }  
    k.a(this.g, i(), this.m, this.n, this.t);
    this.c.setSelection(-1);
    if (!this.J || this.c.isInTouchMode())
      m(); 
    if (!this.J)
      this.f.post(this.F); 
  }
  
  public void a(int paramInt) { this.x = paramInt; }
  
  public void a(Rect paramRect) { this.I = paramRect; }
  
  public void a(Drawable paramDrawable) { this.g.setBackgroundDrawable(paramDrawable); }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener) { this.B = paramOnItemClickListener; }
  
  public void a(ListAdapter paramListAdapter) {
    DataSetObserver dataSetObserver = this.y;
    if (dataSetObserver == null) {
      this.y = new b(this);
    } else {
      ListAdapter listAdapter = this.j;
      if (listAdapter != null)
        listAdapter.unregisterDataSetObserver(dataSetObserver); 
    } 
    this.j = paramListAdapter;
    if (paramListAdapter != null)
      paramListAdapter.registerDataSetObserver(this.y); 
    am am1 = this.c;
    if (am1 != null)
      am1.setAdapter(this.j); 
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener) { this.g.setOnDismissListener(paramOnDismissListener); }
  
  public void a(boolean paramBoolean) {
    this.J = paramBoolean;
    this.g.setFocusable(paramBoolean);
  }
  
  public void b(int paramInt) { this.g.setAnimationStyle(paramInt); }
  
  public void b(View paramView) { this.z = paramView; }
  
  public void b(boolean paramBoolean) {
    this.s = true;
    this.r = paramBoolean;
  }
  
  public void c() {
    this.g.dismiss();
    b();
    this.g.setContentView(null);
    this.c = null;
    this.f.removeCallbacks(this.e);
  }
  
  public void c(int paramInt) { this.m = paramInt; }
  
  public void d(int paramInt) {
    this.n = paramInt;
    this.p = true;
  }
  
  public boolean d() { return this.g.isShowing(); }
  
  public ListView e() { return this.c; }
  
  public void e(int paramInt) { this.t = paramInt; }
  
  public void f(int paramInt) { this.l = paramInt; }
  
  public void g(int paramInt) {
    Drawable drawable = this.g.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.H);
      this.l = paramInt + this.H.left + this.H.right;
      return;
    } 
    f(paramInt);
  }
  
  public boolean g() { return this.J; }
  
  public Drawable h() { return this.g.getBackground(); }
  
  public void h(int paramInt) { this.g.setInputMethodMode(paramInt); }
  
  public View i() { return this.z; }
  
  public void i(int paramInt) {
    am am1 = this.c;
    if (d() && am1 != null) {
      am1.setListSelectionHidden(false);
      am1.setSelection(paramInt);
      if (am1.getChoiceMode() != 0)
        am1.setItemChecked(paramInt, true); 
    } 
  }
  
  public int j() { return this.m; }
  
  public int k() { return !this.p ? 0 : this.n; }
  
  public int l() { return this.l; }
  
  public void m() {
    am am1 = this.c;
    if (am1 != null) {
      am1.setListSelectionHidden(true);
      am1.requestLayout();
    } 
  }
  
  public boolean n() { return (this.g.getInputMethodMode() == 2); }
  
  private class a implements Runnable {
    a(at this$0) {}
    
    public void run() { this.a.m(); }
  }
  
  private class b extends DataSetObserver {
    b(at this$0) {}
    
    public void onChanged() {
      if (this.a.d())
        this.a.a(); 
    }
    
    public void onInvalidated() { this.a.c(); }
  }
  
  private class c implements AbsListView.OnScrollListener {
    c(at this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (param1Int == 1 && !this.a.n() && this.a.g.getContentView() != null) {
        this.a.f.removeCallbacks(this.a.e);
        this.a.e.run();
      } 
    }
  }
  
  private class d implements View.OnTouchListener {
    d(at this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      int i = param1MotionEvent.getAction();
      int j = (int)param1MotionEvent.getX();
      int k = (int)param1MotionEvent.getY();
      if (i == 0 && this.a.g != null && this.a.g.isShowing() && j >= 0 && j < this.a.g.getWidth() && k >= 0 && k < this.a.g.getHeight()) {
        this.a.f.postDelayed(this.a.e, 250L);
      } else if (i == 1) {
        this.a.f.removeCallbacks(this.a.e);
      } 
      return false;
    }
  }
  
  private class e implements Runnable {
    e(at this$0) {}
    
    public void run() {
      if (this.a.c != null && r.A(this.a.c) && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.d) {
        this.a.g.setInputMethodMode(2);
        this.a.a();
      } 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */