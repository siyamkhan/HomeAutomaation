package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.b.a;
import android.support.v4.a.a;
import android.support.v4.g.i;
import android.support.v4.g.j;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.a;
import android.support.v4.h.d;
import android.support.v4.h.n;
import android.support.v4.h.o;
import android.support.v4.h.p;
import android.support.v4.h.r;
import android.support.v4.h.z;
import android.support.v4.widget.f;
import android.support.v4.widget.r;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements n {
  static final String a;
  
  static final Class<?>[] b;
  
  static final ThreadLocal<Map<String, Constructor<b>>> c;
  
  static final Comparator<View> d;
  
  private static final j.a<Rect> f;
  
  ViewGroup.OnHierarchyChangeListener e;
  
  private final List<View> g = new ArrayList();
  
  private final f<View> h = new f();
  
  private final List<View> i = new ArrayList();
  
  private final List<View> j = new ArrayList();
  
  private final int[] k = new int[2];
  
  private Paint l;
  
  private boolean m;
  
  private boolean n;
  
  private int[] o;
  
  private View p;
  
  private View q;
  
  private f r;
  
  private boolean s;
  
  private z t;
  
  private boolean u;
  
  private Drawable v;
  
  private p w;
  
  private final o x = new o(this);
  
  static  {
    Object object;
    Package package = CoordinatorLayout.class.getPackage();
    if (package != null) {
      object = package.getName();
    } else {
      object = null;
    } 
    a = object;
    if (Build.VERSION.SDK_INT >= 21) {
      d = new h();
    } else {
      d = null;
    } 
    b = new Class[] { Context.class, AttributeSet.class };
    c = new ThreadLocal();
    f = new j.c(12);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.coordinatorLayoutStyle); }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    byte b1 = 0;
    if (paramInt == 0) {
      typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, 0, a.b.Widget_Support_CoordinatorLayout);
    } else {
      typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.CoordinatorLayout, paramInt, 0);
    } 
    int i1 = typedArray.getResourceId(a.c.CoordinatorLayout_keylines, 0);
    if (i1 != 0) {
      Resources resources = paramContext.getResources();
      this.o = resources.getIntArray(i1);
      float f1 = (resources.getDisplayMetrics()).density;
      int i2 = this.o.length;
      while (b1 < i2) {
        int[] arrayOfInt = this.o;
        arrayOfInt[b1] = (int)(f1 * arrayOfInt[b1]);
        b1++;
      } 
    } 
    this.v = typedArray.getDrawable(a.c.CoordinatorLayout_statusBarBackground);
    typedArray.recycle();
    g();
    super.setOnHierarchyChangeListener(new d(this));
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3) { return (paramInt1 < paramInt2) ? paramInt2 : ((paramInt1 > paramInt3) ? paramInt3 : paramInt1); }
  
  static b a(Context paramContext, AttributeSet paramAttributeSet, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.startsWith(".")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
    } else if (paramString.indexOf('.') < 0 && !TextUtils.isEmpty(a)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append('.');
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
    } 
    try {
      Map map = (Map)c.get();
      if (map == null) {
        map = new HashMap();
        c.set(map);
      } 
      Constructor constructor = (Constructor)map.get(paramString);
      if (constructor == null) {
        constructor = paramContext.getClassLoader().loadClass(paramString).getConstructor(b);
        constructor.setAccessible(true);
        map.put(paramString, constructor);
      } 
      return (b)constructor.newInstance(new Object[] { paramContext, paramAttributeSet });
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not inflate Behavior subclass ");
      stringBuilder.append(paramString);
      throw new RuntimeException(stringBuilder.toString(), exception);
    } 
  }
  
  private static void a(Rect paramRect) {
    paramRect.setEmpty();
    f.a(paramRect);
  }
  
  private void a(e parame, Rect paramRect, int paramInt1, int paramInt2) {
    int i1 = getWidth();
    int i2 = getHeight();
    int i3 = Math.max(getPaddingLeft() + parame.leftMargin, Math.min(paramRect.left, i1 - getPaddingRight() - paramInt1 - parame.rightMargin));
    int i4 = Math.max(getPaddingTop() + parame.topMargin, Math.min(paramRect.top, i2 - getPaddingBottom() - paramInt2 - parame.bottomMargin));
    paramRect.set(i3, i4, paramInt1 + i3, paramInt2 + i4);
  }
  
  private void a(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, e parame, int paramInt2, int paramInt3) {
    int i8;
    int i7;
    int i1 = d.a(e(parame.c), paramInt1);
    int i2 = d.a(c(parame.d), paramInt1);
    int i3 = i1 & 0x7;
    int i4 = i1 & 0x70;
    int i5 = i2 & 0x7;
    int i6 = i2 & 0x70;
    if (i5 != 1) {
      if (i5 != 5) {
        i7 = paramRect1.left;
      } else {
        i7 = paramRect1.right;
      } 
    } else {
      i7 = paramRect1.left + paramRect1.width() / 2;
    } 
    if (i6 != 16) {
      if (i6 != 80) {
        i8 = paramRect1.top;
      } else {
        i8 = paramRect1.bottom;
      } 
    } else {
      i8 = paramRect1.top + paramRect1.height() / 2;
    } 
    if (i3 != 1) {
      if (i3 != 5)
        i7 -= paramInt2; 
    } else {
      i7 -= paramInt2 / 2;
    } 
    if (i4 != 16) {
      if (i4 != 80)
        i8 -= paramInt3; 
    } else {
      i8 -= paramInt3 / 2;
    } 
    paramRect2.set(i7, i8, paramInt2 + i7, paramInt3 + i8);
  }
  
  private void a(View paramView, Rect paramRect, int paramInt) { // Byte code:
    //   0: aload_1
    //   1: invokestatic x : (Landroid/view/View;)Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual getWidth : ()I
    //   12: ifle -> 456
    //   15: aload_1
    //   16: invokevirtual getHeight : ()I
    //   19: ifgt -> 23
    //   22: return
    //   23: aload_1
    //   24: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   27: checkcast android/support/design/widget/CoordinatorLayout$e
    //   30: astore #4
    //   32: aload #4
    //   34: invokevirtual b : ()Landroid/support/design/widget/CoordinatorLayout$b;
    //   37: astore #5
    //   39: invokestatic e : ()Landroid/graphics/Rect;
    //   42: astore #6
    //   44: invokestatic e : ()Landroid/graphics/Rect;
    //   47: astore #7
    //   49: aload #7
    //   51: aload_1
    //   52: invokevirtual getLeft : ()I
    //   55: aload_1
    //   56: invokevirtual getTop : ()I
    //   59: aload_1
    //   60: invokevirtual getRight : ()I
    //   63: aload_1
    //   64: invokevirtual getBottom : ()I
    //   67: invokevirtual set : (IIII)V
    //   70: aload #5
    //   72: ifnull -> 162
    //   75: aload #5
    //   77: aload_0
    //   78: aload_1
    //   79: aload #6
    //   81: invokevirtual a : (Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/graphics/Rect;)Z
    //   84: ifeq -> 162
    //   87: aload #7
    //   89: aload #6
    //   91: invokevirtual contains : (Landroid/graphics/Rect;)Z
    //   94: ifeq -> 100
    //   97: goto -> 169
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: astore #15
    //   109: aload #15
    //   111: ldc_w 'Rect should be within the child's bounds. Rect:'
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #15
    //   120: aload #6
    //   122: invokevirtual toShortString : ()Ljava/lang/String;
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #15
    //   131: ldc_w ' | Bounds:'
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload #15
    //   140: aload #7
    //   142: invokevirtual toShortString : ()Ljava/lang/String;
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new java/lang/IllegalArgumentException
    //   152: dup
    //   153: aload #15
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokespecial <init> : (Ljava/lang/String;)V
    //   161: athrow
    //   162: aload #6
    //   164: aload #7
    //   166: invokevirtual set : (Landroid/graphics/Rect;)V
    //   169: aload #7
    //   171: invokestatic a : (Landroid/graphics/Rect;)V
    //   174: aload #6
    //   176: invokevirtual isEmpty : ()Z
    //   179: ifeq -> 188
    //   182: aload #6
    //   184: invokestatic a : (Landroid/graphics/Rect;)V
    //   187: return
    //   188: aload #4
    //   190: getfield h : I
    //   193: iload_3
    //   194: invokestatic a : (II)I
    //   197: istore #8
    //   199: iload #8
    //   201: bipush #48
    //   203: iand
    //   204: bipush #48
    //   206: if_icmpne -> 255
    //   209: aload #6
    //   211: getfield top : I
    //   214: aload #4
    //   216: getfield topMargin : I
    //   219: isub
    //   220: aload #4
    //   222: getfield j : I
    //   225: isub
    //   226: istore #14
    //   228: iload #14
    //   230: aload_2
    //   231: getfield top : I
    //   234: if_icmpge -> 255
    //   237: aload_0
    //   238: aload_1
    //   239: aload_2
    //   240: getfield top : I
    //   243: iload #14
    //   245: isub
    //   246: invokespecial f : (Landroid/view/View;I)V
    //   249: iconst_1
    //   250: istore #9
    //   252: goto -> 258
    //   255: iconst_0
    //   256: istore #9
    //   258: iload #8
    //   260: bipush #80
    //   262: iand
    //   263: bipush #80
    //   265: if_icmpne -> 316
    //   268: aload_0
    //   269: invokevirtual getHeight : ()I
    //   272: aload #6
    //   274: getfield bottom : I
    //   277: isub
    //   278: aload #4
    //   280: getfield bottomMargin : I
    //   283: isub
    //   284: aload #4
    //   286: getfield j : I
    //   289: iadd
    //   290: istore #13
    //   292: iload #13
    //   294: aload_2
    //   295: getfield bottom : I
    //   298: if_icmpge -> 316
    //   301: aload_0
    //   302: aload_1
    //   303: iload #13
    //   305: aload_2
    //   306: getfield bottom : I
    //   309: isub
    //   310: invokespecial f : (Landroid/view/View;I)V
    //   313: iconst_1
    //   314: istore #9
    //   316: iload #9
    //   318: ifne -> 327
    //   321: aload_0
    //   322: aload_1
    //   323: iconst_0
    //   324: invokespecial f : (Landroid/view/View;I)V
    //   327: iload #8
    //   329: iconst_3
    //   330: iand
    //   331: iconst_3
    //   332: if_icmpne -> 381
    //   335: aload #6
    //   337: getfield left : I
    //   340: aload #4
    //   342: getfield leftMargin : I
    //   345: isub
    //   346: aload #4
    //   348: getfield i : I
    //   351: isub
    //   352: istore #12
    //   354: iload #12
    //   356: aload_2
    //   357: getfield left : I
    //   360: if_icmpge -> 381
    //   363: aload_0
    //   364: aload_1
    //   365: aload_2
    //   366: getfield left : I
    //   369: iload #12
    //   371: isub
    //   372: invokespecial e : (Landroid/view/View;I)V
    //   375: iconst_1
    //   376: istore #10
    //   378: goto -> 384
    //   381: iconst_0
    //   382: istore #10
    //   384: iload #8
    //   386: iconst_5
    //   387: iand
    //   388: iconst_5
    //   389: if_icmpne -> 440
    //   392: aload_0
    //   393: invokevirtual getWidth : ()I
    //   396: aload #6
    //   398: getfield right : I
    //   401: isub
    //   402: aload #4
    //   404: getfield rightMargin : I
    //   407: isub
    //   408: aload #4
    //   410: getfield i : I
    //   413: iadd
    //   414: istore #11
    //   416: iload #11
    //   418: aload_2
    //   419: getfield right : I
    //   422: if_icmpge -> 440
    //   425: aload_0
    //   426: aload_1
    //   427: iload #11
    //   429: aload_2
    //   430: getfield right : I
    //   433: isub
    //   434: invokespecial e : (Landroid/view/View;I)V
    //   437: iconst_1
    //   438: istore #10
    //   440: iload #10
    //   442: ifne -> 451
    //   445: aload_0
    //   446: aload_1
    //   447: iconst_0
    //   448: invokespecial e : (Landroid/view/View;I)V
    //   451: aload #6
    //   453: invokestatic a : (Landroid/graphics/Rect;)V
    //   456: return }
  
  private void a(View paramView1, View paramView2, int paramInt) {
    rect1 = e();
    rect2 = e();
    try {
      a(paramView2, rect1);
      a(paramView1, paramInt, rect1, rect2);
      paramView1.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
      return;
    } finally {
      a(rect1);
      a(rect2);
    } 
  }
  
  private void a(List<View> paramList) {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int i1 = getChildCount();
    for (int i2 = i1 - 1; i2 >= 0; i2--) {
      int i3;
      if (bool) {
        i3 = getChildDrawingOrder(i1, i2);
      } else {
        i3 = i2;
      } 
      paramList.add(getChildAt(i3));
    } 
    Comparator comparator = d;
    if (comparator != null)
      Collections.sort(paramList, comparator); 
  }
  
  private void a(boolean paramBoolean) {
    int i1 = getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      b b3 = ((e)view.getLayoutParams()).b();
      if (b3 != null) {
        long l1 = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          b3.b(this, view, motionEvent);
        } else {
          b3.a(this, view, motionEvent);
        } 
        motionEvent.recycle();
      } 
    } 
    for (byte b2 = 0; b2 < i1; b2++)
      ((e)getChildAt(b2).getLayoutParams()).f(); 
    this.p = null;
    this.m = false;
  }
  
  private boolean a(MotionEvent paramMotionEvent, int paramInt) {
    int i1 = paramMotionEvent.getActionMasked();
    List list = this.i;
    a(list);
    int i2 = list.size();
    MotionEvent motionEvent = null;
    byte b1 = 0;
    boolean bool = false;
    boolean bool1 = false;
    while (b1 < i2) {
      View view = (View)list.get(b1);
      e e1 = (e)view.getLayoutParams();
      b b2 = e1.b();
      if ((bool || bool1) && i1 != 0) {
        if (b2 != null) {
          if (motionEvent == null) {
            long l1 = SystemClock.uptimeMillis();
            motionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
          } 
          switch (paramInt) {
            case 1:
              b2.a(this, view, motionEvent);
              break;
            case 0:
              b2.b(this, view, motionEvent);
              break;
          } 
        } 
      } else {
        if (!bool && b2 != null) {
          switch (paramInt) {
            case 1:
              bool = b2.a(this, view, paramMotionEvent);
              break;
            case 0:
              bool = b2.b(this, view, paramMotionEvent);
              break;
          } 
          if (bool)
            this.p = view; 
        } 
        boolean bool2 = e1.e();
        boolean bool3 = e1.a(this, view);
        if (bool3 && !bool2) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (bool3 && !bool1)
          break; 
      } 
      b1++;
    } 
    list.clear();
    return bool;
  }
  
  private int b(int paramInt) {
    int[] arrayOfInt = this.o;
    if (arrayOfInt == null) {
      String str = "CoordinatorLayout";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No keylines defined for ");
      stringBuilder.append(this);
      stringBuilder.append(" - attempted index lookup ");
      stringBuilder.append(paramInt);
      Log.e(str, stringBuilder.toString());
      return 0;
    } 
    if (paramInt < 0 || paramInt >= arrayOfInt.length) {
      String str = "CoordinatorLayout";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Keyline index ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" out of range for ");
      stringBuilder.append(this);
      Log.e(str, stringBuilder.toString());
      return 0;
    } 
    return arrayOfInt[paramInt];
  }
  
  private z b(z paramz) {
    if (paramz.e())
      return paramz; 
    byte b1 = 0;
    int i1 = getChildCount();
    while (b1 < i1) {
      View view = getChildAt(b1);
      if (r.q(view)) {
        b b2 = ((e)view.getLayoutParams()).b();
        if (b2 != null) {
          paramz = b2.a(this, view, paramz);
          if (paramz.e())
            return paramz; 
        } 
      } 
      b1++;
    } 
    return paramz;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2) {
    int i9;
    e e1 = (e)paramView.getLayoutParams();
    int i1 = d.a(d(e1.c), paramInt2);
    int i2 = i1 & 0x7;
    int i3 = i1 & 0x70;
    int i4 = getWidth();
    int i5 = getHeight();
    int i6 = paramView.getMeasuredWidth();
    int i7 = paramView.getMeasuredHeight();
    if (paramInt2 == 1)
      paramInt1 = i4 - paramInt1; 
    int i8 = b(paramInt1) - i6;
    if (i2 != 1) {
      if (i2 == 5)
        i8 += i6; 
    } else {
      i8 += i6 / 2;
    } 
    if (i3 != 16) {
      if (i3 != 80) {
        i9 = 0;
      } else {
        i9 = i7 + 0;
      } 
    } else {
      i9 = 0 + i7 / 2;
    } 
    int i10 = Math.max(getPaddingLeft() + e1.leftMargin, Math.min(i8, i4 - getPaddingRight() - i6 - e1.rightMargin));
    int i11 = Math.max(getPaddingTop() + e1.topMargin, Math.min(i9, i5 - getPaddingBottom() - i7 - e1.bottomMargin));
    paramView.layout(i10, i11, i6 + i10, i7 + i11);
  }
  
  private static int c(int paramInt) {
    if ((paramInt & 0x7) == 0)
      paramInt |= 0x800003; 
    if ((paramInt & 0x70) == 0)
      paramInt |= 0x30; 
    return paramInt;
  }
  
  private static int d(int paramInt) {
    if (paramInt == 0)
      paramInt = 8388661; 
    return paramInt;
  }
  
  private void d(View paramView, int paramInt) {
    e e1 = (e)paramView.getLayoutParams();
    Rect rect1 = e();
    rect1.set(getPaddingLeft() + e1.leftMargin, getPaddingTop() + e1.topMargin, getWidth() - getPaddingRight() - e1.rightMargin, getHeight() - getPaddingBottom() - e1.bottomMargin);
    if (this.t != null && r.q(this) && !r.q(paramView)) {
      rect1.left += this.t.a();
      rect1.top += this.t.b();
      rect1.right -= this.t.c();
      rect1.bottom -= this.t.d();
    } 
    Rect rect2 = e();
    d.a(c(e1.c), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), rect1, rect2, paramInt);
    paramView.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    a(rect1);
    a(rect2);
  }
  
  private static int e(int paramInt) {
    if (paramInt == 0)
      paramInt = 17; 
    return paramInt;
  }
  
  private static Rect e() {
    Rect rect = (Rect)f.a();
    if (rect == null)
      rect = new Rect(); 
    return rect;
  }
  
  private void e(View paramView, int paramInt) {
    e e1 = (e)paramView.getLayoutParams();
    if (e1.i != paramInt) {
      r.f(paramView, paramInt - e1.i);
      e1.i = paramInt;
    } 
  }
  
  private boolean e(View paramView) { return this.h.e(paramView); }
  
  private void f() {
    this.g.clear();
    this.h.a();
    int i1 = getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      e e1 = a(view);
      e1.b(this, view);
      this.h.a(view);
      for (byte b2 = 0; b2 < i1; b2++) {
        if (b2 != b1) {
          View view1 = getChildAt(b2);
          if (e1.a(this, view, view1)) {
            if (!this.h.b(view1))
              this.h.a(view1); 
            this.h.a(view1, view);
          } 
        } 
      } 
    } 
    this.g.addAll(this.h.b());
    Collections.reverse(this.g);
  }
  
  private void f(View paramView, int paramInt) {
    e e1 = (e)paramView.getLayoutParams();
    if (e1.j != paramInt) {
      r.e(paramView, paramInt - e1.j);
      e1.j = paramInt;
    } 
  }
  
  private void g() {
    if (Build.VERSION.SDK_INT < 21)
      return; 
    if (r.q(this)) {
      if (this.w == null)
        this.w = new p(this) {
            public z a(View param1View, z param1z) { return this.a.a(param1z); }
          }; 
      r.a(this, this.w);
      setSystemUiVisibility(1280);
      return;
    } 
    r.a(this, null);
  }
  
  public e a(AttributeSet paramAttributeSet) { return new e(getContext(), paramAttributeSet); }
  
  e a(View paramView) {
    e e1 = (e)paramView.getLayoutParams();
    if (!e1.b) {
      if (paramView instanceof a) {
        b b1 = ((a)paramView).getBehavior();
        if (b1 == null)
          Log.e("CoordinatorLayout", "Attached behavior class is null"); 
        e1.a(b1);
        e1.b = true;
        return e1;
      } 
      Class clazz = paramView.getClass();
      c c1 = null;
      while (clazz != null) {
        c1 = (c)clazz.getAnnotation(c.class);
        if (c1 == null)
          clazz = clazz.getSuperclass(); 
      } 
      if (c1 != null)
        try {
          e1.a((b)c1.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Default behavior class ");
          stringBuilder.append(c1.a().getName());
          stringBuilder.append(" could not be instantiated. Did you forget");
          stringBuilder.append(" a default constructor?");
          Log.e("CoordinatorLayout", stringBuilder.toString(), exception);
        }  
      e1.b = true;
      return e1;
    } 
    return e1;
  }
  
  protected e a(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams instanceof e) ? new e((e)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new e((ViewGroup.MarginLayoutParams)paramLayoutParams) : new e(paramLayoutParams)); }
  
  final z a(z paramz) {
    if (!i.a(this.t, paramz)) {
      boolean bool1;
      this.t = paramz;
      boolean bool = true;
      if (paramz != null && paramz.b() > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.u = bool1;
      if (this.u || getBackground() != null)
        bool = false; 
      setWillNotDraw(bool);
      paramz = b(paramz);
      requestLayout();
    } 
    return paramz;
  }
  
  void a() {
    boolean bool;
    int i1 = getChildCount();
    byte b1 = 0;
    while (true) {
      bool = false;
      if (b1 < i1) {
        if (e(getChildAt(b1))) {
          bool = true;
          break;
        } 
        b1++;
        continue;
      } 
      break;
    } 
    if (bool != this.s) {
      if (bool) {
        b();
        return;
      } 
      c();
    } 
  }
  
  final void a(int paramInt) {
    int i1 = r.f(this);
    int i2 = this.g.size();
    Rect rect1 = e();
    Rect rect2 = e();
    Rect rect3 = e();
    for (byte b1 = 0; b1 < i2; b1++) {
      View view = (View)this.g.get(b1);
      e e1 = (e)view.getLayoutParams();
      if (paramInt == 0 && view.getVisibility() == 8)
        continue; 
      for (byte b2 = 0; b2 < b1; b2++) {
        View view1 = (View)this.g.get(b2);
        if (e1.l == view1)
          b(view, i1); 
      } 
      a(view, true, rect2);
      if (e1.g != 0 && !rect2.isEmpty()) {
        int i3 = d.a(e1.g, i1);
        int i4 = i3 & 0x70;
        if (i4 != 48) {
          if (i4 == 80)
            rect1.bottom = Math.max(rect1.bottom, getHeight() - rect2.top); 
        } else {
          rect1.top = Math.max(rect1.top, rect2.bottom);
        } 
        int i5 = i3 & 0x7;
        if (i5 != 3) {
          if (i5 == 5)
            rect1.right = Math.max(rect1.right, getWidth() - rect2.left); 
        } else {
          rect1.left = Math.max(rect1.left, rect2.right);
        } 
      } 
      if (e1.h != 0 && view.getVisibility() == 0)
        a(view, rect1, i1); 
      if (paramInt != 2) {
        c(view, rect3);
        if (rect3.equals(rect2))
          continue; 
        b(view, rect2);
      } 
      for (byte b3 = b1 + 1; b3 < i2; b3++) {
        View view1 = (View)this.g.get(b3);
        e e2 = (e)view1.getLayoutParams();
        b b4 = e2.b();
        if (b4 != null && b4.a(this, view1, view))
          if (paramInt == 0 && e2.g()) {
            e2.h();
          } else {
            boolean bool;
            if (paramInt != 2) {
              bool = b4.b(this, view1, view);
            } else {
              b4.c(this, view1, view);
              bool = true;
            } 
            if (paramInt == 1)
              e2.a(bool); 
          }  
      } 
      continue;
    } 
    a(rect1);
    a(rect2);
    a(rect3);
  }
  
  public void a(View paramView, int paramInt) {
    e e1 = (e)paramView.getLayoutParams();
    if (!e1.d()) {
      if (e1.k != null) {
        a(paramView, e1.k, paramInt);
        return;
      } 
      if (e1.e >= 0) {
        b(paramView, e1.e, paramInt);
        return;
      } 
      d(paramView, paramInt);
      return;
    } 
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4); }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i1 = getChildCount();
    boolean bool = false;
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        e e1 = (e)view.getLayoutParams();
        if (e1.b(paramInt5)) {
          b b2 = e1.b();
          if (b2 != null) {
            b2.a(this, view, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
            bool = true;
          } 
        } 
      } 
    } 
    if (bool)
      a(1); 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3) {
    int i1 = getChildCount();
    boolean bool = false;
    byte b1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (b1 < i1) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        e e1 = (e)view.getLayoutParams();
        if (e1.b(paramInt3)) {
          b b2 = e1.b();
          if (b2 != null) {
            int i5;
            int i4;
            int[] arrayOfInt = this.k;
            arrayOfInt[1] = 0;
            arrayOfInt[0] = 0;
            b2.a(this, view, paramView, paramInt1, paramInt2, arrayOfInt, paramInt3);
            if (paramInt1 > 0) {
              i4 = Math.max(i2, this.k[0]);
            } else {
              i4 = Math.min(i2, this.k[0]);
            } 
            if (paramInt2 > 0) {
              i5 = Math.max(i3, this.k[1]);
            } else {
              i5 = Math.min(i3, this.k[1]);
            } 
            i2 = i4;
            i3 = i5;
            bool = true;
          } 
        } 
      } 
      b1++;
    } 
    paramArrayOfInt[0] = i2;
    paramArrayOfInt[1] = i3;
    if (bool)
      a(1); 
  }
  
  void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2) {
    e e1 = (e)paramView.getLayoutParams();
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    a(paramView, paramInt, paramRect1, paramRect2, e1, i1, i2);
    a(e1, paramRect2, i1, i2);
  }
  
  void a(View paramView, Rect paramRect) { r.b(this, paramView, paramRect); }
  
  void a(View paramView, boolean paramBoolean, Rect paramRect) {
    if (paramView.isLayoutRequested() || paramView.getVisibility() == 8) {
      paramRect.setEmpty();
      return;
    } 
    if (paramBoolean) {
      a(paramView, paramRect);
      return;
    } 
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2) {
    rect = e();
    a(paramView, rect);
    try {
      return rect.contains(paramInt1, paramInt2);
    } finally {
      a(rect);
    } 
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    int i1 = getChildCount();
    byte b1 = 0;
    boolean bool = false;
    while (b1 < i1) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        e e1 = (e)view.getLayoutParams();
        b b2 = e1.b();
        if (b2 != null) {
          boolean bool1 = b2.a(this, view, paramView1, paramView2, paramInt1, paramInt2);
          boolean bool2 = bool | bool1;
          e1.a(paramInt2, bool1);
          bool = bool2;
        } else {
          e1.a(paramInt2, false);
        } 
      } 
      b1++;
    } 
    return bool;
  }
  
  void b() {
    if (this.n) {
      if (this.r == null)
        this.r = new f(this); 
      getViewTreeObserver().addOnPreDrawListener(this.r);
    } 
    this.s = true;
  }
  
  public void b(View paramView) {
    List list = this.h.c(paramView);
    if (list != null && !list.isEmpty())
      for (byte b1 = 0; b1 < list.size(); b1++) {
        View view = (View)list.get(b1);
        b b2 = ((e)view.getLayoutParams()).b();
        if (b2 != null)
          b2.b(this, view, paramView); 
      }  
  }
  
  void b(View paramView, int paramInt) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   4: checkcast android/support/design/widget/CoordinatorLayout$e
    //   7: astore_3
    //   8: aload_3
    //   9: getfield k : Landroid/view/View;
    //   12: ifnull -> 217
    //   15: invokestatic e : ()Landroid/graphics/Rect;
    //   18: astore #4
    //   20: invokestatic e : ()Landroid/graphics/Rect;
    //   23: astore #5
    //   25: invokestatic e : ()Landroid/graphics/Rect;
    //   28: astore #6
    //   30: aload_0
    //   31: aload_3
    //   32: getfield k : Landroid/view/View;
    //   35: aload #4
    //   37: invokevirtual a : (Landroid/view/View;Landroid/graphics/Rect;)V
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: aload #5
    //   45: invokevirtual a : (Landroid/view/View;ZLandroid/graphics/Rect;)V
    //   48: aload_1
    //   49: invokevirtual getMeasuredWidth : ()I
    //   52: istore #7
    //   54: aload_1
    //   55: invokevirtual getMeasuredHeight : ()I
    //   58: istore #8
    //   60: aload_0
    //   61: aload_1
    //   62: iload_2
    //   63: aload #4
    //   65: aload #6
    //   67: aload_3
    //   68: iload #7
    //   70: iload #8
    //   72: invokespecial a : (Landroid/view/View;ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/support/design/widget/CoordinatorLayout$e;II)V
    //   75: aload #6
    //   77: getfield left : I
    //   80: aload #5
    //   82: getfield left : I
    //   85: if_icmpne -> 112
    //   88: aload #6
    //   90: getfield top : I
    //   93: istore #14
    //   95: aload #5
    //   97: getfield top : I
    //   100: istore #15
    //   102: iconst_0
    //   103: istore #9
    //   105: iload #14
    //   107: iload #15
    //   109: if_icmpeq -> 115
    //   112: iconst_1
    //   113: istore #9
    //   115: aload_0
    //   116: aload_3
    //   117: aload #6
    //   119: iload #7
    //   121: iload #8
    //   123: invokespecial a : (Landroid/support/design/widget/CoordinatorLayout$e;Landroid/graphics/Rect;II)V
    //   126: aload #6
    //   128: getfield left : I
    //   131: aload #5
    //   133: getfield left : I
    //   136: isub
    //   137: istore #10
    //   139: aload #6
    //   141: getfield top : I
    //   144: aload #5
    //   146: getfield top : I
    //   149: isub
    //   150: istore #11
    //   152: iload #10
    //   154: ifeq -> 163
    //   157: aload_1
    //   158: iload #10
    //   160: invokestatic f : (Landroid/view/View;I)V
    //   163: iload #11
    //   165: ifeq -> 174
    //   168: aload_1
    //   169: iload #11
    //   171: invokestatic e : (Landroid/view/View;I)V
    //   174: iload #9
    //   176: ifeq -> 202
    //   179: aload_3
    //   180: invokevirtual b : ()Landroid/support/design/widget/CoordinatorLayout$b;
    //   183: astore #12
    //   185: aload #12
    //   187: ifnull -> 202
    //   190: aload #12
    //   192: aload_0
    //   193: aload_1
    //   194: aload_3
    //   195: getfield k : Landroid/view/View;
    //   198: invokevirtual b : (Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z
    //   201: pop
    //   202: aload #4
    //   204: invokestatic a : (Landroid/graphics/Rect;)V
    //   207: aload #5
    //   209: invokestatic a : (Landroid/graphics/Rect;)V
    //   212: aload #6
    //   214: invokestatic a : (Landroid/graphics/Rect;)V
    //   217: return }
  
  void b(View paramView, Rect paramRect) { ((e)paramView.getLayoutParams()).a(paramRect); }
  
  public void b(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    this.x.a(paramView1, paramView2, paramInt1, paramInt2);
    this.q = paramView2;
    int i1 = getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      e e1 = (e)view.getLayoutParams();
      if (e1.b(paramInt2)) {
        b b2 = e1.b();
        if (b2 != null)
          b2.b(this, view, paramView1, paramView2, paramInt1, paramInt2); 
      } 
    } 
  }
  
  public List<View> c(View paramView) {
    List list = this.h.d(paramView);
    this.j.clear();
    if (list != null)
      this.j.addAll(list); 
    return this.j;
  }
  
  void c() {
    if (this.n && this.r != null)
      getViewTreeObserver().removeOnPreDrawListener(this.r); 
    this.s = false;
  }
  
  public void c(View paramView, int paramInt) {
    this.x.a(paramView, paramInt);
    int i1 = getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      e e1 = (e)view.getLayoutParams();
      if (e1.b(paramInt)) {
        b b2 = e1.b();
        if (b2 != null)
          b2.a(this, view, paramView, paramInt); 
        e1.a(paramInt);
        e1.h();
      } 
    } 
    this.q = null;
  }
  
  void c(View paramView, Rect paramRect) { paramRect.set(((e)paramView.getLayoutParams()).c()); }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) { return (paramLayoutParams instanceof e && super.checkLayoutParams(paramLayoutParams)); }
  
  protected e d() { return new e(-2, -2); }
  
  public List<View> d(View paramView) {
    List list = this.h.c(paramView);
    this.j.clear();
    if (list != null)
      this.j.addAll(list); 
    return this.j;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    e e1 = (e)paramView.getLayoutParams();
    if (e1.a != null) {
      float f1 = e1.a.d(this, paramView);
      if (f1 > 0.0F) {
        if (this.l == null)
          this.l = new Paint(); 
        this.l.setColor(e1.a.c(this, paramView));
        this.l.setAlpha(a(Math.round(f1 * 255.0F), 0, 255));
        int i1 = paramCanvas.save();
        if (paramView.isOpaque())
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE); 
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), (getWidth() - getPaddingRight()), (getHeight() - getPaddingBottom()), this.l);
        paramCanvas.restoreToCount(i1);
      } 
    } 
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable drawable = this.v;
    boolean bool = false;
    if (drawable != null) {
      boolean bool1 = drawable.isStateful();
      bool = false;
      if (bool1)
        bool = false | drawable.setState(arrayOfInt); 
    } 
    if (bool)
      invalidate(); 
  }
  
  final List<View> getDependencySortedChildren() {
    f();
    return Collections.unmodifiableList(this.g);
  }
  
  public final z getLastWindowInsets() { return this.t; }
  
  public int getNestedScrollAxes() { return this.x.a(); }
  
  public Drawable getStatusBarBackground() { return this.v; }
  
  protected int getSuggestedMinimumHeight() { return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom()); }
  
  protected int getSuggestedMinimumWidth() { return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight()); }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    a(false);
    if (this.s) {
      if (this.r == null)
        this.r = new f(this); 
      getViewTreeObserver().addOnPreDrawListener(this.r);
    } 
    if (this.t == null && r.q(this))
      r.p(this); 
    this.n = true;
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a(false);
    if (this.s && this.r != null)
      getViewTreeObserver().removeOnPreDrawListener(this.r); 
    View view = this.q;
    if (view != null)
      onStopNestedScroll(view); 
    this.n = false;
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.u && this.v != null) {
      byte b1;
      z z1 = this.t;
      if (z1 != null) {
        b1 = z1.b();
      } else {
        b1 = 0;
      } 
      if (b1) {
        this.v.setBounds(0, 0, getWidth(), b1);
        this.v.draw(paramCanvas);
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0)
      a(true); 
    boolean bool = a(paramMotionEvent, 0);
    if (i1 == 1 || i1 == 3)
      a(true); 
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i1 = r.f(this);
    int i2 = this.g.size();
    for (byte b1 = 0; b1 < i2; b1++) {
      View view = (View)this.g.get(b1);
      if (view.getVisibility() != 8) {
        b b2 = ((e)view.getLayoutParams()).b();
        if (b2 == null || !b2.a(this, view, i1))
          a(view, i1); 
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: invokespecial f : ()V
    //   4: aload_0
    //   5: invokevirtual a : ()V
    //   8: aload_0
    //   9: invokevirtual getPaddingLeft : ()I
    //   12: istore_3
    //   13: aload_0
    //   14: invokevirtual getPaddingTop : ()I
    //   17: istore #4
    //   19: aload_0
    //   20: invokevirtual getPaddingRight : ()I
    //   23: istore #5
    //   25: aload_0
    //   26: invokevirtual getPaddingBottom : ()I
    //   29: istore #6
    //   31: aload_0
    //   32: invokestatic f : (Landroid/view/View;)I
    //   35: istore #7
    //   37: iload #7
    //   39: iconst_1
    //   40: if_icmpne -> 49
    //   43: iconst_1
    //   44: istore #8
    //   46: goto -> 52
    //   49: iconst_0
    //   50: istore #8
    //   52: iload_1
    //   53: invokestatic getMode : (I)I
    //   56: istore #9
    //   58: iload_1
    //   59: invokestatic getSize : (I)I
    //   62: istore #10
    //   64: iload_2
    //   65: invokestatic getMode : (I)I
    //   68: istore #11
    //   70: iload_2
    //   71: invokestatic getSize : (I)I
    //   74: istore #12
    //   76: iload_3
    //   77: iload #5
    //   79: iadd
    //   80: istore #13
    //   82: iload #4
    //   84: iload #6
    //   86: iadd
    //   87: istore #14
    //   89: aload_0
    //   90: invokevirtual getSuggestedMinimumWidth : ()I
    //   93: istore #15
    //   95: aload_0
    //   96: invokevirtual getSuggestedMinimumHeight : ()I
    //   99: istore #16
    //   101: aload_0
    //   102: getfield t : Landroid/support/v4/h/z;
    //   105: ifnull -> 121
    //   108: aload_0
    //   109: invokestatic q : (Landroid/view/View;)Z
    //   112: ifeq -> 121
    //   115: iconst_1
    //   116: istore #17
    //   118: goto -> 124
    //   121: iconst_0
    //   122: istore #17
    //   124: aload_0
    //   125: getfield g : Ljava/util/List;
    //   128: invokeinterface size : ()I
    //   133: istore #18
    //   135: iload #15
    //   137: istore #19
    //   139: iload #16
    //   141: istore #20
    //   143: iconst_0
    //   144: istore #21
    //   146: iconst_0
    //   147: istore #22
    //   149: iload #22
    //   151: iload #18
    //   153: if_icmpge -> 635
    //   156: aload_0
    //   157: getfield g : Ljava/util/List;
    //   160: iload #22
    //   162: invokeinterface get : (I)Ljava/lang/Object;
    //   167: checkcast android/view/View
    //   170: astore #25
    //   172: aload #25
    //   174: invokevirtual getVisibility : ()I
    //   177: bipush #8
    //   179: if_icmpne -> 193
    //   182: iload #22
    //   184: istore #37
    //   186: iload #18
    //   188: istore #35
    //   190: goto -> 622
    //   193: aload #25
    //   195: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   198: checkcast android/support/design/widget/CoordinatorLayout$e
    //   201: astore #26
    //   203: aload #26
    //   205: getfield e : I
    //   208: iflt -> 323
    //   211: iload #9
    //   213: ifeq -> 323
    //   216: aload_0
    //   217: aload #26
    //   219: getfield e : I
    //   222: invokespecial b : (I)I
    //   225: istore #53
    //   227: bipush #7
    //   229: aload #26
    //   231: getfield c : I
    //   234: invokestatic d : (I)I
    //   237: iload #7
    //   239: invokestatic a : (II)I
    //   242: iand
    //   243: istore #54
    //   245: iload #20
    //   247: istore #27
    //   249: iload #54
    //   251: iconst_3
    //   252: if_icmpne -> 260
    //   255: iload #8
    //   257: ifeq -> 271
    //   260: iload #54
    //   262: iconst_5
    //   263: if_icmpne -> 288
    //   266: iload #8
    //   268: ifeq -> 288
    //   271: iconst_0
    //   272: iload #10
    //   274: iload #5
    //   276: isub
    //   277: iload #53
    //   279: isub
    //   280: invokestatic max : (II)I
    //   283: istore #28
    //   285: goto -> 330
    //   288: iload #54
    //   290: iconst_5
    //   291: if_icmpne -> 299
    //   294: iload #8
    //   296: ifeq -> 310
    //   299: iload #54
    //   301: iconst_3
    //   302: if_icmpne -> 327
    //   305: iload #8
    //   307: ifeq -> 327
    //   310: iconst_0
    //   311: iload #53
    //   313: iload_3
    //   314: isub
    //   315: invokestatic max : (II)I
    //   318: istore #28
    //   320: goto -> 330
    //   323: iload #20
    //   325: istore #27
    //   327: iconst_0
    //   328: istore #28
    //   330: iload #17
    //   332: ifeq -> 412
    //   335: aload #25
    //   337: invokestatic q : (Landroid/view/View;)Z
    //   340: ifne -> 412
    //   343: aload_0
    //   344: getfield t : Landroid/support/v4/h/z;
    //   347: invokevirtual a : ()I
    //   350: aload_0
    //   351: getfield t : Landroid/support/v4/h/z;
    //   354: invokevirtual c : ()I
    //   357: iadd
    //   358: istore #49
    //   360: aload_0
    //   361: getfield t : Landroid/support/v4/h/z;
    //   364: invokevirtual b : ()I
    //   367: aload_0
    //   368: getfield t : Landroid/support/v4/h/z;
    //   371: invokevirtual d : ()I
    //   374: iadd
    //   375: istore #50
    //   377: iload #10
    //   379: iload #49
    //   381: isub
    //   382: iload #9
    //   384: invokestatic makeMeasureSpec : (II)I
    //   387: istore #51
    //   389: iload #12
    //   391: iload #50
    //   393: isub
    //   394: iload #11
    //   396: invokestatic makeMeasureSpec : (II)I
    //   399: istore #52
    //   401: iload #51
    //   403: istore #29
    //   405: iload #52
    //   407: istore #30
    //   409: goto -> 418
    //   412: iload_1
    //   413: istore #29
    //   415: iload_2
    //   416: istore #30
    //   418: aload #26
    //   420: invokevirtual b : ()Landroid/support/design/widget/CoordinatorLayout$b;
    //   423: astore #31
    //   425: aload #31
    //   427: ifnull -> 487
    //   430: aload #26
    //   432: astore #32
    //   434: iload #27
    //   436: istore #36
    //   438: iload #21
    //   440: istore #33
    //   442: iload #29
    //   444: istore #46
    //   446: iload #19
    //   448: istore #34
    //   450: iload #28
    //   452: istore #47
    //   454: iload #22
    //   456: istore #37
    //   458: iload #30
    //   460: istore #48
    //   462: iload #18
    //   464: istore #35
    //   466: aload #31
    //   468: aload_0
    //   469: aload #25
    //   471: iload #46
    //   473: iload #47
    //   475: iload #48
    //   477: iconst_0
    //   478: invokevirtual a : (Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;IIII)Z
    //   481: ifne -> 524
    //   484: goto -> 511
    //   487: aload #26
    //   489: astore #32
    //   491: iload #21
    //   493: istore #33
    //   495: iload #19
    //   497: istore #34
    //   499: iload #18
    //   501: istore #35
    //   503: iload #27
    //   505: istore #36
    //   507: iload #22
    //   509: istore #37
    //   511: aload_0
    //   512: aload #25
    //   514: iload #29
    //   516: iload #28
    //   518: iload #30
    //   520: iconst_0
    //   521: invokevirtual a : (Landroid/view/View;IIII)V
    //   524: iload #13
    //   526: aload #25
    //   528: invokevirtual getMeasuredWidth : ()I
    //   531: iadd
    //   532: istore #38
    //   534: aload #32
    //   536: astore #39
    //   538: iload #38
    //   540: aload #39
    //   542: getfield leftMargin : I
    //   545: iadd
    //   546: aload #39
    //   548: getfield rightMargin : I
    //   551: iadd
    //   552: istore #40
    //   554: iload #34
    //   556: iload #40
    //   558: invokestatic max : (II)I
    //   561: istore #41
    //   563: iload #14
    //   565: aload #25
    //   567: invokevirtual getMeasuredHeight : ()I
    //   570: iadd
    //   571: aload #39
    //   573: getfield topMargin : I
    //   576: iadd
    //   577: aload #39
    //   579: getfield bottomMargin : I
    //   582: iadd
    //   583: istore #42
    //   585: iload #36
    //   587: iload #42
    //   589: invokestatic max : (II)I
    //   592: istore #43
    //   594: aload #25
    //   596: invokevirtual getMeasuredState : ()I
    //   599: istore #44
    //   601: iload #33
    //   603: iload #44
    //   605: invokestatic combineMeasuredStates : (II)I
    //   608: istore #45
    //   610: iload #41
    //   612: istore #19
    //   614: iload #45
    //   616: istore #21
    //   618: iload #43
    //   620: istore #20
    //   622: iload #37
    //   624: iconst_1
    //   625: iadd
    //   626: istore #22
    //   628: iload #35
    //   630: istore #18
    //   632: goto -> 149
    //   635: iload #20
    //   637: istore #23
    //   639: iload #21
    //   641: istore #24
    //   643: aload_0
    //   644: iload #19
    //   646: iload_1
    //   647: ldc_w -16777216
    //   650: iload #24
    //   652: iand
    //   653: invokestatic resolveSizeAndState : (III)I
    //   656: iload #23
    //   658: iload_2
    //   659: iload #24
    //   661: bipush #16
    //   663: ishl
    //   664: invokestatic resolveSizeAndState : (III)I
    //   667: invokevirtual setMeasuredDimension : (II)V
    //   670: return }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    int i1 = getChildCount();
    byte b1 = 0;
    boolean bool = false;
    while (b1 < i1) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        e e1 = (e)view.getLayoutParams();
        if (e1.b(0)) {
          b b2 = e1.b();
          if (b2 != null)
            bool |= b2.a(this, view, paramView, paramFloat1, paramFloat2, paramBoolean); 
        } 
      } 
      b1++;
    } 
    if (bool)
      a(1); 
    return bool;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    int i1 = getChildCount();
    byte b1 = 0;
    boolean bool = false;
    while (b1 < i1) {
      View view = getChildAt(b1);
      if (view.getVisibility() != 8) {
        e e1 = (e)view.getLayoutParams();
        if (e1.b(0)) {
          b b2 = e1.b();
          if (b2 != null)
            bool |= b2.a(this, view, paramView, paramFloat1, paramFloat2); 
        } 
      } 
      b1++;
    } 
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) { a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0); }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0); }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) { b(paramView1, paramView2, paramInt, 0); }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof g)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    g g1 = (g)paramParcelable;
    super.onRestoreInstanceState(g1.a());
    SparseArray sparseArray = g1.a;
    byte b1 = 0;
    int i1 = getChildCount();
    while (b1 < i1) {
      View view = getChildAt(b1);
      int i2 = view.getId();
      b b2 = a(view).b();
      if (i2 != -1 && b2 != null) {
        Parcelable parcelable = (Parcelable)sparseArray.get(i2);
        if (parcelable != null)
          b2.a(this, view, parcelable); 
      } 
      b1++;
    } 
  }
  
  protected Parcelable onSaveInstanceState() {
    g g1 = new g(super.onSaveInstanceState());
    SparseArray sparseArray = new SparseArray();
    int i1 = getChildCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      View view = getChildAt(b1);
      int i2 = view.getId();
      b b2 = ((e)view.getLayoutParams()).b();
      if (i2 != -1 && b2 != null) {
        Parcelable parcelable = b2.b(this, view);
        if (parcelable != null)
          sparseArray.append(i2, parcelable); 
      } 
    } 
    g1.a = sparseArray;
    return g1;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) { return a(paramView1, paramView2, paramInt, 0); }
  
  public void onStopNestedScroll(View paramView) { c(paramView, 0); }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore_2
    //   5: aload_0
    //   6: getfield p : Landroid/view/View;
    //   9: ifnonnull -> 26
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_1
    //   15: invokespecial a : (Landroid/view/MotionEvent;I)Z
    //   18: istore_3
    //   19: iload_3
    //   20: ifeq -> 64
    //   23: goto -> 28
    //   26: iconst_0
    //   27: istore_3
    //   28: aload_0
    //   29: getfield p : Landroid/view/View;
    //   32: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   35: checkcast android/support/design/widget/CoordinatorLayout$e
    //   38: invokevirtual b : ()Landroid/support/design/widget/CoordinatorLayout$b;
    //   41: astore #4
    //   43: aload #4
    //   45: ifnull -> 64
    //   48: aload #4
    //   50: aload_0
    //   51: aload_0
    //   52: getfield p : Landroid/view/View;
    //   55: aload_1
    //   56: invokevirtual a : (Landroid/support/design/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   59: istore #5
    //   61: goto -> 67
    //   64: iconst_0
    //   65: istore #5
    //   67: aload_0
    //   68: getfield p : Landroid/view/View;
    //   71: ifnonnull -> 90
    //   74: iload #5
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   81: ior
    //   82: istore #5
    //   84: aconst_null
    //   85: astore #6
    //   87: goto -> 122
    //   90: aconst_null
    //   91: astore #6
    //   93: iload_3
    //   94: ifeq -> 122
    //   97: invokestatic uptimeMillis : ()J
    //   100: lstore #7
    //   102: lload #7
    //   104: lload #7
    //   106: iconst_3
    //   107: fconst_0
    //   108: fconst_0
    //   109: iconst_0
    //   110: invokestatic obtain : (JJIFFI)Landroid/view/MotionEvent;
    //   113: astore #6
    //   115: aload_0
    //   116: aload #6
    //   118: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   121: pop
    //   122: aload #6
    //   124: ifnull -> 132
    //   127: aload #6
    //   129: invokevirtual recycle : ()V
    //   132: iload_2
    //   133: iconst_1
    //   134: if_icmpeq -> 142
    //   137: iload_2
    //   138: iconst_3
    //   139: if_icmpne -> 147
    //   142: aload_0
    //   143: iconst_0
    //   144: invokespecial a : (Z)V
    //   147: iload #5
    //   149: ireturn }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    b b1 = ((e)paramView.getLayoutParams()).b();
    return (b1 != null && b1.a(this, paramView, paramRect, paramBoolean)) ? true : super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean && !this.m) {
      a(false);
      this.m = true;
    } 
  }
  
  public void setFitsSystemWindows(boolean paramBoolean) {
    super.setFitsSystemWindows(paramBoolean);
    g();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener) { this.e = paramOnHierarchyChangeListener; }
  
  public void setStatusBarBackground(Drawable paramDrawable) {
    Drawable drawable = this.v;
    if (drawable != paramDrawable) {
      if (drawable != null)
        drawable.setCallback(null); 
      Drawable drawable1 = null;
      if (paramDrawable != null)
        drawable1 = paramDrawable.mutate(); 
      this.v = drawable1;
      Drawable drawable2 = this.v;
      if (drawable2 != null) {
        boolean bool;
        if (drawable2.isStateful())
          this.v.setState(getDrawableState()); 
        a.b(this.v, r.f(this));
        Drawable drawable3 = this.v;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        drawable3.setVisible(bool, false);
        this.v.setCallback(this);
      } 
      r.d(this);
    } 
  }
  
  public void setStatusBarBackgroundColor(int paramInt) { setStatusBarBackground(new ColorDrawable(paramInt)); }
  
  public void setStatusBarBackgroundResource(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = a.a(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setStatusBarBackground(drawable);
  }
  
  public void setVisibility(int paramInt) {
    boolean bool;
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable = this.v;
    if (drawable != null && drawable.isVisible() != bool)
      this.v.setVisible(bool, false); 
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) { return (super.verifyDrawable(paramDrawable) || paramDrawable == this.v); }
  
  public static interface a {
    CoordinatorLayout.b getBehavior();
  }
  
  public static abstract class b<V extends View> extends Object {
    public b() {}
    
    public b(Context param1Context, AttributeSet param1AttributeSet) {}
    
    public z a(CoordinatorLayout param1CoordinatorLayout, V param1V, z param1z) { return param1z; }
    
    public void a(CoordinatorLayout.e param1e) {}
    
    public void a(CoordinatorLayout param1CoordinatorLayout, V param1V, Parcelable param1Parcelable) {}
    
    public void a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int) {
      if (param1Int == 0)
        d(param1CoordinatorLayout, param1V, param1View); 
    }
    
    @Deprecated
    public void a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    public void a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      if (param1Int5 == 0)
        a(param1CoordinatorLayout, param1V, param1View, param1Int1, param1Int2, param1Int3, param1Int4); 
    }
    
    @Deprecated
    public void a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfInt) {}
    
    public void a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfInt, int param1Int3) {
      if (param1Int3 == 0)
        a(param1CoordinatorLayout, param1V, param1View, param1Int1, param1Int2, param1ArrayOfInt); 
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, int param1Int) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, int param1Int1, int param1Int2, int param1Int3, int param1Int4) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, Rect param1Rect) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, Rect param1Rect, boolean param1Boolean) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, MotionEvent param1MotionEvent) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, float param1Float1, float param1Float2) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, float param1Float1, float param1Float2, boolean param1Boolean) { return false; }
    
    @Deprecated
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int) { return false; }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int1, int param1Int2) { return (param1Int2 == 0) ? a(param1CoordinatorLayout, param1V, param1View1, param1View2, param1Int1) : 0; }
    
    public Parcelable b(CoordinatorLayout param1CoordinatorLayout, V param1V) { return View.BaseSavedState.EMPTY_STATE; }
    
    @Deprecated
    public void b(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int) {}
    
    public void b(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int1, int param1Int2) {
      if (param1Int2 == 0)
        b(param1CoordinatorLayout, param1V, param1View1, param1View2, param1Int1); 
    }
    
    public boolean b(CoordinatorLayout param1CoordinatorLayout, V param1V, MotionEvent param1MotionEvent) { return false; }
    
    public boolean b(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) { return false; }
    
    public int c(CoordinatorLayout param1CoordinatorLayout, V param1V) { return -16777216; }
    
    public void c() {}
    
    public void c(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) {}
    
    public float d(CoordinatorLayout param1CoordinatorLayout, V param1V) { return 0.0F; }
    
    @Deprecated
    public void d(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) {}
    
    public boolean e(CoordinatorLayout param1CoordinatorLayout, V param1V) { return (d(param1CoordinatorLayout, param1V) > 0.0F); }
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface c {
    Class<? extends CoordinatorLayout.b> a();
  }
  
  private class d implements ViewGroup.OnHierarchyChangeListener {
    d(CoordinatorLayout this$0) {}
    
    public void onChildViewAdded(View param1View1, View param1View2) {
      if (this.a.e != null)
        this.a.e.onChildViewAdded(param1View1, param1View2); 
    }
    
    public void onChildViewRemoved(View param1View1, View param1View2) {
      this.a.a(2);
      if (this.a.e != null)
        this.a.e.onChildViewRemoved(param1View1, param1View2); 
    }
  }
  
  public static class e extends ViewGroup.MarginLayoutParams {
    CoordinatorLayout.b a;
    
    boolean b = false;
    
    public int c = 0;
    
    public int d = 0;
    
    public int e = -1;
    
    int f = -1;
    
    public int g = 0;
    
    public int h = 0;
    
    int i;
    
    int j;
    
    View k;
    
    View l;
    
    final Rect m = new Rect();
    
    Object n;
    
    private boolean o;
    
    private boolean p;
    
    private boolean q;
    
    private boolean r;
    
    public e(int param1Int1, int param1Int2) { super(param1Int1, param1Int2); }
    
    e(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.c.CoordinatorLayout_Layout);
      this.c = typedArray.getInteger(a.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.f = typedArray.getResourceId(a.c.CoordinatorLayout_Layout_layout_anchor, -1);
      this.d = typedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.e = typedArray.getInteger(a.c.CoordinatorLayout_Layout_layout_keyline, -1);
      this.g = typedArray.getInt(a.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.h = typedArray.getInt(a.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      this.b = typedArray.hasValue(a.c.CoordinatorLayout_Layout_layout_behavior);
      if (this.b)
        this.a = CoordinatorLayout.a(param1Context, param1AttributeSet, typedArray.getString(a.c.CoordinatorLayout_Layout_layout_behavior)); 
      typedArray.recycle();
      CoordinatorLayout.b b1 = this.a;
      if (b1 != null)
        b1.a(this); 
    }
    
    public e(e param1e) { super(param1e); }
    
    public e(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
    
    public e(ViewGroup.MarginLayoutParams param1MarginLayoutParams) { super(param1MarginLayoutParams); }
    
    private void a(View param1View, CoordinatorLayout param1CoordinatorLayout) {
      this.k = param1CoordinatorLayout.findViewById(this.f);
      View view = this.k;
      if (view != null) {
        if (view == param1CoordinatorLayout) {
          if (!param1CoordinatorLayout.isInEditMode())
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout"); 
        } else {
          ViewParent viewParent = view.getParent();
          while (true) {
            if (viewParent != param1CoordinatorLayout && viewParent != null) {
              if (viewParent == param1View) {
                if (!param1CoordinatorLayout.isInEditMode())
                  throw new IllegalStateException("Anchor must not be a descendant of the anchored view"); 
              } else {
                if (viewParent instanceof View)
                  view = (View)viewParent; 
                viewParent = viewParent.getParent();
                continue;
              } 
            } else {
              break;
            } 
            this.l = null;
            this.k = null;
            return;
          } 
          this.l = view;
          return;
        } 
      } else if (!param1CoordinatorLayout.isInEditMode()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
        stringBuilder.append(param1CoordinatorLayout.getResources().getResourceName(this.f));
        stringBuilder.append(" to anchor view ");
        stringBuilder.append(param1View);
        throw new IllegalStateException(stringBuilder.toString());
      } 
      this.l = null;
      this.k = null;
    }
    
    private boolean a(View param1View, int param1Int) {
      int i1 = d.a(((e)param1View.getLayoutParams()).g, param1Int);
      return (i1 != 0 && (i1 & d.a(this.h, param1Int)) == i1);
    }
    
    private boolean b(View param1View, CoordinatorLayout param1CoordinatorLayout) {
      if (this.k.getId() != this.f)
        return false; 
      View view = this.k;
      for (ViewParent viewParent = view.getParent(); viewParent != param1CoordinatorLayout; viewParent = viewParent.getParent()) {
        if (viewParent == null || viewParent == param1View) {
          this.l = null;
          this.k = null;
          return false;
        } 
        if (viewParent instanceof View)
          view = (View)viewParent; 
      } 
      this.l = view;
      return true;
    }
    
    public int a() { return this.f; }
    
    void a(int param1Int) { a(param1Int, false); }
    
    void a(int param1Int, boolean param1Boolean) {
      switch (param1Int) {
        default:
          return;
        case 1:
          this.q = param1Boolean;
          return;
        case 0:
          break;
      } 
      this.p = param1Boolean;
    }
    
    void a(Rect param1Rect) { this.m.set(param1Rect); }
    
    public void a(CoordinatorLayout.b param1b) {
      CoordinatorLayout.b b1 = this.a;
      if (b1 != param1b) {
        if (b1 != null)
          b1.c(); 
        this.a = param1b;
        this.n = null;
        this.b = true;
        if (param1b != null)
          param1b.a(this); 
      } 
    }
    
    void a(boolean param1Boolean) { this.r = param1Boolean; }
    
    boolean a(CoordinatorLayout param1CoordinatorLayout, View param1View) {
      boolean bool;
      boolean bool1 = this.o;
      if (bool1)
        return true; 
      CoordinatorLayout.b b1 = this.a;
      if (b1 != null) {
        bool = b1.e(param1CoordinatorLayout, param1View);
      } else {
        bool = false;
      } 
      boolean bool2 = bool | bool1;
      this.o = bool2;
      return bool2;
    }
    
    boolean a(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) {
      if (param1View2 != this.l && !a(param1View2, r.f(param1CoordinatorLayout))) {
        CoordinatorLayout.b b1 = this.a;
        if (b1 == null || !b1.a(param1CoordinatorLayout, param1View1, param1View2))
          return false; 
      } 
      return true;
    }
    
    public CoordinatorLayout.b b() { return this.a; }
    
    View b(CoordinatorLayout param1CoordinatorLayout, View param1View) {
      if (this.f == -1) {
        this.l = null;
        this.k = null;
        return null;
      } 
      if (this.k == null || !b(param1View, param1CoordinatorLayout))
        a(param1View, param1CoordinatorLayout); 
      return this.k;
    }
    
    boolean b(int param1Int) {
      switch (param1Int) {
        default:
          return false;
        case 1:
          return this.q;
        case 0:
          break;
      } 
      return this.p;
    }
    
    Rect c() { return this.m; }
    
    boolean d() { return (this.k == null && this.f != -1); }
    
    boolean e() {
      if (this.a == null)
        this.o = false; 
      return this.o;
    }
    
    void f() { this.o = false; }
    
    boolean g() { return this.r; }
    
    void h() { this.r = false; }
  }
  
  class f implements ViewTreeObserver.OnPreDrawListener {
    f(CoordinatorLayout this$0) {}
    
    public boolean onPreDraw() {
      this.a.a(0);
      return true;
    }
  }
  
  protected static class g extends a {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.ClassLoaderCreator<g>() {
        public CoordinatorLayout.g a(Parcel param2Parcel) { return new CoordinatorLayout.g(param2Parcel, null); }
        
        public CoordinatorLayout.g a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new CoordinatorLayout.g(param2Parcel, param2ClassLoader); }
        
        public CoordinatorLayout.g[] a(int param2Int) { return new CoordinatorLayout.g[param2Int]; }
      };
    
    SparseArray<Parcelable> a;
    
    public g(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      int i = param1Parcel.readInt();
      int[] arrayOfInt = new int[i];
      param1Parcel.readIntArray(arrayOfInt);
      Parcelable[] arrayOfParcelable = param1Parcel.readParcelableArray(param1ClassLoader);
      this.a = new SparseArray(i);
      for (byte b = 0; b < i; b++)
        this.a.append(arrayOfInt[b], arrayOfParcelable[b]); 
    }
    
    public g(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      byte b2;
      super.writeToParcel(param1Parcel, param1Int);
      SparseArray sparseArray = this.a;
      byte b1 = 0;
      if (sparseArray != null) {
        b2 = sparseArray.size();
      } else {
        b2 = 0;
      } 
      param1Parcel.writeInt(b2);
      int[] arrayOfInt = new int[b2];
      Parcelable[] arrayOfParcelable = new Parcelable[b2];
      while (b1 < b2) {
        arrayOfInt[b1] = this.a.keyAt(b1);
        arrayOfParcelable[b1] = (Parcelable)this.a.valueAt(b1);
        b1++;
      } 
      param1Parcel.writeIntArray(arrayOfInt);
      param1Parcel.writeParcelableArray(arrayOfParcelable, param1Int);
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<g> {
    public CoordinatorLayout.g a(Parcel param1Parcel) { return new CoordinatorLayout.g(param1Parcel, null); }
    
    public CoordinatorLayout.g a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new CoordinatorLayout.g(param1Parcel, param1ClassLoader); }
    
    public CoordinatorLayout.g[] a(int param1Int) { return new CoordinatorLayout.g[param1Int]; }
  }
  
  static class h extends Object implements Comparator<View> {
    public int a(View param1View1, View param1View2) {
      float f1 = r.y(param1View1);
      float f2 = r.y(param1View2);
      return (f1 > f2) ? -1 : ((f1 < f2) ? 1 : 0);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\CoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */