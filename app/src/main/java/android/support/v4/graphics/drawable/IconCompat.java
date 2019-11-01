package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
  static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
  
  public int a;
  
  Object b;
  
  public byte[] c;
  
  public Parcelable d;
  
  public int e;
  
  public int f;
  
  public ColorStateList g = null;
  
  PorterDuff.Mode i = h;
  
  public String j;
  
  private static String a(int paramInt) {
    switch (paramInt) {
      default:
        return "UNKNOWN";
      case 5:
        return "BITMAP_MASKABLE";
      case 4:
        return "URI";
      case 3:
        return "DATA";
      case 2:
        return "RESOURCE";
      case 1:
        break;
    } 
    return "BITMAP";
  }
  
  private static String a(Icon paramIcon) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getResPackage(); 
    try {
      return (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException null) {
    
    } catch (NoSuchMethodException noSuchMethodException) {}
    Log.e("IconCompat", "Unable to get icon package", noSuchMethodException);
    return null;
  }
  
  private static int b(Icon paramIcon) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramIcon.getResId(); 
    try {
      return ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
    } catch (IllegalAccessException null) {
    
    } catch (InvocationTargetException null) {
    
    } catch (NoSuchMethodException noSuchMethodException) {}
    Log.e("IconCompat", "Unable to get icon resource", noSuchMethodException);
    return 0;
  }
  
  public String a() {
    if (this.a == -1 && Build.VERSION.SDK_INT >= 23)
      return a((Icon)this.b); 
    if (this.a == 2)
      return ((String)this.b).split(":", -1)[0]; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("called getResPackage() on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void a(boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield i : Landroid/graphics/PorterDuff$Mode;
    //   5: invokevirtual name : ()Ljava/lang/String;
    //   8: putfield j : Ljava/lang/String;
    //   11: aload_0
    //   12: getfield a : I
    //   15: istore_2
    //   16: iload_2
    //   17: iconst_m1
    //   18: if_icmpeq -> 152
    //   21: iload_2
    //   22: tableswitch default -> 56, 1 -> 109, 2 -> 81, 3 -> 69, 4 -> 57, 5 -> 109
    //   56: return
    //   57: aload_0
    //   58: getfield b : Ljava/lang/Object;
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: astore #7
    //   66: goto -> 90
    //   69: aload_0
    //   70: getfield b : Ljava/lang/Object;
    //   73: checkcast [B
    //   76: astore #6
    //   78: goto -> 102
    //   81: aload_0
    //   82: getfield b : Ljava/lang/Object;
    //   85: checkcast java/lang/String
    //   88: astore #7
    //   90: aload #7
    //   92: ldc 'UTF-16'
    //   94: invokestatic forName : (Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   97: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   100: astore #6
    //   102: aload_0
    //   103: aload #6
    //   105: putfield c : [B
    //   108: return
    //   109: iload_1
    //   110: ifeq -> 156
    //   113: aload_0
    //   114: getfield b : Ljava/lang/Object;
    //   117: checkcast android/graphics/Bitmap
    //   120: astore_3
    //   121: new java/io/ByteArrayOutputStream
    //   124: dup
    //   125: invokespecial <init> : ()V
    //   128: astore #4
    //   130: aload_3
    //   131: getstatic android/graphics/Bitmap$CompressFormat.PNG : Landroid/graphics/Bitmap$CompressFormat;
    //   134: bipush #90
    //   136: aload #4
    //   138: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   141: pop
    //   142: aload #4
    //   144: invokevirtual toByteArray : ()[B
    //   147: astore #6
    //   149: goto -> 102
    //   152: iload_1
    //   153: ifne -> 168
    //   156: aload_0
    //   157: aload_0
    //   158: getfield b : Ljava/lang/Object;
    //   161: checkcast android/os/Parcelable
    //   164: putfield d : Landroid/os/Parcelable;
    //   167: return
    //   168: new java/lang/IllegalArgumentException
    //   171: dup
    //   172: ldc 'Can't serialize Icon created with IconCompat#createFromIcon'
    //   174: invokespecial <init> : (Ljava/lang/String;)V
    //   177: athrow }
  
  public int b() {
    if (this.a == -1 && Build.VERSION.SDK_INT >= 23)
      return b((Icon)this.b); 
    if (this.a == 2)
      return this.e; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("called getResId() on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void c() {
    Parcelable parcelable;
    this.i = PorterDuff.Mode.valueOf(this.j);
    int k = this.a;
    if (k != -1) {
      byte[] arrayOfByte;
      String str;
      switch (k) {
        default:
          return;
        case 3:
          arrayOfByte = this.c;
          this.b = arrayOfByte;
          return;
        case 2:
        case 4:
          str = new String(this.c, Charset.forName("UTF-16"));
          this.b = str;
          return;
        case 1:
        case 5:
          break;
      } 
      parcelable = this.d;
      if (parcelable == null) {
        byte[] arrayOfByte1 = this.c;
        this.b = arrayOfByte1;
        this.a = 3;
        this.e = 0;
        this.f = arrayOfByte1.length;
        return;
      } 
    } else {
      parcelable = this.d;
      if (parcelable == null)
        throw new IllegalArgumentException("Invalid icon"); 
    } 
    this.b = parcelable;
  }
  
  public String toString() {
    Object[] arrayOfObject;
    int k;
    if (this.a == -1)
      return String.valueOf(this.b); 
    StringBuilder stringBuilder = new StringBuilder("Icon(typ=");
    stringBuilder.append(a(this.a));
    switch (this.a) {
      case 4:
        stringBuilder.append(" uri=");
        stringBuilder.append(this.b);
        break;
      case 3:
        stringBuilder.append(" len=");
        stringBuilder.append(this.e);
        if (this.f != 0) {
          stringBuilder.append(" off=");
          k = this.f;
        } else {
          break;
        } 
        stringBuilder.append(k);
        break;
      case 2:
        stringBuilder.append(" pkg=");
        stringBuilder.append(a());
        stringBuilder.append(" id=");
        arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(b());
        stringBuilder.append(String.format("0x%08x", arrayOfObject));
        break;
      case 1:
      case 5:
        stringBuilder.append(" size=");
        stringBuilder.append(((Bitmap)this.b).getWidth());
        stringBuilder.append("x");
        k = ((Bitmap)this.b).getHeight();
        stringBuilder.append(k);
        break;
    } 
    if (this.g != null) {
      stringBuilder.append(" tint=");
      stringBuilder.append(this.g);
    } 
    if (this.i != h) {
      stringBuilder.append(" mode=");
      stringBuilder.append(this.i);
    } 
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\drawable\IconCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */