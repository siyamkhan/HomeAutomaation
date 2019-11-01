package android.support.design.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g extends Object implements TypeEvaluator<Matrix> {
  private final float[] a = new float[9];
  
  private final float[] b = new float[9];
  
  private final Matrix c = new Matrix();
  
  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2) {
    paramMatrix1.getValues(this.a);
    paramMatrix2.getValues(this.b);
    for (byte b1 = 0; b1 < 9; b1++) {
      float[] arrayOfFloat1 = this.b;
      float f1 = arrayOfFloat1[b1];
      float[] arrayOfFloat2 = this.a;
      float f2 = f1 - arrayOfFloat2[b1];
      arrayOfFloat1[b1] = arrayOfFloat2[b1] + f2 * paramFloat;
    } 
    this.c.setValues(this.b);
    return this.c;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */