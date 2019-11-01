package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
  private static int a(int paramInt, float paramFloat) {
    int i = Math.round(paramFloat * Color.alpha(paramInt));
    return paramInt & 0xFFFFFF | i << 24;
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme) {
    int i;
    AttributeSet attributeSet = Xml.asAttributeSet(paramXmlPullParser);
    while (true) {
      i = paramXmlPullParser.next();
      if (i != 2 && i != 1)
        continue; 
      break;
    } 
    if (i == 2)
      return a(paramResources, paramXmlPullParser, attributeSet, paramTheme); 
    throw new XmlPullParserException("No start tag found");
  }
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    String str = paramXmlPullParser.getName();
    if (str.equals("selector"))
      return b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": invalid color state list tag ");
    stringBuilder.append(str);
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt) { return (paramTheme == null) ? paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt) : paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0); }
  
  private static ColorStateList b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) { // Byte code:
    //   0: aload_1
    //   1: invokeinterface getDepth : ()I
    //   6: istore #4
    //   8: iconst_1
    //   9: istore #5
    //   11: iload #4
    //   13: iload #5
    //   15: iadd
    //   16: istore #6
    //   18: bipush #20
    //   20: anewarray [I
    //   23: astore #7
    //   25: aload #7
    //   27: arraylength
    //   28: newarray int
    //   30: astore #8
    //   32: iconst_0
    //   33: istore #9
    //   35: aload_1
    //   36: invokeinterface next : ()I
    //   41: istore #10
    //   43: iload #10
    //   45: iload #5
    //   47: if_icmpeq -> 347
    //   50: aload_1
    //   51: invokeinterface getDepth : ()I
    //   56: istore #13
    //   58: iload #13
    //   60: iload #6
    //   62: if_icmpge -> 71
    //   65: iload #10
    //   67: iconst_3
    //   68: if_icmpeq -> 347
    //   71: iload #10
    //   73: iconst_2
    //   74: if_icmpne -> 341
    //   77: iload #13
    //   79: iload #6
    //   81: if_icmpgt -> 341
    //   84: aload_1
    //   85: invokeinterface getName : ()Ljava/lang/String;
    //   90: ldc 'item'
    //   92: invokevirtual equals : (Ljava/lang/Object;)Z
    //   95: ifne -> 101
    //   98: goto -> 341
    //   101: aload_0
    //   102: aload_3
    //   103: aload_2
    //   104: getstatic android/support/a/a$c.ColorStateListItem : [I
    //   107: invokestatic a : (Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   110: astore #14
    //   112: aload #14
    //   114: getstatic android/support/a/a$c.ColorStateListItem_android_color : I
    //   117: ldc -65281
    //   119: invokevirtual getColor : (II)I
    //   122: istore #15
    //   124: fconst_1
    //   125: fstore #16
    //   127: aload #14
    //   129: getstatic android/support/a/a$c.ColorStateListItem_android_alpha : I
    //   132: invokevirtual hasValue : (I)Z
    //   135: ifeq -> 157
    //   138: getstatic android/support/a/a$c.ColorStateListItem_android_alpha : I
    //   141: istore #26
    //   143: aload #14
    //   145: iload #26
    //   147: fload #16
    //   149: invokevirtual getFloat : (IF)F
    //   152: fstore #16
    //   154: goto -> 176
    //   157: aload #14
    //   159: getstatic android/support/a/a$c.ColorStateListItem_alpha : I
    //   162: invokevirtual hasValue : (I)Z
    //   165: ifeq -> 176
    //   168: getstatic android/support/a/a$c.ColorStateListItem_alpha : I
    //   171: istore #26
    //   173: goto -> 143
    //   176: aload #14
    //   178: invokevirtual recycle : ()V
    //   181: aload_2
    //   182: invokeinterface getAttributeCount : ()I
    //   187: istore #17
    //   189: iload #17
    //   191: newarray int
    //   193: astore #18
    //   195: iconst_0
    //   196: istore #19
    //   198: iconst_0
    //   199: istore #20
    //   201: iload #19
    //   203: iload #17
    //   205: if_icmpge -> 283
    //   208: aload_2
    //   209: iload #19
    //   211: invokeinterface getAttributeNameResource : (I)I
    //   216: istore #24
    //   218: iload #24
    //   220: ldc 16843173
    //   222: if_icmpeq -> 277
    //   225: iload #24
    //   227: ldc 16843551
    //   229: if_icmpeq -> 277
    //   232: iload #24
    //   234: getstatic android/support/a/a$a.alpha : I
    //   237: if_icmpeq -> 277
    //   240: iload #20
    //   242: iconst_1
    //   243: iadd
    //   244: istore #25
    //   246: aload_2
    //   247: iload #19
    //   249: iconst_0
    //   250: invokeinterface getAttributeBooleanValue : (IZ)Z
    //   255: ifeq -> 261
    //   258: goto -> 266
    //   261: iload #24
    //   263: ineg
    //   264: istore #24
    //   266: aload #18
    //   268: iload #20
    //   270: iload #24
    //   272: iastore
    //   273: iload #25
    //   275: istore #20
    //   277: iinc #19, 1
    //   280: goto -> 201
    //   283: aload #18
    //   285: iload #20
    //   287: invokestatic trimStateSet : ([II)[I
    //   290: astore #21
    //   292: iload #15
    //   294: fload #16
    //   296: invokestatic a : (IF)I
    //   299: istore #22
    //   301: iload #9
    //   303: ifeq -> 310
    //   306: aload #21
    //   308: arraylength
    //   309: pop
    //   310: aload #8
    //   312: iload #9
    //   314: iload #22
    //   316: invokestatic a : ([III)[I
    //   319: astore #8
    //   321: aload #7
    //   323: iload #9
    //   325: aload #21
    //   327: invokestatic a : ([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;
    //   330: checkcast [[I
    //   333: astore #7
    //   335: iinc #9, 1
    //   338: goto -> 341
    //   341: iconst_1
    //   342: istore #5
    //   344: goto -> 35
    //   347: iload #9
    //   349: newarray int
    //   351: astore #11
    //   353: iload #9
    //   355: anewarray [I
    //   358: astore #12
    //   360: aload #8
    //   362: iconst_0
    //   363: aload #11
    //   365: iconst_0
    //   366: iload #9
    //   368: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   371: aload #7
    //   373: iconst_0
    //   374: aload #12
    //   376: iconst_0
    //   377: iload #9
    //   379: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   382: new android/content/res/ColorStateList
    //   385: dup
    //   386: aload #12
    //   388: aload #11
    //   390: invokespecial <init> : ([[I[I)V
    //   393: areturn }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */