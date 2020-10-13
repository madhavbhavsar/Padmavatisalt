package com.madappsdevlopers.padmavatisalt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.madappsdevlopers.padmavatisalt.Constants.Companion.CONTENT_TYPE
import com.madappsdevlopers.padmavatisalt.Constants.Companion.SERVER_KEY
import com.madappsdevlopers.padmavatisalt.R
import com.madappsdevlopers.padmavatisalt.MainActivity
import com.madappsdevlopers.padmavatisalt.Constants.Companion.CONTENT_TYPE
import com.madappsdevlopers.padmavatisalt.Constants.Companion.SERVER_KEY
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import kotlin.random.Random
//class Toopic {
//    fun topics(mytxt:TextView){
//        val TOPIC:String = "/topics/maddy123"
//        mytxt.text = TOPIC
//    }
//}
const val TOPIC = "/topics/maddy1234"
class Kotclass : AppCompatActivity() {

    val TAG = "MainActivity"

    fun kooot(ktit:String,kmessag:String){
        val text:String = "kotkotkotkot"


        //FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        val title =ktit
        val message = kmessag
        if(title.isNotEmpty() && message.isNotEmpty()) {
            PushNotification(
                    NotificationData(title, message),
                    TOPIC
            ).also {
                sendNotification(it)
            }
        }

    }
    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.api.postNotification(notification)
            //   val response = Ret
//            if(response.isSuccessful) {
//                Log.d(TAG, "Response: ${Gson().toJson(response)}")
//            } else {
//                Log.e(TAG, response.errorBody().toString())
//            }
        } catch(e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

}
data class PushNotification(
        val data: NotificationData,
        val to: String
)
data class NotificationData(
        val title: String,
        val message: String
)

class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        val api by lazy {
            retrofit.create(NotificationAPI::class.java)
        }
    }
}

interface NotificationAPI {
    @Headers("Authorization: key=AAAAJnDE4cs:APA91bFvjaHXe3WhTN4SEVBUPmWxWWC33KzswJvH0pU10HV6yDNvehjfy3QbrrkBrZi454CM7zXkGUiupLrPklPkbz9ImXJZtreUJre4T0YCUKrCUi4UAAYxZA1V61vAOQFAAw5gG4-P", "Content-Type:application/json")
    @POST("fcm/send")
    suspend fun postNotification(
            @Body notification: PushNotification
    ): Response<ResponseBody>
}

class Constants {
    companion object {
        const val BASE_URL = "https://fcm.googleapis.com"
        const val SERVER_KEY = "AAAAJnDE4cs:APA91bFvjaHXe3WhTN4SEVBUPmWxWWC33KzswJvH0pU10HV6yDNvehjfy3QbrrkBrZi454CM7zXkGUiupLrPklPkbz9ImXJZtreUJre4T0YCUKrCUi4UAAYxZA1V61vAOQFAAw5gG4-P"
        const val CONTENT_TYPE = "application/json"
    }

}
private const val CHANNEL_ID = "my_channel"
class FirebaseService  : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val intent = Intent(this, MainActivity::class.java)
        val intent1 = Intent(this, PendingList::class.java)
        val intent2 = Intent(this, Dispatched::class.java)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationID = Random.nextInt()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val pendingIntent1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_ONE_SHOT)
        val pendingIntent2 = PendingIntent.getActivity(this, 0, intent2, PendingIntent.FLAG_ONE_SHOT)
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(message.data["title"])
                .setContentText(message.data["message"])
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build()

        notificationManager.notify(notificationID, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channelName = "channelName"
        val channel = NotificationChannel(CHANNEL_ID, channelName,
                NotificationManager.IMPORTANCE_HIGH).apply {
            description = "My channel description"
            enableLights(true)
            lightColor = Color.GREEN
        }
        notificationManager.createNotificationChannel(channel)
    }
}
