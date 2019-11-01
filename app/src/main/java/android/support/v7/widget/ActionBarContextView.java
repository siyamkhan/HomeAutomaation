package android.support.v7.widget;

import android.content.Context;
import android.support.v4.h.r;
import android.support.v4.h.v;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
  private CharSequence g;
  
  private CharSequence h;
  
  private View i;
  
  private View j;
  
  private LinearLayout k;
  
  private TextView l;
  
  private TextView m;
  
  private int n;
  
  private int o;
  
  private boolean p;
  
  private int q;
  
  public ActionBarContextView(Context paramContext) { this(paramContext, null); }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.actionModeStyle); }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    bm bm = bm.a(paramContext, paramAttributeSet, a.j.ActionMode, paramInt, 0);
    r.a(this, bm.a(a.j.ActionMode_background));
    this.n = bm.g(a.j.ActionMode_titleTextStyle, 0);
    this.o = bm.g(a.j.ActionMode_subtitleTextStyle, 0);
    this.e = bm.f(a.j.ActionMode_height, 0);
    this.q = bm.g(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
    bm.a();
  }
  
  private void e() {
    byte b1;
    if (this.k == null) {
      LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
      this.k = (LinearLayout)getChildAt(-1 + getChildCount());
      this.l = (TextView)this.k.findViewById(a.f.action_bar_title);
      this.m = (TextView)this.k.findViewById(a.f.action_bar_subtitle);
      if (this.n != 0)
        this.l.setTextAppearance(getContext(), this.n); 
      if (this.o != 0)
        this.m.setTextAppearance(getContext(), this.o); 
    } 
    this.l.setText(this.g);
    this.m.setText(this.h);
    boolean bool1 = true ^ TextUtils.isEmpty(this.g);
    boolean bool2 = true ^ TextUtils.isEmpty(this.h);
    TextView textView = this.m;
    if (bool2) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    textView.setVisibility(b1);
    LinearLayout linearLayout = this.k;
    byte b2 = 0;
    if (!bool1)
      if (bool2) {
        b2 = 0;
      } else {
        b2 = 8;
      }  
    linearLayout.setVisibility(b2);
    if (this.k.getParent() == null)
      addView(this.k); 
  }
  
  public void a(b paramb) { // Byte code:
    //   0: aload_0
    //   1: getfield i : Landroid/view/View;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull -> 40
    //   9: aload_0
    //   10: aload_0
    //   11: invokevirtual getContext : ()Landroid/content/Context;
    //   14: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   17: aload_0
    //   18: getfield q : I
    //   21: aload_0
    //   22: iconst_0
    //   23: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   26: putfield i : Landroid/view/View;
    //   29: aload_0
    //   30: aload_0
    //   31: getfield i : Landroid/view/View;
    //   34: invokevirtual addView : (Landroid/view/View;)V
    //   37: goto -> 50
    //   40: aload_2
    //   41: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   44: ifnonnull -> 50
    //   47: goto -> 29
    //   50: aload_0
    //   51: getfield i : Landroid/view/View;
    //   54: getstatic android/support/v7/a/a$f.action_mode_close_button : I
    //   57: invokevirtual findViewById : (I)Landroid/view/View;
    //   60: new android/support/v7/widget/ActionBarContextView$1
    //   63: dup
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial <init> : (Landroid/support/v7/widget/ActionBarContextView;Landroid/support/v7/view/b;)V
    //   69: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   72: aload_1
    //   73: invokevirtual b : ()Landroid/view/Menu;
    //   76: checkcast android/support/v7/view/menu/h
    //   79: astore_3
    //   80: aload_0
    //   81: getfield d : Landroid/support/v7/widget/c;
    //   84: ifnull -> 95
    //   87: aload_0
    //   88: getfield d : Landroid/support/v7/widget/c;
    //   91: invokevirtual f : ()Z
    //   94: pop
    //   95: aload_0
    //   96: new android/support/v7/widget/c
    //   99: dup
    //   100: aload_0
    //   101: invokevirtual getContext : ()Landroid/content/Context;
    //   104: invokespecial <init> : (Landroid/content/Context;)V
    //   107: putfield d : Landroid/support/v7/widget/c;
    //   110: aload_0
    //   111: getfield d : Landroid/support/v7/widget/c;
    //   114: iconst_1
    //   115: invokevirtual c : (Z)V
    //   118: new android/view/ViewGroup$LayoutParams
    //   121: dup
    //   122: bipush #-2
    //   124: iconst_m1
    //   125: invokespecial <init> : (II)V
    //   128: astore #4
    //   130: aload_3
    //   131: aload_0
    //   132: getfield d : Landroid/support/v7/widget/c;
    //   135: aload_0
    //   136: getfield b : Landroid/content/Context;
    //   139: invokevirtual a : (Landroid/support/v7/view/menu/o;Landroid/content/Context;)V
    //   142: aload_0
    //   143: aload_0
    //   144: getfield d : Landroid/support/v7/widget/c;
    //   147: aload_0
    //   148: invokevirtual a : (Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/p;
    //   151: checkcast android/support/v7/widget/ActionMenuView
    //   154: putfield c : Landroid/support/v7/widget/ActionMenuView;
    //   157: aload_0
    //   158: getfield c : Landroid/support/v7/widget/ActionMenuView;
    //   161: aconst_null
    //   162: invokestatic a : (Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   165: aload_0
    //   166: aload_0
    //   167: getfield c : Landroid/support/v7/widget/ActionMenuView;
    //   170: aload #4
    //   172: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   175: return }
  
  public boolean a() { return (this.d != null) ? this.d.d() : 0; }
  
  public void b() {
    if (this.i == null)
      c(); 
  }
  
  public void c() {
    removeAllViews();
    this.j = null;
    this.c = null;
  }
  
  public boolean d() { return this.p; }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() { return new ViewGroup.MarginLayoutParams(-1, -2); }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) { return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet); }
  
  public CharSequence getSubtitle() { return this.h; }
  
  public CharSequence getTitle() { return this.g; }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.d != null) {
      this.d.e();
      this.d.g();
    } 
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    if (paramAccessibilityEvent.getEventType() == 32) {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.g);
      return;
    } 
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i6;
    int i4;
    int i1;
    boolean bool = bu.a(this);
    if (bool) {
      i1 = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i1 = getPaddingLeft();
    } 
    int i2 = getPaddingTop();
    int i3 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    View view1 = this.i;
    if (view1 != null && view1.getVisibility() != 8) {
      int i8;
      int i7;
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
      if (bool) {
        i7 = marginLayoutParams.rightMargin;
      } else {
        i7 = marginLayoutParams.leftMargin;
      } 
      if (bool) {
        i8 = marginLayoutParams.leftMargin;
      } else {
        i8 = marginLayoutParams.rightMargin;
      } 
      int i9 = a(i1, i7, bool);
      i4 = a(i9 + a(this.i, i9, i2, i3, bool), i8, bool);
    } else {
      i4 = i1;
    } 
    LinearLayout linearLayout = this.k;
    if (linearLayout != null && this.j == null && linearLayout.getVisibility() != 8)
      i4 += a(this.k, i4, i2, i3, bool); 
    int i5 = i4;
    View view2 = this.j;
    if (view2 != null)
      a(view2, i5, i2, i3, bool); 
    if (bool) {
      i6 = getPaddingLeft();
    } else {
      i6 = paramInt3 - paramInt1 - getPaddingRight();
    } 
    if (this.c != null)
      a(this.c, i6, i2, i3, bool ^ true); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = 1073741824;
    if (i1 == i2) {
      if (View.MeasureSpec.getMode(paramInt2) != 0) {
        int i4;
        int i3 = View.MeasureSpec.getSize(paramInt1);
        if (this.e > 0) {
          i4 = this.e;
        } else {
          i4 = View.MeasureSpec.getSize(paramInt2);
        } 
        int i5 = getPaddingTop() + getPaddingBottom();
        int i6 = i3 - getPaddingLeft() - getPaddingRight();
        int i7 = i4 - i5;
        int i8 = View.MeasureSpec.makeMeasureSpec(i7, -2147483648);
        View view1 = this.i;
        byte b = 0;
        if (view1 != null) {
          int i9 = a(view1, i6, i8, 0);
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
          i6 = i9 - marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        } 
        if (this.c != null && this.c.getParent() == this)
          i6 = a(this.c, i6, i8, 0); 
        LinearLayout linearLayout = this.k;
        if (linearLayout != null && this.j == null)
          if (this.p) {
            byte b1;
            boolean bool;
            int i9 = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.k.measure(i9, i8);
            int i10 = this.k.getMeasuredWidth();
            if (i10 <= i6) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool)
              i6 -= i10; 
            LinearLayout linearLayout1 = this.k;
            if (bool) {
              b1 = 0;
            } else {
              b1 = 8;
            } 
            linearLayout1.setVisibility(b1);
          } else {
            i6 = a(linearLayout, i6, i8, 0);
          }  
        View view2 = this.j;
        if (view2 != null) {
          int i9;
          ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
          if (layoutParams.width != -2) {
            i9 = 1073741824;
          } else {
            i9 = Integer.MIN_VALUE;
          } 
          if (layoutParams.width >= 0)
            i6 = Math.min(layoutParams.width, i6); 
          if (layoutParams.height == -2)
            i2 = Integer.MIN_VALUE; 
          if (layoutParams.height >= 0)
            i7 = Math.min(layoutParams.height, i7); 
          this.j.measure(View.MeasureSpec.makeMeasureSpec(i6, i9), View.MeasureSpec.makeMeasureSpec(i7, i2));
        } 
        if (this.e <= 0) {
          int i9 = getChildCount();
          int i10 = 0;
          while (b < i9) {
            int i11 = i5 + getChildAt(b).getMeasuredHeight();
            if (i11 > i10)
              i10 = i11; 
            b++;
          } 
          setMeasuredDimension(i3, i10);
          return;
        } 
        setMeasuredDimension(i3, i4);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(getClass().getSimpleName());
      stringBuilder1.append(" can only be used ");
      stringBuilder1.append("with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" can only be used ");
    stringBuilder.append("with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void setContentHeight(int paramInt) { this.e = paramInt; }
  
  public void setCustomView(View paramView) {
    View view = this.j;
    if (view != null)
      removeView(view); 
    this.j = paramView;
    if (paramView != null) {
      LinearLayout linearLayout = this.k;
      if (linearLayout != null) {
        removeView(linearLayout);
        this.k = null;
      } 
    } 
    if (paramView != null)
      addView(paramView); 
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {
    this.h = paramCharSequence;
    e();
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.g = paramCharSequence;
    e();
  }
  
  public void setTitleOptional(boolean paramBoolean) {
    if (paramBoolean != this.p)
      requestLayout(); 
    this.p = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState() { return false; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */