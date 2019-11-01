package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.a.a;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import org.jd.gui.api.API;

class ab {
  private static final RectF a = new RectF();
  
  private static ConcurrentHashMap<String, Method> b = new ConcurrentHashMap();
  
  private int c = 0;
  
  private boolean d = false;
  
  private float e = -1.0F;
  
  private float f = -1.0F;
  
  private float g = -1.0F;
  
  private int[] h = new int[0];
  
  private boolean i = false;
  
  private TextPaint j;
  
  private final TextView k;
  
  private final Context l;
  
  ab(TextView paramTextView) {
    this.k = paramTextView;
    this.l = this.k.getContext();
  }
  
  private int a(RectF paramRectF) {
    int m = this.h.length;
    if (m != 0) {
      int n = m - 1;
      int i1 = 1;
      int i2 = 0;
      while (i1 <= n) {
        int i3 = (i1 + n) / 2;
        if (a(this.h[i3], paramRectF)) {
          int i4 = i3 + 1;
          i2 = i1;
          i1 = i4;
          continue;
        } 
        i2 = i3 - 1;
        n = i2;
      } 
      return this.h[i2];
    } 
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt) {
    boolean bool1;
    float f2;
    float f1;
    if (Build.VERSION.SDK_INT >= 16) {
      f1 = this.k.getLineSpacingMultiplier();
      f2 = this.k.getLineSpacingExtra();
      bool1 = this.k.getIncludeFontPadding();
    } else {
      f1 = ((Float)a(this.k, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.k, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
      bool1 = ((Boolean)a(this.k, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
    } 
    float f3 = f1;
    float f4 = f2;
    boolean bool2 = bool1;
    return new StaticLayout(paramCharSequence, this.j, paramInt, paramAlignment, f3, f4, bool2);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2) {
    TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic)a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    StaticLayout.Builder builder = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.j, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
    if (paramInt2 == -1)
      paramInt2 = Integer.MAX_VALUE; 
    return builder.setMaxLines(paramInt2).setTextDirection(textDirectionHeuristic).build();
  }
  
  private <T> T a(Object paramObject, String paramString, T paramT) {
    API aPI;
    try {
      return (T)a(paramString).invoke(paramObject, new Object[0]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to invoke TextView#");
      stringBuilder.append(paramString);
      stringBuilder.append("() method");
      Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), exception);
      return paramT;
    } finally {}
    throw aPI;
  }
  
  private Method a(String paramString) {
    try {
      Method method = (Method)b.get(paramString);
      if (method == null) {
        method = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        if (method != null) {
          method.setAccessible(true);
          b.put(paramString, method);
        } 
      } 
      return method;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to retrieve TextView#");
      stringBuilder.append(paramString);
      stringBuilder.append("() method");
      Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), exception);
      return null;
    } 
  }
  
  private void a(float paramFloat) {
    if (paramFloat != this.k.getPaint().getTextSize()) {
      boolean bool;
      this.k.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT >= 18) {
        bool = this.k.isInLayout();
      } else {
        bool = false;
      } 
      if (this.k.getLayout() != null) {
        this.d = false;
        try {
          Method method = a("nullLayouts");
          if (method != null)
            method.invoke(this.k, new Object[0]); 
        } catch (Exception exception) {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", exception);
        } 
        if (!bool) {
          this.k.requestLayout();
        } else {
          this.k.forceLayout();
        } 
        this.k.invalidate();
      } 
    } 
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (paramFloat1 > 0.0F) {
      if (paramFloat2 > paramFloat1) {
        if (paramFloat3 > 0.0F) {
          this.c = 1;
          this.f = paramFloat1;
          this.g = paramFloat2;
          this.e = paramFloat3;
          this.i = false;
          return;
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("The auto-size step granularity (");
        stringBuilder2.append(paramFloat3);
        stringBuilder2.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Maximum auto-size text size (");
      stringBuilder1.append(paramFloat2);
      stringBuilder1.append("px) is less or equal to minimum auto-size ");
      stringBuilder1.append("text size (");
      stringBuilder1.append(paramFloat1);
      stringBuilder1.append("px)");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Minimum auto-size text size (");
    stringBuilder.append(paramFloat1);
    stringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private void a(TypedArray paramTypedArray) {
    int m = paramTypedArray.length();
    int[] arrayOfInt = new int[m];
    if (m > 0) {
      for (byte b1 = 0; b1 < m; b1++)
        arrayOfInt[b1] = paramTypedArray.getDimensionPixelSize(b1, -1); 
      this.h = a(arrayOfInt);
      h();
    } 
  }
  
  private boolean a(int paramInt, RectF paramRectF) {
    StaticLayout staticLayout;
    byte b1;
    CharSequence charSequence = this.k.getText();
    TransformationMethod transformationMethod = this.k.getTransformationMethod();
    if (transformationMethod != null) {
      CharSequence charSequence1 = transformationMethod.getTransformation(charSequence, this.k);
      if (charSequence1 != null)
        charSequence = charSequence1; 
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      b1 = this.k.getMaxLines();
    } else {
      b1 = -1;
    } 
    TextPaint textPaint = this.j;
    if (textPaint == null) {
      this.j = new TextPaint();
    } else {
      textPaint.reset();
    } 
    this.j.set(this.k.getPaint());
    this.j.setTextSize(paramInt);
    Layout.Alignment alignment = (Layout.Alignment)a(this.k, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
    if (Build.VERSION.SDK_INT >= 23) {
      staticLayout = a(charSequence, alignment, Math.round(paramRectF.right), b1);
    } else {
      staticLayout = a(charSequence, alignment, Math.round(paramRectF.right));
    } 
    return (b1 != -1 && (staticLayout.getLineCount() > b1 || staticLayout.getLineEnd(staticLayout.getLineCount() - 1) != charSequence.length())) ? false : (!(staticLayout.getHeight() > paramRectF.bottom));
  }
  
  private int[] a(int[] paramArrayOfInt) {
    int m = paramArrayOfInt.length;
    if (m == 0)
      return paramArrayOfInt; 
    Arrays.sort(paramArrayOfInt);
    ArrayList arrayList = new ArrayList();
    byte b1 = 0;
    for (byte b2 = 0; b2 < m; b2++) {
      int i1 = paramArrayOfInt[b2];
      if (i1 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i1)) < 0)
        arrayList.add(Integer.valueOf(i1)); 
    } 
    if (m == arrayList.size())
      return paramArrayOfInt; 
    int n = arrayList.size();
    int[] arrayOfInt = new int[n];
    while (b1 < n) {
      arrayOfInt[b1] = ((Integer)arrayList.get(b1)).intValue();
      b1++;
    } 
    return arrayOfInt;
  }
  
  private boolean h() {
    boolean bool;
    int m = this.h.length;
    if (m > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.i = bool;
    if (this.i) {
      this.c = 1;
      int[] arrayOfInt = this.h;
      this.f = arrayOfInt[0];
      this.g = arrayOfInt[m - 1];
      this.e = -1.0F;
    } 
    return this.i;
  }
  
  private boolean i() {
    boolean bool = k();
    byte b1 = 0;
    if (bool && this.c == 1) {
      if (!this.i || this.h.length == 0) {
        float f1 = Math.round(this.f);
        byte b2 = 1;
        while (Math.round(f1 + this.e) <= Math.round(this.g)) {
          b2++;
          f1 += this.e;
        } 
        int[] arrayOfInt = new int[b2];
        float f2 = this.f;
        while (b1 < b2) {
          arrayOfInt[b1] = Math.round(f2);
          f2 += this.e;
          b1++;
        } 
        this.h = a(arrayOfInt);
      } 
      this.d = true;
    } else {
      this.d = false;
    } 
    return this.d;
  }
  
  private void j() {
    this.c = 0;
    this.f = -1.0F;
    this.g = -1.0F;
    this.e = -1.0F;
    this.h = new int[0];
    this.d = false;
  }
  
  private boolean k() { return !(this.k instanceof m); }
  
  int a() { return this.c; }
  
  void a(int paramInt) {
    if (k()) {
      StringBuilder stringBuilder;
      DisplayMetrics displayMetrics;
      switch (paramInt) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown auto-size text type: ");
          stringBuilder.append(paramInt);
          throw new IllegalArgumentException(stringBuilder.toString());
        case 1:
          displayMetrics = this.l.getResources().getDisplayMetrics();
          a(TypedValue.applyDimension(2, 12.0F, displayMetrics), TypedValue.applyDimension(2, 112.0F, displayMetrics), 1.0F);
          if (i()) {
            f();
            return;
          } 
          return;
        case 0:
          break;
      } 
      j();
    } 
  }
  
  void a(int paramInt, float paramFloat) {
    Resources resources;
    Context context = this.l;
    if (context == null) {
      resources = Resources.getSystem();
    } else {
      resources = context.getResources();
    } 
    a(TypedValue.applyDimension(paramInt, paramFloat, resources.getDisplayMetrics()));
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (k()) {
      DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
      a(TypedValue.applyDimension(paramInt4, paramInt1, displayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, displayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, displayMetrics));
      if (i())
        f(); 
    } 
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    float f3;
    float f2;
    float f1;
    TypedArray typedArray = this.l.obtainStyledAttributes(paramAttributeSet, a.j.AppCompatTextView, paramInt, 0);
    if (typedArray.hasValue(a.j.AppCompatTextView_autoSizeTextType))
      this.c = typedArray.getInt(a.j.AppCompatTextView_autoSizeTextType, 0); 
    if (typedArray.hasValue(a.j.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = typedArray.getDimension(a.j.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    } 
    if (typedArray.hasValue(a.j.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = typedArray.getDimension(a.j.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    } 
    if (typedArray.hasValue(a.j.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = typedArray.getDimension(a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    } 
    if (typedArray.hasValue(a.j.AppCompatTextView_autoSizePresetSizes)) {
      int m = typedArray.getResourceId(a.j.AppCompatTextView_autoSizePresetSizes, 0);
      if (m > 0) {
        TypedArray typedArray1 = typedArray.getResources().obtainTypedArray(m);
        a(typedArray1);
        typedArray1.recycle();
      } 
    } 
    typedArray.recycle();
    if (k()) {
      if (this.c == 1) {
        if (!this.i) {
          DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
          if (f2 == -1.0F)
            f2 = TypedValue.applyDimension(2, 12.0F, displayMetrics); 
          if (f3 == -1.0F)
            f3 = TypedValue.applyDimension(2, 112.0F, displayMetrics); 
          if (f1 == -1.0F)
            f1 = 1.0F; 
          a(f2, f3, f1);
        } 
        i();
        return;
      } 
    } else {
      this.c = 0;
    } 
  }
  
  void a(int[] paramArrayOfInt, int paramInt) {
    if (k()) {
      int m = paramArrayOfInt.length;
      byte b1 = 0;
      if (m > 0) {
        int[] arrayOfInt = new int[m];
        if (paramInt == 0) {
          arrayOfInt = Arrays.copyOf(paramArrayOfInt, m);
        } else {
          DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
          while (b1 < m) {
            arrayOfInt[b1] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[b1], displayMetrics));
            b1++;
          } 
        } 
        this.h = a(arrayOfInt);
        if (!h()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("None of the preset sizes is valid: ");
          stringBuilder.append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } else {
        this.i = false;
      } 
      if (i())
        f(); 
    } 
  }
  
  int b() { return Math.round(this.e); }
  
  int c() { return Math.round(this.f); }
  
  int d() { return Math.round(this.g); }
  
  int[] e() { return this.h; }
  
  void f() {
    if (!g())
      return; 
    if (this.d)
      if (this.k.getMeasuredHeight() > 0) {
        int m;
        if (this.k.getMeasuredWidth() <= 0)
          return; 
        if (((Boolean)a(this.k, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
          m = 1048576;
        } else {
          m = this.k.getMeasuredWidth() - this.k.getTotalPaddingLeft() - this.k.getTotalPaddingRight();
        } 
        int n = this.k.getHeight() - this.k.getCompoundPaddingBottom() - this.k.getCompoundPaddingTop();
        if (m > 0) {
          if (n <= 0)
            return; 
          synchronized (a) {
            a.setEmpty();
            a.right = m;
            a.bottom = n;
            float f1 = a(a);
            if (f1 != this.k.getTextSize())
              a(0, f1); 
          } 
        } else {
          return;
        } 
      } else {
        return;
      }  
    this.d = true;
  }
  
  boolean g() { return (k() && this.c != 0); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */