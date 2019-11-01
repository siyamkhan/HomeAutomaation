package android.support.v4.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jd.gui.api.API;

public class i {
  public static File a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(".font");
    stringBuilder.append(Process.myPid());
    stringBuilder.append("-");
    stringBuilder.append(Process.myTid());
    stringBuilder.append("-");
    String str = stringBuilder.toString();
    for (byte b = 0; b < 100; b++) {
      File file1 = paramContext.getCacheDir();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(b);
      File file2 = new File(file1, stringBuilder1.toString());
      boolean bool = file2.createNewFile();
      if (bool)
        return file2; 
    } 
    return null;
  }
  
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt) {
    file = a(paramContext);
    if (file == null)
      return null; 
    try {
      boolean bool = a(file, paramResources, paramInt);
      if (!bool)
        return null; 
      return a(file);
    } finally {
      file.delete();
    } 
  }
  
  public static ByteBuffer a(Context paramContext, CancellationSignal paramCancellationSignal, Uri paramUri) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    try {
      API aPI;
      Object object;
      parcelFileDescriptor = contentResolver.openFileDescriptor(paramUri, "r", paramCancellationSignal);
      if (parcelFileDescriptor == null) {
        if (parcelFileDescriptor != null)
          parcelFileDescriptor.close(); 
        return null;
      } 
      try {
        API aPI1;
        Object object1;
        fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
        try {
          FileChannel fileChannel = fileInputStream.getChannel();
          long l = fileChannel.size();
          return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, l);
        } catch (Throwable throwable) {
          try {
            throw throwable;
          } finally {
            API aPI2 = null;
            object1 = throwable;
          } 
        } finally {
          aPI1 = null;
        } 
        if (object1 != null) {
          try {
            fileInputStream.close();
          } catch (Throwable throwable) {
            object1.addSuppressed(throwable);
          } 
        } else {
          fileInputStream.close();
        } 
        throw aPI1;
      } catch (Throwable throwable) {
        try {
          throw throwable;
        } finally {
          API aPI1 = null;
          object = throwable;
        } 
      } finally {
        aPI = null;
      } 
      if (parcelFileDescriptor != null)
        if (object != null) {
          try {
            parcelFileDescriptor.close();
          } catch (Throwable throwable) {
            object.addSuppressed(throwable);
          } 
        } else {
          parcelFileDescriptor.close();
        }  
      throw aPI;
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  private static ByteBuffer a(File paramFile) {
    try {
      API aPI;
      Object object;
      fileInputStream = new FileInputStream(paramFile);
      try {
        FileChannel fileChannel = fileInputStream.getChannel();
        long l = fileChannel.size();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, l);
      } catch (Throwable throwable) {
        try {
          throw throwable;
        } finally {
          API aPI1 = null;
          object = throwable;
        } 
      } finally {
        aPI = null;
      } 
      if (object != null) {
        try {
          fileInputStream.close();
        } catch (Throwable throwable) {
          object.addSuppressed(throwable);
        } 
      } else {
        fileInputStream.close();
      } 
      throw aPI;
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  public static void a(Closeable paramCloseable) { // Byte code:
    //   0: aload_0
    //   1: ifnull -> 13
    //   4: aload_0
    //   5: invokeinterface close : ()V
    //   10: goto -> 14
    //   13: pop
    //   14: return
    // Exception table:
    //   from	to	target	type
    //   4	10	13	java/io/IOException }
  
  public static boolean a(File paramFile, Resources paramResources, int paramInt) {
    API aPI;
    try {
      closeable = paramResources.openRawResource(paramInt);
    } finally {
      aPI = null;
    } 
    a(closeable);
    throw aPI;
  }
  
  public static boolean a(File paramFile, InputStream paramInputStream) {
    threadPolicy = StrictMode.allowThreadDiskWrites();
    fileOutputStream = null;
    try {
      fileOutputStream1 = new FileOutputStream(paramFile, false);
      try {
        byte[] arrayOfByte = new byte[1024];
        while (true) {
          int j = paramInputStream.read(arrayOfByte);
          if (j != -1) {
            fileOutputStream1.write(arrayOfByte, 0, j);
            continue;
          } 
          break;
        } 
        a(fileOutputStream1);
        return true;
      } catch (IOException null) {
      
      } finally {
        API aPI = null;
      } 
    } catch (IOException iOException) {
    
    } finally {
      API aPI;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Error copying resource contents to temp file: ");
    stringBuilder.append(iOException.getMessage());
    Log.e("TypefaceCompatUtil", stringBuilder.toString());
    a(fileOutputStream);
    StrictMode.setThreadPolicy(threadPolicy);
    return false;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */