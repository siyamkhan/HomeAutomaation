package android.support.v4.h.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
  private final float[] a;
  
  private final float b;
  
  protected d(float[] paramArrayOfFloat) {
    this.a = paramArrayOfFloat;
    this.b = 1.0F / (-1 + this.a.length);
  }
  
  public float getInterpolation(float paramFloat) {
    if (paramFloat >= 1.0F)
      return 1.0F; 
    if (paramFloat <= 0.0F)
      return 0.0F; 
    float[] arrayOfFloat1 = this.a;
    int i = Math.min((int)(paramFloat * (-1 + arrayOfFloat1.length)), -2 + arrayOfFloat1.length);
    float f1 = i;
    float f2 = this.b;
    float f3 = (paramFloat - f1 * f2) / f2;
    float[] arrayOfFloat2 = this.a;
    return arrayOfFloat2[i] + f3 * (arrayOfFloat2[i + 1] - arrayOfFloat2[i]);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */