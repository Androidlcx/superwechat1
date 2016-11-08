package cn.ucai.superwechat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.hyphenate.easeui.domain.User;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.ui.AddContactActivity;
import cn.ucai.superwechat.ui.AddFriendActivity;
import cn.ucai.superwechat.ui.ChatActivity;
import cn.ucai.superwechat.ui.FriendProfileActivity;
import cn.ucai.superwechat.ui.LoginActivity;
import cn.ucai.superwechat.ui.MainActivity;
import cn.ucai.superwechat.ui.NewFriendsMsgActivity;
import cn.ucai.superwechat.ui.RegisterActivity;
import cn.ucai.superwechat.ui.SettingsActivity;
import cn.ucai.superwechat.ui.UserProfileActivity;

//闪屏的实现封装
public class MFGT {
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    public static void startActivity(Activity context,Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context,cls);
        startActivity(context,intent);
    }
    public static void startActivity(Context context,Intent intent){
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
    public static void satartActivityForResult(Activity context,Intent intent,int requestCode){
        context.startActivityForResult(intent,requestCode);
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
    //欢迎页面登录的跳转方法
    public static void gotoLogin(Activity context){
        startActivity(context, LoginActivity.class);
    }
    //欢迎页面注册的跳转方法
    public static void gotoRegister(Activity context){
        startActivity(context, RegisterActivity.class);
    }
    //跳转到设置的方法
    public static void gotoSettings(Activity context){
        startActivity(context, SettingsActivity.class);
    }
    //跳转到个人资料的方法
    public static void gotoUserProfile(Activity context){
        startActivity(context, UserProfileActivity.class);
    }
    //跳转到添加好友的方法
    public static void gotoAddFirend(Activity context){
        startActivity(context, AddContactActivity.class);
    }
    //跳转到好友的详细信息界面
    public static void gotoFriendProfile(Activity context,User user){
        Intent intent = new Intent();
        intent.setClass(context, FriendProfileActivity.class);
        intent.putExtra(I.User.USER_NAME,user);
        startActivity(context, intent);
    }
    //跳转到添加好友申请消息的方法
    public static void gotoAddFirendMsg(Activity context,String username){
        Intent intent = new Intent();
        intent.setClass(context, AddFriendActivity.class);
        intent.putExtra(I.User.USER_NAME,username);
        startActivity(context,intent);
    }
    //跳转到好友详情界面
    public static void gotoNewFriendsMsg(Activity context){
        startActivity(context, NewFriendsMsgActivity.class);
    }
    //和谁聊天的跳转方法
    public static void gotoChat(Activity context,String username){
        Intent intent = new Intent();
        intent.setClass(context, ChatActivity.class);
        intent.putExtra("userId",username);
        startActivity(context,intent);
    }

}