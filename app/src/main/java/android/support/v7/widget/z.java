package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a.f;
import android.support.v4.widget.b;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class z {
  private final TextView a;
  
  private bk b;
  
  private bk c;
  
  private bk d;
  
  private bk e;
  
  private bk f;
  
  private bk g;
  
  private final ab h;
  
  private int i = 0;
  
  private Typeface j;
  
  private boolean k;
  
  z(TextView paramTextView) {
    this.a = paramTextView;
    this.h = new ab(this.a);
  }
  
  private static bk a(Context paramContext, l paraml, int paramInt) {
    ColorStateList colorStateList = paraml.b(paramContext, paramInt);
    if (colorStateList != null) {
      bk bk1 = new bk();
      bk1.d = true;
      bk1.a = colorStateList;
      return bk1;
    } 
    return null;
  }
  
  private void a(Context paramContext, bm parambm) {
    this.i = parambm.a(a.j.TextAppearance_android_textStyle, this.i);
    boolean bool = parambm.g(a.j.TextAppearance_android_fontFamily);
    byte b1 = 1;
    if (bool || parambm.g(a.j.TextAppearance_fontFamily)) {
      int m;
      this.j = null;
      if (parambm.g(a.j.TextAppearance_fontFamily)) {
        m = a.j.TextAppearance_fontFamily;
      } else {
        m = a.j.TextAppearance_android_fontFamily;
      } 
      if (!paramContext.isRestricted()) {
        f.a a1 = new f.a(this, new WeakReference(this.a)) {
            public void a(int param1Int) {}
            
            public void a(Typeface param1Typeface) { this.b.a(this.a, param1Typeface); }
          };
        this.j = parambm.a(m, this.i, a1);
        if (this.j != null)
          b1 = 0; 
        this.k = b1;
      } 
      if (this.j == null) {
        String str = parambm.d(m);
        if (str != null)
          this.j = Typeface.create(str, this.i); 
      } 
      return;
    } 
    if (parambm.g(a.j.TextAppearance_android_typeface)) {
      Typeface typeface;
      this.k = false;
      switch (parambm.a(a.j.TextAppearance_android_typeface, b1)) {
        default:
          return;
        case 3:
          typeface = Typeface.MONOSPACE;
          break;
        case 2:
          typeface = Typeface.SERIF;
          break;
        case 1:
          typeface = Typeface.SANS_SERIF;
          break;
      } 
      this.j = typeface;
    } 
  }
  
  private void a(Drawable paramDrawable, bk parambk) {
    if (paramDrawable != null && parambk != null)
      l.a(paramDrawable, parambk, this.a.getDrawableState()); 
  }
  
  private void b(int paramInt, float paramFloat) { this.h.a(paramInt, paramFloat); }
  
  void a() {
    if (this.b != null || this.c != null || this.d != null || this.e != null) {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawables();
      a(arrayOfDrawable[0], this.b);
      a(arrayOfDrawable[1], this.c);
      a(arrayOfDrawable[2], this.d);
      a(arrayOfDrawable[3], this.e);
    } 
    if (Build.VERSION.SDK_INT >= 17 && (this.f != null || this.g != null)) {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.f);
      a(arrayOfDrawable[2], this.g);
    } 
  }
  
  void a(int paramInt) { this.h.a(paramInt); }
  
  void a(int paramInt, float paramFloat) {
    if (!b.a && !c())
      b(paramInt, paramFloat); 
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { this.h.a(paramInt1, paramInt2, paramInt3, paramInt4); }
  
  void a(Context paramContext, int paramInt) {
    bm bm = bm.a(paramContext, paramInt, a.j.TextAppearance);
    if (bm.g(a.j.TextAppearance_textAllCaps))
      a(bm.a(a.j.TextAppearance_textAllCaps, false)); 
    if (Build.VERSION.SDK_INT < 23 && bm.g(a.j.TextAppearance_android_textColor)) {
      ColorStateList colorStateList = bm.e(a.j.TextAppearance_android_textColor);
      if (colorStateList != null)
        this.a.setTextColor(colorStateList); 
    } 
    if (bm.g(a.j.TextAppearance_android_textSize) && bm.e(a.j.TextAppearance_android_textSize, -1) == 0)
      this.a.setTextSize(0, 0.0F); 
    a(paramContext, bm);
    bm.a();
    Typeface typeface = this.j;
    if (typeface != null)
      this.a.setTypeface(typeface, this.i); 
  }
  
  @SuppressLint({"NewApi"})
  void a(AttributeSet paramAttributeSet, int paramInt) {
    boolean bool2;
    byte b2;
    ColorStateList colorStateList3;
    ColorStateList colorStateList2;
    Context context = this.a.getContext();
    l l = l.a();
    bm bm1 = bm.a(context, paramAttributeSet, a.j.AppCompatTextHelper, paramInt, 0);
    int m = bm1.g(a.j.AppCompatTextHelper_android_textAppearance, -1);
    if (bm1.g(a.j.AppCompatTextHelper_android_drawableLeft))
      this.b = a(context, l, bm1.g(a.j.AppCompatTextHelper_android_drawableLeft, 0)); 
    if (bm1.g(a.j.AppCompatTextHelper_android_drawableTop))
      this.c = a(context, l, bm1.g(a.j.AppCompatTextHelper_android_drawableTop, 0)); 
    if (bm1.g(a.j.AppCompatTextHelper_android_drawableRight))
      this.d = a(context, l, bm1.g(a.j.AppCompatTextHelper_android_drawableRight, 0)); 
    if (bm1.g(a.j.AppCompatTextHelper_android_drawableBottom))
      this.e = a(context, l, bm1.g(a.j.AppCompatTextHelper_android_drawableBottom, 0)); 
    if (Build.VERSION.SDK_INT >= 17) {
      if (bm1.g(a.j.AppCompatTextHelper_android_drawableStart))
        this.f = a(context, l, bm1.g(a.j.AppCompatTextHelper_android_drawableStart, 0)); 
      if (bm1.g(a.j.AppCompatTextHelper_android_drawableEnd))
        this.g = a(context, l, bm1.g(a.j.AppCompatTextHelper_android_drawableEnd, 0)); 
    } 
    bm1.a();
    boolean bool1 = this.a.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
    byte b1 = 1;
    ColorStateList colorStateList1 = null;
    if (m != -1) {
      bm bm = bm.a(context, m, a.j.TextAppearance);
      if (!bool1 && bm.g(a.j.TextAppearance_textAllCaps)) {
        bool2 = bm.a(a.j.TextAppearance_textAllCaps, false);
        b2 = 1;
      } else {
        b2 = 0;
        bool2 = false;
      } 
      a(context, bm);
      if (Build.VERSION.SDK_INT < 23) {
        Object object1;
        if (bm.g(a.j.TextAppearance_android_textColor)) {
          object1 = bm.e(a.j.TextAppearance_android_textColor);
        } else {
          object1 = null;
        } 
        if (bm.g(a.j.TextAppearance_android_textColorHint)) {
          colorStateList3 = bm.e(a.j.TextAppearance_android_textColorHint);
        } else {
          colorStateList3 = null;
        } 
        boolean bool = bm.g(a.j.TextAppearance_android_textColorLink);
        ColorStateList colorStateList = null;
        if (bool)
          colorStateList = bm.e(a.j.TextAppearance_android_textColorLink); 
        Object object2 = object1;
        colorStateList2 = colorStateList;
        colorStateList1 = object2;
      } else {
        colorStateList2 = null;
        colorStateList3 = null;
      } 
      bm.a();
    } else {
      colorStateList2 = null;
      colorStateList3 = null;
      b2 = 0;
      bool2 = false;
    } 
    bm bm2 = bm.a(context, paramAttributeSet, a.j.TextAppearance, paramInt, 0);
    if (!bool1 && bm2.g(a.j.TextAppearance_textAllCaps)) {
      bool2 = bm2.a(a.j.TextAppearance_textAllCaps, false);
    } else {
      b1 = b2;
    } 
    if (Build.VERSION.SDK_INT < 23) {
      if (bm2.g(a.j.TextAppearance_android_textColor))
        colorStateList1 = bm2.e(a.j.TextAppearance_android_textColor); 
      if (bm2.g(a.j.TextAppearance_android_textColorHint))
        colorStateList3 = bm2.e(a.j.TextAppearance_android_textColorHint); 
      if (bm2.g(a.j.TextAppearance_android_textColorLink))
        colorStateList2 = bm2.e(a.j.TextAppearance_android_textColorLink); 
    } 
    if (Build.VERSION.SDK_INT >= 28 && bm2.g(a.j.TextAppearance_android_textSize) && bm2.e(a.j.TextAppearance_android_textSize, -1) == 0)
      this.a.setTextSize(0, 0.0F); 
    a(context, bm2);
    bm2.a();
    if (colorStateList1 != null)
      this.a.setTextColor(colorStateList1); 
    if (colorStateList3 != null)
      this.a.setHintTextColor(colorStateList3); 
    if (colorStateList2 != null)
      this.a.setLinkTextColor(colorStateList2); 
    if (!bool1 && b1 != 0)
      a(bool2); 
    Typeface typeface = this.j;
    if (typeface != null)
      this.a.setTypeface(typeface, this.i); 
    this.h.a(paramAttributeSet, paramInt);
    if (b.a && this.h.a() != 0) {
      int[] arrayOfInt = this.h.e();
      if (arrayOfInt.length > 0)
        if (this.a.getAutoSizeStepGranularity() != -1.0F) {
          this.a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.d(), this.h.b(), 0);
        } else {
          this.a.setAutoSizeTextTypeUniformWithPresetSizes(arrayOfInt, 0);
        }  
    } 
    bm bm3 = bm.a(context, paramAttributeSet, a.j.AppCompatTextView);
    int n = bm3.e(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
    int i1 = bm3.e(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
    int i2 = bm3.e(a.j.AppCompatTextView_lineHeight, -1);
    bm3.a();
    if (n != -1)
      n.b(this.a, n); 
    if (i1 != -1)
      n.c(this.a, i1); 
    if (i2 != -1)
      n.d(this.a, i2); 
  }
  
  void a(WeakReference<TextView> paramWeakReference, Typeface paramTypeface) {
    if (this.k) {
      this.j = paramTypeface;
      TextView textView = (TextView)paramWeakReference.get();
      if (textView != null)
        textView.setTypeface(paramTypeface, this.i); 
    } 
  }
  
  void a(boolean paramBoolean) { this.a.setAllCaps(paramBoolean); }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!b.a)
      b(); 
  }
  
  void a(int[] paramArrayOfInt, int paramInt) { this.h.a(paramArrayOfInt, paramInt); }
  
  void b() { this.h.f(); }
  
  boolean c() { return this.h.g(); }
  
  int d() { return this.h.a(); }
  
  int e() { return this.h.b(); }
  
  int f() { return this.h.c(); }
  
  int g() { return this.h.d(); }
  
  int[] h() { return this.h.e(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */