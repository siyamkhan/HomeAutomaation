package a.a.a.a.a.g;

import a.a.a.a.a.b.k;
import org.json.JSONObject;

class k implements v {
  private long a(k paramk, long paramLong, JSONObject paramJSONObject) { return paramJSONObject.has("expires_at") ? paramJSONObject.getLong("expires_at") : (paramk.a() + paramLong * 1000L); }
  
  private e a(JSONObject paramJSONObject) {
    Object object;
    String str1 = paramJSONObject.getString("identifier");
    String str2 = paramJSONObject.getString("status");
    String str3 = paramJSONObject.getString("url");
    String str4 = paramJSONObject.getString("reports_url");
    String str5 = paramJSONObject.getString("ndk_reports_url");
    boolean bool = paramJSONObject.optBoolean("update_required", false);
    if (paramJSONObject.has("icon") && paramJSONObject.getJSONObject("icon").has("hash")) {
      object = b(paramJSONObject.getJSONObject("icon"));
    } else {
      object = null;
    } 
    c c = object;
    return new e(str1, str2, str3, str4, str5, bool, c);
  }
  
  private c b(JSONObject paramJSONObject) { return new c(paramJSONObject.getString("hash"), paramJSONObject.getInt("width"), paramJSONObject.getInt("height")); }
  
  private m c(JSONObject paramJSONObject) {
    boolean bool1 = paramJSONObject.optBoolean("prompt_enabled", false);
    boolean bool2 = paramJSONObject.optBoolean("collect_logged_exceptions", true);
    boolean bool3 = paramJSONObject.optBoolean("collect_reports", true);
    boolean bool4 = paramJSONObject.optBoolean("collect_analytics", false);
    boolean bool5 = paramJSONObject.optBoolean("firebase_crashlytics_enabled", false);
    return new m(bool1, bool2, bool3, bool4, bool5);
  }
  
  private b d(JSONObject paramJSONObject) {
    String str = paramJSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events");
    int i = paramJSONObject.optInt("flush_interval_secs", 600);
    int j = paramJSONObject.optInt("max_byte_size_per_file", 8000);
    int m = paramJSONObject.optInt("max_file_count_per_send", 1);
    int n = paramJSONObject.optInt("max_pending_send_file_count", 100);
    boolean bool1 = paramJSONObject.optBoolean("forward_to_google_analytics", false);
    boolean bool2 = paramJSONObject.optBoolean("include_purchase_events_in_forwarded_events", false);
    boolean bool3 = paramJSONObject.optBoolean("track_custom_events", true);
    boolean bool4 = paramJSONObject.optBoolean("track_predefined_events", true);
    int i1 = paramJSONObject.optInt("sampling_rate", 1);
    boolean bool5 = paramJSONObject.optBoolean("flush_on_background", true);
    return new b(str, i, j, m, n, bool1, bool2, bool3, bool4, i1, bool5);
  }
  
  private p e(JSONObject paramJSONObject) {
    int i = paramJSONObject.optInt("log_buffer_size", 64000);
    int j = paramJSONObject.optInt("max_chained_exception_depth", 8);
    int m = paramJSONObject.optInt("max_custom_exception_events", 64);
    int n = paramJSONObject.optInt("max_custom_key_value_pairs", 64);
    int i1 = paramJSONObject.optInt("identifier_mask", 255);
    boolean bool = paramJSONObject.optBoolean("send_session_without_crash", false);
    int i2 = paramJSONObject.optInt("max_complete_sessions_count", 4);
    return new p(i, j, m, n, i1, bool, i2);
  }
  
  private o f(JSONObject paramJSONObject) {
    String str1 = paramJSONObject.optString("title", "Send Crash Report?");
    String str2 = paramJSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report.");
    String str3 = paramJSONObject.optString("send_button_title", "Send");
    boolean bool1 = paramJSONObject.optBoolean("show_cancel_button", true);
    String str4 = paramJSONObject.optString("cancel_button_title", "Don't Send");
    boolean bool2 = paramJSONObject.optBoolean("show_always_send_button", true);
    String str5 = paramJSONObject.optString("always_send_button_title", "Always Send");
    return new o(str1, str2, str3, bool1, str4, bool2, str5);
  }
  
  private f g(JSONObject paramJSONObject) { return new f(paramJSONObject.optString("update_endpoint", u.a), paramJSONObject.optInt("update_suspend_duration", 3600)); }
  
  public t a(k paramk, JSONObject paramJSONObject) {
    int i = paramJSONObject.optInt("settings_version", 0);
    int j = paramJSONObject.optInt("cache_duration", 3600);
    e e = a(paramJSONObject.getJSONObject("app"));
    p p = e(paramJSONObject.getJSONObject("session"));
    o o = f(paramJSONObject.getJSONObject("prompt"));
    m m = c(paramJSONObject.getJSONObject("features"));
    b b = d(paramJSONObject.getJSONObject("analytics"));
    f f = g(paramJSONObject.getJSONObject("beta"));
    long l = a(paramk, j, paramJSONObject);
    return new t(l, e, p, o, m, b, f, i, j);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\g\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */