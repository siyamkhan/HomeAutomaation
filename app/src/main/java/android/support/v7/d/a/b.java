package android.support.v7.d.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.graphics.drawable.a;
import android.util.SparseArray;

class b extends Drawable implements Drawable.Callback {
  private b a;
  
  private Rect b;
  
  private Drawable c;
  
  private Drawable d;
  
  private int e = 255;
  
  private boolean f;
  
  private int g = -1;
  
  private int h = -1;
  
  private boolean i;
  
  private Runnable j;
  
  private long k;
  
  private long l;
  
  private a m;
  
  static int a(Resources paramResources, int paramInt) {
    if (paramResources != null)
      paramInt = (paramResources.getDisplayMetrics()).densityDpi; 
    if (paramInt == 0)
      paramInt = 160; 
    return paramInt;
  }
  
  private void a(Drawable paramDrawable) {
    if (this.m == null)
      this.m = new a(); 
    paramDrawable.setCallback(this.m.a(paramDrawable.getCallback()));
    try {
      if (this.a.C <= 0 && this.f)
        paramDrawable.setAlpha(this.e); 
      if (this.a.G) {
        paramDrawable.setColorFilter(this.a.F);
      } else {
        if (this.a.J)
          a.a(paramDrawable, this.a.H); 
        if (this.a.K)
          a.a(paramDrawable, this.a.I); 
      } 
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setDither(this.a.z);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setBounds(getBounds());
      if (Build.VERSION.SDK_INT >= 23)
        paramDrawable.setLayoutDirection(getLayoutDirection()); 
      if (Build.VERSION.SDK_INT >= 19)
        paramDrawable.setAutoMirrored(this.a.E); 
      Rect rect = this.b;
      if (Build.VERSION.SDK_INT >= 21 && rect != null)
        paramDrawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom); 
      return;
    } finally {
      paramDrawable.setCallback(this.m.a());
    } 
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(23)
  private boolean a() { return (isAutoMirrored() && getLayoutDirection() == 1); }
  
  final void a(Resources paramResources) { this.a.a(paramResources); }
  
  protected void a(b paramb) {
    this.a = paramb;
    int n = this.g;
    if (n >= 0) {
      this.c = paramb.b(n);
      Drawable drawable = this.c;
      if (drawable != null)
        a(drawable); 
    } 
    this.h = -1;
    this.d = null;
  }
  
  void a(boolean paramBoolean) { // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: iload_2
    //   4: putfield f : Z
    //   7: invokestatic uptimeMillis : ()J
    //   10: lstore_3
    //   11: aload_0
    //   12: getfield c : Landroid/graphics/drawable/Drawable;
    //   15: astore #5
    //   17: aload #5
    //   19: ifnull -> 101
    //   22: aload_0
    //   23: getfield k : J
    //   26: lstore #12
    //   28: lload #12
    //   30: lconst_0
    //   31: lcmp
    //   32: ifeq -> 106
    //   35: lload #12
    //   37: lload_3
    //   38: lcmp
    //   39: ifgt -> 54
    //   42: aload #5
    //   44: aload_0
    //   45: getfield e : I
    //   48: invokevirtual setAlpha : (I)V
    //   51: goto -> 101
    //   54: ldc2_w 255
    //   57: lload #12
    //   59: lload_3
    //   60: lsub
    //   61: lmul
    //   62: l2i
    //   63: aload_0
    //   64: getfield a : Landroid/support/v7/d/a/b$b;
    //   67: getfield C : I
    //   70: idiv
    //   71: istore #14
    //   73: aload_0
    //   74: getfield c : Landroid/graphics/drawable/Drawable;
    //   77: sipush #255
    //   80: iload #14
    //   82: isub
    //   83: aload_0
    //   84: getfield e : I
    //   87: imul
    //   88: sipush #255
    //   91: idiv
    //   92: invokevirtual setAlpha : (I)V
    //   95: iconst_1
    //   96: istore #6
    //   98: goto -> 109
    //   101: aload_0
    //   102: lconst_0
    //   103: putfield k : J
    //   106: iconst_0
    //   107: istore #6
    //   109: aload_0
    //   110: getfield d : Landroid/graphics/drawable/Drawable;
    //   113: astore #7
    //   115: aload #7
    //   117: ifnull -> 201
    //   120: aload_0
    //   121: getfield l : J
    //   124: lstore #8
    //   126: lload #8
    //   128: lconst_0
    //   129: lcmp
    //   130: ifeq -> 206
    //   133: lload #8
    //   135: lload_3
    //   136: lcmp
    //   137: ifgt -> 161
    //   140: aload #7
    //   142: iconst_0
    //   143: iconst_0
    //   144: invokevirtual setVisible : (ZZ)Z
    //   147: pop
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield d : Landroid/graphics/drawable/Drawable;
    //   153: aload_0
    //   154: iconst_m1
    //   155: putfield h : I
    //   158: goto -> 201
    //   161: ldc2_w 255
    //   164: lload #8
    //   166: lload_3
    //   167: lsub
    //   168: lmul
    //   169: l2i
    //   170: aload_0
    //   171: getfield a : Landroid/support/v7/d/a/b$b;
    //   174: getfield D : I
    //   177: idiv
    //   178: istore #10
    //   180: aload_0
    //   181: getfield d : Landroid/graphics/drawable/Drawable;
    //   184: iload #10
    //   186: aload_0
    //   187: getfield e : I
    //   190: imul
    //   191: sipush #255
    //   194: idiv
    //   195: invokevirtual setAlpha : (I)V
    //   198: goto -> 209
    //   201: aload_0
    //   202: lconst_0
    //   203: putfield l : J
    //   206: iload #6
    //   208: istore_2
    //   209: iload_1
    //   210: ifeq -> 230
    //   213: iload_2
    //   214: ifeq -> 230
    //   217: aload_0
    //   218: aload_0
    //   219: getfield j : Ljava/lang/Runnable;
    //   222: lload_3
    //   223: ldc2_w 16
    //   226: ladd
    //   227: invokevirtual scheduleSelf : (Ljava/lang/Runnable;J)V
    //   230: return }
  
  boolean a(int paramInt) {
    if (paramInt == this.g)
      return false; 
    long l1 = SystemClock.uptimeMillis();
    if (this.a.D > 0) {
      Drawable drawable1 = this.d;
      if (drawable1 != null)
        drawable1.setVisible(false, false); 
      Drawable drawable2 = this.c;
      if (drawable2 != null) {
        this.d = drawable2;
        this.h = this.g;
        this.l = l1 + this.a.D;
      } else {
        this.d = null;
        this.h = -1;
        this.l = 0L;
      } 
    } else {
      Drawable drawable = this.c;
      if (drawable != null)
        drawable.setVisible(false, false); 
    } 
    if (paramInt >= 0 && paramInt < this.a.j) {
      Drawable drawable = this.a.b(paramInt);
      this.c = drawable;
      this.g = paramInt;
      if (drawable != null) {
        if (this.a.C > 0)
          this.k = l1 + this.a.C; 
        a(drawable);
      } 
    } else {
      this.c = null;
      this.g = -1;
    } 
    if (this.k != 0L || this.l != 0L) {
      Runnable runnable = this.j;
      if (runnable == null) {
        this.j = new Runnable(this) {
            public void run() {
              this.a.a(true);
              this.a.invalidateSelf();
            }
          };
      } else {
        unscheduleSelf(runnable);
      } 
      a(true);
    } 
    invalidateSelf();
    return true;
  }
  
  public void applyTheme(Resources.Theme paramTheme) { this.a.a(paramTheme); }
  
  b c() { return this.a; }
  
  public boolean canApplyTheme() { return this.a.canApplyTheme(); }
  
  int d() { return this.g; }
  
  public void draw(Canvas paramCanvas) {
    Drawable drawable1 = this.c;
    if (drawable1 != null)
      drawable1.draw(paramCanvas); 
    Drawable drawable2 = this.d;
    if (drawable2 != null)
      drawable2.draw(paramCanvas); 
  }
  
  public int getAlpha() { return this.e; }
  
  public int getChangingConfigurations() { return super.getChangingConfigurations() | this.a.getChangingConfigurations(); }
  
  public final Drawable.ConstantState getConstantState() {
    if (this.a.n()) {
      this.a.f = getChangingConfigurations();
      return this.a;
    } 
    return null;
  }
  
  public Drawable getCurrent() { return this.c; }
  
  public void getHotspotBounds(Rect paramRect) {
    Rect rect = this.b;
    if (rect != null) {
      paramRect.set(rect);
      return;
    } 
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight() {
    if (this.a.f())
      return this.a.h(); 
    Drawable drawable = this.c;
    return (drawable != null) ? drawable.getIntrinsicHeight() : -1;
  }
  
  public int getIntrinsicWidth() {
    if (this.a.f())
      return this.a.g(); 
    Drawable drawable = this.c;
    return (drawable != null) ? drawable.getIntrinsicWidth() : -1;
  }
  
  public int getMinimumHeight() {
    if (this.a.f())
      return this.a.j(); 
    Drawable drawable = this.c;
    return (drawable != null) ? drawable.getMinimumHeight() : 0;
  }
  
  public int getMinimumWidth() {
    if (this.a.f())
      return this.a.i(); 
    Drawable drawable = this.c;
    return (drawable != null) ? drawable.getMinimumWidth() : 0;
  }
  
  public int getOpacity() {
    Drawable drawable = this.c;
    return (drawable == null || !drawable.isVisible()) ? -2 : this.a.l();
  }
  
  public void getOutline(Outline paramOutline) {
    Drawable drawable = this.c;
    if (drawable != null)
      drawable.getOutline(paramOutline); 
  }
  
  public boolean getPadding(Rect paramRect) {
    boolean bool;
    Rect rect = this.a.e();
    if (rect != null) {
      paramRect.set(rect);
      if ((rect.left | rect.top | rect.bottom | rect.right) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
    } else {
      Drawable drawable = this.c;
      if (drawable != null) {
        bool = drawable.getPadding(paramRect);
      } else {
        bool = super.getPadding(paramRect);
      } 
    } 
    if (a()) {
      int n = paramRect.left;
      paramRect.left = paramRect.right;
      paramRect.right = n;
    } 
    return bool;
  }
  
  public void invalidateDrawable(Drawable paramDrawable) {
    b b1 = this.a;
    if (b1 != null)
      b1.b(); 
    if (paramDrawable == this.c && getCallback() != null)
      getCallback().invalidateDrawable(this); 
  }
  
  public boolean isAutoMirrored() { return this.a.E; }
  
  public boolean isStateful() { return this.a.m(); }
  
  public void jumpToCurrentState() {
    boolean bool;
    Drawable drawable1 = this.d;
    if (drawable1 != null) {
      drawable1.jumpToCurrentState();
      this.d = null;
      this.h = -1;
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable2 = this.c;
    if (drawable2 != null) {
      drawable2.jumpToCurrentState();
      if (this.f)
        this.c.setAlpha(this.e); 
    } 
    if (this.l != 0L) {
      this.l = 0L;
      bool = true;
    } 
    if (this.k != 0L) {
      this.k = 0L;
      bool = true;
    } 
    if (bool)
      invalidateSelf(); 
  }
  
  public Drawable mutate() {
    if (!this.i && super.mutate() == this) {
      b b1 = c();
      b1.a();
      a(b1);
      this.i = true;
    } 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    Drawable drawable1 = this.d;
    if (drawable1 != null)
      drawable1.setBounds(paramRect); 
    Drawable drawable2 = this.c;
    if (drawable2 != null)
      drawable2.setBounds(paramRect); 
  }
  
  public boolean onLayoutDirectionChanged(int paramInt) { return this.a.d(paramInt, d()); }
  
  protected boolean onLevelChange(int paramInt) {
    Drawable drawable1 = this.d;
    if (drawable1 != null)
      return drawable1.setLevel(paramInt); 
    Drawable drawable2 = this.c;
    return (drawable2 != null) ? drawable2.setLevel(paramInt) : 0;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    Drawable drawable1 = this.d;
    if (drawable1 != null)
      return drawable1.setState(paramArrayOfInt); 
    Drawable drawable2 = this.c;
    return (drawable2 != null) ? drawable2.setState(paramArrayOfInt) : 0;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    if (paramDrawable == this.c && getCallback() != null)
      getCallback().scheduleDrawable(this, paramRunnable, paramLong); 
  }
  
  public void setAlpha(int paramInt) {
    if (!this.f || this.e != paramInt) {
      this.f = true;
      this.e = paramInt;
      Drawable drawable = this.c;
      if (drawable != null) {
        if (this.k == 0L) {
          drawable.setAlpha(paramInt);
          return;
        } 
        a(false);
      } 
    } 
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    if (this.a.E != paramBoolean) {
      b b1 = this.a;
      b1.E = paramBoolean;
      Drawable drawable = this.c;
      if (drawable != null)
        a.a(drawable, b1.E); 
    } 
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    b b1 = this.a;
    b1.G = true;
    if (b1.F != paramColorFilter) {
      this.a.F = paramColorFilter;
      Drawable drawable = this.c;
      if (drawable != null)
        drawable.setColorFilter(paramColorFilter); 
    } 
  }
  
  public void setDither(boolean paramBoolean) {
    if (this.a.z != paramBoolean) {
      b b1 = this.a;
      b1.z = paramBoolean;
      Drawable drawable = this.c;
      if (drawable != null)
        drawable.setDither(b1.z); 
    } 
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2) {
    Drawable drawable = this.c;
    if (drawable != null)
      a.a(drawable, paramFloat1, paramFloat2); 
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Rect rect = this.b;
    if (rect == null) {
      this.b = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      rect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    } 
    Drawable drawable = this.c;
    if (drawable != null)
      a.a(drawable, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    b b1 = this.a;
    b1.J = true;
    if (b1.H != paramColorStateList) {
      this.a.H = paramColorStateList;
      a.a(this.c, paramColorStateList);
    } 
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    b b1 = this.a;
    b1.K = true;
    if (b1.I != paramMode) {
      this.a.I = paramMode;
      a.a(this.c, paramMode);
    } 
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable drawable1 = this.d;
    if (drawable1 != null)
      drawable1.setVisible(paramBoolean1, paramBoolean2); 
    Drawable drawable2 = this.c;
    if (drawable2 != null)
      drawable2.setVisible(paramBoolean1, paramBoolean2); 
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    if (paramDrawable == this.c && getCallback() != null)
      getCallback().unscheduleDrawable(this, paramRunnable); 
  }
  
  static class a implements Drawable.Callback {
    private Drawable.Callback a;
    
    public Drawable.Callback a() {
      Drawable.Callback callback = this.a;
      this.a = null;
      return callback;
    }
    
    public a a(Drawable.Callback param1Callback) {
      this.a = param1Callback;
      return this;
    }
    
    public void invalidateDrawable(Drawable param1Drawable) {}
    
    public void scheduleDrawable(Drawable param1Drawable, Runnable param1Runnable, long param1Long) {
      Drawable.Callback callback = this.a;
      if (callback != null)
        callback.scheduleDrawable(param1Drawable, param1Runnable, param1Long); 
    }
    
    public void unscheduleDrawable(Drawable param1Drawable, Runnable param1Runnable) {
      Drawable.Callback callback = this.a;
      if (callback != null)
        callback.unscheduleDrawable(param1Drawable, param1Runnable); 
    }
  }
  
  static abstract class b extends Drawable.ConstantState {
    boolean A;
    
    int B;
    
    int C;
    
    int D;
    
    boolean E;
    
    ColorFilter F;
    
    boolean G;
    
    ColorStateList H;
    
    PorterDuff.Mode I;
    
    boolean J;
    
    boolean K;
    
    final b c;
    
    Resources d;
    
    int e = 160;
    
    int f;
    
    int g;
    
    SparseArray<Drawable.ConstantState> h;
    
    Drawable[] i;
    
    int j;
    
    boolean k;
    
    boolean l;
    
    Rect m;
    
    boolean n;
    
    boolean o;
    
    int p;
    
    int q;
    
    int r;
    
    int s;
    
    boolean t;
    
    int u;
    
    boolean v;
    
    boolean w;
    
    boolean x;
    
    boolean y;
    
    boolean z;
    
    b(b param1b, b param1b1, Resources param1Resources) {
      byte b1 = 0;
      this.k = false;
      this.n = false;
      this.z = true;
      this.C = 0;
      this.D = 0;
      this.c = param1b1;
      if (param1Resources != null) {
        object = param1Resources;
      } else if (param1b != null) {
        object = param1b.d;
      } else {
        object = null;
      } 
      this.d = object;
      if (param1b != null) {
        b2 = param1b.e;
      } else {
        b2 = 0;
      } 
      this.e = b.a(param1Resources, b2);
      if (param1b != null) {
        SparseArray sparseArray2;
        this.f = param1b.f;
        this.g = param1b.g;
        this.x = true;
        this.y = true;
        this.k = param1b.k;
        this.n = param1b.n;
        this.z = param1b.z;
        this.A = param1b.A;
        this.B = param1b.B;
        this.C = param1b.C;
        this.D = param1b.D;
        this.E = param1b.E;
        this.F = param1b.F;
        this.G = param1b.G;
        this.H = param1b.H;
        this.I = param1b.I;
        this.J = param1b.J;
        this.K = param1b.K;
        if (param1b.e == this.e) {
          if (param1b.l) {
            this.m = new Rect(param1b.m);
            this.l = true;
          } 
          if (param1b.o) {
            this.p = param1b.p;
            this.q = param1b.q;
            this.r = param1b.r;
            this.s = param1b.s;
            this.o = true;
          } 
        } 
        if (param1b.t) {
          this.u = param1b.u;
          this.t = true;
        } 
        if (param1b.v) {
          this.w = param1b.w;
          this.v = true;
        } 
        Drawable[] arrayOfDrawable = param1b.i;
        this.i = new Drawable[arrayOfDrawable.length];
        this.j = param1b.j;
        SparseArray sparseArray1 = param1b.h;
        if (sparseArray1 != null) {
          sparseArray2 = sparseArray1.clone();
        } else {
          sparseArray2 = new SparseArray(this.j);
        } 
        this.h = sparseArray2;
        int i1 = this.j;
        while (b1 < i1) {
          if (arrayOfDrawable[b1] != null) {
            Drawable.ConstantState constantState = arrayOfDrawable[b1].getConstantState();
            if (constantState != null) {
              this.h.put(b1, constantState);
            } else {
              this.i[b1] = arrayOfDrawable[b1];
            } 
          } 
          b1++;
        } 
      } else {
        this.i = new Drawable[10];
        this.j = 0;
      } 
    }
    
    private Drawable b(Drawable param1Drawable) {
      if (Build.VERSION.SDK_INT >= 23)
        param1Drawable.setLayoutDirection(this.B); 
      Drawable drawable = param1Drawable.mutate();
      drawable.setCallback(this.c);
      return drawable;
    }
    
    private void o() {
      SparseArray sparseArray = this.h;
      if (sparseArray != null) {
        int i1 = sparseArray.size();
        for (byte b1 = 0; b1 < i1; b1++) {
          int i2 = this.h.keyAt(b1);
          Drawable.ConstantState constantState = (Drawable.ConstantState)this.h.valueAt(b1);
          this.i[i2] = b(constantState.newDrawable(this.d));
        } 
        this.h = null;
      } 
    }
    
    public final int a(Drawable param1Drawable) {
      int i1 = this.j;
      if (i1 >= this.i.length)
        e(i1, i1 + 10); 
      param1Drawable.mutate();
      param1Drawable.setVisible(false, true);
      param1Drawable.setCallback(this.c);
      this.i[i1] = param1Drawable;
      this.j = 1 + this.j;
      this.g |= param1Drawable.getChangingConfigurations();
      b();
      this.m = null;
      this.l = false;
      this.o = false;
      this.x = false;
      return i1;
    }
    
    void a() {
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      for (byte b1 = 0; b1 < i1; b1++) {
        if (arrayOfDrawable[b1] != null)
          arrayOfDrawable[b1].mutate(); 
      } 
      this.A = true;
    }
    
    final void a(Resources.Theme param1Theme) {
      if (param1Theme != null) {
        o();
        int i1 = this.j;
        Drawable[] arrayOfDrawable = this.i;
        for (byte b1 = 0; b1 < i1; b1++) {
          if (arrayOfDrawable[b1] != null && arrayOfDrawable[b1].canApplyTheme()) {
            arrayOfDrawable[b1].applyTheme(param1Theme);
            this.g |= arrayOfDrawable[b1].getChangingConfigurations();
          } 
        } 
        a(param1Theme.getResources());
      } 
    }
    
    final void a(Resources param1Resources) {
      if (param1Resources != null) {
        this.d = param1Resources;
        int i1 = b.a(param1Resources, this.e);
        int i2 = this.e;
        this.e = i1;
        if (i2 != i1) {
          this.o = false;
          this.l = false;
        } 
      } 
    }
    
    public final void a(boolean param1Boolean) { this.k = param1Boolean; }
    
    public final Drawable b(int param1Int) {
      Drawable drawable = this.i[param1Int];
      if (drawable != null)
        return drawable; 
      SparseArray sparseArray = this.h;
      if (sparseArray != null) {
        int i1 = sparseArray.indexOfKey(param1Int);
        if (i1 >= 0) {
          Drawable drawable1 = b(((Drawable.ConstantState)this.h.valueAt(i1)).newDrawable(this.d));
          this.i[param1Int] = drawable1;
          this.h.removeAt(i1);
          if (this.h.size() == 0)
            this.h = null; 
          return drawable1;
        } 
      } 
      return null;
    }
    
    void b() {
      this.t = false;
      this.v = false;
    }
    
    public final void b(boolean param1Boolean) { this.n = param1Boolean; }
    
    final int c() { return this.i.length; }
    
    public final void c(int param1Int) { this.C = param1Int; }
    
    public boolean canApplyTheme() {
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      for (byte b1 = 0; b1 < i1; b1++) {
        Drawable drawable = arrayOfDrawable[b1];
        if (drawable != null) {
          if (drawable.canApplyTheme())
            return true; 
        } else {
          Drawable.ConstantState constantState = (Drawable.ConstantState)this.h.get(b1);
          if (constantState != null && constantState.canApplyTheme())
            return true; 
        } 
      } 
      return false;
    }
    
    public final int d() { return this.j; }
    
    public final void d(int param1Int) { this.D = param1Int; }
    
    final boolean d(int param1Int1, int param1Int2) {
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      byte b1 = 0;
      int i2 = 0;
      while (b1 < i1) {
        if (arrayOfDrawable[b1] != null) {
          byte b2;
          if (Build.VERSION.SDK_INT >= 23) {
            b2 = arrayOfDrawable[b1].setLayoutDirection(param1Int1);
          } else {
            b2 = 0;
          } 
          if (b1 == param1Int2)
            i2 = b2; 
        } 
        b1++;
      } 
      this.B = param1Int1;
      return i2;
    }
    
    public final Rect e() {
      if (this.k)
        return null; 
      if (this.m != null || this.l)
        return this.m; 
      o();
      Rect rect1 = new Rect();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      Rect rect2 = null;
      for (byte b1 = 0; b1 < i1; b1++) {
        if (arrayOfDrawable[b1].getPadding(rect1)) {
          if (rect2 == null)
            rect2 = new Rect(0, 0, 0, 0); 
          if (rect1.left > rect2.left)
            rect2.left = rect1.left; 
          if (rect1.top > rect2.top)
            rect2.top = rect1.top; 
          if (rect1.right > rect2.right)
            rect2.right = rect1.right; 
          if (rect1.bottom > rect2.bottom)
            rect2.bottom = rect1.bottom; 
        } 
      } 
      this.l = true;
      this.m = rect2;
      return rect2;
    }
    
    public void e(int param1Int1, int param1Int2) {
      Drawable[] arrayOfDrawable = new Drawable[param1Int2];
      System.arraycopy(this.i, 0, arrayOfDrawable, 0, param1Int1);
      this.i = arrayOfDrawable;
    }
    
    public final boolean f() { return this.n; }
    
    public final int g() {
      if (!this.o)
        k(); 
      return this.p;
    }
    
    public int getChangingConfigurations() { return this.f | this.g; }
    
    public final int h() {
      if (!this.o)
        k(); 
      return this.q;
    }
    
    public final int i() {
      if (!this.o)
        k(); 
      return this.r;
    }
    
    public final int j() {
      if (!this.o)
        k(); 
      return this.s;
    }
    
    protected void k() {
      this.o = true;
      o();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      this.q = -1;
      this.p = -1;
      byte b1 = 0;
      this.s = 0;
      this.r = 0;
      while (b1 < i1) {
        Drawable drawable = arrayOfDrawable[b1];
        int i2 = drawable.getIntrinsicWidth();
        if (i2 > this.p)
          this.p = i2; 
        int i3 = drawable.getIntrinsicHeight();
        if (i3 > this.q)
          this.q = i3; 
        int i4 = drawable.getMinimumWidth();
        if (i4 > this.r)
          this.r = i4; 
        int i5 = drawable.getMinimumHeight();
        if (i5 > this.s)
          this.s = i5; 
        b1++;
      } 
    }
    
    public final int l() {
      byte b1;
      if (this.t)
        return this.u; 
      o();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      if (i1 > 0) {
        b1 = arrayOfDrawable[0].getOpacity();
      } else {
        b1 = -2;
      } 
      int i2 = b1;
      for (byte b2 = 1; b2 < i1; b2++)
        i2 = Drawable.resolveOpacity(i2, arrayOfDrawable[b2].getOpacity()); 
      this.u = i2;
      this.t = true;
      return i2;
    }
    
    public final boolean m() {
      boolean bool;
      if (this.v)
        return this.w; 
      o();
      int i1 = this.j;
      Drawable[] arrayOfDrawable = this.i;
      byte b1 = 0;
      while (true) {
        bool = false;
        if (b1 < i1) {
          if (arrayOfDrawable[b1].isStateful()) {
            bool = true;
            break;
          } 
          b1++;
          continue;
        } 
        break;
      } 
      this.w = bool;
      this.v = true;
      return bool;
    }
    
    public boolean n() { // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield x : Z
      //   6: ifeq -> 20
      //   9: aload_0
      //   10: getfield y : Z
      //   13: istore #5
      //   15: aload_0
      //   16: monitorexit
      //   17: iload #5
      //   19: ireturn
      //   20: aload_0
      //   21: invokespecial o : ()V
      //   24: aload_0
      //   25: iconst_1
      //   26: putfield x : Z
      //   29: aload_0
      //   30: getfield j : I
      //   33: istore_2
      //   34: aload_0
      //   35: getfield i : [Landroid/graphics/drawable/Drawable;
      //   38: astore_3
      //   39: iconst_0
      //   40: istore #4
      //   42: iload #4
      //   44: iload_2
      //   45: if_icmpge -> 73
      //   48: aload_3
      //   49: iload #4
      //   51: aaload
      //   52: invokevirtual getConstantState : ()Landroid/graphics/drawable/Drawable$ConstantState;
      //   55: ifnonnull -> 67
      //   58: aload_0
      //   59: iconst_0
      //   60: putfield y : Z
      //   63: aload_0
      //   64: monitorexit
      //   65: iconst_0
      //   66: ireturn
      //   67: iinc #4, 1
      //   70: goto -> 42
      //   73: aload_0
      //   74: iconst_1
      //   75: putfield y : Z
      //   78: aload_0
      //   79: monitorexit
      //   80: iconst_1
      //   81: ireturn
      //   82: astore_1
      //   83: aload_0
      //   84: monitorexit
      //   85: aload_1
      //   86: athrow
      // Exception table:
      //   from	to	target	type
      //   2	15	82	finally
      //   20	39	82	finally
      //   48	63	82	finally
      //   73	78	82	finally }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */