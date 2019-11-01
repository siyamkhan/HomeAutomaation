package android.support.design.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

public class e extends Property<Drawable, Integer> {
  public static final Property<Drawable, Integer> a = new e();
  
  private final WeakHashMap<Drawable, Integer> b = new WeakHashMap();
  
  private e() { super(Integer.class, "drawableAlphaCompat"); }
  
  public Integer a(Drawable paramDrawable) { return (Build.VERSION.SDK_INT >= 19) ? Integer.valueOf(paramDrawable.getAlpha()) : (this.b.containsKey(paramDrawable) ? (Integer)this.b.get(paramDrawable) : Integer.valueOf(255)); }
  
  public void a(Drawable paramDrawable, Integer paramInteger) {
    if (Build.VERSION.SDK_INT < 19)
      this.b.put(paramDrawable, paramInteger); 
    paramDrawable.setAlpha(paramInteger.intValue());
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */