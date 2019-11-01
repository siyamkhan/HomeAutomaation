package android.support.e;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class k extends Object implements TypeEvaluator<Rect> {
  private Rect a;
  
  public Rect a(float paramFloat, Rect paramRect1, Rect paramRect2) {
    int i = paramRect1.left + (int)(paramFloat * (paramRect2.left - paramRect1.left));
    int j = paramRect1.top + (int)(paramFloat * (paramRect2.top - paramRect1.top));
    int m = paramRect1.right + (int)(paramFloat * (paramRect2.right - paramRect1.right));
    int n = paramRect1.bottom + (int)(paramFloat * (paramRect2.bottom - paramRect1.bottom));
    Rect rect = this.a;
    if (rect == null)
      return new Rect(i, j, m, n); 
    rect.set(i, j, m, n);
    return this.a;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */