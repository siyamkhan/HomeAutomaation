package android.support.e;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

class f {
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath) { return (Build.VERSION.SDK_INT >= 21) ? ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath) : ObjectAnimator.ofFloat(paramT, new h(paramProperty, paramPath), new float[] { 0.0F, 1.0F }); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */