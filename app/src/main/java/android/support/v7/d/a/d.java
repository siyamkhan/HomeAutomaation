package android.support.v7.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.a.a.g;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class d extends b {
  private a a;
  
  private boolean b;
  
  d() { this(null, null); }
  
  d(a parama) {
    if (parama != null)
      a(parama); 
  }
  
  d(a parama, Resources paramResources) {
    a(new a(parama, this, paramResources));
    onStateChange(getState());
  }
  
  private void a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    a a1 = this.a;
    int i = 1 + paramXmlPullParser.getDepth();
    while (true) {
      int j = paramXmlPullParser.next();
      if (j != 1) {
        int k = paramXmlPullParser.getDepth();
        if (k >= i || j != 3) {
          if (j != 2 || k > i || !paramXmlPullParser.getName().equals("item"))
            continue; 
          TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.StateListDrawableItem);
          int m = typedArray.getResourceId(a.j.StateListDrawableItem_android_drawable, -1);
          Drawable drawable = null;
          if (m > 0)
            drawable = a.b(paramContext, m); 
          typedArray.recycle();
          int[] arrayOfInt = a(paramAttributeSet);
          if (drawable == null) {
            int n;
            while (true) {
              n = paramXmlPullParser.next();
              if (n == 4)
                continue; 
              break;
            } 
            if (n == 2) {
              if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
              } else {
                drawable = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
              } 
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(paramXmlPullParser.getPositionDescription());
              stringBuilder.append(": <item> tag requires a 'drawable' attribute or ");
              stringBuilder.append("child tag defining a drawable");
              throw new XmlPullParserException(stringBuilder.toString());
            } 
          } 
          a1.a(arrayOfInt, drawable);
          continue;
        } 
      } 
      break;
    } 
  }
  
  private void a(TypedArray paramTypedArray) {
    a a1 = this.a;
    if (Build.VERSION.SDK_INT >= 21)
      a1.f |= paramTypedArray.getChangingConfigurations(); 
    a1.k = paramTypedArray.getBoolean(a.j.StateListDrawable_android_variablePadding, a1.k);
    a1.n = paramTypedArray.getBoolean(a.j.StateListDrawable_android_constantSize, a1.n);
    a1.C = paramTypedArray.getInt(a.j.StateListDrawable_android_enterFadeDuration, a1.C);
    a1.D = paramTypedArray.getInt(a.j.StateListDrawable_android_exitFadeDuration, a1.D);
    a1.z = paramTypedArray.getBoolean(a.j.StateListDrawable_android_dither, a1.z);
  }
  
  protected void a(b.b paramb) {
    super.a(paramb);
    if (paramb instanceof a)
      this.a = (a)paramb; 
  }
  
  int[] a(AttributeSet paramAttributeSet) {
    int i = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[i];
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < i) {
      int j = paramAttributeSet.getAttributeNameResource(b1);
      if (j != 0 && j != 16842960 && j != 16843161) {
        byte b3 = b2 + true;
        if (!paramAttributeSet.getAttributeBooleanValue(b1, false))
          j = -j; 
        arrayOfInt[b2] = j;
        b2 = b3;
      } 
      b1++;
    } 
    return StateSet.trimStateSet(arrayOfInt, b2);
  }
  
  public void applyTheme(Resources.Theme paramTheme) {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  a b() { return new a(this.a, this, null); }
  
  public void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.StateListDrawable);
    setVisible(typedArray.getBoolean(a.j.StateListDrawable_android_visible, true), true);
    a(typedArray);
    a(paramResources);
    typedArray.recycle();
    a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    onStateChange(getState());
  }
  
  public boolean isStateful() { return true; }
  
  public Drawable mutate() {
    if (!this.b && super.mutate() == this) {
      this.a.a();
      this.b = true;
    } 
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt) {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int i = this.a.b(paramArrayOfInt);
    if (i < 0)
      i = this.a.b(StateSet.WILD_CARD); 
    return (a(i) || bool);
  }
  
  static class a extends b.b {
    int[][] L;
    
    a(a param1a, d param1d, Resources param1Resources) {
      super(param1a, param1d, param1Resources);
      if (param1a != null) {
        arrayOfInt = param1a.L;
      } else {
        arrayOfInt = new int[c()][];
      } 
      this.L = arrayOfInt;
    }
    
    int a(int[] param1ArrayOfInt, Drawable param1Drawable) {
      int i = a(param1Drawable);
      this.L[i] = param1ArrayOfInt;
      return i;
    }
    
    void a() {
      int[][] arrayOfInt1 = this.L;
      int[][] arrayOfInt2 = new int[arrayOfInt1.length][];
      for (int i = -1 + arrayOfInt1.length; i >= 0; i--) {
        Object object;
        int[][] arrayOfInt = this.L;
        if (arrayOfInt[i] != null) {
          object = (int[])arrayOfInt[i].clone();
        } else {
          object = null;
        } 
        arrayOfInt2[i] = object;
      } 
      this.L = arrayOfInt2;
    }
    
    int b(int[] param1ArrayOfInt) {
      int[][] arrayOfInt = this.L;
      int i = d();
      for (byte b1 = 0; b1 < i; b1++) {
        if (StateSet.stateSetMatches(arrayOfInt[b1], param1ArrayOfInt))
          return b1; 
      } 
      return -1;
    }
    
    public void e(int param1Int1, int param1Int2) {
      super.e(param1Int1, param1Int2);
      int[][] arrayOfInt = new int[param1Int2][];
      System.arraycopy(this.L, 0, arrayOfInt, 0, param1Int1);
      this.L = arrayOfInt;
    }
    
    public Drawable newDrawable() { return new d(this, null); }
    
    public Drawable newDrawable(Resources param1Resources) { return new d(this, param1Resources); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */