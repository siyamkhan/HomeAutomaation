package android.support.design.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class b extends FrameLayout implements d {
  private final c a;
  
  public void a() { this.a.a(); }
  
  public void a(Canvas paramCanvas) { super.draw(paramCanvas); }
  
  public void b() { this.a.b(); }
  
  public boolean c() { return super.isOpaque(); }
  
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {
    c c1 = this.a;
    if (c1 != null) {
      c1.a(paramCanvas);
      return;
    } 
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable() { return this.a.e(); }
  
  public int getCircularRevealScrimColor() { return this.a.d(); }
  
  public d.d getRevealInfo() { return this.a.c(); }
  
  public boolean isOpaque() {
    c c1 = this.a;
    return (c1 != null) ? c1.f() : super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable) { this.a.a(paramDrawable); }
  
  public void setCircularRevealScrimColor(int paramInt) { this.a.a(paramInt); }
  
  public void setRevealInfo(d.d paramd) { this.a.a(paramd); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */