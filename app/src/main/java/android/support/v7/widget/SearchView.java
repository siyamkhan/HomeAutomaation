package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.h.a;
import android.support.v4.h.r;
import android.support.v4.widget.d;
import android.support.v7.a.a;
import android.support.v7.view.c;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends as implements c {
  static final a i = new a();
  
  private c A;
  
  private b B;
  
  private d C;
  
  private View.OnClickListener D;
  
  private boolean E;
  
  private boolean F;
  
  private boolean G;
  
  private CharSequence H;
  
  private boolean I;
  
  private boolean J;
  
  private int K;
  
  private boolean L;
  
  private CharSequence M;
  
  private CharSequence N;
  
  private boolean O;
  
  private int P;
  
  private Bundle Q;
  
  private final Runnable R = new Runnable(this) {
      public void run() { this.a.d(); }
    };
  
  private Runnable S = new Runnable(this) {
      public void run() {
        if (this.a.g != null && this.a.g instanceof bg)
          this.a.g.a(null); 
      }
    };
  
  private final WeakHashMap<String, Drawable.ConstantState> T = new WeakHashMap();
  
  private final View.OnClickListener U = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        if (param1View == this.a.b) {
          this.a.g();
          return;
        } 
        if (param1View == this.a.d) {
          this.a.f();
          return;
        } 
        if (param1View == this.a.c) {
          this.a.e();
          return;
        } 
        if (param1View == this.a.e) {
          this.a.h();
          return;
        } 
        if (param1View == this.a.a)
          this.a.l(); 
      }
    };
  
  private final TextView.OnEditorActionListener V = new TextView.OnEditorActionListener(this) {
      public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
        this.a.e();
        return true;
      }
    };
  
  private final AdapterView.OnItemClickListener W = new AdapterView.OnItemClickListener(this) {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) { this.a.a(param1Int, 0, null); }
    };
  
  final SearchAutoComplete a;
  
  private final AdapterView.OnItemSelectedListener aa = new AdapterView.OnItemSelectedListener(this) {
      public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) { this.a.a(param1Int); }
      
      public void onNothingSelected(AdapterView<?> param1AdapterView) {}
    };
  
  private TextWatcher ab = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {}
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) { this.a.b(param1CharSequence); }
    };
  
  final ImageView b;
  
  final ImageView c;
  
  final ImageView d;
  
  final ImageView e;
  
  View.OnFocusChangeListener f;
  
  d g;
  
  SearchableInfo h;
  
  View.OnKeyListener j = new View.OnKeyListener(this) {
      public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
        if (this.a.h == null)
          return false; 
        if (this.a.a.isPopupShowing() && this.a.a.getListSelection() != -1)
          return this.a.a(param1View, param1Int, param1KeyEvent); 
        if (!this.a.a.a() && param1KeyEvent.hasNoModifiers() && param1KeyEvent.getAction() == 1 && param1Int == 66) {
          param1View.cancelLongPress();
          SearchView searchView = this.a;
          searchView.a(0, null, searchView.a.getText().toString());
          return true;
        } 
        return false;
      }
    };
  
  private final View k;
  
  private final View l;
  
  private final View m;
  
  private final View n;
  
  private f o;
  
  private Rect p = new Rect();
  
  private Rect q = new Rect();
  
  private int[] r = new int[2];
  
  private int[] s = new int[2];
  
  private final ImageView t;
  
  private final Drawable u;
  
  private final int v;
  
  private final int w;
  
  private final Intent x;
  
  private final Intent y;
  
  private final CharSequence z;
  
  public SearchView(Context paramContext) { this(paramContext, null); }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.searchViewStyle); }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    bm bm = bm.a(paramContext, paramAttributeSet, a.j.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(bm.g(a.j.SearchView_layout, a.g.abc_search_view), this, true);
    this.a = (SearchAutoComplete)findViewById(a.f.search_src_text);
    this.a.setSearchView(this);
    this.k = findViewById(a.f.search_edit_frame);
    this.l = findViewById(a.f.search_plate);
    this.m = findViewById(a.f.submit_area);
    this.b = (ImageView)findViewById(a.f.search_button);
    this.c = (ImageView)findViewById(a.f.search_go_btn);
    this.d = (ImageView)findViewById(a.f.search_close_btn);
    this.e = (ImageView)findViewById(a.f.search_voice_btn);
    this.t = (ImageView)findViewById(a.f.search_mag_icon);
    r.a(this.l, bm.a(a.j.SearchView_queryBackground));
    r.a(this.m, bm.a(a.j.SearchView_submitBackground));
    this.b.setImageDrawable(bm.a(a.j.SearchView_searchIcon));
    this.c.setImageDrawable(bm.a(a.j.SearchView_goIcon));
    this.d.setImageDrawable(bm.a(a.j.SearchView_closeIcon));
    this.e.setImageDrawable(bm.a(a.j.SearchView_voiceIcon));
    this.t.setImageDrawable(bm.a(a.j.SearchView_searchIcon));
    this.u = bm.a(a.j.SearchView_searchHintIcon);
    bo.a(this.b, getResources().getString(a.h.abc_searchview_description_search));
    this.v = bm.g(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
    this.w = bm.g(a.j.SearchView_commitIcon, 0);
    this.b.setOnClickListener(this.U);
    this.d.setOnClickListener(this.U);
    this.c.setOnClickListener(this.U);
    this.e.setOnClickListener(this.U);
    this.a.setOnClickListener(this.U);
    this.a.addTextChangedListener(this.ab);
    this.a.setOnEditorActionListener(this.V);
    this.a.setOnItemClickListener(this.W);
    this.a.setOnItemSelectedListener(this.aa);
    this.a.setOnKeyListener(this.j);
    this.a.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public void onFocusChange(View param1View, boolean param1Boolean) {
            if (this.a.f != null)
              this.a.f.onFocusChange(this.a, param1Boolean); 
          }
        });
    setIconifiedByDefault(bm.a(a.j.SearchView_iconifiedByDefault, true));
    int i1 = bm.e(a.j.SearchView_android_maxWidth, -1);
    if (i1 != -1)
      setMaxWidth(i1); 
    this.z = bm.c(a.j.SearchView_defaultQueryHint);
    this.H = bm.c(a.j.SearchView_queryHint);
    int i2 = bm.a(a.j.SearchView_android_imeOptions, -1);
    if (i2 != -1)
      setImeOptions(i2); 
    int i3 = bm.a(a.j.SearchView_android_inputType, -1);
    if (i3 != -1)
      setInputType(i3); 
    setFocusable(bm.a(a.j.SearchView_android_focusable, true));
    bm.a();
    this.x = new Intent("android.speech.action.WEB_SEARCH");
    this.x.addFlags(268435456);
    this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.y.addFlags(268435456);
    this.n = findViewById(this.a.getDropDownAnchor());
    View view = this.n;
    if (view != null)
      view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) { this.a.k(); }
          }); 
    a(this.E);
    r();
  }
  
  private Intent a(Intent paramIntent, SearchableInfo paramSearchableInfo) {
    String str;
    Intent intent = new Intent(paramIntent);
    ComponentName componentName = paramSearchableInfo.getSearchActivity();
    if (componentName == null) {
      str = null;
    } else {
      str = componentName.flattenToShortString();
    } 
    intent.putExtra("calling_package", str);
    return intent;
  }
  
  private Intent a(Cursor paramCursor, int paramInt, String paramString) {
    String str1;
    try {
      str1 = bg.a(paramCursor, "suggest_intent_action");
      if (str1 == null)
        str1 = this.h.getSuggestIntentAction(); 
    } catch (RuntimeException runtimeException) {
      byte b1;
      try {
        b1 = paramCursor.getPosition();
      } catch (RuntimeException runtimeException1) {
        b1 = -1;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Search suggestions cursor at row ");
      stringBuilder.append(b1);
      stringBuilder.append(" returned exception.");
      Log.w("SearchView", stringBuilder.toString(), runtimeException);
      return null;
    } 
    if (str1 == null)
      str1 = "android.intent.action.SEARCH"; 
    String str2 = str1;
    String str3 = bg.a(paramCursor, "suggest_intent_data");
    if (str3 == null)
      str3 = this.h.getSuggestIntentData(); 
    if (str3 != null) {
      String str = bg.a(paramCursor, "suggest_intent_data_id");
      if (str != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("/");
        stringBuilder.append(Uri.encode(str));
        str3 = stringBuilder.toString();
      } 
    } 
    if (str3 == null) {
      Uri uri1 = null;
      String str = bg.a(paramCursor, "suggest_intent_query");
      return a(str2, uri1, bg.a(paramCursor, "suggest_intent_extra_data"), str, paramInt, paramString);
    } 
    Uri uri = Uri.parse(str3);
    String str4 = bg.a(paramCursor, "suggest_intent_query");
    return a(str2, uri, bg.a(paramCursor, "suggest_intent_extra_data"), str4, paramInt, paramString);
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4) {
    Intent intent = new Intent(paramString1);
    intent.addFlags(268435456);
    if (paramUri != null)
      intent.setData(paramUri); 
    intent.putExtra("user_query", this.N);
    if (paramString3 != null)
      intent.putExtra("query", paramString3); 
    if (paramString2 != null)
      intent.putExtra("intent_extra_data_key", paramString2); 
    Bundle bundle = this.Q;
    if (bundle != null)
      intent.putExtra("app_data", bundle); 
    if (paramInt != 0) {
      intent.putExtra("action_key", paramInt);
      intent.putExtra("action_msg", paramString4);
    } 
    intent.setComponent(this.h.getSearchActivity());
    return intent;
  }
  
  private void a(Intent paramIntent) {
    if (paramIntent == null)
      return; 
    try {
      getContext().startActivity(paramIntent);
      return;
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed launch activity: ");
      stringBuilder.append(paramIntent);
      Log.e("SearchView", stringBuilder.toString(), runtimeException);
      return;
    } 
  }
  
  private void a(View paramView, Rect paramRect) {
    paramView.getLocationInWindow(this.r);
    getLocationInWindow(this.s);
    int[] arrayOfInt1 = this.r;
    int i1 = arrayOfInt1[1];
    int[] arrayOfInt2 = this.s;
    int i2 = i1 - arrayOfInt2[1];
    int i3 = arrayOfInt1[0] - arrayOfInt2[0];
    paramRect.set(i3, i2, i3 + paramView.getWidth(), i2 + paramView.getHeight());
  }
  
  private void a(boolean paramBoolean) {
    byte b3;
    byte b2;
    this.F = paramBoolean;
    byte b1 = 8;
    if (paramBoolean) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    boolean bool1 = true ^ TextUtils.isEmpty(this.a.getText());
    this.b.setVisibility(b2);
    b(bool1);
    View view = this.k;
    if (paramBoolean) {
      b3 = 8;
    } else {
      b3 = 0;
    } 
    view.setVisibility(b3);
    if (this.t.getDrawable() != null && !this.E)
      b1 = 0; 
    this.t.setVisibility(b1);
    p();
    boolean bool2 = false;
    if (!bool1)
      bool2 = true; 
    c(bool2);
    o();
  }
  
  static boolean a(Context paramContext) { return ((paramContext.getResources().getConfiguration()).orientation == 2); }
  
  private Intent b(Intent paramIntent, SearchableInfo paramSearchableInfo) {
    String str4;
    String str3;
    String str2;
    ComponentName componentName = paramSearchableInfo.getSearchActivity();
    Intent intent1 = new Intent("android.intent.action.SEARCH");
    intent1.setComponent(componentName);
    PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent1, 1073741824);
    Bundle bundle1 = new Bundle();
    Bundle bundle2 = this.Q;
    if (bundle2 != null)
      bundle1.putParcelable("app_data", bundle2); 
    Intent intent2 = new Intent(paramIntent);
    String str1 = "free_form";
    int i1 = 1;
    Resources resources = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0)
      str1 = resources.getString(paramSearchableInfo.getVoiceLanguageModeId()); 
    if (paramSearchableInfo.getVoicePromptTextId() != 0) {
      str2 = resources.getString(paramSearchableInfo.getVoicePromptTextId());
    } else {
      str2 = null;
    } 
    if (paramSearchableInfo.getVoiceLanguageId() != 0) {
      str3 = resources.getString(paramSearchableInfo.getVoiceLanguageId());
    } else {
      str3 = null;
    } 
    if (paramSearchableInfo.getVoiceMaxResults() != 0)
      i1 = paramSearchableInfo.getVoiceMaxResults(); 
    intent2.putExtra("android.speech.extra.LANGUAGE_MODEL", str1);
    intent2.putExtra("android.speech.extra.PROMPT", str2);
    intent2.putExtra("android.speech.extra.LANGUAGE", str3);
    intent2.putExtra("android.speech.extra.MAX_RESULTS", i1);
    if (componentName == null) {
      str4 = null;
    } else {
      str4 = componentName.flattenToShortString();
    } 
    intent2.putExtra("calling_package", str4);
    intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pendingIntent);
    intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle1);
    return intent2;
  }
  
  private void b(boolean paramBoolean) {
    byte b1;
    if (this.G && n() && hasFocus() && (paramBoolean || !this.L)) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    this.c.setVisibility(b1);
  }
  
  private boolean b(int paramInt1, int paramInt2, String paramString) {
    Cursor cursor = this.g.a();
    if (cursor != null && cursor.moveToPosition(paramInt1)) {
      a(a(cursor, paramInt2, paramString));
      return true;
    } 
    return false;
  }
  
  private CharSequence c(CharSequence paramCharSequence) {
    if (this.E) {
      if (this.u == null)
        return paramCharSequence; 
      double d1 = this.a.getTextSize();
      Double.isNaN(d1);
      int i1 = (int)(d1 * 1.25D);
      this.u.setBounds(0, 0, i1, i1);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
      spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
      spannableStringBuilder.append(paramCharSequence);
      return spannableStringBuilder;
    } 
    return paramCharSequence;
  }
  
  private void c(boolean paramBoolean) {
    byte b1;
    if (this.L && !c() && paramBoolean) {
      this.c.setVisibility(8);
      b1 = 0;
    } else {
      b1 = 8;
    } 
    this.e.setVisibility(b1);
  }
  
  private void e(int paramInt) {
    Editable editable = this.a.getText();
    Cursor cursor = this.g.a();
    if (cursor == null)
      return; 
    if (cursor.moveToPosition(paramInt)) {
      CharSequence charSequence = this.g.c(cursor);
      if (charSequence != null) {
        setQuery(charSequence);
        return;
      } 
    } 
    setQuery(editable);
  }
  
  private int getPreferredHeight() { return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height); }
  
  private int getPreferredWidth() { return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width); }
  
  private boolean m() {
    SearchableInfo searchableInfo = this.h;
    boolean bool = false;
    if (searchableInfo != null) {
      boolean bool1 = searchableInfo.getVoiceSearchEnabled();
      bool = false;
      if (bool1) {
        Intent intent;
        if (this.h.getVoiceSearchLaunchWebSearch()) {
          intent = this.x;
        } else {
          boolean bool2 = this.h.getVoiceSearchLaunchRecognizer();
          intent = null;
          if (bool2)
            intent = this.y; 
        } 
        bool = false;
        if (intent != null) {
          ResolveInfo resolveInfo = getContext().getPackageManager().resolveActivity(intent, 65536);
          bool = false;
          if (resolveInfo != null)
            bool = true; 
        } 
      } 
    } 
    return bool;
  }
  
  private boolean n() { return ((this.G || this.L) && !c()); }
  
  private void o() {
    byte b1;
    if (n() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    this.m.setVisibility(b1);
  }
  
  private void p() {
    byte b1;
    boolean bool1 = TextUtils.isEmpty(this.a.getText());
    boolean bool = true;
    boolean bool2 = bool1 ^ bool;
    if (!bool2 && (!this.E || this.O))
      bool = false; 
    ImageView imageView = this.d;
    if (bool) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    imageView.setVisibility(b1);
    Drawable drawable = this.d.getDrawable();
    if (drawable != null) {
      int[] arrayOfInt;
      if (bool2) {
        arrayOfInt = ENABLED_STATE_SET;
      } else {
        arrayOfInt = EMPTY_STATE_SET;
      } 
      drawable.setState(arrayOfInt);
    } 
  }
  
  private void q() { post(this.R); }
  
  private void r() {
    CharSequence charSequence = getQueryHint();
    SearchAutoComplete searchAutoComplete = this.a;
    if (charSequence == null)
      charSequence = ""; 
    searchAutoComplete.setHint(c(charSequence));
  }
  
  private void s() {
    this.a.setThreshold(this.h.getSuggestThreshold());
    this.a.setImeOptions(this.h.getImeOptions());
    int i1 = this.h.getInputType();
    int i2 = i1 & 0xF;
    byte b1 = 1;
    if (i2 == b1) {
      i1 &= 0xFFFEFFFF;
      if (this.h.getSuggestAuthority() != null)
        i1 = 0x80000 | i1 | 0x10000; 
    } 
    this.a.setInputType(i1);
    d d1 = this.g;
    if (d1 != null)
      d1.a(null); 
    if (this.h.getSuggestAuthority() != null) {
      this.g = new bg(getContext(), this, this.h, this.T);
      this.a.setAdapter(this.g);
      bg bg = (bg)this.g;
      if (this.I)
        b1 = 2; 
      bg.a(b1);
    } 
  }
  
  private void setQuery(CharSequence paramCharSequence) {
    int i1;
    this.a.setText(paramCharSequence);
    SearchAutoComplete searchAutoComplete = this.a;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i1 = 0;
    } else {
      i1 = paramCharSequence.length();
    } 
    searchAutoComplete.setSelection(i1);
  }
  
  private void t() { this.a.dismissDropDown(); }
  
  public void a() {
    if (this.O)
      return; 
    this.O = true;
    this.P = this.a.getImeOptions();
    this.a.setImeOptions(0x2000000 | this.P);
    this.a.setText("");
    setIconified(false);
  }
  
  void a(int paramInt, String paramString1, String paramString2) {
    Intent intent = a("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(intent);
  }
  
  void a(CharSequence paramCharSequence) { setQuery(paramCharSequence); }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean) {
    this.a.setText(paramCharSequence);
    if (paramCharSequence != null) {
      SearchAutoComplete searchAutoComplete = this.a;
      searchAutoComplete.setSelection(searchAutoComplete.length());
      this.N = paramCharSequence;
    } 
    if (paramBoolean && !TextUtils.isEmpty(paramCharSequence))
      e(); 
  }
  
  boolean a(int paramInt) {
    d d1 = this.C;
    if (d1 == null || !d1.a(paramInt)) {
      e(paramInt);
      return true;
    } 
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString) {
    d d1 = this.C;
    if (d1 == null || !d1.b(paramInt1)) {
      b(paramInt1, 0, null);
      this.a.setImeVisibility(false);
      t();
      return true;
    } 
    return false;
  }
  
  boolean a(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (this.h == null)
      return false; 
    if (this.g == null)
      return false; 
    if (paramKeyEvent.getAction() == 0 && paramKeyEvent.hasNoModifiers()) {
      if (paramInt == 66 || paramInt == 84 || paramInt == 61)
        return a(this.a.getListSelection(), 0, null); 
      if (paramInt == 21 || paramInt == 22) {
        int i1;
        if (paramInt == 21) {
          i1 = 0;
        } else {
          i1 = this.a.length();
        } 
        this.a.setSelection(i1);
        this.a.setListSelection(0);
        this.a.clearListSelection();
        i.a(this.a, true);
        return true;
      } 
      if (paramInt == 19 && this.a.getListSelection() == 0)
        return false; 
    } 
    return false;
  }
  
  public void b() {
    a("", false);
    clearFocus();
    a(true);
    this.a.setImeOptions(this.P);
    this.O = false;
  }
  
  void b(CharSequence paramCharSequence) {
    Editable editable = this.a.getText();
    this.N = editable;
    boolean bool1 = TextUtils.isEmpty(editable);
    boolean bool2 = true;
    boolean bool3 = bool1 ^ bool2;
    b(bool3);
    if (bool3)
      bool2 = false; 
    c(bool2);
    p();
    o();
    if (this.A != null && !TextUtils.equals(paramCharSequence, this.M))
      this.A.b(paramCharSequence.toString()); 
    this.M = paramCharSequence.toString();
  }
  
  public boolean c() { return this.F; }
  
  public void clearFocus() {
    this.J = true;
    super.clearFocus();
    this.a.clearFocus();
    this.a.setImeVisibility(false);
    this.J = false;
  }
  
  void d() {
    int[] arrayOfInt;
    if (this.a.hasFocus()) {
      arrayOfInt = FOCUSED_STATE_SET;
    } else {
      arrayOfInt = EMPTY_STATE_SET;
    } 
    Drawable drawable1 = this.l.getBackground();
    if (drawable1 != null)
      drawable1.setState(arrayOfInt); 
    Drawable drawable2 = this.m.getBackground();
    if (drawable2 != null)
      drawable2.setState(arrayOfInt); 
    invalidate();
  }
  
  void e() {
    Editable editable = this.a.getText();
    if (editable != null && TextUtils.getTrimmedLength(editable) > 0) {
      c c1 = this.A;
      if (c1 == null || !c1.a(editable.toString())) {
        if (this.h != null)
          a(0, null, editable.toString()); 
        this.a.setImeVisibility(false);
        t();
      } 
    } 
  }
  
  void f() {
    if (TextUtils.isEmpty(this.a.getText())) {
      if (this.E) {
        b b1 = this.B;
        if (b1 == null || !b1.a()) {
          clearFocus();
          a(true);
          return;
        } 
      } 
    } else {
      this.a.setText("");
      this.a.requestFocus();
      this.a.setImeVisibility(true);
    } 
  }
  
  void g() {
    a(false);
    this.a.requestFocus();
    this.a.setImeVisibility(true);
    View.OnClickListener onClickListener = this.D;
    if (onClickListener != null)
      onClickListener.onClick(this); 
  }
  
  public int getImeOptions() { return this.a.getImeOptions(); }
  
  public int getInputType() { return this.a.getInputType(); }
  
  public int getMaxWidth() { return this.K; }
  
  public CharSequence getQuery() { return this.a.getText(); }
  
  public CharSequence getQueryHint() {
    CharSequence charSequence = this.H;
    if (charSequence != null)
      return charSequence; 
    SearchableInfo searchableInfo = this.h;
    return (searchableInfo != null && searchableInfo.getHintId() != 0) ? getContext().getText(this.h.getHintId()) : this.z;
  }
  
  int getSuggestionCommitIconResId() { return this.w; }
  
  int getSuggestionRowLayout() { return this.v; }
  
  public d getSuggestionsAdapter() { return this.g; }
  
  void h() {
    SearchableInfo searchableInfo = this.h;
    if (searchableInfo == null)
      return; 
    try {
      Intent intent;
      if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
        intent = a(this.x, searchableInfo);
      } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
        intent = b(this.y, searchableInfo);
      } else {
        return;
      } 
      getContext().startActivity(intent);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.w("SearchView", "Could not find voice search activity");
    } 
  }
  
  void i() {
    a(c());
    q();
    if (this.a.hasFocus())
      l(); 
  }
  
  void k() {
    if (this.n.getWidth() > 1) {
      int i3;
      int i2;
      Resources resources = getContext().getResources();
      int i1 = this.l.getPaddingLeft();
      Rect rect = new Rect();
      boolean bool = bu.a(this);
      if (this.E) {
        i2 = resources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left);
      } else {
        i2 = 0;
      } 
      this.a.getDropDownBackground().getPadding(rect);
      if (bool) {
        i3 = -rect.left;
      } else {
        i3 = i1 - i2 + rect.left;
      } 
      this.a.setDropDownHorizontalOffset(i3);
      int i4 = i2 + this.n.getWidth() + rect.left + rect.right - i1;
      this.a.setDropDownWidth(i4);
    } 
  }
  
  void l() {
    i.a(this.a);
    i.b(this.a);
  }
  
  protected void onDetachedFromWindow() {
    removeCallbacks(this.R);
    post(this.S);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(this.a, this.p);
      this.q.set(this.p.left, 0, this.p.right, paramInt4 - paramInt2);
      f f1 = this.o;
      if (f1 == null) {
        this.o = new f(this.q, this.p, this.a);
        setTouchDelegate(this.o);
        return;
      } 
      f1.a(this.q, this.p);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual c : ()Z
    //   4: ifeq -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: iload_2
    //   10: invokespecial onMeasure : (II)V
    //   13: return
    //   14: iload_1
    //   15: invokestatic getMode : (I)I
    //   18: istore_3
    //   19: iload_1
    //   20: invokestatic getSize : (I)I
    //   23: istore #4
    //   25: iload_3
    //   26: ldc_w -2147483648
    //   29: if_icmpeq -> 83
    //   32: iload_3
    //   33: ifeq -> 60
    //   36: iload_3
    //   37: ldc_w 1073741824
    //   40: if_icmpeq -> 46
    //   43: goto -> 112
    //   46: aload_0
    //   47: getfield K : I
    //   50: istore #5
    //   52: iload #5
    //   54: ifle -> 112
    //   57: goto -> 94
    //   60: aload_0
    //   61: getfield K : I
    //   64: istore #4
    //   66: iload #4
    //   68: ifle -> 74
    //   71: goto -> 112
    //   74: aload_0
    //   75: invokespecial getPreferredWidth : ()I
    //   78: istore #4
    //   80: goto -> 112
    //   83: aload_0
    //   84: getfield K : I
    //   87: istore #5
    //   89: iload #5
    //   91: ifle -> 97
    //   94: goto -> 103
    //   97: aload_0
    //   98: invokespecial getPreferredWidth : ()I
    //   101: istore #5
    //   103: iload #5
    //   105: iload #4
    //   107: invokestatic min : (II)I
    //   110: istore #4
    //   112: iload_2
    //   113: invokestatic getMode : (I)I
    //   116: istore #6
    //   118: iload_2
    //   119: invokestatic getSize : (I)I
    //   122: istore #7
    //   124: iload #6
    //   126: ldc_w -2147483648
    //   129: if_icmpeq -> 149
    //   132: iload #6
    //   134: ifeq -> 140
    //   137: goto -> 160
    //   140: aload_0
    //   141: invokespecial getPreferredHeight : ()I
    //   144: istore #7
    //   146: goto -> 160
    //   149: aload_0
    //   150: invokespecial getPreferredHeight : ()I
    //   153: iload #7
    //   155: invokestatic min : (II)I
    //   158: istore #7
    //   160: aload_0
    //   161: iload #4
    //   163: ldc_w 1073741824
    //   166: invokestatic makeMeasureSpec : (II)I
    //   169: iload #7
    //   171: ldc_w 1073741824
    //   174: invokestatic makeMeasureSpec : (II)I
    //   177: invokespecial onMeasure : (II)V
    //   180: return }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof e)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    e e1 = (e)paramParcelable;
    super.onRestoreInstanceState(e1.a());
    a(e1.a);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState() {
    e e1 = new e(super.onSaveInstanceState());
    e1.a = c();
    return e1;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    q();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect) {
    if (this.J)
      return false; 
    if (!isFocusable())
      return false; 
    if (!c()) {
      boolean bool = this.a.requestFocus(paramInt, paramRect);
      if (bool)
        a(false); 
      return bool;
    } 
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle) { this.Q = paramBundle; }
  
  public void setIconified(boolean paramBoolean) {
    if (paramBoolean) {
      f();
      return;
    } 
    g();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean) {
    if (this.E == paramBoolean)
      return; 
    this.E = paramBoolean;
    a(paramBoolean);
    r();
  }
  
  public void setImeOptions(int paramInt) { this.a.setImeOptions(paramInt); }
  
  public void setInputType(int paramInt) { this.a.setInputType(paramInt); }
  
  public void setMaxWidth(int paramInt) {
    this.K = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb) { this.B = paramb; }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) { this.f = paramOnFocusChangeListener; }
  
  public void setOnQueryTextListener(c paramc) { this.A = paramc; }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener) { this.D = paramOnClickListener; }
  
  public void setOnSuggestionListener(d paramd) { this.C = paramd; }
  
  public void setQueryHint(CharSequence paramCharSequence) {
    this.H = paramCharSequence;
    r();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean) {
    this.I = paramBoolean;
    d d1 = this.g;
    if (d1 instanceof bg) {
      byte b1;
      bg bg = (bg)d1;
      if (paramBoolean) {
        b1 = 2;
      } else {
        b1 = 1;
      } 
      bg.a(b1);
    } 
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo) {
    this.h = paramSearchableInfo;
    if (this.h != null) {
      s();
      r();
    } 
    this.L = m();
    if (this.L)
      this.a.setPrivateImeOptions("nm"); 
    a(c());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean) {
    this.G = paramBoolean;
    a(c());
  }
  
  public void setSuggestionsAdapter(d paramd) {
    this.g = paramd;
    this.a.setAdapter(this.g);
  }
  
  public static class SearchAutoComplete extends f {
    final Runnable a = new Runnable(this) {
        public void run() { this.a.b(); }
      };
    
    private int b = getThreshold();
    
    private SearchView c;
    
    private boolean d;
    
    public SearchAutoComplete(Context param1Context, AttributeSet param1AttributeSet) { this(param1Context, param1AttributeSet, a.a.autoCompleteTextViewStyle); }
    
    public SearchAutoComplete(Context param1Context, AttributeSet param1AttributeSet, int param1Int) { super(param1Context, param1AttributeSet, param1Int); }
    
    private int getSearchViewTextMinWidthDp() {
      Configuration configuration = getResources().getConfiguration();
      int i = configuration.screenWidthDp;
      int j = configuration.screenHeightDp;
      return (i >= 960 && j >= 720 && configuration.orientation == 2) ? 256 : ((i >= 600 || (i >= 640 && j >= 480)) ? 192 : 160);
    }
    
    boolean a() { return (TextUtils.getTrimmedLength(getText()) == 0); }
    
    void b() {
      if (this.d) {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        this.d = false;
      } 
    }
    
    public boolean enoughToFilter() { return (this.b <= 0 || super.enoughToFilter()); }
    
    public InputConnection onCreateInputConnection(EditorInfo param1EditorInfo) {
      InputConnection inputConnection = super.onCreateInputConnection(param1EditorInfo);
      if (this.d) {
        removeCallbacks(this.a);
        post(this.a);
      } 
      return inputConnection;
    }
    
    protected void onFinishInflate() {
      super.onFinishInflate();
      DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), displayMetrics));
    }
    
    protected void onFocusChanged(boolean param1Boolean, int param1Int, Rect param1Rect) {
      super.onFocusChanged(param1Boolean, param1Int, param1Rect);
      this.c.i();
    }
    
    public boolean onKeyPreIme(int param1Int, KeyEvent param1KeyEvent) {
      if (param1Int == 4) {
        if (param1KeyEvent.getAction() == 0 && param1KeyEvent.getRepeatCount() == 0) {
          KeyEvent.DispatcherState dispatcherState = getKeyDispatcherState();
          if (dispatcherState != null)
            dispatcherState.startTracking(param1KeyEvent, this); 
          return true;
        } 
        if (param1KeyEvent.getAction() == 1) {
          KeyEvent.DispatcherState dispatcherState = getKeyDispatcherState();
          if (dispatcherState != null)
            dispatcherState.handleUpEvent(param1KeyEvent); 
          if (param1KeyEvent.isTracking() && !param1KeyEvent.isCanceled()) {
            this.c.clearFocus();
            setImeVisibility(false);
            return true;
          } 
        } 
      } 
      return super.onKeyPreIme(param1Int, param1KeyEvent);
    }
    
    public void onWindowFocusChanged(boolean param1Boolean) {
      super.onWindowFocusChanged(param1Boolean);
      if (param1Boolean && this.c.hasFocus() && getVisibility() == 0) {
        this.d = true;
        if (SearchView.a(getContext()))
          SearchView.i.a(this, true); 
      } 
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence param1CharSequence) {}
    
    void setImeVisibility(boolean param1Boolean) {
      InputMethodManager inputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!param1Boolean) {
        this.d = false;
        removeCallbacks(this.a);
        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      } 
      if (inputMethodManager.isActive(this)) {
        this.d = false;
        removeCallbacks(this.a);
        inputMethodManager.showSoftInput(this, 0);
        return;
      } 
      this.d = true;
    }
    
    void setSearchView(SearchView param1SearchView) { this.c = param1SearchView; }
    
    public void setThreshold(int param1Int) {
      super.setThreshold(param1Int);
      this.b = param1Int;
    }
  }
  
  class null implements Runnable {
    null(SearchView this$0) {}
    
    public void run() { this.a.b(); }
  }
  
  private static class a {
    private Method a;
    
    private Method b;
    
    private Method c;
    
    a() {
      try {
        this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.a.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        try {
          null;
          this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.b.setAccessible(true);
        } catch (NoSuchMethodException noSuchMethodException1) {
          try {
            null;
            Class[] arrayOfClass = new Class[1];
            arrayOfClass[0] = boolean.class;
            this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", arrayOfClass);
            this.c.setAccessible(true);
          } catch (NoSuchMethodException noSuchMethodException2) {}
        } 
      } 
      this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
      this.b.setAccessible(true);
    }
    
    void a(AutoCompleteTextView param1AutoCompleteTextView) { // Byte code:
      //   0: aload_0
      //   1: getfield a : Ljava/lang/reflect/Method;
      //   4: astore_2
      //   5: aload_2
      //   6: ifnull -> 22
      //   9: aload_2
      //   10: aload_1
      //   11: iconst_0
      //   12: anewarray java/lang/Object
      //   15: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   18: pop
      //   19: goto -> 23
      //   22: pop
      //   23: return
      // Exception table:
      //   from	to	target	type
      //   9	19	22	java/lang/Exception }
    
    void a(AutoCompleteTextView param1AutoCompleteTextView, boolean param1Boolean) { // Byte code:
      //   0: aload_0
      //   1: getfield c : Ljava/lang/reflect/Method;
      //   4: astore_3
      //   5: aload_3
      //   6: ifnull -> 34
      //   9: iconst_1
      //   10: anewarray java/lang/Object
      //   13: astore #5
      //   15: aload #5
      //   17: iconst_0
      //   18: iload_2
      //   19: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   22: aastore
      //   23: aload_3
      //   24: aload_1
      //   25: aload #5
      //   27: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   30: pop
      //   31: goto -> 35
      //   34: pop
      //   35: return
      // Exception table:
      //   from	to	target	type
      //   9	31	34	java/lang/Exception }
    
    void b(AutoCompleteTextView param1AutoCompleteTextView) { // Byte code:
      //   0: aload_0
      //   1: getfield b : Ljava/lang/reflect/Method;
      //   4: astore_2
      //   5: aload_2
      //   6: ifnull -> 22
      //   9: aload_2
      //   10: aload_1
      //   11: iconst_0
      //   12: anewarray java/lang/Object
      //   15: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   18: pop
      //   19: goto -> 23
      //   22: pop
      //   23: return
      // Exception table:
      //   from	to	target	type
      //   9	19	22	java/lang/Exception }
  }
  
  public static interface b {
    boolean a();
  }
  
  public static interface c {
    boolean a(String param1String);
    
    boolean b(String param1String);
  }
  
  public static interface d {
    boolean a(int param1Int);
    
    boolean b(int param1Int);
  }
  
  static class e extends a {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>() {
        public SearchView.e a(Parcel param2Parcel) { return new SearchView.e(param2Parcel, null); }
        
        public SearchView.e a(Parcel param2Parcel, ClassLoader param2ClassLoader) { return new SearchView.e(param2Parcel, param2ClassLoader); }
        
        public SearchView.e[] a(int param2Int) { return new SearchView.e[param2Int]; }
      };
    
    boolean a;
    
    public e(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = ((Boolean)param1Parcel.readValue(null)).booleanValue();
    }
    
    e(Parcelable param1Parcelable) { super(param1Parcelable); }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SearchView.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" isIconified=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeValue(Boolean.valueOf(this.a));
    }
  }
  
  static final class null extends Object implements Parcelable.ClassLoaderCreator<e> {
    public SearchView.e a(Parcel param1Parcel) { return new SearchView.e(param1Parcel, null); }
    
    public SearchView.e a(Parcel param1Parcel, ClassLoader param1ClassLoader) { return new SearchView.e(param1Parcel, param1ClassLoader); }
    
    public SearchView.e[] a(int param1Int) { return new SearchView.e[param1Int]; }
  }
  
  private static class f extends TouchDelegate {
    private final View a;
    
    private final Rect b;
    
    private final Rect c;
    
    private final Rect d;
    
    private final int e;
    
    private boolean f;
    
    public f(Rect param1Rect1, Rect param1Rect2, View param1View) {
      super(param1Rect1, param1View);
      this.e = ViewConfiguration.get(param1View.getContext()).getScaledTouchSlop();
      this.b = new Rect();
      this.d = new Rect();
      this.c = new Rect();
      a(param1Rect1, param1Rect2);
      this.a = param1View;
    }
    
    public void a(Rect param1Rect1, Rect param1Rect2) {
      this.b.set(param1Rect1);
      this.d.set(param1Rect1);
      Rect rect = this.d;
      int i = this.e;
      rect.inset(-i, -i);
      this.c.set(param1Rect2);
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      boolean bool1;
      int i = (int)param1MotionEvent.getX();
      int j = (int)param1MotionEvent.getY();
      int k = param1MotionEvent.getAction();
      boolean bool = true;
      switch (k) {
        default:
          bool1 = false;
          break;
        case 3:
          bool1 = this.f;
          this.f = false;
          break;
        case 1:
        case 2:
          bool1 = this.f;
          if (bool1 && !this.d.contains(i, j))
            bool = false; 
          break;
        case 0:
          if (this.b.contains(i, j)) {
            this.f = bool;
            bool1 = true;
            break;
          } 
      } 
      boolean bool2 = false;
      if (bool1) {
        int m;
        float f1;
        if (bool && !this.c.contains(i, j)) {
          f1 = (this.a.getWidth() / 2);
          m = this.a.getHeight() / 2;
        } else {
          f1 = (i - this.c.left);
          m = j - this.c.top;
        } 
        param1MotionEvent.setLocation(f1, m);
        bool2 = this.a.dispatchTouchEvent(param1MotionEvent);
      } 
      return bool2;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */