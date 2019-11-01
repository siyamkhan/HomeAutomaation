package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.v;
import android.support.v4.widget.i;
import android.support.v7.a.a;
import android.support.v7.d.a.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class am extends ListView {
  b a;
  
  private final Rect b = new Rect();
  
  private int c = 0;
  
  private int d = 0;
  
  private int e = 0;
  
  private int f = 0;
  
  private int g;
  
  private Field h;
  
  private a i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private v m;
  
  private i n;
  
  am(Context paramContext, boolean paramBoolean) {
    super(paramContext, null, a.a.dropDownListViewStyle);
    this.k = paramBoolean;
    setCacheColorHint(0);
    try {
      this.h = android.widget.AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.h.setAccessible(true);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      return;
    } 
  }
  
  private void a() {
    Drawable drawable = getSelector();
    if (drawable != null && c() && isPressed())
      drawable.setState(getDrawableState()); 
  }
  
  private void a(int paramInt, View paramView) {
    boolean bool1;
    Drawable drawable = getSelector();
    boolean bool = true;
    if (drawable != null && paramInt != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1)
      drawable.setVisible(false, false); 
    b(paramInt, paramView);
    if (bool1) {
      Rect rect = this.b;
      float f1 = rect.exactCenterX();
      float f2 = rect.exactCenterY();
      if (getVisibility() != 0)
        bool = false; 
      drawable.setVisible(bool, false);
      a.a(drawable, f1, f2);
    } 
  }
  
  private void a(int paramInt, View paramView, float paramFloat1, float paramFloat2) {
    a(paramInt, paramView);
    Drawable drawable = getSelector();
    if (drawable != null && paramInt != -1)
      a.a(drawable, paramFloat1, paramFloat2); 
  }
  
  private void a(Canvas paramCanvas) {
    if (!this.b.isEmpty()) {
      Drawable drawable = getSelector();
      if (drawable != null) {
        drawable.setBounds(this.b);
        drawable.draw(paramCanvas);
      } 
    } 
  }
  
  private void a(View paramView, int paramInt) { performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt)); }
  
  private void a(View paramView, int paramInt, float paramFloat1, float paramFloat2) {
    this.l = true;
    if (Build.VERSION.SDK_INT >= 21)
      drawableHotspotChanged(paramFloat1, paramFloat2); 
    if (!isPressed())
      setPressed(true); 
    layoutChildren();
    int i1 = this.g;
    if (i1 != -1) {
      View view = getChildAt(i1 - getFirstVisiblePosition());
      if (view != null && view != paramView && view.isPressed())
        view.setPressed(false); 
    } 
    this.g = paramInt;
    float f1 = paramFloat1 - paramView.getLeft();
    float f2 = paramFloat2 - paramView.getTop();
    if (Build.VERSION.SDK_INT >= 21)
      paramView.drawableHotspotChanged(f1, f2); 
    if (!paramView.isPressed())
      paramView.setPressed(true); 
    a(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private void b() {
    this.l = false;
    setPressed(false);
    drawableStateChanged();
    View view = getChildAt(this.g - getFirstVisiblePosition());
    if (view != null)
      view.setPressed(false); 
    v v1 = this.m;
    if (v1 != null) {
      v1.b();
      this.m = null;
    } 
  }
  
  private void b(int paramInt, View paramView) {
    Rect rect = this.b;
    rect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    rect.left -= this.c;
    rect.top -= this.d;
    rect.right += this.e;
    rect.bottom += this.f;
    try {
      boolean bool = this.h.getBoolean(this);
      if (paramView.isEnabled() != bool) {
        boolean bool1;
        Field field = this.h;
        if (!bool) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        field.set(this, Boolean.valueOf(bool1));
        if (paramInt != -1) {
          refreshDrawableState();
          return;
        } 
      } 
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } 
  }
  
  private boolean c() { return this.l; }
  
  private void setSelectorEnabled(boolean paramBoolean) {
    a a1 = this.i;
    if (a1 != null)
      a1.a(paramBoolean); 
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i1 = getListPaddingTop();
    int i2 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int i3 = getDividerHeight();
    Drawable drawable = getDivider();
    ListAdapter listAdapter = getAdapter();
    if (listAdapter == null)
      return i1 + i2; 
    int i4 = i1 + i2;
    if (i3 <= 0 || drawable == null)
      i3 = 0; 
    int i5 = listAdapter.getCount();
    int i6 = i4;
    View view = null;
    byte b1 = 0;
    int i7 = 0;
    int i8 = 0;
    while (b1 < i5) {
      int i10;
      int i9 = listAdapter.getItemViewType(b1);
      if (i9 != i7) {
        view = null;
        i7 = i9;
      } 
      view = listAdapter.getView(b1, view, this);
      ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
      if (layoutParams == null) {
        layoutParams = generateDefaultLayoutParams();
        view.setLayoutParams(layoutParams);
      } 
      if (layoutParams.height > 0) {
        i10 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
      } else {
        i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
      } 
      view.measure(paramInt1, i10);
      view.forceLayout();
      if (b1 > 0)
        i6 += i3; 
      i6 += view.getMeasuredHeight();
      if (i6 >= paramInt4) {
        if (paramInt5 >= 0 && b1 > paramInt5 && i8 && i6 != paramInt4)
          paramInt4 = i8; 
        return paramInt4;
      } 
      if (paramInt5 >= 0 && b1 >= paramInt5)
        i8 = i6; 
      b1++;
    } 
    return i6;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: tableswitch default -> 32, 1 -> 56, 2 -> 50, 3 -> 41
    //   32: iconst_1
    //   33: istore #4
    //   35: iconst_0
    //   36: istore #10
    //   38: goto -> 157
    //   41: iconst_0
    //   42: istore #4
    //   44: iconst_0
    //   45: istore #10
    //   47: goto -> 157
    //   50: iconst_1
    //   51: istore #4
    //   53: goto -> 59
    //   56: iconst_0
    //   57: istore #4
    //   59: aload_1
    //   60: iload_2
    //   61: invokevirtual findPointerIndex : (I)I
    //   64: istore #5
    //   66: iload #5
    //   68: ifge -> 74
    //   71: goto -> 41
    //   74: aload_1
    //   75: iload #5
    //   77: invokevirtual getX : (I)F
    //   80: f2i
    //   81: istore #6
    //   83: aload_1
    //   84: iload #5
    //   86: invokevirtual getY : (I)F
    //   89: f2i
    //   90: istore #7
    //   92: aload_0
    //   93: iload #6
    //   95: iload #7
    //   97: invokevirtual pointToPosition : (II)I
    //   100: istore #8
    //   102: iload #8
    //   104: iconst_m1
    //   105: if_icmpne -> 114
    //   108: iconst_1
    //   109: istore #10
    //   111: goto -> 157
    //   114: aload_0
    //   115: iload #8
    //   117: aload_0
    //   118: invokevirtual getFirstVisiblePosition : ()I
    //   121: isub
    //   122: invokevirtual getChildAt : (I)Landroid/view/View;
    //   125: astore #9
    //   127: aload_0
    //   128: aload #9
    //   130: iload #8
    //   132: iload #6
    //   134: i2f
    //   135: iload #7
    //   137: i2f
    //   138: invokespecial a : (Landroid/view/View;IFF)V
    //   141: iload_3
    //   142: iconst_1
    //   143: if_icmpne -> 32
    //   146: aload_0
    //   147: aload #9
    //   149: iload #8
    //   151: invokespecial a : (Landroid/view/View;I)V
    //   154: goto -> 32
    //   157: iload #4
    //   159: ifeq -> 167
    //   162: iload #10
    //   164: ifeq -> 171
    //   167: aload_0
    //   168: invokespecial b : ()V
    //   171: iload #4
    //   173: ifeq -> 217
    //   176: aload_0
    //   177: getfield n : Landroid/support/v4/widget/i;
    //   180: ifnonnull -> 195
    //   183: aload_0
    //   184: new android/support/v4/widget/i
    //   187: dup
    //   188: aload_0
    //   189: invokespecial <init> : (Landroid/widget/ListView;)V
    //   192: putfield n : Landroid/support/v4/widget/i;
    //   195: aload_0
    //   196: getfield n : Landroid/support/v4/widget/i;
    //   199: iconst_1
    //   200: invokevirtual a : (Z)Landroid/support/v4/widget/a;
    //   203: pop
    //   204: aload_0
    //   205: getfield n : Landroid/support/v4/widget/i;
    //   208: aload_0
    //   209: aload_1
    //   210: invokevirtual onTouch : (Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   213: pop
    //   214: iload #4
    //   216: ireturn
    //   217: aload_0
    //   218: getfield n : Landroid/support/v4/widget/i;
    //   221: astore #11
    //   223: aload #11
    //   225: ifnull -> 235
    //   228: aload #11
    //   230: iconst_0
    //   231: invokevirtual a : (Z)Landroid/support/v4/widget/a;
    //   234: pop
    //   235: iload #4
    //   237: ireturn }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    a(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged() {
    if (this.a != null)
      return; 
    super.drawableStateChanged();
    setSelectorEnabled(true);
    a();
  }
  
  public boolean hasFocus() { return (this.k || super.hasFocus()); }
  
  public boolean hasWindowFocus() { return (this.k || super.hasWindowFocus()); }
  
  public boolean isFocused() { return (this.k || super.isFocused()); }
  
  public boolean isInTouchMode() { return ((this.k && this.j) || super.isInTouchMode()); }
  
  protected void onDetachedFromWindow() {
    this.a = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    if (Build.VERSION.SDK_INT < 26)
      return super.onHoverEvent(paramMotionEvent); 
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 10 && this.a == null) {
      this.a = new b(this);
      this.a.b();
    } 
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if (i1 == 9 || i1 == 7) {
      int i2 = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (i2 != -1 && i2 != getSelectedItemPosition()) {
        View view = getChildAt(i2 - getFirstVisiblePosition());
        if (view.isEnabled())
          setSelectionFromTop(i2, view.getTop() - getTop()); 
        a();
      } 
      return bool;
    } 
    setSelection(-1);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0)
      this.g = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()); 
    b b1 = this.a;
    if (b1 != null)
      b1.a(); 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void setListSelectionHidden(boolean paramBoolean) { this.j = paramBoolean; }
  
  public void setSelector(Drawable paramDrawable) {
    Object object;
    if (paramDrawable != null) {
      object = new a(paramDrawable);
    } else {
      object = null;
    } 
    this.i = object;
    super.setSelector(this.i);
    Rect rect = new Rect();
    if (paramDrawable != null)
      paramDrawable.getPadding(rect); 
    this.c = rect.left;
    this.d = rect.top;
    this.e = rect.right;
    this.f = rect.bottom;
  }
  
  private static class a extends c {
    private boolean a = true;
    
    a(Drawable param1Drawable) { super(param1Drawable); }
    
    void a(boolean param1Boolean) { this.a = param1Boolean; }
    
    public void draw(Canvas param1Canvas) {
      if (this.a)
        super.draw(param1Canvas); 
    }
    
    public void setHotspot(float param1Float1, float param1Float2) {
      if (this.a)
        super.setHotspot(param1Float1, param1Float2); 
    }
    
    public void setHotspotBounds(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (this.a)
        super.setHotspotBounds(param1Int1, param1Int2, param1Int3, param1Int4); 
    }
    
    public boolean setState(int[] param1ArrayOfInt) { return this.a ? super.setState(param1ArrayOfInt) : 0; }
    
    public boolean setVisible(boolean param1Boolean1, boolean param1Boolean2) { return this.a ? super.setVisible(param1Boolean1, param1Boolean2) : 0; }
  }
  
  private class b implements Runnable {
    b(am this$0) {}
    
    public void a() {
      am am1 = this.a;
      am1.a = null;
      am1.removeCallbacks(this);
    }
    
    public void b() { this.a.post(this); }
    
    public void run() {
      am am1 = this.a;
      am1.a = null;
      am1.drawableStateChanged();
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */