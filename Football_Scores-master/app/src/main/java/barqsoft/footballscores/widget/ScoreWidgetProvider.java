package barqsoft.footballscores.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;

/**
 * Created by raghav on 8/28/15.
 */
public class ScoreWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            int layoutId = R.layout.widget_today_small;
            RemoteViews views = new RemoteViews(context.getPackageName(), layoutId);

            views.setTextViewText(R.id.widget_home_name,"Real Madrid");
            views.setTextViewText(R.id.widget_away_name,"Arsenal");
            views.setTextViewText(R.id.widget_score_textview,"2-2");
            views.setTextViewText(R.id.widget_data_textview,"22:00");

            Intent launchIntent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,launchIntent,0);
            views.setOnClickPendingIntent(R.id.widget, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }



    }
}
