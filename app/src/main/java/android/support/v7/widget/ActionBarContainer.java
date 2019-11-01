package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
  Drawable a;
  
  Drawable b;
  
  Drawable c;
  
  boolean d;
  
  boolean e;
  
  private boolean f;
  
  private View g;
  
  private View h;
  
  private View i;
  
  private int j;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet) { // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: new android/support/v7/widget/b
    //   10: dup
    //   11: aload_0
    //   12: invokespecial <init> : (Landroid/support/v7/widget/ActionBarContainer;)V
    //   15: invokestatic a : (Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic android/support/v7/a/a$j.ActionBar : [I
    //   23: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: getstatic android/support/v7/a/a$j.ActionBar_background : I
    //   32: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   35: putfield a : Landroid/graphics/drawable/Drawable;
    //   38: aload_0
    //   39: aload_3
    //   40: getstatic android/support/v7/a/a$j.ActionBar_backgroundStacked : I
    //   43: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   46: putfield b : Landroid/graphics/drawable/Drawable;
    //   49: aload_0
    //   50: aload_3
    //   51: getstatic android/support/v7/a/a$j.ActionBar_height : I
    //   54: iconst_m1
    //   55: invokevirtual getDimensionPixelSize : (II)I
    //   58: putfield j : I
    //   61: aload_0
    //   62: invokevirtual getId : ()I
    //   65: getstatic android/support/v7/a/a$f.split_action_bar : I
    //   68: if_icmpne -> 87
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield d : Z
    //   76: aload_0
    //   77: aload_3
    //   78: getstatic android/support/v7/a/a$j.ActionBar_backgroundSplit : I
    //   81: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   84: putfield c : Landroid/graphics/drawable/Drawable;
    //   87: aload_3
    //   88: invokevirtual recycle : ()V
    //   91: aload_0
    //   92: getfield d : Z
    //   95: ifeq -> 118
    //   98: aload_0
    //   99: getfield c : Landroid/graphics/drawable/Drawable;
    //   102: astore #7
    //   104: iconst_0
    //   105: istore #5
    //   107: aload #7
    //   109: ifnonnull -> 149
    //   112: iconst_1
    //   113: istore #5
    //   115: goto -> 149
    //   118: aload_0
    //   119: getfield a : Landroid/graphics/drawable/Drawable;
    //   122: astore #4
    //   124: iconst_0
    //   125: istore #5
    //   127: aload #4
    //   129: ifnonnull -> 149
    //   132: aload_0
    //   133: getfield b : Landroid/graphics/drawable/Drawable;
    //   136: astore #6
    //   138: iconst_0
    //   139: istore #5
    //   141: aload #6
    //   143: ifnonnull -> 149
    //   146: goto -> 112
    //   149: aload_0
    //   150: iload #5
    //   152: invokevirtual setWillNotDraw : (Z)V
    //   155: return }
  
  private boolean a(View paramView) { return (paramView == null || paramView.getVisibility() == 8 || paramView.getMeasuredHeight() == 0); }
  
  private int b(View paramView) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    Drawable drawable1 = this.a;
    if (drawable1 != null && drawable1.isStateful())
      this.a.setState(getDrawableState()); 
    Drawable drawable2 = this.b;
    if (drawable2 != null && drawable2.isStateful())
      this.b.setState(getDrawableState()); 
    Drawable drawable3 = this.c;
    if (drawable3 != null && drawable3.isStateful())
      this.c.setState(getDrawableState()); 
  }
  
  public View getTabContainer() { return this.g; }
  
  public void jumpDrawablesToCurrentState() {
    super.jumpDrawablesToCurrentState();
    Drawable drawable1 = this.a;
    if (drawable1 != null)
      drawable1.jumpToCurrentState(); 
    Drawable drawable2 = this.b;
    if (drawable2 != null)
      drawable2.jumpToCurrentState(); 
    Drawable drawable3 = this.c;
    if (drawable3 != null)
      drawable3.jumpToCurrentState(); 
  }
  
  public void onFinishInflate() {
    super.onFinishInflate();
    this.h = findViewById(a.f.action_bar);
    this.i = findViewById(a.f.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) { return (this.f || super.onInterceptTouchEvent(paramMotionEvent)); }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload #4
    //   6: iload #5
    //   8: invokespecial onLayout : (ZIIII)V
    //   11: aload_0
    //   12: getfield g : Landroid/view/View;
    //   15: astore #6
    //   17: iconst_1
    //   18: istore #7
    //   20: aload #6
    //   22: ifnull -> 41
    //   25: aload #6
    //   27: invokevirtual getVisibility : ()I
    //   30: bipush #8
    //   32: if_icmpeq -> 41
    //   35: iconst_1
    //   36: istore #8
    //   38: goto -> 44
    //   41: iconst_0
    //   42: istore #8
    //   44: aload #6
    //   46: ifnull -> 105
    //   49: aload #6
    //   51: invokevirtual getVisibility : ()I
    //   54: bipush #8
    //   56: if_icmpeq -> 105
    //   59: aload_0
    //   60: invokevirtual getMeasuredHeight : ()I
    //   63: istore #19
    //   65: aload #6
    //   67: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   70: checkcast android/widget/FrameLayout$LayoutParams
    //   73: astore #20
    //   75: aload #6
    //   77: iload_2
    //   78: iload #19
    //   80: aload #6
    //   82: invokevirtual getMeasuredHeight : ()I
    //   85: isub
    //   86: aload #20
    //   88: getfield bottomMargin : I
    //   91: isub
    //   92: iload #4
    //   94: iload #19
    //   96: aload #20
    //   98: getfield bottomMargin : I
    //   101: isub
    //   102: invokevirtual layout : (IIII)V
    //   105: aload_0
    //   106: getfield d : Z
    //   109: ifeq -> 147
    //   112: aload_0
    //   113: getfield c : Landroid/graphics/drawable/Drawable;
    //   116: astore #18
    //   118: aload #18
    //   120: ifnull -> 141
    //   123: aload #18
    //   125: iconst_0
    //   126: iconst_0
    //   127: aload_0
    //   128: invokevirtual getMeasuredWidth : ()I
    //   131: aload_0
    //   132: invokevirtual getMeasuredHeight : ()I
    //   135: invokevirtual setBounds : (IIII)V
    //   138: goto -> 358
    //   141: iconst_0
    //   142: istore #7
    //   144: goto -> 358
    //   147: aload_0
    //   148: getfield a : Landroid/graphics/drawable/Drawable;
    //   151: astore #9
    //   153: iconst_0
    //   154: istore #10
    //   156: aload #9
    //   158: ifnull -> 304
    //   161: aload_0
    //   162: getfield h : Landroid/view/View;
    //   165: invokevirtual getVisibility : ()I
    //   168: ifne -> 229
    //   171: aload_0
    //   172: getfield a : Landroid/graphics/drawable/Drawable;
    //   175: astore #13
    //   177: aload_0
    //   178: getfield h : Landroid/view/View;
    //   181: invokevirtual getLeft : ()I
    //   184: istore #14
    //   186: aload_0
    //   187: getfield h : Landroid/view/View;
    //   190: invokevirtual getTop : ()I
    //   193: istore #15
    //   195: aload_0
    //   196: getfield h : Landroid/view/View;
    //   199: invokevirtual getRight : ()I
    //   202: istore #16
    //   204: aload_0
    //   205: getfield h : Landroid/view/View;
    //   208: astore #17
    //   210: aload #13
    //   212: iload #14
    //   214: iload #15
    //   216: iload #16
    //   218: aload #17
    //   220: invokevirtual getBottom : ()I
    //   223: invokevirtual setBounds : (IIII)V
    //   226: goto -> 301
    //   229: aload_0
    //   230: getfield i : Landroid/view/View;
    //   233: astore #12
    //   235: aload #12
    //   237: ifnull -> 290
    //   240: aload #12
    //   242: invokevirtual getVisibility : ()I
    //   245: ifne -> 290
    //   248: aload_0
    //   249: getfield a : Landroid/graphics/drawable/Drawable;
    //   252: astore #13
    //   254: aload_0
    //   255: getfield i : Landroid/view/View;
    //   258: invokevirtual getLeft : ()I
    //   261: istore #14
    //   263: aload_0
    //   264: getfield i : Landroid/view/View;
    //   267: invokevirtual getTop : ()I
    //   270: istore #15
    //   272: aload_0
    //   273: getfield i : Landroid/view/View;
    //   276: invokevirtual getRight : ()I
    //   279: istore #16
    //   281: aload_0
    //   282: getfield i : Landroid/view/View;
    //   285: astore #17
    //   287: goto -> 210
    //   290: aload_0
    //   291: getfield a : Landroid/graphics/drawable/Drawable;
    //   294: iconst_0
    //   295: iconst_0
    //   296: iconst_0
    //   297: iconst_0
    //   298: invokevirtual setBounds : (IIII)V
    //   301: iconst_1
    //   302: istore #10
    //   304: aload_0
    //   305: iload #8
    //   307: putfield e : Z
    //   310: iload #8
    //   312: ifeq -> 354
    //   315: aload_0
    //   316: getfield b : Landroid/graphics/drawable/Drawable;
    //   319: astore #11
    //   321: aload #11
    //   323: ifnull -> 354
    //   326: aload #11
    //   328: aload #6
    //   330: invokevirtual getLeft : ()I
    //   333: aload #6
    //   335: invokevirtual getTop : ()I
    //   338: aload #6
    //   340: invokevirtual getRight : ()I
    //   343: aload #6
    //   345: invokevirtual getBottom : ()I
    //   348: invokevirtual setBounds : (IIII)V
    //   351: goto -> 358
    //   354: iload #10
    //   356: istore #7
    //   358: iload #7
    //   360: ifeq -> 367
    //   363: aload_0
    //   364: invokevirtual invalidate : ()V
    //   367: return }
  
  public void onMeasure(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/view/View;
    //   4: ifnonnull -> 42
    //   7: iload_2
    //   8: invokestatic getMode : (I)I
    //   11: ldc -2147483648
    //   13: if_icmpne -> 42
    //   16: aload_0
    //   17: getfield j : I
    //   20: istore #8
    //   22: iload #8
    //   24: iflt -> 42
    //   27: iload #8
    //   29: iload_2
    //   30: invokestatic getSize : (I)I
    //   33: invokestatic min : (II)I
    //   36: ldc -2147483648
    //   38: invokestatic makeMeasureSpec : (II)I
    //   41: istore_2
    //   42: aload_0
    //   43: iload_1
    //   44: iload_2
    //   45: invokespecial onMeasure : (II)V
    //   48: aload_0
    //   49: getfield h : Landroid/view/View;
    //   52: ifnonnull -> 56
    //   55: return
    //   56: iload_2
    //   57: invokestatic getMode : (I)I
    //   60: istore_3
    //   61: aload_0
    //   62: getfield g : Landroid/view/View;
    //   65: astore #4
    //   67: aload #4
    //   69: ifnull -> 182
    //   72: aload #4
    //   74: invokevirtual getVisibility : ()I
    //   77: bipush #8
    //   79: if_icmpeq -> 182
    //   82: iload_3
    //   83: ldc 1073741824
    //   85: if_icmpeq -> 182
    //   88: aload_0
    //   89: aload_0
    //   90: getfield h : Landroid/view/View;
    //   93: invokespecial a : (Landroid/view/View;)Z
    //   96: ifne -> 116
    //   99: aload_0
    //   100: getfield h : Landroid/view/View;
    //   103: astore #7
    //   105: aload_0
    //   106: aload #7
    //   108: invokespecial b : (Landroid/view/View;)I
    //   111: istore #5
    //   113: goto -> 139
    //   116: aload_0
    //   117: aload_0
    //   118: getfield i : Landroid/view/View;
    //   121: invokespecial a : (Landroid/view/View;)Z
    //   124: ifne -> 136
    //   127: aload_0
    //   128: getfield i : Landroid/view/View;
    //   131: astore #7
    //   133: goto -> 105
    //   136: iconst_0
    //   137: istore #5
    //   139: iload_3
    //   140: ldc -2147483648
    //   142: if_icmpne -> 154
    //   145: iload_2
    //   146: invokestatic getSize : (I)I
    //   149: istore #6
    //   151: goto -> 158
    //   154: ldc 2147483647
    //   156: istore #6
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual getMeasuredWidth : ()I
    //   163: iload #5
    //   165: aload_0
    //   166: aload_0
    //   167: getfield g : Landroid/view/View;
    //   170: invokespecial b : (Landroid/view/View;)I
    //   173: iadd
    //   174: iload #6
    //   176: invokestatic min : (II)I
    //   179: invokevirtual setMeasuredDimension : (II)V
    //   182: return }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable) {
    Drawable drawable = this.a;
    if (drawable != null) {
      drawable.setCallback(null);
      unscheduleDrawable(this.a);
    } 
    this.a = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
      View view = this.h;
      if (view != null)
        this.a.setBounds(view.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom()); 
    } 
    boolean bool1 = this.d;
    boolean bool2 = true;
    if (bool1 ? (this.c == null) : (this.a == null && this.b == null))
      bool2 = false; 
    setWillNotDraw(bool2);
    invalidate();
  }
  
  public void setSplitBackground(Drawable paramDrawable) { // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/graphics/drawable/Drawable;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull -> 22
    //   9: aload_2
    //   10: aconst_null
    //   11: invokevirtual setCallback : (Landroid/graphics/drawable/Drawable$Callback;)V
    //   14: aload_0
    //   15: aload_0
    //   16: getfield c : Landroid/graphics/drawable/Drawable;
    //   19: invokevirtual unscheduleDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   22: aload_0
    //   23: aload_1
    //   24: putfield c : Landroid/graphics/drawable/Drawable;
    //   27: aload_1
    //   28: ifnull -> 69
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual setCallback : (Landroid/graphics/drawable/Drawable$Callback;)V
    //   36: aload_0
    //   37: getfield d : Z
    //   40: ifeq -> 69
    //   43: aload_0
    //   44: getfield c : Landroid/graphics/drawable/Drawable;
    //   47: astore #7
    //   49: aload #7
    //   51: ifnull -> 69
    //   54: aload #7
    //   56: iconst_0
    //   57: iconst_0
    //   58: aload_0
    //   59: invokevirtual getMeasuredWidth : ()I
    //   62: aload_0
    //   63: invokevirtual getMeasuredHeight : ()I
    //   66: invokevirtual setBounds : (IIII)V
    //   69: aload_0
    //   70: getfield d : Z
    //   73: ifeq -> 96
    //   76: aload_0
    //   77: getfield c : Landroid/graphics/drawable/Drawable;
    //   80: astore #6
    //   82: iconst_0
    //   83: istore #4
    //   85: aload #6
    //   87: ifnonnull -> 125
    //   90: iconst_1
    //   91: istore #4
    //   93: goto -> 125
    //   96: aload_0
    //   97: getfield a : Landroid/graphics/drawable/Drawable;
    //   100: astore_3
    //   101: iconst_0
    //   102: istore #4
    //   104: aload_3
    //   105: ifnonnull -> 125
    //   108: aload_0
    //   109: getfield b : Landroid/graphics/drawable/Drawable;
    //   112: astore #5
    //   114: iconst_0
    //   115: istore #4
    //   117: aload #5
    //   119: ifnonnull -> 125
    //   122: goto -> 90
    //   125: aload_0
    //   126: iload #4
    //   128: invokevirtual setWillNotDraw : (Z)V
    //   131: aload_0
    //   132: invokevirtual invalidate : ()V
    //   135: return }
  
  public void setStackedBackground(Drawable paramDrawable) {
    Drawable drawable = this.b;
    if (drawable != null) {
      drawable.setCallback(null);
      unscheduleDrawable(this.b);
    } 
    this.b = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
      if (this.e) {
        Drawable drawable1 = this.b;
        if (drawable1 != null)
          drawable1.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom()); 
      } 
    } 
    boolean bool1 = this.d;
    boolean bool2 = true;
    if (bool1 ? (this.c == null) : (this.a == null && this.b == null))
      bool2 = false; 
    setWillNotDraw(bool2);
    invalidate();
  }
  
  public void setTabContainer(be parambe) {
    View view = this.g;
    if (view != null)
      removeView(view); 
    this.g = parambe;
    if (parambe != null) {
      addView(parambe);
      ViewGroup.LayoutParams layoutParams = parambe.getLayoutParams();
      layoutParams.width = -1;
      layoutParams.height = -2;
      parambe.setAllowCollapse(false);
    } 
  }
  
  public void setTransitioning(boolean paramBoolean) {
    int k;
    this.f = paramBoolean;
    if (paramBoolean) {
      k = 393216;
    } else {
      k = 262144;
    } 
    setDescendantFocusability(k);
  }
  
  public void setVisibility(int paramInt) {
    boolean bool;
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable1 = this.a;
    if (drawable1 != null)
      drawable1.setVisible(bool, false); 
    Drawable drawable2 = this.b;
    if (drawable2 != null)
      drawable2.setVisible(bool, false); 
    Drawable drawable3 = this.c;
    if (drawable3 != null)
      drawable3.setVisible(bool, false); 
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback) { return null; }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt) { return (paramInt != 0) ? super.startActionModeForChild(paramView, paramCallback, paramInt) : null; }
  
  protected boolean verifyDrawable(Drawable paramDrawable) { return ((paramDrawable == this.a && !this.d) || (paramDrawable == this.b && this.e) || (paramDrawable == this.c && this.d) || super.verifyDrawable(paramDrawable)); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */