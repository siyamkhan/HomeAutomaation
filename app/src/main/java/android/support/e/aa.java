package android.support.e;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.h.r;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class aa implements ac {
  protected a a;
  
  aa(Context paramContext, ViewGroup paramViewGroup, View paramView) { this.a = new a(paramContext, paramViewGroup, paramView, this); }
  
  static ViewGroup c(View paramView) {
    while (paramView != null) {
      if (paramView.getId() == 16908290 && paramView instanceof ViewGroup)
        return (ViewGroup)paramView; 
      if (paramView.getParent() instanceof ViewGroup)
        ViewGroup viewGroup = (ViewGroup)paramView.getParent(); 
    } 
    return null;
  }
  
  static aa d(View paramView) {
    ViewGroup viewGroup = c(paramView);
    if (viewGroup != null) {
      int i = viewGroup.getChildCount();
      for (byte b = 0; b < i; b++) {
        View view = viewGroup.getChildAt(b);
        if (view instanceof a)
          return ((a)view).e; 
      } 
      return new u(viewGroup.getContext(), viewGroup, paramView);
    } 
    return null;
  }
  
  public void a(Drawable paramDrawable) { this.a.a(paramDrawable); }
  
  public void b(Drawable paramDrawable) { this.a.b(paramDrawable); }
  
  static class a extends ViewGroup {
    static Method a;
    
    ViewGroup b;
    
    View c;
    
    ArrayList<Drawable> d = null;
    
    aa e;
    
    static  {
      try {
        Class[] arrayOfClass = new Class[3];
        arrayOfClass[0] = int.class;
        arrayOfClass[1] = int.class;
        arrayOfClass[2] = Rect.class;
        a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", arrayOfClass);
      } catch (NoSuchMethodException noSuchMethodException) {}
    }
    
    a(Context param1Context, ViewGroup param1ViewGroup, View param1View, aa param1aa) {
      super(param1Context);
      this.b = param1ViewGroup;
      this.c = param1View;
      setRight(param1ViewGroup.getWidth());
      setBottom(param1ViewGroup.getHeight());
      param1ViewGroup.addView(this);
      this.e = param1aa;
    }
    
    private void a(int[] param1ArrayOfInt) {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.b.getLocationOnScreen(arrayOfInt1);
      this.c.getLocationOnScreen(arrayOfInt2);
      param1ArrayOfInt[0] = arrayOfInt2[0] - arrayOfInt1[0];
      param1ArrayOfInt[1] = arrayOfInt2[1] - arrayOfInt1[1];
    }
    
    public void a(Drawable param1Drawable) {
      if (this.d == null)
        this.d = new ArrayList(); 
      if (!this.d.contains(param1Drawable)) {
        this.d.add(param1Drawable);
        invalidate(param1Drawable.getBounds());
        param1Drawable.setCallback(this);
      } 
    }
    
    public void a(View param1View) {
      if (param1View.getParent() instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)param1View.getParent();
        if (viewGroup != this.b && viewGroup.getParent() != null && r.A(viewGroup)) {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          viewGroup.getLocationOnScreen(arrayOfInt1);
          this.b.getLocationOnScreen(arrayOfInt2);
          r.f(param1View, arrayOfInt1[0] - arrayOfInt2[0]);
          r.e(param1View, arrayOfInt1[1] - arrayOfInt2[1]);
        } 
        viewGroup.removeView(param1View);
        if (param1View.getParent() != null)
          viewGroup.removeView(param1View); 
      } 
      addView(param1View, getChildCount() - 1);
    }
    
    boolean a() {
      if (getChildCount() == 0) {
        ArrayList arrayList = this.d;
        if (arrayList == null || arrayList.size() == 0)
          return true; 
      } 
      return false;
    }
    
    public void b(Drawable param1Drawable) {
      ArrayList arrayList = this.d;
      if (arrayList != null) {
        arrayList.remove(param1Drawable);
        invalidate(param1Drawable.getBounds());
        param1Drawable.setCallback(null);
      } 
    }
    
    public void b(View param1View) {
      removeView(param1View);
      if (a())
        this.b.removeView(this); 
    }
    
    protected void dispatchDraw(Canvas param1Canvas) {
      int i;
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.b.getLocationOnScreen(arrayOfInt1);
      this.c.getLocationOnScreen(arrayOfInt2);
      byte b1 = 0;
      param1Canvas.translate((arrayOfInt2[0] - arrayOfInt1[0]), (arrayOfInt2[1] - arrayOfInt1[1]));
      param1Canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
      super.dispatchDraw(param1Canvas);
      ArrayList arrayList = this.d;
      if (arrayList == null) {
        i = 0;
        b1 = 0;
      } else {
        i = arrayList.size();
      } 
      while (b1 < i) {
        ((Drawable)this.d.get(b1)).draw(param1Canvas);
        b1++;
      } 
    }
    
    public boolean dispatchTouchEvent(MotionEvent param1MotionEvent) { return false; }
    
    public ViewParent invalidateChildInParent(int[] param1ArrayOfInt, Rect param1Rect) {
      if (this.b != null) {
        param1Rect.offset(param1ArrayOfInt[0], param1ArrayOfInt[1]);
        if (this.b instanceof ViewGroup) {
          param1ArrayOfInt[0] = 0;
          param1ArrayOfInt[1] = 0;
          int[] arrayOfInt = new int[2];
          a(arrayOfInt);
          param1Rect.offset(arrayOfInt[0], arrayOfInt[1]);
          return super.invalidateChildInParent(param1ArrayOfInt, param1Rect);
        } 
        invalidate(param1Rect);
      } 
      return null;
    }
    
    public void invalidateDrawable(Drawable param1Drawable) { invalidate(param1Drawable.getBounds()); }
    
    protected void onLayout(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    protected boolean verifyDrawable(Drawable param1Drawable) {
      if (!super.verifyDrawable(param1Drawable)) {
        ArrayList arrayList = this.d;
        if (arrayList == null || !arrayList.contains(param1Drawable))
          return false; 
      } 
      return true;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */