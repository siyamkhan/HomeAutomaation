package android.support.v4.h;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.a.a;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class r {
  private static final AtomicInteger a = new AtomicInteger(1);
  
  private static Field b;
  
  private static boolean c;
  
  private static Field d;
  
  private static boolean e;
  
  private static WeakHashMap<View, String> f;
  
  private static WeakHashMap<View, v> g = null;
  
  private static Field h;
  
  private static boolean i = false;
  
  private static ThreadLocal<Rect> j;
  
  public static boolean A(View paramView) { return (Build.VERSION.SDK_INT >= 19) ? paramView.isAttachedToWindow() : ((paramView.getWindowToken() != null) ? 1 : 0); }
  
  public static boolean B(View paramView) { return (Build.VERSION.SDK_INT >= 15) ? paramView.hasOnClickListeners() : 0; }
  
  public static Display C(View paramView) { return (Build.VERSION.SDK_INT >= 17) ? paramView.getDisplay() : (A(paramView) ? ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay() : null); }
  
  private static void D(View paramView) {
    float f1 = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f1);
    paramView.setTranslationY(f1);
  }
  
  @SuppressLint({"InlinedApi"})
  public static int a(View paramView) { return (Build.VERSION.SDK_INT >= 26) ? paramView.getImportantForAutofill() : 0; }
  
  private static Rect a() {
    if (j == null)
      j = new ThreadLocal(); 
    Rect rect = (Rect)j.get();
    if (rect == null) {
      rect = new Rect();
      j.set(rect);
    } 
    rect.setEmpty();
    return rect;
  }
  
  public static z a(View paramView, z paramz) {
    if (Build.VERSION.SDK_INT >= 21) {
      WindowInsets windowInsets1 = (WindowInsets)z.a(paramz);
      WindowInsets windowInsets2 = paramView.onApplyWindowInsets(windowInsets1);
      if (windowInsets2 != windowInsets1)
        windowInsets1 = new WindowInsets(windowInsets2); 
      return z.a(windowInsets1);
    } 
    return paramz;
  }
  
  public static void a(View paramView, float paramFloat) {
    if (Build.VERSION.SDK_INT >= 21)
      paramView.setElevation(paramFloat); 
  }
  
  public static void a(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setImportantForAutofill(paramInt); 
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2) {
    if (Build.VERSION.SDK_INT >= 23)
      paramView.setScrollIndicators(paramInt1, paramInt2); 
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21) {
        boolean bool;
        Drawable drawable = paramView.getBackground();
        if (paramView.getBackgroundTintList() != null || paramView.getBackgroundTintMode() != null) {
          bool = true;
        } else {
          bool = false;
        } 
        if (drawable != null && bool) {
          if (drawable.isStateful())
            drawable.setState(paramView.getDrawableState()); 
          paramView.setBackground(drawable);
          return;
        } 
      } 
    } else if (paramView instanceof q) {
      ((q)paramView).setSupportBackgroundTintList(paramColorStateList);
    } 
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21) {
        boolean bool;
        Drawable drawable = paramView.getBackground();
        if (paramView.getBackgroundTintList() != null || paramView.getBackgroundTintMode() != null) {
          bool = true;
        } else {
          bool = false;
        } 
        if (drawable != null && bool) {
          if (drawable.isStateful())
            drawable.setState(paramView.getDrawableState()); 
          paramView.setBackground(drawable);
          return;
        } 
      } 
    } else if (paramView instanceof q) {
      ((q)paramView).setSupportBackgroundTintMode(paramMode);
    } 
  }
  
  public static void a(View paramView, Rect paramRect) {
    if (Build.VERSION.SDK_INT >= 18)
      paramView.setClipBounds(paramRect); 
  }
  
  public static void a(View paramView, Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.setBackground(paramDrawable);
      return;
    } 
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, b paramb) {
    View.AccessibilityDelegate accessibilityDelegate;
    if (paramb == null) {
      accessibilityDelegate = null;
    } else {
      accessibilityDelegate = paramb.a();
    } 
    paramView.setAccessibilityDelegate(accessibilityDelegate);
  }
  
  public static void a(View paramView, p paramp) {
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramp == null) {
        paramView.setOnApplyWindowInsetsListener(null);
        return;
      } 
      paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(paramp) {
            public WindowInsets onApplyWindowInsets(View param1View, WindowInsets param1WindowInsets) {
              z z;
              return (WindowInsets)(z = z.a(param1WindowInsets)).a(this.a.a(param1View, z));
            }
          });
    } 
  }
  
  public static void a(View paramView, Runnable paramRunnable) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.postOnAnimation(paramRunnable);
      return;
    } 
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
      return;
    } 
    paramView.postDelayed(paramRunnable, paramLong + ValueAnimator.getFrameDelay());
  }
  
  public static void a(View paramView, String paramString) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTransitionName(paramString);
      return;
    } 
    if (f == null)
      f = new WeakHashMap(); 
    f.put(paramView, paramString);
  }
  
  public static void a(View paramView, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 16)
      paramView.setHasTransientState(paramBoolean); 
  }
  
  static boolean a(View paramView, KeyEvent paramKeyEvent) { return (Build.VERSION.SDK_INT >= 28) ? false : b.a(paramView).a(paramKeyEvent); }
  
  public static void b(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT < 19)
      if (Build.VERSION.SDK_INT >= 16) {
        if (paramInt == 4)
          paramInt = 2; 
      } else {
        return;
      }  
    paramView.setImportantForAccessibility(paramInt);
  }
  
  @Deprecated
  public static void b(View paramView, boolean paramBoolean) { paramView.setFitsSystemWindows(paramBoolean); }
  
  public static boolean b(View paramView) {
    if (i)
      return false; 
    if (h == null)
      try {
        h = View.class.getDeclaredField("mAccessibilityDelegate");
        h.setAccessible(true);
      } catch (Throwable throwable) {
        i = true;
        return false;
      }  
    try {
      Object object = h.get(paramView);
      boolean bool = false;
      if (object != null)
        bool = true; 
      return bool;
    } catch (Throwable throwable) {
      i = true;
      return false;
    } 
  }
  
  static boolean b(View paramView, KeyEvent paramKeyEvent) { return (Build.VERSION.SDK_INT >= 28) ? false : b.a(paramView).a(paramView, paramKeyEvent); }
  
  public static void c(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 19)
      paramView.setAccessibilityLiveRegion(paramInt); 
  }
  
  public static boolean c(View paramView) { return (Build.VERSION.SDK_INT >= 16) ? paramView.hasTransientState() : 0; }
  
  public static void d(View paramView) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.postInvalidateOnAnimation();
      return;
    } 
    paramView.postInvalidate();
  }
  
  public static void d(View paramView, int paramInt) {
    if (paramView instanceof k) {
      ((k)paramView).a(paramInt);
      return;
    } 
    if (paramInt == 0)
      w(paramView); 
  }
  
  public static int e(View paramView) { return (Build.VERSION.SDK_INT >= 16) ? paramView.getImportantForAccessibility() : 0; }
  
  public static void e(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.offsetTopAndBottom(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      Rect rect = a();
      ViewParent viewParent = paramView.getParent();
      boolean bool1 = viewParent instanceof View;
      boolean bool2 = false;
      if (bool1) {
        View view = (View)viewParent;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        bool2 = true ^ rect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      } 
      g(paramView, paramInt);
      if (bool2 && rect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        ((View)viewParent).invalidate(rect);
        return;
      } 
    } else {
      g(paramView, paramInt);
    } 
  }
  
  public static int f(View paramView) { return (Build.VERSION.SDK_INT >= 17) ? paramView.getLayoutDirection() : 0; }
  
  public static void f(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.offsetLeftAndRight(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      Rect rect = a();
      ViewParent viewParent = paramView.getParent();
      boolean bool1 = viewParent instanceof View;
      boolean bool2 = false;
      if (bool1) {
        View view = (View)viewParent;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        bool2 = true ^ rect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      } 
      h(paramView, paramInt);
      if (bool2 && rect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        ((View)viewParent).invalidate(rect);
        return;
      } 
    } else {
      h(paramView, paramInt);
    } 
  }
  
  public static int g(View paramView) { return (Build.VERSION.SDK_INT >= 19) ? paramView.getAccessibilityLiveRegion() : 0; }
  
  private static void g(View paramView, int paramInt) {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0) {
      D(paramView);
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View)
        D((View)viewParent); 
    } 
  }
  
  public static int h(View paramView) { return (Build.VERSION.SDK_INT >= 17) ? paramView.getPaddingStart() : paramView.getPaddingLeft(); }
  
  private static void h(View paramView, int paramInt) {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0) {
      D(paramView);
      ViewParent viewParent = paramView.getParent();
      if (viewParent instanceof View)
        D((View)viewParent); 
    } 
  }
  
  public static int i(View paramView) { return (Build.VERSION.SDK_INT >= 17) ? paramView.getPaddingEnd() : paramView.getPaddingRight(); }
  
  public static int j(View paramView) {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getMinimumWidth(); 
    if (!c) {
      try {
        b = View.class.getDeclaredField("mMinWidth");
        b.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      c = true;
    } 
    Field field = b;
    return (field != null) ? ((Integer)field.get(paramView)).intValue() : 0;
  }
  
  public static int k(View paramView) {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getMinimumHeight(); 
    if (!e) {
      try {
        d = View.class.getDeclaredField("mMinHeight");
        d.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      e = true;
    } 
    Field field = d;
    return (field != null) ? ((Integer)field.get(paramView)).intValue() : 0;
  }
  
  public static v l(View paramView) {
    if (g == null)
      g = new WeakHashMap(); 
    v v = (v)g.get(paramView);
    if (v == null) {
      v = new v(paramView);
      g.put(paramView, v);
    } 
    return v;
  }
  
  public static float m(View paramView) { return (Build.VERSION.SDK_INT >= 21) ? paramView.getElevation() : 0.0F; }
  
  public static String n(View paramView) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getTransitionName(); 
    WeakHashMap weakHashMap = f;
    return (weakHashMap == null) ? null : (String)weakHashMap.get(paramView);
  }
  
  public static int o(View paramView) { return (Build.VERSION.SDK_INT >= 16) ? paramView.getWindowSystemUiVisibility() : 0; }
  
  public static void p(View paramView) {
    if (Build.VERSION.SDK_INT >= 20) {
      paramView.requestApplyInsets();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      paramView.requestFitSystemWindows(); 
  }
  
  public static boolean q(View paramView) { return (Build.VERSION.SDK_INT >= 16) ? paramView.getFitsSystemWindows() : 0; }
  
  public static boolean r(View paramView) { return (Build.VERSION.SDK_INT >= 16) ? paramView.hasOverlappingRendering() : 1; }
  
  public static boolean s(View paramView) { return (Build.VERSION.SDK_INT >= 17) ? paramView.isPaddingRelative() : 0; }
  
  public static ColorStateList t(View paramView) { return (Build.VERSION.SDK_INT >= 21) ? paramView.getBackgroundTintList() : ((paramView instanceof q) ? ((q)paramView).getSupportBackgroundTintList() : null); }
  
  public static PorterDuff.Mode u(View paramView) { return (Build.VERSION.SDK_INT >= 21) ? paramView.getBackgroundTintMode() : ((paramView instanceof q) ? ((q)paramView).getSupportBackgroundTintMode() : null); }
  
  public static boolean v(View paramView) { return (Build.VERSION.SDK_INT >= 21) ? paramView.isNestedScrollingEnabled() : ((paramView instanceof j) ? ((j)paramView).isNestedScrollingEnabled() : 0); }
  
  public static void w(View paramView) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.stopNestedScroll();
      return;
    } 
    if (paramView instanceof j)
      ((j)paramView).stopNestedScroll(); 
  }
  
  public static boolean x(View paramView) { return (Build.VERSION.SDK_INT >= 19) ? paramView.isLaidOut() : ((paramView.getWidth() > 0 && paramView.getHeight() > 0) ? 1 : 0); }
  
  public static float y(View paramView) { return (Build.VERSION.SDK_INT >= 21) ? paramView.getZ() : 0.0F; }
  
  public static Rect z(View paramView) { return (Build.VERSION.SDK_INT >= 18) ? paramView.getClipBounds() : null; }
  
  public static interface a {
    boolean a(View param1View, KeyEvent param1KeyEvent);
  }
  
  static class b {
    private static final ArrayList<WeakReference<View>> a = new ArrayList();
    
    private WeakHashMap<View, Boolean> b = null;
    
    private SparseArray<WeakReference<View>> c = null;
    
    private WeakReference<KeyEvent> d = null;
    
    static b a(View param1View) {
      b b1 = (b)param1View.getTag(a.b.tag_unhandled_key_event_manager);
      if (b1 == null) {
        b1 = new b();
        param1View.setTag(a.b.tag_unhandled_key_event_manager, b1);
      } 
      return b1;
    }
    
    private SparseArray<WeakReference<View>> a() {
      if (this.c == null)
        this.c = new SparseArray(); 
      return this.c;
    }
    
    private View b(View param1View, KeyEvent param1KeyEvent) {
      WeakHashMap weakHashMap = this.b;
      if (weakHashMap != null) {
        if (!weakHashMap.containsKey(param1View))
          return null; 
        if (param1View instanceof ViewGroup) {
          ViewGroup viewGroup = (ViewGroup)param1View;
          for (int i = -1 + viewGroup.getChildCount(); i >= 0; i--) {
            View view = b(viewGroup.getChildAt(i), param1KeyEvent);
            if (view != null)
              return view; 
          } 
        } 
        if (c(param1View, param1KeyEvent))
          return param1View; 
      } 
      return null;
    }
    
    private void b() {
      WeakHashMap weakHashMap = this.b;
      if (weakHashMap != null)
        weakHashMap.clear(); 
      if (a.isEmpty())
        return; 
      synchronized (a) {
        if (this.b == null)
          this.b = new WeakHashMap(); 
        for (int i = -1 + a.size();; i--) {
          if (i >= 0) {
            View view = (View)((WeakReference)a.get(i)).get();
            if (view == null) {
              a.remove(i);
            } else {
              this.b.put(view, Boolean.TRUE);
              for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent())
                this.b.put((View)viewParent, Boolean.TRUE); 
            } 
          } else {
            return;
          } 
        } 
      } 
    }
    
    private boolean c(View param1View, KeyEvent param1KeyEvent) {
      ArrayList arrayList = (ArrayList)param1View.getTag(a.b.tag_unhandled_key_listeners);
      if (arrayList != null)
        for (int i = arrayList.size() - 1; i >= 0; i--) {
          if (((r.a)arrayList.get(i)).a(param1View, param1KeyEvent))
            return true; 
        }  
      return false;
    }
    
    boolean a(KeyEvent param1KeyEvent) {
      WeakReference weakReference1 = this.d;
      if (weakReference1 != null && weakReference1.get() == param1KeyEvent)
        return false; 
      this.d = new WeakReference(param1KeyEvent);
      SparseArray sparseArray = a();
      int i = param1KeyEvent.getAction();
      WeakReference weakReference2 = null;
      if (i == 1) {
        int j = sparseArray.indexOfKey(param1KeyEvent.getKeyCode());
        weakReference2 = null;
        if (j >= 0) {
          weakReference2 = (WeakReference)sparseArray.valueAt(j);
          sparseArray.removeAt(j);
        } 
      } 
      if (weakReference2 == null)
        weakReference2 = (WeakReference)sparseArray.get(param1KeyEvent.getKeyCode()); 
      if (weakReference2 != null) {
        View view = (View)weakReference2.get();
        if (view != null && r.A(view))
          c(view, param1KeyEvent); 
        return true;
      } 
      return false;
    }
    
    boolean a(View param1View, KeyEvent param1KeyEvent) {
      if (param1KeyEvent.getAction() == 0)
        b(); 
      View view = b(param1View, param1KeyEvent);
      if (param1KeyEvent.getAction() == 0) {
        int i = param1KeyEvent.getKeyCode();
        if (view != null && !KeyEvent.isModifierKey(i))
          a().put(i, new WeakReference(view)); 
      } 
      return (view != null);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */