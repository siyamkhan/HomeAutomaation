package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.a.a;
import android.support.v4.widget.l;
import android.support.v7.a.a;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class bg extends l implements View.OnClickListener {
  private final SearchManager j = (SearchManager)this.d.getSystemService("search");
  
  private final SearchView k;
  
  private final SearchableInfo l;
  
  private final Context m;
  
  private final WeakHashMap<String, Drawable.ConstantState> n;
  
  private final int o;
  
  private boolean p = false;
  
  private int q = 1;
  
  private ColorStateList r;
  
  private int s = -1;
  
  private int t = -1;
  
  private int u = -1;
  
  private int v = -1;
  
  private int w = -1;
  
  private int x = -1;
  
  public bg(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap) {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.k = paramSearchView;
    this.l = paramSearchableInfo;
    this.o = paramSearchView.getSuggestionCommitIconResId();
    this.m = paramContext;
    this.n = paramWeakHashMap;
  }
  
  private Drawable a(ComponentName paramComponentName) {
    Drawable.ConstantState constantState;
    String str = paramComponentName.flattenToShortString();
    if (this.n.containsKey(str)) {
      Drawable.ConstantState constantState1 = (Drawable.ConstantState)this.n.get(str);
      return (constantState1 == null) ? null : constantState1.newDrawable(this.m.getResources());
    } 
    Drawable drawable = b(paramComponentName);
    if (drawable == null) {
      constantState = null;
    } else {
      constantState = drawable.getConstantState();
    } 
    this.n.put(str, constantState);
    return drawable;
  }
  
  private Drawable a(String paramString) {
    Drawable drawable = null;
    if (paramString != null) {
      boolean bool = paramString.isEmpty();
      drawable = null;
      if (!bool) {
        if ("0".equals(paramString))
          return null; 
        try {
          int i = Integer.parseInt(paramString);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("android.resource://");
          stringBuilder.append(this.m.getPackageName());
          stringBuilder.append("/");
          stringBuilder.append(i);
          String str = stringBuilder.toString();
          Drawable drawable1 = b(str);
          if (drawable1 != null)
            return drawable1; 
          Drawable drawable2 = a.a(this.m, i);
          a(str, drawable2);
          return drawable2;
        } catch (NumberFormatException numberFormatException) {
          Drawable drawable1 = b(paramString);
          if (drawable1 != null)
            return drawable1; 
          drawable = b(Uri.parse(paramString));
          a(paramString, drawable);
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Icon resource not found: ");
          stringBuilder.append(paramString);
          Log.w("SuggestionsAdapter", stringBuilder.toString());
          return null;
        } 
      } 
    } 
    return drawable;
  }
  
  private static String a(Cursor paramCursor, int paramInt) {
    if (paramInt == -1)
      return null; 
    try {
      return paramCursor.getString(paramInt);
    } catch (Exception exception) {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", exception);
      return null;
    } 
  }
  
  public static String a(Cursor paramCursor, String paramString) { return a(paramCursor, paramCursor.getColumnIndex(paramString)); }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, int paramInt) {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      paramImageView.setVisibility(paramInt);
      return;
    } 
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence) {
    byte b;
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {
      b = 8;
    } else {
      b = 0;
    } 
    paramTextView.setVisibility(b);
  }
  
  private void a(String paramString, Drawable paramDrawable) {
    if (paramDrawable != null)
      this.n.put(paramString, paramDrawable.getConstantState()); 
  }
  
  private Drawable b(ComponentName paramComponentName) {
    String str2;
    String str1;
    PackageManager packageManager = this.d.getPackageManager();
    try {
      ActivityInfo activityInfo = packageManager.getActivityInfo(paramComponentName, 128);
      int i = activityInfo.getIconResource();
      if (i == 0)
        return null; 
      Drawable drawable = packageManager.getDrawable(paramComponentName.getPackageName(), i, activityInfo.applicationInfo);
      if (drawable == null) {
        str1 = "SuggestionsAdapter";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid icon resource ");
        stringBuilder.append(i);
        stringBuilder.append(" for ");
        stringBuilder.append(paramComponentName.flattenToShortString());
        str2 = stringBuilder.toString();
        Log.w(str1, str2);
        return null;
      } 
      return drawable;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      str1 = "SuggestionsAdapter";
      str2 = nameNotFoundException.toString();
    } 
    Log.w(str1, str2);
    return null;
  }
  
  private Drawable b(Uri paramUri) {
    try {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool)
        try {
          return a(paramUri);
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Resource does not exist: ");
          stringBuilder1.append(paramUri);
          throw new FileNotFoundException(stringBuilder1.toString());
        }  
      inputStream = this.m.getContentResolver().openInputStream(paramUri);
      if (inputStream != null)
        try {
          drawable = Drawable.createFromStream(inputStream, null);
        } finally {
          try {
            inputStream.close();
          } catch (IOException iOException) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Error closing icon stream for ");
            stringBuilder1.append(paramUri);
            Log.e("SuggestionsAdapter", stringBuilder1.toString(), iOException);
          } 
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to open ");
      stringBuilder.append(paramUri);
      throw new FileNotFoundException(stringBuilder.toString());
    } catch (FileNotFoundException fileNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Icon not found: ");
      stringBuilder.append(paramUri);
      stringBuilder.append(", ");
      stringBuilder.append(fileNotFoundException.getMessage());
      Log.w("SuggestionsAdapter", stringBuilder.toString());
      return null;
    } 
  }
  
  private Drawable b(String paramString) {
    Drawable.ConstantState constantState = (Drawable.ConstantState)this.n.get(paramString);
    return (constantState == null) ? null : constantState.newDrawable();
  }
  
  private CharSequence b(CharSequence paramCharSequence) {
    if (this.r == null) {
      TypedValue typedValue = new TypedValue();
      this.d.getTheme().resolveAttribute(a.a.textColorSearchUrl, typedValue, true);
      this.r = this.d.getResources().getColorStateList(typedValue.resourceId);
    } 
    SpannableString spannableString = new SpannableString(paramCharSequence);
    TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, this.r, null);
    spannableString.setSpan(textAppearanceSpan, 0, paramCharSequence.length(), 33);
    return spannableString;
  }
  
  private void d(Cursor paramCursor) {
    Object object;
    if (paramCursor != null) {
      object = paramCursor.getExtras();
    } else {
      object = null;
    } 
    if (object == null || object.getBoolean("in_progress"));
  }
  
  private Drawable e(Cursor paramCursor) {
    int i = this.v;
    if (i == -1)
      return null; 
    Drawable drawable = a(paramCursor.getString(i));
    return (drawable != null) ? drawable : g(paramCursor);
  }
  
  private Drawable f(Cursor paramCursor) {
    int i = this.w;
    return (i == -1) ? null : a(paramCursor.getString(i));
  }
  
  private Drawable g(Cursor paramCursor) {
    Drawable drawable = a(this.l.getSearchActivity());
    return (drawable != null) ? drawable : this.d.getPackageManager().getDefaultActivityIcon();
  }
  
  Cursor a(SearchableInfo paramSearchableInfo, String paramString, int paramInt) {
    String[] arrayOfString1 = null;
    if (paramSearchableInfo == null)
      return null; 
    String str1 = paramSearchableInfo.getSuggestAuthority();
    if (str1 == null)
      return null; 
    Uri.Builder builder = (new Uri.Builder()).scheme("content").authority(str1).query("").fragment("");
    String str2 = paramSearchableInfo.getSuggestPath();
    if (str2 != null)
      builder.appendEncodedPath(str2); 
    builder.appendPath("search_suggest_query");
    String str3 = paramSearchableInfo.getSuggestSelection();
    if (str3 != null) {
      arrayOfString1 = new String[] { paramString };
    } else {
      builder.appendPath(paramString);
    } 
    String[] arrayOfString2 = arrayOfString1;
    if (paramInt > 0)
      builder.appendQueryParameter("limit", String.valueOf(paramInt)); 
    Uri uri = builder.build();
    return this.d.getContentResolver().query(uri, null, str3, arrayOfString2, null);
  }
  
  public Cursor a(CharSequence paramCharSequence) {
    String str;
    if (paramCharSequence == null) {
      str = "";
    } else {
      str = paramCharSequence.toString();
    } 
    if (this.k.getVisibility() == 0) {
      if (this.k.getWindowVisibility() != 0)
        return null; 
      try {
        Cursor cursor = a(this.l, str, 50);
        if (cursor != null) {
          cursor.getCount();
          return cursor;
        } 
      } catch (RuntimeException runtimeException) {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", runtimeException);
      } 
    } 
    return null;
  }
  
  Drawable a(Uri paramUri) {
    String str = paramUri.getAuthority();
    if (!TextUtils.isEmpty(str))
      try {
        Resources resources = this.d.getPackageManager().getResourcesForApplication(str);
        List list = paramUri.getPathSegments();
        if (list != null) {
          int i1;
          int i = list.size();
          if (i == 1) {
            try {
              i1 = Integer.parseInt((String)list.get(0));
            } catch (NumberFormatException numberFormatException) {
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append("Single path segment is not a resource ID: ");
              stringBuilder3.append(paramUri);
              throw new FileNotFoundException(stringBuilder3.toString());
            } 
          } else if (i == 2) {
            i1 = resources.getIdentifier((String)list.get(1), (String)list.get(0), str);
          } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("More than two path segments: ");
            stringBuilder3.append(paramUri);
            throw new FileNotFoundException(stringBuilder3.toString());
          } 
          if (i1 != 0)
            return resources.getDrawable(i1); 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("No resource found for: ");
          stringBuilder2.append(paramUri);
          throw new FileNotFoundException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("No path: ");
        stringBuilder1.append(paramUri);
        throw new FileNotFoundException(stringBuilder1.toString());
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("No package found for authority: ");
        stringBuilder1.append(paramUri);
        throw new FileNotFoundException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No authority: ");
    stringBuilder.append(paramUri);
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) {
    View view = super.a(paramContext, paramCursor, paramViewGroup);
    view.setTag(new a(view));
    ((ImageView)view.findViewById(a.f.edit_query)).setImageResource(this.o);
    return view;
  }
  
  public void a(int paramInt) { this.q = paramInt; }
  
  public void a(Cursor paramCursor) {
    if (this.p) {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null)
        paramCursor.close(); 
      return;
    } 
    try {
      super.a(paramCursor);
      if (paramCursor != null) {
        this.s = paramCursor.getColumnIndex("suggest_text_1");
        this.t = paramCursor.getColumnIndex("suggest_text_2");
        this.u = paramCursor.getColumnIndex("suggest_text_2_url");
        this.v = paramCursor.getColumnIndex("suggest_icon_1");
        this.w = paramCursor.getColumnIndex("suggest_icon_2");
        this.x = paramCursor.getColumnIndex("suggest_flags");
        return;
      } 
    } catch (Exception exception) {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", exception);
    } 
  }
  
  public void a(View paramView, Context paramContext, Cursor paramCursor) {
    boolean bool;
    a a = (a)paramView.getTag();
    int i = this.x;
    if (i != -1) {
      bool = paramCursor.getInt(i);
    } else {
      bool = false;
    } 
    if (a.a != null) {
      String str = a(paramCursor, this.s);
      a(a.a, str);
    } 
    if (a.b != null) {
      String str2;
      String str1 = a(paramCursor, this.u);
      if (str1 != null) {
        str2 = b(str1);
      } else {
        str2 = a(paramCursor, this.t);
      } 
      if (TextUtils.isEmpty(str2)) {
        if (a.a != null) {
          a.a.setSingleLine(false);
          a.a.setMaxLines(2);
        } 
      } else if (a.a != null) {
        a.a.setSingleLine(true);
        a.a.setMaxLines(1);
      } 
      a(a.b, str2);
    } 
    if (a.c != null)
      a(a.c, e(paramCursor), 4); 
    if (a.d != null)
      a(a.d, f(paramCursor), 8); 
    int i1 = this.q;
    if (i1 == 2 || (i1 == 1 && bool & true)) {
      a.e.setVisibility(0);
      a.e.setTag(a.a.getText());
      a.e.setOnClickListener(this);
      return;
    } 
    a.e.setVisibility(8);
  }
  
  public CharSequence c(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    String str = a(paramCursor, "suggest_intent_query");
    if (str != null)
      return str; 
    if (this.l.shouldRewriteQueryFromData()) {
      String str1 = a(paramCursor, "suggest_intent_data");
      if (str1 != null)
        return str1; 
    } 
    if (this.l.shouldRewriteQueryFromText()) {
      String str1 = a(paramCursor, "suggest_text_1");
      if (str1 != null)
        return str1; 
    } 
    return null;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    try {
      return super.getDropDownView(paramInt, paramView, paramViewGroup);
    } catch (RuntimeException runtimeException) {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException);
      View view = b(this.d, this.c, paramViewGroup);
      if (view != null)
        ((a)view.getTag()).a.setText(runtimeException.toString()); 
      return view;
    } 
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    try {
      return super.getView(paramInt, paramView, paramViewGroup);
    } catch (RuntimeException runtimeException) {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException);
      View view = a(this.d, this.c, paramViewGroup);
      if (view != null)
        ((a)view.getTag()).a.setText(runtimeException.toString()); 
      return view;
    } 
  }
  
  public boolean hasStableIds() { return false; }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
    d(a());
  }
  
  public void notifyDataSetInvalidated() {
    super.notifyDataSetInvalidated();
    d(a());
  }
  
  public void onClick(View paramView) {
    Object object = paramView.getTag();
    if (object instanceof CharSequence)
      this.k.a((CharSequence)object); 
  }
  
  private static final class a {
    public final TextView a;
    
    public final TextView b;
    
    public final ImageView c;
    
    public final ImageView d;
    
    public final ImageView e;
    
    public a(View param1View) {
      this.a = (TextView)param1View.findViewById(16908308);
      this.b = (TextView)param1View.findViewById(16908309);
      this.c = (ImageView)param1View.findViewById(16908295);
      this.d = (ImageView)param1View.findViewById(16908296);
      this.e = (ImageView)param1View.findViewById(a.f.edit_query);
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */