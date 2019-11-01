package b.a.a.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import b.a.a.a.a.a;
import b.a.a.a.a.b;
import b.a.a.a.b.a;

public class b extends FrameLayout {
  private a A;
  
  private a B;
  
  private final Paint a = new Paint();
  
  private final Paint b = new Paint();
  
  private final Paint c = new Paint();
  
  private final Paint d = new Paint();
  
  private final Paint e = new Paint(1);
  
  private final Xfermode f = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  
  private View g;
  
  private RectF h;
  
  private final Rect i = new Rect();
  
  private float j;
  
  private float k;
  
  private boolean l;
  
  private boolean m;
  
  private int n = 0;
  
  private float o;
  
  private float p = 0.0F;
  
  private float q;
  
  private float r = 0.0F;
  
  private float s;
  
  private int t;
  
  private float u;
  
  private float v;
  
  private float w;
  
  private boolean x = false;
  
  private a y;
  
  private b z;
  
  private b(Context paramContext, View paramView) {
    super(paramContext);
    setWillNotDraw(false);
    setLayerType(2, null);
    this.g = paramView;
    this.j = (paramContext.getResources().getDisplayMetrics()).density;
    d();
    int[] arrayOfInt = new int[2];
    this.g.getLocationOnScreen(arrayOfInt);
    this.h = new RectF(arrayOfInt[0], arrayOfInt[1], (arrayOfInt[0] + this.g.getWidth()), (arrayOfInt[1] + this.g.getHeight()));
    this.B = new a(getContext());
    a a1 = this.B;
    int i1 = this.t;
    a1.setPadding(i1, i1, i1, i1);
    this.B.c(-1);
    addView(this.B, new FrameLayout.LayoutParams(-2, -2));
    setMessageLocation(f());
    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) {
        public void onGlobalLayout() {
          float f2;
          float f1;
          if (Build.VERSION.SDK_INT > 16) {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          } else {
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          } 
          b b1;
          b.a(b1, (b1 = this.a).a(b1));
          int[] arrayOfInt = new int[2];
          b.b(this.a).getLocationOnScreen(arrayOfInt);
          b b2;
          b.a(b2, new RectF(arrayOfInt[0], arrayOfInt[1], (arrayOfInt[0] + (b2 = this.a).b(b2).getWidth()), (arrayOfInt[1] + b.b(this.a).getHeight())));
          b.c(this.a).set(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getWidth() - this.a.getPaddingRight(), this.a.getHeight() - this.a.getPaddingBottom());
          b b3;
          if ((b3 = this.a).d(b3)) {
            f1 = b.e(this.a);
          } else {
            f1 = -b.e(this.a);
          } 
          b.a(b3, (int)f1);
          b b4;
          if ((b4 = this.a).d(b4)) {
            f2 = (b.f(this.a)).bottom;
          } else {
            f2 = (b.f(this.a)).top;
          } 
          b.b(b4, f2 + b.e(this.a));
          b b5;
          b.c(b5, (b5 = this.a).g(b5) + b.h(this.a));
          b.i(this.a);
          this.a.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
      };
    getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int i3 = paramView.getWidth();
    int i4 = paramView.getHeight();
    int i5 = paramFloat1 cmp i1;
    boolean bool = false;
    if (i5 >= 0) {
      int i6 = paramFloat1 cmp (i1 + i3);
      bool = false;
      if (i6 <= 0) {
        int i7 = paramFloat2 cmp i2;
        bool = false;
        if (i7 >= 0) {
          int i8 = paramFloat2 cmp (i2 + i4);
          bool = false;
          if (i8 <= 0)
            bool = true; 
        } 
      } 
    } 
    return bool;
  }
  
  private void c() {
    if (!this.x) {
      float[] arrayOfFloat1 = new float[2];
      arrayOfFloat1[0] = 0.0F;
      arrayOfFloat1[1] = this.q;
      ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(arrayOfFloat1);
      valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, valueAnimator1) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              b.d(this.b, ((Float)this.a.getAnimatedValue()).floatValue());
              b.e(this.b, ((Float)this.a.getAnimatedValue()).floatValue() - b.j(this.b));
              this.b.postInvalidate();
            }
          });
      float[] arrayOfFloat2 = new float[2];
      arrayOfFloat2[0] = this.k;
      arrayOfFloat2[1] = this.o;
      ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(arrayOfFloat2);
      valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, valueAnimator2) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              b.b(this.b, ((Float)this.a.getAnimatedValue()).floatValue());
              this.b.postInvalidate();
            }
          });
      valueAnimator2.setDuration(700L);
      valueAnimator2.start();
      valueAnimator2.addListener(new Animator.AnimatorListener(this, valueAnimator1) {
            public void onAnimationCancel(Animator param1Animator) {}
            
            public void onAnimationEnd(Animator param1Animator) {
              this.a.setDuration(700L);
              this.a.start();
              b.a(this.b, true);
            }
            
            public void onAnimationRepeat(Animator param1Animator) {}
            
            public void onAnimationStart(Animator param1Animator) {}
          });
    } 
  }
  
  private void d() {
    float f1 = this.j;
    this.s = f1 * 3.0F;
    this.u = 15.0F * f1;
    this.w = 40.0F * f1;
    this.t = (int)(5.0F * f1);
    this.v = 3.0F * f1;
    this.q = f1 * 6.0F;
  }
  
  private boolean e() { return ((getResources().getConfiguration()).orientation != 1); }
  
  private Point f() {
    float f1;
    int i1;
    if (this.z == b.b) {
      i1 = (int)(this.h.left - (this.B.getWidth() / 2) + (this.g.getWidth() / 2));
    } else {
      i1 = (int)this.h.right - this.B.getWidth();
    } 
    if (e())
      i1 -= getNavigationBarSize(); 
    if (i1 + this.B.getWidth() > getWidth())
      i1 = getWidth() - this.B.getWidth(); 
    if (i1 < 0)
      i1 = 0; 
    if (this.h.top + this.w > (getHeight() / 2)) {
      this.l = false;
      f1 = this.h.top - this.B.getHeight() - this.w;
    } else {
      this.l = true;
      f1 = this.h.top + this.g.getHeight() + this.w;
    } 
    this.n = (int)f1;
    if (this.n < 0)
      this.n = 0; 
    return new Point(i1, this.n);
  }
  
  private int getNavigationBarSize() {
    Resources resources = getContext().getResources();
    int i1 = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    return (i1 > 0) ? resources.getDimensionPixelSize(i1) : 0;
  }
  
  private void setMessageLocation(Point paramPoint) {
    this.B.setX(paramPoint.x);
    this.B.setY(paramPoint.y);
    postInvalidate();
  }
  
  public void a() {
    ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(this);
    this.m = false;
    a a1 = this.y;
    if (a1 != null)
      a1.a(this.g); 
  }
  
  public void b() {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setClickable(false);
    ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).addView(this);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(400L);
    alphaAnimation.setFillAfter(true);
    startAnimation(alphaAnimation);
    this.m = true;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.g != null) {
      this.a.setColor(-1728053248);
      this.a.setStyle(Paint.Style.FILL);
      this.a.setAntiAlias(true);
      paramCanvas.drawRect(this.i, this.a);
      this.b.setStyle(Paint.Style.FILL);
      this.b.setColor(-1);
      this.b.setStrokeWidth(this.s);
      this.b.setAntiAlias(true);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setColor(-1);
      this.c.setStrokeCap(Paint.Cap.ROUND);
      this.c.setStrokeWidth(this.v);
      this.c.setAntiAlias(true);
      this.d.setStyle(Paint.Style.FILL);
      this.d.setColor(-3355444);
      this.d.setAntiAlias(true);
      float f1 = this.h.left / 2.0F + this.h.right / 2.0F;
      paramCanvas.drawLine(f1, this.o, f1, this.k, this.b);
      paramCanvas.drawCircle(f1, this.o, this.p, this.c);
      paramCanvas.drawCircle(f1, this.o, this.r, this.d);
      this.e.setXfermode(this.f);
      this.e.setAntiAlias(true);
      paramCanvas.drawRoundRect(this.h, 15.0F, 15.0F, this.e);
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 0) {
      switch (null.a[this.A.ordinal()]) {
        default:
          return true;
        case 3:
          if (this.h.contains(f1, f2)) {
            this.g.performClick();
          } else {
          
          } 
        case 2:
          a();
        case 1:
          break;
      } 
      if (!a(this.B, f1, f2));
    } 
    return false;
  }
  
  public void setContentSpan(Spannable paramSpannable) { this.B.a(paramSpannable); }
  
  public void setContentText(String paramString) { this.B.b(paramString); }
  
  public void setContentTextSize(int paramInt) { this.B.b(paramInt); }
  
  public void setContentTypeFace(Typeface paramTypeface) { this.B.a(paramTypeface); }
  
  public void setTitle(String paramString) { this.B.a(paramString); }
  
  public void setTitleTextSize(int paramInt) { this.B.a(paramInt); }
  
  public void setTitleTypeFace(Typeface paramTypeface) { this.B.b(paramTypeface); }
  
  public static class a {
    private View a;
    
    private String b;
    
    private String c;
    
    private b d;
    
    private a e;
    
    private Context f;
    
    private Spannable g;
    
    private Typeface h;
    
    private Typeface i;
    
    private a j;
    
    private int k;
    
    private int l;
    
    private float m;
    
    private float n;
    
    private float o;
    
    private float p;
    
    private float q;
    
    public a(Context param1Context) { this.f = param1Context; }
    
    public a a(int param1Int) {
      this.l = param1Int;
      return this;
    }
    
    public a a(View param1View) {
      this.a = param1View;
      return this;
    }
    
    public a a(a param1a) {
      this.e = param1a;
      return this;
    }
    
    public a a(b param1b) {
      this.d = param1b;
      return this;
    }
    
    public a a(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public b a() {
      b b1 = new b(this.f, this.a, null);
      b b2 = this.d;
      if (b2 == null)
        b2 = b.a; 
      b.a(b1, b2);
      a a1 = this.e;
      if (a1 == null)
        a1 = a.c; 
      b.a(b1, a1);
      float f1 = (this.f.getResources().getDisplayMetrics()).density;
      b1.setTitle(this.b);
      String str = this.c;
      if (str != null)
        b1.setContentText(str); 
      int i1 = this.k;
      if (i1 != 0)
        b1.setTitleTextSize(i1); 
      int i2 = this.l;
      if (i2 != 0)
        b1.setContentTextSize(i2); 
      Spannable spannable = this.g;
      if (spannable != null)
        b1.setContentSpan(spannable); 
      Typeface typeface1 = this.h;
      if (typeface1 != null)
        b1.setTitleTypeFace(typeface1); 
      Typeface typeface2 = this.i;
      if (typeface2 != null)
        b1.setContentTypeFace(typeface2); 
      a a2 = this.j;
      if (a2 != null)
        b.a(b1, a2); 
      float f2 = this.m;
      if (f2 != 0.0F)
        b.f(b1, f2 * f1); 
      float f3 = this.n;
      if (f3 != 0.0F)
        b.g(b1, f3 * f1); 
      float f4 = this.o;
      if (f4 != 0.0F)
        b.d(b1, f4 * f1); 
      float f5 = this.p;
      if (f5 != 0.0F)
        b.e(b1, f5 * f1); 
      float f6 = this.q;
      if (f6 != 0.0F)
        b.h(b1, f6 * f1); 
      return b1;
    }
    
    public a b(int param1Int) {
      this.k = param1Int;
      return this;
    }
    
    public a b(String param1String) {
      this.c = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\b\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */