package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.f;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;

public class bm {
  private final Context a;
  
  private final TypedArray b;
  
  private TypedValue c;
  
  private bm(Context paramContext, TypedArray paramTypedArray) {
    this.a = paramContext;
    this.b = paramTypedArray;
  }
  
  public static bm a(Context paramContext, int paramInt, int[] paramArrayOfInt) { return new bm(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt)); }
  
  public static bm a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt) { return new bm(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt)); }
  
  public static bm a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2) { return new bm(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2)); }
  
  public float a(int paramInt, float paramFloat) { return this.b.getFloat(paramInt, paramFloat); }
  
  public int a(int paramInt1, int paramInt2) { return this.b.getInt(paramInt1, paramInt2); }
  
  public Typeface a(int paramInt1, int paramInt2, f.a parama) {
    int i = this.b.getResourceId(paramInt1, 0);
    if (i == 0)
      return null; 
    if (this.c == null)
      this.c = new TypedValue(); 
    return f.a(this.a, i, this.c, paramInt2, parama);
  }
  
  public Drawable a(int paramInt) {
    if (this.b.hasValue(paramInt)) {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0)
        return a.b(this.a, i); 
    } 
    return this.b.getDrawable(paramInt);
  }
  
  public void a() { this.b.recycle(); }
  
  public boolean a(int paramInt, boolean paramBoolean) { return this.b.getBoolean(paramInt, paramBoolean); }
  
  public float b(int paramInt, float paramFloat) { return this.b.getDimension(paramInt, paramFloat); }
  
  public int b(int paramInt1, int paramInt2) { return this.b.getColor(paramInt1, paramInt2); }
  
  public Drawable b(int paramInt) {
    if (this.b.hasValue(paramInt)) {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0)
        return l.a().a(this.a, i, true); 
    } 
    return null;
  }
  
  public int c(int paramInt1, int paramInt2) { return this.b.getInteger(paramInt1, paramInt2); }
  
  public CharSequence c(int paramInt) { return this.b.getText(paramInt); }
  
  public int d(int paramInt1, int paramInt2) { return this.b.getDimensionPixelOffset(paramInt1, paramInt2); }
  
  public String d(int paramInt) { return this.b.getString(paramInt); }
  
  public int e(int paramInt1, int paramInt2) { return this.b.getDimensionPixelSize(paramInt1, paramInt2); }
  
  public ColorStateList e(int paramInt) {
    if (this.b.hasValue(paramInt)) {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0) {
        ColorStateList colorStateList = a.a(this.a, i);
        if (colorStateList != null)
          return colorStateList; 
      } 
    } 
    return this.b.getColorStateList(paramInt);
  }
  
  public int f(int paramInt1, int paramInt2) { return this.b.getLayoutDimension(paramInt1, paramInt2); }
  
  public CharSequence[] f(int paramInt) { return this.b.getTextArray(paramInt); }
  
  public int g(int paramInt1, int paramInt2) { return this.b.getResourceId(paramInt1, paramInt2); }
  
  public boolean g(int paramInt) { return this.b.hasValue(paramInt); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */