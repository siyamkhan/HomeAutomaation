package android.support.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class r {
  private static final boolean a;
  
  private static final boolean b;
  
  private static final boolean c;
  
  static  {
    boolean bool3;
    boolean bool2;
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = true;
    if (i >= 19) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    a = bool2;
    if (Build.VERSION.SDK_INT >= 18) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    b = bool3;
    if (Build.VERSION.SDK_INT < 28)
      bool1 = false; 
    c = bool1;
  }
  
  static Animator a(Animator paramAnimator1, Animator paramAnimator2) {
    if (paramAnimator1 == null)
      return paramAnimator2; 
    if (paramAnimator2 == null)
      return paramAnimator1; 
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return animatorSet;
  }
  
  private static Bitmap a(View paramView, Matrix paramMatrix, RectF paramRectF, ViewGroup paramViewGroup) { // Byte code:
    //   0: getstatic android/support/e/r.a : Z
    //   3: istore #4
    //   5: iconst_0
    //   6: istore #5
    //   8: iload #4
    //   10: ifeq -> 37
    //   13: iconst_1
    //   14: aload_0
    //   15: invokevirtual isAttachedToWindow : ()Z
    //   18: ixor
    //   19: istore #6
    //   21: aload_3
    //   22: ifnonnull -> 28
    //   25: goto -> 40
    //   28: aload_3
    //   29: invokevirtual isAttachedToWindow : ()Z
    //   32: istore #7
    //   34: goto -> 43
    //   37: iconst_0
    //   38: istore #6
    //   40: iconst_0
    //   41: istore #7
    //   43: getstatic android/support/e/r.b : Z
    //   46: ifeq -> 97
    //   49: iload #6
    //   51: ifeq -> 97
    //   54: iload #7
    //   56: ifne -> 61
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   65: checkcast android/view/ViewGroup
    //   68: astore #20
    //   70: aload #20
    //   72: aload_0
    //   73: invokevirtual indexOfChild : (Landroid/view/View;)I
    //   76: istore #21
    //   78: aload_3
    //   79: invokevirtual getOverlay : ()Landroid/view/ViewGroupOverlay;
    //   82: aload_0
    //   83: invokevirtual add : (Landroid/view/View;)V
    //   86: aload #20
    //   88: astore #8
    //   90: iload #21
    //   92: istore #5
    //   94: goto -> 100
    //   97: aconst_null
    //   98: astore #8
    //   100: aload_2
    //   101: invokevirtual width : ()F
    //   104: invokestatic round : (F)I
    //   107: istore #9
    //   109: aload_2
    //   110: invokevirtual height : ()F
    //   113: invokestatic round : (F)I
    //   116: istore #10
    //   118: aconst_null
    //   119: astore #11
    //   121: iload #9
    //   123: ifle -> 283
    //   126: aconst_null
    //   127: astore #11
    //   129: iload #10
    //   131: ifle -> 283
    //   134: fconst_1
    //   135: ldc 1048576.0
    //   137: iload #9
    //   139: iload #10
    //   141: imul
    //   142: i2f
    //   143: fdiv
    //   144: invokestatic min : (FF)F
    //   147: fstore #12
    //   149: fload #12
    //   151: iload #9
    //   153: i2f
    //   154: fmul
    //   155: invokestatic round : (F)I
    //   158: istore #13
    //   160: fload #12
    //   162: iload #10
    //   164: i2f
    //   165: fmul
    //   166: invokestatic round : (F)I
    //   169: istore #14
    //   171: aload_1
    //   172: aload_2
    //   173: getfield left : F
    //   176: fneg
    //   177: aload_2
    //   178: getfield top : F
    //   181: fneg
    //   182: invokevirtual postTranslate : (FF)Z
    //   185: pop
    //   186: aload_1
    //   187: fload #12
    //   189: fload #12
    //   191: invokevirtual postScale : (FF)Z
    //   194: pop
    //   195: getstatic android/support/e/r.c : Z
    //   198: ifeq -> 248
    //   201: new android/graphics/Picture
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #17
    //   210: aload #17
    //   212: iload #13
    //   214: iload #14
    //   216: invokevirtual beginRecording : (II)Landroid/graphics/Canvas;
    //   219: astore #18
    //   221: aload #18
    //   223: aload_1
    //   224: invokevirtual concat : (Landroid/graphics/Matrix;)V
    //   227: aload_0
    //   228: aload #18
    //   230: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   233: aload #17
    //   235: invokevirtual endRecording : ()V
    //   238: aload #17
    //   240: invokestatic createBitmap : (Landroid/graphics/Picture;)Landroid/graphics/Bitmap;
    //   243: astore #11
    //   245: goto -> 283
    //   248: iload #13
    //   250: iload #14
    //   252: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   255: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   258: astore #11
    //   260: new android/graphics/Canvas
    //   263: dup
    //   264: aload #11
    //   266: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   269: astore #19
    //   271: aload #19
    //   273: aload_1
    //   274: invokevirtual concat : (Landroid/graphics/Matrix;)V
    //   277: aload_0
    //   278: aload #19
    //   280: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   283: getstatic android/support/e/r.b : Z
    //   286: ifeq -> 310
    //   289: iload #6
    //   291: ifeq -> 310
    //   294: aload_3
    //   295: invokevirtual getOverlay : ()Landroid/view/ViewGroupOverlay;
    //   298: aload_0
    //   299: invokevirtual remove : (Landroid/view/View;)V
    //   302: aload #8
    //   304: aload_0
    //   305: iload #5
    //   307: invokevirtual addView : (Landroid/view/View;I)V
    //   310: aload #11
    //   312: areturn }
  
  static View a(ViewGroup paramViewGroup, View paramView1, View paramView2) {
    Matrix matrix = new Matrix();
    matrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    ad.a(paramView1, matrix);
    ad.b(paramViewGroup, matrix);
    RectF rectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    matrix.mapRect(rectF);
    int i = Math.round(rectF.left);
    int j = Math.round(rectF.top);
    int k = Math.round(rectF.right);
    int m = Math.round(rectF.bottom);
    ImageView imageView = new ImageView(paramView1.getContext());
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Bitmap bitmap = a(paramView1, matrix, rectF, paramViewGroup);
    if (bitmap != null)
      imageView.setImageBitmap(bitmap); 
    imageView.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    imageView.layout(i, j, k, m);
    return imageView;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */