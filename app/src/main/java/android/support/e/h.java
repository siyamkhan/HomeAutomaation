package android.support.e;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class h<T> extends Property<T, Float> {
  private final Property<T, PointF> a;
  
  private final PathMeasure b;
  
  private final float c;
  
  private final float[] d = new float[2];
  
  private final PointF e = new PointF();
  
  private float f;
  
  h(Property<T, PointF> paramProperty, Path paramPath) {
    super(Float.class, paramProperty.getName());
    this.a = paramProperty;
    this.b = new PathMeasure(paramPath, false);
    this.c = this.b.getLength();
  }
  
  public Float a(T paramT) { return Float.valueOf(this.f); }
  
  public void a(T paramT, Float paramFloat) {
    this.f = paramFloat.floatValue();
    this.b.getPosTan(this.c * paramFloat.floatValue(), this.d, null);
    PointF pointF = this.e;
    float[] arrayOfFloat = this.d;
    pointF.x = arrayOfFloat[0];
    pointF.y = arrayOfFloat[1];
    this.a.set(paramT, pointF);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */