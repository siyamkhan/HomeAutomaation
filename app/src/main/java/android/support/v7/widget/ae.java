package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class ae implements ag {
  final RectF a = new RectF();
  
  private bb a(Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) { return new bb(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3); }
  
  private bb j(af paramaf) { return (bb)paramaf.c(); }
  
  public float a(af paramaf) { return j(paramaf).c(); }
  
  public void a() { bb.a = new bb.a(this) {
        public void a(Canvas param1Canvas, RectF param1RectF, float param1Float, Paint param1Paint) {
          float f1 = 2.0F * param1Float;
          float f2 = param1RectF.width() - f1 - 1.0F;
          float f3 = param1RectF.height() - f1 - 1.0F;
          if (param1Float >= 1.0F) {
            float f4 = param1Float + 0.5F;
            RectF rectF = this.a.a;
            float f5 = -f4;
            rectF.set(f5, f5, f4, f4);
            int i = param1Canvas.save();
            param1Canvas.translate(f4 + param1RectF.left, f4 + param1RectF.top);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.translate(f2, 0.0F);
            param1Canvas.rotate(90.0F);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.translate(f3, 0.0F);
            param1Canvas.rotate(90.0F);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.translate(f2, 0.0F);
            param1Canvas.rotate(90.0F);
            param1Canvas.drawArc(this.a.a, 180.0F, 90.0F, true, param1Paint);
            param1Canvas.restoreToCount(i);
            param1Canvas.drawRect(f4 + param1RectF.left - 1.0F, param1RectF.top, 1.0F + param1RectF.right - f4, f4 + param1RectF.top, param1Paint);
            param1Canvas.drawRect(f4 + param1RectF.left - 1.0F, param1RectF.bottom - f4, 1.0F + param1RectF.right - f4, param1RectF.bottom, param1Paint);
          } 
          param1Canvas.drawRect(param1RectF.left, param1Float + param1RectF.top, param1RectF.right, param1RectF.bottom - param1Float, param1Paint);
        }
      }; }
  
  public void a(af paramaf, float paramFloat) {
    j(paramaf).a(paramFloat);
    f(paramaf);
  }
  
  public void a(af paramaf, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) {
    bb bb = a(paramContext, paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    bb.a(paramaf.b());
    paramaf.a(bb);
    f(paramaf);
  }
  
  public void a(af paramaf, ColorStateList paramColorStateList) { j(paramaf).a(paramColorStateList); }
  
  public float b(af paramaf) { return j(paramaf).d(); }
  
  public void b(af paramaf, float paramFloat) {
    j(paramaf).c(paramFloat);
    f(paramaf);
  }
  
  public float c(af paramaf) { return j(paramaf).e(); }
  
  public void c(af paramaf, float paramFloat) { j(paramaf).b(paramFloat); }
  
  public float d(af paramaf) { return j(paramaf).a(); }
  
  public float e(af paramaf) { return j(paramaf).b(); }
  
  public void f(af paramaf) {
    Rect rect = new Rect();
    j(paramaf).a(rect);
    paramaf.a((int)Math.ceil(b(paramaf)), (int)Math.ceil(c(paramaf)));
    paramaf.a(rect.left, rect.top, rect.right, rect.bottom);
  }
  
  public void g(af paramaf) {}
  
  public void h(af paramaf) {
    j(paramaf).a(paramaf.b());
    f(paramaf);
  }
  
  public ColorStateList i(af paramaf) { return j(paramaf).f(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */