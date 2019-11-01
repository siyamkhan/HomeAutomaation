package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class ad implements ag {
  private ba j(af paramaf) { return (ba)paramaf.c(); }
  
  public float a(af paramaf) { return j(paramaf).a(); }
  
  public void a() {}
  
  public void a(af paramaf, float paramFloat) { j(paramaf).a(paramFloat); }
  
  public void a(af paramaf, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) {
    paramaf.a(new ba(paramColorStateList, paramFloat1));
    View view = paramaf.d();
    view.setClipToOutline(true);
    view.setElevation(paramFloat2);
    b(paramaf, paramFloat3);
  }
  
  public void a(af paramaf, ColorStateList paramColorStateList) { j(paramaf).a(paramColorStateList); }
  
  public float b(af paramaf) { return 2.0F * d(paramaf); }
  
  public void b(af paramaf, float paramFloat) {
    j(paramaf).a(paramFloat, paramaf.a(), paramaf.b());
    f(paramaf);
  }
  
  public float c(af paramaf) { return 2.0F * d(paramaf); }
  
  public void c(af paramaf, float paramFloat) { paramaf.d().setElevation(paramFloat); }
  
  public float d(af paramaf) { return j(paramaf).b(); }
  
  public float e(af paramaf) { return paramaf.d().getElevation(); }
  
  public void f(af paramaf) {
    if (!paramaf.a()) {
      paramaf.a(0, 0, 0, 0);
      return;
    } 
    float f1 = a(paramaf);
    float f2 = d(paramaf);
    int i = (int)Math.ceil(bb.b(f1, f2, paramaf.b()));
    int j = (int)Math.ceil(bb.a(f1, f2, paramaf.b()));
    paramaf.a(i, j, i, j);
  }
  
  public void g(af paramaf) { b(paramaf, a(paramaf)); }
  
  public void h(af paramaf) { b(paramaf, a(paramaf)); }
  
  public ColorStateList i(af paramaf) { return j(paramaf).c(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */