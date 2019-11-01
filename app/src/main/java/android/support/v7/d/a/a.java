package android.support.v7.d.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.d.a.c;
import android.support.d.a.i;
import android.support.v4.a.a.g;
import android.support.v4.g.f;
import android.support.v4.g.m;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends d {
  private static final String a = "a";
  
  private b b;
  
  private f c;
  
  private int d = -1;
  
  private int e = -1;
  
  private boolean f;
  
  static  {
  
  }
  
  public a() { this(null, null); }
  
  a(b paramb, Resources paramResources) {
    super(null);
    a(new b(paramb, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  public static a a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    String str = paramXmlPullParser.getName();
    if (str.equals("animated-selector")) {
      a a1 = new a();
      a1.b(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return a1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": invalid animated-selector tag ");
    stringBuilder.append(str);
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private void a(TypedArray paramTypedArray) {
    b b1 = this.b;
    if (Build.VERSION.SDK_INT >= 21)
      b1.f |= paramTypedArray.getChangingConfigurations(); 
    b1.a(paramTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_variablePadding, b1.k));
    b1.b(paramTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_constantSize, b1.n));
    b1.c(paramTypedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, b1.C));
    b1.d(paramTypedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, b1.D));
    setDither(paramTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_dither, b1.z));
  }
  
  private boolean b(int paramInt) {
    int i;
    f f1 = this.c;
    if (f1 != null) {
      if (paramInt == this.d)
        return true; 
      if (paramInt == this.e && f1.c()) {
        f1.d();
        this.d = this.e;
        this.e = paramInt;
        return true;
      } 
      i = this.d;
      f1.b();
    } else {
      i = d();
    } 
    this.c = null;
    this.e = -1;
    this.d = -1;
    b b1 = this.b;
    int j = b1.a(i);
    int k = b1.a(paramInt);
    if (k != 0) {
      a a1;
      if (j == 0)
        return false; 
      int m = b1.a(j, k);
      if (m < 0)
        return false; 
      boolean bool = b1.c(j, k);
      a(m);
      Drawable drawable = getCurrent();
      if (drawable instanceof AnimationDrawable) {
        boolean bool1 = b1.b(j, k);
        a1 = new d((AnimationDrawable)drawable, bool1, bool);
      } else if (drawable instanceof c) {
        a1 = new c((c)drawable);
      } else {
        if (drawable instanceof Animatable) {
          a1 = new a((Animatable)drawable);
          a1.a();
          this.c = a1;
          this.e = i;
          this.d = paramInt;
          return true;
        } 
        return false;
      } 
      a1.a();
      this.c = a1;
      this.e = i;
      this.d = paramInt;
      return true;
    } 
    return false;
  }
  
  private void c(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    int i = 1 + paramXmlPullParser.getDepth();
    while (true) {
      int j = paramXmlPullParser.next();
      if (j != 1) {
        int k = paramXmlPullParser.getDepth();
        if (k >= i || j != 3) {
          if (j != 2 || k > i)
            continue; 
          if (paramXmlPullParser.getName().equals("item")) {
            e(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            continue;
          } 
          if (paramXmlPullParser.getName().equals("transition"))
            d(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme); 
          continue;
        } 
      } 
      break;
    } 
  }
  
  private int d(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    Drawable drawable;
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableTransition);
    int i = typedArray.getResourceId(a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
    int j = typedArray.getResourceId(a.j.AnimatedStateListDrawableTransition_android_toId, -1);
    int k = typedArray.getResourceId(a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
    if (k > 0) {
      drawable = a.b(paramContext, k);
    } else {
      drawable = null;
    } 
    boolean bool = typedArray.getBoolean(a.j.AnimatedStateListDrawableTransition_android_reversible, false);
    typedArray.recycle();
    if (drawable == null) {
      int m;
      while (true) {
        m = paramXmlPullParser.next();
        if (m == 4)
          continue; 
        break;
      } 
      if (m == 2) {
        if (paramXmlPullParser.getName().equals("animated-vector")) {
          drawable = c.a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else if (Build.VERSION.SDK_INT >= 21) {
          Drawable drawable1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else {
          drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramXmlPullParser.getPositionDescription());
        stringBuilder1.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(stringBuilder1.toString());
      } 
    } 
    if (drawable != null) {
      if (i != -1 && j != -1)
        return this.b.a(i, j, drawable, bool); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramXmlPullParser.getPositionDescription());
      stringBuilder1.append(": <transition> tag requires 'fromId' & 'toId' attributes");
      throw new XmlPullParserException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private int e(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    Drawable drawable;
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableItem);
    int i = typedArray.getResourceId(a.j.AnimatedStateListDrawableItem_android_id, 0);
    int j = typedArray.getResourceId(a.j.AnimatedStateListDrawableItem_android_drawable, -1);
    if (j > 0) {
      drawable = a.b(paramContext, j);
    } else {
      drawable = null;
    } 
    typedArray.recycle();
    int[] arrayOfInt = a(paramAttributeSet);
    if (drawable == null) {
      int k;
      while (true) {
        k = paramXmlPullParser.next();
        if (k == 4)
          continue; 
        break;
      } 
      if (k == 2) {
        if (paramXmlPullParser.getName().equals("vector")) {
          drawable = i.a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else if (Build.VERSION.SDK_INT >= 21) {
          Drawable drawable1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else {
          drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramXmlPullParser.getPositionDescription());
        stringBuilder1.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(stringBuilder1.toString());
      } 
    } 
    if (drawable != null)
      return this.b.a(arrayOfInt, drawable, i); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private void e() { onStateChange(getState()); }
  
  b a() { return new b(this.b, this, null); }
  
  protected void a(b.b paramb) {
    super.a(paramb);
    if (paramb instanceof b)
      this.b = (b)paramb; 
  }
  
  public void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableCompat);
    setVisible(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
    a(typedArray);
    a(paramResources);
    typedArray.recycle();
    c(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    e();
  }
  
  public boolean isStateful() { return true; }
  
  public void jumpToCurrentState() {
    super.jumpToCurrentState();
    f f1 = this.c;
    if (f1 != null) {
      f1.b();
      this.c = null;
      a(this.d);
      this.d = -1;
      this.e = -1;
    } 
  }
  
  public Drawable mutate() {
    if (!this.f && super.mutate() == this) {
      this.b.a();
      this.f = true;
    } 
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    boolean bool;
    int i = this.b.a(paramArrayOfInt);
    if (i != d() && (b(i) || a(i))) {
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable = getCurrent();
    if (drawable != null)
      bool |= drawable.setState(paramArrayOfInt); 
    return bool;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.c != null && (bool || paramBoolean2)) {
      if (paramBoolean1) {
        this.c.a();
        return bool;
      } 
      jumpToCurrentState();
    } 
    return bool;
  }
  
  private static class a extends f {
    private final Animatable a;
    
    a(Animatable param1Animatable) {
      super(null);
      this.a = param1Animatable;
    }
    
    public void a() { this.a.start(); }
    
    public void b() { this.a.stop(); }
  }
  
  static class b extends d.a {
    f<Long> a;
    
    m<Integer> b;
    
    b(b param1b, a param1a, Resources param1Resources) {
      super(param1b, param1a, param1Resources);
      if (param1b != null) {
        this.a = param1b.a;
        m1 = param1b.b;
      } else {
        this.a = new f();
        m1 = new m();
      } 
      this.b = m1;
    }
    
    private static long f(int param1Int1, int param1Int2) { return param1Int1 << 32 | param1Int2; }
    
    int a(int param1Int) { return (param1Int < 0) ? 0 : ((Integer)this.b.a(param1Int, Integer.valueOf(0))).intValue(); }
    
    int a(int param1Int1, int param1Int2) {
      long l = f(param1Int1, param1Int2);
      return (int)((Long)this.a.a(l, Long.valueOf(-1L))).longValue();
    }
    
    int a(int param1Int1, int param1Int2, Drawable param1Drawable, boolean param1Boolean) {
      long l2;
      int i = a(param1Drawable);
      long l1 = f(param1Int1, param1Int2);
      if (param1Boolean) {
        l2 = 8589934592L;
      } else {
        l2 = 0L;
      } 
      f f1 = this.a;
      long l3 = i;
      f1.c(l1, Long.valueOf(l3 | l2));
      if (param1Boolean) {
        long l = f(param1Int2, param1Int1);
        this.a.c(l, Long.valueOf(l2 | 0x100000000L | l3));
      } 
      return i;
    }
    
    int a(int[] param1ArrayOfInt) {
      int i = b(param1ArrayOfInt);
      return (i >= 0) ? i : b(StateSet.WILD_CARD);
    }
    
    int a(int[] param1ArrayOfInt, Drawable param1Drawable, int param1Int) {
      int i = a(param1ArrayOfInt, param1Drawable);
      this.b.b(i, Integer.valueOf(param1Int));
      return i;
    }
    
    void a() {
      this.a = this.a.a();
      this.b = this.b.a();
    }
    
    boolean b(int param1Int1, int param1Int2) {
      long l = f(param1Int1, param1Int2);
      return ((0x100000000L & ((Long)this.a.a(l, Long.valueOf(-1L))).longValue()) != 0L);
    }
    
    boolean c(int param1Int1, int param1Int2) {
      long l = f(param1Int1, param1Int2);
      return ((0x200000000L & ((Long)this.a.a(l, Long.valueOf(-1L))).longValue()) != 0L);
    }
    
    public Drawable newDrawable() { return new a(this, null); }
    
    public Drawable newDrawable(Resources param1Resources) { return new a(this, param1Resources); }
  }
  
  private static class c extends f {
    private final c a;
    
    c(c param1c) {
      super(null);
      this.a = param1c;
    }
    
    public void a() { this.a.start(); }
    
    public void b() { this.a.stop(); }
  }
  
  private static class d extends f {
    private final ObjectAnimator a;
    
    private final boolean b;
    
    d(AnimationDrawable param1AnimationDrawable, boolean param1Boolean1, boolean param1Boolean2) {
      super(null);
      int i = param1AnimationDrawable.getNumberOfFrames();
      if (param1Boolean1) {
        bool = i - 1;
      } else {
        bool = false;
      } 
      if (param1Boolean1) {
        j = 0;
      } else {
        j = i - 1;
      } 
      a.e e = new a.e(param1AnimationDrawable, param1Boolean1);
      ObjectAnimator objectAnimator = ObjectAnimator.ofInt(param1AnimationDrawable, "currentIndex", new int[] { bool, j });
      if (Build.VERSION.SDK_INT >= 18)
        objectAnimator.setAutoCancel(true); 
      objectAnimator.setDuration(e.a());
      objectAnimator.setInterpolator(e);
      this.b = param1Boolean2;
      this.a = objectAnimator;
    }
    
    public void a() { this.a.start(); }
    
    public void b() { this.a.cancel(); }
    
    public boolean c() { return this.b; }
    
    public void d() { this.a.reverse(); }
  }
  
  private static class e implements TimeInterpolator {
    private int[] a;
    
    private int b;
    
    private int c;
    
    e(AnimationDrawable param1AnimationDrawable, boolean param1Boolean) { a(param1AnimationDrawable, param1Boolean); }
    
    int a() { return this.c; }
    
    int a(AnimationDrawable param1AnimationDrawable, boolean param1Boolean) {
      int i = param1AnimationDrawable.getNumberOfFrames();
      this.b = i;
      int[] arrayOfInt1 = this.a;
      if (arrayOfInt1 == null || arrayOfInt1.length < i)
        this.a = new int[i]; 
      int[] arrayOfInt2 = this.a;
      int j = 0;
      int k = 0;
      while (j < i) {
        int m;
        if (param1Boolean) {
          m = -1 + i - j;
        } else {
          m = j;
        } 
        int n = param1AnimationDrawable.getDuration(m);
        arrayOfInt2[j] = n;
        k += n;
        j++;
      } 
      this.c = k;
      return k;
    }
    
    public float getInterpolation(float param1Float) {
      float f;
      int i = (int)(0.5F + param1Float * this.c);
      int j = this.b;
      int[] arrayOfInt = this.a;
      byte b1;
      for (b1 = 0; b1 < j && i >= arrayOfInt[b1]; b1++)
        i -= arrayOfInt[b1]; 
      if (b1 < j) {
        f = i / this.c;
      } else {
        f = 0.0F;
      } 
      return f + b1 / j;
    }
  }
  
  private static abstract class f {
    private f() {}
    
    public abstract void a();
    
    public abstract void b();
    
    public boolean c() { return false; }
    
    public void d() {}
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */