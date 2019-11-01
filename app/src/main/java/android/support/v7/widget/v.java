package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class v extends RatingBar {
  private final t a = new t(this);
  
  public v(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.ratingBarStyle); }
  
  public v(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: iload_2
    //   5: invokespecial onMeasure : (II)V
    //   8: aload_0
    //   9: getfield a : Landroid/support/v7/widget/t;
    //   12: invokevirtual a : ()Landroid/graphics/Bitmap;
    //   15: astore #4
    //   17: aload #4
    //   19: ifnull -> 45
    //   22: aload_0
    //   23: aload #4
    //   25: invokevirtual getWidth : ()I
    //   28: aload_0
    //   29: invokevirtual getNumStars : ()I
    //   32: imul
    //   33: iload_1
    //   34: iconst_0
    //   35: invokestatic resolveSizeAndState : (III)I
    //   38: aload_0
    //   39: invokevirtual getMeasuredHeight : ()I
    //   42: invokevirtual setMeasuredDimension : (II)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_3
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	48	finally
    //   22	45	48	finally }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */