package android.support.v4.f;

import android.os.Build;
import android.support.v4.g.i;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.concurrent.Executor;

public class b implements Spannable {
  private static final Object a = new Object();
  
  private static Executor b = null;
  
  private final Spannable c;
  
  private final a d;
  
  private final PrecomputedText e;
  
  public PrecomputedText a() {
    Spannable spannable = this.c;
    return (spannable instanceof PrecomputedText) ? (PrecomputedText)spannable : null;
  }
  
  public a b() { return this.d; }
  
  public char charAt(int paramInt) { return this.c.charAt(paramInt); }
  
  public int getSpanEnd(Object paramObject) { return this.c.getSpanEnd(paramObject); }
  
  public int getSpanFlags(Object paramObject) { return this.c.getSpanFlags(paramObject); }
  
  public int getSpanStart(Object paramObject) { return this.c.getSpanStart(paramObject); }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass) { return (Build.VERSION.SDK_INT >= 28) ? (T[])this.e.getSpans(paramInt1, paramInt2, paramClass) : (T[])this.c.getSpans(paramInt1, paramInt2, paramClass); }
  
  public int length() { return this.c.length(); }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass) { return this.c.nextSpanTransition(paramInt1, paramInt2, paramClass); }
  
  public void removeSpan(Object paramObject) {
    if (!(paramObject instanceof android.text.style.MetricAffectingSpan)) {
      if (Build.VERSION.SDK_INT >= 28) {
        this.e.removeSpan(paramObject);
        return;
      } 
      this.c.removeSpan(paramObject);
      return;
    } 
    throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {
    if (!(paramObject instanceof android.text.style.MetricAffectingSpan)) {
      if (Build.VERSION.SDK_INT >= 28) {
        this.e.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
        return;
      } 
      this.c.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    } 
    throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2) { return this.c.subSequence(paramInt1, paramInt2); }
  
  public String toString() { return this.c.toString(); }
  
  public static final class a {
    final PrecomputedText.Params a;
    
    private final TextPaint b;
    
    private final TextDirectionHeuristic c;
    
    private final int d;
    
    private final int e;
    
    public a(PrecomputedText.Params param1Params) {
      this.b = param1Params.getTextPaint();
      this.c = param1Params.getTextDirection();
      this.d = param1Params.getBreakStrategy();
      this.e = param1Params.getHyphenationFrequency();
      this.a = param1Params;
    }
    
    a(TextPaint param1TextPaint, TextDirectionHeuristic param1TextDirectionHeuristic, int param1Int1, int param1Int2) {
      if (Build.VERSION.SDK_INT >= 28) {
        object = (new PrecomputedText.Params.Builder(param1TextPaint)).setBreakStrategy(param1Int1).setHyphenationFrequency(param1Int2).setTextDirection(param1TextDirectionHeuristic).build();
      } else {
        object = null;
      } 
      this.a = object;
      this.b = param1TextPaint;
      this.c = param1TextDirectionHeuristic;
      this.d = param1Int1;
      this.e = param1Int2;
    }
    
    public TextPaint a() { return this.b; }
    
    public TextDirectionHeuristic b() { return this.c; }
    
    public int c() { return this.d; }
    
    public int d() { return this.e; }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object != null) {
        if (!(param1Object instanceof a))
          return false; 
        a a1 = (a)param1Object;
        PrecomputedText.Params params = this.a;
        if (params != null)
          return params.equals(a1.a); 
        if (Build.VERSION.SDK_INT >= 23) {
          if (this.d != a1.c())
            return false; 
          if (this.e != a1.d())
            return false; 
        } 
        if (Build.VERSION.SDK_INT >= 18 && this.c != a1.b())
          return false; 
        if (this.b.getTextSize() != a1.a().getTextSize())
          return false; 
        if (this.b.getTextScaleX() != a1.a().getTextScaleX())
          return false; 
        if (this.b.getTextSkewX() != a1.a().getTextSkewX())
          return false; 
        if (Build.VERSION.SDK_INT >= 21) {
          if (this.b.getLetterSpacing() != a1.a().getLetterSpacing())
            return false; 
          if (!TextUtils.equals(this.b.getFontFeatureSettings(), a1.a().getFontFeatureSettings()))
            return false; 
        } 
        if (this.b.getFlags() != a1.a().getFlags())
          return false; 
        if (Build.VERSION.SDK_INT >= 24) {
          if (!this.b.getTextLocales().equals(a1.a().getTextLocales()))
            return false; 
        } else if (Build.VERSION.SDK_INT >= 17 && !this.b.getTextLocale().equals(a1.a().getTextLocale())) {
          return false;
        } 
        if (this.b.getTypeface() == null) {
          if (a1.a().getTypeface() != null)
            return false; 
        } else if (!this.b.getTypeface().equals(a1.a().getTypeface())) {
          return false;
        } 
        return true;
      } 
      return false;
    }
    
    public int hashCode() {
      if (Build.VERSION.SDK_INT >= 24) {
        Object[] arrayOfObject1 = new Object[11];
        arrayOfObject1[0] = Float.valueOf(this.b.getTextSize());
        arrayOfObject1[1] = Float.valueOf(this.b.getTextScaleX());
        arrayOfObject1[2] = Float.valueOf(this.b.getTextSkewX());
        arrayOfObject1[3] = Float.valueOf(this.b.getLetterSpacing());
        arrayOfObject1[4] = Integer.valueOf(this.b.getFlags());
        arrayOfObject1[5] = this.b.getTextLocales();
        arrayOfObject1[6] = this.b.getTypeface();
        arrayOfObject1[7] = Boolean.valueOf(this.b.isElegantTextHeight());
        arrayOfObject1[8] = this.c;
        arrayOfObject1[9] = Integer.valueOf(this.d);
        arrayOfObject1[10] = Integer.valueOf(this.e);
        return i.a(arrayOfObject1);
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        Object[] arrayOfObject1 = new Object[11];
        arrayOfObject1[0] = Float.valueOf(this.b.getTextSize());
        arrayOfObject1[1] = Float.valueOf(this.b.getTextScaleX());
        arrayOfObject1[2] = Float.valueOf(this.b.getTextSkewX());
        arrayOfObject1[3] = Float.valueOf(this.b.getLetterSpacing());
        arrayOfObject1[4] = Integer.valueOf(this.b.getFlags());
        arrayOfObject1[5] = this.b.getTextLocale();
        arrayOfObject1[6] = this.b.getTypeface();
        arrayOfObject1[7] = Boolean.valueOf(this.b.isElegantTextHeight());
        arrayOfObject1[8] = this.c;
        arrayOfObject1[9] = Integer.valueOf(this.d);
        arrayOfObject1[10] = Integer.valueOf(this.e);
        return i.a(arrayOfObject1);
      } 
      if (Build.VERSION.SDK_INT >= 18) {
        Object[] arrayOfObject1 = new Object[9];
        arrayOfObject1[0] = Float.valueOf(this.b.getTextSize());
        arrayOfObject1[1] = Float.valueOf(this.b.getTextScaleX());
        arrayOfObject1[2] = Float.valueOf(this.b.getTextSkewX());
        arrayOfObject1[3] = Integer.valueOf(this.b.getFlags());
        arrayOfObject1[4] = this.b.getTextLocale();
        arrayOfObject1[5] = this.b.getTypeface();
        arrayOfObject1[6] = this.c;
        arrayOfObject1[7] = Integer.valueOf(this.d);
        arrayOfObject1[8] = Integer.valueOf(this.e);
        return i.a(arrayOfObject1);
      } 
      if (Build.VERSION.SDK_INT >= 17) {
        Object[] arrayOfObject1 = new Object[9];
        arrayOfObject1[0] = Float.valueOf(this.b.getTextSize());
        arrayOfObject1[1] = Float.valueOf(this.b.getTextScaleX());
        arrayOfObject1[2] = Float.valueOf(this.b.getTextSkewX());
        arrayOfObject1[3] = Integer.valueOf(this.b.getFlags());
        arrayOfObject1[4] = this.b.getTextLocale();
        arrayOfObject1[5] = this.b.getTypeface();
        arrayOfObject1[6] = this.c;
        arrayOfObject1[7] = Integer.valueOf(this.d);
        arrayOfObject1[8] = Integer.valueOf(this.e);
        return i.a(arrayOfObject1);
      } 
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = Float.valueOf(this.b.getTextSize());
      arrayOfObject[1] = Float.valueOf(this.b.getTextScaleX());
      arrayOfObject[2] = Float.valueOf(this.b.getTextSkewX());
      arrayOfObject[3] = Integer.valueOf(this.b.getFlags());
      arrayOfObject[4] = this.b.getTypeface();
      arrayOfObject[5] = this.c;
      arrayOfObject[6] = Integer.valueOf(this.d);
      arrayOfObject[7] = Integer.valueOf(this.e);
      return i.a(arrayOfObject);
    }
    
    public String toString() { // Byte code:
      //   0: new java/lang/StringBuilder
      //   3: dup
      //   4: ldc '{'
      //   6: invokespecial <init> : (Ljava/lang/String;)V
      //   9: astore_1
      //   10: new java/lang/StringBuilder
      //   13: dup
      //   14: invokespecial <init> : ()V
      //   17: astore_2
      //   18: aload_2
      //   19: ldc 'textSize='
      //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: pop
      //   25: aload_2
      //   26: aload_0
      //   27: getfield b : Landroid/text/TextPaint;
      //   30: invokevirtual getTextSize : ()F
      //   33: invokevirtual append : (F)Ljava/lang/StringBuilder;
      //   36: pop
      //   37: aload_1
      //   38: aload_2
      //   39: invokevirtual toString : ()Ljava/lang/String;
      //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: pop
      //   46: new java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial <init> : ()V
      //   53: astore #6
      //   55: aload #6
      //   57: ldc ', textScaleX='
      //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: aload #6
      //   65: aload_0
      //   66: getfield b : Landroid/text/TextPaint;
      //   69: invokevirtual getTextScaleX : ()F
      //   72: invokevirtual append : (F)Ljava/lang/StringBuilder;
      //   75: pop
      //   76: aload_1
      //   77: aload #6
      //   79: invokevirtual toString : ()Ljava/lang/String;
      //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: pop
      //   86: new java/lang/StringBuilder
      //   89: dup
      //   90: invokespecial <init> : ()V
      //   93: astore #10
      //   95: aload #10
      //   97: ldc ', textSkewX='
      //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: pop
      //   103: aload #10
      //   105: aload_0
      //   106: getfield b : Landroid/text/TextPaint;
      //   109: invokevirtual getTextSkewX : ()F
      //   112: invokevirtual append : (F)Ljava/lang/StringBuilder;
      //   115: pop
      //   116: aload_1
      //   117: aload #10
      //   119: invokevirtual toString : ()Ljava/lang/String;
      //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   125: pop
      //   126: getstatic android/os/Build$VERSION.SDK_INT : I
      //   129: bipush #21
      //   131: if_icmplt -> 214
      //   134: new java/lang/StringBuilder
      //   137: dup
      //   138: invokespecial <init> : ()V
      //   141: astore #14
      //   143: aload #14
      //   145: ldc ', letterSpacing='
      //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   150: pop
      //   151: aload #14
      //   153: aload_0
      //   154: getfield b : Landroid/text/TextPaint;
      //   157: invokevirtual getLetterSpacing : ()F
      //   160: invokevirtual append : (F)Ljava/lang/StringBuilder;
      //   163: pop
      //   164: aload_1
      //   165: aload #14
      //   167: invokevirtual toString : ()Ljava/lang/String;
      //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   173: pop
      //   174: new java/lang/StringBuilder
      //   177: dup
      //   178: invokespecial <init> : ()V
      //   181: astore #18
      //   183: aload #18
      //   185: ldc ', elegantTextHeight='
      //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: pop
      //   191: aload #18
      //   193: aload_0
      //   194: getfield b : Landroid/text/TextPaint;
      //   197: invokevirtual isElegantTextHeight : ()Z
      //   200: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   203: pop
      //   204: aload_1
      //   205: aload #18
      //   207: invokevirtual toString : ()Ljava/lang/String;
      //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: pop
      //   214: getstatic android/os/Build$VERSION.SDK_INT : I
      //   217: bipush #24
      //   219: if_icmplt -> 269
      //   222: new java/lang/StringBuilder
      //   225: dup
      //   226: invokespecial <init> : ()V
      //   229: astore #22
      //   231: aload #22
      //   233: ldc ', textLocale='
      //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   238: pop
      //   239: aload_0
      //   240: getfield b : Landroid/text/TextPaint;
      //   243: invokevirtual getTextLocales : ()Landroid/os/LocaleList;
      //   246: astore #24
      //   248: aload #22
      //   250: aload #24
      //   252: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   255: pop
      //   256: aload_1
      //   257: aload #22
      //   259: invokevirtual toString : ()Ljava/lang/String;
      //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   265: pop
      //   266: goto -> 306
      //   269: getstatic android/os/Build$VERSION.SDK_INT : I
      //   272: bipush #17
      //   274: if_icmplt -> 306
      //   277: new java/lang/StringBuilder
      //   280: dup
      //   281: invokespecial <init> : ()V
      //   284: astore #22
      //   286: aload #22
      //   288: ldc ', textLocale='
      //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   293: pop
      //   294: aload_0
      //   295: getfield b : Landroid/text/TextPaint;
      //   298: invokevirtual getTextLocale : ()Ljava/util/Locale;
      //   301: astore #24
      //   303: goto -> 248
      //   306: new java/lang/StringBuilder
      //   309: dup
      //   310: invokespecial <init> : ()V
      //   313: astore #27
      //   315: aload #27
      //   317: ldc ', typeface='
      //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   322: pop
      //   323: aload #27
      //   325: aload_0
      //   326: getfield b : Landroid/text/TextPaint;
      //   329: invokevirtual getTypeface : ()Landroid/graphics/Typeface;
      //   332: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   335: pop
      //   336: aload_1
      //   337: aload #27
      //   339: invokevirtual toString : ()Ljava/lang/String;
      //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   345: pop
      //   346: getstatic android/os/Build$VERSION.SDK_INT : I
      //   349: bipush #26
      //   351: if_icmplt -> 394
      //   354: new java/lang/StringBuilder
      //   357: dup
      //   358: invokespecial <init> : ()V
      //   361: astore #31
      //   363: aload #31
      //   365: ldc ', variationSettings='
      //   367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   370: pop
      //   371: aload #31
      //   373: aload_0
      //   374: getfield b : Landroid/text/TextPaint;
      //   377: invokevirtual getFontVariationSettings : ()Ljava/lang/String;
      //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: pop
      //   384: aload_1
      //   385: aload #31
      //   387: invokevirtual toString : ()Ljava/lang/String;
      //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   393: pop
      //   394: new java/lang/StringBuilder
      //   397: dup
      //   398: invokespecial <init> : ()V
      //   401: astore #35
      //   403: aload #35
      //   405: ldc ', textDir='
      //   407: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   410: pop
      //   411: aload #35
      //   413: aload_0
      //   414: getfield c : Landroid/text/TextDirectionHeuristic;
      //   417: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   420: pop
      //   421: aload_1
      //   422: aload #35
      //   424: invokevirtual toString : ()Ljava/lang/String;
      //   427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   430: pop
      //   431: new java/lang/StringBuilder
      //   434: dup
      //   435: invokespecial <init> : ()V
      //   438: astore #39
      //   440: aload #39
      //   442: ldc ', breakStrategy='
      //   444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   447: pop
      //   448: aload #39
      //   450: aload_0
      //   451: getfield d : I
      //   454: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   457: pop
      //   458: aload_1
      //   459: aload #39
      //   461: invokevirtual toString : ()Ljava/lang/String;
      //   464: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   467: pop
      //   468: new java/lang/StringBuilder
      //   471: dup
      //   472: invokespecial <init> : ()V
      //   475: astore #43
      //   477: aload #43
      //   479: ldc ', hyphenationFrequency='
      //   481: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   484: pop
      //   485: aload #43
      //   487: aload_0
      //   488: getfield e : I
      //   491: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   494: pop
      //   495: aload_1
      //   496: aload #43
      //   498: invokevirtual toString : ()Ljava/lang/String;
      //   501: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   504: pop
      //   505: aload_1
      //   506: ldc '}'
      //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   511: pop
      //   512: aload_1
      //   513: invokevirtual toString : ()Ljava/lang/String;
      //   516: areturn }
    
    public static class a {
      private final TextPaint a;
      
      private TextDirectionHeuristic b;
      
      private int c;
      
      private int d;
      
      public a(TextPaint param2TextPaint) {
        this.a = param2TextPaint;
        if (Build.VERSION.SDK_INT >= 23) {
          this.c = 1;
          this.d = 1;
        } else {
          this.d = 0;
          this.c = 0;
        } 
        if (Build.VERSION.SDK_INT >= 18) {
          object = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        } else {
          object = null;
        } 
        this.b = object;
      }
      
      public a a(int param2Int) {
        this.c = param2Int;
        return this;
      }
      
      public a a(TextDirectionHeuristic param2TextDirectionHeuristic) {
        this.b = param2TextDirectionHeuristic;
        return this;
      }
      
      public b.a a() { return new b.a(this.a, this.b, this.c, this.d); }
      
      public a b(int param2Int) {
        this.d = param2Int;
        return this;
      }
    }
  }
  
  public static class a {
    private final TextPaint a;
    
    private TextDirectionHeuristic b;
    
    private int c;
    
    private int d;
    
    public a(TextPaint param1TextPaint) {
      this.a = param1TextPaint;
      if (Build.VERSION.SDK_INT >= 23) {
        this.c = 1;
        this.d = 1;
      } else {
        this.d = 0;
        this.c = 0;
      } 
      if (Build.VERSION.SDK_INT >= 18) {
        object = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      } else {
        object = null;
      } 
      this.b = object;
    }
    
    public a a(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public a a(TextDirectionHeuristic param1TextDirectionHeuristic) {
      this.b = param1TextDirectionHeuristic;
      return this;
    }
    
    public b.a a() { return new b.a(this.a, this.b, this.c, this.d); }
    
    public a b(int param1Int) {
      this.d = param1Int;
      return this;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */