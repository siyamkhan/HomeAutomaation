package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.q;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class y extends Spinner implements q {
  private static final int[] d = { 16843505 };
  
  b a;
  
  int b;
  
  final Rect c;
  
  private final g e;
  
  private final Context f;
  
  private ap g;
  
  private SpinnerAdapter h;
  
  private final boolean i;
  
  public y(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.spinnerStyle); }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { this(paramContext, paramAttributeSet, paramInt, -1); }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) { this(paramContext, paramAttributeSet, paramInt1, paramInt2, null); }
  
  public y(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, Resources.Theme paramTheme) { // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new android/graphics/Rect
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: putfield c : Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic android/support/v7/a/a$j.Spinner : [I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic a : (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/bm;
    //   28: astore #6
    //   30: aload_0
    //   31: new android/support/v7/widget/g
    //   34: dup
    //   35: aload_0
    //   36: invokespecial <init> : (Landroid/view/View;)V
    //   39: putfield e : Landroid/support/v7/widget/g;
    //   42: aload #5
    //   44: ifnull -> 68
    //   47: new android/support/v7/view/d
    //   50: dup
    //   51: aload_1
    //   52: aload #5
    //   54: invokespecial <init> : (Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   57: astore #7
    //   59: aload_0
    //   60: aload #7
    //   62: putfield f : Landroid/content/Context;
    //   65: goto -> 122
    //   68: aload #6
    //   70: getstatic android/support/v7/a/a$j.Spinner_popupTheme : I
    //   73: iconst_0
    //   74: invokevirtual g : (II)I
    //   77: istore #17
    //   79: iload #17
    //   81: ifeq -> 99
    //   84: new android/support/v7/view/d
    //   87: dup
    //   88: aload_1
    //   89: iload #17
    //   91: invokespecial <init> : (Landroid/content/Context;I)V
    //   94: astore #7
    //   96: goto -> 59
    //   99: getstatic android/os/Build$VERSION.SDK_INT : I
    //   102: bipush #23
    //   104: if_icmpge -> 113
    //   107: aload_1
    //   108: astore #18
    //   110: goto -> 116
    //   113: aconst_null
    //   114: astore #18
    //   116: aload_0
    //   117: aload #18
    //   119: putfield f : Landroid/content/Context;
    //   122: aload_0
    //   123: getfield f : Landroid/content/Context;
    //   126: ifnull -> 332
    //   129: iload #4
    //   131: iconst_m1
    //   132: if_icmpne -> 229
    //   135: aload_1
    //   136: aload_2
    //   137: getstatic android/support/v7/widget/y.d : [I
    //   140: iload_3
    //   141: iconst_0
    //   142: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   145: astore #14
    //   147: aload #14
    //   149: iconst_0
    //   150: invokevirtual hasValue : (I)Z
    //   153: ifeq -> 165
    //   156: aload #14
    //   158: iconst_0
    //   159: iconst_0
    //   160: invokevirtual getInt : (II)I
    //   163: istore #4
    //   165: aload #14
    //   167: ifnull -> 229
    //   170: aload #14
    //   172: invokevirtual recycle : ()V
    //   175: goto -> 229
    //   178: astore #13
    //   180: goto -> 196
    //   183: astore #15
    //   185: aconst_null
    //   186: astore #14
    //   188: goto -> 216
    //   191: astore #13
    //   193: aconst_null
    //   194: astore #14
    //   196: ldc 'AppCompatSpinner'
    //   198: ldc 'Could not read android:spinnerMode'
    //   200: aload #13
    //   202: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   205: pop
    //   206: aload #14
    //   208: ifnull -> 229
    //   211: goto -> 170
    //   214: astore #15
    //   216: aload #14
    //   218: ifnull -> 226
    //   221: aload #14
    //   223: invokevirtual recycle : ()V
    //   226: aload #15
    //   228: athrow
    //   229: iload #4
    //   231: iconst_1
    //   232: if_icmpne -> 332
    //   235: new android/support/v7/widget/y$b
    //   238: dup
    //   239: aload_0
    //   240: aload_0
    //   241: getfield f : Landroid/content/Context;
    //   244: aload_2
    //   245: iload_3
    //   246: invokespecial <init> : (Landroid/support/v7/widget/y;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   249: astore #11
    //   251: aload_0
    //   252: getfield f : Landroid/content/Context;
    //   255: aload_2
    //   256: getstatic android/support/v7/a/a$j.Spinner : [I
    //   259: iload_3
    //   260: iconst_0
    //   261: invokestatic a : (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/bm;
    //   264: astore #12
    //   266: aload_0
    //   267: aload #12
    //   269: getstatic android/support/v7/a/a$j.Spinner_android_dropDownWidth : I
    //   272: bipush #-2
    //   274: invokevirtual f : (II)I
    //   277: putfield b : I
    //   280: aload #11
    //   282: aload #12
    //   284: getstatic android/support/v7/a/a$j.Spinner_android_popupBackground : I
    //   287: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   290: invokevirtual a : (Landroid/graphics/drawable/Drawable;)V
    //   293: aload #11
    //   295: aload #6
    //   297: getstatic android/support/v7/a/a$j.Spinner_android_prompt : I
    //   300: invokevirtual d : (I)Ljava/lang/String;
    //   303: invokevirtual a : (Ljava/lang/CharSequence;)V
    //   306: aload #12
    //   308: invokevirtual a : ()V
    //   311: aload_0
    //   312: aload #11
    //   314: putfield a : Landroid/support/v7/widget/y$b;
    //   317: aload_0
    //   318: new android/support/v7/widget/y$1
    //   321: dup
    //   322: aload_0
    //   323: aload_0
    //   324: aload #11
    //   326: invokespecial <init> : (Landroid/support/v7/widget/y;Landroid/view/View;Landroid/support/v7/widget/y$b;)V
    //   329: putfield g : Landroid/support/v7/widget/ap;
    //   332: aload #6
    //   334: getstatic android/support/v7/a/a$j.Spinner_android_entries : I
    //   337: invokevirtual f : (I)[Ljava/lang/CharSequence;
    //   340: astore #8
    //   342: aload #8
    //   344: ifnull -> 375
    //   347: new android/widget/ArrayAdapter
    //   350: dup
    //   351: aload_1
    //   352: ldc 17367048
    //   354: aload #8
    //   356: invokespecial <init> : (Landroid/content/Context;I[Ljava/lang/Object;)V
    //   359: astore #9
    //   361: aload #9
    //   363: getstatic android/support/v7/a/a$g.support_simple_spinner_dropdown_item : I
    //   366: invokevirtual setDropDownViewResource : (I)V
    //   369: aload_0
    //   370: aload #9
    //   372: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   375: aload #6
    //   377: invokevirtual a : ()V
    //   380: aload_0
    //   381: iconst_1
    //   382: putfield i : Z
    //   385: aload_0
    //   386: getfield h : Landroid/widget/SpinnerAdapter;
    //   389: astore #10
    //   391: aload #10
    //   393: ifnull -> 407
    //   396: aload_0
    //   397: aload #10
    //   399: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   402: aload_0
    //   403: aconst_null
    //   404: putfield h : Landroid/widget/SpinnerAdapter;
    //   407: aload_0
    //   408: getfield e : Landroid/support/v7/widget/g;
    //   411: aload_2
    //   412: iload_3
    //   413: invokevirtual a : (Landroid/util/AttributeSet;I)V
    //   416: return
    // Exception table:
    //   from	to	target	type
    //   135	147	191	java/lang/Exception
    //   135	147	183	finally
    //   147	165	178	java/lang/Exception
    //   147	165	214	finally
    //   196	206	214	finally }
  
  int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable) {
    int j = 0;
    if (paramSpinnerAdapter == null)
      return 0; 
    int k = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int m = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int n = Math.max(0, getSelectedItemPosition());
    int i1 = Math.min(paramSpinnerAdapter.getCount(), n + 15);
    int i2 = Math.max(0, n - 15 - i1 - n);
    View view = null;
    int i3 = 0;
    while (i2 < i1) {
      int i4 = paramSpinnerAdapter.getItemViewType(i2);
      if (i4 != j) {
        view = null;
        j = i4;
      } 
      view = paramSpinnerAdapter.getView(i2, view, this);
      if (view.getLayoutParams() == null)
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2)); 
      view.measure(k, m);
      i3 = Math.max(i3, view.getMeasuredWidth());
      i2++;
    } 
    if (paramDrawable != null) {
      paramDrawable.getPadding(this.c);
      i3 += this.c.left + this.c.right;
    } 
    return i3;
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    g g1 = this.e;
    if (g1 != null)
      g1.c(); 
  }
  
  public int getDropDownHorizontalOffset() {
    b b1 = this.a;
    return (b1 != null) ? b1.j() : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownHorizontalOffset() : 0);
  }
  
  public int getDropDownVerticalOffset() {
    b b1 = this.a;
    return (b1 != null) ? b1.k() : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownVerticalOffset() : 0);
  }
  
  public int getDropDownWidth() { return (this.a != null) ? this.b : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownWidth() : 0); }
  
  public Drawable getPopupBackground() {
    b b1 = this.a;
    return (b1 != null) ? b1.h() : ((Build.VERSION.SDK_INT >= 16) ? super.getPopupBackground() : null);
  }
  
  public Context getPopupContext() { return (this.a != null) ? this.f : ((Build.VERSION.SDK_INT >= 23) ? super.getPopupContext() : null); }
  
  public CharSequence getPrompt() {
    b b1 = this.a;
    return (b1 != null) ? b1.b() : super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    g g1 = this.e;
    return (g1 != null) ? g1.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    g g1 = this.e;
    return (g1 != null) ? g1.b() : null;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    b b1 = this.a;
    if (b1 != null && b1.d())
      this.a.c(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a != null && View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight()); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    ap ap1 = this.g;
    return (ap1 != null && ap1.onTouch(this, paramMotionEvent)) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick() {
    b b1 = this.a;
    if (b1 != null) {
      if (!b1.d())
        this.a.a(); 
      return true;
    } 
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter) {
    if (!this.i) {
      this.h = paramSpinnerAdapter;
      return;
    } 
    super.setAdapter(paramSpinnerAdapter);
    if (this.a != null) {
      Context context = this.f;
      if (context == null)
        context = getContext(); 
      this.a.a(new a(paramSpinnerAdapter, context.getTheme()));
    } 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    g g1 = this.e;
    if (g1 != null)
      g1.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    g g1 = this.e;
    if (g1 != null)
      g1.a(paramInt); 
  }
  
  public void setDropDownHorizontalOffset(int paramInt) {
    b b1 = this.a;
    if (b1 != null) {
      b1.c(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setDropDownHorizontalOffset(paramInt); 
  }
  
  public void setDropDownVerticalOffset(int paramInt) {
    b b1 = this.a;
    if (b1 != null) {
      b1.d(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setDropDownVerticalOffset(paramInt); 
  }
  
  public void setDropDownWidth(int paramInt) {
    if (this.a != null) {
      this.b = paramInt;
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setDropDownWidth(paramInt); 
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable) {
    b b1 = this.a;
    if (b1 != null) {
      b1.a(paramDrawable);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setPopupBackgroundDrawable(paramDrawable); 
  }
  
  public void setPopupBackgroundResource(int paramInt) { setPopupBackgroundDrawable(a.b(getPopupContext(), paramInt)); }
  
  public void setPrompt(CharSequence paramCharSequence) {
    b b1 = this.a;
    if (b1 != null) {
      b1.a(paramCharSequence);
      return;
    } 
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    g g1 = this.e;
    if (g1 != null)
      g1.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    g g1 = this.e;
    if (g1 != null)
      g1.a(paramMode); 
  }
  
  private static class a implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter a;
    
    private ListAdapter b;
    
    public a(SpinnerAdapter param1SpinnerAdapter, Resources.Theme param1Theme) {
      this.a = param1SpinnerAdapter;
      if (param1SpinnerAdapter instanceof ListAdapter)
        this.b = (ListAdapter)param1SpinnerAdapter; 
      if (param1Theme != null)
        if (Build.VERSION.SDK_INT >= 23 && param1SpinnerAdapter instanceof ThemedSpinnerAdapter) {
          ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter)param1SpinnerAdapter;
          if (themedSpinnerAdapter.getDropDownViewTheme() != param1Theme) {
            themedSpinnerAdapter.setDropDownViewTheme(param1Theme);
            return;
          } 
        } else if (param1SpinnerAdapter instanceof bi) {
          bi bi = (bi)param1SpinnerAdapter;
          if (bi.a() == null)
            bi.a(param1Theme); 
        }  
    }
    
    public boolean areAllItemsEnabled() {
      ListAdapter listAdapter = this.b;
      return (listAdapter != null) ? listAdapter.areAllItemsEnabled() : 1;
    }
    
    public int getCount() {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? 0 : spinnerAdapter.getCount();
    }
    
    public View getDropDownView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? null : spinnerAdapter.getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public Object getItem(int param1Int) {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? null : spinnerAdapter.getItem(param1Int);
    }
    
    public long getItemId(int param1Int) {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? -1L : spinnerAdapter.getItemId(param1Int);
    }
    
    public int getItemViewType(int param1Int) { return 0; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) { return getDropDownView(param1Int, param1View, param1ViewGroup); }
    
    public int getViewTypeCount() { return 1; }
    
    public boolean hasStableIds() {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter != null && spinnerAdapter.hasStableIds());
    }
    
    public boolean isEmpty() { return (getCount() == 0); }
    
    public boolean isEnabled(int param1Int) {
      ListAdapter listAdapter = this.b;
      return (listAdapter != null) ? listAdapter.isEnabled(param1Int) : 1;
    }
    
    public void registerDataSetObserver(DataSetObserver param1DataSetObserver) {
      SpinnerAdapter spinnerAdapter = this.a;
      if (spinnerAdapter != null)
        spinnerAdapter.registerDataSetObserver(param1DataSetObserver); 
    }
    
    public void unregisterDataSetObserver(DataSetObserver param1DataSetObserver) {
      SpinnerAdapter spinnerAdapter = this.a;
      if (spinnerAdapter != null)
        spinnerAdapter.unregisterDataSetObserver(param1DataSetObserver); 
    }
  }
  
  private class b extends at {
    ListAdapter a;
    
    private CharSequence h;
    
    private final Rect i = new Rect();
    
    public b(y this$0, Context param1Context, AttributeSet param1AttributeSet, int param1Int) {
      super(param1Context, param1AttributeSet, param1Int);
      b(this$0);
      a(true);
      a(0);
      a(new AdapterView.OnItemClickListener(this, this$0) {
            public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
              this.b.b.setSelection(param2Int);
              if (this.b.b.getOnItemClickListener() != null)
                this.b.b.performItemClick(param2View, param2Int, this.b.a.getItemId(param2Int)); 
              this.b.c();
            }
          });
    }
    
    public void a() {
      boolean bool = d();
      f();
      h(2);
      super.a();
      e().setChoiceMode(1);
      i(this.b.getSelectedItemPosition());
      if (bool)
        return; 
      ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
      if (viewTreeObserver != null) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) {
            public void onGlobalLayout() {
              y.b b1 = this.a;
              if (!b1.a(b1.b)) {
                this.a.c();
                return;
              } 
              this.a.f();
              y.b.a(this.a);
            }
          };
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        a(new PopupWindow.OnDismissListener(this, onGlobalLayoutListener) {
              public void onDismiss() {
                ViewTreeObserver viewTreeObserver = this.b.b.getViewTreeObserver();
                if (viewTreeObserver != null)
                  viewTreeObserver.removeGlobalOnLayoutListener(this.a); 
              }
            });
      } 
    }
    
    public void a(ListAdapter param1ListAdapter) {
      super.a(param1ListAdapter);
      this.a = param1ListAdapter;
    }
    
    public void a(CharSequence param1CharSequence) { this.h = param1CharSequence; }
    
    boolean a(View param1View) { return (r.A(param1View) && param1View.getGlobalVisibleRect(this.i)); }
    
    public CharSequence b() { return this.h; }
    
    void f() {
      int i2;
      int i1;
      Drawable drawable = h();
      int j = 0;
      if (drawable != null) {
        int i3;
        drawable.getPadding(this.b.c);
        if (bu.a(this.b)) {
          i3 = this.b.c.right;
        } else {
          i3 = -this.b.c.left;
        } 
        j = i3;
      } else {
        Rect rect = this.b.c;
        this.b.c.right = 0;
        rect.left = 0;
      } 
      int k = this.b.getPaddingLeft();
      int m = this.b.getPaddingRight();
      int n = this.b.getWidth();
      if (this.b.b == -2) {
        int i3 = this.b.a((SpinnerAdapter)this.a, h());
        int i4 = (this.b.getContext().getResources().getDisplayMetrics()).widthPixels - this.b.c.left - this.b.c.right;
        if (i3 > i4)
          i3 = i4; 
        i1 = Math.max(i3, n - k - m);
      } else if (this.b.b == -1) {
        i1 = n - k - m;
      } else {
        i1 = this.b.b;
      } 
      g(i1);
      if (bu.a(this.b)) {
        i2 = j + n - m - l();
      } else {
        i2 = j + k;
      } 
      c(i2);
    }
  }
  
  class null implements AdapterView.OnItemClickListener {
    null(y this$0, y param1y) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      this.b.b.setSelection(param1Int);
      if (this.b.b.getOnItemClickListener() != null)
        this.b.b.performItemClick(param1View, param1Int, this.b.a.getItemId(param1Int)); 
      this.b.c();
    }
  }
  
  class null implements ViewTreeObserver.OnGlobalLayoutListener {
    null(y this$0) {}
    
    public void onGlobalLayout() {
      y.b b1 = this.a;
      if (!b1.a(b1.b)) {
        this.a.c();
        return;
      } 
      this.a.f();
      y.b.a(this.a);
    }
  }
  
  class null implements PopupWindow.OnDismissListener {
    null(y this$0, ViewTreeObserver.OnGlobalLayoutListener param1OnGlobalLayoutListener) {}
    
    public void onDismiss() {
      ViewTreeObserver viewTreeObserver = this.b.b.getViewTreeObserver();
      if (viewTreeObserver != null)
        viewTreeObserver.removeGlobalOnLayoutListener(this.a); 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */