package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
  private TypedValue a;
  
  private TypedValue b;
  
  private TypedValue c;
  
  private TypedValue d;
  
  private TypedValue e;
  
  private TypedValue f;
  
  private final Rect g = new Rect();
  
  private a h;
  
  public ContentFrameLayout(Context paramContext) { this(paramContext, null); }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (r.x(this))
      requestLayout(); 
  }
  
  public void a(Rect paramRect) { fitSystemWindows(paramRect); }
  
  public TypedValue getFixedHeightMajor() {
    if (this.e == null)
      this.e = new TypedValue(); 
    return this.e;
  }
  
  public TypedValue getFixedHeightMinor() {
    if (this.f == null)
      this.f = new TypedValue(); 
    return this.f;
  }
  
  public TypedValue getFixedWidthMajor() {
    if (this.c == null)
      this.c = new TypedValue(); 
    return this.c;
  }
  
  public TypedValue getFixedWidthMinor() {
    if (this.d == null)
      this.d = new TypedValue(); 
    return this.d;
  }
  
  public TypedValue getMinWidthMajor() {
    if (this.a == null)
      this.a = new TypedValue(); 
    return this.a;
  }
  
  public TypedValue getMinWidthMinor() {
    if (this.b == null)
      this.b = new TypedValue(); 
    return this.b;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    a a1 = this.h;
    if (a1 != null)
      a1.a(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a a1 = this.h;
    if (a1 != null)
      a1.b(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContext : ()Landroid/content/Context;
    //   4: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   7: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   10: astore_3
    //   11: aload_3
    //   12: getfield widthPixels : I
    //   15: istore #4
    //   17: aload_3
    //   18: getfield heightPixels : I
    //   21: istore #5
    //   23: iconst_1
    //   24: istore #6
    //   26: iload #4
    //   28: iload #5
    //   30: if_icmpge -> 39
    //   33: iconst_1
    //   34: istore #7
    //   36: goto -> 42
    //   39: iconst_0
    //   40: istore #7
    //   42: iload_1
    //   43: invokestatic getMode : (I)I
    //   46: istore #8
    //   48: iload_2
    //   49: invokestatic getMode : (I)I
    //   52: istore #9
    //   54: iload #8
    //   56: ldc -2147483648
    //   58: if_icmpne -> 195
    //   61: iload #7
    //   63: ifeq -> 75
    //   66: aload_0
    //   67: getfield d : Landroid/util/TypedValue;
    //   70: astore #20
    //   72: goto -> 81
    //   75: aload_0
    //   76: getfield c : Landroid/util/TypedValue;
    //   79: astore #20
    //   81: aload #20
    //   83: ifnull -> 195
    //   86: aload #20
    //   88: getfield type : I
    //   91: ifeq -> 195
    //   94: aload #20
    //   96: getfield type : I
    //   99: iconst_5
    //   100: if_icmpne -> 119
    //   103: aload #20
    //   105: aload_3
    //   106: invokevirtual getDimension : (Landroid/util/DisplayMetrics;)F
    //   109: fstore #22
    //   111: fload #22
    //   113: f2i
    //   114: istore #21
    //   116: goto -> 152
    //   119: aload #20
    //   121: getfield type : I
    //   124: bipush #6
    //   126: if_icmpne -> 149
    //   129: aload #20
    //   131: aload_3
    //   132: getfield widthPixels : I
    //   135: i2f
    //   136: aload_3
    //   137: getfield widthPixels : I
    //   140: i2f
    //   141: invokevirtual getFraction : (FF)F
    //   144: fstore #22
    //   146: goto -> 111
    //   149: iconst_0
    //   150: istore #21
    //   152: iload #21
    //   154: ifle -> 195
    //   157: iload #21
    //   159: aload_0
    //   160: getfield g : Landroid/graphics/Rect;
    //   163: getfield left : I
    //   166: aload_0
    //   167: getfield g : Landroid/graphics/Rect;
    //   170: getfield right : I
    //   173: iadd
    //   174: isub
    //   175: iload_1
    //   176: invokestatic getSize : (I)I
    //   179: invokestatic min : (II)I
    //   182: ldc 1073741824
    //   184: invokestatic makeMeasureSpec : (II)I
    //   187: istore #10
    //   189: iconst_1
    //   190: istore #11
    //   192: goto -> 201
    //   195: iload_1
    //   196: istore #10
    //   198: iconst_0
    //   199: istore #11
    //   201: iload #9
    //   203: ldc -2147483648
    //   205: if_icmpne -> 335
    //   208: iload #7
    //   210: ifeq -> 222
    //   213: aload_0
    //   214: getfield e : Landroid/util/TypedValue;
    //   217: astore #17
    //   219: goto -> 228
    //   222: aload_0
    //   223: getfield f : Landroid/util/TypedValue;
    //   226: astore #17
    //   228: aload #17
    //   230: ifnull -> 335
    //   233: aload #17
    //   235: getfield type : I
    //   238: ifeq -> 335
    //   241: aload #17
    //   243: getfield type : I
    //   246: iconst_5
    //   247: if_icmpne -> 266
    //   250: aload #17
    //   252: aload_3
    //   253: invokevirtual getDimension : (Landroid/util/DisplayMetrics;)F
    //   256: fstore #19
    //   258: fload #19
    //   260: f2i
    //   261: istore #18
    //   263: goto -> 299
    //   266: aload #17
    //   268: getfield type : I
    //   271: bipush #6
    //   273: if_icmpne -> 296
    //   276: aload #17
    //   278: aload_3
    //   279: getfield heightPixels : I
    //   282: i2f
    //   283: aload_3
    //   284: getfield heightPixels : I
    //   287: i2f
    //   288: invokevirtual getFraction : (FF)F
    //   291: fstore #19
    //   293: goto -> 258
    //   296: iconst_0
    //   297: istore #18
    //   299: iload #18
    //   301: ifle -> 335
    //   304: iload #18
    //   306: aload_0
    //   307: getfield g : Landroid/graphics/Rect;
    //   310: getfield top : I
    //   313: aload_0
    //   314: getfield g : Landroid/graphics/Rect;
    //   317: getfield bottom : I
    //   320: iadd
    //   321: isub
    //   322: iload_2
    //   323: invokestatic getSize : (I)I
    //   326: invokestatic min : (II)I
    //   329: ldc 1073741824
    //   331: invokestatic makeMeasureSpec : (II)I
    //   334: istore_2
    //   335: aload_0
    //   336: iload #10
    //   338: iload_2
    //   339: invokespecial onMeasure : (II)V
    //   342: aload_0
    //   343: invokevirtual getMeasuredWidth : ()I
    //   346: istore #12
    //   348: iload #12
    //   350: ldc 1073741824
    //   352: invokestatic makeMeasureSpec : (II)I
    //   355: istore #13
    //   357: iload #11
    //   359: ifne -> 504
    //   362: iload #8
    //   364: ldc -2147483648
    //   366: if_icmpne -> 504
    //   369: iload #7
    //   371: ifeq -> 383
    //   374: aload_0
    //   375: getfield b : Landroid/util/TypedValue;
    //   378: astore #14
    //   380: goto -> 389
    //   383: aload_0
    //   384: getfield a : Landroid/util/TypedValue;
    //   387: astore #14
    //   389: aload #14
    //   391: ifnull -> 504
    //   394: aload #14
    //   396: getfield type : I
    //   399: ifeq -> 504
    //   402: aload #14
    //   404: getfield type : I
    //   407: iconst_5
    //   408: if_icmpne -> 427
    //   411: aload #14
    //   413: aload_3
    //   414: invokevirtual getDimension : (Landroid/util/DisplayMetrics;)F
    //   417: fstore #16
    //   419: fload #16
    //   421: f2i
    //   422: istore #15
    //   424: goto -> 460
    //   427: aload #14
    //   429: getfield type : I
    //   432: bipush #6
    //   434: if_icmpne -> 457
    //   437: aload #14
    //   439: aload_3
    //   440: getfield widthPixels : I
    //   443: i2f
    //   444: aload_3
    //   445: getfield widthPixels : I
    //   448: i2f
    //   449: invokevirtual getFraction : (FF)F
    //   452: fstore #16
    //   454: goto -> 419
    //   457: iconst_0
    //   458: istore #15
    //   460: iload #15
    //   462: ifle -> 485
    //   465: iload #15
    //   467: aload_0
    //   468: getfield g : Landroid/graphics/Rect;
    //   471: getfield left : I
    //   474: aload_0
    //   475: getfield g : Landroid/graphics/Rect;
    //   478: getfield right : I
    //   481: iadd
    //   482: isub
    //   483: istore #15
    //   485: iload #12
    //   487: iload #15
    //   489: if_icmpge -> 504
    //   492: iload #15
    //   494: ldc 1073741824
    //   496: invokestatic makeMeasureSpec : (II)I
    //   499: istore #13
    //   501: goto -> 507
    //   504: iconst_0
    //   505: istore #6
    //   507: iload #6
    //   509: ifeq -> 519
    //   512: aload_0
    //   513: iload #13
    //   515: iload_2
    //   516: invokespecial onMeasure : (II)V
    //   519: return }
  
  public void setAttachListener(a parama) { this.h = parama; }
  
  public static interface a {
    void a();
    
    void b();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ContentFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */