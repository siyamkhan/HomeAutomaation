package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.f.a;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;

class g extends f {
  private InsetDrawable x;
  
  g(t paramt, m paramm) { super(paramt, paramm); }
  
  private Animator a(float paramFloat1, float paramFloat2) {
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play(ObjectAnimator.ofFloat(this.v, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.v, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    animatorSet.setInterpolator(a);
    return animatorSet;
  }
  
  public float a() { return this.v.getElevation(); }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (Build.VERSION.SDK_INT == 21) {
      this.v.refreshDrawableState();
    } else {
      StateListAnimator stateListAnimator = new StateListAnimator();
      stateListAnimator.addState(p, a(paramFloat1, paramFloat3));
      stateListAnimator.addState(q, a(paramFloat1, paramFloat2));
      stateListAnimator.addState(r, a(paramFloat1, paramFloat2));
      stateListAnimator.addState(s, a(paramFloat1, paramFloat2));
      AnimatorSet animatorSet = new AnimatorSet();
      ArrayList arrayList = new ArrayList();
      arrayList.add(ObjectAnimator.ofFloat(this.v, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
        t t = this.v;
        Property property = View.TRANSLATION_Z;
        float[] arrayOfFloat = new float[1];
        arrayOfFloat[0] = this.v.getTranslationZ();
        arrayList.add(ObjectAnimator.ofFloat(t, property, arrayOfFloat).setDuration(100L));
      } 
      arrayList.add(ObjectAnimator.ofFloat(this.v, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      animatorSet.playSequentially((Animator[])arrayList.toArray(new Animator[0]));
      animatorSet.setInterpolator(a);
      stateListAnimator.addState(t, animatorSet);
      stateListAnimator.addState(u, a(0.0F, 0.0F));
      this.v.setStateListAnimator(stateListAnimator);
    } 
    if (this.w.b())
      j(); 
  }
  
  void a(Rect paramRect) {
    if (this.w.b()) {
      float f1 = this.w.a();
      float f2 = a() + this.m;
      int i = (int)Math.ceil(l.b(f2, f1, false));
      int j = (int)Math.ceil(l.a(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    } 
    paramRect.set(0, 0, 0, 0);
  }
  
  void a(int[] paramArrayOfInt) { // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #21
    //   5: if_icmpne -> 111
    //   8: aload_0
    //   9: getfield v : Landroid/support/design/widget/t;
    //   12: invokevirtual isEnabled : ()Z
    //   15: istore_2
    //   16: fconst_0
    //   17: fstore_3
    //   18: iload_2
    //   19: ifeq -> 91
    //   22: aload_0
    //   23: getfield v : Landroid/support/design/widget/t;
    //   26: aload_0
    //   27: getfield k : F
    //   30: invokevirtual setElevation : (F)V
    //   33: aload_0
    //   34: getfield v : Landroid/support/design/widget/t;
    //   37: invokevirtual isPressed : ()Z
    //   40: ifeq -> 57
    //   43: aload_0
    //   44: getfield v : Landroid/support/design/widget/t;
    //   47: astore #4
    //   49: aload_0
    //   50: getfield m : F
    //   53: fstore_3
    //   54: goto -> 105
    //   57: aload_0
    //   58: getfield v : Landroid/support/design/widget/t;
    //   61: invokevirtual isFocused : ()Z
    //   64: ifne -> 77
    //   67: aload_0
    //   68: getfield v : Landroid/support/design/widget/t;
    //   71: invokevirtual isHovered : ()Z
    //   74: ifeq -> 99
    //   77: aload_0
    //   78: getfield v : Landroid/support/design/widget/t;
    //   81: astore #4
    //   83: aload_0
    //   84: getfield l : F
    //   87: fstore_3
    //   88: goto -> 105
    //   91: aload_0
    //   92: getfield v : Landroid/support/design/widget/t;
    //   95: fconst_0
    //   96: invokevirtual setElevation : (F)V
    //   99: aload_0
    //   100: getfield v : Landroid/support/design/widget/t;
    //   103: astore #4
    //   105: aload #4
    //   107: fload_3
    //   108: invokevirtual setTranslationZ : (F)V
    //   111: return }
  
  void b(ColorStateList paramColorStateList) {
    if (this.h instanceof RippleDrawable) {
      ((RippleDrawable)this.h).setColor(a.a(paramColorStateList));
      return;
    } 
    super.b(paramColorStateList);
  }
  
  void b(Rect paramRect) {
    Drawable drawable;
    m m;
    if (this.w.b()) {
      InsetDrawable insetDrawable = new InsetDrawable(this.h, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      this.x = insetDrawable;
      m = this.w;
      drawable = this.x;
    } else {
      m = this.w;
      drawable = this.h;
    } 
    m.a(drawable);
  }
  
  void g() {}
  
  void i() { j(); }
  
  boolean m() { return false; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */