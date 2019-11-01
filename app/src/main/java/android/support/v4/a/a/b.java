package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;

public final class b {
  private final Shader a;
  
  private final ColorStateList b;
  
  private int c;
  
  private b(Shader paramShader, ColorStateList paramColorStateList, int paramInt) {
    this.a = paramShader;
    this.b = paramColorStateList;
    this.c = paramInt;
  }
  
  static b a(int paramInt) { return new b(null, null, paramInt); }
  
  static b a(ColorStateList paramColorStateList) { return new b(null, paramColorStateList, paramColorStateList.getDefaultColor()); }
  
  public static b a(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    try {
      return b(paramResources, paramInt, paramTheme);
    } catch (Exception exception) {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", exception);
      return null;
    } 
  }
  
  static b a(Shader paramShader) { return new b(paramShader, null, 0); }
  
  private static b b(Resources paramResources, int paramInt, Resources.Theme paramTheme) { // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual getXml : (I)Landroid/content/res/XmlResourceParser;
    //   5: astore_3
    //   6: aload_3
    //   7: invokestatic asAttributeSet : (Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   10: astore #4
    //   12: aload_3
    //   13: invokeinterface next : ()I
    //   18: istore #5
    //   20: iconst_1
    //   21: istore #6
    //   23: iload #5
    //   25: iconst_2
    //   26: if_icmpeq -> 39
    //   29: iload #5
    //   31: iload #6
    //   33: if_icmpeq -> 39
    //   36: goto -> 12
    //   39: iload #5
    //   41: iconst_2
    //   42: if_icmpne -> 206
    //   45: aload_3
    //   46: invokeinterface getName : ()Ljava/lang/String;
    //   51: astore #7
    //   53: aload #7
    //   55: invokevirtual hashCode : ()I
    //   58: istore #8
    //   60: iload #8
    //   62: ldc 89650992
    //   64: if_icmpeq -> 93
    //   67: iload #8
    //   69: ldc 1191572447
    //   71: if_icmpeq -> 77
    //   74: goto -> 106
    //   77: aload #7
    //   79: ldc 'selector'
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 106
    //   87: iconst_0
    //   88: istore #6
    //   90: goto -> 109
    //   93: aload #7
    //   95: ldc 'gradient'
    //   97: invokevirtual equals : (Ljava/lang/Object;)Z
    //   100: ifeq -> 106
    //   103: goto -> 109
    //   106: iconst_m1
    //   107: istore #6
    //   109: iload #6
    //   111: tableswitch default -> 132, 0 -> 194, 1 -> 182
    //   132: new java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: astore #9
    //   141: aload #9
    //   143: aload_3
    //   144: invokeinterface getPositionDescription : ()Ljava/lang/String;
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #9
    //   155: ldc ': unsupported complex color tag '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #9
    //   163: aload #7
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: new org/xmlpull/v1/XmlPullParserException
    //   172: dup
    //   173: aload #9
    //   175: invokevirtual toString : ()Ljava/lang/String;
    //   178: invokespecial <init> : (Ljava/lang/String;)V
    //   181: athrow
    //   182: aload_0
    //   183: aload_3
    //   184: aload #4
    //   186: aload_2
    //   187: invokestatic a : (Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/Shader;
    //   190: invokestatic a : (Landroid/graphics/Shader;)Landroid/support/v4/a/a/b;
    //   193: areturn
    //   194: aload_0
    //   195: aload_3
    //   196: aload #4
    //   198: aload_2
    //   199: invokestatic a : (Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;
    //   202: invokestatic a : (Landroid/content/res/ColorStateList;)Landroid/support/v4/a/a/b;
    //   205: areturn
    //   206: new org/xmlpull/v1/XmlPullParserException
    //   209: dup
    //   210: ldc 'No start tag found'
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: athrow }
  
  public Shader a() { return this.a; }
  
  public boolean a(int[] paramArrayOfInt) {
    if (d()) {
      ColorStateList colorStateList = this.b;
      int i = colorStateList.getColorForState(paramArrayOfInt, colorStateList.getDefaultColor());
      if (i != this.c) {
        this.c = i;
        return true;
      } 
    } 
    return false;
  }
  
  public int b() { return this.c; }
  
  public void b(int paramInt) { this.c = paramInt; }
  
  public boolean c() { return (this.a != null); }
  
  public boolean d() {
    if (this.a == null) {
      ColorStateList colorStateList = this.b;
      if (colorStateList != null && colorStateList.isStateful())
        return true; 
    } 
    return false;
  }
  
  public boolean e() { return (c() || this.c != 0); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */