package android.support.design.c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.k;
import android.view.View;

public class c {
  public static final int a;
  
  private final a b;
  
  private final View c;
  
  private final Path d;
  
  private final Paint e;
  
  private final Paint f;
  
  private d.d g;
  
  private Drawable h;
  
  private boolean i;
  
  private boolean j;
  
  static  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else if (Build.VERSION.SDK_INT >= 18) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
  
  private float b(d.d paramd) { return k.a(paramd.a, paramd.b, 0.0F, 0.0F, this.c.getWidth(), this.c.getHeight()); }
  
  private void b(Canvas paramCanvas) {
    if (j()) {
      Rect rect = this.h.getBounds();
      float f1 = this.g.a - rect.width() / 2.0F;
      float f2 = this.g.b - rect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.h.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    } 
  }
  
  private void g() {
    if (a == 1) {
      this.d.rewind();
      d.d d1 = this.g;
      if (d1 != null)
        this.d.addCircle(d1.a, this.g.b, this.g.c, Path.Direction.CW); 
    } 
    this.c.invalidate();
  }
  
  private boolean h() {
    boolean bool;
    d.d d1 = this.g;
    if (d1 == null || d1.a()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (a == 0) {
      boolean bool1 = false;
      if (!bool) {
        boolean bool2 = this.j;
        bool1 = false;
        if (bool2)
          bool1 = true; 
      } 
      return bool1;
    } 
    return bool ^ true;
  }
  
  private boolean i() { return (!this.i && Color.alpha(this.f.getColor()) != 0); }
  
  private boolean j() { return (!this.i && this.h != null && this.g != null); }
  
  public void a() {
    if (a == 0) {
      this.i = true;
      this.j = false;
      this.c.buildDrawingCache();
      Bitmap bitmap = this.c.getDrawingCache();
      if (bitmap == null && this.c.getWidth() != 0 && this.c.getHeight() != 0) {
        bitmap = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.c.draw(canvas);
      } 
      if (bitmap != null)
        this.e.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)); 
      this.i = false;
      this.j = true;
    } 
  }
  
  public void a(int paramInt) {
    this.f.setColor(paramInt);
    this.c.invalidate();
  }
  
  public void a(Canvas paramCanvas) { // Byte code:
    //   0: aload_0
    //   1: invokespecial h : ()Z
    //   4: ifeq -> 228
    //   7: getstatic android/support/design/c/c.a : I
    //   10: tableswitch default -> 36, 0 -> 160, 1 -> 95, 2 -> 75
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #4
    //   45: aload #4
    //   47: ldc 'Unsupported strategy '
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload #4
    //   55: getstatic android/support/design/c/c.a : I
    //   58: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new java/lang/IllegalStateException
    //   65: dup
    //   66: aload #4
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: athrow
    //   75: aload_0
    //   76: getfield b : Landroid/support/design/c/c$a;
    //   79: aload_1
    //   80: invokeinterface a : (Landroid/graphics/Canvas;)V
    //   85: aload_0
    //   86: invokespecial i : ()Z
    //   89: ifeq -> 271
    //   92: goto -> 245
    //   95: aload_1
    //   96: invokevirtual save : ()I
    //   99: istore_2
    //   100: aload_1
    //   101: aload_0
    //   102: getfield d : Landroid/graphics/Path;
    //   105: invokevirtual clipPath : (Landroid/graphics/Path;)Z
    //   108: pop
    //   109: aload_0
    //   110: getfield b : Landroid/support/design/c/c$a;
    //   113: aload_1
    //   114: invokeinterface a : (Landroid/graphics/Canvas;)V
    //   119: aload_0
    //   120: invokespecial i : ()Z
    //   123: ifeq -> 152
    //   126: aload_1
    //   127: fconst_0
    //   128: fconst_0
    //   129: aload_0
    //   130: getfield c : Landroid/view/View;
    //   133: invokevirtual getWidth : ()I
    //   136: i2f
    //   137: aload_0
    //   138: getfield c : Landroid/view/View;
    //   141: invokevirtual getHeight : ()I
    //   144: i2f
    //   145: aload_0
    //   146: getfield f : Landroid/graphics/Paint;
    //   149: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   152: aload_1
    //   153: iload_2
    //   154: invokevirtual restoreToCount : (I)V
    //   157: goto -> 271
    //   160: aload_1
    //   161: aload_0
    //   162: getfield g : Landroid/support/design/c/d$d;
    //   165: getfield a : F
    //   168: aload_0
    //   169: getfield g : Landroid/support/design/c/d$d;
    //   172: getfield b : F
    //   175: aload_0
    //   176: getfield g : Landroid/support/design/c/d$d;
    //   179: getfield c : F
    //   182: aload_0
    //   183: getfield e : Landroid/graphics/Paint;
    //   186: invokevirtual drawCircle : (FFFLandroid/graphics/Paint;)V
    //   189: aload_0
    //   190: invokespecial i : ()Z
    //   193: ifeq -> 271
    //   196: aload_1
    //   197: aload_0
    //   198: getfield g : Landroid/support/design/c/d$d;
    //   201: getfield a : F
    //   204: aload_0
    //   205: getfield g : Landroid/support/design/c/d$d;
    //   208: getfield b : F
    //   211: aload_0
    //   212: getfield g : Landroid/support/design/c/d$d;
    //   215: getfield c : F
    //   218: aload_0
    //   219: getfield f : Landroid/graphics/Paint;
    //   222: invokevirtual drawCircle : (FFFLandroid/graphics/Paint;)V
    //   225: goto -> 271
    //   228: aload_0
    //   229: getfield b : Landroid/support/design/c/c$a;
    //   232: aload_1
    //   233: invokeinterface a : (Landroid/graphics/Canvas;)V
    //   238: aload_0
    //   239: invokespecial i : ()Z
    //   242: ifeq -> 271
    //   245: aload_1
    //   246: fconst_0
    //   247: fconst_0
    //   248: aload_0
    //   249: getfield c : Landroid/view/View;
    //   252: invokevirtual getWidth : ()I
    //   255: i2f
    //   256: aload_0
    //   257: getfield c : Landroid/view/View;
    //   260: invokevirtual getHeight : ()I
    //   263: i2f
    //   264: aload_0
    //   265: getfield f : Landroid/graphics/Paint;
    //   268: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   271: aload_0
    //   272: aload_1
    //   273: invokespecial b : (Landroid/graphics/Canvas;)V
    //   276: return }
  
  public void a(Drawable paramDrawable) {
    this.h = paramDrawable;
    this.c.invalidate();
  }
  
  public void a(d.d paramd) {
    if (paramd == null) {
      this.g = null;
    } else {
      d.d d1 = this.g;
      if (d1 == null) {
        this.g = new d.d(paramd);
      } else {
        d1.a(paramd);
      } 
      if (k.b(paramd.c, b(paramd), 1.0E-4F))
        this.g.c = Float.MAX_VALUE; 
    } 
    g();
  }
  
  public void b() {
    if (a == 0) {
      this.j = false;
      this.c.destroyDrawingCache();
      this.e.setShader(null);
      this.c.invalidate();
    } 
  }
  
  public d.d c() {
    d.d d1 = this.g;
    if (d1 == null)
      return null; 
    d.d d2 = new d.d(d1);
    if (d2.a())
      d2.c = b(d2); 
    return d2;
  }
  
  public int d() { return this.f.getColor(); }
  
  public Drawable e() { return this.h; }
  
  public boolean f() { return (this.b.c() && !h()); }
  
  static interface a {
    void a(Canvas param1Canvas);
    
    boolean c();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */