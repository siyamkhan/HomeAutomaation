package android.support.d.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.a.a.g;
import android.support.v4.graphics.b;
import android.support.v4.graphics.b.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.jd.gui.api.API;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {
  private static int a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser) {
    boolean bool;
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j);
    TypedValue typedValue = g.b(typedArray, paramXmlPullParser, "value", 0);
    if (typedValue != null) {
      bool = true;
    } else {
      bool = false;
    } 
    byte b = 0;
    if (bool) {
      boolean bool1 = a(typedValue.type);
      b = 0;
      if (bool1)
        b = 3; 
    } 
    typedArray.recycle();
    return b;
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2) {
    byte b2;
    byte b1;
    boolean bool2;
    TypedValue typedValue1 = paramTypedArray.peekValue(paramInt1);
    boolean bool1 = true;
    if (typedValue1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool2) {
      b1 = typedValue1.type;
    } else {
      b1 = 0;
    } 
    TypedValue typedValue2 = paramTypedArray.peekValue(paramInt2);
    if (typedValue2 == null)
      bool1 = false; 
    if (bool1) {
      b2 = typedValue2.type;
    } else {
      b2 = 0;
    } 
    if (!bool2 || !a(b1)) {
      byte b = 0;
      if (bool1) {
        boolean bool = a(b2);
        b = 0;
        if (bool)
          return 3; 
      } 
      return b;
    } 
    return 3;
  }
  
  public static Animator a(Context paramContext, int paramInt) { return (Build.VERSION.SDK_INT >= 24) ? AnimatorInflater.loadAnimator(paramContext, paramInt) : a(paramContext, paramContext.getResources(), paramContext.getTheme(), paramInt); }
  
  public static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt) { return a(paramContext, paramResources, paramTheme, paramInt, 1.0F); }
  
  public static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt, float paramFloat) {
    API aPI;
    XmlResourceParser xmlResourceParser = null;
    try {
      xmlResourceParser = paramResources.getAnimation(paramInt);
      Animator animator = a(paramContext, paramResources, paramTheme, xmlResourceParser, paramFloat);
      if (xmlResourceParser != null)
        xmlResourceParser.close(); 
      return animator;
    } catch (XmlPullParserException xmlPullParserException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't load animation resource ID #0x");
      stringBuilder.append(Integer.toHexString(paramInt));
      Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
      notFoundException.initCause(xmlPullParserException);
      throw notFoundException;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't load animation resource ID #0x");
      stringBuilder.append(Integer.toHexString(paramInt));
      Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
      notFoundException.initCause(iOException);
      throw notFoundException;
    } finally {}
    if (xmlResourceParser != null)
      xmlResourceParser.close(); 
    throw aPI;
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, float paramFloat) { return a(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0, paramFloat); }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat) { // Byte code:
    //   0: aload_3
    //   1: invokeinterface getDepth : ()I
    //   6: istore #8
    //   8: aconst_null
    //   9: astore #9
    //   11: aconst_null
    //   12: astore #10
    //   14: aload_3
    //   15: invokeinterface next : ()I
    //   20: istore #11
    //   22: iconst_0
    //   23: istore #12
    //   25: iload #11
    //   27: iconst_3
    //   28: if_icmpne -> 42
    //   31: aload_3
    //   32: invokeinterface getDepth : ()I
    //   37: iload #8
    //   39: if_icmple -> 329
    //   42: iload #11
    //   44: iconst_1
    //   45: if_icmpeq -> 329
    //   48: iload #11
    //   50: iconst_2
    //   51: if_icmpeq -> 57
    //   54: goto -> 14
    //   57: aload_3
    //   58: invokeinterface getName : ()Ljava/lang/String;
    //   63: astore #17
    //   65: aload #17
    //   67: ldc 'objectAnimator'
    //   69: invokevirtual equals : (Ljava/lang/Object;)Z
    //   72: ifeq -> 94
    //   75: aload_0
    //   76: aload_1
    //   77: aload_2
    //   78: aload #4
    //   80: fload #7
    //   82: aload_3
    //   83: invokestatic a : (Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ObjectAnimator;
    //   86: astore #9
    //   88: iconst_0
    //   89: istore #22
    //   91: goto -> 252
    //   94: aload #17
    //   96: ldc 'animator'
    //   98: invokevirtual equals : (Ljava/lang/Object;)Z
    //   101: ifeq -> 121
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: aload #4
    //   109: aconst_null
    //   110: fload #7
    //   112: aload_3
    //   113: invokestatic a : (Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Landroid/animation/ValueAnimator;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ValueAnimator;
    //   116: astore #9
    //   118: goto -> 88
    //   121: aload #17
    //   123: ldc 'set'
    //   125: invokevirtual equals : (Ljava/lang/Object;)Z
    //   128: ifeq -> 198
    //   131: new android/animation/AnimatorSet
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: astore #18
    //   140: aload_1
    //   141: aload_2
    //   142: aload #4
    //   144: getstatic android/support/d/a/a.h : [I
    //   147: invokestatic a : (Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   150: astore #19
    //   152: aload #19
    //   154: aload_3
    //   155: ldc 'ordering'
    //   157: iconst_0
    //   158: iconst_0
    //   159: invokestatic a : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I
    //   162: istore #20
    //   164: aload_0
    //   165: aload_1
    //   166: aload_2
    //   167: aload_3
    //   168: aload #4
    //   170: aload #18
    //   172: checkcast android/animation/AnimatorSet
    //   175: iload #20
    //   177: fload #7
    //   179: invokestatic a : (Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    //   182: pop
    //   183: aload #19
    //   185: invokevirtual recycle : ()V
    //   188: aload #18
    //   190: astore #9
    //   192: iconst_0
    //   193: istore #22
    //   195: goto -> 252
    //   198: aload #17
    //   200: ldc 'propertyValuesHolder'
    //   202: invokevirtual equals : (Ljava/lang/Object;)Z
    //   205: ifeq -> 287
    //   208: aload_0
    //   209: aload_1
    //   210: aload_2
    //   211: aload_3
    //   212: aload_3
    //   213: invokestatic asAttributeSet : (Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   216: invokestatic a : (Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)[Landroid/animation/PropertyValuesHolder;
    //   219: astore #27
    //   221: aload #27
    //   223: ifnull -> 249
    //   226: aload #9
    //   228: ifnull -> 249
    //   231: aload #9
    //   233: instanceof android/animation/ValueAnimator
    //   236: ifeq -> 249
    //   239: aload #9
    //   241: checkcast android/animation/ValueAnimator
    //   244: aload #27
    //   246: invokevirtual setValues : ([Landroid/animation/PropertyValuesHolder;)V
    //   249: iconst_1
    //   250: istore #22
    //   252: aload #5
    //   254: ifnull -> 14
    //   257: iload #22
    //   259: ifne -> 14
    //   262: aload #10
    //   264: ifnonnull -> 276
    //   267: new java/util/ArrayList
    //   270: dup
    //   271: invokespecial <init> : ()V
    //   274: astore #10
    //   276: aload #10
    //   278: aload #9
    //   280: invokevirtual add : (Ljava/lang/Object;)Z
    //   283: pop
    //   284: goto -> 14
    //   287: new java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial <init> : ()V
    //   294: astore #24
    //   296: aload #24
    //   298: ldc 'Unknown animator name: '
    //   300: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload #24
    //   306: aload_3
    //   307: invokeinterface getName : ()Ljava/lang/String;
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: new java/lang/RuntimeException
    //   319: dup
    //   320: aload #24
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokespecial <init> : (Ljava/lang/String;)V
    //   328: athrow
    //   329: aload #5
    //   331: ifnull -> 420
    //   334: aload #10
    //   336: ifnull -> 420
    //   339: aload #10
    //   341: invokevirtual size : ()I
    //   344: anewarray android/animation/Animator
    //   347: astore #13
    //   349: aload #10
    //   351: invokevirtual iterator : ()Ljava/util/Iterator;
    //   354: astore #14
    //   356: aload #14
    //   358: invokeinterface hasNext : ()Z
    //   363: ifeq -> 398
    //   366: aload #14
    //   368: invokeinterface next : ()Ljava/lang/Object;
    //   373: checkcast android/animation/Animator
    //   376: astore #15
    //   378: iload #12
    //   380: iconst_1
    //   381: iadd
    //   382: istore #16
    //   384: aload #13
    //   386: iload #12
    //   388: aload #15
    //   390: aastore
    //   391: iload #16
    //   393: istore #12
    //   395: goto -> 356
    //   398: iload #6
    //   400: ifne -> 413
    //   403: aload #5
    //   405: aload #13
    //   407: invokevirtual playTogether : ([Landroid/animation/Animator;)V
    //   410: aload #9
    //   412: areturn
    //   413: aload #5
    //   415: aload #13
    //   417: invokevirtual playSequentially : ([Landroid/animation/Animator;)V
    //   420: aload #9
    //   422: areturn }
  
  private static Keyframe a(Keyframe paramKeyframe, float paramFloat) { return (paramKeyframe.getType() == float.class) ? Keyframe.ofFloat(paramFloat) : ((paramKeyframe.getType() == int.class) ? Keyframe.ofInt(paramFloat) : Keyframe.ofObject(paramFloat)); }
  
  private static Keyframe a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt, XmlPullParser paramXmlPullParser) {
    Keyframe keyframe;
    boolean bool;
    TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j);
    float f = g.a(typedArray, paramXmlPullParser, "fraction", 3, -1.0F);
    TypedValue typedValue = g.b(typedArray, paramXmlPullParser, "value", 0);
    if (typedValue != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramInt == 4)
      if (bool && a(typedValue.type)) {
        paramInt = 3;
      } else {
        paramInt = 0;
      }  
    if (bool) {
      if (paramInt != 3) {
        switch (paramInt) {
          default:
            keyframe = null;
            break;
          case 0:
            keyframe = Keyframe.ofFloat(f, g.a(typedArray, paramXmlPullParser, "value", 0, 0.0F));
            break;
          case 1:
            keyframe = Keyframe.ofInt(f, g.a(typedArray, paramXmlPullParser, "value", 0, 0));
            break;
        } 
      } else {
      
      } 
    } else if (paramInt == 0) {
      keyframe = Keyframe.ofFloat(f);
    } else {
      keyframe = Keyframe.ofInt(f);
    } 
    int i = g.c(typedArray, paramXmlPullParser, "interpolator", 1, 0);
    if (i > 0)
      keyframe.setInterpolator(d.a(paramContext, i)); 
    typedArray.recycle();
    return keyframe;
  }
  
  private static ObjectAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser) {
    ObjectAnimator objectAnimator = new ObjectAnimator();
    a(paramContext, paramResources, paramTheme, paramAttributeSet, objectAnimator, paramFloat, paramXmlPullParser);
    return objectAnimator;
  }
  
  private static PropertyValuesHolder a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, String paramString, int paramInt) {
    int i = paramInt;
    ArrayList arrayList = null;
    while (true) {
      int j = paramXmlPullParser.next();
      if (j != 3 && j != 1) {
        if (paramXmlPullParser.getName().equals("keyframe")) {
          if (i == 4)
            i = a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramXmlPullParser); 
          Keyframe keyframe = a(paramContext, paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), i, paramXmlPullParser);
          if (keyframe != null) {
            if (arrayList == null)
              arrayList = new ArrayList(); 
            arrayList.add(keyframe);
          } 
          paramXmlPullParser.next();
        } 
        continue;
      } 
      break;
    } 
    PropertyValuesHolder propertyValuesHolder = null;
    if (arrayList != null) {
      int j = arrayList.size();
      propertyValuesHolder = null;
      if (j > 0) {
        byte b = 0;
        Keyframe keyframe1 = (Keyframe)arrayList.get(0);
        Keyframe keyframe2 = (Keyframe)arrayList.get(j - 1);
        float f1 = keyframe2.getFraction();
        if (f1 < 1.0F)
          if (f1 < 0.0F) {
            keyframe2.setFraction(1.0F);
          } else {
            arrayList.add(arrayList.size(), a(keyframe2, 1.0F));
            j++;
          }  
        float f2 = keyframe1.getFraction();
        if (f2 != 0.0F)
          if (f2 < 0.0F) {
            keyframe1.setFraction(0.0F);
          } else {
            arrayList.add(0, a(keyframe1, 0.0F));
            j++;
          }  
        Keyframe[] arrayOfKeyframe = new Keyframe[j];
        arrayList.toArray(arrayOfKeyframe);
        while (b < j) {
          Keyframe keyframe = arrayOfKeyframe[b];
          if (keyframe.getFraction() < 0.0F)
            if (!b) {
              keyframe.setFraction(0.0F);
            } else {
              int k = j - 1;
              if (b == k) {
                keyframe.setFraction(1.0F);
              } else {
                byte b1 = b + true;
                byte b2 = b;
                while (b1 < k && arrayOfKeyframe[b1].getFraction() < 0.0F) {
                  byte b3 = b1 + true;
                  b2 = b1;
                  b1 = b3;
                } 
                a(arrayOfKeyframe, arrayOfKeyframe[b2 + 1].getFraction() - arrayOfKeyframe[b - true].getFraction(), b, b2);
              } 
            }  
          b++;
        } 
        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(paramString, arrayOfKeyframe);
        if (i == 3)
          propertyValuesHolder.setEvaluator(f.a()); 
      } 
    } 
    return propertyValuesHolder;
  }
  
  private static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString) { // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: invokevirtual peekValue : (I)Landroid/util/TypedValue;
    //   5: astore #5
    //   7: aload #5
    //   9: ifnull -> 18
    //   12: iconst_1
    //   13: istore #6
    //   15: goto -> 21
    //   18: iconst_0
    //   19: istore #6
    //   21: iload #6
    //   23: ifeq -> 36
    //   26: aload #5
    //   28: getfield type : I
    //   31: istore #7
    //   33: goto -> 39
    //   36: iconst_0
    //   37: istore #7
    //   39: aload_0
    //   40: iload_3
    //   41: invokevirtual peekValue : (I)Landroid/util/TypedValue;
    //   44: astore #8
    //   46: aload #8
    //   48: ifnull -> 57
    //   51: iconst_1
    //   52: istore #9
    //   54: goto -> 60
    //   57: iconst_0
    //   58: istore #9
    //   60: iload #9
    //   62: ifeq -> 75
    //   65: aload #8
    //   67: getfield type : I
    //   70: istore #10
    //   72: goto -> 78
    //   75: iconst_0
    //   76: istore #10
    //   78: iload_1
    //   79: iconst_4
    //   80: if_icmpne -> 116
    //   83: iload #6
    //   85: ifeq -> 96
    //   88: iload #7
    //   90: invokestatic a : (I)Z
    //   93: ifne -> 109
    //   96: iload #9
    //   98: ifeq -> 114
    //   101: iload #10
    //   103: invokestatic a : (I)Z
    //   106: ifeq -> 114
    //   109: iconst_3
    //   110: istore_1
    //   111: goto -> 116
    //   114: iconst_0
    //   115: istore_1
    //   116: iload_1
    //   117: ifne -> 126
    //   120: iconst_1
    //   121: istore #11
    //   123: goto -> 129
    //   126: iconst_0
    //   127: istore #11
    //   129: iload_1
    //   130: iconst_2
    //   131: if_icmpne -> 330
    //   134: aload_0
    //   135: iload_2
    //   136: invokevirtual getString : (I)Ljava/lang/String;
    //   139: astore #21
    //   141: aload_0
    //   142: iload_3
    //   143: invokevirtual getString : (I)Ljava/lang/String;
    //   146: astore #22
    //   148: aload #21
    //   150: invokestatic b : (Ljava/lang/String;)[Landroid/support/v4/graphics/b$b;
    //   153: astore #23
    //   155: aload #22
    //   157: invokestatic b : (Ljava/lang/String;)[Landroid/support/v4/graphics/b$b;
    //   160: astore #24
    //   162: aload #23
    //   164: ifnonnull -> 175
    //   167: aconst_null
    //   168: astore #13
    //   170: aload #24
    //   172: ifnull -> 725
    //   175: aload #23
    //   177: ifnull -> 300
    //   180: new android/support/d/a/e$a
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore #25
    //   189: aload #24
    //   191: ifnull -> 279
    //   194: aload #23
    //   196: aload #24
    //   198: invokestatic a : ([Landroid/support/v4/graphics/b$b;[Landroid/support/v4/graphics/b$b;)Z
    //   201: ifeq -> 223
    //   204: iconst_2
    //   205: anewarray java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload #23
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: aload #24
    //   217: aastore
    //   218: astore #26
    //   220: goto -> 290
    //   223: new java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial <init> : ()V
    //   230: astore #27
    //   232: aload #27
    //   234: ldc_w ' Can't morph from '
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload #27
    //   243: aload #21
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload #27
    //   251: ldc_w ' to '
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload #27
    //   260: aload #22
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: new android/view/InflateException
    //   269: dup
    //   270: aload #27
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: invokespecial <init> : (Ljava/lang/String;)V
    //   278: athrow
    //   279: iconst_1
    //   280: anewarray java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: aload #23
    //   287: aastore
    //   288: astore #26
    //   290: aload #4
    //   292: aload #25
    //   294: aload #26
    //   296: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   299: areturn
    //   300: aconst_null
    //   301: astore #13
    //   303: aload #24
    //   305: ifnull -> 725
    //   308: aload #4
    //   310: new android/support/d/a/e$a
    //   313: dup
    //   314: invokespecial <init> : ()V
    //   317: iconst_1
    //   318: anewarray java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: aload #24
    //   325: aastore
    //   326: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   329: areturn
    //   330: iload_1
    //   331: iconst_3
    //   332: if_icmpne -> 343
    //   335: invokestatic a : ()Landroid/support/d/a/f;
    //   338: astore #12
    //   340: goto -> 346
    //   343: aconst_null
    //   344: astore #12
    //   346: iload #11
    //   348: ifeq -> 499
    //   351: iload #6
    //   353: ifeq -> 452
    //   356: iload #7
    //   358: iconst_5
    //   359: if_icmpne -> 373
    //   362: aload_0
    //   363: iload_2
    //   364: fconst_0
    //   365: invokevirtual getDimension : (IF)F
    //   368: fstore #19
    //   370: goto -> 381
    //   373: aload_0
    //   374: iload_2
    //   375: fconst_0
    //   376: invokevirtual getFloat : (IF)F
    //   379: fstore #19
    //   381: iload #9
    //   383: ifeq -> 434
    //   386: iload #10
    //   388: iconst_5
    //   389: if_icmpne -> 403
    //   392: aload_0
    //   393: iload_3
    //   394: fconst_0
    //   395: invokevirtual getDimension : (IF)F
    //   398: fstore #20
    //   400: goto -> 411
    //   403: aload_0
    //   404: iload_3
    //   405: fconst_0
    //   406: invokevirtual getFloat : (IF)F
    //   409: fstore #20
    //   411: aload #4
    //   413: iconst_2
    //   414: newarray float
    //   416: dup
    //   417: iconst_0
    //   418: fload #19
    //   420: fastore
    //   421: dup
    //   422: iconst_1
    //   423: fload #20
    //   425: fastore
    //   426: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   429: astore #18
    //   431: goto -> 492
    //   434: aload #4
    //   436: iconst_1
    //   437: newarray float
    //   439: dup
    //   440: iconst_0
    //   441: fload #19
    //   443: fastore
    //   444: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   447: astore #18
    //   449: goto -> 492
    //   452: iload #10
    //   454: iconst_5
    //   455: if_icmpne -> 469
    //   458: aload_0
    //   459: iload_3
    //   460: fconst_0
    //   461: invokevirtual getDimension : (IF)F
    //   464: fstore #17
    //   466: goto -> 477
    //   469: aload_0
    //   470: iload_3
    //   471: fconst_0
    //   472: invokevirtual getFloat : (IF)F
    //   475: fstore #17
    //   477: aload #4
    //   479: iconst_1
    //   480: newarray float
    //   482: dup
    //   483: iconst_0
    //   484: fload #17
    //   486: fastore
    //   487: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   490: astore #18
    //   492: aload #18
    //   494: astore #13
    //   496: goto -> 708
    //   499: iload #6
    //   501: ifeq -> 640
    //   504: iload #7
    //   506: iconst_5
    //   507: if_icmpne -> 522
    //   510: aload_0
    //   511: iload_2
    //   512: fconst_0
    //   513: invokevirtual getDimension : (IF)F
    //   516: f2i
    //   517: istore #15
    //   519: goto -> 549
    //   522: iload #7
    //   524: invokestatic a : (I)Z
    //   527: ifeq -> 541
    //   530: aload_0
    //   531: iload_2
    //   532: iconst_0
    //   533: invokevirtual getColor : (II)I
    //   536: istore #15
    //   538: goto -> 549
    //   541: aload_0
    //   542: iload_2
    //   543: iconst_0
    //   544: invokevirtual getInt : (II)I
    //   547: istore #15
    //   549: iload #9
    //   551: ifeq -> 622
    //   554: iload #10
    //   556: iconst_5
    //   557: if_icmpne -> 572
    //   560: aload_0
    //   561: iload_3
    //   562: fconst_0
    //   563: invokevirtual getDimension : (IF)F
    //   566: f2i
    //   567: istore #16
    //   569: goto -> 599
    //   572: iload #10
    //   574: invokestatic a : (I)Z
    //   577: ifeq -> 591
    //   580: aload_0
    //   581: iload_3
    //   582: iconst_0
    //   583: invokevirtual getColor : (II)I
    //   586: istore #16
    //   588: goto -> 599
    //   591: aload_0
    //   592: iload_3
    //   593: iconst_0
    //   594: invokevirtual getInt : (II)I
    //   597: istore #16
    //   599: aload #4
    //   601: iconst_2
    //   602: newarray int
    //   604: dup
    //   605: iconst_0
    //   606: iload #15
    //   608: iastore
    //   609: dup
    //   610: iconst_1
    //   611: iload #16
    //   613: iastore
    //   614: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   617: astore #13
    //   619: goto -> 708
    //   622: aload #4
    //   624: iconst_1
    //   625: newarray int
    //   627: dup
    //   628: iconst_0
    //   629: iload #15
    //   631: iastore
    //   632: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   635: astore #13
    //   637: goto -> 708
    //   640: aconst_null
    //   641: astore #13
    //   643: iload #9
    //   645: ifeq -> 708
    //   648: iload #10
    //   650: iconst_5
    //   651: if_icmpne -> 666
    //   654: aload_0
    //   655: iload_3
    //   656: fconst_0
    //   657: invokevirtual getDimension : (IF)F
    //   660: f2i
    //   661: istore #14
    //   663: goto -> 693
    //   666: iload #10
    //   668: invokestatic a : (I)Z
    //   671: ifeq -> 685
    //   674: aload_0
    //   675: iload_3
    //   676: iconst_0
    //   677: invokevirtual getColor : (II)I
    //   680: istore #14
    //   682: goto -> 693
    //   685: aload_0
    //   686: iload_3
    //   687: iconst_0
    //   688: invokevirtual getInt : (II)I
    //   691: istore #14
    //   693: aload #4
    //   695: iconst_1
    //   696: newarray int
    //   698: dup
    //   699: iconst_0
    //   700: iload #14
    //   702: iastore
    //   703: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   706: astore #13
    //   708: aload #13
    //   710: ifnull -> 725
    //   713: aload #12
    //   715: ifnull -> 725
    //   718: aload #13
    //   720: aload #12
    //   722: invokevirtual setEvaluator : (Landroid/animation/TypeEvaluator;)V
    //   725: aload #13
    //   727: areturn }
  
  private static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser) {
    TypedArray typedArray1 = g.a(paramResources, paramTheme, paramAttributeSet, a.g);
    TypedArray typedArray2 = g.a(paramResources, paramTheme, paramAttributeSet, a.k);
    if (paramValueAnimator == null)
      paramValueAnimator = new ValueAnimator(); 
    a(paramValueAnimator, typedArray1, typedArray2, paramFloat, paramXmlPullParser);
    int i = g.c(typedArray1, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0)
      paramValueAnimator.setInterpolator(d.a(paramContext, i)); 
    typedArray1.recycle();
    if (typedArray2 != null)
      typedArray2.recycle(); 
    return paramValueAnimator;
  }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray, int paramInt, float paramFloat, XmlPullParser paramXmlPullParser) { // Byte code:
    //   0: aload_0
    //   1: checkcast android/animation/ObjectAnimator
    //   4: astore #5
    //   6: aload_1
    //   7: aload #4
    //   9: ldc_w 'pathData'
    //   12: iconst_1
    //   13: invokestatic a : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   16: astore #6
    //   18: aload #6
    //   20: ifnull -> 126
    //   23: aload_1
    //   24: aload #4
    //   26: ldc_w 'propertyXName'
    //   29: iconst_2
    //   30: invokestatic a : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   33: astore #7
    //   35: aload_1
    //   36: aload #4
    //   38: ldc_w 'propertyYName'
    //   41: iconst_3
    //   42: invokestatic a : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   45: astore #8
    //   47: iload_2
    //   48: iconst_2
    //   49: if_icmpeq -> 52
    //   52: aload #7
    //   54: ifnonnull -> 106
    //   57: aload #8
    //   59: ifnull -> 65
    //   62: goto -> 106
    //   65: new java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial <init> : ()V
    //   72: astore #9
    //   74: aload #9
    //   76: aload_1
    //   77: invokevirtual getPositionDescription : ()Ljava/lang/String;
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload #9
    //   86: ldc_w ' propertyXName or propertyYName is needed for PathData'
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: new android/view/InflateException
    //   96: dup
    //   97: aload #9
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokespecial <init> : (Ljava/lang/String;)V
    //   105: athrow
    //   106: aload #6
    //   108: invokestatic a : (Ljava/lang/String;)Landroid/graphics/Path;
    //   111: aload #5
    //   113: fload_3
    //   114: ldc_w 0.5
    //   117: fmul
    //   118: aload #7
    //   120: aload #8
    //   122: invokestatic a : (Landroid/graphics/Path;Landroid/animation/ObjectAnimator;FLjava/lang/String;Ljava/lang/String;)V
    //   125: return
    //   126: aload #5
    //   128: aload_1
    //   129: aload #4
    //   131: ldc_w 'propertyName'
    //   134: iconst_0
    //   135: invokestatic a : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   138: invokevirtual setPropertyName : (Ljava/lang/String;)V
    //   141: return }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser) {
    long l1 = g.a(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = g.a(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int i = g.a(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    if (g.a(paramXmlPullParser, "valueFrom") && g.a(paramXmlPullParser, "valueTo")) {
      if (i == 4)
        i = a(paramTypedArray1, 5, 6); 
      PropertyValuesHolder propertyValuesHolder = a(paramTypedArray1, i, 5, 6, "");
      if (propertyValuesHolder != null)
        paramValueAnimator.setValues(new PropertyValuesHolder[] { propertyValuesHolder }); 
    } 
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(g.a(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(g.a(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null)
      a(paramValueAnimator, paramTypedArray2, i, paramFloat, paramXmlPullParser); 
  }
  
  private static void a(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2) {
    Object object;
    PathMeasure pathMeasure1 = new PathMeasure(paramPath, false);
    ArrayList arrayList = new ArrayList();
    arrayList.add(Float.valueOf(0.0F));
    float f1 = 0.0F;
    do {
      f1 += pathMeasure1.getLength();
      arrayList.add(Float.valueOf(f1));
    } while (pathMeasure1.nextContour());
    PathMeasure pathMeasure2 = new PathMeasure(paramPath, false);
    int i = Math.min(100, 1 + (int)(f1 / paramFloat));
    float[] arrayOfFloat1 = new float[i];
    float[] arrayOfFloat2 = new float[i];
    float[] arrayOfFloat3 = new float[2];
    float f2 = f1 / (i - 1);
    byte b1 = 0;
    float f3 = 0.0F;
    byte b2 = 0;
    while (b1 < i) {
      pathMeasure2.getPosTan(f3 - ((Float)arrayList.get(b2)).floatValue(), arrayOfFloat3, null);
      arrayOfFloat1[b1] = arrayOfFloat3[0];
      arrayOfFloat2[b1] = arrayOfFloat3[1];
      f3 += f2;
      byte b = b2 + 1;
      if (b < arrayList.size() && f3 > ((Float)arrayList.get(b)).floatValue()) {
        pathMeasure2.nextContour();
        b2 = b;
      } 
      b1++;
    } 
    if (paramString1 != null) {
      object = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat1);
    } else {
      object = null;
    } 
    PropertyValuesHolder propertyValuesHolder = null;
    if (paramString2 != null)
      propertyValuesHolder = PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat2); 
    if (object == null) {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { propertyValuesHolder });
      return;
    } 
    if (propertyValuesHolder == null) {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { object });
      return;
    } 
    paramObjectAnimator.setValues(new PropertyValuesHolder[] { object, propertyValuesHolder });
  }
  
  private static void a(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2) {
    float f = paramFloat / (2 + paramInt2 - paramInt1);
    while (paramInt1 <= paramInt2) {
      paramArrayOfKeyframe[paramInt1].setFraction(f + paramArrayOfKeyframe[paramInt1 - 1].getFraction());
      paramInt1++;
    } 
  }
  
  private static boolean a(int paramInt) { return (paramInt >= 28 && paramInt <= 31); }
  
  private static PropertyValuesHolder[] a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {
    byte b;
    ArrayList arrayList = null;
    while (true) {
      int i = paramXmlPullParser.getEventType();
      b = 0;
      if (i != 3 && i != 1) {
        if (i == 2 && paramXmlPullParser.getName().equals("propertyValuesHolder")) {
          TypedArray typedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.i);
          String str = g.a(typedArray, paramXmlPullParser, "propertyName", 3);
          int j = g.a(typedArray, paramXmlPullParser, "valueType", 2, 4);
          PropertyValuesHolder propertyValuesHolder = a(paramContext, paramResources, paramTheme, paramXmlPullParser, str, j);
          if (propertyValuesHolder == null)
            propertyValuesHolder = a(typedArray, j, 0, 1, str); 
          if (propertyValuesHolder != null) {
            if (arrayList == null)
              arrayList = new ArrayList(); 
            arrayList.add(propertyValuesHolder);
          } 
          typedArray.recycle();
        } 
        paramXmlPullParser.next();
        continue;
      } 
      break;
    } 
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = null;
    if (arrayList != null) {
      int i = arrayList.size();
      arrayOfPropertyValuesHolder = new PropertyValuesHolder[i];
      while (b < i) {
        arrayOfPropertyValuesHolder[b] = (PropertyValuesHolder)arrayList.get(b);
        b++;
      } 
    } 
    return arrayOfPropertyValuesHolder;
  }
  
  private static class a extends Object implements TypeEvaluator<b.b[]> {
    private b.b[] a;
    
    public b.b[] a(float param1Float, b.b[] param1ArrayOfb1, b.b[] param1ArrayOfb2) {
      if (b.a(param1ArrayOfb1, param1ArrayOfb2)) {
        b.b[] arrayOfb = this.a;
        if (arrayOfb == null || !b.a(arrayOfb, param1ArrayOfb1))
          this.a = b.a(param1ArrayOfb1); 
        for (byte b1 = 0; b1 < param1ArrayOfb1.length; b1++)
          this.a[b1].a(param1ArrayOfb1[b1], param1ArrayOfb2[b1], param1Float); 
        return this.a;
      } 
      throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\d\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */