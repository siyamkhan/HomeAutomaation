package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {
  final ActionBarContainer a;
  
  public b(ActionBarContainer paramActionBarContainer) { this.a = paramActionBarContainer; }
  
  public void draw(Canvas paramCanvas) {
    Drawable drawable;
    if (this.a.d) {
      if (this.a.c != null) {
        drawable = this.a.c;
      } else {
        return;
      } 
    } else {
      if (this.a.a != null)
        this.a.a.draw(paramCanvas); 
      if (this.a.b != null && this.a.e) {
        drawable = this.a.b;
      } else {
        return;
      } 
    } 
    drawable.draw(paramCanvas);
  }
  
  public int getOpacity() { return 0; }
  
  public void getOutline(Outline paramOutline) {
    Drawable drawable;
    if (this.a.d) {
      if (this.a.c != null) {
        drawable = this.a.c;
      } else {
        return;
      } 
    } else if (this.a.a != null) {
      drawable = this.a.a;
    } else {
      return;
    } 
    drawable.getOutline(paramOutline);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */