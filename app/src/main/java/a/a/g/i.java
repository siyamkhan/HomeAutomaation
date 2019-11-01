package a.a.a.a.a.g;

import a.a.a.a.a.b.i;
import a.a.a.a.a.f.b;
import a.a.a.a.c;
import a.a.a.a.i;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.jd.gui.api.API;
import org.json.JSONObject;

class i implements g {
  private final i a;
  
  public i(i parami) { this.a = parami; }
  
  public JSONObject a() {
    Closeable closeable;
    c.g().a("Fabric", "Reading cached settings...");
    fileInputStream = null;
    try {
      file = new File((new b(this.a)).a(), "com.crashlytics.settings.json");
    } catch (Exception exception) {
      closeable1 = null;
      c.g().e("Fabric", "Failed to fetch cached settings", exception);
      return null;
    } finally {
      aPI = null;
    } 
    i.a(closeable, "Error while closing settings cache file.");
    throw aPI;
  }
  
  public void a(long paramLong, JSONObject paramJSONObject) {
    c.g().a("Fabric", "Writing settings to cache file...");
    if (paramJSONObject != null) {
      fileWriter = null;
      try {
        paramJSONObject.put("expires_at", paramLong);
        fileWriter1 = new FileWriter(new File((new b(this.a)).a(), "com.crashlytics.settings.json"));
        try {
          fileWriter1.write(paramJSONObject.toString());
          fileWriter1.flush();
          return;
        } catch (Exception null) {
        
        } finally {
          API aPI = null;
        } 
      } catch (Exception exception) {
      
      } finally {
        API aPI;
      } 
      c.g().e("Fabric", "Failed to cache settings", exception);
      i.a(fileWriter, "Failed to close settings writer.");
      return;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */