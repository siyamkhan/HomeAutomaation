package android.support.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.a.a.b;
import android.support.v4.a.a.f;
import android.support.v4.a.a.g;
import android.support.v4.g.a;
import android.support.v4.graphics.b;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  
  private g b = new g();
  
  private PorterDuffColorFilter d;
  
  private ColorFilter e;
  
  private boolean f;
  
  private boolean g = true;
  
  private Drawable.ConstantState h;
  
  private final float[] i = new float[9];
  
  private final Matrix j = new Matrix();
  
  private final Rect k = new Rect();
  
  i() {}
  
  i(g paramg) { this.d = a(this.d, paramg.c, paramg.d); }
  
  static int a(int paramInt, float paramFloat) {
    int m = Color.alpha(paramInt);
    return paramInt & 0xFFFFFF | (int)(paramFloat * m) << 24;
  }
  
  private static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 9) {
          switch (paramInt) {
            default:
              return paramMode;
            case 16:
              return PorterDuff.Mode.ADD;
            case 15:
              return PorterDuff.Mode.SCREEN;
            case 14:
              break;
          } 
          return PorterDuff.Mode.MULTIPLY;
        } 
        return PorterDuff.Mode.SRC_ATOP;
      } 
      return PorterDuff.Mode.SRC_IN;
    } 
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static i a(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 24) {
      i i1 = new i();
      i1.c = f.a(paramResources, paramInt, paramTheme);
      i1.h = new h(i1.c.getConstantState());
      return i1;
    } 
    try {
      int m;
      XmlResourceParser xmlResourceParser = paramResources.getXml(paramInt);
      AttributeSet attributeSet = Xml.asAttributeSet(xmlResourceParser);
      while (true) {
        m = xmlResourceParser.next();
        if (m != 2 && m != 1)
          continue; 
        break;
      } 
      if (m == 2)
        return a(paramResources, xmlResourceParser, attributeSet, paramTheme); 
      throw new XmlPullParserException("No start tag found");
    } catch (XmlPullParserException null) {
    
    } catch (IOException iOException) {}
    Log.e("VectorDrawableCompat", "parser error", iOException);
    return null;
  }
  
  public static i a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    i i1 = new i();
    i1.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return i1;
  }
  
  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser) {
    g g1 = this.b;
    f f1 = g1.b;
    g1.d = a(g.a(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList colorStateList = paramTypedArray.getColorStateList(1);
    if (colorStateList != null)
      g1.c = colorStateList; 
    g1.e = g.a(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, g1.e);
    f1.f = g.a(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, f1.f);
    f1.g = g.a(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, f1.g);
    if (f1.f > 0.0F) {
      if (f1.g > 0.0F) {
        f1.d = paramTypedArray.getDimension(3, f1.d);
        f1.e = paramTypedArray.getDimension(2, f1.e);
        if (f1.d > 0.0F) {
          if (f1.e > 0.0F) {
            f1.setAlpha(g.a(paramTypedArray, paramXmlPullParser, "alpha", 4, f1.getAlpha()));
            String str = paramTypedArray.getString(0);
            if (str != null) {
              f1.i = str;
              f1.k.put(str, f1);
            } 
            return;
          } 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(paramTypedArray.getPositionDescription());
          stringBuilder3.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(stringBuilder3.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramTypedArray.getPositionDescription());
        stringBuilder2.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramTypedArray.getPositionDescription());
      stringBuilder1.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTypedArray.getPositionDescription());
    stringBuilder.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private boolean a() {
    int m = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (m >= 17) {
      boolean bool1 = isAutoMirrored();
      bool = false;
      if (bool1) {
        int n = a.h(this);
        bool = false;
        if (n == 1)
          bool = true; 
      } 
    } 
    return bool;
  }
  
  private void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    g g1 = this.b;
    f f1 = g1.b;
    ArrayDeque arrayDeque = new ArrayDeque();
    arrayDeque.push(f1.c);
    int m = paramXmlPullParser.getEventType();
    int n = 1 + paramXmlPullParser.getDepth();
    boolean bool = true;
    while (m != 1 && (paramXmlPullParser.getDepth() >= n || m != 3)) {
      if (m == 2) {
        int i2;
        int i1;
        String str = paramXmlPullParser.getName();
        c c = (c)arrayDeque.peek();
        if ("path".equals(str)) {
          b b1 = new b();
          b1.a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          c.b.add(b1);
          if (b1.getPathName() != null)
            f1.k.put(b1.getPathName(), b1); 
          i1 = g1.a;
          i2 = b1.o;
          bool = false;
        } else if ("clip-path".equals(str)) {
          a a1 = new a();
          a1.a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          c.b.add(a1);
          if (a1.getPathName() != null)
            f1.k.put(a1.getPathName(), a1); 
          i1 = g1.a;
          i2 = a1.o;
        } else if ("group".equals(str)) {
          c c1 = new c();
          c1.a(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          c.b.add(c1);
          arrayDeque.push(c1);
          if (c1.getGroupName() != null)
            f1.k.put(c1.getGroupName(), c1); 
          i1 = g1.a;
          i2 = c1.e;
        } else {
          continue;
        } 
        g1.a = i2 | i1;
        continue;
      } 
      if (m == 3 && "group".equals(paramXmlPullParser.getName()))
        arrayDeque.pop(); 
      continue;
      m = paramXmlPullParser.next();
    } 
    if (!bool)
      return; 
    throw new XmlPullParserException("no path defined");
  }
  
  PorterDuffColorFilter a(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode) { return (paramColorStateList == null || paramMode == null) ? null : new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode); }
  
  Object a(String paramString) { return this.b.b.k.get(paramString); }
  
  void a(boolean paramBoolean) { this.g = paramBoolean; }
  
  public boolean canApplyTheme() {
    if (this.c != null)
      a.d(this.c); 
    return false;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.c != null) {
      this.c.draw(paramCanvas);
      return;
    } 
    copyBounds(this.k);
    if (this.k.width() > 0) {
      if (this.k.height() <= 0)
        return; 
      PorterDuffColorFilter porterDuffColorFilter = this.e;
      if (porterDuffColorFilter == null)
        porterDuffColorFilter = this.d; 
      paramCanvas.getMatrix(this.j);
      this.j.getValues(this.i);
      float f1 = Math.abs(this.i[0]);
      float f2 = Math.abs(this.i[4]);
      float f3 = Math.abs(this.i[1]);
      float f4 = Math.abs(this.i[3]);
      if (f3 != 0.0F || f4 != 0.0F) {
        f1 = 1.0F;
        f2 = 1.0F;
      } 
      int m = (int)(f1 * this.k.width());
      int n = (int)(f2 * this.k.height());
      int i1 = Math.min(2048, m);
      int i2 = Math.min(2048, n);
      if (i1 > 0) {
        if (i2 <= 0)
          return; 
        int i3 = paramCanvas.save();
        paramCanvas.translate(this.k.left, this.k.top);
        if (a()) {
          paramCanvas.translate(this.k.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        } 
        this.k.offsetTo(0, 0);
        this.b.b(i1, i2);
        if (!this.g) {
          this.b.a(i1, i2);
        } else if (!this.b.b()) {
          this.b.a(i1, i2);
          this.b.c();
        } 
        this.b.a(paramCanvas, porterDuffColorFilter, this.k);
        paramCanvas.restoreToCount(i3);
      } 
    } 
  }
  
  public int getAlpha() { return (this.c != null) ? a.c(this.c) : this.b.b.getRootAlpha(); }
  
  public int getChangingConfigurations() { return (this.c != null) ? this.c.getChangingConfigurations() : (super.getChangingConfigurations() | this.b.getChangingConfigurations()); }
  
  public Drawable.ConstantState getConstantState() {
    if (this.c != null && Build.VERSION.SDK_INT >= 24)
      return new h(this.c.getConstantState()); 
    this.b.a = getChangingConfigurations();
    return this.b;
  }
  
  public int getIntrinsicHeight() { return (this.c != null) ? this.c.getIntrinsicHeight() : (int)this.b.b.e; }
  
  public int getIntrinsicWidth() { return (this.c != null) ? this.c.getIntrinsicWidth() : (int)this.b.b.d; }
  
  public int getOpacity() { return (this.c != null) ? this.c.getOpacity() : -3; }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {
    if (this.c != null) {
      this.c.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    } 
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    if (this.c != null) {
      a.a(this.c, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    g g1 = this.b;
    g1.b = new f();
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.a);
    a(typedArray, paramXmlPullParser);
    typedArray.recycle();
    g1.a = getChangingConfigurations();
    g1.k = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.d = a(this.d, g1.c, g1.d);
  }
  
  public void invalidateSelf() {
    if (this.c != null) {
      this.c.invalidateSelf();
      return;
    } 
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored() { return (this.c != null) ? a.b(this.c) : this.b.e; }
  
  public boolean isStateful() {
    if (this.c != null)
      return this.c.isStateful(); 
    if (!super.isStateful()) {
      g g1 = this.b;
      if (g1 == null || (!g1.d() && (this.b.c == null || !this.b.c.isStateful())))
        return false; 
    } 
    return true;
  }
  
  public Drawable mutate() {
    if (this.c != null) {
      this.c.mutate();
      return this;
    } 
    if (!this.f && super.mutate() == this) {
      this.b = new g(this.b);
      this.f = true;
    } 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    if (this.c != null)
      this.c.setBounds(paramRect); 
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    if (this.c != null)
      return this.c.setState(paramArrayOfInt); 
    g g1 = this.b;
    ColorStateList colorStateList = g1.c;
    boolean bool = false;
    if (colorStateList != null) {
      PorterDuff.Mode mode = g1.d;
      bool = false;
      if (mode != null) {
        this.d = a(this.d, g1.c, g1.d);
        invalidateSelf();
        bool = true;
      } 
    } 
    if (g1.d() && g1.a(paramArrayOfInt)) {
      invalidateSelf();
      bool = true;
    } 
    return bool;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong) {
    if (this.c != null) {
      this.c.scheduleSelf(paramRunnable, paramLong);
      return;
    } 
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {
    if (this.c != null) {
      this.c.setAlpha(paramInt);
      return;
    } 
    if (this.b.b.getRootAlpha() != paramInt) {
      this.b.b.setRootAlpha(paramInt);
      invalidateSelf();
    } 
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    if (this.c != null) {
      a.a(this.c, paramBoolean);
      return;
    } 
    this.b.e = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.c != null) {
      this.c.setColorFilter(paramColorFilter);
      return;
    } 
    this.e = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt) {
    if (this.c != null) {
      a.a(this.c, paramInt);
      return;
    } 
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (this.c != null) {
      a.a(this.c, paramColorStateList);
      return;
    } 
    g g1 = this.b;
    if (g1.c != paramColorStateList) {
      g1.c = paramColorStateList;
      this.d = a(this.d, paramColorStateList, g1.d);
      invalidateSelf();
    } 
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.c != null) {
      a.a(this.c, paramMode);
      return;
    } 
    g g1 = this.b;
    if (g1.d != paramMode) {
      g1.d = paramMode;
      this.d = a(this.d, g1.c, paramMode);
      invalidateSelf();
    } 
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) { return (this.c != null) ? this.c.setVisible(paramBoolean1, paramBoolean2) : super.setVisible(paramBoolean1, paramBoolean2); }
  
  public void unscheduleSelf(Runnable paramRunnable) {
    if (this.c != null) {
      this.c.unscheduleSelf(paramRunnable);
      return;
    } 
    super.unscheduleSelf(paramRunnable);
  }
  
  private static class a extends e {
    public a() {}
    
    public a(a param1a) { super(param1a); }
    
    private void a(TypedArray param1TypedArray) {
      String str1 = param1TypedArray.getString(0);
      if (str1 != null)
        this.n = str1; 
      String str2 = param1TypedArray.getString(1);
      if (str2 != null)
        this.m = b.b(str2); 
    }
    
    public void a(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      if (!g.a(param1XmlPullParser, "pathData"))
        return; 
      TypedArray typedArray = g.a(param1Resources, param1Theme, param1AttributeSet, a.d);
      a(typedArray);
      typedArray.recycle();
    }
    
    public boolean a() { return true; }
  }
  
  private static class b extends e {
    b a;
    
    float b = 0.0F;
    
    b c;
    
    float d = 1.0F;
    
    int e = 0;
    
    float f = 1.0F;
    
    float g = 0.0F;
    
    float h = 1.0F;
    
    float i = 0.0F;
    
    Paint.Cap j = Paint.Cap.BUTT;
    
    Paint.Join k = Paint.Join.MITER;
    
    float l = 4.0F;
    
    private int[] p;
    
    public b() {}
    
    public b(b param1b) {
      super(param1b);
      this.p = param1b.p;
      this.a = param1b.a;
      this.b = param1b.b;
      this.d = param1b.d;
      this.c = param1b.c;
      this.e = param1b.e;
      this.f = param1b.f;
      this.g = param1b.g;
      this.h = param1b.h;
      this.i = param1b.i;
      this.j = param1b.j;
      this.k = param1b.k;
      this.l = param1b.l;
    }
    
    private Paint.Cap a(int param1Int, Paint.Cap param1Cap) {
      switch (param1Int) {
        default:
          return param1Cap;
        case 2:
          return Paint.Cap.SQUARE;
        case 1:
          return Paint.Cap.ROUND;
        case 0:
          break;
      } 
      return Paint.Cap.BUTT;
    }
    
    private Paint.Join a(int param1Int, Paint.Join param1Join) {
      switch (param1Int) {
        default:
          return param1Join;
        case 2:
          return Paint.Join.BEVEL;
        case 1:
          return Paint.Join.ROUND;
        case 0:
          break;
      } 
      return Paint.Join.MITER;
    }
    
    private void a(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser, Resources.Theme param1Theme) {
      this.p = null;
      if (!g.a(param1XmlPullParser, "pathData"))
        return; 
      String str1 = param1TypedArray.getString(0);
      if (str1 != null)
        this.n = str1; 
      String str2 = param1TypedArray.getString(2);
      if (str2 != null)
        this.m = b.b(str2); 
      this.c = g.a(param1TypedArray, param1XmlPullParser, param1Theme, "fillColor", 1, 0);
      this.f = g.a(param1TypedArray, param1XmlPullParser, "fillAlpha", 12, this.f);
      this.j = a(g.a(param1TypedArray, param1XmlPullParser, "strokeLineCap", 8, -1), this.j);
      this.k = a(g.a(param1TypedArray, param1XmlPullParser, "strokeLineJoin", 9, -1), this.k);
      this.l = g.a(param1TypedArray, param1XmlPullParser, "strokeMiterLimit", 10, this.l);
      this.a = g.a(param1TypedArray, param1XmlPullParser, param1Theme, "strokeColor", 3, 0);
      this.d = g.a(param1TypedArray, param1XmlPullParser, "strokeAlpha", 11, this.d);
      this.b = g.a(param1TypedArray, param1XmlPullParser, "strokeWidth", 4, this.b);
      this.h = g.a(param1TypedArray, param1XmlPullParser, "trimPathEnd", 6, this.h);
      this.i = g.a(param1TypedArray, param1XmlPullParser, "trimPathOffset", 7, this.i);
      this.g = g.a(param1TypedArray, param1XmlPullParser, "trimPathStart", 5, this.g);
      this.e = g.a(param1TypedArray, param1XmlPullParser, "fillType", 13, this.e);
    }
    
    public void a(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      TypedArray typedArray = g.a(param1Resources, param1Theme, param1AttributeSet, a.c);
      a(typedArray, param1XmlPullParser, param1Theme);
      typedArray.recycle();
    }
    
    public boolean a(int[] param1ArrayOfInt) { return this.c.a(param1ArrayOfInt) | this.a.a(param1ArrayOfInt); }
    
    public boolean b() { return (this.c.d() || this.a.d()); }
    
    float getFillAlpha() { return this.f; }
    
    int getFillColor() { return this.c.b(); }
    
    float getStrokeAlpha() { return this.d; }
    
    int getStrokeColor() { return this.a.b(); }
    
    float getStrokeWidth() { return this.b; }
    
    float getTrimPathEnd() { return this.h; }
    
    float getTrimPathOffset() { return this.i; }
    
    float getTrimPathStart() { return this.g; }
    
    void setFillAlpha(float param1Float) { this.f = param1Float; }
    
    void setFillColor(int param1Int) { this.c.b(param1Int); }
    
    void setStrokeAlpha(float param1Float) { this.d = param1Float; }
    
    void setStrokeColor(int param1Int) { this.a.b(param1Int); }
    
    void setStrokeWidth(float param1Float) { this.b = param1Float; }
    
    void setTrimPathEnd(float param1Float) { this.h = param1Float; }
    
    void setTrimPathOffset(float param1Float) { this.i = param1Float; }
    
    void setTrimPathStart(float param1Float) { this.g = param1Float; }
  }
  
  private static class c extends d {
    final Matrix a = new Matrix();
    
    final ArrayList<i.d> b = new ArrayList();
    
    float c = 0.0F;
    
    final Matrix d = new Matrix();
    
    int e;
    
    private float f = 0.0F;
    
    private float g = 0.0F;
    
    private float h = 1.0F;
    
    private float i = 1.0F;
    
    private float j = 0.0F;
    
    private float k = 0.0F;
    
    private int[] l;
    
    private String m = null;
    
    public c() { super(null); }
    
    public c(c param1c, a<String, Object> param1a) {
      super(null);
      this.c = param1c.c;
      this.f = param1c.f;
      this.g = param1c.g;
      this.h = param1c.h;
      this.i = param1c.i;
      this.j = param1c.j;
      this.k = param1c.k;
      this.l = param1c.l;
      this.m = param1c.m;
      this.e = param1c.e;
      String str = this.m;
      if (str != null)
        param1a.put(str, this); 
      this.d.set(param1c.d);
      ArrayList arrayList = param1c.b;
      for (byte b1 = 0; b1 < arrayList.size(); b1++) {
        Object object = arrayList.get(b1);
        if (object instanceof c) {
          c c1 = (c)object;
          this.b.add(new c(c1, param1a));
        } else {
          i.a a1;
          if (object instanceof i.b) {
            a1 = new i.b((i.b)object);
          } else if (object instanceof i.a) {
            a1 = new i.a((i.a)object);
          } else {
            throw new IllegalStateException("Unknown object in the tree!");
          } 
          this.b.add(a1);
          if (a1.n != null)
            param1a.put(a1.n, a1); 
        } 
      } 
    }
    
    private void a() {
      this.d.reset();
      this.d.postTranslate(-this.f, -this.g);
      this.d.postScale(this.h, this.i);
      this.d.postRotate(this.c, 0.0F, 0.0F);
      this.d.postTranslate(this.j + this.f, this.k + this.g);
    }
    
    private void a(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser) {
      this.l = null;
      this.c = g.a(param1TypedArray, param1XmlPullParser, "rotation", 5, this.c);
      this.f = param1TypedArray.getFloat(1, this.f);
      this.g = param1TypedArray.getFloat(2, this.g);
      this.h = g.a(param1TypedArray, param1XmlPullParser, "scaleX", 3, this.h);
      this.i = g.a(param1TypedArray, param1XmlPullParser, "scaleY", 4, this.i);
      this.j = g.a(param1TypedArray, param1XmlPullParser, "translateX", 6, this.j);
      this.k = g.a(param1TypedArray, param1XmlPullParser, "translateY", 7, this.k);
      String str = param1TypedArray.getString(0);
      if (str != null)
        this.m = str; 
      a();
    }
    
    public void a(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      TypedArray typedArray = g.a(param1Resources, param1Theme, param1AttributeSet, a.b);
      a(typedArray, param1XmlPullParser);
      typedArray.recycle();
    }
    
    public boolean a(int[] param1ArrayOfInt) {
      byte b1 = 0;
      boolean bool = false;
      while (b1 < this.b.size()) {
        bool |= ((i.d)this.b.get(b1)).a(param1ArrayOfInt);
        b1++;
      } 
      return bool;
    }
    
    public boolean b() {
      for (byte b1 = 0; b1 < this.b.size(); b1++) {
        if (((i.d)this.b.get(b1)).b())
          return true; 
      } 
      return false;
    }
    
    public String getGroupName() { return this.m; }
    
    public Matrix getLocalMatrix() { return this.d; }
    
    public float getPivotX() { return this.f; }
    
    public float getPivotY() { return this.g; }
    
    public float getRotation() { return this.c; }
    
    public float getScaleX() { return this.h; }
    
    public float getScaleY() { return this.i; }
    
    public float getTranslateX() { return this.j; }
    
    public float getTranslateY() { return this.k; }
    
    public void setPivotX(float param1Float) {
      if (param1Float != this.f) {
        this.f = param1Float;
        a();
      } 
    }
    
    public void setPivotY(float param1Float) {
      if (param1Float != this.g) {
        this.g = param1Float;
        a();
      } 
    }
    
    public void setRotation(float param1Float) {
      if (param1Float != this.c) {
        this.c = param1Float;
        a();
      } 
    }
    
    public void setScaleX(float param1Float) {
      if (param1Float != this.h) {
        this.h = param1Float;
        a();
      } 
    }
    
    public void setScaleY(float param1Float) {
      if (param1Float != this.i) {
        this.i = param1Float;
        a();
      } 
    }
    
    public void setTranslateX(float param1Float) {
      if (param1Float != this.j) {
        this.j = param1Float;
        a();
      } 
    }
    
    public void setTranslateY(float param1Float) {
      if (param1Float != this.k) {
        this.k = param1Float;
        a();
      } 
    }
  }
  
  private static abstract class d {
    private d() {}
    
    public boolean a(int[] param1ArrayOfInt) { return false; }
    
    public boolean b() { return false; }
  }
  
  private static abstract class e extends d {
    protected b.b[] m = null;
    
    String n;
    
    int o;
    
    public e() { super(null); }
    
    public e(e param1e) {
      super(null);
      this.n = param1e.n;
      this.o = param1e.o;
      this.m = b.a(param1e.m);
    }
    
    public void a(Path param1Path) {
      param1Path.reset();
      b.b[] arrayOfb = this.m;
      if (arrayOfb != null)
        b.b.a(arrayOfb, param1Path); 
    }
    
    public boolean a() { return false; }
    
    public b.b[] getPathData() { return this.m; }
    
    public String getPathName() { return this.n; }
    
    public void setPathData(b.b[] param1ArrayOfb) {
      if (!b.a(this.m, param1ArrayOfb)) {
        this.m = b.a(param1ArrayOfb);
        return;
      } 
      b.b(this.m, param1ArrayOfb);
    }
  }
  
  private static class f {
    private static final Matrix n = new Matrix();
    
    Paint a;
    
    Paint b;
    
    final i.c c = new i.c();
    
    float d = 0.0F;
    
    float e = 0.0F;
    
    float f = 0.0F;
    
    float g = 0.0F;
    
    int h = 255;
    
    String i = null;
    
    Boolean j = null;
    
    final a<String, Object> k = new a();
    
    private final Path l = new Path();
    
    private final Path m = new Path();
    
    private final Matrix o = new Matrix();
    
    private PathMeasure p;
    
    private int q;
    
    public f() {}
    
    public f(f param1f) {
      this.d = param1f.d;
      this.e = param1f.e;
      this.f = param1f.f;
      this.g = param1f.g;
      this.q = param1f.q;
      this.h = param1f.h;
      this.i = param1f.i;
      String str = param1f.i;
      if (str != null)
        this.k.put(str, this); 
      this.j = param1f.j;
    }
    
    private static float a(float param1Float1, float param1Float2, float param1Float3, float param1Float4) { return param1Float1 * param1Float4 - param1Float2 * param1Float3; }
    
    private float a(Matrix param1Matrix) {
      float[] arrayOfFloat = { 0.0F, 1.0F, 1.0F, 0.0F };
      param1Matrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f2 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f3 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      float f4 = Math.max(f1, f2);
      int i1 = f4 cmp 0.0F;
      float f5 = 0.0F;
      if (i1 > 0)
        f5 = Math.abs(f3) / f4; 
      return f5;
    }
    
    private void a(i.c param1c, Matrix param1Matrix, Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      param1c.a.set(param1Matrix);
      param1c.a.preConcat(param1c.d);
      param1Canvas.save();
      for (byte b1 = 0; b1 < param1c.b.size(); b1++) {
        i.d d1 = (i.d)param1c.b.get(b1);
        if (d1 instanceof i.c) {
          a((i.c)d1, param1c.a, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
        } else if (d1 instanceof i.e) {
          a(param1c, (i.e)d1, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
        } 
      } 
      param1Canvas.restore();
    }
    
    private void a(i.c param1c, i.e param1e, Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      float f1 = param1Int1 / this.f;
      float f2 = param1Int2 / this.g;
      float f3 = Math.min(f1, f2);
      Matrix matrix = param1c.a;
      this.o.set(matrix);
      this.o.postScale(f1, f2);
      float f4 = a(matrix);
      if (f4 == 0.0F)
        return; 
      param1e.a(this.l);
      Path path = this.l;
      this.m.reset();
      if (param1e.a()) {
        this.m.addPath(path, this.o);
        param1Canvas.clipPath(this.m);
        return;
      } 
      i.b b1 = (i.b)param1e;
      if (b1.g != 0.0F || b1.h != 1.0F) {
        float f5 = (b1.g + b1.i) % 1.0F;
        float f6 = (b1.h + b1.i) % 1.0F;
        if (this.p == null)
          this.p = new PathMeasure(); 
        this.p.setPath(this.l, false);
        float f7 = this.p.getLength();
        float f8 = f5 * f7;
        float f9 = f6 * f7;
        path.reset();
        if (f8 > f9) {
          this.p.getSegment(f8, f7, path, true);
          this.p.getSegment(0.0F, f9, path, true);
        } else {
          this.p.getSegment(f8, f9, path, true);
        } 
        path.rLineTo(0.0F, 0.0F);
      } 
      this.m.addPath(path, this.o);
      if (b1.c.e()) {
        Path.FillType fillType;
        b b2 = b1.c;
        if (this.b == null) {
          this.b = new Paint(1);
          this.b.setStyle(Paint.Style.FILL);
        } 
        Paint paint = this.b;
        if (b2.c()) {
          Shader shader = b2.a();
          shader.setLocalMatrix(this.o);
          paint.setShader(shader);
          paint.setAlpha(Math.round(255.0F * b1.f));
        } else {
          paint.setColor(i.a(b2.b(), b1.f));
        } 
        paint.setColorFilter(param1ColorFilter);
        Path path1 = this.m;
        if (b1.e == 0) {
          fillType = Path.FillType.WINDING;
        } else {
          fillType = Path.FillType.EVEN_ODD;
        } 
        path1.setFillType(fillType);
        param1Canvas.drawPath(this.m, paint);
      } 
      if (b1.a.e()) {
        b b2 = b1.a;
        if (this.a == null) {
          this.a = new Paint(1);
          this.a.setStyle(Paint.Style.STROKE);
        } 
        Paint paint = this.a;
        if (b1.k != null)
          paint.setStrokeJoin(b1.k); 
        if (b1.j != null)
          paint.setStrokeCap(b1.j); 
        paint.setStrokeMiter(b1.l);
        if (b2.c()) {
          Shader shader = b2.a();
          shader.setLocalMatrix(this.o);
          paint.setShader(shader);
          paint.setAlpha(Math.round(255.0F * b1.d));
        } else {
          paint.setColor(i.a(b2.b(), b1.d));
        } 
        paint.setColorFilter(param1ColorFilter);
        paint.setStrokeWidth(f3 * f4 * b1.b);
        param1Canvas.drawPath(this.m, paint);
      } 
    }
    
    public void a(Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) { a(this.c, n, param1Canvas, param1Int1, param1Int2, param1ColorFilter); }
    
    public boolean a() {
      if (this.j == null)
        this.j = Boolean.valueOf(this.c.b()); 
      return this.j.booleanValue();
    }
    
    public boolean a(int[] param1ArrayOfInt) { return this.c.a(param1ArrayOfInt); }
    
    public float getAlpha() { return getRootAlpha() / 255.0F; }
    
    public int getRootAlpha() { return this.h; }
    
    public void setAlpha(float param1Float) { setRootAlpha((int)(param1Float * 255.0F)); }
    
    public void setRootAlpha(int param1Int) { this.h = param1Int; }
  }
  
  private static class g extends Drawable.ConstantState {
    int a;
    
    i.f b;
    
    ColorStateList c = null;
    
    PorterDuff.Mode d = i.a;
    
    boolean e;
    
    Bitmap f;
    
    ColorStateList g;
    
    PorterDuff.Mode h;
    
    int i;
    
    boolean j;
    
    boolean k;
    
    Paint l;
    
    public g() { this.b = new i.f(); }
    
    public g(g param1g) {
      if (param1g != null) {
        this.a = param1g.a;
        this.b = new i.f(param1g.b);
        if (param1g.b.b != null)
          this.b.b = new Paint(param1g.b.b); 
        if (param1g.b.a != null)
          this.b.a = new Paint(param1g.b.a); 
        this.c = param1g.c;
        this.d = param1g.d;
        this.e = param1g.e;
      } 
    }
    
    public Paint a(ColorFilter param1ColorFilter) {
      if (!a() && param1ColorFilter == null)
        return null; 
      if (this.l == null) {
        this.l = new Paint();
        this.l.setFilterBitmap(true);
      } 
      this.l.setAlpha(this.b.getRootAlpha());
      this.l.setColorFilter(param1ColorFilter);
      return this.l;
    }
    
    public void a(int param1Int1, int param1Int2) {
      this.f.eraseColor(0);
      Canvas canvas = new Canvas(this.f);
      this.b.a(canvas, param1Int1, param1Int2, null);
    }
    
    public void a(Canvas param1Canvas, ColorFilter param1ColorFilter, Rect param1Rect) {
      Paint paint = a(param1ColorFilter);
      param1Canvas.drawBitmap(this.f, null, param1Rect, paint);
    }
    
    public boolean a() { return (this.b.getRootAlpha() < 255); }
    
    public boolean a(int[] param1ArrayOfInt) {
      boolean bool = this.b.a(param1ArrayOfInt);
      this.k = bool | this.k;
      return bool;
    }
    
    public void b(int param1Int1, int param1Int2) {
      if (this.f == null || !c(param1Int1, param1Int2)) {
        this.f = Bitmap.createBitmap(param1Int1, param1Int2, Bitmap.Config.ARGB_8888);
        this.k = true;
      } 
    }
    
    public boolean b() { return (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha()); }
    
    public void c() {
      this.g = this.c;
      this.h = this.d;
      this.i = this.b.getRootAlpha();
      this.j = this.e;
      this.k = false;
    }
    
    public boolean c(int param1Int1, int param1Int2) { return (param1Int1 == this.f.getWidth() && param1Int2 == this.f.getHeight()); }
    
    public boolean d() { return this.b.a(); }
    
    public int getChangingConfigurations() { return this.a; }
    
    public Drawable newDrawable() { return new i(this); }
    
    public Drawable newDrawable(Resources param1Resources) { return new i(this); }
  }
  
  private static class h extends Drawable.ConstantState {
    private final Drawable.ConstantState a;
    
    public h(Drawable.ConstantState param1ConstantState) { this.a = param1ConstantState; }
    
    public boolean canApplyTheme() { return this.a.canApplyTheme(); }
    
    public int getChangingConfigurations() { return this.a.getChangingConfigurations(); }
    
    public Drawable newDrawable() {
      i i = new i();
      i.c = (VectorDrawable)this.a.newDrawable();
      return i;
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      i i = new i();
      i.c = (VectorDrawable)this.a.newDrawable(param1Resources);
      return i;
    }
    
    public Drawable newDrawable(Resources param1Resources, Resources.Theme param1Theme) {
      i i = new i();
      i.c = (VectorDrawable)this.a.newDrawable(param1Resources, param1Theme);
      return i;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\d\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */