package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

class c extends GradientDrawable {
  private final Paint a = new Paint(1);
  
  private final RectF b;
  
  private int c;
  
  c() {
    c();
    this.b = new RectF();
  }
  
  private void a(Canvas paramCanvas) {
    Drawable.Callback callback = getCallback();
    if (a(callback)) {
      ((View)callback).setLayerType(2, null);
      return;
    } 
    b(paramCanvas);
  }
  
  private boolean a(Drawable.Callback paramCallback) { return paramCallback instanceof View; }
  
  private void b(Canvas paramCanvas) {
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
    } else {
      i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
    } 
    this.c = i;
  }
  
  private void c() {
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setColor(-1);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private void c(Canvas paramCanvas) {
    if (!a(getCallback()))
      paramCanvas.restoreToCount(this.c); 
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (paramFloat1 != this.b.left || paramFloat2 != this.b.top || paramFloat3 != this.b.right || paramFloat4 != this.b.bottom) {
      this.b.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    } 
  }
  
  void a(RectF paramRectF) { a(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom); }
  
  boolean a() { return true ^ this.b.isEmpty(); }
  
  void b() { a(0.0F, 0.0F, 0.0F, 0.0F); }
  
  public void draw(Canvas paramCanvas) {
    a(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(this.b, this.a);
    c(paramCanvas);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */