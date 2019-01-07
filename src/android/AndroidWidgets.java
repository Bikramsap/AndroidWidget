package cordova-plugin-androidwidgets;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;



/**
 * This class echoes a string called from JavaScript.
 */
public class AndroidWidgets extends CordovaPlugin, AppWidgetProvider {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        return false;
    }

    @Override
    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                              int appWidgetId)
    {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
    // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);


        displayTime(views, R.id.example_clock, );
        views.setOnClickPendingIntent(R.id.example_clock, pendingIntent);

    // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    // There may be multiple widgets active, so update all of them
    for (int appWidgetId : appWidgetIds) {
        updateAppWidget(context, appWidgetManager, appWidgetId);
    }
  }

  @Override
  public void onEnabled(Context context) {
    // Enter relevant functionality for when the first widget is created
  }

  @Override
  public void onDisabled(Context context) {
    // Enter relevant functionality for when the last widget is disabled
  }

  public void displayTime(RemoteViews views, int layout, CallbackContext callback){
      DateFormat dateFormat = new SimpleDateFormat("yyyy MM");
      Calendar calendar = Calendar.getInstance();
      views.setTextViewText(layout, "Hello");
  }
}
