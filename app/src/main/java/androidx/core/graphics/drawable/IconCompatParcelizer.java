package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
  public static IconCompat read(a parama) {
    IconCompat iconCompat = new IconCompat();
    iconCompat.a = parama.b(iconCompat.a, 1);
    iconCompat.c = parama.b(iconCompat.c, 2);
    iconCompat.d = parama.b(iconCompat.d, 3);
    iconCompat.e = parama.b(iconCompat.e, 4);
    iconCompat.f = parama.b(iconCompat.f, 5);
    iconCompat.g = (ColorStateList)parama.b(iconCompat.g, 6);
    iconCompat.j = parama.b(iconCompat.j, 7);
    iconCompat.c();
    return iconCompat;
  }
  
  public static void write(IconCompat paramIconCompat, a parama) {
    parama.a(true, true);
    paramIconCompat.a(parama.a());
    parama.a(paramIconCompat.a, 1);
    parama.a(paramIconCompat.c, 2);
    parama.a(paramIconCompat.d, 3);
    parama.a(paramIconCompat.e, 4);
    parama.a(paramIconCompat.f, 5);
    parama.a(paramIconCompat.g, 6);
    parama.a(paramIconCompat.j, 7);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\androidx\core\graphics\drawable\IconCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */