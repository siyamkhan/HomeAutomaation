package android.support.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.h.r;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class c extends m {
  private static final String[] h = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  
  private static final Property<Drawable, PointF> i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
      private Rect a = new Rect();
      
      public PointF a(Drawable param1Drawable) {
        param1Drawable.copyBounds(this.a);
        return new PointF(this.a.left, this.a.top);
      }
      
      public void a(Drawable param1Drawable, PointF param1PointF) {
        param1Drawable.copyBounds(this.a);
        this.a.offsetTo(Math.round(param1PointF.x), Math.round(param1PointF.y));
        param1Drawable.setBounds(this.a);
      }
    };
  
  private static final Property<a, PointF> j = new Property<a, PointF>(PointF.class, "topLeft") {
      public PointF a(c.a param1a) { return null; }
      
      public void a(c.a param1a, PointF param1PointF) { param1a.a(param1PointF); }
    };
  
  private static final Property<a, PointF> k = new Property<a, PointF>(PointF.class, "bottomRight") {
      public PointF a(c.a param1a) { return null; }
      
      public void a(c.a param1a, PointF param1PointF) { param1a.b(param1PointF); }
    };
  
  private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "bottomRight") {
      public PointF a(View param1View) { return null; }
      
      public void a(View param1View, PointF param1PointF) { ad.a(param1View, param1View.getLeft(), param1View.getTop(), Math.round(param1PointF.x), Math.round(param1PointF.y)); }
    };
  
  private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "topLeft") {
      public PointF a(View param1View) { return null; }
      
      public void a(View param1View, PointF param1PointF) { ad.a(param1View, Math.round(param1PointF.x), Math.round(param1PointF.y), param1View.getRight(), param1View.getBottom()); }
    };
  
  private static final Property<View, PointF> n = new Property<View, PointF>(PointF.class, "position") {
      public PointF a(View param1View) { return null; }
      
      public void a(View param1View, PointF param1PointF) {
        int i = Math.round(param1PointF.x);
        int j = Math.round(param1PointF.y);
        ad.a(param1View, i, j, i + param1View.getWidth(), j + param1View.getHeight());
      }
    };
  
  private static k r = new k();
  
  private int[] o = new int[2];
  
  private boolean p = false;
  
  private boolean q = false;
  
  private boolean a(View paramView1, View paramView2) {
    if (this.q) {
      s s = b(paramView1, true);
      return (s == null) ? ((paramView1 == paramView2)) : ((paramView2 == s.b));
    } 
    return true;
  }
  
  private void d(s params) {
    View view = params.b;
    if (r.x(view) || view.getWidth() != 0 || view.getHeight() != 0) {
      params.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
      params.a.put("android:changeBounds:parent", params.b.getParent());
      if (this.q) {
        params.b.getLocationInWindow(this.o);
        params.a.put("android:changeBounds:windowX", Integer.valueOf(this.o[0]));
        params.a.put("android:changeBounds:windowY", Integer.valueOf(this.o[1]));
      } 
      if (this.p)
        params.a.put("android:changeBounds:clip", r.z(view)); 
    } 
  }
  
  public Animator a(ViewGroup paramViewGroup, s params1, s params2) {
    View view2;
    if (params1 == null || params2 == null)
      return null; 
    Map map1 = params1.a;
    Map map2 = params2.a;
    ViewGroup viewGroup1 = (ViewGroup)map1.get("android:changeBounds:parent");
    ViewGroup viewGroup2 = (ViewGroup)map2.get("android:changeBounds:parent");
    if (viewGroup1 == null || viewGroup2 == null)
      return null; 
    View view1 = params2.b;
    if (a(viewGroup1, viewGroup2)) {
      byte b;
      Rect rect1 = (Rect)params1.a.get("android:changeBounds:bounds");
      Rect rect2 = (Rect)params2.a.get("android:changeBounds:bounds");
      int i1 = rect1.left;
      int i2 = rect2.left;
      int i3 = rect1.top;
      int i4 = rect2.top;
      int i5 = rect1.right;
      int i6 = rect2.right;
      int i7 = rect1.bottom;
      int i8 = rect2.bottom;
      int i9 = i5 - i1;
      int i10 = i7 - i3;
      int i11 = i6 - i2;
      int i12 = i8 - i4;
      Rect rect3 = (Rect)params1.a.get("android:changeBounds:clip");
      Rect rect4 = (Rect)params2.a.get("android:changeBounds:clip");
      if ((i9 != 0 && i10 != 0) || (i11 != 0 && i12 != 0)) {
        if (i1 != i2 || i3 != i4) {
          b = 1;
        } else {
          b = 0;
        } 
        if (i5 != i6 || i7 != i8)
          b++; 
      } else {
        b = 0;
      } 
      if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null))
        b++; 
      if (b > 0) {
        if (!this.p) {
          Property property;
          Path path;
          view2 = view1;
          ad.a(view2, i1, i3, i5, i7);
          if (b == 2) {
            if (i9 == i11 && i10 == i12) {
              path = l().a(i1, i3, i2, i4);
              property = n;
            } else {
              a a = new a(view2);
              Path path1 = l().a(i1, i3, i2, i4);
              ObjectAnimator objectAnimator1 = f.a(a, j, path1);
              Path path2 = l().a(i5, i7, i6, i8);
              ObjectAnimator objectAnimator2 = f.a(a, k, path2);
              AnimatorSet animatorSet2 = new AnimatorSet();
              animatorSet2.playTogether(new Animator[] { objectAnimator1, objectAnimator2 });
              animatorSet2.addListener(new AnimatorListenerAdapter(this, a) {
                    private c.a mViewBounds = this.a;
                  });
              AnimatorSet animatorSet1 = animatorSet2;
              if (view2.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)view2.getParent();
                x.a(viewGroup, true);
                a(new n(this, viewGroup) {
                      boolean a = false;
                      
                      public void a(m param1m) {
                        if (!this.a)
                          x.a(this.b, false); 
                        param1m.b(this);
                      }
                      
                      public void b(m param1m) { x.a(this.b, false); }
                      
                      public void c(m param1m) { x.a(this.b, true); }
                    });
              } 
            } 
          } else if (i1 != i2 || i3 != i4) {
            path = l().a(i1, i3, i2, i4);
            property = m;
          } else {
            path = l().a(i5, i7, i6, i8);
            property = l;
          } 
          ObjectAnimator objectAnimator = f.a(view2, property, path);
        } else {
          Animator animator2;
          Rect rect6;
          Rect rect5;
          Animator animator1;
          view2 = view1;
          int i13 = Math.max(i9, i11);
          int i14 = Math.max(i10, i12);
          ad.a(view2, i1, i3, i13 + i1, i14 + i3);
          if (i1 != i2 || i3 != i4) {
            Path path = l().a(i1, i3, i2, i4);
            animator1 = f.a(view2, n, path);
          } else {
            animator1 = null;
          } 
          if (rect3 == null) {
            rect5 = new Rect(0, 0, i9, i10);
          } else {
            rect5 = rect3;
          } 
          if (rect4 == null) {
            rect6 = new Rect(0, 0, i11, i12);
          } else {
            rect6 = rect4;
          } 
          if (!rect5.equals(rect6)) {
            r.a(view2, rect5);
            animator2 = ObjectAnimator.ofObject(view2, "clipBounds", r, new Object[] { rect5, rect6 });
            AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this, view2, rect4, i2, i4, i6, i8) {
                private boolean h;
                
                public void onAnimationCancel(Animator param1Animator) { this.h = true; }
                
                public void onAnimationEnd(Animator param1Animator) {
                  if (!this.h) {
                    r.a(this.a, this.b);
                    ad.a(this.a, this.c, this.d, this.e, this.f);
                  } 
                }
              };
            animator2.addListener(animatorListenerAdapter);
          } else {
            animator2 = null;
          } 
          Animator animator3 = r.a(animator1, animator2);
        } 
      } else {
        return null;
      } 
    } else {
      int i1 = ((Integer)params1.a.get("android:changeBounds:windowX")).intValue();
      int i2 = ((Integer)params1.a.get("android:changeBounds:windowY")).intValue();
      int i3 = ((Integer)params2.a.get("android:changeBounds:windowX")).intValue();
      int i4 = ((Integer)params2.a.get("android:changeBounds:windowY")).intValue();
      if (i1 != i3 || i2 != i4) {
        paramViewGroup.getLocationInWindow(this.o);
        Bitmap bitmap = Bitmap.createBitmap(view1.getWidth(), view1.getHeight(), Bitmap.Config.ARGB_8888);
        view1.draw(new Canvas(bitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        float f = ad.c(view1);
        ad.a(view1, 0.0F);
        ad.a(paramViewGroup).a(bitmapDrawable);
        g g = l();
        int[] arrayOfInt = this.o;
        Path path = g.a((i1 - arrayOfInt[0]), (i2 - arrayOfInt[1]), (i3 - arrayOfInt[0]), (i4 - arrayOfInt[1]));
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[] { i.a(i, path) });
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this, paramViewGroup, bitmapDrawable, view1, f) {
            public void onAnimationEnd(Animator param1Animator) {
              ad.a(this.a).b(this.b);
              ad.a(this.c, this.d);
            }
          };
        objectAnimator.addListener(animatorListenerAdapter);
        return objectAnimator;
      } 
      return null;
    } 
    if (view2.getParent() instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)view2.getParent();
      x.a(viewGroup, true);
      a(new n(this, viewGroup) {
            boolean a = false;
            
            public void a(m param1m) {
              if (!this.a)
                x.a(this.b, false); 
              param1m.b(this);
            }
            
            public void b(m param1m) { x.a(this.b, false); }
            
            public void c(m param1m) { x.a(this.b, true); }
          });
    } 
  }
  
  public void a(s params) { d(params); }
  
  public String[] a() { return h; }
  
  public void b(s params) { d(params); }
  
  private static class a {
    private int a;
    
    private int b;
    
    private int c;
    
    private int d;
    
    private View e;
    
    private int f;
    
    private int g;
    
    a(View param1View) { this.e = param1View; }
    
    private void a() {
      ad.a(this.e, this.a, this.b, this.c, this.d);
      this.f = 0;
      this.g = 0;
    }
    
    void a(PointF param1PointF) {
      this.a = Math.round(param1PointF.x);
      this.b = Math.round(param1PointF.y);
      this.f = 1 + this.f;
      if (this.f == this.g)
        a(); 
    }
    
    void b(PointF param1PointF) {
      this.c = Math.round(param1PointF.x);
      this.d = Math.round(param1PointF.y);
      this.g = 1 + this.g;
      if (this.f == this.g)
        a(); 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */