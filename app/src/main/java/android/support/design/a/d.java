package android.support.design.a;

import android.support.design.a;
import android.util.Property;
import android.view.ViewGroup;

public class d extends Property<ViewGroup, Float> {
  public static final Property<ViewGroup, Float> a = new d("childrenAlpha");
  
  private d(String paramString) { super(Float.class, paramString); }
  
  public Float a(ViewGroup paramViewGroup) {
    Float float = (Float)paramViewGroup.getTag(a.f.mtrl_internal_children_alpha_tag);
    return (float != null) ? float : Float.valueOf(1.0F);
  }
  
  public void a(ViewGroup paramViewGroup, Float paramFloat) {
    float f = paramFloat.floatValue();
    paramViewGroup.setTag(a.f.mtrl_internal_children_alpha_tag, Float.valueOf(f));
    int i = paramViewGroup.getChildCount();
    for (byte b = 0; b < i; b++)
      paramViewGroup.getChildAt(b).setAlpha(f); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */