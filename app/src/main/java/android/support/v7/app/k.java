package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.a.c;
import android.util.Log;
import java.util.Calendar;

class k {
  private static k a;
  
  private final Context b;
  
  private final LocationManager c;
  
  private final a d = new a();
  
  k(Context paramContext, LocationManager paramLocationManager) {
    this.b = paramContext;
    this.c = paramLocationManager;
  }
  
  private Location a(String paramString) {
    try {
      if (this.c.isProviderEnabled(paramString))
        return this.c.getLastKnownLocation(paramString); 
    } catch (Exception exception) {
      Log.d("TwilightManager", "Failed to get last known location", exception);
    } 
    return null;
  }
  
  static k a(Context paramContext) {
    if (a == null) {
      Context context = paramContext.getApplicationContext();
      a = new k(context, (LocationManager)context.getSystemService("location"));
    } 
    return a;
  }
  
  private void a(Location paramLocation) {
    long l7;
    boolean bool1;
    a a1 = this.d;
    long l1 = System.currentTimeMillis();
    j j = j.a();
    j.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = j.a;
    j.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (j.c == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    long l3 = j.b;
    long l4 = j.a;
    long l5 = 86400000L + l1;
    double d1 = paramLocation.getLatitude();
    double d2 = paramLocation.getLongitude();
    boolean bool2 = bool1;
    j.a(l5, d1, d2);
    long l6 = j.b;
    if (l3 == -1L || l4 == -1L) {
      l7 = 43200000L + l1;
    } else {
      long l;
      if (l1 > l4) {
        l = 0L + l6;
      } else if (l1 > l3) {
        l = 0L + l4;
      } else {
        l = 0L + l3;
      } 
      l7 = l + 60000L;
    } 
    a1.a = bool2;
    a1.b = l2;
    a1.c = l3;
    a1.d = l4;
    a1.e = l6;
    a1.f = l7;
  }
  
  @SuppressLint({"MissingPermission"})
  private Location b() {
    Location location1;
    if (c.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
      location1 = a("network");
    } else {
      location1 = null;
    } 
    int i = c.a(this.b, "android.permission.ACCESS_FINE_LOCATION");
    Location location2 = null;
    if (i == 0)
      location2 = a("gps"); 
    if (location2 != null && location1 != null) {
      if (location2.getTime() > location1.getTime())
        location1 = location2; 
      return location1;
    } 
    if (location2 != null)
      location1 = location2; 
    return location1;
  }
  
  private boolean c() { return (this.d.f > System.currentTimeMillis()); }
  
  boolean a() {
    a a1 = this.d;
    if (c())
      return a1.a; 
    Location location = b();
    if (location != null) {
      a(location);
      return a1.a;
    } 
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6 || i >= 22);
  }
  
  private static class a {
    boolean a;
    
    long b;
    
    long c;
    
    long d;
    
    long e;
    
    long f;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */