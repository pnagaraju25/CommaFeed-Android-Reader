package com.commafeed.commafeedreader;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Stack;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

public class Tools {
	
	private static ExpectedException e = new ExpectedException();
	private static Context context;
	
	public static String stackTraceString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	
	public static String stackToString(Stack<Category> stack) {
		String str = new String();
		for (Category e : stack) {
			str += e.name + "\n";
		}
		return str;
	}

	public static boolean isOnline(Activity activity) {
		ConnectivityManager cm =
			(ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}
	
	public static void error(String s) {
		Log.e("CommaFeed Reader", s);
	}
	
	public static void debug(String s) {
		Log.d("CommaFeed Reader", s);
	}
	
	public static void info(String s) {
		Log.i("CommaFeed Reader", s);
	}
	
	public static void verbose(String s) {
		Log.v("CommaFeed Reader", s);
	}
	
	private static String username = null;
	private static String password = null;
	private static SharedPreferences preferences = null;
	
	// Need this for access to preferences to load/save login
	public static void setContext(Context c) {
		if (c != null) {
			context = c;
			preferences = PreferenceManager.getDefaultSharedPreferences(c);
		}
	}
	
	// Loads user/pass from sharedpreferences; throws an exception on failure
	public static void loadLogin() {
		if (preferences == null)
				throw e;
		if (username != null && password != null) // User/pass was set during the lifetime of this program; don't bother loading
			return;
		String _username = preferences.getString("username", null);
		String _password = preferences.getString("password", null);
		if (_username == null || _password == null)
			throw e;
		username = _username;
		password = _password;
		//debug("Loaded login: "+username+" / "+password);
		return;
	}
	
	// Saves user/pass to sharedpreferences; returns true on success, false on failure
	public static void saveLogin() {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		editor.commit(); // Flush changes
	}
	
	public static void clearLogin() {
		// Clear caches
		username = null;
		password = null;
		// Clear saved values, too
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("username", null);
		editor.putString("password", null);
		editor.commit();
	}
	
	public static void setUsername(String u) {
		username = u;
	}
	
	public static void setPassword(String p) {
		password = p;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static String getApiUrl() { // Don't cache because it can change
		return preferences.getString("apiUrl", context.getString(R.string.defaultApiUrl)); // if prefs aren't set, return default URL
	}

	public static <T> ArrayList<T> stackToArrayList(Stack<T> stack) {
		ArrayList<T> list = new ArrayList<T>();
		for (int i = 0; i < stack.size(); i++) {
			list.add(stack.get(i));
		}
		return list;
	}
	
	public static <T> Stack<T> arrayListToStack(ArrayList<T> list) {
		Stack<T> stack = new Stack<T>();
		for (int i = 0; i < list.size(); i++) {
			stack.push(list.get(i));
		}
		return stack;
	}
}
