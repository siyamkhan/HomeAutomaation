package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.design.a;
import android.support.design.a.a;
import android.support.design.a.b;
import android.support.v4.h.r;
import android.support.v4.widget.m;
import android.support.v4.widget.n;
import android.support.v7.widget.aa;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class j {
  private final Context a;
  
  private final TextInputLayout b;
  
  private LinearLayout c;
  
  private int d;
  
  private FrameLayout e;
  
  private int f;
  
  private Animator g;
  
  private final float h;
  
  private int i;
  
  private int j;
  
  private CharSequence k;
  
  private boolean l;
  
  private TextView m;
  
  private int n;
  
  private CharSequence o;
  
  private boolean p;
  
  private TextView q;
  
  private int r;
  
  private Typeface s;
  
  public j(TextInputLayout paramTextInputLayout) {
    this.a = paramTextInputLayout.getContext();
    this.b = paramTextInputLayout;
    this.h = this.a.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y);
  }
  
  private ObjectAnimator a(TextView paramTextView) {
    Property property = View.TRANSLATION_Y;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = -this.h;
    arrayOfFloat[1] = 0.0F;
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramTextView, property, arrayOfFloat);
    objectAnimator.setDuration(217L);
    objectAnimator.setInterpolator(a.d);
    return objectAnimator;
  }
  
  private ObjectAnimator a(TextView paramTextView, boolean paramBoolean) {
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    } 
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f1 });
    objectAnimator.setDuration(167L);
    objectAnimator.setInterpolator(a.a);
    return objectAnimator;
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (paramInt1 == paramInt2)
      return; 
    if (paramInt2 != 0) {
      TextView textView = d(paramInt2);
      if (textView != null) {
        textView.setVisibility(0);
        textView.setAlpha(1.0F);
      } 
    } 
    if (paramInt1 != 0) {
      TextView textView = d(paramInt1);
      if (textView != null) {
        textView.setVisibility(4);
        if (paramInt1 == 1)
          textView.setText(null); 
      } 
    } 
    this.i = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramBoolean) {
      AnimatorSet animatorSet = new AnimatorSet();
      this.g = animatorSet;
      ArrayList arrayList = new ArrayList();
      a(arrayList, this.p, this.q, 2, paramInt1, paramInt2);
      a(arrayList, this.l, this.m, 1, paramInt1, paramInt2);
      b.a(animatorSet, arrayList);
      TextView textView1 = d(paramInt1);
      TextView textView2 = d(paramInt2);
      AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this, paramInt2, textView1, paramInt1, textView2) {
          public void onAnimationEnd(Animator param1Animator) {
            j.a(this.e, this.a);
            j.a(this.e, null);
            TextView textView = this.b;
            if (textView != null) {
              textView.setVisibility(4);
              if (this.c == 1 && j.a(this.e) != null)
                j.a(this.e).setText(null); 
            } 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            TextView textView = this.d;
            if (textView != null)
              textView.setVisibility(0); 
          }
        };
      animatorSet.addListener(animatorListenerAdapter);
      animatorSet.start();
    } else {
      a(paramInt1, paramInt2);
    } 
    this.b.c();
    this.b.a(paramBoolean);
    this.b.d();
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt) {
    if (paramInt == 0)
      paramViewGroup.setVisibility(8); 
  }
  
  private void a(TextView paramTextView, Typeface paramTypeface) {
    if (paramTextView != null)
      paramTextView.setTypeface(paramTypeface); 
  }
  
  private void a(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramTextView != null) {
      if (!paramBoolean)
        return; 
      if (paramInt1 == paramInt3 || paramInt1 == paramInt2) {
        boolean bool;
        if (paramInt3 == paramInt1) {
          bool = true;
        } else {
          bool = false;
        } 
        paramList.add(a(paramTextView, bool));
        if (paramInt3 == paramInt1)
          paramList.add(a(paramTextView)); 
      } 
    } 
  }
  
  private boolean a(TextView paramTextView, CharSequence paramCharSequence) { return (r.x(this.b) && this.b.isEnabled() && (this.j != this.i || paramTextView == null || !TextUtils.equals(paramTextView.getText(), paramCharSequence))); }
  
  private TextView d(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 2:
        return this.q;
      case 1:
        break;
    } 
    return this.m;
  }
  
  private boolean e(int paramInt) { return (paramInt == 1 && this.m != null && !TextUtils.isEmpty(this.k)); }
  
  private boolean m() { return (this.c != null && this.b.getEditText() != null); }
  
  void a() {
    c();
    if (this.i == 2)
      this.j = 0; 
    a(this.i, this.j, a(this.q, null));
  }
  
  void a(ColorStateList paramColorStateList) {
    TextView textView = this.m;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  void a(Typeface paramTypeface) {
    if (paramTypeface != this.s) {
      this.s = paramTypeface;
      a(this.m, paramTypeface);
      a(this.q, paramTypeface);
    } 
  }
  
  void a(TextView paramTextView, int paramInt) {
    if (this.c == null && this.e == null) {
      this.c = new LinearLayout(this.a);
      this.c.setOrientation(0);
      this.b.addView(this.c, -1, -2);
      this.e = new FrameLayout(this.a);
      this.c.addView(this.e, -1, new FrameLayout.LayoutParams(-2, -2));
      m m1 = new m(this.a);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.c.addView(m1, layoutParams);
      if (this.b.getEditText() != null)
        d(); 
    } 
    if (a(paramInt)) {
      this.e.setVisibility(0);
      this.e.addView(paramTextView);
      this.f = 1 + this.f;
    } else {
      this.c.addView(paramTextView, paramInt);
    } 
    this.c.setVisibility(0);
    this.d = 1 + this.d;
  }
  
  void a(CharSequence paramCharSequence) {
    c();
    this.o = paramCharSequence;
    this.q.setText(paramCharSequence);
    if (this.i != 2)
      this.j = 2; 
    a(this.i, this.j, a(this.q, paramCharSequence));
  }
  
  void a(boolean paramBoolean) {
    if (this.l == paramBoolean)
      return; 
    c();
    if (paramBoolean) {
      this.m = new aa(this.a);
      this.m.setId(a.f.textinput_error);
      Typeface typeface = this.s;
      if (typeface != null)
        this.m.setTypeface(typeface); 
      b(this.n);
      this.m.setVisibility(4);
      r.c(this.m, 1);
      a(this.m, 0);
    } else {
      b();
      b(this.m, 0);
      this.m = null;
      this.b.c();
      this.b.d();
    } 
    this.l = paramBoolean;
  }
  
  boolean a(int paramInt) {
    boolean bool = true;
    if (paramInt != 0) {
      if (paramInt == bool)
        return bool; 
      bool = false;
    } 
    return bool;
  }
  
  void b() {
    this.k = null;
    c();
    if (this.i == 1) {
      boolean bool;
      if (this.p && !TextUtils.isEmpty(this.o)) {
        bool = true;
      } else {
        bool = false;
      } 
      this.j = bool;
    } 
    a(this.i, this.j, a(this.m, null));
  }
  
  void b(int paramInt) {
    this.n = paramInt;
    TextView textView = this.m;
    if (textView != null)
      this.b.a(textView, paramInt); 
  }
  
  void b(ColorStateList paramColorStateList) {
    TextView textView = this.q;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  void b(TextView paramTextView, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/widget/LinearLayout;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: aload_0
    //   9: iload_2
    //   10: invokevirtual a : (I)Z
    //   13: ifeq -> 55
    //   16: aload_0
    //   17: getfield e : Landroid/widget/FrameLayout;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull -> 55
    //   25: aload_0
    //   26: iconst_m1
    //   27: aload_0
    //   28: getfield f : I
    //   31: iadd
    //   32: putfield f : I
    //   35: aload_0
    //   36: aload_3
    //   37: aload_0
    //   38: getfield f : I
    //   41: invokespecial a : (Landroid/view/ViewGroup;I)V
    //   44: aload_0
    //   45: getfield e : Landroid/widget/FrameLayout;
    //   48: aload_1
    //   49: invokevirtual removeView : (Landroid/view/View;)V
    //   52: goto -> 63
    //   55: aload_0
    //   56: getfield c : Landroid/widget/LinearLayout;
    //   59: aload_1
    //   60: invokevirtual removeView : (Landroid/view/View;)V
    //   63: aload_0
    //   64: iconst_m1
    //   65: aload_0
    //   66: getfield d : I
    //   69: iadd
    //   70: putfield d : I
    //   73: aload_0
    //   74: aload_0
    //   75: getfield c : Landroid/widget/LinearLayout;
    //   78: aload_0
    //   79: getfield d : I
    //   82: invokespecial a : (Landroid/view/ViewGroup;I)V
    //   85: return }
  
  void b(CharSequence paramCharSequence) {
    c();
    this.k = paramCharSequence;
    this.m.setText(paramCharSequence);
    if (this.i != 1)
      this.j = 1; 
    a(this.i, this.j, a(this.m, paramCharSequence));
  }
  
  void b(boolean paramBoolean) {
    if (this.p == paramBoolean)
      return; 
    c();
    if (paramBoolean) {
      this.q = new aa(this.a);
      this.q.setId(a.f.textinput_helper_text);
      Typeface typeface = this.s;
      if (typeface != null)
        this.q.setTypeface(typeface); 
      this.q.setVisibility(4);
      r.c(this.q, 1);
      c(this.r);
      a(this.q, 1);
    } else {
      a();
      b(this.q, 1);
      this.q = null;
      this.b.c();
      this.b.d();
    } 
    this.p = paramBoolean;
  }
  
  void c() {
    Animator animator = this.g;
    if (animator != null)
      animator.cancel(); 
  }
  
  void c(int paramInt) {
    this.r = paramInt;
    TextView textView = this.q;
    if (textView != null)
      n.a(textView, paramInt); 
  }
  
  void d() {
    if (m())
      r.a(this.c, r.h(this.b.getEditText()), 0, r.i(this.b.getEditText()), 0); 
  }
  
  boolean e() { return this.l; }
  
  boolean f() { return this.p; }
  
  boolean g() { return e(this.j); }
  
  CharSequence h() { return this.k; }
  
  CharSequence i() { return this.o; }
  
  int j() {
    TextView textView = this.m;
    return (textView != null) ? textView.getCurrentTextColor() : -1;
  }
  
  ColorStateList k() {
    TextView textView = this.m;
    return (textView != null) ? textView.getTextColors() : null;
  }
  
  int l() {
    TextView textView = this.q;
    return (textView != null) ? textView.getCurrentTextColor() : -1;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */