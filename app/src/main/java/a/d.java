package a.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

class d extends ContextWrapper {
  private final String a;
  
  private final String b;
  
  public d(Context paramContext, String paramString1, String paramString2) {
    super(paramContext);
    this.b = paramString1;
    this.a = paramString2;
  }
  
  public File getCacheDir() { return new File(super.getCacheDir(), this.a); }
  
  public File getDatabasePath(String paramString) {
    File file = new File(super.getDatabasePath(paramString).getParentFile(), this.a);
    file.mkdirs();
    return new File(file, paramString);
  }
  
  @TargetApi(8)
  public File getExternalCacheDir() { return new File(super.getExternalCacheDir(), this.a); }
  
  @TargetApi(8)
  public File getExternalFilesDir(String paramString) { return new File(super.getExternalFilesDir(paramString), this.a); }
  
  public File getFilesDir() { return new File(super.getFilesDir(), this.a); }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append(":");
    stringBuilder.append(paramString);
    return super.getSharedPreferences(stringBuilder.toString(), paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory) { return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString), paramCursorFactory); }
  
  @TargetApi(11)
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler) { return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getPath(), paramCursorFactory, paramDatabaseErrorHandler); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */