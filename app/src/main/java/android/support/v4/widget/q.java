package android.support.v4.widget;

import android.content.Context;
import android.support.v4.h.r;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public class q {
  private static final Interpolator v = new Interpolator() {
      public float getInterpolation(float param1Float) {
        float f = param1Float - 1.0F;
        return 1.0F + f * f * f * f * f;
      }
    };
  
  private int a;
  
  private int b;
  
  private int c = -1;
  
  private float[] d;
  
  private float[] e;
  
  private float[] f;
  
  private float[] g;
  
  private int[] h;
  
  private int[] i;
  
  private int[] j;
  
  private int k;
  
  private VelocityTracker l;
  
  private float m;
  
  private float n;
  
  private int o;
  
  private int p;
  
  private OverScroller q;
  
  private final a r;
  
  private View s;
  
  private boolean t;
  
  private final ViewGroup u;
  
  private final Runnable w = new Runnable(this) {
      public void run() { this.a.b(0); }
    };
  
  private q(Context paramContext, ViewGroup paramViewGroup, a parama) {
    if (paramViewGroup != null) {
      if (parama != null) {
        this.u = paramViewGroup;
        this.r = parama;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
        this.o = (int)(0.5F + 20.0F * (paramContext.getResources().getDisplayMetrics()).density);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(paramContext, v);
        return;
      } 
      throw new IllegalArgumentException("Callback may not be null");
    } 
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private float a(float paramFloat) { return (float)Math.sin((0.47123894F * (paramFloat - 0.5F))); }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    float f1 = Math.abs(paramFloat1);
    return (f1 < paramFloat2) ? 0.0F : ((f1 > paramFloat3) ? ((paramFloat1 > 0.0F) ? paramFloat3 : -paramFloat3) : paramFloat1);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    int i4;
    if (paramInt1 == 0)
      return 0; 
    int i1 = this.u.getWidth();
    int i2 = i1 / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f2 = i2;
    float f3 = f2 + f2 * a(f1);
    int i3 = Math.abs(paramInt2);
    if (i3 > 0) {
      i4 = 4 * Math.round(1000.0F * Math.abs(f3 / i3));
    } else {
      i4 = (int)(256.0F * (1.0F + Math.abs(paramInt1) / paramInt3));
    } 
    return Math.min(i4, 600);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f5;
    float f4;
    float f2;
    float f1;
    int i1 = b(paramInt3, (int)this.n, (int)this.m);
    int i2 = b(paramInt4, (int)this.n, (int)this.m);
    int i3 = Math.abs(paramInt1);
    int i4 = Math.abs(paramInt2);
    int i5 = Math.abs(i1);
    int i6 = Math.abs(i2);
    int i7 = i5 + i6;
    int i8 = i3 + i4;
    if (i1 != 0) {
      f1 = i5;
      f2 = i7;
    } else {
      f1 = i3;
      f2 = i8;
    } 
    float f3 = f1 / f2;
    if (i2 != 0) {
      f4 = i6;
      f5 = i7;
    } else {
      f4 = i4;
      f5 = i8;
    } 
    float f6 = f4 / f5;
    int i9 = a(paramInt1, i1, this.r.b(paramView));
    int i10 = a(paramInt2, i2, this.r.a(paramView));
    return (int)(f3 * i9 + f6 * i10);
  }
  
  public static q a(ViewGroup paramViewGroup, float paramFloat, a parama) {
    q q1 = a(paramViewGroup, parama);
    q1.b = (int)(q1.b * 1.0F / paramFloat);
    return q1;
  }
  
  public static q a(ViewGroup paramViewGroup, a parama) { return new q(paramViewGroup.getContext(), paramViewGroup, parama); }
  
  private void a(float paramFloat1, float paramFloat2) {
    this.t = true;
    this.r.a(this.s, paramFloat1, paramFloat2);
    this.t = false;
    if (this.a == 1)
      b(0); 
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt) {
    d(paramInt);
    float[] arrayOfFloat1 = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat1[paramInt] = paramFloat1;
    float[] arrayOfFloat2 = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat2[paramInt] = paramFloat2;
    this.h[paramInt] = d((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    float f1 = Math.abs(paramFloat1);
    float f2 = Math.abs(paramFloat2);
    int i1 = paramInt2 & this.h[paramInt1];
    boolean bool = false;
    if (i1 == paramInt2) {
      int i2 = paramInt2 & this.p;
      bool = false;
      if (i2 != 0) {
        int i3 = paramInt2 & this.j[paramInt1];
        bool = false;
        if (i3 != paramInt2) {
          int i4 = paramInt2 & this.i[paramInt1];
          bool = false;
          if (i4 != paramInt2) {
            int i5 = this.b;
            if (f1 <= i5 && f2 <= i5)
              return false; 
            if (f1 < f2 * 0.5F && this.r.b(paramInt2)) {
              int[] arrayOfInt = this.j;
              arrayOfInt[paramInt1] = paramInt2 | arrayOfInt[paramInt1];
              return false;
            } 
            int i6 = paramInt2 & this.i[paramInt1];
            bool = false;
            if (i6 == 0) {
              int i7 = f1 cmp this.b;
              bool = false;
              if (i7 > 0)
                bool = true; 
            } 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    int i3 = paramInt1 - i1;
    int i4 = paramInt2 - i2;
    if (i3 == 0 && i4 == 0) {
      this.q.abortAnimation();
      b(0);
      return false;
    } 
    int i5 = a(this.s, i3, i4, paramInt3, paramInt4);
    this.q.startScroll(i1, i2, i3, i4, i5);
    b(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2) {
    boolean bool2;
    boolean bool1;
    if (paramView == null)
      return false; 
    if (this.r.b(paramView) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.r.a(paramView) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 && bool2) {
      float f1 = paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
      int i1 = this.b;
      int i2 = f1 cmp (i1 * i1);
      boolean bool3 = false;
      if (i2 > 0)
        bool3 = true; 
      return bool3;
    } 
    if (bool1) {
      int i1 = Math.abs(paramFloat1) cmp this.b;
      boolean bool3 = false;
      if (i1 > 0)
        bool3 = true; 
      return bool3;
    } 
    boolean bool = false;
    if (bool2) {
      int i1 = Math.abs(paramFloat2) cmp this.b;
      bool = false;
      if (i1 > 0)
        bool = true; 
    } 
    return bool;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3) {
    int i1 = Math.abs(paramInt1);
    return (i1 < paramInt2) ? 0 : ((i1 > paramInt3) ? ((paramInt1 > 0) ? paramInt3 : -paramInt3) : paramInt1);
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt) {
    int i1 = 1;
    if (!a(paramFloat1, paramFloat2, paramInt, i1))
      i1 = 0; 
    if (a(paramFloat2, paramFloat1, paramInt, 4))
      i1 |= 0x4; 
    if (a(paramFloat1, paramFloat2, paramInt, 2))
      i1 |= 0x2; 
    if (a(paramFloat2, paramFloat1, paramInt, 8))
      i1 |= 0x8; 
    if (i1 != 0) {
      int[] arrayOfInt = this.i;
      arrayOfInt[paramInt] = i1 | arrayOfInt[paramInt];
      this.r.b(i1, paramInt);
    } 
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    if (paramInt3 != 0) {
      paramInt1 = this.r.b(this.s, paramInt1, paramInt3);
      r.f(this.s, paramInt1 - i1);
    } 
    int i3 = paramInt1;
    if (paramInt4 != 0) {
      paramInt2 = this.r.a(this.s, paramInt2, paramInt4);
      r.e(this.s, paramInt2 - i2);
    } 
    int i4 = paramInt2;
    if (paramInt3 != 0 || paramInt4 != 0) {
      int i5 = i3 - i1;
      int i6 = i4 - i2;
      this.r.a(this.s, i3, i4, i5, i6);
    } 
  }
  
  private void c() {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null)
      return; 
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.g, 0.0F);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.i, 0);
    Arrays.fill(this.j, 0);
    this.k = 0;
  }
  
  private void c(int paramInt) {
    if (this.d != null) {
      if (!a(paramInt))
        return; 
      this.d[paramInt] = 0.0F;
      this.e[paramInt] = 0.0F;
      this.f[paramInt] = 0.0F;
      this.g[paramInt] = 0.0F;
      this.h[paramInt] = 0;
      this.i[paramInt] = 0;
      this.j[paramInt] = 0;
      this.k &= (0xFFFFFFFF ^ 1 << paramInt);
    } 
  }
  
  private void c(MotionEvent paramMotionEvent) {
    int i1 = paramMotionEvent.getPointerCount();
    for (byte b1 = 0; b1 < i1; b1++) {
      int i2 = paramMotionEvent.getPointerId(b1);
      if (e(i2)) {
        float f1 = paramMotionEvent.getX(b1);
        float f2 = paramMotionEvent.getY(b1);
        this.f[i2] = f1;
        this.g[i2] = f2;
      } 
    } 
  }
  
  private int d(int paramInt1, int paramInt2) {
    byte b1;
    if (paramInt1 < this.u.getLeft() + this.o) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    if (paramInt2 < this.u.getTop() + this.o)
      b1 |= 0x4; 
    if (paramInt1 > this.u.getRight() - this.o)
      b1 |= 0x2; 
    if (paramInt2 > this.u.getBottom() - this.o)
      b1 |= 0x8; 
    return b1;
  }
  
  private void d() {
    this.l.computeCurrentVelocity(1000, this.m);
    a(a(this.l.getXVelocity(this.c), this.n, this.m), a(this.l.getYVelocity(this.c), this.n, this.m));
  }
  
  private void d(int paramInt) {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null || arrayOfFloat.length <= paramInt) {
      int i1 = paramInt + 1;
      float[] arrayOfFloat1 = new float[i1];
      float[] arrayOfFloat2 = new float[i1];
      float[] arrayOfFloat3 = new float[i1];
      float[] arrayOfFloat4 = new float[i1];
      int[] arrayOfInt1 = new int[i1];
      int[] arrayOfInt2 = new int[i1];
      int[] arrayOfInt3 = new int[i1];
      float[] arrayOfFloat5 = this.d;
      if (arrayOfFloat5 != null) {
        System.arraycopy(arrayOfFloat5, 0, arrayOfFloat1, 0, arrayOfFloat5.length);
        float[] arrayOfFloat6 = this.e;
        System.arraycopy(arrayOfFloat6, 0, arrayOfFloat2, 0, arrayOfFloat6.length);
        float[] arrayOfFloat7 = this.f;
        System.arraycopy(arrayOfFloat7, 0, arrayOfFloat3, 0, arrayOfFloat7.length);
        float[] arrayOfFloat8 = this.g;
        System.arraycopy(arrayOfFloat8, 0, arrayOfFloat4, 0, arrayOfFloat8.length);
        int[] arrayOfInt4 = this.h;
        System.arraycopy(arrayOfInt4, 0, arrayOfInt1, 0, arrayOfInt4.length);
        int[] arrayOfInt5 = this.i;
        System.arraycopy(arrayOfInt5, 0, arrayOfInt2, 0, arrayOfInt5.length);
        int[] arrayOfInt6 = this.j;
        System.arraycopy(arrayOfInt6, 0, arrayOfInt3, 0, arrayOfInt6.length);
      } 
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.g = arrayOfFloat4;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    } 
  }
  
  private boolean e(int paramInt) {
    if (!a(paramInt)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Ignoring pointerId=");
      stringBuilder.append(paramInt);
      stringBuilder.append(" because ACTION_DOWN was not received ");
      stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
      stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
      Log.e("ViewDragHelper", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  public int a() { return this.b; }
  
  public void a(View paramView, int paramInt) {
    if (paramView.getParent() == this.u) {
      this.s = paramView;
      this.c = paramInt;
      this.r.b(paramView, paramInt);
      b(1);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    stringBuilder.append(this.u);
    stringBuilder.append(")");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean a(int paramInt) { return ((this.k & 1 << paramInt) != 0); }
  
  public boolean a(int paramInt1, int paramInt2) {
    if (this.t)
      return a(paramInt1, paramInt2, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c)); 
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean a(MotionEvent paramMotionEvent) {
    int i9;
    float f4;
    float f3;
    int i8;
    byte b1;
    int i7;
    int i5;
    int i4;
    View view;
    int i3;
    float f2;
    float f1;
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0)
      b(); 
    if (this.l == null)
      this.l = VelocityTracker.obtain(); 
    this.l.addMovement(paramMotionEvent);
    switch (i1) {
      case 6:
        c(paramMotionEvent.getPointerId(i2));
        break;
      case 5:
        i8 = paramMotionEvent.getPointerId(i2);
        f3 = paramMotionEvent.getX(i2);
        f4 = paramMotionEvent.getY(i2);
        a(f3, f4, i8);
        i9 = this.a;
        if (i9 == 0) {
          int i10 = this.h[i8];
          int i11 = this.p;
          if ((i10 & i11) != 0)
            this.r.a(i10 & i11, i8); 
          break;
        } 
        if (i9 == 2) {
          View view1 = c((int)f3, (int)f4);
          if (view1 == this.s)
            b(view1, i8); 
        } 
        break;
      case 2:
        if (this.d == null || this.e == null)
          break; 
        i7 = paramMotionEvent.getPointerCount();
        for (b1 = 0; b1 < i7; b1++) {
          int i10 = paramMotionEvent.getPointerId(b1);
          if (e(i10)) {
            boolean bool1;
            float f5 = paramMotionEvent.getX(b1);
            float f6 = paramMotionEvent.getY(b1);
            float f7 = f5 - this.d[i10];
            float f8 = f6 - this.e[i10];
            View view1 = c((int)f5, (int)f6);
            if (view1 != null && a(view1, f7, f8)) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool1) {
              int i11 = view1.getLeft();
              int i12 = (int)f7;
              int i13 = i11 + i12;
              int i14 = this.r.b(view1, i13, i12);
              int i15 = view1.getTop();
              int i16 = (int)f8;
              int i17 = i15 + i16;
              int i18 = this.r.a(view1, i17, i16);
              int i19 = this.r.b(view1);
              int i20 = this.r.a(view1);
              if ((i19 == 0 || (i19 > 0 && i14 == i11)) && (i20 == 0 || (i20 > 0 && i18 == i15)))
                break; 
            } 
            b(f7, f8, i10);
            if (this.a == 1 || (bool1 && b(view1, i10)))
              break; 
          } 
        } 
        c(paramMotionEvent);
        break;
      case 1:
      case 3:
        b();
        break;
      case 0:
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i3 = paramMotionEvent.getPointerId(0);
        a(f1, f2, i3);
        view = c((int)f1, (int)f2);
        if (view == this.s && this.a == 2)
          b(view, i3); 
        i4 = this.h[i3];
        i5 = this.p;
        if ((i4 & i5) != 0)
          this.r.a(i4 & i5, i3); 
        break;
    } 
    int i6 = this.a;
    boolean bool = false;
    if (i6 == 1)
      bool = true; 
    return bool;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2) {
    this.s = paramView;
    this.c = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if (!bool && this.a == 0 && this.s != null)
      this.s = null; 
    return bool;
  }
  
  public boolean a(boolean paramBoolean) {
    if (this.a == 2) {
      boolean bool1 = this.q.computeScrollOffset();
      int i2 = this.q.getCurrX();
      int i3 = this.q.getCurrY();
      int i4 = i2 - this.s.getLeft();
      int i5 = i3 - this.s.getTop();
      if (i4 != 0)
        r.f(this.s, i4); 
      if (i5 != 0)
        r.e(this.s, i5); 
      if (i4 != 0 || i5 != 0)
        this.r.a(this.s, i2, i3, i4, i5); 
      if (bool1 && i2 == this.q.getFinalX() && i3 == this.q.getFinalY()) {
        this.q.abortAnimation();
        bool1 = false;
      } 
      if (!bool1)
        if (paramBoolean) {
          this.u.post(this.w);
        } else {
          b(0);
        }  
    } 
    int i1 = this.a;
    boolean bool = false;
    if (i1 == 2)
      bool = true; 
    return bool;
  }
  
  public void b() {
    this.c = -1;
    c();
    VelocityTracker velocityTracker = this.l;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.l = null;
    } 
  }
  
  void b(int paramInt) {
    this.u.removeCallbacks(this.w);
    if (this.a != paramInt) {
      this.a = paramInt;
      this.r.a(paramInt);
      if (this.a == 0)
        this.s = null; 
    } 
  }
  
  public void b(MotionEvent paramMotionEvent) {
    int i7;
    float f4;
    float f3;
    int i6;
    int i1 = paramMotionEvent.getActionMasked();
    int i2 = paramMotionEvent.getActionIndex();
    if (i1 == 0)
      b(); 
    if (this.l == null)
      this.l = VelocityTracker.obtain(); 
    this.l.addMovement(paramMotionEvent);
    byte b1 = 0;
    switch (i1) {
      default:
        return;
      case 6:
        i7 = paramMotionEvent.getPointerId(i2);
        if (this.a == 1 && i7 == this.c) {
          byte b2;
          int i8 = paramMotionEvent.getPointerCount();
          while (true) {
            if (b1 < i8) {
              int i9 = paramMotionEvent.getPointerId(b1);
              if (i9 != this.c) {
                float f5 = paramMotionEvent.getX(b1);
                float f6 = paramMotionEvent.getY(b1);
                View view1 = c((int)f5, (int)f6);
                View view2 = this.s;
                if (view1 == view2 && b(view2, i9)) {
                  int i10 = this.c;
                  break;
                } 
              } 
              b1++;
              continue;
            } 
            b2 = -1;
            break;
          } 
          if (b2 == -1)
            d(); 
        } 
        c(i7);
        return;
      case 5:
        i6 = paramMotionEvent.getPointerId(i2);
        f3 = paramMotionEvent.getX(i2);
        f4 = paramMotionEvent.getY(i2);
        a(f3, f4, i6);
        if (this.a == 0) {
          b(c((int)f3, (int)f4), i6);
          int i8 = this.h[i6];
          int i9 = this.p;
          if ((i8 & i9) != 0) {
            this.r.a(i8 & i9, i6);
            return;
          } 
        } else if (b((int)f3, (int)f4)) {
          b(this.s, i6);
          return;
        } 
        return;
      case 3:
        if (this.a == 1)
          a(0.0F, 0.0F); 
        b();
        return;
      case 2:
        if (this.a == 1) {
          if (!e(this.c))
            return; 
          int i8 = paramMotionEvent.findPointerIndex(this.c);
          float f5 = paramMotionEvent.getX(i8);
          float f6 = paramMotionEvent.getY(i8);
          float[] arrayOfFloat = this.f;
          int i9 = this.c;
          int i10 = (int)(f5 - arrayOfFloat[i9]);
          int i11 = (int)(f6 - this.g[i9]);
          b(i10 + this.s.getLeft(), i11 + this.s.getTop(), i10, i11);
        } else {
          int i8 = paramMotionEvent.getPointerCount();
          while (true) {
            if (b1 < i8) {
              int i9 = paramMotionEvent.getPointerId(b1);
              if (e(i9)) {
                float f5 = paramMotionEvent.getX(b1);
                float f6 = paramMotionEvent.getY(b1);
                float f7 = f5 - this.d[i9];
                float f8 = f6 - this.e[i9];
                b(f7, f8, i9);
                if (this.a == 1) {
                  c(paramMotionEvent);
                  return;
                } 
                View view1 = c((int)f5, (int)f6);
                if (a(view1, f7, f8) && b(view1, i9)) {
                  c(paramMotionEvent);
                  return;
                } 
              } 
              b1++;
              continue;
            } 
            c(paramMotionEvent);
            return;
          } 
        } 
        c(paramMotionEvent);
        return;
      case 1:
        if (this.a == 1)
          d(); 
        b();
        return;
      case 0:
        break;
    } 
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i3 = paramMotionEvent.getPointerId(0);
    View view = c((int)f1, (int)f2);
    a(f1, f2, i3);
    b(view, i3);
    int i4 = this.h[i3];
    int i5 = this.p;
    if ((i4 & i5) != 0)
      this.r.a(i4 & i5, i3); 
  }
  
  public boolean b(int paramInt1, int paramInt2) { return b(this.s, paramInt1, paramInt2); }
  
  boolean b(View paramView, int paramInt) {
    if (paramView == this.s && this.c == paramInt)
      return true; 
    if (paramView != null && this.r.a(paramView, paramInt)) {
      this.c = paramInt;
      a(paramView, paramInt);
      return true;
    } 
    return false;
  }
  
  public boolean b(View paramView, int paramInt1, int paramInt2) {
    if (paramView == null)
      return false; 
    int i1 = paramView.getLeft();
    boolean bool = false;
    if (paramInt1 >= i1) {
      int i2 = paramView.getRight();
      bool = false;
      if (paramInt1 < i2) {
        int i3 = paramView.getTop();
        bool = false;
        if (paramInt2 >= i3) {
          int i4 = paramView.getBottom();
          bool = false;
          if (paramInt2 < i4)
            bool = true; 
        } 
      } 
    } 
    return bool;
  }
  
  public View c(int paramInt1, int paramInt2) {
    for (int i1 = -1 + this.u.getChildCount(); i1 >= 0; i1--) {
      View view = this.u.getChildAt(this.r.c(i1));
      if (paramInt1 >= view.getLeft() && paramInt1 < view.getRight() && paramInt2 >= view.getTop() && paramInt2 < view.getBottom())
        return view; 
    } 
    return null;
  }
  
  public static abstract class a {
    public int a(View param1View) { return 0; }
    
    public int a(View param1View, int param1Int1, int param1Int2) { return 0; }
    
    public void a(int param1Int) {}
    
    public void a(int param1Int1, int param1Int2) {}
    
    public void a(View param1View, float param1Float1, float param1Float2) {}
    
    public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    public abstract boolean a(View param1View, int param1Int);
    
    public int b(View param1View) { return 0; }
    
    public int b(View param1View, int param1Int1, int param1Int2) { return 0; }
    
    public void b(int param1Int1, int param1Int2) {}
    
    public void b(View param1View, int param1Int) {}
    
    public boolean b(int param1Int) { return false; }
    
    public int c(int param1Int) { return param1Int; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */