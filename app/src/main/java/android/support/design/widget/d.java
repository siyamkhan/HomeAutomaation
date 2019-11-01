package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class d {
  private static final ThreadLocal<Matrix> a = new ThreadLocal();
  
  private static final ThreadLocal<RectF> b = new ThreadLocal();
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect) {
    Matrix matrix = (Matrix)a.get();
    if (matrix == null) {
      matrix = new Matrix();
      a.set(matrix);
    } else {
      matrix.reset();
    } 
    a(paramViewGroup, paramView, matrix);
    RectF rectF = (RectF)b.get();
    if (rectF == null) {
      rectF = new RectF();
      b.set(rectF);
    } 
    rectF.set(paramRect);
    matrix.mapRect(rectF);
    paramRect.set((int)(0.5F + rectF.left), (int)(0.5F + rectF.top), (int)(0.5F + rectF.right), (int)(0.5F + rectF.bottom));
  }
  
  private static void a(ViewParent paramViewParent, View paramView, Matrix paramMatrix) {
    ViewParent viewParent = paramView.getParent();
    if (viewParent instanceof View && viewParent != paramViewParent) {
      View view = (View)viewParent;
      a(paramViewParent, view, paramMatrix);
      paramMatrix.preTranslate(-view.getScrollX(), -view.getScrollY());
    } 
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity())
      paramMatrix.preConcat(paramView.getMatrix()); 
  }
  
  public static void b(ViewGroup paramViewGroup, View paramView, Rect paramRect) {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    a(paramViewGroup, paramView, paramRect);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */