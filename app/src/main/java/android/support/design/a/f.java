package android.support.design.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class f extends Property<ImageView, Matrix> {
  private final Matrix a = new Matrix();
  
  public f() { super(Matrix.class, "imageMatrixProperty"); }
  
  public Matrix a(ImageView paramImageView) {
    this.a.set(paramImageView.getImageMatrix());
    return this.a;
  }
  
  public void a(ImageView paramImageView, Matrix paramMatrix) { paramImageView.setImageMatrix(paramMatrix); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */