package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.a;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class be extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
  private static final Interpolator j = new DecelerateInterpolator();
  
  Runnable a;
  
  as b;
  
  int c;
  
  int d;
  
  private b e;
  
  private Spinner f;
  
  private boolean g;
  
  private int h;
  
  private int i;
  
  private boolean a() {
    Spinner spinner = this.f;
    return (spinner != null && spinner.getParent() == this);
  }
  
  private void b() {
    if (a())
      return; 
    if (this.f == null)
      this.f = d(); 
    removeView(this.b);
    addView(this.f, new ViewGroup.LayoutParams(-2, -1));
    if (this.f.getAdapter() == null)
      this.f.setAdapter(new a(this)); 
    Runnable runnable = this.a;
    if (runnable != null) {
      removeCallbacks(runnable);
      this.a = null;
    } 
    this.f.setSelection(this.i);
  }
  
  private boolean c() {
    if (!a())
      return false; 
    removeView(this.f);
    addView(this.b, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.f.getSelectedItemPosition());
    return false;
  }
  
  private Spinner d() {
    y y = new y(getContext(), null, a.a.actionDropDownStyle);
    y.setLayoutParams(new as.a(-2, -1));
    y.setOnItemSelectedListener(this);
    return y;
  }
  
  c a(a.c paramc, boolean paramBoolean) {
    c c1 = new c(this, getContext(), paramc, paramBoolean);
    if (paramBoolean) {
      c1.setBackgroundDrawable(null);
      c1.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
      return c1;
    } 
    c1.setFocusable(true);
    if (this.e == null)
      this.e = new b(this); 
    c1.setOnClickListener(this.e);
    return c1;
  }
  
  public void a(int paramInt) {
    View view = this.b.getChildAt(paramInt);
    Runnable runnable = this.a;
    if (runnable != null)
      removeCallbacks(runnable); 
    this.a = new Runnable(this, view) {
        public void run() {
          int i = this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2;
          this.b.smoothScrollTo(i, 0);
          this.b.a = null;
        }
      };
    post(this.a);
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    Runnable runnable = this.a;
    if (runnable != null)
      post(runnable); 
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    a a1 = a.a(getContext());
    setContentHeight(a1.e());
    this.d = a1.g();
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Runnable runnable = this.a;
    if (runnable != null)
      removeCallbacks(runnable); 
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) { ((c)paramView).b().d(); }
  
  public void onMeasure(int paramInt1, int paramInt2) { // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore_3
    //   5: iconst_1
    //   6: istore #4
    //   8: iload_3
    //   9: ldc 1073741824
    //   11: if_icmpne -> 20
    //   14: iconst_1
    //   15: istore #5
    //   17: goto -> 23
    //   20: iconst_0
    //   21: istore #5
    //   23: aload_0
    //   24: iload #5
    //   26: invokevirtual setFillViewport : (Z)V
    //   29: aload_0
    //   30: getfield b : Landroid/support/v7/widget/as;
    //   33: invokevirtual getChildCount : ()I
    //   36: istore #6
    //   38: iload #6
    //   40: iload #4
    //   42: if_icmple -> 105
    //   45: iload_3
    //   46: ldc 1073741824
    //   48: if_icmpeq -> 57
    //   51: iload_3
    //   52: ldc -2147483648
    //   54: if_icmpne -> 105
    //   57: iload #6
    //   59: iconst_2
    //   60: if_icmple -> 79
    //   63: aload_0
    //   64: ldc 0.4
    //   66: iload_1
    //   67: invokestatic getSize : (I)I
    //   70: i2f
    //   71: fmul
    //   72: f2i
    //   73: putfield c : I
    //   76: goto -> 89
    //   79: aload_0
    //   80: iload_1
    //   81: invokestatic getSize : (I)I
    //   84: iconst_2
    //   85: idiv
    //   86: putfield c : I
    //   89: aload_0
    //   90: getfield c : I
    //   93: aload_0
    //   94: getfield d : I
    //   97: invokestatic min : (II)I
    //   100: istore #7
    //   102: goto -> 108
    //   105: iconst_m1
    //   106: istore #7
    //   108: aload_0
    //   109: iload #7
    //   111: putfield c : I
    //   114: aload_0
    //   115: getfield h : I
    //   118: ldc 1073741824
    //   120: invokestatic makeMeasureSpec : (II)I
    //   123: istore #8
    //   125: iload #5
    //   127: ifne -> 140
    //   130: aload_0
    //   131: getfield g : Z
    //   134: ifeq -> 140
    //   137: goto -> 143
    //   140: iconst_0
    //   141: istore #4
    //   143: iload #4
    //   145: ifeq -> 179
    //   148: aload_0
    //   149: getfield b : Landroid/support/v7/widget/as;
    //   152: iconst_0
    //   153: iload #8
    //   155: invokevirtual measure : (II)V
    //   158: aload_0
    //   159: getfield b : Landroid/support/v7/widget/as;
    //   162: invokevirtual getMeasuredWidth : ()I
    //   165: iload_1
    //   166: invokestatic getSize : (I)I
    //   169: if_icmple -> 179
    //   172: aload_0
    //   173: invokespecial b : ()V
    //   176: goto -> 184
    //   179: aload_0
    //   180: invokespecial c : ()Z
    //   183: pop
    //   184: aload_0
    //   185: invokevirtual getMeasuredWidth : ()I
    //   188: istore #10
    //   190: aload_0
    //   191: iload_1
    //   192: iload #8
    //   194: invokespecial onMeasure : (II)V
    //   197: aload_0
    //   198: invokevirtual getMeasuredWidth : ()I
    //   201: istore #11
    //   203: iload #5
    //   205: ifeq -> 223
    //   208: iload #10
    //   210: iload #11
    //   212: if_icmpeq -> 223
    //   215: aload_0
    //   216: aload_0
    //   217: getfield i : I
    //   220: invokevirtual setTabSelected : (I)V
    //   223: return }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void setAllowCollapse(boolean paramBoolean) { this.g = paramBoolean; }
  
  public void setContentHeight(int paramInt) {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt) {
    this.i = paramInt;
    int k = this.b.getChildCount();
    for (byte b1 = 0; b1 < k; b1++) {
      boolean bool;
      View view = this.b.getChildAt(b1);
      if (b1 == paramInt) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setSelected(bool);
      if (bool)
        a(paramInt); 
    } 
    Spinner spinner = this.f;
    if (spinner != null && paramInt >= 0)
      spinner.setSelection(paramInt); 
  }
  
  private class a extends BaseAdapter {
    a(be this$0) {}
    
    public int getCount() { return this.a.b.getChildCount(); }
    
    public Object getItem(int param1Int) { return ((be.c)this.a.b.getChildAt(param1Int)).b(); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      if (param1View == null)
        return this.a.a((a.c)getItem(param1Int), true); 
      ((be.c)param1View).a((a.c)getItem(param1Int));
      return param1View;
    }
  }
  
  private class b implements View.OnClickListener {
    b(be this$0) {}
    
    public void onClick(View param1View) {
      ((be.c)param1View).b().d();
      int i = this.a.b.getChildCount();
      for (byte b1 = 0; b1 < i; b1++) {
        boolean bool;
        View view = this.a.b.getChildAt(b1);
        if (view == param1View) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setSelected(bool);
      } 
    }
  }
  
  private class c extends LinearLayout {
    private final int[] b = { 16842964 };
    
    private a.c c;
    
    private TextView d;
    
    private ImageView e;
    
    private View f;
    
    public c(be this$0, Context param1Context, a.c param1c, boolean param1Boolean) {
      super(param1Context, null, a.a.actionBarTabStyle);
      this.c = param1c;
      bm bm = bm.a(param1Context, null, this.b, a.a.actionBarTabStyle, 0);
      if (bm.g(0))
        setBackgroundDrawable(bm.a(0)); 
      bm.a();
      if (param1Boolean)
        setGravity(8388627); 
      a();
    }
    
    public void a() {
      a.c c1 = this.c;
      View view = c1.c();
      if (view != null) {
        ViewParent viewParent = view.getParent();
        if (viewParent != this) {
          if (viewParent != null)
            ((ViewGroup)viewParent).removeView(view); 
          addView(view);
        } 
        this.f = view;
        TextView textView = this.d;
        if (textView != null)
          textView.setVisibility(8); 
        ImageView imageView = this.e;
        if (imageView != null) {
          imageView.setVisibility(8);
          this.e.setImageDrawable(null);
          return;
        } 
      } else {
        CharSequence charSequence2;
        View view1 = this.f;
        if (view1 != null) {
          removeView(view1);
          this.f = null;
        } 
        Drawable drawable = c1.a();
        CharSequence charSequence1 = c1.b();
        if (drawable != null) {
          if (this.e == null) {
            q q = new q(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            q.setLayoutParams(layoutParams);
            addView(q, 0);
            this.e = q;
          } 
          this.e.setImageDrawable(drawable);
          this.e.setVisibility(0);
        } else {
          ImageView imageView1 = this.e;
          if (imageView1 != null) {
            imageView1.setVisibility(8);
            this.e.setImageDrawable(null);
          } 
        } 
        boolean bool = true ^ TextUtils.isEmpty(charSequence1);
        if (bool) {
          if (this.d == null) {
            aa aa = new aa(getContext(), null, a.a.actionBarTabTextStyle);
            aa.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            aa.setLayoutParams(layoutParams);
            addView(aa);
            this.d = aa;
          } 
          this.d.setText(charSequence1);
          this.d.setVisibility(0);
        } else {
          TextView textView = this.d;
          if (textView != null) {
            textView.setVisibility(8);
            this.d.setText(null);
          } 
        } 
        ImageView imageView = this.e;
        if (imageView != null)
          imageView.setContentDescription(c1.e()); 
        if (bool) {
          charSequence2 = null;
        } else {
          charSequence2 = c1.e();
        } 
        bo.a(this, charSequence2);
      } 
    }
    
    public void a(a.c param1c) {
      this.c = param1c;
      a();
    }
    
    public a.c b() { return this.c; }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(a.c.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      super.onInitializeAccessibilityNodeInfo(param1AccessibilityNodeInfo);
      param1AccessibilityNodeInfo.setClassName(a.c.class.getName());
    }
    
    public void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, param1Int2);
      if (this.a.c > 0 && getMeasuredWidth() > this.a.c)
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a.c, 1073741824), param1Int2); 
    }
    
    public void setSelected(boolean param1Boolean) {
      boolean bool;
      if (isSelected() != param1Boolean) {
        bool = true;
      } else {
        bool = false;
      } 
      super.setSelected(param1Boolean);
      if (bool && param1Boolean)
        sendAccessibilityEvent(4); 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */