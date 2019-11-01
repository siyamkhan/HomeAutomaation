package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class o {
  ValueAnimator a = null;
  
  private final ArrayList<a> b = new ArrayList();
  
  private a c = null;
  
  private final Animator.AnimatorListener d = new AnimatorListenerAdapter(this) {
      public void onAnimationEnd(Animator param1Animator) {
        if (this.a.a == param1Animator)
          this.a.a = null; 
      }
    };
  
  private void a(a parama) {
    this.a = parama.b;
    this.a.start();
  }
  
  private void b() {
    ValueAnimator valueAnimator = this.a;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.a = null;
    } 
  }
  
  public void a() {
    ValueAnimator valueAnimator = this.a;
    if (valueAnimator != null) {
      valueAnimator.end();
      this.a = null;
    } 
  }
  
  public void a(int[] paramArrayOfInt) { // Byte code:
    //   0: aload_0
    //   1: getfield b : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: istore_2
    //   8: iconst_0
    //   9: istore_3
    //   10: iload_3
    //   11: iload_2
    //   12: if_icmpge -> 49
    //   15: aload_0
    //   16: getfield b : Ljava/util/ArrayList;
    //   19: iload_3
    //   20: invokevirtual get : (I)Ljava/lang/Object;
    //   23: checkcast android/support/design/widget/o$a
    //   26: astore #4
    //   28: aload #4
    //   30: getfield a : [I
    //   33: aload_1
    //   34: invokestatic stateSetMatches : ([I[I)Z
    //   37: ifeq -> 43
    //   40: goto -> 52
    //   43: iinc #3, 1
    //   46: goto -> 10
    //   49: aconst_null
    //   50: astore #4
    //   52: aload_0
    //   53: getfield c : Landroid/support/design/widget/o$a;
    //   56: astore #5
    //   58: aload #4
    //   60: aload #5
    //   62: if_acmpne -> 66
    //   65: return
    //   66: aload #5
    //   68: ifnull -> 75
    //   71: aload_0
    //   72: invokespecial b : ()V
    //   75: aload_0
    //   76: aload #4
    //   78: putfield c : Landroid/support/design/widget/o$a;
    //   81: aload #4
    //   83: ifnull -> 92
    //   86: aload_0
    //   87: aload #4
    //   89: invokespecial a : (Landroid/support/design/widget/o$a;)V
    //   92: return }
  
  public void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator) {
    a a1 = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.d);
    this.b.add(a1);
  }
  
  static class a {
    final int[] a;
    
    final ValueAnimator b;
    
    a(int[] param1ArrayOfInt, ValueAnimator param1ValueAnimator) {
      this.a = param1ArrayOfInt;
      this.b = param1ValueAnimator;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */