package android.support.v4.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.e.b;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.jd.gui.api.API;

class d extends h {
  private File a(ParcelFileDescriptor paramParcelFileDescriptor) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/proc/self/fd/");
    stringBuilder.append(paramParcelFileDescriptor.getFd());
    String str = Os.readlink(stringBuilder.toString());
    return OsConstants.S_ISREG((Os.stat(str)).st_mode) ? new File(str) : null;
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, b.b[] paramArrayOfb, int paramInt) {
    if (paramArrayOfb.length < 1)
      return null; 
    b.b b1 = a(paramArrayOfb, paramInt);
    ContentResolver contentResolver = paramContext.getContentResolver();
    try {
      API aPI;
      Object object;
      parcelFileDescriptor = contentResolver.openFileDescriptor(b1.a(), "r", paramCancellationSignal);
      try {
        File file = a(parcelFileDescriptor);
        if (file == null || !file.canRead()) {
          API aPI1;
          Object object1;
          fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
          try {
            return a(paramContext, fileInputStream);
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
        } 
        return Typeface.createFromFile(file);
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
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\graphics\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */